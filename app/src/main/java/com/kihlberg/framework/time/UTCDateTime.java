package com.kihlberg.framework.time;

/**
 * Created by root on 3/26/15.
 */
public class UTCDateTime {
    public int year;
    public int month;
    public int day;
    public int hour;
    public int minute;
    public int second;

    public UTCDateTime(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public UTCDateTime(int year, int month, int day, int hour, int minute, int second) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public String toString() {
        return year+"/"+month+"/"+day+" "+hour+":"+minute+":"+second+" UT";
    }

}
