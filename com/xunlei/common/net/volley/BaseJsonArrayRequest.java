package com.xunlei.common.net.volley;

import android.os.SystemClock;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.android.volley.toolbox.t;
import com.xunlei.common.net.thunderserver.request.BasicRequest;
import org.json.JSONArray;

public class BaseJsonArrayRequest extends t {
    public BaseJsonArrayRequest(String str, b<JSONArray> bVar, a aVar) {
        super(str, bVar, aVar);
    }

    public BaseJsonArrayRequest(int i, String str, JSONArray jSONArray, b<JSONArray> bVar, a aVar) {
        super(i, str, jSONArray, bVar, aVar);
    }

    protected void deliverResponse(JSONArray jSONArray) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        super.deliverResponse(jSONArray);
        BasicRequest.logDeliverResponseCostTime(getUrl(), elapsedRealtime);
    }
}
