package com.xiaomi.mipush.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ae extends Handler {
    final /* synthetic */ ac a;

    ae(ac acVar, Looper looper) {
        this.a = acVar;
        super(looper);
    }

    public void dispatchMessage(Message message) {
        switch (message.what) {
            case 18:
                synchronized (this.a.f) {
                    ac.d = message.getData().getString("xmsf_region");
                    this.a.f.notifyAll();
                }
                return;
            case 19:
                String str = (String) message.obj;
                int i = message.arg1;
                synchronized (u.class) {
                    if (u.a(this.a.j).e(str)) {
                        if (u.a(this.a.j).c(str) < 10) {
                            ac acVar;
                            aj ajVar;
                            if (aj.DISABLE_PUSH.ordinal() == i && "syncing".equals(u.a(this.a.j).a(aj.DISABLE_PUSH))) {
                                acVar = this.a;
                                ajVar = aj.DISABLE_PUSH;
                            } else if (aj.ENABLE_PUSH.ordinal() == i && "syncing".equals(u.a(this.a.j).a(aj.ENABLE_PUSH))) {
                                acVar = this.a;
                                ajVar = aj.ENABLE_PUSH;
                            } else {
                                if (aj.UPLOAD_TOKEN.ordinal() == i && "syncing".equals(u.a(this.a.j).a(aj.UPLOAD_TOKEN))) {
                                    this.a.a(str, aj.UPLOAD_TOKEN, false, d.e(this.a.j));
                                }
                                u.a(this.a.j).b(str);
                            }
                            acVar.a(str, ajVar, true, null);
                            u.a(this.a.j).b(str);
                        } else {
                            u.a(this.a.j).d(str);
                        }
                    }
                }
                return;
            default:
                return;
        }
    }
}
