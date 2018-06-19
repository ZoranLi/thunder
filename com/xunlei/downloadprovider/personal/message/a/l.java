package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;

/* compiled from: BaseCommentViewHolder */
final class l implements OnClickListener {
    final /* synthetic */ g a;

    l(g gVar) {
        this.a = gVar;
    }

    public final void onClick(View view) {
        if (this.a.a != null) {
            view = this.a.a;
            this.a.i;
            view.a(5, this.a.b, true);
            q.a(MessageInfo.REPLY, String.valueOf(this.a.b.getId()), this.a.b.getSourceId(), "discuss_list", this.a.b.getType());
        }
    }
}
