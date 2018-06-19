package com.xunlei.downloadprovider.download.util;

import android.text.TextUtils;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.task.h;
import com.xunlei.xllib.b.d;
import java.io.File;
import java.util.List;

/* compiled from: TaskPlayableHelper */
public final class m {
    public static long a(long j) {
        if (j <= -1) {
            return -1;
        }
        List a = h.e().a();
        if (d.a(a)) {
            return -1;
        }
        int i = -1;
        for (int i2 = 0; i2 < a.size(); i2++) {
            e eVar = (e) a.get(i2);
            if (!(eVar == null || eVar.b() == null || j != eVar.b().getTaskId())) {
                i = i2;
            }
        }
        if (i == -1) {
            return -1;
        }
        while (true) {
            int i3 = 1;
            if (i >= a.size() - 1) {
                j = (e) a.get(0);
                i = -1;
            } else {
                j = (e) a.get(i + 1);
            }
            if (j == null || j.b() == null) {
                j = null;
            } else {
                j = j.b();
                if (TextUtils.isEmpty(j.mLocalFileName)) {
                    i++;
                } else if (new File(j.mLocalFileName).exists()) {
                    boolean e = k.e(j);
                    if (!(e && a((TaskInfo) j))) {
                        if (!e && k.c(j)) {
                        }
                        if (i3 != 0) {
                            break;
                        }
                        i++;
                    }
                    i3 = 0;
                    if (i3 != 0) {
                        break;
                    }
                    i++;
                } else {
                    i++;
                }
            }
        }
        j = null;
        if (j == null) {
            return -1;
        }
        return j.getTaskId();
    }

    private static boolean a(TaskInfo taskInfo) {
        if (taskInfo != null) {
            if (taskInfo.getTaskId() > -1) {
                taskInfo = h.e().a(taskInfo.getTaskId());
                if (taskInfo == null) {
                    return false;
                }
                TaskInfo<BTSubTaskInfo> g = taskInfo.g();
                if (!d.a(g)) {
                    for (BTSubTaskInfo c : g) {
                        if (k.c(c)) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return false;
    }
}
