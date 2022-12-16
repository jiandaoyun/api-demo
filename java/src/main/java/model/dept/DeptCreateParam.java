package model.dept;

import org.apache.commons.lang3.StringUtils;

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
    private Integer parent_no;

    /**
     * 部门编号 选填
     */
    private Integer dept_no;

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

    public Integer getParent_no() {
        return parent_no;
    }

    public void setParent_no(Integer parent_no) {
        this.parent_no = parent_no;
    }

    public Integer getDept_no() {
        return dept_no;
    }

    public void setDept_no(Integer dept_no) {
        this.dept_no = dept_no;
    }

    public boolean isValid() {
        return StringUtils.isNotBlank(this.getName());
    }

    @Override
    public String toString() {
        return "DeptCreateParam{" +
                "name='" + name + '\'' +
                ", parent_no=" + parent_no +
                ", dept_no=" + dept_no +
                '}';
    }
}
