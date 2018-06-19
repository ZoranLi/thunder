package com.xunlei.tdlive;

import com.xunlei.downloadprovider.member.login.b.g;

class LivePlugin$6 implements g {
    final /* synthetic */ LivePlugin this$0;

    LivePlugin$6(LivePlugin livePlugin) {
        this.this$0 = livePlugin;
    }

    public void onLogout() {
        this.this$0.notifyUserLogout();
    }
}
