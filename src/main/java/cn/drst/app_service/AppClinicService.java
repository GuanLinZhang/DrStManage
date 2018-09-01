package cn.drst.app_service;

import cn.drst.bean.AppMobileClinicAppendixBean;
import cn.drst.bean.AppMobileClinicBean;
import cn.drst.dao.AppMobileClinicAppendixDao;
import cn.drst.dao.ClinicDao;
import cn.drst.dao.MobileTokenDao;
import cn.drst.entity.AppMobileClinicAppendix;
import cn.drst.entity.Clinic;
import cn.drst.entity.MobileToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AppClinicService {
    private final ClinicDao clinicDao;
    private final AppMobileClinicAppendixDao clinicAppendixDao;
    private final MobileTokenDao mobileTokenDao;

    @Autowired
    public AppClinicService(ClinicDao clinicDao,
                            AppMobileClinicAppendixDao clinicAppendixDao,
                            MobileTokenDao mobileTokenDao) {
        this.clinicDao = clinicDao;
        this.clinicAppendixDao = clinicAppendixDao;
        this.mobileTokenDao = mobileTokenDao;
    }

    //诊所组织名是否存在
    public int FindClinic(String organizationNumber) {
        return clinicDao.findByPKey(organizationNumber) != null ? 1 : 0;
    }

    //返回指定诊所信息
    public AppMobileClinicBean GetClinicDetail(String organizationNumber) {
        Clinic clinic =  clinicDao.findByPKey(organizationNumber);
        AppMobileClinicBean clinicBean = new AppMobileClinicBean();
        clinicBean.setOrganizationNumber(clinic.getOrganizationNumber());
        clinicBean.setClinicName(clinic.getClinicName());
        clinicBean.setClinicAddress(clinic.getClinicAddress());
        clinicBean.setClinicState(clinic.getClinicState());
        return clinicBean;
    }

    //获得全部诊所列表
    public List<AppMobileClinicBean> GetClinicList() {
        List<AppMobileClinicBean> clinicBeanList = new ArrayList<AppMobileClinicBean>();
        List<Clinic> resList = clinicDao.findAll();
        //是否查询出结果
        if (resList.size() == 0 ) {
            return null;
        }
        for (int i = 0; i < resList.size(); i++) {
            AppMobileClinicBean clinicBean = new AppMobileClinicBean();
            clinicBean.setOrganizationNumber(resList.get(i).getOrganizationNumber());
            clinicBean.setClinicAddress(resList.get(i).getClinicAddress());
            clinicBean.setClinicName(resList.get(i).getClinicName());
            clinicBean.setClinicState(resList.get(i).getClinicState());
            clinicBeanList.add(clinicBean);
        }
        return clinicBeanList;
    }


    //判断是否是登陆Token
    public boolean IsLoginToken(String token) {
        Map<String, Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("loginToken", token);

        List<MobileToken> resList = mobileTokenDao.findByConditions(conditionMap);
        return resList.size() == 1;
    }

    //根据名字查找明星诊所
    public AppMobileClinicAppendixBean FindStarClinicByOrgName(String name) {
        Map<String,Object> conditionMap = new HashMap<String, Object>();
        //插入条件
        conditionMap.put("star",1);
        conditionMap.put("organizationNumber",name);
        List<AppMobileClinicAppendix> resList =  clinicAppendixDao.findByConditions(conditionMap);
        AppMobileClinicAppendixBean resBean = new AppMobileClinicAppendixBean();
        //检测查询结果
        if (resList.size() == 0) {
            return null;
        } else {
            //录入查询结果信息
            resBean.setOrganizationNumber(resList.get(0).getOrganizationNumber());
            resBean.setRecommendLevel(resList.get(0).getRecommendLevel());
            resBean.setSuperiorRecommendNumber(resList.get(0).getSuperiorRecommendNumber());
            return resBean;
        }
    }

    //列出所有明星诊所
    public List<AppMobileClinicAppendixBean> GetStarClinicList() {
        //生成查询条件
        Map<String,Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("star",1);
        //查询明星诊所列表
        List<AppMobileClinicAppendix> resList = clinicAppendixDao.findByConditions(conditionMap);
        //没有发现任何明星诊所,返回null
        if (resList.size() == 0) {
            return null;
        }
        List<AppMobileClinicAppendixBean> beanList = new ArrayList<AppMobileClinicAppendixBean>();
        //输入结果数据集合
        for (int i = 0; i < resList.size(); i++) {
            //将entity加载到bean中
            AppMobileClinicAppendixBean clinicAppendixBeanBean = new AppMobileClinicAppendixBean();
            clinicAppendixBeanBean.setOrganizationNumber(resList.get(i).getOrganizationNumber());
            clinicAppendixBeanBean.setRecommendLevel(resList.get(i).getRecommendLevel());
            clinicAppendixBeanBean.setSuperiorRecommendNumber(resList.get(i).getSuperiorRecommendNumber());
            clinicAppendixBeanBean.setJianYiYuan(resList.get(i).getJianYiYuan());
            clinicAppendixBeanBean.setStar(resList.get(i).getStar());
            clinicAppendixBeanBean.setStarRating(resList.get(i).getStarRating());
            clinicAppendixBeanBean.setSort(resList.get(i).getSort());
            beanList.add(clinicAppendixBeanBean);
        }
        return beanList;
    }
}
