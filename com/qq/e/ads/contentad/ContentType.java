package com.qq.e.ads.contentad;

public enum ContentType {
    ARTICLE,
    VIDEO;

    public static ContentType fromString(String str) {
        return "article".equals(str) ? ARTICLE : "video".equals(str) ? VIDEO : null;
    }
}
