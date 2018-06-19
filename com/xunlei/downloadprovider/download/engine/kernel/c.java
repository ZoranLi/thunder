package com.xunlei.downloadprovider.download.engine.kernel;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.CursorLoader;
import com.xunlei.download.DownloadManager;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BTSubTaskLoader */
public class c {
    public final a a = new a();

    public final void a(Cursor cursor) {
        this.a.a(cursor);
    }

    public final long b(@NonNull Cursor cursor) {
        return cursor.getLong(this.a.a);
    }

    public final void a(@NonNull Cursor cursor, @NonNull BTSubTaskInfo bTSubTaskInfo) {
        a(cursor, this.a, bTSubTaskInfo);
    }

    public final List<BTSubTaskInfo> a(Context context, long j, @Nullable b bVar) {
        List arrayList = new ArrayList(10);
        try {
            String[] strArr = new String[]{String.valueOf(j)};
            Uri btSubTaskUri = g.a(context).getBtSubTaskUri();
            Cursor query = context.getContentResolver().query(btSubTaskUri, null, "bt_parent_id=?", strArr, null);
            this.a.a(query);
            if (query != null) {
                while (query.moveToNext()) {
                    long j2 = (long) query.getInt(this.a.a);
                    if (j2 != -1) {
                        BTSubTaskInfo bTSubTaskInfo = null;
                        if (bVar != null) {
                            bTSubTaskInfo = bVar.a(j2);
                        }
                        if (bTSubTaskInfo == null) {
                            bTSubTaskInfo = new BTSubTaskInfo();
                        }
                        bTSubTaskInfo.mTaskId = j2;
                        bTSubTaskInfo.mParentTaskId = j;
                        a(query, this.a, bTSubTaskInfo);
                        arrayList.add(bTSubTaskInfo);
                    }
                }
                query.close();
            }
        } catch (Context context2) {
            context2.printStackTrace();
        }
        return arrayList;
    }

    private static void a(Cursor cursor, a aVar, BTSubTaskInfo bTSubTaskInfo) {
        bTSubTaskInfo.mTaskId = cursor.getLong(aVar.a);
        bTSubTaskInfo.mBTSubIndex = cursor.getInt(aVar.g);
        bTSubTaskInfo.mTitle = cursor.getString(aVar.b);
        bTSubTaskInfo.mFileSize = cursor.getLong(aVar.c);
        bTSubTaskInfo.mDownloadedSize = cursor.getLong(aVar.d);
        bTSubTaskInfo.mLocalFileName = cursor.getString(aVar.e);
        bTSubTaskInfo.mRangeInfoStr = cursor.getString(aVar.j);
        int i = cursor.getInt(aVar.f);
        bTSubTaskInfo.mOriginalStatusCode = i;
        bTSubTaskInfo.mTaskStatus = DownloadManager.translateStatus(i);
        if (aVar.h != -1) {
            bTSubTaskInfo.mCID = cursor.getString(aVar.h);
        }
        if (aVar.i != -1) {
            bTSubTaskInfo.mGCID = cursor.getString(aVar.i);
        }
    }

    public static CursorLoader a(Context context, long j) {
        return new f(context, g.a(context).getBtSubTaskUri(), null, "bt_parent_id=?", new String[]{String.valueOf(j)}, null);
    }
}
