package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

/* compiled from: ChatNotificationInfo */
public final class e {
    public String a = "";
    public String b = "";
    public String c = "";

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ChatNotificationInfo{dialogTitle='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", messagePreviewText='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", messageSenderAvatarUrl='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
