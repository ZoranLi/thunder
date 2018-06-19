package com.xunlei.downloadprovider.ad.taskdetail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.ad.common.report.a;
import com.xunlei.downloadprovider.ad.taskdetail.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TaskDetailStyleDownloadListAdView */
final class l implements OnClickListener {
    final /* synthetic */ j a;

    l(j jVar) {
        this.a = jVar;
    }

    public final void onClick(View view) {
        view = this.a.b;
        c.a = true;
        this.a.d();
        String y = view.y();
        String e = view.e();
        String a = view.a();
        String adUIStyle = this.a.getAdUIStyle();
        view = view.v;
        Map hashMap = new HashMap();
        hashMap.put("ad_type", y);
        hashMap.put("advid", e);
        hashMap.put("material", a);
        hashMap.put("background", adUIStyle);
        y = "ad_content";
        switch (com.xunlei.downloadprovider.ad.taskdetail.a.c.a[view.ordinal()]) {
            case 1:
                view = "bigpic";
                break;
            case 2:
                view = "smallpic";
                break;
            case 3:
                view = "skin";
                break;
            case 4:
                view = "skinbrand";
                break;
            default:
                view = "";
                break;
        }
        hashMap.put(y, view);
        a.a("adv_download_detail_close", hashMap);
    }
}
