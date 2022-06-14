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

    public new async Task<JsonElement?> doRequest(IDictionary<string, object> option)
    {
        if (Array.IndexOf(validVersions, base.version) == -1)
        {
            base.version = defaultVersion;
        }
        return await base.doRequest(option);
    }


    /**
     * 用户应用查询接口
     */
    public async Task<JsonElement?> appList(Dictionary<string, object> option)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", "app/retrieve_all");
        requestOption.Add("payload", option);
        return await this.doRequest(requestOption);
    }

    /**
     * 用户表单查询接口
     */
    public async Task<JsonElement?> entryList(string appId, Dictionary<string, object> option)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", $"app/{appId}/entry_retrieve");
        requestOption.Add("payload", option);
        return await this.doRequest(requestOption);
    }
}