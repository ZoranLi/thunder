package com.xunlei.downloadprovider.personal.lixianspace.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.xllib.android.b;

/* compiled from: LXSpaceCreateTaskByMagnetUrlActivity */
final class m implements OnClickListener {
    final /* synthetic */ LXSpaceCreateTaskByMagnetUrlActivity a;

    m(LXSpaceCreateTaskByMagnetUrlActivity lXSpaceCreateTaskByMagnetUrlActivity) {
        this.a = lXSpaceCreateTaskByMagnetUrlActivity;
    }

    public final void onClick(View view) {
        if (this.a.j.size() == null) {
            XLToast.showToast(this.a.getApplicationContext(), "请至少选择一个文件");
        } else if (b.a(this.a.getApplicationContext()) == null) {
            this.a.b();
        } else if (b.e(this.a.getApplicationContext()) != null) {
            view = this.a;
            if (view.d != null) {
                view.d.dismiss();
                view.d = null;
            }
            view.d = new XLAlertDialog(view);
            view.d.setMessage(view.getString(R.string.net_change_mobile_createtask_tips));
            view.d.setConfirmButtonText(view.getString(R.string.net_change_confirm_createtask));
            view.d.setCancelButtonText(view.getString(R.string.net_change_close));
            view.d.setCanceledOnTouchOutside(true);
            view.d.setCancelButtonHidden(true);
            view.d.setOnClickConfirmButtonListener(new n(view));
            view.d.setOnClickCancelButtonListener(new o(view));
            view.d.show();
        } else {
            this.a.b();
        }
    }
}
