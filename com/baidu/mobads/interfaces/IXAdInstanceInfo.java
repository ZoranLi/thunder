package com.baidu.mobads.interfaces;

import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public interface IXAdInstanceInfo {

    public enum CreativeType {
        NONE("none"),
        TEXT("text"),
        STATIC_IMAGE("static_image"),
        GIF("gif"),
        RM("rich_media"),
        HTML("html"),
        HYBRID("hybrid"),
        VIDEO("video");
        
        private final String a;

        private CreativeType(String str) {
            this.a = str;
        }

        public final String getValue() {
            return this.a;
        }

        public static CreativeType parse(String str) {
            for (CreativeType creativeType : values()) {
                if (creativeType.a.equalsIgnoreCase(str)) {
                    return creativeType;
                }
            }
            return null;
        }
    }

    boolean getAPOOpen();

    String getAction();

    int getActionType();

    String getAdId();

    String getAdSource();

    int getAntiTag();

    String getAppName();

    String getAppOpenStrs();

    String getAppPackageName();

    long getAppSize();

    List<String> getCcardTrackers();

    String getClickThroughUrl();

    String getClklogurl();

    List<String> getCloseTrackers();

    String getConfirmBorderPercent();

    long getCreateTime();

    CreativeType getCreativeType();

    List<String> getCstartcardTrackers();

    String getDescription();

    int getDlTunnel();

    String getExp2ForSingleAd();

    List<String> getFullScreenTrackers();

    String getFwt();

    int getHoursInADayToShowAd();

    String getHtmlSnippet();

    String getIconUrl();

    Set<String> getImpressionUrls();

    String getLocalCreativeURL();

    int getMainMaterialHeight();

    int getMainMaterialWidth();

    String getMainPictureUrl();

    String getMaterialType();

    JSONArray getNwinurl();

    String getOriginClickUrl();

    JSONObject getOriginJsonObject();

    String getPage();

    String getPhoneForLocalBranding();

    String getPhoneNumber();

    int getPointsForWall();

    String getQueryKey();

    List<String> getScardTrackers();

    List<String> getSkipTrackers();

    String getSponsorUrl();

    List<String> getStartTrackers();

    int getSwitchButton();

    List<String> getThirdClickTrackingUrls();

    List<String> getThirdImpressionTrackingUrls();

    String getTitle();

    String getUniqueId();

    String getUrl();

    int getVideoDuration();

    int getVideoHeight();

    String getVideoUrl();

    int getVideoWidth();

    String getVurl();

    String getWebUrl();

    String getWinurl();

    boolean isActionOnlyWifi();

    boolean isAutoOpen();

    boolean isCanCancel();

    boolean isCanDelete();

    boolean isClose();

    @Deprecated
    boolean isIconVisibleForImageType();

    boolean isInapp();

    boolean isPopNotif();

    boolean isSecondConfirmed();

    boolean isTaskDoneForWall();

    boolean isTooLarge();

    Boolean isValid();

    boolean isVideoMuted();

    boolean isWifiTargeted();

    void setAPOOpen(boolean z);

    void setAction(String str);

    void setActionOnlyWifi(boolean z);

    void setActionType(int i);

    void setAdId(String str);

    void setAdSource(String str);

    void setAntiTag(int i);

    void setAppName(String str);

    void setAppOpenStrs(String str);

    void setAppPackageName(String str);

    void setAppSize(long j);

    void setAutoOpen(boolean z);

    void setCanCancel(boolean z);

    void setCanDelete(boolean z);

    void setCcardTrackers(List<String> list);

    void setClickThroughUrl(String str);

    void setClklogurl(String str);

    void setClose(boolean z);

    void setCloseTrackers(List<String> list);

    void setConfirmBorderPercent(String str);

    void setCreateTime(long j);

    void setCreativeType(CreativeType creativeType);

    void setCstartcardTrackers(List<String> list);

    void setDescription(String str);

    void setDlTunnel(int i);

    void setExp2ForSingleAd(String str);

    void setFullScreenTrackers(List<String> list);

    void setFwt(String str);

    @Deprecated
    void setHoursInADayToShowAd(int i);

    void setHtmlSnippet(String str);

    void setIconUrl(String str);

    @Deprecated
    void setIconVisibleForImageType(boolean z);

    void setImpressionUrls(Set<String> set);

    void setInapp(boolean z);

    void setLocalCreativeURL(String str);

    void setMainMaterialHeight(int i);

    void setMainMaterialWidth(int i);

    void setMainPictureUrl(String str);

    void setMaterialType(String str);

    void setNwinurl(JSONArray jSONArray);

    void setOriginClickUrl(String str);

    void setPage(String str);

    void setPhoneForLocalBranding(String str);

    void setPhoneNumber(String str);

    void setPointsForWall(int i);

    void setPopNotif(boolean z);

    void setQueryKey(String str);

    void setScardTrackers(List<String> list);

    void setSecondConfirmed(boolean z);

    void setSkipTrackers(List<String> list);

    void setSponsorUrl(String str);

    void setStartTrackers(List<String> list);

    void setSwitchButton(int i);

    void setTaskDoneForWall(boolean z);

    void setThirdClickTrackingUrls(Set<String> set);

    void setThirdImpressionTrackingUrls(Set<String> set);

    void setTitle(String str);

    void setTooLarge(boolean z);

    void setUrl(String str);

    void setVideoDuration(int i);

    void setVideoHeight(int i);

    void setVideoMuted(boolean z);

    void setVideoUrl(String str);

    void setVideoWidth(int i);

    void setVurl(String str);

    void setWebUrl(String str);

    void setWifiTargeted(boolean z);

    void setWinurl(String str);
}
