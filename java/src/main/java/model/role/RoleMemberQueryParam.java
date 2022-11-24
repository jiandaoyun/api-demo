package model.role;

import model.base.PageBaseParam;

public class RoleMemberQueryParam extends PageBaseParam {
    private Integer role_no;

    public Integer getRole_no() {
        return role_no;
    }

    public void setRole_no(Integer role_no) {
        this.role_no = role_no;
    }

    public boolean isValid() {
        return this.getRole_no() != null && super.isValid();
    }

    @Override
    public String toString() {
        return "RoleMemberQueryParam{" +
                "skip=" + super.getSkip() +
                ", limit=" + super.getLimit() +
                ", role_no=" + role_no +
                '}';
    }
}
