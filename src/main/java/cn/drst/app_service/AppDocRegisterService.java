package cn.drst.app_service;

import cn.drst.dao.AppMobileDoctorAppendixDao;
import cn.drst.dao.AppMobileDoctorDao;
import cn.drst.dao.MobileTokenDao;
import cn.drst.entity.AppMobileDoctor;
import cn.drst.entity.AppMobileDoctorAppendix;
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
public class AppDocRegisterService {
    private final MobileTokenDao mobileTokenDao;
    private final AppMobileDoctorAppendixDao appMobileDoctorAppendixDao;
    private final AppMobileDoctorDao appMobileDoctorDao;

    @Autowired
    public AppDocRegisterService(MobileTokenDao mobileTokenDao, AppMobileDoctorAppendixDao appMobileDoctorAppendixDao, AppMobileDoctorDao appMobileDoctorDao) {
        this.mobileTokenDao = mobileTokenDao;
        this.appMobileDoctorAppendixDao = appMobileDoctorAppendixDao;
        this.appMobileDoctorDao = appMobileDoctorDao;
    }



    //用户注册
    public int register(String tempToken,
                        String accounts,
                        String password,
                        String name,
                        int sex,
                        String birthday,
                        String idNumber,
                        String phone,
                        int headImage,
                        int titles,
                        int qualification,
                        String qualificationNumber,
                        String affiliatedHospital,
                        int department,
                        String major,
                        String synopsis,
                        int titlesImage,
                        String registerDate) {
        //查询token
        List<MobileToken> tokenList = findTempToken(tempToken);
        //如果是临时Token,并且账号名不重复,允许注册
        if (tokenList != null) {
            if (!isRepeatedAccount(accounts)) {
                //录入医生附表信息
                AppMobileDoctorAppendix appendix = new AppMobileDoctorAppendix();
                appendix.setAccounts(accounts);
                appendix.setPassWord(password);
                appendix.setJianYiYuan(100);
                appMobileDoctorAppendixDao.save(appendix);
                //录入医师表信息
                AppMobileDoctor doctor = new AppMobileDoctor();
                doctor.setName(name);
                doctor.setIdNumber(idNumber);
                doctor.setSex(sex);
                doctor.setBirthday(birthday);
                doctor.setPhone(phone);
                doctor.setHeadImage(headImage);
                doctor.setTitles(titles);
                doctor.setQualification(qualification);
                doctor.setQualificationNumber(qualificationNumber);
                doctor.setAffiliatedHospital(affiliatedHospital);
                doctor.setDepartment(department);
                doctor.setMajor(major);
                doctor.setSynopsis(synopsis);
                doctor.setTitlesImage(titlesImage);
                //将registerDate转为timestamp类型 输入格式必须为YYYY-MM-DD HH:MM:SS
                try {
                    Timestamp ts = Timestamp.valueOf(registerDate);
                    doctor.setRegisterDate(ts);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //保存注册实例
                appMobileDoctorDao.save(doctor);
                return 0; //注册成功
            }
            return 1; //注册失败,账号重复
        }
        //
        return 2; //注册失败,属于非法token
    }



    //查询是否存在临时Token,如果存在则返回
    private List<MobileToken> findTempToken(String token) {
        Map<String,Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("temporaryToken",token);
        List<MobileToken> result = mobileTokenDao.findByConditions(conditionMap);

        return result.size() == 0 ? null : result;
    }

    //判断账号是否重复
    private boolean isRepeatedAccount(String accounts) {
        //查询账号是否存在
        Map<String,Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("accounts",accounts);
        List<AppMobileDoctorAppendix> result = appMobileDoctorAppendixDao.findByConditions(conditionMap);

        //是否查询出账号信息
        return result.size() == 0;
    }

}
