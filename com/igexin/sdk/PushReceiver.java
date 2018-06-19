package com.igexin.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.igexin.b.a.c.a;
import com.igexin.push.core.a.f;
import com.igexin.sdk.a.d;

public class PushReceiver extends BroadcastReceiver {
    private static final String a = "com.igexin.sdk.PushReceiver";

    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null) {
            try {
                String c = f.a().c("ss");
                if (c == null || !c.equals("1") || new d(context).c()) {
                    c = intent.getAction();
                    if (PushConsts.ACTION_BROADCAST_PUSHMANAGER.equals(c)) {
                        if (intent.getExtras() != null) {
                            Intent intent2 = new Intent(context.getApplicationContext(), f.a().a(context));
                            intent2.putExtra("action", PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                            intent2.putExtra("bundle", intent.getExtras());
                            context.getApplicationContext().startService(intent2);
                        }
                    } else if (PushConsts.ACTION_BROADCAST_REFRESHLS.equals(c)) {
                        c = intent.getStringExtra("callback_pkgname");
                        String stringExtra = intent.getStringExtra("callback_classname");
                        Intent intent3 = new Intent(context.getApplicationContext(), f.a().a(context));
                        intent3.putExtra("action", PushConsts.ACTION_BROADCAST_REFRESHLS);
                        intent3.putExtra("callback_pkgname", c);
                        intent3.putExtra("callback_classname", stringExtra);
                        context.startService(intent3);
                    } else {
                        if (!(PushConsts.ACTION_BROADCAST_TO_BOOT.equals(c) || c.equals("android.intent.action.ACTION_POWER_CONNECTED") || c.equals("android.intent.action.ACTION_POWER_DISCONNECTED"))) {
                            if (!c.equals("android.intent.action.MEDIA_MOUNTED")) {
                                if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(c) || PushConsts.ACTION_BROADCAST_USER_PRESENT.equals(c)) {
                                    intent = new Intent(context.getApplicationContext(), f.a().a(context));
                                    intent.putExtra("action", c);
                                    context.startService(intent);
                                }
                                return;
                            }
                        }
                        context.startService(new Intent(context.getApplicationContext(), f.a().a(context)));
                    }
                }
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append("|");
                stringBuilder.append(th.toString());
                a.b(stringBuilder.toString());
            }
        }
    }
}
