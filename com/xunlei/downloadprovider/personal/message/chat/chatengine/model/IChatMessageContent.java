package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

import java.io.Serializable;

public interface IChatMessageContent extends Serializable {
    public static final int TYPE_CUSTOM = 3;
    public static final int TYPE_IMAGE = 2;
    public static final int TYPE_LOCAL = 1000;
    public static final int TYPE_LOCAL_DATE_HEADER = 1001;
    public static final int TYPE_LOCAL_UNKNOWN = 1002;
    public static final int TYPE_TEXT = 1;

    public static class a {
        public boolean a = false;
        public String b = null;

        public a(boolean z, String str) {
            this.a = z;
            this.b = str;
        }
    }

    public interface IChatCustomMessageContent<T> extends IChatMessageContent {
        int customType();

        T getMessageContent();
    }

    public interface IChatTextMessageContent extends IChatMessageContent {
        String text();
    }

    a checkMyself();

    String content();

    String previewText();

    String reportType();

    int type();
}
