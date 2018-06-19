package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;

public class SecurityInit {
    public static int Initialize(Context context) throws JAQException {
        try {
            return SecurityGuardManager.getInitializer().initialize(context);
        } catch (SecException e) {
            e.printStackTrace();
            throw new JAQException(e.getErrorCode());
        }
    }
}
