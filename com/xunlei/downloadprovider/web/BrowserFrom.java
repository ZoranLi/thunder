package com.xunlei.downloadprovider.web;

import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum BrowserFrom {
    BROWSER_COLLECT("browser_collect"),
    BROWSER_HIS("browser_his"),
    COLLECT_CARD("collect_card"),
    COLLECT_WEBSITE_UPDATE("collect_website_update"),
    DL_CENTER_COLLECT("dl_center_collect"),
    DL_CENTER_DETAIL("dl_center_detail"),
    DL_CENTER_HIS("dl_center_his"),
    DL_CENTER_HOME("dl_home"),
    DL_CENTER_ALL("dl_all"),
    DL_CENTER_DOWNLOADING("dl_dloading"),
    DL_CENTER_COMPLETE("dl_complete"),
    DOWNLOAD_DETAIL_SEARCH_AGAIN("download_detail_search_again"),
    DOWNLOAD_DETAIL_WEB("download_detail_web"),
    FEEDBACK_PAGE("feedback_page"),
    HOME_COLLECT_URL("home_collect_url"),
    LINK_DETAIL_URL("link_detail_url"),
    LINK_MAKE_URL("link_make_url"),
    OTHER(DispatchConstants.OTHER),
    SCAN_QRCODE("scan_qrcode"),
    SEARCH_COPY("search_copy"),
    SEARCH_DIRECT_KEYIN("search_direct_keyin"),
    SEARCH_DIRECT_SEARCH("search_direct_search"),
    SEARCH_ENTER("search_enter"),
    SEARCH_HIS("search_his"),
    SEARCH_HOT_WORD("search_hot_word"),
    SEARCH_NOW_LINK("search_now_link"),
    SEARCH_NOW_THINK("search_now_think"),
    SEARCH_RESULT("search_result"),
    SEARCH_RESULT_LINK("search_result_link"),
    SEARCH_THINK("search_think"),
    SEARCH_THINK_COLLECT("search_think_collect"),
    SEARCH_THINK_HISTORY("search_think_history"),
    SEARCH_THINK_LINK("search_think_link"),
    SEARCH_WEB_COLLECT("search_web_collect"),
    SEARCH_WEB_HIS("search_web_his"),
    SHORTVIDEO_USERCENTER_URL("shortvideo_usercenter_url"),
    THIRDAPP_URL_INPUT("thirdapp_url_input"),
    WEBSITE_TOPIC("link_collect"),
    VIDEO_DETAIL_RECOMMEND_WEBSITE("videodetail_matched_link"),
    CHAT_MESSAGE_LINK("message_link"),
    UNDEFINED("undefined");
    
    private static final Map<String, BrowserFrom> sValuesMap = null;
    private String value;

    static {
        Map hashMap = new HashMap();
        BrowserFrom[] values = values();
        int length = values.length;
        int i;
        while (i < length) {
            BrowserFrom browserFrom = values[i];
            hashMap.put(browserFrom.value, browserFrom);
            i++;
        }
        sValuesMap = Collections.unmodifiableMap(hashMap);
    }

    private BrowserFrom(String str) {
        this.value = str;
    }

    public static BrowserFrom fromString(String str) {
        return fromString(str, OTHER);
    }

    public static BrowserFrom fromString(String str, BrowserFrom browserFrom) {
        return sValuesMap.containsKey(str) ? (BrowserFrom) sValuesMap.get(str) : browserFrom;
    }

    public final String toString() {
        return getValue();
    }

    public final String getValue() {
        return this.value;
    }
}
