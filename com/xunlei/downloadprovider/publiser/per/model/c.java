package com.xunlei.downloadprovider.publiser.per.model;

import com.xunlei.downloadprovider.comment.entity.BaseCommentInfo;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CommentWebsiteInfo */
public final class c extends b {
    public WebsiteInfo a;
    public int b;

    public static c a(JSONObject jSONObject) throws JSONException {
        c cVar = new c();
        JSONObject optJSONObject = jSONObject.optJSONObject("site_info");
        if (optJSONObject != null) {
            if (optJSONObject.length() != 0) {
                cVar.a = WebsiteInfo.a(optJSONObject);
                cVar.baseCommentInfo = BaseCommentInfo.parseFrom(jSONObject.getJSONObject("comment_info"));
                if (!(cVar.baseCommentInfo == null || cVar.a == null)) {
                    cVar.baseCommentInfo.setGcid(cVar.a.a);
                }
                cVar.b = jSONObject.optInt("resource_status");
                return cVar;
            }
        }
        cVar.a = null;
        cVar.baseCommentInfo = BaseCommentInfo.parseFrom(jSONObject.getJSONObject("comment_info"));
        cVar.baseCommentInfo.setGcid(cVar.a.a);
        cVar.b = jSONObject.optInt("resource_status");
        return cVar;
    }
}
