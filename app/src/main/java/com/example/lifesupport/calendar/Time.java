package com.example.lifesupport.calendar;

/**
 * Created by Administrator on 2016/7/14.
 */
public class Time {
    private int year;
    private int month;
    private int day;

    public Time( int year,int month) {
        this.month = month;
        this.year = year;
    }

    public Time(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
