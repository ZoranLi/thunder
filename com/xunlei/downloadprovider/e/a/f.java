package com.xunlei.downloadprovider.e.a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.b.h;
import com.xunlei.downloadprovider.homepage.recommend.b.c;
import com.xunlei.downloadprovider.homepage.recommend.b.d;
import com.xunlei.downloadprovider.homepage.recommend.feed.k;
import com.xunlei.xllib.android.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LikePresenterImpl */
public class f {
    private static f a;
    private SparseArray<List<e>> b = new SparseArray();
    private int c = 0;
    private boolean d = false;

    /* compiled from: LikePresenterImpl */
    public interface a {
        void a();

        void b();
    }

    public static f a() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                }
            }
        }
        return a;
    }

    public final void a(int i, e eVar) {
        if (eVar != null) {
            List list = (List) this.b.get(i);
            if (list == null) {
                list = new ArrayList();
                this.b.put(i, list);
            }
            if (list.contains(eVar) == 0) {
                list.add(eVar);
            }
        }
    }

    public final void b(int i, e eVar) {
        List list = (List) this.b.get(i);
        if (list != null) {
            list.remove(eVar);
        }
    }

    public final boolean a(e eVar) {
        List list = (List) this.b.get(1);
        if (list != null && list.size() > 0) {
            list.contains(eVar);
        }
        return null;
    }

    public final void a(Context context, d dVar, a aVar) {
        int i = dVar.a;
        String str = dVar.b;
        String str2 = dVar.c;
        int i2 = dVar.d;
        dVar = dVar.e;
        k.a();
        int i3 = i2 + 1;
        if (str != null) {
            if (k.a != null) {
                Editor edit = k.a.edit();
                edit.putBoolean(k.a(i, str), true);
                edit.putInt(k.b(i, str), i3);
                edit.apply();
            }
        }
        if (b.a(BrothersApplication.getApplicationInstance())) {
            com.xunlei.downloadprovider.homepage.recommend.a.a.a().a(String.valueOf(str), i, str2, new g(this, aVar), new h(this, aVar));
        } else if (i != 7) {
            XLThreadPool.execute(new d(c.a(), str, "", "", str2));
        }
        List list = (List) this.b.get(i);
        if (list != null && list.size() > 0) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((e) list.get(i4)).a(str, i2);
            }
        }
        aVar = h.a();
        if (aVar.d == -1) {
            aVar.d = aVar.a.getInt("like_count", 0);
        }
        int i5 = aVar.d + 1;
        aVar.d = i5;
        aVar.a.edit().putInt("like_count", i5).apply();
        if (this.c >= 2) {
            if (aVar.d == -1) {
                aVar.d = aVar.a.getInt("like_count", 0);
            }
            com.xunlei.downloadprovider.b.a.a(context, aVar.d);
        }
        if (i == 1 && dVar != null) {
            if (this.c == null) {
                XLToast.showToast(BrothersApplication.getApplicationInstance(), "将为你推荐更多相关视频");
                this.c = 1;
            } else if (this.c == 1) {
                XLToast.showToast(BrothersApplication.getApplicationInstance(), "在“我赞过的”可查看赞过的视频");
                this.c = 2;
            }
        }
        if (i == 8 && this.d == null) {
            this.d = true;
            XLToast.showToast(BrothersApplication.getApplicationInstance(), "在“我赞过的”可查看赞过的影评");
        }
    }
}
