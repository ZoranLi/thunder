package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.ad;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.p;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.e;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import org.android.agoo.common.AgooConstants;

/* compiled from: ChatDialogMoreOperationPPW */
public final class c extends PopupWindow implements OnClickListener {
    IChatDialog a = null;
    a b = null;
    String c;
    private Context d;
    private View e = null;
    private View f = null;
    private TextView g = null;
    private View h = null;

    /* compiled from: ChatDialogMoreOperationPPW */
    interface a {
    }

    public c(Context context) {
        this.d = context;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.d).inflate(R.layout.personal_chat_dialog_more_operation_ppw, null);
        this.e = linearLayout.findViewById(R.id.btn_watch_info);
        this.f = linearLayout.findViewById(R.id.btn_clear_chat_messages);
        this.g = (TextView) linearLayout.findViewById(R.id.btn_block);
        this.h = linearLayout.findViewById(R.id.btn_report);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth((int) this.d.getResources().getDimension(R.dimen.personal_chat_more_operation_width));
        setHeight(-2);
        setContentView(linearLayout);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
    }

    final void a() {
        if (b()) {
            this.g.setText(R.string.personal_chat_dialog_unblock);
        } else {
            this.g.setText(R.string.personal_chat_dialog_block);
        }
    }

    public final void onClick(View view) {
        view = view.getId();
        if (view != R.id.btn_report) {
            switch (view) {
                case R.id.btn_watch_info:
                    com.xunlei.downloadprovider.personal.message.chat.personalchat.c.a(this.a, this.c, "visit");
                    dismiss();
                    e.a(this.d, this.a.targetUser(), From.PERSONAL_CHAT_DIALOG);
                    if (this.b != null) {
                        return;
                    }
                    break;
                case R.id.btn_clear_chat_messages:
                    com.xunlei.downloadprovider.personal.message.chat.personalchat.c.a(this.a, this.c, "clear");
                    if (this.b != null) {
                        return;
                    }
                    break;
                case R.id.btn_block:
                    if (b() != null) {
                        com.xunlei.downloadprovider.personal.message.chat.personalchat.c.a(this.a, this.c, "unblack");
                        ((ad) p.a(ad.class)).b(this.a, new f(this));
                    } else {
                        com.xunlei.downloadprovider.personal.message.chat.personalchat.c.a(this.a, this.c, "black");
                        ((ad) p.a(ad.class)).a(this.a, new e(this));
                    }
                    if (this.b != null) {
                        return;
                    }
                    break;
                default:
                    break;
            }
        }
        com.xunlei.downloadprovider.personal.message.chat.personalchat.c.a(this.a, this.c, AgooConstants.MESSAGE_REPORT);
        ((ad) p.a(ad.class)).c(this.a, new d(this));
    }

    private boolean b() {
        return this.a.isBlocking();
    }
}
