package com.tencent.smtt.sdk;

import anet.channel.util.ErrorConstant;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.n.a;

final class ah implements a {
    final /* synthetic */ boolean a;
    final /* synthetic */ TbsDownloadConfig b;

    ah(boolean z, TbsDownloadConfig tbsDownloadConfig) {
        this.a = z;
        this.b = tbsDownloadConfig;
    }

    public final void a(int i) {
        String str = TbsDownloader.LOGTAG;
        StringBuilder stringBuilder = new StringBuilder("[TbsDownloader.sendRequest] httpResponseCode=");
        stringBuilder.append(i);
        TbsLog.i(str, stringBuilder.toString());
        if (i >= 300) {
            if (this.a) {
                this.b.setDownloadInterruptCode(ErrorConstant.ERROR_DEPULICATE_ACCS_SESSION);
                return;
            }
            this.b.setDownloadInterruptCode(-207);
        }
    }
}
