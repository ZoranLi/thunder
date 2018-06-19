package okhttp3.internal.connection;

import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.a;
import okhttp3.am;
import okhttp3.internal.c;

/* compiled from: RouteSelector */
public final class e {
    final a a;
    final d b;
    private Proxy c;
    private InetSocketAddress d;
    private List<Proxy> e = Collections.emptyList();
    private int f;
    private List<InetSocketAddress> g = Collections.emptyList();
    private int h;
    private final List<am> i = new ArrayList();

    public e(a aVar, d dVar) {
        this.a = aVar;
        this.b = dVar;
        dVar = aVar.a;
        aVar = aVar.h;
        if (aVar != null) {
            aVar = Collections.singletonList(aVar);
        } else {
            List select = this.a.g.select(dVar.a());
            if (select == null || select.isEmpty() != null) {
                aVar = c.a(Proxy.NO_PROXY);
            } else {
                aVar = c.a(select);
            }
        }
        this.e = aVar;
        this.f = 0;
    }

    public final am a() throws IOException {
        while (true) {
            if (!c()) {
                if (!b()) {
                    break;
                } else if (b()) {
                    List list = this.e;
                    int i = this.f;
                    this.f = i + 1;
                    Proxy proxy = (Proxy) list.get(i);
                    a(proxy);
                    this.c = proxy;
                } else {
                    StringBuilder stringBuilder = new StringBuilder("No route to ");
                    stringBuilder.append(this.a.a.b);
                    stringBuilder.append("; exhausted proxy configurations: ");
                    stringBuilder.append(this.e);
                    throw new SocketException(stringBuilder.toString());
                }
            }
            if (c()) {
                list = this.g;
                i = this.h;
                this.h = i + 1;
                this.d = (InetSocketAddress) list.get(i);
                am amVar = new am(this.a, this.c, this.d);
                if (!this.b.c(amVar)) {
                    return amVar;
                }
                this.i.add(amVar);
            } else {
                stringBuilder = new StringBuilder("No route to ");
                stringBuilder.append(this.a.a.b);
                stringBuilder.append("; exhausted inet socket addresses: ");
                stringBuilder.append(this.g);
                throw new SocketException(stringBuilder.toString());
            }
        }
        if (d()) {
            return (am) this.i.remove(0);
        }
        throw new NoSuchElementException();
    }

    public final boolean b() {
        return this.f < this.e.size();
    }

    private void a(Proxy proxy) throws IOException {
        String hostName;
        int port;
        int size;
        int i;
        StringBuilder stringBuilder;
        this.g = new ArrayList();
        if (proxy.type() != Type.DIRECT) {
            if (proxy.type() != Type.SOCKS) {
                SocketAddress address = proxy.address();
                if (address instanceof InetSocketAddress) {
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                    InetAddress address2 = inetSocketAddress.getAddress();
                    if (address2 == null) {
                        hostName = inetSocketAddress.getHostName();
                    } else {
                        hostName = address2.getHostAddress();
                    }
                    port = inetSocketAddress.getPort();
                    if (port > 0) {
                        if (port > 65535) {
                            if (proxy.type() != Type.SOCKS) {
                                this.g.add(InetSocketAddress.createUnresolved(hostName, port));
                            } else {
                                proxy = this.a.b.a(hostName);
                                if (proxy.isEmpty()) {
                                    size = proxy.size();
                                    for (i = 0; i < size; i++) {
                                        this.g.add(new InetSocketAddress((InetAddress) proxy.get(i), port));
                                    }
                                } else {
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append(this.a.b);
                                    stringBuilder2.append(" returned no addresses for ");
                                    stringBuilder2.append(hostName);
                                    throw new UnknownHostException(stringBuilder2.toString());
                                }
                            }
                            this.h = 0;
                            return;
                        }
                    }
                    stringBuilder = new StringBuilder("No route to ");
                    stringBuilder.append(hostName);
                    stringBuilder.append(Constants.COLON_SEPARATOR);
                    stringBuilder.append(port);
                    stringBuilder.append("; port is out of range");
                    throw new SocketException(stringBuilder.toString());
                }
                StringBuilder stringBuilder3 = new StringBuilder("Proxy.address() is not an InetSocketAddress: ");
                stringBuilder3.append(address.getClass());
                throw new IllegalArgumentException(stringBuilder3.toString());
            }
        }
        hostName = this.a.a.b;
        port = this.a.a.c;
        if (port > 0) {
            if (port > 65535) {
                if (proxy.type() != Type.SOCKS) {
                    proxy = this.a.b.a(hostName);
                    if (proxy.isEmpty()) {
                        size = proxy.size();
                        for (i = 0; i < size; i++) {
                            this.g.add(new InetSocketAddress((InetAddress) proxy.get(i), port));
                        }
                    } else {
                        StringBuilder stringBuilder22 = new StringBuilder();
                        stringBuilder22.append(this.a.b);
                        stringBuilder22.append(" returned no addresses for ");
                        stringBuilder22.append(hostName);
                        throw new UnknownHostException(stringBuilder22.toString());
                    }
                }
                this.g.add(InetSocketAddress.createUnresolved(hostName, port));
                this.h = 0;
                return;
            }
        }
        stringBuilder = new StringBuilder("No route to ");
        stringBuilder.append(hostName);
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(port);
        stringBuilder.append("; port is out of range");
        throw new SocketException(stringBuilder.toString());
    }

    public final boolean c() {
        return this.h < this.g.size();
    }

    public final boolean d() {
        return !this.i.isEmpty();
    }
}
