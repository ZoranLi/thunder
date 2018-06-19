package com.igexin.push.d.c;

public class f extends e {
    String a;
    String b;
    String c;
    String d;

    public f() {
        this.i = 6;
        this.j = (byte) 20;
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
    }

    public f(String str, String str2, String str3, String str4) {
        this.i = 6;
        this.j = (byte) 20;
        if (str == null) {
            str = "";
        }
        this.a = str;
        if (str2 == null) {
            str2 = "";
        }
        this.b = str2;
        if (str3 == null) {
            str3 = "";
        }
        this.c = str3;
        if (str4 == null) {
            str4 = "";
        }
        this.d = str4;
    }

    public String a() {
        return this.c;
    }

    public void a(byte[] r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = 0;
        r0 = com.igexin.b.a.b.f.a(r6, r0);	 Catch:{ Exception -> 0x003c }
        r1 = new java.lang.String;	 Catch:{ Exception -> 0x003c }
        r2 = "utf-8";	 Catch:{ Exception -> 0x003c }
        r3 = 1;	 Catch:{ Exception -> 0x003c }
        r1.<init>(r6, r3, r0, r2);	 Catch:{ Exception -> 0x003c }
        r5.a = r1;	 Catch:{ Exception -> 0x003c }
        r0 = r0 + r3;	 Catch:{ Exception -> 0x003c }
        r1 = com.igexin.b.a.b.f.a(r6, r0);	 Catch:{ Exception -> 0x003c }
        r0 = r0 + r3;	 Catch:{ Exception -> 0x003c }
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x003c }
        r4 = "utf-8";	 Catch:{ Exception -> 0x003c }
        r2.<init>(r6, r0, r1, r4);	 Catch:{ Exception -> 0x003c }
        r5.b = r2;	 Catch:{ Exception -> 0x003c }
        r0 = r0 + r1;	 Catch:{ Exception -> 0x003c }
        r1 = com.igexin.b.a.b.f.a(r6, r0);	 Catch:{ Exception -> 0x003c }
        r0 = r0 + r3;	 Catch:{ Exception -> 0x003c }
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x003c }
        r4 = "utf-8";	 Catch:{ Exception -> 0x003c }
        r2.<init>(r6, r0, r1, r4);	 Catch:{ Exception -> 0x003c }
        r5.c = r2;	 Catch:{ Exception -> 0x003c }
        r0 = r0 + r1;	 Catch:{ Exception -> 0x003c }
        r1 = com.igexin.b.a.b.f.a(r6, r0);	 Catch:{ Exception -> 0x003c }
        r0 = r0 + r3;	 Catch:{ Exception -> 0x003c }
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x003c }
        r3 = "utf-8";	 Catch:{ Exception -> 0x003c }
        r2.<init>(r6, r0, r1, r3);	 Catch:{ Exception -> 0x003c }
        r5.d = r2;	 Catch:{ Exception -> 0x003c }
    L_0x003c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.d.c.f.a(byte[]):void");
    }

    public byte[] d() {
        Object bytes = this.b.getBytes();
        Object bytes2 = this.a.getBytes();
        Object bytes3 = this.c.getBytes();
        Object bytes4 = this.d.getBytes();
        Object obj = new byte[((((bytes.length + bytes2.length) + bytes3.length) + bytes4.length) + 4)];
        com.igexin.b.a.b.f.c(bytes.length, obj, 0);
        System.arraycopy(bytes, 0, obj, 1, bytes.length);
        int length = 1 + bytes.length;
        int i = length + 1;
        com.igexin.b.a.b.f.c(bytes2.length, obj, length);
        System.arraycopy(bytes2, 0, obj, i, bytes2.length);
        i += bytes2.length;
        int i2 = i + 1;
        com.igexin.b.a.b.f.c(bytes3.length, obj, i);
        System.arraycopy(bytes3, 0, obj, i2, bytes3.length);
        i2 += bytes3.length;
        int i3 = i2 + 1;
        com.igexin.b.a.b.f.c(bytes4.length, obj, i2);
        System.arraycopy(bytes4, 0, obj, i3, bytes4.length);
        return obj;
    }
}
