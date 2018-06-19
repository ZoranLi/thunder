package com.alibaba.fastjson.parser.a;

/* compiled from: StackTraceElementDeserializer */
public final class w implements r {
    public static final w a = new w();

    public final int e_() {
        return 12;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T a(com.alibaba.fastjson.parser.a r12, java.lang.reflect.Type r13, java.lang.Object r14) {
        /*
        r11 = this;
        r13 = r12.e;
        r14 = r13.a();
        r0 = 0;
        r1 = 8;
        if (r14 != r1) goto L_0x000f;
    L_0x000b:
        r13.d();
        return r0;
    L_0x000f:
        r14 = r13.a();
        r2 = 12;
        r3 = 16;
        if (r14 == r2) goto L_0x003b;
    L_0x0019:
        r14 = r13.a();
        if (r14 == r3) goto L_0x003b;
    L_0x001f:
        r12 = new com.alibaba.fastjson.JSONException;
        r14 = new java.lang.StringBuilder;
        r0 = "syntax error: ";
        r14.<init>(r0);
        r13 = r13.a();
        r13 = com.alibaba.fastjson.parser.e.a(r13);
        r14.append(r13);
        r13 = r14.toString();
        r12.<init>(r13);
        throw r12;
    L_0x003b:
        r14 = 0;
        r6 = r14;
        r2 = r0;
        r4 = r2;
        r5 = r4;
    L_0x0040:
        r7 = r12.b;
        r7 = r13.a(r7);
        r8 = 13;
        if (r7 != 0) goto L_0x0063;
    L_0x004a:
        r9 = r13.a();
        if (r9 != r8) goto L_0x0055;
    L_0x0050:
        r13.a(r3);
        goto L_0x016d;
    L_0x0055:
        r9 = r13.a();
        if (r9 != r3) goto L_0x0063;
    L_0x005b:
        r9 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas;
        r9 = r13.a(r9);
        if (r9 != 0) goto L_0x0040;
    L_0x0063:
        r13.p();
        r9 = "className";
        r9 = r9.equals(r7);
        r10 = 4;
        if (r9 == 0) goto L_0x008c;
    L_0x006f:
        r2 = r13.a();
        if (r2 != r1) goto L_0x0078;
    L_0x0075:
        r2 = r0;
        goto L_0x0164;
    L_0x0078:
        r2 = r13.a();
        if (r2 != r10) goto L_0x0084;
    L_0x007e:
        r2 = r13.l();
        goto L_0x0164;
    L_0x0084:
        r12 = new com.alibaba.fastjson.JSONException;
        r13 = "syntax error";
        r12.<init>(r13);
        throw r12;
    L_0x008c:
        r9 = "methodName";
        r9 = r9.equals(r7);
        if (r9 == 0) goto L_0x00b1;
    L_0x0094:
        r4 = r13.a();
        if (r4 != r1) goto L_0x009d;
    L_0x009a:
        r4 = r0;
        goto L_0x0164;
    L_0x009d:
        r4 = r13.a();
        if (r4 != r10) goto L_0x00a9;
    L_0x00a3:
        r4 = r13.l();
        goto L_0x0164;
    L_0x00a9:
        r12 = new com.alibaba.fastjson.JSONException;
        r13 = "syntax error";
        r12.<init>(r13);
        throw r12;
    L_0x00b1:
        r9 = "fileName";
        r9 = r9.equals(r7);
        if (r9 == 0) goto L_0x00d6;
    L_0x00b9:
        r5 = r13.a();
        if (r5 != r1) goto L_0x00c2;
    L_0x00bf:
        r5 = r0;
        goto L_0x0164;
    L_0x00c2:
        r5 = r13.a();
        if (r5 != r10) goto L_0x00ce;
    L_0x00c8:
        r5 = r13.l();
        goto L_0x0164;
    L_0x00ce:
        r12 = new com.alibaba.fastjson.JSONException;
        r13 = "syntax error";
        r12.<init>(r13);
        throw r12;
    L_0x00d6:
        r9 = "lineNumber";
        r9 = r9.equals(r7);
        if (r9 == 0) goto L_0x00fc;
    L_0x00de:
        r6 = r13.a();
        if (r6 != r1) goto L_0x00e7;
    L_0x00e4:
        r6 = r14;
        goto L_0x0164;
    L_0x00e7:
        r6 = r13.a();
        r7 = 2;
        if (r6 != r7) goto L_0x00f4;
    L_0x00ee:
        r6 = r13.n();
        goto L_0x0164;
    L_0x00f4:
        r12 = new com.alibaba.fastjson.JSONException;
        r13 = "syntax error";
        r12.<init>(r13);
        throw r12;
    L_0x00fc:
        r9 = "nativeMethod";
        r9 = r9.equals(r7);
        if (r9 == 0) goto L_0x012c;
    L_0x0104:
        r7 = r13.a();
        if (r7 != r1) goto L_0x010e;
    L_0x010a:
        r13.a(r3);
        goto L_0x0164;
    L_0x010e:
        r7 = r13.a();
        r9 = 6;
        if (r7 != r9) goto L_0x0119;
    L_0x0115:
        r13.a(r3);
        goto L_0x0164;
    L_0x0119:
        r7 = r13.a();
        r9 = 7;
        if (r7 != r9) goto L_0x0124;
    L_0x0120:
        r13.a(r3);
        goto L_0x0164;
    L_0x0124:
        r12 = new com.alibaba.fastjson.JSONException;
        r13 = "syntax error";
        r12.<init>(r13);
        throw r12;
    L_0x012c:
        r9 = com.alibaba.fastjson.a.DEFAULT_TYPE_KEY;
        if (r7 != r9) goto L_0x0173;
    L_0x0130:
        r7 = r13.a();
        if (r7 != r10) goto L_0x0156;
    L_0x0136:
        r7 = r13.l();
        r9 = "java.lang.StackTraceElement";
        r9 = r7.equals(r9);
        if (r9 != 0) goto L_0x0164;
    L_0x0142:
        r12 = new com.alibaba.fastjson.JSONException;
        r13 = new java.lang.StringBuilder;
        r14 = "syntax error : ";
        r13.<init>(r14);
        r13.append(r7);
        r13 = r13.toString();
        r12.<init>(r13);
        throw r12;
    L_0x0156:
        r7 = r13.a();
        if (r7 == r1) goto L_0x0164;
    L_0x015c:
        r12 = new com.alibaba.fastjson.JSONException;
        r13 = "syntax error";
        r12.<init>(r13);
        throw r12;
    L_0x0164:
        r7 = r13.a();
        if (r7 != r8) goto L_0x0040;
    L_0x016a:
        r13.a(r3);
    L_0x016d:
        r12 = new java.lang.StackTraceElement;
        r12.<init>(r2, r4, r5, r6);
        return r12;
    L_0x0173:
        r12 = new com.alibaba.fastjson.JSONException;
        r13 = new java.lang.StringBuilder;
        r14 = "syntax error : ";
        r13.<init>(r14);
        r13.append(r7);
        r13 = r13.toString();
        r12.<init>(r13);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.a.w.a(com.alibaba.fastjson.parser.a, java.lang.reflect.Type, java.lang.Object):T");
    }
}
