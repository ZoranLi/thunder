package com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.a;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ChatRelationTable */
public final class n extends a {
    protected static boolean a(int i) {
        return i == 1;
    }

    protected final String c() {
        return "chat_relation";
    }

    public n(o oVar) {
        super(oVar);
    }

    protected final List<q> d() {
        List<q> arrayList = new ArrayList();
        q qVar = new q("member1", "INTEGER");
        qVar.c = true;
        qVar.d = false;
        q qVar2 = new q("member2", "INTEGER");
        qVar2.d = false;
        q qVar3 = new q("dialog_id", "INTEGER");
        qVar3.c = true;
        qVar3.d = false;
        q qVar4 = new q("is_blocking", "SMALLINT");
        qVar4.d = true;
        q qVar5 = new q("is_follow", "SMALLINT");
        qVar5.d = true;
        q qVar6 = new q("send_before", "SMALLINT");
        qVar6.d = true;
        arrayList.add(qVar);
        arrayList.add(qVar2);
        arrayList.add(qVar3);
        arrayList.add(qVar4);
        arrayList.add(qVar5);
        arrayList.add(qVar6);
        return arrayList;
    }

    public final boolean a(IChatDialog iChatDialog) {
        if (o.b()) {
            return a((JSONObject) b(iChatDialog));
        }
        return null;
    }

    public final boolean a(List<IChatDialog> list) {
        if (!o.b()) {
            return null;
        }
        if (o.b()) {
            JSONArray jSONArray = new JSONArray();
            for (IChatDialog b : list) {
                JSONObject b2 = b(b);
                if (b2 != null) {
                    jSONArray.put(b2);
                }
            }
            list = jSONArray;
        } else {
            list = null;
        }
        return a((JSONArray) list);
    }

    private static JSONObject b(IChatDialog iChatDialog) {
        if (!o.b() || iChatDialog == null || !a.a().b) {
            return null;
        }
        IChatUser targetUser = iChatDialog.targetUser();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("member1", a.a().a.userId());
            jSONObject.put("member2", targetUser.userId());
            jSONObject.put("dialog_id", iChatDialog.dialogId());
            jSONObject.put("is_blocking", iChatDialog.isBlocking());
            jSONObject.put("is_follow", iChatDialog.isFollow());
            jSONObject.put("send_before", iChatDialog.sendBefore());
            return jSONObject;
        } catch (IChatDialog iChatDialog2) {
            iChatDialog2.printStackTrace();
            return null;
        }
    }
}
