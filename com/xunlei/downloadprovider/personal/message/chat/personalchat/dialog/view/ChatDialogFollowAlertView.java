package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.ad;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.p;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.c;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.view.q.a;

public class ChatDialogFollowAlertView extends RelativeLayout implements OnClickListener, q {
    private TextView a = null;
    private View b = null;
    private IChatDialog c = null;
    private String d;
    private Handler e = new Handler(new a(this));
    private a f = null;

    public ChatDialogFollowAlertView(Context context) {
        super(context);
        a();
    }

    public ChatDialogFollowAlertView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ChatDialogFollowAlertView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        inflate(getContext(), R.layout.personal_chat_dialog_alert_view_follow, this);
        setBackgroundColor(getResources().getColor(R.color.message_center_main_blue));
        setLayoutParams(new LayoutParams(-1, -2));
        this.a = (TextView) findViewById(R.id.btn_follow);
        this.b = findViewById(R.id.btn_close);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
    }

    public void setChatDialog(IChatDialog iChatDialog) {
        this.c = iChatDialog;
    }

    public void setFrom(String str) {
        this.d = str;
    }

    public void setOnAlertViewCloseListener(a aVar) {
        this.f = aVar;
    }

    public void onClick(View view) {
        view = view.getId();
        if (view != R.id.btn_follow) {
            if (view == R.id.btn_close) {
                if (this.f != null) {
                    this.f.a();
                }
            }
            return;
        }
        c.a(this.c, this.d, "follow");
        this.a.setEnabled(false);
        ((ad) p.a(ad.class)).d(this.c, new b(this));
    }
}
