package okio;

import com.umeng.message.proguard.k;
import java.io.IOException;

/* compiled from: ForwardingSource */
public abstract class i implements v {
    private final v a;

    public i(v vVar) {
        if (vVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = vVar;
    }

    public final long a(e eVar, long j) throws IOException {
        return this.a.a(eVar, j);
    }

    public final w a() {
        return this.a.a();
    }

    public void close() throws IOException {
        this.a.close();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(k.s);
        stringBuilder.append(this.a.toString());
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
