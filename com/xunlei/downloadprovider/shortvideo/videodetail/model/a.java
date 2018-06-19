package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.message.proguard.k;
import java.util.ArrayList;

/* compiled from: CommentDbHelpler */
public class a extends SQLiteOpenHelper {
    private static final String a = "a";

    /* compiled from: CommentDbHelpler */
    public static class a {
        public long a;
        public boolean b;
        public boolean c;
        public boolean d;
        public String e;
        public String f;
        public long g;
    }

    public a(Context context) {
        super(context, "comment.db", null, 3);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    private static void a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder stringBuilder = new StringBuilder(k.o);
        stringBuilder.append("comment_zan_info( _id INTEGER PRIMARY KEY AUTOINCREMENT, res_id TEXT, src_id TEXT, usr_id LONG, comment_id LONG UNIQUE, has_zan SHORT , has_login SHORT , has_commit SHORT )");
        sQLiteDatabase.execSQL(stringBuilder.toString());
    }

    private static void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(new StringBuilder("DROP TABLE IF EXISTS comment_zan_info").toString());
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        b(sQLiteDatabase);
        a(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        b(sQLiteDatabase);
        a(sQLiteDatabase);
    }

    public final ArrayList<a> a(String str) {
        SQLiteDatabase readableDatabase;
        ArrayList<a> arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            readableDatabase = getReadableDatabase();
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("SELECT * FROM comment_zan_info WHERE res_id='");
                stringBuilder.append(str);
                stringBuilder.append("'");
                str = readableDatabase.rawQuery(stringBuilder.toString(), null);
                if (str == null) {
                    if (readableDatabase != null) {
                        readableDatabase.close();
                    }
                    return null;
                }
                while (str.moveToNext()) {
                    a aVar = new a();
                    aVar.e = str.getString(str.getColumnIndex("res_id"));
                    aVar.f = str.getString(str.getColumnIndex("src_id"));
                    aVar.g = str.getLong(str.getColumnIndex("usr_id"));
                    aVar.a = str.getLong(str.getColumnIndex("comment_id"));
                    boolean z = false;
                    aVar.b = str.getShort(str.getColumnIndex("has_zan")) == (short) 1;
                    aVar.c = str.getShort(str.getColumnIndex("has_login")) == (short) 1;
                    if (str.getShort(str.getColumnIndex("has_commit")) == (short) 1) {
                        z = true;
                    }
                    aVar.d = z;
                    arrayList.add(aVar);
                }
                if (readableDatabase != null) {
                    readableDatabase.close();
                }
                new StringBuilder("query data size=>").append(arrayList.size());
                return arrayList;
            } catch (Exception e) {
                str = e;
                sQLiteDatabase = readableDatabase;
            } catch (Throwable th) {
                str = th;
            }
        } catch (Exception e2) {
            str = e2;
            try {
                str.printStackTrace();
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                new StringBuilder("query data size=>").append(arrayList.size());
                return arrayList;
            } catch (Throwable th2) {
                str = th2;
                readableDatabase = sQLiteDatabase;
                if (readableDatabase != null) {
                    readableDatabase.close();
                }
                throw str;
            }
        }
    }

    public final ArrayList<a> a(long j) {
        SQLiteDatabase readableDatabase;
        ArrayList<a> arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            readableDatabase = getReadableDatabase();
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("SELECT * FROM comment_zan_info WHERE usr_id='");
                stringBuilder.append(j);
                stringBuilder.append("'");
                j = readableDatabase.rawQuery(stringBuilder.toString(), null);
                if (j == null) {
                    if (readableDatabase != null) {
                        readableDatabase.close();
                    }
                    return null;
                }
                while (j.moveToNext()) {
                    a aVar = new a();
                    aVar.e = j.getString(j.getColumnIndex("res_id"));
                    aVar.f = j.getString(j.getColumnIndex("src_id"));
                    aVar.g = j.getLong(j.getColumnIndex("usr_id"));
                    aVar.a = j.getLong(j.getColumnIndex("comment_id"));
                    boolean z = false;
                    aVar.b = j.getShort(j.getColumnIndex("has_zan")) == (short) 1;
                    aVar.c = j.getShort(j.getColumnIndex("has_login")) == (short) 1;
                    if (j.getShort(j.getColumnIndex("has_commit")) == (short) 1) {
                        z = true;
                    }
                    aVar.d = z;
                    arrayList.add(aVar);
                }
                if (readableDatabase != null) {
                    readableDatabase.close();
                }
                new StringBuilder("query data size=>").append(arrayList.size());
                return arrayList;
            } catch (Exception e) {
                j = e;
                sQLiteDatabase = readableDatabase;
            } catch (Throwable th) {
                j = th;
            }
        } catch (Exception e2) {
            j = e2;
            try {
                j.printStackTrace();
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                }
                new StringBuilder("query data size=>").append(arrayList.size());
                return arrayList;
            } catch (Throwable th2) {
                j = th2;
                readableDatabase = sQLiteDatabase;
                if (readableDatabase != null) {
                    readableDatabase.close();
                }
                throw j;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<com.xunlei.downloadprovider.shortvideo.videodetail.model.a.a> a() {
        /*
        r8 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = 0;
        r2 = r8.getReadableDatabase();	 Catch:{ Exception -> 0x00a0, all -> 0x009d }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009b }
        r3.<init>();	 Catch:{ Exception -> 0x009b }
        r4 = "SELECT * FROM comment_zan_info WHERE has_commit=0";
        r3.append(r4);	 Catch:{ Exception -> 0x009b }
        r3 = r3.toString();	 Catch:{ Exception -> 0x009b }
        r3 = r2.rawQuery(r3, r1);	 Catch:{ Exception -> 0x009b }
        if (r3 != 0) goto L_0x0024;
    L_0x001e:
        if (r2 == 0) goto L_0x0023;
    L_0x0020:
        r2.close();
    L_0x0023:
        return r1;
    L_0x0024:
        r1 = r3.moveToNext();	 Catch:{ Exception -> 0x009b }
        if (r1 == 0) goto L_0x0096;
    L_0x002a:
        r1 = new com.xunlei.downloadprovider.shortvideo.videodetail.model.a$a;	 Catch:{ Exception -> 0x009b }
        r1.<init>();	 Catch:{ Exception -> 0x009b }
        r4 = "res_id";
        r4 = r3.getColumnIndex(r4);	 Catch:{ Exception -> 0x009b }
        r4 = r3.getString(r4);	 Catch:{ Exception -> 0x009b }
        r1.e = r4;	 Catch:{ Exception -> 0x009b }
        r4 = "src_id";
        r4 = r3.getColumnIndex(r4);	 Catch:{ Exception -> 0x009b }
        r4 = r3.getString(r4);	 Catch:{ Exception -> 0x009b }
        r1.f = r4;	 Catch:{ Exception -> 0x009b }
        r4 = "usr_id";
        r4 = r3.getColumnIndex(r4);	 Catch:{ Exception -> 0x009b }
        r4 = r3.getLong(r4);	 Catch:{ Exception -> 0x009b }
        r1.g = r4;	 Catch:{ Exception -> 0x009b }
        r4 = "comment_id";
        r4 = r3.getColumnIndex(r4);	 Catch:{ Exception -> 0x009b }
        r4 = r3.getLong(r4);	 Catch:{ Exception -> 0x009b }
        r1.a = r4;	 Catch:{ Exception -> 0x009b }
        r4 = "has_zan";
        r4 = r3.getColumnIndex(r4);	 Catch:{ Exception -> 0x009b }
        r4 = r3.getShort(r4);	 Catch:{ Exception -> 0x009b }
        r5 = 0;
        r6 = 1;
        if (r4 != r6) goto L_0x006f;
    L_0x006d:
        r4 = r6;
        goto L_0x0070;
    L_0x006f:
        r4 = r5;
    L_0x0070:
        r1.b = r4;	 Catch:{ Exception -> 0x009b }
        r4 = "has_login";
        r4 = r3.getColumnIndex(r4);	 Catch:{ Exception -> 0x009b }
        r4 = r3.getShort(r4);	 Catch:{ Exception -> 0x009b }
        if (r4 != r6) goto L_0x0080;
    L_0x007e:
        r4 = r6;
        goto L_0x0081;
    L_0x0080:
        r4 = r5;
    L_0x0081:
        r1.c = r4;	 Catch:{ Exception -> 0x009b }
        r4 = "has_commit";
        r4 = r3.getColumnIndex(r4);	 Catch:{ Exception -> 0x009b }
        r4 = r3.getShort(r4);	 Catch:{ Exception -> 0x009b }
        if (r4 != r6) goto L_0x0090;
    L_0x008f:
        r5 = r6;
    L_0x0090:
        r1.d = r5;	 Catch:{ Exception -> 0x009b }
        r0.add(r1);	 Catch:{ Exception -> 0x009b }
        goto L_0x0024;
    L_0x0096:
        if (r2 == 0) goto L_0x00ac;
    L_0x0098:
        goto L_0x00a9;
    L_0x0099:
        r0 = move-exception;
        goto L_0x00bb;
    L_0x009b:
        r1 = move-exception;
        goto L_0x00a4;
    L_0x009d:
        r0 = move-exception;
        r2 = r1;
        goto L_0x00bb;
    L_0x00a0:
        r2 = move-exception;
        r7 = r2;
        r2 = r1;
        r1 = r7;
    L_0x00a4:
        r1.printStackTrace();	 Catch:{ all -> 0x0099 }
        if (r2 == 0) goto L_0x00ac;
    L_0x00a9:
        r2.close();
    L_0x00ac:
        r1 = new java.lang.StringBuilder;
        r2 = "query data size=>";
        r1.<init>(r2);
        r2 = r0.size();
        r1.append(r2);
        return r0;
    L_0x00bb:
        if (r2 == 0) goto L_0x00c0;
    L_0x00bd:
        r2.close();
    L_0x00c0:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.shortvideo.videodetail.model.a.a():java.util.ArrayList<com.xunlei.downloadprovider.shortvideo.videodetail.model.a$a>");
    }
}
