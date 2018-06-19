package com.xunlei.downloadprovidershare;

import com.xunlei.common.concurrent.XLThreadPool;
import org.json.JSONObject;

/* compiled from: ShareWechatReportHelper */
public final class z {

    /* compiled from: ShareWechatReportHelper */
    public interface a {
        void a(String str);
    }

    public static void a(JSONObject jSONObject, a aVar) {
        XLThreadPool.execute(new aa(jSONObject, aVar));
    }
}
