package util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LimitUtil {
    private int seq;

    private int bucket;

    private List<Long> requestTimeList;

    public LimitUtil() {
    }

    public LimitUtil(int bucket, int limit) {
        this.seq = 0;
        this.bucket = bucket;
        this.requestTimeList = new ArrayList(limit) {{
            for (int i = 0; i < limit; i++) {
                add(0L);
            }
        }};
    }

    public void tryBeforeRun() throws InterruptedException {
        Long now = System.currentTimeMillis();
        System.out.println("now" + now);
        // 当前时间 与 前limit个请求的时间 作比较
        Long interval = now - this.requestTimeList.get(this.seq);
        if (interval < 0) {
            // 执行时间: t[seq]+bucket=now-interval+bucket
            // 等待时间: bucket-interval
            Thread.sleep(this.bucket - interval);
            // 重新等待
            tryBeforeRun();
        }
        if (interval < this.bucket) {
            this.requestTimeList.set(this.seq, this.requestTimeList.get(this.seq) + this.bucket);
            Thread.sleep(this.bucket - interval);
        } else {
            this.requestTimeList.set(this.seq, now);
        }
        this.seq = (this.seq + 1) % this.requestTimeList.size();
    }
}
