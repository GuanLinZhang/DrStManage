package cn.drst.entity;

public class Permission {
    private String permissionId;
    private String permissionName;
    private String permissionExplain;
    private int permissionVisible;
    private String permissionValue;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionExplain() {
        return permissionExplain;
    }

    public void setPermissionExplain(String permissionExplain) {
        this.permissionExplain = permissionExplain;
    }

    public int getPermissionVisible() {
        return permissionVisible;
    }

    public void setPermissionVisible(int permissionVisible) {
        this.permissionVisible = permissionVisible;
    }

    public String getPermissionValue() {
        return permissionValue;
    }

    public void setPermissionValue(String permissionValue) {
        this.permissionValue = permissionValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission that = (Permission) o;

        if (permissionVisible != that.permissionVisible) return false;
        if (permissionId != null ? !permissionId.equals(that.permissionId) : that.permissionId != null) return false;
        if (permissionName != null ? !permissionName.equals(that.permissionName) : that.permissionName != null)
            return false;
        if (permissionExplain != null ? !permissionExplain.equals(that.permissionExplain) : that.permissionExplain != null)
            return false;
        if (permissionValue != null ? !permissionValue.equals(that.permissionValue) : that.permissionValue != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = permissionId != null ? permissionId.hashCode() : 0;
        result = 31 * result + (permissionName != null ? permissionName.hashCode() : 0);
        result = 31 * result + (permissionExplain != null ? permissionExplain.hashCode() : 0);
        result = 31 * result + permissionVisible;
        result = 31 * result + (permissionValue != null ? permissionValue.hashCode() : 0);
        return result;
    }
}
