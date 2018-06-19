package com.xunlei.download.proguard;

import android.webkit.MimeTypeMap;
import java.util.Locale;

/* compiled from: MimeUtil */
public class am {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        str = str.trim().toLowerCase(new Locale("", ""));
        int indexOf = str.indexOf(59);
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        return str;
    }

    public static String b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return "";
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(lastIndexOf + 1));
    }
}
