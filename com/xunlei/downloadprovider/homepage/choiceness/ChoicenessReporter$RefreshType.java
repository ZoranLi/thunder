package com.xunlei.downloadprovider.homepage.choiceness;

public enum ChoicenessReporter$RefreshType {
    single_click_bottom_rec,
    single_click_top_tab,
    double_click_top_tab,
    auto_pull,
    manul_pull,
    view_tab;

    public final boolean isAutoRefresh() {
        return this == auto_pull;
    }
}
