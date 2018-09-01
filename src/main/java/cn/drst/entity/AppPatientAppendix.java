package cn.drst.entity;

public class AppPatientAppendix {
    private int id;
    private String accounts;
    private String password;
    private String recommendNumber;
    private Integer recommendLevel;
    private String superiorRecommendNumber;
    private Integer integral;
    private Integer jianYiYuan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRecommendNumber() {
        return recommendNumber;
    }

    public void setRecommendNumber(String recommendNumber) {
        this.recommendNumber = recommendNumber;
    }

    public Integer getRecommendLevel() {
        return recommendLevel;
    }

    public void setRecommendLevel(Integer recommendLevel) {
        this.recommendLevel = recommendLevel;
    }

    public String getSuperiorRecommendNumber() {
        return superiorRecommendNumber;
    }

    public void setSuperiorRecommendNumber(String superiorRecommendNumber) {
        this.superiorRecommendNumber = superiorRecommendNumber;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getJianYiYuan() {
        return jianYiYuan;
    }

    public void setJianYiYuan(Integer jianYiYuan) {
        this.jianYiYuan = jianYiYuan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppPatientAppendix that = (AppPatientAppendix) o;

        if (id != that.id) return false;
        if (accounts != null ? !accounts.equals(that.accounts) : that.accounts != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (recommendNumber != null ? !recommendNumber.equals(that.recommendNumber) : that.recommendNumber != null)
            return false;
        if (recommendLevel != null ? !recommendLevel.equals(that.recommendLevel) : that.recommendLevel != null)
            return false;
        if (superiorRecommendNumber != null ? !superiorRecommendNumber.equals(that.superiorRecommendNumber) : that.superiorRecommendNumber != null)
            return false;
        if (integral != null ? !integral.equals(that.integral) : that.integral != null) return false;
        if (jianYiYuan != null ? !jianYiYuan.equals(that.jianYiYuan) : that.jianYiYuan != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (accounts != null ? accounts.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (recommendNumber != null ? recommendNumber.hashCode() : 0);
        result = 31 * result + (recommendLevel != null ? recommendLevel.hashCode() : 0);
        result = 31 * result + (superiorRecommendNumber != null ? superiorRecommendNumber.hashCode() : 0);
        result = 31 * result + (integral != null ? integral.hashCode() : 0);
        result = 31 * result + (jianYiYuan != null ? jianYiYuan.hashCode() : 0);
        return result;
    }
}
