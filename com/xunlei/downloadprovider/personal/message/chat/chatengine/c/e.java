package com.xunlei.downloadprovider.personal.message.chat.chatengine.c;

import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import org.json.JSONException;

/* compiled from: ChatDialogNetwork */
final class e implements Runnable {
    final /* synthetic */ int a = 1;
    final /* synthetic */ c b;
    final /* synthetic */ long c;
    final /* synthetic */ d d;

    e(d dVar, c cVar, long j) {
        this.d = dVar;
        this.b = cVar;
        this.c = j;
    }

    public final void run() {
        if (this.a != 1) {
            c cVar = this.b;
            StringBuilder stringBuilder = new StringBuilder("do not support this dialog type. dialogType: ");
            stringBuilder.append(this.a);
            cVar.a(b.a(-1000, stringBuilder.toString()));
        } else if (this.c == 0) {
            this.b.a(b.a(-1000, "targetUserId can not be zero."));
        } else {
            try {
                this.d.a(this.d.a(1, "http://api-shoulei-ssl.xunlei.com/chitchat/one-to-one/group", d.a(this.c), new f(this)));
            } catch (JSONException e) {
                c cVar2 = this.b;
                StringBuilder stringBuilder2 = new StringBuilder("build requestBody error. e: ");
                stringBuilder2.append(e.getMessage());
                cVar2.a(b.a(-1000, stringBuilder2.toString()));
            }
        }
    }
}
