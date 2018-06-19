package com.xunlei.downloadprovider.download.create;

import android.os.Message;
import com.xunlei.download.TorrentParser.ParseResult;
import com.xunlei.downloadlib.parameter.TorrentFileInfo;

/* compiled from: BaseBtFileExplorerActivity */
final class j implements Runnable {
    final /* synthetic */ TorrentFileInfo[] a;
    final /* synthetic */ ParseResult b;
    final /* synthetic */ BaseBtFileExplorerActivity c;

    j(BaseBtFileExplorerActivity baseBtFileExplorerActivity, TorrentFileInfo[] torrentFileInfoArr, ParseResult parseResult) {
        this.c = baseBtFileExplorerActivity;
        this.a = torrentFileInfoArr;
        this.b = parseResult;
    }

    public final void run() {
        if (this.a != null && this.a.length > 0) {
            for (TorrentFileInfo a : this.a) {
                BaseBtFileExplorerActivity$c a2 = BaseBtFileExplorerActivity.a(a);
                BaseBtFileExplorerActivity.a(a2);
                BaseBtFileExplorerActivity.d(this.c).add(a2);
            }
        }
        Message obtainMessage = this.c.i.obtainMessage();
        obtainMessage.what = 2;
        obtainMessage.obj = this.b;
        this.c.i.sendMessage(obtainMessage);
    }
}
