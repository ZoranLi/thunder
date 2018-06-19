package com.xunlei.downloadprovider.personal.lixianspace.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.create.BaseCreateBtTaskActivity;
import com.xunlei.downloadprovider.download.create.m;
import com.xunlei.downloadprovider.personal.lixianspace.b.b;
import com.xunlei.xllib.android.XLIntent;

public final class LXSpaceCreateBtTaskActivity extends BaseCreateBtTaskActivity implements OnClickListener {
    private b d = new i(this);

    protected final void a(String str, int i) {
        if (i == 0) {
            LXBtFileExplorerActivity.a(this, str, 9);
        } else {
            LXBtFileExplorerActivity.a(this, str, 10);
        }
    }

    public static void a(Context context) {
        Intent xLIntent = new XLIntent(context, LXSpaceCreateBtTaskActivity.class);
        if (!(context instanceof Activity)) {
            xLIntent.addFlags(268435456);
        }
        String b = b();
        if (b != null) {
            xLIntent.putExtra("last_torrent_open_path", b);
        }
        context.startActivity(xLIntent);
    }

    private static java.lang.String b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.xunlei.common.businessutil.SettingStateController.getInstance();
        r0 = r0.getLastTorrentOpenPath();
        r1 = 0;
        if (r0 == 0) goto L_0x0017;
    L_0x000b:
        r2 = new java.io.File;	 Catch:{ Exception -> 0x0017 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0017 }
        r2 = r2.exists();	 Catch:{ Exception -> 0x0017 }
        if (r2 == 0) goto L_0x0017;
    L_0x0016:
        r1 = r0;
    L_0x0017:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.lixianspace.ui.LXSpaceCreateBtTaskActivity.b():java.lang.String");
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.a.a(this.d);
    }

    protected final void onResume() {
        super.onResume();
        m.a().b = true;
    }

    protected final void onDestroy() {
        a.a.b(this.d);
        super.onDestroy();
    }
}
