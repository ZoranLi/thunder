package okhttp3;

import anet.channel.util.HttpConstant;
import com.alipay.sdk.util.h;
import com.xiaomi.mipush.sdk.Constants;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.HttpUrl.Builder;
import okhttp3.internal.c;

/* compiled from: Address */
public final class a {
    public final HttpUrl a;
    public final s b;
    public final SocketFactory c;
    public final b d;
    public final List<Protocol> e;
    public final List<n> f;
    public final ProxySelector g;
    @Nullable
    public final Proxy h;
    @Nullable
    public final SSLSocketFactory i;
    @Nullable
    public final HostnameVerifier j;
    @Nullable
    public final h k;

    public a(String str, int i, s sVar, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable h hVar, b bVar, @Nullable Proxy proxy, List<Protocol> list, List<n> list2, ProxySelector proxySelector) {
        Builder builder = new Builder();
        String str2 = sSLSocketFactory != null ? "https" : HttpConstant.HTTP;
        if (str2.equalsIgnoreCase(HttpConstant.HTTP)) {
            builder.a = HttpConstant.HTTP;
        } else if (str2.equalsIgnoreCase("https")) {
            builder.a = "https";
        } else {
            i = new StringBuilder("unexpected scheme: ");
            i.append(str2);
            throw new IllegalArgumentException(i.toString());
        }
        if (str == null) {
            throw new NullPointerException("host == null");
        }
        str2 = Builder.a(str, 0, str.length());
        if (str2 == null) {
            sVar = new StringBuilder("unexpected host: ");
            sVar.append(str);
            throw new IllegalArgumentException(sVar.toString());
        }
        builder.d = str2;
        if (i > 0) {
            if (i <= 65535) {
                builder.e = i;
                this.a = builder.b();
                if (sVar == null) {
                    throw new NullPointerException("dns == null");
                }
                this.b = sVar;
                if (socketFactory == null) {
                    throw new NullPointerException("socketFactory == null");
                }
                this.c = socketFactory;
                if (bVar == null) {
                    throw new NullPointerException("proxyAuthenticator == null");
                }
                this.d = bVar;
                if (list == null) {
                    throw new NullPointerException("protocols == null");
                }
                this.e = c.a(list);
                if (list2 == null) {
                    throw new NullPointerException("connectionSpecs == null");
                }
                this.f = c.a(list2);
                if (proxySelector == null) {
                    throw new NullPointerException("proxySelector == null");
                }
                this.g = proxySelector;
                this.h = proxy;
                this.i = sSLSocketFactory;
                this.j = hostnameVerifier;
                this.k = hVar;
                return;
            }
        }
        sVar = new StringBuilder("unexpected port: ");
        sVar.append(i);
        throw new IllegalArgumentException(sVar.toString());
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.a.equals(aVar.a) && a(aVar) != null) {
                return true;
            }
        }
        return null;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = 31 * (((((((((((((((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + (this.h != null ? this.h.hashCode() : 0)) * 31) + (this.i != null ? this.i.hashCode() : 0)) * 31) + (this.j != null ? this.j.hashCode() : 0));
        if (this.k != null) {
            i = this.k.hashCode();
        }
        return hashCode + i;
    }

    final boolean a(a aVar) {
        return (this.b.equals(aVar.b) && this.d.equals(aVar.d) && this.e.equals(aVar.e) && this.f.equals(aVar.f) && this.g.equals(aVar.g) && c.a(this.h, aVar.h) && c.a(this.i, aVar.i) && c.a(this.j, aVar.j) && c.a(this.k, aVar.k) && this.a.c == aVar.a.c) ? true : null;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Address{");
        stringBuilder.append(this.a.b);
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(this.a.c);
        if (this.h != null) {
            stringBuilder.append(", proxy=");
            stringBuilder.append(this.h);
        } else {
            stringBuilder.append(", proxySelector=");
            stringBuilder.append(this.g);
        }
        stringBuilder.append(h.d);
        return stringBuilder.toString();
    }
}
