package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.android.c;
import com.xiaomi.xmpush.thrift.aa;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.af;
import com.xiaomi.xmpush.thrift.ai;
import com.xiaomi.xmpush.thrift.ak;
import com.xiaomi.xmpush.thrift.am;
import com.xiaomi.xmpush.thrift.an;
import com.xiaomi.xmpush.thrift.ap;
import com.xiaomi.xmpush.thrift.ar;
import com.xiaomi.xmpush.thrift.at;
import com.xiaomi.xmpush.thrift.au;
import com.xiaomi.xmpush.thrift.z;
import org.apache.thrift.a;

public class x {
    protected static <T extends a<T, ?>> af a(Context context, T t, com.xiaomi.xmpush.thrift.a aVar) {
        return a(context, t, aVar, aVar.equals(com.xiaomi.xmpush.thrift.a.Registration) ^ 1, context.getPackageName(), c.a(context).c());
    }

    protected static <T extends org.apache.thrift.a<T, ?>> com.xiaomi.xmpush.thrift.af a(android.content.Context r4, T r5, com.xiaomi.xmpush.thrift.a r6, boolean r7, java.lang.String r8, java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = com.xiaomi.xmpush.thrift.au.a(r5);
        r0 = 0;
        if (r5 != 0) goto L_0x000d;
    L_0x0007:
        r4 = "invoke convertThriftObjectToBytes method, return null.";
    L_0x0009:
        com.xiaomi.channel.commonutils.logger.b.a(r4);
        return r0;
    L_0x000d:
        r1 = new com.xiaomi.xmpush.thrift.af;
        r1.<init>();
        if (r7 == 0) goto L_0x0033;
    L_0x0014:
        r4 = com.xiaomi.mipush.sdk.c.a(r4);
        r4 = r4.f();
        r2 = android.text.TextUtils.isEmpty(r4);
        if (r2 == 0) goto L_0x0025;
    L_0x0022:
        r4 = "regSecret is empty, return null";
        goto L_0x0009;
    L_0x0025:
        r4 = com.xiaomi.channel.commonutils.string.a.a(r4);
        r4 = com.xiaomi.channel.commonutils.android.c.b(r4, r5);	 Catch:{ Exception -> 0x002e }
        goto L_0x0034;
    L_0x002e:
        r4 = "encryption error. ";
        com.xiaomi.channel.commonutils.logger.b.d(r4);
    L_0x0033:
        r4 = r5;
    L_0x0034:
        r5 = new com.xiaomi.xmpush.thrift.x;
        r5.<init>();
        r2 = 5;
        r5.a = r2;
        r0 = "fakeid";
        r5.b = r0;
        r1.a(r5);
        r4 = java.nio.ByteBuffer.wrap(r4);
        r1.a(r4);
        r1.a(r6);
        r4 = 1;
        r1.c(r4);
        r1.b(r8);
        r1.a(r7);
        r1.a(r9);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.x.a(android.content.Context, org.apache.thrift.a, com.xiaomi.xmpush.thrift.a, boolean, java.lang.String, java.lang.String):com.xiaomi.xmpush.thrift.af");
    }

    public static a a(Context context, af afVar) {
        if (afVar.c()) {
            try {
                byte[] a = c.a(com.xiaomi.channel.commonutils.string.a.a(c.a(context).f()), afVar.f());
            } catch (Throwable e) {
                throw new f("the aes decrypt failed.", e);
            }
        }
        a = afVar.f();
        a a2 = a(afVar.a(), afVar.c);
        if (a2 != null) {
            au.a(a2, a);
        }
        return a2;
    }

    private static a a(com.xiaomi.xmpush.thrift.a aVar, boolean z) {
        switch (y.a[aVar.ordinal()]) {
            case 1:
                return new ak();
            case 2:
                return new ar();
            case 3:
                return new ap();
            case 4:
                return new at();
            case 5:
                return new an();
            case 6:
                return new z();
            case 7:
                return new ae();
            case 8:
                return new am();
            case 9:
                if (z) {
                    return new ai();
                }
                a aaVar = new aa();
                aaVar.a(true);
                return aaVar;
            case 10:
                return new ae();
            default:
                return null;
        }
    }
}
