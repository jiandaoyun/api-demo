package api.arch;

import constants.HttpConstant;
import model.dept.DeptCreateParam;
import model.http.HttpRequestParam;
import org.apache.commons.lang3.StringUtils;
import util.HttpUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.HttpConstant.DEPT_BASE_URL;

/**
 * 部门相关的 请求 Demo
 */
public class DeptDemo {


    /**
     * 获取部门编号对应部门列表 （递归）
     *
     * @param deptNo 部门编号
     * @throws Exception
     */
    public Map<String, Object> deptList(Integer deptNo, Boolean hasChild) throws Exception {
        if (deptNo == null) {
            throw new RuntimeException("param lack!");
        }
        String url = DEPT_BASE_URL + deptNo + "/department_list";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("has_child", hasChild);
        param.setData(data);
        return HttpUtil.sendPostRequest(param);
    }

    /**
     * 创建部门
     *
     * @param param 部门名称
     * @throws Exception
     */
    public Map<String, Object> deptCreate(DeptCreateParam param) throws Exception {
        if (param == null || StringUtils.isBlank(param.getName())) {
            throw new RuntimeException("param lack!");
        }
        String url = DEPT_BASE_URL + "create";
        HttpRequestParam httpRequestParam = new HttpRequestParam();
        httpRequestParam.setApiKey(HttpConstant.API_KEY);
        httpRequestParam.setUrl(url);
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("name", param.getName());
        data.put("dept_no", param.getDept_no());
        data.put("parent_no", param.getParent_no());
        httpRequestParam.setData(data);
        return HttpUtil.sendPostRequest(httpRequestParam);
    }


    /**
     * 根据部门编号 更新部门名称
     *
     * @param deptNo
     * @param name
     * @throws Exception
     */
    public Map<String, Object> deptUpdate(Integer deptNo, String name) throws Exception {
        if (deptNo == null || StringUtils.isBlank(name)) {
            throw new RuntimeException("param lack!");
        }
        String url = DEPT_BASE_URL + deptNo + "/update";
        HttpRequestParam httpRequestParam = new HttpRequestParam();
        httpRequestParam.setApiKey(HttpConstant.API_KEY);
        httpRequestParam.setUrl(url);
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("name", name);
        httpRequestParam.setData(data);
        return HttpUtil.sendPostRequest(httpRequestParam);
    }

    /**
     * 根据部门编号 删除部门
     *
     * @param deptNo
     * @throws Exception
     */
    public Map<String, Object> deptDelete(Integer deptNo) throws Exception {
        if (deptNo == null) {
            throw new RuntimeException("param lack!");
        }
        String url = DEPT_BASE_URL + deptNo + "/delete";
        HttpRequestParam httpRequestParam = new HttpRequestParam();
        httpRequestParam.setApiKey(HttpConstant.API_KEY);
        httpRequestParam.setUrl(url);
        return HttpUtil.sendPostRequest(httpRequestParam);
    }

    /**
     * 根据集成模式通讯录的部门ID获取部门编号
     *
     * @param integrateId
     * @return
     * @throws Exception
     */
    public Map<String, Object> deptByIntegrateId(String integrateId) throws Exception {
        if (StringUtils.isBlank(integrateId)) {
            throw new RuntimeException("param lack!");
        }
        String url = DEPT_BASE_URL + "get_deptno_by_integrateid";
        HttpRequestParam httpRequestParam = new HttpRequestParam();
        httpRequestParam.setApiKey(HttpConstant.API_KEY);
        httpRequestParam.setUrl(url);
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("integrate_id", integrateId);
        httpRequestParam.setData(data);
        return HttpUtil.sendPostRequest(httpRequestParam);
    }

    /**
     * 批量创建部门
     *
     * @param paramList
     * @return
     * @throws Exception
     */
    public Map<String, Object> departmentImport(List<Object> paramList) throws Exception {
        if (paramList == null || paramList.size() == 0) {
            throw new RuntimeException("param lack!");
        }
        String url = DEPT_BASE_URL + "import";
        HttpRequestParam httpRequestParam = new HttpRequestParam();
        httpRequestParam.setApiKey(HttpConstant.API_KEY);
        httpRequestParam.setUrl(url);
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("departments", paramList);
        httpRequestParam.setData(data);
        return HttpUtil.sendPostRequest(httpRequestParam);
    }

}
