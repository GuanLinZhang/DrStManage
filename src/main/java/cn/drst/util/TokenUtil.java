package cn.drst.util;

import cn.drst.dao.MobileTokenDao;

import java.util.*;

public class TokenUtil {

    private static MobileTokenDao mobileTokenDao;

    //通过token的值获取登陆状态
    public static String getLoginStatus(String token){
        return null;
    }

    //生成32位UUID验证码
    public static List<String> GetUUID() {
        List<String> tokens = new ArrayList<String>();
        tokens.add(UUID.randomUUID().toString().replace("-",""));
        tokens.add(UUID.randomUUID().toString().replace("-",""));
        return tokens;
    }

}
