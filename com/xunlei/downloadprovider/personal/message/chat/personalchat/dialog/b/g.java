package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.b;

import android.os.Message;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog.b;

/* compiled from: DialogTransmitterPresenter */
final class g implements c<IChatMessage> {
    final /* synthetic */ IChatMessage a;
    final /* synthetic */ f b;

    g(f fVar, IChatMessage iChatMessage) {
        this.b = fVar;
        this.a = iChatMessage;
    }

    public final /* synthetic */ void a(Object obj) {
        IChatMessage iChatMessage = (IChatMessage) obj;
        if (!this.b.c) {
            new StringBuilder("sendTextMessage. onSuccess: ").append(iChatMessage.toString());
            int i = 0;
            com.xunlei.downloadprovider.personal.message.chat.personalchat.c.a(this.a, this.b.b, true, 0);
            obj = b.a();
            IChatUser targetUser = this.a.chatDialog().targetUser();
            IChatMessage iChatMessage2 = this.a;
            if (!obj.b(targetUser.userId())) {
                obj.d.put(Long.valueOf(targetUser.userId()), Integer.valueOf(iChatMessage2.createdAt()));
                Message obtainMessage = obj.g.obtainMessage(1000);
                obtainMessage.obj = Long.valueOf(targetUser.userId());
                obj.g.sendMessageDelayed(obtainMessage, b.b);
            }
            Integer num = (Integer) obj.e.get(Long.valueOf(targetUser.userId()));
            if (num != null) {
                i = num.intValue();
            }
            i++;
            StringBuilder stringBuilder = new StringBuilder("messageSent. userId: ");
            stringBuilder.append(targetUser.userId());
            stringBuilder.append(" messageSentCount: ");
            stringBuilder.append(i);
            obj.e.put(Long.valueOf(targetUser.userId()), Integer.valueOf(i));
        }
    }

    public final void a(com.xunlei.downloadprovider.personal.message.chat.b bVar) {
        if (!this.b.c) {
            new StringBuilder("sendTextMessage. onFail. errorInfo: ").append(bVar);
            if (bVar.a == 1000) {
                if (bVar.b == 2) {
                    this.b.a.a((int) R.string.personal_chat_dialog_message_send_new_user_forbid);
                }
            }
            com.xunlei.downloadprovider.personal.message.chat.personalchat.c.a(this.a, this.b.b, false, bVar.a);
        }
    }
}
