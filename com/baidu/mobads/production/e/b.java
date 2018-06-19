package com.baidu.mobads.production.e;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.internal.view.SupportMenu;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.d.c;
import com.baidu.mobads.production.v;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.vo.d;
import java.util.HashMap;

public class b extends com.baidu.mobads.production.b implements a {
    private CountDownTimer A;
    private f B;
    private boolean C = false;
    private boolean D = false;
    private Activity E;
    private Boolean F;
    public final String w = "html5_intersitial";
    protected final IXAdLogger x = XAdSDKFoundationFacade.getInstance().getAdLogger();
    private RelativeLayout y;
    private TextView z;

    public void a(Activity activity) {
    }

    public boolean a(int i, KeyEvent keyEvent) {
        return true;
    }

    public void c(IXAdResponseInfo iXAdResponseInfo) {
    }

    public void g() {
    }

    public void q() {
    }

    public /* synthetic */ IXAdRequestInfo getAdRequestInfo() {
        return t();
    }

    public b(Context context, RelativeLayout relativeLayout, Boolean bool, AdSize adSize, String str) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.o = SlotType.SLOT_TYPE_INTERSTITIAL;
        this.F = bool;
        this.B = new f(getApplicationContext(), getActivity(), this.o, Boolean.valueOf(true));
        this.B.c(SlotType.SLOT_TYPE_INTERSTITIAL.getValue());
        this.B.f(adSize.getValue());
        this.B.d(str);
        e(str);
    }

    protected void h() {
        this.m = 8000;
    }

    public void request() {
        super.a(this.B);
    }

    protected void a(c cVar, v vVar, int i) {
        i = new StringBuilder("{'ad':[{'id':99999999,'url':'");
        i.append(this.B.b());
        i.append("', type='");
        i.append(CreativeType.HTML.getValue());
        i.append("'}],'n':1}");
        vVar.a(cVar, i.toString());
    }

    public void start() {
        super.start();
    }

    public void a(int i, int i2) {
        if (!this.C && !this.D) {
            this.B.d(i);
            this.B.e(i2);
            load();
        }
    }

    public void a(Activity activity, RelativeLayout relativeLayout) {
        try {
            this.x.d("showInterstitialAdInit");
            if (this.C && !this.D) {
                this.D = true;
                this.C = false;
                this.E = activity;
                start();
                u();
                this.e.setBackgroundColor(0);
                View relativeLayout2 = new RelativeLayout(activity);
                relativeLayout2.setBackgroundColor(0);
                relativeLayout.addView(relativeLayout2, new LayoutParams(-1, -1));
                this.e.addView(this.h.getAdView(), new LayoutParams(-1, -1));
                relativeLayout2.addView(this.e, new LayoutParams(-1, -1));
                this.h.getAdView().setVisibility(4);
            } else if (this.D != null) {
                this.x.w("interstitial ad is showing now");
            } else {
                if (this.C == null) {
                    this.x.w("interstitial ad is not ready");
                }
            }
        } catch (Throwable e) {
            this.x.d(e);
        }
    }

    public void r() {
        new Handler(Looper.getMainLooper()).post(new c(this));
    }

    private boolean w() {
        return s();
    }

    protected boolean s() {
        return AdSize.InterstitialForVideoBeforePlay.getValue() == this.B.getApt();
    }

    protected void c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        this.C = true;
    }

    protected void d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        r();
    }

    public d t() {
        return this.B;
    }

    protected void u() {
        if (this.E != null) {
            this.E.runOnUiThread(new d(this));
        }
    }

    public boolean v() {
        return this.C;
    }

    protected void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        u();
        this.D = null;
    }

    private View x() {
        if (this.y == null) {
            this.y = new RelativeLayout(this.f);
            this.y.setBackgroundColor(Color.argb(42, 0, 0, 0));
            this.z = new TextView(this.f);
            this.z.setTextColor(SupportMenu.CATEGORY_MASK);
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.y.addView(this.z, layoutParams);
        }
        this.A = new e(this, 6000, 1000).start();
        return this.y;
    }

    private void y() {
        if (!(this.y == null || this.y.getParent() == null)) {
            ((ViewGroup) this.y.getParent()).removeView(this.y);
        }
        if (this.A != null) {
            this.x.d("cancel countDownTimer before it finished");
            try {
                this.A.cancel();
            } catch (Throwable e) {
                this.x.d(e);
            }
        }
    }

    private LayoutParams z() {
        int screenDensity = (int) (20.0f * XAdSDKFoundationFacade.getInstance().getCommonUtils().getScreenDensity(this.f));
        LayoutParams layoutParams = new LayoutParams(screenDensity, screenDensity);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        return layoutParams;
    }
}
