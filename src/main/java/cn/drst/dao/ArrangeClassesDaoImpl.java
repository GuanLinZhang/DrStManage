package cn.drst.dao;

import cn.drst.entity.ArrangeClasses;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ArrangeClassesDaoImpl extends BaseDaoImpl<ArrangeClasses> implements ArrangeClassesDao {
    public ArrangeClassesDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
