package com.alibaba.fastjson.parser.a;

import java.lang.reflect.Constructor;

/* compiled from: ThrowableDeserializer */
public final class x extends m {
    public final int e_() {
        return 12;
    }

    public x(Class<?> cls) {
        super(cls, cls);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T a(com.alibaba.fastjson.parser.a r12, java.lang.reflect.Type r13, java.lang.Object r14) {
        /*
        r11 = this;
        r14 = r12.e;
        r0 = r14.a();
        r1 = 8;
        r2 = 0;
        if (r0 != r1) goto L_0x000f;
    L_0x000b:
        r14.d();
        return r2;
    L_0x000f:
        r0 = r12.g;
        r3 = 2;
        if (r0 != r3) goto L_0x0018;
    L_0x0014:
        r0 = 0;
        r12.g = r0;
        goto L_0x0028;
    L_0x0018:
        r0 = r14.a();
        r3 = 12;
        if (r0 == r3) goto L_0x0028;
    L_0x0020:
        r12 = new com.alibaba.fastjson.JSONException;
        r13 = "syntax error";
        r12.<init>(r13);
        throw r12;
    L_0x0028:
        if (r13 == 0) goto L_0x0039;
    L_0x002a:
        r0 = r13 instanceof java.lang.Class;
        if (r0 == 0) goto L_0x0039;
    L_0x002e:
        r13 = (java.lang.Class) r13;
        r0 = java.lang.Throwable.class;
        r0 = r0.isAssignableFrom(r13);
        if (r0 == 0) goto L_0x0039;
    L_0x0038:
        goto L_0x003a;
    L_0x0039:
        r13 = r2;
    L_0x003a:
        r0 = new java.util.HashMap;
        r0.<init>();
        r4 = r13;
        r13 = r2;
        r3 = r13;
        r5 = r3;
    L_0x0043:
        r6 = r12.b;
        r6 = r14.a(r6);
        r7 = 13;
        r8 = 16;
        if (r6 != 0) goto L_0x0068;
    L_0x004f:
        r9 = r14.a();
        if (r9 != r7) goto L_0x005a;
    L_0x0055:
        r14.a(r8);
        goto L_0x00ee;
    L_0x005a:
        r9 = r14.a();
        if (r9 != r8) goto L_0x0068;
    L_0x0060:
        r9 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas;
        r9 = r14.a(r9);
        if (r9 != 0) goto L_0x0043;
    L_0x0068:
        r14.p();
        r9 = com.alibaba.fastjson.a.DEFAULT_TYPE_KEY;
        r9 = r9.equals(r6);
        r10 = 4;
        if (r9 == 0) goto L_0x0096;
    L_0x0074:
        r4 = r14.a();
        if (r4 != r10) goto L_0x008e;
    L_0x007a:
        r4 = r14.l();
        r6 = r12.b();
        r6 = r6.b();
        r4 = com.alibaba.fastjson.c.j.a(r4, r6);
        r14.a(r8);
        goto L_0x00e5;
    L_0x008e:
        r12 = new com.alibaba.fastjson.JSONException;
        r13 = "syntax error";
        r12.<init>(r13);
        throw r12;
    L_0x0096:
        r9 = "message";
        r9 = r9.equals(r6);
        if (r9 == 0) goto L_0x00bc;
    L_0x009e:
        r13 = r14.a();
        if (r13 != r1) goto L_0x00a6;
    L_0x00a4:
        r13 = r2;
        goto L_0x00b0;
    L_0x00a6:
        r13 = r14.a();
        if (r13 != r10) goto L_0x00b4;
    L_0x00ac:
        r13 = r14.l();
    L_0x00b0:
        r14.d();
        goto L_0x00e5;
    L_0x00b4:
        r12 = new com.alibaba.fastjson.JSONException;
        r13 = "syntax error";
        r12.<init>(r13);
        throw r12;
    L_0x00bc:
        r9 = "cause";
        r9 = r9.equals(r6);
        if (r9 == 0) goto L_0x00cd;
    L_0x00c4:
        r3 = "cause";
        r3 = r11.a(r12, r2, r3);
        r3 = (java.lang.Throwable) r3;
        goto L_0x00e5;
    L_0x00cd:
        r9 = "stackTrace";
        r9 = r9.equals(r6);
        if (r9 == 0) goto L_0x00de;
    L_0x00d5:
        r5 = java.lang.StackTraceElement[].class;
        r5 = r12.a(r5, r2);
        r5 = (java.lang.StackTraceElement[]) r5;
        goto L_0x00e5;
    L_0x00de:
        r9 = r12.a(r2);
        r0.put(r6, r9);
    L_0x00e5:
        r6 = r14.a();
        if (r6 != r7) goto L_0x0043;
    L_0x00eb:
        r14.a(r8);
    L_0x00ee:
        if (r4 != 0) goto L_0x00f6;
    L_0x00f0:
        r12 = new java.lang.Exception;
        r12.<init>(r13, r3);
        goto L_0x0101;
    L_0x00f6:
        r12 = a(r13, r3, r4);	 Catch:{ Exception -> 0x0107 }
        if (r12 != 0) goto L_0x0101;
    L_0x00fc:
        r12 = new java.lang.Exception;	 Catch:{ Exception -> 0x0107 }
        r12.<init>(r13, r3);	 Catch:{ Exception -> 0x0107 }
    L_0x0101:
        if (r5 == 0) goto L_0x0106;
    L_0x0103:
        r12.setStackTrace(r5);
    L_0x0106:
        return r12;
    L_0x0107:
        r12 = move-exception;
        r13 = new com.alibaba.fastjson.JSONException;
        r14 = "create instance error";
        r13.<init>(r14, r12);
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.a.x.a(com.alibaba.fastjson.parser.a, java.lang.reflect.Type, java.lang.Object):T");
    }

    private static Throwable a(String str, Throwable th, Class<?> cls) throws Exception {
        Constructor constructor = null;
        Constructor constructor2 = constructor;
        Constructor constructor3 = constructor2;
        for (Constructor constructor4 : cls.getConstructors()) {
            Class[] parameterTypes = constructor4.getParameterTypes();
            if (parameterTypes.length == 0) {
                constructor3 = constructor4;
            } else if (parameterTypes.length == 1 && parameterTypes[0] == String.class) {
                constructor2 = constructor4;
            } else if (parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1] == Throwable.class) {
                constructor = constructor4;
            }
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(new Object[]{str, th});
        } else if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(new Object[]{str});
        } else if (constructor3 != null) {
            return (Throwable) constructor3.newInstance(new Object[0]);
        } else {
            return null;
        }
    }
}
