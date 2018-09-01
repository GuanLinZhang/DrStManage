package cn.drst.dao;

import cn.drst.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl  extends BaseDaoImpl<User> implements UserDao {

    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
