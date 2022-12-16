package api.jdy;

import constants.HttpConstant;
import model.base.PageBaseParam;

import java.util.Map;

import static constants.HttpConstant.API_KEY;

/**
 * 应用相关接口测试
 */
public class AppApiClientTest {

    private static final AppApiClient appApiClient = new AppApiClient(API_KEY, HttpConstant.HOST);


    public static void main(String[] args) throws Exception {
        // 应用列表 分页
        appList();
    }

    private static void appList() throws Exception {
        PageBaseParam queryParam = new PageBaseParam();
        queryParam.setSkip(0);
        queryParam.setLimit(10);
        Map<String, Object> result = appApiClient.appList(queryParam, null);
        System.out.println("appList result \n" + result);
    }
}
