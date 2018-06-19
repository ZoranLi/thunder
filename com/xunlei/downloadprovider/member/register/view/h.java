package com.xunlei.downloadprovider.member.register.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.R;
import com.xunlei.xllib.android.b;

/* compiled from: VerifyCodeDialog */
final class h implements OnClickListener {
    final /* synthetic */ d a;

    h(d dVar) {
        this.a = dVar;
    }

    public final void onClick(View view) {
        if (this.a.b.length() == null) {
            a.b(this.a.getContext(), R.string.verifycode_empty);
        } else if (b.a(this.a.i) == null) {
            a.c(this.a.getContext(), R.string.verifycode_empty);
        } else {
            if (this.a.a != null) {
                this.a.a.a(this.a.b.getText().toString());
            }
        }
    }
}
