package api.arch;

import model.user.UserCreateParam;
import model.user.UserUpdateParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 用户 接口 Demo 测试
 */
public class MemberDemoTest {
    public static void main(String[] args) throws Exception {
        MemberDemo memberDemo = new MemberDemo();
        // 用户创建
        userCreate(memberDemo);
        // 部门用户列表
        deptMemberList(memberDemo);
        // 根据userName查用户信息
        userInfo(memberDemo);
        // 用户更新
        userUpdate(memberDemo);
        // 删除用户
        userDelete(memberDemo);
        // 批量删除用户
        userBatchDelete(memberDemo);
        // 批量创建成员
        userImport(memberDemo);
    }

    private static void userImport(MemberDemo memberDemo) throws Exception {
        // 批量的话 三个参数必传
        List<UserCreateParam> paramList = new ArrayList<>();
        UserCreateParam createParam = new UserCreateParam("importName1","importUserName1");
        createParam.setDepartments(Arrays.asList(97,98));
        paramList.add(createParam);
        createParam = new UserCreateParam("importName2","importUserName2");
        createParam.setDepartments(Arrays.asList(101,102));
        paramList.add(createParam);

        Map<String, Object> result = memberDemo.userImport(paramList);
        System.out.println("departmentImport result \n" + result);
    }

    private static void userBatchDelete(MemberDemo memberDemo) throws Exception {
        Map<String, Object> result = memberDemo.userBatchDelete(Arrays.asList("userName3", "userName4"));
        System.out.println("userBatchDelete result \n" + result);
    }

    private static void userDelete(MemberDemo memberDemo) throws Exception {
        Map<String, Object> result = memberDemo.userDelete("userName");
        System.out.println("userDelete result \n" + result);
    }

    private static void userUpdate(MemberDemo memberDemo) throws Exception {
        UserUpdateParam param = new UserUpdateParam("name_update", "userName");
        param.setDepartmentList(Arrays.asList(97, 98));
        Map<String, Object> result = memberDemo.userUpdate(param);
        System.out.println("userUpdate result \n" + result);
    }


    private static void userCreate(MemberDemo memberDemo) throws Exception {
        UserCreateParam param = new UserCreateParam("name21", "userName21");
        param.setDepartments(Arrays.asList(97, 98));
        Map<String, Object> result = memberDemo.userCreate(param);
        System.out.println("userCreate result \n" + result);
    }

    private static void deptMemberList(MemberDemo memberDemo) throws Exception {
        Map<String, Object> result = memberDemo.deptMemberList(1, true);
        System.out.println("deptMemberList result \n" + result);
    }


    private static void userInfo(MemberDemo memberDemo) throws Exception {
        Map<String, Object> result = memberDemo.userInfo("userName");
        System.out.println("userInfo result \n" + result);
    }

}
