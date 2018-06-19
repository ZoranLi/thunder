package com.duiba.maila.sdk;

import android.view.View;
import android.view.View.OnClickListener;

final class e implements OnClickListener {
    final /* synthetic */ MailaActivityInSdk a;

    e(MailaActivityInSdk mailaActivityInSdk) {
        this.a = mailaActivityInSdk;
    }

    public final void onClick(View view) {
        if (this.a.a.canGoBack() != null) {
            this.a.a.goBack();
        } else {
            this.a.finish();
        }
    }
}
