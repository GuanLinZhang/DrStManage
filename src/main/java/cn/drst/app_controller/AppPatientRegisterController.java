package cn.drst.app_controller;

import cn.drst.app_service.AppPatientAppendixService;
import cn.drst.bean.AppLoginBean;
import cn.drst.bean.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppPatientRegisterController {
    private final AppPatientAppendixService appendixLoginService;

    @Autowired
    public AppPatientRegisterController(AppPatientAppendixService appendixLoginService) {
        this.appendixLoginService = appendixLoginService;
    }

    @RequestMapping(value = "/SignIn/patient.do",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<AppLoginBean> SignIn(@RequestParam("token") String token,
                                             @RequestParam("account") String account,
                                             @RequestParam("password") String password){
        ResponseBean<AppLoginBean> responseBean = new ResponseBean<AppLoginBean>();
        //验证token,账号,密码
        int state = appendixLoginService.Verifying(token,account,password);
        //根据验证结果,判断登陆状态 0: 登陆成功 1: 账号密码验证失败 2: token非法
        if (state == 0) {
            responseBean.setMessage("登陆成功");
            responseBean.setState(100);
        } else if (state == 1) {
            responseBean.setMessage("登陆失败,账号密码错误");
            responseBean.setState(200);
        } else {
            responseBean.setState(200);
            responseBean.setMessage("登陆失败,Token非法");
        }
        responseBean.setRetData(null);
        return responseBean;
    }
}
