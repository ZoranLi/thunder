package com.xunlei.downloadprovider.homepage.follow;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.xunlei.downloadprovider.homepage.follow.a.a;
import com.xunlei.downloadprovider.homepage.follow.b.f;

/* compiled from: FollowManager */
final class t implements Runnable {
    final /* synthetic */ f a;
    final /* synthetic */ s b;

    t(s sVar, f fVar) {
        this.b = sVar;
        this.a = fVar;
    }

    public final void run() {
        a aVar = this.b.d.e;
        long j = this.a.b;
        SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("following_uid", Long.valueOf(j));
        writableDatabase.insert("following_id_list", "following_uid", contentValues);
        this.b.d.e.a(this.a);
    }
}
