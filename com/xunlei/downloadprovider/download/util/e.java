package com.xunlei.downloadprovider.download.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: EpisodeUtil */
public final class e {
    private static b a = new b();

    /* compiled from: EpisodeUtil */
    public static class a {
        public int a = -1;
        public int b = -1;
        public String c = "";
        public String d = "";
    }

    /* compiled from: EpisodeUtil */
    private static class b {
        public static String[] a = new String[]{"(?:([0-9]+)(?:集|话|回))", "(?:EP(?:isode)?[\\s\\.]*([0-9]+))", "(?:(?:第[^\\s]*(?:季|部).*)E(?:(?:P|pisode)?)?[\\s\\.]*([0-9]+))", "(?:S(?:[0-9]+)E[P]?([0-9]+))"};
        public static String[] b = new String[]{"S([0-9]+)E[P]?([0-9]+)"};
        public static String[] c = new String[]{"([\\u4e00-\\u9fa5]+)([0-9]+)\\."};
        final a d = new f(this);
        final a e = new g(this);
        final a f = new h(this);

        /* compiled from: EpisodeUtil */
        static abstract class a {
            protected Pattern b;

            protected abstract a a(String str, Matcher matcher);

            public abstract Pattern a();

            public final a a(String str) {
                return a(str, a().matcher(str));
            }
        }

        public static int a(String str) throws NumberFormatException {
            return Integer.parseInt(str.replaceAll("[^\\d]+", ""), 10);
        }
    }

    public static a a(String str) {
        b bVar = a;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        a a;
        a aVar = new a();
        r3 = new a[3];
        int i = 0;
        r3[0] = bVar.e;
        r3[1] = bVar.d;
        r3[2] = bVar.f;
        while (i < 3) {
            a = r3[i].a(str);
            if (a != null) {
                if (a.b > 0 && a.a > 0) {
                    break;
                }
                if (a.b > 0) {
                    aVar.b = a.b;
                }
                if (a.a > 0) {
                    aVar.a = a.a;
                }
                if (!TextUtils.isEmpty(a.c)) {
                    aVar.c = a.c;
                }
                if (!TextUtils.isEmpty(a.d)) {
                    aVar.d = a.d;
                }
            }
            i++;
        }
        a = aVar;
        return a;
    }
}
