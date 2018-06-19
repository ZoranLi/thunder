package com.xunlei.downloadprovider.cardslide.c;

import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import org.json.JSONObject;

/* compiled from: CardSlideModel */
public final class a {
    public VideoUserInfo a = new VideoUserInfo();
    public BaseVideoInfo b = new BaseVideoInfo();
    public String c;

    public static a a(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("res_id");
                JSONObject optJSONObject = jSONObject.optJSONObject("res_info");
                jSONObject = jSONObject.optJSONObject(VideoUserInfo.JSON_KEY);
                aVar.c = optString;
                if (optJSONObject != null) {
                    BaseVideoInfo.parseFrom(aVar.b, optJSONObject);
                }
                if (jSONObject != null) {
                    VideoUserInfo.parseFrom(aVar.a, jSONObject);
                }
            } catch (JSONObject jSONObject2) {
                jSONObject2.printStackTrace();
            }
        }
        return aVar;
    }
}
