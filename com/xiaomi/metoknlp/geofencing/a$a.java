package com.xiaomi.metoknlp.geofencing;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class a$a extends Handler {
    final /* synthetic */ a a;

    public a$a(a aVar, Looper looper) {
        this.a = aVar;
        super(looper);
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                a.a(this.a);
                this.a.a(a.b(this.a));
                StringBuilder stringBuilder = new StringBuilder("Try bindService count=");
                stringBuilder.append(a.c(this.a));
                stringBuilder.append(",mBinded=");
                stringBuilder.append(a.d(this.a));
                if (!(a.d(this.a) || a.e(this.a) == null || a.c(this.a) >= 10)) {
                    a.e(this.a).sendEmptyMessageDelayed(1, 10000);
                }
                return;
            case 2:
                a.f(this.a);
                return;
            case 3:
                a.g(this.a);
                return;
            default:
                return;
        }
    }
}
