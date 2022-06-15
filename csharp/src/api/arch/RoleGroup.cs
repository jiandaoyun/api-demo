/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
*/
using System.Text.Json;
using Src.Base;

namespace Src.Api.Jdy;

public class RoleGroupApiClient : ApiClient
{
    private readonly static string[] validVersions = { "v2" };
    private readonly static string defaultVersion = "v2";
    public RoleGroupApiClient(string host, string apiKey, string version = "") : base(host, apiKey, version)
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
    * 角色组列表
    */
    public async Task<JsonElement?> roleGroupList(IDictionary<string, object> option)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", "role_group/list");
        requestOption.Add("payload", option);
        return await this.doRequest(requestOption);
    }

    /**
    * 创建角色组
    */
    public async Task<JsonElement?> roleGroupCreate(string name)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", "role_group/create");
        IDictionary<string, object> payload = new Dictionary<string, object>();
        payload.Add("name", name);
        requestOption.Add("payload", payload);
        return await this.doRequest(requestOption);
    }


    /**
    * 更新角色组
    */
    public async Task<JsonElement?> roleGroupUpdate(int roleGroupNo, string name)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", "role_group/update");
        IDictionary<string, object> payload = new Dictionary<string, object>();
        payload.Add("role_group_no", roleGroupNo);
        payload.Add("name", name);
        requestOption.Add("payload", payload);
        return await this.doRequest(requestOption);
    }

    /**
    * 删除自建角色组
    */
    public async Task<JsonElement?> roleGroupDelete(int roleGroupNo)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", "role_group/delete");
        IDictionary<string, object> payload = new Dictionary<string, object>();
        payload.Add("role_group_no", roleGroupNo);
        requestOption.Add("payload", payload);
        return await this.doRequest(requestOption);
    }
}