package cn.drst.entity;

import java.sql.Timestamp;

public class AppMobilePharmacy {
    private int id;
    private String pharmacyName;
    private String legalName;
    private String phone;
    private String telephone;
    private String businessLicenseNumber;
    private String mainScope;
    private Integer businessLiceseImage;
    private String synopsis;
    private Timestamp registerDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBusinessLicenseNumber() {
        return businessLicenseNumber;
    }

    public void setBusinessLicenseNumber(String businessLicenseNumber) {
        this.businessLicenseNumber = businessLicenseNumber;
    }

    public String getMainScope() {
        return mainScope;
    }

    public void setMainScope(String mainScope) {
        this.mainScope = mainScope;
    }

    public Integer getBusinessLiceseImage() {
        return businessLiceseImage;
    }

    public void setBusinessLiceseImage(Integer businessLiceseImage) {
        this.businessLiceseImage = businessLiceseImage;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppMobilePharmacy that = (AppMobilePharmacy) o;

        if (id != that.id) return false;
        if (pharmacyName != null ? !pharmacyName.equals(that.pharmacyName) : that.pharmacyName != null) return false;
        if (legalName != null ? !legalName.equals(that.legalName) : that.legalName != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (businessLicenseNumber != null ? !businessLicenseNumber.equals(that.businessLicenseNumber) : that.businessLicenseNumber != null)
            return false;
        if (mainScope != null ? !mainScope.equals(that.mainScope) : that.mainScope != null) return false;
        if (businessLiceseImage != null ? !businessLiceseImage.equals(that.businessLiceseImage) : that.businessLiceseImage != null)
            return false;
        if (synopsis != null ? !synopsis.equals(that.synopsis) : that.synopsis != null) return false;
        if (registerDate != null ? !registerDate.equals(that.registerDate) : that.registerDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (pharmacyName != null ? pharmacyName.hashCode() : 0);
        result = 31 * result + (legalName != null ? legalName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (businessLicenseNumber != null ? businessLicenseNumber.hashCode() : 0);
        result = 31 * result + (mainScope != null ? mainScope.hashCode() : 0);
        result = 31 * result + (businessLiceseImage != null ? businessLiceseImage.hashCode() : 0);
        result = 31 * result + (synopsis != null ? synopsis.hashCode() : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        return result;
    }
}
