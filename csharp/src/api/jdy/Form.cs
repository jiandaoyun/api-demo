/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
*/
using System.Text.Json;
using Src.Base;

namespace Src.Api.Jdy;

public class FormApiClient : ApiClient
{
    private readonly static string[] validVersions = { "v2", "v1" };
    private readonly static string defaultVersion = "v2";
    public FormApiClient(string host, string apiKey, string version = "") : base(host, apiKey, version)
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
    * 新建单条数据接口
    */
    public async Task<JsonElement?> formWidgets(string appId, string entryId)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", $"app/{appId}/entry/{entryId}/widgets");
        return await this.doRequest(requestOption);
    }
}