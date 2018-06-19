package com.xunlei.downloadprovider.pushmessage.localpush;

import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.pushmessage.c.c;
import com.xunlei.downloadprovider.pushmessage.report.l;

/* compiled from: LocalPushReporter */
final class e {
    static void a(int i, String str) {
        l.b(i, str, "", "", "", "");
        if (c.a(BrothersApplication.getApplicationInstance())) {
            l.a(i, str, "", "", "", "");
        }
    }
}
