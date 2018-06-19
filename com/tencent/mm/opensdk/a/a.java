package com.tencent.mm.opensdk.a;

import android.os.Bundle;

public final class a {
    public static int a(Bundle bundle, String str) {
        if (bundle == null) {
            return -1;
        }
        try {
            return bundle.getInt(str, -1);
        } catch (Exception e) {
            new StringBuilder("getIntExtra exception:").append(e.getMessage());
            return -1;
        }
    }

    public static String b(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        try {
            return bundle.getString(str);
        } catch (Exception e) {
            new StringBuilder("getStringExtra exception:").append(e.getMessage());
            return null;
        }
    }
}
