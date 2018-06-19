package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.umeng.message.proguard.k;
import java.io.IOException;

/* compiled from: AsyncTimeout */
final class b implements u {
    final /* synthetic */ u a;
    final /* synthetic */ a b;

    b(a aVar, u uVar) {
        this.b = aVar;
        this.a = uVar;
    }

    public final void a_(e eVar, long j) throws IOException {
        y.a(eVar.b, 0, j);
        while (true) {
            long j2 = 0;
            if (j > 0) {
                s sVar = eVar.a;
                while (j2 < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    long j3 = j2 + ((long) (eVar.a.c - eVar.a.b));
                    if (j3 >= j) {
                        j2 = j;
                        break;
                    }
                    j2 = j3;
                }
                this.b.t_();
                try {
                    this.a.a_(eVar, j2);
                    long j4 = j - j2;
                    this.b.a(true);
                    j = j4;
                } catch (e eVar2) {
                    throw this.b.b(eVar2);
                } catch (Throwable th) {
                    this.b.a(false);
                }
            } else {
                return;
            }
        }
    }

    public final void flush() throws IOException {
        this.b.t_();
        try {
            this.a.flush();
            this.b.a(true);
        } catch (IOException e) {
            throw this.b.b(e);
        } catch (Throwable th) {
            this.b.a(false);
        }
    }

    public final void close() throws IOException {
        this.b.t_();
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
        StringBuilder stringBuilder = new StringBuilder("AsyncTimeout.sink(");
        stringBuilder.append(this.a);
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
