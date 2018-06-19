package com.xunlei.download.proguard;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.umeng.message.entity.UMessage;
import com.xunlei.download.DownloadManager;
import com.xunlei.download.Downloads.Impl;
import java.util.Collection;
import java.util.HashMap;

/* compiled from: DownloadNotifier */
public class e {
    private static final int a = 1;
    private static final int b = 2;
    private static final int c = 3;
    private static final int d = 4;
    private final Context e;
    private final NotificationManager f;
    private final boolean g;
    private final HashMap<String, Long> h = new HashMap();
    private final b i = new b();
    private final b j = new b();

    /* compiled from: DownloadNotifier */
    public static class a {
        private Context a;
        private long b = System.currentTimeMillis();
        private int c;
        private int d;
        private int e;
        private PendingIntent f;
        private RemoteViews g;
        private PendingIntent h;
        private CharSequence i;
        private int j = -1;
        private long[] k;
        private int l;
        private int m;
        private int n;
        private int o;
        private int p;

        public a(Context context) {
            this.a = context;
        }

        public a a(long j) {
            this.b = j;
            return this;
        }

        public a a(int i) {
            this.c = i;
            return this;
        }

        public a a(int i, int i2) {
            this.c = i;
            this.d = i2;
            return this;
        }

        public a a(RemoteViews remoteViews) {
            this.g = remoteViews;
            return this;
        }

        public a a(PendingIntent pendingIntent) {
            this.f = pendingIntent;
            return this;
        }

        public a b(PendingIntent pendingIntent) {
            this.h = pendingIntent;
            return this;
        }

        public a a(boolean z) {
            a(2, z);
            return this;
        }

        public a b(boolean z) {
            a(16, z);
            return this;
        }

        private void a(int i, boolean z) {
            if (z) {
                this.p = i | this.p;
                return;
            }
            this.p = (i ^ -1) & this.p;
        }

        public Notification a() {
            Notification notification = new Notification();
            notification.when = this.b;
            notification.icon = this.c;
            notification.iconLevel = this.d;
            notification.number = this.e;
            notification.contentView = this.g;
            notification.contentIntent = this.f;
            notification.deleteIntent = this.h;
            notification.tickerText = this.i;
            notification.audioStreamType = this.j;
            notification.vibrate = this.k;
            notification.ledARGB = this.l;
            notification.ledOnMS = this.m;
            notification.ledOffMS = this.n;
            notification.defaults = this.o;
            notification.flags = this.p;
            if (!(this.m == 0 && this.n == 0)) {
                notification.flags |= 1;
            }
            if ((this.o & 4) != 0) {
                notification.flags |= 1;
            }
            return notification;
        }
    }

    /* compiled from: DownloadNotifier */
    static class b {

        /* compiled from: DownloadNotifier */
        static class a {
            static int a;

            a() {
            }
        }

        /* compiled from: DownloadNotifier */
        static class b {
            static int a;
            static int b;
            static int c;
            static int d;
            static int e;
            static int f;
            static int g;

            b() {
            }
        }

        /* compiled from: DownloadNotifier */
        static class c {
            static int a;

            c() {
            }
        }

        /* compiled from: DownloadNotifier */
        static class d {
            static int a;
            static int b;
            static int c;
            static int d;
            static int e;
            static int f;
            static int g;
            static int h;
            static int i;
            static int j;
            static int k;

            d() {
            }
        }

        b() {
        }

        static void a(Context context) {
            a.a = ah.a(context).a("xl_small");
            c.a = ah.a(context).b("xl_notification");
            d.a = ah.a(context).d("download_remaining");
            d.b = ah.a(context).d("notif_text_engine_on");
            d.c = ah.a(context).d("notif_text_engine_off");
            d.d = ah.a(context).d("notification_need_wifi_for_size");
            d.e = ah.a(context).d("paused_waiting_for_network");
            d.f = ah.a(context).d("notification_download_failed");
            d.g = ah.a(context).d("notification_download_complete");
            d.h = ah.a(context).d("notif_title_file_size");
            d.i = ah.a(context).d("notif_title_multiple_downloading");
            d.j = ah.a(context).d("notif_title_single_downloading");
            d.k = ah.a(context).d("download_unknown_title");
            b.a = ah.a(context).c("time");
            b.b = ah.a(context).c("icon");
            b.c = ah.a(context).c(NotificationCompat.CATEGORY_PROGRESS);
            b.d = ah.a(context).c("title");
            b.e = ah.a(context).c("text");
            b.f = ah.a(context).c("text_icon");
            b.g = ah.a(context).c("info");
        }
    }

