package com.xunlei.downloadprovider.frame;

import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;

public enum MainTabSpec$Tab {
    THUNDER("thunder"),
    XLLIVE("xllive"),
    FIND("find"),
    USER(MessageInfo.USER);
    
    private int iconRes;
    private String tag;
    private int textRes;

    private MainTabSpec$Tab(String str) {
        this.tag = str;
        if (str.equals("thunder") != null) {
            this.iconRes = R.drawable.main_tab_first_selector;
            this.textRes = R.string.main_tab_xunlei;
        } else if (str.equals("xllive") != null) {
            this.iconRes = R.drawable.main_tab_xllive_selector;
            this.textRes = R.string.main_tab_xllive;
        } else if (str.equals("find") != null) {
            this.iconRes = R.drawable.main_tab_second_selector;
            this.textRes = R.string.main_tab_find;
        } else {
            if (str.equals(MessageInfo.USER) != null) {
                this.iconRes = R.drawable.main_tab_third_selector;
                this.textRes = R.string.main_tab_user;
            }
        }
    }

    public final String getTag() {
        return this.tag;
    }

    public final int getIcon() {
        return this.iconRes;
    }

    public final int getText() {
        return this.textRes;
    }
}
