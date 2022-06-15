/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/15
*/
using Src.Api.Jdy;
using Src.Base;

namespace Test;

[Collection("CorpCoop")]
[TestCaseOrderer("XUnit.Project.Orderers.AlphabeticalOrderer", "Test")]
public class CorpCoopTest
{
    private static CorpCoopApiClient api = new CorpCoopApiClient(Global.Host, Global.ApiKey);


    [Fact]
    public async void Test1()
    {
        var corpCoopDepartList = await api.corpCoopDepartList(new Dictionary<string, object>());
        Assert.True(corpCoopDepartList != null);
        Console.WriteLine(corpCoopDepartList);
    }
}