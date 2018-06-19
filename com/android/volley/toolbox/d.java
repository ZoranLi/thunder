package com.android.volley.toolbox;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.a.a;
import com.android.volley.g;
import com.android.volley.h;
import com.android.volley.p;
import com.android.volley.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

/* compiled from: BasicNetwork */
public final class d implements h {
    protected static final boolean a = q.b;
    @Deprecated
    protected final m b;
    protected final g c;
    private final c d;

    @Deprecated
    public d(m mVar) {
        this(mVar, new g());
    }

    @Deprecated
    private d(m mVar, g gVar) {
        this.b = mVar;
        this.d = new a(mVar);
        this.c = gVar;
    }

    public d(c cVar) {
        this(cVar, new g());
    }

    private d(c cVar, g gVar) {
        this.d = cVar;
        this.b = cVar;
        this.c = gVar;
    }

    public final com.android.volley.j a(com.android.volley.Request<?> r28) throws com.android.volley.VolleyError {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r27 = this;
        r1 = r27;
        r2 = r28;
        r3 = android.os.SystemClock.elapsedRealtime();
    L_0x0008:
        r5 = java.util.Collections.emptyList();
        r8 = 0;
        r9 = 0;
        r10 = r28.getCacheEntry();	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
        if (r10 != 0) goto L_0x0019;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
    L_0x0014:
        r10 = java.util.Collections.emptyMap();	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
        goto L_0x0046;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
    L_0x0019:
        r11 = new java.util.HashMap;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
        r11.<init>();	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
        r12 = r10.b;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
        if (r12 == 0) goto L_0x0029;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
    L_0x0022:
        r12 = "If-None-Match";	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
        r13 = r10.b;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
        r11.put(r12, r13);	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
    L_0x0029:
        r12 = r10.d;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
        r14 = 0;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
        r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
        if (r16 <= 0) goto L_0x0045;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
    L_0x0031:
        r12 = "If-Modified-Since";	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
        r13 = r10.d;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
        r10 = com.android.volley.toolbox.k.a();	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
        r15 = new java.util.Date;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
        r15.<init>(r13);	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
        r10 = r10.format(r15);	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
        r11.put(r12, r10);	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
    L_0x0045:
        r10 = r11;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
    L_0x0046:
        r11 = r1.d;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
        r10 = r11.a(r2, r10);	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0120 }
        r12 = r10.a;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x011b }
        r11 = r10.b;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x011b }
        r11 = java.util.Collections.unmodifiableList(r11);	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x011b }
        r5 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r12 != r5) goto L_0x0093;
    L_0x0058:
        r5 = r28.getCacheEntry();	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        if (r5 != 0) goto L_0x0072;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
    L_0x005e:
        r5 = new com.android.volley.j;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        r14 = 304; // 0x130 float:4.26E-43 double:1.5E-321;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        r15 = 0;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        r16 = 1;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        r12 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        r17 = r12 - r3;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        r13 = r5;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        r19 = r11;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        r13.<init>(r14, r15, r16, r17, r19);	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        return r5;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
    L_0x0072:
        r25 = a(r11, r5);	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        r12 = new com.android.volley.j;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        r20 = 304; // 0x130 float:4.26E-43 double:1.5E-321;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        r5 = r5.a;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        r22 = 1;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        r13 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        r23 = r13 - r3;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        r19 = r12;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        r21 = r5;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        r19.<init>(r20, r21, r22, r23, r25);	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        return r12;
    L_0x008c:
        r0 = move-exception;
        r5 = r0;
        r13 = r8;
        r17 = r11;
        goto L_0x0126;
    L_0x0093:
        r5 = r10.d;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0114 }
        if (r5 == 0) goto L_0x009e;
    L_0x0097:
        r13 = r10.c;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        r5 = r1.a(r5, r13);	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x008c }
        goto L_0x00a0;
    L_0x009e:
        r5 = new byte[r9];	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x0114 }
    L_0x00a0:
        r13 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        r6 = r13 - r3;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        r8 = a;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        if (r8 != 0) goto L_0x00b0;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
    L_0x00aa:
        r13 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        r8 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1));	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        if (r8 <= 0) goto L_0x00ea;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
    L_0x00b0:
        r8 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]";	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        r13 = 5;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        r13 = new java.lang.Object[r13];	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        r13[r9] = r2;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        r7 = 1;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        r13[r7] = r6;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        if (r5 == 0) goto L_0x00cc;
    L_0x00c0:
        r6 = r5.length;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x00c6 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x00c6 }
        goto L_0x00ce;
    L_0x00c6:
        r0 = move-exception;
        r13 = r5;
        r17 = r11;
        goto L_0x0125;
    L_0x00cc:
        r6 = "null";	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
    L_0x00ce:
        r7 = 2;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        r13[r7] = r6;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        r6 = 3;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        r7 = java.lang.Integer.valueOf(r12);	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        r13[r6] = r7;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        r6 = 4;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        r7 = r28.getRetryPolicy();	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        r7 = r7.b();	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        r13[r6] = r7;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        com.android.volley.q.b(r8, r13);	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
    L_0x00ea:
        r6 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        if (r12 < r6) goto L_0x0105;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
    L_0x00ee:
        r6 = 299; // 0x12b float:4.19E-43 double:1.477E-321;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        if (r12 <= r6) goto L_0x00f3;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
    L_0x00f2:
        goto L_0x0105;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
    L_0x00f3:
        r6 = new com.android.volley.j;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        r14 = 0;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        r7 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010e }
        r15 = r7 - r3;
        r7 = r11;
        r11 = r6;
        r13 = r5;
        r17 = r7;
        r11.<init>(r12, r13, r14, r15, r17);	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010c }
        return r6;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010c }
    L_0x0105:
        r7 = r11;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010c }
        r6 = new java.io.IOException;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010c }
        r6.<init>();	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010c }
        throw r6;	 Catch:{ SocketTimeoutException -> 0x01c4, MalformedURLException -> 0x01aa, IOException -> 0x010c }
    L_0x010c:
        r0 = move-exception;
        goto L_0x0110;
    L_0x010e:
        r0 = move-exception;
        r7 = r11;
    L_0x0110:
        r13 = r5;
        r17 = r7;
        goto L_0x0125;
    L_0x0114:
        r0 = move-exception;
        r7 = r11;
        r5 = r0;
        r17 = r7;
        r13 = r8;
        goto L_0x0126;
    L_0x011b:
        r0 = move-exception;
        r17 = r5;
        r13 = r8;
        goto L_0x0125;
    L_0x0120:
        r0 = move-exception;
        r17 = r5;
        r10 = r8;
        r13 = r10;
    L_0x0125:
        r5 = r0;
    L_0x0126:
        if (r10 == 0) goto L_0x01a4;
    L_0x0128:
        r5 = r10.a;
        r6 = "Unexpected response code %d for %s";
        r7 = 2;
        r7 = new java.lang.Object[r7];
        r8 = java.lang.Integer.valueOf(r5);
        r7[r9] = r8;
        r8 = r28.getUrl();
        r9 = 1;
        r7[r9] = r8;
        com.android.volley.q.c(r6, r7);
        if (r13 == 0) goto L_0x0198;
    L_0x0141:
        r6 = new com.android.volley.j;
        r14 = 0;
        r7 = android.os.SystemClock.elapsedRealtime();
        r15 = r7 - r3;
        r11 = r6;
        r12 = r5;
        r11.<init>(r12, r13, r14, r15, r17);
        r7 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r5 == r7) goto L_0x018c;
    L_0x0153:
        r7 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r5 != r7) goto L_0x0158;
    L_0x0157:
        goto L_0x018c;
    L_0x0158:
        r7 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r5 < r7) goto L_0x0166;
    L_0x015c:
        r7 = 499; // 0x1f3 float:6.99E-43 double:2.465E-321;
        if (r5 > r7) goto L_0x0166;
    L_0x0160:
        r2 = new com.android.volley.ClientError;
        r2.<init>(r6);
        throw r2;
    L_0x0166:
        r7 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r5 < r7) goto L_0x0186;
    L_0x016a:
        r7 = 599; // 0x257 float:8.4E-43 double:2.96E-321;
        if (r5 > r7) goto L_0x0186;
    L_0x016e:
        r5 = r28.shouldRetryServerErrors();
        if (r5 == 0) goto L_0x0180;
    L_0x0174:
        r5 = "server";
        r7 = new com.android.volley.ServerError;
        r7.<init>(r6);
        a(r5, r2, r7);
        goto L_0x0008;
    L_0x0180:
        r2 = new com.android.volley.ServerError;
        r2.<init>(r6);
        throw r2;
    L_0x0186:
        r2 = new com.android.volley.ServerError;
        r2.<init>(r6);
        throw r2;
    L_0x018c:
        r5 = "auth";
        r7 = new com.android.volley.AuthFailureError;
        r7.<init>(r6);
        a(r5, r2, r7);
        goto L_0x0008;
    L_0x0198:
        r5 = "network";
        r6 = new com.android.volley.NetworkError;
        r6.<init>();
        a(r5, r2, r6);
        goto L_0x0008;
    L_0x01a4:
        r2 = new com.android.volley.NoConnectionError;
        r2.<init>(r5);
        throw r2;
    L_0x01aa:
        r0 = move-exception;
        r3 = r0;
        r4 = new java.lang.RuntimeException;
        r5 = new java.lang.StringBuilder;
        r6 = "Bad URL ";
        r5.<init>(r6);
        r2 = r28.getUrl();
        r5.append(r2);
        r2 = r5.toString();
        r4.<init>(r2, r3);
        throw r4;
    L_0x01c4:
        r5 = "socket";
        r6 = new com.android.volley.TimeoutError;
        r6.<init>();
        a(r5, r2, r6);
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.d.a(com.android.volley.Request):com.android.volley.j");
    }

    private static void a(String str, Request<?> request, VolleyError volleyError) throws VolleyError {
        p retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.a(volleyError);
            request.addMarker(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(timeoutMs)}));
        } catch (VolleyError volleyError2) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(timeoutMs)}));
            throw volleyError2;
        }
    }

    private byte[] a(java.io.InputStream r6, int r7) throws java.io.IOException, com.android.volley.ServerError {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = new com.android.volley.toolbox.y;
        r1 = r5.c;
        r0.<init>(r1, r7);
        r7 = 0;
        r1 = 0;
        if (r6 != 0) goto L_0x0013;
    L_0x000b:
        r2 = new com.android.volley.ServerError;	 Catch:{ all -> 0x0011 }
        r2.<init>();	 Catch:{ all -> 0x0011 }
        throw r2;	 Catch:{ all -> 0x0011 }
    L_0x0011:
        r2 = move-exception;	 Catch:{ all -> 0x0011 }
        goto L_0x0044;	 Catch:{ all -> 0x0011 }
    L_0x0013:
        r2 = r5.c;	 Catch:{ all -> 0x0011 }
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ all -> 0x0011 }
        r2 = r2.a(r3);	 Catch:{ all -> 0x0011 }
    L_0x001b:
        r1 = r6.read(r2);	 Catch:{ all -> 0x0040 }
        r3 = -1;	 Catch:{ all -> 0x0040 }
        if (r1 == r3) goto L_0x0026;	 Catch:{ all -> 0x0040 }
    L_0x0022:
        r0.write(r2, r7, r1);	 Catch:{ all -> 0x0040 }
        goto L_0x001b;	 Catch:{ all -> 0x0040 }
    L_0x0026:
        r1 = r0.toByteArray();	 Catch:{ all -> 0x0040 }
        if (r6 == 0) goto L_0x0037;
    L_0x002c:
        r6.close();	 Catch:{ IOException -> 0x0030 }
        goto L_0x0037;
    L_0x0030:
        r6 = "Error occurred when closing InputStream";
        r7 = new java.lang.Object[r7];
        com.android.volley.q.a(r6, r7);
    L_0x0037:
        r6 = r5.c;
        r6.a(r2);
        r0.close();
        return r1;
    L_0x0040:
        r1 = move-exception;
        r4 = r2;
        r2 = r1;
        r1 = r4;
    L_0x0044:
        if (r6 == 0) goto L_0x0051;
    L_0x0046:
        r6.close();	 Catch:{ IOException -> 0x004a }
        goto L_0x0051;
    L_0x004a:
        r6 = "Error occurred when closing InputStream";
        r7 = new java.lang.Object[r7];
        com.android.volley.q.a(r6, r7);
    L_0x0051:
        r6 = r5.c;
        r6.a(r1);
        r0.close();
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.d.a(java.io.InputStream, int):byte[]");
    }

    private static List<g> a(List<g> list, a aVar) {
        Set treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            for (g gVar : list) {
                treeSet.add(gVar.a);
            }
        }
        List<g> arrayList = new ArrayList(list);
        if (aVar.h != null) {
            if (aVar.h.isEmpty() == null) {
                for (g gVar2 : aVar.h) {
                    if (!treeSet.contains(gVar2.a)) {
                        arrayList.add(gVar2);
                    }
                }
            }
        } else if (aVar.g.isEmpty() == null) {
            list = aVar.g.entrySet().iterator();
            while (list.hasNext() != null) {
                Entry entry = (Entry) list.next();
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new g((String) entry.getKey(), (String) entry.getValue()));
                }
            }
        }
        return arrayList;
    }
}
