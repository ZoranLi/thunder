package com.xunlei.download.proguard;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import com.xunlei.download.Downloads.Impl;
import java.io.File;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: Helpers */
public class k {
    public static Random a = new Random(SystemClock.uptimeMillis());
    private static final int b = 80;
    private static final Pattern c = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
    private static final Object d = new Object();

    /* compiled from: Helpers */
    static class a {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;
        public static final int e = 4;
        public static final int f = 5;
        public static final int g = 6;
        public static final int h = 7;
        public static final int i = 8;
        public static final int j = 9;
        private final String k;
        private final Set<String> l;
        private int m = 0;
        private int n = 0;
        private final char[] o;

        private static final boolean a(char c) {
            if (c != '_' && (c < 'A' || c > 'Z')) {
                if (c < 'a' || c > 'z') {
                    return false;
                }
            }
            return true;
        }

        private static final boolean b(char c) {
            if (c != '_' && ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z'))) {
                if (c < '0' || c > '9') {
                    return false;
                }
            }
            return true;
        }

        public a(String str, Set<String> set) {
            this.k = str;
            this.l = set;
            this.o = new char[this.k.length()];
            this.k.getChars(0, this.o.length, this.o, 0);
            b();
        }

        public int a() {
            return this.n;
        }

        public void b() {
            char[] cArr = this.o;
            while (this.m < cArr.length && cArr[this.m] == ' ') {
                this.m++;
            }
            if (this.m == cArr.length) {
                this.n = 9;
            } else if (cArr[this.m] == '(') {
                this.m++;
                this.n = 1;
            } else if (cArr[this.m] == ')') {
                this.m++;
                this.n = 2;
            } else if (cArr[this.m] == '?') {
                this.m++;
                this.n = 6;
            } else if (cArr[this.m] == '=') {
                this.m++;
                this.n = 5;
                if (this.m < cArr.length && cArr[this.m] == '=') {
                    this.m++;
                }
            } else if (cArr[this.m] == '>') {
                this.m++;
                this.n = 5;
                if (this.m < cArr.length && cArr[this.m] == '=') {
                    this.m++;
                }
            } else if (cArr[this.m] == '<') {
                this.m++;
                this.n = 5;
                if (this.m < cArr.length && (cArr[this.m] == '=' || cArr[this.m] == '>')) {
                    this.m++;
                }
            } else if (cArr[this.m] == '!') {
                this.m++;
                this.n = 5;
                if (this.m >= cArr.length || cArr[this.m] != '=') {
                    throw new IllegalArgumentException("Unexpected character after !");
                }
                this.m++;
            } else if (a(cArr[this.m])) {
                int i = this.m;
                this.m++;
                while (this.m < cArr.length && b(cArr[this.m])) {
                    this.m++;
                }
                String substring = this.k.substring(i, this.m);
                if (this.m - i <= 4) {
                    if (substring.equals("IS")) {
                        this.n = 7;
                        return;
                    }
                    if (!substring.equals("OR")) {
                        if (!substring.equals("AND")) {
                            if (substring.equals("NULL")) {
                                this.n = 8;
                                return;
                            }
                        }
                    }
                    this.n = 3;
                    return;
                }
                if (this.l.contains(substring)) {
                    this.n = 4;
                    return;
                }
                r2 = new StringBuilder("unrecognized column or keyword ");
                r2.append(substring);
                throw new IllegalArgumentException(r2.toString());
            } else if (cArr[this.m] == '\'') {
                this.m++;
                while (this.m < cArr.length) {
                    if (cArr[this.m] == '\'') {
                        if (this.m + 1 >= cArr.length || cArr[this.m + 1] != '\'') {
                            break;
                        }
                        this.m++;
                    }
                    this.m++;
                }
                if (this.m == cArr.length) {
                    throw new IllegalArgumentException("unterminated string");
                }
                this.m++;
                this.n = 6;
            } else {
                r2 = new StringBuilder("illegal character: ");
                r2.append(cArr[this.m]);
                throw new IllegalArgumentException(r2.toString());
            }
        }
    }

