package anet.channel.util;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;

/* compiled from: Taobao */
public class c {
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private volatile boolean f = false;

    private c() {
    }

    public c(c cVar) {
        this.a = cVar.a;
        this.b = cVar.b;
        this.c = cVar.c;
        this.d = cVar.d;
        this.e = cVar.e;
        this.f = cVar.f;
    }

    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i;
        str = str.trim();
        c cVar = new c();
        cVar.d = str;
        if (str.startsWith("//")) {
            cVar.a = null;
            i = 0;
        } else {
            if (str.regionMatches(true, 0, "https:", 0, 6)) {
                cVar.a = "https";
                i = 6;
            } else {
                if (!str.regionMatches(true, 0, "http:", 0, 5)) {
                    return null;
                }
                cVar.a = HttpConstant.HTTP;
                i = 5;
            }
        }
        int length = str.length();
        i += 2;
        int i2 = i;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt != '/' && charAt != ':' && charAt != '?') {
                if (charAt != '#') {
                    i2++;
                }
            }
            cVar.b = str.substring(i, i2);
        }
        if (i2 == length) {
            cVar.b = str.substring(i);
            return cVar;
        }
        i = 0;
        while (i2 < length) {
            charAt = str.charAt(i2);
            if (charAt == '/' && i == 0) {
                i = i2;
            } else {
                if (charAt != '?') {
                    if (charAt == '#') {
                    }
                }
                if (i != 0) {
                    if (i != 0) {
                        if (i2 != 0) {
                            length = i2;
                        }
                        cVar.c = str.substring(i, length);
                    }
                    return cVar;
                }
                i2 = 0;
                if (i != 0) {
                    if (i2 != 0) {
                        length = i2;
                    }
                    cVar.c = str.substring(i, length);
                }
                return cVar;
            }
            i2++;
        }
        i2 = 0;
        if (i != 0) {
            if (i2 != 0) {
                length = i2;
            }
            cVar.c = str.substring(i, length);
        }
        return cVar;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        if (this.e == null) {
            this.e = StringUtils.concatString(this.a, HttpConstant.SCHEME_SPLIT, this.b);
        }
        return this.e;
    }

    public String e() {
        return this.d;
    }

    public java.net.URL f() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0008 }
        r1 = r2.d;	 Catch:{ MalformedURLException -> 0x0008 }
        r0.<init>(r1);	 Catch:{ MalformedURLException -> 0x0008 }
        return r0;
    L_0x0008:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.c.f():java.net.URL");
    }

    public void g() {
        this.f = true;
        if (!HttpConstant.HTTP.equals(this.a)) {
            this.a = HttpConstant.HTTP;
            this.d = StringUtils.concatString(this.a, Constants.COLON_SEPARATOR, this.d.substring(this.d.indexOf("//")));
            this.e = null;
        }
    }

    public boolean h() {
        return this.f;
    }

    public void i() {
        this.f = true;
    }

    public void b(String str) {
        if (!this.f && !this.a.equalsIgnoreCase(str)) {
            this.a = str;
            this.d = StringUtils.concatString(str, Constants.COLON_SEPARATOR, this.d.substring(this.d.indexOf("//")));
            this.e = null;
        }
    }

    public void a(String str, int i) {
        if (i != 0 && str != null) {
            int indexOf = this.d.indexOf("//") + 2;
            while (indexOf < this.d.length() && this.d.charAt(indexOf) != '/') {
                indexOf++;
            }
            StringBuilder stringBuilder = new StringBuilder(this.d.length() + str.length());
            stringBuilder.append(this.a);
            stringBuilder.append(HttpConstant.SCHEME_SPLIT);
            stringBuilder.append(str);
            stringBuilder.append(':');
            stringBuilder.append(i);
            stringBuilder.append(this.d.substring(indexOf));
            this.d = stringBuilder.toString();
        }
    }

    public String toString() {
        return this.d;
    }
}
