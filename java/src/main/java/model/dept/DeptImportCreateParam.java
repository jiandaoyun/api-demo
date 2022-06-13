package model.dept;

/**
 * 批量创建部门的参数
 */
public class DeptImportCreateParam {

    /**
     * 部门名称 必填
     */
    private String name;

    /**
     * 部门编号 选填
     */
    private Integer dept_no;

    public DeptImportCreateParam(String name) {
        this.name = name;
    }

    public DeptImportCreateParam() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDept_no() {
        return dept_no;
    }

    public void setDept_no(Integer dept_no) {
        this.dept_no = dept_no;
    }

    @Override
    public String toString() {
        return "DeptCreateParam{" +
                "name='" + name + '\'' +
                ", dept_no=" + dept_no +
                '}';
    }
}
