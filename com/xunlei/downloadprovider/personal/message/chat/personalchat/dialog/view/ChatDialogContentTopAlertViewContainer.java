package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.view.q.a;

public class ChatDialogContentTopAlertViewContainer extends FrameLayout implements a {
    ChatDialogFollowAlertView a = null;
    IChatDialog b = null;
    String c = null;
    private View d = null;

    public ChatDialogContentTopAlertViewContainer(@NonNull Context context) {
        super(context);
    }

    public ChatDialogContentTopAlertViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChatDialogContentTopAlertViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
    }

    public void setChatDialog(IChatDialog iChatDialog) {
        this.b = iChatDialog;
    }

    public void setFrom(String str) {
        this.c = str;
    }

    void setSingleAlertView(View view) {
        if (view != null) {
            this.d = view;
            removeAllViews();
            addView(this.d, new LayoutParams(-1, -2));
        }
    }

    public final void a() {
        setVisibility(8);
    }
}
