package com.xunlei.downloadprovider.homepage;

import com.xunlei.downloadprovider.d.b.h.a;
import com.xunlei.downloadprovider.homepage.choiceness.ui.HomeChoicenessFragment;
import com.xunlei.downloadprovider.homepage.download.DownloadTabFragment;
import com.xunlei.downloadprovider.homepage.follow.ui.FollowTabFragment;
import com.xunlei.downloadprovider.homepage.recommend.SummaryMoviesListFragment;
import com.xunlei.downloadprovider.homepage.youliao.YouliaoVideoFragment;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: HomeTabController */
public class o {
    private static Map<String, Class> h;
    private static o i;
    List<a> a = new ArrayList();
    List<Class<?>> b = new ArrayList();
    List<String> c = new ArrayList();
    List<String> d = new ArrayList();
    public List<Boolean> e = new ArrayList();
    Class<?>[] f;
    String[] g;

    static {
        Map hashMap = new HashMap();
        h = hashMap;
        hashMap.put("choiceness", HomeChoicenessFragment.class);
        h.put("short_movie", SummaryMoviesListFragment.class);
        h.put("follow", FollowTabFragment.class);
        h.put("youliao", YouliaoVideoFragment.class);
        h.put("download", DownloadTabFragment.class);
    }

    public static o a() {
        if (i == null) {
            synchronized (o.class) {
                if (i == null) {
                    i = new o();
                }
            }
        }
        return i;
    }

    private o() {
    }

    final void b() {
        if (!d.a(this.a)) {
            List arrayList = new ArrayList();
            for (a aVar : this.a) {
                Class cls = (Class) h.get(aVar.a);
                if (cls != null) {
                    String str = aVar.b;
                    String str2 = aVar.a;
                    this.b.add(cls);
                    this.c.add(str);
                    this.d.add(str2);
                    this.e.add(Boolean.valueOf(false));
                    arrayList.add(aVar);
                }
            }
            this.a = arrayList;
        }
        this.f = new Class[this.b.size()];
        this.g = new String[this.b.size()];
        this.b.toArray(this.f);
        this.c.toArray(this.g);
    }

    public final String a(int i) {
        return (String) this.d.get(i);
    }

    public final void a(int i, boolean z) {
        if (i < this.e.size()) {
            this.e.set(i, Boolean.valueOf(z));
        }
    }

    public final String b(int i) {
        if (i >= 0) {
            if (i < this.a.size()) {
                return ((a) this.a.get(i)).a;
            }
        }
        return 0;
    }

    public final int a(String str) {
        if (d.a(this.a)) {
            return -1;
        }
        int i = 0;
        while (i < this.a.size()) {
            if (((a) this.a.get(i)).a.equals(str)) {
                break;
            }
            i++;
        }
        i = -1;
        return i;
    }
}
