package okhttp3.internal.b;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.HttpUrl;
import okhttp3.a;
import okhttp3.ac;
import okhttp3.af;
import okhttp3.aj;
import okhttp3.h;
import okhttp3.internal.connection.f;
import okhttp3.z;

/* compiled from: RetryAndFollowUpInterceptor */
public final class k implements z {
    public Object a;
    public volatile boolean b;
    private final ac c;
    private final boolean d;
    private f e;

    public k(ac acVar, boolean z) {
        this.c = acVar;
        this.d = z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final okhttp3.aj a(okhttp3.z.a r11) throws java.io.IOException {
        /*
        r10 = this;
        r0 = r11.a();
        r1 = new okhttp3.internal.connection.f;
        r2 = r10.c;
        r2 = r2.u;
        r3 = r0.a;
        r3 = r10.a(r3);
        r4 = r10.a;
        r1.<init>(r2, r3, r4);
        r10.e = r1;
        r1 = 0;
        r2 = 0;
        r4 = r1;
        r3 = r2;
    L_0x001b:
        r5 = r10.b;
        if (r5 == 0) goto L_0x002c;
    L_0x001f:
        r11 = r10.e;
        r11.c();
        r11 = new java.io.IOException;
        r0 = "Canceled";
        r11.<init>(r0);
        throw r11;
    L_0x002c:
        r5 = 1;
        r6 = r11;
        r6 = (okhttp3.internal.b.h) r6;	 Catch:{ RouteException -> 0x01e3, IOException -> 0x01d5 }
        r7 = r10.e;	 Catch:{ RouteException -> 0x01e3, IOException -> 0x01d5 }
        r6 = r6.a(r0, r7, r2, r2);	 Catch:{ RouteException -> 0x01e3, IOException -> 0x01d5 }
        if (r3 == 0) goto L_0x005a;
    L_0x0038:
        r0 = r6.a();
        r3 = r3.a();
        r3.g = r2;
        r3 = r3.a();
        r6 = r3.g;
        if (r6 == 0) goto L_0x0052;
    L_0x004a:
        r11 = new java.lang.IllegalArgumentException;
        r0 = "priorResponse.body != null";
        r11.<init>(r0);
        throw r11;
    L_0x0052:
        r0.j = r3;
        r0 = r0.a();
        r3 = r0;
        goto L_0x005b;
    L_0x005a:
        r3 = r6;
    L_0x005b:
        if (r3 != 0) goto L_0x0063;
    L_0x005d:
        r11 = new java.lang.IllegalStateException;
        r11.<init>();
        throw r11;
    L_0x0063:
        r0 = r10.e;
        r0 = r0.b();
        if (r0 == 0) goto L_0x0070;
    L_0x006b:
        r0 = r0.a();
        goto L_0x0071;
    L_0x0070:
        r0 = r2;
    L_0x0071:
        r6 = r3.c;
        r7 = r3.a;
        r7 = r7.b;
        switch(r6) {
            case 300: goto L_0x00c5;
            case 301: goto L_0x00c5;
            case 302: goto L_0x00c5;
            case 303: goto L_0x00c5;
            case 307: goto L_0x00b5;
            case 308: goto L_0x00b5;
            case 401: goto L_0x00ab;
            case 407: goto L_0x0088;
            case 408: goto L_0x007c;
            default: goto L_0x007a;
        };
    L_0x007a:
        goto L_0x014a;
    L_0x007c:
        r0 = r3.a;
        r0 = r0.d;
        r0 = r0 instanceof okhttp3.internal.b.m;
        if (r0 != 0) goto L_0x014a;
    L_0x0084:
        r0 = r3.a;
        goto L_0x014b;
    L_0x0088:
        if (r0 == 0) goto L_0x008d;
    L_0x008a:
        r0 = r0.b;
        goto L_0x0091;
    L_0x008d:
        r0 = r10.c;
        r0 = r0.d;
    L_0x0091:
        r0 = r0.type();
        r5 = java.net.Proxy.Type.HTTP;
        if (r0 == r5) goto L_0x00a1;
    L_0x0099:
        r11 = new java.net.ProtocolException;
        r0 = "Received HTTP_PROXY_AUTH (407) code while not using proxy";
        r11.<init>(r0);
        throw r11;
    L_0x00a1:
        r0 = r10.c;
        r0 = r0.s;
        r0 = r0.a(r3);
        goto L_0x014b;
    L_0x00ab:
        r0 = r10.c;
        r0 = r0.t;
        r0 = r0.a(r3);
        goto L_0x014b;
    L_0x00b5:
        r0 = "GET";
        r0 = r7.equals(r0);
        if (r0 != 0) goto L_0x00c5;
    L_0x00bd:
        r0 = "HEAD";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x014a;
    L_0x00c5:
        r0 = r10.c;
        r0 = r0.x;
        if (r0 == 0) goto L_0x014a;
    L_0x00cb:
        r0 = "Location";
        r0 = r3.a(r0);
        if (r0 == 0) goto L_0x014a;
    L_0x00d3:
        r6 = r3.a;
        r6 = r6.a;
        r0 = r6.c(r0);
        if (r0 == 0) goto L_0x00e2;
    L_0x00dd:
        r0 = r0.b();
        goto L_0x00e3;
    L_0x00e2:
        r0 = r2;
    L_0x00e3:
        if (r0 == 0) goto L_0x014a;
    L_0x00e5:
        r6 = r0.a;
        r8 = r3.a;
        r8 = r8.a;
        r8 = r8.a;
        r6 = r6.equals(r8);
        if (r6 != 0) goto L_0x00f9;
    L_0x00f3:
        r6 = r10.c;
        r6 = r6.w;
        if (r6 == 0) goto L_0x014a;
    L_0x00f9:
        r6 = r3.a;
        r6 = r6.a();
        r8 = okhttp3.internal.b.g.b(r7);
        if (r8 == 0) goto L_0x0136;
    L_0x0105:
        r8 = "PROPFIND";
        r8 = r7.equals(r8);
        r9 = "PROPFIND";
        r9 = r7.equals(r9);
        r5 = r5 ^ r9;
        if (r5 == 0) goto L_0x011a;
    L_0x0114:
        r5 = "GET";
        r6.a(r5, r2);
        goto L_0x0125;
    L_0x011a:
        if (r8 == 0) goto L_0x0121;
    L_0x011c:
        r5 = r3.a;
        r5 = r5.d;
        goto L_0x0122;
    L_0x0121:
        r5 = r2;
    L_0x0122:
        r6.a(r7, r5);
    L_0x0125:
        if (r8 != 0) goto L_0x0136;
    L_0x0127:
        r5 = "Transfer-Encoding";
        r6.b(r5);
        r5 = "Content-Length";
        r6.b(r5);
        r5 = "Content-Type";
        r6.b(r5);
    L_0x0136:
        r5 = a(r3, r0);
        if (r5 != 0) goto L_0x0141;
    L_0x013c:
        r5 = "Authorization";
        r6.b(r5);
    L_0x0141:
        r0 = r6.a(r0);
        r0 = r0.a();
        goto L_0x014b;
    L_0x014a:
        r0 = r2;
    L_0x014b:
        if (r0 != 0) goto L_0x0157;
    L_0x014d:
        r11 = r10.d;
        if (r11 != 0) goto L_0x0156;
    L_0x0151:
        r11 = r10.e;
        r11.c();
    L_0x0156:
        return r3;
    L_0x0157:
        r5 = r3.g;
        okhttp3.internal.c.a(r5);
        r4 = r4 + 1;
        r5 = 20;
        if (r4 <= r5) goto L_0x017b;
    L_0x0162:
        r11 = r10.e;
        r11.c();
        r11 = new java.net.ProtocolException;
        r0 = new java.lang.StringBuilder;
        r1 = "Too many follow-up requests: ";
        r0.<init>(r1);
        r0.append(r4);
        r0 = r0.toString();
        r11.<init>(r0);
        throw r11;
    L_0x017b:
        r5 = r0.d;
        r5 = r5 instanceof okhttp3.internal.b.m;
        if (r5 == 0) goto L_0x0190;
    L_0x0181:
        r11 = r10.e;
        r11.c();
        r11 = new java.net.HttpRetryException;
        r0 = "Cannot retry streamed HTTP body";
        r1 = r3.c;
        r11.<init>(r0, r1);
        throw r11;
    L_0x0190:
        r5 = r0.a;
        r5 = a(r3, r5);
        if (r5 != 0) goto L_0x01b2;
    L_0x0198:
        r5 = r10.e;
        r5.c();
        r5 = new okhttp3.internal.connection.f;
        r6 = r10.c;
        r6 = r6.u;
        r7 = r0.a;
        r7 = r10.a(r7);
        r8 = r10.a;
        r5.<init>(r6, r7, r8);
        r10.e = r5;
        goto L_0x001b;
    L_0x01b2:
        r5 = r10.e;
        r5 = r5.a();
        if (r5 == 0) goto L_0x001b;
    L_0x01ba:
        r11 = new java.lang.IllegalStateException;
        r0 = new java.lang.StringBuilder;
        r1 = "Closing the body of ";
        r0.<init>(r1);
        r0.append(r3);
        r1 = " didn't close its backing stream. Bad interceptor?";
        r0.append(r1);
        r0 = r0.toString();
        r11.<init>(r0);
        throw r11;
    L_0x01d3:
        r11 = move-exception;
        goto L_0x01f3;
    L_0x01d5:
        r6 = move-exception;
        r7 = r6 instanceof okhttp3.internal.http2.ConnectionShutdownException;	 Catch:{ all -> 0x01d3 }
        if (r7 != 0) goto L_0x01db;
    L_0x01da:
        goto L_0x01dc;
    L_0x01db:
        r5 = r1;
    L_0x01dc:
        r5 = r10.a(r6, r5, r0);	 Catch:{ all -> 0x01d3 }
        if (r5 != 0) goto L_0x001b;
    L_0x01e2:
        throw r6;	 Catch:{ all -> 0x01d3 }
    L_0x01e3:
        r5 = move-exception;
        r6 = r5.getLastConnectException();	 Catch:{ all -> 0x01d3 }
        r6 = r10.a(r6, r1, r0);	 Catch:{ all -> 0x01d3 }
        if (r6 != 0) goto L_0x001b;
    L_0x01ee:
        r11 = r5.getLastConnectException();	 Catch:{ all -> 0x01d3 }
        throw r11;	 Catch:{ all -> 0x01d3 }
    L_0x01f3:
        r0 = r10.e;
        r0.a(r2);
        r0 = r10.e;
        r0.c();
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.b.k.a(okhttp3.z$a):okhttp3.aj");
    }

    private a a(HttpUrl httpUrl) {
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        h hVar;
        k kVar = this;
        HttpUrl httpUrl2 = httpUrl;
        if (httpUrl.b()) {
            SSLSocketFactory sSLSocketFactory2 = kVar.c.o;
            hostnameVerifier = kVar.c.q;
            sSLSocketFactory = sSLSocketFactory2;
            hVar = kVar.c.r;
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = sSLSocketFactory;
            hVar = hostnameVerifier;
        }
        return new a(httpUrl2.b, httpUrl2.c, kVar.c.v, kVar.c.n, sSLSocketFactory, hostnameVerifier, hVar, kVar.c.s, kVar.c.d, kVar.c.e, kVar.c.f, kVar.c.j);
    }

    private boolean a(IOException iOException, boolean z, af afVar) {
        this.e.a(iOException);
        if (!this.c.y) {
            return false;
        }
        if (z && (afVar.d instanceof m) != null) {
            return false;
        }
        if ((iOException instanceof ProtocolException) == null) {
            if ((iOException instanceof InterruptedIOException) != null) {
                if ((iOException instanceof SocketTimeoutException) != null) {
                    if (z) {
                    }
                }
            } else if (!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) {
                if ((iOException instanceof SSLPeerUnverifiedException) != null) {
                }
            }
            iOException = 1;
            if (iOException == null) {
                return false;
            }
            iOException = this.e;
            if (!iOException.b) {
                iOException = iOException.d;
                if (!(iOException.c() || iOException.b())) {
                    if (iOException.d() != null) {
                        iOException = null;
                        if (iOException == null) {
                            iOException = null;
                            if (iOException != null) {
                                return false;
                            }
                            return true;
                        }
                    }
                }
                iOException = 1;
                if (iOException == null) {
                    iOException = null;
                    if (iOException != null) {
                        return true;
                    }
                    return false;
                }
            }
            iOException = 1;
            if (iOException != null) {
                return false;
            }
            return true;
        }
        iOException = null;
        if (iOException == null) {
            return false;
        }
        iOException = this.e;
        if (iOException.b) {
            iOException = iOException.d;
            if (iOException.d() != null) {
                iOException = null;
                if (iOException == null) {
                    iOException = null;
                    if (iOException != null) {
                        return true;
                    }
                    return false;
                }
            } else {
                iOException = 1;
                if (iOException == null) {
                    iOException = null;
                    if (iOException != null) {
                        return false;
                    }
                    return true;
                }
            }
        }
        iOException = 1;
        if (iOException != null) {
            return true;
        }
        return false;
    }

    private static boolean a(aj ajVar, HttpUrl httpUrl) {
        ajVar = ajVar.a.a;
        return (ajVar.b.equals(httpUrl.b) && ajVar.c == httpUrl.c && ajVar.a.equals(httpUrl.a) != null) ? true : null;
    }
}
