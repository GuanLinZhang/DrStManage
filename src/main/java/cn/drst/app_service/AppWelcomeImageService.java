package cn.drst.app_service;

import cn.drst.dao.MobileManageImagesDao;
import cn.drst.dao.MobileTokenDao;
import cn.drst.entity.MobileManageImages;
import cn.drst.entity.MobileToken;
import cn.drst.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AppWelcomeImageService {

    private final MobileTokenDao mobileTokenDao;
    private final MobileManageImagesDao mobileManageImagesDao;

    @Autowired
    public AppWelcomeImageService(MobileTokenDao mobileTokenDao, MobileManageImagesDao mobileManageImagesDao) {
        this.mobileTokenDao = mobileTokenDao;
        this.mobileManageImagesDao = mobileManageImagesDao;
    }


    public void insertToken(String t, String l) {
        MobileToken mt = new MobileToken();
        mt.setTemporaryToken(t);
        mt.setLoginToken(l);
        Timestamp timestamp = Timestamp.valueOf(DateUtil.getAllSystemDateToString());
        mt.setCreateTime(timestamp);
        mobileTokenDao.save(mt);
    }

    public String getImage() {
        String ImgUrl = "";
        Map<String, Object> conditionsMap = new HashMap<String, Object>();
        conditionsMap.put("type", 1);
        List<MobileManageImages> list = mobileManageImagesDao.findByConditions(conditionsMap);
        if(list.size() > 0){
            ImgUrl = list.get(0).getUrl();
        }
        return ImgUrl;
    }
}

