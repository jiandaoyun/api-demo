package api.arch;

import constants.HttpConstant;
import model.role.RoleListQueryParam;
import model.role.RoleMemberQueryParam;
import model.role.RoleUpdateParam;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 角色相关接口测试
 */
public class RoleApiClientTest {

    private static final RoleApiClient roleApiClient = new RoleApiClient(HttpConstant.API_KEY, HttpConstant.HOST);

    private static final int GROUP_NO = 120;

    private static final String ROLE_NAME = "role_name";

    private static Integer roleNo = null;

    private static final List<String> userNameList = Collections.singletonList("R-gDIIDws8");

    public static void main(String[] args) throws Exception {
        // 创建角色
        roleCreate();
        // 列出角色
        roleList();
        // 更新角色
        roleUpdate();
        // 批量给已有的成员设置角色
        roleAddMembers();
        // 列出角色下的所有成员
        roleMemberList();
        // 为自建角色批量移除成员
        roleRemoveMembers();
        // 删除角色
        roleDelete();
    }

    private static void roleRemoveMembers() throws Exception {
        Map<String, Object> result = roleApiClient.roleRemoveMembers(roleNo, userNameList, null);
        System.out.println("roleRemoveMembers result\n" + result);
    }

    private static void roleAddMembers() throws Exception {
        Map<String, Object> result =
                roleApiClient.roleAddMembers(roleNo, userNameList, null);
        System.out.println("roleAddMembers result\n" + result);
    }

    private static void roleMemberList() throws Exception {
        RoleMemberQueryParam queryParam = new RoleMemberQueryParam();
        queryParam.setRole_no(roleNo);
        queryParam.setSkip(0);
        queryParam.setLimit(100);
        Map<String, Object> result = roleApiClient.roleMemberList(queryParam, null);
        System.out.println("roleMemberList result\n" + result);
    }

    private static void roleDelete() throws Exception {
        Map<String, Object> result = roleApiClient.roleDelete(roleNo, null);
        System.out.println("roleDelete result\n" + result);
    }

    private static void roleUpdate() throws Exception {
        RoleUpdateParam updateParam = new RoleUpdateParam();
        updateParam.setRole_no(roleNo);
        updateParam.setGroup_no(GROUP_NO);
        updateParam.setName(ROLE_NAME + "_update");
        Map<String, Object> result = roleApiClient.roleUpdate(updateParam, null);
        System.out.println("roleUpdate result\n" + result);
    }

    private static void roleCreate() throws Exception {
        Map<String, Object> result = roleApiClient.roleCreate(ROLE_NAME, GROUP_NO, null);
        System.out.println("roleCreate result\n" + result);
        if (result.get("role") != null) {
            Map<String, Object> role = (Map<String, Object>) result.get("role");
            roleNo = Integer.parseInt(role.get("role_no").toString());
        }
    }

    private static void roleList() throws Exception {
        RoleListQueryParam queryParam = new RoleListQueryParam();
        queryParam.setSkip(0);
        queryParam.setLimit(10);
        queryParam.setHas_internal(true);
        queryParam.setHas_sync(true);
        Map<String, Object> result = roleApiClient.roleList(queryParam, null);
        System.out.println("roleList result\n" + result);
    }
}
