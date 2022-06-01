/**
* Copyright (c) 2015-2022, FineX, All Rights Reserved.
* @author Thomas.Zhuang
* @date 2022/05/31
*/
namespace Src.Base;

public class Limiter
{
    private int seq;
    private long bucket;
    private long[] t;
    private readonly Mutex mutex = new Mutex();

    public Limiter(long duration, int limit)
    {
        this.seq = 0;
        this.bucket = duration;
        this.t = new long[limit];
    }

    public void TryBeforeRun()
    {
        mutex.WaitOne();
        int idx = this.seq;
        long now = new DateTimeOffset(DateTime.UtcNow).ToUnixTimeMilliseconds();
        long interval = now - this.t[idx];
        if (interval < 0)
        {
            mutex.ReleaseMutex();
            Thread.Sleep((int)(this.bucket - interval));
            this.TryBeforeRun();
            return;
        }

        if (interval < this.bucket)
        {
            this.t[idx] += this.bucket;
            this.seq = (idx + 1) % this.t.Length;
            mutex.ReleaseMutex();
            Thread.Sleep((int)(this.bucket - interval));
        }
        else
        {
            this.t[idx] = now;
            this.seq = (idx + 1) % this.t.Length;
            mutex.ReleaseMutex();
        }
    }
}