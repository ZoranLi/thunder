package com.xunlei.downloadprovider.pushmessage;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.umeng.message.NotificationProxyBroadcastReceiver;
import com.xunlei.common.businessutil.SettingStateController;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.h.l;
import com.xunlei.downloadprovider.pushmessage.a.a;
import com.xunlei.downloadprovider.pushmessage.bean.BasePushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.biz.BasePushBiz;
import com.xunlei.downloadprovider.pushmessage.c.c;
import com.xunlei.xllib.android.XLIntent;

/* compiled from: PushResultNotification */
public final class m {
    public static Notification a(Context context, BasePushMessageInfo basePushMessageInfo, int i, Bitmap bitmap) {
        i = c(context, basePushMessageInfo.getTitle(), basePushMessageInfo.getDesc(), i);
        if (bitmap != null) {
            i.setCustomHeadsUpContentView(a(basePushMessageInfo.getTitle(), basePushMessageInfo.getDesc(), bitmap, context));
            if (TextUtils.isEmpty(basePushMessageInfo.getBigPic())) {
                context = a(basePushMessageInfo.getTitle(), basePushMessageInfo.getDesc(), bitmap, context);
            } else {
                basePushMessageInfo.getTitle();
                CharSequence desc = basePushMessageInfo.getDesc();
                basePushMessageInfo = basePushMessageInfo.getShortVideoType();
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.mqtt_noti_push);
                if (bitmap == null) {
                    remoteViews.setImageViewResource(R.id.push_msg_pic, R.drawable.loading_default_icon);
                } else {
                    remoteViews.setImageViewBitmap(R.id.push_msg_pic, bitmap);
                }
                remoteViews.setTextViewText(R.id.push_msg_content, desc);
                if (basePushMessageInfo == 1) {
                    remoteViews.setViewVisibility(R.id.push_msg_play, null);
                } else {
                    remoteViews.setViewVisibility(R.id.push_msg_play, 8);
                }
                context = remoteViews;
            }
            i.setCustomBigContentView(context);
        }
        return i.build();
    }

    public static Notification a(Context context, String str, String str2, int i) {
        return c(context, str, str2, i).build();
    }

    private static Builder c(Context context, String str, String str2, int i) {
        return new Builder(context).setAutoCancel(true).setTicker(str).setSmallIcon(R.drawable.bt_noti_default_logo).setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher)).setDefaults(i).setNumber(0).setPriority(2).setContentTitle(str).setContentText(str2);
    }

    public static Builder b(Context context, String str, String str2, int i) {
        return new Builder(context).setAutoCancel(true).setTicker(str).setSmallIcon(R.drawable.bt_noti_default_logo).setDefaults(i).setNumber(0).setPriority(2).setContentTitle(str).setContentText(str2);
    }

    public static RemoteViews a(String str, String str2, Bitmap bitmap, Context context) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.mqtt_noti_push_new);
        if (bitmap == null) {
            remoteViews.setImageViewResource(R.id.push_msg_pic_new, R.drawable.loading_default_icon);
        } else {
            remoteViews.setImageViewBitmap(R.id.push_msg_pic_new, bitmap);
        }
        remoteViews.setTextViewText(R.id.push_msg_title_new, str);
        remoteViews.setTextViewText(R.id.push_msg_content_new, str2);
        return remoteViews;
    }

    public static void a(Context context, BasePushBiz basePushBiz, Bitmap bitmap) {
        PendingIntent activity;
        PendingIntent activity2;
        Intent xLIntent;
        if (l.e()) {
            xLIntent = new XLIntent();
            xLIntent.setClass(context, PushNotificationHandleActivity.class);
            xLIntent.putExtra("push_biz", basePushBiz);
            xLIntent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_ACTION, 500);
            activity = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), xLIntent, 268435456);
        } else {
            xLIntent = new XLIntent();
            xLIntent.setClass(context, PushOnClickReceiver.class);
            xLIntent.putExtra("push_biz", basePushBiz);
            xLIntent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_ACTION, 500);
            activity = PendingIntent.getBroadcast(context, (int) System.currentTimeMillis(), xLIntent, 268435456);
        }
        Intent xLIntent2;
        if (l.e()) {
            xLIntent2 = new XLIntent();
            xLIntent2.setClass(context, PushNotificationHandleActivity.class);
            xLIntent2.putExtra("push_biz", basePushBiz);
            xLIntent2.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_ACTION, 501);
            activity2 = PendingIntent.getActivity(context, (int) (System.currentTimeMillis() + 1), xLIntent2, 268435456);
        } else {
            xLIntent2 = new XLIntent();
            xLIntent2.setClass(context, PushOnClickReceiver.class);
            xLIntent2.putExtra("push_biz", basePushBiz);
            xLIntent2.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_ACTION, 501);
            activity2 = PendingIntent.getBroadcast(context, (int) (System.currentTimeMillis() + 1), xLIntent2, 268435456);
        }
        try {
            bitmap = basePushBiz.getNotification(context, SettingStateController.getInstance().isSoundOn(), bitmap);
            if (bitmap == null) {
                basePushBiz.onError(context, "displayNotification,but notification is null");
                return;
            }
            if (activity != null) {
                bitmap.contentIntent = activity;
            }
            if (activity2 != null) {
                bitmap.deleteIntent = activity2;
            }
            if (a.a(context)) {
                basePushBiz.showNotification(context, basePushBiz.getNotificationTag(), basePushBiz.getNotificationId(), bitmap);
                if (c.a(context) != null) {
                    basePushBiz.onShow(context);
                    return;
                } else {
                    basePushBiz.onError(context, "user has turned off the device's push switch");
                    return;
                }
            }
            basePushBiz.onError(context, "user has turned off the app's push switch");
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }
}
