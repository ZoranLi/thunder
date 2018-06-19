package com.qihoo360.replugin.component.service.server;

/* compiled from: ConnectionBindRecord */
final class a {
    final g a;
    final com.qihoo360.loader2.mgr.a b;
    final int c;
    boolean d;
    private String e;

    a(g gVar, com.qihoo360.loader2.mgr.a aVar, int i) {
        this.a = gVar;
        this.b = aVar;
        this.c = i;
    }

    public final String toString() {
        if (this.e != null) {
            return this.e;
        }
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("ConnectionBindRecord{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" p");
        stringBuilder.append(this.a.c.a);
        stringBuilder.append(' ');
        if ((this.c & 1) != 0) {
            stringBuilder.append("CR ");
        }
        if ((this.c & 2) != 0) {
            stringBuilder.append("DBG ");
        }
        if ((this.c & 4) != 0) {
            stringBuilder.append("!FG ");
        }
        if ((this.c & 8) != 0) {
            stringBuilder.append("ABCLT ");
        }
        if ((this.c & 16) != 0) {
            stringBuilder.append("OOM ");
        }
        if ((32 & this.c) != 0) {
            stringBuilder.append("WPRI ");
        }
        if ((this.c & 64) != 0) {
            stringBuilder.append("IMP ");
        }
        if ((128 & this.c) != 0) {
            stringBuilder.append("WACT ");
        }
        if (this.d) {
            stringBuilder.append("DEAD ");
        }
        stringBuilder.append(this.a.a.k);
        stringBuilder.append(":@");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this.b.asBinder())));
        stringBuilder.append('}');
        this.e = stringBuilder.toString();
        return this.e;
    }
}
