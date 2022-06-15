/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
*/
using System.Text.Json;
using Src.Base;

namespace Src.Api.Jdy;

public class FormDataApiClient : ApiClient
{
    private readonly static string[] validVersions = { "v4", "v3", "v2", "v1" };
    private readonly static string defaultVersion = "v4";
    public FormDataApiClient(string host, string apiKey, string version = "") : base(host, apiKey, version)
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
    public async Task<JsonElement?> singleDataCreate(string appId, string entryId, IDictionary<string, object> data, IDictionary<string, object> option)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", $"app/{appId}/entry/{entryId}/data_create");
        option.Add("data", data);
        requestOption.Add("payload", option);
        return await this.doRequest(requestOption);
    }

    /**
    * 查询单条数据接口
    */
    public async Task<JsonElement?> singleDataQuery(string appId, string entryId, string dataId)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", $"app/{appId}/entry/{entryId}/data_retrieve");
        IDictionary<string, object> payload = new Dictionary<string, object>();
        payload.Add("data_id", dataId);
        requestOption.Add("payload", payload);
        return await this.doRequest(requestOption);
    }

    /**
    * 修改单条数据接口
    */
    public async Task<JsonElement?> singleDataUpdate(string appId, string entryId, string dataId, IDictionary<string, object> data, IDictionary<string, object> option)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", $"app/{appId}/entry/{entryId}/data_update");
        option.Add("data", data);
        option.Add("data_id", dataId);
        requestOption.Add("payload", option);
        return await this.doRequest(requestOption);
    }

    /**
    * 删除单条数据接口
    */
    public async Task<JsonElement?> singleDataRemove(string appId, string entryId, string dataId, IDictionary<string, object> option)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("version", "v1");
        requestOption.Add("method", "POST");
        requestOption.Add("path", $"app/{appId}/entry/{entryId}/data_delete");
        option.Add("data_id", dataId);
        requestOption.Add("payload", option);
        return await this.doRequest(requestOption);
    }

    /**
    * 新建多条数据接口
    */
    public async Task<JsonElement?> batchDataCreate(string appId, string entryId, IDictionary<string, object>[] dataList, IDictionary<string, object> option)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("version", "v1");
        requestOption.Add("method", "POST");
        requestOption.Add("path", $"app/{appId}/entry/{entryId}/data_batch_create");
        option.Add("data_list", dataList);
        requestOption.Add("payload", option);
        return await this.doRequest(requestOption);
    }

    /**
    * 查询多条数据接口
    */
    public async Task<JsonElement?> batchDataQuery(string appId, string entryId, IDictionary<string, object> option)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("version", "v1");
        requestOption.Add("method", "POST");
        requestOption.Add("path", $"app/{appId}/entry/{entryId}/data");
        requestOption.Add("payload", option);
        return await this.doRequest(requestOption);
    }

    /**
    * 修改多条数据接口
    */
    public async Task<JsonElement?> batchDataUpdate(string appId, string entryId, string[] dataIds, IDictionary<string, object> data, IDictionary<string, object> option)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("version", "v1");
        requestOption.Add("method", "POST");
        requestOption.Add("path", $"app/{appId}/entry/{entryId}/data_batch_update");
        option.Add("data_ids", dataIds);
        option.Add("data", data);
        requestOption.Add("payload", option);
        return await this.doRequest(requestOption);
    }

    /**
    * 删除多条数据接口
    */
    public async Task<JsonElement?> batchDataRemove(string appId, string entryId, string[] dataIds)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("version", "v1");
        requestOption.Add("method", "POST");
        requestOption.Add("path", $"app/{appId}/entry/{entryId}/data_batch_delete");
        IDictionary<string, object> payload = new Dictionary<string, object>();
        payload.Add("data_ids", dataIds);
        requestOption.Add("payload", payload);
        return await this.doRequest(requestOption);
    }
}