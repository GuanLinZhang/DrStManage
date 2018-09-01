package cn.drst.dao;

import cn.drst.entity.AppMobilePharmacy;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class AppMobilePharmacyDaoImpl extends BaseDaoImpl<AppMobilePharmacy> implements AppMobilePharmacyDao {
    public AppMobilePharmacyDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
