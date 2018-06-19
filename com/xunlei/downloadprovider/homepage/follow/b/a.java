package com.xunlei.downloadprovider.homepage.follow.b;

import android.text.TextUtils;
import com.xunlei.downloadprovider.publiser.visitors.model.Gender;
import com.xunlei.downloadprovider.search.ui.a.c;
import com.xunlei.downloadprovider.shortvideo.entity.LiveExtra;
import com.xunlei.downloadprovider.shortvideo.entity.VideoFollowInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VipExtra;
import com.xunlei.downloadprovider.shortvideo.entity.VipExtras;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FollowInfo */
public class a extends c implements Comparable<a> {
    public VideoUserInfo a;
    public long b;
    public String c;
    public boolean d;
    public String e;
    public String f;
    public long g;
    public long h;
    public int i;
    public boolean j;
    public String k;
    public int l;
    public long m;
    public String n;
    private int o;
    private String q;
    private String r;
    private String s;
    private boolean t;
    private Gender u = Gender.UNKNOWN;
    private String v;
    private String w;
    private VipExtra x;

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        a aVar = (a) obj;
        if (this.j && !aVar.j) {
            return -1;
        }
        if ((!this.j && aVar.j) || this.g < aVar.g) {
            return 1;
        }
        if (this.g > aVar.g) {
            return -1;
        }
        return null;
    }

    public final String a() {
        return TextUtils.isEmpty(this.q) ? this.s : this.q;
    }

    public static a a(JSONObject jSONObject) {
        a aVar = new a();
        aVar.b = jSONObject.optLong("uid");
        aVar.c = jSONObject.optString("kind");
        boolean z = false;
        aVar.d = jSONObject.optInt("v_status") == 1;
        aVar.e = jSONObject.optString("title");
        if (aVar.e.length() == 0) {
            aVar.e = "迅雷用户";
        }
        aVar.o = jSONObject.optInt("fans_count");
        aVar.q = jSONObject.optString("description");
        aVar.r = jSONObject.optString("recommend_reason");
        aVar.f = jSONObject.optString("icon_url");
        aVar.g = jSONObject.optLong("update_time");
        aVar.h = jSONObject.optLong("follow_time");
        aVar.i = jSONObject.optInt("update_count");
        aVar.m = jSONObject.optLong("ptime");
        aVar.t = jSONObject.optBoolean("is_follow");
        jSONObject = jSONObject.optJSONObject("live_extra");
        if (jSONObject != null) {
            if (jSONObject.optInt("rad_status") == 1) {
                z = true;
            }
            aVar.j = z;
            aVar.l = jSONObject.optInt("roomusers");
            aVar.k = jSONObject.optString("rad_title");
            aVar.n = jSONObject.optString("roomInfo");
            jSONObject = jSONObject.optString("head_portrait");
            if (!"".equals(jSONObject)) {
                aVar.f = jSONObject;
            }
        }
        return aVar;
    }

    public static a b(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject(VideoUserInfo.JSON_KEY);
        VideoFollowInfo videoFollowInfo = null;
        VideoUserInfo parseFrom = optJSONObject != null ? VideoUserInfo.parseFrom(optJSONObject) : null;
        jSONObject = jSONObject.optJSONObject("follow_info");
        if (jSONObject != null) {
            videoFollowInfo = VideoFollowInfo.a(jSONObject);
        }
        return a(parseFrom, videoFollowInfo);
    }

    public static a a(VideoUserInfo videoUserInfo, VideoFollowInfo videoFollowInfo) {
        a aVar = new a();
        if (videoUserInfo != null) {
            aVar.a = videoUserInfo;
            aVar.b = Long.parseLong(videoUserInfo.getUid());
            aVar.u = videoUserInfo.getGender();
            aVar.c = videoUserInfo.getKind();
            aVar.e = videoUserInfo.getNickname();
            aVar.q = videoUserInfo.getDescription();
            aVar.f = videoUserInfo.getPortraitUrl();
            aVar.d = videoUserInfo.isAuthPub();
            aVar.v = videoUserInfo.getProvince();
            aVar.w = videoUserInfo.getCity();
            LiveExtra liveExtra = videoUserInfo.getLiveExtra();
            if (liveExtra != null) {
                aVar.j = liveExtra.a();
                aVar.l = liveExtra.c;
                aVar.k = liveExtra.d;
                aVar.n = liveExtra.f;
            }
            VipExtras vipExtras = videoUserInfo.getVipExtras();
            if (vipExtras != null) {
                VipExtra vipExtra = (VipExtra) vipExtras.a.get(2);
                VipExtra vipExtra2 = (VipExtra) vipExtras.a.get(14);
                if (vipExtra == null || !vipExtra.a) {
                    if (vipExtra2 == null || !vipExtra2.a) {
                        if (vipExtra == null) {
                        }
                    }
                    aVar.x = vipExtra2;
                }
                vipExtra2 = vipExtra;
                aVar.x = vipExtra2;
            }
            videoUserInfo = videoUserInfo.getParamsExtra();
            if (videoUserInfo != null) {
                aVar.s = videoUserInfo.a;
                aVar.g = videoUserInfo.b;
                aVar.i = videoUserInfo.c;
            }
        }
        if (videoFollowInfo != null) {
            aVar.o = videoFollowInfo.b;
            aVar.h = videoFollowInfo.d;
            aVar.t = videoFollowInfo.a;
        }
        return aVar;
    }
}
