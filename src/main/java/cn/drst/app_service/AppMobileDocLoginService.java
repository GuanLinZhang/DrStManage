package cn.drst.app_service;

import cn.drst.dao.AppMobileDoctorAppendixDao;
import cn.drst.dao.MobileTokenDao;
import cn.drst.entity.AppMobileDoctorAppendix;
import cn.drst.entity.MobileToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AppMobileDocLoginService {
    private final AppMobileDoctorAppendixDao appMobileDoctorAppendixDao;
    private final MobileTokenDao mobileTokenDao;

    @Autowired
    public AppMobileDocLoginService(AppMobileDoctorAppendixDao appMobileDoctorAppendixDao,MobileTokenDao mobileTokenDao) {
        this.appMobileDoctorAppendixDao = appMobileDoctorAppendixDao;
        this.mobileTokenDao = mobileTokenDao;
    }

    //登陆验证
    public int Verifying(String tempToken,
                         String accounts,
                         String password) {
        //查询token
        List<MobileToken> tokenList = findTempToken(tempToken);
        //如果是临时Token,账号密码验证成功,允许登陆
        if (tokenList != null) {
            Map<String, Object> conditionMap = new HashMap<String, Object>();
            conditionMap.put("accounts", accounts);
            conditionMap.put("passWord", password);
            List<AppMobileDoctorAppendix> appMobileDoctorAppendixDaoList =
                    appMobileDoctorAppendixDao.findByConditions(conditionMap);
            return appMobileDoctorAppendixDaoList.size() != 0 ? 1 : 0;
        }
        return 2; //token非法
    }

    //查询是否存在临时Token,如果存在则返回
    private List<MobileToken> findTempToken(String token) {
        Map<String,Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("temporaryToken",token);
        List<MobileToken> result = mobileTokenDao.findByConditions(conditionMap);

        if (result.size() == 0) {
            return null;
        } else {
            return result;
        }
    }


}
