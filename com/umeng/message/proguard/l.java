package com.umeng.message.proguard;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.provider.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: MsgLogStore */
public class l {
    private static final String A = " And ";
    private static final String B = " Asc ";
    private static final String C = " Desc ";
    public static final String a = "MsgLogStore.db";
    public static final int b = 5;
    public static final String c = "MsgLogStore";
    public static final String d = "MsgLogIdTypeStore";
    public static final String e = "MsgLogStoreForAgoo";
    public static final String f = "MsgLogIdTypeStoreForAgoo";
    public static final String g = "MsgConfigInfo";
    public static final String h = "InAppLogStore";
    public static final String i = "MsgId";
    public static final String j = "MsgType";
    public static final String k = "ActionType";
    public static final String l = "Time";
    public static final String m = "TaskId";
    public static final String n = "MsgStatus";
    public static final String o = "SerialNo";
    public static final String p = "AppLaunchAt";
    public static final String q = "UpdateResponse";
    public static final String r = "NumDisplay";
    public static final String s = "NumOpenFull";
    public static final String t = "NumOpenTop";
    public static final String u = "NumOpenBottom";
    public static final String v = "NumClose";
    public static final String w = "NumDuration";
    private static final String x = "com.umeng.message.proguard.l";
    private static l y;
    private Context z;

    public boolean a(String str, String str2, String str3, long j) {
        return false;
    }

    public static l a(Context context) {
        if (y == null) {
            l lVar = new l(context);
            y = lVar;
            lVar.h();
        }
        return y;
    }

    private l(Context context) {
        this.z = context.getApplicationContext();
    }

    private void h() {
        if (!MessageSharedPrefs.getInstance(this.z).hasTransferedCacheFileDataToSQL()) {
            File[] listFiles = this.z.getCacheDir().listFiles(new 1(this));
            if (listFiles != null) {
                for (File file : listFiles) {
                    a(file);
                    file.delete();
                }
            }
            MessageSharedPrefs.getInstance(this.z).finishTransferedCacheFileDataToSQL();
        }
    }

    private void a(File file) {
        try {
            JSONObject jSONObject = new JSONObject(b(file));
            a(jSONObject.optString("msg_id"), jSONObject.optInt(MsgConstant.KEY_ACTION_TYPE), jSONObject.optLong(MsgConstant.KEY_TS));
        } catch (File file2) {
            file2.printStackTrace();
        }
    }

