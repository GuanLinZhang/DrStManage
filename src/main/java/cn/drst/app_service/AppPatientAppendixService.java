package cn.drst.app_service;

import cn.drst.dao.AppPatientAppendixDao;
import cn.drst.dao.MobileTokenDao;
import cn.drst.entity.AppPatientAppendix;
import cn.drst.entity.MobileToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AppPatientAppendixService {

    private final AppPatientAppendixDao appPatientAppendixDao;
    private final MobileTokenDao mobileTokenDao;

    @Autowired
    public AppPatientAppendixService(AppPatientAppendixDao appPatientAppendixDao, MobileTokenDao mobileTokenDao) {
        this.appPatientAppendixDao = appPatientAppendixDao;
        this.mobileTokenDao = mobileTokenDao;
    }

    //登陆验证
    public int Verifying(String tempToken,
                         String account,
                         String password) {
        //查询token
        List<MobileToken> tokenList = findTempToken(tempToken);
        //如果是临时Token,账号密码验证成功,允许登陆
        if (tokenList != null) {
            Map<String, Object> conditionMap = new HashMap<String, Object>();
            conditionMap.put("account", account);
            conditionMap.put("passWord", password);
            List<AppPatientAppendix> resList =
                    appPatientAppendixDao.findByConditions(conditionMap);
            if (resList.size() != 0) {
                return 0; //登陆成功
            } else {
                return 1; //账户密码错误
            }
        }
        return 2; //token非法
    }

    //判断是否是临时Token
    private List<MobileToken> findTempToken(String token) {
        Map<String,Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("temporaryToken",token);
        List<MobileToken> resList = mobileTokenDao.findByConditions(conditionMap);

        if (resList.size() == 0) {
            return null;
        } else {
            return resList;
        }
    }

}
