package com.xunlei.downloadprovider.download.player.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.View.OnClickListener;
import com.qihoo360.replugin.RePlugin;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.dialog.k;
import com.xunlei.downloadprovider.download.downloadvod.TaskPlayInfo;
import com.xunlei.downloadprovider.download.downloadvod.a.d;
import com.xunlei.downloadprovider.download.downloadvod.i;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskRangeInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.engine.task.z;
import com.xunlei.downloadprovider.download.player.PlayProgressRanges;
import com.xunlei.downloadprovider.download.player.a;
import com.xunlei.downloadprovider.download.player.b;
import com.xunlei.downloadprovider.download.player.views.DownloadVodPlayerView;
import com.xunlei.downloadprovider.download.player.views.backgroundlayer.PlayerBackgroundLayerViewGroup;
import com.xunlei.downloadprovider.download.player.views.bottom.PlayerBottomViewGroup;
import com.xunlei.downloadprovider.vod.floatwindow.VodPlayerFloatWindowService;
import com.xunlei.downloadprovider.vod.manager.PlayerConfigPersistManager;
import com.xunlei.downloadprovider.vod.manager.PlayerConfigPersistManager.ConfigPersistData;
import com.xunlei.downloadprovider.vod.subtitle.SubtitleManifest;
import com.xunlei.downloadprovider.vodnew.VodPlayerActivityNew;
import com.xunlei.downloadprovider.vodnew.a.b.j;
import com.xunlei.downloadprovider.vodnew.a.d.c;
import com.xunlei.downloadprovider.vodnew.a.e.o;
import com.xunlei.downloadprovider.vodnew.a.e.o.e;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: DownloadVodPlayerController */
public class m extends f implements b {
    private static XLAlertDialog A = null;
    private static final String m = "m";
    private long B = 0;
    private long C = System.currentTimeMillis();
    private long D = this.C;
    private XLAlertDialog E = null;
    public c a;
    public i b;
    public a c;
    public boolean d = false;
    public int g = 0;
    public boolean h = false;
    List<e> i = new CopyOnWriteArrayList();
    public OnClickListener j;
    public OnClickListener k;
    int l = 0;
    private boolean n = false;
    private boolean o;
    private long p;
    private long q = 0;
    private final com.xunlei.downloadprovider.download.player.c r = new com.xunlei.downloadprovider.download.player.c();
    private long s;
    private Handler t = new Handler(Looper.getMainLooper());
    private long u = 0;
    private long v = 0;
    private int w = 0;
    private long x = 0;
    private boolean y = false;
    private Runnable z = new n(this);

    public final void a(String str) {
        if (this.r != null) {
            this.r.j = str;
        }
    }

    private void R() {
        this.t.removeCallbacks(this.z);
    }

    public m(a aVar, DownloadVodPlayerView downloadVodPlayerView) {
        super(aVar, downloadVodPlayerView);
        SurfaceView surfaceView = downloadVodPlayerView.getSurfaceView();
        c jVar = new j(new com.xunlei.downloadprovider.vodnew.a.b.a(new o()));
        jVar.a(surfaceView);
        jVar.c(false);
        jVar.a(209, "1");
        jVar.a(504, "0");
        jVar.a(501, "1");
        jVar.a(202, "0");
        this.a = jVar;
        this.e = downloadVodPlayerView;
        if (this.e != null) {
            this.e.setPlayerController(this);
            this.e.setViewEventListener(new w(this));
            this.e.setOnGestureListener(new x(this));
        }
        aVar = this.a;
        aVar.a(new ac(this));
        aVar.a(new o(this));
        aVar.a(new p(this));
        aVar.a(new q(this));
        aVar.a(new r(this));
        aVar.a(new s(this));
        this.s = System.currentTimeMillis();
        this.r.l = this;
    }

    public final String m() {
        String str = "";
        if (this.b == null) {
            return str;
        }
        str = this.b.c();
        return str != null ? str : "";
    }

    public final String r() {
        if (this.b == null) {
            return "";
        }
        i iVar = this.b;
        return iVar.c != null ? iVar.c.mGCID : "";
    }

    public final void s() {
        if (this.e != null && this.e.getPlayerTopViewGroup() != null) {
            this.e.getPlayerTopViewGroup().setTitleVisible(false);
        }
    }

    public final boolean t() {
        return q() != null ? q().i() : false;
    }

