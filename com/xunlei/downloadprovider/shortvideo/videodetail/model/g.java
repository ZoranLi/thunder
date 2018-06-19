package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.android.volley.Request;
import com.android.volley.l;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.comment.entity.m;
import com.xunlei.downloadprovider.comment.h;
import com.xunlei.downloadprovider.comment.k;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.homepage.recommend.a.v;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VipExtra;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ShortMovieDetailDataLoader */
public class g {
    @Nullable
    public a a;
    public ArrayList<com.xunlei.downloadprovider.shortvideo.videodetail.model.a.a> b;
    public long c;
    private long d;
    private final String e;
    private final l f;
    private final com.xunlei.downloadprovider.comment.a g;
    private final a h;
    private final f i;
    private final d j;
    private final c k;
    private final e l;
    private LoginHelper m;
    private String n;
    private String o;
    private final Handler p;
    private b q;
    private ArrayList<com.xunlei.downloadprovider.shortvideo.videodetail.model.a.a> r;

    /* compiled from: ShortMovieDetailDataLoader */
    public interface a {
        void a(int i, com.xunlei.downloadprovider.comment.entity.f fVar);

        void a(int i, String str);

        void a(int i, List<v> list);

        void a(long j);

        void a(CommentInfo commentInfo);

        void a(com.xunlei.downloadprovider.comment.entity.f fVar);

        void a(String str);

        void a(String str, b bVar);

        void a(List<e> list);

        void b(CommentInfo commentInfo);

        void b(com.xunlei.downloadprovider.comment.entity.f fVar);
    }

    /* compiled from: ShortMovieDetailDataLoader */
    private class c implements Runnable {
        final /* synthetic */ g a;

        private c(g gVar) {
            this.a = gVar;
        }

