package api.arch;

import model.http.ApiClient;
import model.http.HttpRequestParam;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.HttpConstant.CORP_COOP_BASE_PATH;

/**
 * 企业互联相关接口
 */
public class CorpCoopApiClient extends ApiClient {

    private static final String DEFAULT_VERSION = "v5";
    private static final List<String> VALID_VERSION_LIST = Collections.singletonList("v5");


    public CorpCoopApiClient(String apiKey, String host) {
        super(apiKey, host);
        this.setDefaultVersion(DEFAULT_VERSION);
        this.setValidVersionList(VALID_VERSION_LIST);
    }

    @Override
    public String generatePath(String version, String path) {
        return super.getValidVersion(version) + CORP_COOP_BASE_PATH + path;
    }

    /**
     * 列出我连接的企业
     *
     * @param deptNo - 部门编号 可为null
     * @return 我连接的企业
     */
    public Map<String, Object> corpCoopDepartList(Integer deptNo, String version) throws Exception {
        String path = this.generatePath(version, "department/list");
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("dept_no", deptNo);
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 列出我连接的企业对接人
     *
     * @param deptNo - 部门编号 可为null
     * @return 我连接的企业对接人
     */
    public Map<String, Object> corpCoopMemberList(Integer deptNo, String version) throws Exception {
        String path = this.generatePath(version,"user/list");
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("dept_no", deptNo);
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 列出我连接的企业对接人详细信息
     *
     * @param userName - 用户名
     */
    public Map<String, Object> corpCoopUserInfo(String userName, String version) throws Exception {
        if (StringUtils.isBlank(userName)) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version,"user/get");
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("username", userName);
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }
}
