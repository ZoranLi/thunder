package com.xunlei.downloadprovider.download.taskdetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.a.e;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.taskdetail.c;
import com.xunlei.downloadprovider.contentpublish.website.a.m;
import com.xunlei.downloadprovider.download.engine.task.a.t;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.taskdetails.b.b;
import com.xunlei.downloadprovider.download.taskdetails.widget.FloatDragView;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.k;
import java.util.ArrayList;
import java.util.List;

public class TaskDetailFragment extends Fragment {
    final af a = new af();
    final b b = new b();
    ag c;
    DownloadTaskInfo d;
    com.xunlei.downloadprovider.download.control.a e;
    ao f;
    boolean g;
    RecyclerView h;
    c i = null;
    b j;
    FloatDragView k;
    boolean l;
    boolean m;
    a n = null;
    final t o = new t("BTTaskDetail", new am(this));
    private boolean p = true;
    private boolean q = true;
    private LinearLayoutManager r;
    private OnScrollListener s = new ah(this);
    private final int t = 1;

    public interface a {
        void a(boolean z, l lVar, c cVar);
    }

    public static boolean a(TaskInfo taskInfo) {
        if (taskInfo == null || TextUtils.isEmpty(taskInfo.mWebsiteName)) {
            return false;
        }
        String str = "";
        if (!TextUtils.isEmpty(taskInfo.mRefUrl)) {
            str = taskInfo.mRefUrl;
        } else if (!(taskInfo.mExtraInfo == null || TextUtils.isEmpty(taskInfo.mExtraInfo.mRefUrl))) {
            str = taskInfo.mExtraInfo.mRefUrl;
        }
        if (m.a().d(str) != null) {
            return true;
        }
        return false;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_task_detail, viewGroup, false);
        this.q = com.xunlei.downloadprovider.d.l.a().b();
        this.h = (RecyclerView) inflate.findViewById(R.id.task_detail_recycler_view);
        this.r = new LinearLayoutManager(getActivity());
        this.h.setLayoutManager(this.r);
        this.h.setAdapter(this.c);
        this.h.setItemAnimator(new k());
        this.j.a(inflate, this.h);
        this.h.setOnScrollListener(this.s);
        return inflate;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.i = new c(getActivity());
        c.d();
        this.i.a(new ak(this));
        this.c = new ag(getContext());
        this.c.setHasStableIds(false);
        this.c.a(this.e);
        this.c.d = this.i;
        this.c.a(new aj(this));
        this.c.g = this.g;
        this.a.a = new com.xunlei.downloadprovider.download.taskdetails.items.a.a(1, this.d, null, -1);
        this.b.b = this.a.a;
        this.a.b = new com.xunlei.downloadprovider.download.taskdetails.items.a.a(3, this.d, null, -1);
        this.a.c = new com.xunlei.downloadprovider.download.taskdetails.items.a.a(4, this.d, null, -1);
        this.b.c = this.a.c;
        this.a.d = new com.xunlei.downloadprovider.download.taskdetails.items.a.a(8, this.d, null, 0);
        this.a.e = new com.xunlei.downloadprovider.download.taskdetails.items.a.a(9, this.d, null, 0);
        this.a.f = new com.xunlei.downloadprovider.download.taskdetails.items.a.a(10, null, null, 0);
        this.b.e = new com.xunlei.downloadprovider.download.taskdetails.items.a.a(8, this.d, null, 0);
        this.b.f = new com.xunlei.downloadprovider.download.taskdetails.items.a.a(9, this.d, null, 0);
        this.b.g = new com.xunlei.downloadprovider.download.taskdetails.items.a.a(10, null, null, 0);
        this.a.g = new com.xunlei.downloadprovider.download.taskdetails.items.a.a(5, this.d, null, -1);
        this.b.d = this.a.g;
        i();
        h();
        com.xunlei.downloadprovider.download.util.k.e(this.d);
        List list = this.a.j;
        List list2 = this.a.k;
        list2.add(new com.xunlei.downloadprovider.download.taskdetails.items.a.a(7, null, Integer.valueOf(80), 0));
        this.c.a(list, list2);
        this.j = new b(getContext(), this.c.h);
        this.p = true;
    }

    public void onResume() {
        super.onResume();
        if (this.p) {
            a();
            if (this.c != null) {
                this.c.notifyDataSetChanged();
            }
        }
        this.p = false;
        if (this.o != null) {
            try {
                if (!this.o.isAlive()) {
                    this.o.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void onDestroy() {
        if (this.o != null && this.o.isAlive()) {
            try {
                this.o.a.sendEmptyMessage(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.j != null) {
            this.j.c();
            this.j.b = null;
        }
        b();
        super.onDestroy();
        this.i.f();
    }

    final void a(boolean z, boolean z2) {
        if (!this.g) {
            this.j.a(z, z2, this.c);
        }
    }

    final void a() {
        if (isAdded() && com.xunlei.downloadprovider.download.util.k.e(this.d)) {
            getLoaderManager().initLoader(10, null, new ai(this));
        }
    }

    final void b() {
        if (isAdded()) {
            getLoaderManager().destroyLoader(10);
            this.b.m.clear();
        }
    }

    private void h() {
        ArrayList arrayList = this.a.j;
        ArrayList arrayList2 = this.a.k;
        arrayList.add(this.a.a);
        arrayList.add(this.a.c);
        boolean z = this.d != null && !com.xunlei.downloadprovider.download.util.k.d(this.d) && com.xunlei.downloadprovider.download.util.k.a(this.d) && (this.q || this.d.getTaskStatus() == 8);
        if (z) {
            arrayList.add(this.a.b);
        }
        if (a(this.d)) {
            arrayList.add(this.a.g);
        }
        com.xunlei.downloadprovider.download.taskdetails.items.a.a a = a(this.i, this.a);
        if (a != null) {
            com.xunlei.downloadprovider.ad.taskdetail.b bVar = new com.xunlei.downloadprovider.ad.taskdetail.b(true, this.a.b);
            com.xunlei.downloadprovider.ad.taskdetail.b bVar2 = new com.xunlei.downloadprovider.ad.taskdetail.b(true, this.a.c);
            bVar.a(bVar2).a(new com.xunlei.downloadprovider.ad.taskdetail.b(true, this.a.a)).a(new com.xunlei.downloadprovider.ad.taskdetail.b(false, null));
            bVar.a(arrayList, arrayList2, a);
        }
    }

    private void i() {
        ArrayList arrayList = this.b.j;
        arrayList.add(this.b.b);
        arrayList.add(this.b.c);
        if (a(this.d)) {
            arrayList.add(this.b.d);
        }
        arrayList = this.b.j;
        ArrayList arrayList2 = this.b.k;
        com.xunlei.downloadprovider.download.taskdetails.items.a.a a = a(this.i, this.b);
        if (a != null) {
            com.xunlei.downloadprovider.ad.taskdetail.b bVar = new com.xunlei.downloadprovider.ad.taskdetail.b(true, this.b.c);
            bVar.a(new com.xunlei.downloadprovider.ad.taskdetail.b(true, this.b.b).a(new com.xunlei.downloadprovider.ad.taskdetail.b(false, null)));
            bVar.a(arrayList, arrayList2, a);
        }
    }

    final boolean c() {
        if (this.c != null) {
            if (isAdded()) {
                List list;
                List list2;
                if (com.xunlei.downloadprovider.download.util.k.e(this.d)) {
                    this.b.j.clear();
                    this.b.k.clear();
                    i();
                    list = this.b.j;
                    list2 = this.b.k;
                    if (!(!this.b.j.contains(this.b.b) || this.c == null || this.c.c() == null)) {
                        this.c.c().a();
                    }
                    if (!(!this.b.j.contains(this.b.d) || this.c == null || this.c.i == null)) {
                        this.c.i.a();
                    }
                } else {
                    this.a.j.clear();
                    this.a.k.clear();
                    h();
                    list = this.a.j;
                    list2 = this.a.k;
                    if (!(!this.a.j.contains(this.a.a) || this.c == null || this.c.c() == null)) {
                        this.c.c().a();
                    }
                    if (!(!this.a.j.contains(this.a.g) || this.c == null || this.c.i == null)) {
                        this.c.i.a();
                    }
                }
                this.c.a(list, list2);
                return true;
            }
        }
        return false;
    }

    public final void d() {
        if (isVisible()) {
            if (isAdded()) {
                if (isVisible()) {
                    if (isAdded()) {
                        if (!(this.d == null || this.c == null)) {
                            this.c.f();
                        }
                    }
                }
            }
        }
    }

    public static void e() {
        e.a().a(false);
    }

    public final void f() {
        this.i.a(false);
        this.i.e();
        e.a().a(true);
    }

    public final void g() {
        b();
        if (this.c != null) {
            this.c.a(true);
        }
    }

    @Nullable
    private com.xunlei.downloadprovider.download.taskdetails.items.a.a a(c cVar, Object obj) {
        l lVar = cVar.e;
        if (lVar != null) {
            switch (an.a[lVar.v.ordinal()]) {
                case 1:
                    if (this.m != null) {
                        return null;
                    }
                    cVar.g();
                    return null;
                case 2:
                case 4:
                    if ((obj instanceof af) != null) {
                        return ((af) obj).e;
                    }
                    if ((obj instanceof b) != null) {
                        return ((b) obj).f;
                    }
                    return null;
                case 3:
                    if ((obj instanceof af) != null) {
                        return ((af) obj).d;
                    }
                    if ((obj instanceof b) != null) {
                        return ((b) obj).e;
                    }
                    return null;
                default:
                    return null;
            }
        } else if ((obj instanceof af) != null) {
            return ((af) obj).f;
        } else {
            if ((obj instanceof b) != null) {
                return ((b) obj).g;
            }
            return null;
        }
    }

    static /* synthetic */ void a(TaskDetailFragment taskDetailFragment, DownloadTaskInfo downloadTaskInfo) {
        if (downloadTaskInfo != null) {
            if (com.xunlei.downloadprovider.download.util.k.d(downloadTaskInfo)) {
                if (com.xunlei.downloadprovider.download.util.k.g(downloadTaskInfo)) {
                    com.xunlei.downloadprovider.download.report.a.a("finish_install", downloadTaskInfo);
                } else if (com.xunlei.downloadprovider.download.util.k.a(downloadTaskInfo)) {
                    com.xunlei.downloadprovider.download.report.a.a("finish_play", downloadTaskInfo);
                } else {
                    com.xunlei.downloadprovider.download.report.a.a("finish_open", downloadTaskInfo);
                }
                if (com.xunlei.downloadprovider.download.util.k.c(downloadTaskInfo)) {
                    taskDetailFragment.e.a((TaskInfo) downloadTaskInfo, "", "download_detail");
                    return;
                } else {
                    taskDetailFragment.e.b((TaskInfo) downloadTaskInfo);
                    return;
                }
            }
            com.xunlei.downloadprovider.download.report.a.a("dl_bxbb", downloadTaskInfo);
            if (downloadTaskInfo.getTaskStatus() == 4) {
                com.xunlei.downloadprovider.cooperation.ui.b.a().e = true;
                if (!com.xunlei.xllib.android.b.e(taskDetailFragment.getContext())) {
                    taskDetailFragment.e.c(downloadTaskInfo);
                }
            }
            com.xunlei.downloadprovider.download.player.a.m.a(taskDetailFragment.getContext(), downloadTaskInfo, null, "download_detail");
        }
    }
}
