package cn.drst.dao;

import cn.drst.entity.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class DataSourceDaoImpl extends BaseDaoImpl<DataSource> implements DataSourceDao{

    public DataSourceDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
