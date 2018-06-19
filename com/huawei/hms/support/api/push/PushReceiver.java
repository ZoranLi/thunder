package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.k;
import com.xunlei.downloadprovider.ad.notification.NotificationADInfo;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.Executors;

public abstract class PushReceiver extends BroadcastReceiver {

    public interface BOUND_KEY {
        public static final String deviceTokenKey = "deviceToken";
        public static final String pushMsgKey = "pushMsg";
        public static final String pushNotifyId = "pushNotifyId";
        public static final String pushStateKey = "pushState";
        public static final String receiveTypeKey = "receiveType";
    }

    public enum Event {
        NOTIFICATION_OPENED,
        NOTIFICATION_CLICK_BTN
    }

    private class a implements Runnable {
        final /* synthetic */ PushReceiver a;
        private Context b;
        private Bundle c;

        public a(PushReceiver pushReceiver, Context context, Bundle bundle) {
            this.a = pushReceiver;
            this.b = context;
            this.c = bundle;
        }

        public void run() {
            StringBuilder stringBuilder;
            try {
                if (this.c != null) {
                    int i = this.c.getInt(BOUND_KEY.receiveTypeKey);
                    if (i >= 0) {
                        if (i < c.values().length) {
                            switch (c.values()[i]) {
                                case ReceiveType_Token:
                                    this.a.onToken(this.b, this.c.getString(BOUND_KEY.deviceTokenKey), this.c);
                                    return;
                                case ReceiveType_Msg:
                                    byte[] byteArray = this.c.getByteArray(BOUND_KEY.pushMsgKey);
                                    if (byteArray != null) {
                                        this.a.onPushMsg(this.b, byteArray, this.c);
                                        return;
                                    }
                                    break;
                                case ReceiveType_PushState:
                                    this.a.onPushState(this.b, this.c.getBoolean(BOUND_KEY.pushStateKey));
                                    return;
                                case ReceiveType_NotifyClick:
                                    this.a.onEvent(this.b, Event.NOTIFICATION_OPENED, this.c);
                                    return;
                                case ReceiveType_ClickBtn:
                                    this.a.onEvent(this.b, Event.NOTIFICATION_CLICK_BTN, this.c);
                                    break;
                                default:
                                    break;
                            }
                            return;
                        }
                    }
                    if (com.huawei.hms.support.log.a.a()) {
                        stringBuilder = new StringBuilder("invalid receiverType:");
                        stringBuilder.append(i);
                        com.huawei.hms.support.log.a.a("PushReceiver", stringBuilder.toString());
                    }
                }
            } catch (Exception e) {
                if (com.huawei.hms.support.log.a.a()) {
                    stringBuilder = new StringBuilder("call EventThread(ReceiveType cause:");
                    stringBuilder.append(e.getMessage());
                    com.huawei.hms.support.log.a.a("PushReceiver", stringBuilder.toString());
                }
            }
        }
    }

    private static class b implements Runnable {
        Context a;
        String b;

        public b(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        public void run() {
            com.huawei.hms.support.api.push.a.a.a.c cVar = new com.huawei.hms.support.api.push.a.a.a.c(this.a, "push_client_self_info");
            cVar.a("hasRequestToken", false);
            cVar.d("token_info");
            com.huawei.hms.support.api.push.a.a.a.a(this.a, "push_client_self_info", "token_info", this.b);
        }
    }

    enum c {
        ReceiveType_Init,
        ReceiveType_Token,
        ReceiveType_Msg,
        ReceiveType_PushState,
        ReceiveType_NotifyClick,
        ReceiveType_ClickBtn
    }

    public void onEvent(Context context, Event event, Bundle bundle) {
    }

    public void onPushMsg(Context context, byte[] bArr, String str) {
    }

    public void onPushState(Context context, boolean z) {
    }

    public void onToken(Context context, String str) {
    }

    public void onToken(Context context, String str, Bundle bundle) {
        onToken(context, str);
    }

    public boolean onPushMsg(Context context, byte[] bArr, Bundle bundle) {
        String str = "";
        if (bundle != null) {
            str = bundle.getString(BOUND_KEY.deviceTokenKey);
        }
        onPushMsg(context, bArr, str);
        return true;
    }

