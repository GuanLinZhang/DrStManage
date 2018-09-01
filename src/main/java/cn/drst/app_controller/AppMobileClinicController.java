package cn.drst.app_controller;

import cn.drst.app_service.AppClinicService;
import cn.drst.base.RetData;
import cn.drst.bean.AppMobileClinicAppendixBean;
import cn.drst.bean.AppMobileClinicBean;
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
public class AppMobileClinicController {
    private final AppClinicService appClinicService;

    @Autowired
    public AppMobileClinicController(AppClinicService appClinicService) {
        this.appClinicService = appClinicService;
    }

    @RequestMapping(value = "/Clinic/FindByOrgNum.do",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<AppMobileClinicBean> FindByOrgNum(@RequestParam("token") String token,
                                                          @RequestParam("orgNum") String orgNum) {
        ResponseBean<AppMobileClinicBean> responseBean = new ResponseBean<AppMobileClinicBean>();
        RetData<AppMobileClinicBean> retData = new RetData<AppMobileClinicBean>();
        //验证Token合法性
        if (!appClinicService.IsLoginToken(token)) {
            responseBean.setState(200);
            responseBean.setMessage("Token无效,拒绝访问");
            return responseBean;
        }
        //获取诊所信息
        AppMobileClinicBean clinicBean = appClinicService.GetClinicDetail(orgNum);
        //添加到查询结果集
        List<AppMobileClinicBean> clinicBeanList = new ArrayList<AppMobileClinicBean>();
        clinicBeanList.add(clinicBean);

        //判断是否存在查询结果
        if (clinicBeanList.size() != 0) {
            responseBean.setState(100);
            responseBean.setMessage("查询成功");
            retData.setListData(clinicBeanList);
            responseBean.setRetData(retData);
            return responseBean;
        }
        //查询结果不存在
        responseBean.setState(200);
        responseBean.setMessage("查询失败,诊所组织号有误");
        return responseBean;
    }

    @RequestMapping(value = "/Clinic/FindAllClinic.do",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<AppMobileClinicBean> FindAllClinic(@RequestParam("token") String token) {
        ResponseBean<AppMobileClinicBean> responseBean = new ResponseBean<AppMobileClinicBean>();
        RetData<AppMobileClinicBean> retData = new RetData<AppMobileClinicBean>();
        //验证Token合法性
        if (!appClinicService.IsLoginToken(token)) {
            responseBean.setState(200);
            responseBean.setMessage("Token无效,拒绝访问");
            return responseBean;
        }
        //获取诊所信息,并添加到查询结果集
        List<AppMobileClinicBean> clinicList = appClinicService.GetClinicList();
        //是否成功查询出结果
        if (clinicList.size() == 0 ) {
            responseBean.setState(200);
            responseBean.setMessage("没有发现诊所");
        } else {
            responseBean.setState(100);
            responseBean.setMessage("查询成功,返回诊所数据");
            retData.setListData(clinicList);
            responseBean.setRetData(retData);
        }
        return responseBean;
    }

    @RequestMapping(value = "/Clinic/FindStarClinicByName.do",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<AppMobileClinicAppendixBean> FindStarClinicByName(@RequestParam("token") String token,
                                                                          @RequestParam("organizationNumber") String organizationNumber) {
        ResponseBean<AppMobileClinicAppendixBean> responseBean = new ResponseBean<AppMobileClinicAppendixBean>();
        RetData<AppMobileClinicAppendixBean> retData = new RetData<AppMobileClinicAppendixBean>();

        //验证Token合法性
        if (!appClinicService.IsLoginToken(token)) {
            responseBean.setState(200);
            responseBean.setMessage("Token无效,拒绝访问");
            return responseBean;
        }
        //判断查询结果
        AppMobileClinicAppendixBean clinicAppendixBean = appClinicService.FindStarClinicByOrgName(organizationNumber);
        if (clinicAppendixBean != null) {
            //查询到数据,返回结果
            responseBean.setState(100);
            responseBean.setMessage("查询成功,返回明星诊所信息");
            List<AppMobileClinicAppendixBean> resList = new ArrayList<AppMobileClinicAppendixBean>();
            resList.add(clinicAppendixBean);
            retData.setListData(resList);
            responseBean.setRetData(retData);
        } else {
            //查询结果为空
            responseBean.setState(200);
            responseBean.setMessage("查询失败,组织号不正确");
        }
        return responseBean;
    }

    @RequestMapping(value = "/Clinic/FindAllStarClinic.do",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<AppMobileClinicAppendixBean> FindAllStarClinic(@RequestParam("token") String token) {
        ResponseBean<AppMobileClinicAppendixBean> responseBean = new ResponseBean<AppMobileClinicAppendixBean>();
        RetData<AppMobileClinicAppendixBean> retData = new RetData<AppMobileClinicAppendixBean>();

        //验证Token合法性
        if (!appClinicService.IsLoginToken(token)) {
            responseBean.setState(200);
            responseBean.setMessage("Token无效,拒绝访问");
            return responseBean;
        }
        //返回成功
        List<AppMobileClinicAppendixBean> resList = appClinicService.GetStarClinicList();
        if (resList.size() == 0) {
            responseBean.setState(200);
            responseBean.setMessage("查询失败,没有发现任何明星诊所");
        }
        //将结果数据集合放到retData中
        retData.setListData(resList);
        responseBean.setRetData(retData);
        responseBean.setState(100);
        responseBean.setMessage("查询成功,返回所有明星诊所数据");

        return responseBean;
    }
}
