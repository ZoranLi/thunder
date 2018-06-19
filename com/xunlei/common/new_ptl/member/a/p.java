package com.xunlei.common.new_ptl.member.a;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.webkit.WebView;
import com.umeng.message.MsgConstant;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.base.XLPhoneInfo;
import com.xunlei.common.base.permission.XLAndroidPermission;
import com.xunlei.common.base.permission.XLAndroidPermissionListener;
import com.xunlei.common.base.permission.XLAndroidPermissionOptions.Builder;
import com.xunlei.common.device.XLDeviceGen;
import com.xunlei.common.httpclient.AsyncHttpClient;
import com.xunlei.common.httpclient.BaseHttpClient;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLQRCodeAuthHandler;
import com.xunlei.common.new_ptl.member.XLUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.task.aq.UserAqModifyPassWordTask;
import com.xunlei.common.new_ptl.member.task.d.d;
import com.xunlei.common.new_ptl.member.task.d.f;
import com.xunlei.common.new_ptl.member.task.g.b;
import com.xunlei.common.new_ptl.member.task.g.c;
import com.xunlei.common.new_ptl.member.task.h.e;
import com.xunlei.common.new_ptl.member.task.helpertask.UserAqWebViewTask;
import com.xunlei.common.stat.XLStatPack;
import com.xunlei.common.stat.XLStatUtil;
import com.xunlei.common.stat.base.XLStatCommandID;
import com.xunlei.xluagc.XLMessageInterface;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ssl.AbstractVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"UseSparseArrays"})
/* compiled from: XLUserUtilProxy */
public final class p implements i {
    private static int a = 1;
    private static int b = 2;
    private static int c = 3;
    private static int d = 4;
    private static int e = 5;
    private static int f = 6;
    private static int g = 7;
    private static int h = 8;
    private static int i = 9;
    private static int j = 10;
    private static int k = 11;
    private static final p o = new p();
    private Map<WebView, com.xunlei.common.new_ptl.member.task.a> A = new HashMap();
    private Map<Integer, h> B = new HashMap();
    private int C = 0;
    private Context D = null;
    private String E = "1";
    private String F = "ABCDEFGHIJK";
    private String G = "2.7.2.178225";
    private int H = 0;
    private String I = "MEA";
    private int J = 0;
    private g K = null;
    private XLStatUtil L = null;
    private n M = null;
    private b N = null;
    private c O = null;
    private m P = null;
    private long Q = 0;
    private boolean R = true;
    private String S = "none";
    private String T = "none";
    private BroadcastReceiver U = new BroadcastReceiver(this) {
        private /* synthetic */ p a;

        {
            this.a = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            context = intent.getAction();
            StringBuilder stringBuilder = new StringBuilder("recive broadcast action = ");
            stringBuilder.append(context);
            XLLog.v("KEEP_LIVE_ACTION", stringBuilder.toString());
            if (context.equals(this.a.n) == null) {
                return;
            }
            if (this.a.r() == null) {
                XLLog.v("KEEP_LIVE_ACTION", "user is not logined, kill timer and return.");
                this.a.a(false, 0);
                return;
            }
            this.a.c(false);
            if (VERSION.SDK_INT >= 19) {
                this.a.a(true, 0, false);
            }
        }
    };
    private final int l;
    private final int m;
    private String n = "";
    private o p = new o();
    private List<XLOnUserListener> q = new LinkedList();
    private d r = new d(this);
    private a s = a.b();
    private PendingIntent t = null;
    private Handler u = null;
    private BaseHttpClient v = null;
    private boolean w = false;
    private boolean x = false;
    private int y = 300000;
    private Map<Integer, com.xunlei.common.new_ptl.member.task.a> z = new HashMap();

    /* compiled from: XLUserUtilProxy */
    class a extends AbstractVerifier {
        private final X509HostnameVerifier a;
        private final String b;
        private /* synthetic */ p c;

        public a(p pVar, X509HostnameVerifier x509HostnameVerifier) {
            this.c = pVar;
            this.a = x509HostnameVerifier;
        }

        public final void verify(String str, String[] strArr, String[] strArr2) throws SSLException {
            StringBuilder stringBuilder = new StringBuilder("XLNewLoginVerifier host = ");
            stringBuilder.append(str);
            XLLog.v("XLNewLoginVerifier", stringBuilder.toString());
            if (a(strArr, strArr2)) {
                try {
                    this.a.verify(str, strArr, strArr2);
                    return;
                } catch (String[] strArr3) {
                    if (this.c.s.a(str) == null) {
                        throw strArr3;
                    }
                    return;
                }
            }
            throw new SSLException("CA certificate not belong to XunLei!");
        }

        private static boolean a(String[] strArr, String[] strArr2) {
            int i = 0;
            if (strArr != null) {
                int i2 = 0;
                while (i2 < strArr.length) {
                    if (!TextUtils.isEmpty(strArr[i2]) && strArr[i2].contains("xunlei.com")) {
                        strArr = 1;
                        break;
                    }
                    i2++;
                }
                strArr = null;
                if (strArr != null) {
                    return strArr;
                }
            } else {
                strArr = null;
            }
            if (strArr2 == null) {
                return strArr;
            }
            while (i < strArr2.length) {
                if (!TextUtils.isEmpty(strArr2[i]) && strArr2[i].contains("xunlei.com")) {
                    return 1;
                }
                i++;
            }
            return strArr;
        }
    }

