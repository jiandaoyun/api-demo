package api.arch;

import constants.HttpConstant;
import model.http.HttpRequestParam;
import model.user.UserCreateParam;
import model.user.UserUpdateParam;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

/**
 * 成员相关接口测试
 */
public class MemberApiClientTest {
    private static final Integer DEPT_NO = 1;
    private static final String NAME = "name";
    private static final String USER_NAME = "user_name";
    private static final MemberApiClient memberApiClient = new MemberApiClient(HttpConstant.API_KEY, HttpConstant.HOST);

    @Test
    @DisplayName("test userImport")
    public void userImport() throws Exception {
        // 批量的话 三个参数必传
        List<UserCreateParam> paramList = new ArrayList<>();
        UserCreateParam createParam1 = new UserCreateParam(NAME + "1", USER_NAME + "1");
        createParam1.setDepartments(Collections.singletonList(DEPT_NO));
        paramList.add(createParam1);
        UserCreateParam createParam2 = new UserCreateParam(NAME + "2", USER_NAME + "2");
        createParam2.setDepartments(Collections.singletonList(DEPT_NO));
        paramList.add(createParam2);

        MemberApiClient spyClient = spy(memberApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.userImport(paramList, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/user/import", httpRequestParam.getPath());
        assertEquals(Arrays.asList(createParam1, createParam2), httpRequestParam.getData().get("users"));
    }

    @Test
    @DisplayName("test userBatchDelete")
    public void userBatchDelete() throws Exception {
        List<String> userNameList = Arrays.asList(USER_NAME + "1", USER_NAME + "2");
        MemberApiClient spyClient = spy(memberApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.userBatchDelete(userNameList, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/user/batch_delete", httpRequestParam.getPath());
        assertEquals(userNameList, httpRequestParam.getData().get("usernames"));
    }

    @Test
    @DisplayName("test userDelete")
    public void userDelete() throws Exception {
        MemberApiClient spyClient = spy(memberApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.userDelete(USER_NAME, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/user/delete", httpRequestParam.getPath());
        assertEquals(USER_NAME, httpRequestParam.getData().get("username"));
    }

    @Test
    @DisplayName("test userUpdate")
    public void userUpdate() throws Exception {
        UserUpdateParam param = new UserUpdateParam(NAME + "_update", USER_NAME);
        param.setDepartmentList(Collections.singletonList(DEPT_NO));

        MemberApiClient spyClient = spy(memberApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.userUpdate(param, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/user/update", httpRequestParam.getPath());
        assertEquals(NAME + "_update", httpRequestParam.getData().get("name"));
        assertEquals(Collections.singletonList(DEPT_NO), httpRequestParam.getData().get("departments"));
        assertEquals(USER_NAME, httpRequestParam.getData().get("username"));
    }

    @Test
    @DisplayName("test userCreate")
    public void userCreate() throws Exception {
        UserCreateParam param = new UserCreateParam(NAME, USER_NAME);
        param.setDepartments(Collections.singletonList(DEPT_NO));

        MemberApiClient spyClient = spy(memberApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.userCreate(param, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/user/create", httpRequestParam.getPath());
        assertEquals(NAME, httpRequestParam.getData().get("name"));
        assertEquals(Collections.singletonList(DEPT_NO), httpRequestParam.getData().get("departments"));
        assertEquals(USER_NAME, httpRequestParam.getData().get("username"));
    }

    @Test
    @DisplayName("test userInfo")
    public void userInfo() throws Exception {
        MemberApiClient spyClient = spy(memberApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.userInfo(USER_NAME, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/user/get", httpRequestParam.getPath());
        assertEquals(USER_NAME, httpRequestParam.getData().get("username"));
    }
}
