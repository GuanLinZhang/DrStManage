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
public class AppMobileTokenService {
    private MobileTokenDao mobileTokenDao;

    @Autowired
    public AppMobileTokenService(MobileTokenDao mobileTokenDao) {
        this.mobileTokenDao = mobileTokenDao;
    }

    //判断是否是登陆Token
    public boolean isLoginToken(String token) {
        Map<String,Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("loginToken",token);
        List<MobileToken> result = mobileTokenDao.findByConditions(conditionMap);

        return result.size() != 0;
    }

    //判断是否是临时Token
    public boolean isTempToken(String token) {
        Map<String,Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("temporaryToken",token);
        List<MobileToken> result = mobileTokenDao.findByConditions(conditionMap);

        return result.size() != 0;
    }

    public void SetNameAndRole(String token,int role) {
        Map<String,Object> queryMap = new HashMap<String, Object>();
        queryMap.put("temporaryToken",token);

        Map<String,Object> roleConditionMap = new HashMap<String, Object>();
        roleConditionMap.put("role",role);

        //更新role,name字段
        mobileTokenDao.updateFieldsByConditions(roleConditionMap,queryMap);
    }
}
