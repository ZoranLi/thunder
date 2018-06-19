package com.qihoo360.replugin.packages;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qihoo360.loader2.m;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.model.PluginInfo;

class PluginInfoUpdater$UpdateReceiver extends BroadcastReceiver {
    private PluginInfoUpdater$UpdateReceiver() {
    }

    public final void onReceive(Context context, Intent intent) {
        if (TextUtils.equals(intent.getAction(), "com.qihoo360.replugin.pms.ACTION_UPDATE_INFO") != null) {
            if (c.a != null) {
                StringBuilder stringBuilder = new StringBuilder("onReceiveUpdateInfo: in=");
                stringBuilder.append(intent);
                c.b("PluginInfoUpdater", stringBuilder.toString());
            }
            String stringExtra = intent.getStringExtra("pn");
            if (!TextUtils.isEmpty(stringExtra)) {
                PluginInfo a = m.a(stringExtra, false);
                if (a != null && intent.hasExtra("used")) {
                    intent = intent.getBooleanExtra("used", false);
                    if (c.a) {
                        StringBuilder stringBuilder2 = new StringBuilder("onReceiveUpdateInfo: pn=");
                        stringBuilder2.append(stringExtra);
                        stringBuilder2.append("; setIsUsed=");
                        stringBuilder2.append(intent);
                        c.b("PluginInfoUpdater", stringBuilder2.toString());
                    }
                    a.setIsUsed(intent);
                }
            }
        }
    }
}
