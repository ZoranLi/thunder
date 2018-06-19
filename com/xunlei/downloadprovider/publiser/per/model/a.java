package com.xunlei.downloadprovider.publiser.per.model;

import com.xunlei.downloadprovider.comment.entity.BaseCommentInfo;
import com.xunlei.downloadprovider.homepage.cinecism.data.CinecismInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CommentCinecismInfo */
public final class a extends b {
    public CinecismInfo a;
    public int b;

    public static a a(JSONObject jSONObject) throws JSONException {
        a aVar = new a();
        JSONObject optJSONObject = jSONObject.optJSONObject("cinecism_info");
        if (optJSONObject != null) {
            if (optJSONObject.length() != 0) {
                aVar.a = CinecismInfo.a(optJSONObject);
                if (aVar.a == null) {
                    return null;
                }
                aVar.baseCommentInfo = BaseCommentInfo.parseFrom(jSONObject.getJSONObject("comment_info"));
                if (!(aVar.baseCommentInfo == null || aVar.a == null)) {
                    aVar.baseCommentInfo.setGcid(aVar.a.a);
                }
                aVar.b = jSONObject.optInt("resource_status");
                return aVar;
            }
        }
        aVar.a = null;
        if (aVar.a == null) {
            return null;
        }
        aVar.baseCommentInfo = BaseCommentInfo.parseFrom(jSONObject.getJSONObject("comment_info"));
        aVar.baseCommentInfo.setGcid(aVar.a.a);
        aVar.b = jSONObject.optInt("resource_status");
        return aVar;
    }
}
