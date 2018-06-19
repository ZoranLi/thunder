package com.xunlei.downloadprovider.frame;

import android.os.Handler;
import android.os.Message;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.redpacket.a;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.personal.user.t;
import java.lang.ref.SoftReference;

class MainTabActivity$a extends Handler {
    final /* synthetic */ MainTabActivity a;
    private SoftReference<MainTabActivity> b;

    public MainTabActivity$a(MainTabActivity mainTabActivity, SoftReference<MainTabActivity> softReference) {
        this.a = mainTabActivity;
        this.b = softReference;
    }

    public final void handleMessage(Message message) {
        if (((MainTabActivity) this.b.get()) != null) {
            message = message.what;
            if (message != null) {
                switch (message) {
                    case 4:
                        MainTabActivity.b(this.a).a(MessageInfo.USER).a(this.a.getString(R.string.main_tab_user_not_login)).a((int) R.drawable.main_tab_me_not_login_selector);
                        t.a().a = false;
                        MainTabActivity.a(this.a, "xllive", 8);
                        return;
                    case 5:
                        MainTabActivity.b(this.a).a(MessageInfo.USER).a(this.a.getString(R.string.main_tab_user)).a((int) R.drawable.main_tab_third_selector);
                        t.a().a = true;
                        MainTabActivity.a(this.a, "xllive", 0);
                        return;
                    case 6:
                        new a(this.a).show();
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
