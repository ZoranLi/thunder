package com.xiaomi.smack.packet;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class d {
    protected static final String a = Locale.getDefault().getLanguage().toLowerCase();
    public static final DateFormat b;
    private static String c;
    private static String d;
    private static long e;
    private String f = c;
    private String g = null;
    private String h = null;
    private String i = null;
    private String j = null;
    private String k = null;
    private List<a> l = new CopyOnWriteArrayList();
    private final Map<String, Object> m = new HashMap();
    private h n = null;

    static {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        b = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(com.xiaomi.smack.util.d.a(5));
        stringBuilder.append("-");
        d = stringBuilder.toString();
    }

    public d(Bundle bundle) {
        this.h = bundle.getString("ext_to");
        this.i = bundle.getString("ext_from");
        this.j = bundle.getString("ext_chid");
        this.g = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.l = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                a a = a.a((Bundle) parcelable);
                if (a != null) {
                    this.l.add(a);
                }
            }
        }
        bundle = bundle.getBundle("ext_ERROR");
        if (bundle != null) {
            this.n = new h(bundle);
        }
    }

    public static synchronized String j() {
        String stringBuilder;
        synchronized (d.class) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(d);
            long j = e;
            e = j + 1;
            stringBuilder2.append(Long.toString(j));
            stringBuilder = stringBuilder2.toString();
        }
        return stringBuilder;
    }

    public static String u() {
        return a;
    }

    public void a(a aVar) {
        this.l.add(aVar);
    }

    public void a(h hVar) {
        this.n = hVar;
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f)) {
            bundle.putString("ext_ns", this.f);
        }
        if (!TextUtils.isEmpty(this.i)) {
            bundle.putString("ext_from", this.i);
        }
        if (!TextUtils.isEmpty(this.h)) {
            bundle.putString("ext_to", this.h);
        }
        if (!TextUtils.isEmpty(this.g)) {
            bundle.putString("ext_pkt_id", this.g);
        }
        if (!TextUtils.isEmpty(this.j)) {
            bundle.putString("ext_chid", this.j);
        }
        if (this.n != null) {
            bundle.putBundle("ext_ERROR", this.n.a());
        }
        if (this.l != null) {
            Parcelable[] parcelableArr = new Bundle[this.l.size()];
            int i = 0;
            for (a e : this.l) {
                Bundle e2 = e.e();
                if (e2 != null) {
                    int i2 = i + 1;
                    parcelableArr[i] = e2;
                    i = i2;
                }
            }
            bundle.putParcelableArray("ext_exts", parcelableArr);
        }
        return bundle;
    }

    public a b(String str, String str2) {
        for (a aVar : this.l) {
            if ((str2 == null || str2.equals(aVar.b())) && str.equals(aVar.a())) {
                return aVar;
            }
        }
        return null;
    }

    public abstract String c();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.n != null) {
            if (!this.n.equals(dVar.n)) {
                return false;
            }
        } else if (dVar.n != null) {
            return false;
        }
        if (this.i != null) {
            if (!this.i.equals(dVar.i)) {
                return false;
            }
        } else if (dVar.i != null) {
            return false;
        }
        if (!this.l.equals(dVar.l)) {
            return false;
        }
        if (this.g != null) {
            if (!this.g.equals(dVar.g)) {
                return false;
            }
        } else if (dVar.g != null) {
            return false;
        }
        if (this.j != null) {
            if (!this.j.equals(dVar.j)) {
                return false;
            }
        } else if (dVar.j != null) {
            return false;
        }
        if (this.m != null) {
            if (!this.m.equals(dVar.m)) {
                return false;
            }
        } else if (dVar.m != null) {
            return false;
        }
        if (this.h != null) {
            if (!this.h.equals(dVar.h)) {
                return false;
            }
        } else if (dVar.h != null) {
            return false;
        }
        if (this.f == null) {
            return dVar.f == null;
        } else {
            if (!this.f.equals(dVar.f)) {
                return false;
            }
        }
    }

    public int hashCode() {
        int i = 0;
        int hashCode = 31 * (((((((((((((this.f != null ? this.f.hashCode() : 0) * 31) + (this.g != null ? this.g.hashCode() : 0)) * 31) + (this.h != null ? this.h.hashCode() : 0)) * 31) + (this.i != null ? this.i.hashCode() : 0)) * 31) + (this.j != null ? this.j.hashCode() : 0)) * 31) + this.l.hashCode()) * 31) + this.m.hashCode());
        if (this.n != null) {
            i = this.n.hashCode();
        }
        return hashCode + i;
    }

    public String k() {
        if ("ID_NOT_AVAILABLE".equals(this.g)) {
            return null;
        }
        if (this.g == null) {
            this.g = j();
        }
        return this.g;
    }

    public void k(String str) {
        this.g = str;
    }

    public String l() {
        return this.j;
    }

    public void l(String str) {
        this.j = str;
    }

    public String m() {
        return this.h;
    }

    public void m(String str) {
        this.h = str;
    }

    public String n() {
        return this.i;
    }

    public void n(String str) {
        this.i = str;
    }

    public String o() {
        return this.k;
    }

    public void o(String str) {
        this.k = str;
    }

    public a p(String str) {
        return b(str, null);
    }

    public h p() {
        return this.n;
    }

    public synchronized Object q(String str) {
        if (this.m == null) {
            return null;
        }
        return this.m.get(str);
    }

    public synchronized Collection<a> q() {
        if (this.l == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.l));
    }

    public synchronized Collection<String> r() {
        if (this.m == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.m.keySet()));
    }

    protected synchronized java.lang.String s() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        monitor-enter(r6);
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x012d }
        r0.<init>();	 Catch:{ all -> 0x012d }
        r1 = r6.q();	 Catch:{ all -> 0x012d }
        r1 = r1.iterator();	 Catch:{ all -> 0x012d }
    L_0x000e:
        r2 = r1.hasNext();	 Catch:{ all -> 0x012d }
        if (r2 == 0) goto L_0x0022;	 Catch:{ all -> 0x012d }
    L_0x0014:
        r2 = r1.next();	 Catch:{ all -> 0x012d }
        r2 = (com.xiaomi.smack.packet.e) r2;	 Catch:{ all -> 0x012d }
        r2 = r2.d();	 Catch:{ all -> 0x012d }
        r0.append(r2);	 Catch:{ all -> 0x012d }
        goto L_0x000e;	 Catch:{ all -> 0x012d }
    L_0x0022:
        r1 = r6.m;	 Catch:{ all -> 0x012d }
        if (r1 == 0) goto L_0x0127;	 Catch:{ all -> 0x012d }
    L_0x0026:
        r1 = r6.m;	 Catch:{ all -> 0x012d }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x012d }
        if (r1 != 0) goto L_0x0127;	 Catch:{ all -> 0x012d }
    L_0x002e:
        r1 = "<properties xmlns=\"http://www.jivesoftware.com/xmlns/xmpp/properties\">";	 Catch:{ all -> 0x012d }
        r0.append(r1);	 Catch:{ all -> 0x012d }
        r1 = r6.r();	 Catch:{ all -> 0x012d }
        r1 = r1.iterator();	 Catch:{ all -> 0x012d }
    L_0x003b:
        r2 = r1.hasNext();	 Catch:{ all -> 0x012d }
        if (r2 == 0) goto L_0x0122;	 Catch:{ all -> 0x012d }
    L_0x0041:
        r2 = r1.next();	 Catch:{ all -> 0x012d }
        r2 = (java.lang.String) r2;	 Catch:{ all -> 0x012d }
        r3 = r6.q(r2);	 Catch:{ all -> 0x012d }
        r4 = "<property>";	 Catch:{ all -> 0x012d }
        r0.append(r4);	 Catch:{ all -> 0x012d }
        r4 = "<name>";	 Catch:{ all -> 0x012d }
        r0.append(r4);	 Catch:{ all -> 0x012d }
        r2 = com.xiaomi.smack.util.d.a(r2);	 Catch:{ all -> 0x012d }
        r0.append(r2);	 Catch:{ all -> 0x012d }
        r2 = "</name>";	 Catch:{ all -> 0x012d }
        r0.append(r2);	 Catch:{ all -> 0x012d }
        r2 = "<value type=\"";	 Catch:{ all -> 0x012d }
        r0.append(r2);	 Catch:{ all -> 0x012d }
        r2 = r3 instanceof java.lang.Integer;	 Catch:{ all -> 0x012d }
        if (r2 == 0) goto L_0x0079;	 Catch:{ all -> 0x012d }
    L_0x006a:
        r2 = "integer\">";	 Catch:{ all -> 0x012d }
        r0.append(r2);	 Catch:{ all -> 0x012d }
        r0.append(r3);	 Catch:{ all -> 0x012d }
        r2 = "</value>";	 Catch:{ all -> 0x012d }
    L_0x0074:
        r0.append(r2);	 Catch:{ all -> 0x012d }
        goto L_0x010f;	 Catch:{ all -> 0x012d }
    L_0x0079:
        r2 = r3 instanceof java.lang.Long;	 Catch:{ all -> 0x012d }
        if (r2 == 0) goto L_0x0088;	 Catch:{ all -> 0x012d }
    L_0x007d:
        r2 = "long\">";	 Catch:{ all -> 0x012d }
        r0.append(r2);	 Catch:{ all -> 0x012d }
        r0.append(r3);	 Catch:{ all -> 0x012d }
        r2 = "</value>";	 Catch:{ all -> 0x012d }
        goto L_0x0074;	 Catch:{ all -> 0x012d }
    L_0x0088:
        r2 = r3 instanceof java.lang.Float;	 Catch:{ all -> 0x012d }
        if (r2 == 0) goto L_0x0097;	 Catch:{ all -> 0x012d }
    L_0x008c:
        r2 = "float\">";	 Catch:{ all -> 0x012d }
        r0.append(r2);	 Catch:{ all -> 0x012d }
        r0.append(r3);	 Catch:{ all -> 0x012d }
        r2 = "</value>";	 Catch:{ all -> 0x012d }
        goto L_0x0074;	 Catch:{ all -> 0x012d }
    L_0x0097:
        r2 = r3 instanceof java.lang.Double;	 Catch:{ all -> 0x012d }
        if (r2 == 0) goto L_0x00a6;	 Catch:{ all -> 0x012d }
    L_0x009b:
        r2 = "double\">";	 Catch:{ all -> 0x012d }
        r0.append(r2);	 Catch:{ all -> 0x012d }
        r0.append(r3);	 Catch:{ all -> 0x012d }
        r2 = "</value>";	 Catch:{ all -> 0x012d }
        goto L_0x0074;	 Catch:{ all -> 0x012d }
    L_0x00a6:
        r2 = r3 instanceof java.lang.Boolean;	 Catch:{ all -> 0x012d }
        if (r2 == 0) goto L_0x00b5;	 Catch:{ all -> 0x012d }
    L_0x00aa:
        r2 = "boolean\">";	 Catch:{ all -> 0x012d }
        r0.append(r2);	 Catch:{ all -> 0x012d }
        r0.append(r3);	 Catch:{ all -> 0x012d }
        r2 = "</value>";	 Catch:{ all -> 0x012d }
        goto L_0x0074;	 Catch:{ all -> 0x012d }
    L_0x00b5:
        r2 = r3 instanceof java.lang.String;	 Catch:{ all -> 0x012d }
        if (r2 == 0) goto L_0x00ca;	 Catch:{ all -> 0x012d }
    L_0x00b9:
        r2 = "string\">";	 Catch:{ all -> 0x012d }
        r0.append(r2);	 Catch:{ all -> 0x012d }
        r3 = (java.lang.String) r3;	 Catch:{ all -> 0x012d }
        r2 = com.xiaomi.smack.util.d.a(r3);	 Catch:{ all -> 0x012d }
        r0.append(r2);	 Catch:{ all -> 0x012d }
        r2 = "</value>";	 Catch:{ all -> 0x012d }
        goto L_0x0074;
    L_0x00ca:
        r2 = 0;
        r4 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0100, all -> 0x00fc }
        r4.<init>();	 Catch:{ Exception -> 0x0100, all -> 0x00fc }
        r5 = new java.io.ObjectOutputStream;	 Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
        r5.<init>(r4);	 Catch:{ Exception -> 0x00f9, all -> 0x00f6 }
        r5.writeObject(r3);	 Catch:{ Exception -> 0x00f4 }
        r2 = "java-object\">";	 Catch:{ Exception -> 0x00f4 }
        r0.append(r2);	 Catch:{ Exception -> 0x00f4 }
        r2 = r4.toByteArray();	 Catch:{ Exception -> 0x00f4 }
        r2 = com.xiaomi.smack.util.d.a(r2);	 Catch:{ Exception -> 0x00f4 }
        r0.append(r2);	 Catch:{ Exception -> 0x00f4 }
        r2 = "</value>";	 Catch:{ Exception -> 0x00f4 }
        r0.append(r2);	 Catch:{ Exception -> 0x00f4 }
        r5.close();	 Catch:{ Exception -> 0x00f0 }
    L_0x00f0:
        r4.close();	 Catch:{ Exception -> 0x010f }
        goto L_0x010f;
    L_0x00f4:
        r2 = move-exception;
        goto L_0x0104;
    L_0x00f6:
        r0 = move-exception;
        r5 = r2;
        goto L_0x0117;
    L_0x00f9:
        r3 = move-exception;
        r5 = r2;
        goto L_0x0103;
    L_0x00fc:
        r0 = move-exception;
        r4 = r2;
        r5 = r4;
        goto L_0x0117;
    L_0x0100:
        r3 = move-exception;
        r4 = r2;
        r5 = r4;
    L_0x0103:
        r2 = r3;
    L_0x0104:
        r2.printStackTrace();	 Catch:{ all -> 0x0116 }
        if (r5 == 0) goto L_0x010c;
    L_0x0109:
        r5.close();	 Catch:{ Exception -> 0x010c }
    L_0x010c:
        if (r4 == 0) goto L_0x010f;
    L_0x010e:
        goto L_0x00f0;
    L_0x010f:
        r2 = "</property>";	 Catch:{ all -> 0x012d }
        r0.append(r2);	 Catch:{ all -> 0x012d }
        goto L_0x003b;
    L_0x0116:
        r0 = move-exception;
    L_0x0117:
        if (r5 == 0) goto L_0x011c;
    L_0x0119:
        r5.close();	 Catch:{ Exception -> 0x011c }
    L_0x011c:
        if (r4 == 0) goto L_0x0121;
    L_0x011e:
        r4.close();	 Catch:{ Exception -> 0x0121 }
    L_0x0121:
        throw r0;	 Catch:{ all -> 0x012d }
    L_0x0122:
        r1 = "</properties>";	 Catch:{ all -> 0x012d }
        r0.append(r1);	 Catch:{ all -> 0x012d }
    L_0x0127:
        r0 = r0.toString();	 Catch:{ all -> 0x012d }
        monitor-exit(r6);
        return r0;
    L_0x012d:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.packet.d.s():java.lang.String");
    }

    public String t() {
        return this.f;
    }
}
