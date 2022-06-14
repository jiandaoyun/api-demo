/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/01
*/

using Src.Api.Jdy;
using Src.Base;

namespace Test;

[TestCaseOrderer("XUnit.Project.Orderers.AlphabeticalOrderer", "Test")]
public class AppTest
{
    public static string appId = "";
    public static string entryId = "";

    private static AppApiClient api = new AppApiClient(Global.Host, Global.ApiKey);

    [Fact]
    public async void TestAppList()
    {
        var appList = await api.appList(new Dictionary<string, object>());
        Assert.True(appList != null);
        Console.WriteLine(appList);
        appId = appList.Value.GetProperty("apps")[0].GetProperty("app_id").GetString();
    }

    [Fact]
    public async void TestEntryList()
    {
        var entryList = await api.entryList(appId, new Dictionary<string, object>());
        Assert.True(entryList != null);
        entryId = entryList.Value.GetProperty("forms")[0].GetProperty("entry_id").GetString();
        Console.WriteLine(entryList);
    }
}