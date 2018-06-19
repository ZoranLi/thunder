package com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a;

import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ChatUserTable */
public final class p extends a {
    protected final String c() {
        return "chat_user";
    }

    public p(o oVar) {
        super(oVar);
    }

    protected final List<q> d() {
        List<q> arrayList = new ArrayList();
        q qVar = new q(SocializeConstants.TENCENT_UID, "INTEGER");
        qVar.c = true;
        qVar.d = false;
        q qVar2 = new q("nickname", "TEXT");
        qVar2.d = false;
        q qVar3 = new q("gender", "TEXT");
        qVar3.d = true;
        q qVar4 = new q("avatar_url", "TEXT");
        qVar4.d = true;
        q qVar5 = new q("kind", "TEXT");
        qVar5.d = true;
        q qVar6 = new q("raw_version", "INTEGER");
        qVar6.d = true;
        q qVar7 = new q(ShareConstants.DEXMODE_RAW, "TEXT");
        qVar7.d = false;
        arrayList.add(qVar);
        arrayList.add(qVar2);
        arrayList.add(qVar3);
        arrayList.add(qVar4);
        arrayList.add(qVar5);
        arrayList.add(qVar6);
        arrayList.add(qVar7);
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
        if (!o.b() || iChatDialog == null) {
            return null;
        }
        iChatDialog = iChatDialog.targetUser();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SocializeConstants.TENCENT_UID, iChatDialog.userId());
            jSONObject.put("nickname", iChatDialog.nickname());
            jSONObject.put("gender", iChatDialog.gender());
            jSONObject.put("avatar_url", iChatDialog.avatarUrl());
            jSONObject.put("kind", iChatDialog.kind());
            jSONObject.put("raw_version", iChatDialog.rawVersion());
            jSONObject.put(ShareConstants.DEXMODE_RAW, iChatDialog.raw());
            return jSONObject;
        } catch (IChatDialog iChatDialog2) {
            iChatDialog2.printStackTrace();
            return null;
        }
    }
}
