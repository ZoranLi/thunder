package com.xunlei.downloadprovider.download.engine.shub;

import com.android.volley.Request;
import com.android.volley.d;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.download.engine.shub.b.a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GcidManager */
public final class c implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ String b;
    final /* synthetic */ a c;
    final /* synthetic */ b d;

    public c(b bVar, b bVar2, String str, a aVar) {
        this.d = bVar;
        this.a = bVar2;
        this.b = str;
        this.c = aVar;
    }

    public final void run() {
        b bVar = this.a;
        bVar.c = new d(this);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", bVar.a);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Request sigJsonObjectRequest = new SigJsonObjectRequest(1, bVar.d, jSONObject, new e(bVar), new f(bVar));
        sigJsonObjectRequest.setRetryPolicy(new d(ReaderCallback.GET_BAR_ANIMATING, 1, 1.0f));
        sigJsonObjectRequest.setShouldCache(false);
        VolleyRequestManager.getRequestQueue().a(sigJsonObjectRequest);
    }
}
