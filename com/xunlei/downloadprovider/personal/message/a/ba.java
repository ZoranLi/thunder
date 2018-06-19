package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: WebsiteCommentViewHolder */
final class ba implements OnClickListener {
    final /* synthetic */ az a;

    ba(az azVar) {
        this.a = azVar;
    }

    public final void onClick(View view) {
        if (this.a.a != null) {
            view = this.a.a;
            this.a.c;
            view.a(3, this.a.b, true);
            q.a("discuss_content", String.valueOf(this.a.b.getId()), this.a.b.getSourceId(), "discuss_list", this.a.b.getType());
        }
    }
}
