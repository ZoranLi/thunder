package com.baidu.mobads.production.a;

import android.content.Context;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.d.c;
import com.baidu.mobads.production.b;
import com.baidu.mobads.production.v;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.vo.d;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.util.HashMap;
import org.json.JSONObject;

public class a extends b implements IXNonLinearAdSlot {
    private c w;

    public void c(IXAdResponseInfo iXAdResponseInfo) {
    }

    protected void d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    public /* synthetic */ IXAdRequestInfo getAdRequestInfo() {
        return q();
    }

    public a(Context context, RelativeLayout relativeLayout, String str, boolean z) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.o = SlotType.SLOT_TYPE_BANNER;
        XAdSDKFoundationFacade.getInstance().getAdConstants();
        this.w = new c(getApplicationContext(), getActivity(), this.o);
        this.w.f(AdSize.Banner.getValue());
        this.w.d(str);
        com.baidu.mobads.vo.b bVar = (com.baidu.mobads.vo.b) this.w.d();
        bVar.a(z);
        JSONObject attribute = bVar.getAttribute();
        if (attribute == null) {
            attribute = new JSONObject();
        }
        try {
            attribute.put("ABILITY", "BANNER_CLOSE,PAUSE,UNLIMITED_BANNER_SIZE,");
        } catch (boolean z2) {
            z2.printStackTrace();
        }
        bVar.a(attribute);
        e(str);
    }

    public void g() {
        load();
    }

    protected void h() {
        this.m = 10000;
    }

    public void request() {
        a(this.w);
        try {
            WebView webView = new WebView(getActivity());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void b(d dVar) {
        this.k = dVar;
        k();
        a(null, null, ReaderCallback.GET_BAR_ANIMATING);
    }

    protected void a(c cVar, v vVar, int i) {
        cVar = new StringBuilder("{'ad':[{'id':99999999,'url':'");
        cVar.append(this.w.b());
        cVar.append("', type='");
        cVar.append(CreativeType.HTML.getValue());
        cVar.append("'}],'n':1}");
        try {
            setAdResponseInfo(new com.baidu.mobads.vo.c(cVar.toString()));
        } catch (c cVar2) {
            cVar2.printStackTrace();
        }
        b("XAdMouldeLoader ad-server requesting success");
    }

    protected void c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        start();
    }

    public d q() {
        return this.w;
    }

    protected void c() {
        new Thread(new b(this)).start();
    }

    protected void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        super.p();
        dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_USER_CLOSE));
    }
}
