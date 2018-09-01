package cn.drst.dao;

import cn.drst.entity.RoleRelation;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRelationDaoImpl extends BaseDaoImpl<RoleRelation> implements RoleRelationDao {
    public RoleRelationDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
