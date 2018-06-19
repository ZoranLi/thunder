package com.xunlei.downloadprovider.member.login.c;

import android.app.Activity;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.launch.LaunchActivity;
import com.xunlei.downloadprovider.launch.guide.GuideActivity;
import com.xunlei.downloadprovider.loading.LoadingActivity;
import com.xunlei.downloadprovider.member.login.ui.XLLoginOfflineDlgActivity;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b;
import com.xunlei.downloadprovider.plugin.q;
import com.xunlei.downloadprovider.vodnew.VodPlayerActivityNew;

/* compiled from: LoginUIHelper */
public class i {
    private static i b;
    public boolean a;

    private i() {
    }

    public static i a() {
        if (b == null) {
            synchronized (i.class) {
                if (b == null) {
                    b = new i();
                }
            }
        }
        return b;
    }

    public final void a(int i, int i2) {
        if (!(AppStatusChgObserver.b().c() instanceof VodPlayerActivityNew)) {
            Activity c = AppStatusChgObserver.b().c();
            boolean z = ((c instanceof LaunchActivity) || (c instanceof GuideActivity) || (c instanceof LoadingActivity) || q.a(c) || b.b().g()) ? false : true;
            if (z) {
                XLLoginOfflineDlgActivity.a(BrothersApplication.getApplicationInstance(), i, i2);
                this.a = false;
                return;
            }
            this.a = true;
        }
    }
}
