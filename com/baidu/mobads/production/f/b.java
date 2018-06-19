package com.baidu.mobads.production.f;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
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
import org.json.JSONObject;

public class b extends com.baidu.mobads.production.b implements a {
    private boolean A = false;
    private boolean B = false;
    private Activity C;
    private RelativeLayout D;
    private Boolean E;
    public final String w = "html5_intersitial";
    protected final IXAdLogger x = XAdSDKFoundationFacade.getInstance().getAdLogger();
    private d y;
    private AdSize z;

    public void a(int i, int i2) {
    }

    public void a(Activity activity, RelativeLayout relativeLayout) {
    }

    public void c(IXAdResponseInfo iXAdResponseInfo) {
    }

    protected void d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    public void g() {
    }

    public /* synthetic */ IXAdRequestInfo getAdRequestInfo() {
        return r();
    }

    public b(Context context, RelativeLayout relativeLayout, Boolean bool, String str) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.o = SlotType.SLOT_TYPE_INTERSTITIAL;
        this.E = bool;
        this.z = AdSize.InterstitialGame;
        XAdSDKFoundationFacade.getInstance().getAdConstants();
        this.y = new d(getApplicationContext(), getActivity(), this.o, Boolean.valueOf(true));
        this.y.d(str);
        this.y.f(AdSize.InterstitialGame.getValue());
        com.baidu.mobads.vo.b bVar = (com.baidu.mobads.vo.b) this.y.d();
        JSONObject attribute = bVar.getAttribute();
        if (attribute == null) {
            attribute = new JSONObject();
        }
        try {
            attribute.put("ABILITY", "PAUSE,");
        } catch (Boolean bool2) {
            bool2.printStackTrace();
        }
        bVar.a(attribute);
        e(str);
    }

    protected void h() {
        this.m = 8000;
    }

    public void request() {
        super.a(this.y);
    }

    protected void a(c cVar, v vVar, int i) {
        i = new StringBuilder("{'ad':[{'id':99999999,'url':'");
        i.append(this.y.b());
        i.append("', type='");
        i.append(CreativeType.HTML.getValue());
        i.append("'}],'n':1}");
        vVar.a(cVar, i.toString());
    }

    public void start() {
        super.start();
    }

    public void a(Activity activity) {
        if (this.A && !this.B) {
            this.B = true;
            this.A = false;
            this.C = activity;
            start();
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            this.e.setBackgroundColor(0);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = rect.top;
            ViewGroup b = b((Context) activity);
            this.D = new RelativeLayout(activity);
            this.D.addView(this.e, layoutParams);
            b.addView(this.D, new RelativeLayout.LayoutParams(-1, -1));
            this.e.setFocusableInTouchMode(true);
            this.e.setFocusable(true);
            this.e.requestFocus();
        } else if (this.B != null) {
            this.x.w("interstitial ad is showing now");
        } else {
            if (this.A == null) {
                this.x.w("interstitial ad is not ready");
            }
        }
    }

    private ViewGroup b(Context context) {
        return (ViewGroup) ((Activity) context).getWindow().getDecorView();
    }

    protected void c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        this.A = true;
        if (hashMap != null) {
            iXAdContainer = hashMap.get("type");
            if (iXAdContainer != null) {
                ((String) iXAdContainer).equals("video");
            }
        }
    }

    public d r() {
        return this.y;
    }

    public void s() {
        if (this.C != null) {
            this.C.runOnUiThread(new c(this));
        }
    }

    public boolean v() {
        return this.A;
    }

    protected void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        s();
        this.B = null;
    }

    public void q() {
        load();
    }
}
