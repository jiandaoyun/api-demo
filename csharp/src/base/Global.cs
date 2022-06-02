/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/05/31
*/
namespace Src.Base;

public static class Global
{
    public static readonly string ApiKey = "TDlysl39yzl65V0ZmVf6AcSJTL3VwGYp";
    public static readonly string Host = "https://api.jiandaoyun.com/api";
    public static readonly Limiter DefaultLimiter = new Limiter(1000, 5);

    public static void TryBeforeRun(object? obj)
    {
        if (obj == null)
        {
            throw new Exception("unknown error");
        }
        ManualResetEvent mre = (ManualResetEvent)obj;
        DefaultLimiter.TryBeforeRun();
        mre.Set();
    }

    public static readonly HttpClient DefaultHttpClient = new HttpClient();

    static Global()
    {
        DefaultHttpClient.Timeout = TimeSpan.FromSeconds(5);
    }
}