package api.arch;

import constants.HttpConstant;
import model.dept.DeptCreateParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 部门相关接口启动器
 */
public class DeptApiClientStarter {

    private static final Integer DEPT_NO = 10015;

    private static final Integer PARENT_NO = 1;

    private static final String DEPT_NAME = "Java_v5_";

    private static final DeptApiClient deptApiClient = new DeptApiClient(HttpConstant.API_KEY, HttpConstant.HOST);

    public static void main(String[] args) throws Exception {
        // 创建部门
        deptCreate();
        // 根据deptNo查询部门信息
        deptList();
        // 更新部门
        deptUpdate();
        // 删除部门
        deptDelete();
        // 批量导入部门
        departmentImport();
        // 部门用户列表
        deptMemberList();
        // 根据集成模式通讯录的部门ID获取部门编号
        deptByIntegrateId();
    }

    private static void departmentImport() throws Exception {
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
        Map<String, Object> result = deptApiClient.departmentImport(paramList, null);
        System.out.println("departmentImport result \n" + result);
    }

    private static void deptByIntegrateId() throws Exception {
        Map<String, Object> result = deptApiClient.deptByIntegrateId("58335612", null);
        System.out.println("deptByIntegrateId result \n" + result);
    }

    private static void deptDelete() throws Exception {
        Map<String, Object> result = deptApiClient.deptDelete(DEPT_NO, null);
        System.out.println("testDeptDelete result \n" + result);
    }

    private static void deptUpdate() throws Exception {
        Map<String, Object> result = deptApiClient.deptUpdate(DEPT_NO, DEPT_NAME + DEPT_NO + "_update", null);
        System.out.println("testDeptUpdate result \n" + result);
    }

    private static void deptList() throws Exception {
        Map<String, Object> result = deptApiClient.deptList(PARENT_NO, false, null);
        System.out.println("testDeptList result \n" + result);
    }

    private static void deptCreate() throws Exception {
        DeptCreateParam param = new DeptCreateParam(DEPT_NAME + DEPT_NO);
        param.setDept_no(DEPT_NO);
        param.setParent_no(PARENT_NO);
        Map<String, Object> result = deptApiClient.deptCreate(param, null);
        System.out.println("testDeptCreate result \n" + result);
    }

    private static void deptMemberList() throws Exception {
        Map<String, Object> result = deptApiClient.deptMemberList(DEPT_NO, true, null);
        System.out.println("deptMemberList result \n" + result);
    }
}
