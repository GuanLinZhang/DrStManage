package cn.drst.dao;

import cn.drst.entity.AppMobilePharmacyAppendix;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class AppMobilePharmacyAppendixDaoImpl extends BaseDaoImpl<AppMobilePharmacyAppendix> implements AppMobilePharmacyAppendixDao {
    public AppMobilePharmacyAppendixDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
