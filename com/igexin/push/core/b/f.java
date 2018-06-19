package com.igexin.push.core.b;

import android.content.ContentValues;
import com.igexin.push.b.d;

class f extends d {
    final /* synthetic */ long a;
    final /* synthetic */ d b;

    f(d dVar, ContentValues contentValues, long j) {
        this.b = dVar;
        this.a = j;
        super(contentValues);
    }

    public void a() {
        this.c.delete("ral", "id=?", new String[]{String.valueOf(this.a)});
    }
}
