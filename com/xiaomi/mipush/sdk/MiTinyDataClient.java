package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.message.proguard.k;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.be;
import com.xiaomi.xmpush.thrift.f;
import java.util.ArrayList;
import java.util.Iterator;

public class MiTinyDataClient {
    public static final String PENDING_REASON_APPID = "com.xiaomi.xmpushsdk.tinydataPending.appId";
    public static final String PENDING_REASON_CHANNEL = "com.xiaomi.xmpushsdk.tinydataPending.channel";
    public static final String PENDING_REASON_INIT = "com.xiaomi.xmpushsdk.tinydataPending.init";

    public static class a {
        private static a a;
        private Context b;
        private String c;
        private Boolean d;
        private a e = new a(this);
        private final ArrayList<f> f = new ArrayList();

        public static a a() {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a();
                    }
                }
            }
            return a;
        }

        private void b(f fVar) {
            synchronized (this.f) {
                if (!this.f.contains(fVar)) {
                    this.f.add(fVar);
                    if (this.f.size() > 100) {
                        this.f.remove(0);
                    }
                }
            }
        }

        private boolean b(android.content.Context r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = com.xiaomi.mipush.sdk.ac.a(r5);
            r0 = r0.d();
            r1 = 1;
            if (r0 != 0) goto L_0x000c;
        L_0x000b:
            return r1;
        L_0x000c:
            r5 = r5.getPackageManager();
            r0 = 0;
            r2 = "com.xiaomi.xmsf";	 Catch:{ Exception -> 0x0023 }
            r3 = 4;	 Catch:{ Exception -> 0x0023 }
            r5 = r5.getPackageInfo(r2, r3);	 Catch:{ Exception -> 0x0023 }
            if (r5 != 0) goto L_0x001b;	 Catch:{ Exception -> 0x0023 }
        L_0x001a:
            return r0;	 Catch:{ Exception -> 0x0023 }
        L_0x001b:
            r5 = r5.versionCode;	 Catch:{ Exception -> 0x0023 }
            r2 = 108; // 0x6c float:1.51E-43 double:5.34E-322;
            if (r5 >= r2) goto L_0x0022;
        L_0x0021:
            return r0;
        L_0x0022:
            return r1;
        L_0x0023:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiTinyDataClient.a.b(android.content.Context):boolean");
        }

        private boolean c(Context context) {
            return c.a(context).c() == null && !b(this.b);
        }

        private boolean c(f fVar) {
            if (be.a(fVar, false)) {
                return false;
            }
            if (this.d.booleanValue()) {
                StringBuilder stringBuilder = new StringBuilder("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem).");
                stringBuilder.append(fVar.d());
                b.c(stringBuilder.toString());
                ac.a(this.b).a(fVar);
            } else {
                this.e.a(fVar);
            }
            return true;
        }

        public void a(Context context) {
            if (context == null) {
                b.a("context is null, MiTinyDataClientImp.init() failed.");
                return;
            }
            this.b = context;
            this.d = Boolean.valueOf(b(context));
            b(MiTinyDataClient.PENDING_REASON_INIT);
        }

        public synchronized void a(String str) {
            if (TextUtils.isEmpty(str)) {
                b.a("channel is null, MiTinyDataClientImp.setChannel(String) failed.");
                return;
            }
            this.c = str;
            b(MiTinyDataClient.PENDING_REASON_CHANNEL);
        }

        public synchronized boolean a(f fVar) {
            boolean z = false;
            if (fVar == null) {
                return false;
            }
            if (be.a(fVar, true)) {
                return false;
            }
            String stringBuilder;
            boolean z2 = TextUtils.isEmpty(fVar.a()) && TextUtils.isEmpty(this.c);
            int b = b() ^ 1;
            if (this.b == null || c(this.b)) {
                z = true;
            }
            if (b == 0 && !z2) {
                if (!z) {
                    StringBuilder stringBuilder2 = new StringBuilder("MiTinyDataClient Send item immediately.");
                    stringBuilder2.append(fVar.d());
                    b.c(stringBuilder2.toString());
                    if (TextUtils.isEmpty(fVar.m())) {
                        fVar.f(MiPushClient.generatePacketID());
                    }
                    if (TextUtils.isEmpty(fVar.a())) {
                        fVar.a(this.c);
                    }
                    if (TextUtils.isEmpty(fVar.k())) {
                        fVar.e(this.b.getPackageName());
                    }
                    if (fVar.g() <= 0) {
                        fVar.b(System.currentTimeMillis());
                    }
                    return c(fVar);
                }
            }
            if (z2) {
                stringBuilder2 = new StringBuilder("MiTinyDataClient Pending ");
                stringBuilder2.append(fVar.d());
                stringBuilder2.append(" reason is com.xiaomi.xmpushsdk.tinydataPending.channel");
                stringBuilder = stringBuilder2.toString();
            } else if (b != 0) {
                stringBuilder2 = new StringBuilder("MiTinyDataClient Pending ");
                stringBuilder2.append(fVar.d());
                stringBuilder2.append(" reason is com.xiaomi.xmpushsdk.tinydataPending.init");
                stringBuilder = stringBuilder2.toString();
            } else {
                if (z) {
                    stringBuilder2 = new StringBuilder("MiTinyDataClient Pending ");
                    stringBuilder2.append(fVar.d());
                    stringBuilder2.append(" reason is com.xiaomi.xmpushsdk.tinydataPending.appId");
                    stringBuilder = stringBuilder2.toString();
                }
                b(fVar);
                return true;
            }
            b.c(stringBuilder);
            b(fVar);
            return true;
        }

        public void b(String str) {
            StringBuilder stringBuilder = new StringBuilder("MiTinyDataClient.processPendingList(");
            stringBuilder.append(str);
            stringBuilder.append(k.t);
            b.c(stringBuilder.toString());
            ArrayList arrayList = new ArrayList();
            synchronized (this.f) {
                arrayList.addAll(this.f);
                this.f.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a((f) it.next());
            }
        }

        public boolean b() {
            return this.b != null;
        }
    }

    public static void init(Context context, String str) {
        if (context == null) {
            b.a("context is null, MiTinyDataClient.init(Context, String) failed.");
            return;
        }
        a.a().a(context);
        if (TextUtils.isEmpty(str)) {
            b.a("channel is null or empty, MiTinyDataClient.init(Context, String) failed.");
        } else {
            a.a().a(str);
        }
    }

    public static boolean upload(Context context, f fVar) {
        StringBuilder stringBuilder = new StringBuilder("MiTinyDataClient.upload ");
        stringBuilder.append(fVar.d());
        b.c(stringBuilder.toString());
        if (!a.a().b()) {
            a.a().a(context);
        }
        return a.a().a(fVar);
    }

    public static boolean upload(Context context, String str, String str2, long j, String str3) {
        f fVar = new f();
        fVar.d(str);
        fVar.c(str2);
        fVar.a(j);
        fVar.b(str3);
        fVar.c(true);
        fVar.a("push_sdk_channel");
        return upload(context, fVar);
    }

    public static boolean upload(String str, String str2, long j, String str3) {
        f fVar = new f();
        fVar.d(str);
        fVar.c(str2);
        fVar.a(j);
        fVar.b(str3);
        return a.a().a(fVar);
    }
}
