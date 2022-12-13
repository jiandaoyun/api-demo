package api.arch;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.http.ApiClient;
import model.http.HttpRequestParam;
import model.role.RoleGroupListQueryParam;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.HttpConstant.ROLE_GROUP_BASE_PATH;

/**
 * 角色组相关接口
 */
public class RoleGroupApiClient extends ApiClient {

    private static final String DEFAULT_VERSION = "v5";
    private static final List<String> VALID_VERSION_LIST = Collections.singletonList("v5");

    public RoleGroupApiClient(String apiKey, String host) {
        super(apiKey, host);
        this.setDefaultVersion(DEFAULT_VERSION);
        this.setValidVersionList(VALID_VERSION_LIST);
    }

    @Override
    public String generatePath(String version, String path) {
        return super.getValidVersion(version) + ROLE_GROUP_BASE_PATH + path;
    }

    /**
     * 列出角色组
     *
     * @param queryParam - 查询参数
     * @return 角色组信息
     */
    public Map<String, Object> roleGroupList(RoleGroupListQueryParam queryParam, String version) throws Exception {
        if (queryParam == null || !queryParam.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version,"list");
        // 请求参数 将 queryParam 里面的属性转换成map
        Map<String, Object> data =
                new ObjectMapper().convertValue(queryParam, new TypeReference<Map<String, Object>>() {
                });
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 创建角色组
     *
     * @param name - 角色组名称
     * @return 角色组信息
     */
    public Map<String, Object> roleGroupCreate(String name, String version) throws Exception {
        if (StringUtils.isBlank(name)) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version,"create");
        Map<String, Object> data = new HashMap<>();
        data.put("name", name);
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 更新角色组
     *
     * @param name        - 角色组名称
     * @param roleGroupNo - 角色组编号
     * @return 更新后的角色组信息
     */
    public Map<String, Object> roleGroupUpdate(String name, Integer roleGroupNo, String version) throws Exception {
        if (StringUtils.isBlank(name) || roleGroupNo == null) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version,"update");
        Map<String, Object> data = new HashMap<>();
        data.put("name", name);
        data.put("role_group_no", roleGroupNo);
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 删除角色组
     *
     * @param roleGroupNo - 角色组编号
     * @return status
     */
    public Map<String, Object> roleGroupDelete(Integer roleGroupNo, String version) throws Exception {
        if (roleGroupNo == null) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "delete");
        Map<String, Object> data = new HashMap<>();
        data.put("role_group_no", roleGroupNo);
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }
}
