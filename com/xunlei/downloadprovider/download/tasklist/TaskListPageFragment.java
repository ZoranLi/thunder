package com.xunlei.downloadprovider.download.tasklist;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.umeng.message.proguard.k;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.common.accelerator.bean.KnParams;
import com.xunlei.common.accelerator.bean.XLAccelBandInfo;
import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.a.h;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.center.DownloadCenterTabBaseFragment;
import com.xunlei.downloadprovider.download.control.q;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.list.feed.b.c;
import com.xunlei.downloadprovider.download.tasklist.list.feed.f;
import com.xunlei.downloadprovider.download.tasklist.list.feed.view.m;
import com.xunlei.downloadprovider.download.util.i;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.xlui.recyclerview.XLTaskRecyclerView;
import com.xunlei.downloadprovider.xlui.recyclerview.XLTaskRecyclerView.b;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TaskListPageFragment extends DownloadCenterTabBaseFragment implements com.xunlei.downloadprovider.discovery.kuainiao.d.a, com.xunlei.downloadprovider.member.b.a.a {
    private boolean A;
    private boolean B;
    private b C = new a(this);
    private com.xunlei.downloadprovider.download.tasklist.list.feed.e.a<List<e>> D = new c(this);
    private i E = new d(this, this.m);
    private boolean F = false;
    private boolean G;
    private com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr.a H = new b(this);
    com.xunlei.downloadprovider.download.control.a a;
    public int b = 0;
    public XLTaskRecyclerView c;
    public com.xunlei.downloadprovider.download.tasklist.list.a d;
    public a e;
    public Set<LOAD_TAG> f = new HashSet();
    public boolean g;
    public List<String> h = new ArrayList();
    public h i = null;
    public c j = null;
    public boolean k;
    public boolean l = false;
    public Handler m = new Handler();
    public long n;
    public boolean o = false;
    public boolean p = false;
    com.xunlei.downloadprovider.member.b.a q;
    private com.xunlei.downloadprovider.download.tasklist.task.b r;
    private q s;
    private AdapterDataObserver t;
    private com.xunlei.downloadprovider.download.tasklist.task.b.c u;
    private ErrorBlankView v;
    private boolean w;
    private boolean x;
    private int y = 0;
    private int z = 1;

    public enum LOAD_TAG {
        LOAD_LIST_AD,
        LOAD_RECOMMEND_AD,
        LOAD_TASK
    }

    public interface a {
        void a(int i);

        void a(List<e> list);
    }

    public final void a(String str, int i, KnParams knParams) {
    }

    public final void j() {
    }

    public final void c() {
        if (!this.B) {
            if (!this.x) {
                int i = 1;
                this.B = true;
                String str = null;
                for (int i2 = 0; i2 < this.d.getItemCount(); i2++) {
                    e a = this.d.a(i2);
                    if (a.a == 0) {
                        str = a.b().mTitle;
                        break;
                    }
                }
                if (com.xunlei.downloadprovider.download.b.b.c() || !d.a().d.l()) {
                    com.xunlei.downloadprovider.download.tasklist.list.feed.d.b.a().a(new WeakReference(this.D), this.z, this.b, str);
                    return;
                }
                com.xunlei.downloadprovider.download.tasklist.list.feed.d.b a2 = com.xunlei.downloadprovider.download.tasklist.list.feed.d.b.a();
                WeakReference weakReference = new WeakReference(this.D);
                com.xunlei.downloadprovider.download.tasklist.list.feed.d a3 = com.xunlei.downloadprovider.download.tasklist.list.feed.d.a();
                int i3 = this.b;
                if (a3.a.get(Integer.valueOf(i3)) != null) {
                    if (((Integer) a3.a.get(Integer.valueOf(i3))).intValue() > 0) {
                        i = ((Integer) a3.a.get(Integer.valueOf(i3))).intValue();
                    }
                }
                StringBuilder stringBuilder = new StringBuilder("getPage key:");
                stringBuilder.append(i3);
                stringBuilder.append(" result:");
                stringBuilder.append(i);
                a2.a(weakReference, i, this.b, str);
            }
        }
    }

    public final void a(int i, XLAccelBandInfo xLAccelBandInfo) {
        if (i == 0 && xLAccelBandInfo != null) {
            com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a().d = true;
        }
    }

    public static TaskListPageFragment a(int i) {
        TaskListPageFragment taskListPageFragment = new TaskListPageFragment();
        Bundle bundle = new Bundle(1);
        bundle.putInt("page_index", i);
        taskListPageFragment.setArguments(bundle);
        return taskListPageFragment;
    }

    public final void a(com.xunlei.downloadprovider.download.control.a aVar) {
        this.a = aVar;
        if (this.d != null) {
            this.d.l = aVar;
        }
    }

    public final void a(boolean z) {
        if (this.c != null && this.w) {
            this.c.setLoadingMoreEnabled(z ^ 1);
        }
        if (this.x != z) {
            this.x = z;
            if (this.d != null) {
                this.d.a(z);
            }
        }
    }

    public final void d() {
        if (this.d != null) {
            com.xunlei.downloadprovider.download.tasklist.list.a aVar = this.d;
            Iterator it = aVar.a.a.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                if (eVar.a == 0) {
                    eVar.a(true);
                }
            }
            aVar.notifyDataSetChanged();
            if (this.e != null) {
                this.e.a(this.d.f());
            }
        }
    }

    public final void e() {
        if (this.d != null) {
            com.xunlei.downloadprovider.download.tasklist.list.a aVar = this.d;
            Iterator it = aVar.a.a.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                if (eVar.a == 0) {
                    eVar.a(false);
                }
            }
            aVar.notifyDataSetChanged();
            if (this.e != null) {
                this.e.a(this.d.f());
            }
        }
    }

    public final boolean f() {
        boolean z = false;
        if (this.d == null) {
            return false;
        }
        Iterator it = this.d.a.a.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.a == 0 && !eVar.a()) {
                break;
            }
        }
        z = true;
        return z;
    }

    public final boolean g() {
        if (this.d == null) {
            return false;
        }
        com.xunlei.downloadprovider.download.tasklist.list.e eVar = this.d.a;
        if (eVar.a != null) {
            if (eVar.a.size() != 0) {
                if (eVar.a.size() != 1 || ((e) eVar.a.get(0)).a == 0) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public final boolean h() {
        return this.d != null ? this.d.b() : false;
    }

    public final void b() {
        if (this.c != null && this.d.getItemCount() > 0) {
            this.c.scrollToPosition(0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f.clear();
        this.f.add(LOAD_TAG.LOAD_TASK);
        if (getArguments() != null) {
            this.b = getArguments().getInt("page_index");
        }
        PrivateSpaceMgr.a().a(this.H);
        this.u = new e(this);
        this.r = com.xunlei.downloadprovider.download.tasklist.task.h.e().b(this.b);
        if (this.r != null) {
            this.r.a(this.u);
        }
        this.d = new com.xunlei.downloadprovider.download.tasklist.list.a(getActivity(), this.b, this);
        this.d.setHasStableIds(true);
        this.d.l = this.a;
        this.d.a(this.x);
        this.d.f = new h(this);
        this.t = new j(this);
        this.d.registerAdapterDataObserver(this.t);
        if (this.r != null) {
            bundle = this.d;
            List c = this.r.c();
            if (!c.isEmpty()) {
                for (int i = 0; i < c.size(); i++) {
                    e eVar = (e) c.get(i);
                    if (!bundle.a.a.contains(eVar)) {
                        bundle.a.a.add(eVar);
                    }
                }
                com.xunlei.downloadprovider.download.tasklist.task.b.a(bundle.a.a);
                bundle.g();
                bundle.notifyDataSetChanged();
            }
            if (this.r.e != null && this.d.d == null) {
                new StringBuilder("notifyDownloadTaskLoaded - PageIndex = ").append(this.b);
                this.d.h();
            }
            this.y = 1;
        }
        this.s = new k(this);
        if (this.a != null) {
            com.xunlei.downloadprovider.download.control.a.a(this.s);
        }
        com.xunlei.downloadprovider.discovery.kuainiao.d.a().a((com.xunlei.downloadprovider.discovery.kuainiao.d.a) this);
        com.xunlei.downloadprovider.discovery.kuainiao.d.a();
        com.xunlei.downloadprovider.discovery.kuainiao.d.e();
        this.i = new h(getActivity(), this.d);
        this.j = new c(getActivity(), this.d);
        bundle = com.xunlei.downloadprovider.ad.a.e.a();
        int i2 = this.b;
        bundle.b.put(Integer.valueOf(i2), this.d);
        this.w = f.a();
        if (this.w == null || this.b != null || this.A != null) {
            return;
        }
        if (com.xunlei.downloadprovider.download.b.b.c() == null || com.xunlei.downloadprovider.ad.downloadlist.c.a().d != null) {
            c();
        }
    }

    private void l() {
        new StringBuilder("postSyncDataSource - PageIndex = ").append(this.b);
        this.F = true;
        m();
    }

    private void m() {
        this.E.a(false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        new StringBuilder("onCreateView: pageIndex = ").append(this.b);
        layoutInflater = layoutInflater.inflate(R.layout.fragment_task_list_page, viewGroup, false);
        this.c = (XLTaskRecyclerView) layoutInflater.findViewById(R.id.taskListRecyclerView);
        this.c.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.c.getItemAnimator().setChangeDuration(0);
        this.c.addItemDecoration(new m(getContext()));
        this.c.setLoadingMoreEnabled(this.w);
        if (this.w != null) {
            this.c.setLoadingMoreEnabled(true);
            this.c.setRestCountForLoadMore(6);
        } else {
            this.c.setLoadingMoreEnabled(false);
        }
        this.c.setLoadingListener(this.C);
        this.c.setAdapter(this.d);
        viewGroup = this.d;
        viewGroup.m = this.c;
        viewGroup.m.addOnScrollListener(new com.xunlei.downloadprovider.download.tasklist.list.d(viewGroup));
        this.v = (ErrorBlankView) layoutInflater.findViewById(R.id.emptyView);
        this.y = 1;
        viewGroup = com.xunlei.downloadprovider.download.tasklist.list.feed.b.a.a();
        int i = this.b;
        RecyclerView recyclerView = this.c;
        a aVar = (a) viewGroup.b.get(Integer.valueOf(i));
        if (aVar == null) {
            aVar = new a();
            viewGroup.b.put(Integer.valueOf(i), aVar);
        }
        aVar.b = recyclerView;
        if (i == 0) {
            recyclerView.addOnScrollListener(viewGroup);
        }
        return layoutInflater;
    }

    public void onResume() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        super.onResume();
        m();
        if (this.y > 0) {
            this.y = 0;
            if (this.d != null) {
                this.d.notifyDataSetChanged();
            }
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        StringBuilder stringBuilder = new StringBuilder("onResume: pageIndex = ");
        stringBuilder.append(this.b);
        stringBuilder.append(" cost:");
        stringBuilder.append(elapsedRealtime2);
        stringBuilder.append("ms");
        if (this.b == 0) {
            LoginHelper.a();
            if (l.b()) {
                PreferenceHelper preferenceHelper = new PreferenceHelper(getActivity(), "vip_renew");
                String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                StringBuilder stringBuilder2 = new StringBuilder("dateAndUser");
                stringBuilder2.append(LoginHelper.a().g.c());
                CharSequence string = preferenceHelper.getString(stringBuilder2.toString(), "");
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(format);
                stringBuilder2.append(LoginHelper.a().g.c());
                if (TextUtils.equals(stringBuilder2.toString(), string)) {
                    this.o = false;
                } else {
                    this.o = true;
                }
            }
        }
        if (this.o && !this.p) {
            if (this.q == null) {
                this.q = com.xunlei.downloadprovider.member.b.c.a(this);
            }
            this.q.c("9");
        }
    }

    public final void a(long j, boolean z) {
        this.n = j;
        this.G = z;
        if (this.d != null && this.d.getItemCount() > 2) {
            this.m.postDelayed(new m(this), 100);
        }
    }

    public void onPause() {
        new StringBuilder("onPause: pageIndex = ").append(this.b);
        this.E.b();
        super.onPause();
    }

    public void onStop() {
        super.onStop();
        com.xunlei.downloadprovider.download.tasklist.list.feed.b.d(this.b);
    }

    public void onDestroyView() {
        new StringBuilder("onDestroyView: pageIndex = ").append(this.b);
        this.v = null;
        super.onDestroyView();
    }

    public void onDestroy() {
        new StringBuilder("onDestroy: pageIndex = ").append(this.b);
        if (!(this.t == null || this.d == null)) {
            this.d.unregisterAdapterDataObserver(this.t);
        }
        if (!(this.r == null || this.u == null)) {
            this.r.b(this.u);
        }
        if (!(this.a == null || this.s == null)) {
            com.xunlei.downloadprovider.download.control.a.b(this.s);
            this.s = null;
        }
        com.xunlei.downloadprovider.discovery.kuainiao.d.a().b((com.xunlei.downloadprovider.discovery.kuainiao.d.a) this);
        if (this.m != null) {
            this.m.removeCallbacksAndMessages(null);
        }
        PrivateSpaceMgr.a().b(this.H);
        this.D = null;
        com.xunlei.downloadprovider.download.tasklist.list.feed.d.b.a();
        com.xunlei.downloadprovider.download.tasklist.list.feed.d.b.b();
        com.xunlei.downloadprovider.download.tasklist.list.feed.b.a a = com.xunlei.downloadprovider.download.tasklist.list.feed.b.a.a();
        a.b.clear();
        a.c = null;
        com.xunlei.downloadprovider.download.tasklist.list.feed.b.a.d = null;
        super.onDestroy();
    }

    public final void a() {
        l();
        com.xunlei.downloadprovider.download.tasklist.task.h.e().d(0);
        if (this.w && !this.A) {
            this.A = true;
            c();
        }
        OnScrollListener a = com.xunlei.downloadprovider.download.tasklist.list.feed.b.a.a();
        int i = this.b;
        a.e = i;
        for (Integer intValue : a.b.keySet()) {
            a aVar = (a) a.b.get(Integer.valueOf(intValue.intValue()));
            if (!(aVar == null || aVar.b == null)) {
                aVar.b.removeOnScrollListener(a);
            }
        }
        a aVar2 = (a) a.b.get(Integer.valueOf(i));
        if (!(aVar2 == null || aVar2.b == null)) {
            aVar2.b.addOnScrollListener(a);
        }
        a.b();
        com.xunlei.downloadprovider.ad.downloadlist.c.a().a(this.b);
    }

    public static void k() {
        com.xunlei.downloadprovider.download.tasklist.list.feed.b.a.a().a(false);
    }

    public final void i() {
        if (this.q == null) {
            this.q = com.xunlei.downloadprovider.member.b.c.a(this);
        }
        com.xunlei.downloadprovider.member.b.d b = this.q.b("9");
        if (b != null && b.a()) {
            e eVar = new e(201, b, 0);
            if (this.d != null) {
                com.xunlei.downloadprovider.download.tasklist.list.a aVar = this.d;
                if (aVar.h != null) {
                    aVar.a.a.remove(aVar.h);
                }
                aVar.h = eVar;
                if (aVar.h != null) {
                    aVar.a.a.remove(aVar.h);
                    aVar.a.a.add(0, aVar.h);
                }
                aVar.notifyDataSetChanged();
                this.g = true;
            }
        }
    }

    static /* synthetic */ void a(TaskListPageFragment taskListPageFragment, List list) {
        int i = 0;
        if (!taskListPageFragment.l) {
            com.xunlei.downloadprovider.download.tasklist.list.a aVar = taskListPageFragment.d;
            e eVar = new e(303);
            if (aVar.a.b != null) {
                aVar.a.b.add(0, eVar);
                aVar.notifyDataSetChanged();
            }
            taskListPageFragment.l = true;
        }
        taskListPageFragment = taskListPageFragment.d;
        if (list != null && !list.isEmpty()) {
            while (i < list.size()) {
                e eVar2 = (e) list.get(i);
                if (!taskListPageFragment.a.b.contains(eVar2)) {
                    taskListPageFragment.a.b.add(eVar2);
                }
                i++;
            }
            taskListPageFragment.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void e(TaskListPageFragment taskListPageFragment) {
        if (taskListPageFragment.isAdded() && taskListPageFragment.d != null && taskListPageFragment.F) {
            new StringBuilder("syncTaskDataSource - PageIndex = ").append(taskListPageFragment.b);
            taskListPageFragment.F = false;
            com.xunlei.downloadprovider.download.tasklist.list.a aVar = taskListPageFragment.d;
            taskListPageFragment = taskListPageFragment.r;
            if (taskListPageFragment != null) {
                aVar.e = taskListPageFragment.a();
                taskListPageFragment = taskListPageFragment.c();
                if (aVar.a.a.isEmpty()) {
                    aVar.a.a.addAll(taskListPageFragment);
                    aVar.notifyDataSetChanged();
                    return;
                }
                taskListPageFragment = a.a(aVar.a.a, taskListPageFragment);
                aVar.a.a.clear();
                aVar.a.a.addAll(taskListPageFragment);
                aVar.g();
                aVar.notifyDataSetChanged();
            }
        }
    }

    static /* synthetic */ void m(TaskListPageFragment taskListPageFragment) {
        if (taskListPageFragment.n > 0) {
            long j = taskListPageFragment.n;
            int a = taskListPageFragment.d.a(taskListPageFragment.n);
            int i = a == taskListPageFragment.d.getItemCount() ? 1 : 0;
            if (a >= 0) {
                taskListPageFragment.n = 0;
                if (i != 0) {
                    taskListPageFragment.c.getLayoutManager().scrollToPosition(a);
                } else {
                    ((LinearLayoutManager) taskListPageFragment.c.getLayoutManager()).scrollToPositionWithOffset(a, 1);
                }
            }
            if (taskListPageFragment.G && j > 0) {
                TaskInfo c = com.xunlei.downloadprovider.download.tasklist.task.h.e().c(j);
                if (c != null) {
                    com.xunlei.downloadprovider.download.control.a.a(taskListPageFragment.getActivity(), c, "");
                }
            }
        }
    }

    static /* synthetic */ void o(TaskListPageFragment taskListPageFragment) {
        if (taskListPageFragment.b == 0 && taskListPageFragment.d != null) {
            taskListPageFragment = taskListPageFragment.d;
            if (taskListPageFragment.i == null) {
                com.xunlei.downloadprovider.download.tasklist.list.b.d dVar = new com.xunlei.downloadprovider.download.tasklist.list.b.d();
                dVar.a = com.xunlei.downloadprovider.cooperation.c.a().a(23);
                if (dVar.a != null) {
                    e eVar;
                    long b = com.xunlei.downloadprovider.h.f.b(BrothersApplication.getApplicationInstance(), "exchange_download_card_close_time", 0);
                    int d = d.a().d.d();
                    int i = 0;
                    if (b > 0 && d > 0) {
                        Calendar instance = Calendar.getInstance();
                        instance.setTimeInMillis(b * 1000);
                        instance.add(6, d);
                        instance.set(11, 0);
                        instance.set(12, 0);
                        instance.set(13, 0);
                        long timeInMillis = instance.getTimeInMillis();
                        StringBuilder stringBuilder = new StringBuilder("Next open cooperation card time:");
                        stringBuilder.append(timeInMillis / 1000);
                        stringBuilder.append(" (");
                        stringBuilder.append(b);
                        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        stringBuilder.append(d);
                        stringBuilder.append(k.t);
                        if (System.currentTimeMillis() <= timeInMillis) {
                            if (i != 0) {
                                eVar = new e(200, dVar, 0);
                                if (taskListPageFragment.a.b() >= 7) {
                                    if (taskListPageFragment.i != null) {
                                        taskListPageFragment.a.a.remove(taskListPageFragment.i);
                                    }
                                    taskListPageFragment.i = eVar;
                                    taskListPageFragment.a.a.add(6, taskListPageFragment.i);
                                    new StringBuilder("addCooperationCardItem: ").append(dVar.a.getAppName());
                                    taskListPageFragment.notifyDataSetChanged();
                                }
                            }
                        }
                    }
                    i = 1;
                    if (i != 0) {
                        eVar = new e(200, dVar, 0);
                        if (taskListPageFragment.a.b() >= 7) {
                            if (taskListPageFragment.i != null) {
                                taskListPageFragment.a.a.remove(taskListPageFragment.i);
                            }
                            taskListPageFragment.i = eVar;
                            taskListPageFragment.a.a.add(6, taskListPageFragment.i);
                            new StringBuilder("addCooperationCardItem: ").append(dVar.a.getAppName());
                            taskListPageFragment.notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ void p(TaskListPageFragment taskListPageFragment) {
        if (d.a().d.i()) {
            if (com.xunlei.downloadprovider.download.tasklist.task.h.e().b(0).b() <= 0) {
                taskListPageFragment = taskListPageFragment.d;
                if (taskListPageFragment.j == null) {
                    taskListPageFragment.j = new e(500, null, 0);
                    taskListPageFragment.a.a.remove(taskListPageFragment.j);
                    taskListPageFragment.a.a.add(0, taskListPageFragment.j);
                    taskListPageFragment.notifyDataSetChanged();
                }
                return;
            }
            taskListPageFragment = taskListPageFragment.d;
            if (taskListPageFragment.j != null) {
                taskListPageFragment.a.a.remove(taskListPageFragment.j);
                taskListPageFragment.j = null;
                taskListPageFragment.notifyDataSetChanged();
            }
        }
    }
}
