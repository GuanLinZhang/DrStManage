package cn.drst.service;

import cn.drst.bean.ClinicBean;
import cn.drst.dao.ClinicDao;
import cn.drst.dao.DataSourceDao;
import cn.drst.db.DynamicDataSource;
import cn.drst.entity.Clinic;
import cn.drst.entity.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.sql.Timestamp;

@Service
@Transactional
public class ClinicService {

    private final ClinicDao clinicDao;
    private final DataSourceDao dataSourceDao;
    private final DynamicDataSource dynamicDataSource;

    @Autowired
    public ClinicService(ClinicDao clinicDao, DataSourceDao dataSourceDao, DynamicDataSource dynamicDataSource) {
        this.clinicDao = clinicDao;
        this.dataSourceDao = dataSourceDao;
        this.dynamicDataSource = dynamicDataSource;
    }


    public int findClinic(String organizationNumber) {
        /*  Map<String,Object> map = new HashMap<String, Object>();
       map.put("organizationNumber",organizationNumber);
        List<Clinic> list = clinicDao.findByConditions(map);*/
       Clinic clinic = clinicDao.findByPKey(organizationNumber);
        if(clinic!=null){
            return 1;

        }else {
            return 0;
        }
    }

   /*public Clinic findClinicDetail(Clinic clinic) {
        String num = clinic.getOrganizationNumber();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("organizationNumber",num);
        List<Clinic> list = clinicDao.findByConditions(map);
        if(list.size()==0){
            return null;
        }else {
            return list.get(0);
        }
    }*/

    public Clinic findClinicDetail(String num) {

        return clinicDao.findByPKey(num);

    }

    public void saveClinic(ClinicBean cb) {
        Clinic clinic = new Clinic();
        Date date = new Date();
        clinic.setOrganizationNumber(cb.getOrgnazationNumber());
        clinic.setClinicName(cb.getName());
        clinic.setClinicAddress(cb.getAddress());
        clinic.setCreateDate(new Timestamp(date.getTime()));
        clinic.setClinicState(1);
        clinicDao.save(clinic);


       /* // 创建格式化对象
        // SimpleDateFormat sdf = new SimpleDateFormat();
        // 给定模式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        // public final String format(Date date)
        String s = sdf.format(d);
        System.out.println(s);


        //String -- Date
        String str = "2008-08-08 12:12:12";
        //在把一个字符串解析为日期的时候，请注意格式必须和给定的字符串格式匹配
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dd = sdf2.parse(str);*/
    }

    public void  updateClinic(ClinicBean clinicBean) {
        Clinic clinic = clinicDao.findByPKey(clinicBean.getOrgnazationNumber());
        clinic.setClinicName(clinicBean.getName());
        clinic.setClinicState(Integer.parseInt(clinicBean.getState()));
        clinic.setClinicAddress(clinicBean.getAddress());
    }

    public int deleteClinic(ClinicBean clinicBean) {
        Clinic clinic = clinicDao.findByPKey(clinicBean.getOrgnazationNumber());
        if(clinic == null){
            return 0;
        }else {
            clinicDao.delete(clinicBean.getOrgnazationNumber());
        }
        return 1;
    }

    public DataSource findDataSource(String num) {
        String pKey = "dataSource_"+num;
        DataSource dataSource = dataSourceDao.findByPKey(pKey);
        return dataSource;
    }
}