    private CharSequence a(long j) {
        return null;
    }

    private static boolean d(d dVar) {
        return false;
    }

    public e(Context context) {
        this.e = context;
        this.f = (NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
        this.g = ad.a(this.e, DownloadManager.KEY_SHOW_NOTIFY, true);
        b.a(this.e);
    }

    public void a() {
        this.f.cancelAll();
    }

    public void a(long j, long j2) {
        synchronized (this.i) {
            if (j2 != 0) {
                this.i.b(j, j2);
                this.j.b(j, SystemClock.elapsedRealtime());
            } else {
                this.i.b(j);
                this.j.b(j);
            }
        }
    }

    public void a(Collection<d> collection) {
        synchronized (this.h) {
            b((Collection) collection);
        }
    }

    private void b(java.util.Collection<com.xunlei.download.proguard.d> r31) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r30 = this;
        r1 = r30;
        r2 = r1.g;
        if (r2 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r2 = r1.e;
        r2 = r2.getResources();
        r3 = new java.util.HashMap;
        r3.<init>();
        r4 = r31.iterator();
    L_0x0016:
        r5 = r4.hasNext();
        if (r5 == 0) goto L_0x0040;
    L_0x001c:
        r5 = r4.next();
        r5 = (com.xunlei.download.proguard.d) r5;
        r6 = r1.a(r5);
        if (r6 == 0) goto L_0x0016;
    L_0x0028:
        r7 = r3.get(r6);
        r7 = (java.util.ArrayList) r7;
        if (r7 == 0) goto L_0x0034;
    L_0x0030:
        r7.add(r5);
        goto L_0x0016;
    L_0x0034:
        r7 = new java.util.ArrayList;
        r7.<init>();
        r7.add(r5);
        r3.put(r6, r7);
        goto L_0x0016;
    L_0x0040:
        r4 = r3.keySet();
        r4 = r4.iterator();
    L_0x0048:
        r5 = r4.hasNext();
        if (r5 == 0) goto L_0x03a9;
    L_0x004e:
        r5 = r4.next();
        r5 = (java.lang.String) r5;
        r7 = a(r5);
        r8 = r3.get(r5);
        r8 = (java.util.Collection) r8;
        r9 = r8.iterator();
        r9 = r9.next();
        r9 = (com.xunlei.download.proguard.d) r9;
        r10 = r8.iterator();
    L_0x006c:
        r11 = r10.hasNext();
        if (r11 == 0) goto L_0x007e;
    L_0x0072:
        r11 = r10.next();
        r11 = (com.xunlei.download.proguard.d) r11;
        r11 = r11.J;
        if (r11 == 0) goto L_0x006c;
    L_0x007c:
        r10 = 1;
        goto L_0x007f;
    L_0x007e:
        r10 = 0;
    L_0x007f:
        r11 = new com.xunlei.download.proguard.e$a;
        r13 = r1.e;
        r11.<init>(r13);
        r13 = com.xunlei.download.proguard.e.b.a.a;
        r11.a(r13);
        r13 = new android.widget.RemoteViews;
        r14 = r1.e;
        r14 = r14.getPackageName();
        r15 = com.xunlei.download.proguard.e.b.c.a;
        r13.<init>(r14, r15);
        r14 = r1.h;
        r14 = r14.containsKey(r5);
        if (r14 == 0) goto L_0x00ad;
    L_0x00a0:
        r14 = r1.h;
        r14 = r14.get(r5);
        r14 = (java.lang.Long) r14;
        r14 = r14.longValue();
        goto L_0x00ba;
    L_0x00ad:
        r14 = java.lang.System.currentTimeMillis();
        r6 = r1.h;
        r12 = java.lang.Long.valueOf(r14);
        r6.put(r5, r12);
    L_0x00ba:
        r6 = com.xunlei.download.proguard.e.b.b.a;
        r12 = "setTime";
        r13.setLong(r6, r12, r14);
        r6 = r1.e;
        r12 = r9.p;
        r6 = com.xunlei.download.proguard.ab.a(r6, r12);
        if (r6 == 0) goto L_0x00d0;
    L_0x00cb:
        r12 = com.xunlei.download.proguard.e.b.b.b;
        r13.setImageViewBitmap(r12, r6);
    L_0x00d0:
        r11.a(r14);
        r14 = 3;
        r15 = 2;
        r6 = 1;
        if (r7 == r6) goto L_0x0146;
    L_0x00d8:
        if (r7 != r15) goto L_0x00db;
    L_0x00da:
        goto L_0x0146;
    L_0x00db:
        if (r7 != r14) goto L_0x013c;
    L_0x00dd:
        r14 = r1.e;
        r14 = com.xunlei.download.DownloadManager.getInstanceFor(r14);
        r16 = r13;
        r12 = r9.c;
        r12 = r14.getDownloadUri(r12);
        r11.b(r6);
        r6 = r9.l;
        r6 = com.xunlei.download.Downloads.Impl.isStatusError(r6);
        if (r6 != 0) goto L_0x0106;
    L_0x00f6:
        r6 = r9.i;
        r13 = 5;
        if (r6 == r13) goto L_0x0106;
    L_0x00fb:
        r6 = r9.l;
        r6 = com.xunlei.download.Downloads.Impl.isStatusSuccess(r6);
        if (r6 == 0) goto L_0x0106;
    L_0x0103:
        r6 = "android.intent.action.DOWNLOAD_OPEN";
        goto L_0x0108;
    L_0x0106:
        r6 = "android.intent.action.DOWNLOAD_LIST";
    L_0x0108:
        r13 = new android.content.Intent;
        r14 = r1.e;
        r15 = com.android.providers.downloads.DownloadReceiver.class;
        r13.<init>(r6, r12, r14, r15);
        r6 = "extra_click_download_ids";
        r14 = r1.c(r8);
        r13.putExtra(r6, r14);
        r6 = r1.e;
        r14 = 0;
        r15 = 134217728; // 0x8000000 float:3.85186E-34 double:6.63123685E-316;
        r6 = android.app.PendingIntent.getBroadcast(r6, r14, r13, r15);
        r11.a(r6);
        r6 = new android.content.Intent;
        r13 = "android.intent.action.DOWNLOAD_HIDE";
        r15 = r1.e;
        r14 = com.android.providers.downloads.DownloadReceiver.class;
        r6.<init>(r13, r12, r15, r14);
        r12 = r1.e;
        r13 = 0;
        r6 = android.app.PendingIntent.getBroadcast(r12, r13, r6, r13);
        r11.b(r6);
        goto L_0x0181;
    L_0x013c:
        r16 = r13;
        r6 = 4;
        if (r7 != r6) goto L_0x0181;
    L_0x0141:
        r6 = 1;
        r11.b(r6);
        goto L_0x0187;
    L_0x0146:
        r16 = r13;
        r6 = new android.net.Uri$Builder;
        r6.<init>();
        r12 = "active-dl";
        r6 = r6.scheme(r12);
        r6 = r6.appendPath(r5);
        r6 = r6.build();
        r12 = new android.content.Intent;
        r13 = "android.intent.action.DOWNLOAD_LIST";
        r14 = r1.e;
        r15 = com.android.providers.downloads.DownloadReceiver.class;
        r12.<init>(r13, r6, r14, r15);
        r6 = "extra_click_download_ids";
        r13 = r1.c(r8);
        r12.putExtra(r6, r13);
        r6 = r1.e;
        r13 = 0;
        r14 = 134217728; // 0x8000000 float:3.85186E-34 double:6.63123685E-316;
        r6 = android.app.PendingIntent.getBroadcast(r6, r13, r12, r14);
        r11.a(r6);
        r6 = 2;
        if (r7 != r6) goto L_0x0183;
    L_0x017e:
        r11.a(r13);
    L_0x0181:
        r6 = 1;
        goto L_0x0187;
    L_0x0183:
        r6 = 1;
        r11.a(r6);
    L_0x0187:
        if (r7 != r6) goto L_0x0237;
    L_0x0189:
        r6 = r1.i;
        monitor-enter(r6);
        r13 = r8.iterator();	 Catch:{ all -> 0x0233 }
        r14 = 0;	 Catch:{ all -> 0x0233 }
        r18 = r14;	 Catch:{ all -> 0x0233 }
        r20 = r18;	 Catch:{ all -> 0x0233 }
        r22 = r20;	 Catch:{ all -> 0x0233 }
    L_0x0198:
        r17 = r13.hasNext();	 Catch:{ all -> 0x0233 }
        if (r17 == 0) goto L_0x01cf;	 Catch:{ all -> 0x0233 }
    L_0x019e:
        r17 = r13.next();	 Catch:{ all -> 0x0233 }
        r12 = r17;	 Catch:{ all -> 0x0233 }
        r12 = (com.xunlei.download.proguard.d) r12;	 Catch:{ all -> 0x0233 }
        r24 = r3;	 Catch:{ all -> 0x0233 }
        r25 = r4;	 Catch:{ all -> 0x0233 }
        r3 = r12.v;	 Catch:{ all -> 0x0233 }
        r17 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1));	 Catch:{ all -> 0x0233 }
        if (r17 <= 0) goto L_0x01c8;	 Catch:{ all -> 0x0233 }
    L_0x01b0:
        r3 = r12.w;	 Catch:{ all -> 0x0233 }
        r26 = r20 + r3;	 Catch:{ all -> 0x0233 }
        r3 = r12.v;	 Catch:{ all -> 0x0233 }
        r20 = r18 + r3;	 Catch:{ all -> 0x0233 }
        r3 = r1.i;	 Catch:{ all -> 0x0233 }
        r14 = r12.c;	 Catch:{ all -> 0x0233 }
        r3 = r3.a(r14);	 Catch:{ all -> 0x0233 }
        r14 = r22 + r3;	 Catch:{ all -> 0x0233 }
        r22 = r14;	 Catch:{ all -> 0x0233 }
        r18 = r20;	 Catch:{ all -> 0x0233 }
        r20 = r26;	 Catch:{ all -> 0x0233 }
    L_0x01c8:
        r3 = r24;	 Catch:{ all -> 0x0233 }
        r4 = r25;	 Catch:{ all -> 0x0233 }
        r14 = 0;	 Catch:{ all -> 0x0233 }
        goto L_0x0198;	 Catch:{ all -> 0x0233 }
    L_0x01cf:
        r24 = r3;	 Catch:{ all -> 0x0233 }
        r25 = r4;	 Catch:{ all -> 0x0233 }
        monitor-exit(r6);	 Catch:{ all -> 0x0233 }
        r3 = 0;
        r6 = (r18 > r3 ? 1 : (r18 == r3 ? 0 : -1));
        if (r6 <= 0) goto L_0x0222;
    L_0x01da:
        r13 = 100;
        r13 = r13 * r20;
        r13 = r13 / r18;
        r6 = java.text.NumberFormat.getPercentInstance();
        r3 = (double) r13;
        r26 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r3 = r3 / r26;
        r3 = r6.format(r3);
        r26 = 0;
        r4 = (r22 > r26 ? 1 : (r22 == r26 ? 0 : -1));
        if (r4 <= 0) goto L_0x020d;
    L_0x01f3:
        r26 = r18 - r20;
        r18 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r26 = r26 * r18;
        r28 = r13;
        r12 = r26 / r22;
        r4 = com.xunlei.download.proguard.e.b.d.a;
        r6 = 1;
        r14 = new java.lang.Object[r6];
        r6 = r1.a(r12);
        r12 = 0;
        r14[r12] = r6;
        r2.getString(r4, r14);
        goto L_0x0210;
    L_0x020d:
        r28 = r13;
        r12 = 0;
    L_0x0210:
        r4 = com.xunlei.download.proguard.e.b.b.c;
        r13 = r16;
        r13.setViewVisibility(r4, r12);
        r4 = com.xunlei.download.proguard.e.b.b.c;
        r14 = r28;
        r6 = (int) r14;
        r14 = 100;
        r13.setProgressBar(r4, r14, r6, r12);
        goto L_0x023e;
    L_0x0222:
        r13 = r16;
        r12 = 0;
        r14 = 100;
        r3 = com.xunlei.download.proguard.e.b.b.c;
        r13.setViewVisibility(r3, r12);
        r3 = com.xunlei.download.proguard.e.b.b.c;
        r4 = 1;
        r13.setProgressBar(r3, r14, r12, r4);
        goto L_0x023d;
    L_0x0233:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r6);	 Catch:{ all -> 0x0233 }
        throw r2;
    L_0x0237:
        r24 = r3;
        r25 = r4;
        r13 = r16;
    L_0x023d:
        r3 = 0;
    L_0x023e:
        r4 = 4;
        if (r7 != r4) goto L_0x0247;
    L_0x0241:
        r3 = r11.a();
        goto L_0x039d;
    L_0x0247:
        r4 = r8.size();
        r6 = 8;
        r12 = 1;
        if (r4 != r12) goto L_0x0314;
    L_0x0250:
        r4 = com.xunlei.download.proguard.e.b.b.d;
        r8 = a(r2, r9, r7, r12);
        r13.setTextViewText(r4, r8);
        if (r7 != r12) goto L_0x0286;
    L_0x025b:
        if (r10 == 0) goto L_0x026f;
    L_0x025d:
        r4 = com.xunlei.download.proguard.e.b.b.f;
        r6 = 0;
        r13.setViewVisibility(r4, r6);
        r4 = com.xunlei.download.proguard.e.b.b.e;
        r6 = com.xunlei.download.proguard.e.b.d.b;
        r6 = r2.getString(r6);
        r13.setTextViewText(r4, r6);
        goto L_0x027f;
    L_0x026f:
        r4 = com.xunlei.download.proguard.e.b.b.f;
        r13.setViewVisibility(r4, r6);
        r4 = com.xunlei.download.proguard.e.b.b.e;
        r6 = com.xunlei.download.proguard.e.b.d.c;
        r6 = r2.getString(r6);
        r13.setTextViewText(r4, r6);
    L_0x027f:
        r4 = com.xunlei.download.proguard.e.b.b.g;
        r13.setTextViewText(r4, r3);
        goto L_0x030b;
    L_0x0286:
        r3 = 2;
        if (r7 != r3) goto L_0x02c9;
    L_0x0289:
        r3 = r1.e;
        r3 = com.xunlei.download.proguard.ab.a(r3);
        if (r3 == 0) goto L_0x02ad;
    L_0x0291:
        r3 = com.xunlei.download.proguard.e.b.b.d;
        r4 = 1;
        r8 = 3;
        r4 = a(r2, r9, r8, r4);
        r13.setTextViewText(r3, r4);
        r3 = com.xunlei.download.proguard.e.b.b.f;
        r13.setViewVisibility(r3, r6);
        r3 = com.xunlei.download.proguard.e.b.b.e;
        r4 = com.xunlei.download.proguard.e.b.d.d;
        r4 = r2.getString(r4);
        r13.setTextViewText(r3, r4);
        goto L_0x030b;
    L_0x02ad:
        r4 = 1;
        r8 = 3;
        r3 = com.xunlei.download.proguard.e.b.b.d;
        r4 = a(r2, r9, r8, r4);
        r13.setTextViewText(r3, r4);
        r3 = com.xunlei.download.proguard.e.b.b.f;
        r13.setViewVisibility(r3, r6);
        r3 = com.xunlei.download.proguard.e.b.b.e;
        r4 = com.xunlei.download.proguard.e.b.d.e;
        r4 = r2.getString(r4);
        r13.setTextViewText(r3, r4);
        goto L_0x030b;
    L_0x02c9:
        r8 = 3;
        if (r7 != r8) goto L_0x030b;
    L_0x02cc:
        r3 = r9.l;
        r3 = com.xunlei.download.Downloads.Impl.isStatusError(r3);
        if (r3 == 0) goto L_0x02e0;
    L_0x02d4:
        r3 = com.xunlei.download.proguard.e.b.b.e;
        r4 = com.xunlei.download.proguard.e.b.d.f;
        r4 = r2.getText(r4);
        r13.setTextViewText(r3, r4);
        goto L_0x0302;
    L_0x02e0:
        r3 = r9.l;
        r3 = com.xunlei.download.Downloads.Impl.isStatusSuccess(r3);
        if (r3 == 0) goto L_0x0302;
    L_0x02e8:
        if (r10 == 0) goto L_0x02f7;
    L_0x02ea:
        r3 = com.xunlei.download.proguard.e.b.b.f;
        r4 = 0;
        r13.setViewVisibility(r3, r4);
        r3 = com.xunlei.download.proguard.e.b.b.f;
        r4 = com.xunlei.download.proguard.e.b.a.a;
        r13.setImageViewResource(r3, r4);
    L_0x02f7:
        r3 = com.xunlei.download.proguard.e.b.b.e;
        r4 = com.xunlei.download.proguard.e.b.d.g;
        r4 = r2.getText(r4);
        r13.setTextViewText(r3, r4);
    L_0x0302:
        r3 = com.xunlei.download.proguard.e.b.b.a;
        r4 = "setTime";
        r6 = r9.o;
        r13.setLong(r3, r4, r6);
    L_0x030b:
        r11.a(r13);
        r3 = r11.a();
        goto L_0x039d;
    L_0x0314:
        r4 = com.xunlei.download.proguard.e.b.b.d;
        r12 = r8.size();
        r9 = a(r2, r9, r7, r12);
        r13.setTextViewText(r4, r9);
        r4 = 1;
        if (r7 != r4) goto L_0x0355;
    L_0x0324:
        if (r10 == 0) goto L_0x033f;
    L_0x0326:
        r4 = com.xunlei.download.proguard.e.b.b.f;
        r6 = 0;
        r13.setViewVisibility(r4, r6);
        r4 = com.xunlei.download.proguard.e.b.b.f;
        r6 = com.xunlei.download.proguard.e.b.a.a;
        r13.setImageViewResource(r4, r6);
        r4 = com.xunlei.download.proguard.e.b.b.e;
        r6 = com.xunlei.download.proguard.e.b.d.b;
        r6 = r2.getString(r6);
        r13.setTextViewText(r4, r6);
        goto L_0x034f;
    L_0x033f:
        r4 = com.xunlei.download.proguard.e.b.b.f;
        r13.setViewVisibility(r4, r6);
        r4 = com.xunlei.download.proguard.e.b.b.e;
        r6 = com.xunlei.download.proguard.e.b.d.c;
        r6 = r2.getString(r6);
        r13.setTextViewText(r4, r6);
    L_0x034f:
        r4 = com.xunlei.download.proguard.e.b.b.g;
        r13.setTextViewText(r4, r3);
        goto L_0x0396;
    L_0x0355:
        r3 = 2;
        if (r7 != r3) goto L_0x0396;
    L_0x0358:
        r3 = com.xunlei.download.proguard.e.b.b.d;
        r4 = com.xunlei.download.proguard.e.b.d.h;
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = r8.size();
        r7 = java.lang.Integer.valueOf(r7);
        r8 = 0;
        r6[r8] = r7;
        r4 = r2.getString(r4, r6);
        r6 = new java.lang.Object[r8];
        r4 = java.lang.String.format(r4, r6);
        r13.setTextViewText(r3, r4);
        r3 = r1.e;
        r3 = com.xunlei.download.proguard.ab.a(r3);
        if (r3 == 0) goto L_0x038b;
    L_0x037f:
        r3 = com.xunlei.download.proguard.e.b.b.e;
        r4 = com.xunlei.download.proguard.e.b.d.d;
        r4 = r2.getString(r4);
        r13.setTextViewText(r3, r4);
        goto L_0x0396;
    L_0x038b:
        r3 = com.xunlei.download.proguard.e.b.b.e;
        r4 = com.xunlei.download.proguard.e.b.d.e;
        r4 = r2.getString(r4);
        r13.setTextViewText(r3, r4);
    L_0x0396:
        r11.a(r13);
        r3 = r11.a();
    L_0x039d:
        r4 = r1.f;
        r6 = 0;
        r4.notify(r5, r6, r3);
        r3 = r24;
        r4 = r25;
        goto L_0x0048;
    L_0x03a9:
        r24 = r3;
        r2 = r1.h;
        r2 = r2.keySet();
        r2 = r2.iterator();
    L_0x03b5:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x03d7;
    L_0x03bb:
        r3 = r2.next();
        r3 = (java.lang.String) r3;
        r4 = r24;
        r5 = r4.containsKey(r3);
        if (r5 != 0) goto L_0x03d3;
    L_0x03c9:
        r5 = r1.f;
        r6 = 0;
        r5.cancel(r3, r6);
        r2.remove();
        goto L_0x03d4;
    L_0x03d3:
        r6 = 0;
    L_0x03d4:
        r24 = r4;
        goto L_0x03b5;
    L_0x03d7:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.e.b(java.util.Collection):void");
    }

    private static CharSequence a(Resources resources, d dVar, int i, int i2) {
        if (i2 > 1) {
            return String.format(resources.getString(d.i), new Object[]{Integer.valueOf(i2)});
        } else if (TextUtils.isEmpty(dVar.G) != 0) {
            return resources.getString(d.k);
        } else {
            if (i == 3) {
                return dVar.G;
            }
            return String.format(resources.getString(d.j), new Object[]{dVar.G});
        }
    }

    private long[] c(Collection<d> collection) {
        long[] jArr = new long[collection.size()];
        int i = 0;
        for (d dVar : collection) {
            int i2 = i + 1;
            jArr[i] = dVar.c;
            i = i2;
        }
        return jArr;
    }

    public void b() {
        synchronized (this.i) {
            for (int i = 0; i < this.i.b(); i++) {
                long b = this.i.b(i);
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.j.a(b);
                StringBuilder stringBuilder = new StringBuilder("Download ");
                stringBuilder.append(b);
                stringBuilder.append(" speed ");
                stringBuilder.append(this.i.c(i));
                stringBuilder.append("bps, ");
                stringBuilder.append(elapsedRealtime);
                stringBuilder.append("ms ago");
                an.b("DownloadManager", stringBuilder.toString());
            }
        }
    }

    private String a(d dVar) {
        if (!dVar.A) {
            if (dVar.ae == 0) {
                StringBuilder stringBuilder;
                if (dVar.l != 196) {
                    if (dVar.l != 195) {
                        if (d(dVar)) {
                            return ab.a(dVar.l()) != null ? "4: external" : "4: internal";
                        } else {
                            if (b(dVar)) {
                                stringBuilder = new StringBuilder("1:");
                                stringBuilder.append(dVar.p);
                                return stringBuilder.toString();
                            } else if (!c(dVar)) {
                                return null;
                            } else {
                                stringBuilder = new StringBuilder("3:");
                                stringBuilder.append(dVar.c);
                                return stringBuilder.toString();
                            }
                        }
                    }
                }
                stringBuilder = new StringBuilder("2:");
                stringBuilder.append(dVar.p);
                return stringBuilder.toString();
            }
        }
        return null;
    }

    private static int a(String str) {
        return Integer.parseInt(str.substring(0, str.indexOf(58)));
    }

    private boolean b(d dVar) {
        return (this.g && ((dVar.l == 192 || dVar.l == 190) && (dVar.j == 0 || dVar.j == 1))) ? true : null;
    }

    private boolean c(d dVar) {
        return (this.g && Impl.isStatusCompleted(dVar.l) && (dVar.j == 1 || dVar.j == 3)) ? true : null;
    }
}
