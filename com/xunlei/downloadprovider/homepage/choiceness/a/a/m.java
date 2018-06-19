package com.xunlei.downloadprovider.homepage.choiceness.a.a;

import com.xunlei.download.DownloadManager;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChoicenessVideoInfo */
public final class m extends e {
    public VideoUserInfo a = new VideoUserInfo();
    public BaseVideoInfo b = new BaseVideoInfo();
    public List<CommentInfo> c;
    public boolean d = false;
    public int n = 0;
    public String o;
    private String p;

    public static m a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        e mVar = new m();
        e.a(mVar, jSONObject);
        mVar.p = jSONObject.optString("res_from");
        JSONObject optJSONObject = jSONObject.optJSONObject("res_info");
        if (optJSONObject != null) {
            BaseVideoInfo.parseFrom(mVar.b, optJSONObject);
            mVar.b.setServerExtData(mVar.m);
        }
        optJSONObject = jSONObject.optJSONObject(VideoUserInfo.JSON_KEY);
        if (optJSONObject != null) {
            VideoUserInfo.parseFrom(mVar.a, optJSONObject);
        }
        mVar.o = jSONObject.optString(DownloadManager.COLUMN_REASON);
        return mVar;
    }
}