    public static String e(int i) {
        return 1 == i ? "/login" : 5 == i ? "/portal" : 7 == i ? "/loginkey" : 2 == i ? "/sessionlogin" : 6 == i ? "/unionlogin" : 3 == i ? "/logout" : 4 == i ? "/getuserinfo" : 9 == i ? "/sendsms" : 10 == i ? "/smslogin" : 11 == i ? "/thirdlogin" : "";
    }

    public static boolean p() {
        return false;
    }

    private p() {
    }

    private void F() {
        new Thread(new Runnable(this) {
            private /* synthetic */ p a;

            {
                this.a = r1;
            }

            public final void run() {
                String t = p.t();
                StringBuilder stringBuilder = new StringBuilder("asynGetDeviceID call device id = ");
                stringBuilder.append(t);
                XLLog.v("XLUserUtilProxy", stringBuilder.toString());
            }
        }).start();
    }

    public static p a() {
        return o;
    }

    public final boolean a(android.content.Context r9, int r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, boolean r14) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r8.w;
        r1 = 1;
        r2 = 0;
        if (r0 != r1) goto L_0x0007;
    L_0x0006:
        return r2;
    L_0x0007:
        r0 = android.os.Looper.myLooper();
        if (r0 == 0) goto L_0x01a6;
    L_0x000d:
        r0 = "UserUtil";
        r3 = new java.lang.StringBuilder;
        r4 = "init threadid = ";
        r3.<init>(r4);
        r4 = java.lang.Thread.currentThread();
        r4 = r4.getId();
        r3.append(r4);
        r4 = "# main threadid = ";
        r3.append(r4);
        r4 = android.os.Looper.getMainLooper();
        r4 = r4.getThread();
        r4 = r4.getId();
        r3.append(r4);
        r3 = r3.toString();
        com.xunlei.common.base.XLLog.i(r0, r3);
        r8.w = r1;
        r8.R = r14;
        r8.C = r10;
        r8.E = r11;
        r8.F = r12;
        r8.D = r9;
        r11 = new com.xunlei.common.new_ptl.member.a.p$4;
        r12 = android.os.Looper.getMainLooper();
        r11.<init>(r8, r12);
        r8.u = r11;
        r11 = org.apache.http.conn.ssl.SSLSocketFactory.class;	 Catch:{ Exception -> 0x0067 }
        r12 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0067 }
        r11 = r11.getDeclaredConstructor(r12);	 Catch:{ Exception -> 0x0067 }
        r11.setAccessible(r1);	 Catch:{ Exception -> 0x0067 }
        r12 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0067 }
        r11 = r11.newInstance(r12);	 Catch:{ Exception -> 0x0067 }
        r11 = (org.apache.http.conn.ssl.SSLSocketFactory) r11;	 Catch:{ Exception -> 0x0067 }
        goto L_0x006b;
    L_0x0067:
        r11 = org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory();
    L_0x006b:
        r12 = new com.xunlei.common.new_ptl.member.a.p$a;
        r14 = r11.getHostnameVerifier();
        r12.<init>(r8, r14);
        r11.setHostnameVerifier(r12);
        r12 = r8.l();
        r12.setSSLSocketFactory(r11);
        r11 = com.xunlei.common.device.XLDeviceGen.getInstance();	 Catch:{ XLDeviceExecption -> 0x008a }
        r12 = r8.C;	 Catch:{ XLDeviceExecption -> 0x008a }
        r14 = r8.G;	 Catch:{ XLDeviceExecption -> 0x008a }
        r11.initialize(r12, r13, r14, r9);	 Catch:{ XLDeviceExecption -> 0x008a }
        goto L_0x00a5;
    L_0x008a:
        r11 = move-exception;
        r11.printStackTrace();
        r12 = "UserUtilProxy";
        r13 = new java.lang.StringBuilder;
        r14 = "XLDeviceGen initialize error = ";
        r13.<init>(r14);
        r11 = r11.getMessage();
        r13.append(r11);
        r11 = r13.toString();
        com.xunlei.common.base.XLLog.v(r12, r11);
    L_0x00a5:
        r11 = r8.R;
        if (r11 == 0) goto L_0x00cb;
    L_0x00a9:
        r11 = r8.D;
        r11 = com.xunlei.common.base.permission.XLAndroidPermission.getInstance(r11);
        r12 = new com.xunlei.common.base.permission.XLAndroidPermissionOptions$Builder;
        r12.<init>();
        r13 = new java.lang.String[r1];
        r14 = "android.permission.READ_PHONE_STATE";
        r13[r2] = r14;
        r12 = r12.setPermissions(r13);
        r12 = r12.build();
        r13 = new com.xunlei.common.new_ptl.member.a.p$2;
        r13.<init>(r8);
        r11.request(r12, r13);
        goto L_0x00ce;
    L_0x00cb:
        r8.F();
    L_0x00ce:
        r11 = r8.s;
        r11.a(r9);
        r11 = new android.content.IntentFilter;
        r11.<init>();
        r12 = new java.lang.StringBuilder;
        r13 = "com.xunlei.acc.sdk.vip.keepLiveTimerAlarm.";
        r12.<init>(r13);
        r10 = java.lang.String.valueOf(r10);
        r12.append(r10);
        r10 = ".";
        r12.append(r10);
        r13 = java.lang.System.currentTimeMillis();
        r12.append(r13);
        r10 = r12.toString();
        r8.n = r10;
        r10 = "XLUserUtil";
        r12 = new java.lang.StringBuilder;
        r13 = "mKeepAliveAction = ";
        r12.<init>(r13);
        r13 = r8.n;
        r12.append(r13);
        r12 = r12.toString();
        com.xunlei.common.base.XLLog.v(r10, r12);
        r10 = new android.content.Intent;
        r12 = r8.n;
        r10.<init>(r12);
        r12 = r8.D;
        r13 = 134217728; // 0x8000000 float:3.85186E-34 double:6.63123685E-316;
        r10 = android.app.PendingIntent.getBroadcast(r12, r2, r10, r13);
        r8.t = r10;
        r10 = "TEST";
        r12 = new java.lang.StringBuilder;
        r13 = "Init threadid = ";
        r12.<init>(r13);
        r13 = java.lang.Thread.currentThread();
        r13 = r13.getId();
        r13 = java.lang.String.valueOf(r13);
        r12.append(r13);
        r13 = " mpendingKeepLiveIntent:";
        r12.append(r13);
        r13 = r8.t;
        r13 = r13.toString();
        r13 = java.lang.String.valueOf(r13);
        r12.append(r13);
        r12 = r12.toString();
        com.xunlei.common.base.XLLog.i(r10, r12);
        r10 = r8.n;
        r11.addAction(r10);
        r10 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r11.setPriority(r10);
        r10 = r8.D;
        r12 = r8.U;
        r10.registerReceiver(r12, r11);
        r10 = com.xunlei.common.stat.XLStatUtil.getInstance();
        r8.L = r10;
        r2 = r8.L;
        r4 = r8.C;
        r5 = r8.E;
        r6 = r8.G;
        r7 = r8.F;
        r3 = r9;
        r2.init(r3, r4, r5, r6, r7);
        r9 = r8.L;
        r10 = 203; // 0xcb float:2.84E-43 double:1.003E-321;
        r9.setLoginProtocolVersion(r10);
        r9 = new com.xunlei.common.new_ptl.member.a.n;
        r10 = r8.L;
        r9.<init>(r10);
        r8.M = r9;
        r9 = r8.M;
        r8.a(r9);
        r9 = new com.xunlei.common.new_ptl.member.a.g;
        r10 = r8.D;
        r9.<init>(r8, r10);
        r8.K = r9;
        r9 = r8.K;
        r9.d();
        r9 = r8.H();
        r8.H = r9;
        r9 = r8.p;
        r10 = r8.D;
        r9.b(r10);
        return r1;
    L_0x01a6:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.member.a.p.a(android.content.Context, int, java.lang.String, java.lang.String, java.lang.String, boolean):boolean");
    }

    public final boolean b() {
        if (this.x) {
            return false;
        }
        b(this.M);
        XLLog.i("UserUtil", "uinit");
        this.x = true;
        this.s.a();
        if (this.D != null) {
            this.D.unregisterReceiver(this.U);
        }
        this.t.cancel();
        a(false, 0, true);
        this.L.uninit();
        this.K.e();
        return true;
    }

    public final String c() {
        return this.G;
    }

    public final int d() {
        return this.C;
    }

    public final String e() {
        return this.E;
    }

    public final int f() {
        return this.H;
    }

    public final String g() {
        return this.F;
    }

    public final Context h() {
        return this.D;
    }

    private boolean G() {
        return this.R;
    }

    public final XLUserInfo i() {
        return this.p;
    }

    public final void j() {
        this.L.clearStatItems();
    }

    public final a k() {
        return this.s;
    }

    public final void a(BaseHttpClient baseHttpClient) {
        this.v = baseHttpClient;
    }

    public final BaseHttpClient l() {
        if (this.v == null) {
            this.v = new AsyncHttpClient(this.G);
        }
        return this.v;
    }

    public final String m() {
        return this.D.getApplicationInfo().packageName;
    }

    public final com.xunlei.common.new_ptl.member.task.a a(int i) {
        return (com.xunlei.common.new_ptl.member.task.a) this.z.get(Integer.valueOf(i));
    }

    public final Handler n() {
        return this.u;
    }

    public final synchronized void a(XLOnUserListener xLOnUserListener) {
        this.q.add(xLOnUserListener);
    }

    public final synchronized void b(XLOnUserListener xLOnUserListener) {
        this.q.remove(xLOnUserListener);
    }

    private void a(com.xunlei.common.new_ptl.member.task.a aVar) {
        b(aVar);
    }

    private void a(boolean z, int i, boolean z2) {
        AlarmManager alarmManager = (AlarmManager) this.D.getSystemService(NotificationCompat.CATEGORY_ALARM);
        alarmManager.cancel(this.t);
        if (!z) {
            z2 = new StringBuilder("stop keepalive timer period = ");
            z2.append(i);
            z2.append(" process = ");
            z2.append(Process.myPid());
            XLLog.v("XLUserUtil", z2.toString());
        } else if (this.p.d()) {
            StringBuilder stringBuilder = new StringBuilder("start keepalive timer period = ");
            stringBuilder.append(i);
            stringBuilder.append(" process = ");
            stringBuilder.append(Process.myPid());
            XLLog.v("XLUserUtil", stringBuilder.toString());
            if (i > 0) {
                this.y = i;
            }
            if (VERSION.SDK_INT < true) {
                alarmManager.setRepeating(0, System.currentTimeMillis() + ((long) this.y), (long) this.y, this.t);
            } else {
                alarmManager.setExact(false, System.currentTimeMillis() + ((long) this.y), this.t);
            }
            if (z2) {
                c(true);
            }
        } else {
            XLLog.v("XLUserUtil", "user is not login, do not start timer and return");
        }
    }

    public final void a(boolean z, int i) {
        a(z, i, true);
    }

    public final void o() {
        if ((System.currentTimeMillis() - this.D.getSharedPreferences("xl-acc-portal-cache", 0).getLong("PrePortalTime", 0)) - 432000000 >= 0) {
            com.xunlei.common.new_ptl.member.task.a aVar = new com.xunlei.common.new_ptl.member.task.f.a(this);
            aVar.a();
            b(aVar);
        }
    }

    public final int a(String str, String str2, String str3, String str4, XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a bVar = new com.xunlei.common.new_ptl.member.task.d.b(this);
        bVar.a();
        bVar.a(str);
        bVar.b(str2);
        bVar.a(obj);
        bVar.a(str3, str4);
        bVar.a(xLOnUserListener);
        this.z.put(Integer.valueOf(bVar.g()), bVar);
        this.L.registerStatReq(bVar.g(), XLStatCommandID.XLCID_ACC_LOGIN);
        return b(bVar);
    }

    public final int a(XLOnUserListener xLOnUserListener, Object obj) {
        return a(false, xLOnUserListener, obj);
    }

    public final int a(int i, Object obj, XLOnUserListener xLOnUserListener, Object obj2) {
        com.xunlei.common.new_ptl.member.task.a cVar;
        if (i == 1) {
            cVar = new com.xunlei.common.new_ptl.member.task.h.c(this);
            cVar.a();
            cVar.b(obj);
            cVar.a(obj2);
            cVar.a(xLOnUserListener);
            obj = b(cVar);
            this.z.put(Integer.valueOf(obj), cVar);
            this.L.registerStatReq(obj);
            return obj;
        } else if (i == 8) {
            cVar = new e(this);
            cVar.a();
            cVar.b(obj);
            cVar.a(obj2);
            cVar.a(xLOnUserListener);
            obj = b(cVar);
            this.z.put(Integer.valueOf(obj), cVar);
            this.L.registerStatReq(obj);
            return obj;
        } else if (i == 21) {
            cVar = new com.xunlei.common.new_ptl.member.task.h.d(this);
            cVar.a();
            cVar.b(obj);
            cVar.a(obj2);
            cVar.a(xLOnUserListener);
            obj = b(cVar);
            this.z.put(Integer.valueOf(obj), cVar);
            this.L.registerStatReq(obj);
            return obj;
        } else {
            int i2;
            if (i == 4) {
                com.xunlei.common.new_ptl.member.task.a aVar = new com.xunlei.common.new_ptl.member.task.h.a(this);
                aVar.a();
                aVar.b(obj);
                aVar.a(obj2);
                aVar.a(xLOnUserListener);
                int b = b(aVar);
                this.z.put(Integer.valueOf(b), aVar);
                this.L.registerStatReq(b);
                i2 = b;
            } else {
                i2 = 0;
            }
            if (i != 15) {
                return i2;
            }
            cVar = new com.xunlei.common.new_ptl.member.task.h.b(this);
            cVar.a();
            cVar.b(obj);
            cVar.a(obj2);
            cVar.a(xLOnUserListener);
            obj = b(cVar);
            this.z.put(Integer.valueOf(obj), cVar);
            this.L.registerStatReq(obj);
            return obj;
        }
    }

    public final int a(long j, String str, int i, int i2, XLOnUserListener xLOnUserListener, Object obj) {
        return a(j, str, i, i2, xLOnUserListener, obj, false);
    }

    public final int a(long j, String str, int i, int i2, XLOnUserListener xLOnUserListener, Object obj, boolean z) {
        com.xunlei.common.new_ptl.member.task.a eVar = new com.xunlei.common.new_ptl.member.task.d.e(this);
        eVar.a();
        eVar.a(j, str, i, i2);
        eVar.a(obj);
        eVar.a(xLOnUserListener);
        if (z) {
            eVar.a((boolean) 0);
        } else {
            this.L.registerStatReq(eVar.g());
        }
        return b(eVar);
    }

    private int b(String str, String str2, String str3, String str4, XLOnUserListener xLOnUserListener, Object obj) {
        return a(str, str2, str3, str4, xLOnUserListener, obj, false);
    }

    public final int a(String str, String str2, String str3, String str4, XLOnUserListener xLOnUserListener, Object obj, boolean z) {
        com.xunlei.common.new_ptl.member.task.a fVar = new f(this);
        fVar.a();
        fVar.a(str, str2, str3, str4);
        fVar.a(obj);
        fVar.a(xLOnUserListener);
        if (z) {
            fVar.a((boolean) null);
        } else {
            this.L.registerStatReq(fVar.g());
        }
        return b(fVar);
    }

    public final int a(String str, String str2, String str3, XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a aVar = new com.xunlei.common.new_ptl.member.task.e.a(this);
        aVar.a();
        aVar.a(str, str2, str3);
        aVar.f(null);
        aVar.a(obj);
        aVar.a(xLOnUserListener);
        return b(aVar);
    }

    public final int a(String str, String str2, String str3, String str4, boolean z, XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a aVar = new com.xunlei.common.new_ptl.member.task.e.a(this);
        aVar.a();
        aVar.a(str, str2, str3);
        aVar.f(1);
        aVar.a(str4, z);
        aVar.a(obj);
        aVar.a(xLOnUserListener);
        return b(aVar);
    }

    public final int a(String str, int i, String str2, String str3, XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a bVar = new com.xunlei.common.new_ptl.member.task.e.b(this);
        bVar.a();
        bVar.a(str2, str3);
        bVar.a(str);
        bVar.f(i);
        bVar.a(obj);
        bVar.a(xLOnUserListener);
        return b(bVar);
    }

    public final int a(String str, String str2, XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a aVar = new com.xunlei.common.new_ptl.member.task.j.a(this);
        aVar.a();
        aVar.a(str, str2);
        aVar.a(obj);
        aVar.a(xLOnUserListener);
        this.L.registerStatReq(aVar.g());
        return b(aVar);
    }

    public final int b(String str, String str2, XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a cVar = new com.xunlei.common.new_ptl.member.task.j.c(this);
        cVar.a();
        cVar.a(str, str2);
        cVar.a(obj);
        cVar.a(xLOnUserListener);
        this.L.registerStatReq(cVar.g());
        return b(cVar);
    }

    public final int a(XLOnUserListener xLOnUserListener, Object obj, int... iArr) {
        return a(xLOnUserListener, false, obj, iArr);
    }

    public final int a(XLOnUserListener xLOnUserListener, boolean z, Object obj, int... iArr) {
        com.xunlei.common.new_ptl.member.task.a eVar = new com.xunlei.common.new_ptl.member.task.i.e(this);
        eVar.a();
        eVar.a(obj);
        eVar.a(iArr);
        eVar.a(xLOnUserListener);
        if (z) {
            eVar.a((boolean) null);
        } else {
            this.L.registerStatReq(eVar.g());
        }
        this.L.registerStatReq(eVar.g());
        return b(eVar);
    }

    public final int a(JSONObject jSONObject, String str, String str2, XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a fVar = new com.xunlei.common.new_ptl.member.task.i.f(this);
        fVar.a();
        fVar.a(obj);
        fVar.a(xLOnUserListener);
        fVar.a(jSONObject, str, str2);
        return b(fVar);
    }

    public final int b(XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a bVar = new com.xunlei.common.new_ptl.member.task.i.b(this);
        bVar.a();
        bVar.a(obj);
        bVar.a(xLOnUserListener);
        return b(bVar);
    }

    public final int c(XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a aVar = new com.xunlei.common.new_ptl.member.task.i.a(this);
        aVar.a();
        aVar.a(obj);
        aVar.a(xLOnUserListener);
        return b(aVar);
    }

    public final int d(XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a cVar = new com.xunlei.common.new_ptl.member.task.i.c(this);
        cVar.a();
        cVar.a(obj);
        cVar.a(xLOnUserListener);
        return b(cVar);
    }

    public final int e(XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a dVar = new com.xunlei.common.new_ptl.member.task.i.d(this);
        dVar.a();
        dVar.a(obj);
        dVar.a(xLOnUserListener);
        return b(dVar);
    }

    public final int f(XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a cVar = new com.xunlei.common.new_ptl.member.task.d.c(this);
        cVar.a();
        cVar.a(obj);
        cVar.a(xLOnUserListener);
        this.L.registerStatReq(cVar.g());
        return b(cVar);
    }

    public final int g(XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a bVar = new com.xunlei.common.new_ptl.member.task.j.b(this);
        bVar.a();
        bVar.a(obj);
        bVar.a(xLOnUserListener);
        this.L.registerStatReq(bVar.g());
        return b(bVar);
    }

    public final int h(XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a aVar = new com.xunlei.common.new_ptl.member.task.a.a(this);
        aVar.a();
        aVar.a(obj);
        aVar.a(xLOnUserListener);
        this.L.registerStatReq(aVar.g());
        return b(aVar);
    }

    public final int a(int i, XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a bVar = new com.xunlei.common.new_ptl.member.task.a.b(this);
        bVar.a();
        bVar.a(obj);
        bVar.f(i);
        bVar.a(xLOnUserListener);
        this.L.registerStatReq(bVar.g());
        return b(bVar);
    }

    public final int a(Bitmap bitmap, XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a cVar = new com.xunlei.common.new_ptl.member.task.a.c(this);
        cVar.a();
        cVar.a(obj);
        cVar.a(bitmap);
        cVar.a(xLOnUserListener);
        this.L.registerStatReq(cVar.g());
        return b(cVar);
    }

    public final boolean q() {
        return this.p.getLongValue(USERINFOKEY.UserID) != 0;
    }

    public final boolean r() {
        return this.p.d();
    }

    public static boolean a(String str) {
        return (TextUtils.isEmpty(str) || str.indexOf("xunlei.com/remote_login") == -1) ? null : true;
    }

    public final int a(String str, XLQRCodeAuthHandler xLQRCodeAuthHandler, XLOnUserListener xLOnUserListener, Object obj) {
        if (xLQRCodeAuthHandler == null) {
            return null;
        }
        if (this.N != null) {
            this.N.m();
        }
        com.xunlei.common.new_ptl.member.task.a bVar = new b(this);
        bVar.a();
        bVar.a(obj);
        bVar.a(xLQRCodeAuthHandler, str);
        bVar.a(xLOnUserListener);
        this.z.put(Integer.valueOf(bVar.g()), bVar);
        this.N = bVar;
        return b(bVar);
    }

    public final int b(int i, XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a aVar = new com.xunlei.common.new_ptl.member.task.g.a(this);
        aVar.a();
        aVar.a(obj);
        aVar.f(i);
        aVar.a(xLOnUserListener);
        return b(aVar);
    }

    public final int a(String str, int i, XLOnUserListener xLOnUserListener, Object obj) {
        if (this.O != null) {
            this.O.m();
        }
        com.xunlei.common.new_ptl.member.task.a cVar = new c(this);
        cVar.a();
        cVar.a(obj);
        cVar.a(str, i);
        cVar.a(xLOnUserListener);
        this.O = cVar;
        return b(cVar);
    }

    public final int i(XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a bVar = new com.xunlei.common.new_ptl.member.task.b.b(this);
        bVar.a();
        bVar.a(obj);
        bVar.a(xLOnUserListener);
        return b(bVar);
    }

    public final int a(int i, String str, String str2, XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a aVar = new com.xunlei.common.new_ptl.member.task.b.a(this);
        aVar.a();
        aVar.a(obj);
        aVar.a(xLOnUserListener);
        aVar.b(i, str, str2);
        this.z.put(Integer.valueOf(aVar.g()), aVar);
        return b(aVar);
    }

    public final int a(int i, String str, Object obj, XLOnUserListener xLOnUserListener, Object obj2) {
        com.xunlei.common.new_ptl.member.task.a cVar = new com.xunlei.common.new_ptl.member.task.b.c(this);
        cVar.a();
        cVar.a(obj2);
        cVar.a(xLOnUserListener);
        cVar.a(i, str, obj);
        this.z.put(Integer.valueOf(cVar.g()), cVar);
        return b(cVar);
    }

    public final int c(int i, XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a dVar = new com.xunlei.common.new_ptl.member.task.b.d(this);
        dVar.a();
        dVar.a(obj);
        dVar.a(xLOnUserListener);
        dVar.f(i);
        return b(dVar);
    }

    public final int a(String str, XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a dVar = new com.xunlei.common.new_ptl.member.task.aq.d(this);
        dVar.a();
        dVar.a(obj);
        dVar.a(xLOnUserListener);
        dVar.a(str);
        return b(dVar);
    }

    public final int c(String str, String str2, XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a aVar = new com.xunlei.common.new_ptl.member.task.aq.a(this);
        aVar.a();
        aVar.a(obj);
        aVar.a(xLOnUserListener);
        aVar.a(str, str2);
        return b(aVar);
    }

    public final int a(WebView webView, XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a userAqModifyPassWordTask = new UserAqModifyPassWordTask(this);
        userAqModifyPassWordTask.a();
        userAqModifyPassWordTask.a(webView);
        userAqModifyPassWordTask.a(obj);
        userAqModifyPassWordTask.a(xLOnUserListener);
        this.A.put(webView, userAqModifyPassWordTask);
        return b(userAqModifyPassWordTask);
    }

    public final int b(WebView webView, XLOnUserListener xLOnUserListener, Object obj) {
        com.xunlei.common.new_ptl.member.task.a bVar = new com.xunlei.common.new_ptl.member.task.aq.b(this);
        bVar.a();
        bVar.a(webView);
        bVar.a(obj);
        bVar.a(xLOnUserListener);
        this.A.put(webView, bVar);
        this.L.registerStatReq(bVar.g());
        return b(bVar);
    }

    public final void a(WebView webView) {
        if (!this.A.isEmpty() && webView != null) {
            com.xunlei.common.new_ptl.member.task.a aVar = (com.xunlei.common.new_ptl.member.task.a) this.A.remove(webView);
            if (aVar != null && (aVar instanceof UserAqWebViewTask)) {
                ((UserAqWebViewTask) aVar).p();
            }
        }
    }

    public final int a(XLMessageInterface xLMessageInterface) {
        com.xunlei.common.new_ptl.member.task.c.b.a(xLMessageInterface, this);
        return null;
    }

    public static int s() {
        com.xunlei.common.new_ptl.member.task.c.b.a();
        return 0;
    }

    private int b(com.xunlei.common.new_ptl.member.task.a aVar) {
        if (Looper.myLooper() == null) {
            a(a(10, (Object) aVar));
        } else {
            aVar.h();
        }
        return aVar.g();
    }

    private void b(com.xunlei.common.new_ptl.member.task.a aVar, Bundle bundle) {
        a(a(11, new Object[]{aVar, bundle}));
    }

    public final void c(boolean z) {
        if (z) {
            this.r.a();
        }
        this.r.h();
    }

    public final XLStatUtil u() {
        return this.L;
    }

    private int H() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.G;
        r1 = ".";
        r0 = r0.lastIndexOf(r1);
        r1 = -1;
        if (r0 == r1) goto L_0x001c;
    L_0x000b:
        r1 = r2.G;
        r0 = r0 + 1;
        r0 = r1.substring(r0);
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ NumberFormatException -> 0x001c }
        r0 = r0.intValue();	 Catch:{ NumberFormatException -> 0x001c }
        goto L_0x001d;
    L_0x001c:
        r0 = 0;
    L_0x001d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.member.a.p.H():int");
    }

    private Message a(int i, Object obj) {
        if (this.u != null) {
            return this.u.obtainMessage(i, obj);
        }
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.obj = obj;
        return obtain;
    }

    private void a(Message message) {
        if (this.u != null) {
            this.u.sendMessage(message);
        } else {
            b(message);
        }
    }

    private void b(Message message) {
        switch (message.what) {
            case 10:
                ((com.xunlei.common.new_ptl.member.task.a) message.obj).h();
                return;
            case 11:
                Object[] objArr = (Object[]) message.obj;
                for (int i = 0; i < this.q.size(); i++) {
                    ((com.xunlei.common.new_ptl.member.task.a) objArr[0]).a((XLOnUserListener) this.q.get(i), (Bundle) objArr[1]);
                }
                break;
            default:
                break;
        }
    }

    public final void b(int i) {
        this.z.remove(Integer.valueOf(i));
    }

    public final void b(String str) {
        this.P = new m(str);
    }

    public final m w() {
        return this.P;
    }

    public final long x() {
        return this.Q;
    }

    public final void a(long j) {
        if (j == 0) {
            XLLog.v("XLUserUtilProxy", " use client timestamp setServerTimeStamp");
            j = System.currentTimeMillis() / 1000;
        }
        this.Q = j;
        StringBuilder stringBuilder = new StringBuilder("use server timestamp setServerTimeStamp:");
        stringBuilder.append(j);
        XLLog.v("XLUserUtilProxy", stringBuilder.toString());
    }

    public final void a(int i, h hVar) {
        this.B.put(Integer.valueOf(i), hVar);
    }

    private void f(int i) {
        this.B.remove(Integer.valueOf(i));
    }

    public final h c(int i) {
        return (h) this.B.get(Integer.valueOf(i));
    }

    public final void c(XLOnUserListener xLOnUserListener) {
        this.r.a(xLOnUserListener);
    }

    public final String y() {
        return this.I;
    }

    public final void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.I = str;
        }
    }

    public final void d(int i) {
        this.J = 1;
    }

    public final int z() {
        return this.J;
    }

    public final void A() {
        this.N = null;
    }

    public final void B() {
        this.O = null;
    }

    public final void a(XLStatPack xLStatPack) {
        if (xLStatPack != null) {
            this.L.report(xLStatPack);
        }
    }

    private String I() {
        String str = "NONE";
        switch (XLPhoneInfo.getNetworkType(this.D)) {
            case 0:
                return "NONE";
            case 1:
                return "WIFI";
            case 2:
                return "2G";
            case 3:
                return "3G";
            case 4:
                return "4G";
            case 5:
                return "2G";
            default:
                return str;
        }
    }

    private String J() {
        int providersName = XLPhoneInfo.getProvidersName(this.D);
        String str = "NONE";
        if (providersName == 0) {
            return "CMCC";
        }
        switch (providersName) {
            case 2:
                return "CUCC";
            case 3:
                return "CTC";
            case 4:
                return "OTHER";
            case 5:
                return "NONE";
            default:
                return str;
        }
    }

    public final void a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("onNetWorkChange state = ");
        stringBuilder.append(z);
        XLLog.v("XLUserUtil", stringBuilder.toString());
        if (!this.p.d()) {
            XLLog.v("XLUserUtil", "onNetWorkChange user is not online, go back!");
        } else if (z) {
            this.u.postDelayed(new Runnable(this) {
                private /* synthetic */ p a;

                {
                    this.a = r1;
                }

                public final void run() {
                    if (this.a.r()) {
                        this.a.c(false);
                    }
                }
            }, 10);
            this.s.c();
        } else {
            c(false);
        }
    }

    private void K() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = org.apache.http.conn.ssl.SSLSocketFactory.class;	 Catch:{ Exception -> 0x0016 }
        r1 = 0;	 Catch:{ Exception -> 0x0016 }
        r2 = new java.lang.Class[r1];	 Catch:{ Exception -> 0x0016 }
        r0 = r0.getDeclaredConstructor(r2);	 Catch:{ Exception -> 0x0016 }
        r2 = 1;	 Catch:{ Exception -> 0x0016 }
        r0.setAccessible(r2);	 Catch:{ Exception -> 0x0016 }
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0016 }
        r0 = r0.newInstance(r1);	 Catch:{ Exception -> 0x0016 }
        r0 = (org.apache.http.conn.ssl.SSLSocketFactory) r0;	 Catch:{ Exception -> 0x0016 }
        goto L_0x001a;
    L_0x0016:
        r0 = org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory();
    L_0x001a:
        r1 = new com.xunlei.common.new_ptl.member.a.p$a;
        r2 = r0.getHostnameVerifier();
        r1.<init>(r3, r2);
        r0.setHostnameVerifier(r1);
        r1 = r3.l();
        r1.setSSLSocketFactory(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.member.a.p.K():void");
    }

    public final void a(int i, JSONArray jSONArray) {
        XLLog.v("XLUserUtilProxy", "notifyUpdateUserVip errorCode = 0");
        for (int i2 = 0; i2 < this.q.size(); i2++) {
            XLOnUserListener xLOnUserListener = (XLOnUserListener) this.q.get(i2);
            if (xLOnUserListener != null) {
                StringBuilder stringBuilder = new StringBuilder("notify to listener = ");
                stringBuilder.append(xLOnUserListener.toString());
                XLLog.v("XLUserUtilProxy", stringBuilder.toString());
                xLOnUserListener.onUserRecvChannelMessage(0, jSONArray);
            }
        }
    }

    public final void d(String str) {
        this.r.a(str);
    }

    private void E() {
        if (this.R) {
            XLAndroidPermission.getInstance(this.D).request(new Builder().setPermissions(MsgConstant.PERMISSION_READ_PHONE_STATE).build(), new XLAndroidPermissionListener(this) {
                private /* synthetic */ p a;

                {
                    this.a = r1;
                }

                public final void onGranted() {
                    XLLog.v("XLUserUtilProxy", "user grant READ_PHONE_STATE permission!");
                    this.a.F();
                }

                public final void onDenied(List<String> list) {
                    XLLog.v("XLUserUtilProxy", "user deny READ_PHONE_STATE permission!");
                    this.a.F();
                }
            });
            return;
        }
        F();
    }

    public final void b(boolean z) {
        d.a(this.D, com.xunlei.common.new_ptl.member.a.d.a.b);
        if (z) {
            o.p.clearUserData();
        }
    }

    public final void a(final com.xunlei.common.new_ptl.member.task.a aVar, final Bundle bundle) {
        this.u.post(new Runnable(this) {
            private /* synthetic */ p c;

            public final void run() {
                aVar.a(bundle);
                if (aVar.b()) {
                    StringBuilder stringBuilder = new StringBuilder("notify to global listener task = ");
                    stringBuilder.append(aVar.g());
                    XLLog.v("XLUserUtil", stringBuilder.toString());
                    this.c.a(this.c.a(11, new Object[]{aVar, bundle}));
                }
            }
        });
    }

    public final int a(boolean z, XLOnUserListener xLOnUserListener, Object obj) {
        if (this.p.d()) {
            XLLog.v("userAutoLogin", "user is online, execute ping command!");
            c(false);
            return 0;
        }
        XLLog.v("userAutoLogin", "user is not online, execute auto login command!");
        d a = d.a(this.D);
        if (a == null || TextUtils.isEmpty(a.b)) {
            return 0;
        }
        com.xunlei.common.new_ptl.member.task.a aVar = new com.xunlei.common.new_ptl.member.task.d.a(this);
        aVar.a();
        aVar.a(xLOnUserListener);
        aVar.a(obj);
        if (z) {
            aVar.a(false);
        }
        aVar.a(String.valueOf(a.a), "", a.b);
        this.L.registerStatReq(aVar.g(), XLStatCommandID.XLCID_KEY_LOGIN);
        return b(aVar);
    }

    public static String t() {
        return XLDeviceGen.getInstance().getDeviceId();
    }

    public static String v() {
        return XLDeviceGen.getInstance().getDeviceIdSign();
    }

    public static void a(int i, String str, int i2) {
        i2 = o.a(i2);
        if (i2 != 0) {
            i2.a(i, str);
        }
    }

    public final String C() {
        String str = "NONE";
        switch (XLPhoneInfo.getNetworkType(this.D)) {
            case 0:
                str = "NONE";
                break;
            case 1:
                str = "WIFI";
                break;
            case 2:
                str = "2G";
                break;
            case 3:
                str = "3G";
                break;
            case 4:
                str = "4G";
                break;
            case 5:
                str = "2G";
                break;
            default:
                break;
        }
        this.S = str;
        return this.S;
    }

    public final String D() {
        int providersName = XLPhoneInfo.getProvidersName(this.D);
        String str = "NONE";
        if (providersName != 0) {
            switch (providersName) {
                case 2:
                    str = "CUCC";
                    break;
                case 3:
                    str = "CTC";
                    break;
                case 4:
                    str = "OTHER";
                    break;
                case 5:
                    str = "NONE";
                    break;
                default:
                    break;
            }
        }
        str = "CMCC";
        this.T = str;
        return this.T;
    }
}
