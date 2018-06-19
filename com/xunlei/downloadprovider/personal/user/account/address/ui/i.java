package com.xunlei.downloadprovider.personal.user.account.address.ui;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;

/* compiled from: UserRegionSelectProvinceActivity */
final class i implements MessageListener {
    final /* synthetic */ UserRegionSelectProvinceActivity a;

    i(UserRegionSelectProvinceActivity userRegionSelectProvinceActivity) {
        this.a = userRegionSelectProvinceActivity;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1338) {
            message = message.peekData();
            if (message != null) {
                this.a.l = true;
                UserRegionSelectProvinceActivity.a(this.a, message.getString("extra_latitude"), message.getString("extra_longitude"));
            }
        }
    }
}
