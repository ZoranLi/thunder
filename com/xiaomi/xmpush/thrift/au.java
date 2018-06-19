package com.xiaomi.xmpush.thrift;

import android.content.Context;
import com.xiaomi.channel.commonutils.android.a;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.misc.g;
import com.xiaomi.push.service.bg;
import org.apache.thrift.e;
import org.apache.thrift.f;
import org.apache.thrift.protocol.k$a;

public class au {
    public static short a(Context context, af afVar) {
        int i = 0;
        int a = ((a.c(context, afVar.f).a() + 0) + (g.b(context) ? 4 : 0)) + (g.a(context) ? 8 : 0);
        if (bg.a(context, afVar)) {
            i = 16;
        }
        return (short) (a + i);
    }

    public static short a(boolean z, boolean z2, boolean z3) {
        int i = 0;
        int i2 = (z ? 4 : 0) + 0;
        if (z2) {
            i = 2;
        }
        return (short) ((i2 + i) + z3);
    }

    public static <T extends org.apache.thrift.a<T, ?>> void a(T t, byte[] bArr) {
        if (bArr == null) {
            throw new f("the message byte is empty.");
        }
        new e(new k$a(true, true, bArr.length)).a(t, bArr);
    }

    public static <T extends org.apache.thrift.a<T, ?>> byte[] a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new org.apache.thrift.g(new org.apache.thrift.protocol.a.a()).a(t);
        } catch (Throwable e) {
            b.a("convertThriftObjectToBytes catch TException.", e);
            return null;
        }
    }
}
