package com.tencent.bugly.beta.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/* compiled from: BUGLY */
public class f {
    private static Toast a;

    public static void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (a == null) {
                a = Toast.makeText(context, str, 0);
            } else {
                a.setText(str);
            }
            a.show();
        }
    }
}
