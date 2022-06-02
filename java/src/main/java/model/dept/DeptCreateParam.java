package model.dept;

/**
 * 创建部门的参数
 */
public class DeptCreateParam {

    /**
     * 部门名称 必填
     */
    private String name;

    /**
     * 父级部门编号 选填
     */
    private Integer parentNo;

    /**
     * 部门编号 选填
     */
    private Integer deptNo;

    public DeptCreateParam(String name) {
        this.name = name;
    }

    public DeptCreateParam() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentNo() {
        return parentNo;
    }

    public void setParentNo(Integer parentNo) {
        this.parentNo = parentNo;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public String toString() {
        return "DeptCreateParam{" +
                "name='" + name + '\'' +
                ", parentNo='" + parentNo + '\'' +
                ", deptNo='" + deptNo + '\'' +
                '}';
    }
}
