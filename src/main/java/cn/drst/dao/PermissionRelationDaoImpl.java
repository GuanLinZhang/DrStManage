package cn.drst.dao;

import cn.drst.entity.PermissionRelation;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PermissionRelationDaoImpl extends BaseDaoImpl<PermissionRelation> implements PermissionRelationDao{
    public PermissionRelationDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
