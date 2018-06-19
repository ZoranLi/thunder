package com.xunlei.common.net.volley;

import android.os.SystemClock;
import com.android.volley.j;
import com.android.volley.n;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.android.volley.toolbox.aa;
import com.xunlei.common.net.thunderserver.request.BasicRequest;

public class BaseStringRequest extends aa {
    public BaseStringRequest(int i, String str, b<String> bVar, a aVar) {
        super(i, str, bVar, aVar);
    }

    public BaseStringRequest(String str, b<String> bVar, a aVar) {
        super(str, bVar, aVar);
    }

    protected void deliverResponse(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        super.deliverResponse(str);
        BasicRequest.logDeliverResponseCostTime(getUrl(), elapsedRealtime);
    }

    public n<String> parseNetworkResponse(j jVar) {
        try {
            return super.parseNetworkResponse(jVar);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(e.getMessage());
            stringBuilder.append(" dataLength = ");
            stringBuilder.append(jVar.b.length);
            stringBuilder.append(" url = ");
            stringBuilder.append(getUrl());
            throw new OutOfMemoryError(stringBuilder.toString());
        }
    }
}
