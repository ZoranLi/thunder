package com.baidu.mobads.command.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

class b extends BroadcastReceiver {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        context = intent.getAction();
        if (TextUtils.isEmpty(context) == null && "AppActivity_onDestroy".equals(context) != null) {
            a.h.set(null);
            this.a.c();
        }
    }
}
