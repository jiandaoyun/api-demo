package api.jdy;

import constants.HttpConstant;
import model.file.UploadTokenParam;
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
 * 文件相关接口测试
 */
public class FileApiClientTest {
    private static final FileApiClient fileApiClient = new FileApiClient(HttpConstant.API_KEY, HttpConstant.HOST);

    @Test
    @DisplayName("test uploadToken")
    public void uploadToken() throws Exception {
        UploadTokenParam uploadTokenParam = new UploadTokenParam();
        uploadTokenParam.setEntryId(ENTRY_ID);
        uploadTokenParam.setAppId(APP_ID);
        uploadTokenParam.setTransactionId("87cd7d71-c6df-4281-9927-469094395678");

        FileApiClient spyClient = spy(fileApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.uploadToken(uploadTokenParam, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/app/entry/file/get_upload_token", httpRequestParam.getPath());
        assertEquals(APP_ID, httpRequestParam.getData().get("app_id"));
        assertEquals(ENTRY_ID, httpRequestParam.getData().get("entry_id"));
        assertEquals("87cd7d71-c6df-4281-9927-469094395678", httpRequestParam.getData().get("transaction_id"));
    }
}
