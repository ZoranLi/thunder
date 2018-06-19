package com.tencent.bugly.proguard;

import java.util.ArrayList;

/* compiled from: BUGLY */
public final class x extends m implements Cloneable {
    static ArrayList<w> b = null;
    static final /* synthetic */ boolean c = true;
    public ArrayList<w> a = null;

    public x(ArrayList<w> arrayList) {
        this.a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return null;
        }
        return n.a(this.a, ((x) obj).a);
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final java.lang.Object clone() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = super.clone();	 Catch:{ CloneNotSupportedException -> 0x0005 }
        goto L_0x0010;
    L_0x0005:
        r0 = c;
        if (r0 != 0) goto L_0x000f;
    L_0x0009:
        r0 = new java.lang.AssertionError;
        r0.<init>();
        throw r0;
    L_0x000f:
        r0 = 0;
    L_0x0010:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.x.clone():java.lang.Object");
    }

    public final void a(l lVar) {
        lVar.a(this.a, 0);
    }

    public final void a(k kVar) {
        if (b == null) {
            b = new ArrayList();
            b.add(new w());
        }
        this.a = (ArrayList) kVar.a(b, 0, true);
    }

    public final void a(StringBuilder stringBuilder, int i) {
        new i(stringBuilder, i).a(this.a, "events");
    }
}
