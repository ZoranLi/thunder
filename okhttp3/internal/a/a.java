package okhttp3.internal.a;

import anet.channel.util.HttpConstant;
import com.umeng.message.util.HttpRequest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.af;
import okhttp3.aj;
import okhttp3.e;
import okhttp3.internal.b.f;
import okhttp3.internal.b.i;
import okhttp3.internal.c;
import okhttp3.y;
import okhttp3.y$a;
import okhttp3.z;
import okio.m;
import okio.u;
import okio.v;

/* compiled from: CacheInterceptor */
public final class a implements z {
    final f a;

    public a(f fVar) {
        this.a = fVar;
    }

    public final aj a(okhttp3.z.a aVar) throws IOException {
        d dVar;
        Object obj;
        af afVar;
        aj ajVar;
        okhttp3.aj.a aVar2;
        aj ajVar2;
        String str;
        aj a = this.a != null ? r1.a.a() : null;
        d$a okhttp3_internal_a_d_a = new d$a(System.currentTimeMillis(), aVar.a(), a);
        if (okhttp3_internal_a_d_a.c == null) {
            dVar = new d(okhttp3_internal_a_d_a.b, null);
        } else if (okhttp3_internal_a_d_a.b.a.b() && okhttp3_internal_a_d_a.c.e == null) {
            dVar = new d(okhttp3_internal_a_d_a.b, null);
        } else if (d.a(okhttp3_internal_a_d_a.c, okhttp3_internal_a_d_a.b)) {
            e b = okhttp3_internal_a_d_a.b.b();
            if (!b.c) {
                long max;
                e b2;
                long toMillis;
                long time;
                HttpUrl httpUrl;
                String str2;
                StringBuilder stringBuilder;
                long toMillis2;
                long j;
                long j2;
                okhttp3.aj.a a2;
                Object obj2;
                aj a3;
                String str3;
                y$a a4;
                okhttp3.af.a a5;
                af afVar2 = okhttp3_internal_a_d_a.b;
                if (afVar2.a("If-Modified-Since") == null) {
                    if (afVar2.a(HttpRequest.HEADER_IF_NONE_MATCH) == null) {
                        obj = null;
                        if (obj != null) {
                            max = okhttp3_internal_a_d_a.d == null ? Math.max(0, okhttp3_internal_a_d_a.j - okhttp3_internal_a_d_a.d.getTime()) : 0;
                            if (okhttp3_internal_a_d_a.l != -1) {
                                max = Math.max(max, TimeUnit.SECONDS.toMillis((long) okhttp3_internal_a_d_a.l));
                            }
                            max = (max + (okhttp3_internal_a_d_a.j - okhttp3_internal_a_d_a.i)) + (okhttp3_internal_a_d_a.a - okhttp3_internal_a_d_a.j);
                            b2 = okhttp3_internal_a_d_a.c.b();
                            if (b2.e == -1) {
                                toMillis = TimeUnit.SECONDS.toMillis((long) b2.e);
                            } else {
                                if (okhttp3_internal_a_d_a.h != null) {
                                    if (okhttp3_internal_a_d_a.d == null) {
                                        toMillis = okhttp3_internal_a_d_a.d.getTime();
                                    } else {
                                        toMillis = okhttp3_internal_a_d_a.j;
                                    }
                                    time = okhttp3_internal_a_d_a.h.getTime() - toMillis;
                                    if (time > 0) {
                                        toMillis = time;
                                    }
                                } else if (okhttp3_internal_a_d_a.f != null) {
                                    httpUrl = okhttp3_internal_a_d_a.c.a.a;
                                    if (httpUrl.d != null) {
                                        str2 = null;
                                    } else {
                                        stringBuilder = new StringBuilder();
                                        HttpUrl.b(stringBuilder, httpUrl.d);
                                        str2 = stringBuilder.toString();
                                    }
                                    if (str2 == null) {
                                        if (okhttp3_internal_a_d_a.d == null) {
                                            toMillis = okhttp3_internal_a_d_a.d.getTime();
                                        } else {
                                            toMillis = okhttp3_internal_a_d_a.i;
                                        }
                                        time = toMillis - okhttp3_internal_a_d_a.f.getTime();
                                        if (time > 0) {
                                            toMillis = time / 10;
                                        }
                                    }
                                }
                                toMillis = 0;
                            }
                            if (b.e != -1) {
                                toMillis = Math.min(toMillis, TimeUnit.SECONDS.toMillis((long) b.e));
                            }
                            toMillis2 = b.j == -1 ? TimeUnit.SECONDS.toMillis((long) b.j) : 0;
                            b2 = okhttp3_internal_a_d_a.c.b();
                            if (!b2.h || b.i == -1) {
                                j = 0;
                            } else {
                                j = TimeUnit.SECONDS.toMillis((long) b.i);
                            }
                            if (!b2.c) {
                                j2 = max + toMillis2;
                                if (j2 < toMillis + j) {
                                    a2 = okhttp3_internal_a_d_a.c.a();
                                    if (j2 >= toMillis) {
                                        a2.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                                    }
                                    if (max > 86400000) {
                                        obj2 = (okhttp3_internal_a_d_a.c.b().e == -1 || okhttp3_internal_a_d_a.h != null) ? null : 1;
                                        if (obj2 != null) {
                                            a2.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                                        }
                                    }
                                    a3 = a2.a();
                                    obj = null;
                                    dVar = new d(null, a3);
                                    if (dVar.a != null && okhttp3_internal_a_d_a.b.b().k) {
                                        dVar = new d(obj, obj);
                                    }
                                    afVar = dVar.a;
                                    ajVar = dVar.b;
                                    if (a != null && ajVar == null) {
                                        c.a(a.g);
                                    }
                                    if (afVar != null && ajVar == null) {
                                        aVar2 = new okhttp3.aj.a();
                                        aVar2.a = aVar.a();
                                        aVar2.b = Protocol.HTTP_1_1;
                                        aVar2.c = 504;
                                        aVar2.d = "Unsatisfiable Request (only-if-cached)";
                                        aVar2.g = c.c;
                                        aVar2.k = -1;
                                        aVar2.l = System.currentTimeMillis();
                                        return aVar2.a();
                                    } else if (afVar != null) {
                                        return ajVar.a().b(a(ajVar)).a();
                                    } else {
                                        ajVar2 = aVar;
                                        try {
                                            ajVar2 = ajVar2.a(afVar);
                                            if (ajVar2 == null) {
                                            }
                                            if (ajVar != null) {
                                                if (ajVar2.c != 304) {
                                                    aVar2 = ajVar.a().a(a(ajVar.f, ajVar2.f));
                                                    aVar2.k = ajVar2.k;
                                                    aVar2.l = ajVar2.l;
                                                    a = aVar2.b(a(ajVar)).a(a(ajVar2)).a();
                                                    ajVar2.g.close();
                                                    return a;
                                                }
                                                c.a(ajVar.g);
                                            }
                                            a = ajVar2.a().b(a(ajVar)).a(a(ajVar2)).a();
                                            if (r1.a != null) {
                                                if (f.b(a) || !d.a(a, afVar)) {
                                                    str = afVar.b;
                                                    if (!(str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE"))) {
                                                        str.equals("MOVE");
                                                    }
                                                } else {
                                                    c b3 = r1.a.b();
                                                    if (b3 == null) {
                                                        return a;
                                                    }
                                                    u a6 = b3.a();
                                                    if (a6 == null) {
                                                        return a;
                                                    }
                                                    v bVar = new b(r1, a.g.c(), b3, m.a(a6));
                                                    okhttp3.aj.a a7 = a.a();
                                                    a7.g = new i(a.f, m.a(bVar));
                                                    return a7.a();
                                                }
                                            }
                                            return a;
                                        } finally {
                                            if (a != null) {
                                                c.a(a.g);
                                            }
                                        }
                                    }
                                }
                            }
                            if (okhttp3_internal_a_d_a.k != null) {
                                str = HttpRequest.HEADER_IF_NONE_MATCH;
                                str3 = okhttp3_internal_a_d_a.k;
                            } else if (okhttp3_internal_a_d_a.f != null) {
                                str = "If-Modified-Since";
                                str3 = okhttp3_internal_a_d_a.g;
                            } else if (okhttp3_internal_a_d_a.d == null) {
                                str = "If-Modified-Since";
                                str3 = okhttp3_internal_a_d_a.e;
                            } else {
                                obj = null;
                                dVar = new d(okhttp3_internal_a_d_a.b, null);
                                dVar = new d(obj, obj);
                                afVar = dVar.a;
                                ajVar = dVar.b;
                                c.a(a.g);
                                if (afVar != null) {
                                }
                                if (afVar != null) {
                                    return ajVar.a().b(a(ajVar)).a();
                                }
                                ajVar2 = aVar;
                                ajVar2 = ajVar2.a(afVar);
                                if (ajVar2 == null) {
                                }
                                if (ajVar != null) {
                                    if (ajVar2.c != 304) {
                                        c.a(ajVar.g);
                                    } else {
                                        aVar2 = ajVar.a().a(a(ajVar.f, ajVar2.f));
                                        aVar2.k = ajVar2.k;
                                        aVar2.l = ajVar2.l;
                                        a = aVar2.b(a(ajVar)).a(a(ajVar2)).a();
                                        ajVar2.g.close();
                                        return a;
                                    }
                                }
                                a = ajVar2.a().b(a(ajVar)).a(a(ajVar2)).a();
                                if (r1.a != null) {
                                    if (f.b(a)) {
                                    }
                                    str = afVar.b;
                                    str.equals("MOVE");
                                }
                                return a;
                            }
                            a4 = okhttp3_internal_a_d_a.b.c.a();
                            okhttp3.internal.a.a.a(a4, str, str3);
                            a5 = okhttp3_internal_a_d_a.b.a();
                            a5.c = a4.a().a();
                            dVar = new d(a5.a(), okhttp3_internal_a_d_a.c);
                            obj = null;
                            dVar = new d(obj, obj);
                            afVar = dVar.a;
                            ajVar = dVar.b;
                            c.a(a.g);
                            if (afVar != null) {
                            }
                            if (afVar != null) {
                                return ajVar.a().b(a(ajVar)).a();
                            }
                            ajVar2 = aVar;
                            ajVar2 = ajVar2.a(afVar);
                            if (ajVar2 == null) {
                            }
                            if (ajVar != null) {
                                if (ajVar2.c != 304) {
                                    aVar2 = ajVar.a().a(a(ajVar.f, ajVar2.f));
                                    aVar2.k = ajVar2.k;
                                    aVar2.l = ajVar2.l;
                                    a = aVar2.b(a(ajVar)).a(a(ajVar2)).a();
                                    ajVar2.g.close();
                                    return a;
                                }
                                c.a(ajVar.g);
                            }
                            a = ajVar2.a().b(a(ajVar)).a(a(ajVar2)).a();
                            if (r1.a != null) {
                                if (f.b(a)) {
                                }
                                str = afVar.b;
                                str.equals("MOVE");
                            }
                            return a;
                        }
                    }
                }
                obj = 1;
                if (obj != null) {
                    if (okhttp3_internal_a_d_a.d == null) {
                    }
                    if (okhttp3_internal_a_d_a.l != -1) {
                        max = Math.max(max, TimeUnit.SECONDS.toMillis((long) okhttp3_internal_a_d_a.l));
                    }
                    max = (max + (okhttp3_internal_a_d_a.j - okhttp3_internal_a_d_a.i)) + (okhttp3_internal_a_d_a.a - okhttp3_internal_a_d_a.j);
                    b2 = okhttp3_internal_a_d_a.c.b();
                    if (b2.e == -1) {
                        if (okhttp3_internal_a_d_a.h != null) {
                            if (okhttp3_internal_a_d_a.d == null) {
                                toMillis = okhttp3_internal_a_d_a.j;
                            } else {
                                toMillis = okhttp3_internal_a_d_a.d.getTime();
                            }
                            time = okhttp3_internal_a_d_a.h.getTime() - toMillis;
                            if (time > 0) {
                                toMillis = time;
                            }
                        } else if (okhttp3_internal_a_d_a.f != null) {
                            httpUrl = okhttp3_internal_a_d_a.c.a.a;
                            if (httpUrl.d != null) {
                                stringBuilder = new StringBuilder();
                                HttpUrl.b(stringBuilder, httpUrl.d);
                                str2 = stringBuilder.toString();
                            } else {
                                str2 = null;
                            }
                            if (str2 == null) {
                                if (okhttp3_internal_a_d_a.d == null) {
                                    toMillis = okhttp3_internal_a_d_a.i;
                                } else {
                                    toMillis = okhttp3_internal_a_d_a.d.getTime();
                                }
                                time = toMillis - okhttp3_internal_a_d_a.f.getTime();
                                if (time > 0) {
                                    toMillis = time / 10;
                                }
                            }
                        }
                        toMillis = 0;
                    } else {
                        toMillis = TimeUnit.SECONDS.toMillis((long) b2.e);
                    }
                    if (b.e != -1) {
                        toMillis = Math.min(toMillis, TimeUnit.SECONDS.toMillis((long) b.e));
                    }
                    if (b.j == -1) {
                    }
                    b2 = okhttp3_internal_a_d_a.c.b();
                    if (b2.h) {
                    }
                    j = 0;
                    if (b2.c) {
                        j2 = max + toMillis2;
                        if (j2 < toMillis + j) {
                            a2 = okhttp3_internal_a_d_a.c.a();
                            if (j2 >= toMillis) {
                                a2.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                            }
                            if (max > 86400000) {
                                if (okhttp3_internal_a_d_a.c.b().e == -1) {
                                }
                                if (obj2 != null) {
                                    a2.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                                }
                            }
                            a3 = a2.a();
                            obj = null;
                            dVar = new d(null, a3);
                            dVar = new d(obj, obj);
                            afVar = dVar.a;
                            ajVar = dVar.b;
                            c.a(a.g);
                            if (afVar != null) {
                            }
                            if (afVar != null) {
                                return ajVar.a().b(a(ajVar)).a();
                            }
                            ajVar2 = aVar;
                            ajVar2 = ajVar2.a(afVar);
                            if (ajVar2 == null) {
                            }
                            if (ajVar != null) {
                                if (ajVar2.c != 304) {
                                    c.a(ajVar.g);
                                } else {
                                    aVar2 = ajVar.a().a(a(ajVar.f, ajVar2.f));
                                    aVar2.k = ajVar2.k;
                                    aVar2.l = ajVar2.l;
                                    a = aVar2.b(a(ajVar)).a(a(ajVar2)).a();
                                    ajVar2.g.close();
                                    return a;
                                }
                            }
                            a = ajVar2.a().b(a(ajVar)).a(a(ajVar2)).a();
                            if (r1.a != null) {
                                if (f.b(a)) {
                                }
                                str = afVar.b;
                                str.equals("MOVE");
                            }
                            return a;
                        }
                    }
                    if (okhttp3_internal_a_d_a.k != null) {
                        str = HttpRequest.HEADER_IF_NONE_MATCH;
                        str3 = okhttp3_internal_a_d_a.k;
                    } else if (okhttp3_internal_a_d_a.f != null) {
                        str = "If-Modified-Since";
                        str3 = okhttp3_internal_a_d_a.g;
                    } else if (okhttp3_internal_a_d_a.d == null) {
                        obj = null;
                        dVar = new d(okhttp3_internal_a_d_a.b, null);
                        dVar = new d(obj, obj);
                        afVar = dVar.a;
                        ajVar = dVar.b;
                        c.a(a.g);
                        if (afVar != null) {
                        }
                        if (afVar != null) {
                            return ajVar.a().b(a(ajVar)).a();
                        }
                        ajVar2 = aVar;
                        ajVar2 = ajVar2.a(afVar);
                        if (ajVar2 == null) {
                        }
                        if (ajVar != null) {
                            if (ajVar2.c != 304) {
                                aVar2 = ajVar.a().a(a(ajVar.f, ajVar2.f));
                                aVar2.k = ajVar2.k;
                                aVar2.l = ajVar2.l;
                                a = aVar2.b(a(ajVar)).a(a(ajVar2)).a();
                                ajVar2.g.close();
                                return a;
                            }
                            c.a(ajVar.g);
                        }
                        a = ajVar2.a().b(a(ajVar)).a(a(ajVar2)).a();
                        if (r1.a != null) {
                            if (f.b(a)) {
                            }
                            str = afVar.b;
                            str.equals("MOVE");
                        }
                        return a;
                    } else {
                        str = "If-Modified-Since";
                        str3 = okhttp3_internal_a_d_a.e;
                    }
                    a4 = okhttp3_internal_a_d_a.b.c.a();
                    okhttp3.internal.a.a.a(a4, str, str3);
                    a5 = okhttp3_internal_a_d_a.b.a();
                    a5.c = a4.a().a();
                    dVar = new d(a5.a(), okhttp3_internal_a_d_a.c);
                    obj = null;
                    dVar = new d(obj, obj);
                    afVar = dVar.a;
                    ajVar = dVar.b;
                    c.a(a.g);
                    if (afVar != null) {
                    }
                    if (afVar != null) {
                        return ajVar.a().b(a(ajVar)).a();
                    }
                    ajVar2 = aVar;
                    ajVar2 = ajVar2.a(afVar);
                    if (ajVar2 == null) {
                    }
                    if (ajVar != null) {
                        if (ajVar2.c != 304) {
                            c.a(ajVar.g);
                        } else {
                            aVar2 = ajVar.a().a(a(ajVar.f, ajVar2.f));
                            aVar2.k = ajVar2.k;
                            aVar2.l = ajVar2.l;
                            a = aVar2.b(a(ajVar)).a(a(ajVar2)).a();
                            ajVar2.g.close();
                            return a;
                        }
                    }
                    a = ajVar2.a().b(a(ajVar)).a(a(ajVar2)).a();
                    if (r1.a != null) {
                        if (f.b(a)) {
                        }
                        str = afVar.b;
                        str.equals("MOVE");
                    }
                    return a;
                }
            }
            obj = null;
            dVar = new d(okhttp3_internal_a_d_a.b, obj);
            dVar = new d(obj, obj);
            afVar = dVar.a;
            ajVar = dVar.b;
            c.a(a.g);
            if (afVar != null) {
            }
            if (afVar != null) {
                return ajVar.a().b(a(ajVar)).a();
            }
            ajVar2 = aVar;
            ajVar2 = ajVar2.a(afVar);
            if (ajVar2 == null) {
            }
            if (ajVar != null) {
                if (ajVar2.c != 304) {
                    aVar2 = ajVar.a().a(a(ajVar.f, ajVar2.f));
                    aVar2.k = ajVar2.k;
                    aVar2.l = ajVar2.l;
                    a = aVar2.b(a(ajVar)).a(a(ajVar2)).a();
                    ajVar2.g.close();
                    return a;
                }
                c.a(ajVar.g);
            }
            a = ajVar2.a().b(a(ajVar)).a(a(ajVar2)).a();
            if (r1.a != null) {
                if (f.b(a)) {
                }
                str = afVar.b;
                str.equals("MOVE");
            }
            return a;
        } else {
            dVar = new d(okhttp3_internal_a_d_a.b, null);
        }
        obj = null;
        dVar = new d(obj, obj);
        afVar = dVar.a;
        ajVar = dVar.b;
        c.a(a.g);
        if (afVar != null) {
        }
        if (afVar != null) {
            return ajVar.a().b(a(ajVar)).a();
        }
        ajVar2 = aVar;
        ajVar2 = ajVar2.a(afVar);
        if (ajVar2 == null) {
        }
        if (ajVar != null) {
            if (ajVar2.c != 304) {
                c.a(ajVar.g);
            } else {
                aVar2 = ajVar.a().a(a(ajVar.f, ajVar2.f));
                aVar2.k = ajVar2.k;
                aVar2.l = ajVar2.l;
                a = aVar2.b(a(ajVar)).a(a(ajVar2)).a();
                ajVar2.g.close();
                return a;
            }
        }
        a = ajVar2.a().b(a(ajVar)).a(a(ajVar2)).a();
        if (r1.a != null) {
            if (f.b(a)) {
            }
            str = afVar.b;
            str.equals("MOVE");
        }
        return a;
    }

    private static y a(y yVar, y yVar2) {
        y$a okhttp3_y_a = new y$a();
        int i = 0;
        int length = yVar.a.length / 2;
        for (int i2 = 0; i2 < length; i2++) {
            String a = yVar.a(i2);
            String b = yVar.b(i2);
            if (!("Warning".equalsIgnoreCase(a) && b.startsWith("1")) && (!a(a) || yVar2.a(a) == null)) {
                okhttp3.internal.a.a.a(okhttp3_y_a, a, b);
            }
        }
        yVar = yVar2.a.length / 2;
        while (i < yVar) {
            String a2 = yVar2.a(i);
            if (!"Content-Length".equalsIgnoreCase(a2) && a(a2)) {
                okhttp3.internal.a.a.a(okhttp3_y_a, a2, yVar2.b(i));
            }
            i++;
        }
        return okhttp3_y_a.a();
    }

    private static boolean a(String str) {
        return (HttpConstant.CONNECTION.equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || HttpRequest.HEADER_PROXY_AUTHORIZATION.equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str) != null) ? null : true;
    }

    private static aj a(aj ajVar) {
        if (ajVar == null || ajVar.g == null) {
            return ajVar;
        }
        ajVar = ajVar.a();
        ajVar.g = null;
        return ajVar.a();
    }
}
