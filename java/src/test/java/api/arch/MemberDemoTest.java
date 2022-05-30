package api.arch;

import model.dept.UserCreateParam;
import model.dept.UserUpdateParam;

import java.util.Arrays;

public class MemberDemoTest {
    public static void main(String[] args) throws Exception {
        MemberDemo memberDemo = new MemberDemo();
        System.out.println("-------------------------------------");
//        userCreate(memberDemo);
        System.out.println("-------------------------------------");
        deptMemberList(memberDemo);
        System.out.println("-------------------------------------");
//        userInfo(memberDemo);
        System.out.println("-------------------------------------");
//        userUpdate(memberDemo);

//        System.out.println("-------------------------------------");
//        userDelete(memberDemo);
//        System.out.println("-------------------------------------");
//        userBatchDelete(memberDemo);
    }

    private static void userBatchDelete(MemberDemo memberDemo) throws Exception {
        memberDemo.userBatchDelete(Arrays.asList("userName3","userName4"));
    }

    private static void userDelete(MemberDemo memberDemo) throws Exception {
        memberDemo.userDelete("userName");
    }

    private static void userUpdate(MemberDemo memberDemo) throws Exception {
        UserUpdateParam param = new UserUpdateParam("name_update", "userName");
        param.setDepartmentList(Arrays.asList(97,98));
        memberDemo.userUpdate(param);
    }


    private static void userCreate(MemberDemo memberDemo) throws Exception {
        UserCreateParam param = new UserCreateParam("name2", "userName2");
//        param.setDepartmentList(Arrays.asList(97,98));
        memberDemo.userCreate(param);
    }

    private static void deptMemberList(MemberDemo memberDemo) throws Exception {
        memberDemo.deptMemberList(1, true);
    }


    private static void userInfo(MemberDemo memberDemo) throws Exception {
        memberDemo.userInfo("userName");
    }

}
