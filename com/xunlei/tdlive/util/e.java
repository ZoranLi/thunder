package com.xunlei.tdlive.util;

import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.r;
import com.android.volley.toolbox.ah;
import com.android.volley.toolbox.ak;
import com.umeng.message.util.HttpRequest;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: HttpUtils */
public class e {
    private static e a;
    private static Executor b;

    /* compiled from: HttpUtils */
    public static class a extends Exception {
        private int a = null;

        public a(Throwable th, int i) {
            super(th);
            this.a = i;
        }
    }

    /* compiled from: HttpUtils */
    public static class b {
        private a a;

        /* compiled from: HttpUtils */
        private interface a {
            void a();
        }

        public b(a aVar) {
            this.a = aVar;
        }

        public void a() {
            this.a.a();
        }
    }

    /* compiled from: HttpUtils */
    public enum c {
        GET,
        POST;

        public final String toString() {
            return this == GET ? "GET" : "POST";
        }
    }

    /* compiled from: HttpUtils */
    public interface e {
        void a(c cVar, String str, h hVar);
    }

    /* compiled from: HttpUtils */
    public static class h {
        private ConcurrentHashMap<String, String> a = new ConcurrentHashMap();
        private ak b = new ak();
        private String c;
        private String d;
        private boolean e = false;
        private int f = 2500;
        private int g = 2;

        public void a(String str, String str2) {
            this.a.put(str, str2);
        }

        public void a(String str, File file) {
            this.b.a(str, file);
        }

        public void a(String str, int i) {
            this.b.a(str, i);
        }

        public void b(String str, String str2) {
            this.b.a(str, str2);
        }

        public void a(String str) {
            this.d = str;
        }

        public String a() {
            return this.d;
        }

        public void a(int i) {
            this.f = i;
        }

        public void b(int i) {
            this.g = i;
        }

        public void b(String str) {
            this.c = str;
        }
    }

    /* compiled from: HttpUtils */
    public static class j<T> {
        public T a;
        public int b;
        public String c;
        public Map<String, String> d;
    }

    /* compiled from: HttpUtils */
    public static abstract class f<T> implements com.android.volley.n.a, com.android.volley.n.b<j<T>> {
        public abstract void onFailure(a aVar, String str);

        public void onParseNetworkResponse(com.android.volley.j jVar) {
        }

        public T onParseResult(String str) {
            return str;
        }

        public void onProgress(long j, long j2) {
        }

        public abstract void onSuccess(j<T> jVar);

        public void onErrorResponse(VolleyError volleyError) {
            try {
                onFailure(new a(volleyError, volleyError.networkResponse == null ? 0 : volleyError.networkResponse.a), volleyError.getMessage());
            } catch (VolleyError volleyError2) {
                XLog.printStackTrace("HttpUtils", volleyError2);
            }
        }

        public void onResponse(j<T> jVar) {
            try {
                onSuccess(jVar);
            } catch (j<T> jVar2) {
                XLog.printStackTrace("HttpUtils", jVar2);
            }
        }
    }

    /* compiled from: HttpUtils */
    private static class i implements a {
        private Request<?> a;

        public i(Request<?> request) {
            this.a = request;
        }

        public void a() {
            this.a.cancel();
        }
    }

    /* compiled from: HttpUtils */
    private class d<T> extends r<j<T>> {
        protected h a;
        final /* synthetic */ e b;
        private String c;
        private f<T> d = null;
        private ah e = null;
        private int f = null;

        private d<?> a() {
            return this;
        }

        protected /* synthetic */ void deliverResponse(Object obj) {
            a((j) obj);
        }

        public d(e eVar, int i, h hVar, String str, f<T> fVar) {
            this.b = eVar;
            super(i, str, fVar);
            this.a = hVar;
            this.d = fVar;
            this.e = hVar.b.b();
        }

        public String getUrl() {
            if (this.c == null || this.c.length() <= 0) {
                return super.getUrl();
            }
            return this.c;
        }

