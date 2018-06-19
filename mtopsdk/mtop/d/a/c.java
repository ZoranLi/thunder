package mtopsdk.mtop.d.a;

import java.io.OutputStream;
import mtopsdk.a.b.d;

final class c extends d {
    final /* synthetic */ byte[] a;
    final /* synthetic */ b b;

    c(b bVar, byte[] bArr) {
        this.b = bVar;
        this.a = bArr;
    }

    public final String a() {
        return "application/x-www-form-urlencoded;charset=UTF-8";
    }

    public final void a(OutputStream outputStream) {
        if (outputStream != null && this.a != null) {
            outputStream.write(this.a);
        }
    }
}
