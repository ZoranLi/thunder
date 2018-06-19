package com.xunlei.downloadprovider.h;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: XLUrlUtils */
public abstract class k {

    /* compiled from: XLUrlUtils */
    public static abstract class a {
        public static b a(String str) {
            b bVar = new b();
            if (TextUtils.isEmpty(str)) {
                return bVar;
            }
            if (!Pattern.matches("[2-7a-zA-Z]{32}", str)) {
                if (!Pattern.matches("[0-9a-fA-F]{40}", str)) {
                    bVar.a = b(str);
                    return bVar;
                }
            }
            bVar = new b();
            bVar.a = com.xunlei.downloadprovider.download.engine.util.b.b(str);
            bVar.b = true;
            return bVar;
        }

        public static String b(String str) {
            try {
                str = c(str);
                Matcher matcher = Pattern.compile("(magnet:\\?\\w+.*)|(ed2k://\\|\\w+.*)|(thunder://[.-_/?&:=+a-z0-9]+)|(https?://\\w+.*)|(ftp://[-a-zA-Z0-9+&@#%?=~_|!:,.;]+/.+)", 2).matcher(str);
                if (matcher.find()) {
                    str = matcher.group();
                }
                return str;
            } catch (String str2) {
                str2.printStackTrace();
                return null;
            }
        }

        @Deprecated
        public static String c(String str) throws UnsupportedEncodingException {
            String trim = !TextUtils.isEmpty(str) ? str.trim() : str;
            if (TextUtils.isEmpty(trim)) {
                return str;
            }
            str = trim.contains("+");
            String str2 = null;
            try {
                Object obj;
                String decode = URLDecoder.decode(trim, "UTF-8");
                for (int i = 0; i < decode.length(); i++) {
                    if (decode.charAt(i) == '�') {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    decode = URLDecoder.decode(trim, "gb2312");
                }
                str2 = str;
                str = decode;
            } catch (String str3) {
                str3.printStackTrace();
                str3 = trim;
            }
            return (TextUtils.isEmpty(str3) || str2 == null) ? str3 : str3.replaceAll(" ", "+");
        }

        public static boolean d(String str) {
            if (str != null) {
                str = str.trim().toLowerCase();
                if (str != null) {
                    if (!str.isEmpty()) {
                        if (Pattern.compile("^((?:http|https|ftp)://(?:[^\\s.]+\\.[^\\s.]+))").matcher(str).find() || Pattern.compile("^(www)\\.[\\w\\d_]+").matcher(str).find() || Pattern.compile("[^一-龥\\s]+\\.(aero|biz|cc|club|cn|co|com|coop|edu|gov|hk|html|idv|info|int|im|is|jp|kim|la|me|mil|mobi|museum|name|net|org|pw|pro|rocks|ren|site|so|space|top|tw|tv|us|vip|wang|xyz)(/)?").matcher(str).find() || Pattern.compile("^\\d+\\.\\d+\\.\\d+\\.\\d+").matcher(str).find() != null) {
                            return true;
                        }
                        return false;
                    }
                }
                return false;
            }
            return false;
        }

        public static String e(String str) {
            if (TextUtils.isEmpty(str) || str.startsWith("http://") || str.startsWith("https://") || str.startsWith("ftp://")) {
                return str;
            }
            StringBuilder stringBuilder = new StringBuilder("http://");
            stringBuilder.append(str);
            return stringBuilder.toString();
        }

        public static String f(String str) {
            for (String str2 : str.split(" ")) {
                if (d(str2)) {
                    return str2;
                }
            }
            return str;
        }
    }

    /* compiled from: XLUrlUtils */
    public static class b {
        public String a;
        public boolean b;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str = i(str);
        if (!(str.endsWith(".rmvb") || str.endsWith(".mkv") || str.endsWith(".rm") || str.endsWith(".avi") || str.endsWith(".mp4") || str.endsWith(".3gp") || str.endsWith(".flv") || str.endsWith(".wmv") || str.endsWith(".mpg") || str.endsWith(".swf"))) {
            if (str.endsWith(".xv") == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str = i(str);
        if (!str.endsWith(".mp3")) {
            if (str.endsWith(".wma") == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return i(str).endsWith(".exe");
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return i(str).endsWith(ShareConstants.PATCH_SUFFIX);
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str = i(str);
        if (!(str.endsWith(".7z") || str.endsWith(".rar") || str.endsWith(".zip") || str.endsWith(".gz") || str.endsWith(".cab") || str.endsWith(".tar"))) {
            if (str.endsWith(".gzip") == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return i(str).endsWith(".torrent");
    }

    @NonNull
    private static String i(String str) {
        str = str.toLowerCase();
        int indexOf = str.indexOf("?");
        return (indexOf == -1 || indexOf == 0) ? str : str.substring(0, indexOf);
    }

    public static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.startsWith("magnet:?");
    }

    public static int h(String str) {
        String b = a.b(str);
        if (!(b == null || str.equals(b))) {
            str = b;
        }
        if (!(str.startsWith("thunder://") || str.startsWith("magnet:?"))) {
            if (!str.startsWith("ed2k://")) {
                if (!str.startsWith("ftp://")) {
                    if (!str.startsWith("http://")) {
                        if (!str.startsWith("https://")) {
                            return 3;
                        }
                    }
                    str = i(str);
                    if (EFileCategoryType.E_OTHER_CATEGORY.equals(XLFileTypeUtil.getFileCategoryTypeByName(str))) {
                        boolean d = d(str);
                        boolean e = e(str);
                        boolean c = c(str);
                        boolean b2 = b(str);
                        boolean a = a(str);
                        str = f(str);
                        if (!(d || e || c || b2 || a || str != null)) {
                            return 2;
                        }
                    }
                } else if (str.endsWith("/") || str.endsWith("html") || str.endsWith("HTML") || str.endsWith("htm")) {
                    return 2;
                } else {
                    if (str.endsWith("HTM") != null) {
                        return 2;
                    }
                }
            }
        }
        return 1;
    }
}
