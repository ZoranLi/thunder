package com.android.providers.downloads;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.UriMatcher;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.qihoo360.replugin.RePlugin;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.k;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.download.DownloadManager;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.download.Downloads.Impl;
import com.xunlei.download.Downloads.Impl.RequestHeaders;
import com.xunlei.download.proguard.ab;
import com.xunlei.download.proguard.ad;
import com.xunlei.download.proguard.an;
import com.xunlei.download.proguard.j;
import com.xunlei.download.proguard.o;
import com.xunlei.download.proguard.q;
import com.xunlei.download.proguard.r;
import com.xunlei.util.StatHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class DownloadProvider extends ContentProvider {
    private static final String[] A = new String[]{"_id", Impl.COLUMN_APP_DATA, Impl._DATA, "mimetype", Impl.COLUMN_VISIBILITY, Impl.COLUMN_DESTINATION, Impl.COLUMN_CONTROL, "status", Impl.COLUMN_LAST_MODIFICATION, Impl.COLUMN_NOTIFICATION_PACKAGE, Impl.COLUMN_NOTIFICATION_CLASS, "total_bytes", Impl.COLUMN_CURRENT_BYTES, "title", "description", "uri", Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, Impl.COLUMN_FILE_NAME_HINT, "mediaprovider_uri", Impl.COLUMN_DELETED, "errorMsg", "_display_name", "_size", "p2s_speed", "origin_speed", "download_speed", "xunlei_spdy", "extra", "bt_select_set", "addition_vip_speed", "cid", "gcid", "is_vip_speedup", "is_lx_speedup", "create_time", "download_duration", Impl.COLUMN_ALLOW_AUTO_RESUME, "apk_package", "apk_version", "etag", Impl.COLUMN_GROUP_ID, "task_type", Impl.COLUMN_SYNCRO_LX_TASK_TO_SERVER};
    private static final HashSet<String> B = new HashSet();
    private static final HashMap<String, String> C;
    private static final List<String> D = new ArrayList();
    public static final String a = "_key";
    public static final String b = "_value";
    public static Uri c = Uri.parse("content://xldownloads/xl_bt_sub_task");
    public static Uri d = Uri.parse("content://xldownloads/xl_config");
    public static String e = "xldownloads";
    private static final String g = "xl_downloads.db";
    private static final int h = 122;
    private static final String i = "xl_downloads";
    private static final String j = "vnd.android.cursor.dir/download";
    private static final String k = "vnd.android.cursor.item/download";
    private static final UriMatcher l = new UriMatcher(-1);
    private static final int m = 1;
    private static final int n = 2;
    private static final int o = 3;
    private static final int p = 4;
    private static final int q = 5;
    private static final int r = 6;
    private static final int s = 9;
    private static final String t = "xl_config";
    private static final int u = 100;
    private static final String v = "xl_bt_sub_task";
    private static final int w = 200;
    private static final int x = 201;
    private static final int y = 202;
    private static Uri[] z;
    private Handler E;
    private SQLiteOpenHelper F = null;
    private boolean G = true;
    private int H = -1;
    private int I = -1;
    private File J;
    r f;

    final class a extends SQLiteOpenHelper {
        final /* synthetic */ DownloadProvider a;

        public a(DownloadProvider downloadProvider, Context context) {
            this.a = downloadProvider;
            super(context, DownloadProvider.g, null, 122);
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            onUpgrade(sQLiteDatabase, 0, 122);
        }

        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            int i3 = 99;
            if (i != 3) {
                if (i != 4) {
                    if (i != 31) {
                        StringBuilder stringBuilder;
                        if (i < 100) {
                            stringBuilder = new StringBuilder("Upgrading downloads database from version ");
                            stringBuilder.append(i);
                            stringBuilder.append(" to version ");
                            stringBuilder.append(i2);
                            stringBuilder.append(", which will destroy all old data");
                            an.a("DownloadManager", stringBuilder.toString());
                        } else if (i > i2) {
                            stringBuilder = new StringBuilder("Downgrading downloads database from version ");
                            stringBuilder.append(i);
                            stringBuilder.append(" (current version is ");
                            stringBuilder.append(i2);
                            stringBuilder.append("), destroying all old data");
                            an.a("DownloadManager", stringBuilder.toString());
                        } else {
                            i3 = i;
                        }
                        while (true) {
                            i3++;
                            if (i3 <= i2) {
                                a(sQLiteDatabase, i3);
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
            i3 = 100;
            while (true) {
                i3++;
                if (i3 <= i2) {
                    a(sQLiteDatabase, i3);
                } else {
                    return;
                }
            }
        }

        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            StringBuilder stringBuilder = new StringBuilder("onDowngrade() ");
            stringBuilder.append(i);
            stringBuilder.append(" -> ");
            stringBuilder.append(i2);
            an.b("DownloadManager", stringBuilder.toString());
            a(sQLiteDatabase);
            onUpgrade(sQLiteDatabase, 0, 122);
        }

        private void a(SQLiteDatabase sQLiteDatabase, int i) {
            switch (i) {
                case 100:
                    d(sQLiteDatabase);
                    return;
                case 101:
                    e(sQLiteDatabase);
                    return;
                case 102:
                    a(sQLiteDatabase, DownloadProvider.i, Impl.COLUMN_IS_PUBLIC_API, "INTEGER NOT NULL DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.i, Impl.COLUMN_ALLOW_ROAMING, "INTEGER NOT NULL DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.i, Impl.COLUMN_ALLOWED_NETWORK_TYPES, "INTEGER NOT NULL DEFAULT 0");
                    return;
                case 103:
                    a(sQLiteDatabase, DownloadProvider.i, Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, "INTEGER NOT NULL DEFAULT 1");
                    c(sQLiteDatabase);
                    return;
                case 104:
                    a(sQLiteDatabase, DownloadProvider.i, Impl.COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT, "INTEGER NOT NULL DEFAULT 0");
                    return;
                case 105:
                    b(sQLiteDatabase);
                    return;
                case 106:
                    a(sQLiteDatabase, DownloadProvider.i, "mediaprovider_uri", "TEXT");
                    a(sQLiteDatabase, DownloadProvider.i, Impl.COLUMN_DELETED, "BOOLEAN NOT NULL DEFAULT 0");
                    return;
                case 107:
                    a(sQLiteDatabase, DownloadProvider.i, "errorMsg", "TEXT");
                    return;
                case 108:
                    a(sQLiteDatabase, DownloadProvider.i, Impl.COLUMN_ALLOW_METERED, "INTEGER NOT NULL DEFAULT 1");
                    return;
                case 109:
                    a(sQLiteDatabase, DownloadProvider.i, "allow_write", "BOOLEAN NOT NULL DEFAULT 0");
                    return;
                case 110:
                    a(sQLiteDatabase, DownloadProvider.i, "p2s_speed", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.i, "download_speed", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.i, "origin_speed", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.i, "xunlei_spdy", "INTEGER NOT NULL DEFAULT -1");
                    a(sQLiteDatabase, DownloadProvider.i, "extra", "TEXT");
                    f(sQLiteDatabase);
                    return;
                case 111:
                    a(sQLiteDatabase, DownloadProvider.i, "addition_vip_speed", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.i, "cid", "TEXT");
                    a(sQLiteDatabase, DownloadProvider.i, "gcid", "TEXT");
                    a(sQLiteDatabase, DownloadProvider.i, "bt_select_set", "TEXT");
                    a(sQLiteDatabase, DownloadProvider.i, "is_vip_speedup", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.i, "is_lx_speedup", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.i, "create_time", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.i, "download_duration", "INTEGER DEFAULT 0");
                    g(sQLiteDatabase);
                    return;
                case 112:
                    a(sQLiteDatabase, DownloadProvider.i, Impl.COLUMN_ALLOW_AUTO_RESUME, "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.i, "apk_package", "TEXT");
                    a(sQLiteDatabase, DownloadProvider.i, "apk_version", "INTEGER DEFAULT 0");
                    return;
                case 113:
                    a(sQLiteDatabase, DownloadProvider.i, "vip_receive_size", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.i, "vip_status", "INTEGER DEFAULT 190");
                    a(sQLiteDatabase, DownloadProvider.i, "addition_lx_speed", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.i, "lx_receive_size", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.i, "lx_status", "INTEGER DEFAULT 190");
                    a(sQLiteDatabase, DownloadProvider.i, "lx_progress", "REAL DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.i, "p2p_speed", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.i, "p2p_receive_size", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.i, "p2s_receive_size", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.i, "origin_receive_size", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.i, "task_type", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.v, "vip_receive_size", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.v, "vip_status", "INTEGER DEFAULT 190");
                    a(sQLiteDatabase, DownloadProvider.v, "addition_lx_speed", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.v, "lx_receive_size", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.v, "lx_status", "INTEGER DEFAULT 190");
                    a(sQLiteDatabase, DownloadProvider.v, "lx_progress", "REAL DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.v, "p2p_speed", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.v, "p2p_receive_size", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.v, "p2s_receive_size", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.v, "origin_receive_size", "INTEGER DEFAULT 0");
                    return;
                case 114:
                    a(sQLiteDatabase, DownloadProvider.i, Impl.COLUMN_GROUP_ID, "INTEGER DEFAULT 0");
                    return;
                case 115:
                    a(sQLiteDatabase, DownloadProvider.i, Impl.COLUMN_RES_TOTAL, "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.i, Impl.COLUMN_RES_USED_TOTAL, "INTEGER DEFAULT 0");
                    return;
                case 116:
                    a(sQLiteDatabase, DownloadProvider.i, Impl.COLUMN_XL_ORIGIN, "TEXT");
                    return;
                case 117:
                    a(sQLiteDatabase, DownloadProvider.i, Impl.COLUMN_SYNCRO_LX_TASK_TO_SERVER, "INTEGER DEFAULT 0");
                    return;
                case 118:
                    a(sQLiteDatabase, DownloadProvider.i, "dcdn_speed", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.i, "dcdn_receive_size", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.v, "dcdn_speed", "INTEGER DEFAULT 0");
                    a(sQLiteDatabase, DownloadProvider.v, "dcdn_receive_size", "INTEGER DEFAULT 0");
                    return;
                case Opcodes.INVOKE_STATIC_RANGE /*119*/:
                    a(sQLiteDatabase, DownloadProvider.i, "is_dcdn_speedup", "INTEGER DEFAULT 0");
                    return;
                case 120:
                    a(sQLiteDatabase, DownloadProvider.i, Impl.COLUMN_CUSTOM_FLAGS, "INTEGER DEFAULT 0");
                    return;
                case 121:
                    a(sQLiteDatabase, DownloadProvider.i, "vip_errno", "INTEGER DEFAULT -1");
                    a(sQLiteDatabase, DownloadProvider.v, "vip_errno", "INTEGER DEFAULT -1");
                    return;
                case 122:
                    a(sQLiteDatabase, DownloadProvider.i, Impl.COLUMN_RANGE_INFO, "TEXT");
                    a(sQLiteDatabase, DownloadProvider.v, Impl.COLUMN_RANGE_INFO, "TEXT");
                    return;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Don't know how to upgrade to ");
                    stringBuilder.append(i);
                    throw new IllegalStateException(stringBuilder.toString());
            }
        }

        private void b(SQLiteDatabase sQLiteDatabase) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Impl.COLUMN_CURRENT_BYTES, Integer.valueOf(0));
            a(sQLiteDatabase, contentValues);
            contentValues.put("total_bytes", Integer.valueOf(-1));
            a(sQLiteDatabase, contentValues);
            contentValues.put("title", "");
            a(sQLiteDatabase, contentValues);
            contentValues.put("description", "");
            a(sQLiteDatabase, contentValues);
        }

        private void a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
            String str = (String) ((Entry) contentValues.valueSet().iterator().next()).getKey();
            String str2 = DownloadProvider.i;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" is null");
            sQLiteDatabase.update(str2, contentValues, stringBuilder.toString(), null);
            contentValues.clear();
        }

        private void c(SQLiteDatabase sQLiteDatabase) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, Boolean.valueOf(false));
            sQLiteDatabase.update(DownloadProvider.i, contentValues, "destination != 0", null);
        }

        private void a(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3) {
            StringBuilder stringBuilder = new StringBuilder("ALTER TABLE ");
            stringBuilder.append(str);
            stringBuilder.append(" ADD COLUMN ");
            stringBuilder.append(str2);
            stringBuilder.append(" ");
            stringBuilder.append(str3);
            sQLiteDatabase.execSQL(stringBuilder.toString());
        }

        private void d(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS xl_downloads");
                sQLiteDatabase.execSQL("CREATE TABLE xl_downloads(_id INTEGER PRIMARY KEY AUTOINCREMENT,uri TEXT, method INTEGER, entity TEXT, no_integrity BOOLEAN, hint TEXT, otaupdate BOOLEAN, _data TEXT, mimetype TEXT, destination INTEGER, no_system BOOLEAN, visibility INTEGER, control INTEGER, status INTEGER, numfailed INTEGER, lastmod BIGINT, notificationpackage TEXT, notificationclass TEXT, notificationextras TEXT, cookiedata TEXT, useragent TEXT, referer TEXT, total_bytes INTEGER, current_bytes INTEGER, etag TEXT, uid INTEGER, otheruid INTEGER, title TEXT, description TEXT, scanned BOOLEAN);");
            } catch (SQLiteDatabase sQLiteDatabase2) {
                an.d("DownloadManager", "couldn't create table in downloads database");
                throw sQLiteDatabase2;
            }
        }

        private void e(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS request_headers");
            sQLiteDatabase.execSQL("CREATE TABLE request_headers(id INTEGER PRIMARY KEY AUTOINCREMENT,download_id INTEGER NOT NULL,header TEXT NOT NULL,value TEXT NOT NULL);");
        }

        private void f(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS xl_config");
            sQLiteDatabase.execSQL("CREATE TABLE xl_config(id INTEGER PRIMARY KEY AUTOINCREMENT,_key TEXT NOT NULL,_value TEXT NOT NULL);");
            ContentValues contentValues = new ContentValues();
            contentValues.put("_key", com.xunlei.download.proguard.aa.a.a);
            contentValues.put("_value", RePlugin.PROCESS_UI);
            sQLiteDatabase.insert("xl_config", null, contentValues);
            contentValues = new ContentValues();
            contentValues.put("_key", com.xunlei.download.proguard.aa.a.b);
            contentValues.put("_value", Long.valueOf(ad.a(this.a.getContext(), DownloadManager.KEY_RECOMMENDED_MAX_BYTES_OVER_MOBILE, 524288)));
            sQLiteDatabase.insert("xl_config", null, contentValues);
        }

        private void g(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS xl_bt_sub_task");
            sQLiteDatabase.execSQL("CREATE TABLE xl_bt_sub_task(_id INTEGER PRIMARY KEY AUTOINCREMENT,bt_parent_id INTEGER NOT NULL,bt_sub_index INTEGER NOT NULL,title TEXT, _data TEXT, mimetype TEXT, total_bytes INTEGER, current_bytes INTEGER, download_speed INTEGER DEFAULT 0, p2s_speed INTEGER DEFAULT 0, origin_speed INTEGER DEFAULT 0, addition_vip_speed INTEGER DEFAULT 0, cid TEXT, gcid TEXT, status INTEGER, errorMsg TEXT, bt_sub_is_selected INTEGER );");
        }

        public final void a(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS xl_downloads");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS request_headers");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS xl_config");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS xl_bt_sub_task");
            } catch (SQLiteDatabase sQLiteDatabase2) {
                this.a.e();
                an.a("DownloadManager", "couldn't delete table in downloads database.", sQLiteDatabase2);
            }
        }
    }

    static class b {
        public static final String c = " AND ";
        public static final String d = " OR ";
        public StringBuilder a;
        public List<String> b;

        private b() {
            this.a = new StringBuilder();
            this.b = new ArrayList();
        }

        public <T> void a(String str, T... tArr) {
            a(str, c, tArr);
        }

        public <T> void a(String str, String str2, T... tArr) {
            if (str != null) {
                if (str.length() != 0) {
                    if (this.a.length() != 0) {
                        this.a.append(str2);
                    }
                    this.a.append(k.s);
                    this.a.append(str);
                    this.a.append(k.t);
                    if (tArr != null) {
                        for (Object obj : tArr) {
                            this.b.add(obj.toString());
                        }
                    }
                }
            }
        }

        public String a() {
            return this.a.toString();
        }

        public String[] b() {
            return (String[]) this.b.toArray(new String[this.b.size()]);
        }
    }

    static final class c {
        static final String a = "StatTracker";
        static final String b = "null";
        static final String[] c = new String[]{"_id", "status", "uri", "total_bytes", "task_type", "errorMsg", Impl.COLUMN_XL_ORIGIN};
        int d;
        ArrayList<a> e = new ArrayList();

        static final class a {
            long a;
            int b;
            long c;
            int d;
            String e = c.b;
            String f = c.b;

            a() {
            }
        }

        c(long j, int i, int i2, String str, ContentValues contentValues) {
            this.d = i;
            i = new a();
            i.b = i2;
            i.a = ((long) XlTaskHelper.a(j, str)) & -1;
            if (contentValues != null) {
                try {
                    i.c = contentValues.getAsLong("total_bytes").longValue();
                    i.d = contentValues.getAsInteger("task_type").intValue();
                    i.e = contentValues.getAsString("errorMsg");
                    i.f = contentValues.getAsString(Impl.COLUMN_XL_ORIGIN);
                } catch (long j2) {
                    j2.printStackTrace();
                    an.a(j2);
                }
            }
            this.e.add(i);
        }

        c(int i, SQLiteDatabase sQLiteDatabase, b bVar, ContentValues contentValues) {
            if (bVar != null) {
                this.d = i;
                Cursor cursor = null;
                try {
                    sQLiteDatabase = sQLiteDatabase.query(DownloadProvider.i, c, bVar.a(), bVar.b(), null, null, null);
                    if (sQLiteDatabase != null) {
                        try {
                            if (sQLiteDatabase.moveToFirst() != null) {
                                while (sQLiteDatabase.isAfterLast() == null) {
                                    if (i != sQLiteDatabase.getInt(sQLiteDatabase.getColumnIndex("status"))) {
                                        bVar = new a();
                                        long j = sQLiteDatabase.getLong(sQLiteDatabase.getColumnIndex("_id"));
                                        bVar.a = ((long) XlTaskHelper.a(j, sQLiteDatabase.getString(sQLiteDatabase.getColumnIndex("uri")))) & 4294967295L;
                                        String str = a;
                                        StringBuilder stringBuilder = new StringBuilder("trackStatusChange id= ");
                                        stringBuilder.append(j);
                                        stringBuilder.append(", appseqid=");
                                        stringBuilder.append(bVar.a);
                                        an.b(str, stringBuilder.toString());
                                        bVar.b = sQLiteDatabase.getInt(sQLiteDatabase.getColumnIndex("status"));
                                        bVar.c = sQLiteDatabase.getLong(sQLiteDatabase.getColumnIndex("total_bytes"));
                                        bVar.d = sQLiteDatabase.getInt(sQLiteDatabase.getColumnIndex("task_type"));
                                        bVar.e = sQLiteDatabase.getString(sQLiteDatabase.getColumnIndex("errorMsg"));
                                        if (contentValues != null) {
                                            Long asLong = contentValues.getAsLong("total_bytes");
                                            if (asLong != null) {
                                                bVar.c = asLong.longValue();
                                            }
                                            String asString = contentValues.getAsString("errorMsg");
                                            if (asString != null) {
                                                bVar.e = asString;
                                            }
                                        }
                                        bVar.f = sQLiteDatabase.getString(sQLiteDatabase.getColumnIndex(Impl.COLUMN_XL_ORIGIN));
                                        this.e.add(bVar);
                                    }
                                    sQLiteDatabase.moveToNext();
                                }
                            }
                        } catch (Exception e) {
                            i = e;
                            cursor = sQLiteDatabase;
                            try {
                                i.printStackTrace();
                                an.a(i);
                                if (cursor != null) {
                                    cursor.close();
                                }
                            } catch (Throwable th) {
                                i = th;
                                sQLiteDatabase = cursor;
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                                throw i;
                            }
                        } catch (Throwable th2) {
                            i = th2;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            throw i;
                        }
                    }
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                } catch (Exception e2) {
                    i = e2;
                    i.printStackTrace();
                    an.a(i);
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }

        final void a(Context context) {
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                StatHelper.instance(context).trackStatusChange(a((a) it.next()));
            }
        }

        private String a(a aVar) {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder("AppSeqId=");
            stringBuilder2.append(aVar.a);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder(",Status=");
            stringBuilder2.append(this.d);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder(",OldStatus=");
            stringBuilder2.append(aVar.b);
            stringBuilder.append(stringBuilder2.toString());
            if (TextUtils.isEmpty(aVar.e)) {
                aVar.e = b;
            }
            stringBuilder2 = new StringBuilder(",ErrMsg=");
            stringBuilder2.append(aVar.e);
            stringBuilder.append(stringBuilder2.toString());
            if (aVar.c < 0) {
                aVar.c = 0;
            }
            stringBuilder2 = new StringBuilder(",FileSize=");
            stringBuilder2.append(aVar.c);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder2 = new StringBuilder(",TaskType=");
            stringBuilder2.append(aVar.d);
            stringBuilder.append(stringBuilder2.toString());
            if (TextUtils.isEmpty(aVar.f)) {
                aVar.f = b;
            }
            stringBuilder2 = new StringBuilder(",TaskOrigin=");
            stringBuilder2.append(aVar.f);
            stringBuilder.append(stringBuilder2.toString());
            return stringBuilder.toString();
        }
    }

    static {
        r1 = new Uri[2];
        int i = 0;
        r1[0] = Impl.CONTENT_URI;
        r1[1] = Impl.ALL_DOWNLOADS_CONTENT_URI;
        z = r1;
        for (Object add : A) {
            B.add(add);
        }
        HashMap hashMap = new HashMap();
        C = hashMap;
        hashMap.put("_display_name", "title AS _display_name");
        C.put("_size", "total_bytes AS _size");
        String[] strArr = DownloadManager.UNDERLYING_COLUMNS;
        int length = strArr.length;
        while (i < length) {
            D.add(strArr[i]);
            i++;
        }
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        a(providerInfo.authority);
    }

    public static void a(String str) {
        e = str;
        str = new StringBuilder("content://");
        str.append(e);
        str.append("/xl_config");
        d = Uri.parse(str.toString());
        str = new StringBuilder("content://");
        str.append(e);
        str.append("/xl_bt_sub_task");
        c = Uri.parse(str.toString());
        Uri[] uriArr = new Uri[2];
        StringBuilder stringBuilder = new StringBuilder("content://");
        stringBuilder.append(e);
        stringBuilder.append("/my_downloads");
        uriArr[0] = Uri.parse(stringBuilder.toString());
        stringBuilder = new StringBuilder("content://");
        stringBuilder.append(e);
        stringBuilder.append("/all_downloads");
        uriArr[1] = Uri.parse(stringBuilder.toString());
        z = uriArr;
        l.addURI(e, "my_downloads", 1);
        l.addURI(e, "my_downloads/#", 2);
        l.addURI(e, "all_downloads", 3);
        l.addURI(e, "all_downloads/#", 4);
        l.addURI(e, "my_downloads/#/headers", 5);
        l.addURI(e, "all_downloads/#/headers", 5);
        l.addURI(e, "xl_task_group/#/#/headers", 5);
        l.addURI(e, "download", 1);
        l.addURI(e, "download/#", 2);
        l.addURI(e, "download/#/headers", 5);
        l.addURI(e, "public_downloads/#", 6);
        l.addURI(e, "xl_config", 9);
        l.addURI(e, v, 100);
        l.addURI(e, "xl_task_group/#", 200);
        l.addURI(e, "xl_task_group/#/#", 201);
    }

    private void c() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("download_speed", Integer.valueOf(0));
        contentValues.put("origin_speed", Integer.valueOf(0));
        contentValues.put("p2p_speed", Integer.valueOf(0));
        contentValues.put("p2s_speed", Integer.valueOf(0));
        contentValues.put("addition_vip_speed", Integer.valueOf(0));
        contentValues.put("addition_lx_speed", Integer.valueOf(0));
        contentValues.put("dcdn_speed", Integer.valueOf(0));
        contentValues.put("status", Integer.valueOf(190));
        try {
            this.F.getWritableDatabase().update(v, contentValues, "status=192", null);
            this.F.getWritableDatabase().update(i, contentValues, "status=192", null);
        } catch (Throwable e) {
            e();
            e.printStackTrace();
            an.a(e);
        }
    }

    private synchronized SQLiteOpenHelper d() {
        if (this.F == null) {
            final File taskDBFile = DownloadManager.getInstanceFor(getContext()).getTaskDBFile(getContext());
            StringBuilder stringBuilder = new StringBuilder("getTaskDBFile file : ");
            stringBuilder.append(taskDBFile);
            an.b("DownloadManager", stringBuilder.toString());
            if (taskDBFile == null || taskDBFile.isDirectory()) {
                this.F = new a(this, getContext());
            } else {
                this.F = new a(this, new ContextWrapper(this, getContext()) {
                    final /* synthetic */ DownloadProvider b;

                    @SuppressLint({"NewApi"})
                    public SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
                        return super.openOrCreateDatabase(taskDBFile.getAbsolutePath(), i, cursorFactory, databaseErrorHandler);
                    }

                    public SQLiteDatabase openOrCreateDatabase(String str, int i, CursorFactory cursorFactory) {
                        return super.openOrCreateDatabase(taskDBFile.getAbsolutePath(), i, cursorFactory);
                    }

                    public File getDatabasePath(String str) {
                        return taskDBFile;
                    }
                });
            }
            if (this.G && this.F != null) {
                c();
                this.G = false;
            }
        }
        return this.F;
    }

    private synchronized void e() {
        if (this.F != null) {
            this.F.close();
            this.F = null;
            an.b("DownloadManager", "closeDatabaseHelper");
        }
    }

    public boolean onCreate() {
        if (this.f == null) {
            this.f = new o(getContext());
        }
        this.E = new Handler();
        this.H = 1000;
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = getContext().getPackageManager().getApplicationInfo("com.android.defcontainer", 0);
        } catch (Throwable e) {
            an.b("DownloadManager", "Could not get ApplicationInfo for com.android.defconatiner", e);
        }
        if (applicationInfo != null) {
            this.I = applicationInfo.uid;
        }
        Context context = getContext();
        try {
            context.startService(new Intent(context, DownloadService.class));
        } catch (Throwable e2) {
            e2.printStackTrace();
            an.a(e2);
        }
        this.J = q.a(getContext());
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getType(android.net.Uri r5) {
        /*
        r4 = this;
        r0 = l;
        r0 = r0.match(r5);
        r1 = 6;
        if (r0 == r1) goto L_0x0039;
    L_0x0009:
        switch(r0) {
            case 1: goto L_0x0036;
            case 2: goto L_0x0039;
            case 3: goto L_0x0036;
            case 4: goto L_0x0039;
            default: goto L_0x000c;
        };
    L_0x000c:
        switch(r0) {
            case 200: goto L_0x0036;
            case 201: goto L_0x0039;
            default: goto L_0x000f;
        };
    L_0x000f:
        r0 = "DownloadManager";
        r1 = new java.lang.StringBuilder;
        r2 = "calling getType on an unknown URI: ";
        r1.<init>(r2);
        r1.append(r5);
        r1 = r1.toString();
        com.xunlei.download.proguard.an.e(r0, r1);
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r2 = "Unknown URI: ";
        r1.<init>(r2);
        r1.append(r5);
        r5 = r1.toString();
        r0.<init>(r5);
        throw r0;
    L_0x0036:
        r5 = "vnd.android.cursor.dir/download";
        return r5;
    L_0x0039:
        r5 = r4.a(r5, r0);
        r0 = r4.d();
        r0 = r0.getReadableDatabase();
        r1 = "SELECT mimetype FROM xl_downloads WHERE _id = ?";
        r2 = 1;
        r2 = new java.lang.String[r2];
        r3 = 0;
        r2[r3] = r5;
        r5 = android.database.DatabaseUtils.stringForQuery(r0, r1, r2);
        r0 = android.text.TextUtils.isEmpty(r5);
        if (r0 == 0) goto L_0x005a;
    L_0x0057:
        r5 = "vnd.android.cursor.item/download";
        return r5;
    L_0x005a:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.providers.downloads.DownloadProvider.getType(android.net.Uri):java.lang.String");
    }

    private TaskType b(String str) {
        str = ab.b(getContext(), str);
        if (!str.startsWith("http://")) {
            if (!str.startsWith("https://")) {
                if (str.startsWith("magnet:?")) {
                    return TaskType.MAGNET;
                }
                if (str.startsWith("file:///")) {
                    return TaskType.BT;
                }
                if (str.startsWith("ftp://")) {
                    return TaskType.FTP;
                }
                if (str.startsWith("ed2k://")) {
                    return TaskType.ED2K;
                }
                if (str.startsWith("cid://")) {
                    return TaskType.CID;
                }
                if (str.startsWith(DownloadManager.TASK_GROUP_URI_PREFIX) != null) {
                    return TaskType.GROUP;
                }
                return TaskType.UNKOWN;
            }
        }
        return TaskType.HTTP;
    }

    public android.net.Uri insert(android.net.Uri r23, android.content.ContentValues r24) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r22 = this;
        r1 = r22;
        r2 = r23;
        r3 = r24;
        r4 = 0;
        r5 = l;	 Catch:{ Exception -> 0x0550 }
        r5 = r5.match(r2);	 Catch:{ Exception -> 0x0550 }
        r6 = 100;	 Catch:{ Exception -> 0x0550 }
        r7 = -1;	 Catch:{ Exception -> 0x0550 }
        if (r5 != r6) goto L_0x0058;	 Catch:{ Exception -> 0x0550 }
    L_0x0013:
        r5 = r22.d();	 Catch:{ Exception -> 0x0550 }
        r5 = r5.getWritableDatabase();	 Catch:{ Exception -> 0x0550 }
        r6 = "xl_bt_sub_task";	 Catch:{ Exception -> 0x0550 }
        r5 = r5.insert(r6, r4, r3);	 Catch:{ Exception -> 0x0550 }
        r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));	 Catch:{ Exception -> 0x0550 }
        if (r9 != 0) goto L_0x002d;	 Catch:{ Exception -> 0x0550 }
    L_0x0025:
        r2 = "DownloadManager";	 Catch:{ Exception -> 0x0550 }
        r3 = "couldn't insert into bt sub task database";	 Catch:{ Exception -> 0x0550 }
        com.xunlei.download.proguard.an.b(r2, r3);	 Catch:{ Exception -> 0x0550 }
        return r4;	 Catch:{ Exception -> 0x0550 }
    L_0x002d:
        r7 = "DownloadManager";	 Catch:{ Exception -> 0x0550 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0550 }
        r9 = "insert into bt sub task index=";	 Catch:{ Exception -> 0x0550 }
        r8.<init>(r9);	 Catch:{ Exception -> 0x0550 }
        r9 = "bt_sub_index";	 Catch:{ Exception -> 0x0550 }
        r3 = r3.getAsInteger(r9);	 Catch:{ Exception -> 0x0550 }
        r8.append(r3);	 Catch:{ Exception -> 0x0550 }
        r3 = r8.toString();	 Catch:{ Exception -> 0x0550 }
        com.xunlei.download.proguard.an.b(r7, r3);	 Catch:{ Exception -> 0x0550 }
        r3 = r22.getContext();	 Catch:{ Exception -> 0x0550 }
        r3 = r3.getContentResolver();	 Catch:{ Exception -> 0x0550 }
        r3.notifyChange(r2, r4);	 Catch:{ Exception -> 0x0550 }
        r2 = c;	 Catch:{ Exception -> 0x0550 }
        r2 = android.content.ContentUris.withAppendedId(r2, r5);	 Catch:{ Exception -> 0x0550 }
        return r2;	 Catch:{ Exception -> 0x0550 }
    L_0x0058:
        r6 = 9;	 Catch:{ Exception -> 0x0550 }
        if (r5 != r6) goto L_0x007b;	 Catch:{ Exception -> 0x0550 }
    L_0x005c:
        r5 = r22.d();	 Catch:{ Exception -> 0x0550 }
        r5 = r5.getWritableDatabase();	 Catch:{ Exception -> 0x0550 }
        r6 = "xl_config";	 Catch:{ Exception -> 0x0550 }
        r5 = r5.insert(r6, r4, r3);	 Catch:{ Exception -> 0x0550 }
        r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));	 Catch:{ Exception -> 0x0550 }
        if (r3 != 0) goto L_0x0076;	 Catch:{ Exception -> 0x0550 }
    L_0x006e:
        r2 = "DownloadManager";	 Catch:{ Exception -> 0x0550 }
        r3 = "couldn't insert into xl_config database";	 Catch:{ Exception -> 0x0550 }
        com.xunlei.download.proguard.an.b(r2, r3);	 Catch:{ Exception -> 0x0550 }
        return r4;	 Catch:{ Exception -> 0x0550 }
    L_0x0076:
        r2 = android.content.ContentUris.withAppendedId(r2, r5);	 Catch:{ Exception -> 0x0550 }
        return r2;	 Catch:{ Exception -> 0x0550 }
    L_0x007b:
        r1.c(r3);	 Catch:{ Exception -> 0x0550 }
        r6 = 1;	 Catch:{ Exception -> 0x0550 }
        if (r5 == r6) goto L_0x00a8;	 Catch:{ Exception -> 0x0550 }
    L_0x0081:
        r3 = "DownloadManager";	 Catch:{ Exception -> 0x0550 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0550 }
        r6 = "calling insert on an unknown/invalid URI: ";	 Catch:{ Exception -> 0x0550 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x0550 }
        r5.append(r2);	 Catch:{ Exception -> 0x0550 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0550 }
        com.xunlei.download.proguard.an.b(r3, r5);	 Catch:{ Exception -> 0x0550 }
        r3 = new java.lang.IllegalArgumentException;	 Catch:{ Exception -> 0x0550 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0550 }
        r6 = "Unknown/Invalid URI ";	 Catch:{ Exception -> 0x0550 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x0550 }
        r5.append(r2);	 Catch:{ Exception -> 0x0550 }
        r2 = r5.toString();	 Catch:{ Exception -> 0x0550 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0550 }
        throw r3;	 Catch:{ Exception -> 0x0550 }
    L_0x00a8:
        r9 = "DownloadManager";	 Catch:{ Exception -> 0x0550 }
        r10 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0550 }
        r11 = "insert() uri = ";	 Catch:{ Exception -> 0x0550 }
        r10.<init>(r11);	 Catch:{ Exception -> 0x0550 }
        r10.append(r2);	 Catch:{ Exception -> 0x0550 }
        r11 = ", values: ";	 Catch:{ Exception -> 0x0550 }
        r10.append(r11);	 Catch:{ Exception -> 0x0550 }
        r10.append(r3);	 Catch:{ Exception -> 0x0550 }
        r10 = r10.toString();	 Catch:{ Exception -> 0x0550 }
        com.xunlei.download.proguard.an.b(r9, r10);	 Catch:{ Exception -> 0x0550 }
        r9 = "uri";	 Catch:{ Exception -> 0x0550 }
        r9 = r3.getAsString(r9);	 Catch:{ Exception -> 0x0550 }
        r15 = r9.trim();	 Catch:{ Exception -> 0x0550 }
        r9 = r1.b(r15);	 Catch:{ Exception -> 0x0550 }
        r10 = "uri";	 Catch:{ Exception -> 0x0550 }
        r3.put(r10, r15);	 Catch:{ Exception -> 0x0550 }
        r10 = com.xunlei.download.DownloadManager.TaskType.BT;	 Catch:{ Exception -> 0x0550 }
        if (r9 != r10) goto L_0x011a;	 Catch:{ Exception -> 0x0550 }
    L_0x00da:
        r10 = "etag";	 Catch:{ Exception -> 0x0550 }
        r10 = r3.getAsString(r10);	 Catch:{ Exception -> 0x0550 }
        r10 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Exception -> 0x0550 }
        if (r10 == 0) goto L_0x011a;	 Catch:{ Exception -> 0x0550 }
    L_0x00e6:
        r10 = "etag";	 Catch:{ Exception -> 0x0550 }
        r10 = r3.getAsString(r10);	 Catch:{ Exception -> 0x0550 }
        r11 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Exception -> 0x0550 }
        if (r11 == 0) goto L_0x00fa;	 Catch:{ Exception -> 0x0550 }
    L_0x00f2:
        r2 = "DownloadManager";	 Catch:{ Exception -> 0x0550 }
        r3 = "Insert BT Task Without InfoHash";	 Catch:{ Exception -> 0x0550 }
        com.xunlei.download.proguard.an.d(r2, r3);	 Catch:{ Exception -> 0x0550 }
        return r4;	 Catch:{ Exception -> 0x0550 }
    L_0x00fa:
        r11 = r10.length();	 Catch:{ Exception -> 0x0550 }
        r12 = 40;	 Catch:{ Exception -> 0x0550 }
        if (r11 == r12) goto L_0x011a;	 Catch:{ Exception -> 0x0550 }
    L_0x0102:
        r2 = "DownloadManager";	 Catch:{ Exception -> 0x0550 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0550 }
        r5 = "Insert BT Task With bad InfoHash length =";	 Catch:{ Exception -> 0x0550 }
        r3.<init>(r5);	 Catch:{ Exception -> 0x0550 }
        r5 = r10.length();	 Catch:{ Exception -> 0x0550 }
        r3.append(r5);	 Catch:{ Exception -> 0x0550 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0550 }
        com.xunlei.download.proguard.an.d(r2, r3);	 Catch:{ Exception -> 0x0550 }
        return r4;	 Catch:{ Exception -> 0x0550 }
    L_0x011a:
        r10 = r1.a(r2, r3, r9);	 Catch:{ Exception -> 0x0550 }
        r12 = "DownloadManager";	 Catch:{ Exception -> 0x0550 }
        r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0550 }
        r14 = "in insert url=";	 Catch:{ Exception -> 0x0550 }
        r13.<init>(r14);	 Catch:{ Exception -> 0x0550 }
        r14 = r23.toString();	 Catch:{ Exception -> 0x0550 }
        r13.append(r14);	 Catch:{ Exception -> 0x0550 }
        r14 = ", existsId=";	 Catch:{ Exception -> 0x0550 }
        r13.append(r14);	 Catch:{ Exception -> 0x0550 }
        r13.append(r10);	 Catch:{ Exception -> 0x0550 }
        r13 = r13.toString();	 Catch:{ Exception -> 0x0550 }
        com.xunlei.download.proguard.an.b(r12, r13);	 Catch:{ Exception -> 0x0550 }
        r12 = 0;	 Catch:{ Exception -> 0x0550 }
        r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));	 Catch:{ Exception -> 0x0550 }
        if (r14 <= 0) goto L_0x0150;	 Catch:{ Exception -> 0x0550 }
    L_0x0143:
        r2 = r22.getContext();	 Catch:{ Exception -> 0x0550 }
        r2 = com.xunlei.download.DownloadManager.getInstanceFor(r2);	 Catch:{ Exception -> 0x0550 }
        r2 = r2.getDownloadUri(r10);	 Catch:{ Exception -> 0x0550 }
        return r2;	 Catch:{ Exception -> 0x0550 }
    L_0x0150:
        r10 = new android.content.ContentValues;	 Catch:{ Exception -> 0x0550 }
        r10.<init>();	 Catch:{ Exception -> 0x0550 }
        r11 = "uri";	 Catch:{ Exception -> 0x0550 }
        c(r11, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r11 = "entity";	 Catch:{ Exception -> 0x0550 }
        c(r11, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r11 = "no_integrity";	 Catch:{ Exception -> 0x0550 }
        b(r11, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r11 = "hint";	 Catch:{ Exception -> 0x0550 }
        c(r11, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r11 = "mimetype";	 Catch:{ Exception -> 0x0550 }
        c(r11, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r11 = "is_public_api";	 Catch:{ Exception -> 0x0550 }
        b(r11, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r11 = "bt_select_set";	 Catch:{ Exception -> 0x0550 }
        c(r11, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r11 = "is_lx_speedup";	 Catch:{ Exception -> 0x0550 }
        b(r11, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r11 = "is_vip_speedup";	 Catch:{ Exception -> 0x0550 }
        b(r11, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r11 = "syncro_lxtask2server";	 Catch:{ Exception -> 0x0550 }
        b(r11, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r11 = "allow_auto_resume";	 Catch:{ Exception -> 0x0550 }
        b(r11, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r11 = "xunlei_spdy";	 Catch:{ Exception -> 0x0550 }
        b(r11, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r11 = "group_id";	 Catch:{ Exception -> 0x0550 }
        a(r11, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r11 = "xl_origin";	 Catch:{ Exception -> 0x0550 }
        c(r11, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r11 = "custom_flags";	 Catch:{ Exception -> 0x0550 }
        r14 = "custom_flags";	 Catch:{ Exception -> 0x0550 }
        r14 = r3.getAsLong(r14);	 Catch:{ Exception -> 0x0550 }
        r10.put(r11, r14);	 Catch:{ Exception -> 0x0550 }
        r11 = com.xunlei.download.DownloadManager.TaskType.BT;	 Catch:{ Exception -> 0x0550 }
        if (r9 != r11) goto L_0x01af;	 Catch:{ Exception -> 0x0550 }
    L_0x01aa:
        r11 = "etag";	 Catch:{ Exception -> 0x0550 }
        c(r11, r3, r10);	 Catch:{ Exception -> 0x0550 }
    L_0x01af:
        r11 = "is_public_api";	 Catch:{ Exception -> 0x0550 }
        r11 = r3.getAsBoolean(r11);	 Catch:{ Exception -> 0x0550 }
        r14 = java.lang.Boolean.TRUE;	 Catch:{ Exception -> 0x0550 }
        if (r11 != r14) goto L_0x01bb;	 Catch:{ Exception -> 0x0550 }
    L_0x01b9:
        r8 = r6;	 Catch:{ Exception -> 0x0550 }
        goto L_0x01bc;	 Catch:{ Exception -> 0x0550 }
    L_0x01bb:
        r8 = 0;	 Catch:{ Exception -> 0x0550 }
    L_0x01bc:
        r11 = "destination";	 Catch:{ Exception -> 0x0550 }
        r11 = r3.getAsInteger(r11);	 Catch:{ Exception -> 0x0550 }
        r14 = 4;	 Catch:{ Exception -> 0x0550 }
        r4 = 2;	 Catch:{ Exception -> 0x0550 }
        if (r11 == 0) goto L_0x0257;	 Catch:{ Exception -> 0x0550 }
    L_0x01c6:
        r12 = r22.getContext();	 Catch:{ Exception -> 0x0550 }
        r13 = "android.permission.ACCESS_DOWNLOAD_MANAGER_ADVANCED";	 Catch:{ Exception -> 0x0550 }
        r12 = r12.checkCallingPermission(r13);	 Catch:{ Exception -> 0x0550 }
        r13 = 5;	 Catch:{ Exception -> 0x0550 }
        if (r12 == 0) goto L_0x01ff;	 Catch:{ Exception -> 0x0550 }
    L_0x01d3:
        r12 = r11.intValue();	 Catch:{ Exception -> 0x0550 }
        if (r12 == r6) goto L_0x01e6;	 Catch:{ Exception -> 0x0550 }
    L_0x01d9:
        r12 = r11.intValue();	 Catch:{ Exception -> 0x0550 }
        r7 = 3;	 Catch:{ Exception -> 0x0550 }
        if (r12 == r7) goto L_0x01e6;	 Catch:{ Exception -> 0x0550 }
    L_0x01e0:
        r7 = r11.intValue();	 Catch:{ Exception -> 0x0550 }
        if (r7 != r13) goto L_0x01ff;	 Catch:{ Exception -> 0x0550 }
    L_0x01e6:
        r2 = new java.lang.SecurityException;	 Catch:{ Exception -> 0x0550 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0550 }
        r4 = "setting destination to : ";	 Catch:{ Exception -> 0x0550 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x0550 }
        r3.append(r11);	 Catch:{ Exception -> 0x0550 }
        r4 = " not allowed, unless PERMISSION_ACCESS_ADVANCED is granted";	 Catch:{ Exception -> 0x0550 }
        r3.append(r4);	 Catch:{ Exception -> 0x0550 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0550 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0550 }
        throw r2;	 Catch:{ Exception -> 0x0550 }
    L_0x01ff:
        r7 = r22.getContext();	 Catch:{ Exception -> 0x0550 }
        r12 = "android.permission.DOWNLOAD_CACHE_NON_PURGEABLE";	 Catch:{ Exception -> 0x0550 }
        r7 = r7.checkCallingPermission(r12);	 Catch:{ Exception -> 0x0550 }
        if (r7 != 0) goto L_0x020d;	 Catch:{ Exception -> 0x0550 }
    L_0x020b:
        r7 = r6;	 Catch:{ Exception -> 0x0550 }
        goto L_0x020e;	 Catch:{ Exception -> 0x0550 }
    L_0x020d:
        r7 = 0;	 Catch:{ Exception -> 0x0550 }
    L_0x020e:
        if (r8 == 0) goto L_0x021c;	 Catch:{ Exception -> 0x0550 }
    L_0x0210:
        r12 = r11.intValue();	 Catch:{ Exception -> 0x0550 }
        if (r12 != r4) goto L_0x021c;	 Catch:{ Exception -> 0x0550 }
    L_0x0216:
        if (r7 == 0) goto L_0x021c;	 Catch:{ Exception -> 0x0550 }
    L_0x0218:
        r11 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0550 }
    L_0x021c:
        r7 = r11.intValue();	 Catch:{ Exception -> 0x0550 }
        if (r7 != r14) goto L_0x0239;	 Catch:{ Exception -> 0x0550 }
    L_0x0222:
        r7 = r22.getContext();	 Catch:{ Exception -> 0x0550 }
        r12 = "android.permission.WRITE_EXTERNAL_STORAGE";	 Catch:{ Exception -> 0x0550 }
        r13 = android.os.Binder.getCallingPid();	 Catch:{ Exception -> 0x0550 }
        r14 = android.os.Binder.getCallingUid();	 Catch:{ Exception -> 0x0550 }
        r4 = "need WRITE_EXTERNAL_STORAGE permission to use DESTINATION_FILE_URI";	 Catch:{ Exception -> 0x0550 }
        r7.enforcePermission(r12, r13, r14, r4);	 Catch:{ Exception -> 0x0550 }
        r1.b(r3);	 Catch:{ Exception -> 0x0550 }
        goto L_0x0252;	 Catch:{ Exception -> 0x0550 }
    L_0x0239:
        r4 = r11.intValue();	 Catch:{ Exception -> 0x0550 }
        if (r4 != r13) goto L_0x0252;	 Catch:{ Exception -> 0x0550 }
    L_0x023f:
        r4 = r22.getContext();	 Catch:{ Exception -> 0x0550 }
        r7 = "android.permission.ACCESS_CACHE_FILESYSTEM";	 Catch:{ Exception -> 0x0550 }
        r12 = android.os.Binder.getCallingPid();	 Catch:{ Exception -> 0x0550 }
        r13 = android.os.Binder.getCallingUid();	 Catch:{ Exception -> 0x0550 }
        r14 = "need ACCESS_CACHE_FILESYSTEM permission to use system cache";	 Catch:{ Exception -> 0x0550 }
        r4.enforcePermission(r7, r12, r13, r14);	 Catch:{ Exception -> 0x0550 }
    L_0x0252:
        r4 = "destination";	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r11);	 Catch:{ Exception -> 0x0550 }
    L_0x0257:
        r4 = "visibility";	 Catch:{ Exception -> 0x0550 }
        r4 = r3.getAsInteger(r4);	 Catch:{ Exception -> 0x0550 }
        if (r4 != 0) goto L_0x027a;	 Catch:{ Exception -> 0x0550 }
    L_0x025f:
        r4 = r11.intValue();	 Catch:{ Exception -> 0x0550 }
        if (r4 != 0) goto L_0x026f;	 Catch:{ Exception -> 0x0550 }
    L_0x0265:
        r4 = "visibility";	 Catch:{ Exception -> 0x0550 }
        r7 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r7);	 Catch:{ Exception -> 0x0550 }
        goto L_0x027f;	 Catch:{ Exception -> 0x0550 }
    L_0x026f:
        r4 = "visibility";	 Catch:{ Exception -> 0x0550 }
        r7 = 2;	 Catch:{ Exception -> 0x0550 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r7);	 Catch:{ Exception -> 0x0550 }
        goto L_0x027f;	 Catch:{ Exception -> 0x0550 }
    L_0x027a:
        r7 = "visibility";	 Catch:{ Exception -> 0x0550 }
        r10.put(r7, r4);	 Catch:{ Exception -> 0x0550 }
    L_0x027f:
        r4 = "control";	 Catch:{ Exception -> 0x0550 }
        a(r4, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r4 = "scanned";	 Catch:{ Exception -> 0x0550 }
        a(r4, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r4 = "destination";	 Catch:{ Exception -> 0x0550 }
        r4 = r3.getAsInteger(r4);	 Catch:{ Exception -> 0x0550 }
        r4 = r4.intValue();	 Catch:{ Exception -> 0x0550 }
        r7 = 6;	 Catch:{ Exception -> 0x0550 }
        r12 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x0550 }
        if (r4 != r7) goto L_0x033a;	 Catch:{ Exception -> 0x0550 }
    L_0x0298:
        r4 = "status";	 Catch:{ Exception -> 0x0550 }
        r7 = java.lang.Integer.valueOf(r12);	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r7);	 Catch:{ Exception -> 0x0550 }
        r4 = "total_bytes";	 Catch:{ Exception -> 0x0550 }
        r7 = "total_bytes";	 Catch:{ Exception -> 0x0550 }
        r7 = r3.getAsLong(r7);	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r7);	 Catch:{ Exception -> 0x0550 }
        r4 = "current_bytes";	 Catch:{ Exception -> 0x0550 }
        r7 = 0;	 Catch:{ Exception -> 0x0550 }
        r12 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r12);	 Catch:{ Exception -> 0x0550 }
        r4 = "notificationpackage";	 Catch:{ Exception -> 0x0550 }
        r7 = r22.getContext();	 Catch:{ Exception -> 0x0550 }
        r7 = r7.getApplicationContext();	 Catch:{ Exception -> 0x0550 }
        r7 = r7.getPackageName();	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r7);	 Catch:{ Exception -> 0x0550 }
        r4 = com.xunlei.download.DownloadManager.TaskType.UNKOWN;	 Catch:{ Exception -> 0x0550 }
        if (r9 == r4) goto L_0x032c;	 Catch:{ Exception -> 0x0550 }
    L_0x02cb:
        r4 = new java.io.File;	 Catch:{ Exception -> 0x0550 }
        r7 = "_data";	 Catch:{ Exception -> 0x0550 }
        r7 = r3.getAsString(r7);	 Catch:{ Exception -> 0x0550 }
        r4.<init>(r7);	 Catch:{ Exception -> 0x0550 }
        r4 = android.net.Uri.fromFile(r4);	 Catch:{ Exception -> 0x0550 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0550 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0550 }
        r7.<init>();	 Catch:{ Exception -> 0x0550 }
        r12 = java.io.File.separatorChar;	 Catch:{ Exception -> 0x0550 }
        r12 = r4.lastIndexOf(r12);	 Catch:{ Exception -> 0x0550 }
        r12 = r12 + r6;	 Catch:{ Exception -> 0x0550 }
        r13 = 0;	 Catch:{ Exception -> 0x0550 }
        r4 = r4.substring(r13, r12);	 Catch:{ Exception -> 0x0550 }
        r7.append(r4);	 Catch:{ Exception -> 0x0550 }
        r4 = "{filename}";	 Catch:{ Exception -> 0x0550 }
        r7.append(r4);	 Catch:{ Exception -> 0x0550 }
        r4 = r7.toString();	 Catch:{ Exception -> 0x0550 }
        r7 = "hint";	 Catch:{ Exception -> 0x0550 }
        r10.put(r7, r4);	 Catch:{ Exception -> 0x0550 }
        r4 = "destination";	 Catch:{ Exception -> 0x0550 }
        r7 = 4;	 Catch:{ Exception -> 0x0550 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r7);	 Catch:{ Exception -> 0x0550 }
        r4 = "task_type";	 Catch:{ Exception -> 0x0550 }
        r7 = r9.ordinal();	 Catch:{ Exception -> 0x0550 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r7);	 Catch:{ Exception -> 0x0550 }
        r4 = com.xunlei.download.DownloadManager.TaskType.HTTP;	 Catch:{ Exception -> 0x0550 }
        if (r9 != r4) goto L_0x0323;	 Catch:{ Exception -> 0x0550 }
    L_0x031b:
        r4 = "thunder://";	 Catch:{ Exception -> 0x0550 }
        r4 = r15.startsWith(r4);	 Catch:{ Exception -> 0x0550 }
        if (r4 == 0) goto L_0x032c;	 Catch:{ Exception -> 0x0550 }
    L_0x0323:
        r4 = "xunlei_spdy";	 Catch:{ Exception -> 0x0550 }
        r7 = java.lang.Boolean.valueOf(r6);	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r7);	 Catch:{ Exception -> 0x0550 }
    L_0x032c:
        r4 = "_data";	 Catch:{ Exception -> 0x0550 }
        c(r4, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r4 = "allow_write";	 Catch:{ Exception -> 0x0550 }
        b(r4, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r19 = r8;	 Catch:{ Exception -> 0x0550 }
        goto L_0x03e7;	 Catch:{ Exception -> 0x0550 }
    L_0x033a:
        r4 = "status";	 Catch:{ Exception -> 0x0550 }
        r7 = 190; // 0xbe float:2.66E-43 double:9.4E-322;	 Catch:{ Exception -> 0x0550 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r7);	 Catch:{ Exception -> 0x0550 }
        r4 = "_data";	 Catch:{ Exception -> 0x0550 }
        r4 = r3.getAsString(r4);	 Catch:{ Exception -> 0x0550 }
        if (r4 != 0) goto L_0x0364;	 Catch:{ Exception -> 0x0550 }
    L_0x034d:
        r4 = "total_bytes";	 Catch:{ Exception -> 0x0550 }
        r7 = -1;	 Catch:{ Exception -> 0x0550 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r7);	 Catch:{ Exception -> 0x0550 }
        r4 = "current_bytes";	 Catch:{ Exception -> 0x0550 }
        r7 = 0;	 Catch:{ Exception -> 0x0550 }
        r12 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r12);	 Catch:{ Exception -> 0x0550 }
        r19 = r8;	 Catch:{ Exception -> 0x0550 }
        goto L_0x03a5;	 Catch:{ Exception -> 0x0550 }
    L_0x0364:
        r7 = 0;	 Catch:{ Exception -> 0x0550 }
        r4 = "total_bytes";	 Catch:{ Exception -> 0x0550 }
        r4 = r3.getAsLong(r4);	 Catch:{ Exception -> 0x0550 }
        r13 = r4.longValue();	 Catch:{ Exception -> 0x0550 }
        r4 = "current_bytes";	 Catch:{ Exception -> 0x0550 }
        r4 = r3.getAsLong(r4);	 Catch:{ Exception -> 0x0550 }
        r19 = r8;	 Catch:{ Exception -> 0x0550 }
        r7 = r4.longValue();	 Catch:{ Exception -> 0x0550 }
        r4 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1));	 Catch:{ Exception -> 0x0550 }
        if (r4 != 0) goto L_0x038e;	 Catch:{ Exception -> 0x0550 }
    L_0x037f:
        r17 = 0;	 Catch:{ Exception -> 0x0550 }
        r4 = (r13 > r17 ? 1 : (r13 == r17 ? 0 : -1));	 Catch:{ Exception -> 0x0550 }
        if (r4 <= 0) goto L_0x038e;	 Catch:{ Exception -> 0x0550 }
    L_0x0385:
        r4 = "status";	 Catch:{ Exception -> 0x0550 }
        r12 = java.lang.Integer.valueOf(r12);	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r12);	 Catch:{ Exception -> 0x0550 }
    L_0x038e:
        r4 = "total_bytes";	 Catch:{ Exception -> 0x0550 }
        r12 = java.lang.Long.valueOf(r13);	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r12);	 Catch:{ Exception -> 0x0550 }
        r4 = "current_bytes";	 Catch:{ Exception -> 0x0550 }
        r7 = java.lang.Long.valueOf(r7);	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r7);	 Catch:{ Exception -> 0x0550 }
        r4 = "_data";	 Catch:{ Exception -> 0x0550 }
        c(r4, r3, r10);	 Catch:{ Exception -> 0x0550 }
    L_0x03a5:
        r4 = "DownloadManager";	 Catch:{ Exception -> 0x0550 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0550 }
        r8 = "insert contentvalues = ";	 Catch:{ Exception -> 0x0550 }
        r7.<init>(r8);	 Catch:{ Exception -> 0x0550 }
        r7.append(r10);	 Catch:{ Exception -> 0x0550 }
        r7 = r7.toString();	 Catch:{ Exception -> 0x0550 }
        com.xunlei.download.proguard.an.b(r4, r7);	 Catch:{ Exception -> 0x0550 }
        r4 = com.xunlei.download.DownloadManager.TaskType.UNKOWN;	 Catch:{ Exception -> 0x0550 }
        if (r9 != r4) goto L_0x03c5;	 Catch:{ Exception -> 0x0550 }
    L_0x03bc:
        r2 = "DownloadManager";	 Catch:{ Exception -> 0x0550 }
        r3 = "UNKOWN PROTOCAL";	 Catch:{ Exception -> 0x0550 }
        com.xunlei.download.proguard.an.b(r2, r3);	 Catch:{ Exception -> 0x0550 }
        r2 = 0;	 Catch:{ Exception -> 0x0550 }
        return r2;	 Catch:{ Exception -> 0x0550 }
    L_0x03c5:
        r4 = com.xunlei.download.DownloadManager.TaskType.HTTP;	 Catch:{ Exception -> 0x0550 }
        if (r9 != r4) goto L_0x03d1;	 Catch:{ Exception -> 0x0550 }
    L_0x03c9:
        r4 = "thunder://";	 Catch:{ Exception -> 0x0550 }
        r4 = r15.startsWith(r4);	 Catch:{ Exception -> 0x0550 }
        if (r4 == 0) goto L_0x03da;	 Catch:{ Exception -> 0x0550 }
    L_0x03d1:
        r4 = "xunlei_spdy";	 Catch:{ Exception -> 0x0550 }
        r7 = java.lang.Boolean.valueOf(r6);	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r7);	 Catch:{ Exception -> 0x0550 }
    L_0x03da:
        r4 = "task_type";	 Catch:{ Exception -> 0x0550 }
        r7 = r9.ordinal();	 Catch:{ Exception -> 0x0550 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r7);	 Catch:{ Exception -> 0x0550 }
    L_0x03e7:
        r4 = "create_time";	 Catch:{ Exception -> 0x0550 }
        r7 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0550 }
        r7 = java.lang.Long.valueOf(r7);	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r7);	 Catch:{ Exception -> 0x0550 }
        r4 = r1.f;	 Catch:{ Exception -> 0x0550 }
        r7 = r4.a();	 Catch:{ Exception -> 0x0550 }
        r4 = "lastmod";	 Catch:{ Exception -> 0x0550 }
        r7 = java.lang.Long.valueOf(r7);	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r7);	 Catch:{ Exception -> 0x0550 }
        r4 = "notificationpackage";	 Catch:{ Exception -> 0x0550 }
        r4 = r3.getAsString(r4);	 Catch:{ Exception -> 0x0550 }
        r7 = "notificationclass";	 Catch:{ Exception -> 0x0550 }
        r7 = r3.getAsString(r7);	 Catch:{ Exception -> 0x0550 }
        if (r4 == 0) goto L_0x042f;	 Catch:{ Exception -> 0x0550 }
    L_0x0411:
        if (r7 != 0) goto L_0x0415;	 Catch:{ Exception -> 0x0550 }
    L_0x0413:
        if (r19 == 0) goto L_0x042f;	 Catch:{ Exception -> 0x0550 }
    L_0x0415:
        r8 = android.os.Binder.getCallingUid();	 Catch:{ Exception -> 0x0550 }
        if (r8 == 0) goto L_0x0423;
    L_0x041b:
        r12 = r1.f;	 Catch:{ NameNotFoundException -> 0x042f }
        r8 = r12.a(r8, r4);	 Catch:{ NameNotFoundException -> 0x042f }
        if (r8 == 0) goto L_0x042f;	 Catch:{ NameNotFoundException -> 0x042f }
    L_0x0423:
        r8 = "notificationpackage";	 Catch:{ NameNotFoundException -> 0x042f }
        r10.put(r8, r4);	 Catch:{ NameNotFoundException -> 0x042f }
        if (r7 == 0) goto L_0x042f;	 Catch:{ NameNotFoundException -> 0x042f }
    L_0x042a:
        r4 = "notificationclass";	 Catch:{ NameNotFoundException -> 0x042f }
        r10.put(r4, r7);	 Catch:{ NameNotFoundException -> 0x042f }
    L_0x042f:
        r4 = "notificationextras";	 Catch:{ Exception -> 0x0550 }
        c(r4, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r4 = "cookiedata";	 Catch:{ Exception -> 0x0550 }
        c(r4, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r4 = "useragent";	 Catch:{ Exception -> 0x0550 }
        c(r4, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r4 = "referer";	 Catch:{ Exception -> 0x0550 }
        c(r4, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r4 = r22.getContext();	 Catch:{ Exception -> 0x0550 }
        r7 = "android.permission.ACCESS_DOWNLOAD_MANAGER_ADVANCED";	 Catch:{ Exception -> 0x0550 }
        r4 = r4.checkCallingPermission(r7);	 Catch:{ Exception -> 0x0550 }
        if (r4 != 0) goto L_0x0454;	 Catch:{ Exception -> 0x0550 }
    L_0x044f:
        r4 = "otheruid";	 Catch:{ Exception -> 0x0550 }
        a(r4, r3, r10);	 Catch:{ Exception -> 0x0550 }
    L_0x0454:
        r4 = "uid";	 Catch:{ Exception -> 0x0550 }
        r7 = android.os.Binder.getCallingUid();	 Catch:{ Exception -> 0x0550 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r7);	 Catch:{ Exception -> 0x0550 }
        r4 = android.os.Binder.getCallingUid();	 Catch:{ Exception -> 0x0550 }
        if (r4 != 0) goto L_0x046c;	 Catch:{ Exception -> 0x0550 }
    L_0x0467:
        r4 = "uid";	 Catch:{ Exception -> 0x0550 }
        a(r4, r3, r10);	 Catch:{ Exception -> 0x0550 }
    L_0x046c:
        r4 = "title";	 Catch:{ Exception -> 0x0550 }
        r7 = "";	 Catch:{ Exception -> 0x0550 }
        a(r4, r3, r10, r7);	 Catch:{ Exception -> 0x0550 }
        r4 = "description";	 Catch:{ Exception -> 0x0550 }
        r7 = "";	 Catch:{ Exception -> 0x0550 }
        a(r4, r3, r10, r7);	 Catch:{ Exception -> 0x0550 }
        r4 = "is_visible_in_downloads_ui";	 Catch:{ Exception -> 0x0550 }
        r4 = r3.containsKey(r4);	 Catch:{ Exception -> 0x0550 }
        if (r4 == 0) goto L_0x0488;	 Catch:{ Exception -> 0x0550 }
    L_0x0482:
        r4 = "is_visible_in_downloads_ui";	 Catch:{ Exception -> 0x0550 }
        b(r4, r3, r10);	 Catch:{ Exception -> 0x0550 }
        goto L_0x049b;	 Catch:{ Exception -> 0x0550 }
    L_0x0488:
        if (r11 == 0) goto L_0x0492;	 Catch:{ Exception -> 0x0550 }
    L_0x048a:
        r4 = r11.intValue();	 Catch:{ Exception -> 0x0550 }
        if (r4 != 0) goto L_0x0491;	 Catch:{ Exception -> 0x0550 }
    L_0x0490:
        goto L_0x0492;	 Catch:{ Exception -> 0x0550 }
    L_0x0491:
        r6 = 0;	 Catch:{ Exception -> 0x0550 }
    L_0x0492:
        r4 = "is_visible_in_downloads_ui";	 Catch:{ Exception -> 0x0550 }
        r6 = java.lang.Boolean.valueOf(r6);	 Catch:{ Exception -> 0x0550 }
        r10.put(r4, r6);	 Catch:{ Exception -> 0x0550 }
    L_0x049b:
        if (r19 == 0) goto L_0x04b1;	 Catch:{ Exception -> 0x0550 }
    L_0x049d:
        r4 = "allowed_network_types";	 Catch:{ Exception -> 0x0550 }
        a(r4, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r4 = "allow_roaming";	 Catch:{ Exception -> 0x0550 }
        b(r4, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r4 = "allow_metered";	 Catch:{ Exception -> 0x0550 }
        b(r4, r3, r10);	 Catch:{ Exception -> 0x0550 }
        r4 = "bypass_recommended_size_limit";	 Catch:{ Exception -> 0x0550 }
        b(r4, r3, r10);	 Catch:{ Exception -> 0x0550 }
    L_0x04b1:
        r4 = com.xunlei.download.DownloadManager.TaskType.BT;	 Catch:{ Exception -> 0x0550 }
        if (r9 != r4) goto L_0x04cd;	 Catch:{ Exception -> 0x0550 }
    L_0x04b5:
        r4 = r22.getContext();	 Catch:{ Exception -> 0x0550 }
        r6 = 0;	 Catch:{ Exception -> 0x0550 }
        r4 = com.xunlei.download.proguard.j.a(r4, r6, r6, r6, r6);	 Catch:{ Exception -> 0x0550 }
        if (r4 == 0) goto L_0x04ca;	 Catch:{ Exception -> 0x0550 }
    L_0x04c0:
        r6 = r22.getContext();	 Catch:{ Exception -> 0x0550 }
        r6 = r4.a(r6, r10);	 Catch:{ Exception -> 0x0550 }
        r7 = r4;	 Catch:{ Exception -> 0x0550 }
        goto L_0x04cf;	 Catch:{ Exception -> 0x0550 }
    L_0x04ca:
        r7 = r4;	 Catch:{ Exception -> 0x0550 }
        r6 = r10;	 Catch:{ Exception -> 0x0550 }
        goto L_0x04cf;	 Catch:{ Exception -> 0x0550 }
    L_0x04cd:
        r6 = r10;	 Catch:{ Exception -> 0x0550 }
        r7 = 0;	 Catch:{ Exception -> 0x0550 }
    L_0x04cf:
        r4 = r22.d();	 Catch:{ Exception -> 0x0550 }
        r4 = r4.getWritableDatabase();	 Catch:{ Exception -> 0x0550 }
        r8 = "xl_downloads";	 Catch:{ Exception -> 0x0550 }
        r9 = 0;	 Catch:{ Exception -> 0x0550 }
        r13 = r4.insert(r8, r9, r6);	 Catch:{ Exception -> 0x0550 }
        r10 = -1;	 Catch:{ Exception -> 0x0550 }
        r8 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1));	 Catch:{ Exception -> 0x0550 }
        if (r8 != 0) goto L_0x04ec;	 Catch:{ Exception -> 0x0550 }
    L_0x04e4:
        r2 = "DownloadManager";	 Catch:{ Exception -> 0x0550 }
        r3 = "couldn't insert into downloads database";	 Catch:{ Exception -> 0x0550 }
        com.xunlei.download.proguard.an.b(r2, r3);	 Catch:{ Exception -> 0x0550 }
        return r9;	 Catch:{ Exception -> 0x0550 }
    L_0x04ec:
        r8 = new com.android.providers.downloads.DownloadProvider$c;	 Catch:{ Exception -> 0x0550 }
        r9 = "status";	 Catch:{ Exception -> 0x0550 }
        r9 = r6.getAsInteger(r9);	 Catch:{ Exception -> 0x0550 }
        r9 = r9.intValue();	 Catch:{ Exception -> 0x0550 }
        r16 = 0;	 Catch:{ Exception -> 0x0550 }
        r10 = r8;	 Catch:{ Exception -> 0x0550 }
        r11 = r13;	 Catch:{ Exception -> 0x0550 }
        r20 = r13;	 Catch:{ Exception -> 0x0550 }
        r13 = r9;	 Catch:{ Exception -> 0x0550 }
        r14 = r16;	 Catch:{ Exception -> 0x0550 }
        r16 = r6;	 Catch:{ Exception -> 0x0550 }
        r10.<init>(r11, r13, r14, r15, r16);	 Catch:{ Exception -> 0x0550 }
        r9 = r22.getContext();	 Catch:{ Exception -> 0x0550 }
        r8.a(r9);	 Catch:{ Exception -> 0x0550 }
        if (r7 == 0) goto L_0x0524;	 Catch:{ Exception -> 0x0550 }
    L_0x050f:
        r8 = r22.getContext();	 Catch:{ Exception -> 0x0550 }
        r9 = "bt_select_set";	 Catch:{ Exception -> 0x0550 }
        r11 = r6.getAsString(r9);	 Catch:{ Exception -> 0x0550 }
        r9 = "_data";	 Catch:{ Exception -> 0x0550 }
        r12 = r6.getAsString(r9);	 Catch:{ Exception -> 0x0550 }
        r9 = r20;	 Catch:{ Exception -> 0x0550 }
        r7.a(r8, r9, r11, r12);	 Catch:{ Exception -> 0x0550 }
    L_0x0524:
        r6 = r20;	 Catch:{ Exception -> 0x0550 }
        r1.a(r4, r6, r3);	 Catch:{ Exception -> 0x0550 }
        r1.b(r2, r5);	 Catch:{ Exception -> 0x0550 }
        r2 = r22.getContext();	 Catch:{ Exception -> 0x0550 }
        r3 = new android.content.Intent;	 Catch:{ Exception -> 0x053b }
        r4 = com.android.providers.downloads.DownloadService.class;	 Catch:{ Exception -> 0x053b }
        r3.<init>(r2, r4);	 Catch:{ Exception -> 0x053b }
        r2.startService(r3);	 Catch:{ Exception -> 0x053b }
        goto L_0x0543;
    L_0x053b:
        r0 = move-exception;
        r3 = r0;
        r3.printStackTrace();	 Catch:{ Exception -> 0x0550 }
        com.xunlei.download.proguard.an.a(r3);	 Catch:{ Exception -> 0x0550 }
    L_0x0543:
        r2 = com.xunlei.download.DownloadManager.getInstanceFor(r2);	 Catch:{ Exception -> 0x0550 }
        r2 = r2.getDownloadUri();	 Catch:{ Exception -> 0x0550 }
        r2 = android.content.ContentUris.withAppendedId(r2, r6);	 Catch:{ Exception -> 0x0550 }
        return r2;
    L_0x0550:
        r0 = move-exception;
        r2 = r0;
        r22.e();
        r2.printStackTrace();
        com.xunlei.download.proguard.an.a(r2);
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.providers.downloads.DownloadProvider.insert(android.net.Uri, android.content.ContentValues):android.net.Uri");
    }

    private long a(Uri uri, ContentValues contentValues, TaskType taskType) {
        String asString = contentValues.getAsString("uri");
        String asString2 = contentValues.getAsString(Impl.COLUMN_FILE_NAME_HINT);
        int intValue = contentValues.getAsInteger(Impl.COLUMN_DESTINATION).intValue();
        long j = -1;
        if (taskType != TaskType.UNKOWN) {
            if (intValue != 6) {
                asString = asString.replaceAll("'", "''");
                if (!TextUtils.isEmpty(asString2)) {
                    asString2 = asString2.replaceAll("'", "''");
                }
                Object asString3 = contentValues.getAsString("etag");
                if (taskType == TaskType.BT && TextUtils.isEmpty(asString3) == null) {
                    taskType = new StringBuilder(" (etag='");
                    taskType.append(asString3);
                    taskType.append("' ) AND (hint='");
                    taskType.append(asString2);
                    taskType.append("' ) AND (deleted != '1')");
                    taskType = taskType.toString();
                } else {
                    taskType = new StringBuilder(" (uri='");
                    taskType.append(asString);
                    taskType.append("' ) AND (hint='");
                    taskType.append(asString2);
                    taskType.append("' ) AND (deleted != '1')");
                    taskType = taskType.toString();
                }
                TaskType taskType2 = taskType;
                taskType = null;
                try {
                    Cursor query = query(uri, null, taskType2, null, null);
                    if (query != null) {
                        try {
                            if (query.moveToFirst() != null) {
                                taskType = query.getColumnIndexOrThrow("status");
                                query.getColumnIndexOrThrow(Impl._DATA);
                                int columnIndexOrThrow = query.getColumnIndexOrThrow("_id");
                                intValue = query.getColumnIndexOrThrow(Impl.COLUMN_DELETED);
                                long currentTimeMillis = System.currentTimeMillis();
                                while (!query.isAfterLast()) {
                                    int i = query.getInt(taskType);
                                    ContentValues contentValues2 = new ContentValues();
                                    contentValues2.put(Impl.COLUMN_LAST_MODIFICATION, Long.valueOf(currentTimeMillis));
                                    Integer asInteger = contentValues.getAsInteger(Impl.COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT);
                                    if (asInteger != null) {
                                        contentValues2.put(Impl.COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT, asInteger);
                                    }
                                    asInteger = contentValues.getAsInteger(Impl.COLUMN_ALLOWED_NETWORK_TYPES);
                                    if (asInteger != null) {
                                        contentValues2.put(Impl.COLUMN_ALLOWED_NETWORK_TYPES, asInteger);
                                    }
                                    if (query.getInt(intValue) == 1) {
                                        break;
                                    } else if (Impl.isStatusInformational(i)) {
                                        j = (long) query.getInt(columnIndexOrThrow);
                                        if (i == 190 || i == 192) {
                                            update(uri, contentValues2, a(), a(j));
                                        } else if (i == 200) {
                                            if (query != null) {
                                                query.close();
                                            }
                                            return j;
                                        } else {
                                            a(contentValues2);
                                            update(uri, contentValues2, a(), a(j));
                                        }
                                    } else if (Impl.isStatusError(i)) {
                                        j = (long) query.getInt(columnIndexOrThrow);
                                        contentValues2.put(Impl.COLUMN_CONTROL, Integer.valueOf(0));
                                        contentValues2.put("status", Integer.valueOf(190));
                                        contentValues2.put(Impl.COLUMN_FAILED_CONNECTIONS, Integer.valueOf(0));
                                        update(uri, contentValues2, a(), a(j));
                                        break;
                                    } else {
                                        query.moveToNext();
                                    }
                                }
                            }
                        } catch (Exception e) {
                            uri = e;
                            taskType = query;
                            try {
                                e();
                                uri.printStackTrace();
                                an.a(uri);
                                if (taskType != null) {
                                    taskType.close();
                                }
                                return j;
                            } catch (Throwable th) {
                                uri = th;
                                query = taskType;
                                if (query != null) {
                                    query.close();
                                }
                                throw uri;
                            }
                        } catch (Throwable th2) {
                            uri = th2;
                            if (query != null) {
                                query.close();
                            }
                            throw uri;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e2) {
                    uri = e2;
                    e();
                    uri.printStackTrace();
                    an.a(uri);
                    if (taskType != null) {
                        taskType.close();
                    }
                    return j;
                }
                return j;
            }
        }
        return -1;
    }

    private void b(ContentValues contentValues) {
        contentValues = contentValues.getAsString(Impl.COLUMN_FILE_NAME_HINT);
        if (contentValues == null) {
            throw new IllegalArgumentException("DESTINATION_FILE_URI must include a file URI under COLUMN_FILE_NAME_HINT");
        }
        StringBuilder stringBuilder;
        contentValues = Uri.parse(contentValues);
        String scheme = contentValues.getScheme();
        if (scheme != null) {
            if (scheme.equals("file")) {
                scheme = contentValues.getPath();
                if (scheme == null) {
                    stringBuilder = new StringBuilder("Invalid file URI: ");
                    stringBuilder.append(contentValues);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                File file = new File(scheme);
                do {
                    file = file.getParentFile();
                    if (file == null) {
                        break;
                    }
                } while (!file.exists());
                if (file == null) {
                    stringBuilder = new StringBuilder("Destination must be on external storage: ");
                    stringBuilder.append(contentValues);
                    throw new SecurityException(stringBuilder.toString());
                }
                return;
            }
        }
        stringBuilder = new StringBuilder("Not a file URI: ");
        stringBuilder.append(contentValues);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private void c(ContentValues contentValues) {
        if (getContext().checkCallingOrSelfPermission(Impl.PERMISSION_ACCESS) != 0) {
            getContext().enforceCallingOrSelfPermission(MsgConstant.PERMISSION_INTERNET, "INTERNET permission is required to use the download manager");
            ContentValues contentValues2 = new ContentValues(contentValues);
            a(contentValues2, Impl.COLUMN_IS_PUBLIC_API, Boolean.TRUE);
            if (contentValues2.getAsInteger(Impl.COLUMN_DESTINATION).intValue() == 6) {
                contentValues2.remove("status");
            }
            contentValues2.remove(Impl._DATA);
            contentValues2.remove("total_bytes");
            contentValues2.remove(Impl.COLUMN_CURRENT_BYTES);
            contentValues2.remove("etag");
            a(contentValues2, Impl.COLUMN_DESTINATION, Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(6));
            if (getContext().checkCallingOrSelfPermission(Impl.PERMISSION_NO_NOTIFICATION) == null) {
                a(contentValues2, Impl.COLUMN_VISIBILITY, Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3));
            } else {
                a(contentValues2, Impl.COLUMN_VISIBILITY, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3));
            }
            contentValues2.remove("uri");
            contentValues2.remove("title");
            contentValues2.remove("description");
            contentValues2.remove("mimetype");
            contentValues2.remove(Impl.COLUMN_FILE_NAME_HINT);
            contentValues2.remove(Impl.COLUMN_NOTIFICATION_PACKAGE);
            contentValues2.remove(Impl.COLUMN_ALLOWED_NETWORK_TYPES);
            contentValues2.remove(Impl.COLUMN_ALLOW_ROAMING);
            contentValues2.remove(Impl.COLUMN_ALLOW_METERED);
            contentValues2.remove(Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI);
            contentValues2.remove("scanned");
            contentValues2.remove("allow_write");
            contentValues2.remove("xunlei_spdy");
            contentValues2.remove("bt_select_set");
            contentValues2.remove("is_vip_speedup");
            contentValues2.remove("is_lx_speedup");
            contentValues2.remove(Impl.COLUMN_ALLOW_AUTO_RESUME);
            contentValues2.remove(Impl.COLUMN_GROUP_ID);
            contentValues2.remove(Impl.COLUMN_XL_ORIGIN);
            contentValues2.remove(Impl.COLUMN_SYNCRO_LX_TASK_TO_SERVER);
            contentValues2.remove(Impl.COLUMN_CUSTOM_FLAGS);
            contentValues = contentValues2.valueSet().iterator();
            while (contentValues.hasNext()) {
                if (((String) ((Entry) contentValues.next()).getKey()).startsWith(RequestHeaders.INSERT_KEY_PREFIX)) {
                    contentValues.remove();
                }
            }
            if (contentValues2.size() > null) {
                contentValues = new StringBuilder("Invalid columns in request: ");
                for (Entry key : contentValues2.valueSet()) {
                    contentValues.append((String) key.getKey());
                }
                throw new SecurityException(contentValues.toString());
            }
        }
    }

    private void a(ContentValues contentValues, String str, Object... objArr) {
        Object obj = contentValues.get(str);
        contentValues.remove(str);
        contentValues = null;
        int length = objArr.length;
        while (contentValues < length) {
            Object obj2 = objArr[contentValues];
            if (obj != null || obj2 != null) {
                if (obj == null || !obj.equals(obj2)) {
                    contentValues++;
                } else {
                    return;
                }
            }
            return;
        }
        objArr = new StringBuilder("Invalid value for ");
        objArr.append(str);
        objArr.append(": ");
        objArr.append(obj);
        throw new SecurityException(objArr.toString());
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            SQLiteDatabase readableDatabase = d().getReadableDatabase();
            int match = l.match(uri);
            if (match == 9) {
                return readableDatabase.query("xl_config", strArr, str, strArr2, null, null, str2);
            }
            if (match == 100) {
                strArr = readableDatabase.query(v, strArr, str, strArr2, null, null, str2);
                if (strArr != null) {
                    strArr.setNotificationUri(getContext().getContentResolver(), uri);
                }
                return strArr;
            }
            com.xunlei.download.proguard.k.a(str, B);
            if (match == -1) {
                str = new StringBuilder("querying unknown URI: ");
                str.append(uri);
                an.e("DownloadManager", str.toString());
                str = new StringBuilder("Unknown URI: ");
                str.append(uri);
                throw new IllegalArgumentException(str.toString());
            } else if (match == 5) {
                if (strArr == null && str == null) {
                    if (str2 == null) {
                        return a(readableDatabase, uri);
                    }
                }
                throw new UnsupportedOperationException("Request header queries do not support projections, selections or sorting");
            } else {
                str = a(uri, str, strArr2, match);
                if (f() != null) {
                    strArr2 = null;
                    if (strArr == null) {
                        strArr = (String[]) A.clone();
                    } else {
                        match = 0;
                        while (match < strArr.length) {
                            if (B.contains(strArr[match]) || D.contains(strArr[match])) {
                                match++;
                            } else {
                                str = new StringBuilder("column ");
                                str.append(strArr[match]);
                                str.append(" is not allowed in queries");
                                throw new IllegalArgumentException(str.toString());
                            }
                        }
                    }
                    while (strArr2 < strArr.length) {
                        String str3 = (String) C.get(strArr[strArr2]);
                        if (str3 != null) {
                            strArr[strArr2] = str3;
                        }
                        strArr2++;
                    }
                }
                strArr = readableDatabase.query(i, strArr, str.a(), str.b(), null, null, str2);
                if (strArr != null) {
                    strArr.setNotificationUri(getContext().getContentResolver(), uri);
                } else {
                    an.e("DownloadManager", "query failed in downloads database");
                }
                return strArr;
            }
        } catch (Uri uri2) {
            e();
            uri2.printStackTrace();
            an.a(uri2);
            return null;
        }
    }

    private void a(String[] strArr, String str, String[] strArr2, String str2, SQLiteDatabase sQLiteDatabase) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("starting query, database is ");
        if (sQLiteDatabase != null) {
            stringBuilder.append("not ");
        }
        stringBuilder.append("null; ");
        sQLiteDatabase = null;
        if (strArr == null) {
            stringBuilder.append("projection is null; ");
        } else if (strArr.length == 0) {
            stringBuilder.append("projection is empty; ");
        } else {
            for (int i = 0; i < strArr.length; i++) {
                stringBuilder.append("projection[");
                stringBuilder.append(i);
                stringBuilder.append("] is ");
                stringBuilder.append(strArr[i]);
                stringBuilder.append("; ");
            }
        }
        stringBuilder.append("selection is ");
        stringBuilder.append(str);
        stringBuilder.append("; ");
        if (strArr2 == null) {
            stringBuilder.append("selectionArgs is null; ");
        } else if (strArr2.length == null) {
            stringBuilder.append("selectionArgs is empty; ");
        } else {
            while (sQLiteDatabase < strArr2.length) {
                stringBuilder.append("selectionArgs[");
                stringBuilder.append(sQLiteDatabase);
                stringBuilder.append("] is ");
                stringBuilder.append(strArr2[sQLiteDatabase]);
                stringBuilder.append("; ");
                sQLiteDatabase++;
            }
        }
        stringBuilder.append("sort is ");
        stringBuilder.append(str2);
        stringBuilder.append(".");
        an.e("DownloadManager", stringBuilder.toString());
    }

    private String a(Uri uri, int i) {
        if (!(i == 2 || i == 4 || i == 6 || i == 201)) {
            if (i != 200) {
                return (String) uri.getPathSegments().get(1);
            }
        }
        return uri.getLastPathSegment();
    }

    private void a(SQLiteDatabase sQLiteDatabase, long j, ContentValues contentValues) {
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(RequestHeaders.COLUMN_DOWNLOAD_ID, Long.valueOf(j));
        for (Entry entry : contentValues.valueSet()) {
            if (((String) entry.getKey()).startsWith(RequestHeaders.INSERT_KEY_PREFIX) != null) {
                String obj = entry.getValue().toString();
                if (obj.contains(Constants.COLON_SEPARATOR) == null) {
                    j = new StringBuilder("Invalid HTTP header line: ");
                    j.append(obj);
                    throw new IllegalArgumentException(j.toString());
                }
                String[] split = obj.split(Constants.COLON_SEPARATOR, 2);
                contentValues2.put("header", split[0].trim());
                contentValues2.put(RequestHeaders.COLUMN_VALUE, split[1].trim());
                sQLiteDatabase.insert(RequestHeaders.HEADERS_DB_TABLE, null, contentValues2);
            }
        }
    }

    private Cursor a(SQLiteDatabase sQLiteDatabase, Uri uri) {
        StringBuilder stringBuilder = new StringBuilder("download_id=");
        stringBuilder.append(a(uri, 5));
        return sQLiteDatabase.query(RequestHeaders.HEADERS_DB_TABLE, new String[]{"header", RequestHeaders.COLUMN_VALUE}, stringBuilder.toString(), null, null, null, null);
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        str = sQLiteDatabase2.query(i, new String[]{"_id"}, str, strArr, null, null, null, null);
        try {
            str.moveToFirst();
            while (str.isAfterLast() == null) {
                long j = str.getLong(0);
                strArr = new StringBuilder("download_id=");
                strArr.append(j);
                sQLiteDatabase.delete(RequestHeaders.HEADERS_DB_TABLE, strArr.toString(), null);
                str.moveToNext();
            }
        } finally {
            str.close();
        }
    }

    private boolean f() {
        int callingUid = Binder.getCallingUid();
        return (Binder.getCallingPid() == Process.myPid() || callingUid == this.H || callingUid == this.I) ? false : true;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Throwable th;
        Cursor cursor;
        Throwable th2;
        DownloadProvider downloadProvider = this;
        Uri uri2 = uri;
        ContentValues contentValues2 = contentValues;
        String str2 = str;
        String[] strArr2 = strArr;
        int i = 0;
        SQLiteDatabase writableDatabase = d().getWritableDatabase();
        int match = l.match(uri2);
        int update;
        if (match == 9) {
            update = writableDatabase.update("xl_config", contentValues2, str2, strArr2);
            getContext().getContentResolver().notifyChange(uri2, null);
            return update;
        } else if (match == 100) {
            update = writableDatabase.update(v, contentValues2, str2, strArr2);
            getContext().getContentResolver().notifyChange(uri2, null);
            return update;
        } else {
            ContentValues contentValues3;
            int i2;
            String asString;
            Cursor query;
            String string;
            String str3;
            String str4;
            b a;
            c cVar;
            Context context;
            if (f()) {
                com.xunlei.download.proguard.k.a(str2, B);
            }
            StringBuilder stringBuilder = new StringBuilder("update() uri = ");
            stringBuilder.append(uri2);
            stringBuilder.append(", values = ");
            stringBuilder.append(contentValues2);
            stringBuilder.append(", where = ");
            stringBuilder.append(str2);
            stringBuilder.append(", whereArgs = ");
            stringBuilder.append(Arrays.toString(strArr));
            an.b("DownloadManager", stringBuilder.toString());
            update = (contentValues2.containsKey(Impl.COLUMN_DELETED) && contentValues2.getAsInteger(Impl.COLUMN_DELETED).intValue() == 1) ? 1 : 0;
            Integer asInteger = contentValues2.getAsInteger(Impl.COLUMN_CONTROL);
            int i3 = asInteger != null ? 1 : update;
            if (Binder.getCallingPid() != Process.myPid()) {
                ContentValues contentValues4 = new ContentValues();
                c(Impl.COLUMN_APP_DATA, contentValues2, contentValues4);
                a(Impl.COLUMN_VISIBILITY, contentValues2, contentValues4);
                if (asInteger != null) {
                    contentValues4.put(Impl.COLUMN_CONTROL, asInteger);
                }
                a(Impl.COLUMN_CONTROL, contentValues2, contentValues4);
                a("status", contentValues2, contentValues4);
                c("title", contentValues2, contentValues4);
                c("mediaprovider_uri", contentValues2, contentValues4);
                c("description", contentValues2, contentValues4);
                a(Impl.COLUMN_DELETED, contentValues2, contentValues4);
                a("is_vip_speedup", contentValues2, contentValues4);
                a("is_lx_speedup", contentValues2, contentValues4);
                a(Impl.COLUMN_SYNCRO_LX_TASK_TO_SERVER, contentValues2, contentValues4);
                contentValues3 = contentValues4;
                i2 = 1;
            } else {
                asString = contentValues2.getAsString(Impl._DATA);
                if (asString != null) {
                    try {
                        String str5 = asString;
                        i2 = 1;
                        query = query(uri2, new String[]{"title"}, null, null, null);
                        try {
                            if (query.moveToFirst()) {
                                string = query.getString(0);
                                if (string.length() == 0 || string.endsWith(" ")) {
                                    contentValues2.put("title", new File(str5).getName());
                                }
                            } else {
                                contentValues2.put("title", new File(str5).getName());
                            }
                            ab.a(query);
                        } catch (Throwable th3) {
                            th = th3;
                            th2 = th;
                            e();
                            th2.printStackTrace();
                            an.a(th2);
                            return i;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        cursor = null;
                        ab.a(cursor);
                        throw th2;
                    }
                }
                i2 = 1;
                Integer asInteger2 = contentValues2.getAsInteger("status");
                update = (asInteger2 == null || asInteger2.intValue() != 190) ? 0 : i2;
                boolean containsKey = contentValues2.containsKey(Impl.COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT);
                if (update == 0) {
                    if (!containsKey) {
                        contentValues3 = contentValues2;
                    }
                }
                contentValues3 = contentValues2;
                i3 = i2;
            }
            String asString2 = contentValues2.getAsString("bt_select_set");
            if ((asString2 != null && match == 2) || match == 4) {
                String[] strArr3 = new String[]{"bt_select_set", "status", Impl._DATA, "uri", "etag"};
                StringBuilder stringBuilder2 = new StringBuilder("task_type='");
                stringBuilder2.append(TaskType.BT.ordinal());
                stringBuilder2.append("'");
                query = query(uri2, strArr3, stringBuilder2.toString(), null, null);
                if (query != null) {
                    String string2;
                    if (query.moveToFirst()) {
                        string = query.getString(query.getColumnIndexOrThrow("bt_select_set"));
                        string2 = query.getString(query.getColumnIndexOrThrow(Impl._DATA));
                        int i4 = query.getInt(query.getColumnIndexOrThrow("status"));
                        asString = query.getString(query.getColumnIndexOrThrow("uri"));
                        String string3 = query.getString(query.getColumnIndexOrThrow("etag"));
                        if (asString2.equals(string) || i4 == 192) {
                            i2 = 0;
                            string = null;
                        } else {
                            string = Uri.parse(asString).getPath();
                            if (!new File(string).exists()) {
                                string = ab.a(string2, string3);
                            }
                        }
                    } else {
                        i2 = 0;
                        string = null;
                        string2 = null;
                    }
                    query.close();
                    str3 = string;
                    str4 = string2;
                    switch (match) {
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                            break;
                        default:
                            switch (match) {
                                case 200:
                                case 201:
                                    break;
                                default:
                                    stringBuilder = new StringBuilder("updating unknown/invalid URI: ");
                                    stringBuilder.append(uri2);
                                    an.b("DownloadManager", stringBuilder.toString());
                                    stringBuilder = new StringBuilder("Cannot update URI: ");
                                    stringBuilder.append(uri2);
                                    throw new UnsupportedOperationException(stringBuilder.toString());
                            }
                    }
                    a = a(uri2, str2, strArr2, match);
                    if (contentValues3.size() > 0) {
                        cVar = contentValues3.containsKey("status") ? new c(contentValues3.getAsInteger("status").intValue(), writableDatabase, a, contentValues3) : null;
                        update = writableDatabase.update(i, contentValues3, a.a(), a.b());
                        try {
                            b(uri2, match);
                            if (update > 0 && cVar != null && DownloadManager.getInstanceFor(getContext()).isDownloadlibSDKInit()) {
                                cVar.a(getContext());
                            }
                            i = update;
                        } catch (Throwable th5) {
                            th4 = th5;
                            i = update;
                            th2 = th4;
                            e();
                            th2.printStackTrace();
                            an.a(th2);
                            return i;
                        }
                    }
                    if (i3 != 0) {
                        context = getContext();
                        try {
                            context.startService(new Intent(context, DownloadService.class));
                        } catch (Throwable th42) {
                            th2 = th42;
                            th2.printStackTrace();
                            an.a(th2);
                        }
                    }
                    if (i2 != 0 && r12 > 0 && DownloadManager.getInstanceFor(getContext()).isDownloadlibSDKInit()) {
                        j.a(getContext(), null, null, null, null).a(getContext(), Long.parseLong(uri.getLastPathSegment()), asString2, str4, str3);
                    }
                    return i;
                }
            }
            i2 = 0;
            str4 = null;
            str3 = null;
            switch (match) {
                case 1:
                case 2:
                case 3:
                case 4:
                    break;
                default:
                    switch (match) {
                        case 200:
                        case 201:
                            break;
                        default:
                            stringBuilder = new StringBuilder("updating unknown/invalid URI: ");
                            stringBuilder.append(uri2);
                            an.b("DownloadManager", stringBuilder.toString());
                            stringBuilder = new StringBuilder("Cannot update URI: ");
                            stringBuilder.append(uri2);
                            throw new UnsupportedOperationException(stringBuilder.toString());
                    }
            }
            a = a(uri2, str2, strArr2, match);
            if (contentValues3.size() > 0) {
                if (contentValues3.containsKey("status")) {
                }
                update = writableDatabase.update(i, contentValues3, a.a(), a.b());
                b(uri2, match);
                cVar.a(getContext());
                i = update;
            }
            if (i3 != 0) {
                context = getContext();
                context.startService(new Intent(context, DownloadService.class));
            }
            j.a(getContext(), null, null, null, null).a(getContext(), Long.parseLong(uri.getLastPathSegment()), asString2, str4, str3);
            return i;
        }
    }

    private void b(Uri uri, int i) {
        if (i == 200 || i == 201) {
            getContext().getContentResolver().notifyChange(uri, null);
            return;
        }
        int i2;
        Uri withAppendedId;
        if (i != 2) {
            if (i != 4) {
                uri = null;
                for (Uri withAppendedId2 : z) {
                    if (uri != null) {
                        withAppendedId2 = ContentUris.withAppendedId(withAppendedId2, uri.longValue());
                    }
                    getContext().getContentResolver().notifyChange(withAppendedId2, null);
                }
            }
        }
        uri = Long.valueOf(Long.parseLong(a(uri, i)));
        for (i2 = 0; i2 < r1; i2++) {
            if (uri != null) {
                withAppendedId2 = ContentUris.withAppendedId(withAppendedId2, uri.longValue());
            }
            getContext().getContentResolver().notifyChange(withAppendedId2, null);
        }
    }

    private b a(Uri uri, String str, String[] strArr, int i) {
        b bVar = new b();
        bVar.a(str, strArr);
        if (i == 202) {
            bVar.a("group_id =? ", Integer.valueOf(0));
        } else if (i == 200) {
            bVar.a("group_id =? ", a(uri, 200));
        }
        if (i == 2 || i == 4 || i == 6 || i == 201) {
            bVar.a("_id = ?", new String[]{a(uri, i)});
        }
        return bVar;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        try {
            if (f()) {
                com.xunlei.download.proguard.k.a(str, B);
            }
            SQLiteDatabase writableDatabase = d().getWritableDatabase();
            int match = l.match(uri);
            if (match == 9) {
                str = writableDatabase.delete("xl_config", str, strArr);
                getContext().getContentResolver().notifyChange(uri, null);
                return str;
            } else if (match != 100) {
                switch (match) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        break;
                    default:
                        switch (match) {
                            case 200:
                            case 201:
                                break;
                            default:
                                strArr = new StringBuilder("deleting unknown/invalid URI: ");
                                strArr.append(uri);
                                an.b("DownloadManager", strArr.toString());
                                strArr = new StringBuilder("Cannot delete URI: ");
                                strArr.append(uri);
                                throw new UnsupportedOperationException(strArr.toString());
                        }
                }
                str = a(uri, str, strArr, match);
                a(writableDatabase, str.a(), str.b());
                StringBuilder stringBuilder = new StringBuilder("deleting ");
                stringBuilder.append(uri);
                stringBuilder.append(", whereArgs=");
                stringBuilder.append(Arrays.toString(strArr));
                an.b("DownloadManager", stringBuilder.toString());
                strArr = new StringBuilder(" DELETE FROM xl_bt_sub_task WHERE bt_parent_id IN (SELECT _id FROM xl_downloads WHERE ");
                strArr.append(str.a());
                strArr.append(" ) ");
                writableDatabase.execSQL(strArr.toString(), str.b());
                strArr = new c(1, writableDatabase, str, null);
                str = writableDatabase.delete(i, str.a(), str.b());
                if (str > null) {
                    strArr.a(getContext());
                }
                b(uri, match);
                return str;
            } else {
                str = writableDatabase.delete(v, str, strArr);
                getContext().getContentResolver().notifyChange(uri, null);
                return str;
            }
        } catch (Uri uri2) {
            e();
            uri2.printStackTrace();
            an.a(uri2);
            return null;
        }
    }

    private int a(SQLiteDatabase sQLiteDatabase, b bVar) {
        String[] strArr = new String[]{"_id", "task_type"};
        ArrayList arrayList = new ArrayList();
        bVar = sQLiteDatabase.query(i, strArr, bVar.a(), bVar.b(), null, null, null);
        try {
            int columnIndexOrThrow = bVar.getColumnIndexOrThrow("_id");
            int columnIndexOrThrow2 = bVar.getColumnIndexOrThrow("task_type");
            while (bVar.moveToNext()) {
                long j = bVar.getLong(columnIndexOrThrow);
                if (TaskType.GROUP.ordinal() == bVar.getInt(columnIndexOrThrow2)) {
                    StringBuilder stringBuilder = new StringBuilder("delete group: ");
                    stringBuilder.append(j);
                    an.b("DownloadManager", stringBuilder.toString());
                    arrayList.add(Long.valueOf(j));
                }
            }
            if (arrayList.size() <= null) {
                return 0;
            }
            bVar = new b();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                bVar.a("group_id=?", b.d, String.valueOf(longValue));
            }
            return sQLiteDatabase.delete(i, bVar.a(), bVar.b());
        } finally {
            bVar.close();
        }
    }

    private int c(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if (!IXAdRequestInfo.WIDTH.equals(str)) {
            if (!"wt".equals(str)) {
                if ("wa".equals(str)) {
                    return 704643072;
                }
                if ("rw".equals(str)) {
                    return 939524096;
                }
                if ("rwt".equals(str)) {
                    return 1006632960;
                }
                StringBuilder stringBuilder = new StringBuilder("Bad mode '");
                stringBuilder.append(str);
                stringBuilder.append("'");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return 738197504;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        int count;
        Cursor query = query(uri, new String[]{Impl._DATA}, null, null, null);
        if (query != null) {
            try {
                count = query.getCount();
            } catch (Throwable th) {
                ab.a(query);
            }
        } else {
            count = 0;
        }
        StringBuilder stringBuilder;
        if (count == 1) {
            query.moveToFirst();
            uri = query.getString(0);
            ab.a(query);
            if (uri == null) {
                throw new FileNotFoundException("No filename found.");
            } else if (com.xunlei.download.proguard.k.a(uri, this.J)) {
                return ParcelFileDescriptor.open(new File(uri), c(str));
            } else {
                stringBuilder = new StringBuilder("Invalid filename: ");
                stringBuilder.append(uri);
                throw new FileNotFoundException(stringBuilder.toString());
            }
        } else if (count == 0) {
            stringBuilder = new StringBuilder("No entry for ");
            stringBuilder.append(uri);
            throw new FileNotFoundException(stringBuilder.toString());
        } else {
            stringBuilder = new StringBuilder("Multiple items at ");
            stringBuilder.append(uri);
            throw new FileNotFoundException(stringBuilder.toString());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dump(java.io.FileDescriptor r10, java.io.PrintWriter r11, java.lang.String[] r12) {
        /*
        r9 = this;
        r10 = new com.xunlei.download.proguard.m;
        r12 = "  ";
        r0 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        r10.<init>(r11, r12, r0);
        r11 = "Downloads updated in last hour:";
        r10.println(r11);
        r10.a();
        r11 = 0;
        r12 = r9.d();	 Catch:{ Exception -> 0x0095, all -> 0x0092 }
        r0 = r12.getReadableDatabase();	 Catch:{ Exception -> 0x0095, all -> 0x0092 }
        r12 = r9.f;	 Catch:{ Exception -> 0x0095, all -> 0x0092 }
        r1 = r12.a();	 Catch:{ Exception -> 0x0095, all -> 0x0092 }
        r3 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r5 = r1 - r3;
        r1 = "xl_downloads";
        r2 = 0;
        r12 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0095, all -> 0x0092 }
        r3 = "lastmod>";
        r12.<init>(r3);	 Catch:{ Exception -> 0x0095, all -> 0x0092 }
        r12.append(r5);	 Catch:{ Exception -> 0x0095, all -> 0x0092 }
        r3 = r12.toString();	 Catch:{ Exception -> 0x0095, all -> 0x0092 }
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r7 = "_id ASC";
        r12 = r0.query(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x0095, all -> 0x0092 }
        r11 = r12.getColumnNames();	 Catch:{ Exception -> 0x0090 }
        r0 = "_id";
        r0 = r12.getColumnIndex(r0);	 Catch:{ Exception -> 0x0090 }
    L_0x0049:
        r1 = r12.moveToNext();	 Catch:{ Exception -> 0x0090 }
        if (r1 == 0) goto L_0x008d;
    L_0x004f:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0090 }
        r2 = "Download #";
        r1.<init>(r2);	 Catch:{ Exception -> 0x0090 }
        r2 = r12.getInt(r0);	 Catch:{ Exception -> 0x0090 }
        r1.append(r2);	 Catch:{ Exception -> 0x0090 }
        r2 = ":";
        r1.append(r2);	 Catch:{ Exception -> 0x0090 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0090 }
        r10.println(r1);	 Catch:{ Exception -> 0x0090 }
        r10.a();	 Catch:{ Exception -> 0x0090 }
        r1 = 0;
    L_0x006d:
        r2 = r11.length;	 Catch:{ Exception -> 0x0090 }
        if (r1 >= r2) goto L_0x0086;
    L_0x0070:
        r2 = "cookiedata";
        r3 = r11[r1];	 Catch:{ Exception -> 0x0090 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x0090 }
        if (r2 != 0) goto L_0x0083;
    L_0x007a:
        r2 = r11[r1];	 Catch:{ Exception -> 0x0090 }
        r3 = r12.getString(r1);	 Catch:{ Exception -> 0x0090 }
        r10.a(r2, r3);	 Catch:{ Exception -> 0x0090 }
    L_0x0083:
        r1 = r1 + 1;
        goto L_0x006d;
    L_0x0086:
        r10.println();	 Catch:{ Exception -> 0x0090 }
        r10.b();	 Catch:{ Exception -> 0x0090 }
        goto L_0x0049;
    L_0x008d:
        if (r12 == 0) goto L_0x00a7;
    L_0x008f:
        goto L_0x00a4;
    L_0x0090:
        r11 = move-exception;
        goto L_0x0099;
    L_0x0092:
        r10 = move-exception;
        r12 = r11;
        goto L_0x00ac;
    L_0x0095:
        r12 = move-exception;
        r8 = r12;
        r12 = r11;
        r11 = r8;
    L_0x0099:
        r9.e();	 Catch:{ all -> 0x00ab }
        r11.printStackTrace();	 Catch:{ all -> 0x00ab }
        com.xunlei.download.proguard.an.a(r11);	 Catch:{ all -> 0x00ab }
        if (r12 == 0) goto L_0x00a7;
    L_0x00a4:
        r12.close();
    L_0x00a7:
        r10.b();
        return;
    L_0x00ab:
        r10 = move-exception;
    L_0x00ac:
        if (r12 == 0) goto L_0x00b1;
    L_0x00ae:
        r12.close();
    L_0x00b1:
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.providers.downloads.DownloadProvider.dump(java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void");
    }

    private void a(Uri uri, String str) {
        StringBuilder stringBuilder = new StringBuilder("openFile uri: ");
        stringBuilder.append(uri);
        stringBuilder.append(", mode: ");
        stringBuilder.append(str);
        stringBuilder.append(", uid: ");
        stringBuilder.append(Binder.getCallingUid());
        an.e("DownloadManager", stringBuilder.toString());
        Cursor query = query(DownloadManager.getInstanceFor(getContext()).getDownloadUri(), new String[]{"_id"}, null, null, "_id");
        if (query == null) {
            an.e("DownloadManager", "null cursor in openFile");
        } else {
            try {
                if (query.moveToFirst()) {
                    do {
                        StringBuilder stringBuilder2 = new StringBuilder("row ");
                        stringBuilder2.append(query.getInt(0));
                        stringBuilder2.append(" available");
                        an.e("DownloadManager", stringBuilder2.toString());
                    } while (query.moveToNext());
                } else {
                    an.e("DownloadManager", "empty cursor in openFile");
                }
                query.close();
            } catch (Throwable th) {
                query.close();
            }
        }
        uri = query(uri, new String[]{Impl._DATA}, null, null, null);
        if (uri == null) {
            an.e("DownloadManager", "null cursor in openFile");
            return;
        }
        try {
            if (uri.moveToFirst() == null) {
                an.e("DownloadManager", "empty cursor in openFile");
            } else {
                str = uri.getString(0);
                stringBuilder = new StringBuilder("filename in openFile: ");
                stringBuilder.append(str);
                an.e("DownloadManager", stringBuilder.toString());
                if (new File(str).isFile() != null) {
                    an.e("DownloadManager", "file exists in openFile");
                }
            }
            uri.close();
        } catch (Throwable th2) {
            uri.close();
        }
    }

    private static final void a(String str, ContentValues contentValues, ContentValues contentValues2) {
        contentValues = contentValues.getAsInteger(str);
        if (contentValues != null) {
            contentValues2.put(str, contentValues);
        }
    }

    private static final void b(String str, ContentValues contentValues, ContentValues contentValues2) {
        contentValues = contentValues.getAsBoolean(str);
        if (contentValues != null) {
            contentValues2.put(str, contentValues);
        }
    }

    private static final void c(String str, ContentValues contentValues, ContentValues contentValues2) {
        contentValues = contentValues.getAsString(str);
        if (contentValues != null) {
            contentValues2.put(str, contentValues);
        }
    }

    private static final void a(String str, ContentValues contentValues, ContentValues contentValues2, String str2) {
        c(str, contentValues, contentValues2);
        if (contentValues2.containsKey(str) == null) {
            contentValues2.put(str, str2);
        }
    }

    static String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(_id = ? )");
        return stringBuilder.toString();
    }

    static String[] a(long j) {
        return new String[]{Long.toString(j)};
    }

    private static String a(String[] strArr, String[] strArr2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(k.s);
        for (int i = 0; i < strArr.length; i++) {
            StringBuilder stringBuilder2;
            if (i > 0) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(strArr2[i - 1]);
                stringBuilder2.append(" ");
                stringBuilder.append(stringBuilder2.toString());
            }
            stringBuilder.append("status");
            stringBuilder2 = new StringBuilder(" ");
            stringBuilder2.append(strArr[i]);
            stringBuilder2.append(" ? ");
            stringBuilder.append(stringBuilder2.toString());
        }
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }

    private static String[] a(int[] iArr) {
        String[] strArr = new String[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            strArr[i] = Integer.toString(iArr[i]);
        }
        return strArr;
    }

    private static <T> T[] a(T[] tArr, T[] tArr2, Class<T> cls) {
        Object[] objArr = (Object[]) Array.newInstance(cls, tArr.length + tArr2.length);
        System.arraycopy(tArr, 0, objArr, 0, tArr.length);
        System.arraycopy(tArr2, 0, objArr, tArr.length, tArr2.length);
        return objArr;
    }

    static void a(ContentValues contentValues) {
        if (contentValues != null) {
            contentValues.put("status", Integer.valueOf(190));
            contentValues.put(Impl.COLUMN_CONTROL, Integer.valueOf(0));
        }
    }

    @Deprecated
    public static void a(Context context, Class<?> cls) {
        DownloadManager.getInstanceFor(context);
    }

    @Deprecated
    public static Uri b() {
        StringBuilder stringBuilder = new StringBuilder("content://");
        stringBuilder.append(e);
        stringBuilder.append("/my_downloads");
        return Uri.parse(stringBuilder.toString());
    }
}
