package com.qihoo360.replugin.utils;

import android.content.Context;
import com.qihoo360.replugin.b.c;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;

public final class AssetsUtils {

    public final /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a = new int[QuickExtractResult.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = com.qihoo360.replugin.utils.AssetsUtils.QuickExtractResult.values();
            r0 = r0.length;
            r0 = new int[r0];
            a = r0;
            r0 = a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = com.qihoo360.replugin.utils.AssetsUtils.QuickExtractResult.FAIL;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = com.qihoo360.replugin.utils.AssetsUtils.QuickExtractResult.EXISTED;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.utils.AssetsUtils.1.<clinit>():void");
        }
    }

    public enum QuickExtractResult {
        SUCCESS,
        FAIL,
        EXISTED
    }

    public static final boolean a(Context context, String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append("/");
        stringBuilder.append(str3);
        File file = new File(stringBuilder.toString());
        Closeable a = c.a(context, str);
        if (a == null) {
            if (c.a != null) {
                str3 = new StringBuilder("extractTo: Fail to open ");
                str3.append(str);
                str3.append("from Assets");
                c.d("ws001", str3.toString());
            }
            return false;
        }
        try {
            c.a((InputStream) a, file);
            return true;
        } catch (String str4) {
            str4.printStackTrace();
            return false;
        } finally {
            b.a(a);
        }
    }
}
