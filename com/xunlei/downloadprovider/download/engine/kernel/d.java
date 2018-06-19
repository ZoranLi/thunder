package com.xunlei.downloadprovider.download.engine.kernel;

import android.content.Context;
import android.database.Cursor;
import com.xunlei.download.DownloadManager;
import com.xunlei.download.DownloadManager.Query;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BasicTaskLoader */
public final class d {
    public Context a;
    private final e b = new e();
    private DownloadManager c;

    public d(Context context, DownloadManager downloadManager) {
        this.a = context;
        this.c = downloadManager;
    }

    public final List<Long> a() {
        List arrayList = new ArrayList();
        try {
            Query query = new Query();
            query.setFilterByStatus(31);
            query.orderBy("_id", 2);
            String[] projection = query.getProjection();
            String selection = query.getSelection();
            String[] selectionArgs = query.getSelectionArgs();
            String sortOrder = query.getSortOrder();
            Cursor query2 = this.a.getContentResolver().query(this.c.getDownloadUri(), projection, selection, selectionArgs, sortOrder);
            this.b.a(query2);
            if (query2 != null) {
                while (query2.moveToNext()) {
                    long j = (long) query2.getInt(this.b.a);
                    if (j != -1) {
                        arrayList.add(Long.valueOf(j));
                    }
                }
                query2.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
