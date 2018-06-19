package com.xunlei.downloadprovider.personal.lixianspace.ui.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.R;

/* compiled from: LXSpaceTaskOperateDlg */
final class l implements OnClickListener {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public final void onClick(View view) {
        switch (view.getId()) {
            case R.id.lx_space_task_operate_first_btn:
                k.a(this.a);
                break;
            case R.id.lx_space_task_operate_copy_original_url_btn:
                k.b(this.a);
                break;
            case R.id.lx_space_task_operate_delete_btn:
                k.c(this.a);
                break;
            case R.id.lx_space_task_operate_cancel_btn:
                break;
            default:
                return;
        }
        this.a.dismiss();
    }
}
