package com.xunlei.downloadprovider.contentpublish.website;

import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: WebsiteUtils */
public final class bg {
    private static int a = DipPixelUtil.dip2px(65.0f);
    private static int b = DipPixelUtil.dip2px(78.0f);
    private static int c = ((BrothersApplication.getApplicationInstance().getResources().getDisplayMetrics().widthPixels * 2) / 5);

    public static boolean a(ImageView imageView, String str, int i, int i2) {
        LayoutParams layoutParams = imageView.getLayoutParams();
        boolean z = false;
        if (i != 0) {
            if (i2 != 0) {
                if ((((float) i2) * 1065353216) / ((float) i) <= 1067450368) {
                    layoutParams.height = a;
                    z = true;
                    imageView.requestLayout();
                    return z;
                }
                layoutParams.height = b;
                imageView.requestLayout();
                return z;
            }
        }
        if (TextUtils.isEmpty(str) != null) {
            layoutParams.height = a;
            z = true;
            imageView.requestLayout();
            return z;
        }
        layoutParams.height = b;
        imageView.requestLayout();
        return z;
    }

    public static void b(ImageView imageView, String str, int i, int i2) {
        LayoutParams layoutParams = imageView.getLayoutParams();
        if (!(i == 0 || i2 == 0)) {
            if (TextUtils.isEmpty(str) == null) {
                str = (((float) i2) * 1.0f) / ((float) i);
                if (i2 > i) {
                    layoutParams.width = (int) (((float) c) / str);
                    layoutParams.height = c;
                } else {
                    layoutParams.width = c;
                    layoutParams.height = (int) (((float) c) * str);
                }
                imageView.requestLayout();
            }
        }
        layoutParams.width = (c * 5) / 7;
        layoutParams.height = c;
        imageView.requestLayout();
    }

    public static boolean a(String str) {
        return (TextUtils.isEmpty(str) || str.length() >= 256) ? null : true;
    }
}
