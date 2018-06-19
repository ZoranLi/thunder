package com.xunlei.downloadprovider.download.tasklist.list.banner.d;

import java.util.Map;
import java.util.Map.Entry;

/* compiled from: DownloadLimitPrivilegeHelper */
final class e implements Runnable {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        Map all = d.a(this.a).getAll();
        if (all != null && !all.isEmpty()) {
            for (Entry entry : all.entrySet()) {
                if (((String) entry.getKey()).startsWith("setting_") && (entry.getValue() instanceof Boolean)) {
                    d.b(this.a).add(entry.getKey());
                }
            }
        }
    }
}