    public final void onReceive(Context context, Intent intent) {
        StringBuilder stringBuilder;
        try {
            if (com.huawei.hms.support.log.a.a()) {
                stringBuilder = new StringBuilder("enter PushMsgReceiver:onReceive(Intent:");
                stringBuilder.append(intent.getAction());
                stringBuilder.append(" pkgName:");
                stringBuilder.append(context.getPackageName());
                stringBuilder.append(k.t);
                com.huawei.hms.support.log.a.a("PushReceiver", stringBuilder.toString());
            }
            String action = intent.getAction();
            if ("com.huawei.android.push.intent.REGISTRATION".equals(action) && intent.hasExtra(MsgConstant.KEY_DEVICE_TOKEN)) {
                a(context, intent);
            } else if ("com.huawei.android.push.intent.RECEIVE".equals(action) && intent.hasExtra("msg_data")) {
                b(context, intent);
            } else if ("com.huawei.android.push.intent.CLICK".equals(action) && intent.hasExtra(NotificationADInfo.REPORT_STATUS_CLICK)) {
                c(context, intent);
            } else if ("com.huawei.android.push.intent.CLICK".equals(action) && intent.hasExtra("clickBtn")) {
                d(context, intent);
            } else if ("com.huawei.intent.action.PUSH_STATE".equals(action)) {
                e(context, intent);
            } else {
                if (com.huawei.hms.support.log.a.a() != null) {
                    StringBuilder stringBuilder2 = new StringBuilder("message can't be recognised:");
                    stringBuilder2.append(intent.toUri(0));
                    com.huawei.hms.support.log.a.b("PushReceiver", stringBuilder2.toString());
                }
            }
        } catch (Context context2) {
            if (com.huawei.hms.support.log.a.d()) {
                stringBuilder = new StringBuilder("call onReceive(intent:");
                stringBuilder.append(intent);
                stringBuilder.append(") cause:");
                stringBuilder.append(context2.getMessage());
                com.huawei.hms.support.log.a.d("PushReceiver", stringBuilder.toString());
            }
        }
    }

    private void a(Context context, Intent intent) throws UnsupportedEncodingException {
        byte[] byteArrayExtra = intent.getByteArrayExtra(MsgConstant.KEY_DEVICE_TOKEN);
        if (byteArrayExtra == null) {
            if (com.huawei.hms.support.log.a.a() != null) {
                com.huawei.hms.support.log.a.a("PushReceiver", "get a deviceToken, but it is null");
            }
            return;
        }
        String str = new String(byteArrayExtra, "UTF-8");
        if (com.huawei.hms.support.log.a.a()) {
            StringBuilder stringBuilder = new StringBuilder("get a deviceToken:");
            stringBuilder.append(com.huawei.hms.support.api.push.a.a.b.c.a(str));
            com.huawei.hms.support.log.a.a("PushReceiver", stringBuilder.toString());
        }
        boolean a = new com.huawei.hms.support.api.push.a.a.a.c(context, "push_client_self_info").a("hasRequestToken");
        String a2 = com.huawei.hms.support.api.push.a.a.a.a(context, "push_client_self_info", "token_info");
        if (com.huawei.hms.support.log.a.a()) {
            StringBuilder stringBuilder2 = new StringBuilder("my oldtoken is :");
            stringBuilder2.append(com.huawei.hms.support.api.push.a.a.b.c.a(a2));
            com.huawei.hms.support.log.a.a("PushReceiver", stringBuilder2.toString());
        }
        if (!a) {
            if (str.equals(a2)) {
                if (com.huawei.hms.support.log.a.a() != null) {
                    com.huawei.hms.support.log.a.a("PushReceiver", "get a deviceToken, but do not requested token, and new token is equals old token");
                }
                if (a && str.equals(a2) == null && com.huawei.hms.support.log.a.a() != null) {
                    com.huawei.hms.support.log.a.a("PushReceiver", "begin to report active state tag");
                }
            }
        }
        if (com.huawei.hms.support.log.a.a()) {
            com.huawei.hms.support.log.a.a("PushReceiver", "push client begin to receive the token");
        }
        Executors.newSingleThreadExecutor().execute(new b(context, str));
        Bundle bundle = new Bundle();
        bundle.putString(BOUND_KEY.deviceTokenKey, str);
        bundle.putByteArray(BOUND_KEY.pushMsgKey, null);
        bundle.putInt(BOUND_KEY.receiveTypeKey, c.ReceiveType_Token.ordinal());
        if (intent.getExtras() != null) {
            bundle.putAll(intent.getExtras());
        }
        Executors.newSingleThreadExecutor().execute(new a(this, context, bundle));
        com.huawei.hms.support.log.a.a("PushReceiver", "begin to report active state tag");
    }

