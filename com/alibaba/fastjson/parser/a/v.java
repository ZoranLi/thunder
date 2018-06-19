package com.alibaba.fastjson.parser.a;

/* compiled from: SqlDateDeserializer */
public final class v extends c implements r {
    public static final v a = new v();
    public static final v b = new v((byte) 0);
    private boolean c;

    public final int e_() {
        return 2;
    }

    public v() {
        this.c = false;
    }

    private v(byte b) {
        this.c = false;
        this.c = true;
    }

    protected final <T> T b(com.alibaba.fastjson.parser.a r4, java.lang.reflect.Type r5, java.lang.Object r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r5 = r3.c;
        if (r5 == 0) goto L_0x0009;
    L_0x0004:
        r4 = a(r4, r6);
        return r4;
    L_0x0009:
        r5 = 0;
        if (r6 != 0) goto L_0x000d;
    L_0x000c:
        return r5;
    L_0x000d:
        r0 = r6 instanceof java.util.Date;
        if (r0 == 0) goto L_0x001d;
    L_0x0011:
        r4 = new java.sql.Date;
        r6 = (java.util.Date) r6;
        r5 = r6.getTime();
        r4.<init>(r5);
        goto L_0x002c;
    L_0x001d:
        r0 = r6 instanceof java.lang.Number;
        if (r0 == 0) goto L_0x002d;
    L_0x0021:
        r4 = new java.sql.Date;
        r6 = (java.lang.Number) r6;
        r5 = r6.longValue();
        r4.<init>(r5);
    L_0x002c:
        return r4;
    L_0x002d:
        r0 = r6 instanceof java.lang.String;
        if (r0 == 0) goto L_0x0075;
    L_0x0031:
        r6 = (java.lang.String) r6;
        r0 = r6.length();
        if (r0 != 0) goto L_0x003a;
    L_0x0039:
        return r5;
    L_0x003a:
        r5 = new com.alibaba.fastjson.parser.d;
        r5.<init>(r6);
        r0 = r5.D();	 Catch:{ all -> 0x0070 }
        if (r0 == 0) goto L_0x004e;	 Catch:{ all -> 0x0070 }
    L_0x0045:
        r4 = r5.C();	 Catch:{ all -> 0x0070 }
        r0 = r4.getTimeInMillis();	 Catch:{ all -> 0x0070 }
        goto L_0x0067;	 Catch:{ all -> 0x0070 }
    L_0x004e:
        r4 = r4.a();	 Catch:{ all -> 0x0070 }
        r4 = r4.parse(r6);	 Catch:{ ParseException -> 0x0063 }
        r0 = new java.sql.Date;	 Catch:{ ParseException -> 0x0063 }
        r1 = r4.getTime();	 Catch:{ ParseException -> 0x0063 }
        r0.<init>(r1);	 Catch:{ ParseException -> 0x0063 }
        r5.close();
        return r0;
    L_0x0063:
        r0 = java.lang.Long.parseLong(r6);	 Catch:{ all -> 0x0070 }
    L_0x0067:
        r5.close();
        r4 = new java.sql.Date;
        r4.<init>(r0);
        return r4;
    L_0x0070:
        r4 = move-exception;
        r5.close();
        throw r4;
    L_0x0075:
        r4 = new com.alibaba.fastjson.JSONException;
        r5 = new java.lang.StringBuilder;
        r0 = "parse error : ";
        r5.<init>(r0);
        r5.append(r6);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.a.v.b(com.alibaba.fastjson.parser.a, java.lang.reflect.Type, java.lang.Object):T");
    }

    private static <T> T a(com.alibaba.fastjson.parser.a r4, java.lang.Object r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5 instanceof java.util.Date;
        if (r1 == 0) goto L_0x0014;
    L_0x0008:
        r4 = new java.sql.Timestamp;
        r5 = (java.util.Date) r5;
        r0 = r5.getTime();
        r4.<init>(r0);
        return r4;
    L_0x0014:
        r1 = r5 instanceof java.lang.Number;
        if (r1 == 0) goto L_0x0024;
    L_0x0018:
        r4 = new java.sql.Timestamp;
        r5 = (java.lang.Number) r5;
        r0 = r5.longValue();
        r4.<init>(r0);
        return r4;
    L_0x0024:
        r1 = r5 instanceof java.lang.String;
        if (r1 == 0) goto L_0x006c;
    L_0x0028:
        r5 = (java.lang.String) r5;
        r1 = r5.length();
        if (r1 != 0) goto L_0x0031;
    L_0x0030:
        return r0;
    L_0x0031:
        r0 = new com.alibaba.fastjson.parser.d;
        r0.<init>(r5);
        r1 = r0.D();	 Catch:{ all -> 0x0067 }
        if (r1 == 0) goto L_0x0045;	 Catch:{ all -> 0x0067 }
    L_0x003c:
        r4 = r0.C();	 Catch:{ all -> 0x0067 }
        r4 = r4.getTimeInMillis();	 Catch:{ all -> 0x0067 }
        goto L_0x005e;	 Catch:{ all -> 0x0067 }
    L_0x0045:
        r4 = r4.a();	 Catch:{ all -> 0x0067 }
        r4 = r4.parse(r5);	 Catch:{ ParseException -> 0x005a }
        r1 = new java.sql.Timestamp;	 Catch:{ ParseException -> 0x005a }
        r2 = r4.getTime();	 Catch:{ ParseException -> 0x005a }
        r1.<init>(r2);	 Catch:{ ParseException -> 0x005a }
        r0.close();
        return r1;
    L_0x005a:
        r4 = java.lang.Long.parseLong(r5);	 Catch:{ all -> 0x0067 }
    L_0x005e:
        r0.close();
        r0 = new java.sql.Timestamp;
        r0.<init>(r4);
        return r0;
    L_0x0067:
        r4 = move-exception;
        r0.close();
        throw r4;
    L_0x006c:
        r4 = new com.alibaba.fastjson.JSONException;
        r5 = "parse error";
        r4.<init>(r5);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.a.v.a(com.alibaba.fastjson.parser.a, java.lang.Object):T");
    }
}
