package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.n.a;

class at implements a {
    final /* synthetic */ TbsLogReport a;

    at(TbsLogReport tbsLogReport) {
        this.a = tbsLogReport;
    }

    public void a(int i) {
        String str = TbsDownloader.LOGTAG;
        StringBuilder stringBuilder = new StringBuilder("[TbsApkDownloadStat.reportTbsLog] httpResponseCode=");
        stringBuilder.append(i);
        TbsLog.i(str, stringBuilder.toString());
    }
}
