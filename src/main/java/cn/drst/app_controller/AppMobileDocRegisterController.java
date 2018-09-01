package cn.drst.app_controller;

import cn.drst.app_service.AppDocRegisterService;
import cn.drst.base.RetData;
import cn.drst.bean.AppDocRegisterBean;
import cn.drst.bean.ResponseBean;
//import com.sun.corba.se.spi.presentation.rmi.IDLNameTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppMobileDocRegisterController {
    private final AppDocRegisterService appDocRegisterService;

    @Autowired
    public AppMobileDocRegisterController(AppDocRegisterService appDocRegisterService) {
        this.appDocRegisterService = appDocRegisterService;
    }

    @RequestMapping(value = "/Register/Doctor.do",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<AppDocRegisterBean> SignUp(@RequestParam("token") String token,
                                                   @RequestParam("account") String account,
                                                   @RequestParam("passWord") String passWord,
                                                   @RequestParam("name") String name,
                                                   @RequestParam("sex") int sex,
                                                   @RequestParam("birthday") String birthday,
                                                   @RequestParam("idNumber") String idNumber,
                                                   @RequestParam("phone") String phone,
                                                   @RequestParam("headImage") int headImage,
                                                   @RequestParam("titles") int titles,
                                                   @RequestParam("qualification") int qualification,
                                                   @RequestParam("qualificationNumber") String qualificationNumber,
                                                   @RequestParam("affiliatedHospital") String affiliatedHospital,
                                                   @RequestParam("department") int department,
                                                   @RequestParam("major") String major,
                                                   @RequestParam("synopsis") String synopsis,
                                                   @RequestParam("titlesImage") int titlesImage,
                                                   @RequestParam("registerDate") String registerDate) {
        ResponseBean<AppDocRegisterBean> responseBean = new ResponseBean<AppDocRegisterBean>();
        List<AppDocRegisterBean> beanList = new ArrayList<AppDocRegisterBean>();
        RetData<AppDocRegisterBean> retData = new RetData<AppDocRegisterBean>();
        AppDocRegisterBean bean = new AppDocRegisterBean();

        //注册结果状态 0:注册成功 1:账号密码错误 2:注册失败
        int state = appDocRegisterService.register(
                token, account, passWord,name,sex,birthday,idNumber,phone,
                headImage,titles,qualification,qualificationNumber,affiliatedHospital,
                department,major,synopsis,titlesImage,registerDate);
        //注册结果判定
        if (state == 0) {
            responseBean.setState(100);
            responseBean.setMessage("注册成功");
        } else if (state == 1) {
            responseBean.setState(200);
            responseBean.setMessage("注册失败,账号密码错误");
        } else {
            responseBean.setState(200);
            responseBean.setMessage("注册失败,token非法");
        }

        beanList.add(bean);
        retData.setListData(beanList);
        responseBean.setRetData(retData);
        return responseBean;
    }
}
