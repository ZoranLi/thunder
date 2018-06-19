package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import org.json.JSONObject;

/* compiled from: RecommendWebsiteInfo */
public final class f {
    public String a;
    public WebsiteInfo b;
    public VideoUserInfo c;

    public static f a(JSONObject jSONObject) {
        f fVar = new f();
        try {
            fVar.c = VideoUserInfo.parseFrom(jSONObject.optJSONObject(VideoUserInfo.JSON_KEY));
            fVar.b = WebsiteInfo.a(jSONObject.optJSONObject("site_info"));
        } catch (JSONObject jSONObject2) {
            jSONObject2.printStackTrace();
        }
        return fVar;
    }
}
