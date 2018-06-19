package com.xunlei.downloadprovider.comment;

import android.text.TextUtils;
import com.android.volley.l;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.comment.entity.f;
import com.xunlei.downloadprovider.comment.entity.k;
import com.xunlei.downloadprovider.member.payment.a.e;

/* compiled from: CommentManager */
public class a extends e {
    public static final String a = "a";
    public l b = VolleyRequestManager.getMainThreadRequestQueue();
    public com.xunlei.downloadprovider.comment.entity.e c;
    public int d = 100;
    private f f;

    /* compiled from: CommentManager */
    public interface a<T> {
        void a(b bVar);

        void a(T t);
    }

    /* compiled from: CommentManager */
    public static class b {
        public int a;
        public String b;
    }

    public final void a(com.xunlei.downloadprovider.comment.entity.e eVar) {
        if (eVar != null) {
            this.c = eVar;
            if (this.f != null && TextUtils.equals(eVar.b, this.f.a) == null) {
                eVar = this.f;
                eVar.a = null;
                eVar.c = 0;
                eVar.b = 0;
                eVar.e = null;
            }
        }
    }

    public final void a(a<f> aVar) {
        a(aVar, "new", "refresh", 0);
    }

    public final void b(a<f> aVar) {
        long j = 0;
        if (this.f != null) {
            f fVar = this.f;
            if (fVar.e != null) {
                if (!fVar.e.isEmpty()) {
                    j = ((CommentInfo) fVar.e.get(fVar.e.size() - 1)).getBaseCommentInfo().getId();
                }
            }
        }
        a<f> aVar2 = aVar;
        a(aVar2, "new", "loadmore", j);
    }

    public final void c(a<f> aVar) {
        a(aVar, "hot", "refresh", 0);
    }

    private void a(a<f> aVar, String str, String str2, long j) {
        if (aVar != null) {
            if (this.c == null) {
                throw new IllegalStateException("no comment resource attached");
            }
            XLThreadPool.execute(new b(this, str, str2, j, aVar));
        }
    }

    public final void a(String str, String str2, a<Long> aVar) {
        a(str, str2, null, -1, 0, 0, aVar);
    }

    public final void a(String str, String str2, String str3, int i, long j, long j2, a<Long> aVar) {
        if (this.c == null) {
            throw new IllegalStateException("no comment resource attached");
        }
        if (!TextUtils.isEmpty(this.c.b)) {
            if (!TextUtils.equals(this.c.b, "null")) {
                k kVar = new k();
                kVar.c = this.c.c;
                kVar.a = this.c.b;
                kVar.b = this.c.a;
                kVar.e = str;
                kVar.f = str2;
                kVar.d = j;
                kVar.g = j2;
                if (TextUtils.isEmpty(str3) == null) {
                    kVar.h = str3;
                }
                kVar.i = i;
                XLThreadPool.execute(new e(this, kVar, aVar));
                return;
            }
        }
        b bVar = new b();
        bVar.a = -1003;
        bVar.b = "gcid is null";
        aVar.a(bVar);
    }
}
