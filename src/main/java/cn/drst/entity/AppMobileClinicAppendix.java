package cn.drst.entity;

public class AppMobileClinicAppendix {
    private String organizationNumber;
    private Integer starRating;
    private String recommendNumber;
    private Integer recommendLevel;
    private String superiorRecommendNumber;
    private Integer jianYiYuan;
    private Integer star;
    private Integer sort;

    public String getOrganizationNumber() {
        return organizationNumber;
    }

    public void setOrganizationNumber(String organizationNumber) {
        this.organizationNumber = organizationNumber;
    }

    public Integer getStarRating() {
        return starRating;
    }

    public void setStarRating(Integer starRating) {
        this.starRating = starRating;
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

        AppMobileClinicAppendix that = (AppMobileClinicAppendix) o;

        if (organizationNumber != null ? !organizationNumber.equals(that.organizationNumber) : that.organizationNumber != null)
            return false;
        if (starRating != null ? !starRating.equals(that.starRating) : that.starRating != null) return false;
        if (recommendNumber != null ? !recommendNumber.equals(that.recommendNumber) : that.recommendNumber != null)
            return false;
        if (recommendLevel != null ? !recommendLevel.equals(that.recommendLevel) : that.recommendLevel != null)
            return false;
        if (superiorRecommendNumber != null ? !superiorRecommendNumber.equals(that.superiorRecommendNumber) : that.superiorRecommendNumber != null)
            return false;
        if (jianYiYuan != null ? !jianYiYuan.equals(that.jianYiYuan) : that.jianYiYuan != null) return false;
        if (star != null ? !star.equals(that.star) : that.star != null) return false;
        if (sort != null ? !sort.equals(that.sort) : that.sort != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = organizationNumber != null ? organizationNumber.hashCode() : 0;
        result = 31 * result + (starRating != null ? starRating.hashCode() : 0);
        result = 31 * result + (recommendNumber != null ? recommendNumber.hashCode() : 0);
        result = 31 * result + (recommendLevel != null ? recommendLevel.hashCode() : 0);
        result = 31 * result + (superiorRecommendNumber != null ? superiorRecommendNumber.hashCode() : 0);
        result = 31 * result + (jianYiYuan != null ? jianYiYuan.hashCode() : 0);
        result = 31 * result + (star != null ? star.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        return result;
    }
}
