package com.xunlei.downloadprovider.ad.splash.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.ad.splash.a.i;
import com.xunlei.downloadprovider.ad.splash.c.c;
import com.xunlei.downloadprovider.ad.splash.c.c.a;
import com.xunlei.downloadprovider.ad.splash.c.d;
import com.xunlei.downloadprovider.ad.splash.downloader.DownloadRequest;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer.VideoViewType;
import com.xunlei.downloadprovider.player.xmp.ak;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerContainer;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerControl.ControlType;
import com.xunlei.downloadprovider.player.xmp.y;
import com.xunlei.xllib.android.b;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: SplashVideoAdView */
public class p extends i implements a, PlayerContainer {
    private static final String t = "p";
    private c A;
    private com.xunlei.downloadprovider.ad.splash.b.a B;
    private View u;
    private ImageView v;
    private ImageView w;
    private ViewGroup x;
    private ThunderXmpPlayer y;
    private y z;

    public final void b(ThunderXmpPlayer thunderXmpPlayer) {
    }

    public p(Context context) {
        super(context);
        this.u = null;
        this.v = null;
        this.w = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.u = LayoutInflater.from(this.a).inflate(R.layout.layout_splash_video_ad, this);
        b();
        c();
    }

    protected final void b() {
        super.b();
        this.v = (ImageView) this.u.findViewById(R.id.iv_poster);
        this.w = (ImageView) this.u.findViewById(R.id.iv_ad_source_icon);
        this.x = (ViewGroup) this.u.findViewById(R.id.player_container);
        u();
        setAdStyle("video");
    }

    protected final void c() {
        super.c();
        this.i.setOnClickListener(new q(this));
        setOnClickListener(new r(this));
    }

    protected final void d() {
        this.h = (CountDownCircleProgressBar) this.u.findViewById(R.id.splash_ad_skip_count_down_pb);
        this.i = this.u.findViewById(R.id.splash_ad_skip_count_down_btn);
    }

    public final void a(@NonNull l lVar) {
        this.o = lVar;
        this.B = new com.xunlei.downloadprovider.ad.splash.b.a(this.o, "video");
        u();
        this.g = Math.max(3000, i.a());
        if (this.A == null) {
            this.A = new c();
        }
        if (TextUtils.isEmpty(lVar.b())) {
            this.B.h = 202;
            b(lVar);
        } else {
            boolean z;
            Object a = c.a(lVar.b());
            if (TextUtils.isEmpty(a)) {
                z = false;
            } else {
                z = new File(a).exists();
            }
            if (z) {
                this.B.d = true;
                b(c.a(lVar.b()));
            } else {
                b(lVar);
                if (b.e(this.a)) {
                    this.B.c = false;
                    this.B.h = 301;
                } else {
                    try {
                        c cVar = this.A;
                        lVar = lVar.b();
                        if (TextUtils.isEmpty(lVar)) {
                            a();
                        } else {
                            String a2 = c.a(lVar);
                            Uri parse = Uri.parse(lVar);
                            Uri parse2 = Uri.parse(a2);
                            DownloadRequest downloadRequest = new DownloadRequest(parse);
                            downloadRequest.e = new com.xunlei.downloadprovider.ad.splash.downloader.a();
                            downloadRequest.g = true;
                            downloadRequest.d = parse2;
                            downloadRequest.i = new d(cVar, lVar, this, a2);
                            lVar = cVar.b;
                            String str = "add(...) called on a released ThinDownloadManager.";
                            if (lVar.a()) {
                                throw new IllegalStateException(str);
                            }
                            lVar.a.a(downloadRequest);
                        }
                        this.B.c = true;
                    } catch (l lVar2) {
                        lVar2.printStackTrace();
                        this.B.c = false;
                        this.B.h = 203;
                    }
                }
            }
        }
        setAdSourceIconIv(getAdSourceIconResId());
        e();
    }

    public final void h() {
        s();
        if (this.B != null) {
            this.B.e = true;
        }
        super.h();
    }

