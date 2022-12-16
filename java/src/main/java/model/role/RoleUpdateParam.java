package model.role;

import org.apache.commons.lang3.StringUtils;

public class RoleUpdateParam {

    private String name;
    private Integer group_no;
    private Integer role_no;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroup_no() {
        return group_no;
    }

    public void setGroup_no(Integer group_no) {
        this.group_no = group_no;
    }

    public Integer getRole_no() {
        return role_no;
    }

    public void setRole_no(Integer role_no) {
        this.role_no = role_no;
    }

    public boolean isValid() {
        return StringUtils.isNotBlank(this.getName()) && this.getRole_no() != null && this.getGroup_no() != null;
    }

    @Override
    public String toString() {
        return "RoleUpdateParam{" +
                "name='" + name + '\'' +
                ", group_no=" + group_no +
                ", role_no=" + role_no +
                '}';
    }
}
