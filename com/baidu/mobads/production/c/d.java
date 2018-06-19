package com.baidu.mobads.production.c;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;

public class d extends com.baidu.mobads.vo.d {
    public d(Context context, Activity activity, SlotType slotType) {
        super(context, activity, slotType);
        this.b = this.i.replaceURLWithSupportProtocol("http://mobads.baidu.com/cpro/ui/mads.php");
        a("androidfeed");
    }

    protected HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap();
        if (this.j) {
            hashMap.put(IXAdRequestInfo.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
        } else {
            hashMap.put(IXAdRequestInfo.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
        }
        return hashMap;
    }

    public String b() {
        return super.b();
    }
}
