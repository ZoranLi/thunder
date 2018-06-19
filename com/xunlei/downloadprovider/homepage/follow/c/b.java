package com.xunlei.downloadprovider.homepage.follow.c;

import android.os.Build;
import com.android.volley.Request;
import com.android.volley.d;
import com.taobao.accs.common.Constants;
import com.xunlei.downloadprovider.member.payment.a.e$d;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FollowNetworkHelper */
public final class b implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ boolean b;
    final /* synthetic */ e$d c;
    final /* synthetic */ a d;

    public b(a aVar, long j, boolean z, e$d com_xunlei_downloadprovider_member_payment_a_e_d) {
        this.d = aVar;
        this.a = j;
        this.b = z;
        this.c = com_xunlei_downloadprovider_member_payment_a_e_d;
    }

    public final void run() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("follow_uid", String.valueOf(this.a));
            jSONObject.put(Constants.KEY_MODEL, Build.MODEL);
            jSONObject.put("need_recommend", this.b ? "1" : "0");
            Request arVar = new ar(1, "http://api-shoulei-ssl.xunlei.com/follow/follow_v2", jSONObject, new c(this), new d(this));
            arVar.setRetryPolicy(new d(10000, 1, 1.0f));
            this.d.a(arVar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
