package com.example.lifesupport.AlarmClock;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/15.
 */
public class Clock implements Serializable {
    private int hour,minute,second;
    private boolean isUse;

    public Clock(int hour, int mniute, int second,boolean isUse) {
        this.hour = hour;
        this.minute = mniute;
        this.second = second;
        this.isUse = isUse;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public boolean isUse() {
        return isUse;
    }

    public void setUse(boolean use) {
        isUse = use;
    }
}
