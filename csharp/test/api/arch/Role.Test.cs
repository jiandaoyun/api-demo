/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
*/
using Src.Api.Jdy;
using Src.Base;

namespace Test;

[Collection("Role")]
[TestCaseOrderer("XUnit.Project.Orderers.AlphabeticalOrderer", "Test")]
public class RoleTest
{
    private static RoleApiClient api = new RoleApiClient(Global.Host, Global.ApiKey);

    [Fact]
    public async void Test1()
    {
        var roleList = await api.roleList(new Dictionary<string, object>());
        Assert.True(roleList != null);
        Console.WriteLine(roleList);
    }
}