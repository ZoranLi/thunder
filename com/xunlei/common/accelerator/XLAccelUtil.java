package com.xunlei.common.accelerator;

import android.content.Context;
import com.xunlei.common.accelerator.config.Config;
import com.xunlei.common.accelerator.interactor.XLAcceleratorInteractor;

public final class XLAccelUtil {
    private static XLAccelUtil mXLAccelUtil;
    private XLAccelerator mXLAccelerator;

    public static synchronized XLAccelUtil getInstance() {
        XLAccelUtil xLAccelUtil;
        synchronized (XLAccelUtil.class) {
            if (mXLAccelUtil == null) {
                mXLAccelUtil = new XLAccelUtil();
            }
            xLAccelUtil = mXLAccelUtil;
        }
        return xLAccelUtil;
    }

    public final void init(Context context, String str, String str2) {
        if (Config.isKeyRegistered(str2)) {
            if (this.mXLAccelerator == null) {
                this.mXLAccelerator = new XLAcceleratorInteractor();
            }
            if (!Config.isKnApp()) {
                this.mXLAccelerator.init(context, str, str2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("XLAccelUtil appKey is not valid...");
    }

    public final XLAccelerator getAccelerator() {
        return this.mXLAccelerator;
    }
}
