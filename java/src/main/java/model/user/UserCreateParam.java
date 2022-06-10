package model.user;

import java.util.List;

public class UserCreateParam {

    private String name;

    /**
     * 用户名 由数字字母和下划线组成
     */
    private String username;

    /**
     * 非必填
     */
    private List<Integer> departments;

    public UserCreateParam() {
    }

    public UserCreateParam(String name, String userName) {
        this.name = name;
        this.username = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Integer> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Integer> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "UserCreateParam{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", departments=" + departments +
                '}';
    }
}
