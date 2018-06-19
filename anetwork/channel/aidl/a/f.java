package anetwork.channel.aidl.a;

/* compiled from: Taobao */
final class f implements Runnable {
    final /* synthetic */ byte a;
    final /* synthetic */ Object b;
    final /* synthetic */ e c;

    f(e eVar, byte b, Object obj) {
        this.c = eVar;
        this.a = b;
        this.b = obj;
    }

    public final void run() {
        this.c.b(this.a, this.b);
    }
}
