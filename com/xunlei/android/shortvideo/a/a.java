package com.xunlei.android.shortvideo.a;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.android.xlstat.param.XLStatKey;
import com.xunlei.android.xlstat.param.XLStatParam;
import com.xunlei.downloadlib.XLDownloadManager;
import com.xunlei.downloadlib.android.XLLog;
import com.xunlei.downloadlib.parameter.GetDownloadLibVersion;
import com.xunlei.downloadprovider.app.BrothersApplication;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: ShortVideoStat */
public final class a {
    private static String c = "ShortVideoStat";
    public Handler a = null;
    public ContentValues b = new ContentValues();
    private String d = "short_video";
    private SQLiteDatabase e = null;
    private HandlerThread f = null;
    private Context g;
    private XLStatKey h = null;
    private com.xunlei.android.xlstat.a i;
    private boolean j = false;

    public a(String str, Context context, String str2) {
        this.d = str;
        this.f = new HandlerThread(c);
        this.f.start();
        this.a = new Handler(this.f.getLooper());
        this.g = context;
        this.j = Boolean.TRUE.equals(a(context, "DEBUG"));
        this.a.post(new b(this, str2));
    }

    public final void a(String str, Long l) {
        this.b.put(str, l);
    }

    public final Object a(String str) {
        return this.b.get(str);
    }

    public final void a(String str, String str2) {
        this.b.put(str, str2);
    }

    public final void b(String str, String str2) {
        if (str2 != null) {
            try {
                this.b.put(str, URLEncoder.encode(str2, "utf-8"));
            } catch (String str3) {
                str3.printStackTrace();
            }
        }
    }

