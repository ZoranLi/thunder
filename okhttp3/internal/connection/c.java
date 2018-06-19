package okhttp3.internal.connection;

import anet.channel.util.HttpConstant;
import com.umeng.message.util.HttpRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.af;
import okhttp3.aj;
import okhttp3.am;
import okhttp3.h;
import okhttp3.internal.g.d;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.e;
import okhttp3.internal.http2.e$b;
import okhttp3.internal.http2.e.a;
import okhttp3.internal.http2.r;
import okhttp3.k;
import okhttp3.l;
import okhttp3.n;
import okhttp3.x;
import okio.f;
import okio.g;
import okio.m;
import okio.v;

/* compiled from: RealConnection */
public final class c extends e$b implements k {
    public final am a;
    public Socket b;
    public x c;
    e d;
    g e;
    f f;
    public boolean g;
    public int h;
    public int i = 1;
    public final List<Reference<f>> j = new ArrayList();
    public long k = Long.MAX_VALUE;
    private final l m;
    private Socket n;
    private Protocol o;

    public c(l lVar, am amVar) {
        this.m = lVar;
        this.a = amVar;
    }

    public final void a(int i, int i2, int i3, boolean z) {
        if (this.o != null) {
            throw new IllegalStateException("already connected");
        }
        List list = this.a.a.f;
        b bVar = new b(list);
        if (this.a.a.i == null) {
            if (list.contains(n.c)) {
                String str = this.a.a.a.b;
                if (!okhttp3.internal.e.e.b().b(str)) {
                    i3 = new StringBuilder("CLEARTEXT communication to ");
                    i3.append(str);
                    i3.append(" not permitted by network security policy");
                    throw new RouteException(new UnknownServiceException(i3.toString()));
                }
            }
            throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
        }
        RouteException routeException = null;
        boolean z2;
        do {
            z2 = true;
            try {
                am amVar = this.a;
                boolean z3 = amVar.a.i != null && amVar.b.type() == Type.HTTP;
                if (z3) {
                    a(i, i2, i3);
                } else {
                    a(i, i2);
                }
                if (this.a.a.i == null) {
                    this.o = Protocol.HTTP_1_1;
                    this.b = this.n;
                } else {
                    a(bVar);
                    if (this.o == Protocol.HTTP_2) {
                        this.b.setSoTimeout(0);
                        a aVar = new a();
                        Socket socket = this.b;
                        String str2 = this.a.a.a.b;
                        g gVar = this.e;
                        f fVar = this.f;
                        aVar.a = socket;
                        aVar.b = str2;
                        aVar.c = gVar;
                        aVar.d = fVar;
                        aVar.e = this;
                        this.d = new e(aVar);
                        e eVar = this.d;
                        eVar.q.a();
                        eVar.q.b(eVar.m);
                        int b = eVar.m.b();
                        if (b != 65535) {
                            eVar.q.a(0, (long) (b - 65535));
                        }
                        new Thread(eVar.r).start();
                    }
                }
                if (this.d != 0) {
                    synchronized (this.m) {
                        this.i = this.d.a();
                    }
                    return;
                }
                return;
            } catch (IOException e) {
                okhttp3.internal.c.a(this.b);
                okhttp3.internal.c.a(this.n);
                this.b = null;
                this.n = null;
                this.e = null;
                this.f = null;
                this.c = null;
                this.o = null;
                this.d = null;
                if (routeException == null) {
                    routeException = new RouteException(e);
                } else {
                    routeException.addConnectException(e);
                }
                if (!z) {
                    break;
                }
                bVar.d = true;
                if (!(!bVar.c || (e instanceof ProtocolException) || (e instanceof InterruptedIOException))) {
                    boolean z4 = e instanceof SSLHandshakeException;
                    if (!((z4 && (e.getCause() instanceof CertificateException)) || (e instanceof SSLPeerUnverifiedException))) {
                        if (z4) {
                            continue;
                        } else if (e instanceof SSLProtocolException) {
                            continue;
                        }
                        if (!z2) {
                        }
                    }
                }
                z2 = false;
                continue;
                if (z2) {
                }
                throw routeException;
            }
        } while (z2);
        throw routeException;
    }

