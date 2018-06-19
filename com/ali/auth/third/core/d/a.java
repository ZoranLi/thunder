package com.ali.auth.third.core.d;

import android.text.TextUtils;
import com.ali.auth.third.core.j.b;
import java.util.ArrayList;
import java.util.List;

public class a {
    public static final a a = new a();
    private static final String b = "a";
    private String[] c;

    private a() {
    }

    public final synchronized void a() {
        if (this.c == null && com.ali.auth.third.core.h.a.a.c.a()) {
            Object a = b.a(com.ali.auth.third.core.c.a.c, "cookies");
            if (!TextUtils.isEmpty(a)) {
                boolean z = com.ali.auth.third.core.config.a.a;
                this.c = TextUtils.split(a, "\u0005");
            }
        }
        if (this.c != null) {
            a(this.c);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(java.lang.String[] r8) {
        /*
        r7 = this;
        monitor-enter(r7);
        r7.c = r8;	 Catch:{ all -> 0x0065 }
        r0 = com.ali.auth.third.core.c.a.c;	 Catch:{ all -> 0x0065 }
        if (r0 == 0) goto L_0x0063;
    L_0x0007:
        if (r8 == 0) goto L_0x0060;
    L_0x0009:
        r0 = com.ali.auth.third.core.config.a.a;	 Catch:{ all -> 0x0065 }
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0065 }
        r0.<init>();	 Catch:{ all -> 0x0065 }
        r1 = r8.length;	 Catch:{ all -> 0x0065 }
        r2 = 0;
    L_0x0012:
        if (r2 >= r1) goto L_0x0046;
    L_0x0014:
        r3 = r8[r2];	 Catch:{ all -> 0x0065 }
        r4 = android.text.TextUtils.isEmpty(r3);	 Catch:{ all -> 0x0065 }
        if (r4 != 0) goto L_0x0043;
    L_0x001c:
        r3 = com.ali.auth.third.core.d.b.a(r3);	 Catch:{ Throwable -> 0x003f }
        r4 = com.ali.auth.third.core.d.b.b(r3);	 Catch:{ Throwable -> 0x003f }
        r5 = r3.toString();	 Catch:{ Throwable -> 0x003f }
        r6 = com.ali.auth.third.core.config.a.a;	 Catch:{ Throwable -> 0x003f }
        r6 = com.ali.auth.third.core.d.c.a();	 Catch:{ Throwable -> 0x003f }
        r6.a(r4, r5);	 Catch:{ Throwable -> 0x003f }
        r4 = r3.a;	 Catch:{ Throwable -> 0x003f }
        r5 = ".taobao.com";
        r4 = android.text.TextUtils.equals(r4, r5);	 Catch:{ Throwable -> 0x003f }
        if (r4 == 0) goto L_0x0043;
    L_0x003b:
        r0.add(r3);	 Catch:{ Throwable -> 0x003f }
        goto L_0x0043;
    L_0x003f:
        r3 = move-exception;
        r3.printStackTrace();	 Catch:{ all -> 0x0065 }
    L_0x0043:
        r2 = r2 + 1;
        goto L_0x0012;
    L_0x0046:
        r0 = com.ali.auth.third.core.d.c.a();	 Catch:{ all -> 0x0065 }
        r0.a();	 Catch:{ all -> 0x0065 }
        r0 = r7.c;	 Catch:{ all -> 0x0065 }
        if (r0 == 0) goto L_0x005e;
    L_0x0051:
        r0 = com.ali.auth.third.core.c.a.c;	 Catch:{ all -> 0x0065 }
        r1 = "cookies";
        r2 = "\u0005";
        r8 = android.text.TextUtils.join(r2, r8);	 Catch:{ all -> 0x0065 }
        com.ali.auth.third.core.j.b.a(r0, r1, r8);	 Catch:{ all -> 0x0065 }
    L_0x005e:
        monitor-exit(r7);
        return;
    L_0x0060:
        r7.b();	 Catch:{ all -> 0x0065 }
    L_0x0063:
        monitor-exit(r7);
        return;
    L_0x0065:
        r8 = move-exception;
        monitor-exit(r7);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.auth.third.core.d.a.a(java.lang.String[]):void");
    }

    private void b() {
        c.a().b();
        if (this.c == null) {
            Object a = b.a(com.ali.auth.third.core.c.a.c, "cookies");
            if (!TextUtils.isEmpty(a)) {
                boolean z = com.ali.auth.third.core.config.a.a;
                this.c = TextUtils.split(a, "\u0005");
            }
        }
        if (this.c != null) {
            String str;
            String[] strArr;
            String b;
            boolean z2;
            List<e> arrayList = new ArrayList();
            for (String str2 : this.c) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        e a2 = b.a(str2);
                        if (!"munb".equals(a2.c)) {
                            String b2 = b.b(a2);
                            b.a(a2);
                            c.a().a(b2, a2.toString());
                            if (TextUtils.equals(a2.a, ".taobao.com")) {
                                arrayList.add(a2);
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            try {
                if (com.ali.auth.third.core.h.a.a.c.b.h != null) {
                    Object obj = com.ali.auth.third.core.h.a.a.c.b.h.get("ssoDomainList");
                    if (obj != null && (obj instanceof ArrayList)) {
                        strArr = (String[]) ((ArrayList) obj).toArray(new String[0]);
                        if (!(strArr == null || strArr.length <= 0 || arrayList.isEmpty())) {
                            for (e eVar : arrayList) {
                                str2 = eVar.a;
                                for (String b3 : strArr) {
                                    if (!"munb".equals(eVar.c)) {
                                        eVar.a = b3;
                                        b3 = b.b(eVar);
                                        b.a(eVar);
                                        c.a().a(b3, eVar.toString());
                                    }
                                }
                                eVar.a = str2;
                            }
                        }
                        z2 = com.ali.auth.third.core.config.a.a;
                        this.c = null;
                        b.a(com.ali.auth.third.core.c.a.c, "cookies", "");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            strArr = null;
            for (e eVar2 : arrayList) {
                str2 = eVar2.a;
                for (String b32 : strArr) {
                    if (!"munb".equals(eVar2.c)) {
                        eVar2.a = b32;
                        b32 = b.b(eVar2);
                        b.a(eVar2);
                        c.a().a(b32, eVar2.toString());
                    }
                }
                eVar2.a = str2;
            }
            z2 = com.ali.auth.third.core.config.a.a;
            this.c = null;
            b.a(com.ali.auth.third.core.c.a.c, "cookies", "");
        }
        c.a().c();
        c.a().a();
    }
}
