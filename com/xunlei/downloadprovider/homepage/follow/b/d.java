package com.xunlei.downloadprovider.homepage.follow.b;

import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FollowingVideoFeed */
public final class d {
    public String a;
    public BaseVideoInfo b = new BaseVideoInfo();
    public VideoUserInfo c = new VideoUserInfo();
    public String d;
    public String e;

    public final long a() {
        return this.c == null ? 0 : Long.parseLong(this.c.getUid());
    }

    public final String b() {
        return this.c == null ? "per" : this.c.getKind();
    }

    public static d a(JSONObject jSONObject) throws JSONException {
        d dVar = new d();
        dVar.a = jSONObject.optString("row_key");
        JSONObject optJSONObject = jSONObject.optJSONObject(BaseVideoInfo.JSON_KEY);
        if (optJSONObject == null || optJSONObject.length() <= 0) {
            throw new JSONException("FollowingVideoFeed json has no video_info");
        }
        BaseVideoInfo.parseFrom(dVar.b, optJSONObject);
        dVar.d = optJSONObject.toString();
        jSONObject = jSONObject.optJSONObject(VideoUserInfo.JSON_KEY);
        if (jSONObject == null || jSONObject.length() <= 0) {
            throw new JSONException("FollowingVideoFeed json has no user_info");
        }
        dVar.c = VideoUserInfo.parseFrom(jSONObject);
        dVar.e = jSONObject.toString();
        return dVar;
    }
}
