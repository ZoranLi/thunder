package com.ali.auth.third.ui.webview;

import android.view.View;
import android.view.View.OnClickListener;

final class e implements OnClickListener {
    final /* synthetic */ BaseWebViewActivity a;

    e(BaseWebViewActivity baseWebViewActivity) {
        this.a = baseWebViewActivity;
    }

    public final void onClick(View view) {
        this.a.finish();
    }
}
