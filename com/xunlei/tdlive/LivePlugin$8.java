package com.xunlei.tdlive;

import com.xunlei.downloadprovider.member.login.b.h;

class LivePlugin$8 implements h {
    final /* synthetic */ LivePlugin this$0;

    LivePlugin$8(LivePlugin livePlugin) {
        this.this$0 = livePlugin;
    }

    public void onRefreshUserInfoCompleted(boolean z, int i) {
        if (i == 0) {
            this.this$0.notifyUserInfoGot(LivePlugin.access$000(this.this$0).g.d(), LivePlugin.access$000(this.this$0).g().toString(), LivePlugin.access$000(this.this$0).h(), LivePlugin.access$000(this.this$0).i(), LivePlugin.access$000(this.this$0).j(), LivePlugin.access$000(this.this$0).k(), LivePlugin.access$000(this.this$0).f());
        }
    }
}
