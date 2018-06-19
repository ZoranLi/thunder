package com.xunlei.downloadprovider.ad.d;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.xunlei.common.androidutil.HandlerUtil$MessageListener;
import com.xunlei.common.androidutil.HandlerUtil$StaticHandler;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.g;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ShortMovieDetailAdController */
public final class f {
    public final h a = new h();
    public boolean b = false;
    public a c = null;
    HandlerUtil$MessageListener d = new g(this);
    private Handler e = new HandlerUtil$StaticHandler(this.d);

    /* compiled from: ShortMovieDetailAdController */
    public interface a {
        void a();
    }

    public static void a(Context context, View view, Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            lVar.onClick(view);
            if (com.xunlei.downloadprovider.ad.common.f.a(lVar) != null && lVar.u() == 2) {
                view = lVar.s();
                if (!TextUtils.isEmpty(view)) {
                    DownloadAdditionInfo downloadAdditionInfo = new DownloadAdditionInfo();
                    downloadAdditionInfo.b = lVar.p();
                    downloadAdditionInfo.a = lVar.o();
                    downloadAdditionInfo.f = true;
                    TaskStatInfo taskStatInfo = new TaskStatInfo(view, null);
                    taskStatInfo.a = com.xunlei.downloadprovider.ad.common.c.a.a(lVar);
                    if (context != null) {
                        g.a();
                        g.a(view, lVar.o(), taskStatInfo, downloadAdditionInfo);
                        return;
                    }
                    throw new RuntimeException("this context must implements ThunderTask");
                }
            }
        }
    }

    public static void a(String str) {
        if (b(str) && !com.xunlei.downloadprovider.ad.d.a.a.a().b(com.xunlei.downloadprovider.ad.d.a.a.a(str))) {
            Map hashMap = new HashMap();
            hashMap.put("type", str);
            com.xunlei.downloadprovider.ad.common.report.a.a("adv_shortvideo_detail_pv", hashMap, true);
            com.xunlei.downloadprovider.ad.d.a.a.a().a(com.xunlei.downloadprovider.ad.d.a.a.a(str));
        }
    }

    public static boolean b(String str) {
        int hashCode = str.hashCode();
        if (hashCode != -1306084975) {
            if (hashCode == 93997959) {
                if (str.equals("brand") != null) {
                    str = null;
                    switch (str) {
                        case null:
                            return false;
                        case 1:
                            return d.a().p.d();
                        default:
                            return false;
                    }
                }
            }
        } else if (str.equals("effect") != null) {
            str = true;
            switch (str) {
                case null:
                    return false;
                case 1:
                    return d.a().p.d();
                default:
                    return false;
            }
        }
        str = -1;
        switch (str) {
            case null:
                return false;
            case 1:
                return d.a().p.d();
            default:
                return false;
        }
    }

    final void a(l lVar) {
        StringBuilder stringBuilder = new StringBuilder("updateBrandAd adInfo: ");
        if (lVar == null) {
            lVar = "null";
        }
        stringBuilder.append(lVar);
        if (this.c != null) {
            this.c.a();
        }
    }
}
