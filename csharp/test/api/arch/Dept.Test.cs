/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/15
*/
using Src.Api.Jdy;
using Src.Base;

namespace Test;

[Collection("Dept")]
[TestCaseOrderer("XUnit.Project.Orderers.AlphabeticalOrderer", "Test")]
public class DeptTest
{
    public static int deptNo = Int32.MinValue;

    private static DeptApiClient api = new DeptApiClient(Global.Host, Global.ApiKey);

    [Fact]
    public async void Test1()
    {
        var dept = await api.deptCreate("Demo研发部门", new Dictionary<string, object>());
        Assert.True(dept != null);
        Console.WriteLine(dept);
        deptNo = dept.Value.GetProperty("department").GetProperty("dept_no").GetInt32();
    }

    [Fact]
    public async void Test2()
    {
        var dept = await api.deptUpdate(deptNo, "Demo测试部门");
        Assert.True(dept != null);
        Assert.Equal(deptNo, dept.Value.GetProperty("department").GetProperty("dept_no").GetInt32());
        Assert.Equal("Demo测试部门", dept.Value.GetProperty("department").GetProperty("name").GetString());
        Console.WriteLine(dept);
    }

    [Fact]
    public async void Test3()
    {
        var option = new Dictionary<string, object>();
        option.Add("hasChild", true);
        var deptList = await api.deptList(deptNo, option);
        Assert.True(deptList != null);
        Console.WriteLine(deptList);
    }

    [Fact]
    public async void Test4()
    {
        var response = await api.deptDelete(deptNo);
        Assert.True(response != null);
        Assert.Equal("success", response.Value.GetProperty("status").GetString());
    }

    [Fact]
    public async void Test5()
    {
        var response = await api.deptByIntegrateId("1005");
        Assert.True(response != null);
        Assert.Equal(3005, response.Value.GetProperty("code").GetInt64());
        Console.WriteLine(response);
    }

    [Fact]
    public async void Test6()
    {
        Dictionary<string, object>[] depts = { };
        var response = await api.departmentImport(depts);
        Assert.True(response != null);
        Assert.Equal(6014, response.Value.GetProperty("code").GetInt64());
        Console.WriteLine(response);
    }
}