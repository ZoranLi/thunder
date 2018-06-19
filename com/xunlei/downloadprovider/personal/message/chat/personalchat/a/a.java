package com.xunlei.downloadprovider.personal.message.chat.personalchat.a;

import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;

/* compiled from: PersonalChatLogoutManager */
public final class a {
    public static void a() {
        MainTabActivity.a(BrothersApplication.getApplicationInstance(), MessageInfo.USER, null, true);
    }
}
