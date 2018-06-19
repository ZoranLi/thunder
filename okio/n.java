package okio;

import com.umeng.message.proguard.k;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: Okio */
final class n implements u {
    final /* synthetic */ w a;
    final /* synthetic */ OutputStream b;

    n(w wVar, OutputStream outputStream) {
        this.a = wVar;
        this.b = outputStream;
    }

    public final void a_(e eVar, long j) throws IOException {
        y.a(eVar.b, 0, j);
        while (j > 0) {
            this.a.f();
            s sVar = eVar.a;
            int min = (int) Math.min(j, (long) (sVar.c - sVar.b));
            this.b.write(sVar.a, sVar.b, min);
            sVar.b += min;
            long j2 = (long) min;
            long j3 = j - j2;
            eVar.b -= j2;
            if (sVar.b == sVar.c) {
                eVar.a = sVar.a();
                t.a(sVar);
            }
            j = j3;
        }
    }

    public final void flush() throws IOException {
        this.b.flush();
    }

    public final void close() throws IOException {
        this.b.close();
    }

    public final w a() {
        return this.a;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("sink(");
        stringBuilder.append(this.b);
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
