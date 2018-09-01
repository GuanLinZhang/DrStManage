package cn.drst.entity;

public class Classes {
    private String classesId;
    private String classesName;

    public String getClassesId() {
        return classesId;
    }

    public void setClassesId(String classesId) {
        this.classesId = classesId;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Classes classes = (Classes) o;

        if (classesId != null ? !classesId.equals(classes.classesId) : classes.classesId != null) return false;
        if (classesName != null ? !classesName.equals(classes.classesName) : classes.classesName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = classesId != null ? classesId.hashCode() : 0;
        result = 31 * result + (classesName != null ? classesName.hashCode() : 0);
        return result;
    }
}
