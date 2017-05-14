package com.example.androidapp.utils;

import android.util.Log;

import com.example.androidapp.BuildConfig;

/**
 * Created by lenovo on 2017/5/12.
 * LogUtil
 */

public class LogUtil {

    private static boolean isDebug = BuildConfig.DEBUG;

    public static int d(String tag, String msg) {
        if (isDebug)
            return Log.d(tag, msg);
        return -1;
    }
}
