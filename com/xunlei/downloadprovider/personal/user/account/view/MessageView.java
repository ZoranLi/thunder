package com.xunlei.downloadprovider.personal.user.account.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class MessageView extends FrameLayout {
    private TextView a;

    public MessageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = (TextView) LayoutInflater.from(context).inflate(R.layout.user_message_view, this, true).findViewById(R.id.tv_message_num);
    }
}
