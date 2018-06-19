package com.tencent.bugly.proguard;

import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;

/* compiled from: BUGLY */
public final class v extends m implements Cloneable {
    static final /* synthetic */ boolean l = true;
    public String a = "";
    public byte b = (byte) 0;
    public int c = 0;
    public String d = "";
    public int e = 0;
    public String f = "";
    public long g = 0;
    public String h = "";
    public String i = "";
    public String j = "";
    public String k = "";

    public v(String str, byte b, int i, String str2, int i2, String str3, long j, String str4, String str5, String str6, String str7) {
        this.a = str;
        this.b = b;
        this.c = i;
        this.d = str2;
        this.e = i2;
        this.f = str3;
        this.g = j;
        this.h = str4;
        this.i = str5;
        this.j = str6;
        this.k = str7;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        v vVar = (v) obj;
        if (n.a(this.a, vVar.a) && n.a(this.b, vVar.b) && n.a(this.c, vVar.c) && n.a(this.d, vVar.d) && n.a(this.e, vVar.e) && n.a(this.f, vVar.f) && n.a(this.g, vVar.g) && n.a(this.h, vVar.h) && n.a(this.i, vVar.i) && n.a(this.j, vVar.j) && n.a(this.k, vVar.k) != null) {
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
        r0 = l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.v.clone():java.lang.Object");
    }

    public final void a(l lVar) {
        lVar.a(this.a, 0);
        lVar.b(this.b, 1);
        lVar.a(this.c, 2);
        if (this.d != null) {
            lVar.a(this.d, 3);
        }
        lVar.a(this.e, 4);
        if (this.f != null) {
            lVar.a(this.f, 5);
        }
        lVar.a(this.g, 6);
        if (this.h != null) {
            lVar.a(this.h, 7);
        }
        if (this.i != null) {
            lVar.a(this.i, 8);
        }
        if (this.j != null) {
            lVar.a(this.j, 9);
        }
        if (this.k != null) {
            lVar.a(this.k, 10);
        }
    }

    public final void a(k kVar) {
        this.a = kVar.a(0, true);
        this.b = kVar.a(this.b, 1, true);
        this.c = kVar.a(this.c, 2, true);
        this.d = kVar.a(3, false);
        this.e = kVar.a(this.e, 4, false);
        this.f = kVar.a(5, false);
        this.g = kVar.a(this.g, 6, false);
        this.h = kVar.a(7, false);
        this.i = kVar.a(8, false);
        this.j = kVar.a(9, false);
        this.k = kVar.a(10, false);
    }

    public final void a(StringBuilder stringBuilder, int i) {
        i iVar = new i(stringBuilder, i);
        iVar.a(this.a, "appId");
        iVar.a(this.b, Token.WX_TOKEN_PLATFORMID_KEY);
        iVar.a(this.c, "versionCode");
        iVar.a(this.d, "versionName");
        iVar.a(this.e, "buildNo");
        iVar.a(this.f, "iconUrl");
        iVar.a(this.g, "apkId");
        iVar.a(this.h, "channelId");
        iVar.a(this.i, "md5");
        iVar.a(this.j, "sdkVer");
        iVar.a(this.k, "bundleId");
    }
}