        public final void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r9 = this;
            r0 = com.xunlei.downloadprovider.shortvideo.videodetail.model.g.class;
            monitor-enter(r0);
            r1 = r9.a;	 Catch:{ all -> 0x0105 }
            r1 = r1.h;	 Catch:{ all -> 0x0105 }
            if (r1 != 0) goto L_0x000d;	 Catch:{ all -> 0x0105 }
        L_0x000b:
            monitor-exit(r0);	 Catch:{ all -> 0x0105 }
            return;	 Catch:{ all -> 0x0105 }
        L_0x000d:
            r1 = r9.a;	 Catch:{ all -> 0x0105 }
            r1 = r1.r;	 Catch:{ all -> 0x0105 }
            if (r1 == 0) goto L_0x0103;	 Catch:{ all -> 0x0105 }
        L_0x0015:
            r1 = r9.a;	 Catch:{ all -> 0x0105 }
            r1 = r1.r;	 Catch:{ all -> 0x0105 }
            r1 = r1.size();	 Catch:{ all -> 0x0105 }
            if (r1 <= 0) goto L_0x0103;	 Catch:{ all -> 0x0105 }
        L_0x0021:
            r1 = r9.a;	 Catch:{ all -> 0x0105 }
            r1 = r1.h;	 Catch:{ all -> 0x0105 }
            r2 = r9.a;	 Catch:{ all -> 0x0105 }
            r2 = r2.r;	 Catch:{ all -> 0x0105 }
            if (r2 == 0) goto L_0x00fa;	 Catch:{ all -> 0x0105 }
        L_0x002f:
            r3 = r2.size();	 Catch:{ all -> 0x0105 }
            if (r3 != 0) goto L_0x0037;	 Catch:{ all -> 0x0105 }
        L_0x0035:
            goto L_0x00fa;	 Catch:{ all -> 0x0105 }
        L_0x0037:
            r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0105 }
            r4 = "insert data size =>";	 Catch:{ all -> 0x0105 }
            r3.<init>(r4);	 Catch:{ all -> 0x0105 }
            r4 = r2.size();	 Catch:{ all -> 0x0105 }
            r3.append(r4);	 Catch:{ all -> 0x0105 }
            r3 = 0;
            r1 = r1.getWritableDatabase();	 Catch:{ SQLiteConstraintException -> 0x00ed, SQLiteException -> 0x00cb }
            r1.beginTransaction();	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r4 = new android.content.ContentValues;	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r4.<init>();	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r2 = r2.iterator();	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
        L_0x0056:
            r5 = r2.hasNext();	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            if (r5 == 0) goto L_0x00b1;	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
        L_0x005c:
            r5 = r2.next();	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r5 = (com.xunlei.downloadprovider.shortvideo.videodetail.model.a.a) r5;	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r4.clear();	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r6 = "res_id";	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r7 = r5.e;	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r4.put(r6, r7);	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r6 = "src_id";	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r7 = r5.f;	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r4.put(r6, r7);	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r6 = "usr_id";	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r7 = r5.g;	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r7 = java.lang.Long.valueOf(r7);	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r4.put(r6, r7);	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r6 = "comment_id";	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r7 = r5.a;	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r7 = java.lang.Long.valueOf(r7);	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r4.put(r6, r7);	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r6 = "has_zan";	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r7 = r5.b;	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r4.put(r6, r7);	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r6 = "has_login";	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r7 = r5.c;	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r4.put(r6, r7);	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r6 = "has_commit";	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r5 = r5.d;	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r5 = java.lang.Integer.valueOf(r5);	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r4.put(r6, r5);	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r5 = "comment_zan_info";	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r6 = 5;	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            r1.insertWithOnConflict(r5, r3, r4, r6);	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            goto L_0x0056;	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
        L_0x00b1:
            r1.setTransactionSuccessful();	 Catch:{ SQLiteConstraintException -> 0x00ee, SQLiteException -> 0x00c5, all -> 0x00c3 }
            if (r1 == 0) goto L_0x00fa;
        L_0x00b6:
            r2 = r1.isOpen();	 Catch:{ all -> 0x0105 }
            if (r2 == 0) goto L_0x00fa;	 Catch:{ all -> 0x0105 }
        L_0x00bc:
            r1.endTransaction();	 Catch:{ all -> 0x0105 }
        L_0x00bf:
            r1.close();	 Catch:{ all -> 0x0105 }
            goto L_0x00fa;
        L_0x00c3:
            r2 = move-exception;
            goto L_0x00de;
        L_0x00c5:
            r2 = move-exception;
            r3 = r1;
            goto L_0x00cc;
        L_0x00c8:
            r2 = move-exception;
            r1 = r3;
            goto L_0x00de;
        L_0x00cb:
            r2 = move-exception;
        L_0x00cc:
            r2.printStackTrace();	 Catch:{ all -> 0x00c8 }
            if (r3 == 0) goto L_0x00fa;
        L_0x00d1:
            r1 = r3.isOpen();	 Catch:{ all -> 0x0105 }
            if (r1 == 0) goto L_0x00fa;	 Catch:{ all -> 0x0105 }
        L_0x00d7:
            r3.endTransaction();	 Catch:{ all -> 0x0105 }
            r3.close();	 Catch:{ all -> 0x0105 }
            goto L_0x00fa;	 Catch:{ all -> 0x0105 }
        L_0x00de:
            if (r1 == 0) goto L_0x00ec;	 Catch:{ all -> 0x0105 }
        L_0x00e0:
            r3 = r1.isOpen();	 Catch:{ all -> 0x0105 }
            if (r3 == 0) goto L_0x00ec;	 Catch:{ all -> 0x0105 }
        L_0x00e6:
            r1.endTransaction();	 Catch:{ all -> 0x0105 }
            r1.close();	 Catch:{ all -> 0x0105 }
        L_0x00ec:
            throw r2;	 Catch:{ all -> 0x0105 }
        L_0x00ed:
            r1 = r3;	 Catch:{ all -> 0x0105 }
        L_0x00ee:
            if (r1 == 0) goto L_0x00fa;	 Catch:{ all -> 0x0105 }
        L_0x00f0:
            r2 = r1.isOpen();	 Catch:{ all -> 0x0105 }
            if (r2 == 0) goto L_0x00fa;	 Catch:{ all -> 0x0105 }
        L_0x00f6:
            r1.endTransaction();	 Catch:{ all -> 0x0105 }
            goto L_0x00bf;	 Catch:{ all -> 0x0105 }
        L_0x00fa:
            r1 = r9.a;	 Catch:{ all -> 0x0105 }
            r1 = r1.r;	 Catch:{ all -> 0x0105 }
            r1.clear();	 Catch:{ all -> 0x0105 }
        L_0x0103:
            monitor-exit(r0);	 Catch:{ all -> 0x0105 }
            return;	 Catch:{ all -> 0x0105 }
        L_0x0105:
            r1 = move-exception;	 Catch:{ all -> 0x0105 }
            monitor-exit(r0);	 Catch:{ all -> 0x0105 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.shortvideo.videodetail.model.g.c.run():void");
        }
    }

    /* compiled from: ShortMovieDetailDataLoader */
    private class d implements Runnable {
        String a;
        final /* synthetic */ g b;

        private d(g gVar) {
            this.b = gVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r4 = this;
            r0 = com.xunlei.downloadprovider.shortvideo.videodetail.model.g.class;
            monitor-enter(r0);
            r1 = r4.b;	 Catch:{ all -> 0x0043 }
            r1 = r1.h;	 Catch:{ all -> 0x0043 }
            if (r1 != 0) goto L_0x000d;
        L_0x000b:
            monitor-exit(r0);	 Catch:{ all -> 0x0043 }
            return;
        L_0x000d:
            r1 = r4.b;	 Catch:{ all -> 0x0043 }
            r2 = r4.b;	 Catch:{ all -> 0x0043 }
            r2 = r2.h;	 Catch:{ all -> 0x0043 }
            r3 = r4.a;	 Catch:{ all -> 0x0043 }
            r2 = r2.a(r3);	 Catch:{ all -> 0x0043 }
            r1.b = r2;	 Catch:{ all -> 0x0043 }
            r1 = r4.b;	 Catch:{ all -> 0x0043 }
            r1 = r1.r;	 Catch:{ all -> 0x0043 }
            if (r1 == 0) goto L_0x0041;
        L_0x0026:
            r1 = r4.b;	 Catch:{ all -> 0x0043 }
            r1 = r1.r;	 Catch:{ all -> 0x0043 }
            r1 = r1.isEmpty();	 Catch:{ all -> 0x0043 }
            if (r1 != 0) goto L_0x0041;
        L_0x0032:
            r1 = r4.b;	 Catch:{ all -> 0x0043 }
            r1 = r1.b;	 Catch:{ all -> 0x0043 }
            r2 = r4.b;	 Catch:{ all -> 0x0043 }
            r2 = r2.r;	 Catch:{ all -> 0x0043 }
            r1.addAll(r2);	 Catch:{ all -> 0x0043 }
        L_0x0041:
            monitor-exit(r0);	 Catch:{ all -> 0x0043 }
            return;
        L_0x0043:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0043 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.shortvideo.videodetail.model.g.d.run():void");
        }
    }

    /* compiled from: ShortMovieDetailDataLoader */
    private class e implements Runnable {
        final /* synthetic */ g a;

        private e(g gVar) {
            this.a = gVar;
        }

        public final void run() {
            if (this.a.h != null) {
                if (this.a.g != null) {
                    ArrayList a = this.a.h.a();
                    if (a != null) {
                        if (a.size() != 0) {
                            this.a.g.b = VolleyRequestManager.getRequestQueue();
                            Iterator it = a.iterator();
                            while (it.hasNext()) {
                                com.xunlei.downloadprovider.shortvideo.videodetail.model.a.a aVar = (com.xunlei.downloadprovider.shortvideo.videodetail.model.a.a) it.next();
                                com.xunlei.downloadprovider.comment.entity.e eVar = new com.xunlei.downloadprovider.comment.entity.e();
                                eVar.a = 1;
                                eVar.b = aVar.e;
                                eVar.c = aVar.f;
                                this.a.g.a(eVar);
                                com.xunlei.downloadprovider.comment.a m = this.a.g;
                                long j = aVar.a;
                                boolean z = aVar.c;
                                com.xunlei.downloadprovider.comment.a.a avVar = new av(this);
                                if (m.c == null) {
                                    throw new IllegalStateException("no comment resource attached");
                                }
                                com.xunlei.downloadprovider.comment.entity.l mVar = new m();
                                mVar.c = m.c.c;
                                mVar.a = m.c.b;
                                mVar.b = m.c.a;
                                mVar.f = z;
                                mVar.d = j;
                                Request a2 = mVar.a(new k(m, avVar, j), new com.xunlei.downloadprovider.comment.l(m, avVar));
                                a2.setRetryPolicy(new com.android.volley.d(10000, 1, 1.0f));
                                a2.setTag("SYNC");
                                m.b.a(a2);
                            }
                        }
                    }
                }
            }
        }
    }

    /* compiled from: ShortMovieDetailDataLoader */
    private class f implements Runnable {
        final /* synthetic */ g a;
        private long b;

        private f(g gVar) {
            this.a = gVar;
            this.b = -1;
        }

        public final void run() {
            synchronized (g.class) {
                if (this.a.h == null) {
                    return;
                }
                this.a.b = this.a.h.a(this.b);
            }
        }
    }

    /* compiled from: ShortMovieDetailDataLoader */
    public static class b implements a {
        public void a(int i, com.xunlei.downloadprovider.comment.entity.f fVar) {
        }

        public void a(int i, String str) {
        }

        public void a(int i, List<v> list) {
        }

        public void a(long j) {
        }

        public void a(CommentInfo commentInfo) {
        }

        public void a(com.xunlei.downloadprovider.comment.entity.f fVar) {
        }

        public final void a(String str) {
        }

        public void a(String str, b bVar) {
        }

        public final void a(List<e> list) {
        }

        public void b(CommentInfo commentInfo) {
        }

        public void b(com.xunlei.downloadprovider.comment.entity.f fVar) {
        }
    }

    public g(Context context) {
        this.d = -1;
        this.e = getClass().getSimpleName();
        this.m = LoginHelper.a();
        this.p = new Handler();
        this.b = new ArrayList();
        this.r = new ArrayList();
        this.f = VolleyRequestManager.getRequestQueue();
        this.g = new com.xunlei.downloadprovider.comment.a();
        this.g.b = this.f;
        this.g.d = 20;
        this.h = new a(context.getApplicationContext());
        this.j = new d();
        this.i = new f();
        this.k = new c();
        this.l = new e();
    }

    public g(Context context, com.xunlei.downloadprovider.comment.entity.e eVar) {
        this(context);
        this.g.a(eVar);
        this.n = eVar.b;
        this.o = eVar.c;
    }

    public final void a(com.xunlei.downloadprovider.comment.entity.e eVar) {
        this.g.a(eVar);
        this.n = eVar.b;
        this.o = eVar.c;
    }

    public final void a(b bVar, boolean z) {
        if (this.q == null || bVar == null || !TextUtils.equals(this.q.a().getGcid(), bVar.a().getGcid())) {
            this.q = bVar;
            com.xunlei.downloadprovider.comment.entity.e eVar = new com.xunlei.downloadprovider.comment.entity.e();
            this.n = bVar.a().getGcid();
            this.o = bVar.a().getVideoId();
            if (z) {
                eVar.a = true;
            } else {
                eVar.a = true;
            }
            eVar.b = bVar.a().getGcid();
            eVar.c = bVar.a().getVideoId();
            this.g.a(eVar);
            return;
        }
        this.q = bVar;
    }

    public final void a() {
        this.j.a = this.n;
        XLThreadPool.submit(this.j);
    }

    public final void a(String str, boolean z) {
        if (this.a != null) {
            XLThreadPool.execute(new h(this, str, z));
        }
    }

    public final void a(String str, int i) {
        if (this.a != null) {
            com.xunlei.downloadprovider.homepage.recommend.a.b.a(i, str, new y(this), new ab(this));
        }
    }

    public final void b(String str, int i) {
        XLThreadPool.execute(new ad(this, str, i));
    }

    public final void b() {
        this.g.a(new aj(this));
    }

    public final void c() {
        this.d = System.currentTimeMillis();
        this.g.b(new am(this));
    }

    public final void d() {
        this.g.c(new ap(this));
    }

    public static void a(Context context, String str, String str2) {
        TaskStatInfo taskStatInfo = new TaskStatInfo("break/break_shortvideo_hot", str, "android_client");
        if (context instanceof FragmentActivity) {
            com.xunlei.downloadprovider.download.c.a(context, str, str2, 0, "", taskStatInfo, null, null);
            return;
        }
        com.xunlei.downloadprovider.download.c.a(str, str2, "", taskStatInfo);
    }

    public final void a(String str, String str2, CommentInfo commentInfo) {
        a(str, str2, null, -1, commentInfo);
    }

    public final void a(String str, String str2, String str3, int i, CommentInfo commentInfo) {
        long j = -1;
        long id = commentInfo == null ? -1 : commentInfo.getId();
        if (commentInfo != null) {
            j = commentInfo.getUserId();
        }
        this.g.a(str, str2, str3, i, id, j, new as(r14, str, str3, i, commentInfo));
    }

    public final void a(long j) {
        com.xunlei.downloadprovider.comment.a aVar = this.g;
        com.xunlei.downloadprovider.comment.a.a nVar = new n(this, j);
        if (aVar.c == null) {
            throw new IllegalStateException("no comment resource attached");
        }
        XLThreadPool.execute(new com.xunlei.downloadprovider.comment.m(aVar, j, nVar));
    }

    public final void a(CommentInfo commentInfo) {
        if (commentInfo != null) {
            com.xunlei.downloadprovider.shortvideo.videodetail.model.a.a aVar = new com.xunlei.downloadprovider.shortvideo.videodetail.model.a.a();
            aVar.e = this.n;
            aVar.f = this.o;
            aVar.a = commentInfo.getId();
            aVar.g = commentInfo.getUserId();
            aVar.d = false;
            aVar.b = true;
            aVar.c = com.xunlei.downloadprovider.member.login.b.l.c();
            this.b.add(aVar);
            this.r.add(aVar);
            com.xunlei.downloadprovider.comment.a aVar2 = this.g;
            long id = commentInfo.getId();
            long userId = commentInfo.getUserId();
            com.xunlei.downloadprovider.comment.a.a qVar = new q(this, commentInfo, aVar);
            if (aVar2.c == null) {
                throw new IllegalStateException("no comment resource attached");
            }
            XLThreadPool.execute(new h(aVar2, id, userId, qVar));
        }
    }

    public final void e() {
        new StringBuilder("cancel all request with TAG=>").append(this.e);
        this.f.a(this.e);
        this.g.b.a(com.xunlei.downloadprovider.comment.a.a);
    }

    public final void f() {
        XLThreadPool.submit(this.k);
        if (System.currentTimeMillis() - com.xunlei.downloadprovider.h.f.b(BrothersApplication.getApplicationInstance(), "comment_sync_time", 0) > 7200000 && com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance())) {
            com.xunlei.downloadprovider.h.f.a(BrothersApplication.getApplicationInstance(), "comment_sync_time", System.currentTimeMillis());
            XLThreadPool.submit(this.l);
        }
    }

    static /* synthetic */ void a(g gVar, com.xunlei.downloadprovider.comment.entity.f fVar, boolean z) {
        if (fVar != null) {
            if (fVar.e != null) {
                for (CommentInfo commentInfo : fVar.e) {
                    if (z) {
                        commentInfo.setHot(true);
                    }
                    if (gVar.q != null) {
                        commentInfo.setPublisher(Long.parseLong(gVar.q.b().getUid()));
                    } else {
                        commentInfo.setPublisher(gVar.c);
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(g gVar, VideoUserInfo videoUserInfo) {
        if (com.xunlei.downloadprovider.member.login.b.l.c()) {
            com.xunlei.downloadprovider.member.login.b.b h = gVar.m.g.h();
            VipExtra vipExtra = new VipExtra();
            vipExtra.a = gVar.m.l();
            vipExtra.b = gVar.m.m();
            vipExtra.d = gVar.m.g.f();
            vipExtra.e = gVar.m.u();
            vipExtra.c = 2;
            videoUserInfo.addVip(vipExtra);
            if (h != null) {
                vipExtra = new VipExtra();
                boolean z = false;
                vipExtra.a = h.a == 1;
                vipExtra.b = h.b;
                vipExtra.d = h.d;
                if (h.k == 1) {
                    z = true;
                }
                vipExtra.e = z;
                vipExtra.c = 14;
                videoUserInfo.addVip(vipExtra);
            }
            videoUserInfo.setProvince(gVar.m.j());
            videoUserInfo.setCity(gVar.m.k());
            videoUserInfo.setSex(gVar.m.g());
        }
    }
}
