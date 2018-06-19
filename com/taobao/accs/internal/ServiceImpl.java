package com.taobao.accs.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.igexin.sdk.PushConsts;
import com.taobao.accs.b.a;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.statistics.c;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.b;
import com.taobao.accs.utl.f;
import com.taobao.accs.utl.i;
import java.util.Map.Entry;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.android.agoo.common.Config;
import org.android.agoo.service.IMessageService.Stub;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
public class ServiceImpl extends b {
    private static a f;
    private Service b = null;
    private Context c;
    private long d;
    private long e;
    private String g = "unknown";
    private ScheduledThreadPoolExecutor h;
    private final Stub i = new Stub() {
        public boolean ping() throws RemoteException {
            return true;
        }

        public void probe() throws RemoteException {
            ALog.d("ServiceImpl", "ReceiverImpl probeTaoBao begin......messageServiceBinder [probe]", new Object[0]);
            ServiceImpl.this.h.execute(new i(this));
        }
    };

    static /* synthetic */ void d() {
    }

    public boolean onUnbind(Intent intent) {
        return false;
    }

    public ServiceImpl(Service service) {
        super(service);
        this.b = service;
        this.c = service.getApplicationContext();
    }

    public void onCreate() {
        super.onCreate();
        GlobalClientInfo.getInstance(this.c);
        com.taobao.accs.client.a.g.incrementAndGet();
        this.d = System.currentTimeMillis();
        this.e = this.d;
        this.g = UtilityImpl.getNetworkTypeExt(this.c);
        this.h = new ScheduledThreadPoolExecutor(2);
        if (Config.f(this.c)) {
            a.c(this.c);
            a a = a.a(this.c, 600, false);
            f = a;
            if (a != null) {
                f.a();
            }
        }
        try {
            this.h.execute(new h(this));
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("serviceImpl init task fail:");
            stringBuilder.append(th.toString());
            ALog.e("ServiceImpl", stringBuilder.toString(), new Object[0]);
        }
        if (ALog.isPrintLog(Level.I)) {
            ALog.i("ServiceImpl", "ServiceImpl onCreate", new Object[]{"ClassLoader", ServiceImpl.class.getClassLoader().toString(), "sdkv", Integer.valueOf(221), "procStart", Integer.valueOf(com.taobao.accs.client.a.g.intValue())});
        }
    }

