package com.xunlei.downloadprovider.personal.lixianspace.ui.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.R;

/* compiled from: LXSpaceTaskDeleteDlg */
final class j implements OnClickListener {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final void onClick(View view) {
        switch (view.getId()) {
            case R.id.lx_space_task_del_dlg_cancel_btn:
                this.a.dismiss();
                return;
            case R.id.lx_space_task_del_dlg_confirm_btn:
                if (this.a.c != null) {
                    this.a.c.a(this.a.b);
                }
                this.a.dismiss();
                break;
            default:
                break;
        }
    }
}
