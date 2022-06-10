package api.arch;

import model.dept.DeptCreateParam;
import model.dept.DeptImportCreateParam;

import java.util.ArrayList;
import java.util.List;
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
        // 批量导入部门
        departmentImport(deptDemo);
    }

    private static void departmentImport(DeptDemo deptDemo) throws Exception {
        // name 和 dept_no 必传
        List<Object> paramList = new ArrayList<>();
        // 父级部门 只要设置部门编号，不要parent_no
        DeptImportCreateParam parentDept = new DeptImportCreateParam("ImportParantName1");
        parentDept.setDept_no(101);
        paramList.add(parentDept);
        // 子部门 需要设置父部门编号
        DeptCreateParam sonDept = new DeptCreateParam("ImportSonName2");
        sonDept.setDept_no(102);
        sonDept.setParent_no(101);
        paramList.add(sonDept);
        Map<String, Object> result = deptDemo.departmentImport(paramList);
        System.out.println("departmentImport result \n" + result);
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
        Map<String, Object> result = deptDemo.deptList(1, false);
        System.out.println("testDeptList result \n" + result);
    }

    private static void testDeptCreate(DeptDemo deptDemo) throws Exception {
        DeptCreateParam param = new DeptCreateParam("Hello-Jdy test5");
        param.setDept_no(96);
        param.setParent_no(2);
        Map<String, Object> result = deptDemo.deptCreate(param);
        System.out.println("testDeptCreate result \n" + result);
    }
}
