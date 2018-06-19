package com.xunlei.downloadprovider.personal.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.personal.message.data.q;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;

/* compiled from: MessageItemFragment */
final class k implements OnClickListener {
    final /* synthetic */ MessageItemFragment a;

    k(MessageItemFragment messageItemFragment) {
        this.a = messageItemFragment;
    }

    public final void onClick(View view) {
        MessageInfo messageInfo = (MessageInfo) this.a.p.b;
        q.a(messageInfo.getSourceId(), String.valueOf(messageInfo.getId()), this.a.A.g.e(), messageInfo.getType());
        if (r.a().a(this.a.d, LoginFrom.PERSONAL_COMMUNITY_REPLY, this.a.F) == null) {
            this.a.b();
        }
    }
}
