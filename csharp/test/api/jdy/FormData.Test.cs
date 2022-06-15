/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
*/
using Src.Api.Jdy;
using Src.Base;

namespace Test;

[Collection("FormData")]
[TestCaseOrderer("XUnit.Project.Orderers.AlphabeticalOrderer", "Test")]
public class FormDataTest
{
    public static IDictionary<string, object> emptyData = new Dictionary<string, object>();

    public static string dataId = "";
    public static List<string> dataIds = new List<string>();

    private static FormDataApiClient api = new FormDataApiClient(Global.Host, Global.ApiKey);

    [Fact]
    public async void Test1()
    {
        var formData = await api.singleDataCreate(AppTest.appId, AppTest.entryId, emptyData, new Dictionary<string, object>());
        Assert.True(formData != null);
        Console.WriteLine(formData);
        dataId = formData.Value.GetProperty("data").GetProperty("_id").GetString();
    }

    [Fact]
    public async void Test2()
    {
        var formData = await api.singleDataQuery(AppTest.appId, AppTest.entryId, dataId);
        Assert.True(formData != null);
        Console.WriteLine(formData);
        Assert.Equal(dataId, formData.Value.GetProperty("data").GetProperty("_id").GetString());
    }

    [Fact]
    public async void Test3()
    {
        var formData = await api.singleDataUpdate(AppTest.appId, AppTest.entryId, dataId, emptyData, new Dictionary<string, object>());
        Assert.True(formData != null);
        Console.WriteLine(formData);
        Assert.Equal(dataId, formData.Value.GetProperty("data").GetProperty("_id").GetString());
    }

    [Fact]
    public async void Test4()
    {
        var response = await api.singleDataRemove(AppTest.appId, AppTest.entryId, dataId, new Dictionary<string, object>());
        Assert.True(response != null);
        Assert.Equal("success", response.Value.GetProperty("status").GetString());
    }

    [Fact]
    public async void Test5()
    {
        IDictionary<string, object>[] batchData = { emptyData, emptyData };
        var response = await api.batchDataCreate(AppTest.appId, AppTest.entryId, batchData, new Dictionary<string, object>());
        Assert.True(response != null);
        Assert.Equal("success", response.Value.GetProperty("status").GetString());
        Assert.Equal(2, response.Value.GetProperty("success_count").GetInt64());
        foreach (JsonElement element in response.Value.GetProperty("success_ids").EnumerateArray())
        {
            dataIds.Add(element.GetString());
        }
    }

    [Fact]
    public async void Test6()
    {
        var option = new Dictionary<string, object>();
        option.Add("limit", 2);
        var response = await api.batchDataQuery(AppTest.appId, AppTest.entryId, option);
        Assert.True(response != null);
        Assert.Equal(2, response.Value.GetProperty("data").GetArrayLength());
        Console.WriteLine(response);
    }

    [Fact]
    public async void Test7()
    {
        var response = await api.batchDataUpdate(AppTest.appId, AppTest.entryId, dataIds.ToArray(), emptyData, new Dictionary<string, object>());
        Assert.True(response != null);
        Assert.Equal("success", response.Value.GetProperty("status").GetString());
        Assert.Equal(2, response.Value.GetProperty("success_count").GetInt64());
        Console.WriteLine(response);
    }

    [Fact]
    public async void Test8()
    {
        var response = await api.batchDataRemove(AppTest.appId, AppTest.entryId, dataIds.ToArray());
        Assert.True(response != null);
        Assert.Equal("success", response.Value.GetProperty("status").GetString());
        Assert.Equal(2, response.Value.GetProperty("success_count").GetInt64());
        Console.WriteLine(response);
    }
}