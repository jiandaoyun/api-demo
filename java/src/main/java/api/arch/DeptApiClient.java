package api.arch;

import model.dept.DeptCreateParam;
import model.http.ApiClient;
import model.http.HttpRequestParam;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.HttpConstant.DEPT_BASE_PATH;

/**
 * 部门相关接口
 */
public class DeptApiClient extends ApiClient {
    private static final String DEFAULT_VERSION = "v5";
    private static final List<String> VALID_VERSION_LIST = Collections.singletonList("v5");

    public DeptApiClient(String apiKey, String host) {
        super(apiKey, host);
        this.setDefaultVersion(DEFAULT_VERSION);
        this.setValidVersionList(VALID_VERSION_LIST);
    }

    @Override
    public String generatePath(String version, String path) {
        return super.getValidVersion(version) + DEPT_BASE_PATH + path;
    }

    /**
     * 获取部门编号对应部门列表 （递归）
     *
     * @param deptNo - 部门编号
     * @return 部门信息
     */
    public Map<String, Object> deptList(Integer deptNo, Boolean hasChild, String version) throws Exception {
        if (deptNo == null) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "list");
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("has_child", hasChild);
        data.put("dept_no", deptNo);
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }

    /**
     * 创建部门
     *
     * @param param - 部门名称
     * @return 部门信息
     */
    public Map<String, Object> deptCreate(DeptCreateParam param, String version) throws Exception {
        if (param == null || !param.isValid()) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "create");
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("name", param.getName());
        data.put("dept_no", param.getDept_no());
        data.put("parent_no", param.getParent_no());
        HttpRequestParam httpRequestParam = new HttpRequestParam(path, data);
        return this.sendPostRequest(httpRequestParam);
    }


    /**
     * 根据部门编号 更新部门名称
     *
     * @param deptNo - 部门编号
     * @param name   - 名称
     * @return 更新后的部门信息
     */
    public Map<String, Object> deptUpdate(Integer deptNo, String name, String version) throws Exception {
        if (deptNo == null || StringUtils.isBlank(name)) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "update");
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("name", name);
        data.put("dept_no", deptNo);
        HttpRequestParam httpRequestParam = new HttpRequestParam(path, data);
        return this.sendPostRequest(httpRequestParam);
    }

    /**
     * 根据部门编号 删除部门
     *
     * @param deptNo - 部门编号
     * @return status
     */
    public Map<String, Object> deptDelete(Integer deptNo, String version) throws Exception {
        if (deptNo == null) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "delete");
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("dept_no", deptNo);
        HttpRequestParam httpRequestParam = new HttpRequestParam(path, data);
        return this.sendPostRequest(httpRequestParam);
    }

    /**
     * 根据集成模式通讯录的部门ID获取部门编号
     *
     * @param integrateId - 第三方平台的通讯录部门的ID
     * @return 部门编号
     */
    public Map<String, Object> deptByIntegrateId(String integrateId, String version) throws Exception {
        if (StringUtils.isBlank(integrateId)) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "dept_no/get");
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("integrate_id", integrateId);
        HttpRequestParam httpRequestParam = new HttpRequestParam(path, data);
        return this.sendPostRequest(httpRequestParam);
    }

    /**
     * 批量创建部门
     *
     * @param paramList - 部门参数列表
     * @return status
     */
    public Map<String, Object> departmentImport(List<DeptCreateParam> paramList, String version) throws Exception {
        if (CollectionUtils.isEmpty(paramList)) {
            throw new RuntimeException("param lack!");
        }
        String path = this.generatePath(version, "import");
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("departments", paramList);
        HttpRequestParam httpRequestParam = new HttpRequestParam(path, data);
        return this.sendPostRequest(httpRequestParam);
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
        String path = this.generatePath(version, "user/list");
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("has_child", hasChild);
        data.put("dept_no", deptNo);
        HttpRequestParam param = new HttpRequestParam(path, data);
        return this.sendPostRequest(param);
    }
}
