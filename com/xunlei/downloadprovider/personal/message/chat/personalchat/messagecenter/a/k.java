package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a;

import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import java.util.List;

/* compiled from: MessageCenterHiItemInfo */
public final class k extends a implements d {
    public int a;
    private List<b> b;

    public final int getCategoryPriority() {
        return 100;
    }

    public final int getId() {
        return 0;
    }

    public final int getItemType() {
        return 2;
    }

    public final String getTitle() {
        return "打招呼";
    }

    public k() {
        this.b = null;
        this.a = 0;
        this.b = f.a().b(2);
    }

    public final int getUnreadCount() {
        return this.a;
    }

    public final int getUpdateTime() {
        IChatMessage b = b();
        return b != null ? b.createdAt() : 0;
    }

    public static Integer a() {
        return Integer.valueOf(R.drawable.icon_message_center_stranger);
    }

    public final int compareTo(b bVar) {
        int compareTo = super.compareTo(bVar);
        if (compareTo != 0) {
            return compareTo;
        }
        if (bVar instanceof d) {
            return ((d) bVar).getUpdateTime() - getUpdateTime();
        }
        return 1;
    }

    public final IChatMessage b() {
        IChatDialog iChatDialog;
        if (this.b != null) {
            for (b bVar : this.b) {
                if (bVar instanceof IChatDialog) {
                    iChatDialog = (IChatDialog) bVar;
                    break;
                }
            }
        }
        iChatDialog = null;
        if (iChatDialog != null) {
            return iChatDialog.lastMessage();
        }
        return null;
    }
}
