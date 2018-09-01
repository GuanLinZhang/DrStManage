package cn.drst.controller;

import cn.drst.base.NullData;
import cn.drst.base.RetData;
import cn.drst.bean.ArrangeClassesBean;
import cn.drst.bean.ClassesDateBean;
import cn.drst.bean.DepartmentBean;
import cn.drst.bean.ResponseBean;
import cn.drst.db.DBContextHolder;
import cn.drst.entity.ArrangeClasses;
import cn.drst.entity.Classes;
import cn.drst.entity.Department;
import cn.drst.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ClassesController {

    private final ClassesService classesService;

    @Autowired
    public ClassesController(ClassesService classesService) {
        this.classesService = classesService;
    }

    // 取得本周日期标题及列表头日期信息
    @RequestMapping(value = "/GetThisWeek.do", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<ClassesDateBean> getThisWeek(HttpSession httpSession){
        // 返回结果设置
        ResponseBean<ClassesDateBean> rb = new ResponseBean<ClassesDateBean>();
        // 切换数据源
        String sourceId = (String)httpSession.getAttribute("SourceId");
        if(sourceId == null || sourceId.equals("")){
            rb.setState(-101);
            rb.setMessage("系统错误");
            return rb;
        }
        DBContextHolder.setDataSource(sourceId);
        List<ClassesDateBean> listClassesDateBean = new ArrayList<ClassesDateBean>();
        ClassesDateBean cdb = classesService.getClassesDateOfThisWeek();
        listClassesDateBean.add(cdb);
        RetData<ClassesDateBean> rdu = new RetData<ClassesDateBean>();
        rdu.setListData(listClassesDateBean);
        rb.setState(100);
        rb.setMessage("成功");
        rb.setRetData(rdu);
        return rb;
    }

    // 取得本周排班列表
    @RequestMapping(value = "/GetThisWeekUserClasses.do", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<ArrangeClassesBean> getThisWeekUserClasses(HttpSession httpSession){
        // 返回结果设置
        ResponseBean<ArrangeClassesBean> rb = new ResponseBean<ArrangeClassesBean>();
        // 切换数据源
        String sourceId = (String)httpSession.getAttribute("SourceId");
        if(sourceId == null || sourceId.equals("")){
            rb.setState(-101);
            rb.setMessage("系统错误");
            return rb;
        }
        DBContextHolder.setDataSource(sourceId);
        // 取得本周排班列表
        ArrangeClassesBean acb = classesService.getArrangeUserClasses();
        List<ArrangeClassesBean> listArrangeClassesBean = new ArrayList<ArrangeClassesBean>();
        listArrangeClassesBean.add(acb);
        RetData<ArrangeClassesBean> rdu = new RetData<ArrangeClassesBean>();
        rdu.setListData(listArrangeClassesBean);
        rb.setState(100);
        rb.setMessage("成功");
        rb.setRetData(rdu);
        return rb;
    }

    // 新建班次
    @RequestMapping(value = "/CreateClasses.do", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<NullData> CreateClasses(@RequestBody Classes classes, HttpSession httpSession){
        // 返回结果设置
        ResponseBean<NullData> rb = new ResponseBean<NullData>();
        // 切换数据源
        String sourceId = (String)httpSession.getAttribute("SourceId");
        if(sourceId == null || sourceId.equals("")){
            rb.setState(-101);
            rb.setMessage("系统错误");
            return rb;
        }
        DBContextHolder.setDataSource(sourceId);
        // 新建班次
        classesService.createClasses(classes);
        rb.setState(100);
        rb.setMessage("成功");
        return rb;
    }

    // 保存排班
    @RequestMapping(value = "/SaveArrangeClasses.do", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<NullData> saveArrangeClasses(@RequestBody List<ArrangeClasses> list, HttpSession httpSession){
        // 返回结果设置
        ResponseBean<NullData> rb = new ResponseBean<NullData>();
        // 切换数据源
        String sourceId = (String)httpSession.getAttribute("SourceId");
        if(sourceId == null || sourceId.equals("")){
            rb.setState(-101);
            rb.setMessage("系统错误");
            return rb;
        }
        DBContextHolder.setDataSource(sourceId);
        // 保存排班
        classesService.saveArrangeClasses(list);
        rb.setState(100);
        rb.setMessage("成功");
        return rb;
    }

    // 改变科室取得人员排班
    @RequestMapping(value = "/GetUserClassesChangeDepartment.do", method = RequestMethod.POST)
    @ResponseBody
    public ResponseBean<ArrangeClassesBean> getUserClassesChangeDepartment(@RequestParam("departmentId") String departmentId,
                                                                           HttpSession httpSession){
        // 返回结果设置
        ResponseBean<ArrangeClassesBean> rb = new ResponseBean<ArrangeClassesBean>();
        // 切换数据源
        String sourceId = (String)httpSession.getAttribute("SourceId");
        if(sourceId == null || sourceId.equals("")){
            rb.setState(-101);
            rb.setMessage("系统错误");
            return rb;
        }
        DBContextHolder.setDataSource(sourceId);
        // 取得本周排班列表
        ArrangeClassesBean acb = classesService.getUserClassesChangeDepartment(departmentId);
        List<ArrangeClassesBean> listArrangeClassesBean = new ArrayList<ArrangeClassesBean>();
        listArrangeClassesBean.add(acb);
        RetData<ArrangeClassesBean> rdu = new RetData<ArrangeClassesBean>();
        rdu.setListData(listArrangeClassesBean);
        rb.setState(100);
        rb.setMessage("成功");
        rb.setRetData(rdu);
        return rb;
    }
}
