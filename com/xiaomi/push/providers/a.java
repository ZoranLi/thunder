package com.xiaomi.push.providers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.Constants;

public class a extends SQLiteOpenHelper {
    public static final Object a = new Object();
    private static int b = 1;
    private static final String[] c = new String[]{Constants.PACKAGE_NAME, "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", com.taobao.accs.common.Constants.KEY_IMSI, "TEXT"};

    public a(Context context) {
        super(context, "traffic.db", null, b);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder stringBuilder = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
        for (int i = 0; i < c.length - 1; i += 2) {
            if (i != 0) {
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            stringBuilder.append(c[i]);
            stringBuilder.append(" ");
            stringBuilder.append(c[i + 1]);
        }
        stringBuilder.append(");");
        sQLiteDatabase.execSQL(stringBuilder.toString());
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (a) {
            try {
                a(sQLiteDatabase);
            } catch (Throwable e) {
                b.a(e);
            }
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
