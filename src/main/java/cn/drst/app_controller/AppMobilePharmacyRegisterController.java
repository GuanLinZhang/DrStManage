package cn.drst.app_controller;

import cn.drst.app_service.AppMobilePharmacyService;
import cn.drst.base.RetData;
import cn.drst.bean.AppMobilePharmacyAppendixBean;
import cn.drst.bean.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AppMobilePharmacyRegisterController {
    private final AppMobilePharmacyService appMobilePharmacyService;

    @Autowired
    public AppMobilePharmacyRegisterController(AppMobilePharmacyService appMobilePharmacyService) {
        this.appMobilePharmacyService = appMobilePharmacyService;
    }



    @RequestMapping(value = "/SignUp/Pharmacy.do",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<AppMobilePharmacyAppendixBean> SignUp(@RequestParam("token") String token,
                                                              @RequestParam("account") String account,
                                                              @RequestParam("password") String password,
                                                              @RequestParam("pharmacyName") String name,
                                                              @RequestParam("legalName") String legalName,
                                                              @RequestParam("phone") String phone,
                                                              @RequestParam("telephone") String telephone,
                                                              @RequestParam("licenseNumber") String licenseNumber,
                                                              @RequestParam("mainScope") String mainScope,
                                                              @RequestParam("businessLicenseImage") int licenseImage,
                                                              @RequestParam("synopsis") String synopsis,
                                                              @RequestParam("registerDate") String registerDate) {
        ResponseBean<AppMobilePharmacyAppendixBean> responseBean = new ResponseBean<AppMobilePharmacyAppendixBean>();
        List<AppMobilePharmacyAppendixBean> beanList = new ArrayList<AppMobilePharmacyAppendixBean>();
        RetData<AppMobilePharmacyAppendixBean> retData = new RetData<AppMobilePharmacyAppendixBean>();
        AppMobilePharmacyAppendixBean bean = new AppMobilePharmacyAppendixBean();
        
        //注册失败,返回结果
        if (!appMobilePharmacyService.register(
                token,
                account,
                password,
                name,legalName,phone,telephone,licenseNumber,mainScope,licenseImage,synopsis,registerDate)) {
            responseBean.setMessage("注册失败");
            responseBean.setState(200);
        } else {
            responseBean.setState(100);
            responseBean.setMessage("注册成功");
        }

        beanList.add(bean);
        retData.setListData(beanList);
        responseBean.setRetData(retData);
        return responseBean;
    }
}
