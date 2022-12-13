package api.arch;

import model.http.ApiClient;
import model.http.HttpRequestParam;
import model.user.UserCreateParam;
import model.user.UserUpdateParam;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.HttpConstant.MEMBER_BASE_PATH;

/**
 * 成员相关接口
 */
public class MemberApiClient extends ApiClient {
    private static final String DEFAULT_VERSION = "v5";
    private static final List<String> VALID_VERSION_LIST = Arrays.asList("v5");

    public MemberApiClient(String apiKey, String host) {
        super(apiKey, host);
        this.setDefaultVersion(DEFAULT_VERSION);
        this.setValidVersionList(VALID_VERSION_LIST);
    }

    @Override
    public String generatePath(String version, String path) {
        return super.getValidVersion(version) + MEMBER_BASE_PATH + path;
    }

    /**
     * 创建成员
     *
     * @param param - 成员信息
     * @return 成员信息
     */
    public Map<String, Object> userCreate(UserCreateParam param, String version) throws Exception {
        if (param == null || !param.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "create");
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("name", param.getName());
        data.put("username", param.getUsername());
        data.put("departments", param.getDepartments());
        HttpRequestParam requestParam = new HttpRequestParam(path, data);
        return this.sendPostRequest(requestParam);
    }

    /**
     * 根据成员名称 获取成员
     *
     * @param userName - 成员名称
     * @return 成员信息
     */
    public Map<String, Object> userInfo(String userName, String version) throws Exception {
        if (StringUtils.isBlank(userName)) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "get");
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("username", userName);
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 更新成员
     *
     * @param updateParam - 更新的成员信息
     * @return 更新后的成员信息
     */
    public Map<String, Object> userUpdate(UserUpdateParam updateParam, String version) throws Exception {
        if (updateParam == null || !updateParam.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "update");
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("name", updateParam.getName());
        data.put("username", updateParam.getUserName());
        data.put("departments", updateParam.getDepartmentList());
        HttpRequestParam requestParam = new HttpRequestParam(path, data);
        return this.sendPostRequest(requestParam);
    }

    /**
     * 成员删除
     *
     * @param userName - 成员名称
     * @return status
     */
    public Map<String, Object> userDelete(String userName, String version) throws Exception {
        if (StringUtils.isBlank(userName)) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "delete");
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("username", userName);
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }


    /**
     * 批量删除成员
     *
     * @param userNameList - 待删除的用户名称列表
     * @return status
     */
    public Map<String, Object> userBatchDelete(List<String> userNameList, String version) throws Exception {
        if (CollectionUtils.isEmpty(userNameList)) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "batch_delete");
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("usernames", userNameList);
        HttpRequestParam requestParam = new HttpRequestParam(path, data);
        return this.sendPostRequest(requestParam);
    }

    /**
     * 批量导入成员
     *
     * @param userNameList - 导入的成员列表
     * @return status
     */
    public Map<String, Object> userImport(List<UserCreateParam> userNameList, String version) throws Exception {
        if (CollectionUtils.isEmpty(userNameList)) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "import");
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("users", userNameList);
        HttpRequestParam requestParam = new HttpRequestParam(path, data);
        return this.sendPostRequest(requestParam);
    }
}
