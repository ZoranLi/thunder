package com.xunlei.downloadprovider.download.taskdetails.items;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.taskdetails.subtask.BTSubTaskItem;
import com.xunlei.downloadprovider.h.e;

/* compiled from: DetailBtTaskSubFileViewHolder */
final class c implements OnClickListener {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final void onClick(View view) {
        if (this.a.f() == null) {
            BTSubTaskItem b = this.a.e();
            if (b != null) {
                boolean a = b.c(b);
                boolean b2 = b.d(b);
                boolean c = e.c(b.mLocalFileName);
                if (a && !c) {
                    return;
                }
                if (a || b2) {
                    b.a(this.a, b);
                    return;
                }
                return;
            }
            return;
        }
        view = this.a.e();
        if (view.isSelected()) {
            view.setSelected(false);
            this.a.n.setImageResource(R.drawable.big_unselected);
        } else {
            view.setSelected(true);
            this.a.n.setImageResource(R.drawable.big_selected);
        }
        if (this.a.b != null) {
            this.a.b.a();
        }
    }
}
