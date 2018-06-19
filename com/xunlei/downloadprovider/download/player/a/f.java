package com.xunlei.downloadprovider.download.player.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.CallSuper;
import com.xunlei.downloadprovider.ad.taskdetailnew.banner.TaskDetailNewBannerAdController;
import com.xunlei.downloadprovider.download.player.a;
import com.xunlei.downloadprovider.download.player.views.DownloadVodPlayerView;
import com.xunlei.downloadprovider.vod.manager.PlayerConfigPersistManager.ConfigPersistData;
import java.lang.ref.WeakReference;

/* compiled from: ControllerBase */
public abstract class f {
    private WeakReference<a> a;
    protected DownloadVodPlayerView e;
    protected boolean f = false;

    public void a(int i, int i2, Intent intent) {
    }

    @CallSuper
    public void a(boolean z, boolean z2) {
    }

    public void b() {
    }

    public void c() {
    }

    public abstract void d();

    public void n_() {
    }

    public f(a aVar, DownloadVodPlayerView downloadVodPlayerView) {
        this.e = downloadVodPlayerView;
        this.a = new WeakReference(aVar);
    }

    public final Context n() {
        return this.e != null ? this.e.getContext() : null;
    }

    public final Activity o() {
        return (n() == null || !(n() instanceof Activity)) ? null : (Activity) n();
    }

    public final a p() {
        return (a) this.a.get();
    }

    public ConfigPersistData a() {
        return p() != null ? p().a : null;
    }

    public m f() {
        return p() != null ? p().f() : null;
    }

    public aq g() {
        return p() != null ? p().g() : null;
    }

    public ba h() {
        return p() != null ? p().h() : null;
    }

    public bn i() {
        return p() != null ? p().i() : null;
    }

    public ay j() {
        return p() != null ? p().j() : null;
    }

    public TaskDetailNewBannerAdController k() {
        return p() != null ? p().k() : null;
    }

    public ae l() {
        return p() != null ? p().l() : null;
    }

    public final DownloadVodPlayerView q() {
        return this.e;
    }

    @CallSuper
    public void a(boolean z) {
        this.f = z;
    }
}
