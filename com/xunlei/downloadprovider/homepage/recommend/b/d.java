package com.xunlei.downloadprovider.homepage.recommend.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: LikeRecordHelper */
public final class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ c e;

    public d(c cVar, String str, String str2, String str3, String str4) {
        this.e = cVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    public final void run() {
        if ((this.e.a.a(this.a) != null ? 1 : null) == null) {
            b bVar = new b();
            bVar.b = this.b;
            bVar.c = this.c;
            bVar.d = this.a;
            bVar.e = this.d;
            SQLiteDatabase writableDatabase = this.e.a.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(a.c, bVar.b);
            contentValues.put(a.d, bVar.c);
            contentValues.put(a.e, bVar.d);
            contentValues.put(a.f, bVar.e);
            writableDatabase.insert(a.a, null, contentValues);
            writableDatabase.close();
        }
    }
}
