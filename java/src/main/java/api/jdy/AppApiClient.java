package api.jdy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.base.PageBaseParam;
import model.form.FormQueryParam;
import model.http.ApiClient;
import model.http.HttpRequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static constants.HttpConstant.APP_BASE_PATH;


/**
 * 应用相关接口
 */
public class AppApiClient extends ApiClient {

    private static final String DEFAULT_VERSION = "v1";
    private static final List<String> VALID_VERSION_LIST = Collections.singletonList("v1");

    public AppApiClient(String apiKey, String host) {
        super(apiKey, host);
        this.setDefaultVersion(DEFAULT_VERSION);
        this.setValidVersionList(VALID_VERSION_LIST);
    }

    /**
     * 应用分页列表
     *
     * @param queryParam - 查询参数
     * @return 应用信息
     */
    public Map<String, Object> appList(PageBaseParam queryParam, String version) throws Exception {
        if (queryParam == null || !queryParam.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = super.getValidVersion(version) + APP_BASE_PATH + "retrieve_all";
        // 请求参数 将 queryParam 里面的属性转换成map
        Map<String, Object> data =
                new ObjectMapper().convertValue(queryParam, new TypeReference<Map<String, Object>>() {
                });
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
        String path = super.getValidVersion(version) + APP_BASE_PATH + queryParam.getAppId() + "/entry_retrieve";
        // 请求参数 将 queryParam 里面的属性转换成map
        Map<String, Object> data =
                new ObjectMapper().convertValue(queryParam, new TypeReference<Map<String, Object>>() {
                });
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }
}
