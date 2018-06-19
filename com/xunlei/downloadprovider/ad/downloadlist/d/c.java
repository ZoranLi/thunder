package com.xunlei.downloadprovider.ad.downloadlist.d;

import android.text.TextUtils;
import android.view.View;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.downloadlist.c.d;
import com.xunlei.downloadprovider.ad.downloadlist.c.f;
import com.xunlei.downloadprovider.ad.downloadlist.c.h;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.g;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import com.xunlei.downloadprovider.download.tasklist.TaskListPageFragment.LOAD_TAG;
import com.xunlei.downloadprovider.download.tasklist.list.a;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: TaskAdCardController */
public final class c {
    e a;
    private a b;
    private com.xunlei.downloadprovider.download.tasklist.list.a.a c;

    public c(a aVar, com.xunlei.downloadprovider.download.tasklist.list.a.a aVar2) {
        this.b = aVar;
        this.c = aVar2;
    }

    public final void a(l lVar, int i, View view) {
        Set set = com.xunlei.downloadprovider.ad.downloadlist.b.a.a().c;
        String a = com.xunlei.downloadprovider.ad.downloadlist.a.a(this.c);
        if (!set.contains(a)) {
            set.add(a);
            f.a().a(new d(lVar, this.b.a(), String.valueOf(i), view));
        }
    }

    public static void a(l lVar, View view) {
        if (com.xunlei.downloadprovider.ad.common.f.a(lVar) && lVar.w()) {
            String s = lVar.s();
            if (!TextUtils.isEmpty(s)) {
                TaskStatInfo taskStatInfo = new TaskStatInfo(com.xunlei.downloadprovider.ad.common.c.a.a(lVar), s, null);
                DownloadAdditionInfo downloadAdditionInfo = new DownloadAdditionInfo();
                downloadAdditionInfo.b = lVar.p();
                downloadAdditionInfo.a = lVar.o();
                downloadAdditionInfo.f = true;
                g.a();
                g.a(s, lVar.o(), taskStatInfo, downloadAdditionInfo);
            }
        }
        lVar.onClick(view);
    }

    public final void a(l lVar, int i) {
        this.b.g.f.remove(LOAD_TAG.LOAD_LIST_AD);
        this.b.a(this.a);
        String a = com.xunlei.downloadprovider.ad.downloadlist.a.a(this.b.a());
        String y = lVar.y();
        String e = lVar.e();
        i = String.valueOf(i);
        lVar = lVar.a();
        Map hashMap = new HashMap();
        hashMap.put("ad_type", y);
        hashMap.put("tabid", a);
        hashMap.put("advid", e);
        hashMap.put("ad_position", i);
        hashMap.put("material", lVar);
        h.a("adv_downloadtab_close", hashMap, 0);
        com.xunlei.downloadprovider.ad.downloadlist.a.a[this.b.a()] = true;
        this.a = null;
    }
}
