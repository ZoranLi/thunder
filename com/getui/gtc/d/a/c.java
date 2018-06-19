package com.getui.gtc.d.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.getui.gtc.a.h;
import com.getui.gtc.e.i;
import com.xunlei.downloadprovider.ad.common.adget.b.b;
import org.android.agoo.common.AgooConstants;

public final class c {
    public SQLiteOpenHelper a;
    public b b;
    public d c;

    public final class a extends SQLiteOpenHelper {
        final /* synthetic */ c a;
        private String b;

        public a(c cVar, Context context) {
            this.a = cVar;
            super(context, "gtc.db", null, 3);
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            StringBuilder stringBuilder;
            try {
                sQLiteDatabase.beginTransaction();
                stringBuilder = new StringBuilder("CREATE TABLE ");
                stringBuilder.append("IF NOT EXISTS ");
                stringBuilder.append("\"c\" (\"id\" INTEGER,\"k\" TEXT,\"v\" TEXT,PRIMARY KEY(id,k));");
                sQLiteDatabase.execSQL(stringBuilder.toString());
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                sQLiteDatabase.endTransaction();
            }
            sQLiteDatabase.endTransaction();
            stringBuilder = new StringBuilder("CREATE TABLE ");
            stringBuilder.append("IF NOT EXISTS ");
            stringBuilder.append("\"r\" (\"id\" INTEGER,\"a\" TEXT NOT NULL,\"b\" TEXT NOT NULL,PRIMARY KEY(id,a));");
            sQLiteDatabase.execSQL(stringBuilder.toString());
        }

        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            c.a(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }

        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            try {
                this.b = d.a(sQLiteDatabase);
                c.a(sQLiteDatabase);
                onCreate(sQLiteDatabase);
                if (!TextUtils.isEmpty(this.b)) {
                    d dVar = this.a.c;
                    String str = this.b;
                    dVar.e = str;
                    byte[] a = i.a(str.getBytes(), h.b);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(AgooConstants.MESSAGE_ID, Integer.valueOf(1));
                    contentValues.put("a", Integer.valueOf(4));
                    contentValues.put(b.a, a);
                    sQLiteDatabase.replace("r", null, contentValues);
                    String[] strArr = new String[1];
                    StringBuilder stringBuilder = new StringBuilder(" db onUpgrade save gicid : ");
                    stringBuilder.append(str);
                    strArr[0] = stringBuilder.toString();
                }
            } catch (Throwable th) {
                new String[1][0] = th.toString();
            }
        }
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS c");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS r");
    }

    public final void a(int i) {
        b bVar = this.b;
        if (bVar.b != null) {
            bVar.b.remove(i);
        }
        bVar.a("id=? and k=?", new String[]{String.valueOf(i), "1001"});
    }
}
