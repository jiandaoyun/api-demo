package api.arch;

import constants.HttpConstant;
import model.http.HttpRequestParam;
import model.role.RoleGroupListQueryParam;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

/**
 * 角色组相关接口测试
 */
public class RoleGroupApiClientTest {

    private static final RoleGroupApiClient roleGroupApiClient = new RoleGroupApiClient(HttpConstant.API_KEY, HttpConstant.HOST);
    private static final String GROUP_NAME = "group_name";
    private static final Integer groupNo = 6;

    @Test
    @DisplayName("test roleGroupDelete")
    public void roleGroupDelete() throws Exception {
        RoleGroupApiClient spyClient = spy(roleGroupApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.roleGroupDelete(groupNo, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/role_group/delete", httpRequestParam.getPath());
        assertEquals(groupNo, httpRequestParam.getData().get("role_group_no"));
    }

    @Test
    @DisplayName("test roleGroupUpdate")
    public void roleGroupUpdate() throws Exception {
        String name = GROUP_NAME + "_update";
        RoleGroupApiClient spyClient = spy(roleGroupApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.roleGroupUpdate(name, groupNo, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/role_group/update", httpRequestParam.getPath());
        assertEquals(groupNo, httpRequestParam.getData().get("role_group_no"));
        assertEquals(name, httpRequestParam.getData().get("name"));
    }

    @Test
    @DisplayName("test roleGroupCreate")
    public void roleGroupCreate() throws Exception {
        RoleGroupApiClient spyClient = spy(roleGroupApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.roleGroupCreate(GROUP_NAME, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/role_group/create", httpRequestParam.getPath());
        assertEquals(GROUP_NAME, httpRequestParam.getData().get("name"));
    }

    @Test
    @DisplayName("test roleGroupList")
    public void roleGroupList() throws Exception {
        RoleGroupListQueryParam queryParam = new RoleGroupListQueryParam();
        queryParam.setSkip(0);
        queryParam.setLimit(10);
        queryParam.setHas_internal(true);
        queryParam.setHas_sync(true);

        RoleGroupApiClient spyClient = spy(roleGroupApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.roleGroupList(queryParam, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/role_group/list", httpRequestParam.getPath());
        assertEquals(0, httpRequestParam.getData().get("skip"));
        assertEquals(10, httpRequestParam.getData().get("limit"));
        assertEquals(true, httpRequestParam.getData().get("has_internal"));
        assertEquals(true, httpRequestParam.getData().get("has_sync"));
    }
}
