package com.xiaomi.push.service;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alipay.sdk.cons.c;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.atomic.AtomicInteger;

public class i extends SQLiteOpenHelper {
    private static i d;
    private static final String[] f = new String[]{c.e, "TEXT NOT NULL", "appId", "INTEGER NOT NULL", Constants.PACKAGE_NAME, "TEXT NOT NULL", "create_time", "INTEGER NOT NULL", "type", "TEXT NOT NULL", "center_longtitude", "TEXT", "center_lantitude", "TEXT", "circle_radius", "REAL", "polygon_point", "TEXT", "coordinate_provider", "TEXT NOT NULL", "current_status", "TEXT NOT NULL"};
    private static final String[] g = new String[]{"message_id", "TEXT NOT NULL", "geo_id", "TEXT NOT NULL", "content", "BLOB NOT NULL", "action", "INTEGER NOT NULL", "deadline", "INTEGER NOT NULL"};
    public final Object a = new Object();
    private final String b = "GeoFenceDatabaseHelper.";
    private AtomicInteger c = new AtomicInteger();
    private SQLiteDatabase e;

    public i(Context context) {
        super(context, "geofencing.db", null, 1);
    }

    public static i a(Context context) {
        if (d == null) {
            synchronized (i.class) {
                if (d == null) {
                    d = new i(context);
                }
            }
        }
        return d;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder stringBuilder = new StringBuilder("CREATE TABLE geofence(id TEXT PRIMARY KEY ,");
            for (int i = 0; i < f.length - 1; i += 2) {
                if (i != 0) {
                    stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                stringBuilder.append(f[i]);
                stringBuilder.append(" ");
                stringBuilder.append(f[i + 1]);
            }
            stringBuilder.append(");");
            sQLiteDatabase.execSQL(stringBuilder.toString());
        } catch (SQLException e) {
            b.d(e.toString());
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder stringBuilder = new StringBuilder("CREATE TABLE geoMessage(");
            for (int i = 0; i < g.length - 1; i += 2) {
                if (i != 0) {
                    stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                stringBuilder.append(g[i]);
                stringBuilder.append(" ");
                stringBuilder.append(f[i + 1]);
            }
            stringBuilder.append(",PRIMARY KEY(message_id,geo_id));");
            sQLiteDatabase.execSQL(stringBuilder.toString());
        } catch (SQLException e) {
            b.d(e.toString());
        }
    }

    public synchronized SQLiteDatabase a() {
        if (this.c.incrementAndGet() == 1) {
            this.e = getWritableDatabase();
        }
        return this.e;
    }

    public synchronized void b() {
        if (this.c.decrementAndGet() == 0) {
            this.e.close();
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (this.a) {
            try {
                a(sQLiteDatabase);
                b(sQLiteDatabase);
                b.c("GeoFenceDatabaseHelper. create tables");
            } catch (Throwable e) {
                b.a(e);
            }
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
