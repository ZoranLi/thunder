package com.xunlei.downloadprovider.personal.user.account.ui;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;

/* compiled from: UserAccountPortraitSettingActivity */
final class ac implements MessageListener {
    final /* synthetic */ UserAccountPortraitSettingActivity a;

    ac(UserAccountPortraitSettingActivity userAccountPortraitSettingActivity) {
        this.a = userAccountPortraitSettingActivity;
    }

    public final void handleMessage(Message message) {
        if (message.what == 107) {
            UserAccountPortraitSettingActivity.a(this.a).a(UserAccountPortraitSettingActivity.l(this.a).e(), UserAccountPortraitSettingActivity.m(this.a), false);
        }
    }
}
