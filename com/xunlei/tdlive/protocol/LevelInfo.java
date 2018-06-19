package com.xunlei.tdlive.protocol;

public final class LevelInfo {
    public int current;
    public long diff_coin;
    public long diff_socre;
    public String icon;
    public String icon2;
    public String icon3;
    public long next_socre;
    public int rate;
    public String title;

    public final String getIconFullPath() {
        return LEVEL_ICON_URL(this.icon);
    }

    public final String getIcon2FullPath() {
        return LEVEL_ICON_URL(this.icon2);
    }

    public static String LEVEL_ICON_URL(String str) {
        StringBuilder stringBuilder = new StringBuilder("http://cdn.live.xunlei.com/cdn/images/level/");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
