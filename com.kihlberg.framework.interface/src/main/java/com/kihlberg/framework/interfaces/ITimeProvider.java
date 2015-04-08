package com.kihlberg.framework.interfaces;


/**
 * Created by root on 3/22/15.
 */
public interface ITimeProvider {
    public UTCDateTime GetTime();

    public boolean IsMorning();
}
