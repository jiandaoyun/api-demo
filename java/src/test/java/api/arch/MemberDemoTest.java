package api.arch;

import model.dept.UserCreateParam;
import model.dept.UserUpdateParam;

import java.util.Arrays;
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
        UserCreateParam param = new UserCreateParam("name2", "userName2");
        param.setDepartmentList(Arrays.asList(97, 98));
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
