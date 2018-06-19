package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import org.json.JSONObject;

/* compiled from: BaseChatCommentReplyInfo */
public abstract class a<RES> {
    public String a = null;
    public String b = null;
    public String c = null;
    public String d = null;
    public RES e = null;
    public IChatUser f = null;
    private long g = 0;

    public static void a(a aVar, JSONObject jSONObject) {
        if (jSONObject != null) {
            aVar.c = jSONObject.optString("gcid");
            aVar.g = jSONObject.optLong("cid");
            aVar.d = jSONObject.optString(MessageInfo.RESOURCE_ID);
            aVar.a = jSONObject.optString(MessageInfo.ORIGINAL);
            aVar.b = jSONObject.optString(MessageInfo.REPLY);
        }
    }
}
