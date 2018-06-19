package com.xunlei.downloadprovider.personal.message;

public enum MessageActivty$MessageType {
    STAR("star"),
    VISIT("visit"),
    COMMENT("comment"),
    FOLLOW("follow"),
    STRANGERS("strangers"),
    UNKNOWN("unknown");
    
    private final String mType;

    private MessageActivty$MessageType(String str) {
        this.mType = str;
    }

    public final String getType() {
        return this.mType;
    }
}
