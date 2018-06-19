package com.xunlei.common;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

public class XLCommonModule {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile XLCommonModule sInstance;
    private Application mApplication;

    private XLCommonModule() {
    }

    public static XLCommonModule getInstance() {
        if (sInstance == null) {
            synchronized (XLCommonModule.class) {
                if (sInstance == null) {
                    sInstance = new XLCommonModule();
                }
            }
        }
        return sInstance;
    }

    public static void init(@NonNull Application application) {
        getInstance().mApplication = application;
    }

    public Application getApplication() {
        return this.mApplication;
    }

    public Context getContext() {
        return this.mApplication;
    }
}
