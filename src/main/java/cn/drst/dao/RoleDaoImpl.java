package cn.drst.dao;

import cn.drst.entity.Role;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

    public RoleDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
