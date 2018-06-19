package com.xunlei.downloadprovider.cooperation;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.net.thunderserver.request.BasicRequest;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.cooperation.data.CooperationScene;
import com.xunlei.downloadprovider.download.engine.task.n;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: CooperationHelper */
public final class c {
    private static c d;
    final ConcurrentHashMap<Integer, k> a = new ConcurrentHashMap(3);
    HashMap<Integer, CooperationScene> b = new HashMap();
    public final a c = new a();
    private m e;

    /* compiled from: CooperationHelper */
    private class a extends g {
        final /* synthetic */ c a;

        private a(c cVar) {
            this.a = cVar;
        }

        protected final void a() {
            XLThreadPool.execute(new f(this));
        }
    }

    private c() {
        g gVar = this.c;
        File cacheDir = BrothersApplication.getApplicationInstance().getCacheDir();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cacheDir.getAbsolutePath());
        stringBuilder.append(File.separator);
        stringBuilder.append("cooperation_list_v537.json");
        gVar.c = stringBuilder.toString();
        gVar.e = new HashMap(BasicRequest.buildCommonHeaders());
        gVar.e.put("Version-Code", "11100");
        gVar.e.put("Channel", AndroidConfig.getPartnerId());
        gVar.e.put("Peer-Id", AndroidConfig.getHubbleDeviceGUID());
        gVar.e.put("App-Type", DispatchConstants.ANDROID);
        this.c.c();
    }

    public static c a() {
        if (d == null) {
            d = new c();
        }
        return d;
    }

    public static void b() {
        a a = a.a();
        if (a.a.size() != 0) {
            Iterator it = a.a.iterator();
            while (it.hasNext()) {
                CooperationItem cooperationItem = (CooperationItem) it.next();
                n.a();
                long e = n.e(cooperationItem.getAppDownloadUrl());
                if (e != -1) {
                    new StringBuilder("加载任务成功以后 taskId ！= -1 ：").append(cooperationItem.getAppName());
                    n.a();
                    if (n.f(e).getCustomFlags() == 101) {
                        StringBuilder stringBuilder = new StringBuilder("加载任务成功以后");
                        stringBuilder.append(cooperationItem.getAppName());
                        stringBuilder.append("应用已经安装，删除任务");
                        n.a().c(false, e);
                    }
                }
            }
            a.a.clear();
        }
    }

    protected final void a(JSONObject jSONObject) {
        if (this.e == null) {
            this.e = new d(this);
        }
        m mVar = this.e;
        mVar.b.clear();
        mVar.c.clear();
        this.e.a(jSONObject);
    }

    public final CooperationItem a(int i) {
        if (l.b(i)) {
            k kVar = (k) this.a.get(Integer.valueOf(i));
            if (kVar != null) {
                i = (kVar.c < 0 || kVar.c >= kVar.b.size()) ? 0 : (CooperationItem) kVar.b.get(kVar.c);
                if (i != 0) {
                    return i.clone();
                }
            }
        }
        return null;
    }

    public final CooperationScene b(int i) {
        if (l.a(i)) {
            CooperationScene cooperationScene = (CooperationScene) this.b.get(Integer.valueOf(i));
            if (cooperationScene != null) {
                return cooperationScene.clone();
            }
        }
        return 0;
    }
}
