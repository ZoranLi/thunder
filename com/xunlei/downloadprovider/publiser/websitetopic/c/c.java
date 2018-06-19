package com.xunlei.downloadprovider.publiser.websitetopic.c;

import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import org.json.JSONObject;

/* compiled from: WebsiteTopicItemModel */
public final class c extends a {
    public WebsiteInfo b;
    public VideoUserInfo c;

    public c(int i) {
        super(i);
    }

    public static c a(JSONObject jSONObject) {
        c cVar = new c(1);
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("res_info");
            jSONObject = jSONObject.optJSONObject(VideoUserInfo.JSON_KEY);
            try {
                cVar.b = WebsiteInfo.a(optJSONObject);
                cVar.c = VideoUserInfo.parseFrom(jSONObject);
            } catch (JSONObject jSONObject2) {
                jSONObject2.printStackTrace();
            }
        }
        return cVar;
    }
}
