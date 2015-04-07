package com.kihlberg.framework.astronomy;

import android.os.Handler;

import com.kihlberg.framework.time.UTCDateTime;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by root on 3/22/15.
 */
public class TimeProvider implements ITimeProvider {

    Calendar cal = null;
    final Handler handler = new Handler();

    public TimeProvider() {
        cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.set(2015, 3, 20,6,0,0);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        cal.add(Calendar.SECOND, 30);
                    }
                });
            }
        },10,10);
    }

    @Override
    public UTCDateTime GetTime() {

        UTCDateTime time = new UTCDateTime(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE),cal.get(Calendar.SECOND));

        return time;
    }

    @Override
    public boolean IsMorning() {
        return GetTime().hour < 12;
    }
}