    public final boolean u() {
        if (this.b == null) {
            return false;
        }
        TaskInfo taskInfo = this.b.a;
        BTSubTaskInfo bTSubTaskInfo = this.b.b;
        if (taskInfo == null) {
            if (bTSubTaskInfo == null) {
                return true;
            }
        }
        if (bTSubTaskInfo != null && bTSubTaskInfo.mTaskStatus == 8) {
            return true;
        }
        if (taskInfo == null || taskInfo.getTaskStatus() != 8) {
            return false;
        }
        return true;
    }

    private void e(boolean z) {
        Context context = this.e.getContext();
        int k_ = k_();
        TaskPlayInfo taskPlayInfo = this.b.c;
        if (taskPlayInfo != null) {
            HashMap j = this.a.j();
            SubtitleManifest subtitleManifest = null;
            if (h() != null) {
                subtitleManifest = h().c;
            }
            VodPlayerFloatWindowService.a(context, taskPlayInfo, k_, j, z, subtitleManifest);
            com.xunlei.downloadprovider.player.a.a(r(), "long_video", "float_window");
            if (this.c) {
                this.c.b();
            }
            v();
        }
    }

    public final void v() {
        if (!this.f && this.e != null) {
            DownloadVodPlayerView downloadVodPlayerView = this.e;
            downloadVodPlayerView.c.a();
            PlayerBackgroundLayerViewGroup playerBackgroundLayerViewGroup = downloadVodPlayerView.c;
            playerBackgroundLayerViewGroup.b.setVisibility(0);
            playerBackgroundLayerViewGroup.c.setVisibility(0);
            playerBackgroundLayerViewGroup.d.setVisibility(0);
            downloadVodPlayerView.b.setGestureViewVisible(false);
            downloadVodPlayerView.e();
            downloadVodPlayerView.b.a();
            downloadVodPlayerView.n();
            downloadVodPlayerView.b();
        }
    }

    public final void w() {
        DownloadVodPlayerView downloadVodPlayerView = this.e;
        PlayerBackgroundLayerViewGroup playerBackgroundLayerViewGroup = downloadVodPlayerView.c;
        playerBackgroundLayerViewGroup.b.setVisibility(8);
        playerBackgroundLayerViewGroup.c.setVisibility(8);
        playerBackgroundLayerViewGroup.d.setVisibility(8);
        downloadVodPlayerView.b.setGestureViewVisible(true);
        downloadVodPlayerView.setViewState(downloadVodPlayerView.getViewState());
    }

    public final void x() {
        if (!(this.e == null || this.e.getPlayerLeftViewGroup() == null)) {
            if (this.e.getPlayerLeftViewGroup().getVisibility() == 0) {
                this.e.getPlayerLeftViewGroup().a();
                a.a(p(), false, true);
                return;
            }
            this.e.getPlayerLeftViewGroup().b();
            XLToast.showToast(n(), "屏幕已锁定，点击图标解锁");
            if (!this.a.v()) {
                this.e.j();
            }
            a.a(p(), true, true);
        }
    }

    private boolean S() {
        return this.e != null && this.e.g();
    }

    public final void y() {
        if (this.e != null && !this.a.v()) {
            this.e.e();
        }
    }

    public final void z() {
        this.a.b(true);
    }

    public final void A() {
        this.a.h();
        this.a.a(false);
        if (this.e != null) {
            DownloadVodPlayerView downloadVodPlayerView = this.e;
            downloadVodPlayerView.a.a = 0;
            downloadVodPlayerView.a.b = 0;
            downloadVodPlayerView.a.c = 0;
            downloadVodPlayerView.a(0, 0, 0);
            this.e.setViewState(0);
        }
    }

    private void T() {
        if (!(p() == null || n() == null)) {
            a p = p();
            Context n = n();
            String r = r();
            CharSequence m = m();
            if (p.a != null) {
                Serializable serializable = p.a;
                if (TextUtils.isEmpty(r)) {
                    if (!TextUtils.isEmpty(m)) {
                        r = m;
                    } else {
                        return;
                    }
                }
                com.xunlei.downloadprovider.vod.b.b.a(serializable, PlayerConfigPersistManager.a(n), r);
            }
        }
    }

