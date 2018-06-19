package com.xunlei.downloadprovider.personal.message.data;

import android.text.TextUtils;
import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType;
import org.json.JSONObject;

/* compiled from: MessageNetWork */
public final class j implements b<String> {
    final /* synthetic */ MessageType a;
    final /* synthetic */ g b;

    public j(g gVar, MessageType messageType) {
        this.b = gVar;
        this.a = messageType;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        String str = (String) obj;
        g.b;
        if (!TextUtils.isEmpty(str)) {
            try {
                if (ITagManager.SUCCESS.equals(new JSONObject(str).optString("result")) != null) {
                    com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.j.b().a(this.a);
                }
            } catch (Object obj2) {
                obj2.printStackTrace();
            }
        }
    }
}
