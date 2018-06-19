package com.xunlei.downloadprovider.personal.message;

import android.view.View;
import android.view.View.OnClickListener;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.personal.message.data.q;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.personal.user.ReportActivity;
import org.android.agoo.common.AgooConstants;

/* compiled from: MessageItemFragment */
final class g implements OnClickListener {
    final /* synthetic */ MessageItemFragment a;

    g(MessageItemFragment messageItemFragment) {
        this.a = messageItemFragment;
    }

    public final void onClick(View view) {
        this.a.q.dismiss();
        MessageInfo messageInfo = (MessageInfo) this.a.q.f;
        if (messageInfo == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        q.a(AgooConstants.MESSAGE_REPORT, String.valueOf(messageInfo.getId()), messageInfo.getSourceId(), this.a.w, messageInfo.getType());
        ReportActivity.a(this.a.d, -1, messageInfo.getId(), messageInfo.getRelateGcid(), messageInfo.getSourceId(), DispatchConstants.OTHER);
    }
}
