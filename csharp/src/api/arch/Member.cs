/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
*/
using System.Text.Json;
using Src.Base;

namespace Src.Api.Jdy;

public class MemberApiClient : ApiClient
{
    private readonly static string[] validVersions = { "v2", "v1" };
    private readonly static string defaultVersion = "v2";
    public MemberApiClient(string host, string apiKey, string version = "") : base(host, apiKey, version)
    {
    }

    public new async Task<JsonElement?> doRequest(IDictionary<string, object> option)
    {
        if (Array.IndexOf(validVersions, base.version) == -1)
        {
            base.version = defaultVersion;
        }
        return await base.doRequest(option);
    }

    /**
    * 获取部门成员（递归）
    */
    public async Task<JsonElement?> deptMemberList(int deptNo, IDictionary<string, object> option)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", $"department/{deptNo}/member_list");
        requestOption.Add("payload", option);
        return await this.doRequest(requestOption);
    }

    /**
    * 获取成员
    */
    public async Task<JsonElement?> userInfo(string username)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", $"user/{username}/user_retrieve");
        return await this.doRequest(requestOption);
    }

    /**
    * 创建成员
    */
    public async Task<JsonElement?> userCreate(string name, IDictionary<string, object> option)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", "user/create");
        option.Add("name", name);
        requestOption.Add("payload", option);
        return await this.doRequest(requestOption);
    }

    /**
    * 更新成员
    */
    public async Task<JsonElement?> userUpdate(string username, IDictionary<string, object> option)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", $"user/{username}/update");
        requestOption.Add("payload", option);
        return await this.doRequest(requestOption);
    }

    /**
    * 删除成员
    */
    public async Task<JsonElement?> userDelete(string username)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", $"user/{username}/delete");
        return await this.doRequest(requestOption);
    }

    /**
    * 批量删除成员
    */
    public async Task<JsonElement?> userBatchDelete(string[] usernames)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", "user/batch_delete");
        IDictionary<string, object> payload = new Dictionary<string, object>();
        payload.Add("usernames", usernames);
        requestOption.Add("payload", payload);
        return await this.doRequest(requestOption);
    }

    /**
    * 批量导入成员
    */
    public async Task<JsonElement?> userImport(Dictionary<string, object>[] users)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", "user/import");
        IDictionary<string, object> payload = new Dictionary<string, object>();
        payload.Add("users", users);
        requestOption.Add("payload", payload);
        return await this.doRequest(requestOption);
    }
}