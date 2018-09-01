package cn.drst.dao;

import cn.drst.entity.AppMobileClinicAppendix;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class AppMobileClinicAppendixDaoImpl extends BaseDaoImpl<AppMobileClinicAppendix> implements AppMobileClinicAppendixDao {
    public AppMobileClinicAppendixDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
