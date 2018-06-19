package com.xunlei.downloadprovider.download.taskdetails;

import com.xunlei.downloadprovider.download.engine.task.a.t.a;
import com.xunlei.downloadprovider.download.taskdetails.subtask.BTSubTaskItem;
import java.util.ArrayList;

/* compiled from: BtTaskDetailDataSource */
final class c extends a<ArrayList<BTSubTaskItem>> {
    final /* synthetic */ b a;

    c(b bVar, ArrayList arrayList) {
        this.a = bVar;
        super(arrayList);
    }

    public final /* synthetic */ void a(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        if (arrayList != null && !arrayList.isEmpty()) {
            obj = arrayList.iterator();
            while (obj.hasNext()) {
                BTSubTaskItem bTSubTaskItem = (BTSubTaskItem) obj.next();
                bTSubTaskItem.checkFileMissing();
                bTSubTaskItem.checkFileCategory();
            }
        }
    }
}