    private String b(File file) throws IOException {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                file = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    file.append(readLine);
                }
                file = file.toString();
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return file;
            } catch (Throwable th) {
                file = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw file;
            }
        } catch (Throwable th2) {
            file = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw file;
        }
    }

    public boolean a(String str, int i, long j) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        a aVar = new a(this, str, i, j);
        str = this.z.getContentResolver();
        a.a(this.z);
        if (str.insert(a.f, aVar.a()) != null) {
            return true;
        }
        return false;
    }

    public boolean a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArr = new String[]{str, String.valueOf(i)};
        str = this.z.getContentResolver();
        a.a(this.z);
        if (str.delete(a.f, "MsgId=? And ActionType=?", strArr) == 1) {
            return true;
        }
        return false;
    }

    public a a(String str) {
        a aVar = null;
        if (TextUtils.isEmpty(str) != null) {
            return null;
        }
        String[] strArr = new String[null];
        ContentResolver contentResolver = this.z.getContentResolver();
        a.a(this.z);
        str = contentResolver.query(a.f, null, "MsgId=?", strArr, null);
        if (str.moveToFirst()) {
            aVar = new a(this, str);
        }
        if (str != null) {
            str.close();
        }
        return aVar;
    }

    public ArrayList<a> a(int i) {
        if (i <= 0) {
            return 0;
        }
        ArrayList<a> arrayList = new ArrayList();
        a.a(this.z);
        Uri build = a.f.buildUpon().appendQueryParameter("limit", String.valueOf(i)).build();
        i = this.z.getContentResolver().query(build, null, null, null, "Time Asc ");
        for (boolean moveToFirst = i.moveToFirst(); moveToFirst; moveToFirst = i.moveToNext()) {
            arrayList.add(new a(this, i));
        }
        if (i != 0) {
            i.close();
        }
        return arrayList;
    }

    public ArrayList<a> a() {
        ArrayList<a> arrayList = new ArrayList();
        ContentResolver contentResolver = this.z.getContentResolver();
        a.a(this.z);
        Cursor query = contentResolver.query(a.f, null, null, null, "Time Asc ");
        if (query == null) {
            return arrayList;
        }
        for (boolean moveToFirst = query.moveToFirst(); moveToFirst; moveToFirst = query.moveToNext()) {
            arrayList.add(new a(this, query));
        }
        if (query != null) {
            query.close();
        }
        return arrayList;
    }

    public boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        c cVar = new c(this, str, str2);
        str = this.z.getContentResolver();
        a.a(this.z);
        if (str.insert(a.g, cVar.a()) != null) {
            return true;
        }
        return false;
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArr = new String[]{str};
        str = this.z.getContentResolver();
        a.a(this.z);
        return str.delete(a.g, "MsgId=?", strArr) == 1;
    }

    public ArrayList<c> b(int i) {
        if (i <= 0) {
            return 0;
        }
        ArrayList<c> arrayList = new ArrayList();
        a.a(this.z);
        Uri build = a.g.buildUpon().appendQueryParameter("limit", String.valueOf(i)).build();
        i = this.z.getContentResolver().query(build, null, null, null, "MsgId Asc ");
        for (boolean moveToFirst = i.moveToFirst(); moveToFirst; moveToFirst = i.moveToNext()) {
            arrayList.add(new c(this, i));
        }
        if (i != 0) {
            i.close();
        }
        return arrayList;
    }

    public ArrayList<c> b() {
        ArrayList<c> arrayList = new ArrayList();
        ContentResolver contentResolver = this.z.getContentResolver();
        a.a(this.z);
        Cursor query = contentResolver.query(a.g, null, null, null, "MsgId Asc ");
        for (boolean moveToFirst = query.moveToFirst(); moveToFirst; moveToFirst = query.moveToNext()) {
            arrayList.add(new c(this, query));
        }
        if (query != null) {
            query.close();
        }
        return arrayList;
    }

    public boolean b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArr = new String[]{str, str2};
        str2 = this.z.getContentResolver();
        a.a(this.z);
        if (str2.delete(a.h, "MsgId=? And MsgStatus=?", strArr) == 1) {
            return true;
        }
        return false;
    }

    public b c(String str) {
        b bVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] strArr = new String[]{str};
        ContentResolver contentResolver = this.z.getContentResolver();
        a.a(this.z);
        str = contentResolver.query(a.h, null, "MsgId=?", strArr, null);
        if (str.moveToFirst()) {
            bVar = new b(this, str);
        }
        if (str != null) {
            str.close();
        }
        return bVar;
    }

    public ArrayList<b> c(int i) {
        if (i <= 0) {
            return 0;
        }
        ArrayList<b> arrayList = new ArrayList();
        a.a(this.z);
        Uri build = a.h.buildUpon().appendQueryParameter("limit", String.valueOf(i)).build();
        i = this.z.getContentResolver().query(build, null, null, null, "Time Asc ");
        for (boolean moveToFirst = i.moveToFirst(); moveToFirst; moveToFirst = i.moveToNext()) {
            arrayList.add(new b(this, i));
        }
        if (i != 0) {
            i.close();
        }
        return arrayList;
    }

    public ArrayList<b> c() {
        ArrayList<b> arrayList = new ArrayList();
        ContentResolver contentResolver = this.z.getContentResolver();
        a.a(this.z);
        Cursor query = contentResolver.query(a.h, null, null, null, "Time Asc ");
        for (boolean moveToFirst = query.moveToFirst(); moveToFirst; moveToFirst = query.moveToNext()) {
            arrayList.add(new b(this, query));
        }
        if (query != null) {
            query.close();
        }
        return arrayList;
    }

    public boolean a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        d dVar = new d(this, str, str2, str3);
        str = this.z.getContentResolver();
        a.a(this.z);
        if (str.insert(a.i, dVar.a()) != null) {
            return true;
        }
        return false;
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArr = new String[]{str};
        str = this.z.getContentResolver();
        a.a(this.z);
        return str.delete(a.i, "MsgId=?", strArr) == 1;
    }

    public ArrayList<d> d(int i) {
        if (i <= 0) {
            return 0;
        }
        ArrayList<d> arrayList = new ArrayList();
        a.a(this.z);
        Uri build = a.i.buildUpon().appendQueryParameter("limit", String.valueOf(i)).build();
        i = this.z.getContentResolver().query(build, null, null, null, "MsgId Asc ");
        for (boolean moveToFirst = i.moveToFirst(); moveToFirst; moveToFirst = i.moveToNext()) {
            arrayList.add(new d(this, i));
        }
        if (i != 0) {
            i.close();
        }
        return arrayList;
    }

    public ArrayList<d> d() {
        ArrayList<d> arrayList = new ArrayList();
        ContentResolver contentResolver = this.z.getContentResolver();
        a.a(this.z);
        Cursor query = contentResolver.query(a.i, null, null, null, "MsgId Asc ");
        for (boolean moveToFirst = query.moveToFirst(); moveToFirst; moveToFirst = query.moveToNext()) {
            arrayList.add(new d(this, query));
        }
        if (query != null) {
            query.close();
        }
        return arrayList;
    }

    public int e() {
        ContentResolver contentResolver = this.z.getContentResolver();
        a.a(this.z);
        Uri uri = a.j;
        String[] strArr = new String[1];
        int i = 0;
        strArr[0] = o;
        Cursor query = contentResolver.query(uri, strArr, null, null, null);
        if (query.moveToFirst()) {
            i = query.getInt(query.getColumnIndex(o));
        }
        if (query != null) {
            query.close();
        }
        return i;
    }

    public void e(int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(o, String.valueOf(i));
        i = this.z.getContentResolver();
        a.a(this.z);
        i.update(a.j, contentValues, null, null);
    }

    public long f() {
        ContentResolver contentResolver = this.z.getContentResolver();
        a.a(this.z);
        Cursor query = contentResolver.query(a.j, new String[]{p}, null, null, null);
        long j = 0;
        if (query == null) {
            return 0;
        }
        if (query.moveToFirst()) {
            j = query.getLong(query.getColumnIndex(p));
        }
        if (query != null) {
            query.close();
        }
        return j;
    }

    public void a(long j) {
        ContentResolver contentResolver = this.z.getContentResolver();
        a.a(this.z);
        Cursor query = contentResolver.query(a.j, new String[]{p}, null, null, null);
        int count = query.getCount();
        if (query != null) {
            query.close();
        }
        if (count > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(p, String.valueOf(j));
            j = this.z.getContentResolver();
            a.a(this.z);
            j.update(a.j, contentValues, null, null);
            return;
        }
        contentValues = new ContentValues();
        contentValues.put(p, String.valueOf(j));
        j = this.z.getContentResolver();
        a.a(this.z);
        j.insert(a.j, contentValues);
    }

    public Object g() {
        ContentResolver contentResolver = this.z.getContentResolver();
        a.a(this.z);
        Cursor query = contentResolver.query(a.j, new String[]{q}, null, null, null);
        String string = query.moveToFirst() ? query.getString(query.getColumnIndex(q)) : null;
        if (query != null) {
            query.close();
        }
        return h.f(string);
    }

    public void a(Object obj) {
        obj = h.a(obj);
        ContentValues contentValues = new ContentValues();
        contentValues.put(q, obj);
        obj = this.z.getContentResolver();
        a.a(this.z);
        obj.update(a.j, contentValues, null, null);
    }
}
