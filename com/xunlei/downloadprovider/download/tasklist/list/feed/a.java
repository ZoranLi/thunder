package com.xunlei.downloadprovider.download.tasklist.list.feed;

import android.net.Uri;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: FeedContentListHelper */
public class a {
    public static final String a = "a";
    private static a b;
    private Map<Integer, b> c = new HashMap();

    /* compiled from: FeedContentListHelper */
    private class a {
        Map<String, String> a = new HashMap();
        final /* synthetic */ a b;

        public a(a aVar) {
            this.b = aVar;
        }
    }

    /* compiled from: FeedContentListHelper */
    private class b {
        Map<String, a> a = new HashMap();
        String b;
        final /* synthetic */ a c;

        public b(a aVar, int i) {
            this.c = aVar;
            aVar = new StringBuilder();
            aVar.append(System.currentTimeMillis() + ((long) i));
            this.b = aVar.toString();
        }
    }

    private a() {
        if (com.xunlei.downloadprovider.download.b.b.c()) {
            this.c.put(Integer.valueOf(0), new b(this, 0));
            return;
        }
        this.c.put(Integer.valueOf(0), new b(this, 1));
        this.c.put(Integer.valueOf(1), new b(this, 2));
        this.c.put(Integer.valueOf(2), new b(this, 3));
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    public final void a(String str, String str2, String str3, int i) {
        b bVar = (b) this.c.get(Integer.valueOf(i));
        if (bVar != null) {
            a aVar = (a) bVar.a.get(str);
            if (aVar == null) {
                aVar = new a(this);
                bVar.a.put(str, aVar);
            }
            aVar.a.put(str2, str3);
        }
    }

    public final String a(List<m> list, int i) {
        b bVar = (b) this.c.get(Integer.valueOf(i));
        if (bVar == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (m b : list) {
            a aVar = (a) bVar.a.get(b.b());
            if (aVar != null) {
                Map map = aVar.a;
                if (map != null) {
                    map.put("sessionid", bVar.b);
                    for (String str : map.keySet()) {
                        String str2 = (String) map.get(str);
                        stringBuilder.append(str);
                        stringBuilder.append('=');
                        stringBuilder.append(str2);
                        stringBuilder.append(',');
                    }
                    if (stringBuilder.length() > 0) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                    stringBuilder.append(';');
                }
            }
        }
        if (stringBuilder.length() > null) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return Uri.encode(stringBuilder.toString());
    }

    public final String a(String str, int i) {
        b bVar = (b) this.c.get(Integer.valueOf(i));
        if (bVar != null) {
            a aVar = (a) bVar.a.get(str);
            if (aVar != null) {
                str = aVar.a;
                if (str != null) {
                    str.put("sessionid", bVar.b);
                    i = new StringBuilder();
                    for (String str2 : str.keySet()) {
                        String str3 = (String) str.get(str2);
                        i.append(str2);
                        i.append('=');
                        i.append(str3);
                        i.append(',');
                    }
                    if (i.length() > null) {
                        i.deleteCharAt(i.length() - 1);
                    }
                    return Uri.encode(i.toString());
                }
            }
        }
        return "";
    }

    public static void b() {
        b = null;
    }
}
