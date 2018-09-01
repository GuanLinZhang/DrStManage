package cn.drst.dao;

import cn.drst.entity.AppPatient;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppPatientDaoImpl extends BaseDaoImpl<AppPatient> implements AppPatientDao {
    @Autowired
    public AppPatientDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
