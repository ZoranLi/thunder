package com.umeng.message;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.text.TextUtils;
import android.widget.RemoteViews;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.message.common.UmLog;
import com.umeng.message.common.c;
import com.umeng.message.entity.UMessage;
import com.umeng.message.entity.UNotificationItem;
import com.umeng.message.proguard.h;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

public class UmengAdHandler implements UHandler {
    private static int a = 64;
    private static final String b = "com.umeng.message.UmengAdHandler";
    private static Date c = null;
    private static String d = "9999999999999";
    private static final String g = "umeng_push_notification_default_large_icon";
    private static final String h = "umeng_push_notification_default_small_icon";
    private static final String i = "umeng_push_notification_default_sound";
    private UMessage e = null;
    private int f;

    public void dealWithCustomMessage(Context context, UMessage uMessage) {
    }

    public void setPrevMessage(UMessage uMessage) {
        this.e = uMessage;
    }

    public void handleMessage(Context context, UMessage uMessage) {
        UmLog.d(b, "handleMessage");
        dealWithNotificationMessage(context, uMessage);
    }

    public void dealWithNotificationMessage(Context context, UMessage uMessage) {
        String str = b;
        StringBuilder stringBuilder = new StringBuilder("notify: ");
        stringBuilder.append(uMessage.getRaw().toString());
        UmLog.d(str, stringBuilder.toString());
        if (MessageSharedPrefs.getInstance(context).hasMessageResourceDownloaded(uMessage.msg_id) || !startDownloadResourceService(context, uMessage)) {
            String substring;
            int i;
            str = MessageSharedPrefs.getInstance(context).getLastMessageMsgID();
            if ("".equals(str)) {
                str = "";
            } else {
                str = str.substring(7, 20);
            }
            if (uMessage.msg_id != null && 22 == uMessage.msg_id.length() && uMessage.msg_id.startsWith("u")) {
                MessageSharedPrefs.getInstance(context).setLastMessageMsgID(uMessage.msg_id);
                substring = uMessage.msg_id.substring(7, 20);
            } else {
                substring = d;
            }
            boolean z = true;
            if (!"".equals(str)) {
                if (substring.compareToIgnoreCase(str) < 0) {
                    z = false;
                }
            }
            MessageSharedPrefs.getInstance(context).removeMessageResouceRecord(uMessage.msg_id);
            Notification notification = getNotification(context, uMessage);
            if (notification != null) {
                i = notification.icon;
            }
            if (notification != null) {
                this.f = new Random(System.nanoTime()).nextInt();
                PendingIntent clickPendingIntent = getClickPendingIntent(context, uMessage);
                notification.deleteIntent = getDismissPendingIntent(context, uMessage);
                notification.contentIntent = clickPendingIntent;
                i = getNotificationDefaults(context, uMessage);
                if ((i & 1) != 0) {
                    Uri sound = getSound(context, uMessage);
                    if (sound != null) {
                        notification.sound = getSound(context, uMessage);
                    }
                    if (sound != null) {
                        i ^= 1;
                    }
                }
                notification.defaults = i;
                a(context, notification, z, uMessage);
            }
        }
    }

