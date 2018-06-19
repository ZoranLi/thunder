package com.xunlei.downloadprovider.download.taskdetails.subtask;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.LoaderManager;
import android.util.LruCache;
import com.xunlei.downloadprovider.download.engine.kernel.c;
import com.xunlei.downloadprovider.download.engine.task.a.t;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: BTSubTaskListLoader */
public class b extends c {
    private static final String o = "b";
    public final t b = new t("BTTaskDetail", new c(this));
    public LoaderManager c;
    ArrayList<com.xunlei.downloadprovider.download.taskdetails.items.a.a> d = new ArrayList();
    public ArrayList<BTSubTaskItem> e = new ArrayList();
    public boolean f = false;
    DownloadTaskInfo g;
    LruCache<String, BTSubTaskItem> h = new LruCache(100);
    long i = -1;
    boolean j = false;
    public Context k;
    public a l;
    public Handler m = new Handler(Looper.getMainLooper(), new d(this));
    boolean n;
    private final int p = 5;
    private final int q = 1000;
    private final int r = 1;
    private final int s = 100;
    private long t = 0;

    /* compiled from: BTSubTaskListLoader */
    public interface a {
        void a();

        void a(List<com.xunlei.downloadprovider.download.taskdetails.items.a.a> list, boolean z);

        void b();
    }

    static String a(long j, long j2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j);
        stringBuilder.append("_");
        stringBuilder.append(j2);
        return stringBuilder.toString();
    }

    public final void a(DownloadTaskInfo downloadTaskInfo) {
        this.g = downloadTaskInfo;
        if (this.d != null && !this.d.isEmpty()) {
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((com.xunlei.downloadprovider.download.taskdetails.items.a.a) it.next()).d = downloadTaskInfo;
            }
        }
    }

    public final void a() {
        this.n = false;
        this.c.initLoader(10, null, new e(this));
    }

    public final void b() {
        this.c.destroyLoader(10);
        this.e.clear();
    }

    static /* synthetic */ void b(b bVar) {
        if (!bVar.e.isEmpty()) {
            Iterator it = bVar.e.iterator();
            while (it.hasNext()) {
                ((BTSubTaskItem) it.next()).refreshTaskUI();
            }
        }
        if (bVar.l != null) {
            bVar.l.a();
        }
    }

    static /* synthetic */ void d(b bVar) {
        if (bVar.l != null) {
            bVar.l.b();
        }
    }
}
