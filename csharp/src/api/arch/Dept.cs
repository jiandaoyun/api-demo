/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/15
*/
using System.Text.Json;
using Src.Base;

namespace Src.Api.Jdy;

public class DeptApiClient : ApiClient
{
    private readonly static string[] validVersions = { "v2" };
    private readonly static string defaultVersion = "v2";
    public DeptApiClient(string host, string apiKey, string version = "") : base(host, apiKey, version)
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
    *（递归）获取部门列表
    */
    public async Task<JsonElement?> deptList(int deptNo, IDictionary<string, object> option)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", $"department/{deptNo}/department_list");
        requestOption.Add("payload", option);
        return await this.doRequest(requestOption);
    }

    /**
    * 创建部门
    */
    public async Task<JsonElement?> deptCreate(string name, IDictionary<string, object> option)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", "department/create");
        option.Add("name", name);
        requestOption.Add("payload", option);
        return await this.doRequest(requestOption);
    }

    /**
    * 更新部门
    */
    public async Task<JsonElement?> deptUpdate(int deptNo, string name)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", $"department/{deptNo}/update");
        IDictionary<string, object> option = new Dictionary<string, object>();
        option.Add("name", name);
        requestOption.Add("payload", option);
        return await this.doRequest(requestOption);
    }

    /**
    * 删除部门
    */
    public async Task<JsonElement?> deptDelete(int deptNo)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", $"department/{deptNo}/delete");
        return await this.doRequest(requestOption);
    }

    /**
    * 根据集成模式通讯录的部门ID获取部门编号
    */
    public async Task<JsonElement?> deptByIntegrateId(string integrateId)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", "department/get_deptno_by_integrateid");
        IDictionary<string, object> option = new Dictionary<string, object>();
        option.Add("integrate_id", integrateId);
        return await this.doRequest(requestOption);
    }

    /**
    * 批量导入部门
    */
    public async Task<JsonElement?> departmentImport(Dictionary<string, object>[] departments)
    {
        IDictionary<string, object> requestOption = new Dictionary<string, object>();
        requestOption.Add("method", "POST");
        requestOption.Add("path", "department/import");
        IDictionary<string, object> option = new Dictionary<string, object>();
        option.Add("departments", departments);
        return await this.doRequest(requestOption);
    }
}