    private k() {
    }

    private static java.lang.String a(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = c;	 Catch:{ IllegalStateException -> 0x0012 }
        r1 = r0.matcher(r1);	 Catch:{ IllegalStateException -> 0x0012 }
        r0 = r1.find();	 Catch:{ IllegalStateException -> 0x0012 }
        if (r0 == 0) goto L_0x0012;	 Catch:{ IllegalStateException -> 0x0012 }
    L_0x000c:
        r0 = 1;	 Catch:{ IllegalStateException -> 0x0012 }
        r1 = r1.group(r0);	 Catch:{ IllegalStateException -> 0x0012 }
        return r1;
    L_0x0012:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.k.a(java.lang.String):java.lang.String");
    }

    public static String a(Context context, String str, String str2, String str3, String str4, String str5, int i, long j, q qVar, String str6) throws p {
        if (j < 0) {
            j = 0;
        }
        if (str2 != null && str2.indexOf("=?UTF8?B?") > 0) {
            int lastIndexOf = str2.lastIndexOf(File.separator);
            String substring = str2.substring(0, lastIndexOf);
            String substring2 = str2.substring(lastIndexOf + 1);
            int indexOf = substring2.indexOf("=?UTF8?B?") + 9;
            int indexOf2 = substring2.indexOf("?", indexOf);
            if (indexOf2 > 0) {
                str2 = new File(substring, new String(Base64.decode(substring2.substring(indexOf, indexOf2).getBytes(), 0))).getPath();
            }
        }
        File file = null;
        if (i == 4) {
            str2 = Uri.parse(str2).getPath();
            if (str2.endsWith("{filename}") != null) {
                if (str6 == null || str6.length() == null) {
                    str6 = a(str, null, str3, str4, i);
                }
                str6 = new File(str2.substring(0, str2.length() - 10), str6).getAbsolutePath();
            } else {
                str6 = str2;
            }
        } else {
            file = qVar.a(str5, i, j);
            if (str6 == null || str6.length() <= null) {
                str6 = a(str, str2, str3, str4, i);
            }
        }
        return a(b(str6), str5, i, file);
    }

    public static boolean a(int i, String str) {
        if (!TextUtils.isEmpty(str) && i == 4 && Uri.parse(str).getPath().endsWith("{filename}") == 0) {
            return true;
        }
        return false;
    }

    public static boolean b(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (i == 4) {
                try {
                    if (new File(Uri.parse(str).getPath()).getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath()) == 0) {
                        return true;
                    }
                    return false;
                } catch (int i2) {
                    i2.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }

    private static String b(String str) {
        File file = new File(str);
        str = file.getParent();
        String name = file.getName();
        if (!TextUtils.isEmpty(name)) {
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0) {
                String substring = name.substring(lastIndexOf);
                name = c(name.substring(0, lastIndexOf));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(name);
                stringBuilder.append(substring);
                name = stringBuilder.toString();
            } else {
                name = c(name);
            }
        }
        if (TextUtils.isEmpty(str)) {
            return name;
        }
        return new File(str, name).getAbsolutePath();
    }

    private static String c(String str) {
        if (str.length() > 80) {
            return str.substring(0, 80).trim();
        }
        return str.trim();
    }

