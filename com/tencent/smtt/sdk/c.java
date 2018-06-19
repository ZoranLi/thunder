package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.d;
import com.tencent.tinker.android.dex.DexFormat;
import java.util.UnknownFormatConversionException;

public class c {
    static int a = 5;
    static int b = 16;
    static char[] c = new char[16];
    static String d = "dex2oat-cmdline";
    static long e = 4096;

    public static String a(Context context, String str) {
        d dVar = new d(str);
        dVar.a(c);
        boolean z = true;
        if (c[a] != '\u0001') {
            z = false;
        }
        dVar.a(z);
        dVar.a(e);
        return a(new String(a(dVar)));
    }

    private static String a(String str) {
        String[] split = str.split(new String(DexFormat.MAGIC_SUFFIX));
        int i = 0;
        while (i < split.length) {
            int i2 = i + 1;
            String str2 = split[i];
            int i3 = i2 + 1;
            String str3 = split[i2];
            if (str2.equals(d)) {
                return str3;
            }
            i = i3;
        }
        return "";
    }

    public static char[] a(d dVar) {
        char[] cArr = new char[4];
        char[] cArr2 = new char[4];
        dVar.a(cArr);
        if (cArr[0] == 'o' && cArr[1] == 'a') {
            if (cArr[2] == 't') {
                dVar.a(cArr2);
                dVar.a();
                dVar.a();
                dVar.a();
                dVar.a();
                dVar.a();
                dVar.a();
                dVar.a();
                dVar.a();
                if (cArr2[1] <= '4') {
                    dVar.a();
                    dVar.a();
                    dVar.a();
                }
                dVar.a();
                dVar.a();
                dVar.a();
                dVar.a();
                dVar.a();
                dVar.a();
                dVar.a();
                cArr2 = new char[dVar.a()];
                dVar.a(cArr2);
                return cArr2;
            }
        }
        throw new UnknownFormatConversionException(String.format("Invalid art magic %c%c%c", new Object[]{Character.valueOf(cArr[0]), Character.valueOf(cArr[1]), Character.valueOf(cArr[2])}));
    }
}
