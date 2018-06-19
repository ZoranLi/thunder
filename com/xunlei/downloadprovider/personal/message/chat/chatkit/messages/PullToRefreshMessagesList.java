package com.xunlei.downloadprovider.personal.message.chat.chatkit.messages;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.commons.BasePullToRefreshRecyclerView;

public class PullToRefreshMessagesList extends BasePullToRefreshRecyclerView<MessagesList> {
    public PullToRefreshMessagesList(Context context) {
        super(context);
    }

    public PullToRefreshMessagesList(Context context, Mode mode) {
        super(context, mode);
    }

    public PullToRefreshMessagesList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected /* synthetic */ View createRefreshableView(Context context, AttributeSet attributeSet) {
        return new MessagesList(context, attributeSet);
    }
}
