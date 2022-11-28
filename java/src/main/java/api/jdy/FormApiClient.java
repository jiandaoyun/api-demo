package api.jdy;

import model.http.ApiClient;
import model.http.HttpRequestParam;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.HttpConstant.FORM_BASE_PATH;

/**
 * 表单相关接口
 */
public class FormApiClient extends ApiClient {
    private static final String DEFAULT_VERSION = "v5";
    private static final List<String> VALID_VERSION_LIST = Arrays.asList("v5");

    public FormApiClient(String apiKey, String host) {
        super(apiKey, host);
        this.setDefaultVersion(DEFAULT_VERSION);
        this.setValidVersionList(VALID_VERSION_LIST);
    }

    /**
     * 表单字段查询接口
     *
     * @param appId   - 应用 Id
     * @param entryId - 表单 Id
     */
    public Map<String, Object> formWidgets(String appId, String entryId, String version) throws Exception {
        if (StringUtils.isBlank(appId) || StringUtils.isBlank(entryId)) {
            throw new RuntimeException("param lack!");
        }
        String url = super.getValidVersion(version) + FORM_BASE_PATH  + "widget/list";
        Map<String, Object> data = new HashMap<>();
        data.put("app_id", appId);
        data.put("entry_id", entryId);
        HttpRequestParam param = new HttpRequestParam(url, data);
        return this.sendPostRequest(param);
    }
}
