package com.tencent.open.b;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.taobao.agoo.a.a.b;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.f;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.d;
import com.tencent.open.utils.e;
import com.tencent.open.utils.h;
import com.tencent.open.utils.i;
import com.umeng.message.util.HttpRequest;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class g {
    protected static g a;
    protected Random b = new Random();
    protected List<Serializable> c = Collections.synchronizedList(new ArrayList());
    protected List<Serializable> d = Collections.synchronizedList(new ArrayList());
    protected HandlerThread e = null;
    protected Handler f;
    protected Executor g = h.b();
    protected Executor h = h.b();

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (a == null) {
                a = new g();
            }
            gVar = a;
        }
        return gVar;
    }

    private g() {
        if (this.e == null) {
            this.e = new HandlerThread("opensdk.report.handlerthread", 10);
            this.e.start();
        }
        if (this.e.isAlive() && this.e.getLooper() != null) {
            this.f = new Handler(this, this.e.getLooper()) {
                final /* synthetic */ g a;

                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 1000:
                            this.a.b();
                            break;
                        case 1001:
                            this.a.e();
                            break;
                        default:
                            break;
                    }
                    super.handleMessage(message);
                }
            };
        }
    }

    public void a(final Bundle bundle, String str, final boolean z) {
        if (bundle != null) {
            StringBuilder stringBuilder = new StringBuilder("-->reportVia, bundle: ");
            stringBuilder.append(bundle.toString());
            f.a("openSDK_LOG.ReportManager", stringBuilder.toString());
            if (a("report_via", str) != null || z) {
                this.g.execute(new Runnable(this) {
                    final /* synthetic */ g c;

                    public void run() {
                        try {
                            Bundle bundle = new Bundle();
                            bundle.putString("uin", Constants.DEFAULT_UIN);
                            bundle.putString("imei", c.b(d.a()));
                            bundle.putString(com.taobao.accs.common.Constants.KEY_IMSI, c.c(d.a()));
                            bundle.putString(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, c.d(d.a()));
                            bundle.putString(SocializeProtocolConstants.PROTOCOL_KEY_MAC, c.a());
                            bundle.putString("platform", "1");
                            bundle.putString("os_ver", VERSION.RELEASE);
                            bundle.putString("position", i.c(d.a()));
                            bundle.putString("network", a.a(d.a()));
                            bundle.putString("language", c.b());
                            bundle.putString("resolution", c.a(d.a()));
                            bundle.putString("apn", a.b(d.a()));
                            bundle.putString("model_name", Build.MODEL);
                            bundle.putString("timezone", TimeZone.getDefault().getID());
                            bundle.putString("sdk_ver", Constants.SDK_VERSION);
                            bundle.putString("qz_ver", i.d(d.a(), "com.qzone"));
                            bundle.putString("qq_ver", i.c(d.a(), "com.tencent.mobileqq"));
                            bundle.putString("qua", i.e(d.a(), d.b()));
                            bundle.putString("packagename", d.b());
                            bundle.putString("app_ver", i.d(d.a(), d.b()));
                            if (bundle != null) {
                                bundle.putAll(bundle);
                            }
                            this.c.d.add(new b(bundle));
                            int size = this.c.d.size();
                            int a = e.a(d.a(), null).a("Agent_ReportTimeInterval");
                            if (a == 0) {
                                a = 10000;
                            }
                            if (!this.c.a("report_via", size)) {
                                if (!z) {
                                    if (!this.c.f.hasMessages(1001)) {
                                        Message obtain = Message.obtain();
                                        obtain.what = 1001;
                                        this.c.f.sendMessageDelayed(obtain, (long) a);
                                    }
                                    return;
                                }
                            }
                            this.c.e();
                            this.c.f.removeMessages(1001);
                        } catch (Throwable e) {
                            f.b("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e);
                        }
                    }
                });
            }
        }
    }

    public void a(String str, long j, long j2, long j3, int i) {
        a(str, j, j2, j3, i, "", false);
    }

    public void a(String str, long j, long j2, long j3, int i, String str2, boolean z) {
        StringBuilder stringBuilder = new StringBuilder("-->reportCgi, command: ");
        final String str3 = str;
        stringBuilder.append(str3);
        stringBuilder.append(" | startTime: ");
        final long j4 = j;
        stringBuilder.append(j4);
        stringBuilder.append(" | reqSize:");
        final long j5 = j2;
        stringBuilder.append(j5);
        stringBuilder.append(" | rspSize: ");
        final long j6 = j3;
        stringBuilder.append(j6);
        stringBuilder.append(" | responseCode: ");
        final int i2 = i;
        stringBuilder.append(i2);
        stringBuilder.append(" | detail: ");
        final String str4 = str2;
        stringBuilder.append(str4);
        f.a("openSDK_LOG.ReportManager", stringBuilder.toString());
        if (a("report_cgi", String.valueOf(i)) || z) {
            final boolean z2 = z;
            r12.h.execute(new Runnable(r12) {
                final /* synthetic */ g h;

                public void run() {
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - j4;
                        Bundle bundle = new Bundle();
                        String a = a.a(d.a());
                        bundle.putString("apn", a);
                        bundle.putString("appid", "1000067");
                        bundle.putString("commandid", str3);
                        bundle.putString("detail", str4);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("network=");
                        stringBuilder.append(a);
                        stringBuilder.append('&');
                        stringBuilder.append("sdcard=");
                        stringBuilder.append(Environment.getExternalStorageState().equals("mounted"));
                        stringBuilder.append('&');
                        stringBuilder.append("wifi=");
                        stringBuilder.append(a.e(d.a()));
                        bundle.putString("deviceInfo", stringBuilder.toString());
                        int i = 100;
                        int a2 = 100 / this.h.a(i2);
                        if (a2 <= 0) {
                            i = 1;
                        } else if (a2 <= 100) {
                            i = a2;
                        }
                        bundle.putString("frequency", String.valueOf(i));
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(j5);
                        bundle.putString("reqSize", stringBuilder.toString());
                        a = b.JSON_ERRORCODE;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(i2);
                        bundle.putString(a, stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(j6);
                        bundle.putString("rspSize", stringBuilder.toString());
                        bundle.putString("timeCost", String.valueOf(elapsedRealtime));
                        bundle.putString("uin", Constants.DEFAULT_UIN);
                        this.h.c.add(new b(bundle));
                        int size = this.h.c.size();
                        a2 = e.a(d.a(), null).a("Agent_ReportTimeInterval");
                        if (a2 == 0) {
                            a2 = 10000;
                        }
                        if (!this.h.a("report_cgi", size)) {
                            if (!z2) {
                                if (!this.h.f.hasMessages(1000)) {
                                    Message obtain = Message.obtain();
                                    obtain.what = 1000;
                                    this.h.f.sendMessageDelayed(obtain, (long) a2);
                                }
                                return;
                            }
                        }
                        this.h.b();
                        this.h.f.removeMessages(1000);
                    } catch (Throwable e) {
                        f.b("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e);
                    }
                }
            });
        }
    }

    protected void b() {
        this.h.execute(new Runnable(this) {
            final /* synthetic */ g a;

            {
                this.a = r1;
            }

            public void run() {
                try {
                    Bundle c = this.a.c();
                    if (c != null) {
                        int a = e.a(d.a(), null).a("Common_HttpRetryCount");
                        if (a == 0) {
                            a = 3;
                        }
                        StringBuilder stringBuilder = new StringBuilder("-->doReportCgi, retryCount: ");
                        stringBuilder.append(a);
                        f.b("openSDK_LOG.ReportManager", stringBuilder.toString());
                        int i = 0;
                        int i2 = 0;
                        do {
                            i2++;
                            try {
                                HttpClient httpClient = HttpUtils.getHttpClient(d.a(), null, "http://wspeed.qq.com/w.cgi");
                                HttpUriRequest httpPost = new HttpPost("http://wspeed.qq.com/w.cgi");
                                httpPost.addHeader("Accept-Encoding", "gzip");
                                httpPost.setHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM);
                                httpPost.setEntity(new ByteArrayEntity(i.i(HttpUtils.encodeUrl(c))));
                                int statusCode = httpClient.execute(httpPost).getStatusLine().getStatusCode();
                                StringBuilder stringBuilder2 = new StringBuilder("-->doReportCgi, statusCode: ");
                                stringBuilder2.append(statusCode);
                                f.b("openSDK_LOG.ReportManager", stringBuilder2.toString());
                                if (statusCode == 200) {
                                    f.a().b("report_cgi");
                                    i = 1;
                                }
                            } catch (Throwable e) {
                                f.b("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e);
                                continue;
                            } catch (Throwable e2) {
                                f.b("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e2);
                                continue;
                            } catch (Throwable e3) {
                                f.b("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e3);
                            }
                            if (i == 0) {
                                f.a().a("report_cgi", this.a.c);
                            }
                            this.a.c.clear();
                        } while (i2 < a);
                        if (i == 0) {
                            f.a().a("report_cgi", this.a.c);
                        }
                        this.a.c.clear();
                    }
                } catch (Throwable e32) {
                    f.b("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception out.", e32);
                }
            }
        });
    }

    protected boolean a(java.lang.String r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = "openSDK_LOG.ReportManager";
        r1 = new java.lang.StringBuilder;
        r2 = "-->availableFrequency, report: ";
        r1.<init>(r2);
        r1.append(r5);
        r2 = " | ext: ";
        r1.append(r2);
        r1.append(r6);
        r1 = r1.toString();
        com.tencent.open.a.f.b(r0, r1);
        r0 = android.text.TextUtils.isEmpty(r5);
        r1 = 0;
        if (r0 == 0) goto L_0x0023;
    L_0x0022:
        return r1;
    L_0x0023:
        r0 = "report_cgi";
        r0 = r5.equals(r0);
        r2 = 1;
        r3 = 100;
        if (r0 == 0) goto L_0x0040;
    L_0x002e:
        r5 = java.lang.Integer.parseInt(r6);	 Catch:{ Exception -> 0x003f }
        r5 = r4.a(r5);
        r6 = r4.b;
        r6 = r6.nextInt(r3);
        if (r6 >= r5) goto L_0x0057;
    L_0x003e:
        goto L_0x0054;
    L_0x003f:
        return r1;
    L_0x0040:
        r0 = "report_via";
        r5 = r5.equals(r0);
        if (r5 == 0) goto L_0x0056;
    L_0x0048:
        r5 = com.tencent.open.b.e.a(r6);
        r6 = r4.b;
        r6 = r6.nextInt(r3);
        if (r6 >= r5) goto L_0x0057;
    L_0x0054:
        r1 = r2;
        goto L_0x0057;
    L_0x0056:
        r5 = r3;
    L_0x0057:
        r6 = "openSDK_LOG.ReportManager";
        r0 = new java.lang.StringBuilder;
        r2 = "-->availableFrequency, result: ";
        r0.<init>(r2);
        r0.append(r1);
        r2 = " | frequency: ";
        r0.append(r2);
        r0.append(r5);
        r5 = r0.toString();
        com.tencent.open.a.f.b(r6, r5);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g.a(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected boolean a(java.lang.String r6, int r7) {
        /*
        r5 = this;
        r0 = "report_cgi";
        r0 = r6.equals(r0);
        r1 = 5;
        r2 = 0;
        r3 = 0;
        if (r0 == 0) goto L_0x001d;
    L_0x000b:
        r0 = com.tencent.open.utils.d.a();
        r0 = com.tencent.open.utils.e.a(r0, r2);
        r2 = "Common_CGIReportMaxcount";
        r0 = r0.a(r2);
        if (r0 != 0) goto L_0x0037;
    L_0x001b:
        r0 = r1;
        goto L_0x0037;
    L_0x001d:
        r0 = "report_via";
        r0 = r6.equals(r0);
        if (r0 == 0) goto L_0x0036;
    L_0x0025:
        r0 = com.tencent.open.utils.d.a();
        r0 = com.tencent.open.utils.e.a(r0, r2);
        r2 = "Agent_ReportBatchCount";
        r0 = r0.a(r2);
        if (r0 != 0) goto L_0x0037;
    L_0x0035:
        goto L_0x001b;
    L_0x0036:
        r0 = r3;
    L_0x0037:
        r1 = "openSDK_LOG.ReportManager";
        r2 = new java.lang.StringBuilder;
        r4 = "-->availableCount, report: ";
        r2.<init>(r4);
        r2.append(r6);
        r6 = " | dataSize: ";
        r2.append(r6);
        r2.append(r7);
        r6 = " | maxcount: ";
        r2.append(r6);
        r2.append(r0);
        r6 = r2.toString();
        com.tencent.open.a.f.b(r1, r6);
        if (r7 < r0) goto L_0x005e;
    L_0x005c:
        r6 = 1;
        return r6;
    L_0x005e:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g.a(java.lang.String, int):boolean");
    }

    protected int a(int i) {
        if (i == 0) {
            i = e.a(d.a(), null).a("Common_CGIReportFrequencySuccess");
            if (i == 0) {
                return 10;
            }
            return i;
        }
        i = e.a(d.a(), null).a("Common_CGIReportFrequencyFailed");
        return i == 0 ? 100 : i;
    }

    protected Bundle c() {
        if (this.c.size() == 0) {
            return null;
        }
        int i = 0;
        b bVar = (b) this.c.get(0);
        if (bVar == null) {
            f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
            return null;
        }
        String str = (String) bVar.a.get("appid");
        Collection a = f.a().a("report_cgi");
        if (a != null) {
            this.c.addAll(a);
        }
        StringBuilder stringBuilder = new StringBuilder("-->prepareCgiData, mCgiList size: ");
        stringBuilder.append(this.c.size());
        f.b("openSDK_LOG.ReportManager", stringBuilder.toString());
        if (this.c.size() == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            bundle.putString("appid", str);
            bundle.putString("releaseversion", Constants.SDK_VERSION_REPORT);
            bundle.putString(com.alipay.sdk.packet.d.n, Build.DEVICE);
            bundle.putString("qua", Constants.SDK_QUA);
            bundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
            while (i < this.c.size()) {
                bVar = (b) this.c.get(i);
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("_1");
                bundle.putString(stringBuilder.toString(), (String) bVar.a.get("apn"));
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("_2");
                bundle.putString(stringBuilder.toString(), (String) bVar.a.get("frequency"));
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("_3");
                bundle.putString(stringBuilder.toString(), (String) bVar.a.get("commandid"));
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("_4");
                bundle.putString(stringBuilder.toString(), (String) bVar.a.get(b.JSON_ERRORCODE));
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("_5");
                bundle.putString(stringBuilder.toString(), (String) bVar.a.get("timeCost"));
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("_6");
                bundle.putString(stringBuilder.toString(), (String) bVar.a.get("reqSize"));
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("_7");
                bundle.putString(stringBuilder.toString(), (String) bVar.a.get("rspSize"));
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("_8");
                bundle.putString(stringBuilder.toString(), (String) bVar.a.get("detail"));
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("_9");
                bundle.putString(stringBuilder.toString(), (String) bVar.a.get("uin"));
                stringBuilder = new StringBuilder();
                stringBuilder.append(c.e(d.a()));
                stringBuilder.append("&");
                stringBuilder.append((String) bVar.a.get("deviceInfo"));
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("_10");
                bundle.putString(stringBuilder.toString(), str);
                i++;
            }
            StringBuilder stringBuilder2 = new StringBuilder("-->prepareCgiData, end. params: ");
            stringBuilder2.append(bundle.toString());
            f.a("openSDK_LOG.ReportManager", stringBuilder2.toString());
            return bundle;
        } catch (Throwable e) {
            f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", e);
            return null;
        }
    }

    protected Bundle d() {
        Collection a = f.a().a("report_via");
        if (a != null) {
            this.d.addAll(a);
        }
        StringBuilder stringBuilder = new StringBuilder("-->prepareViaData, mViaList size: ");
        stringBuilder.append(this.d.size());
        f.b("openSDK_LOG.ReportManager", stringBuilder.toString());
        if (this.d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Serializable serializable : this.d) {
            JSONObject jSONObject = new JSONObject();
            b bVar = (b) serializable;
            for (String str : bVar.a.keySet()) {
                try {
                    Object obj = (String) bVar.a.get(str);
                    if (obj == null) {
                        obj = "";
                    }
                    jSONObject.put(str, obj);
                } catch (Throwable e) {
                    f.b("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e);
                }
            }
            jSONArray.put(jSONObject);
        }
        StringBuilder stringBuilder2 = new StringBuilder("-->prepareViaData, JSONArray array: ");
        stringBuilder2.append(jSONArray.toString());
        f.a("openSDK_LOG.ReportManager", stringBuilder2.toString());
        Bundle bundle = new Bundle();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            bundle.putString("data", jSONObject2.toString());
            return bundle;
        } catch (Throwable e2) {
            f.b("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
            return null;
        }
    }

    protected void e() {
        this.g.execute(new Runnable(this) {
            final /* synthetic */ g a;

            {
                this.a = r1;
            }

            public void run() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r28 = this;
                r1 = r28;
                r2 = r1.a;	 Catch:{ Exception -> 0x011e }
                r2 = r2.d();	 Catch:{ Exception -> 0x011e }
                if (r2 != 0) goto L_0x000b;	 Catch:{ Exception -> 0x011e }
            L_0x000a:
                return;	 Catch:{ Exception -> 0x011e }
            L_0x000b:
                r3 = "openSDK_LOG.ReportManager";	 Catch:{ Exception -> 0x011e }
                r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x011e }
                r5 = "-->doReportVia, params: ";	 Catch:{ Exception -> 0x011e }
                r4.<init>(r5);	 Catch:{ Exception -> 0x011e }
                r5 = r2.toString();	 Catch:{ Exception -> 0x011e }
                r4.append(r5);	 Catch:{ Exception -> 0x011e }
                r4 = r4.toString();	 Catch:{ Exception -> 0x011e }
                com.tencent.open.a.f.a(r3, r4);	 Catch:{ Exception -> 0x011e }
                r3 = com.tencent.open.b.e.a();	 Catch:{ Exception -> 0x011e }
                r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Exception -> 0x011e }
                r6 = 0;
                r9 = r6;
                r14 = r9;
                r10 = 0;
                r12 = 0;
            L_0x0031:
                r15 = 1;
                r6 = r6 + r15;
                r16 = -4;
                r7 = com.tencent.open.utils.d.a();	 Catch:{ ConnectTimeoutException -> 0x00cc, SocketTimeoutException -> 0x00c6, JSONException -> 0x00bb, NetworkUnavailableException -> 0x00ac, HttpStatusException -> 0x0088, IOException -> 0x007f, Exception -> 0x0079 }
                r8 = "http://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report";	 Catch:{ ConnectTimeoutException -> 0x00cc, SocketTimeoutException -> 0x00c6, JSONException -> 0x00bb, NetworkUnavailableException -> 0x00ac, HttpStatusException -> 0x0088, IOException -> 0x007f, Exception -> 0x0079 }
                r15 = "POST";	 Catch:{ ConnectTimeoutException -> 0x00cc, SocketTimeoutException -> 0x00c6, JSONException -> 0x00bb, NetworkUnavailableException -> 0x00ac, HttpStatusException -> 0x0088, IOException -> 0x007f, Exception -> 0x0079 }
                r7 = com.tencent.open.utils.HttpUtils.openUrl2(r7, r8, r15, r2);	 Catch:{ ConnectTimeoutException -> 0x00cc, SocketTimeoutException -> 0x00c6, JSONException -> 0x00bb, NetworkUnavailableException -> 0x00ac, HttpStatusException -> 0x0088, IOException -> 0x007f, Exception -> 0x0079 }
                r8 = r7.a;	 Catch:{ ConnectTimeoutException -> 0x00cc, SocketTimeoutException -> 0x00c6, JSONException -> 0x00bb, NetworkUnavailableException -> 0x00ac, HttpStatusException -> 0x0088, IOException -> 0x007f, Exception -> 0x0079 }
                r8 = com.tencent.open.utils.i.d(r8);	 Catch:{ ConnectTimeoutException -> 0x00cc, SocketTimeoutException -> 0x00c6, JSONException -> 0x00bb, NetworkUnavailableException -> 0x00ac, HttpStatusException -> 0x0088, IOException -> 0x007f, Exception -> 0x0079 }
                r15 = "ret";	 Catch:{ JSONException -> 0x0053, ConnectTimeoutException -> 0x00cc, SocketTimeoutException -> 0x00c6, NetworkUnavailableException -> 0x00ac, HttpStatusException -> 0x004e, IOException -> 0x007f, Exception -> 0x0079 }
                r8 = r8.getInt(r15);	 Catch:{ JSONException -> 0x0053, ConnectTimeoutException -> 0x00cc, SocketTimeoutException -> 0x00c6, NetworkUnavailableException -> 0x00ac, HttpStatusException -> 0x004e, IOException -> 0x007f, Exception -> 0x0079 }
                goto L_0x0055;
            L_0x004e:
                r0 = move-exception;
                r2 = r0;
                r18 = r4;
                goto L_0x008c;
            L_0x0053:
                r8 = r16;
            L_0x0055:
                if (r8 == 0) goto L_0x0063;
            L_0x0057:
                r8 = r7.a;	 Catch:{ ConnectTimeoutException -> 0x00cc, SocketTimeoutException -> 0x00c6, JSONException -> 0x00bb, NetworkUnavailableException -> 0x00ac, HttpStatusException -> 0x004e, IOException -> 0x007f, Exception -> 0x0079 }
                r8 = android.text.TextUtils.isEmpty(r8);	 Catch:{ ConnectTimeoutException -> 0x00cc, SocketTimeoutException -> 0x00c6, JSONException -> 0x00bb, NetworkUnavailableException -> 0x00ac, HttpStatusException -> 0x004e, IOException -> 0x007f, Exception -> 0x0079 }
                if (r8 != 0) goto L_0x0060;
            L_0x005f:
                goto L_0x0063;
            L_0x0060:
                r18 = r4;
                goto L_0x0067;
            L_0x0063:
                r6 = r3;
                r18 = r4;
                r9 = 1;
            L_0x0067:
                r4 = r7.b;	 Catch:{ ConnectTimeoutException -> 0x00cc, SocketTimeoutException -> 0x00c6, JSONException -> 0x00bd, NetworkUnavailableException -> 0x00ac, HttpStatusException -> 0x0077, IOException -> 0x0075, Exception -> 0x007b }
                r7 = r7.c;	 Catch:{ ConnectTimeoutException -> 0x00cc, SocketTimeoutException -> 0x00c6, JSONException -> 0x00bd, NetworkUnavailableException -> 0x00ac, HttpStatusException -> 0x0071, IOException -> 0x0075, Exception -> 0x007b }
                r10 = r4;
                r12 = r7;
                r4 = r18;
                goto L_0x00d3;
            L_0x0071:
                r0 = move-exception;
                r2 = r0;
                r10 = r4;
                goto L_0x008c;
            L_0x0075:
                r0 = move-exception;
                goto L_0x0082;
            L_0x0077:
                r0 = move-exception;
                goto L_0x008b;
            L_0x0079:
                r18 = r4;
            L_0x007b:
                r4 = -6;
                r6 = r3;
            L_0x007d:
                r14 = r4;
                goto L_0x00bf;
            L_0x007f:
                r0 = move-exception;
                r18 = r4;
            L_0x0082:
                r4 = r0;
                r4 = com.tencent.open.utils.HttpUtils.getErrorCodeFromException(r4);	 Catch:{ Exception -> 0x011e }
                goto L_0x007d;
            L_0x0088:
                r0 = move-exception;
                r18 = r4;
            L_0x008b:
                r2 = r0;
            L_0x008c:
                r2 = r2.getMessage();	 Catch:{ Exception -> 0x00a3 }
                r3 = "http status code error:";	 Catch:{ Exception -> 0x00a3 }
                r4 = "";	 Catch:{ Exception -> 0x00a3 }
                r2 = r2.replace(r3, r4);	 Catch:{ Exception -> 0x00a3 }
                r2 = java.lang.Integer.parseInt(r2);	 Catch:{ Exception -> 0x00a3 }
                r25 = r2;
                r21 = r10;
                r23 = r12;
                goto L_0x00a9;
            L_0x00a3:
                r21 = r10;
                r23 = r12;
                r25 = r14;
            L_0x00a9:
                r19 = r18;
                goto L_0x00dd;
            L_0x00ac:
                r2 = r1.a;	 Catch:{ Exception -> 0x011e }
                r2 = r2.d;	 Catch:{ Exception -> 0x011e }
                r2.clear();	 Catch:{ Exception -> 0x011e }
                r2 = "openSDK_LOG.ReportManager";	 Catch:{ Exception -> 0x011e }
                r3 = "doReportVia, NetworkUnavailableException.";	 Catch:{ Exception -> 0x011e }
                com.tencent.open.a.f.b(r2, r3);	 Catch:{ Exception -> 0x011e }
                return;	 Catch:{ Exception -> 0x011e }
            L_0x00bb:
                r18 = r4;	 Catch:{ Exception -> 0x011e }
            L_0x00bd:
                r14 = r16;	 Catch:{ Exception -> 0x011e }
            L_0x00bf:
                r4 = r18;	 Catch:{ Exception -> 0x011e }
            L_0x00c1:
                r10 = 0;	 Catch:{ Exception -> 0x011e }
                r12 = 0;	 Catch:{ Exception -> 0x011e }
                goto L_0x00d3;	 Catch:{ Exception -> 0x011e }
            L_0x00c6:
                r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Exception -> 0x011e }
                r7 = -8;	 Catch:{ Exception -> 0x011e }
                goto L_0x00d1;	 Catch:{ Exception -> 0x011e }
            L_0x00cc:
                r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Exception -> 0x011e }
                r7 = -7;	 Catch:{ Exception -> 0x011e }
            L_0x00d1:
                r14 = r7;	 Catch:{ Exception -> 0x011e }
                goto L_0x00c1;	 Catch:{ Exception -> 0x011e }
            L_0x00d3:
                if (r6 < r3) goto L_0x0031;	 Catch:{ Exception -> 0x011e }
            L_0x00d5:
                r19 = r4;	 Catch:{ Exception -> 0x011e }
                r21 = r10;	 Catch:{ Exception -> 0x011e }
                r23 = r12;	 Catch:{ Exception -> 0x011e }
                r25 = r14;	 Catch:{ Exception -> 0x011e }
            L_0x00dd:
                r2 = r1.a;	 Catch:{ Exception -> 0x011e }
                r18 = "mapp_apptrace_sdk";	 Catch:{ Exception -> 0x011e }
                r26 = 0;	 Catch:{ Exception -> 0x011e }
                r27 = 0;	 Catch:{ Exception -> 0x011e }
                r17 = r2;	 Catch:{ Exception -> 0x011e }
                r17.a(r18, r19, r21, r23, r25, r26, r27);	 Catch:{ Exception -> 0x011e }
                if (r9 == 0) goto L_0x00f6;	 Catch:{ Exception -> 0x011e }
            L_0x00ec:
                r2 = com.tencent.open.b.f.a();	 Catch:{ Exception -> 0x011e }
                r3 = "report_via";	 Catch:{ Exception -> 0x011e }
                r2.b(r3);	 Catch:{ Exception -> 0x011e }
                goto L_0x0103;	 Catch:{ Exception -> 0x011e }
            L_0x00f6:
                r2 = com.tencent.open.b.f.a();	 Catch:{ Exception -> 0x011e }
                r3 = "report_via";	 Catch:{ Exception -> 0x011e }
                r4 = r1.a;	 Catch:{ Exception -> 0x011e }
                r4 = r4.d;	 Catch:{ Exception -> 0x011e }
                r2.a(r3, r4);	 Catch:{ Exception -> 0x011e }
            L_0x0103:
                r2 = r1.a;	 Catch:{ Exception -> 0x011e }
                r2 = r2.d;	 Catch:{ Exception -> 0x011e }
                r2.clear();	 Catch:{ Exception -> 0x011e }
                r2 = "openSDK_LOG.ReportManager";	 Catch:{ Exception -> 0x011e }
                r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x011e }
                r4 = "-->doReportVia, uploadSuccess: ";	 Catch:{ Exception -> 0x011e }
                r3.<init>(r4);	 Catch:{ Exception -> 0x011e }
                r3.append(r9);	 Catch:{ Exception -> 0x011e }
                r3 = r3.toString();	 Catch:{ Exception -> 0x011e }
                com.tencent.open.a.f.b(r2, r3);	 Catch:{ Exception -> 0x011e }
                return;
            L_0x011e:
                r0 = move-exception;
                r2 = r0;
                r3 = "openSDK_LOG.ReportManager";
                r4 = "-->doReportVia, exception in serial executor.";
                com.tencent.open.a.f.b(r3, r4, r2);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g.5.run():void");
            }
        });
    }

    public void a(String str, String str2, Bundle bundle, boolean z) {
        final Bundle bundle2 = bundle;
        final String str3 = str;
        final boolean z2 = z;
        final String str4 = str2;
        h.a(new Runnable(this) {
            final /* synthetic */ g e;

            public void run() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r10 = this;
                r0 = r2;	 Catch:{ Exception -> 0x0102 }
                if (r0 != 0) goto L_0x000c;	 Catch:{ Exception -> 0x0102 }
            L_0x0004:
                r0 = "openSDK_LOG.ReportManager";	 Catch:{ Exception -> 0x0102 }
                r1 = "-->httpRequest, params is null!";	 Catch:{ Exception -> 0x0102 }
                com.tencent.open.a.f.e(r0, r1);	 Catch:{ Exception -> 0x0102 }
                return;	 Catch:{ Exception -> 0x0102 }
            L_0x000c:
                r0 = com.tencent.open.b.e.a();	 Catch:{ Exception -> 0x0102 }
                if (r0 != 0) goto L_0x0013;	 Catch:{ Exception -> 0x0102 }
            L_0x0012:
                r0 = 3;	 Catch:{ Exception -> 0x0102 }
            L_0x0013:
                r1 = "openSDK_LOG.ReportManager";	 Catch:{ Exception -> 0x0102 }
                r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0102 }
                r3 = "-->httpRequest, retryCount: ";	 Catch:{ Exception -> 0x0102 }
                r2.<init>(r3);	 Catch:{ Exception -> 0x0102 }
                r2.append(r0);	 Catch:{ Exception -> 0x0102 }
                r2 = r2.toString();	 Catch:{ Exception -> 0x0102 }
                com.tencent.open.a.f.b(r1, r2);	 Catch:{ Exception -> 0x0102 }
                r1 = com.tencent.open.utils.d.a();	 Catch:{ Exception -> 0x0102 }
                r2 = 0;	 Catch:{ Exception -> 0x0102 }
                r3 = r3;	 Catch:{ Exception -> 0x0102 }
                r1 = com.tencent.open.utils.HttpUtils.getHttpClient(r1, r2, r3);	 Catch:{ Exception -> 0x0102 }
                r2 = r2;	 Catch:{ Exception -> 0x0102 }
                r2 = com.tencent.open.utils.HttpUtils.encodeUrl(r2);	 Catch:{ Exception -> 0x0102 }
                r3 = r4;	 Catch:{ Exception -> 0x0102 }
                if (r3 == 0) goto L_0x003f;	 Catch:{ Exception -> 0x0102 }
            L_0x003b:
                r2 = java.net.URLEncoder.encode(r2);	 Catch:{ Exception -> 0x0102 }
            L_0x003f:
                r3 = r5;	 Catch:{ Exception -> 0x0102 }
                r3 = r3.toUpperCase();	 Catch:{ Exception -> 0x0102 }
                r4 = "GET";	 Catch:{ Exception -> 0x0102 }
                r3 = r3.equals(r4);	 Catch:{ Exception -> 0x0102 }
                if (r3 == 0) goto L_0x0061;	 Catch:{ Exception -> 0x0102 }
            L_0x004d:
                r3 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x0102 }
                r4 = r3;	 Catch:{ Exception -> 0x0102 }
                r3.<init>(r4);	 Catch:{ Exception -> 0x0102 }
                r3.append(r2);	 Catch:{ Exception -> 0x0102 }
                r2 = new org.apache.http.client.methods.HttpGet;	 Catch:{ Exception -> 0x0102 }
                r3 = r3.toString();	 Catch:{ Exception -> 0x0102 }
                r2.<init>(r3);	 Catch:{ Exception -> 0x0102 }
                goto L_0x0083;	 Catch:{ Exception -> 0x0102 }
            L_0x0061:
                r3 = r5;	 Catch:{ Exception -> 0x0102 }
                r3 = r3.toUpperCase();	 Catch:{ Exception -> 0x0102 }
                r4 = "POST";	 Catch:{ Exception -> 0x0102 }
                r3 = r3.equals(r4);	 Catch:{ Exception -> 0x0102 }
                if (r3 == 0) goto L_0x00fa;	 Catch:{ Exception -> 0x0102 }
            L_0x006f:
                r3 = new org.apache.http.client.methods.HttpPost;	 Catch:{ Exception -> 0x0102 }
                r4 = r3;	 Catch:{ Exception -> 0x0102 }
                r3.<init>(r4);	 Catch:{ Exception -> 0x0102 }
                r2 = com.tencent.open.utils.i.i(r2);	 Catch:{ Exception -> 0x0102 }
                r4 = new org.apache.http.entity.ByteArrayEntity;	 Catch:{ Exception -> 0x0102 }
                r4.<init>(r2);	 Catch:{ Exception -> 0x0102 }
                r3.setEntity(r4);	 Catch:{ Exception -> 0x0102 }
                r2 = r3;	 Catch:{ Exception -> 0x0102 }
            L_0x0083:
                r3 = "Accept-Encoding";	 Catch:{ Exception -> 0x0102 }
                r4 = "gzip";	 Catch:{ Exception -> 0x0102 }
                r2.addHeader(r3, r4);	 Catch:{ Exception -> 0x0102 }
                r3 = "Content-Type";	 Catch:{ Exception -> 0x0102 }
                r4 = "application/x-www-form-urlencoded";	 Catch:{ Exception -> 0x0102 }
                r2.addHeader(r3, r4);	 Catch:{ Exception -> 0x0102 }
                r3 = 0;
                r4 = r3;
            L_0x0093:
                r5 = 1;
                r3 = r3 + r5;
                r6 = r1.execute(r2);	 Catch:{ ConnectTimeoutException -> 0x00df, SocketTimeoutException -> 0x00d7, Exception -> 0x00cf }
                r6 = r6.getStatusLine();	 Catch:{ ConnectTimeoutException -> 0x00df, SocketTimeoutException -> 0x00d7, Exception -> 0x00cf }
                r6 = r6.getStatusCode();	 Catch:{ ConnectTimeoutException -> 0x00df, SocketTimeoutException -> 0x00d7, Exception -> 0x00cf }
                r7 = "openSDK_LOG.ReportManager";	 Catch:{ ConnectTimeoutException -> 0x00df, SocketTimeoutException -> 0x00d7, Exception -> 0x00cf }
                r8 = new java.lang.StringBuilder;	 Catch:{ ConnectTimeoutException -> 0x00df, SocketTimeoutException -> 0x00d7, Exception -> 0x00cf }
                r9 = "-->httpRequest, statusCode: ";	 Catch:{ ConnectTimeoutException -> 0x00df, SocketTimeoutException -> 0x00d7, Exception -> 0x00cf }
                r8.<init>(r9);	 Catch:{ ConnectTimeoutException -> 0x00df, SocketTimeoutException -> 0x00d7, Exception -> 0x00cf }
                r8.append(r6);	 Catch:{ ConnectTimeoutException -> 0x00df, SocketTimeoutException -> 0x00d7, Exception -> 0x00cf }
                r8 = r8.toString();	 Catch:{ ConnectTimeoutException -> 0x00df, SocketTimeoutException -> 0x00d7, Exception -> 0x00cf }
                com.tencent.open.a.f.b(r7, r8);	 Catch:{ ConnectTimeoutException -> 0x00df, SocketTimeoutException -> 0x00d7, Exception -> 0x00cf }
                r7 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ ConnectTimeoutException -> 0x00df, SocketTimeoutException -> 0x00d7, Exception -> 0x00cf }
                if (r6 == r7) goto L_0x00c0;	 Catch:{ ConnectTimeoutException -> 0x00df, SocketTimeoutException -> 0x00d7, Exception -> 0x00cf }
            L_0x00b8:
                r6 = "openSDK_LOG.ReportManager";	 Catch:{ ConnectTimeoutException -> 0x00df, SocketTimeoutException -> 0x00d7, Exception -> 0x00cf }
                r7 = "-->ReportCenter httpRequest : HttpStatuscode != 200";	 Catch:{ ConnectTimeoutException -> 0x00df, SocketTimeoutException -> 0x00d7, Exception -> 0x00cf }
                com.tencent.open.a.f.b(r6, r7);	 Catch:{ ConnectTimeoutException -> 0x00df, SocketTimeoutException -> 0x00d7, Exception -> 0x00cf }
                goto L_0x00e8;
            L_0x00c0:
                r4 = "openSDK_LOG.ReportManager";	 Catch:{ ConnectTimeoutException -> 0x00cd, SocketTimeoutException -> 0x00cb, Exception -> 0x00c9 }
                r6 = "-->ReportCenter httpRequest Thread success";	 Catch:{ ConnectTimeoutException -> 0x00cd, SocketTimeoutException -> 0x00cb, Exception -> 0x00c9 }
                com.tencent.open.a.f.b(r4, r6);	 Catch:{ ConnectTimeoutException -> 0x00cd, SocketTimeoutException -> 0x00cb, Exception -> 0x00c9 }
                r4 = r5;
                goto L_0x00e8;
            L_0x00c9:
                r4 = r5;
                goto L_0x00cf;
            L_0x00cb:
                r4 = r5;
                goto L_0x00d7;
            L_0x00cd:
                r4 = r5;
                goto L_0x00df;
            L_0x00cf:
                r0 = "openSDK_LOG.ReportManager";	 Catch:{ Exception -> 0x0102 }
                r1 = "-->ReportCenter httpRequest Exception";	 Catch:{ Exception -> 0x0102 }
                com.tencent.open.a.f.b(r0, r1);	 Catch:{ Exception -> 0x0102 }
                goto L_0x00e8;	 Catch:{ Exception -> 0x0102 }
            L_0x00d7:
                r6 = "openSDK_LOG.ReportManager";	 Catch:{ Exception -> 0x0102 }
                r7 = "-->ReportCenter httpRequest SocketTimeoutException";	 Catch:{ Exception -> 0x0102 }
                com.tencent.open.a.f.b(r6, r7);	 Catch:{ Exception -> 0x0102 }
                goto L_0x00e6;	 Catch:{ Exception -> 0x0102 }
            L_0x00df:
                r6 = "openSDK_LOG.ReportManager";	 Catch:{ Exception -> 0x0102 }
                r7 = "-->ReportCenter httpRequest ConnectTimeoutException";	 Catch:{ Exception -> 0x0102 }
                com.tencent.open.a.f.b(r6, r7);	 Catch:{ Exception -> 0x0102 }
            L_0x00e6:
                if (r3 < r0) goto L_0x0093;	 Catch:{ Exception -> 0x0102 }
            L_0x00e8:
                if (r4 != r5) goto L_0x00f2;	 Catch:{ Exception -> 0x0102 }
            L_0x00ea:
                r0 = "openSDK_LOG.ReportManager";	 Catch:{ Exception -> 0x0102 }
                r1 = "-->ReportCenter httpRequest Thread request success";	 Catch:{ Exception -> 0x0102 }
                com.tencent.open.a.f.b(r0, r1);	 Catch:{ Exception -> 0x0102 }
                return;	 Catch:{ Exception -> 0x0102 }
            L_0x00f2:
                r0 = "openSDK_LOG.ReportManager";	 Catch:{ Exception -> 0x0102 }
                r1 = "-->ReportCenter httpRequest Thread request failed";	 Catch:{ Exception -> 0x0102 }
                com.tencent.open.a.f.b(r0, r1);	 Catch:{ Exception -> 0x0102 }
                return;	 Catch:{ Exception -> 0x0102 }
            L_0x00fa:
                r0 = "openSDK_LOG.ReportManager";	 Catch:{ Exception -> 0x0102 }
                r1 = "-->httpRequest unkonw request method return.";	 Catch:{ Exception -> 0x0102 }
                com.tencent.open.a.f.e(r0, r1);	 Catch:{ Exception -> 0x0102 }
                return;
            L_0x0102:
                r0 = "openSDK_LOG.ReportManager";
                r1 = "-->httpRequest, exception in serial executor.";
                com.tencent.open.a.f.b(r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g.6.run():void");
            }
        });
    }
}
