package util;

/**
 * 限流 多线程 测试
 */
public class LimitUtilTest {

    public static void main(String[] args) {
        // 线程1
        LimitUtilThread thread1 = new LimitUtilThread("thread1");
        Thread t1 = new Thread(thread1);
        // 线程2
        LimitUtilThread thread2 = new LimitUtilThread("thread2");
        Thread t2 = new Thread(thread2);
        // 线程2
        LimitUtilThread thread3 = new LimitUtilThread("thread3");
        Thread t3 = new Thread(thread3);

        t1.start();
        t2.start();
        t3.start();
    }
}
