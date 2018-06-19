package com.xunlei.downloadprovider.ad.downloadlist.c;

import com.xunlei.downloadprovider.ad.downloadlist.c.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CommendADShowPVReporter */
public final class c implements i {
    private String a;
    private String b;
    private int c;

    public c(a aVar) {
        this.a = com.xunlei.downloadprovider.ad.downloadlist.a.a(aVar.b());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(aVar.c());
        this.b = stringBuilder.toString();
        this.c = aVar.b();
    }

    public final int a() {
        return this.c;
    }

    public final boolean b() {
        return !this.b.equals("1");
    }

    public final void c() {
        String str = this.a;
        String str2 = this.b;
        Map hashMap = new HashMap();
        hashMap.put("tabid", str);
        hashMap.put("ad_position", str2);
        h.a("adv_download_ad_tab_show", hashMap, true);
    }
}
