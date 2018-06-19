package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.android.utils.StringUtils;

public class UTDevice {
    public static String getUtdid(Context context) {
        context = DeviceInfo.getDevice(context);
        if (context != null) {
            if (!StringUtils.isEmpty(context.getUtdid())) {
                return context.getUtdid();
            }
        }
        return "ffffffffffffffffffffffff";
    }
}
