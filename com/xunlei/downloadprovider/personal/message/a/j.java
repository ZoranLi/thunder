package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: BaseCommentViewHolder */
final class j implements OnClickListener {
    final /* synthetic */ g a;

    j(g gVar) {
        this.a = gVar;
    }

    public final void onClick(View view) {
        if (this.a.a != null) {
            view = this.a.a;
            this.a.e;
            view.a(1, this.a.b, true);
            q.a("head_icon", String.valueOf(this.a.b.getId()), this.a.b.getSourceId(), "discuss_list", this.a.b.getType());
        }
    }
}
