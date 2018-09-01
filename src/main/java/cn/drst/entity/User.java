package cn.drst.entity;

public class User {
    private String userId;
    private String roleId;
    private String accounts;
    private String password;
    private String departmentId;
    private String name;
    private Integer sex;
    private String phone;
    private Integer remember;

//    private Set<Department> sets = new HashSet<Department>();

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRemember() {
        return remember;
    }

    public void setRemember(Integer remember) {
        this.remember = remember;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (roleId != null ? !roleId.equals(user.roleId) : user.roleId != null) return false;
        if (accounts != null ? !accounts.equals(user.accounts) : user.accounts != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (departmentId != null ? !departmentId.equals(user.departmentId) : user.departmentId != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (sex != null ? !sex.equals(user.sex) : user.sex != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (remember != null ? !remember.equals(user.remember) : user.remember != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        result = 31 * result + (accounts != null ? accounts.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (departmentId != null ? departmentId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (remember != null ? remember.hashCode() : 0);
        return result;
    }
}
