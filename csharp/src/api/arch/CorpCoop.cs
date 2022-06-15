/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/15
*/
using System.Text.Json;
using Src.Base;

namespace Src.Api.Jdy;

public class CorpCoopApiClient : ApiClient
{
    private readonly static string[] validVersions = { "v4" };
    private readonly static string defaultVersion = "v4";
    public CorpCoopApiClient(string host, string apiKey, string version = "") : base(host, apiKey, version)
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
    * 列出我连接的企业
    */
    public async Task<JsonElement?> corpCoopDepartList(IDictionary<string, object> option)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", "corp_coop/guest/department_list");
        requestOption.Add("payload", option);
        return await this.doRequest(requestOption);
    }

    /**
    * 列出我连接的企业对接人
    */
    public async Task<JsonElement?> corpCoopMemberList(IDictionary<string, object> option)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", "corp_coop/guest/member_list");
        requestOption.Add("payload", option);
        return await this.doRequest(requestOption);
    }

    /**
    * 列出我连接的企业对接人详细信息
    */
    public async Task<JsonElement?> CorpCoopUserInfo(string username)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", "corp_coop/guest/user_retrieve");
        IDictionary<string, object> payload = new Dictionary<string, object>();
        payload.Add("username", username);
        requestOption.Add("payload", payload);
        return await this.doRequest(requestOption);
    }

}