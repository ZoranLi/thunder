package com.xunlei.downloadprovider.download.taskdetails.b;

import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.download.report.a;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: TaskCommentReporter */
public final class x {
    public List<CommentInfo> a = new ArrayList();
    public Set<CommentInfo> b = new HashSet();
    DownloadTaskInfo c = null;

    public final void a() {
        b();
        this.a.clear();
        this.b.clear();
        this.c = null;
    }

    public final void b() {
        if (!this.a.isEmpty()) {
            List arrayList = new ArrayList(this.a);
            String str = "";
            if (this.c != null) {
                str = this.c.getResourceGcid();
            }
            a.a(str, arrayList);
            this.a.clear();
        }
    }
}
