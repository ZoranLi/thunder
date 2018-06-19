package com.alibaba.sdk.android.feedback.xblink.f.a;

import com.alibaba.sdk.android.feedback.xblink.f.a;
import com.alibaba.sdk.android.feedback.xblink.f.b;
import com.alibaba.sdk.android.feedback.xblink.f.m;

public class t extends a {
    private static short d;

    private static int a(short s) {
        return s & 65535;
    }

    public static synchronized long d() {
        long a;
        synchronized (t.class) {
            long currentTimeMillis = 6269010681299730432L | (((System.currentTimeMillis() / 1000) << 16) & -1);
            short s = d;
            d = (short) (s + 1);
            a = currentTimeMillis | ((long) a(s));
        }
        return a;
    }

    public synchronized void a(b bVar, String str) {
        m mVar = new m();
        mVar.a("msgId", String.valueOf(d()));
        if (bVar != null) {
            bVar.a(mVar);
        }
    }

    public boolean a(String str, String str2, b bVar) {
        if (!"getMsgId".equals(str)) {
            return false;
        }
        a(bVar, str2);
        return true;
    }
}
