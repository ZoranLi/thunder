package com.xunlei.downloadprovider.download.taskdetails.subtask;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import com.xunlei.downloadprovider.download.engine.kernel.c;
import com.xunlei.downloadprovider.download.engine.task.a.t;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.taskdetails.items.a.a;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.util.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: BTSubTaskListLoader */
final class e implements LoaderCallbacks<Cursor> {
    final /* synthetic */ b a;

    e(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        Cursor cursor = (Cursor) obj;
        b.o;
        b bVar = this.a;
        if (!bVar.f) {
            int i;
            long b;
            Collection collection;
            Collection collection2;
            int size = bVar.e.size();
            if (cursor != null) {
                cursor.getCount();
            }
            DownloadTaskInfo downloadTaskInfo = bVar.g;
            t tVar = bVar.b;
            bVar.a(cursor);
            Collection collection3 = bVar.e;
            HashMap hashMap = new HashMap(bVar.d.size());
            if (!bVar.d.isEmpty()) {
                Iterator it = bVar.d.iterator();
                while (it.hasNext()) {
                    Iterator it2;
                    a aVar = (a) it.next();
                    BTSubTaskItem bTSubTaskItem = (BTSubTaskItem) aVar.a(BTSubTaskItem.class);
                    if (bTSubTaskItem != null) {
                        i = size;
                        it2 = it;
                        hashMap.put(b.a(bTSubTaskItem.mParentTaskId, bTSubTaskItem.mTaskId), aVar);
                    } else {
                        i = size;
                        it2 = it;
                    }
                    size = i;
                    it = it2;
                }
            }
            i = size;
            Collection arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            Collection arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            collection3.clear();
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    ArrayList arrayList7;
                    BTSubTaskInfo bTSubTaskInfo;
                    Cursor cursor2;
                    List list;
                    Collection collection4;
                    ArrayList arrayList8;
                    DownloadTaskInfo downloadTaskInfo2;
                    HashMap hashMap2;
                    List list2;
                    List list3;
                    List list4;
                    ArrayList arrayList9 = arrayList6;
                    b = bVar.b(cursor);
                    Collection collection5 = arrayList5;
                    ArrayList arrayList10 = arrayList4;
                    long taskId = downloadTaskInfo.getTaskId();
                    BTSubTaskInfo bTSubTaskInfo2 = null;
                    a aVar2 = (a) hashMap.get(b.a(taskId, b));
                    if (aVar2 != null) {
                        arrayList7 = arrayList2;
                        bTSubTaskInfo2 = (BTSubTaskItem) aVar2.a(BTSubTaskItem.class);
                    } else {
                        arrayList7 = arrayList2;
                    }
                    if (bTSubTaskInfo2 == null) {
                        BTSubTaskInfo bTSubTaskItem2;
                        if (b <= 0 || taskId <= 0) {
                            bTSubTaskItem2 = new BTSubTaskItem();
                        } else {
                            String a = b.a(taskId, b);
                            bTSubTaskItem2 = (BTSubTaskItem) bVar.h.get(a);
                            if (bTSubTaskItem2 == null) {
                                bTSubTaskItem2 = new BTSubTaskItem();
                                bVar.h.put(a, bTSubTaskItem2);
                            }
                        }
                        bTSubTaskInfo = bTSubTaskItem2;
                    } else {
                        bTSubTaskInfo = bTSubTaskInfo2;
                    }
                    bVar.a(cursor, bTSubTaskInfo);
                    bTSubTaskInfo.mParentTaskId = taskId;
                    if (aVar2 == null) {
                        cursor2 = cursor;
                        list = arrayList9;
                        collection4 = collection5;
                        arrayList8 = arrayList10;
                        downloadTaskInfo2 = downloadTaskInfo;
                        hashMap2 = hashMap;
                        list2 = arrayList7;
                        list3 = arrayList3;
                        a aVar3 = new a(11, downloadTaskInfo, bTSubTaskInfo, bTSubTaskInfo.mTaskId);
                    } else {
                        cursor2 = cursor;
                        downloadTaskInfo2 = downloadTaskInfo;
                        hashMap2 = hashMap;
                        list = arrayList9;
                        arrayList8 = arrayList10;
                        collection4 = collection5;
                        list2 = arrayList7;
                        list3 = arrayList3;
                        aVar2.c = bTSubTaskInfo;
                    }
                    BTSubTaskItem bTSubTaskItem3 = (BTSubTaskItem) aVar2.a(BTSubTaskItem.class);
                    if (k.b(bTSubTaskItem3)) {
                        arrayList.add(aVar2);
                        list4 = arrayList8;
                        list4.add(bTSubTaskItem3);
                        arrayList5 = collection4;
                    } else {
                        list4 = arrayList8;
                        if (k.a(bTSubTaskItem3)) {
                            list2.add(aVar2);
                            arrayList5 = collection4;
                            arrayList5.add(bTSubTaskItem3);
                        } else {
                            arrayList5 = collection4;
                            list3.add(aVar2);
                            list.add(bTSubTaskItem3);
                        }
                    }
                    Object obj2 = "新水浒传02";
                    if (bTSubTaskItem3.mTitle.contains(obj2)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(obj2);
                        stringBuilder.append(" btIndex : ");
                        stringBuilder.append(bTSubTaskItem3.mBTSubIndex);
                        stringBuilder.append(" status : ");
                        stringBuilder.append(bTSubTaskItem3.mTaskStatus);
                    }
                    List list5 = list4;
                    List list6 = list2;
                    List list7 = list3;
                    downloadTaskInfo = downloadTaskInfo2;
                    hashMap = hashMap2;
                    e eVar = this;
                    list4 = list;
                    cursor = cursor2;
                }
                ArrayList arrayList11 = arrayList6;
                collection = arrayList2;
                collection2 = arrayList3;
                collection3.addAll(arrayList4);
                collection3.addAll(arrayList5);
                collection3.addAll(arrayList11);
                if (!collection3.isEmpty()) {
                    try {
                        tVar.execute(new f(bVar, new ArrayList(collection3)));
                    } catch (RejectedExecutionException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                collection = arrayList2;
                collection2 = arrayList3;
            }
            bVar.d.clear();
            bVar.d.addAll(arrayList);
            bVar.d.addAll(collection);
            bVar.d.addAll(collection2);
            boolean z = (i == 0 || i == bVar.e.size()) ? false : true;
            if (!bVar.n) {
                bVar.n = true;
                if (k.e(bVar.g)) {
                    com.xunlei.downloadprovider.download.report.a.e("file_list", "bt");
                }
            }
            b = System.currentTimeMillis();
            if (b - bVar.i <= 5000) {
                if (!z) {
                    bVar.j = true;
                }
            }
            bVar.i = b;
            bVar.j = false;
            if (bVar.l != null) {
                bVar.l.a(bVar.d, z);
            }
        }
    }

    public final Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        b.o;
        try {
            return c.a(this.a.k, this.a.g.getTaskId());
        } catch (int i2) {
            i2.printStackTrace();
            return 0;
        }
    }

    public final void onLoaderReset(Loader<Cursor> loader) {
        b.o;
        if (loader != null) {
            try {
                loader.stopLoading();
            } catch (Loader<Cursor> loader2) {
                loader2.printStackTrace();
            }
        }
    }
}
