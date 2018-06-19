package com.qiniu.android.http;

import com.qiniu.android.c.s;
import com.qiniu.android.d.e;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ab$a;
import okhttp3.ab.b;
import okhttp3.ac;
import okhttp3.ag;
import okhttp3.aj;
import org.json.JSONObject;

/* compiled from: Client */
public final class a {
    public final q a;
    private ac b;

    /* compiled from: Client */
    private static class a {
        public String a;
        public long b;

        private a() {
            this.a = "";
            this.b = -1;
        }
    }

    public a() {
        this(null, 10, 30, null, null);
    }

    public a(m mVar, int i, int i2, q qVar, com.qiniu.android.dns.a aVar) {
        this.a = qVar;
        qVar = new okhttp3.ac.a();
        if (mVar != null) {
            qVar.b = new Proxy(mVar.e, new InetSocketAddress(mVar.a, mVar.b));
            if (!(mVar.c == null || mVar.d == null)) {
                qVar.q = new n(mVar);
            }
        }
        if (aVar != null) {
            qVar.t = new b(this, aVar);
        }
        qVar.f.add(new c(this));
        qVar.a((long) i, TimeUnit.SECONDS);
        qVar.b((long) i2, TimeUnit.SECONDS);
        qVar.c(null, TimeUnit.SECONDS);
        this.b = qVar.a();
    }

    public final void a(okhttp3.af.a aVar, e eVar, s sVar, long j, h hVar) {
        if (eVar != null) {
            eVar.a(new e(this, aVar));
        }
        if (sVar != null) {
            aVar.a(HttpRequest.HEADER_USER_AGENT, r.a().a(sVar.c));
        } else {
            aVar.a(HttpRequest.HEADER_USER_AGENT, r.a().a("pandora"));
        }
        a aVar2 = new a();
        eVar = this.b;
        aVar.e = aVar2;
        eVar.a(aVar.a()).a(new f(this, aVar2, sVar, j, hVar));
    }

