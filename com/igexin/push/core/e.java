package com.igexin.push.core;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.igexin.assist.sdk.AssistPushManager;
import com.igexin.push.config.m;
import com.igexin.push.core.a.f;
import com.igexin.push.f.b.g;
import com.igexin.push.util.a;
import com.igexin.sdk.PushConsts;

public class e extends Handler {
    private static String a = "com.igexin.push.core.e";

    private void a() {
        Object obj;
        g.J = System.currentTimeMillis();
        if (a.a(System.currentTimeMillis())) {
            if ("1".equals(f.a().c("ccs"))) {
                obj = null;
                if (obj != null) {
                    f.a().x();
                }
                if (g.E > m.y) {
                    double d = (double) (m.y / 10);
                    long random = (m.y / 2) + ((long) (((Math.random() * d) * 2.0d) - d));
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(a);
                    stringBuilder.append("|userPresent, reConnectDelayTime = ");
                    stringBuilder.append(m.y);
                    stringBuilder.append(", resetDelay = ");
                    stringBuilder.append(random);
                    com.igexin.b.a.c.a.b(stringBuilder.toString());
                    g.E = random;
                    g.g().h();
                }
            }
        }
        obj = 1;
        if (obj != null) {
            f.a().x();
        }
        if (g.E > m.y) {
            double d2 = (double) (m.y / 10);
            long random2 = (m.y / 2) + ((long) (((Math.random() * d2) * 2.0d) - d2));
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(a);
            stringBuilder2.append("|userPresent, reConnectDelayTime = ");
            stringBuilder2.append(m.y);
            stringBuilder2.append(", resetDelay = ");
            stringBuilder2.append(random2);
            com.igexin.b.a.c.a.b(stringBuilder2.toString());
            g.E = random2;
            g.g().h();
        }
    }

    private void a(Intent intent) {
        String stringExtra = intent.getStringExtra("action");
        if (stringExtra.equals(PushConsts.ACTION_SERVICE_INITIALIZE)) {
            f.a().a(intent);
        } else if (stringExtra.equals(PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE)) {
            f.a().b(intent);
            AssistPushManager.getInstance().turnOnPush(g.f);
        } else if (stringExtra.equals(PushConsts.ACTION_BROADCAST_PUSHMANAGER)) {
            f.a().a(intent.getBundleExtra("bundle"));
        } else if (stringExtra.equals(PushConsts.ACTION_BROADCAST_USER_PRESENT)) {
            a();
        } else if (stringExtra.equals("com.igexin.sdk.action.extdownloadsuccess")) {
            f.a().d(intent);
        } else {
            if (stringExtra.equals(PushConsts.ACTION_BROADCAST_NOTIFICATION_CLICK)) {
                intent = (Intent) intent.getParcelableExtra("broadcast_intent");
                if (intent != null) {
                    g.f.sendBroadcast(intent);
                }
            }
        }
    }

    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                if (message.what == a.c) {
                    Intent intent = (Intent) message.obj;
                    if (intent.hasExtra("action")) {
                        a(intent);
                    }
                } else if (message.what == a.d) {
                    f.a().c((Intent) message.obj);
                } else if (message.what == a.e) {
                    f.a().c((Intent) message.obj);
                } else if (message.what == a.g) {
                    Bundle bundle = (Bundle) message.obj;
                    String string = bundle.getString("taskid");
                    String string2 = bundle.getString("messageid");
                    String string3 = bundle.getString("actionid");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(a);
                    stringBuilder.append("|hand execute_action taskid = ");
                    stringBuilder.append(string);
                    stringBuilder.append(", actionid = ");
                    stringBuilder.append(string3);
                    com.igexin.b.a.c.a.b(stringBuilder.toString());
                    f.a().b(string, string2, string3);
                } else if (message.what == a.h) {
                    a.a((com.igexin.push.core.bean.g) message.obj);
                } else if (message.what == a.j) {
                    f.a().e((Intent) message.obj);
                } else if (message.what == a.f) {
                }
            } else if (message.what == a.i) {
                f.a().s();
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(a);
            stringBuilder2.append("|");
            stringBuilder2.append(th.toString());
            com.igexin.b.a.c.a.b(stringBuilder2.toString());
        }
    }
}
