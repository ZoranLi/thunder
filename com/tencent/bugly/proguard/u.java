package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
public final class u extends m implements Cloneable {
    static final /* synthetic */ boolean f = true;
    public String a = "";
    public String b = "";
    public String c = "";
    public long d = 0;
    public String e = "";

    public final String a() {
        return this.b;
    }

    public u(String str, String str2, String str3, long j, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
        this.e = str4;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        u uVar = (u) obj;
        if (n.a(this.a, uVar.a) && n.a(this.b, uVar.b) && n.a(this.c, uVar.c) && n.a(this.d, uVar.d) && n.a(this.e, uVar.e) != null) {
            return true;
        }
        return false;
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
        r0 = f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.u.clone():java.lang.Object");
    }

    public final void a(l lVar) {
        lVar.a(this.a, 0);
        lVar.a(this.b, 1);
        if (this.c != null) {
            lVar.a(this.c, 2);
        }
        lVar.a(this.d, 3);
        if (this.e != null) {
            lVar.a(this.e, 4);
        }
    }

    public final void a(k kVar) {
        this.a = kVar.a(0, true);
        this.b = kVar.a(1, true);
        this.c = kVar.a(2, false);
        this.d = kVar.a(this.d, 3, true);
        this.e = kVar.a(4, false);
    }

    public final void a(StringBuilder stringBuilder, int i) {
        i iVar = new i(stringBuilder, i);
        iVar.a(this.a, "apkMd5");
        iVar.a(this.b, "apkUrl");
        iVar.a(this.c, "manifestMd5");
        iVar.a(this.d, "fileSize");
        iVar.a(this.e, "signatureMd5");
    }
}
