package com.xunlei.downloadprovider.personal.message.chat.chatengine.d;

import android.content.Context;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.a;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity$From;

/* compiled from: ChatUserHelper */
public final class e {
    public static IChatUser a(long j, IChatUser... iChatUserArr) {
        for (int i = 0; i < 2; i++) {
            IChatUser iChatUser = iChatUserArr[i];
            if (iChatUser != null && iChatUser.userId() == j) {
                return iChatUser;
            }
        }
        return 0;
    }

    public static boolean a(IChatMessage iChatMessage) {
        return a(iChatMessage.sender());
    }

    public static boolean a(IChatUser iChatUser) {
        return iChatUser.userId() == a.a().a.userId() ? true : null;
    }

    public static void a(Context context, IChatUser iChatUser, PublisherActivity$From publisherActivity$From) {
        m.a(context, iChatUser.userId(), iChatUser.kind(), iChatUser.nickname(), iChatUser.avatarUrl(), publisherActivity$From);
    }
}