    private void a(int i, int i2) throws IOException {
        Socket socket;
        Proxy proxy = this.a.b;
        okhttp3.a aVar = this.a.a;
        if (proxy.type() != Type.DIRECT) {
            if (proxy.type() != Type.HTTP) {
                socket = new Socket(proxy);
                this.n = socket;
                this.n.setSoTimeout(i2);
                okhttp3.internal.e.e.b().a(this.n, this.a.c, i);
                try {
                    this.e = m.a(m.b(this.n));
                    this.f = m.a(m.a(this.n));
                } catch (int i3) {
                    if ("throw with null exception".equals(i3.getMessage()) != 0) {
                        throw new IOException(i3);
                    }
                    return;
                }
            }
        }
        socket = aVar.c.createSocket();
        this.n = socket;
        this.n.setSoTimeout(i2);
        try {
            okhttp3.internal.e.e.b().a(this.n, this.a.c, i3);
            this.e = m.a(m.b(this.n));
            this.f = m.a(m.a(this.n));
        } catch (int i32) {
            StringBuilder stringBuilder = new StringBuilder("Failed to connect to ");
            stringBuilder.append(this.a.c);
            i2 = new ConnectException(stringBuilder.toString());
            i2.initCause(i32);
            throw i2;
        }
    }

    private void a(b bVar) throws IOException {
        okhttp3.a aVar = this.a.a;
        String str = null;
        try {
            Socket socket = (SSLSocket) aVar.i.createSocket(this.n, aVar.a.b, aVar.a.c, true);
            try {
                n nVar;
                int size = bVar.a.size();
                for (int i = bVar.b; i < size; i++) {
                    nVar = (n) bVar.a.get(i);
                    if (nVar.a(socket)) {
                        bVar.b = i + 1;
                        break;
                    }
                }
                nVar = null;
                if (nVar == null) {
                    StringBuilder stringBuilder = new StringBuilder("Unable to find acceptable protocols. isFallback=");
                    stringBuilder.append(bVar.d);
                    stringBuilder.append(", modes=");
                    stringBuilder.append(bVar.a);
                    stringBuilder.append(", supported protocols=");
                    stringBuilder.append(Arrays.toString(socket.getEnabledProtocols()));
                    throw new UnknownServiceException(stringBuilder.toString());
                }
                bVar.c = bVar.a(socket);
                okhttp3.internal.a.a.a(nVar, socket, bVar.d);
                if (nVar.e != null) {
                    okhttp3.internal.e.e.b().a(socket, aVar.a.b, aVar.e);
                }
                socket.startHandshake();
                bVar = x.a(socket.getSession());
                if (aVar.j.verify(aVar.a.b, socket.getSession())) {
                    aVar.k.a(aVar.a.b, bVar.b);
                    if (nVar.e) {
                        str = okhttp3.internal.e.e.b().a(socket);
                    }
                    this.b = socket;
                    this.e = m.a(m.b(this.b));
                    this.f = m.a(m.a(this.b));
                    this.c = bVar;
                    if (str != null) {
                        bVar = Protocol.get(str);
                    } else {
                        bVar = Protocol.HTTP_1_1;
                    }
                    this.o = bVar;
                    if (socket != null) {
                        okhttp3.internal.e.e.b().b(socket);
                        return;
                    }
                    return;
                }
                Certificate certificate = (X509Certificate) bVar.b.get(0);
                StringBuilder stringBuilder2 = new StringBuilder("Hostname ");
                stringBuilder2.append(aVar.a.b);
                stringBuilder2.append(" not verified:\n    certificate: ");
                stringBuilder2.append(h.a(certificate));
                stringBuilder2.append("\n    DN: ");
                stringBuilder2.append(certificate.getSubjectDN().getName());
                stringBuilder2.append("\n    subjectAltNames: ");
                stringBuilder2.append(d.a(certificate));
                throw new SSLPeerUnverifiedException(stringBuilder2.toString());
            } catch (AssertionError e) {
                bVar = e;
                str = socket;
                try {
                    if (okhttp3.internal.c.a(bVar)) {
                        throw new IOException(bVar);
                    }
                    throw bVar;
                } catch (Throwable th) {
                    bVar = th;
                    socket = str;
                    if (socket != null) {
                        okhttp3.internal.e.e.b().b(socket);
                    }
                    okhttp3.internal.c.a(socket);
                    throw bVar;
                }
            } catch (Throwable th2) {
                bVar = th2;
                if (socket != null) {
                    okhttp3.internal.e.e.b().b(socket);
                }
                okhttp3.internal.c.a(socket);
                throw bVar;
            }
        } catch (AssertionError e2) {
            bVar = e2;
            if (okhttp3.internal.c.a(bVar)) {
                throw new IOException(bVar);
            }
            throw bVar;
        }
    }

