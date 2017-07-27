package com.tech.universalasynchandler;

/**
 * Created by rohitpuri on 27/7/17.
 */

public interface BackgroundThread {
    Object runTask();
    Object taskCompleted(Object data);
}
