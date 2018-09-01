package cn.drst.entity;

import java.sql.Timestamp;

public class AppMobileDoctor {
    private int id;
    private String name;
    private Integer sex;
    private String birthday;
    private String idNumber;
    private Integer headImage;
    private String phone;
    private Integer titles;
    private Integer qualification;
    private String qualificationNumber;
    private String affiliatedHospital;
    private Integer department;
    private String major;
    private String synopsis;
    private Integer titlesImage;
    private Timestamp registerDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getHeadImage() {
        return headImage;
    }

    public void setHeadImage(Integer headImage) {
        this.headImage = headImage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getTitles() {
        return titles;
    }

    public void setTitles(Integer titles) {
        this.titles = titles;
    }

    public Integer getQualification() {
        return qualification;
    }

    public void setQualification(Integer qualification) {
        this.qualification = qualification;
    }

    public String getQualificationNumber() {
        return qualificationNumber;
    }

    public void setQualificationNumber(String qualificationNumber) {
        this.qualificationNumber = qualificationNumber;
    }

    public String getAffiliatedHospital() {
        return affiliatedHospital;
    }

    public void setAffiliatedHospital(String affiliatedHospital) {
        this.affiliatedHospital = affiliatedHospital;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Integer getTitlesImage() {
        return titlesImage;
    }

    public void setTitlesImage(Integer titlesImage) {
        this.titlesImage = titlesImage;
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

        AppMobileDoctor doctor = (AppMobileDoctor) o;

        if (id != doctor.id) return false;
        if (name != null ? !name.equals(doctor.name) : doctor.name != null) return false;
        if (sex != null ? !sex.equals(doctor.sex) : doctor.sex != null) return false;
        if (birthday != null ? !birthday.equals(doctor.birthday) : doctor.birthday != null) return false;
        if (idNumber != null ? !idNumber.equals(doctor.idNumber) : doctor.idNumber != null) return false;
        if (headImage != null ? !headImage.equals(doctor.headImage) : doctor.headImage != null) return false;
        if (phone != null ? !phone.equals(doctor.phone) : doctor.phone != null) return false;
        if (titles != null ? !titles.equals(doctor.titles) : doctor.titles != null) return false;
        if (qualification != null ? !qualification.equals(doctor.qualification) : doctor.qualification != null)
            return false;
        if (qualificationNumber != null ? !qualificationNumber.equals(doctor.qualificationNumber) : doctor.qualificationNumber != null)
            return false;
        if (affiliatedHospital != null ? !affiliatedHospital.equals(doctor.affiliatedHospital) : doctor.affiliatedHospital != null)
            return false;
        if (department != null ? !department.equals(doctor.department) : doctor.department != null) return false;
        if (major != null ? !major.equals(doctor.major) : doctor.major != null) return false;
        if (synopsis != null ? !synopsis.equals(doctor.synopsis) : doctor.synopsis != null) return false;
        if (titlesImage != null ? !titlesImage.equals(doctor.titlesImage) : doctor.titlesImage != null) return false;
        if (registerDate != null ? !registerDate.equals(doctor.registerDate) : doctor.registerDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (idNumber != null ? idNumber.hashCode() : 0);
        result = 31 * result + (headImage != null ? headImage.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (titles != null ? titles.hashCode() : 0);
        result = 31 * result + (qualification != null ? qualification.hashCode() : 0);
        result = 31 * result + (qualificationNumber != null ? qualificationNumber.hashCode() : 0);
        result = 31 * result + (affiliatedHospital != null ? affiliatedHospital.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (major != null ? major.hashCode() : 0);
        result = 31 * result + (synopsis != null ? synopsis.hashCode() : 0);
        result = 31 * result + (titlesImage != null ? titlesImage.hashCode() : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        return result;
    }
}
