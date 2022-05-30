package api.arch;

import api.jdy.AppDemo;

/**
 * 应用 Demo 测试
 */
public class AppDemoTest {


    public static void main(String[] args) throws Exception {
        AppDemo appDemo = new AppDemo();
        // 应用列表 分页
        appList(appDemo);
        // 表单查询接口 分页
        entryList(appDemo);
    }

    private static void appList(AppDemo appDemo) throws Exception {
        appDemo.appList(0,10);
    }

    private static void entryList(AppDemo appDemo) throws Exception {
        appDemo.entryList("6077edcf5820c900083c9b26",0,10);
    }
}
