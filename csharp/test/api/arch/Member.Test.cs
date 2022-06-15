/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
*/
using Src.Api.Jdy;
using Src.Base;

namespace Test;

[Collection("Member")]
[TestCaseOrderer("XUnit.Project.Orderers.AlphabeticalOrderer", "Test")]
public class MemberTest
{
    public static string username = "";
    public static int rootDeptNo = 1;

    private static MemberApiClient api = new MemberApiClient(Global.Host, Global.ApiKey);

    [Fact]
    public async void Test1()
    {
        var option = new Dictionary<string, object>();
        option.Add("hasChild", true);
        var deptMemberList = await api.deptMemberList(rootDeptNo, option);
        Assert.True(deptMemberList != null);
        Console.WriteLine(deptMemberList);
    }

    [Fact]
    public async void Test2()
    {
        var option = new Dictionary<string, object>();
        option.Add("username", "jiandaoyun");
        var user = await api.userCreate("小云", option);
        Assert.True(user != null);
        Assert.Equal("小云", user.Value.GetProperty("user").GetProperty("name").GetString());
        Assert.Equal("jiandaoyun", user.Value.GetProperty("user").GetProperty("username").GetString());
        Console.WriteLine(user);
        username = user.Value.GetProperty("user").GetProperty("username").GetString();
    }

    [Fact]
    public async void Test3()
    {
        var user = await api.userInfo(username);
        Assert.True(user != null);
        Assert.Equal("小云", user.Value.GetProperty("user").GetProperty("name").GetString());
        Assert.Equal("jiandaoyun", user.Value.GetProperty("user").GetProperty("username").GetString());
        Console.WriteLine(user);
    }

    [Fact]
    public async void Test4()
    {
        var option = new Dictionary<string, object>();
        option.Add("name", "小简");
        var user = await api.userUpdate(username, option);
        Assert.True(user != null);
        Assert.Equal("小简", user.Value.GetProperty("user").GetProperty("name").GetString());
        Assert.Equal("jiandaoyun", user.Value.GetProperty("user").GetProperty("username").GetString());
        Console.WriteLine(user);
    }

    [Fact]
    public async void Test5()
    {
        var response = await api.userDelete(username);
        Assert.True(response != null);
        Assert.Equal("success", response.Value.GetProperty("status").GetString());
    }

    [Fact]
    public async void Test6()
    {
        string[] usernames = { username };
        var response = await api.userBatchDelete(usernames);
        Assert.True(response != null);
        Assert.Equal("success", response.Value.GetProperty("status").GetString());
    }

    [Fact]
    public async void Test7()
    {
        Dictionary<string, object>[] users = { };
        var response = await api.userImport(users);
        Assert.True(response != null);
        Assert.Equal("success", response.Value.GetProperty("status").GetString());
    }
}