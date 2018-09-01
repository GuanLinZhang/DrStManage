package cn.drst.controller;

import cn.drst.base.RetData;
import cn.drst.bean.*;
import cn.drst.bean.AppClinicBean;
import cn.drst.entity.Clinic;
import cn.drst.entity.DataSource;
import cn.drst.service.ClinicService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ClinicController {

    private final ClinicService clinicService;

    @Autowired
    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }


    //诊所机构登录验证，查询【Clinic】和【DataSource】表，验证机构是否存在,如果存在返回机构信息
    @RequestMapping(value = "/LoginByOrganizationNumber.do", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<AppClinicBean> findClinic(@RequestParam("organization_number") String organization_number, @RequestParam("token") String token, HttpSession session) {
       session.setAttribute("organization_number",organization_number);
        //根据机构号查询出机构clinic对象
        Clinic clinic = clinicService.findClinicDetail(organization_number);
        //新建一个返回实体
        ResponseBean<AppClinicBean> responseBean = new ResponseBean<AppClinicBean>();
        //如果查询出机构存在
        if (clinic != null) {
            RetData<AppClinicBean> rd = new RetData<AppClinicBean>();
            List<AppClinicBean> list = new ArrayList<AppClinicBean>();
            //新建返回实体内所需的对象
            AppClinicBean clinicInfo = new AppClinicBean();
            //返回对象内set查询出的值
            clinicInfo.setOrganizationNumber(clinic.getOrganizationNumber());
            clinicInfo.setAddress(clinic.getClinicAddress());
            clinicInfo.setName(clinic.getClinicName());
            //日期格式把createDate格式转成字符串格式
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String tsStr = sdf.format(clinic.getCreateDate());
            clinicInfo.setState(String.valueOf(clinic.getClinicState()));
            clinicInfo.setDate(tsStr);
            DataSource dataSource = clinicService.findDataSource(organization_number);
            clinicInfo.setDataBaseName(dataSource.getDataBaseName());
            clinicInfo.setDriverClass(dataSource.getDriverClass());
            clinicInfo.setJdbcUrl(dataSource.getJdbcUrl());
            clinicInfo.setPassword(dataSource.getPassword());
            clinicInfo.setUserName(dataSource.getUserName());
            //把封装好的对象加入list集合
            list.add(clinicInfo);
            //把list集合传入RetData对象
            rd.setListData(list);
            responseBean.setRetData(rd);
            responseBean.setState(100);
            responseBean.setMessage("成功");
        } else {
            //没有查询到该机构
            responseBean.setState(200);
            responseBean.setMessage("检索的数据不存在");

        }
        return responseBean;
    }

    @RequestMapping(value = "/FindOrganizationDetail.do", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<AppClinicBean> findClinicDetail(HttpSession session) {
        ResponseBean<AppClinicBean> responseBean = new ResponseBean<AppClinicBean>();
        Clinic clinic = clinicService.findClinicDetail((String) session.getAttribute("num"));
        AppClinicBean clinicInfo = new AppClinicBean();
        clinicInfo.setOrganizationNumber(clinic.getOrganizationNumber());
        clinicInfo.setAddress(clinic.getClinicAddress());
        clinicInfo.setName(clinic.getClinicName());
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String tsStr = sdf.format(clinic.getCreateDate());
        clinicInfo.setState(String.valueOf(clinic.getClinicState()));
        clinicInfo.setDate(tsStr);
        DataSource dataSource = clinicService.findDataSource("796314635052");
        clinicInfo.setDataBaseName(dataSource.getDataBaseName());
        clinicInfo.setDriverClass(dataSource.getDriverClass());
        clinicInfo.setJdbcUrl(dataSource.getJdbcUrl());
        clinicInfo.setPassword(dataSource.getPassword());
        clinicInfo.setUserName(dataSource.getUserName());
        responseBean.setState(100);
        responseBean.setMessage("成功");
        RetData<AppClinicBean> rdu = new RetData<AppClinicBean>();
        rdu.setListData((List<AppClinicBean>) clinicInfo);
        responseBean.setRetData(rdu);
        return responseBean;



    }

    @RequestMapping(value = "/SaveClinic.do", method = RequestMethod.POST)

    public void saveClinic(String num, String name, String address) {
        //System.out.println(num+name+date+address);
        ClinicBean cb = new ClinicBean();
        cb.setOrgnazationNumber(num);
        cb.setName(name);
        cb.setAddress(address);

        clinicService.saveClinic(cb);
/*  String num = request.getParameter("num");
        request.getParameter("name");
        //request.getParameter("state");
        request.getParameter("address");
        request.getParameter("date");
        ClinicBean clinicBean = new ClinicBean();*/

    }

    @RequestMapping(value = "/UpdateClinic.do", method = RequestMethod.POST)
    @ResponseBody
    public void updateClinic(@RequestBody ClinicBean clinicBean) {
        System.out.println("==================");
        ;
        clinicService.updateClinic(clinicBean);
    }

    @RequestMapping(value = "/DeleteClinic.do", method = RequestMethod.POST)
    @ResponseBody
    public String deleteClinic(@RequestBody ClinicBean clinicBean) {
        System.out.println("==================");

        Integer flag = clinicService.deleteClinic(clinicBean);
        if (flag == 1) {
            return "1";
        } else {
            return "0";
        }
    }
}
