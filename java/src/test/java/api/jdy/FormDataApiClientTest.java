package api.jdy;

import constants.HttpConstant;
import model.form.*;
import model.http.HttpRequestParam;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.*;

import static constants.HttpConstant.APP_ID;
import static constants.HttpConstant.ENTRY_ID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * 表单数据相关接口测试
 */
public class FormDataApiClientTest {

    private static final FormDataApiClient formDataApiClient = new FormDataApiClient(HttpConstant.API_KEY, HttpConstant.HOST);

    private static final String NUM_WIDGET = "_widget_1669106585318";
    private static final String TEXT_WIDGET = "_widget_1669106585317";
    private static final String ADDRESS_WIDGET = "_widget_1669106585320";
    private static final String DATA_WIDGET = "_widget_1669106585319";

    private static final String dataId = "671619c7cda20728e6d89c51";
    private static final List<String> dataIdList = Arrays.asList("671619c7cda20728e6d89c52", "671619c7cda20728e6d89c53");

    @Test
    @DisplayName("test batchDataUpdate")
    public void batchDataUpdate() throws Exception {
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

        FormDataApiClient spyClient = spy(formDataApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.batchDataUpdate(param, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/app/entry/data/batch_update", httpRequestParam.getPath());
        assertEquals(APP_ID, httpRequestParam.getData().get("app_id"));
        assertEquals(ENTRY_ID, httpRequestParam.getData().get("entry_id"));
        assertEquals(dataIdList, httpRequestParam.getData().get("data_ids"));
        assertEquals(data, httpRequestParam.getData().get("data"));
    }

    @Test
    @DisplayName("test batchDataRemove")
    public void batchDataRemove() throws Exception {
        FormDataBatchRemoveParam param = new FormDataBatchRemoveParam(APP_ID, ENTRY_ID, dataIdList);

        FormDataApiClient spyClient = spy(formDataApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.batchDataRemove(param, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/app/entry/data/batch_delete", httpRequestParam.getPath());
        assertEquals(APP_ID, httpRequestParam.getData().get("app_id"));
        assertEquals(ENTRY_ID, httpRequestParam.getData().get("entry_id"));
        assertEquals(dataIdList, httpRequestParam.getData().get("data_ids"));
    }

    @Test
    @DisplayName("test batchDataQuery")
    public void batchDataQuery() throws Exception {
        FormDataQueryParam param = new FormDataQueryParam(APP_ID, ENTRY_ID);
        param.setLimit(10);
        param.setData_id(dataId);
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

        FormDataApiClient spyClient = spy(formDataApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.batchDataQuery(param, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/app/entry/data/list", httpRequestParam.getPath());
        assertEquals(APP_ID, httpRequestParam.getData().get("app_id"));
        assertEquals(ENTRY_ID, httpRequestParam.getData().get("entry_id"));
        assertEquals(dataId, httpRequestParam.getData().get("data_id"));
        assertEquals(10, httpRequestParam.getData().get("limit"));
        assertEquals(Arrays.asList(NUM_WIDGET, TEXT_WIDGET), httpRequestParam.getData().get("fieldList"));
        assertEquals(filter, httpRequestParam.getData().get("filter"));
    }

    @Test
    @DisplayName("test batchDataCreate")
    public void batchDataCreate() throws Exception {
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
        createParam.setIs_start_workflow(false);

        FormDataApiClient spyClient = spy(formDataApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.batchDataCreate(createParam, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/app/entry/data/batch_create", httpRequestParam.getPath());
        assertEquals(APP_ID, httpRequestParam.getData().get("app_id"));
        assertEquals(ENTRY_ID, httpRequestParam.getData().get("entry_id"));
        assertEquals(dataList, httpRequestParam.getData().get("data_list"));
        assertEquals(false, httpRequestParam.getData().get("is_start_workflow"));
    }

    @Test
    @DisplayName("test singleDataRemove")
    public void singleDataRemove() throws Exception {
        FormDataDeleteParam deleteParam = new FormDataDeleteParam(APP_ID, ENTRY_ID, dataId);

        FormDataApiClient spyClient = spy(formDataApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.singleDataRemove(deleteParam, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/app/entry/data/delete", httpRequestParam.getPath());
        assertEquals(APP_ID, httpRequestParam.getData().get("app_id"));
        assertEquals(ENTRY_ID, httpRequestParam.getData().get("entry_id"));
        assertEquals(dataId, httpRequestParam.getData().get("data_id"));
    }

    @Test
    @DisplayName("test singleDataUpdate")
    public void singleDataUpdate() throws Exception {
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
        updateParam.setIs_start_trigger(false);

        FormDataApiClient spyClient = spy(formDataApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.singleDataUpdate(updateParam, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/app/entry/data/update", httpRequestParam.getPath());
        assertEquals(APP_ID, httpRequestParam.getData().get("app_id"));
        assertEquals(ENTRY_ID, httpRequestParam.getData().get("entry_id"));
        assertEquals(dataId, httpRequestParam.getData().get("data_id"));
        assertEquals(data, httpRequestParam.getData().get("data"));
        assertEquals(false, httpRequestParam.getData().get("is_start_trigger"));
    }

    @Test
    @DisplayName("test singleDataCreate")
    public void singleDataCreate() throws Exception {
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
        createParam.setIs_start_trigger(false);
        createParam.setIs_start_workflow(false);

        FormDataApiClient spyClient = spy(formDataApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.singleDataCreate(createParam, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/app/entry/data/create", httpRequestParam.getPath());
        assertEquals(APP_ID, httpRequestParam.getData().get("app_id"));
        assertEquals(ENTRY_ID, httpRequestParam.getData().get("entry_id"));
        assertEquals(data, httpRequestParam.getData().get("data"));
        assertEquals(false, httpRequestParam.getData().get("is_start_trigger"));
        assertEquals(false, httpRequestParam.getData().get("is_start_workflow"));
    }

    @Test
    @DisplayName("test singleDataQuery")
    public void singleDataQuery() throws Exception {
        FormDataQueryParam queryParam = new FormDataQueryParam(APP_ID, ENTRY_ID);
        queryParam.setData_id(dataId);

        FormDataApiClient spyClient = spy(formDataApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.singleDataQuery(queryParam, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/app/entry/data/get", httpRequestParam.getPath());
        assertEquals(APP_ID, httpRequestParam.getData().get("app_id"));
        assertEquals(ENTRY_ID, httpRequestParam.getData().get("entry_id"));
        assertEquals(dataId, httpRequestParam.getData().get("data_id"));
    }
}
