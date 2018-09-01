package cn.drst.app_service;

import cn.drst.dao.MobileTokenDao;
import cn.drst.entity.MobileToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AppRoleChooseService {
    private final MobileTokenDao mobileTokenDao;

    @Autowired
    public AppRoleChooseService(MobileTokenDao mobileTokenDao) {
        this.mobileTokenDao = mobileTokenDao;
    }




    //判断是否是登陆Token
    public boolean isLoginToken(String token) {
        Map<String,Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("loginToken",token);
        List<MobileToken> result = mobileTokenDao.findByConditions(conditionMap);

        if (result.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    //判断是否是临时Token
    public boolean isTempToken(String token) {
        Map<String,Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("temporaryToken",token);
        List<MobileToken> result = mobileTokenDao.findByConditions(conditionMap);

        if (result.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    //加入角色,只能在验证token合法后,使用
    public void updateRole(int role,String tempToken) {
        MobileToken mobileToken = mobileTokenDao.findByPKey(tempToken);
        mobileToken.setRole(role);
    }
}
