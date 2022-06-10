package api.jdy;

import java.util.Map;

public class FormDemoTest {

    public static void main(String[] args) throws Exception {
        FormDemo formDemo = new FormDemo();
        // 表单字段查询接口
        formWidgets(formDemo);
    }

    private static void formWidgets(FormDemo formDemo) throws Exception {
        Map<String, Object> result = formDemo.formWidgets("62a03afaf1a9380006bbc5d3", "5cebabf676f7b904d79848c7");
        System.out.println("formWidgets result \n" + result);
    }

}
