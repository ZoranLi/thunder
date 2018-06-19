package com.xunlei.common.commonview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.xunlei.common.R;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.xllib.android.d;

class XLToast$Impl {
    private static final long DROP_DUPLICATE_TOAST_TS = 2000;
    private static Toast sBasicToast = null;
    private static String sLastText = "";
    private static long sLastTs;

    private XLToast$Impl() {
    }

    static void showToastImpl(Context context, XLToast$ToastType xLToast$ToastType, String str, int i, int i2, int i3) {
        if (context != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (str != null && (!str.equals(sLastText) || currentTimeMillis < sLastTs || currentTimeMillis - sLastTs > DROP_DUPLICATE_TOAST_TS)) {
                sLastText = str;
                sLastTs = currentTimeMillis;
                if (sBasicToast == null) {
                    sBasicToast = new Toast(context.getApplicationContext());
                }
                View inflate = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.xl_toast_view, null);
                TextView textView = (TextView) inflate.findViewById(R.id.xl_toast_txt);
                textView.setText(str);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_icon);
                xLToast$ToastType = xLToast$ToastType == XLToast$ToastType.TOAST_TYPE_ALARM ? R.drawable.toast_alarm_icon : xLToast$ToastType == XLToast$ToastType.TOAST_TYPE_SUCCESS ? R.drawable.toast_success_icon : null;
                if (xLToast$ToastType != null) {
                    imageView.setImageResource(xLToast$ToastType);
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
                if (i > 0) {
                    textView.setMaxLines(i);
                }
                sBasicToast.setView(inflate);
                if (i2 == 17) {
                    xLToast$ToastType = d.c(context);
                    str = d.d(context);
                } else if (i2 == 80) {
                    xLToast$ToastType = -2 * DipPixelUtil.dip2px(65.0f);
                    str = d.d(context);
                } else {
                    xLToast$ToastType = null;
                    str = xLToast$ToastType;
                }
                if (context.getResources().getConfiguration().orientation == 1) {
                    str = null;
                }
                sBasicToast.setGravity(i2, str / 2, (-xLToast$ToastType) / 2);
                sBasicToast.setDuration(i3);
                sBasicToast.show();
            }
        }
    }

    static void cancelAllToast() {
        if (sBasicToast != null) {
            sBasicToast.cancel();
        }
    }
}
