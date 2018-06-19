package com.xunlei.downloadprovider.download.taskdetails;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.taskdetail.view.m;
import com.xunlei.downloadprovider.download.center.widget.DownloadCenterBottomView;
import com.xunlei.downloadprovider.download.center.widget.DownloadCenterSelectFileTitleView;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskSpeedCountInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.engine.util.b;
import com.xunlei.downloadprovider.download.taskdetails.report.DetailsPeriod;
import com.xunlei.downloadprovider.download.taskdetails.subtask.BTSubTaskItem;
import com.xunlei.downloadprovider.download.taskdetails.widget.FloatDragView;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.tasklist.task.h;
import com.xunlei.downloadprovider.download.tasklist.task.s;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.xllib.b.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DownloadCenterDetailFragment extends DownloadDetailBasicFragment implements ao {
    private com.xunlei.downloadprovider.ad.taskdetail.view.a A = null;
    private DetailsPeriod B;
    private boolean C = false;
    private final int D = 1000;
    private Runnable E = new w(this);
    TaskDetailFragment a;
    boolean b;
    String c = "DownloadCenterDetailFragment";
    XLAlertDialog d;
    public a e;
    MessageListener f = new v(this);
    StaticHandler g = new StaticHandler(this.f);
    private com.xunlei.downloadprovider.download.taskdetails.widget.a k;
    private DownloadCenterSelectFileTitleView l;
    private DownloadCenterBottomView m;
    private boolean n;
    private TextView o;
    private View p;
    private ImageView q;
    private ImageView r;
    private ImageView s;
    private TaskSpeedCountInfo t;
    private FloatDragView u;
    private com.xunlei.downloadprovider.download.control.a v = new com.xunlei.downloadprovider.download.control.a();
    private Animation w;
    private Animation x;
    private Animation y;
    private Animation z;

    private static class a {
        boolean a;
        s b;
        public DownloadTaskInfo c;
        public String d;

        private a() {
            this.a = false;
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.v.a = getActivity();
        layoutInflater = layoutInflater.inflate(R.layout.download_center_taskdetail_layout, viewGroup, false);
        this.p = layoutInflater.findViewById(R.id.status_bar);
        this.q = (ImageView) layoutInflater.findViewById(R.id.detail_title_right_icon);
        this.q.setOnClickListener(new aa(this));
        this.s = (ImageView) layoutInflater.findViewById(R.id.detail_title_share_icon);
        this.s.setOnClickListener(new ab(this));
        this.o = (TextView) layoutInflater.findViewById(R.id.task_detail_mask);
        this.o.setOnClickListener(new ac(this));
        this.u = (FloatDragView) layoutInflater.findViewById(R.id.drag_view);
        this.u.setIdleY(DipPixelUtil.dip2px(92.0f));
        this.u.setContentNestedScrollViewId(R.id.task_detail_recycler_view);
        this.r = (ImageView) layoutInflater.findViewById(R.id.close_btn);
        this.r.setOnClickListener(new ad(this));
        this.u.setListener(new e(this));
        this.l = (DownloadCenterSelectFileTitleView) layoutInflater.findViewById(R.id.select_file_title);
        this.l.setCancelListener(new q(this));
        this.l.setOnClickListener(new x(this));
        this.l.setSelectAllListener(new y(this));
        this.l.setShowListener(new z(this));
        this.m = (DownloadCenterBottomView) layoutInflater.findViewById(R.id.bottom_view);
        this.m.setDeleteTasksListener(new d(this));
        this.A = new m(getContext());
        this.A.setTag("view_tag_value_top");
        this.u.addView(this.A, 0);
        return layoutInflater;
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.a = (TaskDetailFragment) getChildFragmentManager().findFragmentById(R.id.fragment_task_detail);
        view = this.a;
        com.xunlei.downloadprovider.download.control.a aVar = this.v;
        view.e = aVar;
        if (view.c != null) {
            view.c.a(aVar);
            if (!(view.isVisible() == null || view.isAdded() == null)) {
                view.c.notifyDataSetChanged();
            }
        }
        this.a.f = this;
        this.a.k = this.u;
        view = this.A;
        this.a.n = new f(this, view);
        if (this.e != null) {
            a(this.e, true);
        }
    }

    public void onStart() {
        super.onStart();
        if (this.B != null) {
            this.B.onStart();
        }
    }

    public void onStop() {
        super.onStop();
        if (this.B != null) {
            this.B.onStop();
        }
    }

    private void h() {
        this.q.setImageResource(R.drawable.download_center_detail_more_gray_selector);
        this.s.setImageResource(R.drawable.download_detail_share_icon_gray_selector);
        if (this.b) {
            this.r.setImageResource(R.drawable.commonui_nav_arrow_back_selector);
        } else {
            this.r.setImageResource(R.drawable.download_center_detail_close_gray_selector);
        }
        this.p.setBackgroundColor(Color.parseColor("#ffffff"));
        this.p.setClickable(true);
    }

    private void i() {
        this.q.setImageResource(R.drawable.download_center_detail_more_selector);
        this.s.setImageResource(R.drawable.download_detail_share_icon_selector);
        this.r.setImageResource(R.drawable.download_center_detail_close_selector);
        this.p.setBackgroundColor(Color.parseColor("#00000000"));
        this.p.setClickable(false);
    }

    final ArrayList<BTSubTaskItem> a() {
        ArrayList<BTSubTaskItem> arrayList = new ArrayList();
        arrayList.addAll(this.a.b.a());
        return arrayList;
    }

    private void b(boolean z) {
        this.n = z;
        if (z) {
            this.u.setVisibilityState$2563266(true);
            this.u.setScrollEnable(false);
            this.l.b(true);
            this.m.a();
            this.u.cancelLongPress();
        } else {
            this.u.setScrollEnable(true);
            this.m.a(true);
            this.l.c(true);
            h();
        }
        if (this.a != null) {
            TaskDetailFragment taskDetailFragment = this.a;
            taskDetailFragment.g = z;
            if (taskDetailFragment.c != null) {
                taskDetailFragment.c.g = taskDetailFragment.g;
                if (k.e(taskDetailFragment.d)) {
                    if (z) {
                        taskDetailFragment.c.e();
                        taskDetailFragment.a(false, false);
                        taskDetailFragment.j.a(false);
                        return;
                    }
                    z = taskDetailFragment.b.j;
                    List list = taskDetailFragment.b.k;
                    taskDetailFragment.b.a(false);
                    taskDetailFragment.c.b(z, list);
                    taskDetailFragment.j.a(true);
                    taskDetailFragment.a(false, false);
                }
            }
        }
    }

    public final void a(s sVar, String str) {
        a aVar = new a();
        aVar.b = sVar;
        aVar.a = true;
        aVar.d = str;
        a(aVar, false);
    }

    public final void a(a aVar, boolean z) {
        DownloadTaskInfo downloadTaskInfo = aVar.c;
        if (aVar.a) {
            this.i = aVar.b;
            downloadTaskInfo = this.i.b;
            this.b = true;
            this.u.setIdleY(0);
            this.u.setLockScroll(true);
            if (this.g != null) {
                this.g.removeCallbacks(this.E);
                this.g.postDelayed(this.E, 1000);
            }
        }
        if (downloadTaskInfo != null) {
            this.j = aVar.d;
            this.C = false;
            if (TextUtils.isEmpty(downloadTaskInfo.mCreateOrigin) != null) {
                n.a();
                aVar = n.f(downloadTaskInfo.getTaskId());
                if (aVar != null) {
                    downloadTaskInfo.mSniffKeyword = aVar.mSniffKeyword;
                    downloadTaskInfo.mWebsiteName = aVar.mWebsiteName;
                    downloadTaskInfo.mRefUrl = aVar.mRefUrl;
                    downloadTaskInfo.mCreateOrigin = aVar.mCreateOrigin;
                    downloadTaskInfo.mExtraInfo = aVar.mExtraInfo;
                }
            }
            this.h = downloadTaskInfo;
            n.a();
            this.t = n.m(downloadTaskInfo.getTaskId());
            if (b.f(downloadTaskInfo.getResourceGcid()) == null) {
                h.e().e(downloadTaskInfo.getTaskId());
            }
            aVar = new StringBuilder("showTaskDetail title:");
            aVar.append(downloadTaskInfo.mTitle);
            aVar.append(" gcid = ");
            aVar.append(downloadTaskInfo.getResourceGcid());
            aVar = this.j;
            if (TextUtils.isEmpty(aVar)) {
                aVar = DispatchConstants.OTHER;
            }
            a aVar2 = aVar;
            this.B = new DetailsPeriod();
            this.B.onStart();
            boolean a = com.xunlei.downloadprovider.download.taskdetails.b.b.a(downloadTaskInfo);
            String a2 = com.xunlei.downloadprovider.download.engine.report.a.a((TaskInfo) downloadTaskInfo);
            boolean a3 = TaskDetailFragment.a((TaskInfo) downloadTaskInfo);
            boolean z2 = (downloadTaskInfo.getTaskStatus() == 2 || downloadTaskInfo.getTaskStatus() == 1) && downloadTaskInfo.mHasVipChannelSpeedup == null;
            com.xunlei.downloadprovider.download.report.a.a(downloadTaskInfo.mTitle, aVar2, z2, a2, a3, a);
            if (this.t == null) {
                this.t = new TaskSpeedCountInfo();
                this.t.mTaskId = downloadTaskInfo.getTaskId();
            }
            if (this.a != null) {
                this.a.m = this.b;
                aVar = this.a;
                TaskSpeedCountInfo taskSpeedCountInfo = this.t;
                String str = this.j;
                aVar.d = downloadTaskInfo;
                af afVar = aVar.a;
                if (afVar.a != null) {
                    afVar.a.d = downloadTaskInfo;
                }
                if (afVar.b != null) {
                    afVar.b.d = downloadTaskInfo;
                }
                if (afVar.c != null) {
                    afVar.c.d = downloadTaskInfo;
                }
                if (afVar.g != null) {
                    afVar.g.d = downloadTaskInfo;
                }
                if (afVar.d != null) {
                    afVar.d.d = downloadTaskInfo;
                }
                if (afVar.e != null) {
                    afVar.e.d = downloadTaskInfo;
                }
                if (afVar.f != null) {
                    afVar.f.d = downloadTaskInfo;
                }
                aVar.b.a(downloadTaskInfo);
                aVar.b.a(false);
                if (com.xunlei.downloadprovider.download.taskdetails.b.b.a(downloadTaskInfo)) {
                    aVar.j.b(downloadTaskInfo);
                } else {
                    aVar.j.d();
                    aVar.h.postDelayed(new al(aVar), 500);
                }
                aVar.j.a();
                af afVar2 = aVar.a;
                afVar2.h = taskSpeedCountInfo;
                if (afVar2.a != null) {
                    afVar2.a.c = taskSpeedCountInfo;
                }
                b bVar = aVar.b;
                bVar.h = taskSpeedCountInfo;
                if (bVar.b != null) {
                    bVar.b.c = taskSpeedCountInfo;
                }
                if (aVar.c() && aVar.h != null) {
                    aVar.h.scrollToPosition(0);
                }
                if (aVar.c != null) {
                    aVar.c.j = true;
                    aVar.c.k = str;
                    aVar.c.notifyDataSetChanged();
                }
                aVar.b();
                aVar.l = false;
                if (k.e(aVar.d)) {
                    aVar.a();
                    aVar.j.c = true;
                    aVar.a(true, false);
                } else {
                    aVar.j.c = false;
                }
                aVar.i.a(true);
                aVar.i.c();
            }
            if (this.b != null) {
                h();
                this.g.post(new m(this));
                return;
            }
            i();
            if (z) {
                c(false);
            } else {
                this.g.post(new n(this));
            }
        }
    }

    public final void b() {
        if (this.a != null && isVisible()) {
            this.a.d();
        }
    }

    private void c(boolean z) {
        if (this.h != null) {
            if (this.u != null) {
                this.u.a();
            }
            View view = getView();
            if (view != null) {
                this.p.setVisibility(0);
                if (z) {
                    view.setVisibility(0);
                    this.w = AnimationUtils.loadAnimation(getActivity(), R.anim.alpha_0_1);
                    this.w.setDuration(300);
                    this.w.setAnimationListener(new o(this));
                    this.o.setAnimation(this.w);
                    this.o.animate();
                    this.x = AnimationUtils.loadAnimation(getActivity(), R.anim.detail_bottom_in);
                    this.x.setAnimationListener(new p(this));
                    this.u.setAnimation(this.x);
                    this.u.animate();
                } else {
                    getView().setVisibility(0);
                    if (this.a) {
                        TaskDetailFragment.e();
                    }
                }
                this.l.c(false);
                this.m.a(false);
            }
        }
    }

    public final void a(List<BTSubTaskItem> list) {
        b((List) list);
    }

    private void b(List<BTSubTaskItem> list) {
        if (d.a(list)) {
            this.m.b();
            this.l.setTitle("请选择文件");
        } else {
            this.m.c();
            DownloadCenterSelectFileTitleView downloadCenterSelectFileTitleView = this.l;
            StringBuilder stringBuilder = new StringBuilder("已选择");
            stringBuilder.append(list.size());
            stringBuilder.append("个项目");
            downloadCenterSelectFileTitleView.setTitle(stringBuilder.toString());
        }
        if (this.a != null) {
            this.l.a(this.a.b.d() ^ 1);
        }
    }

    public final void d() {
        b(true);
        b(a());
    }

    final void e() {
        if (this.d != null) {
            this.d.dismiss();
        }
    }

    protected final void f() {
        if (isAdded()) {
            if (isVisible()) {
                if (this.i != null) {
                    this.i.i();
                }
                b();
            }
        }
    }

    public void onDestroy() {
        if (this.g != null) {
            this.g.removeCallbacks(this.E);
        }
        this.g.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    public final void c() {
        if (this.n) {
            b(false);
            return;
        }
        if (isVisible()) {
            a(true);
        }
    }

    public final void a(boolean z) {
        if (!this.b) {
            if (z) {
                if (!this.C) {
                    this.C = true;
                }
            }
            if (this.n) {
                b(false);
            }
            if (z) {
                this.y = AnimationUtils.loadAnimation(getActivity(), R.anim.alpha_1_0);
                this.y.setDuration(300);
                this.y.setAnimationListener(new s(this));
                this.o.startAnimation(this.y);
                this.z = AnimationUtils.loadAnimation(getActivity(), R.anim.detail_bottom_out);
                this.z.setDuration(300);
                this.z.setAnimationListener(new t(this));
                this.u.startAnimation(this.z);
            } else {
                getView().setVisibility(8);
                if (this.a) {
                    this.a.g();
                    this.a.f();
                }
            }
            this.l.c(false);
            this.m.a(false);
        }
        if (this.B) {
            this.B.onStop();
            com.xunlei.downloadprovider.download.report.a.a(this.B.getDuration());
            this.B = false;
        }
        if (this.g) {
            this.g.postDelayed(new r(this), 300);
        }
    }

    static /* synthetic */ void c(DownloadCenterDetailFragment downloadCenterDetailFragment) {
        if (downloadCenterDetailFragment.k != null) {
            if (downloadCenterDetailFragment.k.isShowing()) {
                downloadCenterDetailFragment.k.dismiss();
            }
            downloadCenterDetailFragment.k = null;
        }
        downloadCenterDetailFragment.k = new com.xunlei.downloadprovider.download.taskdetails.widget.a(downloadCenterDetailFragment.getActivity());
        downloadCenterDetailFragment.k.c = new g(downloadCenterDetailFragment);
        downloadCenterDetailFragment.k.a = new j(downloadCenterDetailFragment);
        downloadCenterDetailFragment.k.b = new k(downloadCenterDetailFragment);
        downloadCenterDetailFragment.k.d = new l(downloadCenterDetailFragment);
        downloadCenterDetailFragment.k.a(downloadCenterDetailFragment.h);
        downloadCenterDetailFragment.k.show();
    }

    static /* synthetic */ void i(DownloadCenterDetailFragment downloadCenterDetailFragment) {
        if (downloadCenterDetailFragment.h != null && downloadCenterDetailFragment.getView() != null) {
            downloadCenterDetailFragment.p.setVisibility(0);
            downloadCenterDetailFragment.getView().setVisibility(0);
            if (downloadCenterDetailFragment.u != null) {
                downloadCenterDetailFragment.u.a();
                downloadCenterDetailFragment.u.setVisibilityState$2563266(false);
            }
            if (downloadCenterDetailFragment.a != null) {
                TaskDetailFragment.e();
            }
            downloadCenterDetailFragment.l.c(false);
            downloadCenterDetailFragment.m.a(false);
        }
    }

    static /* synthetic */ void a(DownloadCenterDetailFragment downloadCenterDetailFragment, int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (((BTSubTaskItem) list.get(i2)).mLocalFileName != null) {
                File file = new File(((BTSubTaskItem) list.get(i2)).mLocalFileName);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
        list = downloadCenterDetailFragment.a.b.b();
        long[] jArr = new long[list.size()];
        for (int i3 = 0; i3 < list.size(); i3++) {
            jArr[i3] = (long) ((BTSubTaskItem) list.get(i3)).mBTSubIndex;
        }
        if (i == 1) {
            n.a().b(new long[]{downloadCenterDetailFragment.h.getTaskId()});
            downloadCenterDetailFragment.a(false);
            return;
        }
        n.a();
        n.a(downloadCenterDetailFragment.h.getTaskId(), jArr);
        downloadCenterDetailFragment.b(false);
    }
}
