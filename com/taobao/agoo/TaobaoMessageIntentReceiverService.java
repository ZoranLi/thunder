package com.taobao.agoo;

import android.content.Context;
import com.taobao.accs.client.a;
import com.taobao.accs.utl.ALog;
import org.android.agoo.message.MessageReceiverService;

/* compiled from: Taobao */
public class TaobaoMessageIntentReceiverService extends MessageReceiverService {
    public String getIntentServiceClassName(Context context) {
        StringBuilder stringBuilder = new StringBuilder("getPackage Name=");
        stringBuilder.append(context.getPackageName());
        ALog.w("Taobao", stringBuilder.toString(), new Object[0]);
        return a.a(context.getPackageName());
    }
}
