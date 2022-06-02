/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/01
*/

using Src.Api.Jdy;
using Src.Base;

namespace Test;

public class AppTest
{
    private static AppApiClient api = new AppApiClient(Global.Host, Global.ApiKey);
    private string appId = "";

    [Fact]
    public async void TestAppList()
    {
        var appList = await api.appList(0, 10);
        Assert.True(appList != null);
        Console.WriteLine(appList);
        this.appId = appList.Value.GetProperty("apps")[0].GetProperty("app_id").GetString();
        Console.WriteLine(this.appId);
    }
}