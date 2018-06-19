package com.huawei.hms.update.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

/* compiled from: SilentInstallReceive */
public class a extends BroadcastReceiver {
    private Handler a;

    public a(Handler handler) {
        this.a = handler;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                intent.getStringExtra("TestIntent");
                context = intent.getAction();
                if ("com.huawei.appmarket.service.downloadservice.Receiver".equals(context)) {
                    context = intent.getExtras();
                    if (context != null) {
                        intent = new Message();
                        intent.what = 101;
                        intent.obj = context;
                        this.a.sendMessage(intent);
                    }
                } else if ("com.huawei.appmarket.service.downloadservice.progress.Receiver".equals(context)) {
                    context = intent.getExtras();
                    if (context != null) {
                        intent = new Message();
                        intent.what = 102;
                        intent.obj = context;
                        this.a.sendMessage(intent);
                    }
                } else {
                    if ("com.huawei.appmarket.service.installerservice.Receiver".equals(context) != null) {
                        context = intent.getExtras();
                        if (context != null) {
                            intent = new Message();
                            intent.what = 103;
                            intent.obj = context;
                            this.a.sendMessage(intent);
                        }
                    }
                }
            } catch (Context context2) {
                StringBuilder stringBuilder = new StringBuilder("intent has some error");
                stringBuilder.append(context2.getMessage());
                com.huawei.hms.support.log.a.d("SilentInstallReceive", stringBuilder.toString());
            }
        }
    }
}
