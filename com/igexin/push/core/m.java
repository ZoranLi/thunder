package com.igexin.push.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;

public class m extends BroadcastReceiver {
    private static m a;

    private m() {
    }

    public static m a() {
        if (a == null) {
            a = new m();
        }
        return a;
    }

    public void onReceive(Context context, Intent intent) {
        if (f.a() != null) {
            Message message = new Message();
            message.what = a.d;
            message.obj = intent;
            f.a().a(message);
        }
    }
}
