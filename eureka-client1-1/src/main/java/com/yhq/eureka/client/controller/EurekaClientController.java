package com.yhq.eureka.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @author HuaQi.Yang
 * @date 2017年6月29日
 */
@RestController
@RequestMapping("/eureka/client/1/")
public class EurekaClientController {
    @RequestMapping("hello")
    public String home() {
        return "Hello world 1-1";
    }

    static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static final int INIT_MONTH = 8;
    static final int INIT_DAY = 1;
    static final int INIT_HOUR = 0;
    static final int INIT_MINUTE = 0;
    static final int INIT_SECOND = 0;

    public static class TimeVo {
        public final Calendar calendar;
        public final long timeMili;

        public TimeVo(Calendar calendar, long timeMili) {
            this.calendar = calendar;
            this.timeMili = timeMili;
        }

        public static TimeVo getInstance(int year, int month, int day, int hour, int minute, int second) {
            GregorianCalendar calendar = new GregorianCalendar();
            Date date = new Date(0L);
            calendar.setGregorianChange(date);
            calendar.set(year, month, day, hour, minute, second);
            return new TimeVo(calendar, calendar.getTimeInMillis());
        }
    }


//    public static void main(String[] args) {
//        writeWrongTimeToFile();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(653407185528L);
//		System.out.println(sf.format(calendar.getTime()));
//        Calendar calendar2 = Calendar.getInstance();
//        calendar2.setTimeInMillis(653497185528L);
//		System.out.println(sf.format(calendar2.getTime()));
//    }

    private static void writeWrongTimeToFile() {
        int days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        File file = new File("D:/wrondTimeScare_GregorianCalendar_afterdaylightsavingtime.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);

            int fromYear = 1990;

            for (; fromYear < 1991; ++fromYear) {
                int fromMonth = INIT_MONTH;
                for (; fromMonth < 9; ++fromMonth) {
                    int fromDay = INIT_DAY;
                    for (; fromDay < days[fromMonth]; ++fromDay) {
                        int fromHour = INIT_HOUR;
                        for (; fromHour < 24; ++fromHour) {
                            int fromMinute = INIT_MINUTE;
                            for (; fromMinute < 60; ++fromMinute) {
                                int fromSecond = INIT_SECOND;
                                for (; fromSecond < 60; ++fromSecond) {
                                    writeWrongTimeToFile(fromYear, fromMonth, fromDay, fromHour, fromMinute, fromSecond, fw);
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    /**
     * 写文件
     * @Author : YHQ
     * @Date: 17:57 2018/12/3
     *
     */
    private static void writeWrongTimeToFile(int year, int month, int day, int hour, int minute, int second, FileWriter fw) throws IOException {
        TimeZone timeZone =TimeZone.getTimeZone("Asia/Shanghai");
        long ONE_DAY_TIME_MILI = 24 * 60 * 60 * 1000L;
        //前一天时间点
        TimeVo preTimeVo = TimeVo.getInstance(year, month, day, hour, minute, second);
        Calendar preDay = preTimeVo.calendar;
        long preDay_long = preTimeVo.timeMili;
        if(timeZone.inDaylightTime(preDay.getTime())){
            preDay_long += 3600000;
        }
        //后一天时间点
        TimeVo afterTimeVo = TimeVo.getInstance(year, month, day + 1, hour, minute, second);
        Calendar afterDay = afterTimeVo.calendar;
        long afterDay_long = afterTimeVo.timeMili;
        if(timeZone.inDaylightTime(afterDay.getTime())){
            afterDay_long += 3600000;
        }
        String preStr = sf.format(preDay.getTime());
        String afterStr = sf.format(afterDay.getTime());
//		System.out.println(preStr +"至" + afterStr);
//		System.out.println(afterStr);
//		System.out.println(preStr+"毫秒数："+preDay_long);
//		System.out.println(afterStr+"毫秒数："+afterDay_long);
//		System.out.println("两个时间点毫秒数差值："+(afterDay_long-preDay_long));
        long d_val = ((afterDay_long - preDay_long) - ONE_DAY_TIME_MILI);
        if (d_val > (1000L * 60L)) {
            if(preDay_long == 653407187076L){
                System.out.println();
            }
            fw.write(preStr + "[" + preDay_long + "]至" + afterStr + "[" + afterDay_long + "]，两个区间相差"+d_val+"毫秒\n");
//            wrongMap.put(preStr + "[" + preDay_long + "]至" + afterStr + "[" + afterDay_long + "]", d_val);
        }
//		System.out.println("跟正常一天时间毫秒述差值："+d_val);
    }

}
