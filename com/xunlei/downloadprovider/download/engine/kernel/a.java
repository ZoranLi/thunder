package com.xunlei.downloadprovider.download.engine.kernel;

import android.database.Cursor;
import com.xunlei.download.Downloads.Impl;

/* compiled from: BTColumnIndex */
public final class a {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;

    public final void a(Cursor cursor) {
        if (cursor != null) {
            this.a = cursor.getColumnIndex("_id");
            this.g = cursor.getColumnIndex("bt_sub_index");
            this.b = cursor.getColumnIndex("title");
            this.c = cursor.getColumnIndex("total_bytes");
            this.d = cursor.getColumnIndex(Impl.COLUMN_CURRENT_BYTES);
            this.e = cursor.getColumnIndex(Impl._DATA);
            this.f = cursor.getColumnIndex("status");
            this.h = cursor.getColumnIndex("cid");
            this.i = cursor.getColumnIndex("gcid");
            this.j = cursor.getColumnIndex(Impl.COLUMN_RANGE_INFO);
        }
    }
}
