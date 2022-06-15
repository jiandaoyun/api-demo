/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
*/
using System.Text.Json;
using Src.Base;

namespace Src.Api.Jdy;

public class RoleApiClient : ApiClient
{
    private readonly static string[] validVersions = { "v2" };
    private readonly static string defaultVersion = "v2";
    public RoleApiClient(string host, string apiKey, string version = "") : base(host, apiKey, version)
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
    * 角色列表
    */
    public async Task<JsonElement?> roleList(IDictionary<string, object> option)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", "role/list");
        requestOption.Add("payload", option);
        return await this.doRequest(requestOption);
    }

    /**
    * 角色创建
    */
    public async Task<JsonElement?> roleCreate(string name, int groupNo)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", "role/create");
        IDictionary<string, object> payload = new Dictionary<string, object>();
        payload.Add("name", name);
        payload.Add("group_no", groupNo);
        requestOption.Add("payload", payload);
        return await this.doRequest(requestOption);
    }

    /**
    * 角色更新
    */
    public async Task<JsonElement?> roleUpdate(int roleNo, int groupNo, IDictionary<string, object> option)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", "role/update");
        option.Add("role_no", roleNo);
        option.Add("group_no", groupNo);
        requestOption.Add("payload", option);
        return await this.doRequest(requestOption);
    }

    /**
    * 角色删除
    */
    public async Task<JsonElement?> roleDelete(int roleNo)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", "role/delete");
        IDictionary<string, object> payload = new Dictionary<string, object>();
        payload.Add("role_no", roleNo);
        requestOption.Add("payload", payload);
        return await this.doRequest(requestOption);
    }

    /**
    * 列出角色下所有成员
    */
    public async Task<JsonElement?> roleMemberList(int roleNo, IDictionary<string, object> option)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", "role/member_list");
        option.Add("role_no", roleNo);
        requestOption.Add("payload", option);
        return await this.doRequest(requestOption);
    }

    /**
    * 为自建角色批量添加成员
    */
    public async Task<JsonElement?> roleAddMembers(int roleNo, string[] usernames)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", "role/add_members");
        IDictionary<string, object> payload = new Dictionary<string, object>();
        payload.Add("role_no", roleNo);
        payload.Add("usernames", usernames);
        requestOption.Add("payload", payload);
        return await this.doRequest(requestOption);
    }

    /**
    * 为自建角色批量移除成员
    */
    public async Task<JsonElement?> roleRmoveMembers(int roleNo, string[] usernames)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", "role/remove_members");
        IDictionary<string, object> payload = new Dictionary<string, object>();
        payload.Add("role_no", roleNo);
        payload.Add("usernames", usernames);
        requestOption.Add("payload", payload);
        return await this.doRequest(requestOption);
    }
}