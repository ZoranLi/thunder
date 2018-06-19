package com.xunlei.tdlive.protocol;

import android.content.Context;
import android.os.SystemClock;
import com.android.volley.j;
import com.google.gson.Gson;
import com.xunlei.tdlive.modal.JsonWrapper;
import com.xunlei.tdlive.sdk.R;
import com.xunlei.tdlive.util.XLog;
import com.xunlei.tdlive.util.e;
import com.xunlei.tdlive.util.e.a;
import com.xunlei.tdlive.util.e.b;
import com.xunlei.tdlive.util.e.c;
import com.xunlei.tdlive.util.e.f;
import com.xunlei.tdlive.util.e.h;
import com.xunlei.tdlive.util.l;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public abstract class XLLiveRequest {
    public static final int ERROR_ALEARDY_FOLLOW = -1004;
    public static final int ERROR_INVALID_SESSION = -400;
    public static final int ERROR_INVALID_VERSION = -403;
    public static final int ERROR_NETWORK = -3;
    public static final int ERROR_NOT_FOLLOW = -1005;
    public static final int ERROR_PARSER = -2;
    public static final int ERROR_SERVER = -4;
    public static final int ERROR_UNKNOWN = -1;
    private static final int MAX_LOG_LENGTH = Integer.MAX_VALUE;
    public static final String TAG = "XLLiveRequest";
    private static IDNSCache sDnsCache;
    private static Map<String, String> sGlobalCookies;
    private static INetworkHandler sNetworHandler;
    private static long sRequestId;
    private static Map<Class<?>, IRequestResultMonitor> sRequestResultMonitor;
    private b mHandler;
    private e mHttpUtils = new e();
    private long mId;
    private JsonCallBack mJsonCallBack;
    private long mLastSend;
    private ObjectCallBack mObjectCallBack;
    private long mTimeOut;
    private String mURL;

    public interface IDNSCache {
        String did();

        String disc();

        String hit(String str);
    }

    public interface IRequestResultMonitor {
        void onRequestMonitor(XLLiveRequest xLLiveRequest, JsonWrapper jsonWrapper);
    }

    public interface JsonCallBack {
        void onResponse(int i, String str, JsonWrapper jsonWrapper);
    }

    public interface ObjectCallBack {
        void onResponse(int i, String str, Object obj);
    }

    public static class XLLiveRespBase {
        public String message = "未知错误";
        public int result = -1;
    }

    public interface JsonCallBack2 extends JsonCallBack {
        JsonWrapper onPreResult(JsonWrapper jsonWrapper);
    }

    public interface ObjectCallBack2 extends ObjectCallBack {
        Object onPreResult(Object obj);
    }

    abstract class RequestCallBackT<T> extends f<T> {
        RequestCallBackT() {
        }

        public T onParseResult(java.lang.String r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = com.xunlei.tdlive.protocol.XLLiveRequest.sRequestResultMonitor;	 Catch:{ Throwable -> 0x0022 }
            if (r0 == 0) goto L_0x0022;	 Catch:{ Throwable -> 0x0022 }
        L_0x0006:
            r0 = com.xunlei.tdlive.protocol.XLLiveRequest.sRequestResultMonitor;	 Catch:{ Throwable -> 0x0022 }
            r1 = com.xunlei.tdlive.protocol.XLLiveRequest.this;	 Catch:{ Throwable -> 0x0022 }
            r1 = r1.getClass();	 Catch:{ Throwable -> 0x0022 }
            r0 = r0.get(r1);	 Catch:{ Throwable -> 0x0022 }
            r0 = (com.xunlei.tdlive.protocol.XLLiveRequest.IRequestResultMonitor) r0;	 Catch:{ Throwable -> 0x0022 }
            if (r0 == 0) goto L_0x0022;	 Catch:{ Throwable -> 0x0022 }
        L_0x0018:
            r1 = com.xunlei.tdlive.protocol.XLLiveRequest.this;	 Catch:{ Throwable -> 0x0022 }
            r2 = new com.xunlei.tdlive.modal.JsonWrapper;	 Catch:{ Throwable -> 0x0022 }
            r2.<init>(r4);	 Catch:{ Throwable -> 0x0022 }
            r0.onRequestMonitor(r1, r2);	 Catch:{ Throwable -> 0x0022 }
        L_0x0022:
            return r4;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.protocol.XLLiveRequest.RequestCallBackT.onParseResult(java.lang.String):T");
        }
    }

    private class JsonRequestCallBack extends RequestCallBackT<JsonWrapper> {
        private JsonRequestCallBack() {
            super();
        }

        protected void onParseNetworkResponse(j jVar) {
            super.onParseNetworkResponse(jVar);
            XLLiveRequest.this.onParseNetworkResponse(jVar);
        }

        public JsonWrapper onParseResult(String str) {
            super.onParseResult(str);
            String str2;
            StringBuilder stringBuilder;
            if (str.length() >= Integer.MAX_VALUE) {
                str2 = XLLiveRequest.TAG;
                stringBuilder = new StringBuilder("resp id = ");
                stringBuilder.append(XLLiveRequest.this.mId);
                stringBuilder.append(", url = ");
                stringBuilder.append(XLLiveRequest.this.mURL);
                stringBuilder.append(", result=");
                stringBuilder.append(str.substring(0, 2147483646));
                XLog.d(str2, stringBuilder.toString());
            } else {
                str2 = XLLiveRequest.TAG;
                stringBuilder = new StringBuilder("resp id = ");
                stringBuilder.append(XLLiveRequest.this.mId);
                stringBuilder.append(", url = ");
                stringBuilder.append(XLLiveRequest.this.mURL);
                stringBuilder.append(", result=");
                stringBuilder.append(str);
                XLog.d(str2, stringBuilder.toString());
            }
            JsonWrapper jsonWrapper = new JsonWrapper(str);
            try {
                if ((XLLiveRequest.this.mJsonCallBack instanceof JsonCallBack2) != null) {
                    return ((JsonCallBack2) XLLiveRequest.this.mJsonCallBack).onPreResult(jsonWrapper);
                }
            } catch (String str3) {
                XLog.d(XLLiveRequest.TAG, str3.toString());
            }
            return jsonWrapper;
        }

        public void onSuccess(e.j<JsonWrapper> jVar) {
            if (XLLiveRequest.this.mJsonCallBack != null) {
                if (jVar.b != 200) {
                    jVar.a = new JsonWrapper("{}");
                    ((JsonWrapper) jVar.a).putInt("result", -4);
                    ((JsonWrapper) jVar.a).putString("message", XLLiveRequest.this.getContext().getString(R.string.http_error_server));
                } else if (jVar.a == null) {
                    jVar.a = new JsonWrapper("{}");
                    ((JsonWrapper) jVar.a).putInt("result", -2);
                    ((JsonWrapper) jVar.a).putString("message", XLLiveRequest.this.getContext().getString(R.string.http_error_server));
                }
                int i = ((JsonWrapper) jVar.a).getInt("result", -1);
                if (XLLiveRequest.this.onNeedReportInvalidSession() && i == -400 && XLLiveRequest.sNetworHandler != null) {
                    XLLiveRequest.sNetworHandler.onSessionInvalid();
                } else if (i == -403 && XLLiveRequest.sNetworHandler != null) {
                    XLLiveRequest.sNetworHandler.onInvalidVersion(((JsonWrapper) jVar.a).getString("message", "当前版本不可用，请更新~"), ((JsonWrapper) jVar.a).getObject("data", "{}").getString("url", ""));
                }
                XLLiveRequest.this.mJsonCallBack.onResponse(i, ((JsonWrapper) jVar.a).getString("message", "未知错误"), (JsonWrapper) jVar.a);
            }
            XLLiveRequest.this.mHandler = null;
        }

        public void onFailure(a aVar, String str) {
            String str2 = XLLiveRequest.TAG;
            StringBuilder stringBuilder = new StringBuilder("resp id = ");
            stringBuilder.append(XLLiveRequest.this.mId);
            stringBuilder.append(", url = ");
            stringBuilder.append(XLLiveRequest.this.mURL);
            stringBuilder.append(", error=");
            stringBuilder.append(aVar.toString());
            stringBuilder.append(", msg=");
            stringBuilder.append(str);
            XLog.d(str2, stringBuilder.toString());
            if (XLLiveRequest.this.mJsonCallBack != null) {
                int i;
                aVar = new JsonWrapper("{}");
                if (l.a(XLLiveRequest.this.getContext()) == null) {
                    i = -3;
                    str2 = XLLiveRequest.this.getContext().getString(R.string.http_error_network);
                } else {
                    i = -4;
                    str2 = XLLiveRequest.this.getContext().getString(R.string.http_error_server);
                }
                aVar.putInt("result", i);
                aVar.putString("message", str2);
                XLLiveRequest.this.mJsonCallBack.onResponse(i, str2, aVar);
            }
            XLLiveRequest.this.mHandler = null;
        }
    }

    private class ObjectRequestCallBack extends RequestCallBackT<Object> {
        private ObjectRequestCallBack() {
            super();
        }

        public Object onParseResult(String str) {
            super.onParseResult(str);
            try {
                String str2;
                StringBuilder stringBuilder;
                if (str.length() >= Integer.MAX_VALUE) {
                    str2 = XLLiveRequest.TAG;
                    stringBuilder = new StringBuilder("resp id = ");
                    stringBuilder.append(XLLiveRequest.this.mId);
                    stringBuilder.append(", url = ");
                    stringBuilder.append(XLLiveRequest.this.mURL);
                    stringBuilder.append(", result=");
                    stringBuilder.append(str.substring(0, 2147483646));
                    XLog.d(str2, stringBuilder.toString());
                } else {
                    str2 = XLLiveRequest.TAG;
                    stringBuilder = new StringBuilder("resp id = ");
                    stringBuilder.append(XLLiveRequest.this.mId);
                    stringBuilder.append(", url = ");
                    stringBuilder.append(XLLiveRequest.this.mURL);
                    stringBuilder.append(", result=");
                    stringBuilder.append(str);
                    XLog.d(str2, stringBuilder.toString());
                }
                Object fromJson = new Gson().fromJson(str, XLLiveRequest.this.onGetObjectClass());
                try {
                    if (XLLiveRequest.this.mObjectCallBack instanceof ObjectCallBack2) {
                        return ((ObjectCallBack2) XLLiveRequest.this.mObjectCallBack).onPreResult(fromJson);
                    }
                } catch (Throwable th) {
                    XLog.d(XLLiveRequest.TAG, th.toString());
                }
                return fromJson;
            } catch (Exception e) {
                String str3 = XLLiveRequest.TAG;
                StringBuilder stringBuilder2 = new StringBuilder("e:");
                stringBuilder2.append(e.toString());
                stringBuilder2.append(", object:");
                stringBuilder2.append(str);
                XLog.e(str3, stringBuilder2.toString());
                return null;
            }
        }

        public void onSuccess(e.j<Object> jVar) {
            if (XLLiveRequest.this.mObjectCallBack != null) {
                if (jVar.a == null) {
                    XLLiveRequest.this.mObjectCallBack.onResponse(-2, XLLiveRequest.this.getContext().getString(R.string.http_error_server), null);
                } else if (jVar.a instanceof XLLiveRespBase) {
                    XLLiveRespBase xLLiveRespBase = (XLLiveRespBase) jVar.a;
                    if (XLLiveRequest.this.onNeedReportInvalidSession() && xLLiveRespBase.result == -400 && XLLiveRequest.sNetworHandler != null) {
                        XLLiveRequest.sNetworHandler.onSessionInvalid();
                    }
                    XLLiveRequest.this.mObjectCallBack.onResponse(xLLiveRespBase.result, xLLiveRespBase.message, jVar.a);
                } else {
                    XLLiveRequest.this.mObjectCallBack.onResponse(0, "", jVar.a);
                }
            }
            XLLiveRequest.this.mHandler = null;
        }

        public void onFailure(a aVar, String str) {
            String str2 = XLLiveRequest.TAG;
            StringBuilder stringBuilder = new StringBuilder("resp id = ");
            stringBuilder.append(XLLiveRequest.this.mId);
            stringBuilder.append(", url = ");
            stringBuilder.append(XLLiveRequest.this.mURL);
            stringBuilder.append(", error=");
            stringBuilder.append(aVar.toString());
            stringBuilder.append(", msg=");
            stringBuilder.append(str);
            XLog.d(str2, stringBuilder.toString());
            if (XLLiveRequest.this.mObjectCallBack != null) {
                if (l.a(XLLiveRequest.this.getContext()) == null) {
                    XLLiveRequest.this.mObjectCallBack.onResponse(-3, XLLiveRequest.this.getContext().getString(R.string.http_error_network), null);
                } else {
                    XLLiveRequest.this.mObjectCallBack.onResponse(-4, XLLiveRequest.this.getContext().getString(R.string.http_error_server), null);
                }
            }
            XLLiveRequest.this.mHandler = null;
        }
    }

    protected String getBody() {
        return null;
    }

    protected String getContentType() {
        return null;
    }

    protected boolean needMonitorNetworkError() {
        return true;
    }

    protected void onAddBodyParams(h hVar) {
    }

    protected int onGetRetryCount() {
        return 2;
    }

    protected int onGetTimeoutMs() {
        return 2500;
    }

    protected abstract String onGetURL();

    protected boolean onNeedReportInvalidSession() {
        return true;
    }

    protected void onParseNetworkResponse(j jVar) {
    }

    protected boolean useHttpPost() {
        return false;
    }

    public static void setDNSCahce(IDNSCache iDNSCache) {
        sDnsCache = iDNSCache;
    }

    public static IDNSCache getDNSCahce() {
        return sDnsCache;
    }

    public static void addGlobalCookie(String str, String str2) {
        if (sGlobalCookies == null) {
            sGlobalCookies = new ConcurrentHashMap();
        }
        sGlobalCookies.put(str, str2);
    }

    public static void setNetworkHandler(INetworkHandler iNetworkHandler) {
        sNetworHandler = iNetworkHandler;
    }

    public static void addRequestResultMonitor(Class<? extends XLLiveRequest> cls, IRequestResultMonitor iRequestResultMonitor) {
        if (cls != null && iRequestResultMonitor != null) {
            if (sRequestResultMonitor == null) {
                sRequestResultMonitor = new ConcurrentHashMap();
            }
            sRequestResultMonitor.put(cls, iRequestResultMonitor);
        }
    }

    public static void setLoginParam(String str, String str2, int i) {
        addGlobalCookie("userid", str);
        addGlobalCookie("sessionid", str2);
        addGlobalCookie("account_appid", String.valueOf(i));
    }

    public static String getUserId() {
        return sGlobalCookies != null ? (String) sGlobalCookies.get("userid") : "";
    }

    public static String getSessionId() {
        return sGlobalCookies != null ? (String) sGlobalCookies.get("sessionid") : "";
    }

    public XLLiveRequest() {
        long j = sRequestId + 1;
        sRequestId = j;
        this.mId = j;
    }

    public boolean tryLock() {
        if (this.mHandler == null) {
            return true;
        }
        if (this.mTimeOut <= 0 || SystemClock.elapsedRealtime() - this.mLastSend < this.mTimeOut) {
            return false;
        }
        return true;
    }

    public final XLLiveRequest setSendTimeOut(long j) {
        this.mTimeOut = j;
        return this;
    }

    public final XLLiveRequest send(JsonCallBack jsonCallBack) {
        this.mJsonCallBack = jsonCallBack;
        return send();
    }

    public final XLLiveRequest send(ObjectCallBack objectCallBack) {
        this.mObjectCallBack = objectCallBack;
        return send();
    }

    public final com.xunlei.tdlive.protocol.XLLiveRequest send() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r0 = com.xunlei.tdlive.util.a.a();
        r0 = com.xunlei.tdlive.util.l.a(r0);
        if (r0 != 0) goto L_0x0021;
    L_0x000a:
        r0 = r10.needMonitorNetworkError();
        if (r0 == 0) goto L_0x0021;
    L_0x0010:
        r0 = sNetworHandler;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = sNetworHandler;
        r0.onNoConnection();
        goto L_0x0021;
    L_0x001a:
        r0 = "XLLiveRequest";
        r1 = "request when no connection.";
        com.xunlei.tdlive.util.XLog.w(r0, r1);
    L_0x0021:
        r0 = r10.onGetURL();
        r1 = "";
        r2 = "";
        r3 = com.xunlei.tdlive.util.a.a();
        r3 = com.xunlei.tdlive.modal.c.f(r3);
        r4 = com.xunlei.tdlive.util.a.a();
        r4 = com.xunlei.tdlive.modal.c.g(r4);
        r5 = new com.android.volley.a.a;	 Catch:{ Exception -> 0x00a0 }
        r10.mURL = r0;	 Catch:{ Exception -> 0x00a0 }
        r5.<init>(r0);	 Catch:{ Exception -> 0x00a0 }
        r6 = r5.b;	 Catch:{ Exception -> 0x00a0 }
        if (r6 == 0) goto L_0x004c;	 Catch:{ Exception -> 0x00a0 }
    L_0x0044:
        r6 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00a0 }
        r7 = r5.b;	 Catch:{ Exception -> 0x00a0 }
        r6.<init>(r7);	 Catch:{ Exception -> 0x00a0 }
        goto L_0x0051;	 Catch:{ Exception -> 0x00a0 }
    L_0x004c:
        r6 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00a0 }
        r6.<init>();	 Catch:{ Exception -> 0x00a0 }
    L_0x0051:
        r7 = new com.xunlei.tdlive.protocol.XLLiveRequest$1;	 Catch:{ Exception -> 0x00a0 }
        r7.<init>();	 Catch:{ Exception -> 0x00a0 }
        java.util.Collections.sort(r6, r7);	 Catch:{ Exception -> 0x00a0 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a0 }
        r7.<init>();	 Catch:{ Exception -> 0x00a0 }
        r6 = r6.iterator();	 Catch:{ Exception -> 0x00a0 }
    L_0x0062:
        r8 = r6.hasNext();	 Catch:{ Exception -> 0x00a0 }
        if (r8 == 0) goto L_0x008d;	 Catch:{ Exception -> 0x00a0 }
    L_0x0068:
        r8 = r6.next();	 Catch:{ Exception -> 0x00a0 }
        r8 = (com.android.volley.toolbox.al) r8;	 Catch:{ Exception -> 0x00a0 }
        r9 = r7.length();	 Catch:{ Exception -> 0x00a0 }
        if (r9 <= 0) goto L_0x0079;	 Catch:{ Exception -> 0x00a0 }
    L_0x0074:
        r9 = "&";	 Catch:{ Exception -> 0x00a0 }
        r7.append(r9);	 Catch:{ Exception -> 0x00a0 }
    L_0x0079:
        r9 = r8.a();	 Catch:{ Exception -> 0x00a0 }
        r7.append(r9);	 Catch:{ Exception -> 0x00a0 }
        r9 = "=";	 Catch:{ Exception -> 0x00a0 }
        r7.append(r9);	 Catch:{ Exception -> 0x00a0 }
        r8 = r8.b();	 Catch:{ Exception -> 0x00a0 }
        r7.append(r8);	 Catch:{ Exception -> 0x00a0 }
        goto L_0x0062;	 Catch:{ Exception -> 0x00a0 }
    L_0x008d:
        r6 = 0;	 Catch:{ Exception -> 0x00a0 }
        r6 = r7.insert(r6, r3);	 Catch:{ Exception -> 0x00a0 }
        r6.append(r4);	 Catch:{ Exception -> 0x00a0 }
        r4 = r6.toString();	 Catch:{ Exception -> 0x00a0 }
        r4 = com.xunlei.tdlive.util.f.a(r4);	 Catch:{ Exception -> 0x00a0 }
        r1 = r5.a;	 Catch:{ Exception -> 0x00a1 }
        goto L_0x00a2;
    L_0x00a0:
        r4 = r1;
    L_0x00a1:
        r1 = r2;
    L_0x00a2:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r5 = r10.onGetCookie();
        r2.append(r5);
        r5 = "appid=";
        r2.append(r5);
        r2.append(r3);
        r3 = "; sign=";
        r2.append(r3);
        r2.append(r4);
        r3 = ";";
        r2.append(r3);
        r2 = r2.toString();
        r3 = new com.xunlei.tdlive.util.e$h;
        r3.<init>();
        r4 = "Cookie";
        r3.a(r4, r2);
        r4 = r10.onGetRetryCount();
        r3.b(r4);
        r4 = r10.onGetTimeoutMs();
        r3.a(r4);
        r4 = r10.getBody();
        r3.a(r4);
        r4 = r10.getContentType();
        r3.b(r4);
        r10.onAddBodyParams(r3);
        r4 = sDnsCache;
        if (r4 == 0) goto L_0x0113;
    L_0x00f4:
        if (r1 == 0) goto L_0x0113;
    L_0x00f6:
        r4 = r1.length();
        if (r4 <= 0) goto L_0x0113;
    L_0x00fc:
        r4 = sDnsCache;
        r4 = r4.hit(r1);
        if (r4 == 0) goto L_0x0113;
    L_0x0104:
        r5 = r4.length();
        if (r5 <= 0) goto L_0x0113;
    L_0x010a:
        r5 = "Host";
        r3.a(r5, r1);
        r0 = r0.replace(r1, r4);
    L_0x0113:
        r1 = r10.useHttpPost();
        if (r1 == 0) goto L_0x011c;
    L_0x0119:
        r1 = com.xunlei.tdlive.util.e.c.POST;
        goto L_0x011e;
    L_0x011c:
        r1 = com.xunlei.tdlive.util.e.c.GET;
    L_0x011e:
        r4 = r10.mObjectCallBack;
        r5 = 0;
        if (r4 != 0) goto L_0x0129;
    L_0x0123:
        r4 = new com.xunlei.tdlive.protocol.XLLiveRequest$JsonRequestCallBack;
        r4.<init>();
        goto L_0x012e;
    L_0x0129:
        r4 = new com.xunlei.tdlive.protocol.XLLiveRequest$ObjectRequestCallBack;
        r4.<init>();
    L_0x012e:
        r10.onSend(r1, r0, r3, r4);
        r4 = android.os.SystemClock.elapsedRealtime();
        r10.mLastSend = r4;
        r1 = "XLLiveRequest";
        r4 = new java.lang.StringBuilder;
        r5 = "send id = ";
        r4.<init>(r5);
        r5 = r10.mId;
        r4.append(r5);
        r5 = ", url = ";
        r4.append(r5);
        r4.append(r0);
        r0 = ", cookie = ";
        r4.append(r0);
        r4.append(r2);
        r0 = ", body = ";
        r4.append(r0);
        r0 = r3.a();
        r4.append(r0);
        r0 = r4.toString();
        com.xunlei.tdlive.util.XLog.d(r1, r0);
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.protocol.XLLiveRequest.send():com.xunlei.tdlive.protocol.XLLiveRequest");
    }

    public void cancel() {
        if (this.mHandler != null) {
            this.mHandler.a();
            this.mHandler = null;
        }
    }

    public Context getContext() {
        return com.xunlei.tdlive.util.a.a();
    }

    protected void onSend(c cVar, String str, h hVar, f<?> fVar) {
        this.mHandler = this.mHttpUtils.a(cVar, str, hVar, (f) fVar);
    }

    protected String onGetCookie() {
        StringBuilder stringBuilder = new StringBuilder("appver=");
        stringBuilder.append(com.xunlei.tdlive.modal.c.d(com.xunlei.tdlive.util.a.a()));
        stringBuilder.append("; appcode=");
        stringBuilder.append(com.xunlei.tdlive.modal.c.e(com.xunlei.tdlive.util.a.a()));
        stringBuilder.append("; os=android; osver=");
        stringBuilder.append(l.a());
        stringBuilder.append("; model=");
        stringBuilder.append(l.a(false));
        stringBuilder.append("; deviceid=");
        stringBuilder.append(l.f(com.xunlei.tdlive.util.a.a()));
        stringBuilder.append("; channel=");
        stringBuilder.append(com.xunlei.tdlive.modal.c.a(com.xunlei.tdlive.util.a.a()));
        stringBuilder.append("; ");
        String stringBuilder2 = stringBuilder.toString();
        if (sGlobalCookies != null) {
            for (Entry entry : sGlobalCookies.entrySet()) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(stringBuilder2);
                stringBuilder3.append((String) entry.getKey());
                stringBuilder3.append("=");
                stringBuilder3.append((String) entry.getValue());
                stringBuilder3.append("; ");
                stringBuilder2 = stringBuilder3.toString();
            }
        }
        return stringBuilder2;
    }

    protected Class<?> onGetObjectClass() {
        return XLLiveRespBase.class;
    }
}
