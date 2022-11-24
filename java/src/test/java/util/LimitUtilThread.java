package util;

import api.arch.DeptApiClient;
import constants.HttpConstant;

public class LimitUtilThread implements Runnable {

    private final String threadName;

    private static final DeptApiClient deptApiClient = new DeptApiClient(HttpConstant.API_KEY, HttpConstant.HOST);

    public LimitUtilThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();

        long temp;
        for (int i = 0; i < 15; i++) {
            try {
                temp = System.currentTimeMillis();
                deptApiClient.deptList(1, true, null);
                System.out.println(threadName + "第" + i + "次请求耗时 :" + (System.currentTimeMillis() - temp));
            } catch (Exception e) {
                System.out.println(threadName + " error happens!" + e.getMessage());
            }

        }
        long end = System.currentTimeMillis();
        System.out.println(threadName + " cost time:" + (end - start) + "ms");
    }
}
