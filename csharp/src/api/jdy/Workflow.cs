/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
*/
using System.Text.Json;
using Src.Base;

namespace Src.Api.Jdy;

public class WorkflowApiClient : ApiClient
{
    private readonly static string[] validVersions = { "v1" };
    private readonly static string defaultVersion = "v1";
    public WorkflowApiClient(string host, string apiKey, string version = "") : base(host, apiKey, version)
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
    * 获取单条表单流程数据的审批意见
    */
    public async Task<JsonElement?> approvalComments(string appId, string entryId, string dataId, IDictionary<string, object> option)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", $"app/{appId}/entry/{entryId}/data/{dataId}/approval_comments");
        requestOption.Add("payload", option);
        return await this.doRequest(requestOption);
    }
}