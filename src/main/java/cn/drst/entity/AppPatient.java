package cn.drst.entity;

public class AppPatient {
    private int id;
    private String name;
    private String birthday;
    private int sex;
    private String phone;
    private String idNumber;
    private Integer occupation;
    private Integer marital;
    private Integer national;
    private String company;
    private String province;
    private String city;
    private String area;
    private String address;
    private Integer source;
    private String remarks;

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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Integer getOccupation() {
        return occupation;
    }

    public void setOccupation(Integer occupation) {
        this.occupation = occupation;
    }

    public Integer getMarital() {
        return marital;
    }

    public void setMarital(Integer marital) {
        this.marital = marital;
    }

    public Integer getNational() {
        return national;
    }

    public void setNational(Integer national) {
        this.national = national;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppPatient that = (AppPatient) o;

        if (id != that.id) return false;
        if (sex != that.sex) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (idNumber != null ? !idNumber.equals(that.idNumber) : that.idNumber != null) return false;
        if (occupation != null ? !occupation.equals(that.occupation) : that.occupation != null) return false;
        if (marital != null ? !marital.equals(that.marital) : that.marital != null) return false;
        if (national != null ? !national.equals(that.national) : that.national != null) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (province != null ? !province.equals(that.province) : that.province != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (area != null ? !area.equals(that.area) : that.area != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        if (remarks != null ? !remarks.equals(that.remarks) : that.remarks != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + sex;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (idNumber != null ? idNumber.hashCode() : 0);
        result = 31 * result + (occupation != null ? occupation.hashCode() : 0);
        result = 31 * result + (marital != null ? marital.hashCode() : 0);
        result = 31 * result + (national != null ? national.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        return result;
    }
}
