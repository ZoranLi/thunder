package com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;

/* compiled from: ChatDatabaseCacher */
public final class k implements Runnable {
    final /* synthetic */ IChatDialog a;
    final /* synthetic */ b b;

    public k(b bVar, IChatDialog iChatDialog) {
        this.b = bVar;
        this.a = iChatDialog;
    }

    public final void run() {
        try {
            if (o.b()) {
                m mVar = new m(o.a());
                mVar.a();
                l lVar = new l(o.a());
                lVar.a();
                n nVar = new n(o.a());
                nVar.a();
                p pVar = new p(o.a());
                pVar.a();
                int dialogId = this.a.dialogId();
                if (o.b()) {
                    lVar.a("dialog_id=?", new String[]{String.valueOf(dialogId)});
                }
                dialogId = this.a.dialogId();
                if (o.b()) {
                    mVar.a("dialog_id=?", new String[]{String.valueOf(dialogId)});
                }
                dialogId = this.a.dialogId();
                if (o.b()) {
                    nVar.a("dialog_id=?", new String[]{String.valueOf(dialogId)});
                }
                long userId = this.a.targetUser().userId();
                if (o.b()) {
                    pVar.a("user_id=?", new String[]{String.valueOf(userId)});
                }
                mVar.b();
                lVar.b();
                nVar.b();
                pVar.b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
