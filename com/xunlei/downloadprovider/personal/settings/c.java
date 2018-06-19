package com.xunlei.downloadprovider.personal.settings;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadprovider.R;

/* compiled from: AboutBoxActivity */
final class c implements OnClickListener {
    final /* synthetic */ AboutBoxActivity a;

    c(AboutBoxActivity aboutBoxActivity) {
        this.a = aboutBoxActivity;
    }

    public final void onClick(View view) {
        view = new XLAlertDialog(this.a);
        view.setMessage(this.a.getString(R.string.sett_sure_call_xl));
        view.setCancelButtonText(this.a.getString(R.string.cancel));
        view.setConfirmButtonText(this.a.getString(R.string.sett_dial));
        view.setOnClickCancelButtonListener(new d(this));
        view.setOnClickConfirmButtonListener(new e(this));
        view.setCanceledOnTouchOutside(true);
        view.show();
    }
}
