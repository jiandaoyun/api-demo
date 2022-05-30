package api.arch;

import model.dept.DeptCreateParam;

import java.util.Map;

/**
 * 部门 接口 Demo 测试
 */
public class DeptDemoTest {

    public static void main(String[] args) throws Exception {
        DeptDemo deptDemo = new DeptDemo();
        // 创建部门
        testDeptCreate(deptDemo);
        // 根据deptNo查询部门信息
        testDeptList(deptDemo);
        // 更新部门
        testDeptUpdate(deptDemo);
        // 删除部门
        testDeptDelete(deptDemo);
        // 根据集成模式通讯录的部门ID获取部门编号
        deptByIntegrateId(deptDemo);
    }

    private static void deptByIntegrateId(DeptDemo deptDemo) throws Exception {
        Map<String, Object> result = deptDemo.deptByIntegrateId("1005");
        System.out.println("deptByIntegrateId result \n" + result);
    }

    private static void testDeptDelete(DeptDemo deptDemo) throws Exception {
        Map<String, Object> result = deptDemo.deptDelete(96);
        System.out.println("testDeptDelete result \n" + result);
    }

    private static void testDeptUpdate(DeptDemo deptDemo) throws Exception {
        Map<String, Object> result = deptDemo.deptUpdate(97, "name97");
        System.out.println("testDeptUpdate result \n" + result);
    }

    private static void testDeptList(DeptDemo deptDemo) throws Exception {
        Map<String, Object> result = deptDemo.deptList(1);
        System.out.println("testDeptList result \n" + result);
    }

    private static void testDeptCreate(DeptDemo deptDemo) throws Exception {
        DeptCreateParam param = new DeptCreateParam("Hello-Jdy test5");
        param.setDeptNo(96);
        param.setParentNo(97);
        Map<String, Object> result = deptDemo.deptCreate(param);
        System.out.println("testDeptCreate result \n" + result);
    }
}
