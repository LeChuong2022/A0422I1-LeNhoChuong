package model;

public class UserRoleModel {
    private int roleId;
    private String userName;

    public UserRoleModel() {
    }

    public UserRoleModel(int roleId, String userName) {
        this.roleId = roleId;
        this.userName = userName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
