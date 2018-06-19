package com.getui.gtc.d.a;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.SparseArray;
import com.getui.gtc.a.h;
import com.getui.gtc.d.b.a;
import com.getui.gtc.e.b;
import com.getui.gtc.e.i;
import com.getui.gtc.e.j;
import com.getui.gtc.e.l;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.UUID;
import org.android.agoo.common.AgooConstants;

public final class d extends a {
    public SparseArray b;
    public String c;
    public String d;
    public String e;
    public long f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    int l;
    public String m;

    public d(SQLiteOpenHelper sQLiteOpenHelper) {
        super(sQLiteOpenHelper);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.database.sqlite.SQLiteDatabase r12) {
        /*
        r0 = 0;
        r1 = 1;
        r2 = 0;
        r4 = "r";
        r5 = new java.lang.String[r1];	 Catch:{ Throwable -> 0x004a, all -> 0x0045 }
        r3 = "b";
        r5[r2] = r3;	 Catch:{ Throwable -> 0x004a, all -> 0x0045 }
        r6 = "a=?";
        r7 = new java.lang.String[r1];	 Catch:{ Throwable -> 0x004a, all -> 0x0045 }
        r3 = "4";
        r7[r2] = r3;	 Catch:{ Throwable -> 0x004a, all -> 0x0045 }
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r3 = r12;
        r12 = r3.query(r4, r5, r6, r7, r8, r9, r10);	 Catch:{ Throwable -> 0x004a, all -> 0x0045 }
        if (r12 == 0) goto L_0x0042;
    L_0x001d:
        r3 = r12.moveToFirst();	 Catch:{ Throwable -> 0x0040 }
        if (r3 == 0) goto L_0x0042;
    L_0x0023:
        r3 = r12.getBlob(r2);	 Catch:{ Throwable -> 0x0040 }
        if (r3 == 0) goto L_0x0042;
    L_0x0029:
        r4 = new java.lang.String;	 Catch:{ Throwable -> 0x0040 }
        r5 = com.getui.gtc.a.h.b;	 Catch:{ Throwable -> 0x0040 }
        r3 = com.getui.gtc.e.i.a(r3, r5);	 Catch:{ Throwable -> 0x0040 }
        r4.<init>(r3);	 Catch:{ Throwable -> 0x0040 }
        r3 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x0040 }
        if (r3 != 0) goto L_0x0042;
    L_0x003a:
        if (r12 == 0) goto L_0x003f;
    L_0x003c:
        r12.close();
    L_0x003f:
        return r4;
    L_0x0040:
        r3 = move-exception;
        goto L_0x004c;
    L_0x0042:
        if (r12 == 0) goto L_0x0059;
    L_0x0044:
        goto L_0x0056;
    L_0x0045:
        r12 = move-exception;
        r11 = r0;
        r0 = r12;
        r12 = r11;
        goto L_0x005b;
    L_0x004a:
        r3 = move-exception;
        r12 = r0;
    L_0x004c:
        r1 = new java.lang.String[r1];	 Catch:{ all -> 0x005a }
        r3 = r3.toString();	 Catch:{ all -> 0x005a }
        r1[r2] = r3;	 Catch:{ all -> 0x005a }
        if (r12 == 0) goto L_0x0059;
    L_0x0056:
        r12.close();
    L_0x0059:
        return r0;
    L_0x005a:
        r0 = move-exception;
    L_0x005b:
        if (r12 == 0) goto L_0x0060;
    L_0x005d:
        r12.close();
    L_0x0060:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.d.a.d.a(android.database.sqlite.SQLiteDatabase):java.lang.String");
    }

    private void a(String str) {
        try {
            a(1, 4, i.a(str.getBytes(), h.b));
            this.e = str;
        } catch (Throwable th) {
            new String[1][0] = th.toString();
        }
    }

    private void b() {
        Exception e;
        Throwable th;
        Cursor rawQuery;
        try {
            rawQuery = this.a.getReadableDatabase().rawQuery("select id, a, b from r order by id", null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    try {
                        int i = rawQuery.getInt(0);
                        com.getui.gtc.entity.d dVar = (com.getui.gtc.entity.d) this.b.get(i);
                        if (dVar == null) {
                            dVar = new com.getui.gtc.entity.d();
                            dVar.a = i;
                        }
                        int i2 = rawQuery.getInt(1);
                        if (i == 1) {
                            switch (i2) {
                                case 2:
                                    this.c = new String(i.a(rawQuery.getBlob(2), h.b));
                                    break;
                                case 3:
                                    this.d = new String(i.a(rawQuery.getBlob(2), h.b));
                                    break;
                                case 4:
                                    this.e = new String(i.a(rawQuery.getBlob(2), h.b));
                                    break;
                                case 5:
                                    this.f = rawQuery.getLong(2);
                                    break;
                                default:
                                    switch (i2) {
                                        case 11:
                                            this.g = new String(i.a(rawQuery.getBlob(2), h.b));
                                            break;
                                        case 12:
                                            this.h = new String(i.a(rawQuery.getBlob(2), h.b));
                                            break;
                                        default:
                                            break;
                                    }
                            }
                        }
                        if (i2 != 13) {
                            Object string;
                            switch (i2) {
                                case 6:
                                    String str = new String(i.a(rawQuery.getBlob(2), h.b));
                                    if (!TextUtils.isEmpty(str)) {
                                        dVar.b = str;
                                        dVar.f = l.b(str);
                                        break;
                                    }
                                    break;
                                case 7:
                                    string = rawQuery.getString(2);
                                    if (!TextUtils.isEmpty(string)) {
                                        dVar.g = string;
                                        break;
                                    }
                                    break;
                                case 8:
                                    string = new String(i.a(rawQuery.getBlob(2), h.b));
                                    if (!TextUtils.isEmpty(string)) {
                                        dVar.c = string;
                                        break;
                                    }
                                    break;
                                case 9:
                                    dVar.d = Long.valueOf(rawQuery.getLong(2));
                                    break;
                                case 10:
                                    string = new String(i.a(rawQuery.getBlob(2), h.b));
                                    if (!TextUtils.isEmpty(string)) {
                                        dVar.e = string;
                                        break;
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                        dVar.h = Long.valueOf(rawQuery.getLong(2));
                        String[] strArr = new String[1];
                        StringBuilder stringBuilder = new StringBuilder("RuntimeDao_| runtimedao read db sdkinfo : ");
                        stringBuilder.append(dVar);
                        strArr[0] = stringBuilder.toString();
                        this.b.put(i, dVar);
                    } catch (Exception e2) {
                        e = e2;
                    }
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e3) {
            Exception exception = e3;
            rawQuery = null;
            e = exception;
            try {
                String[] strArr2 = new String[1];
                StringBuilder stringBuilder2 = new StringBuilder("read db error : ");
                stringBuilder2.append(e.toString());
                strArr2[0] = stringBuilder2.toString();
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Throwable th2) {
                th = th2;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            rawQuery = null;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }

    protected final String a() {
        return "r";
    }

    public final void a(Context context) {
        TelephonyManager telephonyManager;
        this.b = new SparseArray();
        b();
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Throwable th) {
            new String[1][0] = th.toString();
            telephonyManager = null;
        }
        try {
            if (TextUtils.isEmpty(this.g)) {
                this.g = telephonyManager.getDeviceId();
                if (!TextUtils.isEmpty(this.g)) {
                    a(1, 11, i.a(this.g.getBytes(), h.b));
                }
            }
        } catch (Throwable th2) {
            new String[1][0] = th2.toString();
        }
        try {
            this.i = telephonyManager.getSubscriberId();
            if (TextUtils.isEmpty(this.i)) {
                this.i = "";
            }
        } catch (Throwable th3) {
            new String[1][0] = th3.toString();
        }
        try {
            this.j = l.b();
            if (TextUtils.isEmpty(this.c)) {
                this.c = l.a(context);
                if (!TextUtils.isEmpty(this.c)) {
                    a(1, 2, i.a(this.c.getBytes(), h.b));
                }
            }
        } catch (Throwable th32) {
            new String[1][0] = th32.toString();
        }
        this.k = Build.MODEL;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
            if (packageInfo != null) {
                this.l = packageInfo.versionCode;
            }
        } catch (Throwable th322) {
            String[] strArr = new String[1];
            StringBuilder stringBuilder = new StringBuilder("RuntimeDao_| runtimedao read packageName error : ");
            stringBuilder.append(th322.toString());
            strArr[0] = stringBuilder.toString();
        }
        this.m = context.getPackageName();
        try {
            if (TextUtils.isEmpty(this.h)) {
                this.h = System.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
                if (!TextUtils.isEmpty(this.h)) {
                    a(1, 12, i.a(this.h.getBytes(), h.b));
                }
            }
        } catch (Throwable th3222) {
            new String[1][0] = th3222.toString();
        }
        if (TextUtils.isEmpty(this.d)) {
            try {
                new Thread(new b(context, new e(this))).start();
            } catch (Throwable th4) {
                new String[1][0] = th4.toString();
            }
        }
        try {
            if (TextUtils.isEmpty(this.e)) {
                String a = a.a(h.a).a("gicid");
                CharSequence charSequence = this.e;
                String a2 = l.a();
                String[] strArr2 = new String[1];
                StringBuilder stringBuilder2 = new StringBuilder("db gicid:");
                stringBuilder2.append(charSequence);
                strArr2[0] = stringBuilder2.toString();
                if (TextUtils.isEmpty(a) || !TextUtils.isEmpty(charSequence)) {
                    a = charSequence;
                } else {
                    a(a);
                    a.a(h.a).a("gicid", "");
                }
                if (TextUtils.isEmpty(a) && TextUtils.isEmpty(a2)) {
                    this.e = j.a(UUID.randomUUID().toString());
                    a(this.e);
                    l.a(this.e);
                } else if (TextUtils.isEmpty(a) && !TextUtils.isEmpty(a2)) {
                    this.e = a2;
                    a(this.e);
                } else if (!TextUtils.isEmpty(a) && TextUtils.isEmpty(a2)) {
                    this.e = a;
                    l.a(this.e);
                } else if (a.equalsIgnoreCase(a2)) {
                    this.e = a2;
                } else {
                    this.e = a2;
                    a(this.e);
                }
            }
        } catch (Throwable th42) {
            new String[1][0] = th42.toString();
        }
    }

    public final boolean a(int i, int i2, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AgooConstants.MESSAGE_ID, Integer.valueOf(i));
        contentValues.put("a", Integer.valueOf(i2));
        contentValues.put(com.xunlei.downloadprovider.ad.common.adget.b.b.a, Long.valueOf(j));
        return a(contentValues) != -1;
    }

    public final boolean a(int i, int i2, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AgooConstants.MESSAGE_ID, Integer.valueOf(i));
        contentValues.put("a", Integer.valueOf(i2));
        contentValues.put(com.xunlei.downloadprovider.ad.common.adget.b.b.a, bArr);
        return a(contentValues) != -1;
    }

    public final boolean a(com.getui.gtc.entity.d dVar) {
        try {
            a(dVar.a, 6, i.a(dVar.b.getBytes(), h.b));
            if (((com.getui.gtc.entity.d) this.b.get(dVar.a)) == null) {
                this.b.put(dVar.a, dVar);
                return false;
            }
        } catch (Throwable th) {
            new String[1][0] = th.toString();
        }
        return false;
    }
}
