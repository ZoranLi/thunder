package com.xunlei.downloadprovider.personal.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.personal.message.data.q;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.xllib.android.b;

/* compiled from: MessageItemFragment */
final class h implements OnClickListener {
    final /* synthetic */ MessageItemFragment a;

    h(MessageItemFragment messageItemFragment) {
        this.a = messageItemFragment;
    }

    public final void onClick(View view) {
        this.a.q.dismiss();
        if (b.a(this.a.d) == null) {
            XLToast.showToast(this.a.d, "无网络连接");
            return;
        }
        MessageInfo messageInfo = (MessageInfo) this.a.q.f;
        if (messageInfo != null) {
            q.a("delete", String.valueOf(messageInfo.getId()), messageInfo.getSourceId(), this.a.w, messageInfo.getType());
            this.a.t.a(messageInfo.getMsgid(), this.a.g, this.a.w, this.a);
        }
    }
}
