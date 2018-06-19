package com.xunlei.downloadprovider.personal.message.chat.chatkit.messages;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.ChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.h;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.utils.DateFormatter;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: MessagesListAdapter */
public final class k<MESSAGE extends IChatMessage> extends Adapter<com.xunlei.downloadprovider.personal.message.chat.chatkit.commons.c> {
    static boolean b;
    public List<c> a;
    public LayoutManager c;
    n d;
    public com.xunlei.downloadprovider.personal.message.chat.chatkit.utils.DateFormatter.a e;
    public long f = TimeUnit.MINUTES.toMillis(5);
    public a<IChatMessage> g = null;
    private a h;
    private String i;
    private int j;
    private b k;
    private com.xunlei.downloadprovider.personal.message.chat.chatkit.commons.a l;
    private Context m = null;

    /* compiled from: MessagesListAdapter */
    public interface a<MESSAGE extends IChatMessage> {
        void a(MESSAGE message);

        void onClick(int i, MESSAGE message);
    }

    /* compiled from: MessagesListAdapter */
    public interface b {
    }

    /* compiled from: MessagesListAdapter */
    private class c<DATA> {
        public DATA a;
        boolean b;
        final /* synthetic */ k c;

        public c(k kVar, DATA data) {
            this.c = kVar;
            this.a = data;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null) {
                if (getClass() == obj.getClass()) {
                    return this.a.equals(((c) obj).a);
                }
            }
            return null;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }
    }

    public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        com.xunlei.downloadprovider.personal.message.chat.chatkit.commons.c cVar = (com.xunlei.downloadprovider.personal.message.chat.chatkit.commons.c) viewHolder;
        c cVar2 = (c) this.a.get(i);
        Object obj = cVar2.a;
        boolean z = cVar2.b;
        com.xunlei.downloadprovider.personal.message.chat.chatkit.commons.a aVar = this.l;
        a aVar2 = this.g;
        i = new l(this, cVar2);
        i = new m(this, cVar2);
        a.a(cVar, obj, z, aVar, aVar2, this.e);
    }

    public k(Context context, String str, a aVar, com.xunlei.downloadprovider.personal.message.chat.chatkit.commons.a aVar2) {
        this.m = context;
        this.i = str;
        this.h = aVar;
        this.l = aVar2;
        this.a = new ArrayList();
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public final int getItemViewType(int i) {
        int i2;
        int contentEquals;
        a aVar = this.h;
        i = ((c) this.a.get(i)).a;
        CharSequence charSequence = this.i;
        boolean z = i instanceof IChatMessage;
        int i3 = PushResult.UNFINISH_DOWNLOAD_NOTICE;
        int i4 = 0;
        if (z) {
            e eVar;
            IChatMessage iChatMessage = (IChatMessage) i;
            if (iChatMessage.creatorType() != 2) {
                if (iChatMessage.creatorType() != 3) {
                    i2 = 0;
                    contentEquals = String.valueOf(iChatMessage.sender().userId()).contentEquals(charSequence) ^ 1;
                    iChatMessage.messageContent();
                    if (j.a(iChatMessage) != PushResult.OFFLINE_DOWNLOAD_DONE) {
                        i3 = PushResult.OFFLINE_DOWNLOAD_DONE;
                    } else {
                        while (i4 < aVar.c.size()) {
                            eVar = (e) aVar.c.get(i4);
                            if (aVar.d != null) {
                                throw new IllegalArgumentException("ContentChecker cannot be null when using custom content types!");
                            } else if (aVar.d.a(iChatMessage, eVar.a)) {
                                i3 = eVar.a;
                                break;
                            } else {
                                i4++;
                            }
                        }
                    }
                }
            }
            i2 = 1;
            contentEquals = String.valueOf(iChatMessage.sender().userId()).contentEquals(charSequence) ^ 1;
            iChatMessage.messageContent();
            if (j.a(iChatMessage) != PushResult.OFFLINE_DOWNLOAD_DONE) {
                while (i4 < aVar.c.size()) {
                    eVar = (e) aVar.c.get(i4);
                    if (aVar.d != null) {
                        if (aVar.d.a(iChatMessage, eVar.a)) {
                            i3 = eVar.a;
                            break;
                        }
                        i4++;
                    } else {
                        throw new IllegalArgumentException("ContentChecker cannot be null when using custom content types!");
                    }
                }
            }
            i3 = PushResult.OFFLINE_DOWNLOAD_DONE;
        } else {
            contentEquals = 0;
            i2 = contentEquals;
        }
        return (i2 != 0 || contentEquals == 0) ? i3 : i3 * -1;
    }

    public final boolean a(MESSAGE message) {
        boolean contains = this.a.contains(new c(this, message));
        if (contains) {
            new StringBuilder("filterReduplicateMessage. is reduplicate message: ").append(message.toString());
        }
        return contains;
    }

    public final boolean a(Date date, Date date2) {
        return Math.abs(date.getTime() - date2.getTime()) >= this.f ? true : null;
    }

    @NonNull
    public final c<IChatMessage> b(IChatMessage iChatMessage) {
        h.a();
        iChatMessage = DateFormatter.a(iChatMessage);
        ChatMessage a = h.a(true);
        a.setMessageContent(new DateHeaderMessage(iChatMessage));
        return new c(this, a);
    }

    public final int a(String str) {
        for (int i = 0; i < this.a.size(); i++) {
            c cVar = (c) this.a.get(i);
            if ((cVar.a instanceof IChatMessage) && String.valueOf(((IChatMessage) cVar.a).messageId()).contentEquals(str)) {
                return i;
            }
        }
        return -1;
    }

    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        a aVar = this.h;
        Context context = this.m;
        n nVar = this.d;
        if (i == PushResult.OFFLINE_DOWNLOAD_DONE) {
            return a.a(context, viewGroup, aVar.b, aVar.a, nVar);
        }
        for (e eVar : aVar.c) {
            if (Math.abs(eVar.a) == Math.abs(i)) {
                if (i > 0) {
                    return a.a(context, viewGroup, eVar.b, nVar);
                }
                return a.a(context, viewGroup, eVar.c, nVar);
            }
        }
        return null;
    }

    static /* synthetic */ void c(k kVar) {
        boolean z = true;
        kVar.j--;
        if (kVar.j <= null) {
            z = false;
        }
        b = z;
    }
}
