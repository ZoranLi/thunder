package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: WebsiteLikeViewHolder */
final class bc implements OnClickListener {
    final /* synthetic */ bb a;

    bc(bb bbVar) {
        this.a = bbVar;
    }

    public final void onClick(View view) {
        if (this.a.a != null) {
            view = this.a.a;
            this.a.c;
            view.a(3, this.a.b, false);
            q.a("zan_content", String.valueOf(this.a.b.getId()), this.a.b.getSourceId(), "zan_list", this.a.b.getType());
        }
    }
}
