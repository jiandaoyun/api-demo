package api.arch;

import constants.HttpConstant;
import model.role.RoleGroupListQueryParam;

import java.util.Map;

public class RoleGroupApiClientTest {

    private static RoleGroupApiClient roleGroupApiClient = new RoleGroupApiClient(HttpConstant.API_KEY, HttpConstant.HOST);

    private static final String GROUP_NAME = "group_name";

    private static Integer groupNo = null;

    public static void main(String[] args) throws Exception {
        // 创建角色组
        roleGroupCreate();
        // 列出角色组
        roleGroupList();
        // 更新角色组
        roleGroupUpdate();
        // 删除角色组
        roleGroupDelete();
    }

    private static void roleGroupDelete() throws Exception {
        Map<String, Object> result = roleGroupApiClient.roleGroupDelete(groupNo, null);
        System.out.println("roleGroupDelete result\n" + result);
    }

    private static void roleGroupUpdate() throws Exception {
        Map<String, Object> result = roleGroupApiClient.roleGroupUpdate(GROUP_NAME + "_update", groupNo, null);
        System.out.println("roleGroupUpdate result\n" + result);
    }

    private static void roleGroupCreate() throws Exception {
        Map<String, Object> result = roleGroupApiClient.roleGroupCreate(GROUP_NAME, null);
        System.out.println("roleGroupCreate result\n" + result);
        if (result.get("role_group") != null) {
            Map<String, Object> roleGroup = (Map<String, Object>) result.get("role_group");
            groupNo = Integer.parseInt(roleGroup.get("group_no").toString());
        }
    }

    private static void roleGroupList() throws Exception {
        RoleGroupListQueryParam queryParam = new RoleGroupListQueryParam();
        queryParam.setSkip(0);
        queryParam.setLimit(10);
        queryParam.setHas_internal(true);
        queryParam.setHas_sync(true);
        Map<String, Object> result = roleGroupApiClient.roleGroupList(queryParam, null);
        System.out.println("roleGroupList result\n" + result);
    }
}
