package com.sina.weibo.sdk.utils;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.taobao.accs.utl.UtilityImpl;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public final class BitmapHelper {
    public static boolean makesureSizeNotTooLarge(Rect rect) {
        return (rect.width() * rect.height()) * 2 > UtilityImpl.TNET_FILE_SIZE ? null : true;
    }

    public static int getSampleSizeOfNotTooLarge(Rect rect) {
        double width = ((((double) rect.width()) * ((double) rect.height())) * 2.0d) / 5242880.0d;
        return width >= 1.0d ? (int) width : 1;
    }

    public static int getSampleSizeAutoFitToScreen(int i, int i2, int i3, int i4) {
        if (i2 != 0) {
            if (i != 0) {
                return Math.min(Math.max(i3 / i, i4 / i2), Math.max(i4 / i, i3 / i2));
            }
        }
        return 1;
    }

    public static boolean verifyBitmap(byte[] bArr) {
        return verifyBitmap(new ByteArrayInputStream(bArr));
    }

    public static boolean verifyBitmap(InputStream inputStream) {
        if (inputStream == null) {
            return false;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        if (!(inputStream instanceof BufferedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        BitmapFactory.decodeStream(inputStream, null, options);
        try {
            inputStream.close();
        } catch (InputStream inputStream2) {
            inputStream2.printStackTrace();
        }
        return options.outHeight > null && options.outWidth > null;
    }

    public static boolean verifyBitmap(String str) {
        try {
            return verifyBitmap(new FileInputStream(str));
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }
}
