package okio;

import com.umeng.message.proguard.k;
import java.io.IOException;

/* compiled from: AsyncTimeout */
final class c implements v {
    final /* synthetic */ v a;
    final /* synthetic */ a b;

    c(a aVar, v vVar) {
        this.b = aVar;
        this.a = vVar;
    }

    public final long a(e eVar, long j) throws IOException {
        this.b.t_();
        try {
            eVar = this.a.a(eVar, j);
            this.b.a(true);
            return eVar;
        } catch (e eVar2) {
            throw this.b.b(eVar2);
        } catch (Throwable th) {
            this.b.a(false);
        }
    }

    public final void close() throws IOException {
        try {
            this.a.close();
            this.b.a(true);
        } catch (IOException e) {
            throw this.b.b(e);
        } catch (Throwable th) {
            this.b.a(false);
        }
    }

    public final w a() {
        return this.b;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("AsyncTimeout.source(");
        stringBuilder.append(this.a);
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
