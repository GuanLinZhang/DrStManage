package cn.drst.app_controller;

import cn.drst.app_service.AppRoleChooseService;
import cn.drst.base.RetData;
import cn.drst.bean.AppTokenBean;
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
public class AppMobileRoleChooseController {
    private final AppRoleChooseService appRoleChooseService;
    @Autowired
    public AppMobileRoleChooseController(AppRoleChooseService appRoleChooseService) {
        this.appRoleChooseService = appRoleChooseService;
    }

    @RequestMapping(value = "/RoleChoose.do",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<AppTokenBean> ChangePage(@RequestParam("token") String token) {
        ResponseBean<AppTokenBean> responseBean = new ResponseBean<AppTokenBean>();
        AppTokenBean tokenBean = new AppTokenBean();
        RetData<AppTokenBean> retData = new RetData<AppTokenBean>();
        List<AppTokenBean> retDataList = new ArrayList<AppTokenBean>();

        //判断临时的
        if (appRoleChooseService.isTempToken(token)) {
            responseBean.setState(100);
            responseBean.setMessage("跳转到用户注册界面");
            tokenBean.setType(0); //注册token
//            //根据token更新用户角色
//            appRoleChooseService.updateRole(role,token);
//            //添加结果信息
            retDataList.add(tokenBean);
            retData.setListData(retDataList);
        } else if (appRoleChooseService.isLoginToken(token)) {
            //判断是否是登陆Token
            responseBean.setState(100);
            responseBean.setMessage("已登录,跳转到用户信息界面");
            tokenBean.setType(1); //登陆token
//            //根据token更新用户角色
//            //添加结果信息
//            retDataList.add(tokenBean);
//            retData.setListData(retDataList);
        } else {
            //非法Token State:200
            responseBean.setState(200);
            responseBean.setMessage("Token非法");
            responseBean.setRetData(null);
            return responseBean;
        }

        //添加到RetData,显示结果信息
        responseBean.setRetData(retData);
        return responseBean;
    }
}
