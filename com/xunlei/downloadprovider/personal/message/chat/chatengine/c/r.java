package com.xunlei.downloadprovider.personal.message.chat.chatengine.c;

import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.q;
import org.json.JSONObject;

/* compiled from: ChatUserNetwork */
public final class r extends a {
    private static r a;

    private r() {
    }

    public static r a() {
        if (a == null) {
            a = new r();
        }
        return a;
    }

    public final void a(long j, int i, c<Boolean> cVar) {
        q.a().execute(new s(this, j, i, cVar));
    }

    private static JSONObject b(long j, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SocializeConstants.TENCENT_UID, j);
            jSONObject.put("type", i);
        } catch (long j2) {
            j2.printStackTrace();
        }
        return jSONObject;
    }
}
