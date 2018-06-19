package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import java.util.List;

/* compiled from: TaskDetailEditController */
final class ax implements OnClickListener {
    final /* synthetic */ aw a;

    ax(aw awVar) {
        this.a = awVar;
    }

    public final void onClick(View view) {
        view = this.a;
        view.a();
        if (view.a != null) {
            view.d = new XLAlertDialog(view.c.getContext());
            List a = view.a.a();
            int i = 0;
            if (a.size() == (view.a != null ? view.a.c().size() : 0)) {
                i = 1;
                view.d.setMessage((CharSequence) "删除所有子任务将删除BT任务本身，是否删除？");
            } else {
                XLAlertDialog xLAlertDialog = view.d;
                StringBuilder stringBuilder = new StringBuilder("确定删除");
                stringBuilder.append(a.size());
                stringBuilder.append("个BT子任务?");
                xLAlertDialog.setMessage(stringBuilder.toString());
            }
            view.d.setOnClickConfirmButtonListener(new bb(view, i, a));
            view.d.show();
        }
    }
}