    public final void a(String str, k kVar, s sVar, l lVar, h hVar, CancellationHandler cancellationHandler) {
        ag a;
        long length;
        a aVar = this;
        k kVar2 = kVar;
        if (kVar2.b != null) {
            a = ag.a(aa.a(kVar2.e), kVar2.b);
            length = kVar2.b.length();
        } else {
            aa a2 = aa.a(kVar2.e);
            byte[] bArr = kVar2.a;
            a = ag.a(a2, bArr, bArr.length);
            length = (long) kVar2.a.length;
        }
        long j = length;
        e eVar = kVar2.c;
        String str2 = kVar2.d;
        String a3 = aVar.a != null ? aVar.a.a() : str;
        ab$a okhttp3_ab_a = new ab$a();
        okhttp3_ab_a.a(b.a("file", str2, a));
        eVar.a(new g(aVar, okhttp3_ab_a));
        aa a4 = aa.a("multipart/form-data");
        if (a4 == null) {
            throw new NullPointerException("type == null");
        } else if (a4.a.equals("multipart")) {
            okhttp3_ab_a.b = a4;
            if (okhttp3_ab_a.c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            ag abVar = new ab(okhttp3_ab_a.a, okhttp3_ab_a.b, okhttp3_ab_a.c);
            if (!(lVar == null && cancellationHandler == null)) {
                abVar = new i(abVar, lVar, j, cancellationHandler);
            }
            a(new okhttp3.af.a().a(a3).a("POST", abVar), null, sVar, j, hVar);
        } else {
            StringBuilder stringBuilder = new StringBuilder("multipart != ");
            stringBuilder.append(a4);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    static o a(aj ajVar, String str, long j, s sVar, long j2) {
        byte[] d;
        String str2;
        String str3;
        String str4;
        JSONObject jSONObject;
        Exception exception;
        String str5;
        HttpUrl httpUrl;
        String a;
        String str6;
        String e;
        int i;
        aj ajVar2 = ajVar;
        int i2 = ajVar2.c;
        String a2 = ajVar2.a("X-Reqid", null);
        if (a2 == null) {
            a2 = null;
        } else {
            a2 = a2.trim().split(Constants.ACCEPT_TIME_SEPARATOR_SP)[0];
        }
        try {
            d = ajVar2.g.d();
            str2 = null;
        } catch (IOException e2) {
            str2 = e2.getMessage();
            d = null;
        }
        aa a3 = ajVar2.g.a();
        if (a3 == null) {
            str3 = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a3.a);
            stringBuilder.append("/");
            stringBuilder.append(a3.b);
            str3 = stringBuilder.toString();
        }
        if (!str3.equals(HttpRequest.CONTENT_TYPE_JSON) || d == null) {
            if (d == null) {
                str4 = "null body";
            } else {
                str4 = new String(d);
            }
            jSONObject = null;
        } else {
            try {
                str3 = new String(d, "utf-8");
                if ("".equals(str3)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(str3);
                }
                try {
                    if (ajVar2.c != 200) {
                        str4 = jSONObject.optString("error", new String(d, "utf-8"));
                    } else {
                        str4 = str2;
                    }
                } catch (Exception e3) {
                    exception = e3;
                    if (ajVar2.c < 300) {
                        str2 = exception.getMessage();
                    }
                    str5 = str2;
                    httpUrl = ajVar2.a.a;
                    a = ajVar2.a("X-Log", null);
                    str2 = ajVar2.a("X-Via", "");
                    if (str2.equals("")) {
                        str2 = ajVar2.a("X-Px", "");
                        if (str2.equals("")) {
                            str2 = ajVar2.a("Fw-Via", "");
                            str2.equals("");
                        }
                    }
                    str6 = httpUrl.b;
                    e = httpUrl.e();
                    i = httpUrl.c;
                    return o.a(jSONObject, i2, a2, a, str2, str6, e, str, i, j, a(ajVar), str5, sVar, j2);
                }
            } catch (Exception e32) {
                exception = e32;
                jSONObject = null;
                if (ajVar2.c < 300) {
                    str2 = exception.getMessage();
                }
                str5 = str2;
                httpUrl = ajVar2.a.a;
                a = ajVar2.a("X-Log", null);
                str2 = ajVar2.a("X-Via", "");
                if (str2.equals("")) {
                    str2 = ajVar2.a("X-Px", "");
                    if (str2.equals("")) {
                        str2 = ajVar2.a("Fw-Via", "");
                        str2.equals("");
                    }
                }
                str6 = httpUrl.b;
                e = httpUrl.e();
                i = httpUrl.c;
                return o.a(jSONObject, i2, a2, a, str2, str6, e, str, i, j, a(ajVar), str5, sVar, j2);
            }
        }
        str5 = str4;
        httpUrl = ajVar2.a.a;
        a = ajVar2.a("X-Log", null);
        str2 = ajVar2.a("X-Via", "");
        if (str2.equals("")) {
            str2 = ajVar2.a("X-Px", "");
            if (str2.equals("")) {
                str2 = ajVar2.a("Fw-Via", "");
                str2.equals("");
            }
        }
        str6 = httpUrl.b;
        e = httpUrl.e();
        i = httpUrl.c;
        return o.a(jSONObject, i2, a2, a, str2, str6, e, str, i, j, a(ajVar), str5, sVar, j2);
    }

    private static long a(okhttp3.aj r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = r2.a;	 Catch:{ Throwable -> 0x000e }
        r2 = r2.d;	 Catch:{ Throwable -> 0x000e }
        if (r2 != 0) goto L_0x0009;	 Catch:{ Throwable -> 0x000e }
    L_0x0006:
        r0 = 0;	 Catch:{ Throwable -> 0x000e }
        return r0;	 Catch:{ Throwable -> 0x000e }
    L_0x0009:
        r0 = r2.a();	 Catch:{ Throwable -> 0x000e }
        return r0;
    L_0x000e:
        r0 = -1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.http.a.a(okhttp3.aj):long");
    }
}
