package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;

/* compiled from: ReplyItemViewHolder */
final class am implements OnClickListener {
    final /* synthetic */ ag a;

    am(ag agVar) {
        this.a = agVar;
    }

    public final void onClick(View view) {
        if (this.a.g != null) {
            view = this.a.g;
            this.a.b;
            view.a(5, this.a.i, true);
            q.a(MessageInfo.REPLY, String.valueOf(this.a.i.getId()), this.a.i.getSourceId(), "discuss_list", this.a.i.getType());
        }
    }
}
