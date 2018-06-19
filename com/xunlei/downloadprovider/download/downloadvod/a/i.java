package com.xunlei.downloadprovider.download.downloadvod.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.report.a;
import com.xunlei.downloadprovider.launch.dispatch.mocklink.LinkDownloadCenterActivity;

/* compiled from: DownloadVodNotifyManager */
final class i implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ h b;

    i(h hVar, String str) {
        this.b = hVar;
        this.a = str;
    }

    public final void onClick(View view) {
        a.q(this.a);
        if (this.b.a.h != null) {
            Context applicationInstance = BrothersApplication.getApplicationInstance();
            applicationInstance.startActivity(LinkDownloadCenterActivity.b(applicationInstance, this.b.a.h.getTaskId(), this.b.a.h));
        }
    }
}
