package com.umeng.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.umeng.message.common.UmLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.l;
import com.umeng.message.proguard.l$c;
import com.umeng.message.proguard.l$d;
import java.util.Iterator;

public class UmengMessageBootReceiver extends BroadcastReceiver {
    private static final String b = "com.umeng.message.UmengMessageBootReceiver";
    private static final String c = "android.intent.action.BOOT_COMPLETED";
    Runnable a = new Runnable(this) {
        final /* synthetic */ UmengMessageBootReceiver a;

        {
            this.a = r1;
        }

        public void run() {
            try {
                Iterator it = l.a(this.a.d).b().iterator();
                while (it.hasNext()) {
                    l$c com_umeng_message_proguard_l_c = (l$c) it.next();
                    if (l.a(this.a.d).a(com_umeng_message_proguard_l_c.a) == null && com_umeng_message_proguard_l_c.b.equals(UMessage.DISPLAY_TYPE_NOTIFICATION)) {
                        l.a(this.a.d).a(com_umeng_message_proguard_l_c.a, 2, System.currentTimeMillis());
                    }
                }
                it = l.a(this.a.d).d().iterator();
                while (it.hasNext()) {
                    l$d com_umeng_message_proguard_l_d = (l$d) it.next();
                    if (l.a(this.a.d).c(com_umeng_message_proguard_l_d.a) == null && com_umeng_message_proguard_l_d.c.equals(UMessage.DISPLAY_TYPE_NOTIFICATION)) {
                        l.a(this.a.d).a(com_umeng_message_proguard_l_d.a, com_umeng_message_proguard_l_d.b, "9", System.currentTimeMillis());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                UmLog.d(UmengMessageBootReceiver.b, e.toString());
            }
        }
    };
    private Context d;

    public void onReceive(Context context, Intent intent) {
        try {
            UmLog.d(b, "Boot this system , UmengMessageBootReceiver onReceive()");
            String action = intent.getAction();
            if (action != null) {
                if (!action.equals("")) {
                    action = b;
                    StringBuilder stringBuilder = new StringBuilder("action=");
                    stringBuilder.append(intent.getAction());
                    UmLog.d(action, stringBuilder.toString());
                    if (TextUtils.equals(intent.getAction(), "android.intent.action.BOOT_COMPLETED") != null) {
                        this.d = context;
                        new Thread(this.a).start();
                    }
                }
            }
        } catch (Context context2) {
            UmLog.d(b, context2.toString());
        }
    }
}
