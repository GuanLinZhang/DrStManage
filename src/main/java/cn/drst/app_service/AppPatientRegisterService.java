package cn.drst.app_service;

import cn.drst.dao.AppPatientAppendixDao;
import cn.drst.dao.AppPatientDao;
import cn.drst.entity.AppPatient;
import cn.drst.entity.AppPatientAppendix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AppPatientRegisterService {
    private final AppPatientAppendixDao appPatientAppendixDao;
    private final AppPatientDao appPatientDao;

    @Autowired
    public AppPatientRegisterService(AppPatientAppendixDao appMobilePatientAppendixDao,
                                     AppPatientDao appMobilePatientDao) {
        this.appPatientAppendixDao = appMobilePatientAppendixDao;
        this.appPatientDao = appMobilePatientDao;
    }

    public boolean register(String account,String password,String telephone) {
        //如果是临时Token,并且账号名不重复,允许注册
            if (!isRepeatedAccount(account)) {
                //增加患者附表数据
                AppPatientAppendix patientAppendix = new AppPatientAppendix();
                patientAppendix.setPassword(password);

                //增加患者表数据
                AppPatient patient = new AppPatient();
                patient.setPhone(telephone);
                appPatientDao.save(patient);
                //注册成功
                return true;
            } else {
                return false;
            }
    }


    //判断账号是否重复
    private boolean isRepeatedAccount(String account) {
        //查询账号是否存在
        Map<String,Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("account",account);
        List<AppPatientAppendix> result = appPatientAppendixDao.findByConditions(conditionMap);

        //是否查询出账号信息
        return result.size() != 0;
    }
}
