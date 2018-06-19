package com.xunlei.downloadprovider.cardslide.likelist.c;

import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import org.json.JSONObject;

/* compiled from: CardLikeModel */
public final class b extends a {
    public VideoUserInfo b = new VideoUserInfo();
    public BaseVideoInfo c = new BaseVideoInfo();
    private String d;
    private int e = 1;

    private b() {
    }

    public static b a(JSONObject jSONObject) {
        b bVar = new b();
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString("res_id");
                JSONObject optJSONObject = jSONObject.optJSONObject("res_info");
                jSONObject = jSONObject.optJSONObject(VideoUserInfo.JSON_KEY);
                bVar.d = optString;
                if (optJSONObject != null) {
                    BaseVideoInfo.parseFrom(bVar.c, optJSONObject);
                }
                if (jSONObject != null) {
                    VideoUserInfo.parseFrom(bVar.b, jSONObject);
                }
            } catch (JSONObject jSONObject2) {
                jSONObject2.printStackTrace();
            }
        }
        return bVar;
    }
}
