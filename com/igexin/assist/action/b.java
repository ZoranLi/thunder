package com.igexin.assist.action;

import android.text.TextUtils;
import com.igexin.assist.MessageBean;
import com.igexin.assist.sdk.AssistPushConsts;

class b extends Thread {
    MessageBean a;
    final /* synthetic */ MessageManger b;

    b(MessageManger messageManger, MessageBean messageBean) {
        this.b = messageManger;
        this.a = messageBean;
    }

    public void run() {
        try {
            if (this.a != null) {
                if (this.a.getMessageType().equals("token")) {
                    this.b.a(this.a.getStringMessage());
                } else if (this.a.getMessageType().equals(AssistPushConsts.MSG_TYPE_PAYLOAD) && !TextUtils.isEmpty(this.a.getStringMessage())) {
                    d dVar = new d();
                    dVar.a(this.a);
                    if (dVar.a() && dVar.f().equals(AssistPushConsts.MSG_VALUE_PAYLOAD)) {
                        this.b.a(dVar, this.a.getContext());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
