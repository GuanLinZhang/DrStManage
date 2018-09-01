package cn.drst.dao;

import cn.drst.entity.AppMobileDoctorAppendix;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class AppMobileDoctorAppendixDaoImpl extends BaseDaoImpl<AppMobileDoctorAppendix> implements AppMobileDoctorAppendixDao {
    public AppMobileDoctorAppendixDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
