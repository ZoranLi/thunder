package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.view;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;

/* compiled from: ChatDialogMoreOperationPPW */
final class f implements c<Boolean> {
    final /* synthetic */ c a;

    f(c cVar) {
        this.a = cVar;
    }

    public final /* synthetic */ void a(Object obj) {
        if (((Boolean) obj).booleanValue() != null) {
            this.a.a();
        } else {
            XLToast.showToast(BrothersApplication.getApplicationInstance(), this.a.d.getResources().getString(R.string.personal_chat_dialog_unblock_fail));
        }
    }

    public final void a(b bVar) {
        XLToast.showToast(BrothersApplication.getApplicationInstance(), this.a.d.getResources().getString(R.string.personal_chat_dialog_unblock_fail));
    }
}
