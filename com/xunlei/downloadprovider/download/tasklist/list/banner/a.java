package com.xunlei.downloadprovider.download.tasklist.list.banner;

import com.android.volley.Request;
import com.android.volley.d;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.RedPacketConditionsInfo;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BannerOnlineServerHelper */
final class a {
    public static void a(DownloadTaskInfo downloadTaskInfo, RedPacketConditionsInfo redPacketConditionsInfo, long j, boolean z, com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a aVar) {
        long c = LoginHelper.a().g.c();
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/red_packets_cli/rad_qualification?uid=");
        stringBuilder.append(c);
        Request sigJsonObjectRequest = new SigJsonObjectRequest(0, stringBuilder.toString(), new h(aVar, z, downloadTaskInfo, redPacketConditionsInfo, j), new i(aVar));
        sigJsonObjectRequest.setShouldCache(false);
        sigJsonObjectRequest.setRetryPolicy(new d(3000, 1, 1.0f));
        VolleyRequestManager.getRequestQueue().a(sigJsonObjectRequest);
    }

    static JSONObject a() {
        String hubbleDeviceGUID = AndroidConfig.getHubbleDeviceGUID(BrothersApplication.getApplicationInstance());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.xunlei.analytics.c.d.a, hubbleDeviceGUID);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
