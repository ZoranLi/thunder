package com.xunlei.common.net.volley;

import android.os.SystemClock;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.android.volley.toolbox.u;
import com.xunlei.common.net.thunderserver.request.BasicRequest;
import org.json.JSONObject;

public class BaseJsonObjectRequest extends u {
    private ResponseListenerWrapper mListenerWrapper;

    public BaseJsonObjectRequest(int i, String str, JSONObject jSONObject, b<JSONObject> bVar, a aVar) {
        this(i, str, jSONObject, new ResponseListenerWrapper(bVar, aVar));
    }

    public BaseJsonObjectRequest(String str, JSONObject jSONObject, b<JSONObject> bVar, a aVar) {
        this(jSONObject == null ? 0 : 1, str, jSONObject, new ResponseListenerWrapper(bVar, aVar));
    }

    private BaseJsonObjectRequest(int i, String str, JSONObject jSONObject, ResponseListenerWrapper<JSONObject> responseListenerWrapper) {
        super(i, str, jSONObject, responseListenerWrapper, responseListenerWrapper);
        this.mListenerWrapper = responseListenerWrapper;
    }

    public void cancel() {
        super.cancel();
        if (this.mListenerWrapper != null) {
            this.mListenerWrapper.clear();
        }
    }

    protected void deliverResponse(JSONObject jSONObject) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        super.deliverResponse(jSONObject);
        BasicRequest.logDeliverResponseCostTime(getUrl(), elapsedRealtime);
    }
}
