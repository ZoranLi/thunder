package com.qq.e.comm.net;

import anet.channel.util.HttpConstant;
import com.qq.e.comm.net.NetworkClient.Priority;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.bugly.BuglyStrategy.a;
import com.umeng.message.util.HttpRequest;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class NetworkClientImpl implements NetworkClient {
    private static final HttpClient a;
    private static final NetworkClient b = new NetworkClientImpl();
    private final ExecutorService c = new ThreadPoolExecutor(5, 10, 180, TimeUnit.SECONDS, this.d);
    private PriorityBlockingQueue<Runnable> d = new PriorityBlockingQueue(15);

    class NetFutureTask<T> extends FutureTask<T> implements Comparable<NetFutureTask<T>> {
        private final Priority a;

        public NetFutureTask(NetworkClientImpl networkClientImpl, Callable<T> callable, Priority priority) {
            super(callable);
            this.a = priority;
        }

        public int compareTo(NetFutureTask<T> netFutureTask) {
            return netFutureTask == null ? 1 : this.a.value() - netFutureTask.a.value();
        }
    }

    static class TaskCallable implements Callable<Response> {
        private Request a;
        private NetworkCallBack b;

        public TaskCallable(Request request) {
            this(request, null);
        }

        public TaskCallable(Request request, NetworkCallBack networkCallBack) {
            this.a = request;
            this.b = networkCallBack;
        }

        private void a(HttpRequestBase httpRequestBase) {
            for (Entry entry : this.a.getHeaders().entrySet()) {
                httpRequestBase.setHeader((String) entry.getKey(), (String) entry.getValue());
            }
            String str = HttpRequest.HEADER_USER_AGENT;
            StringBuilder stringBuilder = new StringBuilder("GDTADNetClient-[");
            stringBuilder.append(System.getProperty("http.agent"));
            stringBuilder.append("]");
            httpRequestBase.setHeader(str, stringBuilder.toString());
            httpRequestBase.addHeader("Accept-Encoding", "gzip");
            HttpParams params = httpRequestBase.getParams();
            if (params == null) {
                params = new BasicHttpParams();
            }
            if (this.a.getConnectionTimeOut() > 0) {
                HttpConnectionParams.setConnectionTimeout(params, this.a.getConnectionTimeOut());
            }
            if (this.a.getSocketTimeOut() > 0) {
                HttpConnectionParams.setSoTimeout(params, this.a.getSocketTimeOut());
            }
            httpRequestBase.setParams(params);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.qq.e.comm.net.rr.Response call() throws java.lang.Exception {
            /*
            r6 = this;
            r0 = 0;
            r1 = com.qq.e.comm.net.NetworkClientImpl.a;	 Catch:{ Exception -> 0x0054 }
            r2 = com.qq.e.comm.net.NetworkClientImpl.AnonymousClass1.a;	 Catch:{ Exception -> 0x0054 }
            r3 = r6.a;	 Catch:{ Exception -> 0x0054 }
            r3 = r3.getMethod();	 Catch:{ Exception -> 0x0054 }
            r3 = r3.ordinal();	 Catch:{ Exception -> 0x0054 }
            r2 = r2[r3];	 Catch:{ Exception -> 0x0054 }
            switch(r2) {
                case 1: goto L_0x0027;
                case 2: goto L_0x0018;
                default: goto L_0x0016;
            };	 Catch:{ Exception -> 0x0054 }
        L_0x0016:
            r2 = r0;
            goto L_0x0049;
        L_0x0018:
            r2 = new org.apache.http.client.methods.HttpGet;	 Catch:{ Exception -> 0x0054 }
            r3 = r6.a;	 Catch:{ Exception -> 0x0054 }
            r3 = r3.getUrlWithParas();	 Catch:{ Exception -> 0x0054 }
            r2.<init>(r3);	 Catch:{ Exception -> 0x0054 }
            r6.a(r2);	 Catch:{ Exception -> 0x0054 }
            goto L_0x0049;
        L_0x0027:
            r2 = r6.a;	 Catch:{ Exception -> 0x0054 }
            r2 = r2.getUrlWithParas();	 Catch:{ Exception -> 0x0054 }
            r3 = new org.apache.http.client.methods.HttpPost;	 Catch:{ Exception -> 0x0054 }
            r3.<init>(r2);	 Catch:{ Exception -> 0x0054 }
            r6.a(r3);	 Catch:{ Exception -> 0x0054 }
            r2 = r6.a;	 Catch:{ Exception -> 0x0054 }
            r2 = r2.getPostData();	 Catch:{ Exception -> 0x0054 }
            if (r2 == 0) goto L_0x0048;
        L_0x003d:
            r4 = r2.length;	 Catch:{ Exception -> 0x0054 }
            if (r4 <= 0) goto L_0x0048;
        L_0x0040:
            r4 = new org.apache.http.entity.ByteArrayEntity;	 Catch:{ Exception -> 0x0054 }
            r4.<init>(r2);	 Catch:{ Exception -> 0x0054 }
            r3.setEntity(r4);	 Catch:{ Exception -> 0x0054 }
        L_0x0048:
            r2 = r3;
        L_0x0049:
            r1 = r1.execute(r2);	 Catch:{ Exception -> 0x0054 }
            r3 = r6.a;	 Catch:{ Exception -> 0x0054 }
            r1 = r3.initResponse(r2, r1);	 Catch:{ Exception -> 0x0054 }
            goto L_0x0058;
        L_0x0054:
            r1 = move-exception;
            r5 = r1;
            r1 = r0;
            r0 = r5;
        L_0x0058:
            if (r0 != 0) goto L_0x0071;
        L_0x005a:
            r0 = r6.b;
            if (r0 == 0) goto L_0x0065;
        L_0x005e:
            r0 = r6.b;
            r2 = r6.a;
            r0.onResponse(r2, r1);
        L_0x0065:
            r0 = r6.a;
            r0 = r0.isAutoClose();
            if (r0 == 0) goto L_0x0082;
        L_0x006d:
            r1.close();
            return r1;
        L_0x0071:
            r2 = r6.b;
            if (r2 == 0) goto L_0x0083;
        L_0x0075:
            r2 = "NetworkClientException";
            com.qq.e.comm.util.GDTLogger.w(r2, r0);
            r2 = r6.b;
            r2.onException(r0);
            if (r1 == 0) goto L_0x0082;
        L_0x0081:
            goto L_0x006d;
        L_0x0082:
            return r1;
        L_0x0083:
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.net.NetworkClientImpl.TaskCallable.call():com.qq.e.comm.net.rr.Response");
        }
    }

    static {
        HttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, StatisticConfig.MIN_UPLOAD_INTERVAL);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, a.MAX_USERDATA_VALUE_LENGTH);
        HttpConnectionParams.setSoTimeout(basicHttpParams, a.MAX_USERDATA_VALUE_LENGTH);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(3));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
        StringBuilder stringBuilder = new StringBuilder("GDTADNetClient-[");
        stringBuilder.append(System.getProperty("http.agent"));
        stringBuilder.append("]");
        HttpProtocolParams.setUserAgent(basicHttpParams, stringBuilder.toString());
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpConstant.HTTP, PlainSocketFactory.getSocketFactory(), 80));
        a = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
    }

    private NetworkClientImpl() {
    }

    public static NetworkClient getInstance() {
        return b;
    }

    public Future<Response> submit(Request request) {
        return submit(request, Priority.Mid);
    }

    public Future<Response> submit(Request request, Priority priority) {
        Object netFutureTask = new NetFutureTask(this, new TaskCallable(request), priority);
        this.c.execute(netFutureTask);
        StringBuilder stringBuilder = new StringBuilder("QueueSize:");
        stringBuilder.append(this.d.size());
        GDTLogger.d(stringBuilder.toString());
        return netFutureTask;
    }

    public void submit(Request request, NetworkCallBack networkCallBack) {
        submit(request, Priority.Mid, networkCallBack);
    }

    public void submit(Request request, Priority priority, NetworkCallBack networkCallBack) {
        this.c.execute(new NetFutureTask(this, new TaskCallable(request, networkCallBack), priority));
        StringBuilder stringBuilder = new StringBuilder("QueueSize:");
        stringBuilder.append(this.d.size());
        GDTLogger.d(stringBuilder.toString());
    }
}
