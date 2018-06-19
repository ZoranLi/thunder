package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import android.database.sqlite.SQLiteDatabase;
import com.xunlei.downloadprovider.comment.a.a;
import com.xunlei.downloadprovider.comment.a.b;

/* compiled from: ShortMovieDetailDataLoader */
final class av implements a<Long> {
    final /* synthetic */ e a;

    av(e eVar) {
        this.a = eVar;
    }

    public final /* synthetic */ void a(Object obj) {
        Long l = (Long) obj;
        a j = this.a.a.h;
        long longValue = l.longValue();
        SQLiteDatabase writableDatabase;
        try {
            writableDatabase = j.getWritableDatabase();
            try {
                obj = new StringBuilder();
                obj.append("UPDATE comment_zan_info SET has_commit=1 WHERE comment_id=");
                obj.append(longValue);
                writableDatabase.execSQL(obj.toString());
                if (writableDatabase != null) {
                    writableDatabase.close();
                }
            } catch (Exception e) {
                obj = e;
                try {
                    obj.printStackTrace();
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                } catch (Throwable th) {
                    obj = th;
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                    throw obj;
                }
            }
        } catch (Exception e2) {
            Exception exception = e2;
            writableDatabase = null;
            obj = exception;
            obj.printStackTrace();
            if (writableDatabase != null) {
                writableDatabase.close();
            }
        } catch (Throwable th2) {
            Throwable th3 = th2;
            writableDatabase = null;
            obj = th3;
            if (writableDatabase != null) {
                writableDatabase.close();
            }
            throw obj;
        }
    }

    public final void a(b bVar) {
        new StringBuilder("sync local zan data to server failed:").append(bVar.b);
    }
}