        public byte[] getBody() throws AuthFailureError {
            if (this.a.d != null) {
                try {
                    return this.a.d.getBytes(getParamsEncoding());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return null;
                }
            } else if (!TextUtils.isEmpty(this.a.c) && HttpRequest.CONTENT_TYPE_JSON.equals(this.a.c)) {
                return this.a.b.a().toString().getBytes();
            } else {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (this.e != null) {
                    try {
                        this.e.a(byteArrayOutputStream);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return byteArrayOutputStream.toByteArray();
            }
        }

        public Map<String, String> getHeaders() throws AuthFailureError {
            return this.a.a;
        }

        public String getBodyContentType() {
            if (TextUtils.isEmpty(this.a.c)) {
                return this.e.a().b();
            }
            return this.a.c;
        }

        protected com.android.volley.n<com.xunlei.tdlive.util.e.j<T>> parseNetworkResponse(com.android.volley.j r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r5 = this;
            r0 = r5.d;
            r0.onParseNetworkResponse(r6);
            r0 = new com.xunlei.tdlive.util.e$j;	 Catch:{ Throwable -> 0x0053 }
            r0.<init>();	 Catch:{ Throwable -> 0x0053 }
            r1 = r6.c;	 Catch:{ Throwable -> 0x0053 }
            r2 = "ISO-8859-1";	 Catch:{ Throwable -> 0x0053 }
            r1 = com.android.volley.toolbox.k.a(r1, r2);	 Catch:{ Throwable -> 0x0053 }
            r2 = "ISO-8859-1";	 Catch:{ Throwable -> 0x0053 }
            r2 = r1.equals(r2);	 Catch:{ Throwable -> 0x0053 }
            if (r2 == 0) goto L_0x001c;	 Catch:{ Throwable -> 0x0053 }
        L_0x001a:
            r1 = "UTF-8";	 Catch:{ Throwable -> 0x0053 }
        L_0x001c:
            r2 = r5.d;	 Catch:{ Throwable -> 0x0053 }
            r2 = r2 instanceof com.xunlei.tdlive.util.e.g;	 Catch:{ Throwable -> 0x0053 }
            if (r2 == 0) goto L_0x002f;	 Catch:{ Throwable -> 0x0053 }
        L_0x0022:
            r1 = r5.d;	 Catch:{ Throwable -> 0x0053 }
            r1 = (com.xunlei.tdlive.util.e.g) r1;	 Catch:{ Throwable -> 0x0053 }
            r2 = r6.b;	 Catch:{ Throwable -> 0x0053 }
            r1 = r1.a(r2);	 Catch:{ Throwable -> 0x0053 }
            r0.a = r1;	 Catch:{ Throwable -> 0x0053 }
            goto L_0x003e;	 Catch:{ Throwable -> 0x0053 }
        L_0x002f:
            r2 = r5.d;	 Catch:{ Throwable -> 0x0053 }
            r3 = new java.lang.String;	 Catch:{ Throwable -> 0x0053 }
            r4 = r6.b;	 Catch:{ Throwable -> 0x0053 }
            r3.<init>(r4, r1);	 Catch:{ Throwable -> 0x0053 }
            r1 = r2.onParseResult(r3);	 Catch:{ Throwable -> 0x0053 }
            r0.a = r1;	 Catch:{ Throwable -> 0x0053 }
        L_0x003e:
            r1 = r6.a;	 Catch:{ Throwable -> 0x0053 }
            r0.b = r1;	 Catch:{ Throwable -> 0x0053 }
            r1 = "success";	 Catch:{ Throwable -> 0x0053 }
            r0.c = r1;	 Catch:{ Throwable -> 0x0053 }
            r1 = r6.c;	 Catch:{ Throwable -> 0x0053 }
            r0.d = r1;	 Catch:{ Throwable -> 0x0053 }
            r1 = com.android.volley.toolbox.k.a(r6);	 Catch:{ Throwable -> 0x0053 }
            r0 = com.android.volley.n.a(r0, r1);	 Catch:{ Throwable -> 0x0053 }
            return r0;
        L_0x0053:
            r0 = new com.android.volley.ParseError;
            r0.<init>(r6);
            r6 = com.android.volley.n.a(r0);
            return r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.util.e.d.parseNetworkResponse(com.android.volley.j):com.android.volley.n<com.xunlei.tdlive.util.e$j<T>>");
        }

        protected void a(com.xunlei.tdlive.util.e.j<T> r2) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r0 = r1.d;	 Catch:{ Throwable -> 0x0006 }
            r0.onResponse(r2);	 Catch:{ Throwable -> 0x0006 }
            return;
        L_0x0006:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.util.e.d.a(com.xunlei.tdlive.util.e$j):void");
        }

        public void deliverError(com.android.volley.VolleyError r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = r4.getCause();
            r0 = r0 instanceof java.io.IOException;
            if (r0 != 0) goto L_0x006f;
        L_0x0008:
            r0 = r4.getCause();
            r0 = r0 instanceof java.net.UnknownHostException;
            if (r0 == 0) goto L_0x0011;
        L_0x0010:
            goto L_0x006f;
        L_0x0011:
            r0 = r4 instanceof com.android.volley.ServerError;
            if (r0 == 0) goto L_0x0088;
        L_0x0015:
            r0 = r4.networkResponse;
            if (r0 == 0) goto L_0x0088;
        L_0x0019:
            r0 = r4.networkResponse;
            r0 = r0.a;
            r1 = 301; // 0x12d float:4.22E-43 double:1.487E-321;
            if (r0 == r1) goto L_0x0029;
        L_0x0021:
            r0 = r4.networkResponse;
            r0 = r0.a;
            r1 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
            if (r0 != r1) goto L_0x0088;
        L_0x0029:
            r0 = r4.networkResponse;
            r0 = r0.c;
            if (r0 == 0) goto L_0x0088;
        L_0x002f:
            r0 = r4.networkResponse;
            r0 = r0.c;
            r1 = "Set-Cookie";
            r0 = r0.get(r1);
            r0 = (java.lang.String) r0;
            r1 = r4.networkResponse;
            r1 = r1.c;
            r2 = "Location";
            r1 = r1.get(r2);
            r1 = (java.lang.String) r1;
            r3.c = r1;
            r1 = r3.c;
            if (r1 == 0) goto L_0x0088;
        L_0x004d:
            if (r0 == 0) goto L_0x0056;
        L_0x004f:
            r1 = r3.a;
            r2 = "Cookie";
            r1.a(r2, r0);
        L_0x0056:
            r0 = r3.f;
            r1 = r0 + 1;
            r3.f = r1;
            r1 = 3;
            if (r0 >= r1) goto L_0x0088;
        L_0x005f:
            r4 = com.android.volley.a.c.a();
            r4 = r4.b();
            r0 = r3.a();
            r4.a(r0);
            return;
        L_0x006f:
            r0 = r3.getRetryPolicy();
            if (r0 == 0) goto L_0x0088;
        L_0x0075:
            r0.a(r4);	 Catch:{ Throwable -> 0x0088 }
            r0 = com.android.volley.a.c.a();	 Catch:{ Throwable -> 0x0088 }
            r0 = r0.b();	 Catch:{ Throwable -> 0x0088 }
            r1 = r3.a();	 Catch:{ Throwable -> 0x0088 }
            r0.a(r1);	 Catch:{ Throwable -> 0x0088 }
            return;
        L_0x0088:
            super.deliverError(r4);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.util.e.d.deliverError(com.android.volley.VolleyError):void");
        }
    }

    /* compiled from: HttpUtils */
    public static abstract class g<T> extends f<T> {
        protected T a(byte[] bArr) {
            return bArr;
        }
    }

    public <T> b a(c cVar, String str, h hVar, f<T> fVar) {
        if (a != null) {
            a.a(cVar, str, hVar);
        }
        return a(new d(this, cVar.ordinal(), hVar, str, fVar), hVar.e, hVar.f, hVar.g);
    }

    private b a(Request<?> request, boolean z, int i, int i2) {
        request.setShouldCache(z);
        if (request.getMethod()) {
            i2 = 0;
        }
        request.setRetryPolicy(new com.android.volley.d(i, i2, 1.0f));
        return new b(new i(com.android.volley.a.c.a().b().a(request)));
    }
}
