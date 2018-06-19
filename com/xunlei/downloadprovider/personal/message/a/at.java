package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;

/* compiled from: ReplyVideoItemViewHolder */
final class at implements OnClickListener {
    final /* synthetic */ an a;

    at(an anVar) {
        this.a = anVar;
    }

    public final void onClick(View view) {
        if (this.a.j != null) {
            view = this.a.j;
            this.a.h;
            view.a(5, this.a.l, true);
            q.a(MessageInfo.REPLY, String.valueOf(this.a.l.getId()), this.a.l.getSourceId(), "discuss_list", this.a.l.getType());
        }
    }
}
