package okhttp3;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okhttp3.ab.b;
import okio.ByteString;

/* compiled from: MultipartBody */
public final class ab$a {
    public final ByteString a;
    public aa b;
    public final List<b> c;

    public ab$a() {
        this(UUID.randomUUID().toString());
    }

    private ab$a(String str) {
        this.b = ab.a;
        this.c = new ArrayList();
        this.a = ByteString.encodeUtf8(str);
    }

    public final ab$a a(b bVar) {
        if (bVar == null) {
            throw new NullPointerException("part == null");
        }
        this.c.add(bVar);
        return this;
    }
}
