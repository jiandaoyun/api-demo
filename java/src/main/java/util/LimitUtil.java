package util;

import java.util.Arrays;
import java.util.List;

public class LimitUtil {
    private static volatile int seq = 0;

    private static final int bucket = 1000;

    private static volatile List<Long> requestTimeList = Arrays.asList(0L, 0L, 0L, 0L, 0L);

    private LimitUtil() {
    }

    /**
     * 限流实现 用 static synchronized 修饰 表示 对类上锁
     *
     * @throws InterruptedException
     */
    public static synchronized void tryBeforeRun() throws InterruptedException {
        long now = System.currentTimeMillis();
        // 当前时间 与 前limit个请求的时间 作比较
        long interval = now - requestTimeList.get(seq);
        if (interval < 0) {
            // 执行时间: t[seq]+bucket=now-interval+bucket
            // 等待时间: bucket-interval
            Thread.sleep(bucket - interval);
            // 重新等待
            tryBeforeRun();
        }
        if (interval < bucket) {
            requestTimeList.set(seq, requestTimeList.get(seq) + bucket);
            Thread.sleep(bucket - interval);
        } else {
            requestTimeList.set(seq, now);
        }
        seq = (seq + 1) % requestTimeList.size();
    }
}
