package cn.drst.entity;

import java.sql.Date;

public class ReviseClassesDate {
    private int id;
    private String userId;
    private Integer weekId;
    private String classesId;
    private Date reviseDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getWeekId() {
        return weekId;
    }

    public void setWeekId(Integer weekId) {
        this.weekId = weekId;
    }

    public String getClassesId() {
        return classesId;
    }

    public void setClassesId(String classesId) {
        this.classesId = classesId;
    }

    public Date getReviseDate() {
        return reviseDate;
    }

    public void setReviseDate(Date reviseDate) {
        this.reviseDate = reviseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReviseClassesDate that = (ReviseClassesDate) o;

        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (weekId != null ? !weekId.equals(that.weekId) : that.weekId != null) return false;
        if (classesId != null ? !classesId.equals(that.classesId) : that.classesId != null) return false;
        if (reviseDate != null ? !reviseDate.equals(that.reviseDate) : that.reviseDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (weekId != null ? weekId.hashCode() : 0);
        result = 31 * result + (classesId != null ? classesId.hashCode() : 0);
        result = 31 * result + (reviseDate != null ? reviseDate.hashCode() : 0);
        return result;
    }
}
