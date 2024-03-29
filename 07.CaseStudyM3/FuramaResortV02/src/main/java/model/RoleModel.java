package model;

public class RoleModel {
    private int roleId;
    private int roleName;

    public RoleModel() {
    }

    public RoleModel(int roleId, int roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getRoleName() {
        return roleName;
    }

    public void setRoleName(int roleName) {
        this.roleName = roleName;
    }
}
