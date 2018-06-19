package com.alibaba.sdk.android.feedback.xblink.f.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class e extends BroadcastReceiver {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("sourceId");
            String stringExtra2 = intent.getStringExtra("data");
            String stringExtra3 = intent.getStringExtra("fromId");
            if ("com.alibaba.mobileim.ui.windvane.h5notify".equals(intent.getAction()) && this.a.f.contains(stringExtra)) {
                this.a.a(stringExtra, stringExtra3, stringExtra2);
            }
        }
    }
}
