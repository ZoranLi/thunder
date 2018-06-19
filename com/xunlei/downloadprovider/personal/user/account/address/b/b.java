package com.xunlei.downloadprovider.personal.user.account.address.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alipay.sdk.cons.c;
import com.xunlei.downloadprovider.app.BrothersApplication;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: UserRegionCreateDB */
public final class b extends SQLiteOpenHelper {
    private static b a;

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b(BrothersApplication.getApplicationInstance());
            }
            bVar = a;
        }
        return bVar;
    }

    private b(Context context) {
        super(context, "newregion.db", null, 1);
    }

    private static Map<String, JSONObject> b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        Map<String, JSONObject> treeMap = new TreeMap(new a());
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            treeMap.put(optJSONObject.optString(c.e), optJSONObject);
        }
        return treeMap;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists province(id integer primary key autoincrement,province_code int,full_name text,name text)");
        sQLiteDatabase.execSQL("create table if not exists city(id integer primary key autoincrement,province_code int,city_code int,full_name text,name text)");
    }

    static /* synthetic */ JSONArray a(JSONObject jSONObject) {
        jSONObject = jSONObject.optJSONArray("zone");
        if (jSONObject != null) {
            for (int i = 0; i < jSONObject.length(); i++) {
                JSONObject optJSONObject = jSONObject.optJSONObject(i);
                if (optJSONObject != null) {
                    if ("中国".equals(optJSONObject.optString(c.e))) {
                        return optJSONObject.optJSONArray("zone");
                    }
                }
            }
        }
        return null;
    }

    static /* synthetic */ void a(b bVar, Map map) {
        if (map != null) {
            for (String str : map.keySet()) {
                JSONObject jSONObject = (JSONObject) map.get(str);
                int optInt = jSONObject.optInt("code");
                String optString = jSONObject.optString("fullname");
                String str2 = jSONObject.optString(c.e);
                SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("province_code", Integer.valueOf(optInt));
                contentValues.put("full_name", optString);
                contentValues.put(c.e, str2);
                writableDatabase.insert("province", null, contentValues);
            }
        }
    }

    static /* synthetic */ void b(b bVar, Map map) {
        if (map != null) {
            for (String str : map.keySet()) {
                JSONObject jSONObject = (JSONObject) map.get(str);
                JSONArray optJSONArray = jSONObject.optJSONArray("zone");
                int optInt = jSONObject.optInt("code");
                Map b = b(optJSONArray);
                if (b != null) {
                    for (String str2 : b.keySet()) {
                        JSONObject jSONObject2 = (JSONObject) b.get(str2);
                        int optInt2 = jSONObject2.optInt("code");
                        String optString = jSONObject2.optString("fullname");
                        String str22 = jSONObject2.optString(c.e);
                        SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("province_code", Integer.valueOf(optInt));
                        contentValues.put("city_code", Integer.valueOf(optInt2));
                        contentValues.put("full_name", optString);
                        contentValues.put(c.e, str22);
                        writableDatabase.insert("city", null, contentValues);
                    }
                }
            }
        }
    }
}
