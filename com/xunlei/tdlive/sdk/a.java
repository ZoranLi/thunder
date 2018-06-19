package com.xunlei.tdlive.sdk;

import android.content.Context;
import android.net.Uri;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

/* compiled from: StatHelper */
public class a {
    private static HashSet<IStator> a = new HashSet();
    private static HashMap<String, a> b;

    /* compiled from: StatHelper */
    public static class a {
        private String a;
        private String b;
        private String c;
        private HashMap<String, String> d = new HashMap();

        public a(String str) {
            this.a = str;
        }

        public void a() {
            this.d.clear();
            this.b = null;
            this.c = null;
        }

        public a a(int i) {
            return a(String.valueOf(i));
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public String b() {
            return this.b;
        }

        public a b(String str) {
            this.c = str;
            return this;
        }

        public a a(String str, String str2) {
            this.d.put(str, str2);
            return this;
        }

        public a a(String str, int i) {
            return a(str, String.valueOf(i));
        }

        public a c(String str) {
            return a(str, UUID.randomUUID().toString());
        }

        public String d(String str) {
            str = (String) this.d.get(str);
            return str == null ? "" : str;
        }

        public long a(java.lang.String r3, long r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r3 = r2.d(r3);	 Catch:{ Throwable -> 0x0009 }
            r0 = java.lang.Long.parseLong(r3);	 Catch:{ Throwable -> 0x0009 }
            return r0;
        L_0x0009:
            return r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.sdk.a.a.a(java.lang.String, long):long");
        }

        public a a(String... strArr) {
            if (strArr.length <= 0) {
                this.d.clear();
            } else {
                for (Object remove : strArr) {
                    this.d.remove(remove);
                }
            }
            return this;
        }

        public a b(String... strArr) {
            Map map = this.d;
            if (strArr.length > 0) {
                map = (HashMap) this.d.clone();
                for (Object obj : strArr) {
                    map.put(obj, Uri.encode((String) map.get(obj)));
                }
            }
            a.a(this.a, this.b, this.c, map);
            return this;
        }
    }

    protected static void a(Context context, IStator... iStatorArr) {
        for (IStator iStator : iStatorArr) {
            if (iStator != null) {
                a.add(iStator);
                iStator.init(context);
            }
        }
    }

    protected static void a(String str) {
        Iterator it = a.iterator();
        while (it.hasNext()) {
            ((IStator) it.next()).setUid(str);
        }
    }

    public static void a() {
        Iterator it = a.iterator();
        while (it.hasNext()) {
            ((IStator) it.next()).onResume();
        }
    }

    public static void b() {
        Iterator it = a.iterator();
        while (it.hasNext()) {
            ((IStator) it.next()).onPause();
        }
    }

    public static void b(String str) {
        Iterator it = a.iterator();
        while (it.hasNext()) {
            ((IStator) it.next()).onPageStart(str);
        }
    }

    public static void c(String str) {
        Iterator it = a.iterator();
        while (it.hasNext()) {
            ((IStator) it.next()).onPageEnd(str);
        }
    }

    public static void a(String str, String str2, String str3, Map<String, String> map) {
        Iterator it = a.iterator();
        while (it.hasNext()) {
            ((IStator) it.next()).traceEvent(str, str2, str3, map);
        }
    }

    public static a d(String str) {
        if (b == null) {
            b = new HashMap();
        }
        if (str == null) {
            return null;
        }
        a aVar = (a) b.get(str);
        if (aVar != null) {
            return aVar;
        }
        aVar = new a(str);
        b.put(str, aVar);
        return aVar;
    }
}
