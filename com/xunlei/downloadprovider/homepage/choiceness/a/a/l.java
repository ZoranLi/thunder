package com.xunlei.downloadprovider.homepage.choiceness.a.a;

import com.xunlei.download.DownloadManager;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import java.util.ArrayList;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChoicenessRecommendUserGroupInfo */
public final class l extends e {
    public List<a> a = new ArrayList();

    /* compiled from: ChoicenessRecommendUserGroupInfo */
    public static class a {
        public String a;
        public String b;
        public VideoUserInfo c;
        public boolean d;
        private String e;
        private String f;
        private String g;

        public static a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            a aVar = new a();
            aVar.e = jSONObject.optString(AgooConstants.MESSAGE_EXT);
            aVar.a = jSONObject.optString(AgooConstants.MESSAGE_ID);
            aVar.f = jSONObject.optString(DownloadManager.COLUMN_REASON);
            aVar.b = jSONObject.optString("recommend_reason");
            aVar.g = jSONObject.optString("resource");
            jSONObject = jSONObject.optJSONObject(VideoUserInfo.JSON_KEY);
            if (jSONObject != null) {
                try {
                    aVar.c = VideoUserInfo.parseFrom(jSONObject);
                    if (aVar.c == null) {
                        aVar.c = new VideoUserInfo();
                    }
                } catch (JSONObject jSONObject2) {
                    jSONObject2.printStackTrace();
                }
            }
            return aVar;
        }
    }

    public static l a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        e lVar = new l();
        JSONArray jSONArray = jSONObject.getJSONArray("res_info");
        if (jSONArray != null) {
            if (jSONArray.length() != 0) {
                a(lVar, jSONObject);
                for (jSONObject = null; jSONObject < jSONArray.length(); jSONObject++) {
                    a a = a.a(jSONArray.getJSONObject(jSONObject));
                    if (a != null) {
                        lVar.a.add(a);
                    }
                }
                return lVar;
            }
        }
        return null;
    }
}
