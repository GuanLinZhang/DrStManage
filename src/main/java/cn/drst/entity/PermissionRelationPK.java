package cn.drst.entity;

import java.io.Serializable;

public class PermissionRelationPK implements Serializable {
    private String permissionGroupId;
    private String permissionId;

    public String getPermissionGroupId() {
        return permissionGroupId;
    }

    public void setPermissionGroupId(String permissionGroupId) {
        this.permissionGroupId = permissionGroupId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermissionRelationPK that = (PermissionRelationPK) o;

        if (permissionGroupId != null ? !permissionGroupId.equals(that.permissionGroupId) : that.permissionGroupId != null)
            return false;
        if (permissionId != null ? !permissionId.equals(that.permissionId) : that.permissionId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = permissionGroupId != null ? permissionGroupId.hashCode() : 0;
        result = 31 * result + (permissionId != null ? permissionId.hashCode() : 0);
        return result;
    }
}
