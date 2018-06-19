package com.xunlei.downloadprovider.personal.message.data;

import com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.personal.message.data.vo.a;
import java.util.List;

/* compiled from: MessageDataListener */
public interface f {
    void a(long j, MessageType messageType, boolean z);

    void a(a aVar, boolean z, MessageType messageType);

    void a(List<MessageInfo> list, boolean z, MessageType messageType);
}
