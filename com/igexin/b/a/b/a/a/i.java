package com.igexin.b.a.b.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.igexin.b.a.c.a;
import com.igexin.push.core.a.f;
import java.net.Socket;

class i extends Handler {
    final /* synthetic */ d a;

    public i(d dVar) {
        this.a = dVar;
        super(Looper.getMainLooper());
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                if (!this.a.j()) {
                    this.a.e();
                    break;
                }
                break;
            case 1:
                this.a.k = false;
                return;
            case 2:
                this.a.a((Socket) message.obj);
                return;
            case 3:
                if (this.a.i()) {
                    this.a.g();
                    return;
                }
                break;
            case 4:
                this.a.k();
                if (this.a.j == null && this.a.i == null) {
                    if (this.a.h == null) {
                        f.a().e(false);
                        return;
                    }
                }
                if (this.a.i()) {
                    this.a.g();
                    return;
                } else {
                    this.a.f();
                    return;
                }
            case 5:
                if (this.a.i()) {
                    a.b("S-SM|tcp already close reconnect immediately");
                    f.a().e(((Boolean) message.obj).booleanValue());
                    return;
                }
                a.b("S-SM|reconnect will run after close");
                this.a.f();
                return;
            default:
                return;
        }
    }
}
