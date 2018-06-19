package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.channel.commonutils.string.c;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.as;
import com.xiaomi.push.service.module.PushChannelRegion;
import com.xiaomi.xmpush.thrift.ai;
import com.xiaomi.xmpush.thrift.aj;
import com.xiaomi.xmpush.thrift.aq;
import com.xiaomi.xmpush.thrift.au;
import com.xiaomi.xmpush.thrift.g;
import com.xiaomi.xmpush.thrift.r;
import com.xiaomi.xmpush.thrift.u;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ac {
    public static volatile boolean a = false;
    private static ac c = null;
    private static String d = null;
    private static String e = null;
    private static boolean n = false;
    private static final ArrayList<a> o = new ArrayList();
    private boolean b = false;
    private final Object f = new Object();
    private final int g = ReaderCallback.GET_BAR_ANIMATING;
    private boolean h;
    private boolean i;
    private Context j;
    private String k;
    private Messenger l;
    private Messenger m;
    private final LinkedList<b> p = new LinkedList();
    private Handler q = null;
    private List<Message> r = new ArrayList();
    private boolean s = false;
    private Thread t = new Thread(new ad(this));
    private Intent u = null;
    private Integer v = null;

    static class a<T extends org.apache.thrift.a<T, ?>> {
        T a;
        com.xiaomi.xmpush.thrift.a b;
        boolean c;

        a() {
        }
    }

    static class b {
        int a;
        HashMap<String, Object> b;

        b() {
        }
    }

    private ac(Context context) {
        this.j = context.getApplicationContext();
        this.k = null;
        e = com.xiaomi.push.service.a.a(context).a();
        boolean z = f.a() && com.xiaomi.channel.commonutils.android.a.b(context, "com.xiaomi.xmsf") >= 109;
        this.i = z;
        this.h = false;
        this.b = n();
        n = y();
        this.q = new ae(this, Looper.getMainLooper());
        Intent p = p();
        if (p != null) {
            a(p);
            a = true;
        }
    }

    private boolean A() {
        String packageName = this.j.getPackageName();
        return packageName.contains("miui") || packageName.contains("xiaomi") || (this.j.getApplicationInfo().flags & 1) != 0;
    }

    private void B() {
        Intent intent = new Intent();
        intent.setClassName("com.xiaomi.xmsf", t());
        this.j.bindService(intent, new ah(this), 1);
    }

    private <T extends org.apache.thrift.a<T, ?>> void C() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r0 = r11.p;
        if (r0 == 0) goto L_0x015c;
    L_0x0004:
        r0 = r11.p;
        r0 = r0.size();
        if (r0 != 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = r11.p;
        monitor-enter(r0);
        r1 = r11.p;	 Catch:{ all -> 0x0159 }
        r1 = r1.poll();	 Catch:{ all -> 0x0159 }
        r1 = (com.xiaomi.mipush.sdk.ac.b) r1;	 Catch:{ all -> 0x0159 }
        monitor-exit(r0);	 Catch:{ all -> 0x0159 }
        if (r1 == 0) goto L_0x0155;
    L_0x001b:
        r0 = r1.a;	 Catch:{ Throwable -> 0x000d }
        switch(r0) {
            case 1: goto L_0x0150;
            case 2: goto L_0x014b;
            case 3: goto L_0x0136;
            case 4: goto L_0x0119;
            case 5: goto L_0x0114;
            case 6: goto L_0x00f5;
            case 7: goto L_0x00c0;
            case 8: goto L_0x0051;
            case 9: goto L_0x0043;
            case 10: goto L_0x002f;
            case 11: goto L_0x0021;
            default: goto L_0x0020;
        };	 Catch:{ Throwable -> 0x000d }
    L_0x0020:
        goto L_0x000d;	 Catch:{ Throwable -> 0x000d }
    L_0x0021:
        r0 = r1.b;	 Catch:{ Throwable -> 0x000d }
        r1 = "XmPushActionUnRegistration";	 Catch:{ Throwable -> 0x000d }
        r0 = r0.get(r1);	 Catch:{ Throwable -> 0x000d }
        r0 = (com.xiaomi.xmpush.thrift.aq) r0;	 Catch:{ Throwable -> 0x000d }
        r11.b(r0);	 Catch:{ Throwable -> 0x000d }
        goto L_0x000d;	 Catch:{ Throwable -> 0x000d }
    L_0x002f:
        r0 = r1.b;	 Catch:{ Throwable -> 0x000d }
        r1 = "notifyType";	 Catch:{ Throwable -> 0x000d }
        r0 = r0.get(r1);	 Catch:{ Throwable -> 0x000d }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x000d }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Throwable -> 0x000d }
        r11.f(r0);	 Catch:{ Throwable -> 0x000d }
        goto L_0x000d;	 Catch:{ Throwable -> 0x000d }
    L_0x0043:
        r0 = r1.b;	 Catch:{ Throwable -> 0x000d }
        r1 = "ClientUploadDataItem";	 Catch:{ Throwable -> 0x000d }
        r0 = r0.get(r1);	 Catch:{ Throwable -> 0x000d }
        r0 = (com.xiaomi.xmpush.thrift.f) r0;	 Catch:{ Throwable -> 0x000d }
        r11.b(r0);	 Catch:{ Throwable -> 0x000d }
        goto L_0x000d;	 Catch:{ Throwable -> 0x000d }
    L_0x0051:
        r0 = r1.b;	 Catch:{ Throwable -> 0x000d }
        r2 = "packet";	 Catch:{ Throwable -> 0x000d }
        r0 = r0.get(r2);	 Catch:{ Throwable -> 0x000d }
        r3 = r0;	 Catch:{ Throwable -> 0x000d }
        r3 = (org.apache.thrift.a) r3;	 Catch:{ Throwable -> 0x000d }
        r0 = r1.b;	 Catch:{ Throwable -> 0x000d }
        r2 = "actionType";	 Catch:{ Throwable -> 0x000d }
        r0 = r0.get(r2);	 Catch:{ Throwable -> 0x000d }
        r4 = r0;	 Catch:{ Throwable -> 0x000d }
        r4 = (com.xiaomi.xmpush.thrift.a) r4;	 Catch:{ Throwable -> 0x000d }
        r0 = r1.b;	 Catch:{ Throwable -> 0x000d }
        r2 = "encrypt";	 Catch:{ Throwable -> 0x000d }
        r0 = r0.get(r2);	 Catch:{ Throwable -> 0x000d }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x000d }
        r5 = java.lang.Boolean.parseBoolean(r0);	 Catch:{ Throwable -> 0x000d }
        r0 = r1.b;	 Catch:{ Throwable -> 0x000d }
        r2 = "pendingIfNecessary";	 Catch:{ Throwable -> 0x000d }
        r0 = r0.get(r2);	 Catch:{ Throwable -> 0x000d }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x000d }
        r6 = java.lang.Boolean.parseBoolean(r0);	 Catch:{ Throwable -> 0x000d }
        r0 = r1.b;	 Catch:{ Throwable -> 0x000d }
        r2 = "metaInfo";	 Catch:{ Throwable -> 0x000d }
        r0 = r0.get(r2);	 Catch:{ Throwable -> 0x000d }
        r7 = r0;	 Catch:{ Throwable -> 0x000d }
        r7 = (com.xiaomi.xmpush.thrift.u) r7;	 Catch:{ Throwable -> 0x000d }
        r0 = r1.b;	 Catch:{ Throwable -> 0x000d }
        r2 = "isCache";	 Catch:{ Throwable -> 0x000d }
        r0 = r0.get(r2);	 Catch:{ Throwable -> 0x000d }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x000d }
        r8 = java.lang.Boolean.parseBoolean(r0);	 Catch:{ Throwable -> 0x000d }
        r0 = r1.b;	 Catch:{ Throwable -> 0x000d }
        r2 = "packageName";	 Catch:{ Throwable -> 0x000d }
        r0 = r0.get(r2);	 Catch:{ Throwable -> 0x000d }
        r9 = java.lang.String.valueOf(r0);	 Catch:{ Throwable -> 0x000d }
        r0 = r1.b;	 Catch:{ Throwable -> 0x000d }
        r1 = "appId";	 Catch:{ Throwable -> 0x000d }
        r0 = r0.get(r1);	 Catch:{ Throwable -> 0x000d }
        r10 = java.lang.String.valueOf(r0);	 Catch:{ Throwable -> 0x000d }
        r2 = r11;	 Catch:{ Throwable -> 0x000d }
        r2.b(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ Throwable -> 0x000d }
        goto L_0x000d;	 Catch:{ Throwable -> 0x000d }
    L_0x00c0:
        r0 = r1.b;	 Catch:{ Throwable -> 0x000d }
        r2 = "messageId";	 Catch:{ Throwable -> 0x000d }
        r0 = r0.get(r2);	 Catch:{ Throwable -> 0x000d }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ Throwable -> 0x000d }
        r2 = r1.b;	 Catch:{ Throwable -> 0x000d }
        r3 = "type";	 Catch:{ Throwable -> 0x000d }
        r2 = r2.get(r3);	 Catch:{ Throwable -> 0x000d }
        r2 = (com.xiaomi.mipush.sdk.aj) r2;	 Catch:{ Throwable -> 0x000d }
        r3 = r1.b;	 Catch:{ Throwable -> 0x000d }
        r4 = "expand";	 Catch:{ Throwable -> 0x000d }
        r3 = r3.get(r4);	 Catch:{ Throwable -> 0x000d }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x000d }
        r3 = java.lang.Boolean.parseBoolean(r3);	 Catch:{ Throwable -> 0x000d }
        r1 = r1.b;	 Catch:{ Throwable -> 0x000d }
        r4 = "extra";	 Catch:{ Throwable -> 0x000d }
        r1 = r1.get(r4);	 Catch:{ Throwable -> 0x000d }
        r1 = (java.util.HashMap) r1;	 Catch:{ Throwable -> 0x000d }
        r11.b(r0, r2, r3, r1);	 Catch:{ Throwable -> 0x000d }
        goto L_0x000d;	 Catch:{ Throwable -> 0x000d }
    L_0x00f5:
        r0 = r1.b;	 Catch:{ Throwable -> 0x000d }
        r2 = "XmPushActionRegistration";	 Catch:{ Throwable -> 0x000d }
        r0 = r0.get(r2);	 Catch:{ Throwable -> 0x000d }
        r0 = (com.xiaomi.xmpush.thrift.aj) r0;	 Catch:{ Throwable -> 0x000d }
        r1 = r1.b;	 Catch:{ Throwable -> 0x000d }
        r2 = "isEnvChanage";	 Catch:{ Throwable -> 0x000d }
        r1 = r1.get(r2);	 Catch:{ Throwable -> 0x000d }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x000d }
        r1 = java.lang.Boolean.parseBoolean(r1);	 Catch:{ Throwable -> 0x000d }
        r11.b(r0, r1);	 Catch:{ Throwable -> 0x000d }
        goto L_0x000d;	 Catch:{ Throwable -> 0x000d }
    L_0x0114:
        r11.m();	 Catch:{ Throwable -> 0x000d }
        goto L_0x000d;	 Catch:{ Throwable -> 0x000d }
    L_0x0119:
        r0 = r1.b;	 Catch:{ Throwable -> 0x000d }
        r2 = "title";	 Catch:{ Throwable -> 0x000d }
        r0 = r0.get(r2);	 Catch:{ Throwable -> 0x000d }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ Throwable -> 0x000d }
        r1 = r1.b;	 Catch:{ Throwable -> 0x000d }
        r2 = "description";	 Catch:{ Throwable -> 0x000d }
        r1 = r1.get(r2);	 Catch:{ Throwable -> 0x000d }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ Throwable -> 0x000d }
        r11.b(r0, r1);	 Catch:{ Throwable -> 0x000d }
        goto L_0x000d;	 Catch:{ Throwable -> 0x000d }
    L_0x0136:
        r0 = r1.b;	 Catch:{ Throwable -> 0x000d }
        r1 = "notifyId";	 Catch:{ Throwable -> 0x000d }
        r0 = r0.get(r1);	 Catch:{ Throwable -> 0x000d }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x000d }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Throwable -> 0x000d }
        r11.e(r0);	 Catch:{ Throwable -> 0x000d }
        goto L_0x000d;	 Catch:{ Throwable -> 0x000d }
    L_0x014b:
        r11.z();	 Catch:{ Throwable -> 0x000d }
        goto L_0x000d;	 Catch:{ Throwable -> 0x000d }
    L_0x0150:
        r11.l();	 Catch:{ Throwable -> 0x000d }
        goto L_0x000d;
    L_0x0155:
        r0 = 1;
        a = r0;
        return;
    L_0x0159:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0159 }
        throw r1;
    L_0x015c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.ac.C():void");
    }

    public static synchronized ac a(Context context) {
        ac acVar;
        synchronized (ac.class) {
            if (c == null) {
                c = new ac(context);
            }
            acVar = c;
        }
        return acVar;
    }

    private void a(Intent intent) {
        try {
            this.j.startService(intent);
        } catch (Throwable e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    private final void a(String str, aj ajVar, boolean z, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put(PushResult.MSG_ID, str);
        hashMap2.put("type", ajVar);
        hashMap2.put("expand", Boolean.valueOf(z));
        hashMap2.put("extra", hashMap);
        if (!a(7, hashMap2)) {
            b(str, ajVar, z, hashMap);
        }
    }

    private boolean a(int i, HashMap<String, Object> hashMap) {
        if (!this.i || a || "com.xiaomi.xmsf".equals(this.j.getPackageName())) {
            return false;
        }
        synchronized (this.p) {
            b bVar = new b();
            bVar.a = i;
            bVar.b = hashMap;
            this.p.offer(bVar);
        }
        return true;
    }

    private void b(Intent intent) {
        int a = am.a(this.j).a(g.ServiceBootMode.a(), com.xiaomi.xmpush.thrift.b.START.a());
        int k = k();
        Object obj = (a == com.xiaomi.xmpush.thrift.b.BIND.a() && n) ? 1 : null;
        int a2 = (obj != null ? com.xiaomi.xmpush.thrift.b.BIND : com.xiaomi.xmpush.thrift.b.START).a();
        if (a2 != k) {
            c(a2);
        }
        if (obj != null) {
            c(intent);
        } else {
            a(intent);
        }
    }

    private final void b(aj ajVar, boolean z) {
        this.u = null;
        Intent o = o();
        byte[] a = au.a(x.a(this.j, ajVar, com.xiaomi.xmpush.thrift.a.Registration));
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.a("register fail, because msgBytes is null.");
            return;
        }
        o.setAction("com.xiaomi.mipush.REGISTER_APP");
        o.putExtra("mipush_app_id", c.a(this.j).c());
        o.putExtra("mipush_payload", a);
        o.putExtra("mipush_session", this.k);
        o.putExtra("mipush_env_chanage", z);
        o.putExtra("mipush_env_type", c.a(this.j).l());
        if (d.c(this.j) && h()) {
            b(o);
        } else {
            this.u = o;
        }
    }

    private final void b(aq aqVar) {
        byte[] a = au.a(x.a(this.j, aqVar, com.xiaomi.xmpush.thrift.a.UnRegistration));
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent o = o();
        o.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        o.putExtra("mipush_app_id", c.a(this.j).c());
        o.putExtra("mipush_payload", a);
        b(o);
    }

    private final void b(com.xiaomi.xmpush.thrift.f fVar) {
        Intent o = o();
        byte[] a = au.a(fVar);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        o.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        o.putExtra("mipush_payload", a);
        a(o);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.lang.String r12, com.xiaomi.mipush.sdk.aj r13, boolean r14, java.util.HashMap<java.lang.String, java.lang.String> r15) {
        /*
        r11 = this;
        r0 = r11.j;
        r0 = com.xiaomi.mipush.sdk.c.a(r0);
        r0 = r0.b();
        if (r0 == 0) goto L_0x0139;
    L_0x000c:
        r0 = r11.j;
        r0 = com.xiaomi.channel.commonutils.network.d.c(r0);
        if (r0 != 0) goto L_0x0015;
    L_0x0014:
        return;
    L_0x0015:
        r0 = new com.xiaomi.xmpush.thrift.ai;
        r0.<init>();
        r1 = 1;
        r0.a(r1);
        r2 = r11.o();
        r3 = android.text.TextUtils.isEmpty(r12);
        r4 = 0;
        if (r3 == 0) goto L_0x004a;
    L_0x0029:
        r12 = com.xiaomi.mipush.sdk.MiPushClient.generatePacketID();
        r0.a(r12);
        if (r14 == 0) goto L_0x0038;
    L_0x0032:
        r3 = new com.xiaomi.xmpush.thrift.ai;
        r3.<init>(r12, r1);
        goto L_0x0039;
    L_0x0038:
        r3 = r4;
    L_0x0039:
        r5 = com.xiaomi.mipush.sdk.u.class;
        monitor-enter(r5);
        r6 = r11.j;	 Catch:{ all -> 0x0047 }
        r6 = com.xiaomi.mipush.sdk.u.a(r6);	 Catch:{ all -> 0x0047 }
        r6.a(r12);	 Catch:{ all -> 0x0047 }
        monitor-exit(r5);	 Catch:{ all -> 0x0047 }
        goto L_0x0054;
    L_0x0047:
        r12 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0047 }
        throw r12;
    L_0x004a:
        r0.a(r12);
        if (r14 == 0) goto L_0x0056;
    L_0x004f:
        r3 = new com.xiaomi.xmpush.thrift.ai;
        r3.<init>(r12, r1);
    L_0x0054:
        r6 = r3;
        goto L_0x0057;
    L_0x0056:
        r6 = r4;
    L_0x0057:
        r3 = com.xiaomi.mipush.sdk.ai.a;
        r5 = r13.ordinal();
        r3 = r3[r5];
        switch(r3) {
            case 1: goto L_0x0089;
            case 2: goto L_0x0070;
            case 3: goto L_0x0063;
            default: goto L_0x0062;
        };
    L_0x0062:
        goto L_0x00a4;
    L_0x0063:
        r3 = com.xiaomi.xmpush.thrift.r.ThirdPartyRegUpdate;
        r3 = r3.W;
        r0.c(r3);
        if (r15 == 0) goto L_0x00a4;
    L_0x006c:
        r0.a(r15);
        goto L_0x00a4;
    L_0x0070:
        r3 = com.xiaomi.xmpush.thrift.r.EnablePushMessage;
        r3 = r3.W;
        r0.c(r3);
        r3 = com.xiaomi.xmpush.thrift.r.EnablePushMessage;
        r3 = r3.W;
        r6.c(r3);
        if (r15 == 0) goto L_0x0086;
    L_0x0080:
        r0.a(r15);
        r6.a(r15);
    L_0x0086:
        r15 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
        goto L_0x00a1;
    L_0x0089:
        r3 = com.xiaomi.xmpush.thrift.r.DisablePushMessage;
        r3 = r3.W;
        r0.c(r3);
        r3 = com.xiaomi.xmpush.thrift.r.DisablePushMessage;
        r3 = r3.W;
        r6.c(r3);
        if (r15 == 0) goto L_0x009f;
    L_0x0099:
        r0.a(r15);
        r6.a(r15);
    L_0x009f:
        r15 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
    L_0x00a1:
        r2.setAction(r15);
    L_0x00a4:
        r15 = r11.j;
        r15 = com.xiaomi.mipush.sdk.c.a(r15);
        r15 = r15.c();
        r0.b(r15);
        r15 = r11.j;
        r15 = r15.getPackageName();
        r0.d(r15);
        r15 = com.xiaomi.xmpush.thrift.a.Notification;
        r3 = 0;
        r11.a(r0, r15, r3, r4);
        if (r14 == 0) goto L_0x0122;
    L_0x00c2:
        r14 = r11.j;
        r14 = com.xiaomi.mipush.sdk.c.a(r14);
        r14 = r14.c();
        r6.b(r14);
        r14 = r11.j;
        r14 = r14.getPackageName();
        r6.d(r14);
        r5 = r11.j;
        r7 = com.xiaomi.xmpush.thrift.a.Notification;
        r8 = 0;
        r14 = r11.j;
        r9 = r14.getPackageName();
        r14 = r11.j;
        r14 = com.xiaomi.mipush.sdk.c.a(r14);
        r10 = r14.c();
        r14 = com.xiaomi.mipush.sdk.x.a(r5, r6, r7, r8, r9, r10);
        r14 = com.xiaomi.xmpush.thrift.au.a(r14);
        if (r14 == 0) goto L_0x0122;
    L_0x00f7:
        r15 = "mipush_payload";
        r2.putExtra(r15, r14);
        r14 = "com.xiaomi.mipush.MESSAGE_CACHE";
        r2.putExtra(r14, r1);
        r14 = "mipush_app_id";
        r15 = r11.j;
        r15 = com.xiaomi.mipush.sdk.c.a(r15);
        r15 = r15.c();
        r2.putExtra(r14, r15);
        r14 = "mipush_app_token";
        r15 = r11.j;
        r15 = com.xiaomi.mipush.sdk.c.a(r15);
        r15 = r15.d();
        r2.putExtra(r14, r15);
        r11.b(r2);
    L_0x0122:
        r14 = android.os.Message.obtain();
        r15 = 19;
        r14.what = r15;
        r13 = r13.ordinal();
        r14.obj = r12;
        r14.arg1 = r13;
        r12 = r11.q;
        r0 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r12.sendMessageDelayed(r14, r0);
    L_0x0139:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.ac.b(java.lang.String, com.xiaomi.mipush.sdk.aj, boolean, java.util.HashMap):void");
    }

    private void b(String str, String str2) {
        Intent o = o();
        o.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        o.putExtra(as.y, this.j.getPackageName());
        o.putExtra(as.D, str);
        o.putExtra(as.E, str2);
        b(o);
    }

    private final <T extends org.apache.thrift.a<T, ?>> void b(T t, com.xiaomi.xmpush.thrift.a aVar, boolean z, boolean z2, u uVar, boolean z3, String str, String str2) {
        if (c.a(this.j).i()) {
            org.apache.thrift.a a = x.a(this.j, t, aVar, z, str, str2);
            if (uVar != null) {
                a.a(uVar);
            }
            byte[] a2 = au.a(a);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.a("send message fail, because msgBytes is null.");
                return;
            }
            Intent o = o();
            o.setAction("com.xiaomi.mipush.SEND_MESSAGE");
            o.putExtra("mipush_payload", a2);
            o.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
            b(o);
        } else if (z2) {
            a((org.apache.thrift.a) t, aVar, z);
        } else {
            com.xiaomi.channel.commonutils.logger.b.a("drop the message before initialization.");
        }
    }

    private synchronized void c(Intent intent) {
        if (this.s) {
            Message d = d(intent);
            if (this.r.size() >= 50) {
                this.r.remove(0);
            }
            this.r.add(d);
        } else if (this.l == null) {
            this.j.bindService(intent, new ag(this), 1);
            this.s = true;
            this.r.clear();
            this.r.add(d(intent));
        } else {
            try {
                this.l.send(d(intent));
            } catch (Throwable e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }

    private Message d(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    private synchronized void d(int i) {
        this.j.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
    }

    private void e(int i) {
        Intent o = o();
        o.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        o.putExtra(as.y, this.j.getPackageName());
        o.putExtra(as.z, i);
        b(o);
    }

    private void f(int i) {
        Intent o = o();
        o.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        o.putExtra(as.y, this.j.getPackageName());
        o.putExtra(as.A, i);
        String str = as.C;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.j.getPackageName());
        stringBuilder.append(i);
        o.putExtra(str, c.b(stringBuilder.toString()));
        b(o);
    }

    private synchronized int k() {
        return this.j.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    private void l() {
        a(o());
    }

    private final void m() {
        Intent o = o();
        o.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        b(o);
    }

    private boolean n() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.j;
        r0 = r0.getPackageManager();
        r1 = 0;
        r2 = "com.xiaomi.xmsf";	 Catch:{ Throwable -> 0x001a }
        r3 = 4;	 Catch:{ Throwable -> 0x001a }
        r0 = r0.getPackageInfo(r2, r3);	 Catch:{ Throwable -> 0x001a }
        if (r0 != 0) goto L_0x0011;	 Catch:{ Throwable -> 0x001a }
    L_0x0010:
        return r1;	 Catch:{ Throwable -> 0x001a }
    L_0x0011:
        r0 = r0.versionCode;	 Catch:{ Throwable -> 0x001a }
        r2 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        if (r0 >= r2) goto L_0x0018;
    L_0x0017:
        return r1;
    L_0x0018:
        r0 = 1;
        return r0;
    L_0x001a:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.ac.n():boolean");
    }

    private Intent o() {
        if (!com.xiaomi.channel.commonutils.misc.d.a || a) {
            return (d() && w() && !"com.xiaomi.xmsf".equals(this.j.getPackageName())) ? r() : s();
        } else {
            StringBuilder stringBuilder = new StringBuilder("can't do this on ui thread when debug_switch:");
            stringBuilder.append(com.xiaomi.channel.commonutils.misc.d.a);
            throw new RuntimeException(stringBuilder.toString());
        }
    }

    private Intent p() {
        if (!"com.xiaomi.xmsf".equals(this.j.getPackageName())) {
            return q();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
        return s();
    }

    private Intent q() {
        if (this.i) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start request xmsf region");
            this.m = new Messenger(this.q);
            this.t.start();
            return null;
        } else if (PushChannelRegion.China.name().equals(e)) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
            return r();
        } else {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
            return s();
        }
    }

    private Intent r() {
        Intent intent = new Intent();
        String packageName = this.j.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", t());
        intent.putExtra("mipush_app_package", packageName);
        u();
        return intent;
    }

    private Intent s() {
        Intent intent = new Intent();
        String packageName = this.j.getPackageName();
        v();
        intent.setComponent(new ComponentName(this.j, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    private java.lang.String t() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.j;	 Catch:{ Exception -> 0x0016 }
        r0 = r0.getPackageManager();	 Catch:{ Exception -> 0x0016 }
        r1 = "com.xiaomi.xmsf";	 Catch:{ Exception -> 0x0016 }
        r2 = 4;	 Catch:{ Exception -> 0x0016 }
        r0 = r0.getPackageInfo(r1, r2);	 Catch:{ Exception -> 0x0016 }
        r0 = r0.versionCode;	 Catch:{ Exception -> 0x0016 }
        r1 = 106; // 0x6a float:1.49E-43 double:5.24E-322;	 Catch:{ Exception -> 0x0016 }
        if (r0 < r1) goto L_0x0016;	 Catch:{ Exception -> 0x0016 }
    L_0x0013:
        r0 = "com.xiaomi.push.service.XMPushService";	 Catch:{ Exception -> 0x0016 }
        return r0;
    L_0x0016:
        r0 = "com.xiaomi.xmsf.push.service.XMPushService";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.ac.t():java.lang.String");
    }

    private void u() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.j;	 Catch:{ Throwable -> 0x0014 }
        r0 = r0.getPackageManager();	 Catch:{ Throwable -> 0x0014 }
        r1 = new android.content.ComponentName;	 Catch:{ Throwable -> 0x0014 }
        r2 = r4.j;	 Catch:{ Throwable -> 0x0014 }
        r3 = "com.xiaomi.push.service.XMPushService";	 Catch:{ Throwable -> 0x0014 }
        r1.<init>(r2, r3);	 Catch:{ Throwable -> 0x0014 }
        r2 = 2;	 Catch:{ Throwable -> 0x0014 }
        r3 = 1;	 Catch:{ Throwable -> 0x0014 }
        r0.setComponentEnabledSetting(r1, r2, r3);	 Catch:{ Throwable -> 0x0014 }
    L_0x0014:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.ac.u():void");
    }

    private void v() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.j;	 Catch:{ Throwable -> 0x0013 }
        r0 = r0.getPackageManager();	 Catch:{ Throwable -> 0x0013 }
        r1 = new android.content.ComponentName;	 Catch:{ Throwable -> 0x0013 }
        r2 = r4.j;	 Catch:{ Throwable -> 0x0013 }
        r3 = "com.xiaomi.push.service.XMPushService";	 Catch:{ Throwable -> 0x0013 }
        r1.<init>(r2, r3);	 Catch:{ Throwable -> 0x0013 }
        r2 = 1;	 Catch:{ Throwable -> 0x0013 }
        r0.setComponentEnabledSetting(r1, r2, r2);	 Catch:{ Throwable -> 0x0013 }
    L_0x0013:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.ac.v():void");
    }

    private boolean w() {
        return ((TextUtils.isEmpty(e) || TextUtils.isEmpty(d) || TextUtils.equals(d, e)) && !this.h) ? this.i || TextUtils.equals(e, PushChannelRegion.China.name()) : false;
    }

    private void x() {
        if (am.a(this.j).a(g.GlobalPushChannelException.a(), false)) {
            MiTinyDataClient.upload(this.j, "push_exception", "xmsf_region_timeout", 1, "app request xmsf_request timeout");
        }
    }

    private boolean y() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.d();
        r1 = 1;
        if (r0 == 0) goto L_0x001d;
    L_0x0007:
        r0 = r4.j;	 Catch:{ Exception -> 0x001d }
        r0 = r0.getPackageManager();	 Catch:{ Exception -> 0x001d }
        r2 = "com.xiaomi.xmsf";	 Catch:{ Exception -> 0x001d }
        r3 = 4;	 Catch:{ Exception -> 0x001d }
        r0 = r0.getPackageInfo(r2, r3);	 Catch:{ Exception -> 0x001d }
        r0 = r0.versionCode;	 Catch:{ Exception -> 0x001d }
        r2 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
        if (r0 < r2) goto L_0x001b;
    L_0x001a:
        return r1;
    L_0x001b:
        r0 = 0;
        return r0;
    L_0x001d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.ac.y():boolean");
    }

    private void z() {
        Intent o = o();
        o.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        o.putExtra(as.y, this.j.getPackageName());
        o.putExtra(as.C, c.b(this.j.getPackageName()));
        b(o);
    }

    public void a() {
        if (!a(1, null)) {
            l();
        }
    }

    public void a(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("notifyId", Integer.valueOf(i));
        if (!a(3, hashMap)) {
            e(i);
        }
    }

    public final void a(aj ajVar, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("XmPushActionRegistration", ajVar);
        hashMap.put("isEnvChanage", Boolean.valueOf(z));
        if (!a(6, hashMap)) {
            b(ajVar, z);
        }
    }

    public final void a(aq aqVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("XmPushActionUnRegistration", aqVar);
        if (!a(11, hashMap)) {
            b(aqVar);
        }
    }

    public final void a(com.xiaomi.xmpush.thrift.f fVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("ClientUploadDataItem", fVar);
        if (!a(9, hashMap)) {
            b(fVar);
        }
    }

    public final void a(String str) {
        u.a(this.j).a(aj.UPLOAD_TOKEN, "syncing");
        a(str, aj.UPLOAD_TOKEN, false, d.e(this.j));
    }

    public void a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("title", str);
        hashMap.put("description", str2);
        if (!a(4, hashMap)) {
            b(str, str2);
        }
    }

    public final <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, u uVar) {
        a((org.apache.thrift.a) t, aVar, aVar.equals(com.xiaomi.xmpush.thrift.a.Registration) ^ 1, uVar);
    }

    public <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, boolean z) {
        a aVar2 = new a();
        aVar2.a = t;
        aVar2.b = aVar;
        aVar2.c = z;
        synchronized (o) {
            o.add(aVar2);
            if (o.size() > 10) {
                o.remove(0);
            }
        }
    }

    public final <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, boolean z, u uVar) {
        a(t, aVar, z, true, uVar, true);
    }

    public final <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, boolean z, u uVar, boolean z2) {
        a(t, aVar, z, true, uVar, z2);
    }

    public final <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, boolean z, boolean z2, u uVar, boolean z3) {
        a(t, aVar, z, z2, uVar, z3, this.j.getPackageName(), c.a(this.j).c());
    }

    public final <T extends org.apache.thrift.a<T, ?>> void a(T t, com.xiaomi.xmpush.thrift.a aVar, boolean z, boolean z2, u uVar, boolean z3, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("packet", t);
        hashMap.put("actionType", aVar);
        hashMap.put("encrypt", Boolean.valueOf(z));
        hashMap.put("pendingIfNecessary", Boolean.valueOf(z2));
        hashMap.put("metaInfo", uVar);
        hashMap.put("isCache", Boolean.valueOf(z3));
        hashMap.put(Constants.KEY_PACKAGE_NAME, str);
        hashMap.put("appId", str2);
        if (!a(8, hashMap)) {
            b(t, aVar, z, z2, uVar, z3, str, str2);
        }
    }

    public final void a(boolean z) {
        a(z, null);
    }

    public final void a(boolean z, String str) {
        aj ajVar;
        if (z) {
            u.a(this.j).a(aj.DISABLE_PUSH, "syncing");
            u.a(this.j).a(aj.ENABLE_PUSH, "");
            ajVar = aj.DISABLE_PUSH;
        } else {
            u.a(this.j).a(aj.ENABLE_PUSH, "syncing");
            u.a(this.j).a(aj.DISABLE_PUSH, "");
            ajVar = aj.ENABLE_PUSH;
        }
        a(str, ajVar, true, null);
    }

    public final void b() {
        if (!a(5, null)) {
            m();
        }
    }

    public void b(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("notifyType", Integer.valueOf(i));
        if (!a(10, hashMap)) {
            f(i);
        }
    }

    public final void c() {
        a(null);
    }

    public boolean c(int i) {
        if (!c.a(this.j).b()) {
            return false;
        }
        d(i);
        org.apache.thrift.a aiVar = new ai();
        aiVar.a(MiPushClient.generatePacketID());
        aiVar.b(c.a(this.j).c());
        aiVar.d(this.j.getPackageName());
        aiVar.c(r.ClientABTest.W);
        aiVar.h = new HashMap();
        aiVar.h.put("boot_mode", String.valueOf(i));
        a(this.j).a(aiVar, com.xiaomi.xmpush.thrift.a.Notification, false, null);
        return true;
    }

    public boolean d() {
        return this.b && 1 == c.a(this.j).l();
    }

    public void e() {
        if (this.u != null) {
            b(this.u);
            this.u = null;
        }
    }

    public void f() {
        synchronized (o) {
            Iterator it = o.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                a(aVar.a, aVar.b, aVar.c, false, null, true);
            }
            o.clear();
        }
    }

    public void g() {
        if (!a(2, null)) {
            z();
        }
    }

    public boolean h() {
        if (!d() || !A()) {
            return true;
        }
        if (this.v == null) {
            this.v = Integer.valueOf(com.xiaomi.push.service.au.a(this.j).b());
            if (this.v.intValue() == 0) {
                this.j.getContentResolver().registerContentObserver(com.xiaomi.push.service.au.a(this.j).c(), false, new af(this, new Handler(Looper.getMainLooper())));
            }
        }
        return this.v.intValue() != 0;
    }
}
