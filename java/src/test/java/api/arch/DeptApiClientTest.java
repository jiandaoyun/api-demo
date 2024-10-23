package api.arch;

import constants.HttpConstant;
import model.dept.DeptCreateParam;
import model.http.HttpRequestParam;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

/**
 * 部门相关接口测试
 */
public class DeptApiClientTest {
    private static final Integer DEPT_NO = 10015;
    private static final Integer PARENT_NO = 1;
    private static final String DEPT_NAME = "Java_v5_";
    private static final DeptApiClient deptApiClient = new DeptApiClient(HttpConstant.API_KEY, HttpConstant.HOST);


    @Test
    @DisplayName("test departmentImport")
    public void departmentImport() throws Exception {
        // name 和 dept_no 必传
        List<DeptCreateParam> paramList = new ArrayList<>();
        DeptCreateParam deptOne = new DeptCreateParam(DEPT_NAME + "one");
        deptOne.setDept_no(DEPT_NO + 100);
        deptOne.setParent_no(PARENT_NO);
        paramList.add(deptOne);
        DeptCreateParam deptTwo = new DeptCreateParam(DEPT_NAME + "two");
        deptTwo.setDept_no(DEPT_NO + 200);
        deptTwo.setParent_no(PARENT_NO);
        deptOne.setParent_no(PARENT_NO);
        paramList.add(deptTwo);

        DeptApiClient spyClient = spy(deptApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.departmentImport(paramList, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/department/import", httpRequestParam.getPath());
        assertEquals(Arrays.asList(deptOne, deptTwo), httpRequestParam.getData().get("departments"));
    }

    @Test
    @DisplayName("test deptByIntegrateId")
    public void deptByIntegrateId() throws Exception {
        DeptApiClient spyClient = spy(deptApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.deptByIntegrateId("58335612", null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/department/dept_no/get", httpRequestParam.getPath());
        assertEquals("58335612", httpRequestParam.getData().get("integrate_id"));
    }

    @Test
    @DisplayName("test deptDelete")
    public void deptDelete() throws Exception {
        DeptApiClient spyClient = spy(deptApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.deptDelete(DEPT_NO, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/department/delete", httpRequestParam.getPath());
        assertEquals(DEPT_NO, httpRequestParam.getData().get("dept_no"));
    }

    @Test
    @DisplayName("test deptUpdate")
    public void deptUpdate() throws Exception {
        DeptApiClient spyClient = spy(deptApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.deptUpdate(DEPT_NO, DEPT_NAME + DEPT_NO + "_update", null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/department/update", httpRequestParam.getPath());
        assertEquals(DEPT_NO, httpRequestParam.getData().get("dept_no"));
        assertEquals(DEPT_NAME + DEPT_NO + "_update", httpRequestParam.getData().get("name"));
    }

    @Test
    @DisplayName("test deptList")
    public void deptList() throws Exception {
        DeptApiClient spyClient = spy(deptApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.deptList(PARENT_NO, false, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/department/list", httpRequestParam.getPath());
        assertEquals(PARENT_NO, httpRequestParam.getData().get("dept_no"));
        assertEquals(false, httpRequestParam.getData().get("has_child"));
    }

    @Test
    @DisplayName("test deptCreate")
    public void deptCreate() throws Exception {
        DeptCreateParam param = new DeptCreateParam(DEPT_NAME + DEPT_NO);
        param.setDept_no(DEPT_NO);
        param.setParent_no(PARENT_NO);

        DeptApiClient spyClient = spy(deptApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.deptCreate(param, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/department/create", httpRequestParam.getPath());
        assertEquals(PARENT_NO, httpRequestParam.getData().get("parent_no"));
        assertEquals(DEPT_NO, httpRequestParam.getData().get("dept_no"));
        assertEquals(DEPT_NAME + DEPT_NO, httpRequestParam.getData().get("name"));
    }

    @Test
    @DisplayName("test deptMemberList")
    public void deptMemberList() throws Exception {
        DeptApiClient spyClient = spy(deptApiClient);
        ArgumentCaptor<HttpRequestParam> argumentCaptor = ArgumentCaptor.forClass(HttpRequestParam.class);
        doReturn(null).when(spyClient).sendPostRequest(argumentCaptor.capture());
        spyClient.deptMemberList(DEPT_NO, true, null);
        HttpRequestParam httpRequestParam = argumentCaptor.getValue();

        assertEquals("v5/corp/department/user/list", httpRequestParam.getPath());
        assertEquals(DEPT_NO, httpRequestParam.getData().get("dept_no"));
        assertEquals(true, httpRequestParam.getData().get("has_child"));
    }
}
