package com.xunlei.downloadprovider.ad.c.d;

import com.xunlei.downloadprovider.member.login.c.h;
import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import org.json.JSONObject;

/* compiled from: ReportNotDownloadTask */
final class j implements c<JSONObject> {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optInt("is_send", 0) == 1) {
            h.a().a(3);
        } else if (jSONObject.optInt("reject_reason", 0) == 2) {
            h.a().a(2);
        } else {
            h.a().a(4);
        }
    }

    public final void a(b bVar) {
        h.a().a(2);
    }
}
