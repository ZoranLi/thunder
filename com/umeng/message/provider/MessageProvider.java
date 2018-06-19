package com.umeng.message.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.umeng.message.common.UmLog;
import com.umeng.message.proguard.k;
import com.umeng.message.proguard.l;

public class MessageProvider extends ContentProvider {
    private static final String a = "MessageProvider";
    private static final UriMatcher b = new UriMatcher(-1);
    private static final int g = 1;
    private static final int h = 2;
    private static final int i = 3;
    private static final int j = 4;
    private static final int k = 5;
    private static final int l = 6;
    private static final int m = 7;
    private static final int n = 8;
    private static final int o = 9;
    private static final int p = 10;
    private static Context q;
    private a c;
    private SQLiteDatabase d;
    private b e;
    private SQLiteDatabase f;

    private class a extends SQLiteOpenHelper {
        final /* synthetic */ MessageProvider a;

        public a(MessageProvider messageProvider, Context context) {
            this.a = messageProvider;
            super(context, k.b, null, 3);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            UmLog.d(MessageProvider.a, "MessageStoreHelper-->onCreate-->start");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS MessageStore(_id Integer  PRIMARY KEY  AUTOINCREMENT  , MsdId Varchar  , Json Varchar  , SdkVersion Varchar  , ArrivalTime Long  , ActionType Integer )");
            sQLiteDatabase.execSQL("create table if not exists MsgTemp(id INTEGER AUTO_INCREMENT,tempkey varchar default NULL, tempvalue varchar default NULL,PRIMARY KEY(id))");
            sQLiteDatabase.execSQL("create table if not exists MsgAlias(time long,type varchar default NULL,alias varchar default NULL,exclusive int,error int,message varchar,PRIMARY KEY(time))");
            UmLog.d(MessageProvider.a, "MessageStoreHelper-->onCreate-->end");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i <= 2) {
                sQLiteDatabase.execSQL("drop table MsgTemp");
            }
            onCreate(sQLiteDatabase);
            UmLog.d(MessageProvider.a, "MessageStoreHelper-->onUpgrade");
        }
    }

    private class b extends SQLiteOpenHelper {
        final /* synthetic */ MessageProvider a;

        public b(MessageProvider messageProvider, Context context) {
            this.a = messageProvider;
            super(context, l.a, null, 5);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table if not exists MsgLogStore (MsgId varchar, ActionType Integer, Time long, PRIMARY KEY(MsgId, ActionType))");
            sQLiteDatabase.execSQL("create table if not exists MsgLogIdTypeStore (MsgId varchar, MsgType varchar, PRIMARY KEY(MsgId))");
            sQLiteDatabase.execSQL("create table if not exists MsgLogStoreForAgoo (MsgId varchar, TaskId varchar, MsgStatus varchar, Time long, PRIMARY KEY(MsgId, MsgStatus))");
            sQLiteDatabase.execSQL("create table if not exists MsgLogIdTypeStoreForAgoo (MsgId varchar, TaskId varchar, MsgStatus varchar, PRIMARY KEY(MsgId))");
            sQLiteDatabase.execSQL("create table if not exists MsgConfigInfo (SerialNo integer default 1, AppLaunchAt long default 0, UpdateResponse varchar default NULL)");
            sQLiteDatabase.execSQL("create table if not exists InAppLogStore (Time long, MsgId varchar, MsgType Integer, NumDisplay Integer, NumOpenFull Integer, NumOpenTop Integer, NumOpenBottom Integer, NumClose Integer, NumDuration Integer, PRIMARY KEY(Time))");
            UmLog.d(MessageProvider.a, "MsgLogStoreHelper-->onCreate");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            String a = MessageProvider.a;
            StringBuilder stringBuilder = new StringBuilder("oldVersion:");
            stringBuilder.append(i);
            stringBuilder.append(",newVersion:");
            stringBuilder.append(i2);
            UmLog.d(a, stringBuilder.toString());
            if (i <= 4) {
                UmLog.d(MessageProvider.a, "MsgLogStoreHelper-->drop delete");
                sQLiteDatabase.execSQL("drop table MsgConfigInfo");
            }
            onCreate(sQLiteDatabase);
            UmLog.d(MessageProvider.a, "MsgLogStoreHelper-->onUpgrade");
        }

        private boolean a(android.database.sqlite.SQLiteDatabase r4, java.lang.String r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r3 = this;
            r0 = android.text.TextUtils.isEmpty(r5);
            r1 = 0;
            if (r0 == 0) goto L_0x0008;
        L_0x0007:
            return r1;
        L_0x0008:
            r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0036 }
            r2 = "select count(*) as c from sqlite_master where type = 'table' and name = '";	 Catch:{ Exception -> 0x0036 }
            r0.<init>(r2);	 Catch:{ Exception -> 0x0036 }
            r5 = r5.trim();	 Catch:{ Exception -> 0x0036 }
            r0.append(r5);	 Catch:{ Exception -> 0x0036 }
            r5 = "'";	 Catch:{ Exception -> 0x0036 }
            r0.append(r5);	 Catch:{ Exception -> 0x0036 }
            r5 = r0.toString();	 Catch:{ Exception -> 0x0036 }
            r0 = 0;	 Catch:{ Exception -> 0x0036 }
            r4 = r4.rawQuery(r5, r0);	 Catch:{ Exception -> 0x0036 }
            r5 = r4.moveToNext();	 Catch:{ Exception -> 0x0036 }
            if (r5 == 0) goto L_0x0031;	 Catch:{ Exception -> 0x0036 }
        L_0x002a:
            r5 = r4.getInt(r1);	 Catch:{ Exception -> 0x0036 }
            if (r5 <= 0) goto L_0x0031;	 Catch:{ Exception -> 0x0036 }
        L_0x0030:
            r1 = 1;	 Catch:{ Exception -> 0x0036 }
        L_0x0031:
            if (r4 == 0) goto L_0x0036;	 Catch:{ Exception -> 0x0036 }
        L_0x0033:
            r4.close();	 Catch:{ Exception -> 0x0036 }
        L_0x0036:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.provider.MessageProvider.b.a(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
        }
    }

    public boolean onCreate() {
        q = getContext();
        b();
        UriMatcher uriMatcher = b;
        a.a(q);
        uriMatcher.addURI(a.a, "MessageStores", 1);
        uriMatcher = b;
        a.a(q);
        uriMatcher.addURI(a.a, "MsgTemps", 2);
        uriMatcher = b;
        a.a(q);
        uriMatcher.addURI(a.a, k.e, 3);
        uriMatcher = b;
        a.a(q);
        uriMatcher.addURI(a.a, "MsgAliasDeleteAll", 4);
        uriMatcher = b;
        a.a(q);
        uriMatcher.addURI(a.a, "MsgLogStores", 5);
        uriMatcher = b;
        a.a(q);
        uriMatcher.addURI(a.a, "MsgLogIdTypeStores", 6);
        uriMatcher = b;
        a.a(q);
        uriMatcher.addURI(a.a, "MsgLogStoreForAgoos", 7);
        uriMatcher = b;
        a.a(q);
        uriMatcher.addURI(a.a, "MsgLogIdTypeStoreForAgoos", 8);
        uriMatcher = b;
        a.a(q);
        uriMatcher.addURI(a.a, "MsgConfigInfos", 9);
        uriMatcher = b;
        a.a(q);
        uriMatcher.addURI(a.a, "InAppLogStores", 10);
        return true;
    }

    private void b() {
        try {
            synchronized (this) {
                this.c = new a(this, getContext());
                this.e = new b(this, getContext());
                if (this.d == null) {
                    this.d = this.c.getWritableDatabase();
                }
                if (this.f == null) {
                    this.f = this.e.getWritableDatabase();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        switch (b.match(uri)) {
            case 1:
                break;
            case 2:
                strArr = this.d.query(k.d, strArr, str, strArr2, null, null, str2);
                break;
            case 3:
                strArr = this.d.query(k.e, strArr, str, strArr2, null, null, str2);
                break;
            case 5:
                strArr = this.f.query(l.c, strArr, str, strArr2, null, null, str2);
                break;
            case 7:
                strArr = this.f.query(l.e, strArr, str, strArr2, null, null, str2);
                break;
            case 8:
                strArr = this.f.query(l.f, strArr, str, strArr2, null, null, str2);
                break;
            case 9:
                strArr = this.f.query(l.g, strArr, str, strArr2, null, null, str2);
                break;
            case 10:
                strArr = this.f.query(l.h, strArr, str, strArr2, null, null, str2);
                break;
            default:
                break;
        }
        strArr = null;
        if (strArr != null) {
            strArr.setNotificationUri(getContext().getContentResolver(), uri);
        }
        return strArr;
    }

    public String getType(Uri uri) {
        switch (b.match(uri)) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 7:
            case 8:
            case 9:
                return a$a.k;
            default:
                StringBuilder stringBuilder = new StringBuilder("Unknown URI ");
                stringBuilder.append(uri);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        switch (b.match(uri)) {
            case 1:
                uri = this.d.insertWithOnConflict(k.c, null, contentValues, 5);
                if (uri > null) {
                    a.a(q);
                    uri = ContentUris.withAppendedId(a.b, uri);
                    getContext().getContentResolver().notifyChange(uri, null);
                    return uri;
                }
                break;
            case 2:
                uri = this.d.insertWithOnConflict(k.d, null, contentValues, 5);
                if (uri > null) {
                    a.a(q);
                    uri = ContentUris.withAppendedId(a.b, uri);
                    getContext().getContentResolver().notifyChange(uri, null);
                    return uri;
                }
                break;
            case 3:
                uri = this.d.insertWithOnConflict(k.e, null, contentValues, 5);
                if (uri > null) {
                    a.a(q);
                    uri = ContentUris.withAppendedId(a.d, uri);
                    getContext().getContentResolver().notifyChange(uri, null);
                    return uri;
                }
                break;
            case 5:
                uri = this.f.insertWithOnConflict(l.c, null, contentValues, 5);
                if (uri > null) {
                    a.a(q);
                    uri = ContentUris.withAppendedId(a.f, uri);
                    getContext().getContentResolver().notifyChange(uri, null);
                    return uri;
                }
                break;
            case 6:
                uri = this.f.insertWithOnConflict(l.d, null, contentValues, 5);
                if (uri > null) {
                    a.a(q);
                    return ContentUris.withAppendedId(a.g, uri);
                }
                break;
            case 7:
                uri = this.f.insertWithOnConflict(l.e, null, contentValues, 5);
                if (uri > null) {
                    a.a(q);
                    return ContentUris.withAppendedId(a.h, uri);
                }
                break;
            case 8:
                uri = this.f.insertWithOnConflict(l.f, null, contentValues, 5);
                if (uri > null) {
                    a.a(q);
                    return ContentUris.withAppendedId(a.i, uri);
                }
                break;
            case 9:
                uri = this.f.insertWithOnConflict(l.g, null, contentValues, 5);
                if (uri > null) {
                    a.a(q);
                    return ContentUris.withAppendedId(a.j, uri);
                }
                break;
            case 10:
                uri = this.f.insertWithOnConflict(l.h, null, contentValues, 5);
                if (uri > null) {
                    a.a(q);
                    return ContentUris.withAppendedId(a.k, uri);
                }
                break;
            default:
                break;
        }
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        switch (b.match(uri)) {
            case 1:
                break;
            case 2:
                str = this.d.delete(k.d, str, strArr);
                break;
            case 3:
                str = this.d.delete(k.e, str, strArr);
                break;
            case 4:
                str = this.d.delete(k.e, null, null);
                break;
            case 5:
                str = this.f.delete(l.c, str, strArr);
                break;
            case 6:
                str = this.f.delete(l.d, str, strArr);
                break;
            case 7:
                str = this.f.delete(l.e, str, strArr);
                break;
            case 8:
                str = this.f.delete(l.f, str, strArr);
                break;
            case 10:
                str = this.f.delete(l.h, str, strArr);
                break;
            default:
                break;
        }
        str = null;
        getContext().getContentResolver().notifyChange(uri, null);
        return str;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int match = b.match(uri);
        switch (match) {
            case 1:
                contentValues = this.d.updateWithOnConflict(k.c, contentValues, str, strArr, 5);
                break;
            case 2:
                contentValues = this.d.updateWithOnConflict(k.d, contentValues, str, strArr, 5);
                break;
            case 3:
                this.d.updateWithOnConflict(k.e, contentValues, str, strArr, 5);
                break;
            default:
                switch (match) {
                    case 9:
                        contentValues = this.f.updateWithOnConflict(l.g, contentValues, str, strArr, 5);
                        break;
                    case 10:
                        contentValues = this.f.updateWithOnConflict(l.h, contentValues, str, strArr, 5);
                        break;
                    default:
                        break;
                }
        }
        contentValues = null;
        getContext().getContentResolver().notifyChange(uri, null);
        return contentValues;
    }
}
