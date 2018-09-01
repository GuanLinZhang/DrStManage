package cn.drst.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

    // 取得系统字符串类型的日期
    public static String getAllSystemDateToString(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return sdf.format(date);
    }

    // 取得系统字符串类型的日期
    public static String getSystemDateToString(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        return sdf.format(date);
    }

    // 取得系统日期类型的日期
    public static Date getSystemDateToDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String strDate = sdf.format(date);
        Date d = null;
        try {
            d = sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    // 得到本周周日 yyy年类型
    public static String getMondayYearOfThisWeek() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年");
        return sdf.format(getMondayOfThisWeek().getTime());
    }

    // 得到本周周日 yyy年类型
    public static String getSundayYearOfThisWeek() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年");
        return sdf.format(getSundayOfThisWeek().getTime());
    }

    // 得到本周周一 MM月dd日类型
    public static String getMondayMonthDayOfThisWeek() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
        return sdf.format(getMondayOfThisWeek().getTime());
    }

    // 得到本周周日 MM月dd日类型
    public static String getSundayMonthDayOfThisWeek() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
        return sdf.format(getSundayOfThisWeek().getTime());
    }

    // 取得本周所有日期 MM月dd日类型
    public static List<String> getMonthDayOfThisWeek(){
        SimpleDateFormat sdfDate = new SimpleDateFormat("MM/dd");
        SimpleDateFormat sdfWeek = new SimpleDateFormat("E");
        List<String> listMonthDay = new ArrayList<String>();
        Calendar c = Calendar.getInstance();
        while (c.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            c.add(Calendar.DATE, -1);
        }
        for (int i = 0; i < 7; i++) {
            listMonthDay.add(sdfWeek.format(c.getTime()) + " " + sdfDate.format(c.getTime()));
            c.add(Calendar.DATE, 1);
        }
        return listMonthDay;
    }


    // 得到本周周一的Calendar类型
    private static Calendar getMondayOfThisWeek(){
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0){
            day_of_week = 7;
        }
        c.add(Calendar.DATE, -day_of_week + 1);
        return c;
    }

    // 得到本周周日的Calendar类型
    private static Calendar getSundayOfThisWeek(){
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0){
            day_of_week = 7;
        }
        c.add(Calendar.DATE, -day_of_week + 7);
        return c;
    }


}
