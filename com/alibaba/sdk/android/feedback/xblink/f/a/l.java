package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.os.Handler;
import android.os.Looper;
import com.alibaba.sdk.android.feedback.util.a;
import com.alibaba.sdk.android.feedback.util.a.b;
import com.alibaba.sdk.android.feedback.util.j;
import java.io.File;

class l implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ k c;

    l(k kVar, String str, String str2) {
        this.c = kVar;
        this.a = str;
        this.b = str2;
    }

    public void run() {
        Runnable mVar;
        byte[] a = new b(this.a).a();
        Handler handler = new Handler(Looper.getMainLooper());
        if (a != null) {
            this.c.a(j.b, this.b, a);
            if (this.c.e == null) {
                this.c.e = new a();
            }
            if (this.c.e.b()) {
                this.c.e.a();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j.b);
            stringBuilder.append(File.separator);
            stringBuilder.append(this.b);
            this.c.e.a(new File(stringBuilder.toString()).getAbsolutePath(), this.c.f);
            mVar = new m(this);
        } else {
            mVar = new n(this);
        }
        handler.post(mVar);
    }
}
