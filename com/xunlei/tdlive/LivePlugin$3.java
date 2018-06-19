package com.xunlei.tdlive;

import android.content.Context;
import android.net.Uri;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.tdlive.route.util.Route.IRoute;

class LivePlugin$3 implements IRoute {
    final /* synthetic */ LivePlugin this$0;

    LivePlugin$3(LivePlugin livePlugin) {
        this.this$0 = livePlugin;
    }

    public int action(Context context, String str, Uri uri) {
        MainTabActivity.b(context, "xllive", null);
        return null;
    }
}
