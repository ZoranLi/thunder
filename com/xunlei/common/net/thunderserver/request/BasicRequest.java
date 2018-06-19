package com.xunlei.common.net.thunderserver.request;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.SystemClock;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.net.volley.ResponseListenerWrapper;
import java.util.HashMap;
import java.util.Map;

public abstract class BasicRequest<T> extends Request<T> {
    private final HashMap<String, String> mHeaders;
    protected ResponseListenerWrapper<T> mListener;

    public static HashMap<String, String> buildCommonHeaders() {
        return new HashMap<String, String>() {
            {
                put("Peer-Id", AndroidConfig.getHubbleDeviceGUID());
                put("IMEI", AndroidConfig.getIMEI());
                put("Product-Id", AndroidConfig.getProductId());
                put("channelId", AndroidConfig.getPartnerId());
                put("channel", AndroidConfig.getPartnerId());
                put("Version-Code", "11100");
                put("Version-Name", "5.60.2.5510");
                put("Mobile-Type", DispatchConstants.ANDROID);
                put("App-Type", DispatchConstants.ANDROID);
                put("Platform-Version", VERSION.RELEASE);
                put("Account-Id", "40");
                put("Device-Id", AndroidConfig.getShouleiMemberDeviceId());
            }
        };
    }

    public BasicRequest(String str, a aVar) {
        super(str, new ResponseListenerWrapper(null, aVar));
        this.mListener = null;
        this.mHeaders = buildCommonHeaders();
    }

    public BasicRequest(int i, String str, b<T> bVar, a aVar) {
        this(i, str, new ResponseListenerWrapper(bVar, aVar));
    }

    private BasicRequest(int i, String str, ResponseListenerWrapper<T> responseListenerWrapper) {
        super(i, str, responseListenerWrapper);
        this.mListener = 0;
        this.mHeaders = buildCommonHeaders();
        this.mListener = responseListenerWrapper;
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        return this.mHeaders;
    }

    protected void deliverResponse(T t) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.mListener != null) {
            this.mListener.onResponse(t);
        }
        logDeliverResponseCostTime(getUrl(), elapsedRealtime);
    }

    public void cancel() {
        super.cancel();
        if (this.mListener != null) {
            this.mListener.clear();
        }
    }

    public final void putHeader(String str, String str2) {
        this.mHeaders.put(str, str2);
    }

    public final void putHeaders(Map<String, String> map) {
        this.mHeaders.putAll(map);
    }

    public static void logDeliverResponseCostTime(String str, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        j = Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId() ? 1 : null;
        if (elapsedRealtime >= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(j != null ? "In main thread " : "");
            stringBuilder.append("deliverResponse costTime:");
            stringBuilder.append(elapsedRealtime);
            stringBuilder.append("ms, url = ");
            stringBuilder.append(str);
        }
    }
}
