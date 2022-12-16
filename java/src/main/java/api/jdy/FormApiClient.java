package api.jdy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.form.FormQueryParam;
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

    @Override
    public String generatePath(String version, String path) {
        return super.getValidVersion(version) + FORM_BASE_PATH + path;
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
        String path = this.generatePath(version, "widget/list");
        Map<String, Object> data = new HashMap<>();
        data.put("app_id", appId);
        data.put("entry_id", entryId);
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 表单查询接口 分页
     *
     * @param queryParam - 查询参数
     * @return 表单信息
     */
    public Map<String, Object> entryList(FormQueryParam queryParam, String version) throws Exception {
        if (queryParam == null || !queryParam.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "list");
        // 请求参数 将 queryParam 里面的属性转换成map
        Map<String, Object> data =
                new ObjectMapper().convertValue(queryParam, new TypeReference<Map<String, Object>>() {
                });
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }
}
