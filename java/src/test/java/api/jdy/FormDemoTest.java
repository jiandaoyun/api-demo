package api.jdy;

import java.util.Map;

import static constants.HttpConstant.APP_ID;
import static constants.HttpConstant.ENTRY_ID;

public class FormDemoTest {

    public static void main(String[] args) throws Exception {
        FormDemo formDemo = new FormDemo();
        // 表单字段查询接口
        formWidgets(formDemo);
    }

    private static void formWidgets(FormDemo formDemo) throws Exception {
        Map<String, Object> result = formDemo.formWidgets(APP_ID, ENTRY_ID);
        System.out.println("formWidgets result \n" + result);
    }

}
