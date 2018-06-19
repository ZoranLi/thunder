package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.view;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.f;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.h;

/* compiled from: ChatDialogFollowAlertView */
final class b implements c<Boolean> {
    final /* synthetic */ ChatDialogFollowAlertView a;

    b(ChatDialogFollowAlertView chatDialogFollowAlertView) {
        this.a = chatDialogFollowAlertView;
    }

    public final void a(com.xunlei.downloadprovider.personal.message.chat.b bVar) {
        com.xunlei.downloadprovider.personal.message.chat.personalchat.c.a(this.a.c, this.a.d, false, bVar.a);
        XLToast.showToast(BrothersApplication.getApplicationInstance(), this.a.getResources().getString(R.string.personal_chat_dialog_follow_fail));
        this.a.a.setEnabled(true);
    }

    public final /* synthetic */ void a(Object obj) {
        com.xunlei.downloadprovider.personal.message.chat.personalchat.c.a(this.a.c, this.a.d, true, 0);
        this.a.c.setFollow(true);
        if (h.d() != null) {
            f.a().a(this.a.c);
        }
        this.a.a.setText(R.string.personal_chat_dialog_follow_alert_followed);
        this.a.e.sendEmptyMessageDelayed(1000, 1000);
    }
}
