package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import com.igexin.sdk.PushConsts;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.service.module.PushChannelRegion;
import com.xiaomi.xmpush.thrift.af;
import com.xiaomi.xmpush.thrift.aj;
import com.xiaomi.xmpush.thrift.au;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class XMPushService extends Service implements com.xiaomi.smack.d {
    public static int c = 1;
    private static final int i = Process.myPid();
    Messenger a = null;
    final BroadcastReceiver b = new bp(this);
    private com.xiaomi.smack.b d;
    private ax e;
    private String f;
    private e g;
    private long h = 0;
    private com.xiaomi.slim.f j;
    private com.xiaomi.smack.a k;
    private e l;
    private PacketSync m = null;
    private l n = null;
    private ArrayList<k> o = new ArrayList();
    private com.xiaomi.smack.f p = new bh(this);

    class e extends BroadcastReceiver {
        final /* synthetic */ XMPushService a;

        e(XMPushService xMPushService) {
            this.a = xMPushService;
        }

        public void onReceive(Context context, Intent intent) {
            this.a.onStart(intent, XMPushService.c);
        }
    }

    public interface k {
        void a();
    }

    public static abstract class h extends com.xiaomi.push.service.l.b {
        public h(int i) {
            super(i);
        }

        public abstract void a();

        public abstract String b();

        public void run() {
            if (!(this.a == 4 || this.a == 8)) {
                StringBuilder stringBuilder = new StringBuilder("JOB: ");
                stringBuilder.append(b());
                com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
            }
            a();
        }
    }

    class a extends h {
        com.xiaomi.push.service.ap.b b = null;
        final /* synthetic */ XMPushService c;

        public a(XMPushService xMPushService, com.xiaomi.push.service.ap.b bVar) {
            this.c = xMPushService;
            super(9);
            this.b = bVar;
        }

        public void a() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r9 = this;
            r0 = r9.c;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r0 = r0.f();	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            if (r0 != 0) goto L_0x000e;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
        L_0x0008:
            r0 = "trying bind while the connection is not created, quit!";	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            com.xiaomi.channel.commonutils.logger.b.d(r0);	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            return;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
        L_0x000e:
            r0 = com.xiaomi.push.service.ap.a();	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r1 = r9.b;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r1 = r1.h;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r2 = r9.b;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r2 = r2.b;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r0 = r0.b(r1, r2);	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            if (r0 != 0) goto L_0x003b;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
        L_0x0020:
            r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r1 = "ignore bind because the channel ";	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r0.<init>(r1);	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r1 = r9.b;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r1 = r1.h;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r0.append(r1);	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r1 = " is removed ";	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r0.append(r1);	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r0 = r0.toString();	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            com.xiaomi.channel.commonutils.logger.b.a(r0);	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            return;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
        L_0x003b:
            r1 = r0.m;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r2 = com.xiaomi.push.service.ap.c.unbind;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            if (r1 != r2) goto L_0x005a;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
        L_0x0041:
            r4 = com.xiaomi.push.service.ap.c.binding;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r5 = 0;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r6 = 0;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r7 = 0;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r8 = 0;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r3 = r0;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r3.a(r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r1 = r9.c;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r1 = r1.k;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r1.a(r0);	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r1 = r9.c;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            com.xiaomi.stats.h.a(r1, r0);	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            return;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
        L_0x005a:
            r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r2 = "trying duplicate bind, ingore! ";	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r1.<init>(r2);	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r0 = r0.m;	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r1.append(r0);	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            r0 = r1.toString();	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
            com.xiaomi.channel.commonutils.logger.b.a(r0);	 Catch:{ Exception -> 0x006e, Throwable -> 0x006d }
        L_0x006d:
            return;
        L_0x006e:
            r0 = move-exception;
            com.xiaomi.channel.commonutils.logger.b.a(r0);
            r1 = r9.c;
            r2 = 10;
            r1.a(r2, r0);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.a.a():void");
        }

        public String b() {
            StringBuilder stringBuilder = new StringBuilder("bind the client. ");
            stringBuilder.append(this.b.h);
            return stringBuilder.toString();
        }
    }

    static class b extends h {
        private final com.xiaomi.push.service.ap.b b;

        public b(com.xiaomi.push.service.ap.b bVar) {
            super(12);
            this.b = bVar;
        }

        public void a() {
            this.b.a(com.xiaomi.push.service.ap.c.unbind, 1, 21, null, null);
        }

        public String b() {
            StringBuilder stringBuilder = new StringBuilder("bind time out. chid=");
            stringBuilder.append(this.b.h);
            return stringBuilder.toString();
        }

        public boolean equals(Object obj) {
            return !(obj instanceof b) ? false : TextUtils.equals(((b) obj).b.h, this.b.h);
        }

        public int hashCode() {
            return this.b.h.hashCode();
        }
    }

    class c extends h {
        final /* synthetic */ XMPushService b;
        private com.xiaomi.slim.b c = null;

        public c(XMPushService xMPushService, com.xiaomi.slim.b bVar) {
            this.b = xMPushService;
            super(8);
            this.c = bVar;
        }

        public void a() {
            this.b.m.a(this.c);
        }

        public String b() {
            return "receive a message.";
        }
    }

    public class d extends h {
        final /* synthetic */ XMPushService b;

        d(XMPushService xMPushService) {
            this.b = xMPushService;
            super(1);
        }

        public void a() {
            if (this.b.b()) {
                this.b.o();
            } else {
                com.xiaomi.channel.commonutils.logger.b.a("should not connect. quit the job.");
            }
        }

        public String b() {
            return "do reconnect..";
        }
    }

    public class f extends h {
        public int b;
        public Exception c;
        final /* synthetic */ XMPushService d;

        f(XMPushService xMPushService, int i, Exception exception) {
            this.d = xMPushService;
            super(2);
            this.b = i;
            this.c = exception;
        }

        public void a() {
            this.d.a(this.b, this.c);
        }

        public String b() {
            return "disconnect the connection.";
        }
    }

    class g extends h {
        final /* synthetic */ XMPushService b;
        private Intent c = null;

        public g(XMPushService xMPushService, Intent intent) {
            this.b = xMPushService;
            super(15);
            this.c = intent;
        }

        public void a() {
            this.b.c(this.c);
        }

        public String b() {
            StringBuilder stringBuilder = new StringBuilder("Handle intent action = ");
            stringBuilder.append(this.c.getAction());
            return stringBuilder.toString();
        }
    }

    class i extends h {
        final /* synthetic */ XMPushService b;

        public i(XMPushService xMPushService) {
            this.b = xMPushService;
            super(5);
        }

        public void a() {
            this.b.n.b();
        }

        public String b() {
            return "ask the job queue to quit";
        }
    }

    class j extends h {
        final /* synthetic */ XMPushService b;
        private com.xiaomi.smack.packet.d c = null;

        public j(XMPushService xMPushService, com.xiaomi.smack.packet.d dVar) {
            this.b = xMPushService;
            super(8);
            this.c = dVar;
        }

        public void a() {
            this.b.m.a(this.c);
        }

        public String b() {
            return "receive a message.";
        }
    }

    class l extends h {
        boolean b;
        final /* synthetic */ XMPushService c;

        public l(XMPushService xMPushService, boolean z) {
            this.c = xMPushService;
            super(4);
            this.b = z;
        }

        public void a() {
            if (this.c.f()) {
                try {
                    if (!this.b) {
                        com.xiaomi.stats.h.a();
                    }
                    this.c.k.b(this.b);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    this.c.a(10, e);
                }
            }
        }

        public String b() {
            return "send ping..";
        }
    }

    class m extends h {
        com.xiaomi.push.service.ap.b b = null;
        final /* synthetic */ XMPushService c;

        public m(XMPushService xMPushService, com.xiaomi.push.service.ap.b bVar) {
            this.c = xMPushService;
            super(4);
            this.b = bVar;
        }

        public void a() {
            try {
                this.b.a(com.xiaomi.push.service.ap.c.unbind, 1, 16, null, null);
                this.c.k.a(this.b.h, this.b.b);
                this.b.a(com.xiaomi.push.service.ap.c.binding, 1, 16, null, null);
                this.c.k.a(this.b);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                this.c.a(10, e);
            }
        }

        public String b() {
            StringBuilder stringBuilder = new StringBuilder("rebind the client. ");
            stringBuilder.append(this.b.h);
            return stringBuilder.toString();
        }
    }

    class n extends h {
        final /* synthetic */ XMPushService b;

        n(XMPushService xMPushService) {
            this.b = xMPushService;
            super(3);
        }

        public void a() {
            this.b.a(11, null);
            if (this.b.b()) {
                this.b.o();
            }
        }

        public String b() {
            return "reset the connection.";
        }
    }

    class o extends h {
        com.xiaomi.push.service.ap.b b = null;
        int c;
        String d;
        String e;
        final /* synthetic */ XMPushService f;

        public o(XMPushService xMPushService, com.xiaomi.push.service.ap.b bVar, int i, String str, String str2) {
            this.f = xMPushService;
            super(9);
            this.b = bVar;
            this.c = i;
            this.d = str;
            this.e = str2;
        }

        public void a() {
            if (!(this.b.m == com.xiaomi.push.service.ap.c.unbind || this.f.k == null)) {
                try {
                    this.f.k.a(this.b.h, this.b.b);
                } catch (Exception e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    this.f.a(10, e);
                }
            }
            this.b.a(com.xiaomi.push.service.ap.c.unbind, this.c, 0, this.e, this.d);
        }

        public String b() {
            StringBuilder stringBuilder = new StringBuilder("unbind the channel. ");
            stringBuilder.append(this.b.h);
            return stringBuilder.toString();
        }
    }

    static {
        HostManager.addReservedHost("app.chat.xiaomi.net", "app.chat.xiaomi.net");
        HostManager.addReservedHost("app.chat.xiaomi.net", "42.62.94.2:443");
        HostManager.addReservedHost("app.chat.xiaomi.net", "114.54.23.2");
        HostManager.addReservedHost("app.chat.xiaomi.net", "111.13.142.2");
        HostManager.addReservedHost("app.chat.xiaomi.net", "111.206.200.2");
    }

    @TargetApi(11)
    public static Notification a(Context context) {
        Intent intent = new Intent(context, XMPushService.class);
        if (VERSION.SDK_INT >= 11) {
            Builder builder = new Builder(context);
            builder.setSmallIcon(context.getApplicationInfo().icon);
            builder.setContentTitle("Push Service");
            builder.setContentText("Push Service");
            builder.setContentIntent(PendingIntent.getActivity(context, 0, intent, 0));
            return builder.getNotification();
        }
        Notification notification = new Notification();
        notification.setLatestEventInfo(context, "Push Service", "Push Service", PendingIntent.getService(context, 0, intent, 0));
        return notification;
    }

    private com.xiaomi.smack.packet.d a(com.xiaomi.smack.packet.d dVar, String str, String str2) {
        StringBuilder stringBuilder;
        ap a = ap.a();
        List b = a.b(str);
        if (b.isEmpty()) {
            stringBuilder = new StringBuilder("open channel should be called first before sending a packet, pkg=");
        } else {
            dVar.o(str);
            str = dVar.l();
            if (TextUtils.isEmpty(str)) {
                str = (String) b.get(0);
                dVar.l(str);
            }
            com.xiaomi.push.service.ap.b b2 = a.b(str, dVar.n());
            if (f()) {
                if (b2 != null) {
                    if (b2.m == com.xiaomi.push.service.ap.c.binded) {
                        if (TextUtils.equals(str2, b2.j)) {
                            return dVar;
                        }
                        stringBuilder = new StringBuilder("invalid session. ");
                        stringBuilder.append(str2);
                        com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
                        return null;
                    }
                }
                stringBuilder = new StringBuilder("drop a packet as the channel is not opened, chid=");
            } else {
                stringBuilder = new StringBuilder("drop a packet as the channel is not connected, chid=");
            }
        }
        stringBuilder.append(str);
        com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
        return null;
    }

    private void a(Intent intent) {
        String stringExtra = intent.getStringExtra(as.y);
        String stringExtra2 = intent.getStringExtra(as.B);
        Bundle bundleExtra = intent.getBundleExtra("ext_packet");
        intent.getBooleanExtra("ext_encrypt", true);
        com.xiaomi.smack.packet.d dVar = (com.xiaomi.smack.packet.c) a(new com.xiaomi.smack.packet.c(bundleExtra), stringExtra, stringExtra2);
        if (dVar != null) {
            c(new ay(this, com.xiaomi.slim.b.a(dVar, ap.a().b(dVar.l(), dVar.n()).i)));
        }
    }

    private void a(String str, int i) {
        Collection<com.xiaomi.push.service.ap.b> c = ap.a().c(str);
        if (c != null) {
            for (com.xiaomi.push.service.ap.b bVar : c) {
                if (bVar != null) {
                    a(new o(this, bVar, i, null, null));
                }
            }
        }
        ap.a().a(str);
    }

    public static boolean a(int i, String str) {
        return (TextUtils.equals(str, "Enter") && i == 1) ? true : TextUtils.equals(str, "Leave") && i == 2;
    }

    private boolean a(String str, Intent intent) {
        com.xiaomi.push.service.ap.b b = ap.a().b(str, intent.getStringExtra(as.p));
        boolean z = false;
        if (b == null || str == null) {
            return false;
        }
        Object stringExtra = intent.getStringExtra(as.B);
        String stringExtra2 = intent.getStringExtra(as.u);
        if (!(TextUtils.isEmpty(b.j) || TextUtils.equals(stringExtra, b.j))) {
            StringBuilder stringBuilder = new StringBuilder("session changed. old session=");
            stringBuilder.append(b.j);
            stringBuilder.append(", new session=");
            stringBuilder.append(stringExtra);
            stringBuilder.append(" chid = ");
            stringBuilder.append(str);
            com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
            z = true;
        }
        if (stringExtra2.equals(b.i)) {
            return z;
        }
        StringBuilder stringBuilder2 = new StringBuilder("security changed. chid = ");
        stringBuilder2.append(str);
        stringBuilder2.append(" sechash = ");
        stringBuilder2.append(com.xiaomi.channel.commonutils.string.c.a(stringExtra2));
        com.xiaomi.channel.commonutils.logger.b.a(stringBuilder2.toString());
        return true;
    }

    private boolean a(String str, String str2, Context context) {
        if (TextUtils.equals("Leave", str) && !TextUtils.equals("Enter", h.a(context).c(str2))) {
            return false;
        }
        if (h.a(context).a(str2, str) != 0) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder("update geofence statue failed geo_id:");
        stringBuilder.append(str2);
        com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
        return false;
    }

    private com.xiaomi.push.service.ap.b b(String str, Intent intent) {
        com.xiaomi.push.service.ap.b b = ap.a().b(str, intent.getStringExtra(as.p));
        if (b == null) {
            b = new com.xiaomi.push.service.ap.b(this);
        }
        b.h = intent.getStringExtra(as.q);
        b.b = intent.getStringExtra(as.p);
        b.c = intent.getStringExtra(as.s);
        b.a = intent.getStringExtra(as.y);
        b.f = intent.getStringExtra(as.w);
        b.g = intent.getStringExtra(as.x);
        b.e = intent.getBooleanExtra(as.v, false);
        b.i = intent.getStringExtra(as.u);
        b.j = intent.getStringExtra(as.B);
        b.d = intent.getStringExtra(as.t);
        b.k = this.l;
        b.a((Messenger) intent.getParcelableExtra(as.F));
        b.l = getApplicationContext();
        ap.a().a(b);
        return b;
    }

    private void b(Intent intent) {
        String stringExtra = intent.getStringExtra(as.y);
        String stringExtra2 = intent.getStringExtra(as.B);
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("ext_packets");
        int i = 0;
        com.xiaomi.smack.packet.c[] cVarArr = new com.xiaomi.smack.packet.c[parcelableArrayExtra.length];
        intent.getBooleanExtra("ext_encrypt", true);
        int i2 = 0;
        while (i2 < parcelableArrayExtra.length) {
            cVarArr[i2] = new com.xiaomi.smack.packet.c((Bundle) parcelableArrayExtra[i2]);
            cVarArr[i2] = (com.xiaomi.smack.packet.c) a(cVarArr[i2], stringExtra, stringExtra2);
            if (cVarArr[i2] != null) {
                i2++;
            } else {
                return;
            }
        }
        ap a = ap.a();
        com.xiaomi.slim.b[] bVarArr = new com.xiaomi.slim.b[cVarArr.length];
        while (i < cVarArr.length) {
            com.xiaomi.smack.packet.d dVar = cVarArr[i];
            bVarArr[i] = com.xiaomi.slim.b.a(dVar, a.b(dVar.l(), dVar.n()).i);
            i++;
        }
        c(new d(this, bVarArr));
    }

    private void b(boolean z) {
        this.h = System.currentTimeMillis();
        if (f()) {
            if (!(this.k.p() || this.k.q())) {
                if (!com.xiaomi.channel.commonutils.network.d.e(this)) {
                    c(new f(this, 17, null));
                    a(true);
                    return;
                }
            }
            c(new l(this, z));
            return;
        }
        a(true);
    }

    private void c(android.content.Intent r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r0 = com.xiaomi.push.service.ap.a();
        r1 = com.xiaomi.push.service.as.d;
        r2 = r12.getAction();
        r1 = r1.equalsIgnoreCase(r2);
        r2 = 2;
        r3 = 1;
        r4 = 0;
        if (r1 != 0) goto L_0x05a9;
    L_0x0013:
        r1 = com.xiaomi.push.service.as.j;
        r5 = r12.getAction();
        r1 = r1.equalsIgnoreCase(r5);
        if (r1 == 0) goto L_0x0021;
    L_0x001f:
        goto L_0x05a9;
    L_0x0021:
        r1 = com.xiaomi.push.service.as.i;
        r5 = r12.getAction();
        r1 = r1.equalsIgnoreCase(r5);
        if (r1 == 0) goto L_0x0089;
    L_0x002d:
        r1 = com.xiaomi.push.service.as.y;
        r1 = r12.getStringExtra(r1);
        r3 = com.xiaomi.push.service.as.q;
        r5 = r12.getStringExtra(r3);
        r3 = com.xiaomi.push.service.as.p;
        r6 = r12.getStringExtra(r3);
        r12 = new java.lang.StringBuilder;
        r3 = "Service called closechannel chid = ";
        r12.<init>(r3);
        r12.append(r5);
        r3 = " userId = ";
        r12.append(r3);
        r12.append(r6);
        r12 = r12.toString();
        com.xiaomi.channel.commonutils.logger.b.a(r12);
        r12 = android.text.TextUtils.isEmpty(r5);
        if (r12 == 0) goto L_0x0077;
    L_0x005e:
        r12 = r0.b(r1);
        r12 = r12.iterator();
    L_0x0066:
        r0 = r12.hasNext();
        if (r0 == 0) goto L_0x0076;
    L_0x006c:
        r0 = r12.next();
        r0 = (java.lang.String) r0;
        r11.a(r0, r2);
        goto L_0x0066;
    L_0x0076:
        return;
    L_0x0077:
        r12 = android.text.TextUtils.isEmpty(r6);
        if (r12 == 0) goto L_0x0081;
    L_0x007d:
        r11.a(r5, r2);
        return;
    L_0x0081:
        r7 = 2;
        r8 = 0;
        r9 = 0;
        r4 = r11;
        r4.a(r5, r6, r7, r8, r9);
        return;
    L_0x0089:
        r1 = com.xiaomi.push.service.as.e;
        r5 = r12.getAction();
        r1 = r1.equalsIgnoreCase(r5);
        if (r1 == 0) goto L_0x0099;
    L_0x0095:
        r11.a(r12);
        return;
    L_0x0099:
        r1 = com.xiaomi.push.service.as.g;
        r5 = r12.getAction();
        r1 = r1.equalsIgnoreCase(r5);
        if (r1 == 0) goto L_0x00a9;
    L_0x00a5:
        r11.b(r12);
        return;
    L_0x00a9:
        r1 = com.xiaomi.push.service.as.f;
        r5 = r12.getAction();
        r1 = r1.equalsIgnoreCase(r5);
        if (r1 == 0) goto L_0x00ed;
    L_0x00b5:
        r1 = com.xiaomi.push.service.as.y;
        r1 = r12.getStringExtra(r1);
        r2 = com.xiaomi.push.service.as.B;
        r2 = r12.getStringExtra(r2);
        r3 = "ext_packet";
        r12 = r12.getBundleExtra(r3);
        r3 = new com.xiaomi.smack.packet.b;
        r3.<init>(r12);
        r12 = r11.a(r3, r1, r2);
        if (r12 == 0) goto L_0x00ec;
    L_0x00d2:
        r1 = r12.l();
        r2 = r12.n();
        r0 = r0.b(r1, r2);
        r0 = r0.i;
        r12 = com.xiaomi.slim.b.a(r12, r0);
        r0 = new com.xiaomi.push.service.ay;
        r0.<init>(r11, r12);
        r11.c(r0);
    L_0x00ec:
        return;
    L_0x00ed:
        r1 = com.xiaomi.push.service.as.h;
        r5 = r12.getAction();
        r1 = r1.equalsIgnoreCase(r5);
        if (r1 == 0) goto L_0x0131;
    L_0x00f9:
        r1 = com.xiaomi.push.service.as.y;
        r1 = r12.getStringExtra(r1);
        r2 = com.xiaomi.push.service.as.B;
        r2 = r12.getStringExtra(r2);
        r3 = "ext_packet";
        r12 = r12.getBundleExtra(r3);
        r3 = new com.xiaomi.smack.packet.f;
        r3.<init>(r12);
        r12 = r11.a(r3, r1, r2);
        if (r12 == 0) goto L_0x0130;
    L_0x0116:
        r1 = r12.l();
        r2 = r12.n();
        r0 = r0.b(r1, r2);
        r0 = r0.i;
        r12 = com.xiaomi.slim.b.a(r12, r0);
        r0 = new com.xiaomi.push.service.ay;
        r0.<init>(r11, r12);
        r11.c(r0);
    L_0x0130:
        return;
    L_0x0131:
        r1 = com.xiaomi.push.service.as.k;
        r5 = r12.getAction();
        r1 = r1.equals(r5);
        if (r1 == 0) goto L_0x0197;
    L_0x013d:
        r0 = com.xiaomi.push.service.as.q;
        r0 = r12.getStringExtra(r0);
        r1 = com.xiaomi.push.service.as.p;
        r1 = r12.getStringExtra(r1);
        if (r0 == 0) goto L_0x0196;
    L_0x014b:
        r2 = new java.lang.StringBuilder;
        r3 = "request reset connection from chid = ";
        r2.<init>(r3);
        r2.append(r0);
        r2 = r2.toString();
        com.xiaomi.channel.commonutils.logger.b.a(r2);
        r2 = com.xiaomi.push.service.ap.a();
        r0 = r2.b(r0, r1);
        if (r0 == 0) goto L_0x0196;
    L_0x0166:
        r1 = r0.i;
        r2 = com.xiaomi.push.service.as.u;
        r12 = r12.getStringExtra(r2);
        r12 = r1.equals(r12);
        if (r12 == 0) goto L_0x0196;
    L_0x0174:
        r12 = r0.m;
        r0 = com.xiaomi.push.service.ap.c.binded;
        if (r12 != r0) goto L_0x0196;
    L_0x017a:
        r12 = r11.h();
        if (r12 == 0) goto L_0x018e;
    L_0x0180:
        r0 = java.lang.System.currentTimeMillis();
        r2 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
        r4 = r0 - r2;
        r12 = r12.a(r4);
        if (r12 != 0) goto L_0x0196;
    L_0x018e:
        r12 = new com.xiaomi.push.service.XMPushService$n;
        r12.<init>(r11);
        r11.c(r12);
    L_0x0196:
        return;
    L_0x0197:
        r1 = com.xiaomi.push.service.as.l;
        r5 = r12.getAction();
        r1 = r1.equals(r5);
        r5 = 0;
        if (r1 == 0) goto L_0x0223;
    L_0x01a4:
        r1 = com.xiaomi.push.service.as.y;
        r1 = r12.getStringExtra(r1);
        r2 = r0.b(r1);
        r3 = r2.isEmpty();
        if (r3 == 0) goto L_0x01c6;
    L_0x01b4:
        r12 = new java.lang.StringBuilder;
        r0 = "open channel should be called first before update info, pkg=";
        r12.<init>(r0);
        r12.append(r1);
        r12 = r12.toString();
        com.xiaomi.channel.commonutils.logger.b.a(r12);
        return;
    L_0x01c6:
        r1 = com.xiaomi.push.service.as.q;
        r1 = r12.getStringExtra(r1);
        r3 = com.xiaomi.push.service.as.p;
        r3 = r12.getStringExtra(r3);
        r6 = android.text.TextUtils.isEmpty(r1);
        if (r6 == 0) goto L_0x01de;
    L_0x01d8:
        r1 = r2.get(r4);
        r1 = (java.lang.String) r1;
    L_0x01de:
        r2 = android.text.TextUtils.isEmpty(r3);
        if (r2 == 0) goto L_0x01fc;
    L_0x01e4:
        r0 = r0.c(r1);
        if (r0 == 0) goto L_0x0200;
    L_0x01ea:
        r1 = r0.isEmpty();
        if (r1 != 0) goto L_0x0200;
    L_0x01f0:
        r0 = r0.iterator();
        r0 = r0.next();
        r5 = r0;
        r5 = (com.xiaomi.push.service.ap.b) r5;
        goto L_0x0200;
    L_0x01fc:
        r5 = r0.b(r1, r3);
    L_0x0200:
        if (r5 == 0) goto L_0x0222;
    L_0x0202:
        r0 = com.xiaomi.push.service.as.w;
        r0 = r12.hasExtra(r0);
        if (r0 == 0) goto L_0x0212;
    L_0x020a:
        r0 = com.xiaomi.push.service.as.w;
        r0 = r12.getStringExtra(r0);
        r5.f = r0;
    L_0x0212:
        r0 = com.xiaomi.push.service.as.x;
        r0 = r12.hasExtra(r0);
        if (r0 == 0) goto L_0x0222;
    L_0x021a:
        r0 = com.xiaomi.push.service.as.x;
        r12 = r12.getStringExtra(r0);
        r5.g = r12;
    L_0x0222:
        return;
    L_0x0223:
        r0 = "com.xiaomi.mipush.REGISTER_APP";
        r1 = r12.getAction();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x02a1;
    L_0x022f:
        r0 = r11.getApplicationContext();
        r0 = com.xiaomi.push.service.au.a(r0);
        r0 = r0.a();
        if (r0 == 0) goto L_0x0263;
    L_0x023d:
        r0 = r11.getApplicationContext();
        r0 = com.xiaomi.push.service.au.a(r0);
        r0 = r0.b();
        if (r0 != 0) goto L_0x0263;
    L_0x024b:
        r0 = new java.lang.StringBuilder;
        r1 = "register without being provisioned. ";
        r0.<init>(r1);
        r1 = "mipush_app_package";
        r12 = r12.getStringExtra(r1);
        r0.append(r12);
        r12 = r0.toString();
        com.xiaomi.channel.commonutils.logger.b.a(r12);
        return;
    L_0x0263:
        r0 = "mipush_payload";
        r9 = r12.getByteArrayExtra(r0);
        r0 = "mipush_app_package";
        r10 = r12.getStringExtra(r0);
        r0 = "mipush_env_chanage";
        r0 = r12.getBooleanExtra(r0, r4);
        r1 = "mipush_env_type";
        r8 = r12.getIntExtra(r1, r3);
        r12 = com.xiaomi.push.service.u.a(r11);
        r12.g(r10);
        if (r0 == 0) goto L_0x029d;
    L_0x0284:
        r12 = "com.xiaomi.xmsf";
        r0 = r11.getPackageName();
        r12 = r12.equals(r0);
        if (r12 != 0) goto L_0x029d;
    L_0x0290:
        r12 = new com.xiaomi.push.service.br;
        r7 = 14;
        r5 = r12;
        r6 = r11;
        r5.<init>(r6, r7, r8, r9, r10);
        r11.c(r12);
        return;
    L_0x029d:
        r11.a(r9, r10);
        return;
    L_0x02a1:
        r0 = "com.xiaomi.mipush.SEND_MESSAGE";
        r1 = r12.getAction();
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x0580;
    L_0x02ad:
        r0 = "com.xiaomi.mipush.UNREGISTER_APP";
        r1 = r12.getAction();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x02bb;
    L_0x02b9:
        goto L_0x0580;
    L_0x02bb:
        r0 = com.xiaomi.push.service.av.a;
        r1 = r12.getAction();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0371;
    L_0x02c7:
        r0 = "uninstall_pkg_name";
        r12 = r12.getStringExtra(r0);
        if (r12 == 0) goto L_0x0370;
    L_0x02cf:
        r0 = r12.trim();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x02da;
    L_0x02d9:
        return;
    L_0x02da:
        r0 = r11.getPackageManager();	 Catch:{ NameNotFoundException -> 0x02e2 }
        r0.getPackageInfo(r12, r4);	 Catch:{ NameNotFoundException -> 0x02e2 }
        r3 = r4;
    L_0x02e2:
        r0 = "com.xiaomi.channel";
        r0 = r0.equals(r12);
        if (r0 == 0) goto L_0x0307;
    L_0x02ea:
        r0 = com.xiaomi.push.service.ap.a();
        r1 = "1";
        r0 = r0.c(r1);
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x0307;
    L_0x02fa:
        if (r3 == 0) goto L_0x0307;
    L_0x02fc:
        r12 = "1";
        r11.a(r12, r4);
        r12 = "close the miliao channel as the app is uninstalled.";
        com.xiaomi.channel.commonutils.logger.b.a(r12);
        return;
    L_0x0307:
        r0 = "pref_registered_pkg_names";
        r0 = r11.getSharedPreferences(r0, r4);
        r1 = r0.getString(r12, r5);
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 != 0) goto L_0x0370;
    L_0x0317:
        if (r3 == 0) goto L_0x0370;
    L_0x0319:
        r0 = r0.edit();
        r0.remove(r12);
        r0.commit();
        r0 = com.xiaomi.push.service.ah.e(r11, r12);
        if (r0 == 0) goto L_0x032c;
    L_0x0329:
        com.xiaomi.push.service.ah.d(r11, r12);
    L_0x032c:
        com.xiaomi.push.service.ah.b(r11, r12);
        r0 = r11.f();
        if (r0 == 0) goto L_0x0370;
    L_0x0335:
        if (r1 == 0) goto L_0x0370;
    L_0x0337:
        r0 = com.xiaomi.push.service.af.a(r12, r1);	 Catch:{ l -> 0x0355 }
        com.xiaomi.push.service.af.a(r11, r0);	 Catch:{ l -> 0x0355 }
        r0 = new java.lang.StringBuilder;	 Catch:{ l -> 0x0355 }
        r1 = "uninstall ";	 Catch:{ l -> 0x0355 }
        r0.<init>(r1);	 Catch:{ l -> 0x0355 }
        r0.append(r12);	 Catch:{ l -> 0x0355 }
        r12 = " msg sent";	 Catch:{ l -> 0x0355 }
        r0.append(r12);	 Catch:{ l -> 0x0355 }
        r12 = r0.toString();	 Catch:{ l -> 0x0355 }
        com.xiaomi.channel.commonutils.logger.b.a(r12);	 Catch:{ l -> 0x0355 }
        return;
    L_0x0355:
        r12 = move-exception;
        r0 = new java.lang.StringBuilder;
        r1 = "Fail to send Message: ";
        r0.<init>(r1);
        r1 = r12.getMessage();
        r0.append(r1);
        r0 = r0.toString();
        com.xiaomi.channel.commonutils.logger.b.d(r0);
        r0 = 10;
        r11.a(r0, r12);
    L_0x0370:
        return;
    L_0x0371:
        r0 = "com.xiaomi.mipush.CLEAR_NOTIFICATION";
        r1 = r12.getAction();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x03a7;
    L_0x037d:
        r0 = com.xiaomi.push.service.as.y;
        r0 = r12.getStringExtra(r0);
        r1 = com.xiaomi.push.service.as.z;
        r2 = -2;
        r1 = r12.getIntExtra(r1, r2);
        r2 = android.text.TextUtils.isEmpty(r0);
        if (r2 != 0) goto L_0x03a6;
    L_0x0390:
        r2 = -1;
        if (r1 < r2) goto L_0x0397;
    L_0x0393:
        com.xiaomi.push.service.ah.a(r11, r0, r1);
        return;
    L_0x0397:
        r1 = com.xiaomi.push.service.as.D;
        r1 = r12.getStringExtra(r1);
        r2 = com.xiaomi.push.service.as.E;
        r12 = r12.getStringExtra(r2);
        com.xiaomi.push.service.ah.a(r11, r0, r1, r12);
    L_0x03a6:
        return;
    L_0x03a7:
        r0 = "com.xiaomi.mipush.SET_NOTIFICATION_TYPE";
        r1 = r12.getAction();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0410;
    L_0x03b3:
        r0 = com.xiaomi.push.service.as.y;
        r0 = r12.getStringExtra(r0);
        r1 = com.xiaomi.push.service.as.C;
        r1 = r12.getStringExtra(r1);
        r2 = com.xiaomi.push.service.as.A;
        r2 = r12.hasExtra(r2);
        if (r2 == 0) goto L_0x03e2;
    L_0x03c7:
        r2 = com.xiaomi.push.service.as.A;
        r12 = r12.getIntExtra(r2, r4);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r0);
        r2.append(r12);
        r2 = r2.toString();
        r2 = com.xiaomi.channel.commonutils.string.c.b(r2);
        r3 = r4;
        goto L_0x03e7;
    L_0x03e2:
        r2 = com.xiaomi.channel.commonutils.string.c.b(r0);
        r12 = r4;
    L_0x03e7:
        r4 = android.text.TextUtils.isEmpty(r0);
        if (r4 != 0) goto L_0x03fe;
    L_0x03ed:
        r1 = android.text.TextUtils.equals(r1, r2);
        if (r1 != 0) goto L_0x03f4;
    L_0x03f3:
        goto L_0x03fe;
    L_0x03f4:
        if (r3 == 0) goto L_0x03fa;
    L_0x03f6:
        com.xiaomi.push.service.ah.d(r11, r0);
        return;
    L_0x03fa:
        com.xiaomi.push.service.ah.b(r11, r0, r12);
        return;
    L_0x03fe:
        r12 = new java.lang.StringBuilder;
        r1 = "invalid notification for ";
        r12.<init>(r1);
        r12.append(r0);
        r12 = r12.toString();
        com.xiaomi.channel.commonutils.logger.b.d(r12);
        return;
    L_0x0410:
        r0 = "com.xiaomi.mipush.DISABLE_PUSH";
        r1 = r12.getAction();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0473;
    L_0x041c:
        r0 = "mipush_app_package";
        r12 = r12.getStringExtra(r0);
        r0 = android.text.TextUtils.isEmpty(r12);
        if (r0 != 0) goto L_0x042f;
    L_0x0428:
        r0 = com.xiaomi.push.service.u.a(r11);
        r0.e(r12);
    L_0x042f:
        r12 = "com.xiaomi.xmsf";
        r0 = r11.getPackageName();
        r12 = r12.equals(r0);
        if (r12 != 0) goto L_0x0472;
    L_0x043b:
        r12 = r11.g;
        if (r12 == 0) goto L_0x0446;
    L_0x043f:
        r12 = r11.g;
        r11.unregisterReceiver(r12);
        r11.g = r5;
    L_0x0446:
        r12 = r11.n;
        r12.c();
        r12 = new com.xiaomi.push.service.bs;
        r12.<init>(r11, r2);
        r11.a(r12);
        r12 = com.xiaomi.push.service.ap.a();
        r12.e();
        r12 = com.xiaomi.push.service.ap.a();
        r12.a(r11, r4);
        r12 = com.xiaomi.push.service.ap.a();
        r12.d();
        r12 = com.xiaomi.push.service.az.a();
        r12.b();
        com.xiaomi.push.service.timers.a.a();
    L_0x0472:
        return;
    L_0x0473:
        r0 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
        r1 = r12.getAction();
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x04ff;
    L_0x047f:
        r0 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
        r1 = r12.getAction();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x048c;
    L_0x048b:
        goto L_0x04ff;
    L_0x048c:
        r0 = "com.xiaomi.mipush.SEND_TINYDATA";
        r1 = r12.getAction();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x04b9;
    L_0x0498:
        r0 = "mipush_app_package";
        r0 = r12.getStringExtra(r0);
        r1 = "mipush_payload";
        r12 = r12.getByteArrayExtra(r1);
        r1 = new com.xiaomi.xmpush.thrift.f;
        r1.<init>();
        com.xiaomi.xmpush.thrift.au.a(r1, r12);	 Catch:{ f -> 0x04b4 }
        r12 = com.xiaomi.tinyData.b.a(r11);	 Catch:{ f -> 0x04b4 }
        r12.a(r1, r0);	 Catch:{ f -> 0x04b4 }
        return;
    L_0x04b4:
        r12 = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(r12);
        return;
    L_0x04b9:
        r0 = "com.xiaomi.push.timer";
        r1 = r12.getAction();
        r0 = r0.equalsIgnoreCase(r1);
        if (r0 == 0) goto L_0x04d4;
    L_0x04c5:
        r12 = "Service called on timer";
        com.xiaomi.channel.commonutils.logger.b.a(r12);
        r12 = r11.l();
        if (r12 == 0) goto L_0x04fe;
    L_0x04d0:
        r11.b(r4);
        return;
    L_0x04d4:
        r0 = "com.xiaomi.push.check_alive";
        r1 = r12.getAction();
        r0 = r0.equalsIgnoreCase(r1);
        if (r0 == 0) goto L_0x04ef;
    L_0x04e0:
        r12 = "Service called on check alive.";
        com.xiaomi.channel.commonutils.logger.b.a(r12);
        r12 = r11.l();
        if (r12 == 0) goto L_0x04fe;
    L_0x04eb:
        r11.b(r4);
        return;
    L_0x04ef:
        r0 = "android.net.conn.CONNECTIVITY_CHANGE";
        r12 = r12.getAction();
        r12 = r0.equals(r12);
        if (r12 == 0) goto L_0x04fe;
    L_0x04fb:
        r11.k();
    L_0x04fe:
        return;
    L_0x04ff:
        r0 = "mipush_app_package";
        r3 = r12.getStringExtra(r0);
        r0 = "mipush_payload";
        r6 = r12.getByteArrayExtra(r0);
        r0 = "mipush_app_id";
        r4 = r12.getStringExtra(r0);
        r0 = "mipush_app_token";
        r5 = r12.getStringExtra(r0);
        r0 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
        r1 = r12.getAction();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x052a;
    L_0x0523:
        r0 = com.xiaomi.push.service.u.a(r11);
        r0.f(r3);
    L_0x052a:
        r0 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
        r1 = r12.getAction();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0544;
    L_0x0536:
        r0 = com.xiaomi.push.service.u.a(r11);
        r0.h(r3);
        r0 = com.xiaomi.push.service.u.a(r11);
        r0.i(r3);
    L_0x0544:
        if (r6 != 0) goto L_0x054f;
    L_0x0546:
        r12 = 70000003; // 0x42c1d83 float:2.0232054E-36 double:3.45845967E-316;
        r0 = "null payload";
        com.xiaomi.push.service.w.a(r11, r3, r6, r12, r0);
        return;
    L_0x054f:
        com.xiaomi.push.service.w.b(r3, r6);
        r0 = new com.xiaomi.push.service.v;
        r1 = r0;
        r2 = r11;
        r1.<init>(r2, r3, r4, r5, r6);
        r11.a(r0);
        r0 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
        r12 = r12.getAction();
        r12 = r0.equals(r12);
        if (r12 == 0) goto L_0x057f;
    L_0x0568:
        r12 = r11.g;
        if (r12 != 0) goto L_0x057f;
    L_0x056c:
        r12 = new com.xiaomi.push.service.XMPushService$e;
        r12.<init>(r11);
        r11.g = r12;
        r12 = new android.content.IntentFilter;
        r0 = "android.net.conn.CONNECTIVITY_CHANGE";
        r12.<init>(r0);
        r0 = r11.g;
        r11.registerReceiver(r0, r12);
    L_0x057f:
        return;
    L_0x0580:
        r0 = "mipush_app_package";
        r0 = r12.getStringExtra(r0);
        r1 = "mipush_payload";
        r1 = r12.getByteArrayExtra(r1);
        r2 = "com.xiaomi.mipush.MESSAGE_CACHE";
        r2 = r12.getBooleanExtra(r2, r3);
        r3 = "com.xiaomi.mipush.UNREGISTER_APP";
        r12 = r12.getAction();
        r12 = r3.equals(r12);
        if (r12 == 0) goto L_0x05a5;
    L_0x059e:
        r12 = com.xiaomi.push.service.u.a(r11);
        r12.d(r0);
    L_0x05a5:
        r11.a(r0, r1, r2);
        return;
    L_0x05a9:
        r0 = com.xiaomi.push.service.as.q;
        r0 = r12.getStringExtra(r0);
        r1 = com.xiaomi.push.service.as.u;
        r1 = r12.getStringExtra(r1);
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 == 0) goto L_0x05c1;
    L_0x05bb:
        r12 = "security is empty. ignore.";
        com.xiaomi.channel.commonutils.logger.b.a(r12);
        return;
    L_0x05c1:
        if (r0 == 0) goto L_0x0629;
    L_0x05c3:
        r1 = r11.a(r0, r12);
        r7 = r11.b(r0, r12);
        r12 = com.xiaomi.channel.commonutils.network.d.c(r11);
        if (r12 != 0) goto L_0x05db;
    L_0x05d1:
        r5 = r11.l;
        r8 = 0;
        r9 = 2;
        r10 = 0;
        r6 = r11;
        r5.a(r6, r7, r8, r9, r10);
        return;
    L_0x05db:
        r12 = r11.f();
        if (r12 == 0) goto L_0x0625;
    L_0x05e1:
        r12 = r7.m;
        r0 = com.xiaomi.push.service.ap.c.unbind;
        if (r12 != r0) goto L_0x05f0;
    L_0x05e7:
        r12 = new com.xiaomi.push.service.XMPushService$a;
        r12.<init>(r11, r7);
        r11.c(r12);
        return;
    L_0x05f0:
        if (r1 == 0) goto L_0x05fb;
    L_0x05f2:
        r12 = new com.xiaomi.push.service.XMPushService$m;
        r12.<init>(r11, r7);
        r11.c(r12);
        return;
    L_0x05fb:
        r12 = r7.m;
        r0 = com.xiaomi.push.service.ap.c.binding;
        if (r12 != r0) goto L_0x0615;
    L_0x0601:
        r12 = "the client is binding. %1$s %2$s.";
        r0 = new java.lang.Object[r2];
        r1 = r7.h;
        r0[r4] = r1;
        r1 = r7.b;
        r0[r3] = r1;
        r12 = java.lang.String.format(r12, r0);
        com.xiaomi.channel.commonutils.logger.b.a(r12);
        return;
    L_0x0615:
        r12 = r7.m;
        r0 = com.xiaomi.push.service.ap.c.binded;
        if (r12 != r0) goto L_0x0628;
    L_0x061b:
        r5 = r11.l;
        r8 = 1;
        r9 = 0;
        r10 = 0;
        r6 = r11;
        r5.a(r6, r7, r8, r9, r10);
        return;
    L_0x0625:
        r11.a(r3);
    L_0x0628:
        return;
    L_0x0629:
        r12 = "channel id is empty, do nothing!";
        com.xiaomi.channel.commonutils.logger.b.d(r12);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.c(android.content.Intent):void");
    }

    private void c(h hVar) {
        this.n.a((com.xiaomi.push.service.l.b) hVar);
    }

    private void c(boolean z) {
        try {
            if (com.xiaomi.channel.commonutils.android.h.d()) {
                if (z) {
                    sendBroadcast(new Intent("miui.intent.action.NETWORK_CONNECTED"));
                    return;
                }
                sendBroadcast(new Intent("miui.intent.action.NETWORK_BLOCKED"));
            }
        } catch (Throwable e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    private void k() {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null) {
            StringBuilder stringBuilder = new StringBuilder("network changed, ");
            stringBuilder.append(activeNetworkInfo.toString());
            com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
            State state = activeNetworkInfo.getState();
            if (state == State.SUSPENDED || state == State.UNKNOWN) {
                return;
            }
        }
        com.xiaomi.channel.commonutils.logger.b.a("network changed, no active network");
        if (com.xiaomi.stats.f.b() != null) {
            com.xiaomi.stats.f.b().b();
        }
        com.xiaomi.smack.util.g.a((Context) this);
        this.j.r();
        if (com.xiaomi.channel.commonutils.network.d.c(this)) {
            if (f() && l()) {
                b(false);
            }
            if (!(f() || g())) {
                this.n.b(1);
                a(new d(this));
            }
            com.xiaomi.push.log.b.a((Context) this).a();
        } else {
            a(new f(this, 2, null));
        }
        n();
    }

    private boolean l() {
        return System.currentTimeMillis() - this.h < StatisticConfig.MIN_UPLOAD_INTERVAL ? false : com.xiaomi.channel.commonutils.network.d.d(this);
    }

    private boolean m() {
        if (!"com.xiaomi.xmsf".equals(getPackageName())) {
            if (u.a((Context) this).b(getPackageName())) {
                return false;
            }
        }
        return true;
    }

    private void n() {
        if (!b()) {
            com.xiaomi.push.service.timers.a.a();
        } else if (!com.xiaomi.push.service.timers.a.b()) {
            com.xiaomi.push.service.timers.a.a(true);
        }
    }

    private void o() {
        String str;
        if (this.k != null && this.k.k()) {
            str = "try to connect while connecting.";
        } else if (this.k == null || !this.k.l()) {
            this.d.b(com.xiaomi.channel.commonutils.network.d.k(this));
            p();
            if (this.k == null) {
                ap.a().a((Context) this);
                c(false);
            }
            return;
        } else {
            str = "try to connect while is connected.";
        }
        com.xiaomi.channel.commonutils.logger.b.d(str);
    }

    private void p() {
        try {
            this.j.a(this.p, new bj(this));
            this.j.t();
            this.k = this.j;
        } catch (Throwable e) {
            com.xiaomi.channel.commonutils.logger.b.a("fail to create Slim connection", e);
            this.j.b(3, e);
        }
    }

    private boolean q() {
        return TextUtils.equals(getPackageName(), "com.xiaomi.xmsf") ? false : am.a(this).a(com.xiaomi.xmpush.thrift.g.H.a(), false);
    }

    private void r() {
        if (VERSION.SDK_INT < 18) {
            startForeground(i, new Notification());
        } else {
            bindService(new Intent(this, XMJobService.class), new bk(this), 1);
        }
    }

    private void s() {
        synchronized (this.o) {
            this.o.clear();
        }
    }

    void a() {
        if (System.currentTimeMillis() - this.h >= ((long) com.xiaomi.smack.g.c()) && com.xiaomi.channel.commonutils.network.d.d(this)) {
            b(true);
        }
    }

    public void a(int i) {
        this.n.b(i);
    }

    public void a(int i, Exception exception) {
        StringBuilder stringBuilder = new StringBuilder("disconnect ");
        stringBuilder.append(hashCode());
        stringBuilder.append(", ");
        stringBuilder.append(this.k == null ? null : Integer.valueOf(this.k.hashCode()));
        com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
        if (this.k != null) {
            this.k.b(i, exception);
            this.k = null;
        }
        a(7);
        a(4);
        ap.a().a((Context) this, i);
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.xiaomi.metoknlp.geofencing.state_change_protected");
        registerReceiver(broadcastReceiver, intentFilter, "com.xiaomi.metoknlp.permission.NOTIFY_FENCE_STATE", null);
    }

    public void a(h hVar) {
        a(hVar, 0);
    }

    public void a(com.xiaomi.push.service.XMPushService.h r2, long r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.n;	 Catch:{ IllegalStateException -> 0x0005 }
        r0.a(r2, r3);	 Catch:{ IllegalStateException -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.a(com.xiaomi.push.service.XMPushService$h, long):void");
    }

    public void a(k kVar) {
        synchronized (this.o) {
            this.o.add(kVar);
        }
    }

    public void a(com.xiaomi.push.service.ap.b bVar) {
        if (bVar != null) {
            long b = bVar.b();
            StringBuilder stringBuilder = new StringBuilder("schedule rebind job in ");
            stringBuilder.append(b / 1000);
            com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
            a(new a(this, bVar), b);
        }
    }

    public void a(com.xiaomi.slim.b bVar) {
        if (this.k != null) {
            this.k.b(bVar);
            return;
        }
        throw new com.xiaomi.smack.l("try send msg while connection is null.");
    }

    public void a(com.xiaomi.smack.a aVar) {
        com.xiaomi.stats.f.b().a(aVar);
        c(true);
        this.e.a();
        Iterator it = ap.a().b().iterator();
        while (it.hasNext()) {
            a(new a(this, (com.xiaomi.push.service.ap.b) it.next()));
        }
    }

    public void a(com.xiaomi.smack.a aVar, int i, Exception exception) {
        com.xiaomi.stats.f.b().a(aVar, i, exception);
        a(false);
    }

    public void a(com.xiaomi.smack.a aVar, Exception exception) {
        com.xiaomi.stats.f.b().a(aVar, exception);
        c(false);
        a(false);
    }

    public void a(String str, String str2, int i, String str3, String str4) {
        com.xiaomi.push.service.ap.b b = ap.a().b(str, str2);
        if (b != null) {
            a(new o(this, b, i, str4, str3));
        }
        ap.a().a(str, str2);
    }

    void a(String str, byte[] bArr, boolean z) {
        Collection c = ap.a().c("5");
        if (c.isEmpty()) {
            if (z) {
                w.b(str, bArr);
            }
        } else if (((com.xiaomi.push.service.ap.b) c.iterator().next()).m == com.xiaomi.push.service.ap.c.binded) {
            c(new bt(this, 4, str, bArr));
        } else if (z) {
            w.b(str, bArr);
        }
    }

    public void a(boolean z) {
        this.e.a(z);
    }

    public void a(byte[] bArr, String str) {
        if (bArr == null) {
            w.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "null payload");
            com.xiaomi.channel.commonutils.logger.b.a("register request without payload");
            return;
        }
        af afVar = new af();
        try {
            au.a(afVar, bArr);
            if (afVar.a == com.xiaomi.xmpush.thrift.a.a) {
                aj ajVar = new aj();
                try {
                    au.a(ajVar, afVar.f());
                    w.a(afVar.j(), bArr);
                    a(new v(this, afVar.j(), ajVar.d(), ajVar.h(), bArr));
                    return;
                } catch (Throwable e) {
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    w.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data action error.");
                    return;
                }
            }
            w.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " registration action required.");
            com.xiaomi.channel.commonutils.logger.b.a("register request with invalid payload");
        } catch (Throwable e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            w.a(this, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, " data container error.");
        }
    }

    public void a(com.xiaomi.slim.b[] bVarArr) {
        if (this.k != null) {
            this.k.a(bVarArr);
            return;
        }
        throw new com.xiaomi.smack.l("try send msg while connection is null.");
    }

    public void b(h hVar) {
        this.n.a(hVar.a, (com.xiaomi.push.service.l.b) hVar);
    }

    public void b(com.xiaomi.smack.a aVar) {
        com.xiaomi.channel.commonutils.logger.b.c("begin to connect...");
        com.xiaomi.stats.f.b().b(aVar);
    }

    public boolean b() {
        return com.xiaomi.channel.commonutils.network.d.c(this) && ap.a().c() > 0 && !c() && m();
    }

    public boolean b(int i) {
        return this.n.a(i);
    }

    public boolean c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = "miui.os.Build";	 Catch:{ Throwable -> 0x002f }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x002f }
        r2 = "IS_CM_CUSTOMIZATION_TEST";	 Catch:{ Throwable -> 0x002f }
        r2 = r1.getField(r2);	 Catch:{ Throwable -> 0x002f }
        r3 = "IS_CU_CUSTOMIZATION_TEST";	 Catch:{ Throwable -> 0x002f }
        r3 = r1.getField(r3);	 Catch:{ Throwable -> 0x002f }
        r4 = "IS_CT_CUSTOMIZATION_TEST";	 Catch:{ Throwable -> 0x002f }
        r1 = r1.getField(r4);	 Catch:{ Throwable -> 0x002f }
        r4 = 0;	 Catch:{ Throwable -> 0x002f }
        r2 = r2.getBoolean(r4);	 Catch:{ Throwable -> 0x002f }
        if (r2 != 0) goto L_0x002e;	 Catch:{ Throwable -> 0x002f }
    L_0x0020:
        r2 = r3.getBoolean(r4);	 Catch:{ Throwable -> 0x002f }
        if (r2 != 0) goto L_0x002e;	 Catch:{ Throwable -> 0x002f }
    L_0x0026:
        r1 = r1.getBoolean(r4);	 Catch:{ Throwable -> 0x002f }
        if (r1 == 0) goto L_0x002d;
    L_0x002c:
        goto L_0x002e;
    L_0x002d:
        return r0;
    L_0x002e:
        r0 = 1;
    L_0x002f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.XMPushService.c():boolean");
    }

    public e d() {
        return new e();
    }

    public e e() {
        return this.l;
    }

    public boolean f() {
        return this.k != null && this.k.l();
    }

    public boolean g() {
        return this.k != null && this.k.k();
    }

    public com.xiaomi.smack.a h() {
        return this.k;
    }

    void i() {
        Iterator it = new ArrayList(this.o).iterator();
        while (it.hasNext()) {
            ((k) it.next()).a();
        }
    }

    public IBinder onBind(Intent intent) {
        return this.a.getBinder();
    }

    public void onCreate() {
        super.onCreate();
        com.xiaomi.channel.commonutils.android.h.a(this);
        s a = t.a(this);
        if (a != null) {
            com.xiaomi.channel.commonutils.misc.a.a(a.g);
        }
        Object a2 = a.a(getApplicationContext()).a();
        if (TextUtils.isEmpty(a2)) {
            this.f = PushChannelRegion.China.name();
        } else {
            this.f = a2;
            if (PushChannelRegion.Global.name().equals(this.f)) {
                com.xiaomi.smack.b.a("app.chat.global.xiaomi.net");
            }
        }
        this.a = new Messenger(new bl(this));
        at.a(this);
        this.d = new bm(this, null, 5222, "xiaomi.com", null);
        this.d.a(true);
        this.j = new com.xiaomi.slim.f(this, this.d);
        this.l = d();
        try {
            if (com.xiaomi.channel.commonutils.android.h.d()) {
                this.l.a((Context) this);
            }
        } catch (Throwable e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
        com.xiaomi.push.service.timers.a.a((Context) this);
        this.j.a((com.xiaomi.smack.d) this);
        this.m = new PacketSync(this);
        this.e = new ax(this);
        new f().a();
        com.xiaomi.stats.f.a().a(this);
        this.n = new l("Connection Controller Thread");
        if (m()) {
            a(new bn(this, 11));
        }
        ap a3 = ap.a();
        a3.e();
        a3.a(new bo(this));
        if (m()) {
            this.g = new e(this);
            registerReceiver(this.g, new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
        }
        if (q()) {
            r();
        }
        com.xiaomi.tinyData.b.a(this).a(new n(this), "UPLOADER_PUSH_CHANNEL");
        a(this.b);
        com.xiaomi.channel.commonutils.misc.h.a(this).a(new g(this), 86400);
        a(new com.xiaomi.tinyData.a(this));
        StringBuilder stringBuilder = new StringBuilder("XMPushService created pid = ");
        stringBuilder.append(i);
        com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
    }

    public void onDestroy() {
        if (this.g != null) {
            unregisterReceiver(this.g);
        }
        unregisterReceiver(this.b);
        this.n.c();
        a(new bi(this, 2));
        a(new i(this));
        ap.a().e();
        ap.a().a((Context) this, 15);
        ap.a().d();
        this.j.b((com.xiaomi.smack.d) this);
        az.a().b();
        com.xiaomi.push.service.timers.a.a();
        s();
        super.onDestroy();
        com.xiaomi.channel.commonutils.logger.b.a("Service destroyed");
    }

    public void onStart(Intent intent, int i) {
        if (intent == null) {
            com.xiaomi.channel.commonutils.logger.b.d("onStart() with intent NULL");
        } else {
            com.xiaomi.channel.commonutils.logger.b.c(String.format("onStart() with intent.Action = %s, chid = %s", new Object[]{intent.getAction(), intent.getStringExtra(as.q)}));
        }
        if (!(intent == null || intent.getAction() == null)) {
            if (!"com.xiaomi.push.timer".equalsIgnoreCase(intent.getAction())) {
                if (!"com.xiaomi.push.check_alive".equalsIgnoreCase(intent.getAction())) {
                    if (!"com.xiaomi.push.network_status_changed".equalsIgnoreCase(intent.getAction())) {
                        a(new g(this, intent));
                        return;
                    }
                }
            }
            if (this.n.d()) {
                com.xiaomi.channel.commonutils.logger.b.d("ERROR, the job controller is blocked.");
                ap.a().a((Context) this, 14);
                stopSelf();
                return;
            }
            a(new g(this, intent));
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        onStart(intent, i2);
        return c;
    }
}
