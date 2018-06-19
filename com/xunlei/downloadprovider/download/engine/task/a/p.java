package com.xunlei.downloadprovider.download.engine.task.a;

import android.os.Handler;
import android.os.Message;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: EngineMonitorImpl */
public final class p {
    public c a;
    public List<Handler> b;
    public List<v> c;
    public long d = 0;
    public long e = -1;

    public p(c cVar) {
        this.a = cVar;
        this.b = new ArrayList();
    }

    public final int a() {
        c cVar = this.a;
        int i = 0;
        if (!cVar.s.isEmpty()) {
            Iterator it = cVar.s.iterator();
            while (it.hasNext()) {
                TaskInfo taskInfo = (TaskInfo) it.next();
                if (taskInfo.isUnseen() && taskInfo.getCustomFlags() != 300) {
                    i++;
                }
            }
        }
        return i;
    }

    public final void b() {
        this.d++;
    }

    public final void c() {
        if (this.c != null) {
            for (int i = 0; i < this.c.size(); i++) {
                ((v) this.c.get(i)).e();
            }
        }
    }

    public final void a(Message message, TaskInfo taskInfo) {
        if (this.b != null) {
            for (Handler obtainMessage : this.b) {
                obtainMessage.obtainMessage(message.what, message.arg1, message.arg2, taskInfo).sendToTarget();
            }
        }
        c();
    }
}
