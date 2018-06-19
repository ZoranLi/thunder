package com.xunlei.downloadprovider.pushmessage.localpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.launch.LaunchActivity;
import com.xunlei.downloadprovider.pushmessage.report.l;
import com.xunlei.xllib.android.XLIntent;

public class LocalPushReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        new StringBuilder("onReceive-------------------- context=").append(context);
        if (intent.getAction().equals("status_whole_view_click_action")) {
            int intExtra = intent.getIntExtra("local_notice_display_type", -1);
            String stringExtra = intent.getStringExtra("local_notice_type");
            StringBuilder stringBuilder = new StringBuilder("LocalNotification---onClickReceiver---");
            stringBuilder.append(Thread.currentThread().getId());
            stringBuilder.append(" type=");
            stringBuilder.append(stringExtra);
            l.c(intExtra, stringExtra, "", "", "", "");
            Intent xLIntent = new XLIntent(context, LaunchActivity.class);
            xLIntent.addFlags(335544320);
            xLIntent.putExtra("download_from", "push_local");
            xLIntent.putExtra("dispatch_from_key", 1112);
            xLIntent.putExtra(com.umeng.message.proguard.l.m, intent.getLongExtra(com.umeng.message.proguard.l.m, -1));
            context.startActivity(xLIntent);
        }
    }
}
