package api.arch;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.http.ApiClient;
import model.http.HttpRequestParam;
import model.role.RoleListQueryParam;
import model.role.RoleMemberQueryParam;
import model.role.RoleUpdateParam;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.HttpConstant.ROLE_BASE_PATH;

/**
 * 角色相关接口
 */
public class RoleApiClient extends ApiClient {
    private static final String DEFAULT_VERSION = "v5";
    private static final List<String> VALID_VERSION_LIST = Collections.singletonList("v5");

    public RoleApiClient(String apiKey, String host) {
        super(apiKey, host);
        this.setDefaultVersion(DEFAULT_VERSION);
        this.setValidVersionList(VALID_VERSION_LIST);
    }

    /**
     * 列出角色
     *
     * @param queryParam - 查询参数
     * @return 角色信息
     */
    public Map<String, Object> roleList(RoleListQueryParam queryParam, String version) throws Exception {
        if (queryParam == null || !queryParam.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = super.getValidVersion(version) + ROLE_BASE_PATH + "list";
        // 请求参数 将 queryParam 里面的属性转换成map
        Map<String, Object> data =
                new ObjectMapper().convertValue(queryParam, new TypeReference<Map<String, Object>>() {
                });
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 创建角色
     *
     * @param name    - 角色名称
     * @param groupNo - 角色组编号
     * @return 角色信息
     */
    public Map<String, Object> roleCreate(String name, Integer groupNo, String version) throws Exception {
        if (StringUtils.isBlank(name) || groupNo == null) {
            throw new RuntimeException("param lack!");
        }
        String path = super.getValidVersion(version) + ROLE_BASE_PATH + "create";
        Map<String, Object> data = new HashMap<>();
        data.put("group_no", groupNo);
        data.put("name", name);
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 更新角色
     *
     * @param updateParam - 角色更新信息
     * @return 更新后的角色信息
     */
    public Map<String, Object> roleUpdate(RoleUpdateParam updateParam, String version) throws Exception {
        if (updateParam == null || !updateParam.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = super.getValidVersion(version) + ROLE_BASE_PATH + "update";
        // 请求参数 将 queryParam 里面的属性转换成map
        Map<String, Object> data =
                new ObjectMapper().convertValue(updateParam, new TypeReference<Map<String, Object>>() {
                });
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 删除角色
     *
     * @param roleNo - 角色编号
     * @return 无
     */
    public Map<String, Object> roleDelete(Integer roleNo, String version) throws Exception {
        if (roleNo == null) {
            throw new RuntimeException("param lack!");
        }
        String url = super.getValidVersion(version) + ROLE_BASE_PATH + "delete";
        Map<String, Object> data = new HashMap<>();
        data.put("role_no", roleNo);
        HttpRequestParam param = new HttpRequestParam(url, data);
        return this.sendPostRequest(param);
    }

    /**
     * 列出角色下的所有成员
     *
     * @param queryParam - 产线参数
     * @return 成员信息
     */
    public Map<String, Object> roleMemberList(RoleMemberQueryParam queryParam, String version) throws Exception {
        if (queryParam == null || !queryParam.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = super.getValidVersion(version) + ROLE_BASE_PATH + "user/list";
        // 请求参数 将 queryParam 里面的属性转换成map
        Map<String, Object> data =
                new ObjectMapper().convertValue(queryParam, new TypeReference<Map<String, Object>>() {
                });
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 批量给已有的成员设置自建角色
     *
     * @param roleNo       - 角色编号
     * @param userNameList - 成员名称列表
     * @return success
     */
    public Map<String, Object> roleAddMembers(Integer roleNo, List<String> userNameList, String version)
            throws Exception {
        if (roleNo == null || CollectionUtils.isEmpty(userNameList)) {
            throw new RuntimeException("param lack!");
        }
        String path = super.getValidVersion(version) + ROLE_BASE_PATH + "add_members";
        Map<String, Object> data = new HashMap<>();
        data.put("role_no", roleNo);
        data.put("usernames", userNameList);
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 为自建角色批量移除成员
     *
     * @param roleNo       - 角色编号
     * @param userNameList - 用户名称列表
     * @return status
     */
    public Map<String, Object> roleRemoveMembers(Integer roleNo, List<String> userNameList, String version)
            throws Exception {
        if (roleNo == null || CollectionUtils.isEmpty(userNameList)) {
            throw new RuntimeException("param lack!");
        }
        String path = super.getValidVersion(version) + ROLE_BASE_PATH + "remove_members";
        Map<String, Object> data = new HashMap<>();
        data.put("role_no", roleNo);
        data.put("usernames", userNameList);
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }
}
