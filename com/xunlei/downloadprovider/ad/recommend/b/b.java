package com.xunlei.downloadprovider.ad.recommend.b;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.ad.common.h.a;
import com.xunlei.downloadprovider.ad.common.i;
import com.xunlei.downloadprovider.ad.recommend.a.h;
import com.xunlei.downloadprovider.ad.recommend.a.j;
import com.xunlei.downloadprovider.ad.recommend.a.k;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.g;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: RecommendAdPresenter */
public class b implements a, com.xunlei.downloadprovider.ad.recommend.a.a {
    private static final String a = "b";
    private final h b;
    private com.xunlei.downloadprovider.ad.recommend.a.b c;

    public b(h hVar) {
        this.b = hVar;
    }

    public final void a() {
        a(true);
        if (this.c.getContext() instanceof Activity) {
            h hVar = this.b;
            int b = this.c.b();
            a cVar = new c(this);
            i iVar = new i(10);
            iVar.a(new j(hVar, b, cVar));
            hVar.a.a(b, new k(hVar, iVar, b, cVar), "change");
            iVar.a();
        }
    }

    private void a(boolean z) {
        if (z) {
            this.c.f();
            this.c.a(false);
            return;
        }
        this.c.g();
        this.c.a(true);
    }

    public final void a(l lVar, View view, int i) {
        if (f.b(lVar)) {
            this.c.a(new d(this, lVar, view, i), new e(this));
            this.c.c();
            return;
        }
        b(lVar, view);
    }

    public final void b() {
        boolean z;
        if (this.b.a(this.c.b()).isEmpty()) {
            this.c.a(8);
        }
        h hVar = this.b;
        int b = this.c.b();
        Boolean bool = (Boolean) hVar.b.get(Integer.valueOf(b));
        if (bool == null) {
            z = false;
        } else {
            z = bool.booleanValue();
        }
        if (z) {
            List a = hVar.a(b);
            if (a.isEmpty()) {
                a(-11, "-11");
                return;
            } else {
                a(a);
                return;
            }
        }
        com.xunlei.downloadprovider.ad.recommend.a.b bVar = new com.xunlei.downloadprovider.ad.recommend.a.b();
        bVar.a = b;
        bVar.b = this;
        hVar.a(bVar);
    }

    public final void a(List<l> list) {
        if (!this.c.e()) {
            boolean a = this.c.a((List) list);
            if (a) {
                if (list != null) {
                    Collections.sort(list, new f(this));
                    com.xunlei.downloadprovider.ad.recommend.a.b bVar = this.c;
                    StringBuilder stringBuilder = new StringBuilder();
                    Set hashSet = new HashSet();
                    int i = 0;
                    for (l z : list) {
                        String z2 = z.z();
                        if (hashSet.add(z2)) {
                            if (i > 0) {
                                stringBuilder.append("&");
                            }
                            stringBuilder.append(z2);
                            i++;
                            if (i >= 2) {
                                break;
                            }
                        }
                    }
                    bVar.a(String.format(this.c.getContext().getResources().getString(R.string.task_list_recommend_use_ad_source), new Object[]{stringBuilder.toString()}));
                } else {
                    this.c.a(String.format(this.c.getContext().getResources().getString(R.string.task_list_recommend_use_ad_source), new Object[]{"合作方"}));
                }
            }
            if (a) {
                this.c.a(0);
            }
        }
    }

    public final void a(int i, String str) {
        if (this.c.e() == 0) {
            this.c.a();
            this.c.a(8);
        }
    }

    private static void b(l lVar, View view) {
        lVar.onClick(view);
        if (lVar.w() != null && f.a(lVar) != null && TextUtils.isEmpty(lVar.s()) == null && lVar.w() != null) {
            view = lVar.s();
            TaskStatInfo taskStatInfo = new TaskStatInfo(com.xunlei.downloadprovider.ad.common.c.a.a(lVar), view, null);
            DownloadAdditionInfo downloadAdditionInfo = new DownloadAdditionInfo();
            downloadAdditionInfo.b = lVar.p();
            downloadAdditionInfo.a = lVar.o();
            downloadAdditionInfo.f = true;
            g.a();
            g.a(view, lVar.o(), taskStatInfo, downloadAdditionInfo);
        }
    }
}
