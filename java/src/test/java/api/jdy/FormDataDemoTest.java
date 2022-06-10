package api.jdy;

import model.form.*;

import java.util.*;

public class FormDataDemoTest {

    public static void main(String[] args) throws Exception {
        FormDataDemo formDataDemo = new FormDataDemo();
        // 查询单条数据接口
//        singleDataQuery(formDataDemo);
//        // 新建单条数据接口
//        singleDataCreate(formDataDemo);
//         // 更新单条数据接口
//        singleDataUpdate(formDataDemo);
        // 删除单条数据
//        singleDataRemove(formDataDemo);
//        // 新建多条数据接口
//        batchDataCreate(formDataDemo);
//        // 查询多条数据
//        batchDataQuery(formDataDemo);
//        // 删除多条数据接口
//        batchDataRemove(formDataDemo);
        //  修改多条数据接口
        batchDataUpdate(formDataDemo);

    }

    private static void batchDataUpdate(FormDataDemo formDataDemo) throws Exception {
        FormDataBatchUpdateParam param =
                new FormDataBatchUpdateParam("62a2fc216575a5000628c41f", "62a2fc246575a5000628c444");
        Map<String,Object> data = new HashMap<>();
        data.put("_widget_1654848548501", new HashMap<String, Object>() {
            {
                put("value", 2);
            }
        });
        param.setData(data);
        param.setDataIds(Arrays.asList("62a309ad5cb2173054a96148","62a309ad5cb2173054a96147"));
        Map<String, Object> result = formDataDemo.batchDataUpdate(param);
        System.out.println("batchDataUpdate result \n" + result);
    }

    private static void batchDataRemove(FormDataDemo formDataDemo) throws Exception {
        Map<String, Object> result = formDataDemo.batchDataRemove("62a2fc216575a5000628c41f", "62a2fc246575a5000628c444",
                Arrays.asList("62a302733713b400069e42d1"));
        System.out.println("batchDataRemove result \n" + result);
    }

    private static void batchDataQuery(FormDataDemo formDataDemo) throws Exception {
        FormDataQueryParam param = new FormDataQueryParam();
        param.setAppId("62a2fc216575a5000628c41f");
        param.setEntryId("62a2fc246575a5000628c444");
        param.setDataId("62a2fc6f5e66850006738f73");
        param.setLimit(10);
        param.setFieldList(Arrays.asList("_widget_1654848548482", "_widget_1654848548501"));
        // 按条件查询表单数据
        List<Map<String, Object>> condList = new ArrayList<Map<String, Object>>();
        // 字段 _widget_1654848548482 的值 等于  单行文本 字符串
        condList.add(new HashMap<String, Object>() {
            {
                put("field", "_widget_1654848548482");
                put("type", "text");
                put("method", "eq");
                put("value", Arrays.asList("单行文本"));
            }
        });
        Map<String, Object> filter = new HashMap<String, Object>() {
            {
                // 关系是 and
                put("rel", "and");
                put("cond", condList);
            }
        };
        param.setFilter(filter);
        Map<String, Object> result = formDataDemo.batchDataQuery(param);
        System.out.println("batchDataQuery result \n" + result);
    }


    private static void batchDataCreate(FormDataDemo formDataDemo) throws Exception {
        Map<String, Object> data = new HashMap<>();
        // 数字
        data.put("_widget_1654848548501", new HashMap<String, Object>() {
            {
                put("value", 123);
            }
        });
        // 单行文本
        data.put("_widget_1654848548482", new HashMap<String, Object>() {
            {
                put("value", "单行文本1");
            }
        });
        // 地址
        data.put("_widget_1654848578745", new HashMap<String, Object>() {
            {
                put("value", new HashMap<String, String>() {
                    {
                        put("province", "北京市");
                        put("city", "北京市");
                        put("district", "东城区");
                        put("detail", "详细地址123");
                    }
                });
            }
        });
        // 日期
        data.put("_widget_1654848591194", new HashMap<String, Long>() {
            {
                put("value", 1654876800000L);
            }
        });
        List<Map<String, Object>> dataList = new ArrayList<>();
        dataList.add(data);
        dataList.add(data);

        FormDataBatchCreateParam createParam =
                new FormDataBatchCreateParam("62a2fc216575a5000628c41f", "62a2fc246575a5000628c444", dataList);
        Map<String, Object> result = formDataDemo.batchDataCreate(createParam);
        System.out.println("batchDataCreate result \n" + result);
    }

    private static void singleDataRemove(FormDataDemo formDataDemo) throws Exception {
        FormDataDeleteParam deleteParam = new FormDataDeleteParam("62a2fc216575a5000628c41f", "62a2fc246575a5000628c444", "62a303315cb2173054a96116");
        Map<String, Object> result = formDataDemo.singleDataRemove(deleteParam);
        System.out.println("singleDataRemove result \n" + result);
    }

    private static void singleDataUpdate(FormDataDemo formDataDemo) throws Exception {
        Map<String, Object> data = new HashMap<>();
        // 数字
        data.put("_widget_1654848548501", new HashMap<String, Object>() {
            {
                put("value", 2);
            }
        });
        // 单行文本
        data.put("_widget_1654848548482", new HashMap<String, Object>() {
            {
                put("value", "单行文本2");
            }
        });
        // 地址
        data.put("_widget_1654848578745", new HashMap<String, Object>() {
            {
                put("value", new HashMap<String, String>() {
                    {
                        put("province", "北京市");
                        put("city", "北京市");
                        put("district", "东城区");
                        put("detail", "详细地址321");
                    }
                });
            }
        });
        // 日期
        data.put("_widget_1654848591194", new HashMap<String, Long>() {
            {
                put("value", 1654876900000L);
            }
        });

        FormDataUpdateParam updateParam =
                new FormDataUpdateParam("62a2fc216575a5000628c41f", "62a2fc246575a5000628c444", data);
        updateParam.setDataId("62a303315cb2173054a96116");
        Map<String, Object> result = formDataDemo.singleDataUpdate(updateParam);
        System.out.println("singleDataUpdate result \n" + result);
    }

    private static void singleDataCreate(FormDataDemo formDataDemo) throws Exception {
        Map<String, Object> data = new HashMap<>();
        // 数字
        data.put("_widget_1654848548501", new HashMap<String, Object>() {
            {
                put("value", 123);
            }
        });
        // 单行文本
        data.put("_widget_1654848548482", new HashMap<String, Object>() {
            {
                put("value", "单行文本1");
            }
        });
        // 地址
        data.put("_widget_1654848578745", new HashMap<String, Object>() {
            {
                put("value", new HashMap<String, String>() {
                    {
                        put("province", "北京市");
                        put("city", "北京市");
                        put("district", "东城区");
                        put("detail", "详细地址123");
                    }
                });
            }
        });
        // 日期
        data.put("_widget_1654848591194", new HashMap<String, Long>() {
            {
                put("value", 1654876800000L);
            }
        });

        FormDataCreateParam createParam =
                new FormDataCreateParam("62a2fc216575a5000628c41f", "62a2fc246575a5000628c444", data);
        Map<String, Object> result = formDataDemo.singleDataCreate(createParam);
        System.out.println("singleDataCreate result \n" + result);
    }

    private static void singleDataQuery(FormDataDemo formDataDemo) throws Exception {
        Map<String, Object> result = formDataDemo.singleDataQuery("62a2fc216575a5000628c41f", "62a2fc246575a5000628c444", "62a303315cb2173054a96116");
        System.out.println("singleDataQuery result \n" + result);
    }
}
