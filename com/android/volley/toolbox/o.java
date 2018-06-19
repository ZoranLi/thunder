package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.os.Handler;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.l;
import java.util.HashMap;
import java.util.LinkedList;

/* compiled from: ImageLoader */
public final class o {
    final l a;
    final b b;
    final HashMap<String, a> c;
    final HashMap<String, a> d;
    Runnable e;
    private int f;
    private final Handler g;

    /* compiled from: ImageLoader */
    private class a {
        Bitmap a;
        VolleyError b;
        final LinkedList<c> c = new LinkedList();
        final /* synthetic */ o d;
        private final Request<?> e;

        public a(o oVar, Request<?> request, c cVar) {
            this.d = oVar;
            this.e = request;
            this.c.add(cVar);
        }

        public final boolean a(c cVar) {
            this.c.remove(cVar);
            if (this.c.size() != null) {
                return null;
            }
            this.e.cancel();
            return true;
        }
    }

    /* compiled from: ImageLoader */
    public interface b {
        Bitmap a();
    }

    /* compiled from: ImageLoader */
    public class c {
        Bitmap a;
        final d b;
        final String c;
        final /* synthetic */ o d;
        private final String e;

        public c(o oVar, Bitmap bitmap, String str, String str2, d dVar) {
            this.d = oVar;
            this.a = bitmap;
            this.c = str;
            this.e = str2;
            this.b = dVar;
        }

        public final void a() {
            if (this.b != null) {
                a aVar = (a) this.d.c.get(this.e);
                if (aVar != null) {
                    if (aVar.a(this)) {
                        this.d.c.remove(this.e);
                    }
                    return;
                }
                aVar = (a) this.d.d.get(this.e);
                if (aVar != null) {
                    aVar.a(this);
                    if (aVar.c.size() == 0) {
                        this.d.d.remove(this.e);
                    }
                }
            }
        }
    }

    /* compiled from: ImageLoader */
    public interface d extends com.android.volley.n.a {
        void a(c cVar, boolean z);
    }

    final void a(String str, a aVar) {
        this.d.put(str, aVar);
        if (this.e == null) {
            this.e = new r(this);
            this.g.postDelayed(this.e, (long) this.f);
        }
    }
}
