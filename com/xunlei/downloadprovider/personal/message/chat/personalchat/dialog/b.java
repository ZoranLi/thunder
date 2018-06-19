package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog;

import com.xunlei.common.androidutil.HandlerUtil$MessageListener;
import com.xunlei.common.androidutil.HandlerUtil$StaticHandler;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.e;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* compiled from: MessageSendFrequencyLimiter */
public final class b {
    public static b a;
    public static final long b = TimeUnit.MINUTES.toMillis(2);
    public static final long c = TimeUnit.MINUTES.toMillis(3);
    public Map<Long, Integer> d;
    public Map<Long, Integer> e;
    public Set<Long> f;
    public HandlerUtil$StaticHandler g;
    private HandlerUtil$MessageListener h;

    private b() {
        this.d = null;
        this.e = null;
        this.f = null;
        this.h = new c(this);
        this.g = new HandlerUtil$StaticHandler(this.h);
        this.e = new HashMap();
        this.d = new HashMap();
        this.f = new HashSet();
    }

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    public final void a(List<IChatMessage> list) {
        for (IChatMessage iChatMessage : list) {
            if (!e.a(iChatMessage)) {
                long userId = iChatMessage.chatDialog().targetUser().userId();
                if (b(userId) || a(userId)) {
                    Integer num = (Integer) this.d.get(Long.valueOf(userId));
                    if (iChatMessage.createdAt() > (num != null ? num.intValue() : 0)) {
                        a(iChatMessage);
                    }
                }
            }
        }
    }

    public final void a(IChatMessage iChatMessage) {
        long userId = iChatMessage.chatDialog().targetUser().userId();
        d(userId);
        c(userId);
        this.g.removeMessages(1000, Long.valueOf(userId));
        this.g.removeMessages(1001, Long.valueOf(userId));
    }

    public final boolean a(long j) {
        return this.f.contains(Long.valueOf(j));
    }

    public final boolean b(long j) {
        return this.e.containsKey(Long.valueOf(j));
    }

    private void c(long j) {
        this.f.remove(Long.valueOf(j));
    }

    private void d(long j) {
        this.e.remove(Long.valueOf(j));
        this.d.remove(Long.valueOf(j));
    }
}
