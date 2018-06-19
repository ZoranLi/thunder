package com.xunlei.downloadprovider.ad.d;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.home.a;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.g;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AdBaseInfoViewHolder */
final class c implements OnClickListener {
    final /* synthetic */ l a;
    final /* synthetic */ a b;

    c(a aVar, l lVar) {
        this.b = aVar;
        this.a = lVar;
    }

    public final void onClick(View view) {
        view = this.a.e();
        Object a = this.a.a();
        Map hashMap = new HashMap();
        hashMap.put("advid", view);
        hashMap.put("ad_type", "ssp");
        view = "material";
        if (a == null) {
            a = "";
        }
        hashMap.put(view, a);
        a.a("adv_homeflow_bigvideo_detail_click", hashMap);
        a.a(this.a, "video_detail_button");
        this.a.onClick(this.b.m);
        if (this.a.w() != null) {
            view = this.a.s();
            if (!TextUtils.isEmpty(view)) {
                DownloadAdditionInfo downloadAdditionInfo = new DownloadAdditionInfo();
                downloadAdditionInfo.b = this.a.p();
                downloadAdditionInfo.a = this.a.o();
                downloadAdditionInfo.f = true;
                TaskStatInfo taskStatInfo = new TaskStatInfo(com.xunlei.downloadprovider.ad.common.c.a.a(this.a), view, null);
                g.a();
                g.a(view, this.a.o(), taskStatInfo, downloadAdditionInfo);
            }
        }
    }
}
