package com.taobao.agoo;

import android.content.Intent;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity.INotifyListener;

/* compiled from: Taobao */
public class c implements INotifyListener {
    public String getMsgSource() {
        return "xiaomi";
    }

    public String parseMsgFromIntent(Intent intent) {
        try {
            String str = (String) Class.forName("com.xiaomi.mipush.sdk.PushMessageHelper").getField("KEY_MESSAGE").get(null);
            if (intent.getSerializableExtra(str) == null) {
                return null;
            }
            Class cls = Class.forName("com.xiaomi.mipush.sdk.MiPushMessage");
            return (String) cls.getMethod("getContent", new Class[0]).invoke(cls.cast(intent.getSerializableExtra(str)), new Object[0]);
        } catch (Intent intent2) {
            ALog.e("DefaultXiaomiMsgParseImpl", "parseMsgFromIntent", intent2, new Object[0]);
            return null;
        }
    }
}
