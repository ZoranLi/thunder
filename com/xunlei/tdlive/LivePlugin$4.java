package com.xunlei.tdlive;

import android.content.Context;
import android.net.Uri;
import com.xunlei.downloadprovider.member.login.LoginHelper.LoginPageType;
import com.xunlei.downloadprovider.member.login.b.c;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.tdlive.route.util.Route.IRoute;
import com.xunlei.tdlive.route.util.UriUtil;

class LivePlugin$4 implements IRoute {
    final /* synthetic */ LivePlugin this$0;

    LivePlugin$4(LivePlugin livePlugin) {
        this.this$0 = livePlugin;
    }

    public int action(Context context, String str, Uri uri) {
        if (LivePlugin.access$000(this.this$0) == null) {
            return 0;
        }
        if (UriUtil.getParam(uri, "silent", false) != null) {
            LivePlugin.access$000(this.this$0).a(false);
        } else {
            LivePlugin.access$000(this.this$0).a(LoginPageType.LOGIN_FLOAT, context, new c() {
                public void onLoginCompleted(boolean z, int i, Object obj) {
                }

                public void onLoginCanceled(boolean z) {
                    LivePlugin$4.this.this$0.notifyUserLoginFinished();
                }
            }, LoginFrom.XL_LIVE, 268435456, null);
        }
        return 0;
    }
}
