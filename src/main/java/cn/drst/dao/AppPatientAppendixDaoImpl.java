package cn.drst.dao;

import cn.drst.entity.AppPatientAppendix;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppPatientAppendixDaoImpl extends BaseDaoImpl<AppPatientAppendix> implements AppPatientAppendixDao {
    @Autowired
    public AppPatientAppendixDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
