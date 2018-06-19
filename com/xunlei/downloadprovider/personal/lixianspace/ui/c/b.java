package com.xunlei.downloadprovider.personal.lixianspace.ui.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.lixianspace.c.a;
import com.xunlei.downloadprovider.personal.lixianspace.ui.LXSpaceCreateBtTaskActivity;
import com.xunlei.downloadprovider.personal.lixianspace.ui.LXSpaceCreateUrlTaskActivity;

/* compiled from: LXSpaceCreateTaskDlg */
final class b implements OnClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        switch (view.getId()) {
            case R.id.lx_space_create_url_task_btn:
                LXSpaceCreateUrlTaskActivity.a(this.a.getContext());
                a.b("link");
                this.a.dismiss();
                return;
            case R.id.lx_space_create_bt_task_btn:
                LXSpaceCreateBtTaskActivity.a(this.a.getContext());
                a.b("bt");
                this.a.dismiss();
                return;
            case R.id.lx_space_create_task_cancel_btn:
                a.b("cancel");
                this.a.dismiss();
                break;
            default:
                break;
        }
    }
}
