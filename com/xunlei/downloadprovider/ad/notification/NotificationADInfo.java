package com.xunlei.downloadprovider.ad.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import java.io.Serializable;

public abstract class NotificationADInfo implements Serializable {
    public static final int LANDING_TYPE_DEEP_LINK = 2;
    public static final int LANDING_TYPE_DOWNLOAD = 3;
    public static final int LANDING_TYPE_NONE = 0;
    public static final int LANDING_TYPE_WEB = 1;
    public static final String REPORT_STATUS_CLICK = "click";
    public static final String REPORT_STATUS_ERROR = "error";
    public static final String REPORT_STATUS_RECEIVE = "receive";
    public static final String REPORT_STATUS_SHOW = "show";

    public abstract Intent buildClickIntent(Context context);

    public abstract Notification buildNotification(Context context, int i, Bitmap bitmap);

    public abstract int getLandingType();

    public abstract void report(Context context, String str, @Nullable String str2);
}
