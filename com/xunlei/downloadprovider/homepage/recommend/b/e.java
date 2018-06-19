package com.xunlei.downloadprovider.homepage.recommend.b;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: LikeRecordHelper */
public final class e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ c b;

    public e(c cVar, String str) {
        this.b = cVar;
        this.a = str;
    }

    public final void run() {
        a aVar = this.b.a;
        String str = this.a;
        SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
        String str2 = a.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a.e);
        stringBuilder.append("=");
        stringBuilder.append(str);
        writableDatabase.delete(str2, stringBuilder.toString(), null);
        writableDatabase.close();
    }
}