    private void a(Context context, Notification notification, boolean z, UMessage uMessage) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
            int i = this.f;
            if (!(h.c(context) && h.b(context) && !PushAgent.getInstance(context).getNotificationOnForeground())) {
                if (MessageSharedPrefs.getInstance(context).getDisplayNotificationNumber() == 1) {
                    if (z) {
                    }
                }
                if (MessageSharedPrefs.getInstance(context).getDisplayNotificationNumber() <= false) {
                    while (MessageNotificationQueue.getInstance().size() >= MessageSharedPrefs.getInstance(context).getDisplayNotificationNumber()) {
                        z = MessageNotificationQueue.getInstance().pollFirst();
                        notificationManager.cancel(z.id);
                        UTrack.getInstance(context).setClearPrevMessage(false);
                        UTrack.getInstance(context).trackMsgDismissed(z.message);
                    }
                    MessageNotificationQueue.getInstance().addLast(new UNotificationItem(i, uMessage));
                }
                notificationManager.notify(i, notification);
                return;
            }
            UTrack.getInstance(context).setClearPrevMessage(false);
            UTrack.getInstance(context).trackMsgDismissed(uMessage);
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    @SuppressLint({"NewApi", "Wakelock"})
    private void a(Context context) {
        try {
            final PowerManager powerManager = (PowerManager) context.getSystemService("power");
            boolean z = false;
            if (VERSION.SDK_INT >= 7) {
                z = new Object(this) {
                    final /* synthetic */ UmengAdHandler b;

                    boolean a() {
                        return powerManager.isScreenOn();
                    }
                }.a();
            } else {
                UmLog.d(b, "android os version < 7, skip checking screen on status");
            }
            String str = b;
            StringBuilder stringBuilder = new StringBuilder("screen on.................................");
            stringBuilder.append(z);
            UmLog.d(str, stringBuilder.toString());
            if (!z) {
                powerManager.newWakeLock(805306374, "MyLock").acquire(10000);
            }
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public PendingIntent getClickPendingIntent(Context context, UMessage uMessage) {
        Intent intent = new Intent();
        intent.setClass(context, NotificationProxyBroadcastReceiver.class);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_MSG, uMessage.getRaw().toString());
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_ACTION, 10);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_MESSAGE_ID, uMessage.message_id);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_NOTIFICATION_ID, this.f);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_TASK_ID, uMessage.task_id);
        return PendingIntent.getBroadcast(context, (int) System.currentTimeMillis(), intent, 268435456);
    }

    public PendingIntent getDismissPendingIntent(Context context, UMessage uMessage) {
        Intent intent = new Intent();
        intent.setClass(context, NotificationProxyBroadcastReceiver.class);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_MSG, uMessage.getRaw().toString());
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_ACTION, 11);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_MESSAGE_ID, uMessage.message_id);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_NOTIFICATION_ID, this.f);
        intent.putExtra(NotificationProxyBroadcastReceiver.EXTRA_KEY_TASK_ID, uMessage.task_id);
        return PendingIntent.getBroadcast(context, (int) (System.currentTimeMillis() + 1), intent, 268435456);
    }

    public boolean isInNoDisturbTime(Context context) {
        int i = (Calendar.getInstance().get(11) * 60) + Calendar.getInstance().get(12);
        boolean z = i >= (PushAgent.getInstance(context).getNoDisturbStartHour() * 60) + PushAgent.getInstance(context).getNoDisturbStartMinute();
        boolean z2 = i <= (PushAgent.getInstance(context).getNoDisturbEndHour() * 60) + PushAgent.getInstance(context).getNoDisturbEndMinute();
        if (((PushAgent.getInstance(context).getNoDisturbEndHour() * 60) + PushAgent.getInstance(context).getNoDisturbEndMinute() >= (PushAgent.getInstance(context).getNoDisturbStartHour() * 60) + PushAgent.getInstance(context).getNoDisturbStartMinute() ? 1 : null) != null) {
            return z && z2;
        } else {
            if (!z) {
                if (!z2) {
                    return false;
                }
            }
            return true;
        }
    }

    public int getNotificationDefaults(Context context, UMessage uMessage) {
        long muteDuration = (1 * ((long) MessageSharedPrefs.getInstance(context).getMuteDuration())) * 1000;
        int i = 0;
        if (!isInNoDisturbTime(context)) {
            if (c == null || Calendar.getInstance().getTimeInMillis() - c.getTime() >= muteDuration) {
                String str;
                StringBuilder stringBuilder;
                int notificationPlayVibrate = MessageSharedPrefs.getInstance(context).getNotificationPlayVibrate();
                String str2 = b;
                StringBuilder stringBuilder2 = new StringBuilder("playVibrate:");
                stringBuilder2.append(notificationPlayVibrate);
                UmLog.d(str2, stringBuilder2.toString());
                if (notificationPlayVibrate != 1) {
                    if (notificationPlayVibrate != 2 && uMessage.play_vibrate) {
                    }
                    notificationPlayVibrate = MessageSharedPrefs.getInstance(context).getNotificationPlayLights();
                    str = b;
                    stringBuilder = new StringBuilder("playLights:");
                    stringBuilder.append(notificationPlayVibrate);
                    UmLog.d(str, stringBuilder.toString());
                    if (notificationPlayVibrate != 1) {
                        i |= 4;
                    } else if (notificationPlayVibrate != 2 && uMessage.play_lights) {
                        i |= 4;
                    }
                    notificationPlayVibrate = MessageSharedPrefs.getInstance(context).getNotificationPlaySound();
                    str = b;
                    stringBuilder = new StringBuilder("playSound:");
                    stringBuilder.append(notificationPlayVibrate);
                    UmLog.d(str, stringBuilder.toString());
                    if (notificationPlayVibrate != 1) {
                        notificationPlayVibrate = i | 1;
                    } else {
                        if (notificationPlayVibrate != 2 && uMessage.play_sound) {
                            notificationPlayVibrate = i | 1;
                        }
                        c = Calendar.getInstance().getTime();
                        if (uMessage.screen_on != null) {
                            a(context);
                        }
                    }
                    i = notificationPlayVibrate;
                    c = Calendar.getInstance().getTime();
                    if (uMessage.screen_on != null) {
                        a(context);
                    }
                }
                i = 2;
                notificationPlayVibrate = MessageSharedPrefs.getInstance(context).getNotificationPlayLights();
                str = b;
                stringBuilder = new StringBuilder("playLights:");
                stringBuilder.append(notificationPlayVibrate);
                UmLog.d(str, stringBuilder.toString());
                if (notificationPlayVibrate != 1) {
                    i |= 4;
                } else {
                    i |= 4;
                }
                notificationPlayVibrate = MessageSharedPrefs.getInstance(context).getNotificationPlaySound();
                str = b;
                stringBuilder = new StringBuilder("playSound:");
                stringBuilder.append(notificationPlayVibrate);
                UmLog.d(str, stringBuilder.toString());
                if (notificationPlayVibrate != 1) {
                    notificationPlayVibrate = i | 1;
                } else {
                    notificationPlayVibrate = i | 1;
                }
                i = notificationPlayVibrate;
                c = Calendar.getInstance().getTime();
                if (uMessage.screen_on != null) {
                    a(context);
                }
            }
        }
        return i;
    }

    public boolean startDownloadResourceService(Context context, UMessage uMessage) {
        try {
            Intent intent = new Intent(context, UmengDownloadResourceService.class);
            intent.putExtra(AgooConstants.MESSAGE_BODY, uMessage.getRaw().toString());
            intent.putExtra(AgooConstants.MESSAGE_ID, uMessage.message_id);
            intent.putExtra(AgooConstants.MESSAGE_TASK_ID, uMessage.task_id);
            context.startService(intent);
            return true;
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        }
    }

    private boolean a(Context context, Builder builder, UMessage uMessage) {
        int smallIconId = getSmallIconId(context, uMessage);
        context = getLargeIcon(context, uMessage);
        if (smallIconId < 0) {
            return null;
        }
        builder.setSmallIcon(smallIconId);
        builder.setLargeIcon(context);
        return true;
    }

    public int getSmallIconId(Context context, UMessage uMessage) {
        int i = -1;
        try {
            if (!TextUtils.isEmpty(uMessage.icon)) {
                i = c.a(context).d(uMessage.icon);
            }
            if (i < 0) {
                i = c.a(context).d(h);
            }
            if (i < 0) {
                UmLog.d(b, "no custom notificaiton icon, fail back to app icon.");
                i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.icon;
            }
            if (i < 0) {
                UmLog.e(b, "Cann't find appropriate icon for notification, please make sure you have specified an icon for this notification or the app has defined an icon.");
            }
        } catch (Context context2) {
            context2.printStackTrace();
        }
        return i;
    }

    public android.graphics.Bitmap getLargeIcon(android.content.Context r5, com.umeng.message.entity.UMessage r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = "notificationpullapp";	 Catch:{ Exception -> 0x008c }
        r2 = r6.display_type;	 Catch:{ Exception -> 0x008c }
        r1 = r1.equals(r2);	 Catch:{ Exception -> 0x008c }
        if (r1 == 0) goto L_0x0034;	 Catch:{ Exception -> 0x008c }
    L_0x000b:
        r1 = r6.custom;	 Catch:{ Exception -> 0x008c }
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0058 }
        r2.<init>(r1);	 Catch:{ Exception -> 0x0058 }
        r1 = "img";	 Catch:{ Exception -> 0x0058 }
        r1 = r2.optString(r1);	 Catch:{ Exception -> 0x0058 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0058 }
        r2.<init>();	 Catch:{ Exception -> 0x0058 }
        r3 = com.umeng.message.UmengDownloadResourceService.getMessageResourceFolder(r5, r6);	 Catch:{ Exception -> 0x0058 }
        r2.append(r3);	 Catch:{ Exception -> 0x0058 }
        r1 = r1.hashCode();	 Catch:{ Exception -> 0x0058 }
        r2.append(r1);	 Catch:{ Exception -> 0x0058 }
        r1 = r2.toString();	 Catch:{ Exception -> 0x0058 }
        r1 = android.graphics.BitmapFactory.decodeFile(r1);	 Catch:{ Exception -> 0x0058 }
        goto L_0x0059;
    L_0x0034:
        r1 = r6.isLargeIconFromInternet();	 Catch:{ Exception -> 0x008c }
        if (r1 == 0) goto L_0x0058;	 Catch:{ Exception -> 0x008c }
    L_0x003a:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x008c }
        r1.<init>();	 Catch:{ Exception -> 0x008c }
        r2 = com.umeng.message.UmengDownloadResourceService.getMessageResourceFolder(r5, r6);	 Catch:{ Exception -> 0x008c }
        r1.append(r2);	 Catch:{ Exception -> 0x008c }
        r2 = r6.img;	 Catch:{ Exception -> 0x008c }
        r2 = r2.hashCode();	 Catch:{ Exception -> 0x008c }
        r1.append(r2);	 Catch:{ Exception -> 0x008c }
        r1 = r1.toString();	 Catch:{ Exception -> 0x008c }
        r1 = android.graphics.BitmapFactory.decodeFile(r1);	 Catch:{ Exception -> 0x008c }
        goto L_0x0059;	 Catch:{ Exception -> 0x008c }
    L_0x0058:
        r1 = r0;	 Catch:{ Exception -> 0x008c }
    L_0x0059:
        if (r1 != 0) goto L_0x008b;	 Catch:{ Exception -> 0x008c }
    L_0x005b:
        r2 = b;	 Catch:{ Exception -> 0x008c }
        r3 = "bmp is null";	 Catch:{ Exception -> 0x008c }
        com.umeng.message.common.UmLog.d(r2, r3);	 Catch:{ Exception -> 0x008c }
        r2 = -1;	 Catch:{ Exception -> 0x008c }
        r3 = r6.largeIcon;	 Catch:{ Exception -> 0x008c }
        r3 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Exception -> 0x008c }
        if (r3 != 0) goto L_0x0075;	 Catch:{ Exception -> 0x008c }
    L_0x006b:
        r2 = com.umeng.message.common.c.a(r5);	 Catch:{ Exception -> 0x008c }
        r6 = r6.largeIcon;	 Catch:{ Exception -> 0x008c }
        r2 = r2.d(r6);	 Catch:{ Exception -> 0x008c }
    L_0x0075:
        if (r2 >= 0) goto L_0x0081;	 Catch:{ Exception -> 0x008c }
    L_0x0077:
        r6 = com.umeng.message.common.c.a(r5);	 Catch:{ Exception -> 0x008c }
        r2 = "umeng_push_notification_default_large_icon";	 Catch:{ Exception -> 0x008c }
        r2 = r6.d(r2);	 Catch:{ Exception -> 0x008c }
    L_0x0081:
        if (r2 <= 0) goto L_0x008b;	 Catch:{ Exception -> 0x008c }
    L_0x0083:
        r5 = r5.getResources();	 Catch:{ Exception -> 0x008c }
        r1 = android.graphics.BitmapFactory.decodeResource(r5, r2);	 Catch:{ Exception -> 0x008c }
    L_0x008b:
        return r1;
    L_0x008c:
        r5 = move-exception;
        r5.printStackTrace();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengAdHandler.getLargeIcon(android.content.Context, com.umeng.message.entity.UMessage):android.graphics.Bitmap");
    }

    public android.net.Uri getSound(android.content.Context r5, com.umeng.message.entity.UMessage r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = r6.isSoundFromInternet();	 Catch:{ Throwable -> 0x0070 }
        if (r1 == 0) goto L_0x002b;	 Catch:{ Throwable -> 0x0070 }
    L_0x0007:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0070 }
        r1.<init>();	 Catch:{ Throwable -> 0x0070 }
        r2 = com.umeng.message.UmengDownloadResourceService.getMessageResourceFolder(r5, r6);	 Catch:{ Throwable -> 0x0070 }
        r1.append(r2);	 Catch:{ Throwable -> 0x0070 }
        r2 = r6.sound;	 Catch:{ Throwable -> 0x0070 }
        r2 = r2.hashCode();	 Catch:{ Throwable -> 0x0070 }
        r1.append(r2);	 Catch:{ Throwable -> 0x0070 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0070 }
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x0070 }
        r2.<init>(r1);	 Catch:{ Throwable -> 0x0070 }
        r2 = r2.exists();	 Catch:{ Throwable -> 0x0070 }
        if (r2 != 0) goto L_0x002c;	 Catch:{ Throwable -> 0x0070 }
    L_0x002b:
        r1 = r0;	 Catch:{ Throwable -> 0x0070 }
    L_0x002c:
        if (r1 != 0) goto L_0x0069;	 Catch:{ Throwable -> 0x0070 }
    L_0x002e:
        r2 = -1;	 Catch:{ Throwable -> 0x0070 }
        r3 = r6.sound;	 Catch:{ Throwable -> 0x0070 }
        r3 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x0070 }
        if (r3 != 0) goto L_0x0041;	 Catch:{ Throwable -> 0x0070 }
    L_0x0037:
        r2 = com.umeng.message.common.c.a(r5);	 Catch:{ Throwable -> 0x0070 }
        r6 = r6.sound;	 Catch:{ Throwable -> 0x0070 }
        r2 = r2.j(r6);	 Catch:{ Throwable -> 0x0070 }
    L_0x0041:
        if (r2 >= 0) goto L_0x004d;	 Catch:{ Throwable -> 0x0070 }
    L_0x0043:
        r6 = com.umeng.message.common.c.a(r5);	 Catch:{ Throwable -> 0x0070 }
        r2 = "umeng_push_notification_default_sound";	 Catch:{ Throwable -> 0x0070 }
        r2 = r6.j(r2);	 Catch:{ Throwable -> 0x0070 }
    L_0x004d:
        if (r2 <= 0) goto L_0x0069;	 Catch:{ Throwable -> 0x0070 }
    L_0x004f:
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0070 }
        r1 = "android.resource://";	 Catch:{ Throwable -> 0x0070 }
        r6.<init>(r1);	 Catch:{ Throwable -> 0x0070 }
        r5 = r5.getPackageName();	 Catch:{ Throwable -> 0x0070 }
        r6.append(r5);	 Catch:{ Throwable -> 0x0070 }
        r5 = "/";	 Catch:{ Throwable -> 0x0070 }
        r6.append(r5);	 Catch:{ Throwable -> 0x0070 }
        r6.append(r2);	 Catch:{ Throwable -> 0x0070 }
        r1 = r6.toString();	 Catch:{ Throwable -> 0x0070 }
    L_0x0069:
        if (r1 == 0) goto L_0x0070;	 Catch:{ Throwable -> 0x0070 }
    L_0x006b:
        r5 = android.net.Uri.parse(r1);	 Catch:{ Throwable -> 0x0070 }
        return r5;
    L_0x0070:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengAdHandler.getSound(android.content.Context, com.umeng.message.entity.UMessage):android.net.Uri");
    }

    public Notification getNotification(Context context, UMessage uMessage) {
        String str = uMessage.custom;
        Notification notification = null;
        if (str != null) {
            if (!str.equals("")) {
                try {
                    int optInt = new JSONObject(str).optInt(DispatchConstants.TIMESTAMP);
                    Builder builder = new Builder(context);
                    RemoteViews remoteViews = new RemoteViews(context.getPackageName(), c.a(context).f("upush_notification"));
                    switch (optInt) {
                        case 0:
                            remoteViews.setImageViewBitmap(c.a(context).c("notification_large_icon1"), getLargeIcon(context, uMessage));
                            remoteViews.setViewVisibility(c.a(context).c("upush_notification1"), 0);
                            remoteViews.setViewVisibility(c.a(context).c("upush_notification2"), 8);
                            remoteViews.setTextViewText(c.a(context).c("notification_title"), uMessage.title);
                            remoteViews.setTextViewText(c.a(context).c("notification_text"), uMessage.text);
                            builder.setContent(remoteViews).setTicker(uMessage.ticker).setSmallIcon(getSmallIconId(context, uMessage)).setAutoCancel(true);
                            context = builder.getNotification();
                            break;
                        case 1:
                            remoteViews.setImageViewBitmap(c.a(context).c("notification_large_icon2"), getLargeIcon(context, uMessage));
                            remoteViews.setViewVisibility(c.a(context).c("upush_notification1"), 8);
                            remoteViews.setViewVisibility(c.a(context).c("upush_notification2"), 0);
                            builder.setContent(remoteViews).setTicker(uMessage.ticker).setSmallIcon(getSmallIconId(context, uMessage)).setAutoCancel(true);
                            context = builder.getNotification();
                            break;
                        default:
                            break;
                    }
                    notification = context;
                } catch (Context context2) {
                    context2.printStackTrace();
                }
                return notification;
            }
        }
        return null;
    }
}
