package com.xunlei.common.new_ptl.member.task.c;

import android.support.annotation.NonNull;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.xluagc.XLMessageInterface;

/* compiled from: XLMessageChannelManager */
public final class b {
    private static XLMessageInterface a;

    public static final void a(@NonNull XLMessageInterface xLMessageInterface, p pVar) {
        if (xLMessageInterface != null) {
            a = xLMessageInterface;
            xLMessageInterface = xLMessageInterface.registerServiceType("10000", new c(pVar));
            StringBuilder stringBuilder = new StringBuilder("registerServiceType return = ");
            stringBuilder.append(xLMessageInterface);
            XLLog.v("XLMessageChannelManager", stringBuilder.toString());
        }
    }

    public static final void a() {
        if (a != null) {
            int unregisterServiceType = a.unregisterServiceType("10000");
            StringBuilder stringBuilder = new StringBuilder("unregisterServiceType return = ");
            stringBuilder.append(unregisterServiceType);
            XLLog.v("XLMessageChannelManager", stringBuilder.toString());
            a = null;
        }
    }
}
