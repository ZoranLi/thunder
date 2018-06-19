package com.xunlei.downloadprovider.publiser.campaign.a;

import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoFollowInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TopicVideo */
public final class n extends a {
    public BaseVideoInfo b;
    public VideoUserInfo c;
    private VideoFollowInfo d;

    public static n a(JSONObject jSONObject) {
        n nVar = new n();
        JSONObject optJSONObject = jSONObject.optJSONObject(BaseVideoInfo.JSON_KEY);
        if (optJSONObject != null) {
            try {
                nVar.b = BaseVideoInfo.createFromJson(optJSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        try {
            nVar.c = VideoUserInfo.parseFrom(new VideoUserInfo(), jSONObject.optJSONObject(VideoUserInfo.JSON_KEY));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        jSONObject = jSONObject.optJSONObject("follow_info");
        if (jSONObject != null) {
            nVar.d = VideoFollowInfo.a(jSONObject);
        }
        return nVar;
    }
}
