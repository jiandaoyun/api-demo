package api.jdy;

import constants.HttpConstant;
import model.form.FormQueryParam;

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
        // 表单查询接口 分页
        entryList();
    }

    private static void formWidgets() throws Exception {
        Map<String, Object> result = formApiClient.formWidgets(APP_ID, ENTRY_ID, null);
        System.out.println("formWidgets result \n" + result);
    }

    private static void entryList() throws Exception {
        FormQueryParam queryParam = new FormQueryParam();
        queryParam.setSkip(0);
        queryParam.setLimit(0);
        queryParam.setApp_id(APP_ID);
        Map<String, Object> result = formApiClient.entryList(queryParam, null);
        System.out.println("entryList result \n" + result);
    }
}
