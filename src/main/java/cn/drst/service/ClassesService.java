package cn.drst.service;

import cn.drst.bean.ArrangeClassesBean;
import cn.drst.bean.ClassesBean;
import cn.drst.bean.ClassesDateBean;
import cn.drst.bean.UserClassesBean;
import cn.drst.dao.*;
import cn.drst.entity.*;
import cn.drst.util.DateUtil;
import cn.drst.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ClassesService {

    private final UserDao userDao;
    private final ClassesDao classesDao;
    private final ArrangeClassesDao arrangeClassesDao;
    private final ReviseClassesDateDao reviseClassesDateDao;

    @Autowired
    public ClassesService(UserDao userDao, ClassesDao classesDao, ArrangeClassesDao arrangeClassesDao, ReviseClassesDateDao reviseClassesDateDao) {
        this.userDao = userDao;
        this.classesDao = classesDao;
        this.arrangeClassesDao = arrangeClassesDao;
        this.reviseClassesDateDao = reviseClassesDateDao;
    }

    // 取得本周日期标题及列表头日期信息
    public ClassesDateBean getClassesDateOfThisWeek(){
        ClassesDateBean cdb = new ClassesDateBean();
        cdb.setBeginYear(DateUtil.getMondayYearOfThisWeek());
        cdb.setEndYear(DateUtil.getSundayYearOfThisWeek());
        cdb.setBeginMonthDay(DateUtil.getMondayMonthDayOfThisWeek());
        cdb.setEndMonthDay(DateUtil.getSundayMonthDayOfThisWeek());
        List<String> listMonthDay = DateUtil.getMonthDayOfThisWeek();
        cdb.setMondayDate(listMonthDay.get(0));
        cdb.setTuesdayDate(listMonthDay.get(1));
        cdb.setWednesdayDate(listMonthDay.get(2));
        cdb.setThursdayDate(listMonthDay.get(3));
        cdb.setFridayDate(listMonthDay.get(4));
        cdb.setSaturdayDate(listMonthDay.get(5));
        cdb.setSundayDate(listMonthDay.get(6));
        return cdb;
    }

    // 取得本周排班列表
    public ArrangeClassesBean getArrangeUserClasses() {
        // 返回值
        ArrangeClassesBean acb = new ArrangeClassesBean();

        // 查询班次表
        Map<String, Integer> classesOrdersMap = new HashMap<String, Integer>();
        classesOrdersMap.put("classesId", 1);
        List<Classes> listClasses = classesDao.findByConditions(new HashMap<String, Object>(), classesOrdersMap);
        List<String> listValue = new ArrayList<String>();
        List<String> listText = new ArrayList<String>();
        if (listClasses.size() > 0) {
            listValue.add("C0000");
            listText.add("");
            for (Classes c : listClasses) {
                listValue.add(c.getClassesId());
                listText.add(c.getClassesName());
            }
        } else {
            listValue.add("C0000");
            listText.add("");
        }
        ClassesBean cb = new ClassesBean();
        cb.setClassesValue(listValue);
        cb.setClassesText(listText);

        // 填装数据
        acb.setClasses(cb);

        List<UserClassesBean> listUserClassesBean = new ArrayList<UserClassesBean>();
        // 查询排班表
        Map<String, Integer> ordersMap = new HashMap<String, Integer>();
        ordersMap.put("userId", 1);
        List<ArrangeClasses> listArrangeClasses = arrangeClassesDao.findByConditions(new HashMap<String, Object>(), ordersMap);
        // 排班表如果没有值说明系统首次排班，通过人员表的查询做出新的排班表
        if (listArrangeClasses.size() == 0) {
            // 查询人员表
            List<User> listUser = userDao.findByConditions(new HashMap<String, Object>(), ordersMap);
            for (User u : listUser) {
                UserClassesBean ucb = new UserClassesBean();
                ucb.setUserId(u.getUserId());
                ucb.setImgUrl("");
                ucb.setName(u.getName());
                ucb.setMondayValue("");
                ucb.setThursdayValue("");
                ucb.setWednesdayValue("");
                ucb.setTuesdayValue("");
                ucb.setFridayValue("");
                ucb.setSaturdayValue("");
                ucb.setSundayValue("");
                listUserClassesBean.add(ucb);
            }
            // 填装数据
            acb.setUserClasses(listUserClassesBean);
        } else { // 排班表有值说明系统已经进行过排班，与人员表的查询比对做出新的排班表

            int i = 0;
            // 现有人员排班表导出
            for (ArrangeClasses ac : listArrangeClasses) {
                UserClassesBean ucb = new UserClassesBean();
                User user =  userDao.findByPKey(ac.getUserId());
                if(user != null){
                    ucb.setUserId(user.getUserId());
                    ucb.setImgUrl("");
                    ucb.setName(user.getName());
                }
                ucb.setMondayValue(ac.getMonday());
                ucb.setThursdayValue(ac.getTuesday());
                ucb.setWednesdayValue(ac.getWednesday());
                ucb.setTuesdayValue(ac.getTuesday());
                ucb.setFridayValue(ac.getFriday());
                ucb.setSaturdayValue(ac.getSaturday());
                ucb.setSundayValue(ac.getSunday());
                listUserClassesBean.add(ucb);
                i++;
            }
            List<User> listUser = userDao.findByConditions(new HashMap<String, Object>(), ordersMap);
            // 新增人员排班表做成
            for(int j = i; j < listUser.size(); j++){
                UserClassesBean ucb = new UserClassesBean();
                ucb.setUserId(listUser.get(j).getUserId());
                ucb.setImgUrl("");
                ucb.setName(listUser.get(j).getName());
                ucb.setMondayValue("");
                ucb.setThursdayValue("");
                ucb.setWednesdayValue("");
                ucb.setTuesdayValue("");
                ucb.setFridayValue("");
                ucb.setSaturdayValue("");
                ucb.setSundayValue("");
                listUserClassesBean.add(ucb);
            }
            // 填装数据
            acb.setUserClasses(listUserClassesBean);
        }
        return acb;
    }

    // 新建班次
    public void createClasses(Classes classes){
        String maxColumn = classesDao.findMaxColumn("classesId");
        String classesId = NumberUtil.addNumberOne(maxColumn, "C");
        classes.setClassesId(classesId);
        classesDao.save(classes);
    }

    // 保存排班
    public void saveArrangeClasses(List<ArrangeClasses> list){
        for(ArrangeClasses ac : list){
            ArrangeClasses fac = arrangeClassesDao.findByPKey(ac.getUserId());
            if(fac == null){
                arrangeClassesDao.save(ac);
                for(int i = 0; i < 7; i++){
                    ReviseClassesDate rcd = new ReviseClassesDate();
                    rcd.setUserId(ac.getUserId());
                    rcd.setWeekId(i + 1);
                    switch (i){
                        case 0:
                            rcd.setClassesId(ac.getMonday());
                            break;
                        case 1:
                            rcd.setClassesId(ac.getTuesday());
                            break;
                        case 2:
                            rcd.setClassesId(ac.getWednesday());
                            break;
                        case 3:
                            rcd.setClassesId(ac.getThursday());
                            break;
                        case 4:
                            rcd.setClassesId(ac.getFriday());
                            break;
                        case 5:
                            rcd.setClassesId(ac.getSaturday());
                            break;
                        case 6:
                            rcd.setClassesId(ac.getSunday());
                            break;
                    }
                    Date sqlDate = new Date(DateUtil.getSystemDateToDate().getTime());
                    rcd.setReviseDate(sqlDate);
                    reviseClassesDateDao.save(rcd);
                }
            }else{
                arrangeClassesDao.evict(fac);
                arrangeClassesDao.update(ac);
                if(!ac.getMonday().equals(fac.getMonday())){
                    ReviseClassesDate rcd = new ReviseClassesDate();
                    rcd.setUserId(ac.getUserId());
                    rcd.setWeekId(1);
                    rcd.setClassesId(ac.getMonday());
                    Date sqlDate = new Date(DateUtil.getSystemDateToDate().getTime());
                    rcd.setReviseDate(sqlDate);
                    reviseClassesDateDao.save(rcd);
                }
                if(!ac.getTuesday().equals(fac.getTuesday())){
                    ReviseClassesDate rcd = new ReviseClassesDate();
                    rcd.setUserId(ac.getUserId());
                    rcd.setWeekId(2);
                    rcd.setClassesId(ac.getTuesday());
                    Date sqlDate = new Date(DateUtil.getSystemDateToDate().getTime());
                    rcd.setReviseDate(sqlDate);
                    reviseClassesDateDao.save(rcd);
                }
                if(!ac.getWednesday().equals(fac.getWednesday())){
                    ReviseClassesDate rcd = new ReviseClassesDate();
                    rcd.setUserId(ac.getUserId());
                    rcd.setWeekId(3);
                    rcd.setClassesId(ac.getWednesday());
                    Date sqlDate = new Date(DateUtil.getSystemDateToDate().getTime());
                    rcd.setReviseDate(sqlDate);
                    reviseClassesDateDao.save(rcd);
                }
                if(!ac.getThursday().equals(fac.getThursday())){
                    ReviseClassesDate rcd = new ReviseClassesDate();
                    rcd.setUserId(ac.getUserId());
                    rcd.setWeekId(4);
                    rcd.setClassesId(ac.getThursday());
                    Date sqlDate = new Date(DateUtil.getSystemDateToDate().getTime());
                    rcd.setReviseDate(sqlDate);
                    reviseClassesDateDao.save(rcd);
                }
                if(!ac.getFriday().equals(fac.getFriday())){
                    ReviseClassesDate rcd = new ReviseClassesDate();
                    rcd.setUserId(ac.getUserId());
                    rcd.setWeekId(5);
                    rcd.setClassesId(ac.getFriday());
                    Date sqlDate = new Date(DateUtil.getSystemDateToDate().getTime());
                    rcd.setReviseDate(sqlDate);
                    reviseClassesDateDao.save(rcd);
                }
                if(!ac.getSaturday().equals(fac.getSaturday())){
                    ReviseClassesDate rcd = new ReviseClassesDate();
                    rcd.setUserId(ac.getUserId());
                    rcd.setWeekId(6);
                    rcd.setClassesId(ac.getSaturday());
                    Date sqlDate = new Date(DateUtil.getSystemDateToDate().getTime());
                    rcd.setReviseDate(sqlDate);
                    reviseClassesDateDao.save(rcd);
                }
                if(!ac.getSunday().equals(fac.getSunday())){
                    ReviseClassesDate rcd = new ReviseClassesDate();
                    rcd.setUserId(ac.getUserId());
                    rcd.setWeekId(7);
                    rcd.setClassesId(ac.getSunday());
                    Date sqlDate = new Date(DateUtil.getSystemDateToDate().getTime());
                    rcd.setReviseDate(sqlDate);
                    reviseClassesDateDao.save(rcd);
                }
            }
        }
    }

    // 改变科室取得人员排班
    public ArrangeClassesBean getUserClassesChangeDepartment(String departmentId){
        // 返回值
        ArrangeClassesBean acb = new ArrangeClassesBean();
        // 查询班次表
        Map<String, Integer> classesOrdersMap = new HashMap<String, Integer>();
        classesOrdersMap.put("classesId", 1);
        List<Classes> listClasses = classesDao.findByConditions(new HashMap<String, Object>(), classesOrdersMap);
        List<String> listValue = new ArrayList<String>();
        List<String> listText = new ArrayList<String>();
        if (listClasses.size() > 0) {
            listValue.add("C0000");
            listText.add("");
            for (Classes c : listClasses) {
                listValue.add(c.getClassesId());
                listText.add(c.getClassesName());
            }
        } else {
            listValue.add("C0000");
            listText.add("");
        }
        ClassesBean cb = new ClassesBean();
        cb.setClassesValue(listValue);
        cb.setClassesText(listText);
        // 填装数据
        acb.setClasses(cb);

        List<UserClassesBean> listUserClassesBean = new ArrayList<UserClassesBean>();
        // 查询排班表
        Map<String, Integer> ordersMap = new HashMap<String, Integer>();
        ordersMap.put("userId", 1);
        List<ArrangeClasses> listArrangeClasses = new ArrayList<ArrangeClasses>();
        if(departmentId.equals("")){
            listArrangeClasses = arrangeClassesDao.findByConditions(new HashMap<String, Object>(), ordersMap);
        }else{
            String sql = "select a.* from ArrangeClasses a JOIN User u ON a.UserId = u.UserId JOIN Department d ON d.DepartmentId = '" + departmentId + "' AND d.DepartmentId = u.DepartmentId ORDER BY a.UserId ASC;";
            listArrangeClasses = arrangeClassesDao.findTablesBySql(sql);
        }
        // 排班表如果没有值说明系统首次排班，通过人员表的查询做出新的排班表
        if (listArrangeClasses.size() == 0) {
            // 查询人员表
            List<User> listUser = userDao.findByConditions(new HashMap<String, Object>(), ordersMap);
            for (User u : listUser) {
                UserClassesBean ucb = new UserClassesBean();
                ucb.setUserId(u.getUserId());
                ucb.setImgUrl("");
                ucb.setName(u.getName());
                ucb.setMondayValue("");
                ucb.setThursdayValue("");
                ucb.setWednesdayValue("");
                ucb.setTuesdayValue("");
                ucb.setFridayValue("");
                ucb.setSaturdayValue("");
                ucb.setSundayValue("");
                listUserClassesBean.add(ucb);
            }
            // 填装数据
            acb.setUserClasses(listUserClassesBean);
        } else { // 排班表有值说明系统已经进行过排班，与人员表的查询比对做出新的排班表
            int i = 0;
            // 现有人员排班表导出
            for (ArrangeClasses ac : listArrangeClasses) {
                UserClassesBean ucb = new UserClassesBean();
                User user =  userDao.findByPKey(ac.getUserId());
                if(user != null){
                    ucb.setUserId(user.getUserId());
                    ucb.setImgUrl("");
                    ucb.setName(user.getName());
                }
                ucb.setMondayValue(ac.getMonday());
                ucb.setThursdayValue(ac.getTuesday());
                ucb.setWednesdayValue(ac.getWednesday());
                ucb.setTuesdayValue(ac.getTuesday());
                ucb.setFridayValue(ac.getFriday());
                ucb.setSaturdayValue(ac.getSaturday());
                ucb.setSundayValue(ac.getSunday());
                listUserClassesBean.add(ucb);
                i++;
            }
            List<User> listUser = new ArrayList<User>();
            if(departmentId.equals("")){
                listUser = userDao.findByConditions(new HashMap<String, Object>(), ordersMap);
            }else{
                String sql = "SELECT u.* from User u JOIN Department d ON d.DepartmentId = '" + departmentId + "' AND d.DepartmentId = u.DepartmentId ORDER BY u.UserId ASC;";
                listUser = userDao.findTablesBySql(sql);
            }
            // 新增人员排班表做成
            for(int j = i; j < listUser.size(); j++){
                UserClassesBean ucb = new UserClassesBean();
                ucb.setUserId(listUser.get(j).getUserId());
                ucb.setImgUrl("");
                ucb.setName(listUser.get(j).getName());
                ucb.setMondayValue("");
                ucb.setThursdayValue("");
                ucb.setWednesdayValue("");
                ucb.setTuesdayValue("");
                ucb.setFridayValue("");
                ucb.setSaturdayValue("");
                ucb.setSundayValue("");
                listUserClassesBean.add(ucb);
            }
            // 填装数据
            acb.setUserClasses(listUserClassesBean);
        }
        return acb;
    }

}
