package api.jdy;

import constants.HttpConstant;
import model.base.PageBaseParam;
import model.form.FormQueryParam;

import java.util.Map;

import static constants.HttpConstant.API_KEY;
import static constants.HttpConstant.APP_ID;

/**
 * 应用相关接口测试
 */
public class AppApiClientTest {

    private static final AppApiClient appApiClient = new AppApiClient(API_KEY, HttpConstant.HOST);


    public static void main(String[] args) throws Exception {
        // 应用列表 分页
        appList();
        // 表单查询接口 分页
        entryList();
    }

    private static void appList() throws Exception {
        PageBaseParam queryParam = new PageBaseParam();
        queryParam.setSkip(0);
        queryParam.setLimit(10);
        Map<String, Object> result = appApiClient.appList(queryParam, null);
        System.out.println("appList result \n" + result);
    }

    private static void entryList() throws Exception {
        FormQueryParam queryParam = new FormQueryParam();
        queryParam.setSkip(0);
        queryParam.setLimit(0);
        queryParam.setAppId(APP_ID);
        Map<String, Object> result = appApiClient.entryList(queryParam, null);
        System.out.println("entryList result \n" + result);
    }
}
