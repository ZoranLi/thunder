package com.xunlei.download.proguard;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Environment;
import com.xunlei.downloadlib.XLDownloadManager;
import java.io.Closeable;
import java.io.File;

/* compiled from: XlHelpers */
public class ab {
    private static String a;

    public static android.graphics.Bitmap a(android.content.Context r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r2 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0019 }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x0019 }
        r3 = r2.getApplicationInfo(r3, r1);	 Catch:{ NameNotFoundException -> 0x0019 }
        r2 = r3.loadIcon(r2);	 Catch:{ NameNotFoundException -> 0x0019 }
        r3 = r2 instanceof android.graphics.drawable.BitmapDrawable;	 Catch:{ NameNotFoundException -> 0x0019 }
        if (r3 == 0) goto L_0x0019;	 Catch:{ NameNotFoundException -> 0x0019 }
    L_0x0012:
        r2 = (android.graphics.drawable.BitmapDrawable) r2;	 Catch:{ NameNotFoundException -> 0x0019 }
        r2 = r2.getBitmap();	 Catch:{ NameNotFoundException -> 0x0019 }
        r0 = r2;
    L_0x0019:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.ab.a(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    public static boolean a(Context context) {
        context = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return (context == null || context.isConnected() == null) ? null : true;
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        str = Uri.parse(str);
        if (str.getScheme().equals("file")) {
            return str.getPath().startsWith(Environment.getExternalStorageDirectory().getPath());
        }
        return false;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Closeable closeable2) {
                throw closeable2;
            } catch (Throwable e) {
                an.a(e);
            }
        }
    }

    public static void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Cursor cursor2) {
                throw cursor2;
            } catch (Throwable e) {
                an.a(e);
            }
        }
    }

    public static String b(Context context, String str) {
        context = XLDownloadManager.getInstance(context).parserThunderUrl(str);
        if (context == null) {
            return str;
        }
        return context.trim();
    }

    public static String a(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(File.separator);
                stringBuilder.append(".");
                stringBuilder.append(str2);
                stringBuilder.append(".torrent");
                return stringBuilder.toString();
            }
        }
        return null;
    }
}
