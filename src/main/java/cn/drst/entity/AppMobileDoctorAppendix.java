package cn.drst.entity;

public class AppMobileDoctorAppendix {
    private int doctorId;
    private String accounts;
    private String passWord;
    private Integer starRating;
    private Integer inquiryNumber;
    private String recommendNumber;
    private Integer recommendLevel;
    private String superiorRecommendNumber;
    private Integer integral;
    private Integer jianYiYuan;
    private Integer star;
    private Integer sort;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
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

    public Integer getInquiryNumber() {
        return inquiryNumber;
    }

    public void setInquiryNumber(Integer inquiryNumber) {
        this.inquiryNumber = inquiryNumber;
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

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppMobileDoctorAppendix that = (AppMobileDoctorAppendix) o;

        if (doctorId != that.doctorId) return false;
        if (accounts != null ? !accounts.equals(that.accounts) : that.accounts != null) return false;
        if (passWord != null ? !passWord.equals(that.passWord) : that.passWord != null) return false;
        if (starRating != null ? !starRating.equals(that.starRating) : that.starRating != null) return false;
        if (inquiryNumber != null ? !inquiryNumber.equals(that.inquiryNumber) : that.inquiryNumber != null)
            return false;
        if (recommendNumber != null ? !recommendNumber.equals(that.recommendNumber) : that.recommendNumber != null)
            return false;
        if (recommendLevel != null ? !recommendLevel.equals(that.recommendLevel) : that.recommendLevel != null)
            return false;
        if (superiorRecommendNumber != null ? !superiorRecommendNumber.equals(that.superiorRecommendNumber) : that.superiorRecommendNumber != null)
            return false;
        if (integral != null ? !integral.equals(that.integral) : that.integral != null) return false;
        if (jianYiYuan != null ? !jianYiYuan.equals(that.jianYiYuan) : that.jianYiYuan != null) return false;
        if (star != null ? !star.equals(that.star) : that.star != null) return false;
        if (sort != null ? !sort.equals(that.sort) : that.sort != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = doctorId;
        result = 31 * result + (accounts != null ? accounts.hashCode() : 0);
        result = 31 * result + (passWord != null ? passWord.hashCode() : 0);
        result = 31 * result + (starRating != null ? starRating.hashCode() : 0);
        result = 31 * result + (inquiryNumber != null ? inquiryNumber.hashCode() : 0);
        result = 31 * result + (recommendNumber != null ? recommendNumber.hashCode() : 0);
        result = 31 * result + (recommendLevel != null ? recommendLevel.hashCode() : 0);
        result = 31 * result + (superiorRecommendNumber != null ? superiorRecommendNumber.hashCode() : 0);
        result = 31 * result + (integral != null ? integral.hashCode() : 0);
        result = 31 * result + (jianYiYuan != null ? jianYiYuan.hashCode() : 0);
        result = 31 * result + (star != null ? star.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        return result;
    }
}
