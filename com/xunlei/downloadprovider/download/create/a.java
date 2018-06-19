package com.xunlei.downloadprovider.download.create;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.download.TorrentParser.ParseResult;

/* compiled from: BaseBtFileExplorerActivity */
final class a implements MessageListener {
    final /* synthetic */ BaseBtFileExplorerActivity a;

    a(BaseBtFileExplorerActivity baseBtFileExplorerActivity) {
        this.a = baseBtFileExplorerActivity;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1) {
            this.a.b();
            BaseBtFileExplorerActivity.a(this.a);
        } else if (message.what == 2) {
            BaseBtFileExplorerActivity.b(this.a).setVisibility(0);
            ParseResult parseResult = (ParseResult) message.obj;
            BaseBtFileExplorerActivity.a(this.a, new BaseBtFileExplorerActivity$a(this.a, parseResult));
            BaseBtFileExplorerActivity.c(this.a);
            if (BaseBtFileExplorerActivity.d(this.a).size() == BaseBtFileExplorerActivity.e(this.a).size()) {
                BaseBtFileExplorerActivity.f(this.a).a(false);
            }
            BaseBtFileExplorerActivity.b(this.a).setAdapter(BaseBtFileExplorerActivity.g(this.a));
            this.a.c = parseResult.mTaskId <= 0 ? -1 : parseResult.mTaskId;
            BaseBtFileExplorerActivity.h(this.a);
            BaseBtFileExplorerActivity.i(this.a).setVisibility(8);
        } else {
            this.a.a(message);
        }
    }
}
