package api.arch;

import constants.HttpConstant;
import model.user.UserCreateParam;
import model.user.UserUpdateParam;

import java.util.*;

/**
 * 成员相关接口测试
 */
public class MemberApiClientTest {
    private static final Integer DEPT_NO = 1;

    private static final String NAME = "name";

    private static final String USER_NAME = "user_name";

    private static final MemberApiClient memberApiClient = new MemberApiClient(HttpConstant.API_KEY, HttpConstant.HOST);

    public static void main(String[] args) throws Exception {
        // 用户创建
        userCreate();
        // 部门用户列表
        deptMemberList();
        // 根据userName查用户信息
        userInfo();
        // 用户更新
        userUpdate();
        // 删除用户
        userDelete();
        // 批量创建成员
        userImport();
        // 批量删除用户
        userBatchDelete();
    }

    private static void userImport() throws Exception {
        // 批量的话 三个参数必传
        List<UserCreateParam> paramList = new ArrayList<>();
        UserCreateParam createParam = new UserCreateParam(NAME + "1", USER_NAME + "1");
        createParam.setDepartments(Collections.singletonList(1));
        paramList.add(createParam);
        createParam = new UserCreateParam(NAME + "2", USER_NAME + "2");
        createParam.setDepartments(Collections.singletonList(1));
        paramList.add(createParam);

        Map<String, Object> result = memberApiClient.userImport(paramList, null);
        System.out.println("departmentImport result \n" + result);
    }

    private static void userBatchDelete() throws Exception {
        Map<String, Object> result =
                memberApiClient.userBatchDelete(Arrays.asList(USER_NAME + "1", USER_NAME + "2"), null);
        System.out.println("userBatchDelete result \n" + result);
    }

    private static void userDelete() throws Exception {
        Map<String, Object> result = memberApiClient.userDelete(USER_NAME, null);
        System.out.println("userDelete result \n" + result);
    }

    private static void userUpdate() throws Exception {
        UserUpdateParam param = new UserUpdateParam(NAME + "_update", USER_NAME);
        param.setDepartmentList(Collections.singletonList(1));
        Map<String, Object> result = memberApiClient.userUpdate(param, null);
        System.out.println("userUpdate result \n" + result);
    }


    private static void userCreate() throws Exception {
        UserCreateParam param = new UserCreateParam(NAME, USER_NAME);
        param.setDepartments(Collections.singletonList(DEPT_NO));
        Map<String, Object> result = memberApiClient.userCreate(param, null);
        System.out.println("userCreate result \n" + result);
    }

    private static void deptMemberList() throws Exception {
        Map<String, Object> result = memberApiClient.deptMemberList(DEPT_NO, true, null);
        System.out.println("deptMemberList result \n" + result);
    }


    private static void userInfo() throws Exception {
        Map<String, Object> result = memberApiClient.userInfo(USER_NAME, null);
        System.out.println("userInfo result \n" + result);
    }

}
