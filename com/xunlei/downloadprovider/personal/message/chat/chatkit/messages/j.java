package com.xunlei.downloadprovider.personal.message.chat.chatkit.messages;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessageContent.IChatCustomMessageContent;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;

/* compiled from: MessageListType */
public final class j {
    public static int a(IChatMessage iChatMessage) {
        int type = iChatMessage.messageContent().type();
        switch (type) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                switch (((IChatCustomMessageContent) iChatMessage.messageContent()).customType()) {
                    case 1:
                        return 1001;
                    case 2:
                        return 1002;
                    case 3:
                        return 1003;
                    default:
                        break;
                }
            default:
                switch (type) {
                    case 1001:
                        break;
                    case 1002:
                        return PushResult.UNFINISH_DOWNLOAD_NOTICE;
                    default:
                        return PushResult.UNFINISH_DOWNLOAD_NOTICE;
                }
        }
        return PushResult.OFFLINE_DOWNLOAD_DONE;
    }
}
