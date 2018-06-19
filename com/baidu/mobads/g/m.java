package com.baidu.mobads.g;

import com.baidu.mobads.a.b;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;

class m implements IOAdEventListener {
    final /* synthetic */ double a;
    final /* synthetic */ l b;

    m(l lVar, double d) {
        this.b = lVar;
        this.a = d;
    }

    public void run(IOAdEvent iOAdEvent) {
        this.b.a.b.o();
        if ("URLLoader.Load.Complete".equals(iOAdEvent.getType())) {
            this.b.a.b.k = new e((String) iOAdEvent.getData().get("message"));
            double a = b.a();
            iOAdEvent = this.b.a.b.l().getFloat("__badApkVersion__8.7036", 0.0f);
            boolean z = true;
            Boolean valueOf = Boolean.valueOf(((float) this.b.a.b.k.b()) == iOAdEvent);
            if (a > this.b.a.b.k.b() || Math.floor(a) != Math.floor(this.b.a.b.k.b())) {
                z = false;
            }
            Boolean valueOf2 = Boolean.valueOf(z);
            StringBuilder stringBuilder = new StringBuilder("try to download apk badVer=");
            stringBuilder.append(iOAdEvent);
            stringBuilder.append(", isBad=");
            stringBuilder.append(valueOf);
            stringBuilder.append(", compatible=");
            stringBuilder.append(valueOf2);
            if (this.a >= this.b.a.b.k.b() || this.b.a.b.k == null || this.b.a.b.k.a().booleanValue() == null || valueOf2.booleanValue() == null || valueOf.booleanValue() != null) {
                if (this.b.a.b.n != null) {
                    this.b.a.b.n = false;
                    this.b.a.b.a(false, "Refused to download remote for version...");
                }
                return;
            }
            this.b.a.b.a(this.b.a.b.k);
            return;
        }
        if (this.b.a.b.n != null) {
            this.b.a.b.n = false;
            this.b.a.b.a(false, "remote update Network access failed");
        }
    }
}
