package okhttp3;

import java.io.File;
import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.internal.c;
import okio.f;

/* compiled from: RequestBody */
public abstract class ag {
    public long a() throws IOException {
        return -1;
    }

    public abstract void a(f fVar) throws IOException;

    @Nullable
    public abstract aa b();

    public static ag a(@Nullable aa aaVar, byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        c.a((long) bArr.length, (long) i);
        return new ah(aaVar, i, bArr);
    }

    public static ag a(@Nullable aa aaVar, File file) {
        if (file != null) {
            return new ai(aaVar, file);
        }
        throw new NullPointerException("content == null");
    }
}