    private af a(int i, int i2, af afVar, HttpUrl httpUrl) throws IOException {
        StringBuilder stringBuilder = new StringBuilder("CONNECT ");
        stringBuilder.append(okhttp3.internal.c.a(httpUrl, true));
        stringBuilder.append(" HTTP/1.1");
        httpUrl = stringBuilder.toString();
        while (true) {
            okhttp3.internal.c.a aVar = new okhttp3.internal.c.a(null, null, this.e, this.f);
            this.e.a().a((long) i, TimeUnit.MILLISECONDS);
            this.f.a().a((long) i2, TimeUnit.MILLISECONDS);
            aVar.a(afVar.c, httpUrl);
            aVar.b();
            aj.a a = aVar.a(false);
            a.a = afVar;
            afVar = a.a();
            long a2 = okhttp3.internal.b.f.a(afVar);
            if (a2 == -1) {
                a2 = 0;
            }
            v a3 = aVar.a(a2);
            okhttp3.internal.c.a(a3, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            a3.close();
            int i3 = afVar.c;
            if (i3 == 200) {
                break;
            } else if (i3 != 407) {
                i2 = new StringBuilder("Unexpected response code for CONNECT: ");
                i2.append(afVar.c);
                throw new IOException(i2.toString());
            } else {
                af a4 = this.a.a.d.a(afVar);
                if (a4 == null) {
                    throw new IOException("Failed to authenticate with proxy");
                } else if ("close".equalsIgnoreCase(afVar.a(HttpConstant.CONNECTION)) != null) {
                    return a4;
                } else {
                    afVar = a4;
                }
            }
        }
        if (this.e.b().c() != 0) {
            if (this.f.b().c() != 0) {
                return null;
            }
        }
        throw new IOException("TLS tunnel buffered too many bytes!");
    }

    public final boolean a(okhttp3.a r5, @javax.annotation.Nullable okhttp3.am r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.j;
        r0 = r0.size();
        r1 = r4.i;
        r2 = 0;
        if (r0 >= r1) goto L_0x007f;
    L_0x000b:
        r0 = r4.g;
        if (r0 == 0) goto L_0x0010;
    L_0x000f:
        goto L_0x007f;
    L_0x0010:
        r0 = okhttp3.internal.a.a;
        r1 = r4.a;
        r1 = r1.a;
        r0 = r0.a(r1, r5);
        if (r0 != 0) goto L_0x001d;
    L_0x001c:
        return r2;
    L_0x001d:
        r0 = r5.a;
        r0 = r0.b;
        r1 = r4.a;
        r1 = r1.a;
        r1 = r1.a;
        r1 = r1.b;
        r0 = r0.equals(r1);
        r1 = 1;
        if (r0 == 0) goto L_0x0031;
    L_0x0030:
        return r1;
    L_0x0031:
        r0 = r4.d;
        if (r0 != 0) goto L_0x0036;
    L_0x0035:
        return r2;
    L_0x0036:
        if (r6 != 0) goto L_0x0039;
    L_0x0038:
        return r2;
    L_0x0039:
        r0 = r6.b;
        r0 = r0.type();
        r3 = java.net.Proxy.Type.DIRECT;
        if (r0 == r3) goto L_0x0044;
    L_0x0043:
        return r2;
    L_0x0044:
        r0 = r4.a;
        r0 = r0.b;
        r0 = r0.type();
        r3 = java.net.Proxy.Type.DIRECT;
        if (r0 == r3) goto L_0x0051;
    L_0x0050:
        return r2;
    L_0x0051:
        r0 = r4.a;
        r0 = r0.c;
        r3 = r6.c;
        r0 = r0.equals(r3);
        if (r0 != 0) goto L_0x005e;
    L_0x005d:
        return r2;
    L_0x005e:
        r6 = r6.a;
        r6 = r6.j;
        r0 = okhttp3.internal.g.d.a;
        if (r6 == r0) goto L_0x0067;
    L_0x0066:
        return r2;
    L_0x0067:
        r6 = r5.a;
        r6 = r4.a(r6);
        if (r6 != 0) goto L_0x0070;
    L_0x006f:
        return r2;
    L_0x0070:
        r6 = r5.k;	 Catch:{ SSLPeerUnverifiedException -> 0x007e }
        r5 = r5.a;	 Catch:{ SSLPeerUnverifiedException -> 0x007e }
        r5 = r5.b;	 Catch:{ SSLPeerUnverifiedException -> 0x007e }
        r0 = r4.c;	 Catch:{ SSLPeerUnverifiedException -> 0x007e }
        r0 = r0.b;	 Catch:{ SSLPeerUnverifiedException -> 0x007e }
        r6.a(r5, r0);	 Catch:{ SSLPeerUnverifiedException -> 0x007e }
        return r1;
    L_0x007e:
        return r2;
    L_0x007f:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.c.a(okhttp3.a, okhttp3.am):boolean");
    }

    public final am a() {
        return this.a;
    }

    public final Socket b() {
        return this.b;
    }

    public final boolean a(boolean r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.b;
        r0 = r0.isClosed();
        r1 = 0;
        if (r0 != 0) goto L_0x0053;
    L_0x0009:
        r0 = r4.b;
        r0 = r0.isInputShutdown();
        if (r0 != 0) goto L_0x0053;
    L_0x0011:
        r0 = r4.b;
        r0 = r0.isOutputShutdown();
        if (r0 == 0) goto L_0x001a;
    L_0x0019:
        goto L_0x0053;
    L_0x001a:
        r0 = r4.d;
        r2 = 1;
        if (r0 == 0) goto L_0x0029;
    L_0x001f:
        r5 = r4.d;
        r5 = r5.b();
        if (r5 != 0) goto L_0x0028;
    L_0x0027:
        return r2;
    L_0x0028:
        return r1;
    L_0x0029:
        if (r5 == 0) goto L_0x0052;
    L_0x002b:
        r5 = r4.b;	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
        r5 = r5.getSoTimeout();	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
        r0 = r4.b;	 Catch:{ all -> 0x004a }
        r0.setSoTimeout(r2);	 Catch:{ all -> 0x004a }
        r0 = r4.e;	 Catch:{ all -> 0x004a }
        r0 = r0.c();	 Catch:{ all -> 0x004a }
        if (r0 == 0) goto L_0x0044;
    L_0x003e:
        r0 = r4.b;	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
        r0.setSoTimeout(r5);	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
        return r1;	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
    L_0x0044:
        r0 = r4.b;	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
        r0.setSoTimeout(r5);	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
        return r2;	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
    L_0x004a:
        r0 = move-exception;	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
        r3 = r4.b;	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
        r3.setSoTimeout(r5);	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
        throw r0;	 Catch:{ SocketTimeoutException -> 0x0052, IOException -> 0x0051 }
    L_0x0051:
        return r1;
    L_0x0052:
        return r2;
    L_0x0053:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.c.a(boolean):boolean");
    }

    public final void a(r rVar) throws IOException {
        rVar.a(ErrorCode.REFUSED_STREAM);
    }

    public final void a(e eVar) {
        synchronized (this.m) {
            this.i = eVar.a();
        }
    }

    public final boolean c() {
        return this.d != null;
    }

    public final String toString() {
        Object obj;
        StringBuilder stringBuilder = new StringBuilder("Connection{");
        stringBuilder.append(this.a.a.a.b);
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(this.a.a.a.c);
        stringBuilder.append(", proxy=");
        stringBuilder.append(this.a.b);
        stringBuilder.append(" hostAddress=");
        stringBuilder.append(this.a.c);
        stringBuilder.append(" cipherSuite=");
        if (this.c != null) {
            obj = this.c.a;
        } else {
            obj = "none";
        }
        stringBuilder.append(obj);
        stringBuilder.append(" protocol=");
        stringBuilder.append(this.o);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    private void a(int i, int i2, int i3) throws IOException {
        af a = new af.a().a(this.a.a.a).a(HttpConstant.HOST, okhttp3.internal.c.a(this.a.a.a, true)).a("Proxy-Connection", "Keep-Alive").a(HttpRequest.HEADER_USER_AGENT, "okhttp/3.8.1").a();
        HttpUrl httpUrl = a.a;
        int i4 = 0;
        while (true) {
            i4++;
            if (i4 > 21) {
                throw new ProtocolException("Too many tunnel connections attempted: 21");
            }
            a(i, i2);
            a = a(i2, i3, a, httpUrl);
            if (a != null) {
                okhttp3.internal.c.a(this.n);
                this.n = null;
                this.f = null;
                this.e = null;
            } else {
                return;
            }
        }
    }

    public final boolean a(HttpUrl httpUrl) {
        if (httpUrl.c != this.a.a.a.c) {
            return false;
        }
        if (httpUrl.b.equals(this.a.a.a.b)) {
            return true;
        }
        if (this.c != null) {
            d dVar = d.a;
            if (d.a(httpUrl.b, (X509Certificate) this.c.b.get(0)) != null) {
                return true;
            }
        }
        return false;
    }
}
