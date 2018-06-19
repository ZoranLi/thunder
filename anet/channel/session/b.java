package anet.channel.session;

import android.os.Build.VERSION;
import anet.channel.RequestCb;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.c;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ConnectTimeoutException;

/* compiled from: Taobao */
public class b {

    /* compiled from: Taobao */
    public static class a {
        public int a;
        public byte[] b;
        public Map<String, List<String>> c;
    }

    private b() {
    }

    public static a a(Request request, RequestCb requestCb) {
        HttpURLConnection a;
        Throwable e;
        Request request2 = request;
        RequestCb requestCb2 = requestCb;
        a aVar = new a();
        if (request2 != null) {
            if (request.getUrl() != null) {
                request2.rs.sendBeforeTime = System.currentTimeMillis() - request2.rs.start;
                String str = null;
                while (NetworkStatusHelper.g()) {
                    try {
                        if (ALog.isPrintLog(2)) {
                            ALog.i("awcn.HttpConnector", "", request2.getSeq(), "request URL", request2.getUrl().toString());
                            ALog.i("awcn.HttpConnector", "", request2.getSeq(), "request Method", request2.getMethod());
                            ALog.i("awcn.HttpConnector", "", request2.getSeq(), "request headers", request2.getHeaders());
                        }
                        a = a(request2);
                        if (a != null) {
                            try {
                                a.connect();
                                a(a, request2);
                                aVar.a = a.getResponseCode();
                                aVar.c = anet.channel.util.a.a(a.getHeaderFields());
                                ALog.i("awcn.HttpConnector", "", request2.getSeq(), "response code", Integer.valueOf(aVar.a));
                                ALog.i("awcn.HttpConnector", "", request2.getSeq(), "response headers", aVar.c);
                                if (anet.channel.util.a.a(request2, aVar.a)) {
                                    str = anet.channel.util.a.b(aVar.c, "Location");
                                    if (str != null) {
                                        c a2 = c.a(str);
                                        if (a2 != null) {
                                            Request build = request2.newBuilder().setUrl(a2).setRedirectTimes(request2.getRedirectTimes() + 1).build();
                                            if (a != null) {
                                                try {
                                                    a.disconnect();
                                                } catch (Throwable e2) {
                                                    ALog.e("awcn.HttpConnector", "http disconnect", null, e2, new Object[0]);
                                                }
                                            }
                                            request2 = build;
                                            Object obj = a;
                                        } else {
                                            ALog.e("awcn.HttpConnector", "redirect url is invalid!", request2.getSeq(), "redirect url", str);
                                        }
                                    }
                                }
                                if (!(request2.getMethod() == "HEAD" || aVar.a == 304 || aVar.a == 204)) {
                                    if (aVar.a < 100 || aVar.a >= 200) {
                                        if (!(anet.channel.util.a.b(aVar.c) || requestCb2 == null)) {
                                            requestCb2.onResponseCode(aVar.a, aVar.c);
                                        }
                                        a(a, request2, aVar, requestCb2);
                                        request2.rs.oneWayTime = System.currentTimeMillis() - request2.rs.start;
                                        request2.rs.statusCode = aVar.a;
                                        request2.rs.ret = true;
                                        if (requestCb2 != null) {
                                            requestCb2.onFinish(aVar.a, HttpConstant.SUCCESS, request2.rs);
                                        }
                                    }
                                }
                                if (requestCb2 != null) {
                                    requestCb2.onResponseCode(aVar.a, aVar.c);
                                }
                                request2.rs.oneWayTime = System.currentTimeMillis() - request2.rs.start;
                                request2.rs.statusCode = aVar.a;
                                request2.rs.ret = true;
                                if (requestCb2 != null) {
                                    requestCb2.onFinish(aVar.a, HttpConstant.SUCCESS, request2.rs);
                                }
                            } catch (UnknownHostException e3) {
                                e2 = e3;
                            } catch (SocketTimeoutException e4) {
                                e2 = e4;
                            } catch (ConnectTimeoutException e5) {
                                e2 = e5;
                            } catch (ConnectException e6) {
                                e2 = e6;
                            } catch (SSLHandshakeException e7) {
                                e2 = e7;
                            } catch (SSLException e8) {
                                e2 = e8;
                            } catch (CancellationException e9) {
                                e2 = e9;
                            } catch (Exception e10) {
                                e2 = e10;
                            }
                        } else {
                            a(request2, aVar, requestCb2, ErrorConstant.ERROR_OPEN_CONNECTION_NULL, null);
                        }
                        if (a != null) {
                            try {
                                a.disconnect();
                            } catch (Throwable e22) {
                                ALog.e("awcn.HttpConnector", "http disconnect", null, e22, new Object[0]);
                            }
                        }
                    } catch (UnknownHostException e11) {
                        e22 = e11;
                        a = str;
                    } catch (SocketTimeoutException e12) {
                        e22 = e12;
                        a = str;
                    } catch (ConnectTimeoutException e13) {
                        e22 = e13;
                        a = str;
                    } catch (ConnectException e14) {
                        e22 = e14;
                        a = str;
                    } catch (SSLHandshakeException e15) {
                        e22 = e15;
                        a = str;
                    } catch (SSLException e16) {
                        e22 = e16;
                        a = str;
                    } catch (CancellationException e17) {
                        e22 = e17;
                        a = str;
                    } catch (Exception e18) {
                        e22 = e18;
                        a = str;
                    } catch (Throwable e222) {
                        Throwable th = e222;
                        a = str;
                    }
                    return aVar;
                }
                a(request2, aVar, requestCb2, ErrorConstant.ERROR_NO_NETWORK, null);
                return aVar;
            }
        }
        if (requestCb2 != null) {
            requestCb2.onFinish(ErrorConstant.ERROR_PARAM_ILLEGAL, ErrorConstant.getErrMsg(ErrorConstant.ERROR_PARAM_ILLEGAL), new RequestStatistic(null, null));
        }
        return aVar;
        Throwable th2 = e222;
        a(request2, aVar, requestCb2, -400, th2);
        ALog.e("awcn.HttpConnector", "HTTP Connect Timeout", request2.getSeq(), th2, new Object[0]);
        NetworkStatusHelper.k();
        if (a != null) {
            a.disconnect();
        }
        return aVar;
        th2 = e222;
        a.a.b(request2.getHost());
        a(request2, aVar, requestCb2, ErrorConstant.ERROR_SSL_ERROR, th2);
        ALog.e("awcn.HttpConnector", "connect SSLException", request2.getSeq(), "host", request2.getHost(), th2);
        if (a != null) {
            a.disconnect();
        }
        return aVar;
        th2 = e222;
        a.a.b(request2.getHost());
        a(request2, aVar, requestCb2, ErrorConstant.ERROR_SSL_ERROR, th2);
        ALog.e("awcn.HttpConnector", "HTTP Connect SSLHandshakeException", request2.getSeq(), "host", request2.getHost(), th2);
        if (a != null) {
            a.disconnect();
        }
        return aVar;
        th2 = e222;
        a(request2, aVar, requestCb2, ErrorConstant.ERROR_CONNECT_EXCEPTION, th2);
        ALog.e("awcn.HttpConnector", "HTTP Connect Exception", request2.getSeq(), th2, new Object[0]);
        NetworkStatusHelper.k();
        if (a != null) {
            a.disconnect();
        }
        return aVar;
        th2 = e222;
        a(request2, aVar, requestCb2, ErrorConstant.ERROR_REQUEST_CANCEL, th2);
        ALog.e("awcn.HttpConnector", "HTTP Request Cancel", request2.getSeq(), th2, new Object[0]);
        if (a != null) {
            a.disconnect();
        }
        return aVar;
        th2 = e222;
        try {
            String message = th2.getMessage();
            if (message == null || !message.contains("not verified")) {
                a(request2, aVar, requestCb2, ErrorConstant.ERROR_EXCEPTION, th2);
            } else {
                a.a.b(request2.getHost());
                a(request2, aVar, requestCb2, -403, th2);
            }
            ALog.e("awcn.HttpConnector", "HTTP Connect Exception", request2.getSeq(), th2, new Object[0]);
            if (a != null) {
                a.disconnect();
            }
            return aVar;
        } catch (Throwable e2222) {
            th = e2222;
            if (a != null) {
                try {
                    a.disconnect();
                } catch (Throwable e22222) {
                    ALog.e("awcn.HttpConnector", "http disconnect", null, e22222, new Object[0]);
                }
            }
            throw th;
        }
        a(request2, aVar, requestCb2, ErrorConstant.ERROR_UNKNOWN_HOST_EXCEPTION, e22222);
        ALog.e("awcn.HttpConnector", "Unknown Host Exception", request2.getSeq(), "host", request2.getHost(), th2);
        NetworkStatusHelper.k();
        if (a != null) {
            a.disconnect();
        }
        return aVar;
        th2 = e22222;
        a(request2, aVar, requestCb2, ErrorConstant.ERROR_SOCKET_TIME_OUT, th2);
        ALog.e("awcn.HttpConnector", "HTTP Socket Timeout", request2.getSeq(), th2, new Object[0]);
        NetworkStatusHelper.k();
        if (a != null) {
            a.disconnect();
        }
        return aVar;
    }

