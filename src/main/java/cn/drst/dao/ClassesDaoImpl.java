package cn.drst.dao;

import cn.drst.entity.Classes;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ClassesDaoImpl extends BaseDaoImpl<Classes> implements ClassesDao {
    public ClassesDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
