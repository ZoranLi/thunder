package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.n.a;

class au implements a {
    final /* synthetic */ TbsLogReport a;

    au(TbsLogReport tbsLogReport) {
        this.a = tbsLogReport;
    }

    public void a(int i) {
        String str = TbsDownloader.LOGTAG;
        StringBuilder stringBuilder = new StringBuilder("[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:");
        stringBuilder.append(i);
        TbsLog.i(str, stringBuilder.toString());
        if (i < 300) {
            this.a.h();
        }
    }
}
