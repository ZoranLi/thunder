package com.alipay.sdk.util;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.cons.a;

public final class j {
    private static final String a = "content://com.alipay.android.app.settings.data.ServerProvider/current_server";

    public static String a(Context context) {
        if (context == null) {
            return a.a;
        }
        context = a.a;
        if (TextUtils.isEmpty(context)) {
            context = a.a;
        }
        return context;
    }

    private static String b(Context context) {
        context = context.getContentResolver().query(Uri.parse(a), null, null, null, null);
        String str = null;
        if (context != null && context.getCount() > 0) {
            if (context.moveToFirst()) {
                str = context.getString(context.getColumnIndex("url"));
            }
            context.close();
        }
        return str;
    }
}
