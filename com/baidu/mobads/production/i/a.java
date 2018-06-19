package com.baidu.mobads.production.i;

import android.content.Context;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.production.c.c;
import com.baidu.mobads.vo.d;

public class a extends c {
    private com.baidu.mobads.production.h.a w;

    public /* synthetic */ IXAdRequestInfo getAdRequestInfo() {
        return r();
    }

    public a(Context context, String str) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(null);
        this.o = SlotType.SLOT_TYPE_PREROLL;
        this.w = new com.baidu.mobads.production.h.a(getApplicationContext(), getActivity(), SlotType.SLOT_TYPE_PREROLL, this);
        this.w.f(AdSize.PrerollVideoNative.getValue());
        this.w.d(str);
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        requestParameters = requestParameters.getHeight();
        if (width > 0 && requestParameters > null) {
            this.w.d(width);
            this.w.e(requestParameters);
        }
    }

    public d r() {
        return this.w;
    }

    public void request() {
        super.a(this.w);
    }
}
