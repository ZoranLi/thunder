package com.xunlei.downloadprovider.personal.message.chat.chatengine.c;

import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a.a;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.ChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.SingleChatDialog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: ChatMessageNetwork */
final class q implements c<JSONObject> {
    final /* synthetic */ p a;

    q(p pVar) {
        this.a = pVar;
    }

    public final /* synthetic */ void a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        SingleChatDialog singleChatDialog = (SingleChatDialog) this.a.a;
        a aVar = new a();
        if (o.a.a(aVar, jSONObject)) {
            obj = jSONObject.optJSONArray("records");
            if (obj != null) {
                List arrayList = new ArrayList();
                for (int i = 0; i < obj.length(); i++) {
                    ChatMessage a = o.a.a(true, singleChatDialog.targetUser(), singleChatDialog, obj.optJSONObject(i));
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                aVar.a = arrayList;
            } else {
                aVar.b = -1001;
                aVar.c = "messagesArray is null";
            }
        }
        obj = new StringBuilder("querySingleChatMessages.onResponse wrapper.errorCode: ");
        obj.append(aVar.b);
        obj.append(" errorMsg: ");
        obj.append(aVar.c);
        if (o.a.a(aVar) != null) {
            this.a.c.a(aVar.a);
        } else {
            this.a.c.a(b.a(aVar.b, aVar.c));
        }
    }

    public final void a(b bVar) {
        this.a.c.a(bVar);
    }
}
