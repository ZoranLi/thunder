package com.xiaomi.mipush.sdk;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageHandleService extends IntentService {
    private static ConcurrentLinkedQueue<a> a = new ConcurrentLinkedQueue();

    public static class a {
        private PushMessageReceiver a;
        private Intent b;

        public a(Intent intent, PushMessageReceiver pushMessageReceiver) {
            this.a = pushMessageReceiver;
            this.b = intent;
        }

        public PushMessageReceiver a() {
            return this.a;
        }

        public Intent b() {
            return this.b;
        }
    }

    public MessageHandleService() {
        super("MessageHandleThread");
    }

    protected static void a(Service service, Intent intent) {
        if (intent != null) {
            try {
                a aVar = (a) a.poll();
                if (aVar != null) {
                    PushMessageReceiver a = aVar.a();
                    intent = aVar.b();
                    int intExtra = intent.getIntExtra(PushMessageHelper.MESSAGE_TYPE, 1);
                    MiPushCommandMessage miPushCommandMessage;
                    if (intExtra != 1) {
                        switch (intExtra) {
                            case 3:
                                miPushCommandMessage = (MiPushCommandMessage) intent.getSerializableExtra(PushMessageHelper.KEY_COMMAND);
                                a.onCommandResult(service, miPushCommandMessage);
                                if (TextUtils.equals(miPushCommandMessage.getCommand(), "register")) {
                                    a.onReceiveRegisterResult(service, miPushCommandMessage);
                                    if (miPushCommandMessage.getResultCode() == 0) {
                                        d.c(service);
                                        return;
                                    }
                                }
                                break;
                            case 4:
                                return;
                            default:
                                return;
                        }
                    }
                    com.xiaomi.mipush.sdk.PushMessageHandler.a a2 = aa.a((Context) service).a(intent);
                    if (a2 != null) {
                        if (a2 instanceof MiPushMessage) {
                            MiPushMessage miPushMessage = (MiPushMessage) a2;
                            if (!miPushMessage.isArrivedMessage()) {
                                a.onReceiveMessage(service, miPushMessage);
                            }
                            if (miPushMessage.getPassThrough() == 1) {
                                a.onReceivePassThroughMessage(service, miPushMessage);
                            } else if (miPushMessage.isNotified()) {
                                a.onNotificationMessageClicked(service, miPushMessage);
                            } else {
                                a.onNotificationMessageArrived(service, miPushMessage);
                            }
                        } else if (a2 instanceof MiPushCommandMessage) {
                            miPushCommandMessage = (MiPushCommandMessage) a2;
                            a.onCommandResult(service, miPushCommandMessage);
                            if (TextUtils.equals(miPushCommandMessage.getCommand(), "register")) {
                                a.onReceiveRegisterResult(service, miPushCommandMessage);
                                if (miPushCommandMessage.getResultCode() == 0) {
                                    d.c(service);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable e) {
                b.a(e);
            }
        }
    }

    public static void addJob(a aVar) {
        if (aVar != null) {
            a.add(aVar);
        }
    }

    protected void onHandleIntent(Intent intent) {
        a(this, intent);
    }
}
