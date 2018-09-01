package cn.drst.dao;

import cn.drst.entity.AppMobileDoctor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class AppMobileDoctorDaoImpl extends BaseDaoImpl<AppMobileDoctor> implements AppMobileDoctorDao {
    public AppMobileDoctorDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
