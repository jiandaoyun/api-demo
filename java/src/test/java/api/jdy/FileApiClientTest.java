package api.jdy;

import constants.HttpConstant;
import model.file.UploadTokenParam;

import java.io.File;
import java.util.List;
import java.util.Map;

import static constants.HttpConstant.APP_ID;
import static constants.HttpConstant.ENTRY_ID;

public class FileApiClientTest {
    private static FileApiClient fileApiClient = new FileApiClient(HttpConstant.API_KEY, HttpConstant.HOST);

    public static void main(String[] args) throws Exception {
        // 获取文件上传凭证和上传地址接口
        Map<String, Object> uploadTokenResult = uploadToken();
        uploadFile(uploadTokenResult);
    }

    private static Map<String, Object> uploadToken() throws Exception {
        UploadTokenParam uploadTokenParam = new UploadTokenParam();
        uploadTokenParam.setEntryId(ENTRY_ID);
        uploadTokenParam.setAppId(APP_ID);
        uploadTokenParam.setTransactionId("87cd7d71-c6df-4281-9927-469094395678");
        Map<String, Object> result = fileApiClient.uploadToken(uploadTokenParam, null);
        System.out.println("uploadToken result \n" + result);
        return result;
    }

    private static void uploadFile(Map<String, Object> uploadTokenResult) throws Exception {
        List<Map<String, Object>> uploadTokenList =
                (List<Map<String, Object>>) uploadTokenResult.get("token_and_url_list");
        String url = uploadTokenList.get(0).get("url").toString();
        String token = uploadTokenList.get(0).get("token").toString();
        Map<String, Object> result = fileApiClient.uploadFile(url, token, new File("C:\\Users\\xzh19\\Pictures\\test1.PNG"));
        System.out.println("uploadFile result \n" + result);
    }
}
