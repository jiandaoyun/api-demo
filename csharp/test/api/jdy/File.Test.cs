/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/06/14
*/
using Src.Api.Jdy;
using Src.Base;

namespace Test;

[Collection("File")]
[TestCaseOrderer("XUnit.Project.Orderers.AlphabeticalOrderer", "Test")]
public class FileTest
{
    public static string transactionId = "87cd7d71-c6df-4281-9927-469094395677";
    public static string token = "";
    public static string url = "";

    private static FileApiClient api = new FileApiClient(Global.Host, Global.ApiKey);

    [Fact]
    public async void Test1()
    {
        var response = await api.uploadToken(AppTest.appId, AppTest.entryId, transactionId);
        Assert.True(response != null);
        Assert.Equal(100, response.Value.GetProperty("token_and_url_list").GetArrayLength());
        token = response.Value.GetProperty("token_and_url_list")[0].GetProperty("token").GetString();
        url = response.Value.GetProperty("token_and_url_list")[0].GetProperty("url").GetString();
        Console.WriteLine(url);
        Console.WriteLine(token);
    }

    // [Fact]
    // public async void Test2()
    // {
    //     FileStream file = File.Create("./file");
    //     file.Write(Encoding.ASCII.GetBytes("上传文件"));
    //     var response = await api.uploadFile(url, token, file);
    //     Assert.True(response != null);
    //     Console.WriteLine(response);
    // }
}