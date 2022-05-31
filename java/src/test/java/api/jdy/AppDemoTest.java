package api.jdy;

import api.jdy.AppDemo;

import java.util.Map;

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
        Map<String, Object> result = appDemo.appList(0, 10);
        System.out.println("appList result \n" + result);
    }

    private static void entryList(AppDemo appDemo) throws Exception {
        Map<String, Object> result =  appDemo.entryList("6077edcf5820c900083c9b26", 0, 10);
        System.out.println("entryList result \n" + result);
    }
}