    public final void a(i iVar) {
        if (a() != null) {
            T();
        }
        this.y = false;
        this.b = iVar;
        iVar = this.r;
        iVar.c = this.b;
        iVar.d = iVar.c.a;
        iVar.e = iVar.c.b;
        this.a.a(this.b);
        iVar = this.b.c();
        if (this.e != null) {
            this.e.setTitle(iVar);
        }
        if (!(p() == null || n() == null)) {
            iVar = p();
            Context n = n();
            Object r = r();
            Object m = m();
            if (iVar.a == null) {
                String a = PlayerConfigPersistManager.a(n);
                ConfigPersistData configPersistData = null;
                if (TextUtils.isEmpty(r) || !new File(a, r).exists()) {
                    r = null;
                }
                if (r == null && !TextUtils.isEmpty(m) && new File(a, m).exists()) {
                    r = m;
                }
                if (!TextUtils.isEmpty(r)) {
                    configPersistData = (ConfigPersistData) com.xunlei.downloadprovider.vod.b.b.a(a, r);
                }
                iVar.a = configPersistData;
                if (iVar.a == null) {
                    iVar.a = new ConfigPersistData();
                }
            }
        }
        if (i() != null) {
            i().a(this.b.a != null ? this.b.a.getTaskId() : -1);
        }
        this.e.a(0, 0, 0);
        this.h = false;
        if (j() != null) {
            j().b(false);
            this.x = 0;
            this.y = false;
        }
    }

    private void f(boolean z) {
        this.n = z;
        z = this.r;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        z.f = stringBuilder.toString();
        z.b = System.currentTimeMillis();
        z.a = 0;
        z.k = 0;
        z.h = 0;
        z.g = false;
        if (this.b) {
            this.o = false;
            this.p = SystemClock.elapsedRealtime();
            if (this.e) {
                this.e.setPlayAudioOnly(this.b.e());
                this.e.setViewState(1);
                if (!this.b.g()) {
                    this.e.setLoadingText(this.e.getResources().getString(R.string.vod_player_bxbb_loading_text));
                }
            }
            this.u = 0;
            if (this.a) {
                this.a.d();
            }
        }
    }

    public final void a(int i, String str) {
        if (this.a != null) {
            this.a.a(i, str);
        }
    }

    public final void b(boolean z) {
        if (this.b != null) {
            TaskPlayInfo taskPlayInfo = this.b.c;
            if (taskPlayInfo != null) {
                a(taskPlayInfo.mTaskId, taskPlayInfo.mBtSubIndex, z);
            }
        }
    }

    public static void a(Context context, TaskInfo taskInfo, BTSubTaskInfo bTSubTaskInfo, String str) {
        boolean z = (bTSubTaskInfo == null || bTSubTaskInfo.mTaskStatus == 8) ? false : true;
        if (!(taskInfo == null || taskInfo.getTaskStatus() == 8)) {
            z = true;
        }
        long taskId = taskInfo != null ? taskInfo.getTaskId() : -1;
        int i = bTSubTaskInfo != null ? bTSubTaskInfo.mBTSubIndex : -1;
        if (z) {
            if (!com.xunlei.xllib.android.b.a(context)) {
                XLToast.showToast(context, context.getString(R.string.net_disable));
                return;
            } else if (com.xunlei.xllib.android.b.f(context)) {
                a(taskId, i, false);
            } else {
                XLAlertDialog xLAlertDialog = new XLAlertDialog(context);
                A = xLAlertDialog;
                xLAlertDialog.setMessage(context.getString(R.string.vod_wifi_notify_tag_has_mobile));
                A.setConfirmButtonText(context.getString(R.string.vod_wifi_notify_btn_continue));
                A.setCanceledOnTouchOutside(true);
                A.setOnClickConfirmButtonListener(new aa(taskId, i, context, taskInfo, bTSubTaskInfo, str));
                A.setOnClickCancelButtonListener(new ab());
                A.show();
                return;
            }
        }
        VodPlayerActivityNew.a(context, taskInfo, bTSubTaskInfo, str);
    }

    public static void a(long j, int i, boolean z) {
        n.a();
        z e = n.e(j);
        if (e != null) {
            int i2;
            String str;
            BTSubTaskInfo bTSubTaskInfo = null;
            if (i >= 0) {
                bTSubTaskInfo = e.b(i);
            }
            if (e.b() != 4) {
                if (e.b() != 16) {
                    i2 = 0;
                    if (i2 == 0) {
                        n.a();
                        n.b(z, j);
                    } else if (e.b() != 1 && e.e()) {
                        if (bTSubTaskInfo == null) {
                            str = bTSubTaskInfo.mLocalFileName;
                        } else {
                            str = e.c().mLocalFileName;
                        }
                        if (!com.xunlei.downloadprovider.h.e.c(str)) {
                            n.a();
                            n.a(z, j);
                        }
                    }
                    if (bTSubTaskInfo == null) {
                        if (bTSubTaskInfo.mTaskStatus != 8) {
                            n.a().a(j, (long) i);
                        }
                    } else if (e.b() != 8) {
                        n.a().c(j);
                    }
                }
            }
            i2 = 1;
            if (i2 == 0) {
                if (bTSubTaskInfo == null) {
                    str = e.c().mLocalFileName;
                } else {
                    str = bTSubTaskInfo.mLocalFileName;
                }
                if (com.xunlei.downloadprovider.h.e.c(str)) {
                    n.a();
                    n.a(z, j);
                }
            } else {
                n.a();
                n.b(z, j);
            }
            if (bTSubTaskInfo == null) {
                if (e.b() != 8) {
                    n.a().c(j);
                }
            } else if (bTSubTaskInfo.mTaskStatus != 8) {
                n.a().a(j, (long) i);
            }
        }
    }

