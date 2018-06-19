package com.xunlei.downloadprovider.pushmessage.getui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.umeng.message.entity.UMessage;
import com.xunlei.downloadprovider.pushmessage.h;

public class GetuiADReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (UMessage.DISPLAY_TYPE_NOTIFICATION.equals(intent.getStringExtra("action"))) {
            h.a(context, intent);
        }
    }
}
