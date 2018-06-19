package com.xunlei.downloadprovider.download.tasklist.list.banner;

import com.android.volley.Request;
import com.android.volley.d;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.RedPacketConditionsInfo;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: BannerOnlineServerHelper */
final class e implements Runnable {
    final /* synthetic */ DownloadTaskInfo a;
    final /* synthetic */ RedPacketConditionsInfo b;
    final /* synthetic */ a c;

    e(DownloadTaskInfo downloadTaskInfo, RedPacketConditionsInfo redPacketConditionsInfo, a aVar) {
        this.a = downloadTaskInfo;
        this.b = redPacketConditionsInfo;
        this.c = aVar;
    }

    public final void run() {
        long c;
        int i;
        LoginHelper.a();
        if (l.c()) {
            c = LoginHelper.a().g.c();
            i = 1;
        } else {
            c = -1;
            i = 0;
        }
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/red_packets_cli/get_gift_list?uid=");
        stringBuilder.append(c);
        stringBuilder.append("&check=");
        stringBuilder.append(i);
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, stringBuilder.toString(), new f(this), new g(this));
        sigJsonObjectRequest.setShouldCache(false);
        sigJsonObjectRequest.setRetryPolicy(new d(3000, 1, 1.0f));
        VolleyRequestManager.getRequestQueue().a(sigJsonObjectRequest);
    }
}
