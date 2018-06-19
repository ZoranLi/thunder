package com.alibaba.baichuan.android.trade.adapter.mtop;

import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import org.json.JSONObject;

public final class a implements b {

    private static class a {
        public static a a = new a();
    }

    private a() {
    }

    public static MtopRequest a(NetworkRequest networkRequest) {
        if (TextUtils.isEmpty(networkRequest.apiVersion)) {
            networkRequest.apiVersion = "1.0";
        }
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setApiName(networkRequest.apiName);
        mtopRequest.setVersion(networkRequest.apiVersion);
        mtopRequest.setNeedEcode(networkRequest.needLogin);
        mtopRequest.setNeedSession(true);
        if (networkRequest.paramMap != null) {
            JSONObject a = com.alibaba.baichuan.android.trade.utils.f.a.a(mtopRequest.getData());
            if (a == null) {
                a = new JSONObject();
            }
            for (Entry entry : networkRequest.paramMap.entrySet()) {
                if (entry.getValue() != null) {
                    try {
                        a.put((String) entry.getKey(), ((Serializable) entry.getValue()).toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            mtopRequest.setData(a.toString());
        }
        return mtopRequest;
    }

    public static NetworkResponse b(MtopResponse mtopResponse) {
        NetworkResponse networkResponse = new NetworkResponse();
        if (mtopResponse == null) {
            return networkResponse;
        }
        networkResponse.byteData = mtopResponse.getBytedata();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mtopResponse.getResponseCode());
        networkResponse.httpCode = stringBuilder.toString();
        networkResponse.errorCode = mtopResponse.getRetCode();
        networkResponse.errorMsg = mtopResponse.getRetMsg();
        networkResponse.isSuccess = mtopResponse.isApiSuccess();
        if (mtopResponse.getDataJsonObject() != null) {
            String jSONObject = mtopResponse.getDataJsonObject().toString();
            networkResponse.data = (Map) com.alibaba.baichuan.android.trade.utils.f.a.a(jSONObject, Map.class);
            networkResponse.jsonData = jSONObject;
        }
        return networkResponse;
    }

    public final boolean a(com.alibaba.baichuan.android.trade.adapter.mtop.b.a aVar, NetworkRequest networkRequest) {
        if (networkRequest == null) {
            aVar.b(null);
            return false;
        }
        MtopBusiness build = MtopBusiness.build(a(networkRequest), com.alibaba.baichuan.android.trade.e.a.g().e());
        if (networkRequest.needWua) {
            build.useWua();
        }
        if (networkRequest.needAuth && !AlibcContext.i) {
            build.setNeedAuth(networkRequest.authParams, true);
        }
        if (networkRequest.isPost) {
            build.reqMethod(MethodEnum.POST);
        }
        if (networkRequest.extHeaders != null && networkRequest.extHeaders.size() > 0) {
            build.headers(networkRequest.extHeaders);
        }
        build.setSocketTimeoutMilliSecond(15000);
        build.setConnectionTimeoutMilliSecond(15000);
        build.registeListener(new c(this, aVar, networkRequest)).asyncRequest();
        return true;
    }

    public static void a(MtopResponse mtopResponse) {
        if (mtopResponse.isApiSuccess()) {
            AlibcContext.b();
            return;
        }
        StringBuilder stringBuilder;
        if (mtopResponse.isSessionInvalid()) {
            stringBuilder = new StringBuilder("session 失效， do autologin or login business msg = ");
        } else {
            if (!(mtopResponse.isSystemError() || mtopResponse.isNetworkError() || mtopResponse.isExpiredRequest() || mtopResponse.is41XResult() || mtopResponse.isApiLockedResult())) {
                if (!mtopResponse.isMtopSdkError()) {
                    stringBuilder = new StringBuilder("业务错误 msg =");
                }
            }
            stringBuilder = new StringBuilder("系统错误，网络错误，防刷，防雪崩 msg =");
        }
        stringBuilder.append(mtopResponse.getRetMsg());
        com.alibaba.baichuan.android.trade.utils.g.a.b();
    }
}
