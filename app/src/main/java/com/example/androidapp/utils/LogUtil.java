package com.example.androidapp.utils;

import android.util.Log;

import com.example.androidapp.BuildConfig;

import java.util.Locale;

/**
 * Created by lenovo on 2017/5/12.
 * LogUtil
 */

public class LogUtil {

    private static boolean isDebug = BuildConfig.DEBUG;

    public static int d(String msg) {
        if (isDebug)
            return Log.d(getTag(), buildMessage(msg == null ? "" : msg));
        return -1;
    }

    private static String getTag() {
        StackTraceElement[] trace = new Throwable().fillInStackTrace()
                .getStackTrace();
        String callingClass = "";
        for (int i = 2; i < trace.length; i++) {
            Class<?> clazz = trace[i].getClass();
            if (!clazz.equals(LogUtil.class)) {
                callingClass = trace[i].getClassName();
                callingClass = callingClass.substring(callingClass
                        .lastIndexOf('.') + 1);
                break;
            }
        }
        return callingClass;
    }

    private static String buildMessage(String msg) {
        StackTraceElement[] trace = new Throwable().fillInStackTrace()
                .getStackTrace();
        String caller = "";
        for (int i = 2; i < trace.length; i++) {
            Class<?> clazz = trace[i].getClass();
            if (!clazz.equals(LogUtil.class)) {
                caller = trace[i].getMethodName();
                break;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Thread.currentThread()
                .getId(), caller, msg);
    }
}
