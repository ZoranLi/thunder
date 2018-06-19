package com.xunlei.downloadprovider.database.b;

import android.database.sqlite.SQLiteDatabase;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.database.greendao.DaoMaster;
import com.xunlei.downloadprovider.database.greendao.DaoSession;
import org.greenrobot.greendao.database.Database;

/* compiled from: GreenDaoDatabase */
public class a {
    private static volatile a a;
    private DaoSession b;
    private DaoMaster c;
    private b d;

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a aVar = new a();
                    a = aVar;
                    aVar.c();
                }
            }
        }
        return a;
    }

    private synchronized void c() {
        if (this.d == null) {
            this.d = new b(BrothersApplication.getApplicationInstance(), "greendao.db");
        }
        SQLiteDatabase writableDatabase = this.d.getWritableDatabase();
        if (this.c == null) {
            this.c = new DaoMaster(writableDatabase);
        }
        this.b = this.c.newSession();
    }

    public final synchronized DaoSession b() {
        if (this.b == null) {
            c();
        }
        return this.b;
    }

    public final synchronized void a(SQLiteDatabase sQLiteDatabase) {
        if (this.c == null) {
            this.c = new DaoMaster(sQLiteDatabase);
        }
        if (this.c != null) {
            DaoMaster.dropAllTables(this.c.getDatabase(), true);
        }
    }

    public final synchronized void b(SQLiteDatabase sQLiteDatabase) {
        if (this.c == null) {
            this.c = new DaoMaster(sQLiteDatabase);
        }
        if (this.c != null) {
            DaoMaster.createAllTables(this.c.getDatabase(), true);
        }
    }

    public final synchronized void a(Database database) {
        if (this.c == null) {
            this.c = new DaoMaster(database);
        }
        if (this.c != null) {
            DaoMaster.createAllTables(this.c.getDatabase(), true);
        }
    }
}
