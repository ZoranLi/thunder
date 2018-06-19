package com.xunlei.downloadprovider.download.engine.kernel;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.xunlei.xllib.android.b;
import com.xunlei.xllib.b.k;
import java.io.File;

/* compiled from: DownloadLocalFileServer */
public final class i {
    public static String a(Context context, String str, boolean z) {
        str = g.a().a(str);
        if (TextUtils.isEmpty(str) || z) {
            return str;
        }
        context = b.g(context);
        return !TextUtils.isEmpty(context) ? str.replace("127.0.0.1", context) : str;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            str = Uri.parse(str).getPath();
            if (!TextUtils.isEmpty(str)) {
                str = new File(k.b(str, "UTF-8")).getPath();
            }
            return str;
        } catch (String str2) {
            str2.printStackTrace();
            return "";
        }
    }
}
