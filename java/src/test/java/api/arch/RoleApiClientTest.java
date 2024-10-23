package api.arch;

import constants.HttpConstant;
import model.http.HttpRequestParam;
import model.role.RoleListQueryParam;
import model.role.RoleMemberQueryParam;
import model.role.RoleUpdateParam;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

/**
 * 角色相关接口测试
 */
public class RoleApiClientTest {

    private static final RoleApiClient roleApiClient = new RoleApiClient(HttpConstant.API_KEY, HttpConstant.HOST);
    private static final int GROUP_NO = 120;
    private static final String ROLE_NAME = "role_name";
    private static final Integer roleNo = 6;
    private static final List<String> userNameList = Collections.singletonList("R-gDIIDws8");

    @Test
    @DisplayName("test roleRemoveMembers")
    public void roleRemoveMembers() throws Exception {
        RoleApiClient spyClient = spy(roleApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.roleRemoveMembers(roleNo, userNameList, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/role/remove_members", httpRequestParam.getPath());
        assertEquals(userNameList, httpRequestParam.getData().get("usernames"));
        assertEquals(roleNo, httpRequestParam.getData().get("role_no"));
    }

    @Test
    @DisplayName("test roleAddMembers")
    public void roleAddMembers() throws Exception {
        RoleApiClient spyClient = spy(roleApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.roleAddMembers(roleNo, userNameList, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/role/add_members", httpRequestParam.getPath());
        assertEquals(userNameList, httpRequestParam.getData().get("usernames"));
        assertEquals(roleNo, httpRequestParam.getData().get("role_no"));
    }

    @Test
    @DisplayName("test roleMemberList")
    public void roleMemberList() throws Exception {
        RoleMemberQueryParam queryParam = new RoleMemberQueryParam();
        queryParam.setRole_no(roleNo);
        queryParam.setSkip(0);
        queryParam.setLimit(100);

        RoleApiClient spyClient = spy(roleApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.roleMemberList(queryParam, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/role/user/list", httpRequestParam.getPath());
        assertEquals(0, httpRequestParam.getData().get("skip"));
        assertEquals(100, httpRequestParam.getData().get("limit"));
        assertEquals(roleNo, httpRequestParam.getData().get("role_no"));
    }

    @Test
    @DisplayName("test roleDelete")
    public void roleDelete() throws Exception {
        RoleApiClient spyClient = spy(roleApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.roleDelete(roleNo, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/role/delete", httpRequestParam.getPath());
        assertEquals(roleNo, httpRequestParam.getData().get("role_no"));
    }

    @Test
    @DisplayName("test roleUpdate")
    public void roleUpdate() throws Exception {
        RoleUpdateParam updateParam = new RoleUpdateParam();
        updateParam.setRole_no(roleNo);
        updateParam.setGroup_no(GROUP_NO);
        updateParam.setName(ROLE_NAME + "_update");

        RoleApiClient spyClient = spy(roleApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.roleUpdate(updateParam, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/role/update", httpRequestParam.getPath());
        assertEquals(roleNo, httpRequestParam.getData().get("role_no"));
        assertEquals(ROLE_NAME + "_update", httpRequestParam.getData().get("name"));
        assertEquals(GROUP_NO, httpRequestParam.getData().get("group_no"));
    }

    @Test
    @DisplayName("test roleCreate")
    public void roleCreate() throws Exception {
        RoleApiClient spyClient = spy(roleApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.roleCreate(ROLE_NAME, GROUP_NO, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/role/create", httpRequestParam.getPath());
        assertEquals(ROLE_NAME, httpRequestParam.getData().get("name"));
        assertEquals(GROUP_NO, httpRequestParam.getData().get("group_no"));
    }

    @Test
    @DisplayName("test roleList")
    public void roleList() throws Exception {
        RoleListQueryParam queryParam = new RoleListQueryParam();
        queryParam.setSkip(0);
        queryParam.setLimit(10);
        queryParam.setHas_internal(true);
        queryParam.setHas_sync(true);

        RoleApiClient spyClient = spy(roleApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.roleList(queryParam, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/role/list", httpRequestParam.getPath());
        assertEquals(0, httpRequestParam.getData().get("skip"));
        assertEquals(10, httpRequestParam.getData().get("limit"));
        assertEquals(true, httpRequestParam.getData().get("has_internal"));
        assertEquals(true, httpRequestParam.getData().get("has_sync"));
    }
}
