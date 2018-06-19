package com.xunlei.downloadprovider.launch.dispatch;

import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.download.create.DownloadBtFileExplorerActivity;
import com.xunlei.downloadprovider.launch.e.c;

/* compiled from: DLBtFileExplorerDISP */
public final class g extends b {
    private Intent a;

    protected final boolean a(Intent intent) {
        this.a = intent;
        if (this.a == null || this.a.getIntExtra("dispatch_from_key", -1) != 1102) {
            return false;
        }
        return true;
    }

    protected final void a(Context context) {
        new StringBuilder("enterConcreateActivity ").append(getClass().getSimpleName());
        this.a.setClass(context, DownloadBtFileExplorerActivity.class);
        this.a.putExtra("dispatch_from_key", 0);
        this.a.putExtra("createOriginFrom", "manual/file_bt");
        context.startActivity(this.a);
        c.a("file_bt", true);
    }
}
