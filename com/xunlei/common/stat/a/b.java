package com.xunlei.common.stat.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: XLStatDBHelper */
public final class b extends SQLiteOpenHelper {
    private static final String a = "xl-acc-stat.db";
    private static final int b = 4;

    public b(Context context) {
        super(context, a, null, 4);
    }

    private b(Context context, String str, CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    private b(Context context, String str, CursorFactory cursorFactory, int i, byte b) {
        super(context, str, cursorFactory, i);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE xl_acc_stat_list");
        a(sQLiteDatabase);
    }

    private static void a(SQLiteDatabase sQLiteDatabase) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CREATE TABLE IF NOT EXISTS xl_acc_stat_list(_id INTEGER PRIMARY KEY AUTOINCREMENT,url VARCHAR,error INTEGER,respt DOUBLE,retry INTEGER,ip VARCHAR,domain VARCHAR,cmd INTEGER,bt INTEGER,date VARCHAR,uid INTEGER,flowid INTEGER,net VARCHAR,isp VARCHAR,final INTEGER,message VARCHAR)");
        sQLiteDatabase.execSQL(stringBuffer.toString());
    }
}
