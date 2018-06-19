package com.baidu.mobads.production.b;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import java.util.HashMap;

public class d extends com.baidu.mobads.vo.d {
    public String b() {
        return "http://127.0.0.1";
    }

    public d(Context context, Activity activity, SlotType slotType, String str, String str2) {
        super(context, activity, slotType);
        this.b = new c(context.getApplicationContext(), str2, str).a();
    }

    protected HashMap<String, String> a() {
        return new HashMap();
    }

    public String c() {
        return this.b;
    }
}
