package cn.drst.dao;

import cn.drst.entity.ReviseClassesDate;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ReviseClassesDateDaoImpl extends BaseDaoImpl<ReviseClassesDate> implements ReviseClassesDateDao {
    public ReviseClassesDateDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
