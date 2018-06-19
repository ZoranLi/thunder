package com.xunlei.downloadprovider.ad.taskdetail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import com.xunlei.downloadprovider.ad.cache.b;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.ad.taskdetail.view.a;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.g;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: TaskDetailAdController */
public class c extends a {
    private static final String f = "c";
    public l e = null;
    private boolean g = false;
    private a h = null;

    public static void d() {
    }

    public c(Context context) {
        super(context);
    }

    public final void c() {
        e();
        if (a.b()) {
            d a = d.a();
            List arrayList = new ArrayList(1);
            if (!a.a.isEmpty()) {
                Iterator it = a.a.iterator();
                while (it.hasNext()) {
                    l lVar = (l) it.next();
                    it.remove();
                    if (lVar != null && lVar.I()) {
                        List a2 = b.a().a(lVar.A(), lVar.d(), lVar.v, lVar.v.mRequiredSize);
                        if (!a2.isEmpty()) {
                            l lVar2 = (l) a2.get(0);
                            if (!(lVar2 == null || lVar.G() == null || lVar2.G() == null || lVar.G().getClass() != lVar2.G().getClass())) {
                                lVar.a(lVar2.G());
                            }
                        }
                    }
                    arrayList.add(lVar);
                }
            }
            this.e = !arrayList.isEmpty() ? (l) arrayList.get(0) : null;
            h();
            d.a().b();
        }
    }

    public final void e() {
        this.e = null;
        if (this.h != null) {
            this.h.d();
            this.h = null;
        }
        h();
        com.xunlei.downloadprovider.ad.taskdetail.a.a.a().a.clear();
        this.g = false;
    }

    public final void f() {
        e();
        com.xunlei.downloadprovider.ad.taskdetail.a.a.b();
    }

    public final void a(a aVar) {
        this.h = aVar;
        g();
        l lVar = this.e;
        if (!a.b() || lVar == null) {
            aVar.d();
            return;
        }
        new StringBuilder("process prepare showAdView. mIsShowAdViewInvoked: ").append(this.g);
        if (!this.g) {
            StringBuilder stringBuilder = new StringBuilder("isAdVisible(): ");
            stringBuilder.append(a());
            stringBuilder.append(" isAdEnable(): ");
            stringBuilder.append(a.b());
            if (a() && a.b()) {
                aVar.a(lVar);
            }
            this.g = true;
        }
    }

    public final void a(@NonNull a aVar, @NonNull l lVar) {
        if (!com.xunlei.downloadprovider.ad.taskdetail.a.a.a().b(1)) {
            Map hashMap = new HashMap();
            hashMap.put("background", aVar.getAdUIStyle());
            lVar.E = hashMap;
            lVar.a((View) aVar);
            com.xunlei.downloadprovider.ad.taskdetail.a.a.a().a(1);
        }
    }

    private void h() {
        if (this.c != null) {
            this.c.a();
        }
    }

    public final void g() {
        if (!com.xunlei.downloadprovider.ad.taskdetail.a.a.a().b(0) && a() && a.b()) {
            Map hashMap = new HashMap();
            hashMap.put("net_type", com.xunlei.downloadprovider.ad.common.report.a.a());
            com.xunlei.downloadprovider.ad.common.report.a.a("adv_download_detail_pv", hashMap);
            com.xunlei.downloadprovider.ad.taskdetail.a.a.a().a(0);
        }
    }

    public final void b(@NonNull a aVar, @NonNull l lVar) {
        Map hashMap = new HashMap();
        hashMap.put("background", aVar.getAdUIStyle());
        lVar.F = hashMap;
        lVar.onClick(aVar);
        if (f.a(lVar) != null && lVar.u() == 2 && TextUtils.isEmpty(lVar.s()) == null) {
            aVar = lVar.s();
            TaskStatInfo taskStatInfo = new TaskStatInfo(aVar, null);
            taskStatInfo.a = com.xunlei.downloadprovider.ad.common.c.a.a(lVar);
            DownloadAdditionInfo downloadAdditionInfo = new DownloadAdditionInfo();
            downloadAdditionInfo.b = lVar.p();
            downloadAdditionInfo.a = lVar.o();
            downloadAdditionInfo.f = true;
            if (this.b != null) {
                g.a();
                g.a(aVar, lVar.o(), taskStatInfo, downloadAdditionInfo);
                return;
            }
            new StringBuilder("context can not cast to ThunderTask. mContext: ").append(this.b.getClass().getSimpleName());
        }
    }
}
