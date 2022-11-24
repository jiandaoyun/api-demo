package api.jdy;

import constants.HttpConstant;

import java.util.Map;

import static constants.HttpConstant.APP_ID;
import static constants.HttpConstant.ENTRY_ID;

/**
 * 表单相关接口测试
 */
public class FormApiClientTest {

    private static final FormApiClient formApiClient = new FormApiClient(HttpConstant.API_KEY, HttpConstant.HOST);

    public static void main(String[] args) throws Exception {
        // 表单字段查询接口
        formWidgets();
    }

    private static void formWidgets() throws Exception {
        Map<String, Object> result = formApiClient.formWidgets(APP_ID, ENTRY_ID, null);
        System.out.println("formWidgets result \n" + result);
    }

}
