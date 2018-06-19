package com.xunlei.downloadprovider.download.center;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xunlei.common.accelerator.bean.KnParams;
import com.xunlei.common.accelerator.bean.XLAccelBandInfo;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.download.center.widget.DownloadBriefInfoHeaderView;
import com.xunlei.downloadprovider.download.center.widget.DownloadBriefInfoHeaderView.StatusInfo;
import com.xunlei.downloadprovider.download.center.widget.DownloadBriefInfoHeaderView.StatusInfo.TasksStatus;
import com.xunlei.downloadprovider.download.center.widget.DownloadCenterBottomView;
import com.xunlei.downloadprovider.download.center.widget.DownloadCenterSelectFileTitleView;
import com.xunlei.downloadprovider.download.center.widget.DownloadCenterTabLayout;
import com.xunlei.downloadprovider.download.center.widget.DownloadCenterViewPager;
import com.xunlei.downloadprovider.download.center.widget.DownloadStorageView;
import com.xunlei.downloadprovider.download.center.widget.DownloadTitleBarView;
import com.xunlei.downloadprovider.download.center.widget.j;
import com.xunlei.downloadprovider.download.center.widget.p;
import com.xunlei.downloadprovider.download.control.q;
import com.xunlei.downloadprovider.download.engine.task.info.TaskCountsStatistics;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;
import com.xunlei.downloadprovider.download.tasklist.TaskListPageFragment;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager;
import com.xunlei.downloadprovider.download.tasklist.list.banner.c.f;
import com.xunlei.downloadprovider.download.tasklist.task.h;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.d;
import com.xunlei.downloadprovider.member.login.b.g;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.web.website.fragment.CollectionAndHistoryFragment;
import com.xunlei.downloadprovider.web.website.view.CollectionUserSyncTipBottomView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DownloadCenterActivityFragment extends Fragment implements OnOffsetChangedListener, com.xunlei.downloadprovider.discovery.kuainiao.d.a, com.xunlei.downloadprovider.download.tasklist.TaskListPageFragment.a, d, g {
    static final String a = "DownloadCenterActivityFragment";
    private static boolean y = false;
    private final int A = 1000;
    private Runnable B = new b(this);
    private boolean C;
    private boolean D;
    private boolean E = false;
    private int F;
    private a G = new a();
    private com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr.a H = new w(this);
    private d I = new x(this);
    DownloadTitleBarView b;
    boolean c;
    final com.xunlei.downloadprovider.download.control.a d = new com.xunlei.downloadprovider.download.control.a();
    private DownloadCenterSelectFileTitleView e;
    private DownloadCenterBottomView f;
    private CollectionUserSyncTipBottomView g;
    private j h;
    private p i;
    private AppBarLayout j;
    private CoordinatorLayout k;
    private DownloadCenterTabLayout l;
    private DownloadCenterViewPager m;
    private c n;
    private final b o = new b();
    private DownloadStorageView p;
    private boolean q = false;
    private boolean r = false;
    private DownloadBriefInfoHeaderView s;
    private Handler t = new Handler();
    private FrameLayout u;
    private FrameLayout v;
    private Behavior w;
    private int x = 0;
    private CooperationItem z;

    private class a extends com.xunlei.downloadprovider.broadcast.b {
        final /* synthetic */ DownloadCenterActivityFragment a;

        private a(DownloadCenterActivityFragment downloadCenterActivityFragment) {
            this.a = downloadCenterActivityFragment;
        }

        public final void a(Context context, Intent intent) {
            this.a.a(context);
        }

        public final void c(Context context, Intent intent) {
            PrivateSpaceMgr.a().c();
        }
    }

    private class b implements q, com.xunlei.downloadprovider.download.tasklist.task.q {
        int a;
        final /* synthetic */ DownloadCenterActivityFragment b;

        public final void a(long j) {
        }

        private b(DownloadCenterActivityFragment downloadCenterActivityFragment) {
            this.b = downloadCenterActivityFragment;
            this.a = null;
        }

        public final void a() {
            String str = DownloadCenterActivityFragment.a;
            this.b.q = true;
        }

        public final void a(Collection<Long> collection) {
            h.e().a((Collection) collection);
            h.e().k();
        }

        public final void b(Collection<Long> collection) {
            collection = DownloadCenterActivityFragment.a;
            this.a++;
            this.b.a(new ag(this), 1000);
        }

        public final void a(List<TaskInfo> list) {
            h.e().k();
            this.b.a(new ah(this), 1000);
        }

        public final void b(List<TaskInfo> list) {
            list = DownloadCenterActivityFragment.a;
            h.e().k();
            this.b.a(new ai(this), 2000);
        }

        public final void c(List<TaskInfo> list) {
            h.e().k();
            this.b.a(new aj(this), 1000);
        }
    }

    private class c extends FragmentPagerAdapter {
        protected TaskListPageFragment a;
        protected TaskListPageFragment b;
        protected TaskListPageFragment c;
        protected CollectionAndHistoryFragment d;
        protected final int e = 4;
        protected long f;
        protected boolean g = null;
        final /* synthetic */ DownloadCenterActivityFragment h;
        private boolean i;

        public final /* synthetic */ Fragment getItem(int i) {
            return a(i);
        }

        public c(DownloadCenterActivityFragment downloadCenterActivityFragment, FragmentManager fragmentManager) {
            this.h = downloadCenterActivityFragment;
            super(fragmentManager);
        }

        public final void a(long j, boolean z) {
            this.f = j;
            this.g = z;
            if (this.a != null) {
                this.a.a(this.f, this.g);
                this.f = -1;
                this.g = 0;
            }
        }

        public final DownloadCenterTabBaseFragment a() {
            return a(this.h.m.getCurrentItem());
        }

        public final List<e> b() {
            List<e> arrayList = new ArrayList();
            if (this.h.m.getCurrentItem() < 3) {
                arrayList.addAll(((TaskListPageFragment) a(this.h.m.getCurrentItem())).d.f());
            }
            return arrayList;
        }

        public final boolean c() {
            return this.h.m.getCurrentItem() < 3 ? ((TaskListPageFragment) a(this.h.m.getCurrentItem())).g() : false;
        }

        public final void a(boolean z) {
            if (this.i != z) {
                this.i = z;
                if (this.a != null) {
                    this.a.a(z);
                }
                if (this.b != null) {
                    this.b.a(z);
                }
                if (this.c != null) {
                    this.c.a(z);
                }
            }
        }

        public final DownloadCenterTabBaseFragment a(int i) {
            if (i == 0) {
                if (this.a == 0) {
                    this.a = TaskListPageFragment.a(0);
                    this.a.e = this.h;
                    this.a.a(this.h.d);
                    this.a.a(this.f, this.g);
                    this.a.a(this.i);
                }
                return this.a;
            } else if (i == 1) {
                if (this.b == 0) {
                    this.b = TaskListPageFragment.a(1);
                    this.b.e = this.h;
                    this.b.a(this.h.d);
                    this.b.a(this.i);
                }
                return this.b;
            } else if (i == 2) {
                if (this.c == 0) {
                    this.c = TaskListPageFragment.a(2);
                    this.c.e = this.h;
                    this.c.a(this.h.d);
                    this.c.a(this.i);
                }
                return this.c;
            } else if (i != 3) {
                return 0;
            } else {
                if (this.d == 0) {
                    this.d = CollectionAndHistoryFragment.a(1002);
                }
                return this.d;
            }
        }

        public final int getCount() {
            return this.e;
        }

        public final CharSequence getPageTitle(int i) {
            if (i == 0) {
                return this.h.getString(R.string.download_list_title_all);
            }
            if (i == 1) {
                return this.h.getString(R.string.download_list_title_unfinished);
            }
            if (i == 2) {
                return this.h.getString(R.string.download_list_title_finished);
            }
            if (i == 3) {
                return this.h.getString(R.string.download_list_title_collection);
            }
            return super.getPageTitle(i);
        }
    }

    public final void a(String str, int i, KnParams knParams) {
    }

    public final void a(Runnable runnable, long j) {
        this.t.postDelayed(runnable, j);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d.a = getActivity();
        com.xunlei.downloadprovider.download.control.a.a(this.o);
        h.e().a(0);
        h.e().a(this.o);
        h.e().k();
        c(0);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(R.layout.fragment_download_center, viewGroup, false);
        this.b = (DownloadTitleBarView) layoutInflater.findViewById(R.id.download_center_title);
        this.b.setLeftImageViewClickListener(new ad(this));
        this.b.setRightImageView1ClickListener(new ae(this));
        this.b.setRightImageView2ClickListener(new af(this));
        this.b.setRightImageView3ClickListner(new c(this));
        this.b.setRightNavSearchClickListener(new d(this));
        this.b.setRightNavSearchShow(false);
        this.b.setTouchListener(new e(this));
        this.e = (DownloadCenterSelectFileTitleView) layoutInflater.findViewById(R.id.download_center_select_file_title);
        this.e.setCancelListener(new f(this));
        this.e.setSelectAllListener(new g(this));
        this.f = (DownloadCenterBottomView) layoutInflater.findViewById(R.id.bottom_operate_view);
        this.f.setDeleteTasksListener(new h(this));
        this.f.setPauseTasksListener(new k(this));
        this.f.setStartTasksListener(new l(this));
        this.p = (DownloadStorageView) layoutInflater.findViewById(R.id.storageView);
        this.g = (CollectionUserSyncTipBottomView) layoutInflater.findViewById(R.id.cloud_sync_bottom_card);
        com.xunlei.downloadprovider.web.website.a.a().a = this.g;
        this.s = (DownloadBriefInfoHeaderView) layoutInflater.findViewById(R.id.downloadBriefInfo);
        this.s.setActionListener(new ab(this));
        viewGroup = this.s;
        LoginHelper.a();
        boolean b = l.b();
        boolean l = LoginHelper.a().l();
        viewGroup.getStatusInfo().a = b;
        viewGroup.getStatusInfo().b = l;
        this.l = (DownloadCenterTabLayout) layoutInflater.findViewById(R.id.tabLayout);
        this.m = (DownloadCenterViewPager) layoutInflater.findViewById(R.id.taskListViewPager);
        this.m.setOffscreenPageLimit(4);
        this.m.setPageMargin(getResources().getDimensionPixelOffset(R.dimen.search_line_space_normal));
        this.n = new c(this, getFragmentManager());
        this.m.setAdapter(this.n);
        this.l.setupWithViewPager(this.m);
        com.xunlei.downloadprovider.download.tasklist.list.feed.b.a.a().a(layoutInflater.findViewById(R.id.iv_go_to_top));
        if (!(getActivity() == null || (getActivity() instanceof DownloadCenterActivity) == null || ((DownloadCenterActivity) getActivity()).d != null)) {
            d(this.m.getCurrentItem());
        }
        this.m.addOnPageChangeListener(new z(this));
        this.j = (AppBarLayout) layoutInflater.findViewById(R.id.appbar);
        this.j.addOnOffsetChangedListener(this);
        e(getArguments().getBoolean("extra_key_jump_to_collection", false));
        this.k = (CoordinatorLayout) layoutInflater.findViewById(R.id.main_content);
        this.v = (FrameLayout) layoutInflater.findViewById(R.id.tabLayout_appbar_container);
        this.u = (FrameLayout) layoutInflater.findViewById(R.id.tabLayout_title_container);
        LoginHelper.a();
        if (l.c() != null) {
            PrivateSpaceMgr.a();
            PrivateSpaceMgr.j();
        }
        h();
        com.xunlei.downloadprovider.broadcast.a.a().a(this.G);
        BannerManager.a();
        BannerManager.e();
        com.xunlei.downloadprovider.discovery.kuainiao.d.a().a((com.xunlei.downloadprovider.discovery.kuainiao.d.a) this);
        com.xunlei.downloadprovider.discovery.kuainiao.d.a();
        com.xunlei.downloadprovider.discovery.kuainiao.d.e();
        if (y == null) {
            a(new o(this), 1000);
        }
        PrivateSpaceMgr.a().a(this.H);
        LoginHelper.a().a(this.I);
        com.xunlei.downloadprovider.personal.lixianspace.business.c.a.a().b();
        return layoutInflater;
    }

    public void onResume() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        super.onResume();
        Bundle arguments = getArguments();
        long j = arguments.getLong(com.umeng.message.proguard.l.m, -1);
        arguments.putLong(com.umeng.message.proguard.l.m, -1);
        boolean z = arguments.getBoolean("extra_key_should_open_detailpage", false);
        if (j >= 0) {
            this.m.setCurrentItem(0);
            this.n.a(j, z);
        }
        if (this.t != null) {
            this.t.removeCallbacks(this.B);
            this.t.postDelayed(this.B, 1000);
        }
        d();
        h.e().d(0);
        h.e().d(2000);
        a(getActivity());
        f();
        e(false);
        h.e().i();
        LoginHelper.a().a(this);
        LoginHelper.a().a(this);
        com.xunlei.downloadprovider.ad.a.e.a().a(true);
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        StringBuilder stringBuilder = new StringBuilder("onResume : ");
        stringBuilder.append(elapsedRealtime2);
        stringBuilder.append("ms");
    }

    public void onStop() {
        super.onStop();
        com.xunlei.downloadprovider.ad.a.e.a().a(false);
    }

    public void onDestroyView() {
        super.onDestroyView();
        g();
        PrivateSpaceMgr.a().c();
        PrivateSpaceMgr.a().b(this.H);
        LoginHelper.a().b(this.I);
        f.a().d();
        com.xunlei.downloadprovider.web.website.a.a().c();
        com.xunlei.downloadprovider.download.tasklist.list.banner.d.f.a();
    }

    private void d() {
        if (this.p != null) {
            this.p.a();
        }
    }

    private void e() {
        if (this.s != null) {
            StatusInfo statusInfo = this.s.getStatusInfo();
            if (statusInfo != null) {
                TasksStatus tasksStatus;
                boolean f = h.e().f();
                boolean h = h.e().h();
                boolean z = false;
                boolean z2 = h.e().g() && this.r;
                if (statusInfo.f != f) {
                    statusInfo.f = f;
                    f = true;
                } else {
                    f = false;
                }
                if (this.r) {
                    statusInfo.h = this.r;
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
                h = l.b();
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
                    this.s.a();
                }
            }
        }
    }

    public void onDetach() {
        g();
        super.onDetach();
    }

    private static void c(int i) {
        com.xunlei.downloadprovider.ad.a.e a = com.xunlei.downloadprovider.ad.a.e.a();
        a.c = i;
        com.xunlei.downloadprovider.ad.a.e.a(a.c);
        com.xunlei.downloadprovider.ad.downloadlist.c.e a2 = com.xunlei.downloadprovider.ad.downloadlist.c.e.a();
        a2.d = i;
        a2.b();
        com.xunlei.downloadprovider.ad.downloadlist.c.a().a(i);
    }

    private void d(int i) {
        new Handler().postDelayed(new aa(this, i, this.n.a()), 1000);
    }

    private void a(boolean z) {
        LayoutParams layoutParams;
        if (z) {
            if (this.j.getVisibility()) {
                this.j.setVisibility(0);
                ((ViewGroup) this.l.getParent()).removeView(this.l);
                this.v.addView(this.l);
                this.u.setVisibility(8);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.k.getLayoutParams();
                marginLayoutParams.topMargin = 0;
                this.k.setLayoutParams(marginLayoutParams);
                if (this.w) {
                    layoutParams = (LayoutParams) this.m.getLayoutParams();
                    if (layoutParams.getBehavior() == null) {
                        layoutParams.setBehavior(this.w);
                        this.m.setLayoutParams(layoutParams);
                        this.w = null;
                    }
                }
                this.j.setExpanded(true, false);
            }
        } else if (!this.j.getVisibility()) {
            ((ViewGroup) this.l.getParent()).removeView(this.l);
            this.u.addView(this.l);
            if (!this.c) {
                this.u.setVisibility(0);
            }
            if (!this.j.getVisibility()) {
                this.k.setLayoutParams((MarginLayoutParams) this.k.getLayoutParams());
            }
            this.j.setExpanded(false, false);
            this.j.setVisibility(8);
            layoutParams = (LayoutParams) this.m.getLayoutParams();
            if (layoutParams.getBehavior() != null) {
                this.w = layoutParams.getBehavior();
            }
            layoutParams.setBehavior(null);
            this.m.setLayoutParams(layoutParams);
        }
    }

    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        this.x = i;
        if (this.c == null) {
            if (Math.abs(i) > this.s.getHeight() - 18) {
                b(true);
                if (this.F != i) {
                    c(false);
                    this.F = i;
                }
                if (this.c == 0 && this.n.c() != 0 && com.xunlei.downloadprovider.cooperation.ui.b.a().b == 0) {
                    this.p.setVisibility(8);
                }
                com.xunlei.downloadprovider.ad.downloadlist.c.e.a().a(true);
            } else {
                com.xunlei.downloadprovider.ad.downloadlist.c.e.a().a(false);
                b(false);
                if (this.D == null) {
                    this.p.setVisibility(0);
                }
            }
            d();
        }
    }

    private void b(boolean z) {
        if (z) {
            this.E = true;
            if (this.b.a(0, true)) {
                c(false);
            }
            return;
        }
        if (this.b.a(4, true)) {
            c(false);
        }
        this.E = false;
    }

    private void c(boolean z) {
        d(false);
        if (Math.abs(this.x) > this.s.getHeight() - 18 || z) {
            z = this.s.getStatusInfo().n;
            DownloadBriefInfoHeaderView downloadBriefInfoHeaderView = this.s;
            boolean z2 = downloadBriefInfoHeaderView.b.getVisibility() == 0 && (downloadBriefInfoHeaderView.d == DownloadingTipType.OPEN_VIP || downloadBriefInfoHeaderView.d == DownloadingTipType.OPEN_VIP_LOW_SPEED);
            boolean b = this.s.b();
            if (z) {
                this.b.setTipIcon(-1);
                switch (y.a[z.ordinal()]) {
                    case true:
                        this.b.setCenterTitle((int) R.string.download_center_head_title_notask);
                        LoginHelper.a();
                        if (!(l.b() && LoginHelper.a().l())) {
                            this.b.setTipIcon(R.drawable.download_center_warning);
                            d(true);
                            break;
                        }
                    case true:
                        this.b.setCenterTitle((int) R.string.download_center_head_title_taskpaused);
                        break;
                    case true:
                        this.b.setCenterTitle((int) R.string.download_center_head_title_taskException);
                        break;
                    case true:
                        this.b.setCenterTitle((int) R.string.download_center_head_title_cannotDownload);
                        break;
                    case true:
                        this.b.setCenterTitle((int) R.string.download_center_head_title_taskfinished);
                        if (z2) {
                            LoginHelper.a();
                            if (!(l.b() && LoginHelper.a().l())) {
                                this.b.setTipIcon(R.drawable.download_center_warning);
                                d(true);
                                break;
                            }
                        }
                        break;
                    default:
                        break;
                }
                this.b.a(0, false);
                return;
            }
            long b2 = h.e().b();
            String a = com.xunlei.downloadprovider.download.util.a.a(b2);
            if (b2 <= 0) {
                a = "0KB/s";
            }
            this.b.setCenterTitle(a);
            if (!TextUtils.isEmpty(a) && b) {
                this.b.setTipIcon(R.drawable.download_center_warning);
                d(true);
            } else if (TextUtils.isEmpty(a) || !z2) {
                LoginHelper a2 = LoginHelper.a();
                h e = h.e();
                if (l.b() && a2.l() && e.h()) {
                    this.b.setTipIcon(R.drawable.ic_download_accelerate);
                } else {
                    this.b.setTipIcon(-1);
                }
            } else {
                LoginHelper.a();
                if (!(l.b() && LoginHelper.a().l())) {
                    this.b.setTipIcon(R.drawable.download_center_warning);
                    d(true);
                }
            }
            if (!(TextUtils.isEmpty(a) || b)) {
                z = h.e().c(com.xunlei.downloadprovider.download.c.a.a().e);
                if (z) {
                    if (z.mIsEnteredHighSpeedTrial) {
                        if (z.getTaskStatus() == 2) {
                            if (z.mVipChannelStatus != 16) {
                                if (!k.a(z, k.i(z))) {
                                    this.b.setTipIcon(R.drawable.ic_download_accelerate);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void d(boolean z) {
        if (z) {
            this.b.setIconContainerListener(new ac(this));
        } else {
            this.b.setIconContainerListener(null);
        }
    }

    private void f() {
        h.e();
        TaskCountsStatistics c = h.c();
        if (this.s != null) {
            if (c.mRunningCount > 0) {
                if (!this.c) {
                    a(true);
                }
                this.s.getStatusInfo().n = null;
                long b = h.e().b();
                this.s.setDownloadSpeed(b);
                com.xunlei.downloadprovider.b.a.a(getActivity(), b);
                DownloadBriefInfoHeaderView downloadBriefInfoHeaderView = this.s;
                LoginHelper.a();
                downloadBriefInfoHeaderView.a(l.b(), LoginHelper.a().l());
                e();
            } else {
                if (c.mTotalCount <= c.mSuccessCount || (c.getFailedCount() + c.getPausedCount()) + c.getRunningCount() <= 0 || c.mUnfinishedNoCopyRightProblemCount != 0) {
                    if (c.mPausedCount <= 0) {
                        if (c.mFailedCount <= 0) {
                            if (c.mSuccessCount > 0) {
                                this.s.getStatusInfo().n = TasksStatus.TasksFinished;
                            } else {
                                this.s.getStatusInfo().n = TasksStatus.NoTasks;
                            }
                        }
                    }
                    this.s.getStatusInfo().n = TasksStatus.TasksPaused;
                    if (c.mPausedCount <= 0) {
                        this.s.getStatusInfo().n = TasksStatus.TasksFailed;
                    }
                } else {
                    this.s.getStatusInfo().n = TasksStatus.TasksCopyRightProblem;
                }
                this.s.a();
            }
        }
        this.q = false;
    }

    private void e(boolean z) {
        if (this.l != null) {
            Tab tabAt = this.l.getTabAt(0);
            if (tabAt != null) {
                tabAt.setText(R.string.download_list_title_all);
            }
            tabAt = this.l.getTabAt(1);
            if (tabAt != null) {
                tabAt.setText(R.string.download_list_title_unfinished);
            }
            tabAt = this.l.getTabAt(2);
            if (tabAt != null) {
                tabAt.setText(R.string.download_list_title_finished);
            }
            tabAt = this.l.getTabAt(3);
            if (tabAt != null) {
                com.xunlei.downloadprovider.web.website.g.b.a();
                boolean d = com.xunlei.downloadprovider.web.website.g.b.d();
                if (!d) {
                    tabAt.setText(R.string.download_list_title_collection);
                    if (!this.C) {
                        this.C = true;
                        com.xunlei.downloadprovider.download.report.a.a(false);
                    }
                } else if (d && tabAt.getCustomView() == null) {
                    tabAt.setCustomView(LayoutInflater.from(getContext()).inflate(R.layout.tab_with_red_point_view, null));
                    if (!(this.C || z)) {
                        this.C = true;
                        com.xunlei.downloadprovider.download.report.a.a(true);
                    }
                }
                if (z) {
                    tabAt.select();
                }
            }
        }
    }

    public final void a() {
        this.c = false;
        a(true);
        this.l.setTabLayoutEnable(true);
        this.m.setCanScroll(true);
        this.n.a(false);
        this.e.c(true);
        this.f.a(true);
        com.xunlei.downloadprovider.download.tasklist.list.feed.b.a.a().a(true);
    }

    public final void a(List<e> list) {
        boolean f;
        boolean z = true;
        if (list == null || list.size() <= 0) {
            this.f.b();
            this.e.setTitle(getActivity().getResources().getString(R.string.download_list_select_title));
        } else {
            this.e.setTitle(getActivity().getResources().getString(R.string.download_list_selected_file, new Object[]{String.valueOf(list.size())}));
            this.f.c();
        }
        list = this.e;
        c cVar = this.n;
        if (cVar.h.m.getCurrentItem() < 3) {
            f = ((TaskListPageFragment) cVar.a(cVar.h.m.getCurrentItem())).f();
        } else {
            f = false;
        }
        if (f) {
            z = false;
        }
        list.a(z);
    }

    public final void a(int i) {
        if ((this.m.getCurrentItem() == i ? 1 : 0) != 0 && this.n.c() == 0) {
            this.p.setVisibility(0);
        }
    }

    public final void a(int i, XLAccelBandInfo xLAccelBandInfo) {
        if (i == 0 && xLAccelBandInfo != null) {
            this.r = true;
        }
    }

    private void a(Context context) {
        if (this.s != null) {
            if (isAdded()) {
                StatusInfo statusInfo = this.s.getStatusInfo();
                if (com.xunlei.xllib.android.b.a(context)) {
                    statusInfo.a(true, com.xunlei.xllib.android.b.d(context));
                    statusInfo.m = com.xunlei.xllib.android.b.c(context);
                } else {
                    statusInfo.a(false, false);
                    statusInfo.m = null;
                }
                this.s.a();
            }
        }
    }

    public void onLoginCompleted(boolean z, int i, boolean z2) {
        a(new u(this), (long) 0);
    }

    public void onLogout() {
        a(new v(this), 0);
    }

    private void h() {
        int i;
        View view;
        boolean f;
        DownloadBriefInfoHeaderView downloadBriefInfoHeaderView;
        com.xunlei.downloadprovider.d.b.c cVar = com.xunlei.downloadprovider.d.d.a().d;
        int i2 = 0;
        if (com.xunlei.downloadprovider.d.b.c.o()) {
            PrivateSpaceMgr.a();
            if (PrivateSpaceMgr.b()) {
                i = 1;
                view = this.b.c;
                if (i != 0) {
                    i2 = 8;
                }
                view.setVisibility(i2);
                f = true ^ PrivateSpaceMgr.a().f();
                this.b.b.setSelected(f);
                i = PrivateSpaceMgr.a().a.size();
                if (!PrivateSpaceMgr.a().f() || i <= 0) {
                    this.b.a("");
                } else {
                    String valueOf = String.valueOf(i);
                    if (i >= 100) {
                        valueOf = "99+";
                    }
                    this.b.a(valueOf);
                }
                if (h.e().b() <= 0) {
                    downloadBriefInfoHeaderView = this.s;
                    if (downloadBriefInfoHeaderView.c != null) {
                        downloadBriefInfoHeaderView.c.setVisibility(8);
                    }
                }
            }
        }
        i = 0;
        view = this.b.c;
        if (i != 0) {
            i2 = 8;
        }
        view.setVisibility(i2);
        f = true ^ PrivateSpaceMgr.a().f();
        this.b.b.setSelected(f);
        i = PrivateSpaceMgr.a().a.size();
        if (PrivateSpaceMgr.a().f()) {
        }
        this.b.a("");
        if (h.e().b() <= 0) {
            downloadBriefInfoHeaderView = this.s;
            if (downloadBriefInfoHeaderView.c != null) {
                downloadBriefInfoHeaderView.c.setVisibility(8);
            }
        }
    }

    public void onDestroy() {
        if (this.t != null) {
            this.t.removeCallbacks(this.B);
        }
        if (this.t != null) {
            this.t.removeCallbacksAndMessages(null);
        }
        com.xunlei.downloadprovider.download.control.a.b(this.o);
        h.e().j();
        this.d.a = null;
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
        com.xunlei.downloadprovider.ad.recommend.a.h.b();
        com.xunlei.downloadprovider.ad.a.e.b();
        com.xunlei.downloadprovider.discovery.kuainiao.d.a().b((com.xunlei.downloadprovider.discovery.kuainiao.d.a) this);
        BannerManager.a().b();
        g();
        LoginHelper.a().b(this);
        LoginHelper.a().b(this);
        com.xunlei.downloadprovider.download.tasklist.list.feed.b.a();
        super.onDestroy();
    }

    private void g() {
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
        r1 = r2.G;	 Catch:{ Exception -> 0x0010 }
        r0.b(r1);	 Catch:{ Exception -> 0x0010 }
        return;
    L_0x0010:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.center.DownloadCenterActivityFragment.g():void");
    }

    static /* synthetic */ void b(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        if (downloadCenterActivityFragment.q) {
            downloadCenterActivityFragment.f();
            downloadCenterActivityFragment.e(false);
        } else {
            downloadCenterActivityFragment.e();
        }
        if (downloadCenterActivityFragment.E) {
            downloadCenterActivityFragment.c(false);
        }
        DownloadCenterActivity downloadCenterActivity = (DownloadCenterActivity) downloadCenterActivityFragment.getActivity();
        if (downloadCenterActivity.c != null && downloadCenterActivity.c.isVisible()) {
            downloadCenterActivity.c.b();
        }
    }

    static /* synthetic */ void d(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        downloadCenterActivityFragment = downloadCenterActivityFragment.l.getTabAt(3);
        View customView = downloadCenterActivityFragment.getCustomView();
        if (downloadCenterActivityFragment != null && customView != null) {
            customView.findViewById(R.id.tab_red_point).setVisibility(8);
            com.xunlei.downloadprovider.web.website.g.b.a();
            com.xunlei.downloadprovider.web.website.g.b.c();
        }
    }

    static /* synthetic */ void b(DownloadCenterActivityFragment downloadCenterActivityFragment, boolean z) {
        Tab tabAt = downloadCenterActivityFragment.l.getTabAt(3);
        if (!(tabAt == null || tabAt.getCustomView() == null)) {
            TextView textView = (TextView) tabAt.getCustomView().findViewById(R.id.tab_title);
            if (z) {
                textView.setTextColor(downloadCenterActivityFragment.getResources().getColor(true));
                return;
            }
            textView.setTextColor(downloadCenterActivityFragment.getResources().getColor(true));
        }
    }

    static /* synthetic */ void h(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        if (downloadCenterActivityFragment.i == null) {
            downloadCenterActivityFragment.i = new p(downloadCenterActivityFragment.getActivity());
            downloadCenterActivityFragment.i.setOnDismissListener(new m(downloadCenterActivityFragment));
        }
        downloadCenterActivityFragment.i.show();
    }

    static /* synthetic */ void i(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        if (downloadCenterActivityFragment.h != null) {
            if (downloadCenterActivityFragment.h.isShowing()) {
                downloadCenterActivityFragment.h.dismiss();
            }
            downloadCenterActivityFragment.h = null;
        }
        downloadCenterActivityFragment.h = new j(downloadCenterActivityFragment.getActivity());
        downloadCenterActivityFragment.h.a(downloadCenterActivityFragment.b.getRightImageView2(), -DipPixelUtil.dip2px(99.0f), DipPixelUtil.dip2px(-12.0f));
        downloadCenterActivityFragment.h.e.setOnClickListener(new n(downloadCenterActivityFragment));
        downloadCenterActivityFragment.h.d.setOnClickListener(new p(downloadCenterActivityFragment));
        downloadCenterActivityFragment.h.b.setOnClickListener(new q(downloadCenterActivityFragment));
        downloadCenterActivityFragment.h.c.setOnClickListener(new r(downloadCenterActivityFragment));
        downloadCenterActivityFragment.h.a.setOnClickListener(new s(downloadCenterActivityFragment));
        downloadCenterActivityFragment.h.setOnDismissListener(new t(downloadCenterActivityFragment));
        WindowManager.LayoutParams attributes = downloadCenterActivityFragment.getActivity().getWindow().getAttributes();
        attributes.alpha = 0.6f;
        downloadCenterActivityFragment.getActivity().getWindow().setAttributes(attributes);
        boolean z = downloadCenterActivityFragment.m.getCurrentItem() < 3 && downloadCenterActivityFragment.n != null && downloadCenterActivityFragment.n.a() != null && ((TaskListPageFragment) downloadCenterActivityFragment.n.a()).h();
        j jVar = downloadCenterActivityFragment.h;
        jVar.e.setEnabled(z);
        if (z) {
            jVar.e.setVisibility(0);
            jVar.f.setVisibility(8);
        } else {
            jVar.f.setVisibility(0);
            jVar.e.setVisibility(8);
        }
        downloadCenterActivityFragment.h.a();
    }

    static /* synthetic */ void n(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        downloadCenterActivityFragment.c = true;
        downloadCenterActivityFragment.a(false);
        downloadCenterActivityFragment.l.setTabLayoutEnable(false);
        downloadCenterActivityFragment.m.setCanScroll(false);
        int dip2px = DipPixelUtil.dip2px(74.0f) - Math.abs(downloadCenterActivityFragment.x);
        c cVar = downloadCenterActivityFragment.n;
        if (cVar.h.m.getCurrentItem() < 3) {
            TaskListPageFragment taskListPageFragment = (TaskListPageFragment) cVar.a();
            if (taskListPageFragment.d != null) {
                taskListPageFragment.d.k = dip2px;
            }
        }
        downloadCenterActivityFragment.n.a(true);
        downloadCenterActivityFragment.e.b(true);
        downloadCenterActivityFragment.e.setTitle(downloadCenterActivityFragment.getActivity().getResources().getString(R.string.download_list_select_title));
        downloadCenterActivityFragment.f.b();
        downloadCenterActivityFragment.f.a();
        com.xunlei.downloadprovider.download.tasklist.list.feed.b.a.a().a(false);
    }
}
