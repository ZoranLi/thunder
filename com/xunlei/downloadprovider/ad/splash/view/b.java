package com.xunlei.downloadprovider.ad.splash.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.l;
import com.xunlei.downloadprovider.ad.splash.view.a.a;

/* compiled from: SplashAdView */
public abstract class b extends FrameLayout implements a {
    protected Context a = null;
    protected OnClickListener b = null;
    protected OnClickListener c = null;
    protected com.xunlei.downloadprovider.ad.splash.view.a.b d = null;
    protected a e = null;
    protected boolean f = true;
    protected long g = 3000;
    protected CountDownCircleProgressBar h = null;
    protected View i = null;
    protected ValueAnimator j = null;
    protected l k = null;
    protected String l = "";
    protected boolean m = false;
    protected XLAlertDialog n = null;
    protected com.xunlei.downloadprovider.ad.common.adget.l o = null;
    protected Handler p = new Handler(new c(this));

    protected void c() {
    }

    protected abstract void d();

    public void k() {
    }

    public void l() {
    }

    public b(Context context) {
        super(context);
        this.a = context;
    }

    protected void b() {
        this.j = ValueAnimator.ofInt(new int[]{0, 100});
        d();
    }

    protected Object getAdSourceIconResId() {
        Object valueOf = Integer.valueOf(R.drawable.splash_ad_source_icon_xunlei);
        if (this.o == null) {
            return valueOf;
        }
        switch (h.a[this.o.c().ordinal()]) {
            case 1:
                return Integer.valueOf(R.drawable.splash_ad_source_icon_gdt);
            case 2:
                return Integer.valueOf(R.drawable.splash_ad_source_icon_baidu);
            case 3:
                if (TextUtils.isEmpty(this.o.r())) {
                    return Integer.valueOf(R.drawable.splash_ad_source_icon_xunlei);
                }
                return this.o.r();
            default:
                return valueOf;
        }
    }

    public final void e() {
        this.f = false;
        if (this.d != null) {
            this.d.a();
        }
    }

    public final void f() {
        if (this.b != null) {
            if (this.m && com.xunlei.xllib.android.b.e(getContext()) && this.o != null && this.o.w()) {
                DialogInterface.OnClickListener dVar = new d(this);
                DialogInterface.OnClickListener eVar = new e(this);
                if (this.n == null) {
                    this.n = new XLAlertDialog(this.a);
                    this.n.setTitle((CharSequence) "温馨提示");
                    this.n.setMessage((CharSequence) "当前为移动网络，开始下载/安装应用？");
                    this.n.setConfirmButtonText((CharSequence) "确认");
                    this.n.setCancelButtonText((CharSequence) "取消");
                }
                this.n.setOnClickConfirmButtonListener(dVar);
                this.n.setOnClickCancelButtonListener(eVar);
                if (this.n != null) {
                    this.n.show();
                }
                return;
            }
            g();
        }
    }

    public void g() {
        this.b.onClick(this);
    }

    public void h() {
        if (this.c != null) {
            this.c.onClick(this.i);
        }
        p();
        l();
        i();
    }

    public final void i() {
        if (!(this.f || this.e == null)) {
            this.e.a();
        }
        this.f = true;
    }

    public void setOnAdClickListener(@NonNull OnClickListener onClickListener) {
        this.b = onClickListener;
    }

    public void setOnSkipBtnClickListener(@NonNull OnClickListener onClickListener) {
        this.c = onClickListener;
    }

    public void setOnAdDismissListener(@NonNull a aVar) {
        this.e = aVar;
    }

    public void setOnAdShowListener(@NonNull com.xunlei.downloadprovider.ad.splash.view.a.b bVar) {
        this.d = bVar;
    }

    public String getAdStyle() {
        return this.l;
    }

    protected void setAdStyle(String str) {
        this.l = str;
    }

    public final void j() {
        this.m = true;
    }

    public void m() {
        p();
        n();
        this.n = null;
    }

    protected final void n() {
        if (this.n != null) {
            this.n.dismiss();
        }
    }

    private void setCountDownAnimator$2566ab5(long j) {
        this.j.removeAllUpdateListeners();
        this.j.addUpdateListener(new g(this));
        this.j.setRepeatCount(0);
        this.j.setDuration(j);
        this.j.setInterpolator(new LinearInterpolator());
    }

    public final void q() {
        this.p.sendEmptyMessageDelayed(1000, 0);
    }

    public final void setCountDown$2566ab5(long j) {
        this.j.removeAllUpdateListeners();
        this.j.addUpdateListener(new g(this));
        this.j.setRepeatCount(0);
        this.j.setDuration(j);
        this.j.setInterpolator(new LinearInterpolator());
        this.k = new l(j);
        this.k.a(new f(this));
    }

    public final void o() {
        if (this.j != null) {
            this.j.start();
        }
        if (this.k != null) {
            this.k.b();
        }
    }

    public final void p() {
        if (this.j != null) {
            this.j.cancel();
        }
        if (this.k != null) {
            this.k.a();
        }
    }
}
