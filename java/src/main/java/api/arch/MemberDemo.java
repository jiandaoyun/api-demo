package api.arch;

import constants.HttpConstant;
import model.dept.UserCreateParam;
import model.dept.UserUpdateParam;
import model.http.HttpRequestParam;
import org.apache.commons.lang3.StringUtils;
import util.HttpUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.HttpConstant.DEPT_BASE_URL;
import static constants.HttpConstant.MEMBER_BASE_URL;

public class MemberDemo {


    /**
     * 获取部门成员（递归）
     *
     * @param deptNo   部门编号
     * @param hasChild 是否查子部门
     * @throws Exception
     */
      void deptMemberList(Integer deptNo, Boolean hasChild) throws Exception {
        if (deptNo == null || hasChild == null) {
            throw new RuntimeException("param lack!");
        }
        String url = DEPT_BASE_URL + deptNo + "/member_list";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("has_child", hasChild);
        param.setData(data);
        Object result = HttpUtil.sendPostRequest(param);
        System.out.println("deptMemberList result:\n" + result.toString());
    }

    /**
     * 创建成员
     *
     * @param param
     * @throws Exception
     */
    public void userCreate(UserCreateParam param) throws Exception {
        if (param == null || StringUtils.isBlank(param.getName()) || StringUtils.isBlank(param.getUserName())) {
            throw new RuntimeException("param lack!");
        }
        String url = MEMBER_BASE_URL + "create";
        HttpRequestParam requestParam = new HttpRequestParam();
        requestParam.setApiKey(HttpConstant.API_KEY);
        requestParam.setUrl(url);
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("name", param.getName());
        data.put("username", param.getUserName());
        data.put("departments", param.getDepartmentList());
        requestParam.setData(data);
        Object result = HttpUtil.sendPostRequest(requestParam);
        System.out.println("userCreate result:\n" + result.toString());
    }

    /**
     * 根据成员名称 获取成员
     *
     * @param userName 成员名称
     * @throws Exception
     */
    public void userInfo(String userName) throws Exception {
        if (StringUtils.isBlank(userName)) {
            throw new RuntimeException("param lack!");
        }
        String url = MEMBER_BASE_URL + userName + "/user_retrieve";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        Object result = HttpUtil.sendPostRequest(param);
        System.out.println("userInfo result:\n" + result.toString());
    }

    /**
     * 更新成员
     *
     * @param param
     * @throws Exception
     */
    public void userUpdate(UserUpdateParam param) throws Exception {
        if (param == null || StringUtils.isBlank(param.getName()) || StringUtils.isBlank(param.getUserName())) {
            throw new RuntimeException("param lack!");
        }
        String url = MEMBER_BASE_URL + param.getUserName() + "/update";
        HttpRequestParam requestParam = new HttpRequestParam();
        requestParam.setApiKey(HttpConstant.API_KEY);
        requestParam.setUrl(url);
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("name", param.getName());
        data.put("departments", param.getDepartmentList());
        requestParam.setData(data);
        Object result = HttpUtil.sendPostRequest(requestParam);
        System.out.println("userUpdate result:\n" + result.toString());
    }

    /**
     * 成员删除
     *
     * @param userName
     * @throws Exception
     */
    public void userDelete(String userName) throws Exception {
        if (StringUtils.isBlank(userName)) {
            throw new RuntimeException("param lack!");
        }
        String url = MEMBER_BASE_URL + userName + "/delete";
        HttpRequestParam param = new HttpRequestParam();
        param.setApiKey(HttpConstant.API_KEY);
        param.setUrl(url);
        Object result = HttpUtil.sendPostRequest(param);
        System.out.println("userDelete result:\n" + result.toString());
    }


    /**
     * 批量删除成员
     *
     * @param userNameList
     * @throws Exception
     */
    public void userBatchDelete(List<String> userNameList) throws Exception {
        if (userNameList == null || userNameList.size() == 0) {
            throw new RuntimeException("param lack!");
        }
        String url = MEMBER_BASE_URL + "batch_delete";
        HttpRequestParam requestParam = new HttpRequestParam();
        requestParam.setApiKey(HttpConstant.API_KEY);
        requestParam.setUrl(url);
        // 请求参数
        Map<String, Object> data = new HashMap<>();
        data.put("usernames", userNameList);
        requestParam.setData(data);
        Object result = HttpUtil.sendPostRequest(requestParam);
        System.out.println("userBatchDelete result:\n" + result.toString());
    }

}