    static String a(String str, String str2, int i, File file) throws p {
        int i2;
        String str3;
        StringBuilder stringBuilder;
        boolean equalsIgnoreCase;
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            if (lastIndexOf >= str.lastIndexOf(47)) {
                i2 = 0;
                if (i != 4) {
                    if (i2 == 0) {
                        str2 = "";
                    } else {
                        str2 = str.substring(lastIndexOf);
                        str = str.substring(0, lastIndexOf);
                    }
                } else if (i2 == 0) {
                    str2 = a(str2, true);
                } else {
                    str2 = a(str2, i, str, lastIndexOf);
                    str = str.substring(0, lastIndexOf);
                }
                str3 = c.s;
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(str2);
                equalsIgnoreCase = str3.equalsIgnoreCase(stringBuilder.toString());
                if (file != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(file.getPath());
                    stringBuilder.append(File.separator);
                    stringBuilder.append(str);
                    str = stringBuilder.toString();
                }
                synchronized (d) {
                    str = a(i, str, str2, equalsIgnoreCase);
                    try {
                        str2 = new File(str).getParentFile();
                        if (str2.exists() == 0) {
                            str2.mkdirs();
                        }
                        new File(str).createNewFile();
                    } catch (String str22) {
                        stringBuilder = new StringBuilder("Failed to create target file ");
                        stringBuilder.append(str);
                        throw new p(Impl.STATUS_FILE_ERROR, stringBuilder.toString(), str22);
                    }
                }
                return str;
            }
        }
        i2 = true;
        if (i != 4) {
            if (i2 == 0) {
                str22 = a(str22, i, str, lastIndexOf);
                str = str.substring(0, lastIndexOf);
            } else {
                str22 = a(str22, true);
            }
        } else if (i2 == 0) {
            str22 = str.substring(lastIndexOf);
            str = str.substring(0, lastIndexOf);
        } else {
            str22 = "";
        }
        str3 = c.s;
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str22);
        equalsIgnoreCase = str3.equalsIgnoreCase(stringBuilder.toString());
        if (file != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(file.getPath());
            stringBuilder.append(File.separator);
            stringBuilder.append(str);
            str = stringBuilder.toString();
        }
        synchronized (d) {
            str = a(i, str, str22, equalsIgnoreCase);
            str22 = new File(str).getParentFile();
            if (str22.exists() == 0) {
                str22.mkdirs();
            }
            new File(str).createNewFile();
        }
        return str;
    }

    private static String a(String str, String str2, String str3, String str4, int i) {
        if (str2 == null || str2.endsWith("/")) {
            str2 = null;
        } else {
            int lastIndexOf = str2.lastIndexOf(47) + 1;
            if (lastIndexOf > 0) {
                str2 = str2.substring(lastIndexOf);
            }
        }
        if (str2 == null && str3 != null) {
            str2 = a(str3);
            if (str2 != null) {
                str3 = str2.lastIndexOf(47) + 1;
                if (str3 > null) {
                    str2 = str2.substring(str3);
                }
            }
        }
        if (str2 == null && str4 != null) {
            str4 = Uri.decode(str4);
            if (!(str4 == null || str4.endsWith("/") || str4.indexOf(63) >= 0)) {
                str2 = str4.lastIndexOf(47) + 1;
                str2 = str2 > null ? str4.substring(str2) : str4;
            }
        }
        if (str2 == null) {
            str = Uri.decode(str);
            if (str != null && str.endsWith("/") == null && str.indexOf(63) < null) {
                str3 = str.lastIndexOf(47) + 1;
                if (str3 > null) {
                    str2 = str.substring(str3);
                }
            }
        }
        if (str2 == null) {
            str2 = c.l;
        }
        return d(str2);
    }

    private static String a(String str, boolean z) {
        String extensionFromMimeType;
        if (str != null) {
            extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
            if (extensionFromMimeType != null) {
                StringBuilder stringBuilder = new StringBuilder(".");
                stringBuilder.append(extensionFromMimeType);
                extensionFromMimeType = stringBuilder.toString();
            }
        } else {
            extensionFromMimeType = null;
        }
        if (extensionFromMimeType != null) {
            return extensionFromMimeType;
        }
        if (str == null || !str.toLowerCase().startsWith("text/")) {
            return z ? c.o : extensionFromMimeType;
        } else {
            if (str.equalsIgnoreCase("text/html") != null) {
                return c.m;
            }
            return z ? c.n : extensionFromMimeType;
        }
    }

    private static String a(String str, int i, String str2, int i2) {
        if (str != null) {
            i = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2.substring(i2 + 1));
            if (i == 0 || i.equalsIgnoreCase(str) == 0) {
                str = a(str, (boolean) 0);
                return str != null ? str2.substring(i2) : str;
            }
        }
        str = null;
        if (str != null) {
        }
    }

    private static String a(int i, String str, String str2, boolean z) throws p {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str2);
        String stringBuilder2 = stringBuilder.toString();
        if (!new File(stringBuilder2).exists() && (!z || (i != 1 && i != true && i != true && i != true))) {
            return stringBuilder2;
        }
        i = new StringBuilder();
        i.append(str);
        i.append("-");
        i = i.toString();
        str = 1;
        z = str;
        while (str < 1000000000) {
            for (int i2 = 0; i2 < 9; i2++) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(i);
                stringBuilder3.append(z);
                stringBuilder3.append(str2);
                String stringBuilder4 = stringBuilder3.toString();
                if (!new File(stringBuilder4).exists()) {
                    return stringBuilder4;
                }
                z += a.nextInt(str) + 1;
            }
            str *= 10;
        }
        throw new p(Impl.STATUS_FILE_ERROR, "failed to generate an unused filename on internal download storage");
    }

    public static boolean a(String str, File file) {
        try {
            str = new File(str).getCanonicalPath();
            String[] strArr = new String[]{file.getCanonicalPath(), Environment.getDownloadCacheDirectory().getCanonicalPath(), Environment.getExternalStorageDirectory().getCanonicalPath()};
            for (file = null; file < 3; file++) {
                if (str.startsWith(strArr[file])) {
                    return true;
                }
            }
            return false;
        } catch (String str2) {
            StringBuilder stringBuilder = new StringBuilder("Failed to resolve canonical path: ");
            stringBuilder.append(str2);
            an.c("DownloadManager", stringBuilder.toString());
            return false;
        }
    }

    public static void a(String str, Set<String> set) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    a aVar = new a(str, set);
                    a(aVar);
                    if (aVar.a() != 9) {
                        throw new IllegalArgumentException("syntax error");
                    }
                }
            } catch (Set<String> set2) {
                StringBuilder stringBuilder = new StringBuilder("invalid selection [");
                stringBuilder.append(str);
                stringBuilder.append("] triggered ");
                stringBuilder.append(set2);
                an.b("DownloadManager", stringBuilder.toString());
                throw set2;
            }
        }
    }

    private static void a(a aVar) {
        while (true) {
            if (aVar.a() == 1) {
                aVar.b();
                a(aVar);
                if (aVar.a() != 2) {
                    throw new IllegalArgumentException("syntax error, unmatched parenthese");
                }
                aVar.b();
            } else {
                b(aVar);
            }
            if (aVar.a() == 3) {
                aVar.b();
            } else {
                return;
            }
        }
    }

    private static void b(a aVar) {
        if (aVar.a() != 4) {
            throw new IllegalArgumentException("syntax error, expected column name");
        }
        aVar.b();
        if (aVar.a() == 5) {
            aVar.b();
            if (aVar.a() != 6) {
                throw new IllegalArgumentException("syntax error, expected quoted string");
            }
            aVar.b();
        } else if (aVar.a() == 7) {
            aVar.b();
            if (aVar.a() != 8) {
                throw new IllegalArgumentException("syntax error, expected NULL");
            }
            aVar.b();
        } else {
            throw new IllegalArgumentException("syntax error after column name");
        }
    }

    private static String d(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        int i2 = i;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (!((charAt >= '\u0000' && charAt <= '\u001f') || charAt == '\"' || charAt == '*' || charAt == '/' || charAt == ':' || charAt == '<' || charAt == '>' || charAt == '?' || charAt == '\\' || charAt == '|')) {
                if (charAt != '') {
                    stringBuffer.append(charAt);
                    i2 = 0;
                    i++;
                }
            }
            if (i2 == 0) {
                stringBuffer.append('_');
                i2 = 1;
            }
            i++;
        }
        return stringBuffer.toString();
    }
}