    private void b(Context context, Intent intent) throws UnsupportedEncodingException {
        f(context, intent);
        boolean a = new com.huawei.hms.support.api.push.a.a.a.c(context, "push_switch").a("normal_msg_enable");
        if (com.huawei.hms.support.log.a.a()) {
            StringBuilder stringBuilder = new StringBuilder("closePush_Normal:");
            stringBuilder.append(a);
            com.huawei.hms.support.log.a.a("PushReceiver", stringBuilder.toString());
        }
        if (a) {
            if (com.huawei.hms.support.log.a.a() != null) {
                com.huawei.hms.support.log.a.a("PushReceiver", "close switch is true, message not dispatch");
            }
            return;
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("msg_data");
        intent = intent.getByteArrayExtra(MsgConstant.KEY_DEVICE_TOKEN);
        if (byteArrayExtra != null) {
            if (intent != null) {
                if (com.huawei.hms.support.log.a.a()) {
                    com.huawei.hms.support.log.a.a("PushReceiver", "PushReceiver receive a message success");
                }
                String str = new String(intent, "UTF-8");
                intent = new Bundle();
                intent.putString(BOUND_KEY.deviceTokenKey, str);
                intent.putByteArray(BOUND_KEY.pushMsgKey, byteArrayExtra);
                intent.putInt(BOUND_KEY.receiveTypeKey, c.ReceiveType_Msg.ordinal());
                Executors.newSingleThreadExecutor().execute(new a(this, context, intent));
                return;
            }
        }
        if (com.huawei.hms.support.log.a.a() != null) {
            com.huawei.hms.support.log.a.a("PushReceiver", "PushReceiver receive a message, but message is empty.");
        }
    }

    private void c(Context context, Intent intent) {
        intent = intent.getStringExtra(NotificationADInfo.REPORT_STATUS_CLICK);
        Bundle bundle = new Bundle();
        bundle.putString(BOUND_KEY.pushMsgKey, intent);
        bundle.putInt(BOUND_KEY.receiveTypeKey, c.ReceiveType_NotifyClick.ordinal());
        Executors.newSingleThreadExecutor().execute(new a(this, context, bundle));
    }

    private void d(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("clickBtn");
        intent = intent.getIntExtra("notifyId", 0);
        Bundle bundle = new Bundle();
        bundle.putString(BOUND_KEY.pushMsgKey, stringExtra);
        bundle.putInt(BOUND_KEY.pushNotifyId, intent);
        bundle.putInt(BOUND_KEY.receiveTypeKey, c.ReceiveType_ClickBtn.ordinal());
        Executors.newSingleThreadExecutor().execute(new a(this, context, bundle));
    }

    private void e(Context context, Intent intent) {
        intent = intent.getBooleanExtra("push_state", false);
        Bundle bundle = new Bundle();
        bundle.putBoolean(BOUND_KEY.pushStateKey, intent);
        bundle.putInt(BOUND_KEY.receiveTypeKey, c.ReceiveType_PushState.ordinal());
        Executors.newSingleThreadExecutor().execute(new a(this, context, bundle));
    }

    private void f(Context context, Intent intent) {
        if (context != null) {
            if (intent != null) {
                intent = intent.getStringExtra("msgIdStr");
                if (!TextUtils.isEmpty(intent) && com.huawei.hms.support.api.push.a.a.a(context)) {
                    Intent intent2 = new Intent("com.huawei.android.push.intent.MSG_RESPONSE");
                    intent2.putExtra("msgIdStr", intent);
                    intent2.setPackage(DispatchConstants.ANDROID);
                    intent2.setFlags(32);
                    if (com.huawei.hms.support.log.a.a() != null) {
                        com.huawei.hms.support.log.a.a("PushReceiver", "send msg response broadcast to frameworkPush");
                    }
                    context.sendBroadcast(intent2);
                }
            }
        }
    }
}
