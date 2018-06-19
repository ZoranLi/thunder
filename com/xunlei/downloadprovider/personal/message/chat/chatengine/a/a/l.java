package com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.alipay.sdk.cons.c;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.a;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.u;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.e;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.ChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.ChatUser;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.SingleChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ChatDialogTable */
public final class l extends a {
    protected final String c() {
        return "chat_dialog";
    }

    public l(o oVar) {
        super(oVar);
    }

    protected final List<q> d() {
        List<q> arrayList = new ArrayList();
        q qVar = new q("dialog_id", "INTEGER");
        qVar.c = true;
        qVar.d = false;
        q qVar2 = new q(c.e, "TEXT");
        qVar2.d = false;
        q qVar3 = new q("type", "INTEGER");
        qVar3.d = false;
        q qVar4 = new q("unread_count", "INTEGER");
        qVar4.d = false;
        q qVar5 = new q("sync_time", "INTEGER");
        qVar5.d = false;
        arrayList.add(qVar);
        arrayList.add(qVar2);
        arrayList.add(qVar3);
        arrayList.add(qVar4);
        arrayList.add(qVar5);
        return arrayList;
    }

    static String a(int i, int i2, String str) {
        StringBuilder stringBuilder = new StringBuilder(" WHERE t3.is_follow = ");
        stringBuilder.append(i);
        stringBuilder.append(" ");
        stringBuilder.append(str);
        stringBuilder.append(" t3.send_before = ");
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }

    @NonNull
    final List<IChatDialog> a(String str) {
        if (!o.b()) {
            return Collections.emptyList();
        }
        List<IChatDialog> arrayList = new ArrayList();
        str = this.d.rawQuery(str, null);
        if (str != null) {
            Collection<SingleChatDialog> arrayList2 = new ArrayList();
            while (str.moveToNext()) {
                if (str.getInt(str.getColumnIndex("dialog_type")) == 1) {
                    int i = str.getInt(str.getColumnIndex("dialog_id"));
                    for (SingleChatDialog singleChatDialog : arrayList2) {
                        if (singleChatDialog.dialogId() == i) {
                            break;
                        }
                    }
                    SingleChatDialog singleChatDialog2 = null;
                    if (singleChatDialog2 == null) {
                        singleChatDialog2 = u.a().c().b(i);
                    }
                    IChatUser chatUser = new ChatUser();
                    IChatMessage chatMessage = new ChatMessage();
                    chatUser.setUserId(str.getLong(str.getColumnIndex(SocializeConstants.TENCENT_UID)));
                    chatUser.setGender(str.getString(str.getColumnIndex("gender")));
                    chatUser.setKind(str.getString(str.getColumnIndex("kind")));
                    chatUser.setNickname(str.getString(str.getColumnIndex("nickname")));
                    chatUser.setAvatarUrl(str.getString(str.getColumnIndex("avatar_url")));
                    chatUser.setRaw(str.getInt(str.getColumnIndex("raw_version")), str.getString(str.getColumnIndex(ShareConstants.DEXMODE_RAW)));
                    long j = str.getLong(str.getColumnIndex("message_id"));
                    chatMessage.setMessageId(j);
                    chatMessage.setLocalMessageId(j);
                    IChatUser a = e.a(str.getLong(str.getColumnIndex("message_sender_id")), chatUser, a.a().a);
                    if (a != null) {
                        chatMessage.setSender(a);
                        chatMessage.setMessageContent(d.a().a(a, chatUser, str.getInt(str.getColumnIndex("message_content_type")), str.getString(str.getColumnIndex("message_content"))));
                        chatMessage.setStatus(str.getInt(str.getColumnIndex("message_status")));
                        chatMessage.setCreateAt(str.getInt(str.getColumnIndex("message_created_at")));
                        chatMessage.setCreatorType(1);
                        chatMessage.setChatDialog(singleChatDialog2);
                        singleChatDialog2.setDialogId(i);
                        if (com.xunlei.downloadprovider.personal.message.chat.chatengine.d.d.a(chatMessage)) {
                            singleChatDialog2.setSyncTime((long) chatMessage.createdAt());
                        }
                        if (o.b()) {
                            singleChatDialog2.tryUpdateAllLastMessage(chatMessage);
                        }
                        singleChatDialog2.setUnreadCount(str.getInt(str.getColumnIndex("unread_count")));
                        singleChatDialog2.setBlocking(n.a(str.getInt(str.getColumnIndex("is_blocking"))));
                        singleChatDialog2.setFollow(n.a(str.getInt(str.getColumnIndex("is_follow"))));
                        singleChatDialog2.setSendBefore(n.a(str.getInt(str.getColumnIndex("send_before"))));
                        singleChatDialog2.setTargetUser(chatUser);
                        arrayList2.add(singleChatDialog2);
                    }
                }
            }
            arrayList.addAll(arrayList2);
            if (!str.isClosed()) {
                str.close();
            }
        }
        return arrayList;
    }

    public final boolean a(List<IChatDialog> list) {
        if (!o.b()) {
            return null;
        }
        if (o.b()) {
            JSONArray jSONArray = new JSONArray();
            for (IChatDialog b : list) {
                JSONObject b2 = b(b);
                if (b2 != null) {
                    jSONArray.put(b2);
                }
            }
            list = jSONArray;
        } else {
            list = null;
        }
        return a((JSONArray) list);
    }

    public final boolean a(IChatDialog iChatDialog) {
        if (o.b()) {
            return a((JSONObject) b(iChatDialog));
        }
        return null;
    }

    @Nullable
    private static JSONObject b(IChatDialog iChatDialog) {
        if (!o.b() || iChatDialog == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dialog_id", iChatDialog.dialogId());
            jSONObject.put(c.e, iChatDialog.getTitle());
            jSONObject.put("type", iChatDialog.type());
            jSONObject.put("unread_count", iChatDialog.getUnreadCount());
            jSONObject.put("sync_time", iChatDialog.syncTime());
            return jSONObject;
        } catch (IChatDialog iChatDialog2) {
            iChatDialog2.printStackTrace();
            return null;
        }
    }

    public final int a(int i) {
        switch (i) {
            case 2:
                i = new StringBuilder(" and (is_follow == 0 AND send_before == 0)").toString();
                break;
            case 3:
                i = new StringBuilder(" and (is_follow == 1 OR send_before == 1)").toString();
                break;
            default:
                i = "";
                break;
        }
        StringBuilder stringBuilder = new StringBuilder("select sum(t1.unread_count) from chat_dialog t1  left join chat_relation t2  where t1.dialog_id == t2.dialog_id");
        stringBuilder.append(i);
        i = this.d.rawQuery(stringBuilder.toString(), null);
        int i2 = 0;
        if (i != 0) {
            try {
                if (i.getCount() > 0) {
                    int i3 = 0;
                    while (i.moveToNext()) {
                        if (i.getColumnCount() > 0) {
                            i3 = i.getInt(0);
                        }
                    }
                    i2 = i3;
                }
            } catch (Throwable th) {
                if (!(i == 0 || i.isClosed())) {
                    i.close();
                }
            }
        }
        if (!(i == 0 || i.isClosed())) {
            i.close();
        }
        return i2;
    }
}
