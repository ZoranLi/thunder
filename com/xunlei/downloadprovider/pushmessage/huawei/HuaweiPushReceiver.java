package com.xunlei.downloadprovider.pushmessage.huawei;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.support.api.push.PushReceiver;
import com.huawei.hms.support.api.push.PushReceiver.BOUND_KEY;
import com.huawei.hms.support.api.push.PushReceiver.Event;
import com.umeng.message.entity.UMessage;
import com.xunlei.downloadprovider.pushmessage.bean.PushOriginalInfo;
import com.xunlei.downloadprovider.pushmessage.biz.BasePushBiz;
import com.xunlei.downloadprovider.pushmessage.e;
import com.xunlei.downloadprovider.pushmessage.exception.PushParseException;
import com.xunlei.downloadprovider.pushmessage.h;
import com.xunlei.downloadprovider.pushmessage.n;

public class HuaweiPushReceiver extends PushReceiver {
    public void onPushState(Context context, boolean z) {
    }

    public void onToken(Context context, String str, Bundle bundle) {
        e.c();
        e.a(str);
        e.c().e();
    }

    public boolean onPushMsg(Context context, byte[] bArr, Bundle bundle) {
        try {
            h.c(context, new String(bArr, "UTF-8"), e.c().d());
        } catch (Context context2) {
            context2.printStackTrace();
        }
        return null;
    }

    public void onEvent(Context context, Event event, Bundle bundle) {
        if (Event.NOTIFICATION_OPENED.equals(event) || Event.NOTIFICATION_CLICK_BTN.equals(event)) {
            int i = bundle.getInt(BOUND_KEY.pushNotifyId, 0);
            if (i != 0) {
                ((NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION)).cancel(i);
            }
        }
        String string = bundle.getString(BOUND_KEY.pushMsgKey);
        try {
            BasePushBiz a = n.a(new PushOriginalInfo(3, string, string, e.c().d(), true));
            Intent createClickIntent = a.createClickIntent(context);
            if (createClickIntent != null) {
                new StringBuilder("start launch activity, extra = ").append(createClickIntent.getExtras());
                context.startActivity(createClickIntent);
                a.onClick(context);
            }
        } catch (PushParseException e) {
            new StringBuilder("PushParseException : ").append(e.getErrorMsg());
            e.printStackTrace();
        }
        super.onEvent(context, event, bundle);
    }
}
