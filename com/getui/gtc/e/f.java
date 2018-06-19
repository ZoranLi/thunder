package com.getui.gtc.e;

import android.content.Context;
import android.os.Bundle;

public final class f {
    static String a(Context context, String str) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                for (String str2 : bundle.keySet()) {
                    if (str2.equals(str)) {
                        return bundle.get(str2).toString();
                    }
                }
            }
        } catch (Exception e) {
            new String[1][0] = e.toString();
        }
        return "";
    }
}
