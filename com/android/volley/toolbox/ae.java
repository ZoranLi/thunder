package com.android.volley.toolbox;

/* compiled from: BasicLineFormatter */
public final class ae {
    @Deprecated
    public static final ae a = new ae();
    public static final ae b = new ae();

    public static f a(ag agVar) {
        ac.a(agVar, "Header");
        if (agVar instanceof af) {
            return ((af) agVar).c();
        }
        f fVar = new f(64);
        String a = agVar.a();
        String b = agVar.b();
        int length = a.length() + 2;
        if (b != null) {
            length += b.length();
        }
        fVar.a(length);
        fVar.a(a);
        fVar.a(": ");
        if (b != null) {
            fVar.a(b);
        }
        return fVar;
    }
}
