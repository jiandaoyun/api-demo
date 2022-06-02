/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/05/31
*/
using Src.Base;

namespace Test;
public class LimiterTest
{
    [Fact]
    public void TestTryBeforeRunMaxSpeed()
    {
        long start = new DateTimeOffset(DateTime.UtcNow).ToUnixTimeMilliseconds();
        List<ManualResetEvent> manualEvents = new List<ManualResetEvent>();
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 15; i++)
        {
            ManualResetEvent mre = new ManualResetEvent(false);
            manualEvents.Add(mre);
            ThreadPool.QueueUserWorkItem(Global.TryBeforeRun, mre);
        }
        WaitHandle.WaitAll(manualEvents.ToArray());
        Console.WriteLine(new DateTimeOffset(DateTime.UtcNow).ToUnixTimeMilliseconds() - start);
    }

    // [Fact]
    // public void TestTryBeforeRunSlowSpeed()
    // {
    // }
}