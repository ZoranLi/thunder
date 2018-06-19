package com.sina.weibo.sdk.utils;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.widget.Toast;

public class UIUtils {
    public static int dip2px(int i, Context context) {
        return (int) ((((float) i) * context.getResources().getDisplayMetrics().density) + 1056964608);
    }

    public static void showAlert(Context context, String str, String str2) {
        if (context != null) {
            new Builder(context).setTitle(str).setMessage(str2).create().show();
        }
    }

    public static void showAlert(Context context, int i, int i2) {
        if (context != null) {
            showAlert(context, context.getString(i), context.getString(i2));
        }
    }

    public static void showToast(Context context, int i, int i2) {
        if (context != null) {
            Toast.makeText(context, i, i2).show();
        }
    }

    public static void showToast(Context context, CharSequence charSequence, int i) {
        if (context != null) {
            Toast.makeText(context, charSequence, i).show();
        }
    }

    public static void showToastInCenter(Context context, int i, int i2) {
        if (context != null) {
            context = Toast.makeText(context, i, i2);
            context.setGravity(17, 0, 0);
            context.show();
        }
    }
}
