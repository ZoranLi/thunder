package com.xiaomi.smack.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.misc.j;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class g {
    private static j a = new j(true);
    private static int b = -1;
    private static final Object c = new Object();
    private static List<a> d = Collections.synchronizedList(new ArrayList());
    private static String e = "";
    private static com.xiaomi.push.providers.a f;

    static class a {
        public String a = "";
        public long b = 0;
        public int c = -1;
        public int d = -1;
        public String e = "";
        public long f = 0;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.a = str;
            this.b = j;
            this.c = i;
            this.d = i2;
            this.e = str2;
            this.f = j2;
        }

        public boolean a(a aVar) {
            if (TextUtils.equals(aVar.a, this.a) && TextUtils.equals(aVar.e, this.e) && aVar.c == this.c && aVar.d == this.d) {
                if (Math.abs(aVar.b - this.b) <= 5000) {
                    return true;
                }
            }
            return false;
        }
    }

    public static int a(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0008 }
        r0 = r1.getBytes(r0);	 Catch:{ UnsupportedEncodingException -> 0x0008 }
        r0 = r0.length;	 Catch:{ UnsupportedEncodingException -> 0x0008 }
        return r0;
    L_0x0008:
        r1 = r1.getBytes();
        r1 = r1.length;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.util.g.a(java.lang.String):int");
    }

    private static long a(int i, long j) {
        return (j * ((long) (i == 0 ? 13 : 11))) / 10;
    }

    public static void a(Context context) {
        b = c(context);
    }

    public static void a(Context context, String str, long j, boolean z, long j2) {
        Context context2 = context;
        if (context2 != null && !TextUtils.isEmpty(str) && "com.xiaomi.xmsf".equals(context2.getPackageName())) {
            String str2 = str;
            if (!"com.xiaomi.xmsf".equals(str2)) {
                int b = b(context2);
                if (-1 != b) {
                    boolean isEmpty;
                    synchronized (c) {
                        try {
                            isEmpty = d.isEmpty();
                            a(new a(str2, j2, b, z, b == 0 ? d(context2) : "", a(b, j)));
                        } catch (Throwable th) {
                            while (true) {
                                Throwable th2 = th;
                            }
                        }
                    }
                    if (isEmpty) {
                        a.a(new h(context2), 5000);
                    }
                }
            }
        }
    }

    private static void a(a aVar) {
        for (a aVar2 : d) {
            if (aVar2.a(aVar)) {
                aVar2.f += aVar.f;
                return;
            }
        }
        d.add(aVar);
    }

    private static int b(Context context) {
        if (b == -1) {
            b = c(context);
        }
        return b;
    }

    private static void b(Context context, List<a> list) {
        try {
            synchronized (com.xiaomi.push.providers.a.a) {
                SQLiteDatabase writableDatabase = e(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (a aVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(Constants.PACKAGE_NAME, aVar.a);
                        contentValues.put("message_ts", Long.valueOf(aVar.b));
                        contentValues.put("network_type", Integer.valueOf(aVar.c));
                        contentValues.put("bytes", Long.valueOf(aVar.f));
                        contentValues.put("rcv", Integer.valueOf(aVar.d));
                        contentValues.put(com.taobao.accs.common.Constants.KEY_IMSI, aVar.e);
                        writableDatabase.insert("traffic", null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (Throwable e) {
            b.a(e);
        }
    }

    private static int c(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = -1;
        r1 = "connectivity";	 Catch:{ Exception -> 0x0018 }
        r2 = r2.getSystemService(r1);	 Catch:{ Exception -> 0x0018 }
        r2 = (android.net.ConnectivityManager) r2;	 Catch:{ Exception -> 0x0018 }
        if (r2 != 0) goto L_0x000c;
    L_0x000b:
        return r0;
    L_0x000c:
        r2 = r2.getActiveNetworkInfo();	 Catch:{  }
        if (r2 != 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        r2 = r2.getType();
        return r2;
    L_0x0018:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.util.g.c(android.content.Context):int");
    }

    private static synchronized java.lang.String d(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.xiaomi.smack.util.g.class;
        monitor-enter(r0);
        r1 = e;	 Catch:{ all -> 0x0023 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0023 }
        if (r1 != 0) goto L_0x000f;	 Catch:{ all -> 0x0023 }
    L_0x000b:
        r2 = e;	 Catch:{ all -> 0x0023 }
        monitor-exit(r0);
        return r2;
    L_0x000f:
        r1 = "phone";	 Catch:{ Exception -> 0x001f }
        r2 = r2.getSystemService(r1);	 Catch:{ Exception -> 0x001f }
        r2 = (android.telephony.TelephonyManager) r2;	 Catch:{ Exception -> 0x001f }
        if (r2 == 0) goto L_0x001f;	 Catch:{ Exception -> 0x001f }
    L_0x0019:
        r2 = r2.getSubscriberId();	 Catch:{ Exception -> 0x001f }
        e = r2;	 Catch:{ Exception -> 0x001f }
    L_0x001f:
        r2 = e;	 Catch:{ all -> 0x0023 }
        monitor-exit(r0);
        return r2;
    L_0x0023:
        r2 = move-exception;
        monitor-exit(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.util.g.d(android.content.Context):java.lang.String");
    }

    private static com.xiaomi.push.providers.a e(Context context) {
        if (f != null) {
            return f;
        }
        com.xiaomi.push.providers.a aVar = new com.xiaomi.push.providers.a(context);
        f = aVar;
        return aVar;
    }
}
