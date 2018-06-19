package com.tencent.bugly.proguard;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public final class g extends m {
    static byte[] k = null;
    static Map<String, String> l = null;
    static final /* synthetic */ boolean m = true;
    public short a = (short) 0;
    public byte b = (byte) 0;
    public int c = 0;
    public int d = 0;
    public String e = null;
    public String f = null;
    public byte[] g;
    public int h = 0;
    public Map<String, String> i;
    public Map<String, String> j;

    public final boolean equals(Object obj) {
        g gVar = (g) obj;
        return (n.a(1, gVar.a) && n.a(1, gVar.b) && n.a(1, gVar.c) && n.a(1, gVar.d) && n.a(Integer.valueOf(1), gVar.e) && n.a(Integer.valueOf(1), gVar.f) && n.a(Integer.valueOf(1), gVar.g) && n.a(1, gVar.h) && n.a(Integer.valueOf(1), gVar.i) && n.a(Integer.valueOf(1), gVar.j) != null) ? true : null;
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
        r0 = m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.g.clone():java.lang.Object");
    }

    public final void a(l lVar) {
        lVar.a(this.a, 1);
        lVar.b(this.b, 2);
        lVar.a(this.c, 3);
        lVar.a(this.d, 4);
        lVar.a(this.e, 5);
        lVar.a(this.f, 6);
        lVar.a(this.g, 7);
        lVar.a(this.h, 8);
        lVar.a(this.i, 9);
        lVar.a(this.j, 10);
    }

    public final void a(k kVar) {
        try {
            Map hashMap;
            this.a = kVar.a(this.a, 1, true);
            this.b = kVar.a(this.b, 2, true);
            this.c = kVar.a(this.c, 3, true);
            this.d = kVar.a(this.d, 4, true);
            this.e = kVar.a(5, true);
            this.f = kVar.a(6, true);
            if (k == null) {
                k = new byte[]{(byte) 0};
            }
            this.g = kVar.a(k, 7, true);
            this.h = kVar.a(this.h, 8, true);
            if (l == null) {
                hashMap = new HashMap();
                l = hashMap;
                hashMap.put("", "");
            }
            this.i = (Map) kVar.a(l, 9, true);
            if (l == null) {
                hashMap = new HashMap();
                l = hashMap;
                hashMap.put("", "");
            }
            this.j = (Map) kVar.a(l, 10, true);
        } catch (k kVar2) {
            kVar2.printStackTrace();
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder("RequestPacket decode error ");
            stringBuilder.append(f.a(this.g));
            printStream.println(stringBuilder.toString());
            throw new RuntimeException(kVar2);
        }
    }

    public final void a(StringBuilder stringBuilder, int i) {
        i iVar = new i(stringBuilder, i);
        iVar.a(this.a, "iVersion");
        iVar.a(this.b, "cPacketType");
        iVar.a(this.c, "iMessageType");
        iVar.a(this.d, "iRequestId");
        iVar.a(this.e, "sServantName");
        iVar.a(this.f, "sFuncName");
        iVar.a(this.g, "sBuffer");
        iVar.a(this.h, "iTimeout");
        iVar.a(this.i, "context");
        iVar.a(this.j, "status");
    }
}
