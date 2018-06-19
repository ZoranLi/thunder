package com.xunlei.downloadprovider.download.privatespace;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.xunlei.common.accelerator.utils.LogcatUtil;

/* compiled from: PrivateSpaceHelper */
final class ae implements a {
    final /* synthetic */ v$a a;

    ae(v$a com_xunlei_downloadprovider_download_privatespace_v_a) {
        this.a = com_xunlei_downloadprovider_download_privatespace_v_a;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        LogcatUtil.i("PrivateSpaceHelper", volleyError.getMessage(), null);
        this.a.a(-1, "当前网络异常，请检查网络");
    }
}