    private static void a(Request request, a aVar, RequestCb requestCb, int i, Throwable th) {
        String errMsg = ErrorConstant.getErrMsg(i);
        ALog.e("awcn.HttpConnector", "onException", request.getSeq(), "errorCode", Integer.valueOf(i), "errMsg", errMsg, "url", request.getUrlString(), "host", request.getHost());
        if (aVar != null) {
            aVar.a = i;
        }
        request.rs.statusCode = i;
        request.rs.oneWayTime = System.currentTimeMillis() - request.rs.start;
        if (requestCb != null) {
            requestCb.onFinish(i, errMsg, request.rs);
        }
        if (i != ErrorConstant.ERROR_REQUEST_CANCEL) {
            AppMonitor.getInstance().commitStat(new ExceptionStatistic(i, errMsg, request.rs, th));
        }
    }

    private static java.net.HttpURLConnection a(anet.channel.request.Request r7) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = anet.channel.status.NetworkStatusHelper.j();
        r1 = 0;
        if (r0 == 0) goto L_0x0020;
    L_0x0007:
        r2 = new java.net.Proxy;
        r3 = java.net.Proxy.Type.HTTP;
        r4 = new java.net.InetSocketAddress;
        r5 = r0.first;
        r5 = (java.lang.String) r5;
        r0 = r0.second;
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r4.<init>(r5, r0);
        r2.<init>(r3, r4);
        goto L_0x0021;
    L_0x0020:
        r2 = r1;
    L_0x0021:
        r0 = anet.channel.status.NetworkStatusHelper.a();
        r0 = r0.isMobile();
        if (r0 == 0) goto L_0x0034;
    L_0x002b:
        r0 = anet.channel.GlobalAppRuntimeInfo.getProxySetting();
        if (r0 == 0) goto L_0x0035;
    L_0x0031:
        r2 = r0.a;
        goto L_0x0035;
    L_0x0034:
        r0 = r1;
    L_0x0035:
        r3 = r7.getUrl();	 Catch:{ Exception -> 0x00e2 }
        if (r2 == 0) goto L_0x0043;	 Catch:{ Exception -> 0x00e2 }
    L_0x003b:
        r2 = r3.openConnection(r2);	 Catch:{ Exception -> 0x00e2 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ Exception -> 0x00e2 }
    L_0x0041:
        r1 = r2;	 Catch:{ Exception -> 0x00e2 }
        goto L_0x004a;	 Catch:{ Exception -> 0x00e2 }
    L_0x0043:
        r2 = r3.openConnection();	 Catch:{ Exception -> 0x00e2 }
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ Exception -> 0x00e2 }
        goto L_0x0041;	 Catch:{ Exception -> 0x00e2 }
    L_0x004a:
        r2 = r7.getConnectTimeout();	 Catch:{ Exception -> 0x00e2 }
        r1.setConnectTimeout(r2);	 Catch:{ Exception -> 0x00e2 }
        r2 = r7.getReadTimeout();	 Catch:{ Exception -> 0x00e2 }
        r1.setReadTimeout(r2);	 Catch:{ Exception -> 0x00e2 }
        r2 = r7.getMethod();	 Catch:{ Exception -> 0x00e2 }
        r1.setRequestMethod(r2);	 Catch:{ Exception -> 0x00e2 }
        r2 = r7.containsBody();	 Catch:{ Exception -> 0x00e2 }
        if (r2 == 0) goto L_0x0069;	 Catch:{ Exception -> 0x00e2 }
    L_0x0065:
        r2 = 1;	 Catch:{ Exception -> 0x00e2 }
        r1.setDoOutput(r2);	 Catch:{ Exception -> 0x00e2 }
    L_0x0069:
        r2 = r7.getHeaders();	 Catch:{ Exception -> 0x00e2 }
        r4 = r2.entrySet();	 Catch:{ Exception -> 0x00e2 }
        r4 = r4.iterator();	 Catch:{ Exception -> 0x00e2 }
    L_0x0075:
        r5 = r4.hasNext();	 Catch:{ Exception -> 0x00e2 }
        if (r5 == 0) goto L_0x0091;	 Catch:{ Exception -> 0x00e2 }
    L_0x007b:
        r5 = r4.next();	 Catch:{ Exception -> 0x00e2 }
        r5 = (java.util.Map.Entry) r5;	 Catch:{ Exception -> 0x00e2 }
        r6 = r5.getKey();	 Catch:{ Exception -> 0x00e2 }
        r6 = (java.lang.String) r6;	 Catch:{ Exception -> 0x00e2 }
        r5 = r5.getValue();	 Catch:{ Exception -> 0x00e2 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x00e2 }
        r1.addRequestProperty(r6, r5);	 Catch:{ Exception -> 0x00e2 }
        goto L_0x0075;	 Catch:{ Exception -> 0x00e2 }
    L_0x0091:
        r4 = "Host";	 Catch:{ Exception -> 0x00e2 }
        r4 = r2.get(r4);	 Catch:{ Exception -> 0x00e2 }
        r4 = (java.lang.String) r4;	 Catch:{ Exception -> 0x00e2 }
        if (r4 != 0) goto L_0x009f;	 Catch:{ Exception -> 0x00e2 }
    L_0x009b:
        r4 = r7.getHost();	 Catch:{ Exception -> 0x00e2 }
    L_0x009f:
        r5 = "Host";	 Catch:{ Exception -> 0x00e2 }
        r1.setRequestProperty(r5, r4);	 Catch:{ Exception -> 0x00e2 }
        r5 = anet.channel.status.NetworkStatusHelper.c();	 Catch:{ Exception -> 0x00e2 }
        r6 = "cmwap";	 Catch:{ Exception -> 0x00e2 }
        r5 = r5.equals(r6);	 Catch:{ Exception -> 0x00e2 }
        if (r5 == 0) goto L_0x00b5;	 Catch:{ Exception -> 0x00e2 }
    L_0x00b0:
        r5 = "x-online-host";	 Catch:{ Exception -> 0x00e2 }
        r1.setRequestProperty(r5, r4);	 Catch:{ Exception -> 0x00e2 }
    L_0x00b5:
        r5 = "Accept-Encoding";	 Catch:{ Exception -> 0x00e2 }
        r2 = r2.containsKey(r5);	 Catch:{ Exception -> 0x00e2 }
        if (r2 != 0) goto L_0x00c4;	 Catch:{ Exception -> 0x00e2 }
    L_0x00bd:
        r2 = "Accept-Encoding";	 Catch:{ Exception -> 0x00e2 }
        r5 = "gzip";	 Catch:{ Exception -> 0x00e2 }
        r1.addRequestProperty(r2, r5);	 Catch:{ Exception -> 0x00e2 }
    L_0x00c4:
        if (r0 == 0) goto L_0x00cf;	 Catch:{ Exception -> 0x00e2 }
    L_0x00c6:
        r2 = "Authorization";	 Catch:{ Exception -> 0x00e2 }
        r0 = r0.a();	 Catch:{ Exception -> 0x00e2 }
        r1.setRequestProperty(r2, r0);	 Catch:{ Exception -> 0x00e2 }
    L_0x00cf:
        r0 = r3.getProtocol();	 Catch:{ Exception -> 0x00e2 }
        r2 = "https";	 Catch:{ Exception -> 0x00e2 }
        r0 = r0.equalsIgnoreCase(r2);	 Catch:{ Exception -> 0x00e2 }
        if (r0 == 0) goto L_0x00de;	 Catch:{ Exception -> 0x00e2 }
    L_0x00db:
        a(r1, r7, r4);	 Catch:{ Exception -> 0x00e2 }
    L_0x00de:
        r7 = 0;	 Catch:{ Exception -> 0x00e2 }
        r1.setInstanceFollowRedirects(r7);	 Catch:{ Exception -> 0x00e2 }
    L_0x00e2:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.b.a(anet.channel.request.Request):java.net.HttpURLConnection");
    }

    private static void a(HttpURLConnection httpURLConnection, Request request, String str) {
        if (Integer.parseInt(VERSION.SDK) < 8) {
            ALog.e("awcn.HttpConnector", "supportHttps", "[supportHttps]Froyo 以下版本不支持https", new Object[0]);
            return;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
        if (request.getSslSocketFactory() != null) {
            httpsURLConnection.setSSLSocketFactory(request.getSslSocketFactory());
        } else if (anet.channel.util.b.a() != null) {
            httpsURLConnection.setSSLSocketFactory(anet.channel.util.b.a());
        }
        if (request.getHostnameVerifier() != null) {
            httpsURLConnection.setHostnameVerifier(request.getHostnameVerifier());
        } else if (anet.channel.util.b.b() != null) {
            httpsURLConnection.setHostnameVerifier(anet.channel.util.b.b());
        } else {
            httpsURLConnection.setHostnameVerifier(new c(str));
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Request request) {
        int postBody;
        Throwable th;
        if (request.containsBody()) {
            long currentTimeMillis = System.currentTimeMillis();
            OutputStream outputStream = null;
            try {
                httpURLConnection = httpURLConnection.getOutputStream();
                try {
                    postBody = request.postBody(httpURLConnection);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.flush();
                            httpURLConnection.close();
                        } catch (HttpURLConnection httpURLConnection2) {
                            ALog.e("awcn.HttpConnector", "postData", request.getSeq(), httpURLConnection2, new Object[0]);
                        }
                    }
                } catch (Exception e) {
                    Exception exception = e;
                    outputStream = httpURLConnection2;
                    httpURLConnection2 = exception;
                    try {
                        ALog.e("awcn.HttpConnector", "postData error", request.getSeq(), httpURLConnection2, new Object[0]);
                        if (outputStream != null) {
                            try {
                                outputStream.flush();
                                outputStream.close();
                            } catch (HttpURLConnection httpURLConnection22) {
                                ALog.e("awcn.HttpConnector", "postData", request.getSeq(), httpURLConnection22, new Object[0]);
                            }
                        }
                        postBody = 0;
                        request.rs.sendDataSize = (long) postBody;
                        request.rs.sendDataTime = System.currentTimeMillis() - currentTimeMillis;
                    } catch (Throwable th2) {
                        th = th2;
                        if (outputStream != null) {
                            try {
                                outputStream.flush();
                                outputStream.close();
                            } catch (HttpURLConnection httpURLConnection222) {
                                ALog.e("awcn.HttpConnector", "postData", request.getSeq(), httpURLConnection222, new Object[0]);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = httpURLConnection222;
                    if (outputStream != null) {
                        outputStream.flush();
                        outputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                httpURLConnection222 = e2;
                ALog.e("awcn.HttpConnector", "postData error", request.getSeq(), httpURLConnection222, new Object[0]);
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
                postBody = 0;
                request.rs.sendDataSize = (long) postBody;
                request.rs.sendDataTime = System.currentTimeMillis() - currentTimeMillis;
            }
            request.rs.sendDataSize = (long) postBody;
            request.rs.sendDataTime = System.currentTimeMillis() - currentTimeMillis;
        }
    }

    private static void a(java.net.HttpURLConnection r18, anet.channel.request.Request r19, anet.channel.session.b.a r20, anet.channel.RequestCb r21) throws java.io.IOException, java.util.concurrent.CancellationException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = r19;
        r2 = r20;
        r3 = r21;
        r4 = 0;
        r5 = 0;
        r6 = r18.getInputStream();	 Catch:{ IOException -> 0x000d }
        goto L_0x0047;
    L_0x000d:
        r0 = move-exception;
        r6 = r18.getErrorStream();	 Catch:{ Exception -> 0x0013 }
        goto L_0x0037;
    L_0x0013:
        r0 = move-exception;
        r6 = "awcn.HttpConnector";
        r7 = new java.lang.StringBuilder;
        r8 = "get error stream failed.";
        r7.<init>(r8);
        r8 = r18.getURL();
        r8 = r8.toString();
        r7.append(r8);
        r7 = r7.toString();
        r8 = r19.getSeq();
        r9 = new java.lang.Object[r4];
        r10 = r0;
        anet.channel.util.ALog.e(r6, r7, r8, r10, r9);
        r6 = r5;
    L_0x0037:
        r7 = "awcn.HttpConnector";
        r8 = r18.getURL();
        r8 = r8.toString();
        r9 = new java.lang.Object[r4];
        r10 = r0;
        anet.channel.util.ALog.w(r7, r8, r5, r10, r9);
    L_0x0047:
        if (r6 != 0) goto L_0x004f;
    L_0x0049:
        r4 = -404; // 0xfffffffffffffe6c float:NaN double:NaN;
        a(r1, r2, r3, r4, r5);
        return;
    L_0x004f:
        r7 = r2.c;
        r7 = anet.channel.util.a.c(r7);
        r8 = r2.c;
        r8 = anet.channel.util.a.b(r8);
        if (r8 == 0) goto L_0x0064;
    L_0x005d:
        r9 = r2.c;
        r10 = "Content-Encoding";
        r9.remove(r10);
    L_0x0064:
        if (r3 == 0) goto L_0x006f;
    L_0x0066:
        if (r8 == 0) goto L_0x006d;
    L_0x0068:
        r9 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
        if (r7 > r9) goto L_0x006d;
    L_0x006c:
        goto L_0x006f;
    L_0x006d:
        r9 = r5;
        goto L_0x0078;
    L_0x006f:
        r9 = new java.io.ByteArrayOutputStream;
        if (r7 > 0) goto L_0x0075;
    L_0x0073:
        r7 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
    L_0x0075:
        r9.<init>(r7);
    L_0x0078:
        r7 = new anet.channel.strategy.utils.c;	 Catch:{ all -> 0x014b }
        r7.<init>(r6);	 Catch:{ all -> 0x014b }
        if (r8 == 0) goto L_0x0086;	 Catch:{ all -> 0x014b }
    L_0x007f:
        r10 = new java.util.zip.GZIPInputStream;	 Catch:{ all -> 0x014b }
        r10.<init>(r7);	 Catch:{ all -> 0x014b }
        r6 = r10;
        goto L_0x0087;
    L_0x0086:
        r6 = r7;
    L_0x0087:
        r10 = r5;
    L_0x0088:
        r11 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0147 }
        r11 = r11.isInterrupted();	 Catch:{ all -> 0x0147 }
        if (r11 == 0) goto L_0x009a;
    L_0x0092:
        r1 = new java.util.concurrent.CancellationException;	 Catch:{ all -> 0x014b }
        r2 = "task cancelled";	 Catch:{ all -> 0x014b }
        r1.<init>(r2);	 Catch:{ all -> 0x014b }
        throw r1;	 Catch:{ all -> 0x014b }
    L_0x009a:
        if (r10 != 0) goto L_0x00a4;	 Catch:{ all -> 0x014b }
    L_0x009c:
        r10 = anet.channel.bytes.a.a.a;	 Catch:{ all -> 0x014b }
        r11 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;	 Catch:{ all -> 0x014b }
        r10 = r10.a(r11);	 Catch:{ all -> 0x014b }
    L_0x00a4:
        r11 = r10.readFrom(r6);	 Catch:{ all -> 0x0147 }
        r12 = -1;
        if (r11 == r12) goto L_0x00e0;
    L_0x00ab:
        r11 = r1.rs;	 Catch:{ all -> 0x00d8 }
        r11 = r11.firstDataTime;	 Catch:{ all -> 0x00d8 }
        r13 = 0;	 Catch:{ all -> 0x00d8 }
        r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1));	 Catch:{ all -> 0x00d8 }
        if (r15 != 0) goto L_0x00c6;	 Catch:{ all -> 0x00d8 }
    L_0x00b5:
        r11 = r1.rs;	 Catch:{ all -> 0x00d8 }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00d8 }
        r14 = r1.rs;	 Catch:{ all -> 0x00d8 }
        r14 = r14.start;	 Catch:{ all -> 0x00d8 }
        r16 = r6;
        r5 = r12 - r14;
        r11.firstDataTime = r5;	 Catch:{ all -> 0x00e9 }
        goto L_0x00c8;	 Catch:{ all -> 0x00e9 }
    L_0x00c6:
        r16 = r6;	 Catch:{ all -> 0x00e9 }
    L_0x00c8:
        if (r9 == 0) goto L_0x00d1;	 Catch:{ all -> 0x00e9 }
    L_0x00ca:
        r10.writeTo(r9);	 Catch:{ all -> 0x00e9 }
        r6 = r16;	 Catch:{ all -> 0x00e9 }
        r5 = 0;	 Catch:{ all -> 0x00e9 }
        goto L_0x0088;	 Catch:{ all -> 0x00e9 }
    L_0x00d1:
        r3.onDataReceive(r10, r4);	 Catch:{ all -> 0x00e9 }
        r6 = r16;	 Catch:{ all -> 0x00e9 }
        r5 = 0;	 Catch:{ all -> 0x00e9 }
        goto L_0x0087;	 Catch:{ all -> 0x00e9 }
    L_0x00d8:
        r0 = move-exception;	 Catch:{ all -> 0x00e9 }
        r16 = r6;	 Catch:{ all -> 0x00e9 }
    L_0x00db:
        r1 = r0;	 Catch:{ all -> 0x00e9 }
        r10 = r16;	 Catch:{ all -> 0x00e9 }
        goto L_0x014e;	 Catch:{ all -> 0x00e9 }
    L_0x00e0:
        r16 = r6;	 Catch:{ all -> 0x00e9 }
        r4 = 1;	 Catch:{ all -> 0x00e9 }
        if (r9 == 0) goto L_0x00eb;	 Catch:{ all -> 0x00e9 }
    L_0x00e5:
        r10.recycle();	 Catch:{ all -> 0x00e9 }
        goto L_0x00ee;
    L_0x00e9:
        r0 = move-exception;
        goto L_0x00db;
    L_0x00eb:
        r3.onDataReceive(r10, r4);	 Catch:{ all -> 0x0143 }
    L_0x00ee:
        r5 = r1.rs;	 Catch:{ all -> 0x0143 }
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0143 }
        r6 = r1.rs;	 Catch:{ all -> 0x0143 }
        r12 = r6.start;	 Catch:{ all -> 0x0143 }
        r14 = r10 - r12;	 Catch:{ all -> 0x0143 }
        r6 = r1.rs;	 Catch:{ all -> 0x0143 }
        r10 = r6.firstDataTime;	 Catch:{ all -> 0x0143 }
        r12 = r14 - r10;	 Catch:{ all -> 0x0143 }
        r5.recDataTime = r12;	 Catch:{ all -> 0x0143 }
        r1 = r1.rs;	 Catch:{ all -> 0x0143 }
        r5 = r7.a();	 Catch:{ all -> 0x0143 }
        r1.recDataSize = r5;	 Catch:{ all -> 0x0143 }
        if (r9 == 0) goto L_0x013c;
    L_0x010c:
        r1 = r9.toByteArray();	 Catch:{ all -> 0x00e9 }
        r2.b = r1;	 Catch:{ all -> 0x00e9 }
        if (r8 == 0) goto L_0x012a;	 Catch:{ all -> 0x00e9 }
    L_0x0114:
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x00e9 }
        r1.<init>();	 Catch:{ all -> 0x00e9 }
        r5 = r2.b;	 Catch:{ all -> 0x00e9 }
        r5 = r5.length;	 Catch:{ all -> 0x00e9 }
        r5 = java.lang.String.valueOf(r5);	 Catch:{ all -> 0x00e9 }
        r1.add(r5);	 Catch:{ all -> 0x00e9 }
        r5 = r2.c;	 Catch:{ all -> 0x00e9 }
        r6 = "Content-Length";	 Catch:{ all -> 0x00e9 }
        r5.put(r6, r1);	 Catch:{ all -> 0x00e9 }
    L_0x012a:
        if (r3 == 0) goto L_0x013c;	 Catch:{ all -> 0x00e9 }
    L_0x012c:
        r1 = r2.a;	 Catch:{ all -> 0x00e9 }
        r5 = r2.c;	 Catch:{ all -> 0x00e9 }
        r3.onResponseCode(r1, r5);	 Catch:{ all -> 0x00e9 }
        r1 = r2.b;	 Catch:{ all -> 0x00e9 }
        r1 = anet.channel.bytes.ByteArray.wrap(r1);	 Catch:{ all -> 0x00e9 }
        r3.onDataReceive(r1, r4);	 Catch:{ all -> 0x00e9 }
    L_0x013c:
        r10 = r16;
        r10.close();	 Catch:{ IOException -> 0x0142 }
        return;
    L_0x0142:
        return;
    L_0x0143:
        r0 = move-exception;
        r10 = r16;
        goto L_0x0149;
    L_0x0147:
        r0 = move-exception;
        r10 = r6;
    L_0x0149:
        r1 = r0;
        goto L_0x014e;
    L_0x014b:
        r0 = move-exception;
        r1 = r0;
        r10 = r6;
    L_0x014e:
        if (r10 == 0) goto L_0x0153;
    L_0x0150:
        r10.close();	 Catch:{ IOException -> 0x0153 }
    L_0x0153:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.b.a(java.net.HttpURLConnection, anet.channel.request.Request, anet.channel.session.b$a, anet.channel.RequestCb):void");
    }
}
