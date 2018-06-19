package com.xunlei.downloadprovider.personal.message.chat.chatengine.c;

import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a.a;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.f;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.ChatMessage;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* compiled from: ChatDialogNetwork */
final class h implements c<JSONObject> {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        ChatMessage chatMessage = this.a.d;
        a aVar = new a();
        if (d.a.a(aVar, jSONObject)) {
            obj = jSONObject.optJSONObject("record");
            if (obj == null) {
                aVar.b = -1001;
                aVar.c = "message JSONObject is null";
            } else {
                chatMessage.setMessageId((long) obj.optInt(AgooConstants.MESSAGE_ID));
                chatMessage.setCreateAt(obj.optInt("created_at", f.a()));
                aVar.a = chatMessage;
            }
        }
        if (d.a.a(aVar) != null) {
            this.a.b.a(aVar.a);
        } else {
            this.a.b.a(b.a(aVar.b, aVar.c));
        }
    }

    public final void a(b bVar) {
        this.a.b.a(bVar);
    }
}
