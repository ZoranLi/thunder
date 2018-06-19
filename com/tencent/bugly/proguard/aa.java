package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
public final class aa extends m implements Cloneable {
    static bg c = null;
    static y d = null;
    static final /* synthetic */ boolean e = true;
    public bg a = null;
    public y b = null;

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        aa aaVar = (aa) obj;
        if (!n.a(this.a, aaVar.a) || n.a(this.b, aaVar.b) == null) {
            return false;
        }
        return true;
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
        r0 = e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.aa.clone():java.lang.Object");
    }

    public final void a(l lVar) {
        if (this.a != null) {
            lVar.a(this.a, 0);
        }
        if (this.b != null) {
            lVar.a(this.b, 1);
        }
    }

    public final void a(k kVar) {
        if (c == null) {
            c = new bg();
        }
        this.a = (bg) kVar.a(c, 0, false);
        if (d == null) {
            d = new y();
        }
        this.b = (y) kVar.a(d, 1, false);
    }

    public final void a(StringBuilder stringBuilder, int i) {
        i iVar = new i(stringBuilder, i);
        iVar.a(this.a, "baseStrategy");
        iVar.a(this.b, "grayStrategy");
    }
}
