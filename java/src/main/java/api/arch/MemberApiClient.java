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

import static constants.HttpConstant.DEPT_BASE_PATH;
import static constants.HttpConstant.MEMBER_BASE_PATH;

/**
 * 成员相关接口
 */
public class MemberApiClient extends ApiClient {
    private static final String DEFAULT_VERSION = "v2";
    private static final List<String> VALID_VERSION_LIST = Arrays.asList("v2", "v1");

    public MemberApiClient(String apiKey, String host) {
        super(apiKey, host);
        this.setDefaultVersion(DEFAULT_VERSION);
        this.setValidVersionList(VALID_VERSION_LIST);
    }

    /**
     * 获取部门成员（递归）
     *
     * @param deptNo   - 部门编号
     * @param hasChild - 是否查子部门
     * @return 部门成员信息
     */
    public Map<String, Object> deptMemberList(Integer deptNo, Boolean hasChild, String version) throws Exception {
        if (deptNo == null || hasChild == null) {
            throw new RuntimeException("param lack!");
        }
        String path = super.getValidVersion(version) + DEPT_BASE_PATH + deptNo + "/member_list";
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("has_child", hasChild);
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
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
        String path = super.getValidVersion(version) + MEMBER_BASE_PATH + "create";
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
        String path = super.getValidVersion(version) + MEMBER_BASE_PATH + userName + "/user_retrieve";
        HttpRequestParam param = new HttpRequestParam(path, null);
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
        String path = super.getValidVersion(version) + MEMBER_BASE_PATH + updateParam.getUserName() + "/update";
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("name", updateParam.getName());
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
        String path = super.getValidVersion(version) + MEMBER_BASE_PATH + userName + "/delete";
        HttpRequestParam param = new HttpRequestParam(path, null);
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
        String path = super.getValidVersion(version) + MEMBER_BASE_PATH + "batch_delete";
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
        String path = super.getValidVersion(version) + MEMBER_BASE_PATH + "import";
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("users", userNameList);
        HttpRequestParam requestParam = new HttpRequestParam(path, data);
        return this.sendPostRequest(requestParam);
    }
}
