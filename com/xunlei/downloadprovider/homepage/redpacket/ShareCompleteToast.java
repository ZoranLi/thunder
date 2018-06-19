package com.xunlei.downloadprovider.homepage.redpacket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.xunlei.downloadprovider.R;
import com.xunlei.xllib.android.d;

public final class ShareCompleteToast {

    public enum ToastType {
        TOAST_TYPE_SUCCESS,
        TOAST_TYPE_ERROR
    }

    private static class a {
        private static String a = "";
        private static long b;
        private static Toast c;

        static void a(Context context, ToastType toastType, String str) {
            if (context != null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (str != null && (!str.equals(a) || currentTimeMillis < b || currentTimeMillis - b > 3000)) {
                    a = str;
                    b = currentTimeMillis;
                    if (c == null) {
                        c = new Toast(context.getApplicationContext());
                    }
                    View inflate = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.share_complete_toast_view, null);
                    ((TextView) inflate.findViewById(R.id.xl_toast_txt)).setText(str);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_icon);
                    toastType = toastType == ToastType.TOAST_TYPE_ERROR ? R.drawable.toast_alarm_icon : toastType == ToastType.TOAST_TYPE_SUCCESS ? R.drawable.toast_success_icon : null;
                    if (toastType != null) {
                        imageView.setImageResource(toastType);
                        imageView.setVisibility(0);
                    } else {
                        imageView.setVisibility(8);
                    }
                    c.setView(inflate);
                    toastType = d.c(context);
                    str = d.d(context);
                    if (context.getResources().getConfiguration().orientation == 1) {
                        str = null;
                    }
                    c.setGravity(17, str / 2, (-toastType) / 2);
                    c.setDuration(0);
                    c.show();
                }
            }
        }
    }
}
