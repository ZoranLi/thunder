package com.xunlei.downloadprovider.vod.subtitle;

import android.support.annotation.ColorInt;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.b.d;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class SubtitleManifest implements Serializable {
    private static final String TAG = "SubtitleManifest";
    private static final long serialVersionUID = 5;
    private int defaultIndex = -1;
    private int localDefaultIndex = -1;
    private int localSubCount = 0;
    private boolean mIsSubtitleManifestShowed = false;
    private String relatedGcid;
    private String relatedName;
    private int subtitleColor = BrothersApplication.getApplicationInstance().getResources().getColor(R.color.vod_player_subtitle_color_white);
    private List<SubtitleInfo> subtitleList;

    public int getListCount() {
        return this.subtitleList != null ? this.subtitleList.size() : 0;
    }

    public List<SubtitleInfo> getSubtitleList() {
        return this.subtitleList;
    }

    public void setSubtitleList(List<SubtitleInfo> list) {
        if (!d.a(this.subtitleList)) {
            this.subtitleList.clear();
        }
        this.subtitleList.addAll(list);
    }

    public int getDefaultIndex() {
        return this.defaultIndex;
    }

    public void setDefaultIndex(int i) {
        this.defaultIndex = i;
    }

    public int getLocalDefaultIndex() {
        return this.localDefaultIndex;
    }

    public void setLocalDefaultIndex(int i) {
        this.localDefaultIndex = i;
    }

    public int getLocalSubCount() {
        return this.localSubCount;
    }

    public void setLocalSubCount(int i) {
        this.localSubCount = i;
    }

    public boolean getIsSubtitleManifestShowed() {
        return this.mIsSubtitleManifestShowed;
    }

    public void setIsSubtitleManifestShowed(boolean z) {
        this.mIsSubtitleManifestShowed = z;
    }

    public int getNetSubtitleCount() {
        return getListCount() - this.localSubCount;
    }

    public void addSubtitleInfo(int i, SubtitleInfo subtitleInfo) {
        if (this.subtitleList == null) {
            this.subtitleList = new ArrayList(2);
        }
        this.subtitleList.add(i, subtitleInfo);
        new StringBuilder("subtitleList size : ").append(this.subtitleList.size());
    }

    public void addSubtitleInfo(SubtitleInfo subtitleInfo) {
        if (this.subtitleList == null) {
            this.subtitleList = new ArrayList(2);
        }
        this.subtitleList.add(subtitleInfo);
    }

    public String getRelatedGcid() {
        return this.relatedGcid;
    }

    public void setRelatedGcid(String str) {
        this.relatedGcid = str;
    }

    public String getRelatedName() {
        return this.relatedName;
    }

    public void setRelatedName(String str) {
        this.relatedName = str;
    }

    @ColorInt
    public int getSubtitleColor() {
        return this.subtitleColor;
    }

    public void setSubtitleColor(@ColorInt int i) {
        this.subtitleColor = i;
    }

    public static SubtitleManifest parseFromJson(JSONObject jSONObject) {
        SubtitleManifest subtitleManifest = null;
        if (jSONObject == null) {
            return null;
        }
        if (ITagManager.SUCCESS.equals(jSONObject.optString("result"))) {
            jSONObject = jSONObject.optJSONArray("data");
            if (jSONObject != null) {
                int length = jSONObject.length();
                if (length > 0) {
                    subtitleManifest = new SubtitleManifest();
                    subtitleManifest.subtitleList = new ArrayList(length);
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject = jSONObject.optJSONObject(i);
                        if (!(optJSONObject == null || optJSONObject.length() == 0)) {
                            SubtitleInfo parseFromExectMatchJson = SubtitleInfo.parseFromExectMatchJson(optJSONObject);
                            if (parseFromExectMatchJson != null) {
                                subtitleManifest.subtitleList.add(parseFromExectMatchJson);
                            }
                        }
                    }
                }
            }
        }
        return subtitleManifest;
    }

    public void preProcessSubTitleInfo(r rVar) {
        if (getListCount() > 0) {
            if (rVar != null) {
                int listCount = getListCount();
                for (int i = 0; i < listCount; i++) {
                    rVar.a((SubtitleInfo) this.subtitleList.get(i), i);
                }
            }
        }
    }
}
