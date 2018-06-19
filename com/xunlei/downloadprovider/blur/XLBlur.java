package com.xunlei.downloadprovider.blur;

import android.graphics.Bitmap;

public class XLBlur {
    public static native void blurBitmap(Bitmap bitmap, int i);

    static {
        try {
            System.loadLibrary("genius_blur");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }
}
