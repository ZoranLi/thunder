package com.xunlei.downloadprovider.vod.subtitle;

import android.text.TextUtils;
import com.alipay.sdk.cons.c;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.Serializable;
import org.json.JSONObject;

public class SubtitleInfo implements Serializable {
    private static final long serialVersionUID = 5;
    private String displayName;
    private String fileExtension;
    private String fileLanguange;
    private String fileName;
    private String fileUrl;
    private String localFilePath;
    private int offset = 0;
    private int sDuration;
    private String scid;
    private String uiDisplayName;

    public String getScid() {
        return this.scid;
    }

    public final long getId() {
        if (this.scid != null) {
            return (long) this.scid.hashCode();
        }
        return this.fileUrl != null ? (long) this.fileUrl.hashCode() : 0;
    }

    public boolean isDownload() {
        return !TextUtils.isEmpty(this.fileUrl);
    }

    public void setScid(String str) {
        this.scid = str;
    }

    public int getsDuration() {
        return this.sDuration;
    }

    public void setsDuration(int i) {
        this.sDuration = i;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public String getFileExtension() {
        return this.fileExtension;
    }

    public void setFileExtension(String str) {
        this.fileExtension = str;
    }

    public String getFileLanguange() {
        return this.fileLanguange;
    }

    public void setFileLanguange(String str) {
        this.fileLanguange = str;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }

    public void setFileUrl(String str) {
        this.fileUrl = str;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public String getLocalFilePath() {
        return this.localFilePath;
    }

    public void setLocalFilePath(String str) {
        this.localFilePath = str;
    }

    public String getUiDisplayName() {
        return this.uiDisplayName;
    }

    public void setUiDisplayName(String str) {
        this.uiDisplayName = str;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public static SubtitleInfo parseFromExectMatchJson(JSONObject jSONObject) {
        SubtitleInfo subtitleInfo = null;
        if (jSONObject != null) {
            if (jSONObject.length() != 0) {
                SubtitleInfo subtitleInfo2 = new SubtitleInfo();
                subtitleInfo2.scid = jSONObject.optString("cid");
                subtitleInfo2.displayName = jSONObject.optString(c.e);
                subtitleInfo2.fileLanguange = jSONObject.optJSONArray("languages").optString(0);
                subtitleInfo2.fileUrl = jSONObject.optString("url");
                subtitleInfo2.fileExtension = jSONObject.optString(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND);
                subtitleInfo2.sDuration = jSONObject.optInt(SocializeProtocolConstants.DURATION);
                if (TextUtils.isEmpty(subtitleInfo2.fileUrl) == null) {
                    if (TextUtils.isEmpty(subtitleInfo2.scid) == null) {
                        if (TextUtils.isEmpty(subtitleInfo2.fileExtension) == null) {
                            jSONObject = new StringBuilder();
                            jSONObject.append(subtitleInfo2.scid);
                            jSONObject.append(".");
                            jSONObject.append(subtitleInfo2.fileExtension);
                            subtitleInfo2.fileName = jSONObject.toString();
                        } else {
                            subtitleInfo2.fileName = subtitleInfo2.scid;
                        }
                    }
                    subtitleInfo = subtitleInfo2;
                }
                return subtitleInfo;
            }
        }
        return null;
    }
}
