package com.xunlei.downloadprovider.vod.floatwindow;

import android.app.NotificationManager;
import com.umeng.message.entity.UMessage;
import com.xunlei.downloadprovider.vodnew.a.d.c;
import com.xunlei.downloadprovider.vodnew.a.e.o.e;

/* compiled from: VodPlayerFloatWindow */
final class h implements e {
    final /* synthetic */ a a;

    h(a aVar) {
        this.a = aVar;
    }

    public final void a(c cVar) {
        a.v;
        if (this.a.n != null) {
            this.a.g.a(this.a.n);
        }
        this.a.g.a(this.a.m);
        if (this.a.o != null) {
            this.a.b();
            a.v;
        } else {
            this.a.c();
            a.v;
        }
        cVar = this.a;
        this.a.m;
        cVar = cVar.a();
        if (cVar != null) {
            ((NotificationManager) this.a.b.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION)).notify(111, cVar);
        }
    }
}
