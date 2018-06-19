package com.xunlei.downloadprovidershare;

import android.text.TextUtils;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.common.net.volley.VolleyRequestManager;

/* compiled from: ShareThunderCommandHelper */
final class v implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ q$a b;

    v(String str, q$a com_xunlei_downloadprovidershare_q_a) {
        this.a = str;
        this.b = com_xunlei_downloadprovidershare_q_a;
    }

    public final void run() {
        Object substring;
        String str = this.a;
        if (q.a(str)) {
            substring = str.substring(str.indexOf("【迅雷口令#X") + 7, str.indexOf("#】"));
        } else {
            substring = null;
        }
        if (TextUtils.isEmpty(substring)) {
            this.b.a(null);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/dlj/");
        stringBuilder.append(substring);
        stringBuilder.append("/url");
        VolleyRequestManager.getMainThreadRequestQueue().a(new SigJsonObjectRequest(stringBuilder.toString(), new w(this), new x(this)));
    }
}
