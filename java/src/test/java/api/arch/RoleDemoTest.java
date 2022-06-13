package api.arch;

import model.role.RoleListQueryParam;

import java.util.Arrays;
import java.util.Map;

public class RoleDemoTest {

    public static void main(String[] args) throws Exception {
        RoleDemo roleDemo = new RoleDemo();
        // 列出角色
        roleList(roleDemo);
        // 创建角色
        roleCreate(roleDemo);
        // 更新角色
        roleUpdate(roleDemo);
        // 删除角色
        roleDelete(roleDemo);
        // 列出角色下的所有成员
        roleMemberList(roleDemo);
        // 批量给已有的成员设置角色
        roleAddMembers(roleDemo);
        // 为自建角色批量移除成员
        roleRmoveMembers(roleDemo);
    }

    private static void roleRmoveMembers(RoleDemo roleDemo) throws Exception {
        Map<String, Object> result = roleDemo.roleRmoveMembers(2304, Arrays.asList("importUserName2","userName2"));
        System.out.println("roleRmoveMembers result\n" + result);
    }

    private static void roleAddMembers(RoleDemo roleDemo) throws Exception {
        Map<String, Object> result = roleDemo.roleAddMembers(2304, Arrays.asList("importUserName2","userName2"));
        System.out.println("roleAddMembers result\n" + result);
    }

    private static void roleMemberList(RoleDemo roleDemo) throws Exception {
        Map<String, Object> result = roleDemo.roleMemberList(2304,0,100);
        System.out.println("roleMemberList result\n" + result);
    }

    private static void roleDelete(RoleDemo roleDemo) throws Exception {
        Map<String, Object> result = roleDemo.roleDelete(2310);
        System.out.println("roleDelete result\n" + result);
    }

    private static void roleUpdate(RoleDemo roleDemo) throws Exception {
        Map<String, Object> result = roleDemo.roleUpdate("JavaName2",2302,2326);
        System.out.println("roleUpdate result\n" + result);
    }

    private static void roleCreate(RoleDemo roleDemo) throws Exception {
        Map<String, Object> result = roleDemo.roleCreate("JavaName1",2300);
        System.out.println("roleCreate result\n" + result);
    }

    private static void roleList(RoleDemo roleDemo) throws Exception {
        RoleListQueryParam queryParam = new RoleListQueryParam();
        queryParam.setSkip(0);
        queryParam.setLimit(10);
        queryParam.setHas_internal(true);
        queryParam.setHas_sync(true);
        Map<String, Object> result = roleDemo.roleList(queryParam);
        System.out.println("roleList result\n" + result);
    }
}
