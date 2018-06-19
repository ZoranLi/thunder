package com.xunlei.downloadprovider.pushmessage.biz;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat.Builder;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.launch.LaunchActivity;
import com.xunlei.downloadprovider.launch.dispatch.h;
import com.xunlei.downloadprovider.pushmessage.bean.LivePushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.bean.PushOriginalInfo;
import com.xunlei.downloadprovider.pushmessage.m;
import com.xunlei.downloadprovider.pushmessage.notification.IPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.notification.NotificationManagerPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.report.BasePushReporter;
import com.xunlei.downloadprovider.pushmessage.report.GeneralPushReporter;
import com.xunlei.tdlive.LivePlugin;
import com.xunlei.xllib.android.XLIntent;

public class LivePushBiz extends BasePushBiz<LivePushMessageInfo> {
    public LivePushBiz(PushOriginalInfo pushOriginalInfo) {
        super(pushOriginalInfo);
    }

    @NonNull
    public LivePushMessageInfo parsePushMessageInfo(PushOriginalInfo pushOriginalInfo) {
        return LivePushMessageInfo.parse(pushOriginalInfo);
    }

    public BasePushReporter<LivePushMessageInfo> createReporter() {
        return new GeneralPushReporter();
    }

    public IPushNotificationHandler<LivePushMessageInfo> createPushNotificationHandler() {
        return new NotificationManagerPushNotificationHandler<LivePushMessageInfo>() {
            public int getNotificationId(LivePushMessageInfo livePushMessageInfo) {
                return 1004;
            }

            public String getNotificationTag(LivePushMessageInfo livePushMessageInfo) {
                return null;
            }

            public void onClick(Context context, LivePushMessageInfo livePushMessageInfo) {
            }

            public Notification getNotification(Context context, LivePushMessageInfo livePushMessageInfo, int i, Bitmap bitmap) {
                String title = livePushMessageInfo.getTitle();
                String desc = livePushMessageInfo.getDesc();
                if (bitmap == null) {
                    return m.a(context, title, desc, i);
                }
                return new Builder(context).setAutoCancel(true).setTicker(title).setSmallIcon(R.drawable.bt_noti_default_logo).setLargeIcon(bitmap).setDefaults(i).setNumber(0).setPriority(2).setContentTitle(title).setContentText(desc).build();
            }

            public void onDismiss(Context context, LivePushMessageInfo livePushMessageInfo) {
                LivePlugin.getInstance(context).notifyCanceledPushNotification(context, livePushMessageInfo.getRoomInfo());
            }

            public Intent createClickIntent(Context context, LivePushMessageInfo livePushMessageInfo) {
                Intent xLIntent = new XLIntent(context, LaunchActivity.class);
                xLIntent.addFlags(268435456);
                xLIntent.putExtra("dispatch_from_key", 1106);
                xLIntent.putExtra(h.a, livePushMessageInfo.getRoomInfo());
                return xLIntent;
            }

            public BasePushBiz$a shouldInterceptNotification(Context context, LivePushMessageInfo livePushMessageInfo) {
                return BasePushBiz$a.a(null, "");
            }
        };
    }
}
