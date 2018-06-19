package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.xunlei.downloadprovider.homepage.recommend.a.v;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DetailVideoInfo */
public final class b {
    public String a;
    public String b;
    public String c;
    public List<v> d;
    public BaseVideoInfo e = new BaseVideoInfo();
    public VideoUserInfo f = new VideoUserInfo();

    public final BaseVideoInfo a() {
        if (this.e == null) {
            synchronized (this) {
                if (this.e == null) {
                    this.e = new BaseVideoInfo();
                }
            }
        }
        return this.e;
    }

    public final VideoUserInfo b() {
        if (this.f == null) {
            synchronized (this) {
                if (this.f == null) {
                    this.f = new VideoUserInfo();
                }
            }
        }
        return this.f;
    }

    public final void a(List<v> list) {
        this.d = list;
        if (this.d != null && this.e.hasLike() == null) {
            long c = LoginHelper.a().g.c();
            for (v vVar : this.d) {
                if (vVar.a == c) {
                    this.e.setHasLike(true);
                }
            }
        }
    }

    public static b a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            if (jSONObject.length() > 0) {
                b bVar = new b();
                bVar.e = BaseVideoInfo.createFromJson(jSONObject.getJSONObject(BaseVideoInfo.JSON_KEY));
                bVar.f = VideoUserInfo.parseFrom(jSONObject.optJSONObject(VideoUserInfo.JSON_KEY));
                return bVar;
            }
        }
        return null;
    }
}
