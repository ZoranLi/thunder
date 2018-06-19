package com.xunlei.downloadprovider.download.tasklist.list.banner;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.RedPacketConditionsInfo;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import org.json.JSONObject;

/* compiled from: BannerOnlineServerHelper */
final class h implements b<JSONObject> {
    final /* synthetic */ a a;
    final /* synthetic */ boolean b;
    final /* synthetic */ DownloadTaskInfo c;
    final /* synthetic */ RedPacketConditionsInfo d;
    final /* synthetic */ long e;

    h(a aVar, boolean z, DownloadTaskInfo downloadTaskInfo, RedPacketConditionsInfo redPacketConditionsInfo, long j) {
        this.a = aVar;
        this.b = z;
        this.c = downloadTaskInfo;
        this.d = redPacketConditionsInfo;
        this.e = j;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (ITagManager.SUCCESS.equals(jSONObject.optString("result"))) {
            obj = jSONObject.optInt("status");
            boolean z = true;
            if (this.b) {
                a aVar = this.a;
                if (obj != null) {
                    z = false;
                }
                aVar.a(z);
                return;
            } else if (obj == 1) {
                this.a.a();
                return;
            } else {
                this.a.a(this.c, this.d, this.e);
                return;
            }
        }
        this.a.a();
    }
}
