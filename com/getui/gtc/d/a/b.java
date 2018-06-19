package com.getui.gtc.d.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.getui.gtc.a.h;
import com.getui.gtc.e.i;
import com.getui.gtc.entity.a;
import com.xunlei.downloadprovider.download.tasklist.list.feed.e.c;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

public final class b extends a {
    public SparseArray b;
    public SparseArray c;

    public b(SQLiteOpenHelper sQLiteOpenHelper) {
        super(sQLiteOpenHelper);
    }

    protected final String a() {
        return c.a;
    }

    public final void a(int i) {
        if (this.c != null) {
            this.c.remove(i);
        }
        a("id=? and k=?", new String[]{String.valueOf(i), "1002"});
    }

    public final boolean a(int i, int i2, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(AgooConstants.MESSAGE_ID, Integer.valueOf(i));
        contentValues.put("k", Integer.valueOf(i2));
        contentValues.put("v", bArr);
        return a(contentValues) != -1;
    }

    public final void b() {
        Throwable th;
        Cursor rawQuery;
        try {
            rawQuery = this.a.getReadableDatabase().rawQuery("select id, k, v from c order by id", null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    try {
                        int i = rawQuery.getInt(0);
                        byte[] blob;
                        switch (rawQuery.getInt(1)) {
                            case 1001:
                                blob = rawQuery.getBlob(2);
                                if (blob == null) {
                                    break;
                                }
                                Object str = new String(i.a(blob, h.b));
                                if (!TextUtils.isEmpty(str)) {
                                    this.b.put(i, a.a(new JSONObject(str)));
                                    String[] strArr = new String[1];
                                    StringBuilder stringBuilder = new StringBuilder("sdkid : ");
                                    stringBuilder.append(i);
                                    strArr[0] = stringBuilder.toString();
                                    break;
                                }
                                break;
                            case 1002:
                                blob = rawQuery.getBlob(2);
                                if (blob == null) {
                                    break;
                                }
                                CharSequence str2 = new String(i.a(blob, h.b));
                                if (!TextUtils.isEmpty(str2)) {
                                    this.c.put(i, str2);
                                    break;
                                }
                                break;
                            default:
                                break;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Throwable th3) {
            rawQuery = null;
            th = th3;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
    }
}
