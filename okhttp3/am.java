package okhttp3;

import com.alipay.sdk.util.h;
import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

/* compiled from: Route */
public final class am {
    public final a a;
    public final Proxy b;
    public final InetSocketAddress c;

    public am(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        } else {
            this.a = aVar;
            this.b = proxy;
            this.c = inetSocketAddress;
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof am) {
            am amVar = (am) obj;
            if (amVar.a.equals(this.a) && amVar.b.equals(this.b) && amVar.c.equals(this.c) != null) {
                return true;
            }
        }
        return null;
    }

    public final int hashCode() {
        return (31 * (((527 + this.a.hashCode()) * 31) + this.b.hashCode())) + this.c.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Route{");
        stringBuilder.append(this.c);
        stringBuilder.append(h.d);
        return stringBuilder.toString();
    }
}
