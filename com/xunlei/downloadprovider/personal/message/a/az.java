package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.c;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.personal.message.e.a;

/* compiled from: WebsiteCommentViewHolder */
public final class az extends g {
    private au c = null;

    public az(View view, a aVar) {
        super(view, R.layout.fragment_message_center_website_content, aVar);
        a();
        b();
    }

    protected final void a() {
        super.a();
        this.c = new au();
        this.c.a(this.itemView);
    }

    protected final void b() {
        super.b();
        this.c.a.setOnClickListener(new ba(this));
    }

    public final void a(MessageInfo messageInfo) {
        super.a(messageInfo);
        if (messageInfo.isSiteStatusError()) {
            this.c.a(2);
            this.c.c.setText(messageInfo.getSiteErrorTextMsg());
            return;
        }
        this.c.a(1);
        c.a(this.c.a.getContext(), messageInfo.getWebsiteInfo().g, this.c.a);
        this.c.b.setImageResource(R.drawable.ic_message_center_mark_website);
    }
}
