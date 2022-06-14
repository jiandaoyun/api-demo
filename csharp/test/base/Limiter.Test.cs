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
        Thread.Sleep(1000);
        long start = new DateTimeOffset(DateTime.UtcNow).ToUnixTimeMilliseconds();
        List<ManualResetEvent> manualEvents = new List<ManualResetEvent>();
        for (int i = 0; i < 15; i++)
        {
            ManualResetEvent mre = new ManualResetEvent(false);
            manualEvents.Add(mre);
            ThreadPool.QueueUserWorkItem(Global.TryBeforeRun, mre);
        }
        WaitHandle.WaitAll(manualEvents.ToArray());
        long cost = new DateTimeOffset(DateTime.UtcNow).ToUnixTimeMilliseconds() - start;
        Console.WriteLine(cost);
    }

    // [Fact]
    // public void TestTryBeforeRunSlowSpeed()
    // {
    // }
}