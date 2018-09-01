package cn.drst.entity;

public class RoleRelation {
    private String roleId;
    private String permissionGroupId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionGroupId() {
        return permissionGroupId;
    }

    public void setPermissionGroupId(String permissionGroupId) {
        this.permissionGroupId = permissionGroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleRelation that = (RoleRelation) o;

        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (permissionGroupId != null ? !permissionGroupId.equals(that.permissionGroupId) : that.permissionGroupId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (permissionGroupId != null ? permissionGroupId.hashCode() : 0);
        return result;
    }
}
