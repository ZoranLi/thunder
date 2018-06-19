package com.xunlei.downloadprovider.personal.message.chat.personalchat.chatkit.message.info;

import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import org.json.JSONObject;

/* compiled from: ChatWebsiteCommentReplyInfo */
public final class d extends a<WebsiteInfo> {
    public static d a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a dVar = new d();
        a.a(dVar, jSONObject);
        jSONObject = jSONObject.optJSONObject("resource");
        if (jSONObject == null) {
            return null;
        }
        try {
            dVar.e = WebsiteInfo.a(jSONObject);
            return dVar;
        } catch (JSONObject jSONObject2) {
            jSONObject2.printStackTrace();
            return null;
        }
    }
}
