package com.xunlei.a.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import com.qihoo360.replugin.RePlugin;
import com.xunlei.a.b.a.a;

/* compiled from: QrCodeGenerator */
public final class b {
    public static Bitmap a(String str) {
        a a;
        IBinder fetchBinder = RePlugin.fetchBinder("com.xunlei.plugin.qrcode", "com.xunlei.plugin.qrcode.qrcodefacade");
        if (fetchBinder != null) {
            a = a.a(fetchBinder);
        } else {
            a = null;
        }
        if (a == null) {
            return null;
        }
        try {
            str = a.a(str);
            if (str == null || str == null) {
                return null;
            }
            return BitmapFactory.decodeByteArray(str, 0, str.length);
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }
}
