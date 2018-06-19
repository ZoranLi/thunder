package com.xunlei.downloadprovider.member.login.ui;

import com.xunlei.downloadprovider.frame.MainTabActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum LoginFrom {
    HOME_TOP_BAR("home_topbar"),
    HOME_FOLLOW("home_follow"),
    FEED_FOLLOW("feed_follow"),
    VIDEO_DETAIL_FOLLOW("videodetail_follow"),
    PERSONAL_FOLLOW("personal_follow"),
    PERSONAL_CHAT("personal_chat"),
    CHANNEL_FLOW_FOLLOW("channelflow_follow"),
    FOLLOW_TAB("follow_tab"),
    MESSAGE_CENTER("message_center"),
    MY_LIKE_CONTENT("my_like_content"),
    PER_CL_PACKET("per_cl_packet"),
    DLCENTER_DETAIL_PACKET("dlcenter_detail_packet"),
    LOGIN_DIALOG("login_dialog"),
    SHARE_REPOST("share_zhuanfa"),
    USER_DISCUSS("user_discuss"),
    VIDEO_DETAIL_USER_DISCUSS("shortvideo_detail_send"),
    VIDEO_DETAIL_USER_DISCUSS_DEFAULT("shortvideo_detail_default"),
    DL_USER_DISCUSS("dlcenter_dldetail_send"),
    DL_USER_DISCUSS_DEFAULT("dlcenter_dldetail_default"),
    LINK_DETAIL_DISCUSS("link_detail_discuss"),
    GUIDE("GuideActivity"),
    BASE_PAY("BasePayActivity"),
    EXIT_APP_SIGN("MainTabActivity_appExit_sign"),
    GAME_CENTER("DetailPageBrowserActivity游戏中心"),
    TASK_CENTER("TaskActivity"),
    SPACE_PLAY_RECORD("CloudActivity播放记录"),
    SPACE_LI_XIAN("CloudActivity离线空间"),
    SELF_LOGIN(MainTabActivity.a),
    TWO_BUTTON_DIALOG("XLLoginOfflineDlgActivity"),
    USER_SIGN_BTN("MainTabActivity_user_sign"),
    COLLECT_FAVOR("FavorAndHistroyActivity"),
    H5_OTHER("DetailPageBrowserActivity_other"),
    PAY_PAGE("PaymentOnlineActivity"),
    PAY_FLOAT("PayFloatActivity"),
    FORCE_LOGIN("force_login"),
    FORCE_LOGIN_LAUNCH("force_login_launch"),
    MAIN_TAB_LOGIN_GUIDE("main_tab_login_guide"),
    FIND_KUAINIAO("find_kuainiao"),
    CLOUD_PLAY("cloud_play"),
    GUIDE_PAGE("GuideActivity"),
    PAI_SHE_SDK("PaisheSDK"),
    YOU_LIAO_TAB("you_liao_tab"),
    SELF_LOGIN_VIDEO("shortvideo_usercenter_pulink"),
    SHORT_VIDEO_TAG_PARTICIPATE("shortvideo_tag_participate"),
    XL_LIVE("xllive"),
    DL_COMMENT("dlcenter_detail_commnet"),
    AUTH_PHONE_PAGE("auth_phone_page"),
    BXBB_FREE_TRIAL("bxbb_free_trial"),
    CARD_SLIDE_PAGE("shortvideo_hotornot_like"),
    COLLECT_SUCCESS_PUBLIC("collect_success_public"),
    BROWSER_WEBSITE_SHARE("browser_website_share"),
    COLLECT_TAB_CLOUD("collect_tab_cloud"),
    VISIT_LIST("visit_list"),
    PERSONAL_COMMUNITY_REPLY("personal_community_reply"),
    SHORTVIDEO_USERCENTER_REPLY("shortvideo_usercenter_reply"),
    PERSONAL_COMMUNITY_CHAT("personal_community_message"),
    SHORTVIDEO_RECORD_PUBLISH("VodPlayerActivity"),
    HOME_HONGBAO_GET("home_hongbao_get"),
    HOME_FIND_HONGBAO_DEFAULT("find_hongbao_default"),
    INCOME_DETAIL("income_detail"),
    NEWS_DETAIL_FOLLOW("news_detail_follow"),
    NEWS_DETAIL_DISCUSS("news_detail_discuss"),
    HOME_COLLECT_NEWSFOLLOW("home_collect_newsfollow"),
    CINECISM_DETAIL_FOLLOW("cinecism_detail_follow"),
    CINECISM_DETAIL_DISCUSS("cinecism_detail_discuss"),
    VIDEOTAG_COLLECT_FOLLOW("videotag_collect_follow");
    
    private static final Map<String, LoginFrom> sValuesMap = null;
    private String from;

    static {
        Map hashMap = new HashMap();
        LoginFrom[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            LoginFrom loginFrom = values[i];
            hashMap.put(loginFrom.from, loginFrom);
            i++;
        }
        sValuesMap = Collections.unmodifiableMap(hashMap);
    }

    public static LoginFrom enumValueOf(String str) {
        if (sValuesMap.containsKey(str)) {
            return (LoginFrom) sValuesMap.get(str);
        }
        throw new IllegalArgumentException();
    }

    private LoginFrom(String str) {
        this.from = str;
    }

    public final String toString() {
        return this.from;
    }
}
