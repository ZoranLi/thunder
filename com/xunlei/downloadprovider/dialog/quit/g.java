package com.xunlei.downloadprovider.dialog.quit;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.thunder.commonui.dialog.b;

/* compiled from: QuitAppDialogFragment */
final class g implements OnClickListener {
    final /* synthetic */ b a;
    final /* synthetic */ QuitAppDialogFragment b;

    g(QuitAppDialogFragment quitAppDialogFragment, b bVar) {
        this.b = quitAppDialogFragment;
        this.a = bVar;
    }

    public final void onClick(View view) {
        com.xunlei.downloadprovider.frame.g.a("sign", this.b.b, this.b.c, this.b.d, false);
        this.a.dismiss();
        QuitAppDialogFragment.f(this.b);
    }
}
