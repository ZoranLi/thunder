package com.xiaomi.network;

import com.xiaomi.mipush.sdk.Constants;
import java.net.InetSocketAddress;

public final class Host {
    private String a;
    private int b;

    public Host(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public static com.xiaomi.network.Host a(java.lang.String r2, int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = ":";
        r0 = r2.lastIndexOf(r0);
        r1 = -1;
        if (r0 == r1) goto L_0x001d;
    L_0x0009:
        r1 = 0;
        r1 = r2.substring(r1, r0);
        r0 = r0 + 1;
        r2 = r2.substring(r0);	 Catch:{ NumberFormatException -> 0x001e }
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ NumberFormatException -> 0x001e }
        if (r2 > 0) goto L_0x001b;
    L_0x001a:
        goto L_0x001e;
    L_0x001b:
        r3 = r2;
        goto L_0x001e;
    L_0x001d:
        r1 = r2;
    L_0x001e:
        r2 = new com.xiaomi.network.Host;
        r2.<init>(r1, r3);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.network.Host.a(java.lang.String, int):com.xiaomi.network.Host");
    }

    public static InetSocketAddress b(String str, int i) {
        Host a = a(str, i);
        return new InetSocketAddress(a.b(), a.a());
    }

    public final int a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public final String toString() {
        if (this.b <= 0) {
            return this.a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }
}
