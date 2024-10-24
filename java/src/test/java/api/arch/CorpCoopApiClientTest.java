package api.arch;

import constants.HttpConstant;
import model.http.HttpRequestParam;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

/**
 * 企业互联相关接口测试
 */
public class CorpCoopApiClientTest {

    private static final CorpCoopApiClient corpCoopApiClient = new CorpCoopApiClient(HttpConstant.API_KEY, HttpConstant.HOST);

    @Test
    @DisplayName("test corpCoopDepartList")
    public void corpCoopDepartList() throws Exception {
        CorpCoopApiClient spyClient = spy(corpCoopApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.corpCoopDepartList(6, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/guest/department/list", httpRequestParam.getPath());
        assertEquals(6, httpRequestParam.getData().get("dept_no"));
    }

    @Test
    @DisplayName("test corpCoopMemberList")
    public void corpCoopMemberList() throws Exception {
        CorpCoopApiClient spyClient = spy(corpCoopApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.corpCoopMemberList(6, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/guest/user/list", httpRequestParam.getPath());
        assertEquals(6, httpRequestParam.getData().get("dept_no"));
    }

    @Test
    @DisplayName("test corpCoopUserInfo")
    public void corpCoopUserInfo() throws Exception {
        String userName = "R-60e2767055c8760006ac79bc-jdy-y4r83c4jpqzg";

        CorpCoopApiClient spyClient = spy(corpCoopApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.corpCoopUserInfo(userName, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/guest/user/get", httpRequestParam.getPath());
        assertEquals(userName, httpRequestParam.getData().get("username"));
    }
}
