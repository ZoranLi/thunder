package com.taobao.agoo;

import android.content.Intent;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity.INotifyListener;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
public class b implements INotifyListener {
    public String getMsgSource() {
        return AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI;
    }

    public String parseMsgFromIntent(Intent intent) {
        if (intent == null) {
            ALog.e("DefaultHuaweiMsgParseImpl", "parseMsgFromIntent null", new Object[0]);
            return null;
        }
        try {
            intent = intent.getStringExtra("extras");
        } catch (Intent intent2) {
            ALog.e("DefaultHuaweiMsgParseImpl", "parseMsgFromIntent", intent2, new Object[0]);
            intent2 = null;
        }
        return intent2;
    }
}
