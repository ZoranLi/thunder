package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: BUGLY */
public class d extends c {
    protected HashMap<String, byte[]> e = null;
    k f = new k();
    private HashMap<String, Object> g = new HashMap();

    public void b() {
        this.e = new HashMap();
    }

    public <T> void a(String str, T t) {
        if (this.e == null) {
            super.a(str, (Object) t);
        } else if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        } else {
            l lVar = new l();
            lVar.a(this.c);
            lVar.a((Object) t, 0);
            this.e.put(str, n.a(lVar.a()));
        }
    }

    public <T> T b(String str, T t) throws b {
        if (this.e != null) {
            if (!this.e.containsKey(str)) {
                return null;
            }
            if (this.g.containsKey(str)) {
                return this.g.get(str);
            }
            try {
                t = a((byte[]) this.e.get(str), (Object) t);
                if (t != null) {
                    c(str, t);
                }
                return t;
            } catch (String str2) {
                throw new b(str2);
            }
        } else if (!this.a.containsKey(str2)) {
            return null;
        } else {
            if (this.g.containsKey(str2)) {
                return this.g.get(str2);
            }
            byte[] bArr = new byte[0];
            Iterator it = ((HashMap) this.a.get(str2)).entrySet().iterator();
            if (it.hasNext()) {
                Entry entry = (Entry) it.next();
                entry.getKey();
                bArr = (byte[]) entry.getValue();
            }
            try {
                this.f.a(bArr);
                this.f.a(this.c);
                t = this.f.a((Object) t, 0, true);
                c(str2, t);
                return t;
            } catch (String str22) {
                throw new b(str22);
            }
        }
    }

    private Object a(byte[] bArr, Object obj) {
        this.f.a(bArr);
        this.f.a(this.c);
        return this.f.a(obj, 0, true);
    }

    private void c(String str, Object obj) {
        this.g.put(str, obj);
    }

    public byte[] a() {
        if (this.e == null) {
            return super.a();
        }
        l lVar = new l(0);
        lVar.a(this.c);
        lVar.a(this.e, 0);
        return n.a(lVar.a());
    }

    public void a(byte[] r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        super.a(r4);	 Catch:{ Exception -> 0x0004 }
        return;
    L_0x0004:
        r0 = r3.f;
        r0.a(r4);
        r4 = r3.f;
        r0 = r3.c;
        r4.a(r0);
        r4 = new java.util.HashMap;
        r0 = 1;
        r4.<init>(r0);
        r0 = "";
        r1 = 0;
        r2 = new byte[r1];
        r4.put(r0, r2);
        r0 = r3.f;
        r4 = r0.a(r4, r1, r1);
        r3.e = r4;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.d.a(byte[]):void");
    }
}
