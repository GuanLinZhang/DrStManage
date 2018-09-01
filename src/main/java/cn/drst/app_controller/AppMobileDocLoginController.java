package cn.drst.app_controller;

import cn.drst.app_service.AppMobileDocLoginService;
import cn.drst.bean.AppLoginBean;
import cn.drst.bean.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppMobileDocLoginController {
    private final AppMobileDocLoginService appMobileDocLoginService;

    @Autowired
    public AppMobileDocLoginController(AppMobileDocLoginService appMobileDocLoginService) {
        this.appMobileDocLoginService = appMobileDocLoginService;
    }

    @RequestMapping(value = "/SignIn/Doctor.do",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<AppLoginBean> SignIn(@RequestParam("token") String token,
                                             @RequestParam("account") String account,
                                             @RequestParam("password") String password) {
        ResponseBean<AppLoginBean> responseBean = new ResponseBean<AppLoginBean>();
        int state = appMobileDocLoginService.Verifying(token,account,password);
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
        responseBean.setRetData(null);
        return responseBean;
    }
}
