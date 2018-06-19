package okhttp3;

import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.Reference;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.a;
import okhttp3.internal.connection.c;
import okhttp3.internal.connection.d;
import okhttp3.internal.connection.f;

/* compiled from: OkHttpClient */
final class ad extends a {
    ad() {
    }

    public final void a(y$a okhttp3_y_a, String str, String str2) {
        okhttp3_y_a.b(str, str2);
    }

    public final boolean a(a aVar, a aVar2) {
        return aVar.a(aVar2);
    }

    public final d a(l lVar) {
        return lVar.e;
    }

    public final int a(aj.a aVar) {
        return aVar.c;
    }

    public final void a(y$a okhttp3_y_a, String str) {
        int indexOf = str.indexOf(Constants.COLON_SEPARATOR, 1);
        if (indexOf != -1) {
            okhttp3_y_a.b(str.substring(0, indexOf), str.substring(indexOf + 1));
        } else if (str.startsWith(Constants.COLON_SEPARATOR)) {
            okhttp3_y_a.b("", str.substring(1));
        } else {
            okhttp3_y_a.b("", str);
        }
    }

    public final boolean a(l lVar, c cVar) {
        if (l.g || Thread.holdsLock(lVar)) {
            if (!cVar.g) {
                if (lVar.b != 0) {
                    lVar.notifyAll();
                    return null;
                }
            }
            lVar.d.remove(cVar);
            return true;
        }
        throw new AssertionError();
    }

    public final c a(l lVar, a aVar, f fVar, am amVar) {
        if (l.g || Thread.holdsLock(lVar)) {
            for (c cVar : lVar.d) {
                if (cVar.a(aVar, amVar)) {
                    fVar.a(cVar);
                    return cVar;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    public final Socket a(l lVar, a aVar, f fVar) {
        if (l.g || Thread.holdsLock(lVar)) {
            for (c cVar : lVar.d) {
                if (cVar.a(aVar, null) && cVar.c() && cVar != fVar.b()) {
                    if (f.g == null && Thread.holdsLock(fVar.c) == null) {
                        throw new AssertionError();
                    }
                    if (fVar.f == null) {
                        if (fVar.e.j.size() == 1) {
                            Reference reference = (Reference) fVar.e.j.get(0);
                            aVar = fVar.a(true, false, false);
                            fVar.e = cVar;
                            cVar.j.add(reference);
                            return aVar;
                        }
                    }
                    throw new IllegalStateException();
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    public final void b(l lVar, c cVar) {
        if (l.g || Thread.holdsLock(lVar)) {
            if (!lVar.f) {
                lVar.f = true;
                l.a.execute(lVar.c);
            }
            lVar.d.add(cVar);
            return;
        }
        throw new AssertionError();
    }

    public final void a(n nVar, SSLSocket sSLSocket, boolean z) {
        String[] a;
        String[] a2;
        if (nVar.f != null) {
            a = okhttp3.internal.c.a(i.a, sSLSocket.getEnabledCipherSuites(), nVar.f);
        } else {
            a = sSLSocket.getEnabledCipherSuites();
        }
        if (nVar.g != null) {
            a2 = okhttp3.internal.c.a(okhttp3.internal.c.g, sSLSocket.getEnabledProtocols(), nVar.g);
        } else {
            a2 = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        boolean a3 = okhttp3.internal.c.a(i.a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && !a3) {
            a = okhttp3.internal.c.a(a, supportedCipherSuites[a3]);
        }
        nVar = new n.a(nVar).a(a).b(a2).b();
        if (nVar.g) {
            sSLSocket.setEnabledProtocols(nVar.g);
        }
        if (nVar.f) {
            sSLSocket.setEnabledCipherSuites(nVar.f);
        }
    }
}
