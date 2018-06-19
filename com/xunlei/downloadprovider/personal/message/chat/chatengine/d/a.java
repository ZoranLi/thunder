package com.xunlei.downloadprovider.personal.message.chat.chatengine.d;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import java.util.Iterator;
import java.util.List;

/* compiled from: ChatDialogHelper */
public final class a {

    /* compiled from: ChatDialogHelper */
    public interface a<T> {
        boolean a(T t);
    }

    /* compiled from: ChatDialogHelper */
    public interface b<T, Z extends T> {
        boolean a(T t, Z z);
    }

    public static boolean a(IChatDialog iChatDialog) {
        if (!iChatDialog.sendBefore()) {
            if (iChatDialog.isFollow() == null) {
                return null;
            }
        }
        return true;
    }

    public static boolean b(IChatDialog iChatDialog) {
        return (iChatDialog.isFollow() || iChatDialog.sendBefore() != null) ? null : true;
    }

    public static int c(IChatDialog iChatDialog) {
        if (iChatDialog == null || iChatDialog.lastServerMessage() == null) {
            return 0;
        }
        return iChatDialog.lastServerMessage().createdAt();
    }

    public static com.xunlei.downloadprovider.personal.message.chat.chatengine.model.b a(List<IChatDialog> list) {
        com.xunlei.downloadprovider.personal.message.chat.chatengine.model.b bVar = new com.xunlei.downloadprovider.personal.message.chat.chatengine.model.b();
        com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog.a aVar = new com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog.a();
        for (IChatDialog b : list) {
            b(bVar, b);
        }
        return bVar;
    }

    public static void a(com.xunlei.downloadprovider.personal.message.chat.chatengine.model.b bVar, IChatDialog iChatDialog) {
        com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog.a aVar = new com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog.a();
        b(bVar, iChatDialog);
    }

    private static void b(com.xunlei.downloadprovider.personal.message.chat.chatengine.model.b bVar, IChatDialog iChatDialog) {
        if (iChatDialog != null) {
            if (com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog.a.a(Integer.valueOf(3), iChatDialog)) {
                bVar.b.add(iChatDialog);
            }
            if (com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog.a.a(Integer.valueOf(2), iChatDialog)) {
                bVar.c.add(iChatDialog);
            }
            if (com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog.a.a(Integer.valueOf(1), iChatDialog)) {
                bVar.a.add(iChatDialog);
            }
        }
    }

    public static <T, Z extends T> void a(int i, List<T> list, List<Z> list2, boolean z) {
        a((List) list, (List) list2, z, new b(i));
    }

    public static <T, Z extends T> void a(List<T> list, List<Z> list2, boolean z, a<T> aVar) {
        a(list, list2, z, new c(), aVar);
    }

    public static <T, Z extends T> void a(List<T> list, List<Z> list2, boolean z, b<T, Z> bVar, a<T> aVar) {
        Object next;
        if (aVar != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                next = it.next();
                if (next == null || aVar.a(next)) {
                    it.remove();
                }
            }
        }
        if (z) {
            z = list2.size() - 1;
            while (z < false) {
                next = list2.get(z);
                if (next != null) {
                    if (aVar == null || !aVar.a(next)) {
                        int indexOf = list.indexOf(next);
                        if (indexOf != -1) {
                            if (bVar != null) {
                                bVar.a(list.get(indexOf), next);
                            }
                            list.remove(indexOf);
                        }
                        list.add(0, next);
                        z--;
                    } else {
                        return;
                    }
                }
                return;
            }
            return;
        }
        for (boolean z2 : list2) {
            if (!z2) {
                return;
            }
            if (aVar == null || !aVar.a(z2)) {
                int indexOf2 = list.indexOf(z2);
                if (indexOf2 != -1) {
                    if (bVar != null) {
                        bVar.a(list.get(indexOf2), z2);
                    }
                    list.remove(indexOf2);
                    list.add(z2);
                } else {
                    list.add(z2);
                }
            } else {
                return;
            }
        }
    }
}
