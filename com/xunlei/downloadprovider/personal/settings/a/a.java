package com.xunlei.downloadprovider.personal.settings.a;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.support.v4.view.PointerIconCompat;
import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.aplayer.aplayerandroid.APlayerAndroid.CONFIGID;
import com.umeng.message.entity.UMessage;
import com.xunlei.common.businessutil.SettingStateController;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.h.l;
import com.xunlei.downloadprovider.launch.LaunchActivity;
import com.xunlei.downloadprovider.pushmessage.m;
import com.xunlei.xllib.android.XLIntent;

/* compiled from: AliFeedbackHelper */
public final class a {
    private static String a = "ali_unread_msg";
    private static boolean b = false;
    private static boolean c = false;

    private static synchronized void e() {
        synchronized (a.class) {
            FeedbackAPI.addErrorCallback(new b());
            FeedbackAPI.addLeaveCallback(new c());
            FeedbackAPI.init(BrothersApplication.getApplicationInstance(), "23528347");
            b = true;
        }
    }

    public static void a() {
        if (!b) {
            e();
        }
        if (a(FeedbackAPI.class.getName(), "isUTInit")) {
            FeedbackAPI.getFeedbackUnreadCount(new e());
        }
    }

    private static boolean a(String str, String str2) {
        try {
            str = Class.forName(str);
            str2 = str.getDeclaredField(str2);
            str2.setAccessible(true);
            return str2.getBoolean(str);
        } catch (String str3) {
            str3.printStackTrace();
            return null;
        }
    }

    private static void c(int i) {
        f.a(BrothersApplication.getApplicationInstance(), a, i);
    }

    public static void a(Activity activity) {
        int i = 1;
        if (VERSION.SDK_INT >= 23 && activity.checkSelfPermission("android.permission.CAMERA") != 0) {
            activity.requestPermissions(new String[]{"android.permission.CAMERA"}, 80001);
            i = 0;
        }
        if (i != 0) {
            if (b == null) {
                e();
            }
            c(0);
            FeedbackAPI.openFeedbackActivity();
        }
    }

    static /* synthetic */ void b(int i) {
        if (i > 0) {
            Context applicationInstance = BrothersApplication.getApplicationInstance();
            if (i == 1) {
                i = String.format(applicationInstance.getResources().getString(R.string.um_fb_notifi_msg), new Object[]{Integer.valueOf(1)});
            } else {
                i = String.format(applicationInstance.getResources().getString(R.string.um_fb_notifi_msg), new Object[]{Integer.valueOf(i)});
            }
            String string = applicationInstance.getString(R.string.um_fb_notifi);
            try {
                NotificationManager notificationManager = (NotificationManager) applicationInstance.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
                Intent xLIntent = new XLIntent(applicationInstance, LaunchActivity.class);
                xLIntent.putExtra("dispatch_from_key", CONFIGID.HTTP_USER_AHTTP);
                PendingIntent activity = PendingIntent.getActivity(applicationInstance, (int) System.currentTimeMillis(), xLIntent, 0);
                i = m.b(applicationInstance, string, i, SettingStateController.getInstance().isSoundOn());
                if (!l.b()) {
                    i.setLargeIcon(BitmapFactory.decodeResource(applicationInstance.getResources(), R.mipmap.ic_launcher));
                }
                i = i.build();
                i.contentIntent = activity;
                notificationManager.notify(PointerIconCompat.TYPE_GRABBING, i);
            } catch (int i2) {
                i2.printStackTrace();
            }
        }
    }
}
