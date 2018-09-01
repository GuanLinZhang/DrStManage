package cn.drst.dao;

import cn.drst.entity.MobileToken;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MobileTokenDaoImpl extends BaseDaoImpl<MobileToken> implements MobileTokenDao{
    public MobileTokenDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
