package com.xunlei.downloadprovider.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;

/* compiled from: BroadcastUtil */
public final class c {
    public static void a(Context context, String str, BroadcastReceiver broadcastReceiver) {
        LocalBroadcastManager.getInstance(context).registerReceiver(broadcastReceiver, new IntentFilter(str));
    }

    public static void a(Context context, BroadcastReceiver broadcastReceiver) {
        LocalBroadcastManager.getInstance(context).unregisterReceiver(broadcastReceiver);
    }

    public static void a(Context context, String str, Bundle bundle) {
        Intent intent = new Intent(str);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }
}
