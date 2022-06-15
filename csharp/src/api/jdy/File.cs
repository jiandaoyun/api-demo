/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
*/

using System.Text.Json;
using Src.Base;
using System.Text;

namespace Src.Api.Jdy;

public class FileApiClient : ApiClient
{
    private readonly static string[] validVersions = { "v1" };
    private readonly static string defaultVersion = "v1";
    public FileApiClient(string host, string apiKey, string version = "") : base(host, apiKey, version)
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
     * 获取文件上传凭证和上传地址接口
     */
    public async Task<JsonElement?> uploadToken(string appId, string entryId, string transactionId)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", $"app/{appId}/entry/{entryId}/file/get_upload_token");
        IDictionary<string, object> payload = new Dictionary<string, object>();
        payload.Add("transaction_id", transactionId);
        requestOption.Add("payload", payload);
        return await this.doRequest(requestOption);
    }

    /**
     * 文件上传接口
     */
    public async Task<JsonElement?> uploadFile(string url, string token, FileStream file)
    {
        MultipartFormDataContent formData = new MultipartFormDataContent();
        formData.Add(new StringContent(token), "token");
        formData.Add(new StreamContent(file), "file", file.Name);
        // 发起http请求
        var response = Global.DefaultHttpClient.PostAsync(url, formData).Result;
        // response.EnsureSuccessStatusCode();
        return await JsonSerializer.DeserializeAsync<JsonElement>(response.Content.ReadAsStream());
    }
}