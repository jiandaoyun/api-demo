package model.dept;

import java.util.List;

public class UserUpdateParam {

    private String name;

    private String userName;

    /**
     * 非必填
     */
    private List<Integer> departmentList;

    public UserUpdateParam() {
    }

    public UserUpdateParam(String name, String userName) {
        this.name = name;
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Integer> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Integer> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public String toString() {
        return "UserCreateParam{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", departmentList=" + departmentList +
                '}';
    }
}
