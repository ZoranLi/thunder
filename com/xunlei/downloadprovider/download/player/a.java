package com.xunlei.downloadprovider.download.player;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.view.Window;
import com.xunlei.downloadprovider.ad.taskdetailnew.banner.TaskDetailNewBannerAdController;
import com.xunlei.downloadprovider.download.player.a.ae;
import com.xunlei.downloadprovider.download.player.a.af;
import com.xunlei.downloadprovider.download.player.a.aq;
import com.xunlei.downloadprovider.download.player.a.ay;
import com.xunlei.downloadprovider.download.player.a.ba;
import com.xunlei.downloadprovider.download.player.a.bn;
import com.xunlei.downloadprovider.download.player.a.f;
import com.xunlei.downloadprovider.download.player.a.g;
import com.xunlei.downloadprovider.download.player.a.m;
import com.xunlei.downloadprovider.download.player.views.DownloadVodPlayerView;
import com.xunlei.downloadprovider.vod.manager.PlayerConfigPersistManager.ConfigPersistData;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ControllerManager */
public final class a extends f {
    public ConfigPersistData a = null;
    private Map<Class, f> b = new HashMap();

    public a(DownloadVodPlayerView downloadVodPlayerView) {
        super(null, downloadVodPlayerView);
        this.b.put(m.class, new m(this, downloadVodPlayerView));
        this.b.put(com.xunlei.downloadprovider.download.player.a.a.class, new com.xunlei.downloadprovider.download.player.a.a(this, downloadVodPlayerView));
        this.b.put(g.class, new g(this, downloadVodPlayerView));
        this.b.put(aq.class, new aq(this, downloadVodPlayerView));
        this.b.put(af.class, new af(this, downloadVodPlayerView));
        this.b.put(ba.class, new ba(this, downloadVodPlayerView));
        this.b.put(bn.class, new bn(this, downloadVodPlayerView));
        this.b.put(ay.class, new ay(this, downloadVodPlayerView));
        this.b.put(TaskDetailNewBannerAdController.class, new TaskDetailNewBannerAdController(this, downloadVodPlayerView));
        this.b.put(ae.class, new ae(this, downloadVodPlayerView));
    }

    public final ConfigPersistData a() {
        return this.a;
    }

    public final void b() {
        super.b();
        for (f b : this.b.values()) {
            b.b();
        }
    }

    public final void c() {
        super.c();
        for (f c : this.b.values()) {
            c.c();
        }
    }

    public final void n_() {
        super.n_();
        for (f n_ : this.b.values()) {
            n_.n_();
        }
    }

    public final void d() {
        super.n_();
        for (f d : this.b.values()) {
            d.d();
        }
        this.b.clear();
    }

    public final void a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        for (f a : this.b.values()) {
            a.a(i, i2, intent);
        }
    }

    public static void a(a aVar, boolean z, boolean z2) {
        if (aVar != null) {
            aVar.a(z, z2);
        }
    }

    public final void a(boolean z, boolean z2) {
        super.a(z, z2);
        for (f a : this.b.values()) {
            a.a(z, z2);
        }
    }

    public static void a(Activity activity, a aVar, boolean z) {
        if (activity != null && aVar != null) {
            if (z) {
                b(activity);
            } else if (activity != null) {
                activity.setRequestedOrientation(1);
                if (activity != null) {
                    Window window = activity.getWindow();
                    activity = activity.getWindow().getDecorView().getSystemUiVisibility() & 256;
                    if (VERSION.SDK_INT >= 16) {
                        activity &= -5;
                    }
                    if (VERSION.SDK_INT >= 19) {
                        activity &= -4097;
                    }
                    if (VERSION.SDK_INT >= 21) {
                        window.clearFlags(201326592);
                        window.clearFlags(Integer.MIN_VALUE);
                    }
                    window.getDecorView().setSystemUiVisibility(activity);
                    window.clearFlags(1024);
                }
            }
            aVar.a(z);
        }
    }

    public final void a(boolean z) {
        super.a(z);
        if (this.e != null) {
            this.e.a(z);
        }
        for (f a : this.b.values()) {
            a.a(z);
        }
    }

    public final m f() {
        return (m) this.b.get(m.class);
    }

    public final aq g() {
        return (aq) this.b.get(aq.class);
    }

    public final ba h() {
        return (ba) this.b.get(ba.class);
    }

    public final bn i() {
        return (bn) this.b.get(bn.class);
    }

    public final ay j() {
        return (ay) this.b.get(ay.class);
    }

    public final TaskDetailNewBannerAdController k() {
        return (TaskDetailNewBannerAdController) this.b.get(TaskDetailNewBannerAdController.class);
    }

    public final ae l() {
        return (ae) this.b.get(ae.class);
    }

    public static void a(Activity activity) {
        if (activity != null) {
            activity.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() | 2);
        }
    }

    public static void b(Activity activity) {
        if (activity != null) {
            activity.setRequestedOrientation(6);
            if (activity != null) {
                activity = activity.getWindow();
                int systemUiVisibility = ((activity.getDecorView().getSystemUiVisibility() | 2) | 512) & -257;
                if (VERSION.SDK_INT >= 16) {
                    systemUiVisibility |= 4;
                }
                if (VERSION.SDK_INT >= 19) {
                    systemUiVisibility |= 4096;
                }
                activity.getDecorView().setSystemUiVisibility(systemUiVisibility);
                if (VERSION.SDK_INT >= 21) {
                    activity.clearFlags(201326592);
                    activity.addFlags(Integer.MIN_VALUE);
                    activity.setNavigationBarColor(-16777216);
                }
                activity.addFlags(1024);
            }
        }
    }
}
