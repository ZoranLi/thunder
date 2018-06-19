package com.xunlei.downloadprovider.download.taskdetails.items.a;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.xunlei.downloadprovider.download.control.a;
import com.xunlei.downloadprovider.download.player.a.m;
import com.xunlei.downloadprovider.download.taskdetails.ag;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;

/* compiled from: TaskDetailViewHolder */
public abstract class b extends ViewHolder {
    protected DownloadTaskInfo d;
    protected a e;
    protected ag f;
    public a g;
    protected m h;

    public void a() {
    }

    public abstract void a(a aVar);

    public void a(boolean z) {
    }

    public b(View view) {
        super(view);
    }

    public final void a(m mVar) {
        this.h = mVar;
    }

    public final void a(ag agVar) {
        this.f = agVar;
    }

    public final a b() {
        return this.e;
    }

    public final Activity c() {
        if (this.f.a() == null) {
            return null;
        }
        return this.f.a().a;
    }

    @Nullable
    protected final DownloadTaskInfo d() {
        return this.d;
    }

    public final void b(a aVar) {
        this.d = aVar == null ? null : aVar.d;
        this.e = aVar;
    }
}
