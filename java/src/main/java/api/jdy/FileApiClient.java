package api.jdy;

import model.file.UploadTokenParam;
import model.http.ApiClient;
import model.http.HttpRequestParam;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.HttpConstant.APP_BASE_PATH;

/**
 * 文件相关接口
 */
public class FileApiClient extends ApiClient {

    private static final String DEFAULT_VERSION = "v1";
    private static final List<String> VALID_VERSION_LIST = Collections.singletonList("v1");

    public FileApiClient(String apiKey, String host) {
        super(apiKey, host);
        this.setDefaultVersion(DEFAULT_VERSION);
        this.setValidVersionList(VALID_VERSION_LIST);
    }

    /**
     * 获取文件上传凭证和上传地址接口
     *
     * @param uploadTokenParam - 文件对应的信息
     * @return token和url信息
     */
    public Map<String, Object> uploadToken(UploadTokenParam uploadTokenParam, String version) throws Exception {
        if (uploadTokenParam == null || !uploadTokenParam.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = super.getValidVersion(version) + APP_BASE_PATH + uploadTokenParam.getAppId()
                + "/entry/" + uploadTokenParam.getEntryId() + "/file/get_upload_token";
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("transaction_id", uploadTokenParam.getTransactionId());
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    public Map<String, Object> uploadFile(String url, String token, File file) throws Exception {
        if (StringUtils.isBlank(url) || StringUtils.isBlank(token) || file == null) {
            throw new RuntimeException("param lack!");
        }
        return this.httpPostFile(url, token, file);
    }
}
