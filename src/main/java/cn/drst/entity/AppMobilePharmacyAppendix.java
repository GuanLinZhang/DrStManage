package cn.drst.entity;

public class AppMobilePharmacyAppendix {
    private int pharmacyId;
    private String account;
    private String passWord;
    private Integer starRating;
    private Integer buyTime;
    private String recommendNumber;
    private Integer recommendLevel;
    private String superiorRecommendNumber;
    private Integer integral;
    private Integer jianYiYuan;

    public int getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getStarRating() {
        return starRating;
    }

    public void setStarRating(Integer starRating) {
        this.starRating = starRating;
    }

    public Integer getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Integer buyTime) {
        this.buyTime = buyTime;
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

        AppMobilePharmacyAppendix that = (AppMobilePharmacyAppendix) o;

        if (pharmacyId != that.pharmacyId) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (passWord != null ? !passWord.equals(that.passWord) : that.passWord != null) return false;
        if (starRating != null ? !starRating.equals(that.starRating) : that.starRating != null) return false;
        if (buyTime != null ? !buyTime.equals(that.buyTime) : that.buyTime != null) return false;
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
        int result = pharmacyId;
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (passWord != null ? passWord.hashCode() : 0);
        result = 31 * result + (starRating != null ? starRating.hashCode() : 0);
        result = 31 * result + (buyTime != null ? buyTime.hashCode() : 0);
        result = 31 * result + (recommendNumber != null ? recommendNumber.hashCode() : 0);
        result = 31 * result + (recommendLevel != null ? recommendLevel.hashCode() : 0);
        result = 31 * result + (superiorRecommendNumber != null ? superiorRecommendNumber.hashCode() : 0);
        result = 31 * result + (integral != null ? integral.hashCode() : 0);
        result = 31 * result + (jianYiYuan != null ? jianYiYuan.hashCode() : 0);
        return result;
    }
}
