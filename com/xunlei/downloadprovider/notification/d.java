package com.xunlei.downloadprovider.notification;

import android.os.Handler;
import android.os.Message;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import java.util.List;

/* compiled from: DownloadNotification */
final class d extends Handler {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final void handleMessage(Message message) {
        TaskInfo taskInfo = null;
        try {
            switch (message.what) {
                case 100:
                    if (message.obj instanceof TaskInfo) {
                        taskInfo = (TaskInfo) message.obj;
                    }
                    c.a(this.a, taskInfo);
                    return;
                case 101:
                    if (message.obj instanceof TaskInfo) {
                        message = message.obj;
                    }
                    c.a(this.a);
                    return;
                case 108:
                    if (message.obj instanceof TaskInfo) {
                        c.a(this.a, (TaskInfo) message.obj, message.arg1, message.getData());
                        return;
                    }
                    break;
                case 10000:
                    c.a(this.a, message.obj);
                    return;
                case 10001:
                    c.a(this.a, (List) message.obj);
                    break;
                default:
                    break;
            }
        } catch (Message message2) {
            message2.printStackTrace();
        }
    }
}
