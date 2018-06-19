package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.System;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.igexin.sdk.PushConsts;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.commonview.TwiceClickToConfirm;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.taskdetailnew.f;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.l;
import com.xunlei.downloadprovider.download.center.widget.DownloadCenterBottomView;
import com.xunlei.downloadprovider.download.center.widget.DownloadCenterSelectFileTitleView;
import com.xunlei.downloadprovider.download.create.DownloadBtFileExplorerActivity;
import com.xunlei.downloadprovider.download.downloadvod.i;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskSpeedCountInfo;
import com.xunlei.downloadprovider.download.engine.task.z;
import com.xunlei.downloadprovider.download.player.a.m;
import com.xunlei.downloadprovider.download.player.a.m$a;
import com.xunlei.downloadprovider.download.player.views.DownloadVodPlayerView;
import com.xunlei.downloadprovider.download.taskdetails.TaskDetailFragment;
import com.xunlei.downloadprovider.download.taskdetails.report.DetailsPeriod;
import com.xunlei.downloadprovider.download.taskdetails.subtask.BTSubTaskItem;
import com.xunlei.downloadprovider.download.taskdetails.subtask.b;
import com.xunlei.downloadprovider.download.taskdetails.widget.h;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.tasklist.task.s;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.download.util.n;
import com.xunlei.downloadprovider.h.c;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import com.xunlei.downloadprovider.personal.playrecord.v;
import com.xunlei.downloadprovider.vodnew.a.e.o.e;
import com.xunlei.downloadprovidershare.b.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DownloadDetailsActivityFragment extends Fragment implements c {
    static final int a;
    static final int b;
    static final int c = ((int) (((float) ((a * 5) / 14)) + PayBaseConstants.HALF_OF_FLOAT));
    private static final String q = "DownloadDetailsActivityFragment";
    private com.xunlei.downloadprovider.download.player.a A;
    private com.xunlei.downloadprovider.database.a.a B;
    private boolean C = false;
    private h D;
    private DetailsPeriod E;
    private boolean F = false;
    private boolean G = false;
    private boolean H = false;
    private Handler I = new Handler(Looper.getMainLooper());
    private View J = null;
    private View K = null;
    private BroadcastReceiver L;
    private boolean M = false;
    private int N = 2500;
    private e O = new l(this);
    private OnScrollListener P = new al(this);
    private m$a Q = new am(this);
    private com.xunlei.downloadprovider.download.taskdetails.newui.d.a R;
    private a S;
    private BroadcastReceiver T = new an(this);
    private BroadcastReceiver U = new ao(this);
    private BroadcastReceiver V = new aq(this);
    private XLAlertDialog W = null;
    private OnClickListener X = new ab(this);
    private d Y;
    private com.xunlei.downloadprovider.download.taskdetails.subtask.b.a Z = new ac(this);
    private int aa = 0;
    private int ab = 0;
    private int ac = 0;
    a d;
    final b e = new b();
    protected DownloadTaskInfo f;
    protected s g;
    protected String h;
    m i;
    public boolean j = false;
    ViewGroup k;
    DownloadVodPlayerView l;
    ValueAnimator m;
    public boolean n = false;
    TwiceClickToConfirm o = null;
    public i p;
    private DownloadDetailsBeforePlayController r;
    private RecyclerView s;
    private LinearLayoutManager t;
    private final b u = new b();
    private com.xunlei.downloadprovider.download.taskdetails.b.b v;
    private com.xunlei.downloadprovider.download.control.a w = new com.xunlei.downloadprovider.download.control.a();
    private aw x = new aw();
    private boolean y = true;
    private d z;

    class a extends OrientationEventListener {
        final /* synthetic */ DownloadDetailsActivityFragment a;
        private int b = -1;

        public a(DownloadDetailsActivityFragment downloadDetailsActivityFragment, Context context) {
            this.a = downloadDetailsActivityFragment;
            super(context);
        }

        public final void onOrientationChanged(int i) {
            DownloadDetailsActivityFragment.q;
            if (this.a.getActivity() != null) {
                int i2 = 0;
                int i3 = 1;
                if (System.getInt(this.a.getActivity().getContentResolver(), "accelerometer_rotation", 0) != 1) {
                    i3 = 0;
                }
                if (i3 != 0) {
                    if ((this.a.i == null || !this.a.i.t()) && i != -1) {
                        if (i <= TinkerReport.KEY_LOADED_PACKAGE_CHECK_SIGNATURE) {
                            if (i >= 10) {
                                if (i > 80 && i < 100) {
                                    i2 = 90;
                                } else if (i > Opcodes.REM_FLOAT && i < 190) {
                                    i2 = 180;
                                } else if (i > 260 && i < 280) {
                                    i2 = 270;
                                } else {
                                    return;
                                }
                            }
                        }
                        if (this.b != i2) {
                            DownloadDetailsActivityFragment.q;
                            i = this.b;
                            this.b = i2;
                            if ((i2 == 90 || i2 == 270) && i != -1) {
                                if (!(this.a.getActivity() == 0 || this.a.isAdded() == 0 || this.a.isResumed() == 0)) {
                                    if (com.xunlei.xllib.android.d.g(this.a.getActivity()) != 0) {
                                        if (com.xunlei.downloadprovider.vod.floatwindow.a.a == 0) {
                                            DownloadDetailsActivityFragment.q;
                                            if (!(this.a.f == 0 || this.a.j == 0 || this.a.i == 0)) {
                                                i = this.a;
                                                DownloadTaskInfo downloadTaskInfo = this.a.f;
                                                DownloadDetailsActivityFragment.g(i);
                                            }
                                        }
                                        return;
                                    }
                                }
                                return;
                            }
                            this.a.m();
                        }
                    }
                }
            }
        }
    }

    static {
        int screenWidth = AndroidConfig.getScreenWidth();
        a = screenWidth;
        b = (int) (((float) ((screenWidth * 9) / 16)) + PayBaseConstants.HALF_OF_FLOAT);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.E = DetailsPeriod.createOrRestore(bundle);
        this.y = true;
        c.a(getContext(), "ACTION_SHOW_SHARE_DIALOG", this.V);
        c.a(getContext(), "DownloadVodPlayerController.ACTION_PLAY_COMPLETION", this.U);
        bundle = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        bundle.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        com.xunlei.downloadprovider.broadcast.a a = com.xunlei.downloadprovider.broadcast.a.a();
        BroadcastReceiver broadcastReceiver = this.T;
        com.xunlei.downloadprovider.broadcast.a.a aVar = a.a;
        if (broadcastReceiver != null) {
            aVar.b.add(new a$a$b(broadcastReceiver, bundle));
            bundle = new StringBuilder("registerReceiver(");
            bundle.append(aVar.b.size());
            bundle.append("):");
            bundle.append(broadcastReceiver);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getActivity() != null) {
            this.w.a = getActivity();
        }
        this.K = layoutInflater.inflate(R.layout.fragment_download_details, viewGroup, false);
        View view = this.K;
        this.l = (DownloadVodPlayerView) view.findViewById(R.id.playerView);
        viewGroup = this.l;
        viewGroup.c.setFloatCloseListener(new q(this));
        this.A = new com.xunlei.downloadprovider.download.player.a(this.l);
        this.i = this.A.f();
        this.i.c = this.Q;
        this.i.a(this.O);
        this.i.z();
        viewGroup = this.i;
        this.d = new a(getContext());
        this.d.a((m) viewGroup);
        this.d.setHasStableIds(false);
        this.d.a(this.w);
        this.d.m = this;
        this.d.r = true;
        this.d.q = false;
        this.d.a(new o(this));
        this.e.c = getLoaderManager();
        if (getActivity() != null) {
            this.e.k = getActivity();
        }
        this.e.l = this.Z;
        this.v = new com.xunlei.downloadprovider.download.taskdetails.b.b(getContext(), this.d.h);
        this.v.e = viewGroup;
        this.v.a();
        this.J = view.findViewById(R.id.fl_play_view);
        this.s = (RecyclerView) view.findViewById(R.id.task_detail_recycler_view);
        this.t = new LinearLayoutManager(getActivity());
        this.s.setLayoutManager(this.t);
        this.s.getItemAnimator().setChangeDuration(0);
        this.s.setAdapter(this.d);
        this.d.n = this.t;
        this.k = (ViewGroup) view.findViewById(R.id.player_container_layout);
        this.k.setVisibility(8);
        this.R = new y(this);
        this.z = new d(view.findViewById(R.id.download_details_title_header_bar));
        this.z.d = this.R;
        this.z.a.setVisibility(8);
        if (!(this.A == null || this.A.j() == null)) {
            this.A.j().a = new z(this);
        }
        if (this.i != null) {
            this.i.s();
            this.i.j = new aa(this);
            this.i.k = this.X;
        }
        this.v.a(view, this.s);
        this.D = new h(view.findViewById(R.id.fab_task_expand), this);
        viewGroup = this.D;
        bundle = new r(this);
        if (viewGroup.a != null) {
            viewGroup.a.setOnClickListener(bundle);
        }
        this.d.p = this.D;
        this.s.addOnScrollListener(this.P);
        viewGroup = this.x;
        viewGroup.e = (DownloadCenterBottomView) view.findViewById(R.id.bottom_view);
        viewGroup.e.setDeleteTasksListener(new ax(viewGroup));
        viewGroup.c = (DownloadCenterSelectFileTitleView) view.findViewById(R.id.select_file_title);
        viewGroup.c.setCancelListener(new ay(viewGroup));
        viewGroup.c.setOnClickListener(new az(viewGroup));
        viewGroup.c.setSelectAllListener(new ba(viewGroup));
        this.x.b = this.d;
        this.x.a = this.u.b;
        this.x.g = new s(this);
        this.r = new DownloadDetailsBeforePlayController(getActivity());
        getLifecycle().a(this.r);
        viewGroup = this.r;
        viewGroup.g = -1;
        if ((view instanceof ConstraintLayout) == null) {
            throw new IllegalArgumentException("rootView must be ConstraintLayout");
        }
        viewGroup.a = (ConstraintLayout) view;
        viewGroup.b = viewGroup.a.findViewById(R.id.fl_before_play);
        viewGroup.c = (ImageView) viewGroup.a.findViewById(R.id.iv_bg);
        viewGroup.d = (ImageView) viewGroup.a.findViewById(R.id.iv_logo);
        viewGroup.e = (ImageView) viewGroup.a.findViewById(R.id.iv_app_name);
        viewGroup.f = (ImageView) viewGroup.a.findViewById(R.id.btn_play);
        viewGroup.i = new f(new com.xunlei.downloadprovider.ad.taskdetailnew.i(viewGroup.a));
        viewGroup.m = (DownloadDetailsBeforePlayTopBar) viewGroup.a.findViewById(R.id.before_play_top_bar);
        viewGroup.b.setOnClickListener(new at(viewGroup));
        viewGroup.i.a = new au(viewGroup);
        viewGroup.m.setOnBackClickListener(new av(viewGroup));
        this.r.h = new u(this);
        this.r.l = new v(this);
        h();
        layoutInflater = this.A.k();
        if (layoutInflater != null) {
            getLifecycle().a(layoutInflater);
            layoutInflater.b = new w(this);
            this.d.t = layoutInflater;
        }
        if (this.k != null) {
            layoutInflater = this.k.getLayoutParams();
            layoutInflater.height = b;
            this.k.setLayoutParams(layoutInflater);
        }
        this.o = new TwiceClickToConfirm(getActivity(), this.N, getString(R.string.vod_toast_key_back_quit));
        this.o.setOnConfirmListener(new t(this));
        return this.K;
    }

    public void onStart() {
        super.onStart();
        if (this.E != null) {
            this.E.onStart();
        }
    }

    private void g() {
        long a = com.xunlei.downloadprovider.download.util.m.a(this.f.getTaskId());
        if (a > -1 && this.f.getTaskId() != a) {
            a(a, this.h, true);
            if (this.i != null) {
                this.i.a("auto_next");
            }
            this.s.smoothScrollToPosition(0);
        }
    }

    public final void b() {
        if (this.W != null) {
            this.W.dismiss();
            this.W = null;
        }
    }

    private void h() {
        DownloadDetailsBeforePlayController downloadDetailsBeforePlayController = this.r;
        downloadDetailsBeforePlayController.a(-1);
        downloadDetailsBeforePlayController.i.b = 0;
        downloadDetailsBeforePlayController.j = null;
        downloadDetailsBeforePlayController.k = false;
        downloadDetailsBeforePlayController.n = false;
        downloadDetailsBeforePlayController.o = null;
        if (this.i != null) {
            this.i.d(false);
        }
        i();
    }

    public void onResume() {
        super.onResume();
        if (this.y) {
            this.e.a();
            if (this.d != null) {
                this.d.notifyDataSetChanged();
            }
        }
        if (!(this.i == null || !this.j || this.S == null || getActivity() == null || !com.xunlei.xllib.android.d.g(getActivity()))) {
            this.S.enable();
        }
        this.y = false;
        b bVar = this.e;
        if (bVar.b != null) {
            try {
                if (!bVar.b.isAlive()) {
                    bVar.b.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.A != null) {
            this.A.b();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.E != null) {
            this.E.onSaveInstanceState(bundle);
        }
    }

    public void onPause() {
        super.onPause();
        if (!(this.i == null || !this.j || getActivity() == null || getActivity().isFinishing() || this.S == null)) {
            this.S.disable();
        }
        if (this.A != null) {
            this.A.c();
        }
    }

    public void onStop() {
        super.onStop();
        if (this.E != null) {
            this.E.onStop();
        }
        if (this.A != null) {
            this.A.n_();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.A != null) {
            this.A.a(i, i2, intent);
        }
    }

    protected final void c() {
        if (this.f != null) {
            String str = "download_detail_top";
            if ("home_collect_card".equals(this.h)) {
                str = "home_collect_detailtop";
            }
            String str2 = str;
            if (getActivity() != null) {
                this.Y = n.a(getActivity(), str2, this.f, "", "", null, "download_detail_top");
            }
            a("share");
        }
    }

    public final void d() {
        if (isVisible()) {
            if (isAdded()) {
                if (!(this.f == null || this.d == null)) {
                    this.d.f();
                }
            }
        }
    }

    public final DownloadTaskInfo e() {
        return this.f;
    }

    public final void a(long j, String str, boolean z) {
        j = com.xunlei.downloadprovider.download.tasklist.task.h.e().a(j);
        if (j != null) {
            j.i();
            j.j();
            this.M = z;
            this.h = str;
            this.g = j;
            this.f = j.b;
            j = this.e;
            if (j.m != null) {
                j.m.removeMessages(100);
                j.m.sendMessageDelayed(j.m.obtainMessage(100), 1000);
            }
            if (this.f != null) {
                if (this.g != null) {
                    this.x.f = this.g;
                    this.z.c = this.f;
                    this.v.a();
                    this.v.c = k.e(this.f);
                    j = this.v;
                    DownloadTaskInfo downloadTaskInfo = this.f;
                    if (com.xunlei.downloadprovider.download.engine.util.b.f(downloadTaskInfo.getResourceGcid()) == null) {
                        com.xunlei.downloadprovider.download.tasklist.task.h.e().e(downloadTaskInfo.getTaskId());
                    }
                    if (com.xunlei.downloadprovider.download.taskdetails.b.b.a(downloadTaskInfo) != null) {
                        j.b(downloadTaskInfo);
                    } else {
                        j.d();
                        j.a.postDelayed(new com.xunlei.downloadprovider.download.taskdetails.b.n(j, downloadTaskInfo), 500);
                    }
                    this.D.b(k.e(this.f));
                    j = new StringBuilder("showTaskDetail title:");
                    j.append(this.f.mTitle);
                    j.append(" gcid = ");
                    j.append(this.f.getResourceGcid());
                    this.e.a(this.f);
                    this.e.b();
                    this.e.a();
                    boolean z2 = false;
                    b(true, false);
                    if (z) {
                        h();
                        if (this.i != null) {
                            this.i.A();
                        }
                        if (this.A.k() != null) {
                            this.A.k().h_();
                        }
                    }
                    if (this.A.k() != null) {
                        this.A.k().a(this.f);
                    }
                    str = this.r;
                    str.j = this.f;
                    if (!str.n) {
                        str.n = true;
                        str.o = f.b(str.j);
                    }
                    str = this.r;
                    if (str.n) {
                        str = str.o;
                    } else {
                        str = new com.xunlei.downloadprovider.ad.common.report.c(Boolean.valueOf(false), com.xunlei.downloadprovider.ad.common.report.e.a(-1, "you should check ad enabled first"));
                    }
                    if (((Boolean) str.a).booleanValue() == null || this.n != null) {
                        this.r.a(4);
                        str = this.f;
                        if (!(str == null || !k.c(str) || str.getTaskStatus() == 4 || str.getTaskStatus() == true)) {
                            z2 = 1;
                        }
                    }
                    a(true, z2);
                }
            }
        }
    }

    private void a(boolean z, boolean z2) {
        if (k.c(this.f)) {
            this.p = new i(this.f, null, "download_detail_new");
            b(z2);
            if (z) {
                a(this.g);
            }
        } else if (!k.e(this.f) || this.g == null) {
            b(z2);
            if (z) {
                a(this.g);
            }
        } else {
            v.a().a(this.f.mInfoHash, new af(this, z2, z));
        }
    }

    private void b(boolean z) {
        CharSequence charSequence;
        boolean z2 = false;
        if (this.i == null || this.p == null) {
            this.j = false;
            if (this.i) {
                this.i.D();
            }
            charSequence = "";
            this.k.setVisibility(8);
            this.z.a(0);
            this.r.a(4);
        } else {
            this.j = true;
            charSequence = this.f != null ? this.f.mTitle : "";
            this.k.setVisibility(0);
            this.z.a(8);
            if (z) {
                this.r.a(4);
            } else {
                this.r.a(0);
            }
            a(this.p);
            if (this.M && z && this.i != null) {
                this.i.b(false);
            }
            if (z) {
                this.i.a("auto");
                c(z);
            } else {
                this.i.a("manul");
                this.i.C();
                this.i.y();
            }
            if (this.B) {
                v.a().a(this.B);
            }
            if (this.p.b() < false) {
                if (this.u.e) {
                    this.d.b(this.p.b());
                } else {
                    this.C = true;
                }
            }
        }
        z = this.z;
        if (!(charSequence == null || z.a == null)) {
            z.a.setText(charSequence);
        }
        TaskInfo taskInfo = this.f;
        charSequence = this.h;
        boolean a = com.xunlei.downloadprovider.download.taskdetails.b.b.a((DownloadTaskInfo) taskInfo);
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = DispatchConstants.OTHER;
        }
        CharSequence charSequence2 = charSequence;
        String a2 = com.xunlei.downloadprovider.download.engine.report.a.a(taskInfo);
        boolean a3 = TaskDetailFragment.a(taskInfo);
        boolean z3 = (taskInfo.getTaskStatus() == 2 || taskInfo.getTaskStatus() == 1) && !taskInfo.mHasVipChannelSpeedup;
        if (this.j && this.p != null) {
            z2 = this.p.g() ? true : true;
        }
        com.xunlei.downloadprovider.download.report.a.a(taskInfo.mTitle, charSequence2, z3, a2, a3, a, z2);
    }

    private void i() {
        int i = this.r.g;
        if (i == -1 || i == 4) {
            this.r.b(8);
            this.J.setVisibility(0);
            return;
        }
        this.J.setVisibility(8);
        this.r.b(0);
    }

    private void j() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    private void a(s sVar) {
        b bVar = this.u;
        bVar.d = sVar;
        TaskInfo taskInfo = null;
        boolean z = false;
        if (sVar != null) {
            bVar.c = sVar.b;
            b bVar2 = bVar.a;
            TaskSpeedCountInfo a = sVar.a(true);
            bVar2.f = a;
            if (bVar2.a != null) {
                bVar2.a.c = a;
            }
            bVar2 = bVar.a;
            DownloadTaskInfo downloadTaskInfo = sVar.b;
            if (bVar2.a != null) {
                bVar2.a.d = downloadTaskInfo;
            }
            if (bVar2.b != null) {
                bVar2.b.d = downloadTaskInfo;
            }
            if (bVar2.c != null) {
                bVar2.c.d = downloadTaskInfo;
            }
            if (bVar2.d != null) {
                bVar2.d.d = downloadTaskInfo;
            }
            if (bVar2.e != null) {
                bVar2.e.d = downloadTaskInfo;
            }
            a aVar = bVar.b;
            a = sVar.a(false);
            aVar.f = a;
            if (aVar.a != null) {
                aVar.a.c = a;
            }
            aVar = bVar.b;
            downloadTaskInfo = sVar.b;
            if (aVar.a != null) {
                aVar.a.d = downloadTaskInfo;
            }
            if (aVar.b != null) {
                aVar.b.d = downloadTaskInfo;
            }
            if (aVar.c != null) {
                aVar.c.d = downloadTaskInfo;
            }
            if (!(aVar.l == null || aVar.l.isEmpty())) {
                Iterator it = aVar.l.iterator();
                while (it.hasNext()) {
                    ((com.xunlei.downloadprovider.download.taskdetails.items.a.a) it.next()).d = downloadTaskInfo;
                }
            }
            if (aVar.e != null) {
                aVar.e.d = downloadTaskInfo;
            }
            if (k.e(bVar.c)) {
                bVar.f = bVar.b;
            } else {
                bVar.f = bVar.a;
            }
        } else {
            bVar.c = null;
        }
        if (sVar != null) {
            taskInfo = sVar.b;
        }
        TaskInfo taskInfo2 = taskInfo;
        bVar.a.a = new com.xunlei.downloadprovider.download.taskdetails.items.a.a(14, taskInfo2, null, -1);
        bVar.b.a = bVar.a.a;
        bVar.a.c = new com.xunlei.downloadprovider.download.taskdetails.items.a.a(15, taskInfo2, null, -1);
        bVar.b.b = bVar.a.c;
        bVar.a.b = new com.xunlei.downloadprovider.download.taskdetails.items.a.a(3, taskInfo2, null, -1);
        bVar.a.d = new com.xunlei.downloadprovider.download.taskdetails.items.a.a(5, taskInfo2, null, -1);
        bVar.b.c = bVar.a.d;
        bVar.a.e = new com.xunlei.downloadprovider.download.taskdetails.items.a.a(16, taskInfo2, null, -1);
        bVar.b.e = bVar.a.e;
        bVar.b.d = new com.xunlei.downloadprovider.download.taskdetails.items.a.a(17, taskInfo2, null, -1);
        if (k.e(taskInfo)) {
            bVar.f = bVar.b;
        } else {
            bVar.f = bVar.a;
        }
        bVar.b.j.clear();
        bVar.b.k.clear();
        bVar.b.j.add(bVar.b.a);
        bVar.b.j.add(bVar.b.b);
        bVar.b.j.add(bVar.b.e);
        bVar.b.j.add(bVar.b.d);
        if (b.a(sVar.b)) {
            bVar.b.j.add(bVar.b.c);
        }
        bVar.a.j.clear();
        bVar.a.j.add(bVar.a.a);
        bVar.a.j.add(bVar.a.c);
        if (sVar != null) {
            taskInfo = sVar.b;
            if (!k.d(taskInfo) && l.a().b() && (k.a(taskInfo) || k.b(taskInfo))) {
                z = true;
            }
        }
        if (z) {
            bVar.a.j.add(bVar.a.b);
        }
        bVar.a.j.add(bVar.a.e);
        if (b.a(sVar.b) != null) {
            bVar.a.j.add(bVar.a.d);
        }
        sVar = this.u.f;
        List list = sVar.j;
        sVar = sVar.k;
        sVar.add(new com.xunlei.downloadprovider.download.taskdetails.items.a.a(7, null, Integer.valueOf(80), 0));
        this.d.b(list, sVar);
    }

    private void k() {
        this.d.b(true);
    }

    private void a(String str) {
        com.xunlei.downloadprovider.download.report.a.a(str, this.f);
    }

    private void l() {
        if (this.i != null) {
            if (this.i.u()) {
                this.r.a(4);
                c(true);
                this.i.b(false);
            } else if (com.xunlei.xllib.android.b.f(getContext())) {
                this.r.a(4);
                c(true);
                this.i.b(false);
            } else {
                this.i.a(new ak(this), getContext());
            }
        }
    }

    private void m() {
        if (this.n) {
            this.n = false;
            new StringBuilder("outFullScreen, 播放器恢复高度：").append(this.aa);
            if (this.l.getSurfaceView() != null) {
                this.l.getSurfaceView().getLayoutParams().width = this.ab;
                this.l.getSurfaceView().getLayoutParams().height = this.ac;
                this.l.getSurfaceView().requestLayout();
            }
            this.k.getLayoutParams().height = this.aa;
            this.k.requestLayout();
            if (this.i != null) {
                this.i.k = this.X;
            }
            if (this.A != null) {
                com.xunlei.downloadprovider.download.player.a.a(getActivity(), this.A, false);
            }
        }
    }

    private void n() {
        com.xunlei.downloadprovider.download.taskdetails.a.b bVar = this.u.b;
        aw awVar = this.x;
        int size = bVar.a().size();
        boolean d = bVar.d();
        if (size <= 0) {
            awVar.e.b();
            awVar.c.setTitle("请选择文件");
        } else {
            awVar.e.c();
            DownloadCenterSelectFileTitleView downloadCenterSelectFileTitleView = awVar.c;
            StringBuilder stringBuilder = new StringBuilder("已选择");
            stringBuilder.append(size);
            stringBuilder.append("个项目");
            downloadCenterSelectFileTitleView.setTitle(stringBuilder.toString());
        }
        awVar.c.a(d ^ 1);
    }

    public final void a() {
        n();
    }

    private void c(boolean z) {
        if (this.i != null) {
            this.i.c(z);
            if (z) {
                if (!this.S) {
                    z = getActivity();
                    if (!z) {
                        z = BrothersApplication.getApplicationInstance();
                    }
                    if (z) {
                        this.S = new a(this, z);
                    }
                }
                if (this.S) {
                    this.S.enable();
                }
            }
        }
    }

    private void a(BTSubTaskItem bTSubTaskItem, boolean z) {
        i iVar = new i(this.f, bTSubTaskItem, "download_detail_new");
        if (this.B == null) {
            this.B = new com.xunlei.downloadprovider.database.a.a();
            this.B.c = this.f.mInfoHash;
            this.B.b = this.f.getTaskId();
        }
        this.B.d = bTSubTaskItem.mBTSubIndex;
        v.a().a(this.B);
        this.r.a(4);
        a(iVar);
        if (this.i != null) {
            this.i.a("auto_next");
        }
        if (z) {
            c(true);
            if (this.i) {
                this.i.b(false);
                return;
            }
        }
        c(false);
    }

    private void a(i iVar) {
        if (iVar != null && this.i != null) {
            this.p = iVar;
            m mVar = this.i;
            Object obj = (mVar.a == null || !mVar.a.q()) ? null : 1;
            if (obj == null) {
                this.i.A();
            }
            this.i.a(iVar);
            if (this.L == null) {
                this.L = new ap(this);
                c.a(getContext(), "float_player_close_action", this.L);
                c.a(getContext(), "float_player_open_action", this.L);
            }
        }
    }

    public void onDestroy() {
        com.xunlei.downloadprovider.download.report.a.a(this.E != null ? this.E.getDuration() : 0);
        b bVar = this.e;
        bVar.f = true;
        bVar.m.removeCallbacksAndMessages(null);
        bVar.b();
        if (bVar.b != null && bVar.b.isAlive()) {
            try {
                bVar.b.a.sendEmptyMessage(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        bVar.k = null;
        bVar.l = null;
        if (this.A != null) {
            this.A.d();
            this.A = null;
        }
        this.i = null;
        if (this.v != null) {
            this.v.c();
            this.v.b = null;
        }
        if (this.S != null) {
            this.S.disable();
            this.S = null;
        }
        if (this.Y != null && this.Y.isShowing()) {
            this.Y.dismiss();
            this.Y = null;
        }
        if (this.I != null) {
            this.I.removeCallbacksAndMessages(null);
        }
        c.a(getContext(), this.V);
        c.a(getContext(), this.U);
        if (this.L != null) {
            c.a(getContext(), this.L);
        }
        com.xunlei.downloadprovider.broadcast.a a = com.xunlei.downloadprovider.broadcast.a.a();
        BroadcastReceiver broadcastReceiver = this.T;
        com.xunlei.downloadprovider.broadcast.a.a aVar = a.a;
        if (!(broadcastReceiver == null || aVar.b.isEmpty())) {
            Iterator it = aVar.b.iterator();
            while (it.hasNext()) {
                if (broadcastReceiver.equals(((a$a$b) it.next()).a)) {
                    it.remove();
                    StringBuilder stringBuilder = new StringBuilder("unregisterReceiver(");
                    stringBuilder.append(aVar.b.size());
                    stringBuilder.append("):");
                    stringBuilder.append(broadcastReceiver);
                }
            }
        }
        if (this.i != null) {
            this.i.b(this.O);
        }
        super.onDestroy();
    }

    private void b(boolean z, boolean z2) {
        if (this.d.g) {
            this.D.a((int) true);
            return;
        }
        if (k.e(this.f)) {
            this.d.h();
        }
        this.v.a(z, z2, this.d);
    }

    public final void a(boolean z) {
        if (z) {
            this.k.setVisibility(8);
            this.z.a(8);
            this.x.a(true);
            this.d.e();
            b(false, false);
            this.v.a(false);
            n();
            this.D.a(8);
            if (this.i) {
                this.F = this.i.E();
                if (this.F) {
                    this.i.C();
                }
            }
            this.r.b(8);
            this.r.b();
            return;
        }
        if (this.j) {
            if (this.F && this.i) {
                this.i.B();
            }
            this.k.setVisibility(0);
            this.r.b(0);
            this.r.a();
        } else {
            this.z.a(0);
        }
        this.x.a(false);
        z = this.u.b.j;
        List list = this.u.b.k;
        this.u.b.a(false);
        this.d.b(z, list);
        this.v.a(true);
        b(false, false);
        z = this.D;
        if (z.b && z.c) {
            z.a(0);
        }
        this.s.postDelayed(new ah(this), 200);
    }

    public final boolean a(BTSubTaskItem bTSubTaskItem) {
        if (!this.j || this.f == null || bTSubTaskItem == null) {
            return false;
        }
        if (this.p == null || !bTSubTaskItem.equals(this.p.b)) {
            a(bTSubTaskItem, true);
        } else if (this.i != null) {
            this.r.a(4);
            c(true);
            this.i.b(false);
        }
        return true;
    }

    static /* synthetic */ void g(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        if (downloadDetailsActivityFragment.p == null || !downloadDetailsActivityFragment.p.e()) {
            if (downloadDetailsActivityFragment.i != null) {
                downloadDetailsActivityFragment.i.G();
            }
            if (!downloadDetailsActivityFragment.n) {
                downloadDetailsActivityFragment.n = true;
                if (downloadDetailsActivityFragment.m != null && downloadDetailsActivityFragment.m.isStarted()) {
                    downloadDetailsActivityFragment.m.cancel();
                }
                downloadDetailsActivityFragment.aa = downloadDetailsActivityFragment.k.getLayoutParams().height;
                if (downloadDetailsActivityFragment.l.getSurfaceView() != null) {
                    downloadDetailsActivityFragment.ab = downloadDetailsActivityFragment.l.getSurfaceView().getWidth();
                    downloadDetailsActivityFragment.ac = downloadDetailsActivityFragment.l.getSurfaceView().getHeight();
                }
                new StringBuilder("enterFullScreen, 设置全屏，保存高度：").append(downloadDetailsActivityFragment.aa);
                downloadDetailsActivityFragment.k.getLayoutParams().height = -1;
                downloadDetailsActivityFragment.k.requestLayout();
                if (downloadDetailsActivityFragment.Y != null && downloadDetailsActivityFragment.Y.isShowing()) {
                    downloadDetailsActivityFragment.Y.dismiss();
                    downloadDetailsActivityFragment.Y = null;
                }
                if (downloadDetailsActivityFragment.z != null) {
                    d dVar = downloadDetailsActivityFragment.z;
                    if (dVar.b != null && dVar.b.isShowing()) {
                        dVar.b.dismiss();
                        dVar.b = null;
                    }
                }
                if (downloadDetailsActivityFragment.A != null) {
                    com.xunlei.downloadprovider.download.player.a.a(downloadDetailsActivityFragment.getActivity(), downloadDetailsActivityFragment.A, true);
                }
            }
        }
    }

    static /* synthetic */ void i(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        if (downloadDetailsActivityFragment.i != null && downloadDetailsActivityFragment.i.E()) {
            long M = downloadDetailsActivityFragment.i.M();
            com.xunlei.downloadprovider.download.engine.task.n.a();
            z e = com.xunlei.downloadprovider.download.engine.task.n.e(M);
            if (e == null) {
                return;
            }
            if (e == null || e.b() != 8) {
                downloadDetailsActivityFragment.i.C();
                CharSequence string = downloadDetailsActivityFragment.getString(R.string.vod_wifi_notify_tag_has_mobile);
                CharSequence string2 = downloadDetailsActivityFragment.getString(R.string.vod_wifi_notify_btn_continue);
                CharSequence string3 = downloadDetailsActivityFragment.getString(R.string.vod_wifi_notify_btn_cancel);
                DialogInterface.OnClickListener arVar = new ar(downloadDetailsActivityFragment, M);
                DialogInterface.OnClickListener mVar = new m(downloadDetailsActivityFragment);
                OnCancelListener nVar = new n(downloadDetailsActivityFragment);
                if (downloadDetailsActivityFragment.W != null && downloadDetailsActivityFragment.W.isShowing()) {
                    downloadDetailsActivityFragment.W.dismiss();
                }
                downloadDetailsActivityFragment.W = new XLAlertDialog(downloadDetailsActivityFragment.getContext());
                downloadDetailsActivityFragment.W.setConfirmButtonTextColor(downloadDetailsActivityFragment.getResources().getColor(R.color.global_text_color_2));
                downloadDetailsActivityFragment.W.setCancelable(false);
                downloadDetailsActivityFragment.W.setCanceledOnTouchOutside(false);
                downloadDetailsActivityFragment.W.setMessage(string);
                downloadDetailsActivityFragment.W.setCancelButtonText(string2);
                downloadDetailsActivityFragment.W.setOnClickCancelButtonListener(arVar);
                downloadDetailsActivityFragment.W.setConfirmButtonText(string3);
                downloadDetailsActivityFragment.W.setOnClickConfirmButtonListener(mVar);
                downloadDetailsActivityFragment.W.setOnCancelListener(nVar);
                downloadDetailsActivityFragment.W.setCancelable(true);
                if (!downloadDetailsActivityFragment.W.isShowing()) {
                    downloadDetailsActivityFragment.W.show();
                }
            }
        }
    }

    static /* synthetic */ void l(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        if (downloadDetailsActivityFragment.e != null) {
            if (downloadDetailsActivityFragment.i != null) {
                BTSubTaskInfo bTSubTaskInfo;
                ArrayList arrayList = downloadDetailsActivityFragment.e.e;
                m mVar = downloadDetailsActivityFragment.i;
                BTSubTaskItem bTSubTaskItem = null;
                if (mVar.b == null) {
                    bTSubTaskInfo = null;
                } else {
                    bTSubTaskInfo = mVar.b.b;
                }
                boolean z = false;
                if (!com.xunlei.xllib.b.d.a(arrayList)) {
                    if (bTSubTaskInfo != null) {
                        int i = 0;
                        while (i < arrayList.size()) {
                            BTSubTaskItem bTSubTaskItem2 = (BTSubTaskItem) arrayList.get(i);
                            if (bTSubTaskItem2 == null || bTSubTaskItem2.mBTSubIndex != bTSubTaskInfo.mBTSubIndex) {
                                i++;
                            } else if (i != arrayList.size() - 1) {
                                while (!com.xunlei.xllib.b.d.a(arrayList) && i < arrayList.size() - 1) {
                                    i++;
                                    BTSubTaskItem bTSubTaskItem3 = (BTSubTaskItem) arrayList.get(i);
                                    if (bTSubTaskItem3 != null) {
                                        if (!TextUtils.isEmpty(bTSubTaskItem3.mLocalFileName)) {
                                            File file = new File(bTSubTaskItem3.mLocalFileName);
                                            if (bTSubTaskItem3 != null && k.c(bTSubTaskItem3) && file.exists()) {
                                                bTSubTaskItem = bTSubTaskItem3;
                                                break;
                                            }
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                if (bTSubTaskItem == null) {
                    downloadDetailsActivityFragment.g();
                    return;
                }
                if (!(downloadDetailsActivityFragment.f == null || downloadDetailsActivityFragment.f.getTaskStatus() == 4 || downloadDetailsActivityFragment.f.getTaskStatus() == 16)) {
                    z = true;
                }
                downloadDetailsActivityFragment.a(bTSubTaskItem, z);
                return;
            }
        }
        downloadDetailsActivityFragment.g();
    }

    static /* synthetic */ boolean n(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        if (downloadDetailsActivityFragment.r == null || downloadDetailsActivityFragment.r.g == 4) {
            return false;
        }
        return true;
    }

    static /* synthetic */ void a(DownloadDetailsActivityFragment downloadDetailsActivityFragment, DownloadTaskInfo downloadTaskInfo) {
        if (downloadTaskInfo != null) {
            if (k.d(downloadTaskInfo)) {
                if (k.g(downloadTaskInfo)) {
                    downloadDetailsActivityFragment.a("finish_install");
                } else if (k.a(downloadTaskInfo)) {
                    downloadDetailsActivityFragment.a("finish_play");
                } else {
                    downloadDetailsActivityFragment.a("finish_open");
                }
                if (!k.c(downloadTaskInfo)) {
                    downloadDetailsActivityFragment.w.b((TaskInfo) downloadTaskInfo);
                    return;
                } else if (downloadDetailsActivityFragment.i == null || !downloadDetailsActivityFragment.j) {
                    downloadDetailsActivityFragment.w.a((TaskInfo) downloadTaskInfo, "", "download_detail_new");
                    return;
                } else {
                    downloadDetailsActivityFragment.r.a(4);
                    downloadDetailsActivityFragment.c(true);
                    downloadDetailsActivityFragment.i.b(null);
                    return;
                }
            }
            downloadDetailsActivityFragment.l();
            downloadDetailsActivityFragment.a("dl_bxbb");
        }
    }

    static /* synthetic */ void t(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        downloadDetailsActivityFragment.o.reset();
        if (downloadDetailsActivityFragment.n) {
            downloadDetailsActivityFragment.m();
        } else {
            downloadDetailsActivityFragment.j();
        }
    }

    static /* synthetic */ void x(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        String str = downloadDetailsActivityFragment.f.mUrl;
        downloadDetailsActivityFragment.a("dl_more_bt_add");
        String f = k.f(downloadDetailsActivityFragment.f);
        if (downloadDetailsActivityFragment.getActivity() != null) {
            DownloadBtFileExplorerActivity.a(downloadDetailsActivityFragment.getActivity(), str, f, downloadDetailsActivityFragment.g.a(), 2074, "download_detail_new", downloadDetailsActivityFragment.f.mRefUrl, downloadDetailsActivityFragment.f.mWebsiteName);
        }
    }

    static /* synthetic */ void y(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        downloadDetailsActivityFragment.k();
        downloadDetailsActivityFragment.a("dl_more_bt_delete");
    }

    static /* synthetic */ void z(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        if (downloadDetailsActivityFragment.f != null) {
            long j;
            long j2;
            com.xunlei.downloadprovider.download.center.widget.z zVar;
            if (!downloadDetailsActivityFragment.f.mIsFileMissing) {
                if (downloadDetailsActivityFragment.f.mDownloadedSize != 0) {
                    j = downloadDetailsActivityFragment.f.mDownloadedSize;
                    j2 = j;
                    if (downloadDetailsActivityFragment.f.getTaskStatus() != 8) {
                        zVar = new com.xunlei.downloadprovider.download.center.widget.z(downloadDetailsActivityFragment.getContext(), 1, 0, j2);
                    } else {
                        zVar = new com.xunlei.downloadprovider.download.center.widget.z(downloadDetailsActivityFragment.getContext(), 0, 1, j2);
                    }
                    if (!(downloadDetailsActivityFragment.f == null || downloadDetailsActivityFragment.f.getTaskStatus() == 8)) {
                        r0.setCheckStr(null);
                    }
                    r0.setBtnLeftClickListener(new ai(downloadDetailsActivityFragment, r0));
                    r0.setBtnRightClickListener(new aj(downloadDetailsActivityFragment, r0));
                    r0.show();
                    downloadDetailsActivityFragment.a("dl_more_delete");
                }
            }
            j = 1;
            j2 = j;
            if (downloadDetailsActivityFragment.f.getTaskStatus() != 8) {
                zVar = new com.xunlei.downloadprovider.download.center.widget.z(downloadDetailsActivityFragment.getContext(), 0, 1, j2);
            } else {
                zVar = new com.xunlei.downloadprovider.download.center.widget.z(downloadDetailsActivityFragment.getContext(), 1, 0, j2);
            }
            r0.setCheckStr(null);
            r0.setBtnLeftClickListener(new ai(downloadDetailsActivityFragment, r0));
            r0.setBtnRightClickListener(new aj(downloadDetailsActivityFragment, r0));
            r0.show();
            downloadDetailsActivityFragment.a("dl_more_delete");
        }
    }
}
