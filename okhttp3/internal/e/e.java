package okhttp3.internal.e;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.ac;
import okhttp3.internal.g.a;
import okhttp3.internal.g.b;

/* compiled from: Platform */
public class e {
    private static final Logger a = Logger.getLogger(ac.class.getName());
    static final e c;

    public String a(SSLSocket sSLSocket) {
        return null;
    }

    public void a(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    public void b(SSLSocket sSLSocket) {
    }

    public boolean b(String str) {
        return true;
    }

    public static e b() {
        return c;
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public void a(int i, String str, Throwable th) {
        a.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object a(String str) {
        return a.isLoggable(Level.FINE) ? new Throwable(str) : null;
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
            str = stringBuilder.toString();
        }
        a(5, str, (Throwable) obj);
    }

    public static List<String> a(List<Protocol> list) {
        List<String> arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = (Protocol) list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    public b a(X509TrustManager x509TrustManager) {
        return new a(okhttp3.internal.g.e.a(x509TrustManager));
    }

    static {
        e a = a.a();
        if (a == null) {
            a = b.a();
            if (a == null) {
                a = c.a();
                if (a == null) {
                    a = new e();
                }
            }
        }
        c = a;
    }
}
