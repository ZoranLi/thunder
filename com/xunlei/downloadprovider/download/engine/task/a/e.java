package com.xunlei.downloadprovider.download.engine.task.a;

import android.database.Cursor;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader.OnLoadCompleteListener;
import java.util.ArrayList;

/* compiled from: CoreTaskManager */
final class e implements OnLoadCompleteListener<Cursor> {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    public final /* synthetic */ void onLoadComplete(Loader loader, Object obj) {
        Cursor cursor = (Cursor) obj;
        loader = this.a;
        c cVar = this.a;
        int i = cVar.e + 1;
        cVar.e = i;
        int i2 = 10000;
        if (i <= 10000) {
            i2 = this.a.e;
        }
        loader.e = i2;
        loader = new o(cursor);
        cVar = this.a;
        o.a();
        cVar.a(new ArrayList(loader.d));
        if (cursor != null) {
            new StringBuilder("TaskCount:  ").append(cursor.getCount());
        }
        this.a.d = true;
    }
}
