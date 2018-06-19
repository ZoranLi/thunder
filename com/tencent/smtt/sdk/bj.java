package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;

final class bj extends Thread {
    bj() {
    }

    public final void run() {
        if (WebView.j == null) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
            return;
        }
        l a = l.a(true);
        if (l.a) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
            return;
        }
        af a2 = af.a(WebView.j);
        int c = a2.c();
        StringBuilder stringBuilder = new StringBuilder("WebView.updateNeeeRebootStatus--installStatus = ");
        stringBuilder.append(c);
        TbsLog.d("TbsNeedReboot", stringBuilder.toString());
        if (c == 2) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
            a.a(String.valueOf(a2.b()));
            a.b(true);
            return;
        }
        int b = a2.b("copy_status");
        StringBuilder stringBuilder2 = new StringBuilder("WebView.updateNeeeRebootStatus--copyStatus = ");
        stringBuilder2.append(b);
        TbsLog.d("TbsNeedReboot", stringBuilder2.toString());
        if (b == 1) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
            a.a(String.valueOf(a2.c("copy_core_ver")));
            a.b(true);
            return;
        }
        if (!bk.b().c() && (c == 3 || b == 3)) {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
            a.a(String.valueOf(l.d()));
            a.b(true);
        }
    }
}
