package com.xunlei.downloadprovider.vod.floatwindow;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.downloadvod.TaskPlayInfo;
import com.xunlei.downloadprovider.download.downloadvod.i;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.engine.task.z;
import com.xunlei.downloadprovider.download.player.a.m;
import com.xunlei.downloadprovider.h.c;
import com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import com.xunlei.downloadprovider.vod.subtitle.SubtitleManifest;
import com.xunlei.downloadprovider.vodnew.VodPlayerActivityNew;
import com.xunlei.downloadprovider.vodnew.a.e.o;
import com.xunlei.xllib.android.b;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: VodPlayerFloatWindow */
public class a {
    public static boolean a = false;
    private static final String v = "a";
    private boolean A = false;
    private boolean B;
    private Runnable C = new f(this);
    Context b;
    AudioManager c;
    WindowManager d;
    LayoutParams e;
    VodPlayerFloatWindowView f;
    o g;
    GestureDetector h;
    Timer i = null;
    a j = null;
    boolean k = false;
    TaskPlayInfo l;
    int m;
    HashMap n = null;
    boolean o = true;
    SubtitleManifest p;
    BroadcastReceiver q = null;
    public BroadcastReceiver r;
    boolean s = true;
    OnAudioFocusChangeListener t = new n(this);
    OnGestureListener u = new c(this);
    private long w = 0;
    private Handler x = new Handler(Looper.getMainLooper());
    private volatile VideoPlayRecord y;
    private int z;

    /* compiled from: VodPlayerFloatWindow */
    private class a extends TimerTask {
        final /* synthetic */ a a;

        private a(a aVar) {
            this.a = aVar;
        }

        public final void run() {
            this.a.x.post(this.a.C);
        }
    }

    public a(Context context) {
        this.b = context.getApplicationContext();
        this.d = (WindowManager) this.b.getSystemService("window");
        this.c = (AudioManager) this.b.getSystemService("audio");
        this.e = new LayoutParams();
        if (VERSION.SDK_INT >= 26) {
            this.e.type = 2038;
        } else {
            this.e.type = PushResult.UNFINISH_DOWNLOAD_NOTICE;
        }
        this.e.flags = 8;
        this.e.format = 1;
        this.e.gravity = 51;
        context = this.b.getResources().getDisplayMetrics();
        int i = context.widthPixels < context.heightPixels ? context.widthPixels : context.heightPixels;
        context = context.widthPixels < context.heightPixels ? context.heightPixels : context.widthPixels;
        this.z = i;
        double d = (double) i;
        this.e.width = (int) (0.6d * d);
        this.e.height = (this.e.width * 9) / 16;
        this.e.x = (int) (d * 0.364d);
        this.e.y = (int) (((double) context) * 0.7d);
        a(128);
        if (this.r == null) {
            this.r = new e(this);
            c.a(this.b, "other_player_open_action", this.r);
        }
    }

    public final Notification a() {
        boolean t;
        int n;
        Builder builder = new Builder(this.b);
        if (this.g != null) {
            t = this.g.t();
            n = this.g.n();
        } else {
            t = false;
            n = t;
        }
        builder.setContentIntent(PendingIntent.getActivity(this.b, 0, VodPlayerActivityNew.b(this.b, this.l, "float_window", this.n, t, n, this.p), 134217728)).setContentTitle(this.b.getString(R.string.app_name)).setSmallIcon(R.mipmap.ic_launcher).setContentText(this.b.getString(R.string.vod_float_window_notification_content)).setWhen(System.currentTimeMillis());
        return builder.build();
    }

    final void b() {
        if (b.f(BrothersApplication.getApplicationInstance())) {
            f();
            d();
            return;
        }
        TaskPlayInfo taskPlayInfo = this.l;
        Object obj = null;
        if (taskPlayInfo != null) {
            BTSubTaskInfo bTSubTaskInfo = null;
            if (taskPlayInfo.mBtSubIndex >= 0) {
                n.a();
                z e = n.e(taskPlayInfo.mTaskId);
                if (e != null) {
                    bTSubTaskInfo = e.b(taskPlayInfo.mBtSubIndex);
                }
            }
            n.a();
            TaskInfo f = n.f(taskPlayInfo.mTaskId);
            if (!(f == null && r2 == null) && (r2 == null || r2.mTaskStatus != 8)) {
                if (f != null) {
                    if (f.getTaskStatus() != 8) {
                    }
                }
            }
            obj = 1;
        }
        if (obj != null) {
            f();
        } else if (b.a(BrothersApplication.getApplicationInstance())) {
            XLToast.showToast(BrothersApplication.getApplicationInstance(), "移动网络下无法在悬浮窗开启下载");
        } else {
            XLToast.showToast(BrothersApplication.getApplicationInstance(), BrothersApplication.getApplicationInstance().getString(R.string.net_disable));
        }
    }

    private void f() {
        if (this.g != null) {
            this.c.requestAudioFocus(this.t, 3, 1);
            this.f.c();
            this.g.e();
        }
    }

    final void c() {
        if (this.g != null) {
            this.f.b();
            this.g.f();
            this.c.abandonAudioFocus(this.t);
        }
    }

    final void a(int i) {
        this.e.flags = (i & 128) | (this.e.flags & -129);
    }

    public final void a(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder("savePlayRecord， position ");
        stringBuilder.append(i);
        stringBuilder.append(" duration: ");
        stringBuilder.append(i2);
        if (this.y == null) {
            this.y = new VideoPlayRecord();
        }
        i.a(this.l, i, i2, this.y);
    }

    public final void d() {
        if (this.l != null) {
            m.a(this.l.mTaskId, this.l.mBtSubIndex, false);
        }
    }

    static /* synthetic */ void a(a aVar, Context context) {
        if (aVar.g != null) {
            aVar.a(aVar.g.o(), aVar.g.n());
        }
        VodPlayerFloatWindowService.a(context);
    }

    static /* synthetic */ void a(a aVar, int i) {
        if (i == 100) {
            aVar.B = false;
            if (aVar.f != 0) {
                if (aVar.g == 0 || aVar.g.t() == 0) {
                    aVar.f.b();
                    return;
                } else {
                    aVar.f.c();
                    return;
                }
            }
        }
        if (!aVar.B) {
            aVar.B = true;
        }
        if (!(aVar.g == null || !aVar.g.t() || aVar.f == null)) {
            aVar.f.d();
        }
        if (aVar.f != null) {
            if (i < 0) {
                i = 0;
            }
            i = Math.min(i, 100);
            Object[] objArr = new Object[1];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(i));
            stringBuilder.append("%");
            objArr[0] = stringBuilder.toString();
            aVar.f.setLoadingText(String.format("正在缓冲 %1s...", objArr));
        }
    }
}
