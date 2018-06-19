package android.arch.a.a;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.util.HashMap;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: FastSafeIterableMap */
public final class a<K, V> extends b<K, V> {
    public HashMap<K, c<K, V>> a = new HashMap();

    protected final c<K, V> a(K k) {
        return (c) this.a.get(k);
    }

    public final V a(@NonNull K k, @NonNull V v) {
        c a = a(k);
        if (a != null) {
            return a.b;
        }
        this.a.put(k, b(k, v));
        return null;
    }

    public final boolean b(K k) {
        return this.a.containsKey(k);
    }
}
