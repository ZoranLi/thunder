package com.xunlei.downloadprovidershare;

import android.text.TextUtils;
import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: ShareThunderCommandHelper */
final class t implements b<JSONObject> {
    final /* synthetic */ s a;

    t(s sVar) {
        this.a = sVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        obj = ((JSONObject) obj).optString("bird_key");
        if (TextUtils.isEmpty(obj)) {
            if (this.a.b != null) {
                this.a.b.a(null);
            }
            return;
        }
        if (this.a.b != null) {
            q$a com_xunlei_downloadprovidershare_q_a = this.a.b;
            StringBuilder stringBuilder = new StringBuilder("【迅雷口令#X");
            stringBuilder.append(obj);
            stringBuilder.append("#】复制这条消息，打开最新版Android迅雷，接下来就是见证奇迹的时刻！");
            com_xunlei_downloadprovidershare_q_a.a(stringBuilder.toString());
        }
    }
}
