package com.baidu.mobads.production.b;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.f.a;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.d.c;
import com.baidu.mobads.production.v;
import com.baidu.mobads.vo.d;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.util.HashMap;

public class b extends com.baidu.mobads.production.b implements IXNonLinearAdSlot {
    private d w;

    public void c(IXAdResponseInfo iXAdResponseInfo) {
    }

    protected void d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    public /* synthetic */ IXAdRequestInfo getAdRequestInfo() {
        return q();
    }

    public b(Context context, RelativeLayout relativeLayout, String str, String str2) {
        super(context);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.o = SlotType.SLOT_TYPE_CPU;
        this.w = new d(getApplicationContext(), getActivity(), this.o, str, str2);
    }

    public void g() {
        load();
    }

    protected void h() {
        this.m = 10000;
    }

    public void request() {
        a(this.w);
    }

    protected void b(d dVar) {
        this.k = dVar;
        k();
        a(null, null, ReaderCallback.GET_BAR_ANIMATING);
    }

    protected void a(c cVar, v vVar, int i) {
        cVar = new StringBuilder("{'ad':[{'id':99999999,'html':'");
        cVar.append(this.w.c());
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

    protected void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        super.p();
        dispatchEvent(new a(IXAdEvent.AD_USER_CLOSE));
    }
}
