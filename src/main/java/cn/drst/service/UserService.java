package cn.drst.service;

import cn.drst.dao.DepartmentDao;
import cn.drst.dao.UserDao;
import cn.drst.entity.Department;
import cn.drst.entity.Role;
import cn.drst.entity.User;
import cn.drst.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserService {

    private final UserDao userDao;
    private final DepartmentDao departmentDao;

    @Autowired
    public UserService(UserDao userDao, DepartmentDao departmentDao) {
        this.userDao = userDao;
        this.departmentDao = departmentDao;
    }


}