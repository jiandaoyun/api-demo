/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/01
*/
using System.Text.Json;
using Src.Base;

namespace Src.Api.Jdy;

public class AppApiClient : ApiClient
{
    private readonly static string[] validVersions = { "v1" };
    private readonly static string defaultVersion = "v1";
    public AppApiClient(string host, string apiKey, string version = "") : base(host, apiKey, version)
    {
    }

    public new async Task<JsonElement?> doRequest(string method, string path, IDictionary<string, string>? query, IDictionary<string, object>? payload)
    {
        if (Array.IndexOf(validVersions, base.version) == -1)
        {
            base.version = defaultVersion;
        }
        return await base.doRequest(method, path, query, payload);
    }


    /**
     * 用户应用查询接口
     */
    public async Task<JsonElement?> appList(int skip, int limit)
    {
        IDictionary<string, object> payload = new Dictionary<string, object>();
        payload.Add("skip", skip);
        payload.Add("limit", limit);
        return await this.doRequest("POST", "app/retrieve_all", null, payload);
    }

    /**
     * 用户表单查询接口
     */
    public async Task<object?> entryList(string appId, int skip, int limit)
    {
        IDictionary<string, object> payload = new Dictionary<string, object>();
        payload.Add("skip", skip);
        payload.Add("limit", limit);
        return await this.doRequest("POST", $"app/{appId}/ entry_retrieve", null, payload);
    }
}