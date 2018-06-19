package com.xunlei.downloadprovider.download.engine.task;

import android.app.Service;
import android.content.ClipboardManager;
import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import android.os.Handler;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.downloadprovider.download.assistant.clipboardmonitor.j;
import com.xunlei.downloadprovider.download.engine.task.a.p;
import com.xunlei.downloadprovider.download.engine.task.a.s;
import com.xunlei.downloadprovider.download.engine.task.a.w;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.service.c;

/* compiled from: DownloadEngineServiceLike */
public final class k extends c {
    private static long i;
    private static long j;
    public i a = null;
    public boolean b = null;
    public com.xunlei.downloadprovider.notification.c c;
    public a d;
    public MessageListener e = new l(this);
    public Handler f;
    private j h = j.a();

    /* compiled from: DownloadEngineServiceLike */
    public interface a {
        void a();
    }

    public k(Service service) {
        super(service);
    }

    final boolean a(m mVar) {
        if (this.c != null) {
            this.c.c = true;
        }
        long j = 0;
        if (!mVar.a.mTaskInvisible) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - i;
            i = currentTimeMillis;
            if (j2 < 1000) {
                j += 800;
            } else {
                j = 0;
            }
            j = j;
        }
        return this.a.a(mVar, j);
    }

    final s a() {
        return this.a != null ? this.a.g() : null;
    }

    public final void b() {
        super.b();
        if (this.a == null) {
            this.a = new i(this.g);
        }
        if (this.c == null) {
            this.c = com.xunlei.downloadprovider.notification.c.a(this.g);
            com.xunlei.downloadprovider.notification.c cVar = this.c;
            cVar.b = this;
            Handler handler = cVar.d;
            if (handler != null) {
                p pVar = this.a.b;
                if (!(handler == null || pVar.b.contains(handler))) {
                    pVar.b.add(handler);
                }
            }
            a(cVar.d);
        }
        OnPrimaryClipChangedListener onPrimaryClipChangedListener = this.h;
        try {
            onPrimaryClipChangedListener.a = (ClipboardManager) this.g.getSystemService("clipboard");
            if (onPrimaryClipChangedListener.a != null) {
                onPrimaryClipChangedListener.a.addPrimaryClipChangedListener(onPrimaryClipChangedListener);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void c() {
        super.c();
        Handler handler = this.c.d;
        if (handler != null) {
            p pVar = this.a.b;
            if (handler != null && pVar.b.contains(handler)) {
                pVar.b.remove(handler);
            }
        }
        a(null);
        OnPrimaryClipChangedListener onPrimaryClipChangedListener = this.h;
        try {
            onPrimaryClipChangedListener.a.removePrimaryClipChangedListener(onPrimaryClipChangedListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    final boolean a(w wVar) {
        return this.a != null ? this.a.a(wVar) : null;
    }

    private void a(Handler handler) {
        this.a.a = handler;
    }

    static /* synthetic */ void a(k kVar) {
        LoginHelper.a();
        if (!l.b()) {
            LoginHelper.a().a(false);
        }
        if (kVar.d != null) {
            kVar.d.a();
            kVar.d = null;
        }
    }
}