    public int a(Intent intent) {
        int c;
        if (UtilityImpl.getServiceEnabled(this.c)) {
            if (ALog.isPrintLog(Level.I)) {
                StringBuilder stringBuilder = new StringBuilder("onHostStartCommand:");
                stringBuilder.append(intent);
                ALog.i("ServiceImpl", stringBuilder.toString(), new Object[0]);
            }
            try {
                String str;
                if (ALog.isPrintLog(Level.D) && intent != null) {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        for (String str2 : extras.keySet()) {
                            ALog.d("ServiceImpl", "key", new Object[]{str2, " value", extras.get(str2)});
                        }
                    }
                }
                c = f.c();
                if (c > 3) {
                    try {
                        ALog.e("ServiceImpl", "load SO fail 4 times, don't auto restart", new Object[0]);
                        b.a("accs", BaseMonitor.COUNT_POINT_SOFAIL, UtilityImpl.int2String(c), 0.0d);
                        c = 2;
                    } catch (Throwable th) {
                        intent = th;
                        c = 2;
                        try {
                            ALog.e("ServiceImpl", "onHostStartCommand", intent, new Object[0]);
                            intent.printStackTrace();
                            com.taobao.accs.client.a.g.incrementAndGet();
                            return c;
                        } catch (Throwable th2) {
                            com.taobao.accs.client.a.g.incrementAndGet();
                        }
                    }
                } else {
                    c = 1;
                }
                if (intent == null) {
                    str = null;
                } else {
                    try {
                        str = intent.getAction();
                    } catch (Throwable th3) {
                        intent = th3;
                        ALog.e("ServiceImpl", "onHostStartCommand", intent, new Object[0]);
                        intent.printStackTrace();
                        com.taobao.accs.client.a.g.incrementAndGet();
                        return c;
                    }
                }
                if (!TextUtils.isEmpty(str) && "org.agoo.android.intent.action.PING_V4".equals(str)) {
                    String stringExtra = intent.getStringExtra("source");
                    Object[] objArr = new Object[3];
                    objArr[0] = "serviceStart";
                    objArr[1] = Integer.valueOf(com.taobao.accs.client.a.g.intValue());
                    StringBuilder stringBuilder2 = new StringBuilder("source");
                    stringBuilder2.append(stringExtra);
                    objArr[2] = stringBuilder2.toString();
                    ALog.i("ServiceImpl", "org.agoo.android.intent.action.PING_V4,start channel by brothers", objArr);
                    b.a("accs", "startChannel", stringExtra, 0.0d);
                    if (com.taobao.accs.client.a.c()) {
                        b.a("accs", "createChannel", stringExtra, 0.0d);
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    e();
                    a(false, false);
                    com.taobao.accs.client.a.g.incrementAndGet();
                    return c;
                }
                e();
                if (!TextUtils.equals(str, "android.intent.action.PACKAGE_REMOVED")) {
                    if (TextUtils.equals(str, PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
                        intent = UtilityImpl.getNetworkTypeExt(this.c);
                        boolean isNetworkConnected = UtilityImpl.isNetworkConnected(this.c);
                        StringBuilder stringBuilder3 = new StringBuilder("network change:");
                        stringBuilder3.append(this.g);
                        stringBuilder3.append(" to ");
                        stringBuilder3.append(intent);
                        ALog.i("ServiceImpl", stringBuilder3.toString(), new Object[0]);
                        if (isNetworkConnected) {
                            this.g = intent;
                            f();
                            a(true, false);
                            UTMini.getInstance().commitEvent(66001, "CONNECTIVITY_CHANGE", intent, UtilityImpl.getProxy(), "0");
                        }
                        if (intent.equals("unknown")) {
                            f();
                            this.g = intent;
                        }
                    } else if (TextUtils.equals(str, PushConsts.ACTION_BROADCAST_TO_BOOT)) {
                        a(true, false);
                    } else if (TextUtils.equals(str, PushConsts.ACTION_BROADCAST_USER_PRESENT)) {
                        ALog.d("ServiceImpl", "action android.intent.action.USER_PRESENT", new Object[0]);
                        a(true, false);
                    } else if (str.equals(Constants.ACTION_COMMAND)) {
                        b(intent);
                    } else if (str.equals(Constants.ACTION_START_FROM_AGOO) != null) {
                        ALog.i("ServiceImpl", "ACTION_START_FROM_AGOO", new Object[0]);
                    }
                }
                com.taobao.accs.client.a.g.incrementAndGet();
                return c;
            } catch (Throwable th4) {
                intent = th4;
                c = 1;
                ALog.e("ServiceImpl", "onHostStartCommand", intent, new Object[0]);
                intent.printStackTrace();
                com.taobao.accs.client.a.g.incrementAndGet();
                return c;
            }
        }
        ALog.e("ServiceImpl", "service disabled!", new Object[0]);
        b(false);
        return 2;
    }

    private void b(android.content.Intent r20) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r19 = this;
        r0 = r19;
        r1 = r20;
        r2 = "command";
        r3 = -1;
        r2 = r1.getIntExtra(r2, r3);
        r4 = "ServiceImpl";
        r5 = new java.lang.StringBuilder;
        r6 = "command:";
        r5.<init>(r6);
        r5.append(r2);
        r5 = r5.toString();
        r6 = 0;
        r7 = new java.lang.Object[r6];
        com.taobao.accs.utl.ALog.i(r4, r5, r7);
        r4 = "packageName";
        r4 = r1.getStringExtra(r4);
        r5 = "serviceId";
        r9 = r1.getStringExtra(r5);
        r5 = "userInfo";
        r8 = r1.getStringExtra(r5);
        r5 = "appKey";
        r5 = r1.getStringExtra(r5);
        r7 = "configTag";
        r10 = r1.getStringExtra(r7);
        r7 = "ttid";
        r14 = r1.getStringExtra(r7);
        r7 = "sid";
        r1.getStringExtra(r7);
        r7 = "anti_brush_cookie";
        r1.getStringExtra(r7);
        r15 = 1;
        r7 = 201; // 0xc9 float:2.82E-43 double:9.93E-322;
        if (r2 != r7) goto L_0x005e;
    L_0x0054:
        r7 = com.taobao.accs.data.Message.a(r15, r6);
        r0.a(r7, r15);
        r19.g();
    L_0x005e:
        if (r2 <= 0) goto L_0x0253;
    L_0x0060:
        r7 = android.text.TextUtils.isEmpty(r4);
        if (r7 != 0) goto L_0x0253;
    L_0x0066:
        r7 = r0.c;
        r13 = com.taobao.accs.internal.b.a(r7, r10, r15, r2);
        r7 = 4;
        r11 = 3;
        r12 = 2;
        if (r13 == 0) goto L_0x0238;
    L_0x0071:
        r13.a();
        r17 = 0;
        if (r2 != r15) goto L_0x00e3;
    L_0x0078:
        r7 = r0.c;
        r7 = r7.getPackageName();
        r7 = r4.equals(r7);
        if (r7 != 0) goto L_0x008e;
    L_0x0084:
        r1 = "ServiceImpl";
        r2 = "handleCommand bindapp pkg error";
        r3 = new java.lang.Object[r6];
        com.taobao.accs.utl.ALog.e(r1, r2, r3);
        return;
    L_0x008e:
        r7 = "app_sercet";
        r12 = r1.getStringExtra(r7);
        r7 = r0.c;
        r8 = "appVersion";
        r16 = r1.getStringExtra(r8);
        r8 = r10;
        r9 = r5;
        r10 = r12;
        r11 = r4;
        r15 = r12;
        r12 = r14;
        r3 = r13;
        r13 = r16;
        r7 = com.taobao.accs.data.Message.a(r7, r8, r9, r10, r11, r12, r13);
        r3.a = r14;
        r8 = r0.c;
        com.taobao.accs.utl.UtilityImpl.saveAppKey(r8, r5, r15);
        r5 = r3.j();
        r5 = r5.c(r4);
        if (r5 == 0) goto L_0x00e0;
    L_0x00ba:
        r5 = "fouce_bind";
        r1 = r1.getBooleanExtra(r5, r6);
        if (r1 != 0) goto L_0x00e0;
    L_0x00c2:
        r1 = "ServiceImpl";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r4);
        r4 = " isAppBinded";
        r2.append(r4);
        r2 = r2.toString();
        r4 = new java.lang.Object[r6];
        com.taobao.accs.utl.ALog.i(r1, r2, r4);
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r3.b(r7, r1);
        return;
    L_0x00e0:
        r5 = r7;
        goto L_0x0209;
    L_0x00e3:
        r3 = r13;
        if (r2 != r12) goto L_0x011b;
    L_0x00e6:
        r1 = "ServiceImpl";
        r5 = "onHostStartCommand COMMAND_UNBIND_APP";
        r7 = new java.lang.Object[r6];
        com.taobao.accs.utl.ALog.e(r1, r5, r7);
        r1 = r3.j();
        r1 = r1.d(r4);
        if (r1 == 0) goto L_0x0207;
    L_0x00f9:
        r1 = com.taobao.accs.data.Message.a(r3, r4);
        r2 = "ServiceImpl";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5.append(r4);
        r4 = " isAppUnbinded";
        r5.append(r4);
        r4 = r5.toString();
        r5 = new java.lang.Object[r6];
        com.taobao.accs.utl.ALog.i(r2, r4, r5);
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r3.b(r1, r2);
        return;
    L_0x011b:
        r5 = 5;
        if (r2 != r5) goto L_0x0124;
    L_0x011e:
        r17 = com.taobao.accs.data.Message.a(r4, r9);
        goto L_0x0207;
    L_0x0124:
        r5 = 6;
        if (r2 != r5) goto L_0x012d;
    L_0x0127:
        r17 = com.taobao.accs.data.Message.b(r4, r9);
        goto L_0x0207;
    L_0x012d:
        if (r2 != r11) goto L_0x016d;
    L_0x012f:
        r5 = com.taobao.accs.data.Message.c(r4, r8);
        r7 = r3.j();
        r7 = r7.b(r4, r8);
        if (r7 == 0) goto L_0x0209;
    L_0x013d:
        r7 = "fouce_bind";
        r1 = r1.getBooleanExtra(r7, r6);
        if (r1 != 0) goto L_0x0209;
    L_0x0145:
        r1 = "ServiceImpl";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r4);
        r4 = "/";
        r2.append(r4);
        r2.append(r8);
        r4 = " isUserBinded";
        r2.append(r4);
        r2 = r2.toString();
        r4 = new java.lang.Object[r6];
        com.taobao.accs.utl.ALog.i(r1, r2, r4);
        if (r5 == 0) goto L_0x016c;
    L_0x0167:
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r3.b(r5, r1);
    L_0x016c:
        return;
    L_0x016d:
        if (r2 != r7) goto L_0x0175;
    L_0x016f:
        r17 = com.taobao.accs.data.Message.a(r4);
        goto L_0x0207;
    L_0x0175:
        r5 = 100;
        if (r2 != r5) goto L_0x01e1;
    L_0x0179:
        r5 = "data";
        r10 = r1.getByteArrayExtra(r5);
        r5 = "dataId";
        r11 = r1.getStringExtra(r5);
        r5 = "target";
        r12 = r1.getStringExtra(r5);
        r5 = "businessId";
        r14 = r1.getStringExtra(r5);
        r5 = "extTag";
        r5 = r1.getStringExtra(r5);
        r7 = "send_type";	 Catch:{ Exception -> 0x01a0 }
        r1 = r1.getSerializableExtra(r7);	 Catch:{ Exception -> 0x01a0 }
        r1 = (com.taobao.accs.data.Message.ReqType) r1;	 Catch:{ Exception -> 0x01a0 }
        goto L_0x01a2;
    L_0x01a0:
        r1 = r17;
    L_0x01a2:
        if (r10 == 0) goto L_0x0207;
    L_0x01a4:
        r7 = new java.net.URL;	 Catch:{ Exception -> 0x01c0 }
        r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01c0 }
        r15 = "https://";	 Catch:{ Exception -> 0x01c0 }
        r13.<init>(r15);	 Catch:{ Exception -> 0x01c0 }
        r15 = r3;	 Catch:{ Exception -> 0x01c0 }
        r15 = (com.taobao.accs.net.r) r15;	 Catch:{ Exception -> 0x01c0 }
        r15 = r15.m();	 Catch:{ Exception -> 0x01c0 }
        r13.append(r15);	 Catch:{ Exception -> 0x01c0 }
        r13 = r13.toString();	 Catch:{ Exception -> 0x01c0 }
        r7.<init>(r13);	 Catch:{ Exception -> 0x01c0 }
        r13 = r7;
        goto L_0x01c2;
    L_0x01c0:
        r13 = r17;
    L_0x01c2:
        r15 = new com.taobao.accs.ACCSManager$AccsRequest;
        r7 = r15;
        r7.<init>(r8, r9, r10, r11, r12, r13, r14);
        r15.setTag(r5);
        if (r1 != 0) goto L_0x01d4;
    L_0x01cd:
        r1 = r0.c;
        r17 = com.taobao.accs.data.Message.a(r3, r1, r4, r15, r6);
        goto L_0x0207;
    L_0x01d4:
        r5 = com.taobao.accs.data.Message.ReqType.REQ;
        if (r1 != r5) goto L_0x0207;
    L_0x01d8:
        r1 = r0.c;
        r1 = com.taobao.accs.data.Message.b(r3, r1, r4, r15, r6);
        r17 = r1;
        goto L_0x0207;
    L_0x01e1:
        r5 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        if (r2 != r5) goto L_0x01f2;
    L_0x01e5:
        r5 = "packs";
        r1 = r1.getSerializableExtra(r5);
        r1 = (java.util.Map) r1;
        r17 = com.taobao.accs.data.Message.a(r4, r1);
        goto L_0x0207;
    L_0x01f2:
        r5 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        if (r2 != r5) goto L_0x0207;
    L_0x01f6:
        r2 = "com.taobao.accs.intent.action.RECEIVE";
        r1.setAction(r2);
        r2 = "command";
        r3 = -1;
        r1.putExtra(r2, r3);
        r2 = r0.c;
        com.taobao.accs.data.d.a(r2, r1);
        return;
    L_0x0207:
        r5 = r17;
    L_0x0209:
        if (r5 == 0) goto L_0x0226;
    L_0x020b:
        r1 = "ServiceImpl";
        r2 = "try send message";
        r4 = new java.lang.Object[r6];
        com.taobao.accs.utl.ALog.d(r1, r2, r4);
        r1 = r5.e();
        if (r1 == 0) goto L_0x0221;
    L_0x021a:
        r1 = r5.e();
        r1.onSend();
    L_0x0221:
        r1 = 1;
        r3.b(r5, r1);
        return;
    L_0x0226:
        r1 = "ServiceImpl";
        r5 = "message is null";
        r6 = new java.lang.Object[r6];
        com.taobao.accs.utl.ALog.e(r1, r5, r6);
        r1 = com.taobao.accs.data.Message.a(r4, r2);
        r2 = -2;
        r3.b(r1, r2);
        goto L_0x0253;
    L_0x0238:
        r1 = "ServiceImpl";
        r3 = "no connection";
        r4 = new java.lang.Object[r7];
        r5 = "configTag";
        r4[r6] = r5;
        r5 = 1;
        r4[r5] = r10;
        r5 = "command";
        r4[r12] = r5;
        r2 = java.lang.Integer.valueOf(r2);
        r4[r11] = r2;
        com.taobao.accs.utl.ALog.e(r1, r3, r4);
        return;
    L_0x0253:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.internal.ServiceImpl.b(android.content.Intent):void");
    }

    public IBinder onBind(Intent intent) {
        CharSequence action = intent.getAction();
        StringBuilder stringBuilder = new StringBuilder("accs probeTaoBao begin......action=");
        stringBuilder.append(action);
        ALog.d("ServiceImpl", stringBuilder.toString(), new Object[0]);
        if (TextUtils.isEmpty(action) || !TextUtils.equals(action, "org.agoo.android.intent.action.PING_V4")) {
            return null;
        }
        UTMini.getInstance().commitEvent(66001, "probeChannelService", UtilityImpl.getDeviceId(this.c), intent.getStringExtra("source"));
        return this.i;
    }

    public void onDestroy() {
        super.onDestroy();
        ALog.e("ServiceImpl", "Service onDestroy", new Object[0]);
        UtilityImpl.setServiceTime(this.c, Constants.SP_KEY_SERVICE_END, System.currentTimeMillis());
        this.b = null;
        this.c = null;
        h();
        Process.killProcess(Process.myPid());
    }

    private final void a(Context context) {
        Throwable th;
        ServiceImpl serviceImpl;
        Context context2 = context;
        try {
            Object d = i.d();
            if (!TextUtils.isEmpty(d)) {
                ALog.i("ServiceImpl", "start pull up", new Object[0]);
                JSONArray jSONArray = new JSONArray(d);
                int i = 0;
                while (i < jSONArray.length()) {
                    try {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        StringBuilder stringBuilder = new StringBuilder("app");
                        stringBuilder.append(i);
                        jSONObject = jSONObject.getJSONObject(stringBuilder.toString());
                        String string = jSONObject.getString("action");
                        String string2 = jSONObject.getString("pack");
                        String string3 = jSONObject.getString(NotificationCompat.CATEGORY_SERVICE);
                        boolean z = jSONObject.getBoolean("enabled") && ((double) jSONObject.getInt("probability")) >= Math.random() * 100.0d;
                        ALog.i("ServiceImpl", "pull up", new Object[]{"action", string, "pack", string2, NotificationCompat.CATEGORY_SERVICE, string3, "need pull", Boolean.valueOf(z)});
                        if (z && UtilityImpl.packageExist(context2, string2)) {
                            Intent intent = new Intent();
                            intent.setAction(string);
                            intent.setClassName(string2, string3);
                            intent.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
                            intent.setPackage(string2);
                            context2.startService(intent);
                            try {
                                UTMini.getInstance().commitEvent(66001, "pingApp", com.taobao.accs.utl.a.b(this.c), string2);
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    ALog.e("ServiceImpl", "onPingIpp parse", th, new Object[0]);
                                    i++;
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                            i++;
                        } else {
                            serviceImpl = this;
                            i++;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        serviceImpl = this;
                        ALog.e("ServiceImpl", "onPingIpp parse", th, new Object[0]);
                        i++;
                    }
                }
            }
            serviceImpl = this;
        } catch (Throwable th5) {
            th = th5;
            serviceImpl = this;
            ALog.e("ServiceImpl", "onPingIpp", th, new Object[0]);
        }
    }

    private void b(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("shouldStopSelf, kill:");
        stringBuilder.append(z);
        ALog.e("ServiceImpl", stringBuilder.toString(), new Object[0]);
        if (this.b != null) {
            this.b.stopSelf();
        }
        if (z) {
            Process.killProcess(Process.myPid());
        }
    }

    private synchronized void e() {
        if (a != null) {
            if (a.size() != 0) {
                for (Entry value : a.entrySet()) {
                    com.taobao.accs.net.b bVar = (com.taobao.accs.net.b) value.getValue();
                    if (bVar == null) {
                        ALog.e("ServiceImpl", "tryConnect connection null", new Object[]{"appkey", bVar.i()});
                        return;
                    }
                    if (bVar.k() && TextUtils.isEmpty(bVar.i.getAppSecret())) {
                        ALog.e("ServiceImpl", "tryConnect secret is null", new Object[0]);
                    } else {
                        bVar.a();
                    }
                    ALog.i("ServiceImpl", "tryConnect", new Object[]{"appkey", bVar.i(), Constants.KEY_CONFIG_TAG, value.getKey()});
                }
                return;
            }
        }
        ALog.w("ServiceImpl", "tryConnect no connections", new Object[0]);
    }

    private void a(Message message, boolean z) {
        if (a != null) {
            if (a.size() != 0) {
                for (Entry value : a.entrySet()) {
                    ((com.taobao.accs.net.b) value.getValue()).b(message, z);
                }
            }
        }
    }

    private void a(boolean z, boolean z2) {
        if (a != null) {
            if (a.size() != 0) {
                for (Entry value : a.entrySet()) {
                    ((com.taobao.accs.net.b) value.getValue()).a(z, z2);
                    ALog.i("ServiceImpl", "ping connection", new Object[]{"appkey", r1.i()});
                }
            }
        }
    }

    private void f() {
        if (a != null) {
            if (a.size() != 0) {
                for (Entry value : a.entrySet()) {
                    ((com.taobao.accs.net.b) value.getValue()).b();
                }
            }
        }
    }

    private void g() {
        if (a != null) {
            if (a.size() != 0) {
                for (Entry value : a.entrySet()) {
                    c c = ((com.taobao.accs.net.b) value.getValue()).c();
                    if (c != null) {
                        c.h = this.d;
                        c.commitUT();
                    }
                }
            }
        }
    }

    private void h() {
        if (a != null) {
            if (a.size() != 0) {
                for (Entry value : a.entrySet()) {
                    ((com.taobao.accs.net.b) value.getValue()).e();
                }
            }
        }
    }

    public void c() {
        ALog.i("ServiceImpl", "startConnect", new Object[0]);
        try {
            e();
            a(false, false);
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("tryConnect is error,e=");
            stringBuilder.append(th);
            ALog.e("ServiceImpl", stringBuilder.toString(), new Object[0]);
        }
    }

    public void a() {
        c();
    }

    public static boolean a(String str) {
        com.taobao.accs.net.b bVar = (com.taobao.accs.net.b) a.elements().nextElement();
        if (bVar == null) {
            return null;
        }
        return bVar.j().c(str);
    }
}
