package com.xunlei.downloadprovider.personal.lixianspace.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.xunlei.downloadprovider.web.base.CustomWebViewActivity;
import com.xunlei.downloadprovider.web.base.core.ag;
import com.xunlei.xllib.android.XLIntent;

public final class LixianSpaceH5Activity extends CustomWebViewActivity {
    private static final String i = "LixianSpaceH5Activity";
    private ag j = new aa(this);

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void onResume() {
        super.onResume();
    }

    protected final void onPause() {
        super.onPause();
    }

    protected final void a() {
        super.a();
        this.c.setMode(Mode.PULL_FROM_START);
        this.f.setWebChromeClient(this.e);
        this.f.a(this.j);
        if (this.f.getJsInterfaceClientSettings() != null) {
            this.f.getJsInterfaceClientSettings().a("space/space_lixian", "space/space_lixian");
        }
    }

    protected final void f_() {
        if (this.f != null) {
            this.f.a("javascript:try{Android_XLClient_PullDownToRefresh();}catch(e){window.XLJSWebViewBridge.sendMessage('xlWebPageRefreshOver','',null);}");
            return;
        }
        super.f_();
    }

    public final void onBackPressed() {
        super.onBackPressed();
    }

    protected final void onDestroy() {
        super.onDestroy();
    }

    public static void a(Context context) {
        Intent xLIntent = new XLIntent(context, LixianSpaceH5Activity.class);
        xLIntent.putExtra("url", "http://lixian.xunlei.com/android/");
        xLIntent.putExtra("title", "离线空间");
        if (!(context instanceof Activity)) {
            xLIntent.addFlags(268435456);
        }
        context.startActivity(xLIntent);
    }
}
