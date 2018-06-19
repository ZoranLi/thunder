package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;

/* compiled from: BUGLY */
public class e extends d {
    static HashMap<String, byte[]> h;
    static HashMap<String, HashMap<String, byte[]>> i;
    protected g g;
    private int j;

    public e() {
        this.g = new g();
        this.j = 0;
        this.g.a = (short) 2;
    }

    public <T> void a(String str, T t) {
        if (str.startsWith(".")) {
            StringBuilder stringBuilder = new StringBuilder("put name can not startwith . , now is ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        super.a(str, (Object) t);
    }

    public void b() {
        super.b();
        this.g.a = (short) 3;
    }

    public byte[] a() {
        if (this.g.a != (short) 2) {
            if (this.g.e == null) {
                this.g.e = "";
            }
            if (this.g.f == null) {
                this.g.f = "";
            }
        } else if (this.g.e.equals("")) {
            throw new IllegalArgumentException("servantName can not is null");
        } else if (this.g.f.equals("")) {
            throw new IllegalArgumentException("funcName can not is null");
        }
        l lVar = new l(0);
        lVar.a(this.c);
        if (this.g.a == (short) 2) {
            lVar.a(this.a, 0);
        } else {
            lVar.a(this.e, 0);
        }
        this.g.g = n.a(lVar.a());
        lVar = new l(0);
        lVar.a(this.c);
        a(lVar);
        byte[] a = n.a(lVar.a());
        int length = a.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a).flip();
        return allocate.array();
    }

    public void a(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("decode package must include size head");
        }
        try {
            k kVar = new k(bArr, 4);
            kVar.a(this.c);
            a(kVar);
            HashMap hashMap;
            if (this.g.a == 3) {
                bArr = new k(this.g.g);
                bArr.a(this.c);
                if (h == null) {
                    hashMap = new HashMap();
                    h = hashMap;
                    hashMap.put("", new byte[0]);
                }
                this.e = bArr.a(h, 0, false);
                return;
            }
            bArr = new k(this.g.g);
            bArr.a(this.c);
            if (i == null) {
                i = new HashMap();
                hashMap = new HashMap();
                hashMap.put("", new byte[0]);
                i.put("", hashMap);
            }
            this.a = bArr.a(i, 0, false);
            this.b = new HashMap();
        } catch (byte[] bArr2) {
            throw new RuntimeException(bArr2);
        }
    }

    public void b(String str) {
        this.g.e = str;
    }

    public void c(String str) {
        this.g.f = str;
    }

    public void a(int i) {
        this.g.d = i;
    }

    public void a(l lVar) {
        this.g.a(lVar);
    }

    public void a(k kVar) {
        this.g.a(kVar);
    }
}
