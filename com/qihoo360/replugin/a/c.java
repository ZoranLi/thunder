package com.qihoo360.replugin.a;

import android.content.Context;
import android.content.Intent;

/* compiled from: LocalBroadcastHelper */
public final class c {
    public static void a(Context context, Intent intent) {
        try {
            e.a(new d(context, intent), 10000);
        } catch (Context context2) {
            intent = new RuntimeException(context2);
        }
    }
}
