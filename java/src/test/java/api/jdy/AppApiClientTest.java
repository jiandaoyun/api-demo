package api.jdy;

import constants.HttpConstant;
import model.base.PageBaseParam;
import model.http.HttpRequestParam;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static constants.HttpConstant.API_KEY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

/**
 * 应用相关接口测试
 */
public class AppApiClientTest {

    private static final AppApiClient appApiClient = new AppApiClient(API_KEY, HttpConstant.HOST);

    @Test
    @DisplayName("test appList")
    public void appList() throws Exception {
        PageBaseParam queryParam = new PageBaseParam();
        queryParam.setSkip(0);
        queryParam.setLimit(10);

        AppApiClient spyClient = spy(appApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.appList(queryParam, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/app/list", httpRequestParam.getPath());
        assertEquals(0, httpRequestParam.getData().get("skip"));
        assertEquals(10, httpRequestParam.getData().get("limit"));
    }
}
