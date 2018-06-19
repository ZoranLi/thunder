package com.xunlei.downloadprovider.homepage.choiceness.a.a;

import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChoicenessWebsiteInfo */
public final class n extends e {
    public WebsiteInfo a;
    public VideoUserInfo b;

    public static n a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        e nVar = new n();
        a(nVar, jSONObject);
        nVar.a = WebsiteInfo.a(jSONObject.getJSONObject("res_info"));
        VideoUserInfo videoUserInfo = new VideoUserInfo();
        jSONObject = jSONObject.optJSONObject(VideoUserInfo.JSON_KEY);
        if (jSONObject != null) {
            VideoUserInfo.parseFrom(videoUserInfo, jSONObject);
        }
        nVar.b = videoUserInfo;
        return nVar;
    }
}
