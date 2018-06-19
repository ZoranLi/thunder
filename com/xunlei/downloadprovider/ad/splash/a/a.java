package com.xunlei.downloadprovider.ad.splash.a;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.alipay.sdk.app.statistic.c;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.c.g;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.i;
import com.xunlei.downloadprovider.ad.common.report.j;
import com.xunlei.downloadprovider.ad.splash.view.b;
import com.xunlei.downloadprovider.ad.splash.view.k;
import com.xunlei.downloadprovider.ad.splash.view.n;
import com.xunlei.downloadprovider.ad.splash.view.p;
import com.xunlei.downloadprovider.ad.splash.view.s;
import com.xunlei.downloadprovider.app.BaseActivity;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SplashAd */
public abstract class a implements com.xunlei.downloadprovider.ad.common.i.a, h {
    protected final BaseActivity a;
    protected String b;
    protected String c;
    protected final ViewGroup d;
    protected final h e;
    protected a f = null;
    protected i g = null;
    protected boolean h = false;
    protected boolean i = false;
    protected boolean j = false;
    protected boolean k = false;
    protected b l = null;
    protected int m;
    protected int n = 1;

    protected abstract String i();

    public a(int i, @NonNull BaseActivity baseActivity, @NonNull ViewGroup viewGroup, @NonNull h hVar, i iVar) {
        this.m = i;
        this.a = baseActivity;
        this.d = viewGroup;
        this.e = hVar;
        this.g = iVar;
    }

    public void e() {
        this.g.a(this);
    }

    public final void f() {
        if (this.l != null) {
            this.l.k();
        }
    }

    public final void g() {
        if (this.l != null) {
            this.l.l();
        }
    }

    public final void h() {
        if (this.l != null) {
            this.l.m();
        }
    }

    public final void a(@NonNull l lVar) {
        if (!this.g.c) {
            this.c = lVar.y();
            if (!(lVar instanceof g)) {
                STYLES_INFO styles_info = lVar.v;
                if (styles_info != null) {
                    switch (f.a[styles_info.ordinal()]) {
                        case 1:
                            this.b = "fullscreen";
                            break;
                        case 2:
                            this.b = "background";
                            break;
                        case 3:
                            this.b = "video";
                            break;
                        default:
                            new StringBuilder("I don't recognize this StylesInfo: ").append(styles_info.name());
                            break;
                    }
                }
            }
            this.b = c.e;
            if (TextUtils.isEmpty(this.b)) {
                this.b = "background";
            }
            b(lVar);
        }
    }

    protected final void a(@Nullable com.xunlei.downloadprovider.ad.recommend.a.a.a aVar) {
        if (!this.g.c) {
            if (this.f != null) {
                this.f.e();
            } else {
                a_(aVar.e, aVar.f);
            }
            this.g.b(this);
        }
    }

    protected void b(@NonNull l lVar) {
        a(this.b);
        c(lVar);
        this.l.a(lVar);
    }

    protected final void j() {
        c();
    }

    protected void e(l lVar) {
        g(lVar);
        lVar.onClick(this.d);
        d();
    }

    protected final void g(l lVar) {
        Map hashMap = new HashMap();
        hashMap.put("ad_from", com.xunlei.downloadprovider.ad.splash.b.b.b(this.m));
        hashMap.put("launch_style", i());
        lVar.F = hashMap;
    }

    public final void a() {
        if (!this.h) {
            this.e.a();
            this.h = true;
        }
    }

    public final void a_(int i, String str) {
        if (!this.i) {
            j.b(THUNDER_AD_INFO.SPLASH.getPositionId(), i, str);
            this.e.a_(i, str);
            this.i = true;
        }
    }

    public final void b() {
        if (!this.j) {
            this.e.b();
            this.j = true;
        }
    }

    public final void c() {
        if (!this.k) {
            this.e.c();
            this.k = true;
        }
    }

    public final void d() {
        this.e.d();
    }

    public final void g_() {
        j.a(THUNDER_AD_INFO.SPLASH.getPositionId(), -6, com.alipay.sdk.data.a.f);
        String str = this.c;
        StringBuilder stringBuilder = new StringBuilder("timeout_");
        stringBuilder.append(this.g.b);
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder("splashReport loadFail adType: ");
        stringBuilder3.append(str);
        stringBuilder3.append(" errorcode: ");
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append(" net_type: 正在获取");
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_advertise").addString(HubbleEventBuilder.KEY_ATTRIBUTE1, "adv_launch_fail").addString("ad_type", str).addString("errorcode", stringBuilder2).addString("net_type", com.xunlei.downloadprovider.ad.common.report.a.a()));
        str = THUNDER_AD_INFO.SPLASH.getPositionId();
        stringBuilder = new StringBuilder("timeout_");
        stringBuilder.append(this.g.b);
        j.b(str, -6, stringBuilder.toString());
    }

    protected final void a(String str) {
        if (c.e.equals(str)) {
            str = new n(this.a);
        } else if ("fullscreen".equals(str)) {
            str = new k(this.a);
        } else if ("video".equals(str) != null) {
            str = new p(this.a);
        } else {
            str = new s(this.a);
        }
        this.l = str;
        str = this.l;
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        this.d.removeAllViews();
        this.d.addView(str, layoutParams);
    }

    protected void c(@NonNull l lVar) {
        this.l.setOnAdClickListener(new b(this, lVar));
        this.l.setOnAdDismissListener(new c(this, lVar));
        this.l.setOnAdShowListener(new d(this, lVar));
        this.l.setOnSkipBtnClickListener(new e(this, lVar));
    }

    protected final void d(l lVar) {
        lVar = lVar.e();
        String str = this.c;
        int i = this.m;
        StringBuilder stringBuilder = new StringBuilder("splashReport skip advid: ");
        stringBuilder.append(lVar);
        stringBuilder.append(" ad_type: ");
        stringBuilder.append(str);
        stringBuilder.append(" splashOrigin: ");
        stringBuilder.append(i);
        StatEvent addString = HubbleEventBuilder.build("android_advertise").addString(HubbleEventBuilder.KEY_ATTRIBUTE1, "adv_launch_skip");
        String str2 = "advid";
        if (lVar == null) {
            lVar = "";
        }
        lVar = addString.addString(str2, lVar);
        String str3 = "ad_type";
        if (str == null) {
            str = "";
        }
        ThunderReport.reportEvent(lVar.addString(str3, str).addString("ad_from", com.xunlei.downloadprovider.ad.splash.b.b.b(i)));
    }

    protected final void f(l lVar) {
        Map hashMap = new HashMap();
        hashMap.put("ad_from", com.xunlei.downloadprovider.ad.splash.b.b.b(this.m));
        hashMap.put("load_time", String.valueOf(SystemClock.uptimeMillis() - com.xunlei.downloadprovider.ad.revive.a.a.a.a().g));
        hashMap.put("launch_style", i());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j.a());
        hashMap.put("session", stringBuilder.toString());
        lVar.E = hashMap;
        lVar.a(this.d);
        b();
    }
}
