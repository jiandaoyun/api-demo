package util;

import api.arch.DeptDemo;

import java.util.Map;

public class LimitUtilThread implements Runnable {


    private String threadName;

    public LimitUtilThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        Long start = System.currentTimeMillis();
        DeptDemo deptDemo = new DeptDemo();
        Long temp;
        for (int i = 0; i < 15; i++) {
            try {
                temp = System.currentTimeMillis();
                Map<String, Object> reultMap = deptDemo.deptList(1);
                System.out.println(threadName + "第" + i + "次请求耗时 :" + (System.currentTimeMillis() - temp));
            } catch (Exception e) {
                System.out.println(threadName + " error happens!" + e.getMessage());
            }

        }
        Long end = System.currentTimeMillis();
        System.out.println(threadName + " cost time:" + (end - start) + "ms");
    }
}
