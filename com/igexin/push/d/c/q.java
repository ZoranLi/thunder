package com.igexin.push.d.c;

import android.text.TextUtils;
import com.igexin.b.a.b.f;

public class q extends e {
    public long a;
    public String b;
    public String c;
    public String d;

    public q() {
        this.b = "";
        this.c = "";
        this.d = "";
        this.i = 9;
    }

    private java.lang.String a(byte[] r3, int r4, int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = new java.lang.String;	 Catch:{ Exception -> 0x0008 }
        r1 = "UTF-8";	 Catch:{ Exception -> 0x0008 }
        r0.<init>(r3, r4, r5, r1);	 Catch:{ Exception -> 0x0008 }
        return r0;
    L_0x0008:
        r3 = "";
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.d.c.q.a(byte[], int, int):java.lang.String");
    }

    public void a(byte[] bArr) {
        int i;
        this.a = f.e(bArr, 0);
        int i2 = 9;
        if (bArr.length > 8) {
            i = bArr[8] & 255;
            if (i > 0) {
                this.b = a(bArr, 9, i);
                i2 = 9 + i;
            }
        } else {
            i2 = 8;
        }
        if (bArr.length > i2) {
            i = i2 + 1;
            i2 = bArr[i2] & 255;
            if (i2 > 0) {
                this.c = a(bArr, i, i2);
                i2 += i;
            } else {
                i2 = i;
            }
        }
        if (bArr.length > i2) {
            i = i2 + 1;
            i2 = bArr[i2] & 255;
            if (i2 > 0) {
                this.d = a(bArr, i, i2);
            }
        }
    }

    public byte[] d() {
        if (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d)) {
            Object bytes = this.b.getBytes();
            Object obj = new byte[((bytes.length + 8) + 1)];
            f.a(this.a, obj, 0);
            f.c(bytes.length, obj, 8);
            System.arraycopy(bytes, 0, obj, 9, bytes.length);
            return obj;
        }
        bytes = this.b.getBytes();
        Object bytes2 = this.c.getBytes();
        Object bytes3 = this.d.getBytes();
        obj = new byte[((((bytes.length + 8) + bytes2.length) + bytes3.length) + 3)];
        f.a(this.a, obj, 0);
        f.c(bytes.length, obj, 8);
        System.arraycopy(bytes, 0, obj, 9, bytes.length);
        int length = 9 + bytes.length;
        int i = length + 1;
        f.c(bytes2.length, obj, length);
        System.arraycopy(bytes2, 0, obj, i, bytes2.length);
        i += bytes2.length;
        length = i + 1;
        f.c(bytes3.length, obj, i);
        System.arraycopy(bytes3, 0, obj, length, bytes3.length);
        return obj;
    }
}
