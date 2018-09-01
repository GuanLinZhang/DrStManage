package cn.drst.dao;

import cn.drst.entity.Clinic;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class ClinicDaoImpl extends BaseDaoImpl<Clinic> implements ClinicDao {

    public ClinicDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
