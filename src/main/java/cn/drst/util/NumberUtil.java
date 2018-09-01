package cn.drst.util;

import java.util.Random;

public class NumberUtil {

    //生成随机数
    public static String getRandomNumber(int num) {
        Random rand = new Random();//生成随机数
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < num; i++) {
            number.append(rand.nextInt(10));//生成num位数字
        }
        return number.toString();
    }

    // 自增1
    public static String addNumberOne(String pKey, String dbKey) {
        String newKey;
        if (pKey == null) {
            newKey = dbKey + "0001";
        } else {
            pKey = pKey.substring(pKey.length() - 4, pKey.length());
            int num = Integer.parseInt(pKey);
            num = num + 1;
            String str = String.format("%04d", num);
            newKey = dbKey + str;
        }
        return newKey;
    }

}
