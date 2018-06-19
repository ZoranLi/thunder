package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.view;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;

public class ChatDialogHeader extends RelativeLayout implements OnClickListener {
    IChatDialog a = null;
    TextView b = null;
    private ImageView c = null;
    private ImageView d = null;
    private String e = null;
    private a f = null;

    interface a extends a {
        void i();

        void j();
    }

    public void setUnreadCount(int i) {
    }

    public ChatDialogHeader(@NonNull Context context) {
        super(context);
        a();
    }

    public ChatDialogHeader(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ChatDialogHeader(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.personal_chat_dialog_header, this, true);
        this.c = (ImageView) inflate.findViewById(R.id.btn_back);
        this.b = (TextView) inflate.findViewById(R.id.tv_title);
        this.d = (ImageView) inflate.findViewById(R.id.btn_more_operation);
        setUnreadCount(0);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
    }

    public void setChatDialog(IChatDialog iChatDialog) {
        this.a = iChatDialog;
    }

    public void setFrom(String str) {
        this.e = str;
    }

    public void setOnHeaderClickListener(a aVar) {
        this.f = aVar;
    }

    public void onClick(View view) {
        view = view.getId();
        if (view != R.id.btn_back) {
            if (view == R.id.btn_more_operation) {
                if (this.f != null) {
                    this.f.j();
                }
            }
        } else if (this.f != null) {
            this.f.i();
        }
    }
}
