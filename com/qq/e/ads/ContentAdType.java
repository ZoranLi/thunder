package com.qq.e.ads;

public enum ContentAdType {
    AD,
    INFORMATION;

    public static ContentAdType fromString(String str) {
        return "ad".equals(str) ? AD : "information".equals(str) ? INFORMATION : null;
    }
}
