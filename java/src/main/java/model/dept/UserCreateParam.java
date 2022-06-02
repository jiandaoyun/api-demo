package model.dept;

import java.util.List;

public class UserCreateParam {

    private String name;

    /**
     * 用户名 由数字字母和下划线组成
     */
    private String userName;

    /**
     * 非必填
     */
    private List<Integer> departmentList;

    public UserCreateParam() {
    }

    public UserCreateParam(String name, String userName) {
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