    public final void g() {
        l lVar = this.o;
        boolean z = (lVar == null || !f.a(lVar) || lVar.u() == 7 || TextUtils.isEmpty(lVar.s())) ? false : true;
        if (z && this.B != null) {
            this.B.f = true;
        }
        super.g();
    }

    private void u() {
        this.h.setProgress(0);
        this.v.setImageResource(R.drawable.bg_splash_poster_default);
        this.v.setVisibility(0);
        this.x.setVisibility(4);
        this.w.setVisibility(4);
    }

    public final void k() {
        super.k();
        a(this.z);
    }

    public final void l() {
        super.l();
        if (this.y != null) {
            if (this.y.f.e) {
                this.y.a(false, false);
                return;
            }
            this.y.b();
        }
    }

    public final void m() {
        super.m();
        if (!(this.B == null || (this.B.g ^ 1) == 0)) {
            com.xunlei.downloadprovider.ad.splash.b.a aVar = this.B;
            if (aVar.h == -1) {
                int i = (!aVar.c || aVar.d) ? -1 : aVar.e ? 102 : aVar.f ? 103 : 104;
                if (i != -1) {
                    aVar.h = i;
                }
            }
            if (aVar.h != -1) {
                String e = aVar.b.e();
                String y = aVar.b.y();
                String a = aVar.b.a();
                String str = aVar.a;
                int i2 = aVar.h;
                StringBuilder stringBuilder = new StringBuilder("splashReport materialFailToShow style: ");
                stringBuilder.append(str);
                stringBuilder.append(" errorCode: ");
                stringBuilder.append(i2);
                Map hashMap = new HashMap();
                hashMap.put("advid", e);
                hashMap.put("ad_type", y);
                hashMap.put("material", a);
                hashMap.put("style", str);
                hashMap.put("errorcode", String.valueOf(i2));
                com.xunlei.downloadprovider.ad.common.report.a.a("adv_launch_dynamic_show_fail", hashMap);
            }
        }
        if (this.A != null) {
            this.A.a();
        }
        if (this.y != null) {
            this.y.q();
        }
    }

    public ViewGroup getContainerLayout() {
        return this.x;
    }

    public final void a(ThunderXmpPlayer thunderXmpPlayer) {
        this.v.setVisibility(4);
        this.x.setVisibility(0);
    }

    private void a(y yVar) {
        if (yVar != null && this.y != null) {
            this.y.a(yVar);
        }
    }

    private void b(@NonNull l lVar) {
        this.x.setVisibility(4);
        setPosterBitmap(lVar.t);
        this.v.setVisibility(0);
        p();
        setAnotherCountDown(this.g);
        r();
    }

    private void setPosterBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.v.setImageBitmap(bitmap);
        } else {
            this.v.setImageResource(R.drawable.bg_splash_poster_default);
        }
    }

    private void setAdSourceIconIv(Object obj) {
        com.xunlei.downloadprovider.ad.common.c.a(getContext(), obj, this.w);
        this.w.setVisibility(0);
    }

    public final void a(String str) {
        if (!this.f) {
            if (this.B != null) {
                this.B.d = true;
            }
            b(str);
        }
    }

    public final void a() {
        if (!(this.f || this.B == null)) {
            this.B.d = false;
            this.B.h = 101;
        }
    }

    private void b(String str) {
        if (this.o != null) {
            long a = i.a(TimeUnit.SECONDS.toMillis((long) this.o.v()));
            s();
            setCountDown$2566ab5(a);
            o();
        }
        ThunderXmpPlayer a2 = ak.a().a(PlayerTag.SPLASH_AD, ControlType.SPLASH_AD);
        a2.q = VideoViewType.ZOOM_AND_TAILOR;
        a2.y = false;
        a2.a((BaseActivity) getContext(), (PlayerContainer) this);
        this.y = a2;
        this.z = new y(String.valueOf(System.currentTimeMillis()), str, "");
        this.z.p = this.v.getScaleType();
        this.z.a(this.v.getDrawable());
        this.z.k = "splash_ad";
        this.z.g = true;
        this.z.h = false;
        a(this.z);
        if (this.B != null) {
            this.B.g = true;
        }
    }
}
