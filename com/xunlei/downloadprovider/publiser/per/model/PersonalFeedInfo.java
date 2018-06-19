package com.xunlei.downloadprovider.publiser.per.model;

import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.homepage.cinecism.data.CinecismInfo;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class PersonalFeedInfo<T> implements Serializable {
    public static final String TYPE_COMMENT_CINECISM = "comment_cinecism";
    public static final String TYPE_COMMENT_VIDEO = "comment_video";
    public static final String TYPE_COMMENT_WEBSITE = "comment_site";
    public static final String TYPE_LIKE_CINECISM = "like_cinecism";
    public static final String TYPE_LIKE_VIDEO = "like_video";
    public static final String TYPE_LIKE_WEBSITE = "like_site";
    public static final String TYPE_PUB_CINECISM = "pub_cinecism";
    public static final String TYPE_PUB_VIDEO = "pub_video";
    public static final String TYPE_PUB_WEBSITE = "pub_site";
    private static final long serialVersionUID = 1;
    private T data;
    private long mCursor;
    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T t) {
        this.data = t;
    }

    public long getCursor() {
        return this.mCursor;
    }

    public void setCursor(long j) {
        this.mCursor = j;
    }

    public static PersonalFeedInfo parseDynamicInfoFrom(JSONObject jSONObject) {
        PersonalFeedInfo personalFeedInfo = null;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("type");
        long optLong = jSONObject.optLong("cursor");
        PersonalFeedInfo personalFeedInfo2;
        try {
            if (TYPE_COMMENT_VIDEO.equals(optString)) {
                personalFeedInfo2 = new PersonalFeedInfo();
                try {
                    personalFeedInfo2.type = optString;
                    personalFeedInfo2.mCursor = optLong;
                    personalFeedInfo2.data = CommentVideoFeedInfo.parseFrom(jSONObject);
                } catch (JSONException e) {
                    jSONObject = e;
                    personalFeedInfo = personalFeedInfo2;
                    jSONObject.printStackTrace();
                    personalFeedInfo2 = personalFeedInfo;
                    return personalFeedInfo2;
                }
                return personalFeedInfo2;
            } else if (TYPE_LIKE_VIDEO.equals(optString)) {
                personalFeedInfo2 = new PersonalFeedInfo();
                personalFeedInfo2.type = optString;
                personalFeedInfo2.mCursor = optLong;
                personalFeedInfo2.data = LikeVideoFeedInfo.parseFrom(jSONObject);
                return personalFeedInfo2;
            } else if (TYPE_COMMENT_WEBSITE.equals(optString)) {
                personalFeedInfo2 = new PersonalFeedInfo();
                personalFeedInfo2.type = optString;
                personalFeedInfo2.mCursor = optLong;
                personalFeedInfo2.data = c.a(jSONObject);
                return personalFeedInfo2;
            } else if (TYPE_LIKE_WEBSITE.equals(optString)) {
                personalFeedInfo2 = new PersonalFeedInfo();
                personalFeedInfo2.type = optString;
                personalFeedInfo2.mCursor = optLong;
                e eVar = new e();
                if (jSONObject != null) {
                    eVar.a = jSONObject.optLong(MessageInfo.INSERT_TIME) * 1000;
                    jSONObject.optJSONObject(VideoUserInfo.JSON_KEY);
                    jSONObject = jSONObject.optJSONObject("site_info");
                    if (jSONObject != null) {
                        if (jSONObject.length() != 0) {
                            eVar.b = WebsiteInfo.a(jSONObject);
                            r0 = eVar;
                        }
                    }
                    throw new JSONException("Invalid json site_info");
                }
                personalFeedInfo2.data = r0;
                return personalFeedInfo2;
            } else if (TYPE_COMMENT_CINECISM.equals(optString)) {
                personalFeedInfo2 = new PersonalFeedInfo();
                personalFeedInfo2.type = optString;
                personalFeedInfo2.mCursor = optLong;
                personalFeedInfo2.data = a.a(jSONObject);
                return personalFeedInfo2;
            } else {
                if (TYPE_LIKE_CINECISM.equals(optString)) {
                    personalFeedInfo2 = new PersonalFeedInfo();
                    personalFeedInfo2.type = optString;
                    personalFeedInfo2.mCursor = optLong;
                    d dVar = new d();
                    if (jSONObject != null) {
                        dVar.a = jSONObject.optLong(MessageInfo.INSERT_TIME) * 1000;
                        jSONObject = jSONObject.optJSONObject("cinecism_info");
                        if (jSONObject != null) {
                            if (jSONObject.length() != 0) {
                                dVar.b = CinecismInfo.a(jSONObject);
                                if (dVar.b != null) {
                                    r0 = dVar;
                                }
                            }
                        }
                        throw new JSONException("Invalid json site_info");
                    }
                    personalFeedInfo2.data = r0;
                    return personalFeedInfo2;
                }
                personalFeedInfo2 = personalFeedInfo;
                return personalFeedInfo2;
            }
        } catch (JSONException e2) {
            jSONObject = e2;
            jSONObject.printStackTrace();
            personalFeedInfo2 = personalFeedInfo;
            return personalFeedInfo2;
        }
    }

    public static PersonalFeedInfo parsePublishInfoFrom(JSONObject jSONObject) throws JSONException {
        Object obj = null;
        if (jSONObject == null) {
            return null;
        }
        PersonalFeedInfo personalFeedInfo;
        String optString = jSONObject.optString("type");
        long optLong = jSONObject.optLong("cursor");
        if (TYPE_PUB_VIDEO.equals(optString)) {
            PersonalFeedInfo personalFeedInfo2 = new PersonalFeedInfo();
            personalFeedInfo2.type = optString;
            personalFeedInfo2.mCursor = optLong;
            personalFeedInfo2.data = PublishVideoFeedInfo.parseFrom(jSONObject);
            personalFeedInfo = personalFeedInfo2;
        } else if (TYPE_PUB_WEBSITE.equals(optString)) {
            personalFeedInfo = new PersonalFeedInfo();
            personalFeedInfo.type = optString;
            personalFeedInfo.mCursor = optLong;
            if (jSONObject != null) {
                obj = new h();
                obj.a = WebsiteInfo.a(jSONObject.getJSONObject("site_info"));
                VideoUserInfo videoUserInfo = new VideoUserInfo();
                jSONObject = jSONObject.optJSONObject(VideoUserInfo.JSON_KEY);
                if (jSONObject != null) {
                    VideoUserInfo.parseFrom(videoUserInfo, jSONObject);
                }
                obj.setUserInfo(videoUserInfo);
            }
            personalFeedInfo.data = obj;
        } else if (TYPE_PUB_CINECISM.equals(optString)) {
            personalFeedInfo = new PersonalFeedInfo();
            personalFeedInfo.type = optString;
            personalFeedInfo.mCursor = optLong;
            if (jSONObject != null) {
                f fVar = new f();
                jSONObject = jSONObject.getJSONObject("cinecism_info");
                fVar.a = CinecismInfo.a(jSONObject);
                if (fVar.a != null) {
                    VideoUserInfo videoUserInfo2 = new VideoUserInfo();
                    jSONObject = jSONObject.optJSONObject(VideoUserInfo.JSON_KEY);
                    if (jSONObject != null) {
                        VideoUserInfo.parseFrom(videoUserInfo2, jSONObject);
                    }
                    fVar.setUserInfo(videoUserInfo2);
                    obj = fVar;
                }
            }
            personalFeedInfo.data = obj;
        } else {
            throw new JSONException("Unsupported type");
        }
        return personalFeedInfo;
    }
}
