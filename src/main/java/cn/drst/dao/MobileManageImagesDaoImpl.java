package cn.drst.dao;

import cn.drst.entity.MobileManageImages;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MobileManageImagesDaoImpl extends BaseDaoImpl<MobileManageImages> implements MobileManageImagesDao{
    public MobileManageImagesDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
