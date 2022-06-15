/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
*/
using Src.Api.Jdy;
using Src.Base;

namespace Test;

[Collection("Form")]
[TestCaseOrderer("XUnit.Project.Orderers.AlphabeticalOrderer", "Test")]
public class FormTest
{

    private static FormApiClient api = new FormApiClient(Global.Host, Global.ApiKey);

    [Fact]
    public async void Test1()
    {
        var formWidgets = await api.formWidgets(AppTest.appId, AppTest.entryId);
        Assert.True(formWidgets != null);
        Console.WriteLine(formWidgets);
    }
}