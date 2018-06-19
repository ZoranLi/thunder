package com.tencent.smtt.sdk;

import android.database.sqlite.SQLiteException;
import java.lang.Thread.UncaughtExceptionHandler;

public class m implements UncaughtExceptionHandler {
    public void uncaughtException(Thread thread, Throwable th) {
        if (!(th instanceof SQLiteException)) {
            throw new RuntimeException(th);
        }
    }
}
