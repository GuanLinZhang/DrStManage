package cn.drst.entity;

import java.sql.Timestamp;

public class Clinic {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clinic clinic = (Clinic) o;

        if (organizationNumber != null ? !organizationNumber.equals(clinic.organizationNumber) : clinic.organizationNumber != null)
            return false;
        if (clinicName != null ? !clinicName.equals(clinic.clinicName) : clinic.clinicName != null) return false;
        if (clinicState != null ? !clinicState.equals(clinic.clinicState) : clinic.clinicState != null) return false;
        if (clinicAddress != null ? !clinicAddress.equals(clinic.clinicAddress) : clinic.clinicAddress != null)
            return false;
        if (createDate != null ? !createDate.equals(clinic.createDate) : clinic.createDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = organizationNumber != null ? organizationNumber.hashCode() : 0;
        result = 31 * result + (clinicName != null ? clinicName.hashCode() : 0);
        result = 31 * result + (clinicState != null ? clinicState.hashCode() : 0);
        result = 31 * result + (clinicAddress != null ? clinicAddress.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
