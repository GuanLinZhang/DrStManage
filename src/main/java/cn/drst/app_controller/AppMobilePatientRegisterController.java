package cn.drst.app_controller;

import cn.drst.app_service.AppMobileTokenService;
import cn.drst.app_service.AppPatientRegisterService;
import cn.drst.base.RetData;
import cn.drst.bean.AppMobilePatientAppendixBean;
import cn.drst.bean.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AppMobilePatientRegisterController {
    private final AppPatientRegisterService appPatientRegisterService;
    private final AppMobileTokenService appMobileTokenService;

    @Autowired
    public AppMobilePatientRegisterController(AppPatientRegisterService appPatientRegisterService, AppMobileTokenService appMobileTokenService) {
        this.appPatientRegisterService = appPatientRegisterService;
        this.appMobileTokenService = appMobileTokenService;
    }

    @RequestMapping(value = "/Register/Patient.do",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<AppMobilePatientAppendixBean> SignUp(@RequestParam("token") String token,
                                                             @RequestParam("account") String account,
                                                             @RequestParam("password") String password,
                                                             @RequestParam("telephone") String telephone,
                                                             @RequestParam("role") int role,
                                                             @RequestParam("smsCode") String smsCode) {
        //初始化结果状态Bean
        ResponseBean<AppMobilePatientAppendixBean> responseBean = new ResponseBean<AppMobilePatientAppendixBean>();
        List<AppMobilePatientAppendixBean> beanList = new ArrayList<AppMobilePatientAppendixBean>();
        RetData<AppMobilePatientAppendixBean> retData = new RetData<AppMobilePatientAppendixBean>();
        AppMobilePatientAppendixBean bean = new AppMobilePatientAppendixBean();

        //是否是临时Token,如果不是,直接返回结果状态
        if (!appMobileTokenService.isTempToken(token)) {
            responseBean.setMessage("临时Token非法,禁止注册");
            responseBean.setState(200);
            responseBean.setRetData(null);
            return responseBean;
        }
        //判断注册结果
        if (!appPatientRegisterService.register(account,password,telephone)) {
            responseBean.setMessage("注册失败,账号重复");
            responseBean.setState(200);     //注册失败,未登录状态
        } else {
            responseBean.setState(100);
            responseBean.setMessage("注册成功"); //注册成功,进入登陆状态
            appMobileTokenService.SetNameAndRole(token,role);
        }
        //将注册结果状态信息加载到Bean中
        beanList.add(bean);
        retData.setListData(beanList);
        responseBean.setRetData(retData);
        return responseBean;
    }
}
