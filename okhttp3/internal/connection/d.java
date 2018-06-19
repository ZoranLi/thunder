package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.am;

/* compiled from: RouteDatabase */
public final class d {
    private final Set<am> a = new LinkedHashSet();

    public final synchronized void a(am amVar) {
        this.a.add(amVar);
    }

    public final synchronized void b(am amVar) {
        this.a.remove(amVar);
    }

    public final synchronized boolean c(am amVar) {
        return this.a.contains(amVar);
    }
}
