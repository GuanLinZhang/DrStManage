package cn.drst.entity;

public class DataSource {
    private String sourceId;
    private String organizationNumber;
    private String sourceName;
    private Integer sourceState;
    private String dataBaseName;
    private String driverClass;
    private String jdbcUrl;
    private String userName;
    private String password;
    private Integer sourceType;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getOrganizationNumber() {
        return organizationNumber;
    }

    public void setOrganizationNumber(String organizationNumber) {
        this.organizationNumber = organizationNumber;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Integer getSourceState() {
        return sourceState;
    }

    public void setSourceState(Integer sourceState) {
        this.sourceState = sourceState;
    }

    public String getDataBaseName() {
        return dataBaseName;
    }

    public void setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataSource that = (DataSource) o;

        if (sourceId != null ? !sourceId.equals(that.sourceId) : that.sourceId != null) return false;
        if (organizationNumber != null ? !organizationNumber.equals(that.organizationNumber) : that.organizationNumber != null)
            return false;
        if (sourceName != null ? !sourceName.equals(that.sourceName) : that.sourceName != null) return false;
        if (sourceState != null ? !sourceState.equals(that.sourceState) : that.sourceState != null) return false;
        if (dataBaseName != null ? !dataBaseName.equals(that.dataBaseName) : that.dataBaseName != null) return false;
        if (driverClass != null ? !driverClass.equals(that.driverClass) : that.driverClass != null) return false;
        if (jdbcUrl != null ? !jdbcUrl.equals(that.jdbcUrl) : that.jdbcUrl != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (sourceType != null ? !sourceType.equals(that.sourceType) : that.sourceType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sourceId != null ? sourceId.hashCode() : 0;
        result = 31 * result + (organizationNumber != null ? organizationNumber.hashCode() : 0);
        result = 31 * result + (sourceName != null ? sourceName.hashCode() : 0);
        result = 31 * result + (sourceState != null ? sourceState.hashCode() : 0);
        result = 31 * result + (dataBaseName != null ? dataBaseName.hashCode() : 0);
        result = 31 * result + (driverClass != null ? driverClass.hashCode() : 0);
        result = 31 * result + (jdbcUrl != null ? jdbcUrl.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (sourceType != null ? sourceType.hashCode() : 0);
        return result;
    }
}
