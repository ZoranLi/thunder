package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.util.Pair;
import com.alipay.sdk.packet.d;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.core.CommonCode.ErrorCode;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* compiled from: PendingResultImpl */
public abstract class a<R extends Result, T extends IMessageEntity> extends PendingResult<R> {
    private CountDownLatch a;
    private R b = null;
    private WeakReference<ApiClient> c;
    private String d = null;
    private long e = 0;
    protected DatagramTransport transport = null;

    /* compiled from: PendingResultImpl */
    protected static class a<R extends Result> extends Handler {
        public a() {
            this(Looper.getMainLooper());
        }

        public a(Looper looper) {
            super(looper);
        }

        public void a(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void handleMessage(Message message) {
            if (message.what == 1) {
                Pair pair = (Pair) message.obj;
                b((ResultCallback) pair.first, (Result) pair.second);
            }
        }

        protected void b(ResultCallback<? super R> resultCallback, R r) {
            resultCallback.onResult(r);
        }
    }

    public abstract R onComplete(T t);

    public a(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
        this.d = str;
        a(apiClient, str, iMessageEntity, getResponseType());
    }

    public a(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls) {
        a(apiClient, str, iMessageEntity, cls);
    }

    private void a(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls) {
        if (apiClient == null) {
            throw new IllegalArgumentException("apiClient cannot be null.");
        }
        this.c = new WeakReference(apiClient);
        this.a = new CountDownLatch(1);
        try {
            this.transport = (DatagramTransport) Class.forName(apiClient.getTransportName()).getConstructor(new Class[]{String.class, IMessageEntity.class, Class.class}).newInstance(new Object[]{str, iMessageEntity, cls});
        } catch (ApiClient apiClient2) {
            iMessageEntity = new StringBuilder("Instancing transport exception, ");
            iMessageEntity.append(apiClient2.getMessage());
            throw new IllegalStateException(iMessageEntity.toString(), apiClient2);
        }
    }

