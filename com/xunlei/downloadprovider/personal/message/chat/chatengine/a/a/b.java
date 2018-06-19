package com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a;

import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.q;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.a;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.g;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ChatDatabaseCacher */
public final class b {
    private static b a;

    private b() {
    }

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    public final void a(IChatDialog iChatDialog) {
        q.a().execute(new g(this, iChatDialog));
    }

    public final void a(List<IChatMessage> list) {
        if (!list.isEmpty()) {
            q.a().execute(new i(this, new ArrayList(list)));
        }
    }

    public static g a(i iVar) {
        try {
            if (!o.b()) {
                return new com.xunlei.downloadprovider.personal.message.chat.chatengine.model.b();
            }
            List arrayList;
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder("queryDialogsFromCache. query: ");
            stringBuilder.append(iVar);
            stringBuilder.append(" startTime: ");
            stringBuilder.append(currentTimeMillis);
            l lVar = new l(o.a());
            lVar.a();
            StringBuilder stringBuilder2 = new StringBuilder("queryDialogsFromCache. query: ");
            stringBuilder2.append(iVar);
            stringBuilder2.append(" openDataBase: ");
            stringBuilder2.append(System.currentTimeMillis() - currentTimeMillis);
            if (o.b()) {
                String a;
                arrayList = new ArrayList();
                int i = iVar.a;
                if (i == 2) {
                    a = l.a(0, 0, b.c);
                } else if (i == 3) {
                    a = l.a(1, 1, b.d);
                } else if (i == 1) {
                    a = "";
                }
                if (iVar.b()) {
                    stringBuilder2 = new StringBuilder();
                    if (iVar.b > 0) {
                        stringBuilder2.append("a.created_at > ");
                        stringBuilder2.append(iVar.b);
                        stringBuilder2.append(b.c);
                    }
                    if (iVar.c > 0) {
                        stringBuilder2.append("a.created_at < ");
                        stringBuilder2.append(iVar.c);
                        stringBuilder2.append(b.c);
                    }
                    new StringBuilder("time limit sql: ").append(stringBuilder2.toString());
                    StringBuilder stringBuilder3 = new StringBuilder("SELECT * FROM chat_message a LEFT join chat_message b ON a.dialog_id = b.dialog_id AND a.created_at < b.created_at AND a.status = b.status WHERE ");
                    stringBuilder3.append(stringBuilder2.toString());
                    stringBuilder3.append(" 1 = 1  GROUP BY a.dialog_id, a.message_id, a.status HAVING COUNT(b.message_id) < 1 ORDER BY a.created_at DESC");
                    String stringBuilder4 = stringBuilder3.toString();
                    stringBuilder3 = new StringBuilder("select t2.dialog_id as dialog_id, t2.name as dialog_name, t2.unread_count as unread_count, t2.type as dialog_type, t2.sync_time as sync_time, t1.message_id as message_id, t1.sender_id as message_sender_id, t1.content as message_content, t1.type as message_content_type, t1.created_at as message_created_at, t1.status as message_status, t3.is_blocking as is_blocking, t3.is_follow as is_follow, t3.send_before as send_before , t4.user_id as user_id, t4.nickname as nickname, t4.gender as gender, t4.avatar_url as avatar_url, t4.kind as kind, t4.raw_version as raw_version, t4.raw as raw  FROM  (");
                    stringBuilder3.append(stringBuilder4);
                    stringBuilder3.append(") t1 LEFT JOIN chat_dialog t2 ON t1.dialog_id = t2.dialog_id LEFT JOIN chat_relation t3 ON t1. dialog_id = t3. dialog_id LEFT JOIN chat_user t4 ON t3.member2 = t4.user_id");
                    stringBuilder3.append(a);
                    stringBuilder3.append(" ORDER BY t1.created_at DESC ");
                    stringBuilder3.append(iVar.a());
                    arrayList = lVar.a(stringBuilder3.toString());
                }
            } else {
                arrayList = Collections.emptyList();
            }
            StringBuilder stringBuilder5 = new StringBuilder("queryDialogsFromCache. query: ");
            stringBuilder5.append(iVar);
            stringBuilder5.append(" end: ");
            stringBuilder5.append(System.currentTimeMillis());
            stringBuilder5.append(" spend: ");
            stringBuilder5.append(System.currentTimeMillis() - currentTimeMillis);
            lVar.b();
            return a.a(arrayList);
        } catch (i iVar2) {
            iVar2.printStackTrace();
            return new com.xunlei.downloadprovider.personal.message.chat.chatengine.model.b();
        }
    }

    public static List<IChatMessage> a(IChatDialog iChatDialog, i iVar) {
        try {
            if (!o.b()) {
                return Collections.emptyList();
            }
            m mVar = new m(o.a());
            mVar.a();
            iChatDialog = mVar.a(iChatDialog, iVar);
            mVar.b();
            return iChatDialog;
        } catch (IChatDialog iChatDialog2) {
            iChatDialog2.printStackTrace();
            return Collections.emptyList();
        }
    }
}
