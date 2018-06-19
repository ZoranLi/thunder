package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* compiled from: BUGLY */
public final class z extends m implements Cloneable {
    static Map<String, String> e = null;
    static final /* synthetic */ boolean f = true;
    public int a = 0;
    public String b = "";
    public long c = 0;
    public Map<String, String> d = null;

    public z(int i, String str, long j, Map<String, String> map) {
        this.a = i;
        this.b = str;
        this.c = j;
        this.d = map;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        z zVar = (z) obj;
        if (n.a(this.a, zVar.a) && n.a(this.b, zVar.b) && n.a(this.c, zVar.c) && n.a(this.d, zVar.d) != null) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.z.clone():java.lang.Object");
    }

    public final void a(l lVar) {
        lVar.a(this.a, 0);
        if (this.b != null) {
            lVar.a(this.b, 1);
        }
        lVar.a(this.c, 2);
        if (this.d != null) {
            lVar.a(this.d, 3);
        }
    }

    public final void a(k kVar) {
        this.a = kVar.a(this.a, 0, false);
        this.b = kVar.a(1, false);
        this.c = kVar.a(this.c, 2, false);
        if (e == null) {
            e = new HashMap();
            e.put("", "");
        }
        this.d = (Map) kVar.a(e, 3, false);
    }

    public final void a(StringBuilder stringBuilder, int i) {
        i iVar = new i(stringBuilder, i);
        iVar.a(this.a, AgooConstants.MESSAGE_FLAG);
        iVar.a(this.b, "localStrategyId");
        iVar.a(this.c, "localStrategyTime");
        iVar.a(this.d, "reserved");
    }
}
