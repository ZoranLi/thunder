package okhttp3.internal.a;

import com.umeng.message.util.HttpRequest;
import java.util.Date;
import okhttp3.af;
import okhttp3.aj;
import okhttp3.internal.b.d;
import okhttp3.internal.b.f;

/* compiled from: CacheStrategy */
public class d$a {
    final long a;
    final af b;
    final aj c;
    Date d;
    String e;
    Date f;
    String g;
    Date h;
    long i;
    long j;
    String k;
    int l = -1;

    public d$a(long j, af afVar, aj ajVar) {
        this.a = j;
        this.b = afVar;
        this.c = ajVar;
        if (ajVar != null) {
            this.i = ajVar.k;
            this.j = ajVar.l;
            j = ajVar.f;
            afVar = j.a.length / 2;
            for (int i = 0; i < afVar; i++) {
                ajVar = j.a(i);
                String b = j.b(i);
                if (HttpRequest.HEADER_DATE.equalsIgnoreCase(ajVar)) {
                    this.d = d.a(b);
                    this.e = b;
                } else if (HttpRequest.HEADER_EXPIRES.equalsIgnoreCase(ajVar)) {
                    this.h = d.a(b);
                } else if (HttpRequest.HEADER_LAST_MODIFIED.equalsIgnoreCase(ajVar)) {
                    this.f = d.a(b);
                    this.g = b;
                } else if (HttpRequest.HEADER_ETAG.equalsIgnoreCase(ajVar)) {
                    this.k = b;
                } else if ("Age".equalsIgnoreCase(ajVar) != null) {
                    this.l = f.b(b, -1);
                }
            }
        }
    }
}
