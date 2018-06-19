package com.xunlei.downloadprovider.personal.message.chat.chatengine.a.a;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.a;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.d.e;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.ChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.d;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ChatMessageTable */
public final class m extends a {
    protected final String c() {
        return "chat_message";
    }

    public m(o oVar) {
        super(oVar);
    }

    protected final List<q> d() {
        List<q> arrayList = new ArrayList();
        q qVar = new q("message_id", "INTEGER");
        qVar.c = true;
        qVar.d = false;
        q qVar2 = new q("dialog_id", "INTEGER");
        qVar2.c = true;
        qVar2.d = false;
        q qVar3 = new q("sender_id", "INTEGER");
        qVar3.d = false;
        q qVar4 = new q("content", "TEXT");
        qVar4.d = false;
        q qVar5 = new q("type", "INTEGER");
        qVar5.d = false;
        q qVar6 = new q("created_at", "INTEGER");
        qVar6.d = false;
        q qVar7 = new q("status", "SMALLINT");
        qVar7.d = false;
        arrayList.add(qVar);
        arrayList.add(qVar2);
        arrayList.add(qVar3);
        arrayList.add(qVar4);
        arrayList.add(qVar5);
        arrayList.add(qVar6);
        arrayList.add(qVar7);
        return arrayList;
    }

    public final List<IChatMessage> a(IChatDialog iChatDialog, i iVar) {
        if (!o.b()) {
            return Collections.emptyList();
        }
        new StringBuilder("getChatMessages queryParams: ").append(iVar.toString());
        List<IChatMessage> arrayList = new ArrayList();
        if (!iVar.b()) {
            return arrayList;
        }
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder(" WHERE dialog_id = ");
        stringBuilder2.append(iChatDialog.dialogId());
        StringBuilder stringBuilder3 = new StringBuilder(stringBuilder2.toString());
        String str = "created_at";
        StringBuilder stringBuilder4 = new StringBuilder();
        if (iVar.b > 0) {
            StringBuilder stringBuilder5 = new StringBuilder(b.c);
            stringBuilder5.append(str);
            stringBuilder5.append(" > ");
            stringBuilder5.append(iVar.b);
            stringBuilder = stringBuilder5.toString();
        } else {
            stringBuilder = "";
        }
        stringBuilder4.append(stringBuilder);
        if (iVar.c > 0) {
            stringBuilder5 = new StringBuilder(b.c);
            stringBuilder5.append(str);
            stringBuilder5.append(" < ");
            stringBuilder5.append(iVar.c);
            str = stringBuilder5.toString();
        } else {
            str = "";
        }
        stringBuilder4.append(str);
        new StringBuilder("selection: ").append(stringBuilder4.toString());
        stringBuilder3.append(stringBuilder4.toString());
        new StringBuilder("selection: ").append(stringBuilder3.toString());
        iVar = iVar.a();
        SQLiteDatabase sQLiteDatabase = this.d;
        stringBuilder4 = new StringBuilder("SELECT * FROM chat_message");
        stringBuilder4.append(stringBuilder3.toString());
        stringBuilder4.append(" ORDER BY created_at DESC ");
        stringBuilder4.append(iVar);
        iVar = sQLiteDatabase.rawQuery(stringBuilder4.toString(), null);
        a(arrayList, iChatDialog, iVar);
        iVar.close();
        return arrayList;
    }

    private static void a(List<IChatMessage> list, IChatDialog iChatDialog, Cursor cursor) {
        if (o.b()) {
            while (cursor.moveToNext()) {
                ChatMessage chatMessage = new ChatMessage();
                long j = cursor.getLong(cursor.getColumnIndex("message_id"));
                chatMessage.setMessageId(j);
                chatMessage.setLocalMessageId(j);
                IChatUser a = e.a(cursor.getLong(cursor.getColumnIndex("sender_id")), iChatDialog.targetUser(), a.a().a);
                if (a != null) {
                    chatMessage.setSender(a);
                    chatMessage.setCreatorType(1);
                    chatMessage.setMessageContent(d.a().a(a, iChatDialog.targetUser(), cursor.getInt(cursor.getColumnIndex("type")), cursor.getString(cursor.getColumnIndex("content"))));
                    chatMessage.setStatus(cursor.getInt(cursor.getColumnIndex("status")));
                    chatMessage.setCreateAt(cursor.getInt(cursor.getColumnIndex("created_at")));
                    chatMessage.setChatDialog(iChatDialog);
                    list.add(chatMessage);
                }
            }
        }
    }

    static JSONObject a(IChatMessage iChatMessage) {
        if (!o.b() || iChatMessage == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message_id", iChatMessage.messageId());
            jSONObject.put("dialog_id", iChatMessage.chatDialog().dialogId());
            jSONObject.put("sender_id", iChatMessage.sender().userId());
            jSONObject.put("type", iChatMessage.messageContent().type());
            jSONObject.put("content", iChatMessage.messageContent().content());
            jSONObject.put("created_at", iChatMessage.createdAt());
            jSONObject.put("status", iChatMessage.messageStatus());
            return jSONObject;
        } catch (IChatMessage iChatMessage2) {
            iChatMessage2.printStackTrace();
            return null;
        }
    }

    static JSONArray a(List<IChatMessage> list) {
        if (!o.b() || list == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (IChatMessage a : list) {
            JSONObject a2 = a(a);
            if (a2 != null) {
                jSONArray.put(a2);
            }
        }
        return jSONArray;
    }
}
