/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/05/31
*/

using System.Text;
using System.Text.Json;
using System.Net.Http.Json;

namespace Src.Base;

public class ApiClient
{
    private readonly string host;
    private readonly string apiKey;
    protected string version;


    public ApiClient(string host, string apiKey, string version = "")
    {
        this.host = host;
        this.apiKey = apiKey;
        this.version = version;
    }

    public async Task<JsonElement?> doRequest(IDictionary<string, object> option)
    {
        // 参数获取
        string? version = this.version;
        if (option.ContainsKey("version"))
        {
            version = option["version"] as string;
        }
        string? method = option["method"] as string;
        string? path = option["path"] as string;
        IDictionary<string, object>? payload = new Dictionary<string, object>();
        if (option.ContainsKey("payload"))
        {
            payload = option["payload"] as IDictionary<string, object>;
        }
        IDictionary<string, string>? query = new Dictionary<string, string>(); ;
        if (option.ContainsKey("query"))
        {
            query = option["query"] as IDictionary<string, string>;
        }
        // 创建request
        HttpRequestMessage request = new HttpRequestMessage(new HttpMethod(method), BuildRequestUrl($"{host}/{version}/{path}", BuildQuery(query)));
        request.Headers.Add("Authorization", $"Bearer {this.apiKey}");
        if (payload != null && payload.Count > 0)
        {
            // request.Headers.Add("Content-type", "application/json;charset=utf-8");
            request.Content = JsonContent.Create(payload);
        }
        // 频率校验
        Global.DefaultLimiter.TryBeforeRun();
        // 发起http请求
        var response = await Global.DefaultHttpClient.SendAsync(request);
        // response.EnsureSuccessStatusCode();
        return await JsonSerializer.DeserializeAsync<JsonElement>(response.Content.ReadAsStream());
    }

    public static string BuildQuery(IDictionary<string, string>? parameters)
    {
        if (parameters == null || parameters.Count == 0)
        {
            return "";
        }

        StringBuilder query = new StringBuilder();
        bool hasParam = false;

        foreach (KeyValuePair<string, string> kv in parameters)
        {
            string name = kv.Key;
            string value = kv.Value;
            if (!string.IsNullOrEmpty(name) && !string.IsNullOrEmpty(value))
            {
                if (hasParam)
                {
                    query.Append("&");
                }

                query.Append(name);
                query.Append("=");
                hasParam = true;
            }
        }

        return query.ToString();
    }

    public static string BuildRequestUrl(string path, params string[] queries)
    {
        if (queries == null || queries.Length == 0)
        {
            return path;
        }

        StringBuilder newUrl = new StringBuilder(path);
        bool hasQuery = path.Contains("?");
        bool hasPrepend = path.EndsWith("?") || path.EndsWith("&");

        foreach (string query in queries)
        {
            if (!string.IsNullOrEmpty(query))
            {
                if (!hasPrepend)
                {
                    if (hasQuery)
                    {
                        newUrl.Append("&");
                    }
                    else
                    {
                        newUrl.Append("?");
                        hasQuery = true;
                    }
                }
                newUrl.Append(query);
                hasPrepend = false;
            }
        }
        return newUrl.ToString();
    }
}