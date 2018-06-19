package com.xunlei.downloadprovider.ad.splash.a;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.c.g;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.adget.t;
import com.xunlei.downloadprovider.ad.common.browser.WebViewADActivity;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.ad.common.h.a;
import com.xunlei.downloadprovider.ad.common.i;
import com.xunlei.downloadprovider.ad.common.report.j;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import java.util.List;

/* compiled from: SplashNativeAd */
public class q extends a implements a {
    private static final String o = "q";

    public q(int i, @NonNull BaseActivity baseActivity, @NonNull ViewGroup viewGroup, @NonNull h hVar, i iVar) {
        super(i, baseActivity, viewGroup, hVar, iVar);
    }

    public final void e() {
        super.e();
        com.xunlei.downloadprovider.ad.revive.a.a.a.a().g = SystemClock.uptimeMillis();
        if (this.m == 0) {
            com.xunlei.downloadprovider.ad.splash.c.a.a().a = this;
            com.xunlei.downloadprovider.ad.splash.c.a.a().d();
            j.a(THUNDER_AD_INFO.SPLASH.getPositionId(), SystemClock.uptimeMillis() - com.xunlei.downloadprovider.ad.revive.a.a.a.a().f);
            return;
        }
        new t().a(THUNDER_AD_INFO.SPLASH, (a) this, this.g.b, true);
    }

    public final void a(List<l> list) {
        if (f.a(this.a)) {
            a((com.xunlei.downloadprovider.ad.recommend.a.a.a) new com.xunlei.downloadprovider.ad.recommend.a.a.a(-21, "load complete but activity is destroyed"));
        } else if (!this.g.c) {
            l lVar = (list == null || list.isEmpty()) ? null : (l) list.get(0);
            new StringBuilder("splashAdInfo : ").append(lVar == null ? "null" : lVar.toString());
            if (lVar == null) {
                j.a(THUNDER_AD_INFO.SPLASH.getPositionId(), -13, "no ad");
                a((com.xunlei.downloadprovider.ad.recommend.a.a.a) new com.xunlei.downloadprovider.ad.recommend.a.a.a(-13, "no ad"));
            } else if (lVar instanceof g) {
                g gVar = (g) lVar;
                List<l> jVar;
                switch (r.a[gVar.a.ordinal()]) {
                    case 1:
                        jVar = new j(this.m, this.a, this.d, gVar, this.e, this.g);
                        break;
                    case 2:
                        jVar = new o(this.m, this.a, this.d, gVar, this.e, this.g);
                        break;
                    default:
                        list = null;
                        break;
                }
                if (list != null) {
                    this.g.b(this);
                    list.e();
                    return;
                }
                j.a(THUNDER_AD_INFO.SPLASH.getPositionId(), -13, "no render ad");
                a((com.xunlei.downloadprovider.ad.recommend.a.a.a) new com.xunlei.downloadprovider.ad.recommend.a.a.a(-13, "no render ad"));
            } else {
                j.a(lVar);
                a();
                a(lVar);
            }
        }
    }

    public final void a(int i, String str) {
        if (!this.g.c) {
            j.a(THUNDER_AD_INFO.SPLASH.getPositionId(), i, str);
            a(new com.xunlei.downloadprovider.ad.recommend.a.a.a(i, str));
        }
    }

    protected final void c(@NonNull l lVar) {
        super.c(lVar);
        if (r.a[lVar.c().ordinal()] == 1) {
            this.l.j();
        }
    }

    protected final void e(l lVar) {
        if (f.a(lVar)) {
            if (lVar != null) {
                g(lVar);
                lVar.N();
                String s = lVar.s();
                int u = lVar.u();
                if (u == 0) {
                    a(lVar, s);
                } else if (u != 2) {
                    if (u == 5) {
                        r1 = lVar.t();
                        if (!lVar.a(this.a, s)) {
                            a(lVar, r1);
                        }
                    }
                } else if (!TextUtils.isEmpty(s)) {
                    g();
                    this.l.p();
                    r1 = lVar.o();
                    String p = lVar.p();
                    if (this.m == 0) {
                        MainTabActivity.a(this.a, s, r1, p, com.xunlei.downloadprovider.ad.common.c.a.a(lVar));
                        this.a.finish();
                    } else if (g.a(this.m) && this.a != null) {
                        TaskStatInfo taskStatInfo = new TaskStatInfo(com.xunlei.downloadprovider.ad.common.c.a.a(lVar), s, null);
                        lVar = new DownloadAdditionInfo();
                        lVar.a = r1;
                        lVar.b = p;
                        lVar.f = true;
                        com.xunlei.downloadprovider.download.engine.task.g.a();
                        com.xunlei.downloadprovider.download.engine.task.g.a(s, r1, taskStatInfo, lVar);
                        this.a.finish();
                    }
                }
                d();
            }
            return;
        }
        super.e(lVar);
    }

    protected final String i() {
        return this.l == null ? "fullscreen" : this.l.getAdStyle();
    }

    private void a(l lVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            g();
            this.l.p();
            Bundle bundle;
            if (this.m == 0) {
                bundle = new Bundle(2);
                bundle.putString("key_back", "back_splash");
                bundle.putSerializable("ad_common_report_info", lVar.L());
                WebViewADActivity.startWebViewADActivity(this.a, com.xunlei.downloadprovider.ad.common.c.a.a(lVar), str, lVar.j(), bundle);
                this.a.overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
            } else if (g.a(this.m)) {
                bundle = new Bundle(2);
                bundle.putSerializable("ad_common_report_info", lVar.L());
                WebViewADActivity.startWebViewADActivity(this.a, com.xunlei.downloadprovider.ad.common.c.a.a(lVar), str, lVar.j(), bundle);
                this.a.overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
            }
            this.a.finish();
        }
    }
}
