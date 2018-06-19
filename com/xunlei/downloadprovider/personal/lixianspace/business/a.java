package com.xunlei.downloadprovider.personal.lixianspace.business;

import android.text.TextUtils;
import com.xunlei.downloadprovider.personal.lixianspace.b.b;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;
import com.xunlei.xllib.b.d;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: LXSpaceTaskQueryMgr */
final class a extends b {
    final /* synthetic */ LXSpaceTaskQueryMgr a;

    a(LXSpaceTaskQueryMgr lXSpaceTaskQueryMgr) {
        this.a = lXSpaceTaskQueryMgr;
    }

    public final void a(String str, int i, LXTaskInfo lXTaskInfo) {
        if (i == 0 && lXTaskInfo != null) {
            LXSpaceTaskQueryMgr.a(this.a, str, lXTaskInfo);
            this.a.b.put(Long.valueOf(lXTaskInfo.a), str);
        }
    }

    public final void a(List<LXTaskInfo> list, int i) {
        if (i == 0 && d.a(list) == 0) {
            for (LXTaskInfo lXTaskInfo : list) {
                if (lXTaskInfo != null) {
                    String str = lXTaskInfo.b;
                    if (TextUtils.isEmpty(str)) {
                        str = (String) this.a.b.get(Long.valueOf(lXTaskInfo.a));
                    }
                    LXSpaceTaskQueryMgr.a(this.a, str, lXTaskInfo);
                }
            }
        }
    }

    public final void a(long j, int i) {
        if (i == 0) {
            i = this.a;
            for (Entry entry : i.a.entrySet()) {
                if (((LXTaskInfo) entry.getValue()).a == j) {
                    i.a.remove(entry.getKey());
                    break;
                }
            }
            i.b.remove(Long.valueOf(j));
        }
    }
}