    protected Class<T> getResponseType() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass != null) {
            genericSuperclass = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[1];
            if (genericSuperclass != null) {
                return (Class) genericSuperclass;
            }
        }
        return null;
    }

    public final R await() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = java.lang.System.currentTimeMillis();
        r4.e = r0;
        r0 = android.os.Looper.myLooper();
        r1 = android.os.Looper.getMainLooper();
        if (r0 != r1) goto L_0x0018;
    L_0x0010:
        r0 = new java.lang.IllegalStateException;
        r1 = "await must not be called on the UI thread";
        r0.<init>(r1);
        throw r0;
    L_0x0018:
        r0 = r4.c;
        r0 = r0.get();
        r0 = (com.huawei.hms.support.api.client.ApiClient) r0;
        r1 = r4.checkApiClient(r0);
        r2 = 0;
        if (r1 != 0) goto L_0x0030;
    L_0x0027:
        r0 = 907135003; // 0x3611c81b float:2.172316E-6 double:4.48184241E-315;
        r4.a(r0, r2);
        r0 = r4.b;
        return r0;
    L_0x0030:
        r1 = r4.transport;
        r3 = new com.huawei.hms.support.api.b;
        r3.<init>(r4);
        r1.a(r0, r3);
        r0 = r4.a;	 Catch:{ InterruptedException -> 0x0040 }
        r0.await();	 Catch:{ InterruptedException -> 0x0040 }
        goto L_0x0046;
    L_0x0040:
        r0 = 907135001; // 0x3611c819 float:2.1723156E-6 double:4.4818424E-315;
        r4.a(r0, r2);
    L_0x0046:
        r0 = r4.b;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.api.a.await():R");
    }

    public R await(long r6, java.util.concurrent.TimeUnit r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = java.lang.System.currentTimeMillis();
        r5.e = r0;
        r0 = android.os.Looper.myLooper();
        r1 = android.os.Looper.getMainLooper();
        if (r0 != r1) goto L_0x0018;
    L_0x0010:
        r6 = new java.lang.IllegalStateException;
        r7 = "await must not be called on the UI thread";
        r6.<init>(r7);
        throw r6;
    L_0x0018:
        r0 = r5.c;
        r0 = r0.get();
        r0 = (com.huawei.hms.support.api.client.ApiClient) r0;
        r1 = r5.checkApiClient(r0);
        r2 = 0;
        if (r1 != 0) goto L_0x0030;
    L_0x0027:
        r6 = 907135003; // 0x3611c81b float:2.172316E-6 double:4.48184241E-315;
        r5.a(r6, r2);
        r6 = r5.b;
        return r6;
    L_0x0030:
        r1 = new java.util.concurrent.atomic.AtomicBoolean;
        r1.<init>();
        r3 = r5.transport;
        r4 = new com.huawei.hms.support.api.c;
        r4.<init>(r5, r1);
        r3.b(r0, r4);
        r0 = r5.a;	 Catch:{ InterruptedException -> 0x0052 }
        r6 = r0.await(r6, r8);	 Catch:{ InterruptedException -> 0x0052 }
        if (r6 != 0) goto L_0x0058;	 Catch:{ InterruptedException -> 0x0052 }
    L_0x0047:
        r6 = 1;	 Catch:{ InterruptedException -> 0x0052 }
        r1.set(r6);	 Catch:{ InterruptedException -> 0x0052 }
        r6 = 907135004; // 0x3611c81c float:2.1723163E-6 double:4.481842416E-315;	 Catch:{ InterruptedException -> 0x0052 }
        r5.a(r6, r2);	 Catch:{ InterruptedException -> 0x0052 }
        goto L_0x0058;
    L_0x0052:
        r6 = 907135001; // 0x3611c819 float:2.1723156E-6 double:4.4818424E-315;
        r5.a(r6, r2);
    L_0x0058:
        r6 = r5.b;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.api.a.await(long, java.util.concurrent.TimeUnit):R");
    }

    public final void setResultCallback(ResultCallback<R> resultCallback) {
        setResultCallback(Looper.getMainLooper(), resultCallback);
    }

    public final void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
        this.e = System.currentTimeMillis();
        if (looper == null) {
            looper = Looper.myLooper();
        }
        a aVar = new a(looper);
        ApiClient apiClient = (ApiClient) this.c.get();
        if (checkApiClient(apiClient)) {
            this.transport.b(apiClient, new d(this, aVar, resultCallback));
            return;
        }
        a(ErrorCode.CLIENT_API_INVALID, null);
        aVar.a(resultCallback, this.b);
    }

    private void a(int i, IMessageEntity iMessageEntity) {
        a(i);
        if (i <= 0) {
            this.b = onComplete(iMessageEntity);
        } else {
            this.b = onError(i);
        }
    }

    public R onError(int r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.getClass();
        r0 = r0.getGenericSuperclass();
        r1 = 0;
        if (r0 == 0) goto L_0x0015;
    L_0x000b:
        r0 = (java.lang.reflect.ParameterizedType) r0;
        r0 = r0.getActualTypeArguments();
        r2 = 0;
        r0 = r0[r2];
        goto L_0x0016;
    L_0x0015:
        r0 = r1;
    L_0x0016:
        if (r0 == 0) goto L_0x001d;
    L_0x0018:
        r0 = com.huawei.hms.support.a.a.a(r0);
        goto L_0x001e;
    L_0x001d:
        r0 = r1;
    L_0x001e:
        if (r0 == 0) goto L_0x0034;
    L_0x0020:
        r0 = r0.newInstance();	 Catch:{ Exception -> 0x0033 }
        r0 = (com.huawei.hms.support.api.client.Result) r0;	 Catch:{ Exception -> 0x0033 }
        r3.b = r0;	 Catch:{ Exception -> 0x0033 }
        r0 = r3.b;	 Catch:{ Exception -> 0x0033 }
        r2 = new com.huawei.hms.support.api.client.Status;	 Catch:{ Exception -> 0x0033 }
        r2.<init>(r4);	 Catch:{ Exception -> 0x0033 }
        r0.setStatus(r2);	 Catch:{ Exception -> 0x0033 }
        goto L_0x0034;
    L_0x0033:
        return r1;
    L_0x0034:
        r4 = r3.b;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.api.a.onError(int):R");
    }

    protected boolean checkApiClient(ApiClient apiClient) {
        return (apiClient == null || apiClient.isConnected() == null) ? null : true;
    }

    private void a(int i) {
        ApiClient apiClient = (ApiClient) this.c.get();
        if (!(apiClient == null || this.d == null)) {
            if (this.e != 0) {
                Map hashMap = new HashMap();
                hashMap.put("package", apiClient.getPackageName());
                hashMap.put("sdk_ver", "20502300");
                Object obj = null;
                SubAppInfo subAppInfo = apiClient.getSubAppInfo();
                if (subAppInfo != null) {
                    obj = subAppInfo.getSubAppID();
                }
                if (obj == null) {
                    obj = apiClient.getAppID();
                }
                hashMap.put(Constants.APP_ID, obj);
                String[] split = this.d.split("\\.");
                if (split.length == 2) {
                    hashMap.put(NotificationCompat.CATEGORY_SERVICE, split[0]);
                    hashMap.put(d.i, split[1]);
                }
                hashMap.put("result", String.valueOf(i));
                hashMap.put("cost_time", String.valueOf(System.currentTimeMillis() - this.e));
                com.huawei.hms.support.b.a.a().a(apiClient.getContext(), "HMS_SDK_API_CALL", hashMap);
            }
        }
    }
}
