package com.xunlei.downloadprovider.dialog.quit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.frame.g;

/* compiled from: QuitAppDialogFragment */
final class f implements OnClickListener {
    final /* synthetic */ QuitAppDialogFragment a;

    f(QuitAppDialogFragment quitAppDialogFragment) {
        this.a = quitAppDialogFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.a("confirm", this.a.b, this.a.c, this.a.d, false);
        dialogInterface.dismiss();
        QuitAppDialogFragment.d(this.a);
    }
}
