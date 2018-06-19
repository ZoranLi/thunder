package com.xunlei.downloadprovider.download.create;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.xllib.android.b;

/* compiled from: BaseBtFileExplorerActivity */
final class g implements OnClickListener {
    final /* synthetic */ BaseBtFileExplorerActivity a;

    g(BaseBtFileExplorerActivity baseBtFileExplorerActivity) {
        this.a = baseBtFileExplorerActivity;
    }

    public final void onClick(View view) {
        if (BaseBtFileExplorerActivity.e(this.a).size() == null) {
            XLToast.showToast(this.a.getApplicationContext(), "请至少选择一个文件");
        } else if (b.a(this.a) == null) {
            this.a.d();
        } else if (b.e(this.a) != null) {
            view = this.a;
            if (view.f != null) {
                view.f.dismiss();
                view.f = null;
            }
            view.f = new XLAlertDialog(view);
            view.f.setMessage(view.getString(R.string.net_change_mobile_createtask_tips));
            view.f.setConfirmButtonText(view.getString(R.string.net_change_confirm_createtask));
            view.f.setCancelButtonText(view.getString(R.string.net_change_close));
            view.f.setCanceledOnTouchOutside(true);
            view.f.setCancelButtonHidden(true);
            view.f.setOnClickConfirmButtonListener(new h(view));
            view.f.setOnClickCancelButtonListener(new i(view));
            view.f.show();
        } else {
            this.a.d();
        }
    }
}
