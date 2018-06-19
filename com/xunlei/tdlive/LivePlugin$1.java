package com.xunlei.tdlive;

import android.content.Context;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.tdlive.LivePluginAppRouteDispatcher.ILivePluginCallback;
import com.xunlei.tdlive.route.IXLLiveRoute;

class LivePlugin$1 implements ILivePluginCallback {
    final /* synthetic */ LivePlugin this$0;
    final /* synthetic */ Context val$context;

    LivePlugin$1(LivePlugin livePlugin, Context context) {
        this.this$0 = livePlugin;
        this.val$context = context;
    }

    public void onLivePluginLoaded(IXLLiveRoute iXLLiveRoute) {
        if (iXLLiveRoute != null) {
            this.this$0.setLiveAppPluginVersion(this.val$context, String.valueOf(LivePluginAppRouteDispatcher.getLivePluginVersion()));
            LivePluginAppRouteDispatcher.fireInitEvent(AndroidConfig.getHubbleDeviceGUID(), MainTabActivity.class.getName());
        }
    }
}
