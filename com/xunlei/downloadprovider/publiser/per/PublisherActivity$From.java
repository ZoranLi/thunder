package com.xunlei.downloadprovider.publiser.per;

public enum PublisherActivity$From {
    VIDEO_DETAIL("videodetail"),
    NEWS_DETAIL("newsDetail"),
    HOMEPAGE("homepage"),
    YOULIAO_TAB("youliao_tab"),
    FEED_FLOW("feedflow"),
    FOLLOW_TAB("followtab"),
    FOLLOW_TAB_LIST("followtab_list"),
    FAN_LIST("fan_list"),
    FOLLOW_LIST("follow_list"),
    LIKE_LIST("like_list"),
    VISITOR_LIST("visitor_list"),
    HOME_REC_FOLLOW("home_rec_follow"),
    HOME_COLLECT_DISCUSS("home_collect_discuss"),
    PERSONAL_SPACE("personal_space"),
    ACCOUNT_CENTER("account_center"),
    INFO_CENTER("info_center"),
    INFO_CENTER_ALTER("info_center_alter"),
    NOTICE("notice"),
    PERSONAL_ACCOUNT_HEAD("personal_account_head"),
    VIDEOCOLLECT("videoCollect"),
    MUSIC_COLLECT("musicCollect"),
    LBS_COLLECT("lbsCollect"),
    FOLLOWRECOMMEND("followrec"),
    SEARCH_NOW_LINK("search_now_link"),
    SEARCH_NOW_CHANNEL("search_now_channel"),
    SEARCH_RESULT("search_result"),
    SHARE_H5("publisher_share_h5"),
    XL_LIVE("xllive"),
    HOT_CHANNEL("hot_channel"),
    HOME_COLLECT_URL("home_collect_url"),
    CARD_SLIDE_PAGE("shortvideo_hotornot_info"),
    LINK_DETAIL_HOST("links_detail_host"),
    LINK_DETAIL_LIKE("links_detail_liker"),
    LINK_DETAIL_DISCUSS("links_detail_discusser"),
    FOLLOW_TAB_WEBSITE("followtab_collect_url"),
    PERSONAL_CHAT_DIALOG("personal_community_chatpannel"),
    NEWS_DETAIL_HEAD("news_detail_head"),
    NEWS_DETAIL_ZANER("news_detail_zaner"),
    NEWS_DETAIL_DISCUSSER("news_detail_discusser"),
    HOME_COLLECT_NEWS("home_collect_news"),
    PUBLISHER_HISTORY_TAB("publisher_history_tab"),
    WEBSITE_TOPIC("link_collect"),
    HOME_CINECISM_CARD("home_cinecism_card"),
    CINECISM_DETAIL("cinecism_detail"),
    VIDEOTAG_COLLECT("videotag_collect");
    
    private final String mText;

    private PublisherActivity$From(String str) {
        this.mText = str;
    }

    public final String getText() {
        return this.mText;
    }
}
