package com.xunlei.downloadprovider.personal.message.chat.chatengine.c;

import android.support.annotation.Nullable;
import com.android.volley.Request;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.download.Downloads.Impl;
import com.xunlei.downloadprovider.personal.message.chat.c;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.q;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.u;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.ChatUser;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatUser;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.SingleChatDialog;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.b;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.g;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.i;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChatDialogNetwork */
public final class d extends a {
    private static d a;

    /* compiled from: ChatDialogNetwork */
    public static class a extends com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a {
        protected static com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a.a<SingleChatDialog> a(JSONObject jSONObject) {
            com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a.a<SingleChatDialog> aVar = new com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a.a();
            if (com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a.a(aVar, jSONObject)) {
                int optInt = jSONObject.optInt(Impl.COLUMN_GROUP_ID);
                if (optInt == 0) {
                    aVar.b = -1001;
                    aVar.c = "groupId invalid";
                    return aVar;
                }
                SingleChatDialog b = u.a().c().b(optInt);
                b.setDialogId(optInt);
                b.setBlocking(jSONObject.optBoolean("is_blocking", false));
                b.setFollow(jSONObject.optBoolean("is_follow", false));
                jSONObject = b(jSONObject.optJSONObject(MessageInfo.USER));
                if (jSONObject == null) {
                    aVar.b = -1001;
                    aVar.c = "chatUserInfo invalid";
                    return aVar;
                }
                b.setTargetUser(jSONObject);
                aVar.a = b;
            }
            return aVar;
        }

        @Nullable
        protected static ChatUser b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            long optLong = jSONObject.optLong("uid");
            if (optLong == 0) {
                return null;
            }
            ChatUser chatUser = new ChatUser();
            chatUser.setUserId(optLong);
            chatUser.setNickname(jSONObject.optString("nick_name", ChatUser.DEFAULT_NICK_NAME));
            chatUser.setAvatarUrl(jSONObject.optString("portrait_url"));
            chatUser.setKind(jSONObject.optString("kind"));
            chatUser.setGender(jSONObject.optString("sex", "unknown"));
            chatUser.setRaw(1, jSONObject.toString());
            return chatUser;
        }

        protected static com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a.a<b> c(JSONObject jSONObject) {
            com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a.a<b> aVar = new com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a.a();
            if (com.xunlei.downloadprovider.personal.message.chat.chatengine.c.a.a.a(aVar, jSONObject)) {
                b bVar = new b();
                jSONObject = jSONObject.optJSONArray("sessions");
                if (jSONObject != null) {
                    for (int i = 0; i < jSONObject.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONObject.getJSONObject(i);
                            IChatDialog iChatDialog = null;
                            if (jSONObject2 != null) {
                                IChatUser b = b(jSONObject2.optJSONObject("group"));
                                if (b != null) {
                                    Object a = com.xunlei.downloadprovider.personal.message.chat.chatengine.c.o.a.a(true, b, null, jSONObject2.optJSONObject("record"));
                                    if (a != null) {
                                        if (a.chatDialog() != null) {
                                            iChatDialog = (SingleChatDialog) a.chatDialog();
                                            iChatDialog.setTargetUser(b);
                                            iChatDialog.setUnreadCount(jSONObject2.optInt("unread"));
                                            iChatDialog.setFollow(jSONObject2.optBoolean("is_follow", false));
                                            iChatDialog.setSendBefore(jSONObject2.optBoolean("send_before", false));
                                            iChatDialog.tryUpdateAllLastMessage(a);
                                            iChatDialog.setSyncTime((long) a.createdAt());
                                        }
                                    }
                                }
                            }
                            com.xunlei.downloadprovider.personal.message.chat.chatengine.d.a.a(bVar, iChatDialog);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
                aVar.a = bVar;
            }
            return aVar;
        }
    }

    private d() {
    }

    public static d a() {
        if (a == null) {
            a = new d();
        }
        return a;
    }

    private static JSONObject c(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Impl.COLUMN_GROUP_ID, i);
        } catch (int i2) {
            i2.printStackTrace();
        }
        return jSONObject;
    }

    public final void a(i iVar, c<g> cVar) {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/chitchat/sessions?");
        stringBuilder.append(iVar.a(true));
        a((Request) a(null, stringBuilder.toString(), new l(this, cVar)));
    }

    private static JSONObject d(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Impl.COLUMN_GROUP_ID, i);
        } catch (int i2) {
            i2.printStackTrace();
        }
        return jSONObject;
    }

    public final void a(long j, c<SingleChatDialog> cVar) {
        q.a().execute(new e(this, cVar, j));
    }

    static /* synthetic */ JSONObject a(long j) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SocializeConstants.TENCENT_UID, j);
        return jSONObject;
    }

    static /* synthetic */ JSONObject a(long j, String str, int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SocializeConstants.TENCENT_UID, j);
        jSONObject.put("content", str);
        jSONObject.put("class", i);
        return jSONObject;
    }
}
