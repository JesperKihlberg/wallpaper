package com.kihlberg.framework.astronomy;

import com.kihlberg.framework.time.UTCDateTime;

import java.util.Calendar;

/**
 * Created by root on 3/22/15.
 */
public interface ITimeProvider {
    public UTCDateTime GetTime();

    public boolean IsMorning();
}
