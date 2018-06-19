package com.xunlei.downloadprovider.pushmessage.localpush;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.l;
import com.xunlei.downloadprovider.pushmessage.m;

/* compiled from: LocalNotification */
final class a {
    @SuppressLint({"NewApi"})
    public static void a(Context context, String str, String str2, int i, String str3, long j) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
        Intent intent = new Intent(context, LocalPushReceiver.class);
        intent.setAction("status_whole_view_click_action");
        intent.putExtra("local_notice_display_type", i);
        intent.putExtra("local_notice_type", str3);
        intent.putExtra(l.m, j);
        i = PendingIntent.getBroadcast(context, 211244, intent, 134217728);
        str = m.a(context, str, str2, 1);
        str.contentIntent = i;
        if (com.xunlei.downloadprovider.pushmessage.a.a.a(context) != null && notificationManager != null) {
            notificationManager.notify(1015, str);
        }
    }
}
