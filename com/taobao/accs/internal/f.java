package com.taobao.accs.internal;

import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
class f implements Runnable {
    final /* synthetic */ b a;

    f(b bVar) {
        this.a = bVar;
    }

    public void run() {
        ALog.w("ElectionServiceImpl", "time out, onReportComplete", new Object[]{IXAdCommonUtils.PKGS_PREF_DOWNLOAD_KEY, this.a.e});
        this.a.e();
    }
}
