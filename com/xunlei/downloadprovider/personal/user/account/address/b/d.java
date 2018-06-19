package com.xunlei.downloadprovider.personal.user.account.address.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.personal.user.account.address.c.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: UserRegionDBHelper */
public class d extends SQLiteOpenHelper {
    private static d a;

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d(BrothersApplication.getApplicationInstance());
                }
            }
        }
        return a;
    }

    private d(Context context) {
        this(context, "newregion.db");
    }

    private d(Context context, String str) {
        super(context, str, null, 1);
    }

    public static boolean b() {
        return BrothersApplication.getApplicationInstance().getDatabasePath("newregion.db").exists();
    }

    public final synchronized List<a> c() {
        if (!b()) {
            return null;
        }
        if (!a("province")) {
            return null;
        }
        List<a> arrayList = new ArrayList();
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT PROVINCE_CODE,NAME FROM PROVINCE", null);
        while (rawQuery.moveToNext()) {
            int i = rawQuery.getInt(0);
            String string = rawQuery.getString(1);
            a aVar = new a();
            aVar.b = i;
            aVar.a = string;
            arrayList.add(aVar);
        }
        rawQuery.close();
        return arrayList;
    }

    public final synchronized List<a> a(int i) {
        if (!a("city")) {
            return 0;
        }
        List<a> arrayList = new ArrayList();
        i = getReadableDatabase().rawQuery("SELECT CITY_CODE,NAME FROM CITY WHERE PROVINCE_CODE = ?", new String[]{String.valueOf(i)});
        while (i.moveToNext()) {
            int i2 = i.getInt(0);
            String string = i.getString(1);
            a aVar = new a();
            aVar.b = i2;
            aVar.a = string;
            arrayList.add(aVar);
        }
        i.close();
        return arrayList;
    }

    private boolean a(String str) {
        Cursor cursor = null;
        boolean z = false;
        try {
            SQLiteDatabase readableDatabase = getReadableDatabase();
            StringBuilder stringBuilder = new StringBuilder("select count(*) as c from sqlite_master where type ='table' and name ='");
            stringBuilder.append(str.trim());
            stringBuilder.append("' ");
            str = readableDatabase.rawQuery(stringBuilder.toString(), null);
            try {
                if (str.moveToNext() && str.getInt(0) > 0) {
                    z = true;
                }
                if (str != null) {
                    str.close();
                }
            } catch (Exception e) {
                Exception exception = e;
                cursor = str;
                str = exception;
                try {
                    str.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return z;
                } catch (Throwable th) {
                    str = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw str;
                }
            } catch (Throwable th2) {
                Throwable th3 = th2;
                cursor = str;
                str = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw str;
            }
        } catch (Exception e2) {
            str = e2;
            str.printStackTrace();
            if (cursor != null) {
                cursor.close();
            }
            return z;
        }
        return z;
    }

    public static void d() {
        if (a != null) {
            a.close();
        }
        a = null;
    }
}
