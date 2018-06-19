package com.xunlei.downloadprovider.personal.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;

/* compiled from: MessageItemFragment */
final class i implements OnClickListener {
    final /* synthetic */ MessageItemFragment a;

    i(MessageItemFragment messageItemFragment) {
        this.a = messageItemFragment;
    }

    public final void onClick(View view) {
        this.a.q.dismiss();
        MessageInfo messageInfo = (MessageInfo) this.a.q.f;
        if (messageInfo == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        q.a("cancel", String.valueOf(messageInfo.getId()), messageInfo.getSourceId(), this.a.w, messageInfo.getType());
    }
}
