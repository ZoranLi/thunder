package com.xunlei.downloadprovider.personal.message.a;

import android.text.TextUtils;
import android.view.View;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.personal.message.e.a;

/* compiled from: WebsiteCommentReplyViewHolder */
public final class ax extends g {
    private r c = null;

    public ax(View view, a aVar) {
        super(view, R.layout.fragment_message_center_comment_content, aVar);
        a();
        b();
    }

    protected final void a() {
        super.a();
        this.c = new r();
        this.c.a(this.itemView);
    }

    protected final void b() {
        super.b();
        this.c.a.setOnClickListener(new ay(this));
    }

    public final void a(MessageInfo messageInfo) {
        super.a(messageInfo);
        if (messageInfo.isSiteStatusError()) {
            this.c.a(2);
            this.c.b.setText(messageInfo.getSiteErrorTextMsg());
            return;
        }
        this.c.a(1);
        messageInfo = this.b.getTargetCommentInfo().getContent();
        if (TextUtils.isEmpty(messageInfo)) {
            this.c.a.setText("    ");
        } else {
            this.c.a.setText(messageInfo);
        }
    }
}
