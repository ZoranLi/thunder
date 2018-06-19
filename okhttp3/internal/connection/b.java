package okhttp3.internal.connection;

import java.util.List;
import javax.net.ssl.SSLSocket;
import okhttp3.n;

/* compiled from: ConnectionSpecSelector */
public final class b {
    final List<n> a;
    int b = 0;
    boolean c;
    boolean d;

    public b(List<n> list) {
        this.a = list;
    }

    final boolean a(SSLSocket sSLSocket) {
        for (int i = this.b; i < this.a.size(); i++) {
            if (((n) this.a.get(i)).a(sSLSocket)) {
                return true;
            }
        }
        return null;
    }
}
