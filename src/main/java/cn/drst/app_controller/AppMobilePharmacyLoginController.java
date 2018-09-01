package cn.drst.app_controller;

import cn.drst.app_service.AppMobilePharmacyService;
import cn.drst.bean.AppMobilePharmacyBean;
import cn.drst.bean.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppMobilePharmacyLoginController {
    private AppMobilePharmacyService appMobilePharmacyService;

    @Autowired
    public AppMobilePharmacyLoginController(AppMobilePharmacyService appMobilePharmacyService) {
        this.appMobilePharmacyService = appMobilePharmacyService;
    }

    @RequestMapping(value = "/SignIn/Pharmacy.do",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<AppMobilePharmacyBean> SignIn(@RequestParam("token") String token,
                                                      @RequestParam("account") String account,
                                                      @RequestParam("password") String password) {
        ResponseBean<AppMobilePharmacyBean> responseBean = new ResponseBean<AppMobilePharmacyBean>();
        //验证token,账号,密码
        int state = appMobilePharmacyService.Verifying(token,account,password);
        //根据验证结果,判断登陆状态 0: 登陆成功 1: 账号密码验证失败 2: token非法
        if (state == 0) {
            responseBean.setState(100);
            responseBean.setMessage("登陆成功");
        } else if (state == 1) {
            responseBean.setState(200);
            responseBean.setMessage("登陆失败,账号密码错误");
        } else {
            responseBean.setState(200);
            responseBean.setMessage("登陆失败,Token非法");
        }
        return responseBean;
    }
}
