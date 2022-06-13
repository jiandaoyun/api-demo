package api.arch;

import model.role.RoleGroupListQueryParam;

import java.util.Map;

public class RoleGroupDemoTest {
    public static void main(String[] args) throws Exception {
        RoleGroupDemo roleGroupDemo = new RoleGroupDemo();
        // 列出角色组
        roleGroupList(roleGroupDemo);
        // 创建角色组
        roleGroupCreate(roleGroupDemo);
        // 更新角色组
        roleGroupUpdate(roleGroupDemo);
        // 删除角色组
        roleGroupDelete(roleGroupDemo);
    }

    private static void roleGroupDelete(RoleGroupDemo roleGroupDemo) throws Exception {
        Map<String, Object> result = roleGroupDemo.roleGroupDelete( 2328);
        System.out.println("roleGroupDelete result\n" + result);
    }

    private static void roleGroupUpdate(RoleGroupDemo roleGroupDemo) throws Exception {
        Map<String, Object> result = roleGroupDemo.roleGroupUpdate("Java-name2", 2328);
        System.out.println("roleGroupUpdate result\n" + result);
    }

    private static void roleGroupCreate(RoleGroupDemo roleGroupDemo) throws Exception {
        Map<String, Object> result = roleGroupDemo.roleGroupCreate("Java-name1");
        System.out.println("roleGroupCreate result\n" + result);
    }

    private static void roleGroupList(RoleGroupDemo roleGroupDemo) throws Exception {
        RoleGroupListQueryParam queryParam = new RoleGroupListQueryParam();
        queryParam.setSkip(0);
        queryParam.setLimit(10);
        queryParam.setHas_internal(true);
        queryParam.setHas_sync(true);
        Map<String, Object> result = roleGroupDemo.roleGroupList(queryParam);
        System.out.println("roleGroupList result\n" + result);
    }
}
