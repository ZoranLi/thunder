package com.xunlei.downloadprovider.pushmessage.getui;

import android.content.Context;
import com.alipay.sdk.util.e;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.PushManager;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import com.xunlei.downloadprovider.pushmessage.h;

public class GetuiPushReceiverIntentService extends GTIntentService {
    public void onReceiveClientId(Context context, String str) {
    }

    public void onReceiveServicePid(Context context, int i) {
    }

    public void onReceiveMessageData(Context context, GTTransmitMessage gTTransmitMessage) {
        String appid = gTTransmitMessage.getAppid();
        String taskId = gTTransmitMessage.getTaskId();
        String messageId = gTTransmitMessage.getMessageId();
        byte[] payload = gTTransmitMessage.getPayload();
        String pkgName = gTTransmitMessage.getPkgName();
        gTTransmitMessage = gTTransmitMessage.getClientId();
        new StringBuilder("call sendFeedbackMessage = ").append(PushManager.getInstance().sendFeedbackMessage(context, taskId, messageId, PushConsts.MIN_FEEDBACK_ACTION) ? "success" : e.b);
        StringBuilder stringBuilder = new StringBuilder("onReceiveMessageData -> appid = ");
        stringBuilder.append(appid);
        stringBuilder.append("\ntaskid = ");
        stringBuilder.append(taskId);
        stringBuilder.append("\nmessageid = ");
        stringBuilder.append(messageId);
        stringBuilder.append("\npkg = ");
        stringBuilder.append(pkgName);
        stringBuilder.append("\ncid = ");
        stringBuilder.append(gTTransmitMessage);
        if (payload != null) {
            appid = new String(payload);
            h.a(context, appid, appid, gTTransmitMessage);
        }
    }

    public void onReceiveOnlineState(Context context, boolean z) {
        new StringBuilder("onReceiveOnlineState -> ").append(z ? "online" : "offline");
    }

    public void onReceiveCommandResult(Context context, GTCmdMessage gTCmdMessage) {
        new StringBuilder("onReceiveCommandResult -> action: ").append(gTCmdMessage.getAction());
    }
}
