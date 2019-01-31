package com.yhq.cloud.config.client.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Calendar;
import java.util.Date;

public class TestVo {

    private Date date;

    @JsonFormat(timezone="Asia/Shanghai", pattern = "HH:mm:ss")
    private Date time;

    @JsonFormat(timezone="GMT+8", pattern = "HH:mm:ss")
    private Date time2;

    private TestVo testVo;

//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone="Asia/Shanghai", pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime2() {
        return time2;
    }

    public void setTime2(Date time2) {
        this.time2 = time2;
    }

    public TestVo getTestVo() {
        return testVo;
    }

    public void setTestVo(TestVo testVo) {
        this.testVo = testVo;
    }

    public static Date getDate(int year,int month,int day,int hour,int minute,int second,int milisecond){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DATE,day);
        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,minute);
        calendar.set(Calendar.SECOND,second);
        calendar.set(Calendar.MILLISECOND,milisecond);
        return calendar.getTime();
    }

    public static TestVo getInstance(){
        return getInstance(1991,6,7,1,59,59);
    }

    public static TestVo getInstance(int year,int month,int day,int hour,int minute,int second){
        TestVo rootVo = new TestVo();
        TestVo vo = new TestVo();
        rootVo.setTestVo(vo);
        int to  = 1991;
        int scope= to - year;
        rootVo.setDate(getDate(year,month,day,hour,minute,second,999));
        rootVo.setTime(rootVo.getDate());
        rootVo.setTime2(rootVo.getDate());
        for(int i = 1;i < scope;++i){
            TestVo tmpVo = new TestVo();
            tmpVo.setDate(getDate(year+i,month,day,hour,minute,second,999));
            tmpVo.setTime(tmpVo.getDate());
            tmpVo.setTime2(tmpVo.getDate());
            vo.setTestVo(tmpVo);
            vo = tmpVo;
        }
        return rootVo;
    }

//    public static void main(String[] args) {
//        System.out.println(JSONObject.toJSONString(TestVo.getInstance()));
//    }
}
