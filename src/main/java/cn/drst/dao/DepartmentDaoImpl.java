package cn.drst.dao;

import cn.drst.entity.Department;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {
    public DepartmentDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
