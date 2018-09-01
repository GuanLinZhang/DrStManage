package cn.drst.entity;

public class Department {
    private String departmentId;
    private String departmentName;
    private String departmentExplain;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentExplain() {
        return departmentExplain;
    }

    public void setDepartmentExplain(String departmentExplain) {
        this.departmentExplain = departmentExplain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (departmentId != null ? !departmentId.equals(that.departmentId) : that.departmentId != null) return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;
        if (departmentExplain != null ? !departmentExplain.equals(that.departmentExplain) : that.departmentExplain != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departmentId != null ? departmentId.hashCode() : 0;
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        result = 31 * result + (departmentExplain != null ? departmentExplain.hashCode() : 0);
        return result;
    }
}
