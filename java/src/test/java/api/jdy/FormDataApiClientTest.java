package api.jdy;

import constants.HttpConstant;
import model.form.*;

import java.util.*;

import static constants.HttpConstant.APP_ID;
import static constants.HttpConstant.ENTRY_ID;

/**
 * 表单数据相关接口测试
 */
public class FormDataApiClientTest {

    private static final FormDataApiClient formDataApiClient = new FormDataApiClient(HttpConstant.API_KEY, HttpConstant.HOST);

    private static final String NUM_WIDGET = "_widget_1669106585318";
    private static final String TEXT_WIDGET = "_widget_1669106585317";
    private static final String ADDRESS_WIDGET = "_widget_1669106585320";
    private static final String DATA_WIDGET = "_widget_1669106585319";

    private static String dataId = null;
    private static List<String> dataIdList = null;


    public static void main(String[] args) throws Exception {
        // 新建单条数据接口
        singleDataCreate();
        // 查询单条数据接口
        singleDataQuery();
        // 更新单条数据接口
        singleDataUpdate();
        // 删除单条数据
        singleDataRemove();

        // 新建多条数据接口
        batchDataCreate();
        // 查询多条数据
        batchDataQuery();
        //  修改多条数据接口
        batchDataUpdate();
        // 删除多条数据接口
        batchDataRemove();
    }

    private static void batchDataUpdate() throws Exception {
        FormDataBatchUpdateParam param =
                new FormDataBatchUpdateParam(APP_ID, ENTRY_ID);
        Map<String, Object> data = new HashMap<>();
        data.put(NUM_WIDGET, new HashMap<String, Object>() {
            {
                put("value", 2);
            }
        });
        param.setData(data);
        param.setData_ids(dataIdList);
        Map<String, Object> result = formDataApiClient.batchDataUpdate(param, null);
        System.out.println("batchDataUpdate result \n" + result);
    }

    private static void batchDataRemove() throws Exception {
        FormDataBatchRemoveParam param = new FormDataBatchRemoveParam(APP_ID, ENTRY_ID,
                dataIdList);
        Map<String, Object> result = formDataApiClient.batchDataRemove(param, null);
        System.out.println("batchDataRemove result \n" + result);
    }

    private static void batchDataQuery() throws Exception {
        FormDataQueryParam param = new FormDataQueryParam(APP_ID, ENTRY_ID);
        param.setLimit(10);
        // 只查这两个字段，不传为查全部字段
        param.setFieldList(Arrays.asList(NUM_WIDGET, TEXT_WIDGET));
        // 按条件查询表单数据
        List<Map<String, Object>> condList = new ArrayList<>();
        // 字段 _widget_1654848548482 的值 等于  单行文本 字符串
        condList.add(new HashMap<String, Object>() {
            {
                put("field", TEXT_WIDGET);
                put("type", "text");
                put("method", "eq");
                put("value", Collections.singletonList("单行文本1"));
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
        Map<String, Object> result = formDataApiClient.batchDataQuery(param, null);
        System.out.println("batchDataQuery result \n" + result);
    }


    private static void batchDataCreate() throws Exception {
        Map<String, Object> data = new HashMap<>();
        // 数字
        data.put(NUM_WIDGET, new HashMap<String, Object>() {
            {
                put("value", 123);
            }
        });
        // 单行文本
        data.put(TEXT_WIDGET, new HashMap<String, Object>() {
            {
                put("value", "单行文本1");
            }
        });
        // 地址
        data.put(ADDRESS_WIDGET, new HashMap<String, Object>() {
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
        data.put(DATA_WIDGET, new HashMap<String, Long>() {
            {
                put("value", 1654176800000L);
            }
        });
        List<Map<String, Object>> dataList = new ArrayList<>();
        dataList.add(data);
        dataList.add(data);

        FormDataBatchCreateParam createParam =
                new FormDataBatchCreateParam(APP_ID, ENTRY_ID, dataList);
        Map<String, Object> result = formDataApiClient.batchDataCreate(createParam, null);
        System.out.println("batchDataCreate result \n" + result);
        if (result.get("success_ids") != null) {
            dataIdList = (List<String>) result.get("success_ids");
        }
    }

    private static void singleDataRemove() throws Exception {
        FormDataDeleteParam deleteParam = new FormDataDeleteParam(APP_ID, ENTRY_ID, dataId);
        Map<String, Object> result = formDataApiClient.singleDataRemove(deleteParam, null);
        System.out.println("singleDataRemove result \n" + result);
    }

    private static void singleDataUpdate() throws Exception {
        Map<String, Object> data = new HashMap<>();
        // 数字
        data.put(NUM_WIDGET, new HashMap<String, Object>() {
            {
                put("value", 2);
            }
        });
        // 单行文本
        data.put(TEXT_WIDGET, new HashMap<String, Object>() {
            {
                put("value", "单行文本2");
            }
        });
        // 地址
        data.put(ADDRESS_WIDGET, new HashMap<String, Object>() {
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
        data.put(DATA_WIDGET, new HashMap<String, Long>() {
            {
                put("value", 1654976900000L);
            }
        });

        FormDataUpdateParam updateParam =
                new FormDataUpdateParam(APP_ID, ENTRY_ID, data);
        updateParam.setData_id(dataId);
        Map<String, Object> result = formDataApiClient.singleDataUpdate(updateParam, null);
        System.out.println("singleDataUpdate result \n" + result);
    }

    private static void singleDataCreate() throws Exception {
        Map<String, Object> data = new HashMap<>();
        // 数字
        data.put(NUM_WIDGET, new HashMap<String, Object>() {
            {
                put("value", 123);
            }
        });
        // 单行文本
        data.put(TEXT_WIDGET, new HashMap<String, Object>() {
            {
                put("value", "单行文本1");
            }
        });
        // 地址
        data.put(ADDRESS_WIDGET, new HashMap<String, Object>() {
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
        data.put(DATA_WIDGET, new HashMap<String, Long>() {
            {
                put("value", 1654176800000L);
            }
        });

        FormDataCreateParam createParam =
                new FormDataCreateParam(APP_ID, ENTRY_ID, data);
        Map<String, Object> result = formDataApiClient.singleDataCreate(createParam, null);
        System.out.println("singleDataCreate result \n" + result);
        if (result.get("data") != null) {
            Map<String, Object> dataResult = (Map<String, Object>) result.get("data");
            dataId = dataResult.get("_id").toString();
        }
    }

    private static void singleDataQuery() throws Exception {
        FormDataQueryParam queryParam = new FormDataQueryParam(APP_ID,ENTRY_ID);
        queryParam.setDataId(dataId);
        Map<String, Object> result = formDataApiClient.singleDataQuery(queryParam, null);
        System.out.println("singleDataQuery result \n" + result);
    }
}
