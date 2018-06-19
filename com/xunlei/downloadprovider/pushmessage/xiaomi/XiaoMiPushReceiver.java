package com.xunlei.downloadprovider.pushmessage.xiaomi;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.pushmessage.bean.PushOriginalInfo;
import com.xunlei.downloadprovider.pushmessage.e;
import com.xunlei.downloadprovider.pushmessage.h;
import com.xunlei.downloadprovider.pushmessage.n;
import java.util.List;

public class XiaoMiPushReceiver extends PushMessageReceiver {
    private static final String TAG = "XiaoMiPushReceiver";
    private String mRegId = null;

    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        new StringBuilder("Receiver commandResult is:").append(miPushCommandMessage.toString());
        context = miPushCommandMessage.getCommand();
        List commandArguments = miPushCommandMessage.getCommandArguments();
        String str = (commandArguments == null || commandArguments.size() <= 0) ? null : (String) commandArguments.get(0);
        if (commandArguments != null && commandArguments.size() > 1) {
            commandArguments.get(1);
        }
        if ("register".equals(context) != null && miPushCommandMessage.getResultCode() == 0) {
            this.mRegId = str;
        }
    }

    public void onReceiveMessage(Context context, MiPushMessage miPushMessage) {
        int passThrough = miPushMessage.getPassThrough();
        StringBuilder stringBuilder = new StringBuilder("Receive Message is:");
        stringBuilder.append(miPushMessage.getContent());
        stringBuilder.append(",passThrough=");
        stringBuilder.append(passThrough);
        if (passThrough == 0) {
            if (miPushMessage.getContent() != null) {
                try {
                    miPushMessage = n.a(new PushOriginalInfo(1, miPushMessage.getContent(), miPushMessage.getContent(), MiPushClient.getRegId(BrothersApplication.getApplicationInstance()), false));
                    Intent createClickIntent = miPushMessage.createClickIntent(context);
                    if (createClickIntent != null) {
                        context.startActivity(createClickIntent);
                        miPushMessage.onClick(context);
                    }
                } catch (Context context2) {
                    context2.printStackTrace();
                }
            }
        } else if (passThrough == 1) {
            String content = miPushMessage.getContent();
            String regId = MiPushClient.getRegId(BrothersApplication.getApplicationInstance());
            miPushMessage.getMessageId();
            h.a(context2, content, regId);
        }
    }

    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        context = miPushCommandMessage.getCommand();
        List commandArguments = miPushCommandMessage.getCommandArguments();
        String str = (commandArguments == null || commandArguments.size() <= 0) ? null : (String) commandArguments.get(0);
        if (commandArguments != null && commandArguments.size() > 1) {
            commandArguments.get(1);
        }
        if ("register".equals(context) != null && miPushCommandMessage.getResultCode() == 0) {
            this.mRegId = str;
            new StringBuilder("onReceiveRegisterResult RegId is:").append(this.mRegId);
            e.c();
            e.a(this.mRegId);
            e.c().e();
        }
    }
}
