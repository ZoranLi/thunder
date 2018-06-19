package com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.umeng.message.proguard.k;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: BaseTable */
public abstract class a extends com.xunlei.downloadprovider.download.engine.task.a.a.a.a {
    protected String c = "chat.BaseTable";
    protected SQLiteDatabase d = null;
    private o e = null;
    private String f = null;
    private List<q> g = null;
    private int h;
    private Map<String, q> i;
    private q j;
    private List<q> k;

    protected abstract String c();

    protected abstract List<q> d();

    public a(o oVar) {
        super(1, 1);
        int i = 0;
        this.h = 0;
        this.i = null;
        this.j = null;
        this.k = null;
        StringBuilder stringBuilder = new StringBuilder("chat.");
        stringBuilder.append(getClass().getSimpleName());
        this.c = stringBuilder.toString();
        this.e = oVar;
        this.f = c();
        this.g = d();
        this.h = this.g.size();
        this.k = new ArrayList();
        this.i = new HashMap();
        while (i < this.h) {
            q qVar = (q) this.g.get(i);
            if (this.j == null && qVar.c) {
                this.j = qVar;
            }
            if (qVar.f) {
                this.k.add(qVar);
            }
            this.i.put(qVar.a, qVar);
            i++;
        }
    }

    public final void a() {
        this.d = this.e.c();
    }

    public final void b() {
        this.e.d();
        this.d = null;
    }

    private static boolean a(String str) {
        if (!"INTEGER".equals(str)) {
            if ("SMALLINT".equals(str) == null) {
                return null;
            }
        }
        return true;
    }

    public final int a(String str, String[] strArr) {
        return this.d.delete(c(), str, strArr);
    }

    public final boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            SQLiteDatabase sQLiteDatabase = this.d;
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (this.i.containsKey(str)) {
                    q qVar = (q) this.i.get(str);
                    if (!qVar.c || !qVar.e) {
                        stringBuffer2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        stringBuffer2.append(str);
                        if (a(qVar.b)) {
                            stringBuffer3.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            stringBuffer3.append(jSONObject.optLong(str));
                        } else {
                            stringBuffer3.append(",'");
                            stringBuffer3.append(jSONObject.optString(str).replace("'", "''"));
                            stringBuffer3.append("'");
                        }
                    }
                }
            }
            String str2 = null;
            if (stringBuffer2.length() <= null || stringBuffer3.length() <= null) {
                jSONObject = null;
            } else {
                stringBuffer.append("INSERT INTO ");
                stringBuffer.append(this.f);
                stringBuffer.append(" ( ");
                stringBuffer.append(stringBuffer2.substring(1));
                stringBuffer.append(" ) ");
                stringBuffer.append(" VALUES ");
                stringBuffer.append(" ( ");
                stringBuffer.append(stringBuffer3.substring(1));
                stringBuffer.append(" ) ");
                new StringBuilder("insertSql: ").append(stringBuffer.toString());
                jSONObject = stringBuffer.toString();
            }
            if (!TextUtils.isEmpty(jSONObject)) {
                String str3 = "INSERT";
                int indexOf = jSONObject.indexOf(str3);
                str2 = new StringBuffer(jSONObject).replace(indexOf, str3.length() + indexOf, "INSERT OR REPLACE").toString();
            }
            sQLiteDatabase.execSQL(str2);
            return true;
        } catch (JSONObject jSONObject2) {
            jSONObject2.printStackTrace();
            return false;
        }
    }

    public final boolean a(JSONArray jSONArray) {
        boolean z = false;
        if (jSONArray != null) {
            if (jSONArray.length() != 0) {
                try {
                    this.d.beginTransaction();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        a(jSONArray.optJSONObject(i));
                    }
                    this.d.setTransactionSuccessful();
                    return true;
                } catch (JSONArray jSONArray2) {
                    jSONArray2.printStackTrace();
                    return z;
                } finally {
                    z = this.d;
                    z.endTransaction();
                }
            }
        }
        return false;
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder stringBuilder = new StringBuilder(k.o);
        stringBuilder.append(c());
        stringBuilder.append(" (");
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder.toString());
        CharSequence stringBuilder3 = new StringBuilder(", PRIMARY KEY (");
        int i = 0;
        int i2 = 0;
        while (i < this.h) {
            q qVar = (q) this.g.get(i);
            stringBuilder2.append("`");
            stringBuilder2.append(qVar.a);
            stringBuilder2.append("` ");
            stringBuilder2.append(" ");
            stringBuilder2.append(qVar.b);
            stringBuilder2.append(" ");
            stringBuilder2.append(" ");
            stringBuilder2.append(qVar.f ? "UNIQUE " : " ");
            stringBuilder2.append(" ");
            stringBuilder2.append(qVar.e ? "AUTOINCREMENT " : " ");
            if (i < this.h - 1) {
                stringBuilder2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            if (qVar.c) {
                stringBuilder3.append(" `");
                stringBuilder3.append(qVar.a);
                stringBuilder3.append("`, ");
                i2 = 1;
            }
            i++;
        }
        if (i2 != 0) {
            stringBuilder3.deleteCharAt(stringBuilder3.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)).append(k.t);
            stringBuilder2.append(stringBuilder3);
        }
        stringBuilder2.append(");");
        new StringBuilder("createTable.sql: ").append(stringBuilder2.toString());
        sQLiteDatabase.execSQL(stringBuilder2.toString());
    }

    public final int a(JSONObject jSONObject, String str, String[] strArr) {
        ContentValues contentValues = new ContentValues();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            if (this.i.containsKey(str2)) {
                if (a(((q) this.i.get(str2)).b)) {
                    contentValues.put(str2, Long.valueOf(jSONObject.optLong(str2)));
                } else {
                    contentValues.put(str2, jSONObject.optString(str2));
                }
            }
        }
        return contentValues.size() > null ? this.d.update(this.f, contentValues, str, strArr) : null;
    }
}
