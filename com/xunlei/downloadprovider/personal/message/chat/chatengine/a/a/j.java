package com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a;

import android.database.SQLException;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChatDatabaseCacher */
public final class j implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ b b;

    public j(b bVar, List list) {
        this.b = bVar;
        this.a = list;
    }

    public final void run() {
        try {
            if (o.b()) {
                List arrayList = new ArrayList(this.a.size());
                for (IChatMessage chatDialog : this.a) {
                    arrayList.add(chatDialog.chatDialog());
                }
                m mVar = new m(o.a());
                mVar.a();
                l lVar = new l(o.a());
                lVar.a();
                n nVar = new n(o.a());
                nVar.a();
                p pVar = new p(o.a());
                pVar.a();
                for (IChatMessage iChatMessage : this.a) {
                    if (o.b()) {
                        try {
                            int a = mVar.a(m.a(iChatMessage), "message_id = ? OR message_id = ? AND dialog_id = ?", new String[]{String.valueOf(iChatMessage.localMessageId()), String.valueOf(iChatMessage.messageId()), String.valueOf(iChatMessage.chatDialog().dialogId())});
                            StringBuilder stringBuilder = new StringBuilder("updateChatMessage messageId: ");
                            stringBuilder.append(iChatMessage.messageId());
                            stringBuilder.append(" localMessageId: ");
                            stringBuilder.append(iChatMessage.localMessageId());
                            stringBuilder.append(" affectRowCount: ");
                            stringBuilder.append(a);
                        } catch (SQLException e) {
                            new StringBuilder("updateChatMessage fail. e: ").append(e.getLocalizedMessage());
                            e.printStackTrace();
                        }
                    }
                }
                lVar.a(arrayList);
                nVar.a(arrayList);
                pVar.a(arrayList);
                mVar.b();
                lVar.b();
                nVar.b();
                pVar.b();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
