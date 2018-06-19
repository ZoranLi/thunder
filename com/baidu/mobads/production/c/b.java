package com.baidu.mobads.production.c;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.vo.d;
import java.util.HashMap;

public class b extends d {
    private int a;
    private int l;
    private int m;

    public b(Context context, Activity activity, SlotType slotType) {
        super(context, activity, slotType);
        this.a = 1;
        this.l = 1;
        this.m = 1;
        this.b = this.i.replaceURLWithSupportProtocol("http://mobads.baidu.com/cpro/ui/mads.php");
        a("androidfeed");
    }

    protected HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap();
        if (this.j) {
            hashMap.put(IXAdRequestInfo.FET, "ANTI,MSSP,NMON,HTML,VIDEO");
        } else {
            hashMap.put(IXAdRequestInfo.FET, "ANTI,MSSP,NMON,HTML,CLICK2VIDEO,PAUSE,VIDEO");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.l);
        hashMap.put("pos", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.m);
        hashMap.put("seq", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        hashMap.put("viewid", stringBuilder.toString());
        return hashMap;
    }

    public void a(int i) {
        this.a = i;
    }

    public void b(int i) {
        this.l = i;
    }

    public void c(int i) {
        this.m = i;
    }

    public String b() {
        return super.b();
    }
}
