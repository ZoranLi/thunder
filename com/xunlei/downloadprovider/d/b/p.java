package com.xunlei.downloadprovider.d.b;

import android.support.annotation.NonNull;
import java.util.ArrayList;

/* compiled from: SearchConfig */
public class p extends com.xunlei.downloadprovider.d.a {
    private static final String b = "p";
    public ArrayList<a> a = new ArrayList();

    /* compiled from: SearchConfig */
    public static class a implements Comparable<a> {
        public int a;
        public int b = 3;
        public String c;
        public int d;

        public final /* bridge */ /* synthetic */ int compareTo(@NonNull Object obj) {
            return this.b - ((a) obj).b;
        }

        public a(int i, int i2, String str) {
            this.a = i;
            this.c = str;
            this.d = i2;
        }
    }

    public static boolean b() {
        return false;
    }

    public p() {
        this.a.add(new a(0, 1, "全网搜索"));
        this.a.add(new a(4, 2, "站内搜索"));
        this.a.add(new a(5, 3, "相关用户"));
        this.a.add(new a(6, 4, "相关视频"));
    }

    public final java.util.ArrayList<java.lang.String> a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = "search_box_hint_list";
        r1 = r5.b(r1);
        if (r1 == 0) goto L_0x0036;
    L_0x000d:
        r2 = r1.length();
        if (r2 <= 0) goto L_0x0036;
    L_0x0013:
        r2 = r1.length();	 Catch:{ JSONException -> 0x0036 }
        r3 = 0;	 Catch:{ JSONException -> 0x0036 }
        r4 = 1;	 Catch:{ JSONException -> 0x0036 }
        if (r2 != r4) goto L_0x0026;	 Catch:{ JSONException -> 0x0036 }
    L_0x001b:
        r2 = r1.getString(r3);	 Catch:{ JSONException -> 0x0036 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ JSONException -> 0x0036 }
        if (r2 == 0) goto L_0x0026;	 Catch:{ JSONException -> 0x0036 }
    L_0x0025:
        return r0;	 Catch:{ JSONException -> 0x0036 }
    L_0x0026:
        r2 = r1.length();	 Catch:{ JSONException -> 0x0036 }
        if (r3 >= r2) goto L_0x0036;	 Catch:{ JSONException -> 0x0036 }
    L_0x002c:
        r2 = r1.getString(r3);	 Catch:{ JSONException -> 0x0036 }
        r0.add(r2);	 Catch:{ JSONException -> 0x0036 }
        r3 = r3 + 1;
        goto L_0x0026;
    L_0x0036:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.d.b.p.a():java.util.ArrayList<java.lang.String>");
    }

    public final boolean a(java.lang.String[] r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = 5;
        r2 = r6.length;
        if (r2 == r1) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        r2 = "search_hint_default_words";
        r2 = r5.b(r2);
        if (r2 == 0) goto L_0x0022;
    L_0x000e:
        r3 = r2.length();
        if (r3 != r1) goto L_0x0022;
    L_0x0014:
        r3 = r0;
    L_0x0015:
        if (r3 >= r1) goto L_0x0020;
    L_0x0017:
        r4 = r2.getString(r3);	 Catch:{ JSONException -> 0x0022 }
        r6[r3] = r4;	 Catch:{ JSONException -> 0x0022 }
        r3 = r3 + 1;
        goto L_0x0015;
    L_0x0020:
        r6 = 1;
        return r6;
    L_0x0022:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.d.b.p.a(java.lang.String[]):boolean");
    }

    public final boolean b(java.lang.String[] r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = 5;
        r2 = r6.length;
        if (r2 == r1) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        r2 = "search_hint_words";
        r2 = r5.b(r2);
        if (r2 == 0) goto L_0x0022;
    L_0x000e:
        r3 = r2.length();
        if (r3 != r1) goto L_0x0022;
    L_0x0014:
        r3 = r0;
    L_0x0015:
        if (r3 >= r1) goto L_0x0020;
    L_0x0017:
        r4 = r2.getString(r3);	 Catch:{ JSONException -> 0x0022 }
        r6[r3] = r4;	 Catch:{ JSONException -> 0x0022 }
        r3 = r3 + 1;
        goto L_0x0015;
    L_0x0020:
        r6 = 1;
        return r6;
    L_0x0022:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.d.b.p.b(java.lang.String[]):boolean");
    }

    public final boolean c() {
        return a("is_transcode_open", false);
    }
}
