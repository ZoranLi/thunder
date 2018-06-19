package com.xunlei.downloadprovider.download.taskdetails.subtask;

import com.xunlei.downloadprovider.download.engine.task.a.t.a;
import java.util.ArrayList;

/* compiled from: BTSubTaskListLoader */
final class f extends a<ArrayList<BTSubTaskItem>> {
    final /* synthetic */ b a;

    f(b bVar, ArrayList arrayList) {
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
