package cn.drst.app_service;

import cn.drst.dao.AppMobilePharmacyAppendixDao;
import cn.drst.dao.AppMobilePharmacyDao;
import cn.drst.dao.MobileTokenDao;
import cn.drst.entity.AppMobilePharmacy;
import cn.drst.entity.AppMobilePharmacyAppendix;
import cn.drst.entity.MobileToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AppMobilePharmacyService {
    private AppMobilePharmacyDao appMobilePharmacyDao;
    private AppMobilePharmacyAppendixDao appMobilePharmacyAppendixDao;
    private MobileTokenDao mobileTokenDao;

    @Autowired
    public AppMobilePharmacyService(AppMobilePharmacyDao appMobilePharmacyDao, AppMobilePharmacyAppendixDao appMobilePharmacyAppendixDao, MobileTokenDao mobileTokenDao) {
        this.appMobilePharmacyDao = appMobilePharmacyDao;
        this.appMobilePharmacyAppendixDao = appMobilePharmacyAppendixDao;
        this.mobileTokenDao = mobileTokenDao;
    }

    public boolean register(String token,
                            String account,
                            String password,
                            String pharmacyName,
                            String legalName,
                            String phone,
                            String telephone,
                            String licenseNumber,
                            String mainScope,
                            int businessLicenseImage,
                            String synopsis,
                            String registerDate) {
        //不是临时Token,不允许注册
        if (!isTempToken(token)) {
            return false;
        }

        if (!isRepeatedAccount(account)) {
            //更新药店附表信息
            AppMobilePharmacyAppendix appendix = new AppMobilePharmacyAppendix();
            appendix.setAccount(account);
            appendix.setPassWord(password);
            appendix.setJianYiYuan(200);
            appMobilePharmacyAppendixDao.save(appendix);
            //更新药店表信息
            AppMobilePharmacy appMobilePharmacy = new AppMobilePharmacy();
            appMobilePharmacy.setPharmacyName(pharmacyName);
            appMobilePharmacy.setLegalName(legalName);
            appMobilePharmacy.setPhone(phone);
            appMobilePharmacy.setTelephone(telephone);
            appMobilePharmacy.setTelephone(licenseNumber);
            appMobilePharmacy.setMainScope(mainScope);
            appMobilePharmacy.setBusinessLiceseImage(businessLicenseImage);
            appMobilePharmacy.setSynopsis(synopsis);
            //设置注册时间
            Timestamp timestamp = Timestamp.valueOf(registerDate);
            appMobilePharmacy.setRegisterDate(timestamp);
            //保存实例
            appMobilePharmacyDao.save(appMobilePharmacy);
            return true;
            //账号重复不允许注册
        } else {
            return false;
        }


    }

    //登陆账号密码验证
    public int Verifying(String token,String account,String password) {
        if (!isTempToken(token)) {
            return 2; //传入token不是临时token,禁止登陆
        }
        //创建SQL查询条件
        Map<String,Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("account",account);
        conditionMap.put("passWord",password);
        //查询后,返回结果并将结果赋值resList
        List<AppMobilePharmacyAppendix> resList =  appMobilePharmacyAppendixDao.findByConditions(conditionMap);
        //如果查询出结果,则验证成功,允许登陆
        if (resList.size() != 0) {
            return 0; //登陆成功
        } else {
            return 1; //账号密码验证错误,返回1
        }

    }

    //判断是否是临时Token
    private boolean isTempToken(String token) {
        Map<String,Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("temporaryToken",token);
        List<MobileToken> result = mobileTokenDao.findByConditions(conditionMap);

        return result.size() != 0;
    }

    //判断账号是否重复
    private boolean isRepeatedAccount(String accounts) {
        //查询账号是否存在
        Map<String,Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("account",accounts);
        List<AppMobilePharmacyAppendix> result = appMobilePharmacyAppendixDao.findByConditions(conditionMap);
        //是否查询出账号信息
        if (result.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

}
