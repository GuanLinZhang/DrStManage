package cn.drst.dao;

import cn.drst.entity.Code;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CodeDaoImpl extends BaseDaoImpl<Code> implements CodeDao {
    public CodeDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
