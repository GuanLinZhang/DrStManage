package cn.drst.bean;

import java.sql.Timestamp;

public class AppMobileClinicBean {

    private String organizationNumber;
    private String clinicName;
    private Integer clinicState;
    private String clinicAddress;
    private Timestamp createDate;

    public String getOrganizationNumber() {
        return organizationNumber;
    }

    public void setOrganizationNumber(String organizationNumber) {
        this.organizationNumber = organizationNumber;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public Integer getClinicState() {
        return clinicState;
    }

    public void setClinicState(Integer clinicState) {
        this.clinicState = clinicState;
    }

    public String getClinicAddress() {
        return clinicAddress;
    }

    public void setClinicAddress(String clinicAddress) {
        this.clinicAddress = clinicAddress;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }


}
