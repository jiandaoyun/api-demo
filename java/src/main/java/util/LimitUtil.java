package util;

import java.util.ArrayList;
import java.util.List;

public class LimitUtil {
    private static volatile int seq = 0;

    private static int bucket = 1000;

    private static volatile List<Long> requestTimeList = new ArrayList(5) {{
        for (int i = 0; i < 5; i++) {
            add(0L);
        }
    }};
    ;

    private LimitUtil() {
    }

    /**
     * 限流实现 用 static synchronized 修饰 表示 对类上锁
     *
     * @throws InterruptedException
     */
    public static synchronized void tryBeforeRun() throws InterruptedException {
        Long now = System.currentTimeMillis();
        // 打印seq 看看 在多线程模式下 seq的顺序 是否是 0、1、2、3、4、0、1、2.。。
        System.out.println(Thread.currentThread().getName() + " seq :" + seq);
        // 当前时间 与 前limit个请求的时间 作比较
        Long interval = now - requestTimeList.get(seq);
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
