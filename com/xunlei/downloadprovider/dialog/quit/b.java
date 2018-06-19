package com.xunlei.downloadprovider.dialog.quit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.common.commonview.dialog.XLCheckBoxDialog;
import com.xunlei.downloadprovider.frame.g;

/* compiled from: QuitAppDialogFragment */
final class b implements OnClickListener {
    final /* synthetic */ XLCheckBoxDialog a;
    final /* synthetic */ QuitAppDialogFragment b;

    b(QuitAppDialogFragment quitAppDialogFragment, XLCheckBoxDialog xLCheckBoxDialog) {
        this.b = quitAppDialogFragment;
        this.a = xLCheckBoxDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.a("confirm", this.b.b, false, this.b.d, this.a.getChecked());
        dialogInterface.dismiss();
        if (this.a.getChecked() != null) {
            QuitAppDialogFragment.c(this.b);
        } else {
            QuitAppDialogFragment.d(this.b);
        }
    }
}
