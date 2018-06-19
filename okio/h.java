package okio;

import com.umeng.message.proguard.k;
import java.io.IOException;

/* compiled from: ForwardingSink */
public abstract class h implements u {
    private final u a;

    public h(u uVar) {
        if (uVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = uVar;
    }

    public void a_(e eVar, long j) throws IOException {
        this.a.a_(eVar, j);
    }

    public void flush() throws IOException {
        this.a.flush();
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
