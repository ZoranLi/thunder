package com.taobao.accs.client;

import android.content.Context;
import com.taobao.accs.ChannelService;
import com.taobao.accs.IProcessName;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.i;

/* compiled from: Taobao */
public class GlobalConfig {
    public static boolean enableCookie = true;
    public static AccsConfig$ACCS_GROUP mGroup = AccsConfig$ACCS_GROUP.TAOBAO;

    public static void setControlFrameMaxRetry(int i) {
        Message.a = i;
    }

    public static void setMainProcessName(String str) {
        a.d = str;
    }

    public static void setChannelProcessName(String str) {
        a.e = str;
    }

    public static void setCurrProcessNameImpl(IProcessName iProcessName) {
        a.f = iProcessName;
    }

    public static void setChannelReuse(boolean z, AccsConfig$ACCS_GROUP accsConfig$ACCS_GROUP) {
        GlobalClientInfo.d = z;
        mGroup = accsConfig$ACCS_GROUP;
    }

    public static void setEnableForground(Context context, boolean z) {
        r2 = new Object[2];
        int i = 0;
        r2[0] = "enable";
        r2[1] = Boolean.valueOf(z);
        ALog.i("GlobalConfig", "setEnableForground", r2);
        if (z) {
            i = 24;
        }
        i.a(context, ChannelService.SUPPORT_FOREGROUND_VERSION_KEY, i);
    }
}
