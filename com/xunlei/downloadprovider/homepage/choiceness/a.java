package com.xunlei.downloadprovider.homepage.choiceness;

import android.text.TextUtils;
import android.widget.ImageView;
import com.xunlei.xllib.b.b;

/* compiled from: BlurUrlUtil */
public final class a {
    public static String a(String str, int i, int i2, ImageView imageView) {
        int width;
        int height;
        int i3 = 0;
        if (imageView != null) {
            width = imageView.getWidth();
            height = imageView.getHeight();
        } else {
            width = 0;
            height = width;
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (imageView != null) {
            i3 = imageView.getWidth();
            imageView = imageView.getHeight();
        } else {
            imageView = null;
        }
        if (i3 == 0 || r7 == null) {
            i3 = width;
            imageView = height;
        }
        if (i != 0) {
            if (i2 != 0) {
                i = (float) i;
                i2 = (float) i2;
                if (i / i2 >= 1.7777778f || str.contains("/rotate/auto")) {
                    return str;
                }
                i = (int) ((i * ((float) imageView)) / i2);
                i2 = new StringBuilder();
                i2.append(str);
                i2.append("?imageMogr2/thumbnail/");
                i2.append(i);
                i2.append("x");
                i2.append(imageView);
                i2.append("!");
                i = b.a(i2.toString().getBytes());
                i2 = new StringBuilder();
                i2.append(str);
                i2.append("?imageMogr2/thumbnail/");
                i2.append(i3);
                i2.append("x");
                i2.append(imageView);
                i2.append("!|imageMogr2/blur/50x250|imageMogr2/blur/50x250|imageMogr2/blur/50x250|imageMogr2/blur/50x250|watermark/3/image/");
                i2.append(i);
                i2.append("/gravity/Center/dx/0/dy/0");
                i = i2.toString();
                i2 = new StringBuilder("getBlurUrl--originUrl=");
                i2.append(str);
                i2.append(" |blurUrl=");
                i2.append(i);
                return i;
            }
        }
        return str;
    }
}
