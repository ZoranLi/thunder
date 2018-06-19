package com.xunlei.downloadprovider.homepage.download;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager.LayoutParams;
import com.xunlei.common.accelerator.bean.KnParams;
import com.xunlei.common.accelerator.bean.XLAccelBandInfo;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.downloadlist.c.i;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.center.widget.DownloadStorageView;
import com.xunlei.downloadprovider.download.center.widget.ae;
import com.xunlei.downloadprovider.download.center.widget.z;
import com.xunlei.downloadprovider.download.control.DownloadListControl;
import com.xunlei.downloadprovider.download.control.q;
import com.xunlei.downloadprovider.download.engine.task.info.TaskCountsStatistics;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.engine.task.w;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;
import com.xunlei.downloadprovider.download.tasklist.TaskListPageFragment;
import com.xunlei.downloadprovider.download.tasklist.l;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager;
import com.xunlei.downloadprovider.download.tasklist.task.h;
import com.xunlei.downloadprovider.frame.BasePageFragment;
import com.xunlei.downloadprovider.homepage.download.DownloadBriefInfoView.StatusInfo;
import com.xunlei.downloadprovider.homepage.download.DownloadBriefInfoView.StatusInfo.TasksStatus;
import com.xunlei.downloadprovider.homepage.download.a.f;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DownloadTabFragment extends BasePageFragment implements com.xunlei.downloadprovider.discovery.kuainiao.d.a, com.xunlei.downloadprovider.download.tasklist.TaskListPageFragment.a, g {
    boolean a = false;
    final com.xunlei.downloadprovider.download.control.a b = new com.xunlei.downloadprovider.download.control.a();
    d c = new d();
    private c d = new c();
    private DownloadBriefInfoView e;
    private DownloadStorageView f;
    private boolean g;
    private com.xunlei.downloadprovider.homepage.download.a.a h;
    private f i;
    private ae j;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private long n = -1;
    private LocalBroadcastManager o = LocalBroadcastManager.getInstance(BrothersApplication.getApplicationInstance());
    private Handler p = new Handler();
    private final int q = 1000;
    private Runnable r = new h(this);
    private DownloadListControl s;
    private a t = new a();
    private com.xunlei.downloadprovider.member.login.b.d u = new y(this);
    private b v = new b();
    private BroadcastReceiver w = new r(this);

    private class a extends BroadcastReceiver {
        final /* synthetic */ DownloadTabFragment a;

        private a(DownloadTabFragment downloadTabFragment) {
            this.a = downloadTabFragment;
        }

        public final void onReceive(Context context, Intent intent) {
            context = intent.getAction();
            if (context != null && "com.xunlei.downloadprovider.homepage.download.DownloadTabFragment".equals(context) != null) {
                this.a.e.a();
            }
        }
    }

    private static class c {
        TaskListPageFragment a;

        private c() {
        }

        final void a(long j) {
            if (this.a != null) {
                TaskListPageFragment taskListPageFragment = this.a;
                taskListPageFragment.n = j;
                if (taskListPageFragment.d != null && taskListPageFragment.d.getItemCount() > 2) {
                    taskListPageFragment.m.postDelayed(new l(taskListPageFragment), 100);
                }
            }
        }

        final void a(boolean z) {
            if (this.a != null) {
                this.a.a(z);
            }
        }

        final List<e> a() {
            return this.a != null ? this.a.d.f() : Collections.emptyList();
        }
    }

    private class b extends com.xunlei.downloadprovider.broadcast.b {
        final /* synthetic */ DownloadTabFragment a;

        private b(DownloadTabFragment downloadTabFragment) {
            this.a = downloadTabFragment;
        }

        public final void a(Context context, Intent intent) {
            this.a.a(context);
        }

        public final void c(Context context, Intent intent) {
            PrivateSpaceMgr.a().c();
        }
    }

    private class d implements q, w, com.xunlei.downloadprovider.download.tasklist.task.q {
        int a;
        final /* synthetic */ DownloadTabFragment b;

        public final void b(Collection<Long> collection) {
        }

        private d(DownloadTabFragment downloadTabFragment) {
            this.b = downloadTabFragment;
            this.a = null;
        }

        public final void a() {
            this.b.a = true;
        }

        public final void a(List<TaskInfo> list) {
            h.e().k();
            this.b.a(new ab(this), 1000);
        }

        public final void b(List<TaskInfo> list) {
            h.e().k();
            this.b.a(new ac(this), 2000);
        }

        public final void c(List<TaskInfo> list) {
            h.e().k();
            this.b.a(new ad(this), 1000);
        }

        public final void a(long j) {
            this.a++;
            this.b.a(new ae(this), 1000);
        }

        public final void a(Collection<Long> collection) {
            h.e().a((Collection) collection);
            h.e().k();
        }
    }

    public final void a(String str, int i, KnParams knParams) {
    }

    protected String getTabId() {
        return "download";
    }

    private void c() {
        if (this.p != null) {
            this.p.removeCallbacks(this.r);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return createView(layoutInflater, viewGroup, bundle);
    }

    protected View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(R.layout.fragment_homepage_downloadtab, viewGroup, false);
        this.e = (DownloadBriefInfoView) layoutInflater.findViewById(R.id.download_tab_brief_info);
        this.f = (DownloadStorageView) layoutInflater.findViewById(R.id.storageView);
        this.e.setRightImageView2ClickListener(new u(this));
        this.e.setActionListener(new v(this));
        viewGroup = this.e;
        LoginHelper.a();
        bundle = com.xunlei.downloadprovider.member.login.b.l.b();
        boolean l = LoginHelper.a().l();
        viewGroup.getStatusInfo().a = bundle;
        viewGroup.getStatusInfo().b = l;
        this.h = new com.xunlei.downloadprovider.homepage.download.a.a((ViewStub) layoutInflater.findViewById(R.id.download_tab_edit_title_bar));
        this.h.d = new w(this);
        this.i = new f((ViewStub) layoutInflater.findViewById(R.id.download_tab_edit_tool_bar));
        this.i.e = new x(this);
        return layoutInflater;
    }

    public void onMainTabClick(boolean z) {
        super.onMainTabClick(z);
        if (!z) {
            z = this.d;
            if (z.a != null) {
                z.a.b();
            }
        }
    }

    public void onPageSelected() {
        super.onPageSelected();
        c cVar = this.d;
        if (cVar.a != null) {
            TaskListPageFragment taskListPageFragment = cVar.a;
            com.xunlei.downloadprovider.download.tasklist.list.feed.b.a.a().a(true);
            taskListPageFragment.a();
        }
        this.p.postDelayed(new t(this), 1000);
        d();
        com.xunlei.downloadprovider.ad.downloadlist.c.a().a(0);
    }

    public void onPageOff() {
        super.onPageOff();
        if (this.d.a != null) {
            TaskListPageFragment.k();
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.b.a = activity;
    }

    public void onDetach() {
        super.onDetach();
        this.b.a = null;
        e();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.xunlei.downloadprovider.download.control.a.a(this.c);
        h.e().a(0);
        h.e().a(this.c);
        h.e().k();
        bundle = new IntentFilter();
        bundle.addAction("ACTION_EXIT_PLAYER");
        this.o.registerReceiver(this.w, bundle);
        if (!(getActivity() == null || getActivity().getIntent() == null || getActivity().getIntent().getExtras() == null)) {
            bundle = getActivity().getIntent().getExtras().getBundle("download_tab_arguments");
            if (bundle != null) {
                long j = bundle.getLong(com.umeng.message.proguard.l.m);
                bundle = bundle.getString("gcid");
                if (j >= 0) {
                    this.n = j;
                } else if (!TextUtils.isEmpty(bundle)) {
                    n.a();
                    this.n = n.f(bundle);
                }
            }
        }
        com.xunlei.downloadprovider.ad.downloadlist.c.a().a(0);
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        try {
            this.s = (DownloadListControl) getChildFragmentManager().findFragmentByTag("HomeDownloadListControl");
        } catch (View view2) {
            view2.printStackTrace();
        }
        if (this.s == null) {
            this.s = DownloadListControl.a("HomeDownloadListControl");
            getChildFragmentManager().beginTransaction().add(this.s, "HomeDownloadListControl").commit();
        }
        this.b.e = this.s;
        view2 = this.d;
        if (view2.a == null) {
            view2.a = TaskListPageFragment.a(0);
        }
        view2.a.a(this.b);
        view2.a.e = this;
        getChildFragmentManager().beginTransaction().replace(R.id.fragmentTaskListPage, view2.a).commit();
        if (this.n > -1) {
            this.d.a(this.n);
            this.n = -1;
        }
        com.xunlei.downloadprovider.broadcast.a.a().a(this.v);
        com.xunlei.downloadprovider.discovery.kuainiao.d.a().a((com.xunlei.downloadprovider.discovery.kuainiao.d.a) this);
        com.xunlei.downloadprovider.discovery.kuainiao.d.a();
        com.xunlei.downloadprovider.discovery.kuainiao.d.e();
        if (this.k == null) {
            a(new s(this), 1000);
        }
        com.xunlei.downloadprovider.web.website.g.b.a().b();
        LoginHelper.a().a(this.u);
        if (this.d.a != null) {
            this.d.a.p = false;
        }
        d();
        if (this.m == null && getContext() != null) {
            this.m = true;
            view2 = new IntentFilter();
            view2.addAction("com.xunlei.downloadprovider.homepage.download.DownloadTabFragment");
            LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.t, view2);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.p != null) {
            this.p.removeCallbacks(this.r);
            this.p.postDelayed(this.r, 1000);
        }
        h.e().a(0);
        h.e().i();
        a();
        a(getActivity());
    }

    public void onStart() {
        super.onStart();
    }

    public void onDestroyView() {
        super.onDestroyView();
        c();
        e();
        PrivateSpaceMgr.a().c();
        this.d.a.p = false;
        LoginHelper.a().b(this.u);
        if (getContext() != null) {
            LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.t);
            this.m = false;
        }
        com.xunlei.downloadprovider.download.tasklist.list.banner.c.f.a().d();
        com.xunlei.downloadprovider.download.tasklist.list.banner.d.f.a();
    }

    public void onDestroy() {
        super.onDestroy();
        c();
        com.xunlei.downloadprovider.download.control.a.b(this.c);
        h.e().j();
        if (this.p != null) {
            this.p.removeCallbacksAndMessages(null);
        }
        c cVar = this.d;
        if (cVar.a != null) {
            cVar.a.e = null;
            cVar.a.a(null);
        }
        e();
        this.o.unregisterReceiver(this.w);
        com.xunlei.downloadprovider.discovery.kuainiao.d.a().b((com.xunlei.downloadprovider.discovery.kuainiao.d.a) this);
        BannerManager.a().b();
        LoginHelper.a().b(this);
        if (com.xunlei.downloadprovider.ad.a.h.a()) {
            com.xunlei.downloadprovider.ad.recommend.a.h.b();
            com.xunlei.downloadprovider.ad.downloadlist.b.a.a();
            com.xunlei.downloadprovider.ad.downloadlist.b.a.j = null;
            com.xunlei.downloadprovider.ad.downloadlist.c.a();
            com.xunlei.downloadprovider.ad.downloadlist.c.a = null;
            com.xunlei.downloadprovider.ad.a.a.a();
            com.xunlei.downloadprovider.ad.a.a.a = null;
            com.xunlei.downloadprovider.ad.b.a.a();
            com.xunlei.downloadprovider.ad.b.a.d = null;
            com.xunlei.downloadprovider.ad.downloadlist.d.a();
            com.xunlei.downloadprovider.ad.downloadlist.d.b();
            com.xunlei.downloadprovider.ad.downloadlist.c.g.a();
            com.xunlei.downloadprovider.ad.downloadlist.c.g.c = null;
        }
        com.xunlei.downloadprovider.ad.downloadlist.c.a();
        com.xunlei.downloadprovider.ad.downloadlist.c.a = null;
        com.xunlei.downloadprovider.download.tasklist.list.feed.b.a();
        com.xunlei.downloadprovider.download.tasklist.list.feed.a.a();
        com.xunlei.downloadprovider.download.tasklist.list.feed.a.b();
    }

    public void onPause() {
        super.onPause();
    }

    public void onUserVisible(boolean z) {
        super.onUserVisible(z);
        z = this.d;
        if (z.a != null) {
            z = z.a;
            z.i.a(true);
            z.j.a(true);
            com.xunlei.downloadprovider.ad.downloadlist.c.g a = com.xunlei.downloadprovider.ad.downloadlist.c.g.a();
            if (com.xunlei.downloadprovider.ad.a.h.a()) {
                a.d = true;
                Collection arrayList = new ArrayList();
                Iterator it = a.b.iterator();
                while (it.hasNext()) {
                    i iVar = (i) it.next();
                    if (a.d) {
                        iVar.c();
                        arrayList.add(iVar);
                    }
                }
                if (arrayList.size() != 0) {
                    a.b.removeAll(arrayList);
                }
            }
            com.xunlei.downloadprovider.ad.downloadlist.c.a().a(z.b);
        }
        com.xunlei.downloadprovider.personal.lixianspace.business.c.a.a().b();
    }

    public void onUserInvisible(boolean z) {
        super.onUserInvisible(z);
        z = this.d;
        if (z.a != null) {
            z = z.a;
            z.i.a(false);
            if (z.k) {
                z.j.a(false);
            } else {
                z.k = true;
            }
            z = com.xunlei.downloadprovider.ad.downloadlist.c.g.a();
            if (com.xunlei.downloadprovider.ad.a.h.a()) {
                z.d = false;
            }
        }
    }

    public void onNewExtras(android.os.Bundle r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        super.onNewExtras(r10);
        if (r10 == 0) goto L_0x00f3;
    L_0x0005:
        r0 = "home_sub_tab_has_switch_tab";
        r0 = r10.getBoolean(r0);
        r1 = "download_tab_arguments";
        r10 = r10.getBundle(r1);
        if (r10 == 0) goto L_0x00f3;
    L_0x0013:
        r1 = "from";
        r1 = r10.getString(r1);
        r2 = "TaskId";
        r2 = r10.getLong(r2);
        r4 = "gcid";
        r4 = r10.getString(r4);
        r5 = "extra_key_should_open_detailpage";
        r5 = r10.getBoolean(r5);
        r6 = new java.lang.StringBuilder;
        r7 = "handleIntentArguments: hasSwitchTab = ";
        r6.<init>(r7);
        r6.append(r0);
        r7 = " from = ";
        r6.append(r7);
        r6.append(r1);
        r7 = ", taskId = ";
        r6.append(r7);
        r6.append(r2);
        r6 = 0;
        r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r8 < 0) goto L_0x0051;
    L_0x004b:
        r4 = r9.d;
        r4.a(r2);
        goto L_0x0063;
    L_0x0051:
        r8 = android.text.TextUtils.isEmpty(r4);
        if (r8 != 0) goto L_0x0063;
    L_0x0057:
        com.xunlei.downloadprovider.download.engine.task.n.a();
        r2 = com.xunlei.downloadprovider.download.engine.task.n.f(r4);
        r4 = r9.d;
        r4.a(r2);
    L_0x0063:
        if (r5 == 0) goto L_0x0085;
    L_0x0065:
        r4 = new java.lang.StringBuilder;
        r5 = "handleOpenDetailPage: from = ";
        r4.<init>(r5);
        r4.append(r1);
        r5 = ", taskId = ";
        r4.append(r5);
        r4.append(r2);
        r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x0085;
    L_0x007b:
        com.xunlei.downloadprovider.download.a.a();
        r4 = r9.getActivity();
        com.xunlei.downloadprovider.download.a.b(r4, r2, r1);
    L_0x0085:
        r2 = "extra_key_vodplay_taskinfo";
        r2 = r10.getSerializable(r2);
        r2 = (com.xunlei.downloadprovider.download.engine.task.info.TaskInfo) r2;
        r3 = "extra_key_vodplay_from";
        r10.getString(r3);
        if (r2 == 0) goto L_0x00a7;
    L_0x0094:
        r3 = r2.getTaskId();
        r10 = -1;
        r5 = 0;
        com.xunlei.downloadprovider.download.player.a.m.a(r3, r10, r5);
        r10 = r9.getActivity();
        r3 = 0;
        r4 = "download_list";
        com.xunlei.downloadprovider.vodnew.VodPlayerActivityNew.a(r10, r2, r3, r4);
    L_0x00a7:
        r10 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x00ce }
        if (r10 != 0) goto L_0x00bd;	 Catch:{ Exception -> 0x00ce }
    L_0x00ad:
        r10 = "_noti";	 Catch:{ Exception -> 0x00ce }
        r10 = r1.endsWith(r10);	 Catch:{ Exception -> 0x00ce }
        if (r10 == 0) goto L_0x00bd;	 Catch:{ Exception -> 0x00ce }
    L_0x00b5:
        r10 = com.xunlei.downloadprovider.download.report.DLCenterEntry.download_push;	 Catch:{ Exception -> 0x00ce }
        r10 = r10.toString();	 Catch:{ Exception -> 0x00ce }
    L_0x00bb:
        r1 = r10;	 Catch:{ Exception -> 0x00ce }
        goto L_0x00ce;	 Catch:{ Exception -> 0x00ce }
    L_0x00bd:
        r10 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x00ce }
        if (r10 != 0) goto L_0x00ce;	 Catch:{ Exception -> 0x00ce }
    L_0x00c3:
        r10 = com.xunlei.downloadprovider.download.report.DLCenterEntry.enumValueOf(r1);	 Catch:{ Exception -> 0x00ce }
        if (r10 == 0) goto L_0x00ce;	 Catch:{ Exception -> 0x00ce }
    L_0x00c9:
        r10 = r10.toString();	 Catch:{ Exception -> 0x00ce }
        goto L_0x00bb;
    L_0x00ce:
        r10 = "";
        r2 = "";
        r3 = r9.getActivity();
        r3 = r3 instanceof com.xunlei.downloadprovider.download.create.ThunderTaskActivity;
        if (r3 == 0) goto L_0x00f0;
    L_0x00da:
        r3 = r9.getActivity();
        r3 = (com.xunlei.downloadprovider.download.create.ThunderTaskActivity) r3;
        r3 = r3.f;
        if (r3 == 0) goto L_0x00f0;
    L_0x00e4:
        r10 = "app_id";
        r2 = r3.getString(r10);
        r10 = "partner_id";
        r10 = r3.getString(r10);
    L_0x00f0:
        com.xunlei.downloadprovider.download.report.a.a(r1, r10, r2, r0);
    L_0x00f3:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.download.DownloadTabFragment.onNewExtras(android.os.Bundle):void");
    }

    public void onStop() {
        super.onStop();
    }

    private void d() {
        if (this.f != null) {
            this.f.a();
        }
    }

    public final void a(boolean z) {
        this.g = z;
        boolean z2 = z ^ 1;
        if (this.f != null) {
            this.f.setClickable(z2);
        }
        if (z) {
            LocalBroadcastManager.getInstance(getContext()).sendBroadcast(new Intent("action_enter_full_screen_mode"));
            if (this.h) {
                z = this.h;
                z.a(0);
                z.c.setText(z.b.getResources().getString(R.string.download_list_select_title));
                z.a(true);
            }
            if (this.i) {
                this.i.a(0);
            }
            if (this.e) {
                this.e.setVisibility(8);
            }
            this.d.a(true);
            com.xunlei.downloadprovider.download.tasklist.list.feed.b.a.a().a(false);
            return;
        }
        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(new Intent("action_exit_full_screen_mode"));
        if (this.h) {
            this.h.a(8);
        }
        if (this.i) {
            this.i.a(8);
        }
        if (this.e) {
            this.e.setVisibility(0);
        }
        this.d.a(false);
        com.xunlei.downloadprovider.download.tasklist.list.feed.b.a.a().a(true);
    }

    public final void a(List<e> list) {
        int i = 0;
        if (list == null || list.size() <= 0) {
            this.h.a();
            this.i.a(false);
        } else {
            list = getActivity().getResources().getString(R.string.download_list_selected_file, new Object[]{String.valueOf(list.size())});
            com.xunlei.downloadprovider.homepage.download.a.a aVar = this.h;
            if (aVar.c != null) {
                aVar.c.setText(list);
            }
            this.i.a(true);
        }
        list = this.h;
        c cVar = this.d;
        if (cVar.a != null && cVar.a.f()) {
            i = 1;
        }
        list.a(i ^ true);
    }

    public final void a(int i) {
        i = this.d;
        i = (i.a == null || i.a.g() == 0) ? 0 : 1;
        if (i == 0) {
            this.f.setVisibility(0);
        }
    }

    public final void a(int i, XLAccelBandInfo xLAccelBandInfo) {
        if (i == 0 && xLAccelBandInfo != null) {
            this.l = true;
        }
    }

    public void onLogout() {
        a(new j(this), 0);
    }

    public final void a(Runnable runnable, long j) {
        this.p.postDelayed(runnable, j);
    }

    final void a() {
        h.e();
        TaskCountsStatistics c = h.c();
        if (this.e != null) {
            if (c.mRunningCount > 0) {
                this.e.getStatusInfo().n = null;
                long b = h.e().b();
                this.e.setDownloadSpeed(b);
                com.xunlei.downloadprovider.b.a.a(getActivity(), b);
                DownloadBriefInfoView downloadBriefInfoView = this.e;
                LoginHelper.a();
                downloadBriefInfoView.a(com.xunlei.downloadprovider.member.login.b.l.b(), LoginHelper.a().l());
                b();
            } else {
                if (c.mTotalCount <= c.mSuccessCount || (c.getFailedCount() + c.getPausedCount()) + c.getRunningCount() <= 0 || c.mUnfinishedNoCopyRightProblemCount != 0) {
                    if (c.mPausedCount <= 0) {
                        if (c.mFailedCount <= 0) {
                            if (c.mSuccessCount > 0) {
                                this.e.getStatusInfo().n = TasksStatus.TasksFinished;
                            } else {
                                this.e.getStatusInfo().n = TasksStatus.NoTasks;
                            }
                        }
                    }
                    this.e.getStatusInfo().n = TasksStatus.TasksPaused;
                    if (c.mPausedCount <= 0) {
                        this.e.getStatusInfo().n = TasksStatus.TasksFailed;
                    }
                } else {
                    this.e.getStatusInfo().n = TasksStatus.TasksCopyRightProblem;
                }
                this.e.b();
            }
        }
        this.a = false;
    }

    final void b() {
        if (this.e != null) {
            StatusInfo statusInfo = this.e.getStatusInfo();
            if (statusInfo != null) {
                TasksStatus tasksStatus;
                boolean f = h.e().f();
                boolean h = h.e().h();
                boolean z = false;
                boolean z2 = h.e().g() && this.l;
                if (statusInfo.f != f) {
                    statusInfo.f = f;
                    f = true;
                } else {
                    f = false;
                }
                if (this.l) {
                    statusInfo.h = this.l;
                }
                if (statusInfo.g != z2) {
                    statusInfo.g = z2;
                    f = true;
                }
                h.e();
                TaskCountsStatistics c = h.c();
                if (c.mRunningCount > 0) {
                    tasksStatus = null;
                } else if (c.mTotalCount <= c.mSuccessCount || (c.getFailedCount() + c.getPausedCount()) + c.getRunningCount() <= 0 || c.mUnfinishedNoCopyRightProblemCount != 0) {
                    if (c.mPausedCount <= 0) {
                        if (c.mFailedCount <= 0) {
                            if (c.mSuccessCount > 0) {
                                tasksStatus = TasksStatus.TasksFinished;
                            } else {
                                tasksStatus = TasksStatus.NoTasks;
                            }
                        }
                    }
                    TasksStatus tasksStatus2 = TasksStatus.TasksPaused;
                    if (c.mPausedCount <= 0) {
                        tasksStatus = TasksStatus.TasksFailed;
                    } else {
                        tasksStatus = tasksStatus2;
                    }
                } else {
                    tasksStatus = TasksStatus.TasksCopyRightProblem;
                }
                if (statusInfo.n != tasksStatus) {
                    statusInfo.n = tasksStatus;
                    f = true;
                }
                if (statusInfo.j != h) {
                    statusInfo.j = h;
                    f = true;
                }
                LoginHelper.a();
                h = com.xunlei.downloadprovider.member.login.b.l.b();
                z2 = h && LoginHelper.a().l();
                boolean z3 = h && ((LoginHelper.a().r() || LoginHelper.a().s()) && z2 && !LoginHelper.a().g.g());
                boolean z4 = h && LoginHelper.a().t();
                if (h && LoginHelper.a().s()) {
                    z = true;
                }
                if (statusInfo.a != h) {
                    statusInfo.a = h;
                    f = true;
                }
                if (statusInfo.b != z2) {
                    statusInfo.b = z2;
                    f = true;
                }
                if (statusInfo.e != z3) {
                    statusInfo.e = z3;
                    f = true;
                }
                if (statusInfo.c != z4) {
                    statusInfo.c = z4;
                    f = true;
                }
                if (statusInfo.d != z) {
                    statusInfo.d = z;
                    f = true;
                }
                if (f) {
                    this.e.b();
                }
            }
        }
    }

    private void a(Context context) {
        if (this.e != null) {
            if (isAdded()) {
                StatusInfo statusInfo = this.e.getStatusInfo();
                if (com.xunlei.xllib.android.b.a(context)) {
                    statusInfo.a(true, com.xunlei.xllib.android.b.d(context));
                    statusInfo.m = com.xunlei.xllib.android.b.c(context);
                } else {
                    statusInfo.a(false, false);
                    statusInfo.m = null;
                }
                this.e.b();
            }
        }
    }

    public boolean onBackPressed() {
        if (!this.g) {
            return super.onBackPressed();
        }
        a(false);
        return true;
    }

    private void e() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.getActivity();
        if (r0 == 0) goto L_0x0010;
    L_0x0006:
        r0 = com.xunlei.downloadprovider.broadcast.a.a();	 Catch:{ Exception -> 0x0010 }
        r1 = r2.v;	 Catch:{ Exception -> 0x0010 }
        r0.b(r1);	 Catch:{ Exception -> 0x0010 }
        return;
    L_0x0010:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.download.DownloadTabFragment.e():void");
    }

    static /* synthetic */ void e(DownloadTabFragment downloadTabFragment) {
        c cVar = downloadTabFragment.d;
        boolean z = cVar.a != null && cVar.a.h();
        if (downloadTabFragment.j != null) {
            if (downloadTabFragment.j.isShowing()) {
                downloadTabFragment.j.dismiss();
            }
            downloadTabFragment.j = null;
        }
        downloadTabFragment.j = new ae(downloadTabFragment.getActivity());
        downloadTabFragment.j.a(downloadTabFragment.e.getRightImageView2(), -DipPixelUtil.dip2px(99.0f), DipPixelUtil.dip2px(-12.0f));
        downloadTabFragment.j.f.setOnClickListener(new k(downloadTabFragment));
        downloadTabFragment.j.e.setOnClickListener(new l(downloadTabFragment));
        downloadTabFragment.j.c.setOnClickListener(new m(downloadTabFragment));
        downloadTabFragment.j.d.setOnClickListener(new n(downloadTabFragment));
        downloadTabFragment.j.a.setOnClickListener(new o(downloadTabFragment));
        downloadTabFragment.j.b.setOnClickListener(new p(downloadTabFragment));
        downloadTabFragment.j.setOnDismissListener(new q(downloadTabFragment));
        LayoutParams attributes = downloadTabFragment.getActivity().getWindow().getAttributes();
        attributes.alpha = 0.6f;
        downloadTabFragment.getActivity().getWindow().setAttributes(attributes);
        ae aeVar = downloadTabFragment.j;
        aeVar.f.setEnabled(z);
        if (z) {
            aeVar.f.setVisibility(0);
            aeVar.g.setVisibility(8);
        } else {
            aeVar.g.setVisibility(0);
            aeVar.f.setVisibility(8);
        }
        downloadTabFragment.j.a();
    }

    static /* synthetic */ void a(DownloadTabFragment downloadTabFragment, boolean z) {
        if (z) {
            downloadTabFragment = downloadTabFragment.d;
            if (downloadTabFragment.a) {
                downloadTabFragment.a.d();
            }
            return;
        }
        z = downloadTabFragment.d;
        if (z.a != null) {
            z.a.e();
        }
        downloadTabFragment.h.a();
    }

    static /* synthetic */ void f(DownloadTabFragment downloadTabFragment) {
        List<e> a = downloadTabFragment.d.a();
        List arrayList = new ArrayList();
        if (a.size() != 0) {
            Object obj = null;
            long j = 0;
            for (e eVar : a) {
                if (eVar.b() != null) {
                    long j2;
                    if (eVar.b().mIsFileMissing || eVar.b().mDownloadedSize == 0) {
                        if (!eVar.b().mIsFileMissing) {
                            if (j != 0) {
                                j2 = j;
                            }
                        }
                        j2 = j + 1;
                    } else {
                        j2 = j + eVar.b().mDownloadedSize;
                    }
                    if (eVar.b().getTaskStatus() == 8) {
                        arrayList.add(eVar);
                        if (obj == null) {
                            obj = 1;
                        }
                    }
                    j = j2;
                }
            }
            z zVar = new z(downloadTabFragment.getActivity(), arrayList.size(), a.size() - arrayList.size(), j);
            if (obj == null) {
                zVar.setCheckStr(null);
            }
            zVar.setBtnLeftClickListener(new aa(downloadTabFragment, com.xunlei.downloadprovider.download.report.a.a(a), zVar));
            zVar.setBtnRightClickListener(new i(downloadTabFragment, arrayList, zVar));
            zVar.show();
        }
    }

    static /* synthetic */ void l(DownloadTabFragment downloadTabFragment) {
        if (downloadTabFragment.j != null) {
            downloadTabFragment.j.dismiss();
        }
    }
}
