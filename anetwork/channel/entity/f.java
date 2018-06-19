package anetwork.channel.entity;

import anet.channel.bytes.ByteArray;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.aidl.a.d;
import anetwork.channel.aidl.k;
import anetwork.channel.d.a;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
public final class f implements a {
    long a;
    public String b;
    d c = null;
    boolean d = false;
    j e = null;
    private k f;

    public f(k kVar, j jVar) {
        this.f = kVar;
        this.e = jVar;
        if (kVar != null) {
            try {
                if ((kVar.a() & 8) != null) {
                    this.d = true;
                }
            } catch (k kVar2) {
                kVar2.printStackTrace();
            }
        }
    }

    public final void a(int i, Map<String, List<String>> map) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.Repeater", "[onResponseCode]", this.b, new Object[0]);
        }
        if (this.f != null) {
            a(new g(this, this.f, i, map));
        }
    }

    public final void a(int i, int i2, ByteArray byteArray) {
        if (this.f != null) {
            a(new h(this, byteArray, i2, i, this.f));
        }
    }

    public final void a(DefaultFinishEvent defaultFinishEvent) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.Repeater", "[onFinish] ", this.b, new Object[0]);
        }
        if (this.f != null) {
            Runnable iVar = new i(this, defaultFinishEvent, this.f);
            this.a = System.currentTimeMillis();
            a(iVar);
        }
        this.f = null;
    }

    private void a(Runnable runnable) {
        d.a(this.b != null ? this.b.hashCode() : hashCode(), runnable);
    }
}