    private static Object a(Context context, String str) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getPackageName());
            stringBuilder.append(".BuildConfig");
            return Class.forName(stringBuilder.toString()).getField(str).get(null);
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        } catch (Context context22) {
            context22.printStackTrace();
            return null;
        } catch (Context context222) {
            context222.printStackTrace();
            return null;
        }
    }

    public final void a(String str, long j) {
        a(str, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(j)));
    }

    static /* synthetic */ void a(a aVar, String str) {
        PackageInfo packageInfo;
        String str2 = "<config><server><tcp host=\"dlandroid.rcv.sandai.net\" port=\"80\"/></server><priority><level id=\"0\" report_time=\"0\"/><level id=\"1\" report_time=\"0\"/><level id=\"2\" report_time=\"1\"/><level id=\"3\" report_time=\"-1\"/><level id=\"4\" report_time=\"-2\"/></priority><stat><event index=\"4949\" key=\"shortvideo\" priority=\"2\"/></stat><max_storage_records>2000</max_storage_records><max_send_records>200</max_send_records><storage_name>statstorage_andriod_shortvideo.xml</storage_name><seq_id_file_name>andriod_shortvideo_seq_id</seq_id_file_name></config>";
        try {
            packageInfo = aVar.g.getPackageManager().getPackageInfo(aVar.g.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        GetDownloadLibVersion getDownloadLibVersion = new GetDownloadLibVersion();
        try {
            XLDownloadManager.getInstance(aVar.g).getDownloadLibVersion(getDownloadLibVersion);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        XLStatParam xLStatParam = new XLStatParam();
        xLStatParam.mAppKey = "eGxfZGxfc2RrX2FuZHJvaWQAEgAC";
        xLStatParam.mAppName = "xl_dl_sdk_android";
        xLStatParam.mAppVersion = getDownloadLibVersion.mVersion != null ? getDownloadLibVersion.mVersion : "1.0";
        String str3 = (packageInfo == null || packageInfo.versionName == null) ? "1.0" : packageInfo.versionName;
        xLStatParam.mProductVersion = str3;
        xLStatParam.mProductKey = "Y29tLnh1bmxlaS5kb3dubG9hZHByb3ZpZGVyAHkXAQ==";
        xLStatParam.mProductName = BrothersApplication.COM_XUNLEI_DOWNLOADPROVIDER;
        xLStatParam.mStoragePath = aVar.g.getFilesDir().getPath();
        xLStatParam.mConfigPath = aVar.g.getFilesDir().getPath();
        xLStatParam.mConfigFileName = "android_shortvideo_stat_config.xml";
        xLStatParam.mConfigBuffer = str2;
        aVar.h = new XLStatKey();
        if (TextUtils.isEmpty(str)) {
            aVar.i = com.xunlei.android.xlstat.a.a(aVar.g);
        } else {
            try {
                Method declaredMethod = com.xunlei.android.xlstat.a.class.getDeclaredMethod("a", new Class[]{Context.class, String.class});
                declaredMethod.setAccessible(true);
                aVar.i = (com.xunlei.android.xlstat.a) declaredMethod.invoke(com.xunlei.android.xlstat.a.class, new Object[]{aVar.g, str});
            } catch (String str4) {
                str4.printStackTrace();
            } catch (String str42) {
                str42.printStackTrace();
            } catch (String str422) {
                str422.printStackTrace();
            }
        }
        aVar = aVar.i.a(xLStatParam, aVar.h);
        str422 = c;
        StringBuilder stringBuilder = new StringBuilder("init ret = ");
        stringBuilder.append(aVar);
        XLLog.d(str422, stringBuilder.toString());
    }

    static /* synthetic */ void a(a aVar, ContentValues contentValues) {
        StringBuilder stringBuilder = null;
        for (String str : contentValues.keySet()) {
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder();
            } else {
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            Object obj = contentValues.get(str);
            if (obj == null) {
                obj = "null";
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("=");
            stringBuilder2.append(obj.toString());
            stringBuilder.append(stringBuilder2.toString());
        }
        if (stringBuilder != null) {
            com.xunlei.android.xlstat.a.a(aVar.g).a(aVar.h, "shortvideo", stringBuilder.toString());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(com.xunlei.android.shortvideo.a.a r8, android.content.ContentValues r9) {
        /*
        r0 = 1;
        r1 = 0;
        r2 = 0;
        r3 = r8.e;	 Catch:{ Exception -> 0x00d1, all -> 0x00ce }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00d1, all -> 0x00ce }
        r5 = "SELECT * FROM ";
        r4.<init>(r5);	 Catch:{ Exception -> 0x00d1, all -> 0x00ce }
        r5 = r8.d;	 Catch:{ Exception -> 0x00d1, all -> 0x00ce }
        r4.append(r5);	 Catch:{ Exception -> 0x00d1, all -> 0x00ce }
        r5 = " LIMIT 0";
        r4.append(r5);	 Catch:{ Exception -> 0x00d1, all -> 0x00ce }
        r4 = r4.toString();	 Catch:{ Exception -> 0x00d1, all -> 0x00ce }
        r3 = r3.rawQuery(r4, r1);	 Catch:{ Exception -> 0x00d1, all -> 0x00ce }
        r4 = r9.keySet();	 Catch:{ Exception -> 0x00cc }
        r4 = r4.iterator();	 Catch:{ Exception -> 0x00cc }
    L_0x0026:
        r5 = r4.hasNext();	 Catch:{ Exception -> 0x00cc }
        if (r5 == 0) goto L_0x00aa;
    L_0x002c:
        r5 = r4.next();	 Catch:{ Exception -> 0x00cc }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x00cc }
        if (r3 == 0) goto L_0x003b;
    L_0x0034:
        r6 = r3.getColumnIndex(r5);	 Catch:{ Exception -> 0x00cc }
        r7 = -1;
        if (r6 != r7) goto L_0x0026;
    L_0x003b:
        r6 = r9.get(r5);	 Catch:{ Exception -> 0x00cc }
        r7 = r6 instanceof java.lang.String;	 Catch:{ Exception -> 0x00cc }
        if (r7 == 0) goto L_0x0061;
    L_0x0043:
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00cc }
        r7 = "alter table ";
        r6.<init>(r7);	 Catch:{ Exception -> 0x00cc }
        r7 = r8.d;	 Catch:{ Exception -> 0x00cc }
        r6.append(r7);	 Catch:{ Exception -> 0x00cc }
        r7 = " add column ";
        r6.append(r7);	 Catch:{ Exception -> 0x00cc }
        r6.append(r5);	 Catch:{ Exception -> 0x00cc }
        r5 = " text default '';";
        r6.append(r5);	 Catch:{ Exception -> 0x00cc }
        r5 = r6.toString();	 Catch:{ Exception -> 0x00cc }
        goto L_0x00a2;
    L_0x0061:
        r7 = r6 instanceof java.lang.Long;	 Catch:{ Exception -> 0x00cc }
        if (r7 != 0) goto L_0x0085;
    L_0x0065:
        r6 = r6 instanceof java.lang.Integer;	 Catch:{ Exception -> 0x00cc }
        if (r6 == 0) goto L_0x006a;
    L_0x0069:
        goto L_0x0085;
    L_0x006a:
        if (r3 == 0) goto L_0x0075;
    L_0x006c:
        r9 = r3.isClosed();
        if (r9 != 0) goto L_0x0075;
    L_0x0072:
        r3.close();
    L_0x0075:
        if (r0 != r2) goto L_0x0084;
    L_0x0077:
        r9 = r8.e;
        r9.close();
        r9 = "/sdcard/short_video_debugInfo.db";
        r9 = android.database.sqlite.SQLiteDatabase.openOrCreateDatabase(r9, r1);
        r8.e = r9;
    L_0x0084:
        return;
    L_0x0085:
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00cc }
        r7 = "alter table ";
        r6.<init>(r7);	 Catch:{ Exception -> 0x00cc }
        r7 = r8.d;	 Catch:{ Exception -> 0x00cc }
        r6.append(r7);	 Catch:{ Exception -> 0x00cc }
        r7 = " add column ";
        r6.append(r7);	 Catch:{ Exception -> 0x00cc }
        r6.append(r5);	 Catch:{ Exception -> 0x00cc }
        r5 = " interger default 0;";
        r6.append(r5);	 Catch:{ Exception -> 0x00cc }
        r5 = r6.toString();	 Catch:{ Exception -> 0x00cc }
    L_0x00a2:
        r6 = r8.e;	 Catch:{ Exception -> 0x00cc }
        r6.execSQL(r5);	 Catch:{ Exception -> 0x00cc }
        r2 = r0;
        goto L_0x0026;
    L_0x00aa:
        r4 = r8.e;	 Catch:{ Exception -> 0x00cc }
        r5 = r8.d;	 Catch:{ Exception -> 0x00cc }
        r4.insert(r5, r1, r9);	 Catch:{ Exception -> 0x00cc }
        if (r3 == 0) goto L_0x00bc;
    L_0x00b3:
        r9 = r3.isClosed();
        if (r9 != 0) goto L_0x00bc;
    L_0x00b9:
        r3.close();
    L_0x00bc:
        if (r0 != r2) goto L_0x00f8;
    L_0x00be:
        r9 = r8.e;
        r9.close();
        r9 = "/sdcard/short_video_debugInfo.db";
        r9 = android.database.sqlite.SQLiteDatabase.openOrCreateDatabase(r9, r1);
        r8.e = r9;
        return;
    L_0x00cc:
        r9 = move-exception;
        goto L_0x00d3;
    L_0x00ce:
        r9 = move-exception;
        r3 = r1;
        goto L_0x00fa;
    L_0x00d1:
        r9 = move-exception;
        r3 = r1;
    L_0x00d3:
        r4 = c;	 Catch:{ all -> 0x00f9 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f9 }
        r6 = "insertRecord failed ";
        r5.<init>(r6);	 Catch:{ all -> 0x00f9 }
        r9 = r9.getMessage();	 Catch:{ all -> 0x00f9 }
        r5.append(r9);	 Catch:{ all -> 0x00f9 }
        r9 = r5.toString();	 Catch:{ all -> 0x00f9 }
        com.xunlei.downloadlib.android.XLLog.e(r4, r9);	 Catch:{ all -> 0x00f9 }
        if (r3 == 0) goto L_0x00f5;
    L_0x00ec:
        r9 = r3.isClosed();
        if (r9 != 0) goto L_0x00f5;
    L_0x00f2:
        r3.close();
    L_0x00f5:
        if (r0 != r2) goto L_0x00f8;
    L_0x00f7:
        goto L_0x00be;
    L_0x00f8:
        return;
    L_0x00f9:
        r9 = move-exception;
    L_0x00fa:
        if (r3 == 0) goto L_0x0105;
    L_0x00fc:
        r4 = r3.isClosed();
        if (r4 != 0) goto L_0x0105;
    L_0x0102:
        r3.close();
    L_0x0105:
        if (r0 != r2) goto L_0x0114;
    L_0x0107:
        r0 = r8.e;
        r0.close();
        r0 = "/sdcard/short_video_debugInfo.db";
        r0 = android.database.sqlite.SQLiteDatabase.openOrCreateDatabase(r0, r1);
        r8.e = r0;
    L_0x0114:
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.android.shortvideo.a.a.b(com.xunlei.android.shortvideo.a.a, android.content.ContentValues):void");
    }
}
