package com.xunlei.downloadprovider.homepage.recommend.feed;

import com.xunlei.downloadprovider.ad.feedvideo.a;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoFollowInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import org.json.JSONObject;

/* compiled from: FeedVideoItemInfo */
public final class y {
    public BaseVideoInfo a = new BaseVideoInfo();
    VideoUserInfo b = new VideoUserInfo();
    VideoFollowInfo c = new VideoFollowInfo();
    public String d;
    public String e;
    public boolean f;
    private String g;

    public final void a() {
        this.a.setHasLike(true);
    }

    public final void a(int i) {
        this.a.setLikeCount(i);
    }

    public static y a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            y yVar = new y();
            yVar.g = jSONObject.getString("type");
            yVar.e = jSONObject.optString("ssp_ads_info");
            if ("ads".equals(yVar.g)) {
                StringBuilder stringBuilder = new StringBuilder("ad_");
                stringBuilder.append(System.currentTimeMillis());
                yVar.a.setVideoId(stringBuilder.toString());
                String videoId = yVar.a.getVideoId();
                a.b();
                if (!a.d(videoId)) {
                    a.b().a();
                    a.b().b(videoId);
                }
            }
            BaseVideoInfo.parseFrom(yVar.a, jSONObject.optJSONObject(BaseVideoInfo.JSON_KEY));
            VideoUserInfo.parseFrom(yVar.b, jSONObject.optJSONObject(VideoUserInfo.JSON_KEY));
            VideoFollowInfo.a(yVar.c, jSONObject.optJSONObject("follow_info"));
            yVar.d = jSONObject.optString("ext_data");
            return yVar;
        } catch (JSONObject jSONObject2) {
            jSONObject2.printStackTrace();
            return null;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.getVideoId());
        stringBuilder.append("|");
        stringBuilder.append(this.a.getTitle());
        return stringBuilder.toString();
    }

    public final int b() {
        return this.b.getPubExtra().a;
    }

    public final void a(boolean z) {
        this.c.a = z;
    }

    public final boolean c() {
        return "ads".equals(this.g);
    }
}
