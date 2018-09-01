package cn.drst.entity;

import java.sql.Timestamp;

public class MobileToken {
    private String temporaryToken;
    private String loginToken;
    private Integer role;
    private String name;
    private Timestamp createTime;

    public String getTemporaryToken() {
        return temporaryToken;
    }

    public void setTemporaryToken(String temporaryToken) {
        this.temporaryToken = temporaryToken;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MobileToken that = (MobileToken) o;

        if (temporaryToken != null ? !temporaryToken.equals(that.temporaryToken) : that.temporaryToken != null)
            return false;
        if (loginToken != null ? !loginToken.equals(that.loginToken) : that.loginToken != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = temporaryToken != null ? temporaryToken.hashCode() : 0;
        result = 31 * result + (loginToken != null ? loginToken.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
