package api.arch;

import model.dept.DeptCreateParam;

public class DeptDemoTest {

    public static void main(String[] args) throws Exception {
        DeptDemo deptDemo = new DeptDemo();
        // 创建部门
//        testDeptCreate(deptDemo);
//        System.out.println("-------------------------------------");
        testDeptList(deptDemo);
//        System.out.println("-------------------------------------");
//        testDeptUpdate(deptDemo);
//        System.out.println("-------------------------------------");
//        testDeptDelete(deptDemo);
//        System.out.println("-------------------------------------");
//        deptByIntegrateId(deptDemo);
    }

    private static void deptByIntegrateId(DeptDemo deptDemo) throws Exception {
        deptDemo.deptByIntegrateId("1005");
    }

    private static void testDeptDelete(DeptDemo deptDemo) throws Exception {
        deptDemo.deptDelete(96);
    }

    private static void testDeptUpdate(DeptDemo deptDemo) throws Exception {
        deptDemo.deptUpdate(97, "name97");
    }

    private static void testDeptList(DeptDemo deptDemo) throws Exception {
        deptDemo.deptList(1);
    }

    private static void testDeptCreate(DeptDemo deptDemo) throws Exception {
        DeptCreateParam param = new DeptCreateParam("Hello-Jdy test5");
        param.setDeptNo(96);
        param.setParentNo(97);
        deptDemo.deptCreate(param);
    }
}
