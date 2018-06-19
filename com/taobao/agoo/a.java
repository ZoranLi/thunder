package com.taobao.agoo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.control.NotifManager;

/* compiled from: Taobao */
class a implements Runnable {
    final /* synthetic */ Intent a;
    final /* synthetic */ BaseNotifyClickActivity b;

    a(BaseNotifyClickActivity baseNotifyClickActivity, Intent intent) {
        this.b = baseNotifyClickActivity;
        this.a = intent;
    }

    public void run() {
        Throwable th;
        Intent intent = null;
        try {
            if (this.a != null) {
                String access$000 = this.b.parseMsgByThirdPush(this.a);
                if (TextUtils.isEmpty(access$000) || TextUtils.isEmpty(this.b.msgSource)) {
                    ALog.e("accs.BaseNotifyClickActivity", "parseMsgFromNotifyListener null!!", new Object[]{"source", this.b.msgSource});
                } else {
                    if (this.b.notifyManager == null) {
                        this.b.notifyManager = new NotifManager();
                    }
                    if (this.b.agooFactory == null) {
                        this.b.agooFactory = new AgooFactory();
                        this.b.agooFactory.init(this.b.getApplicationContext(), this.b.notifyManager, null);
                    }
                    Bundle msgReceiverPreHandler = this.b.agooFactory.msgReceiverPreHandler(access$000.getBytes("UTF-8"), this.b.msgSource, null, false);
                    String string = msgReceiverPreHandler.getString(AgooConstants.MESSAGE_BODY);
                    ALog.i("accs.BaseNotifyClickActivity", "begin parse EncryptedMsg", new Object[0]);
                    this.b.agooFactory;
                    Object parseEncryptedMsg = AgooFactory.parseEncryptedMsg(string);
                    if (TextUtils.isEmpty(parseEncryptedMsg)) {
                        ALog.e("accs.BaseNotifyClickActivity", "parse EncryptedMsg fail, empty", new Object[0]);
                    } else {
                        msgReceiverPreHandler.putString(AgooConstants.MESSAGE_BODY, parseEncryptedMsg);
                    }
                    Intent intent2 = new Intent();
                    try {
                        intent2.putExtras(msgReceiverPreHandler);
                        this.b.agooFactory.saveMsg(access$000.getBytes("UTF-8"), "2");
                        this.b.reportClickNotifyMsg(intent2);
                        intent = intent2;
                    } catch (Throwable th2) {
                        th = th2;
                        intent = intent2;
                        this.b.onMessage(intent);
                        throw th;
                    }
                }
            }
            try {
                this.b.onMessage(intent);
            } catch (Throwable th3) {
                ALog.e("accs.BaseNotifyClickActivity", "onMessage", th3, new Object[0]);
            }
        } catch (Throwable th4) {
            th = th4;
            ALog.e("accs.BaseNotifyClickActivity", "buildMessage", th, new Object[0]);
            this.b.onMessage(intent);
        }
    }
}
