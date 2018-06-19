package com.xunlei.tdlive;

import com.taobao.accs.utl.UTMini;
import com.xunlei.downloadprovider.member.login.b.d;

class LivePlugin$7 implements d {
    final /* synthetic */ LivePlugin this$0;

    LivePlugin$7(LivePlugin livePlugin) {
        this.this$0 = livePlugin;
    }

    public void onLoginCompleted(boolean z, int i, boolean z2) {
        if (i == 0) {
            this.this$0.notifyUserLogin(String.valueOf(LivePlugin.access$000(this.this$0).g.c()), UTMini.EVENTID_AGOO, LivePlugin.access$000(this.this$0).c(), LivePlugin.access$000(this.this$0).a(UTMini.EVENTID_AGOO));
        }
    }
}
