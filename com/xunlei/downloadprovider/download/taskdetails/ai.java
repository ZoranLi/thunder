package com.xunlei.downloadprovider.download.taskdetails;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import com.xunlei.downloadprovider.download.engine.kernel.c;
import com.xunlei.downloadprovider.download.engine.task.a.t;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.taskdetails.items.a.a;
import com.xunlei.downloadprovider.download.taskdetails.subtask.BTSubTaskItem;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: TaskDetailFragment */
final class ai implements LoaderCallbacks<Cursor> {
    final /* synthetic */ TaskDetailFragment a;

    ai(TaskDetailFragment taskDetailFragment) {
        this.a = taskDetailFragment;
    }

    public final /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        Cursor cursor = (Cursor) obj;
        TaskDetailFragment taskDetailFragment = this.a;
        if (!taskDetailFragment.isDetached()) {
            if (!taskDetailFragment.isRemoving()) {
                TaskDetailFragment taskDetailFragment2;
                b bVar = taskDetailFragment.b;
                DownloadTaskInfo downloadTaskInfo = taskDetailFragment.d;
                boolean z = taskDetailFragment.g;
                t tVar = taskDetailFragment.o;
                bVar.a.a(cursor);
                Collection collection = bVar.m;
                List a = bVar.a();
                HashMap hashMap = new HashMap(bVar.l.size());
                if (!bVar.l.isEmpty()) {
                    Iterator it = bVar.l.iterator();
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        BTSubTaskItem bTSubTaskItem = (BTSubTaskItem) aVar.a(BTSubTaskItem.class);
                        if (bTSubTaskItem != null) {
                            taskDetailFragment2 = taskDetailFragment;
                            hashMap.put(b.a(bTSubTaskItem.mParentTaskId, bTSubTaskItem.mTaskId), aVar);
                        } else {
                            taskDetailFragment2 = taskDetailFragment;
                        }
                        taskDetailFragment = taskDetailFragment2;
                        ai aiVar = this;
                    }
                }
                taskDetailFragment2 = taskDetailFragment;
                bVar.l.clear();
                collection.clear();
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        BTSubTaskInfo bTSubTaskInfo;
                        HashMap hashMap2;
                        a aVar2;
                        long b = bVar.a.b(cursor);
                        long taskId = downloadTaskInfo.getTaskId();
                        BTSubTaskInfo bTSubTaskInfo2 = null;
                        a aVar3 = (a) hashMap.get(b.a(taskId, b));
                        if (aVar3 != null) {
                            bTSubTaskInfo2 = (BTSubTaskItem) aVar3.a(BTSubTaskItem.class);
                        }
                        if (bTSubTaskInfo2 != null) {
                            bTSubTaskInfo = bTSubTaskInfo2;
                        } else if (b <= 0 || taskId <= 0) {
                            bTSubTaskInfo = new BTSubTaskItem();
                        } else {
                            String a2 = b.a(taskId, b);
                            bTSubTaskInfo = (BTSubTaskItem) bVar.i.get(a2);
                            if (bTSubTaskInfo == null) {
                                bTSubTaskInfo = new BTSubTaskItem();
                                bVar.i.put(a2, bTSubTaskInfo);
                            }
                        }
                        bVar.a.a(cursor, bTSubTaskInfo);
                        bTSubTaskInfo.mParentTaskId = taskId;
                        if (aVar3 == null) {
                            hashMap2 = hashMap;
                            a aVar4 = new a(0, downloadTaskInfo, bTSubTaskInfo, bTSubTaskInfo.mTaskId);
                        } else {
                            hashMap2 = hashMap;
                            aVar3.c = bTSubTaskInfo;
                            aVar2 = aVar3;
                        }
                        BTSubTaskItem bTSubTaskItem2 = (BTSubTaskItem) aVar2.a(BTSubTaskItem.class);
                        collection.add(bTSubTaskItem2);
                        if (z) {
                            bTSubTaskItem2.setSelected(b.a(bTSubTaskItem2.mTaskId, a));
                        }
                        bVar.l.add(aVar2);
                        hashMap = hashMap2;
                    }
                    if (!collection.isEmpty()) {
                        try {
                            tVar.execute(new c(bVar, new ArrayList(collection)));
                        } catch (RejectedExecutionException e) {
                            e.printStackTrace();
                        }
                    }
                }
                TaskDetailFragment taskDetailFragment3 = taskDetailFragment2;
                taskDetailFragment3.c.a(taskDetailFragment3.b.l);
                taskDetailFragment3.a(true, true);
                if (!taskDetailFragment3.l) {
                    taskDetailFragment3.l = true;
                    com.xunlei.downloadprovider.download.report.a.e("file_list", "bt");
                }
            }
        }
    }

    public final Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        try {
            return c.a(this.a.getActivity(), this.a.d.getTaskId());
        } catch (int i2) {
            i2.printStackTrace();
            return 0;
        }
    }

    public final void onLoaderReset(Loader<Cursor> loader) {
        if (loader != null) {
            try {
                loader.stopLoading();
            } catch (Loader<Cursor> loader2) {
                loader2.printStackTrace();
            }
        }
    }
}
