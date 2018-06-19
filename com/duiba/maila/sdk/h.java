package com.duiba.maila.sdk;

import android.view.View;
import android.view.View.OnClickListener;

final class h implements OnClickListener {
    final /* synthetic */ MailaActivityInSdk a;

    h(MailaActivityInSdk mailaActivityInSdk) {
        this.a = mailaActivityInSdk;
    }

    public final void onClick(View view) {
        this.a.c = false;
        this.a.a.reload();
    }
}
