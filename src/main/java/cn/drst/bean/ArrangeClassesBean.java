package cn.drst.bean;

import java.util.List;

public class ArrangeClassesBean {

    List<UserClassesBean> userClasses;
    ClassesBean classes;

    public List<UserClassesBean> getUserClasses() {
        return userClasses;
    }

    public void setUserClasses(List<UserClassesBean> userClasses) {
        this.userClasses = userClasses;
    }

    public ClassesBean getClasses() {
        return classes;
    }

    public void setClasses(ClassesBean classes) {
        this.classes = classes;
    }
}
