package com.igexin.sdk;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.igexin.b.a.c.a;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTTransmitMessage;

public abstract class GTIntentService extends IntentService {
    public static final String TAG = "GTIntentService";

    public GTIntentService() {
        super(TAG);
    }

    private void processOnHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null && extras.get("action") != null && (extras.get("action") instanceof Integer)) {
            switch (extras.getInt("action")) {
                case 10001:
                    onReceiveMessageData(this, (GTTransmitMessage) intent.getSerializableExtra(PushConsts.KEY_MESSAGE_DATA));
                    break;
                case 10002:
                    onReceiveClientId(this, extras.getString(PushConsts.KEY_CLIENT_ID));
                    return;
                case 10007:
                    onReceiveOnlineState(this, extras.getBoolean(PushConsts.KEY_ONLINE_STATE));
                    return;
                case 10008:
                    onReceiveServicePid(this, extras.getInt(PushConsts.KEY_SERVICE_PIT));
                    return;
                case 10010:
                    onReceiveCommandResult(this, (GTCmdMessage) intent.getSerializableExtra(PushConsts.KEY_CMD_MSG));
                    return;
                default:
                    return;
            }
        }
    }

    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            try {
                processOnHandleIntent(intent);
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("GTIntentService|");
                stringBuilder.append(th.toString());
                a.b(stringBuilder.toString());
            }
        }
    }

    public abstract void onReceiveClientId(Context context, String str);

    public abstract void onReceiveCommandResult(Context context, GTCmdMessage gTCmdMessage);

    public abstract void onReceiveMessageData(Context context, GTTransmitMessage gTTransmitMessage);

    public abstract void onReceiveOnlineState(Context context, boolean z);

    public abstract void onReceiveServicePid(Context context, int i);
}
