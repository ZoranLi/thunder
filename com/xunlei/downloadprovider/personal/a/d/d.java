package com.xunlei.downloadprovider.personal.a.d;

import com.android.volley.l;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.personal.a.b.h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: UserCenterDataManager */
public class d {
    private static d e;
    public List<h> a;
    public ArrayList<a> b = new ArrayList();
    public final l c = VolleyRequestManager.getMainThreadRequestQueue();
    private boolean d = true;

    /* compiled from: UserCenterDataManager */
    public interface a {
        void a(List<h> list);
    }

    /* compiled from: UserCenterDataManager */
    public interface b {
        void a();
    }

    private d() {
        this.b.add(new a(1));
        this.b.add(new a(3));
    }

    public static d a() {
        if (e == null) {
            synchronized (d.class) {
                if (e == null) {
                    e = new d();
                }
            }
        }
        return e;
    }

    public final int b() {
        return this.b != null ? this.b.size() : 0;
    }

    public final int a(int i) {
        return this.b != null ? ((a) this.b.get(i)).a : 0;
    }

    static /* synthetic */ void a(d dVar) {
        if (dVar.d) {
            dVar.b.add(new a(com.xunlei.downloadprovider.personal.a.b.a.a().b()));
            dVar.d = false;
        }
    }
}
