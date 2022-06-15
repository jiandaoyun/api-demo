/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
*/
using Src.Api.Jdy;
using Src.Base;

namespace Test;

[Collection("Workflow")]
[TestCaseOrderer("XUnit.Project.Orderers.AlphabeticalOrderer", "Test")]
public class WorkflowTest
{

    private static WorkflowApiClient api = new WorkflowApiClient(Global.Host, Global.ApiKey);


    [Fact]
    public async void Test1()
    {
        var response = await api.approvalComments(AppTest.appId, AppTest.entryId, FormDataTest.dataId, new Dictionary<string, object>());
        Assert.Equal(4001, response.Value.GetProperty("code").GetInt64());
        Console.WriteLine(response);
    }
}