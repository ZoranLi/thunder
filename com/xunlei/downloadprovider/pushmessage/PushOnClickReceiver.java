package com.xunlei.downloadprovider.pushmessage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PushOnClickReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        new f().a(context, intent);
    }
}
