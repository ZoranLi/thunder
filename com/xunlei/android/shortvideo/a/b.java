package com.xunlei.android.shortvideo.a;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: ShortVideoStat */
final class b implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ a b;

    b(a aVar, String str) {
        this.b = aVar;
        this.a = str;
    }

    public final void run() {
        if (this.b.j) {
            this.b.e = SQLiteDatabase.openOrCreateDatabase("/sdcard/short_video_debugInfo.db", null);
            if (this.b.e != null) {
                StringBuilder stringBuilder = new StringBuilder("create table if not exists ");
                stringBuilder.append(this.b.d);
                stringBuilder.append(" (id INTEGER PRIMARY KEY AUTOINCREMENT );");
                this.b.e.execSQL(stringBuilder.toString());
            }
        }
        a.a(this.b, this.a);
    }
}
