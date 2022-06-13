package api.jdy;

import constants.HttpConstant;
import model.http.HttpRequestParam;
import org.apache.commons.lang3.StringUtils;
import util.HttpUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static constants.HttpConstant.APP_BASE_URL;

public class FileDemo {

    /**
     * 获取文件上传凭证和上传地址接口
     *
     * @param appId
     * @param entryId
     * @param transactionId
     * @return
     * @throws Exception
     */
    public Map<String, Object> uploadToken(String appId, String entryId, String transactionId) throws Exception {
        if (StringUtils.isBlank(appId) || StringUtils.isBlank(entryId) || StringUtils.isBlank(transactionId)) {
            throw new RuntimeException("param lack!");
        }
        String url = APP_BASE_URL + appId + "/entry/" + entryId + "/file/get_upload_token";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("transaction_id", transactionId);
        param.setData(data);
        Map<String, Object> result = HttpUtil.sendPostRequest(param);
        return result;
    }

    public Map<String, Object> uploadFile(String url, String token, File file) throws Exception {
        if (StringUtils.isBlank(url) || StringUtils.isBlank(token) || file == null) {
            throw new RuntimeException("param lack!");
        }
        return HttpUtil.httpPostFile(url, token, file);
    }

}
