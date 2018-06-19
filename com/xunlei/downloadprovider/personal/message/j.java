package com.xunlei.downloadprovider.personal.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;

/* compiled from: MessageItemFragment */
final class j implements OnClickListener {
    final /* synthetic */ MessageItemFragment a;

    j(MessageItemFragment messageItemFragment) {
        this.a = messageItemFragment;
    }

    public final void onClick(View view) {
        this.a.q.dismiss();
        MessageInfo messageInfo = (MessageInfo) this.a.q.f;
        if (messageInfo == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        m.b(this.a.d, messageInfo.getUserId(), "per", messageInfo.getUserName(), messageInfo.getUserAvatar(), From.INFO_CENTER_ALTER);
        q.a("homepage", String.valueOf(messageInfo.getId()), messageInfo.getSourceId(), this.a.w, messageInfo.getType());
    }
}
