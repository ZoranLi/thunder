package com.xunlei.downloadprovidershare;

/* compiled from: InternalShareHelper */
final class g implements a {
    final /* synthetic */ b a;

    g(b bVar) {
        this.a = bVar;
    }

    public final void a(int i) {
        StringBuilder stringBuilder = new StringBuilder("onShareComplete--shareResult=");
        stringBuilder.append(i);
        stringBuilder.append("|size=");
        stringBuilder.append(this.a.g.a.size());
        stringBuilder = new StringBuilder("  onShareComplete %%%%%%%% ------ activity: ");
        stringBuilder.append(this.a.a);
        stringBuilder.append("  shareInfo: ");
        stringBuilder.append(this.a.c);
        stringBuilder.append("  operationType: ");
        stringBuilder.append(this.a.b);
        stringBuilder.append(" dataIsEmpty:  ");
        stringBuilder.append(this.a.a());
        stringBuilder.append("   listener:   ");
        stringBuilder.append(this.a.d);
        if (this.a.a()) {
            this.a.c();
            return;
        }
        if (this.a.d != null) {
            this.a.d.onShareComplete(i, this.a.b, this.a.c);
        }
        this.a.c();
    }
}
