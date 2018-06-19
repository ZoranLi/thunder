package okhttp3.internal;

import java.net.Socket;
import javax.net.ssl.SSLSocket;
import okhttp3.am;
import okhttp3.internal.connection.c;
import okhttp3.internal.connection.d;
import okhttp3.internal.connection.f;
import okhttp3.l;
import okhttp3.n;
import okhttp3.y$a;

/* compiled from: Internal */
public abstract class a {
    public static a a;

    public abstract int a(okhttp3.aj.a aVar);

    public abstract Socket a(l lVar, okhttp3.a aVar, f fVar);

    public abstract c a(l lVar, okhttp3.a aVar, f fVar, am amVar);

    public abstract d a(l lVar);

    public abstract void a(n nVar, SSLSocket sSLSocket, boolean z);

    public abstract void a(y$a okhttp3_y_a, String str);

    public abstract void a(y$a okhttp3_y_a, String str, String str2);

    public abstract boolean a(okhttp3.a aVar, okhttp3.a aVar2);

    public abstract boolean a(l lVar, c cVar);

    public abstract void b(l lVar, c cVar);
}