    private void U() {
        if (this.b != null) {
            if (this.b.c != null) {
                n.a().c(-1);
            }
            this.b.h();
        }
    }

    public final void B() {
        if (this.o) {
            this.e.setViewState(1);
        } else {
            this.e.setViewState(2);
        }
        if (this.a != null) {
            this.a.z();
            this.a.e();
            this.a.a(true);
            com.xunlei.downloadprovider.download.player.c cVar = this.r;
            if (cVar.k == 0) {
                cVar.k = System.currentTimeMillis();
            }
            this.v = System.currentTimeMillis();
        }
        if (!this.a.v()) {
            this.e.j();
        }
        this.t.removeCallbacks(this.z);
        this.t.postDelayed(this.z, 1000);
    }

    public final void C() {
        this.e.setViewState(3);
        if (this.a != null) {
            this.a.f();
            this.a.a(false);
        }
        R();
        V();
    }

    private void V() {
        if (this.v != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.v > 0) {
                this.u += currentTimeMillis - this.v;
            }
        }
    }

    public final void D() {
        if (this.v > 0 && E()) {
            V();
        }
        if (this.a != null) {
            this.a.g();
            this.a.a(false);
            if (this.e != null) {
                this.e.k();
            }
        }
        if (this.e != null) {
            this.e.f();
            this.e.setViewState(3);
            this.e.k();
        }
        R();
    }

    public final void a(int i) {
        this.w = i;
        if (this.a != null) {
            this.a.a(i);
            W();
        }
    }

    public final int k_() {
        return this.a != null ? this.a.o() : 0;
    }

    public final int e() {
        return this.a != null ? this.a.n() : 0;
    }

    public final boolean E() {
        return this.a != null && this.a.t();
    }

    public final boolean F() {
        return this.a != null && this.a.u();
    }

    public final boolean l_() {
        return this.a != null && this.a.w();
    }

    public final boolean m_() {
        return this.a != null && this.a.x();
    }

    public final void c() {
        this.a.A();
        G();
    }

    public final void b() {
        super.b();
        this.a.B();
    }

    public final void G() {
        if (!(com.xunlei.downloadprovider.vod.floatwindow.a.a || this.a == null || this.b == null)) {
            int i;
            int n = this.a.n();
            if (this.a.w()) {
                i = n;
            } else {
                i = this.a.o();
            }
            StringBuilder stringBuilder = new StringBuilder("saveCurrentPlayRecord, currentPosition : ");
            stringBuilder.append(i);
            stringBuilder.append(" duration : ");
            stringBuilder.append(n);
            i iVar = this.b;
            i.a(iVar.c, i, n, iVar.f);
        }
    }

    public final void H() {
        if (this.e != null) {
            this.e.j();
        }
    }

    public final void d() {
        V();
        com.xunlei.downloadprovider.download.player.c cVar = this.r;
        new StringBuilder("reportExitBeforePlay. mIsPrepared: ").append(cVar.g);
        if (!cVar.g) {
            cVar.a = System.currentTimeMillis() - cVar.b;
            com.xunlei.downloadprovider.player.a.b d = cVar.d();
            if (d != null) {
                String str = d.v;
                long j = d.t;
                StatEvent build = HubbleEventBuilder.build("android_play", "play_bxbb_exit");
                build.add("gcid", str);
                build.add("load_time", String.valueOf(j));
                ThunderReport.reportEvent(build);
                new StringBuilder("[STAT_EVENT]").append(build);
            }
        }
        b("1");
        T();
        G();
        D();
        if (this.a != null) {
            this.a.i();
            this.a.a(false);
            this.a = null;
        }
        R();
        if (this.e != null) {
            this.e.setViewEventListener(null);
            this.e.setOnClickListener(null);
            this.e.setPlayerController(null);
        }
        this.e = null;
        this.i.clear();
        this.t.removeCallbacksAndMessages(null);
        U();
        Bundle bundle = new Bundle();
        bundle.putLong("EXTRA_STAY_TIME", System.currentTimeMillis() - this.s);
        bundle.putInt("EXTRA_PLAY_POSITION", k_());
        long M = M();
        if (M > 0) {
            bundle.putLong("EXTRA_TASK_ID", M);
        }
        com.xunlei.downloadprovider.h.c.a(n(), "ACTION_EXIT_PLAYER", bundle);
    }

    public final void a(e eVar) {
        if (!this.i.contains(eVar)) {
            this.i.add(eVar);
        }
    }

    public final void b(e eVar) {
        this.i.remove(eVar);
    }

    private void b(String str) {
        if (this.r != null) {
            com.xunlei.downloadprovider.download.player.c cVar = this.r;
            long j = this.B;
            int i = this.l;
            long j2 = this.u;
            if (!RePlugin.PROCESS_UI.equals(cVar.f)) {
                long j3 = 0;
                if (cVar.k > 0) {
                    j3 = System.currentTimeMillis() - cVar.k;
                }
                int i2 = cVar.h;
                if (cVar.c == null) {
                    str = null;
                } else {
                    com.xunlei.downloadprovider.player.a.a aVar = new com.xunlei.downloadprovider.player.a.a();
                    if (cVar.d != null) {
                        aVar.h = cVar.d.mFileSize;
                        aVar.m = cVar.d.getResourceGcid();
                        aVar.n = cVar.d.mCID;
                        aVar.y = cVar.d.mTaskType != null ? cVar.d.mTaskType.toString().toLowerCase() : "";
                    }
                    if (cVar.e != null) {
                        aVar.h = cVar.e.mFileSize;
                        aVar.m = cVar.e.mGCID;
                        aVar.n = cVar.e.mCID;
                    }
                    aVar.a = cVar.a();
                    aVar.i = cVar.f;
                    aVar.d = cVar.j;
                    aVar.e = cVar.i;
                    aVar.f = j2;
                    aVar.g = j3;
                    aVar.b = cVar.c.g() ? "native" : "bxbb";
                    aVar.z = j;
                    aVar.A = i;
                    aVar.B = i2;
                    aVar.c = str;
                    if (cVar.l != null) {
                        if (cVar.l.h() != null) {
                            aVar.C = cVar.l.h().k;
                            aVar.D = cVar.l.h().j;
                            aVar.E = cVar.l.h().l;
                        }
                        if (cVar.l.I() != null) {
                            if (cVar.l.K() != null) {
                                aVar.h = cVar.l.K().getStatSize();
                            } else if (TextUtils.isEmpty(cVar.l.J()) == null) {
                                str = new File(cVar.l.J());
                                if (str.exists()) {
                                    aVar.h = str.length();
                                }
                            }
                        }
                    }
                    str = aVar;
                }
                if (!(str == null || str == null)) {
                    StatEvent build = HubbleEventBuilder.build("android_play", "play_player_end");
                    build.addString("from", str.a);
                    build.addString("play_type", str.b);
                    build.addString("end_type", str.c);
                    build.addString("errorcode", str.v);
                    build.addString("autoplay_status", str.d);
                    build.addLong("file_duration", str.e);
                    build.addLong("play_duration", str.f);
                    build.addLong("stay_duration", str.g);
                    build.addString("movieid", str.k);
                    build.addLong("filesize", str.h);
                    build.addString("play_sessionid", str.i);
                    build.addString("play_tec", str.j);
                    build.addLong("fplay_size", str.l);
                    if (!TextUtils.isEmpty(str.m)) {
                        build.addString("gcid", str.m);
                    }
                    if (!TextUtils.isEmpty(str.m)) {
                        build.addString("cid", str.n);
                    }
                    build.addString("rec_params", str.o);
                    build.addString("platformModel", str.p);
                    build.addString(com.alipay.sdk.app.statistic.c.a, str.q);
                    build.addLong("suspend_drag_time", str.r);
                    build.addLong("suspend_drag_cnt", str.s);
                    build.addLong("suspend_nodrag_time", str.t);
                    build.addLong("suspend_nodrag_cnt", str.u);
                    String str2 = "subtitle_result";
                    String str3 = str.x ? str.w ? "success" : "fail" : "nofit";
                    build.add(str2, str3);
                    build.add("task_type", str.y);
                    build.add("first_buffer_duration", str.z);
                    build.add("buffer_times", str.A);
                    build.add("drag_times", str.B);
                    build.add("has_open_subtile", str.C);
                    build.add("subtitle_result", str.D);
                    build.add("open_subtitle", str.E);
                    ThunderReport.reportEvent(build);
                }
                cVar.f = RePlugin.PROCESS_UI;
            }
        }
    }

    private void W() {
        if (this.e != null) {
            int p;
            int o;
            int n;
            int i = 0;
            if (this.a != null) {
                p = this.a.p();
                o = this.a.o();
                n = this.a.n();
            } else {
                p = 0;
                o = p;
                n = o;
            }
            if (n == 0) {
                n = this.g;
            }
            if (this.b != null) {
                DownloadVodPlayerView downloadVodPlayerView = this.e;
                i iVar = this.b;
                if (iVar.a != null) {
                    TaskRangeInfo taskRangeInfo;
                    if (iVar.c != null) {
                        iVar.e.mLength = iVar.a.mFileSize;
                        if (iVar.a.getTaskStatus() == 8) {
                            taskRangeInfo = new TaskRangeInfo();
                            taskRangeInfo.setLength(iVar.a.mFileSize);
                            iVar.e.mRanges = Collections.singletonList(taskRangeInfo);
                        } else {
                            List list;
                            PlayProgressRanges playProgressRanges = iVar.e;
                            long j = iVar.c.mTaskId;
                            int i2 = iVar.c.mBtSubIndex;
                            n.a();
                            long[] a = n.a(j, i2);
                            if (a == null || a.length <= 1) {
                                list = null;
                            } else {
                                list = new ArrayList(a.length / 2);
                                while (i < a.length - 1) {
                                    TaskRangeInfo taskRangeInfo2 = new TaskRangeInfo();
                                    taskRangeInfo2.setStartPosition(a[i]);
                                    taskRangeInfo2.setLength(a[i + 1]);
                                    list.add(taskRangeInfo2);
                                    i += 2;
                                }
                            }
                            playProgressRanges.mRanges = list;
                        }
                    } else {
                        iVar.e.mLength = iVar.a.mFileSize;
                        taskRangeInfo = new TaskRangeInfo();
                        taskRangeInfo.setLength(iVar.a.mDownloadedSize);
                        iVar.e.mRanges = Collections.singletonList(taskRangeInfo);
                    }
                }
                downloadVodPlayerView.setCacheProgress(iVar.e);
                if (this.q % 5 == 4 && E()) {
                    G();
                }
            }
            StringBuilder stringBuilder = new StringBuilder("updatePlayProgress, position : ");
            stringBuilder.append(o);
            stringBuilder.append(" duration : ");
            stringBuilder.append(n);
            this.e.a(n, o, p);
        }
    }

    public final boolean I() {
        if (this.b == null) {
            return false;
        }
        return this.b.g();
    }

    public final String J() {
        return this.b != null ? this.b.d() : "";
    }

    public final ParcelFileDescriptor K() {
        return this.b != null ? this.b.l() : null;
    }

    public final boolean L() {
        i iVar = this.b;
        if (iVar == null) {
            return false;
        }
        BTSubTaskInfo bTSubTaskInfo = iVar.b;
        if (bTSubTaskInfo != null && bTSubTaskInfo.mTaskStatus != 8) {
            return true;
        }
        TaskInfo taskInfo = iVar.a;
        if (taskInfo == null || taskInfo.getTaskStatus() == 8) {
            return false;
        }
        return true;
    }

    public final long M() {
        if (this.b == null) {
            return -1;
        }
        TaskPlayInfo taskPlayInfo = this.b.c;
        if (taskPlayInfo == null) {
            return -1;
        }
        return taskPlayInfo.mTaskId;
    }

    public final TaskPlayInfo N() {
        return this.b != null ? this.b.c : null;
    }

    public final void d(boolean z) {
        this.e.setADFinish(z);
    }

    public final void a(DialogInterface.OnClickListener onClickListener, Context context) {
        if (com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance())) {
            long M = M();
            if (M != -1) {
                n.a();
                TaskInfo f = n.f(M);
                if (f.getTaskStatus() == 1 || f.getTaskStatus() == 2) {
                    onClickListener.onClick(null, null);
                    return;
                }
            }
            if (this.E != null) {
                this.E.dismiss();
                this.E = null;
            }
            this.E = new XLAlertDialog(context);
            this.E.setMessage(context.getString(R.string.net_change_mobile_continus_tips));
            this.E.setCancelButtonText(context.getString(R.string.net_change_start_downloading));
            this.E.setConfirmButtonText(context.getString(R.string.net_change_close));
            this.E.setCanceledOnTouchOutside(true);
            this.E.setOnClickCancelButtonListener(new t(this, onClickListener));
            this.E.setOnClickConfirmButtonListener(new u(this));
            this.E.show();
            return;
        }
        XLToast.showToast(context, context.getString(R.string.net_disable));
    }

    public final void a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i == 792) {
            i = this.e.getContext();
            if (VERSION.SDK_INT >= 23 && Settings.canDrawOverlays(i) != 0) {
                e(this.d);
            }
        }
    }

    public final void a(boolean z) {
        super.a(z);
        if (!z && this.a) {
            this.a.a(202, "0");
        }
        if (this.e.l()) {
            z = this.e;
            if (z.l()) {
                z.m();
            }
        }
    }

    public final void c(boolean z) {
        if (z) {
            if (this.a) {
                if (!this.a.s()) {
                    if (!this.a.u()) {
                        if (this.a.r()) {
                            y();
                            f(true);
                            return;
                        } else if (this.a.v()) {
                            D();
                            f(true);
                            return;
                        } else if (this.a.w()) {
                            B();
                            H();
                        }
                    }
                }
                B();
                y();
                this.n = true;
                return;
            }
            return;
        }
        if (this.a && this.a.r()) {
            f(false);
        }
    }

    static /* synthetic */ boolean c(m mVar) {
        if (mVar.M() >= 0 && mVar.f && !mVar.y && !mVar.t()) {
            if (!mVar.S()) {
                if (!mVar.m_() && ((mVar.g() == null || !mVar.g().n) && !mVar.l_() && !mVar.F() && ((((float) mVar.k_()) * 1.0f) / ((float) mVar.e())) * 100.0f >= 90.0f)) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    static /* synthetic */ boolean e(m mVar) {
        return (mVar.x <= 0 || System.currentTimeMillis() - mVar.x <= 5000) ? null : true;
    }

    static /* synthetic */ void j(m mVar) {
        if (com.xunlei.xllib.android.b.f(BrothersApplication.getApplicationInstance())) {
            mVar.c(true);
            mVar.b(false);
            mVar.H();
        } else if (mVar.u()) {
            mVar.c(true);
            mVar.H();
        } else {
            mVar.a(new v(mVar), mVar.e.getContext());
        }
    }

    static /* synthetic */ void b(m mVar, boolean z) {
        boolean canDrawOverlays;
        Context context = mVar.e.getContext();
        if (VERSION.SDK_INT >= 23) {
            canDrawOverlays = Settings.canDrawOverlays(context);
        } else if (VERSION.SDK_INT >= 19) {
            canDrawOverlays = com.xunlei.downloadprovider.h.a.a(context);
        } else {
            canDrawOverlays = true;
        }
        if (canDrawOverlays) {
            mVar.e(z);
            return;
        }
        z = new k(mVar.n());
        CharSequence string = mVar.n().getString(R.string.vod_float_window_request_permission_dlg_msg);
        if (!TextUtils.isEmpty(string)) {
            z.c.setText(string);
        }
        string = mVar.n().getString(R.string.vod_float_window_request_permission_dlg_ok);
        if (!TextUtils.isEmpty(string)) {
            z.b.setText(string);
        }
        z.b.setOnClickListener(new y(mVar, z, context));
        z.a.setOnClickListener(new z(mVar, z));
        z.show();
    }

    static /* synthetic */ void p(m mVar) {
        if (mVar.e != null) {
            if (!mVar.S()) {
                mVar.e.f();
                a.a(mVar.p(), true, false);
                if (!mVar.a.v()) {
                    mVar.e.j();
                }
            } else if (!mVar.a.v()) {
                mVar.e.e();
                a.a(mVar.p(), false, false);
            }
        }
    }

    static /* synthetic */ void r(m mVar) {
        new StringBuilder("onPlayerPrepared, mNeedPlayAfterPrepared : ").append(mVar.n);
        new StringBuilder("playUrl : ").append(mVar.b.d());
        if (mVar.r != null) {
            com.xunlei.downloadprovider.download.player.c cVar = mVar.r;
            long e = (long) mVar.e();
            cVar.g = true;
            cVar.a = System.currentTimeMillis() - cVar.b;
            cVar.i = e;
            new StringBuilder("reportPlayStart, from : ").append(cVar.a());
            if (cVar.c != null) {
                com.xunlei.downloadprovider.player.a.b d = cVar.d();
                if (!(d == null || d == null)) {
                    StatEvent build = HubbleEventBuilder.build("android_play", "play_all_start");
                    build.addString("from", d.a);
                    build.addString("play_type", d.b);
                    build.addString("player_type", d.c);
                    build.addString("autoplay_status", d.d);
                    build.addString("suffix", d.e);
                    build.addString("movieid", d.n);
                    build.addLong("filesize", d.f);
                    build.addString("fileurl", d.g);
                    build.addString("filename", d.h);
                    build.addString("fmovie_resolution", d.i);
                    build.addString("screen", d.j);
                    build.addLong("file_duration", d.k);
                    build.addString("play_sessionid", d.l);
                    build.addString("play_tec", d.m);
                    build.addString("channelid", d.o);
                    build.addString("server", d.p);
                    build.addString("rec_params", d.q);
                    build.addString("platformModel", d.r);
                    build.addString(com.alipay.sdk.app.statistic.c.a, d.s);
                    build.addLong("load_time", d.t);
                    build.addString("speed_limit", d.u);
                    if (!TextUtils.isEmpty(d.v)) {
                        build.addString("gcid", d.v);
                        build.addString("cid", d.w);
                        build.addString("if_vip_bxbb", d.x);
                    }
                    build.addString("if_xunlei_download", d.y == null ? "0" : d.y);
                    build.addString("task_type", d.z);
                    build.addString("open_subtitle", d.A);
                    new StringBuilder("[STAT_EVENT]").append(build);
                    ThunderReport.reportEvent(build);
                }
            }
        }
        if (mVar.n) {
            mVar.B();
            if (mVar.k_() > 3000 && mVar.f && mVar.n() != null) {
                XLToast.showToast(mVar.n(), mVar.n().getResources().getString(R.string.vod_toast_play_pos, new Object[]{PlayerBottomViewGroup.a(mVar.k_())}));
            }
        } else {
            mVar.W();
            if (mVar.e != null) {
                mVar.e.setViewState(3);
                mVar.e.j();
            }
        }
        d notifyManager = com.xunlei.downloadprovider.download.downloadvod.a.getNotifyManager();
        notifyManager.b = true;
        notifyManager.c().removeCallbacksAndMessages(null);
        d.a();
        for (e a : mVar.i) {
            a.a(mVar.a);
        }
    }

    static /* synthetic */ void b(m mVar, int i) {
        if (i == 100) {
            mVar.o = false;
            mVar.l++;
            mVar.D = System.currentTimeMillis();
            if (mVar.B == 0) {
                mVar.B = mVar.D - mVar.C;
                new StringBuilder("mFirstBufferDuration : ").append(mVar.B);
            }
            if (mVar.e != 0) {
                if (mVar.E() != 0) {
                    mVar.e.setViewState(2);
                    return;
                } else {
                    mVar.C();
                    return;
                }
            }
        }
        if (!mVar.o) {
            mVar.o = true;
            mVar.C = System.currentTimeMillis();
        }
        if (mVar.E()) {
            mVar.e.setViewState(1);
        }
        if (mVar.e != null) {
            boolean z;
            Resources resources;
            Object[] objArr;
            StringBuilder stringBuilder;
            i iVar = mVar.b;
            if (iVar.c == null || !iVar.c.mIsLocalPlay) {
                if (iVar.b == null || iVar.b.mTaskStatus != 8) {
                    if (iVar.a == null || iVar.a.getTaskStatus() != 8) {
                        z = true;
                        if (z) {
                            if (i < 0) {
                                i = 0;
                            }
                            i = Math.min(i, 100);
                            resources = mVar.e.getResources();
                            objArr = new Object[1];
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(String.valueOf(i));
                            stringBuilder.append("%");
                            objArr[0] = stringBuilder.toString();
                            mVar.e.setLoadingText(resources.getString(R.string.vod_player_bxbb_buffering, objArr));
                        }
                    }
                }
            }
            z = false;
            if (z) {
                if (i < 0) {
                    i = 0;
                }
                i = Math.min(i, 100);
                resources = mVar.e.getResources();
                objArr = new Object[1];
                stringBuilder = new StringBuilder();
                stringBuilder.append(String.valueOf(i));
                stringBuilder.append("%");
                objArr[0] = stringBuilder.toString();
                mVar.e.setLoadingText(resources.getString(R.string.vod_player_bxbb_buffering, objArr));
            }
        }
    }

    static /* synthetic */ void t(m mVar) {
        if (mVar.e != null) {
            mVar.e.f();
            mVar.e.k();
            mVar.e.setViewState(4);
            if (mVar.n() != null) {
                mVar.e.setErrorText(mVar.n().getString(R.string.vod_toast_url_error));
            }
        }
        mVar.U();
        if (mVar.b != null) {
            mVar.b.f();
        }
        if (mVar.r != null) {
            mVar.V();
            mVar.b("2");
        }
    }

    static /* synthetic */ void u(m mVar) {
        mVar.V();
        mVar.b("0");
        mVar.G();
        com.xunlei.downloadprovider.h.c.a(BrothersApplication.getApplicationInstance(), "DownloadVodPlayerController.ACTION_PLAY_COMPLETION", null);
    }
}
