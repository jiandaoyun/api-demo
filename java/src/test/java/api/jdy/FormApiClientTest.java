package api.jdy;

import constants.HttpConstant;
import model.form.FormQueryParam;
import model.http.HttpRequestParam;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static constants.HttpConstant.APP_ID;
import static constants.HttpConstant.ENTRY_ID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

/**
 * 表单相关接口测试
 */
public class FormApiClientTest {

    private static final FormApiClient formApiClient = new FormApiClient(HttpConstant.API_KEY, HttpConstant.HOST);

    @Test
    @DisplayName("test formWidgets")
    public void formWidgets() throws Exception {
        FormApiClient spyClient = spy(formApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.formWidgets(APP_ID, ENTRY_ID, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/app/entry/widget/list", httpRequestParam.getPath());
        assertEquals(APP_ID, httpRequestParam.getData().get("app_id"));
        assertEquals(ENTRY_ID, httpRequestParam.getData().get("entry_id"));
    }

    @Test
    @DisplayName("test entryList")
    public void entryList() throws Exception {
        FormQueryParam queryParam = new FormQueryParam();
        queryParam.setSkip(0);
        queryParam.setLimit(0);
        queryParam.setApp_id(APP_ID);

        FormApiClient spyClient = spy(formApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.entryList(queryParam, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/app/entry/list", httpRequestParam.getPath());
        assertEquals(APP_ID, httpRequestParam.getData().get("app_id"));
        assertEquals(0, httpRequestParam.getData().get("skip"));
        assertEquals(0, httpRequestParam.getData().get("limit"));
    }
}
