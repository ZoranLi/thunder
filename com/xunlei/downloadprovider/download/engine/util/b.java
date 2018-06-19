package com.xunlei.downloadprovider.download.engine.util;

import android.text.TextUtils;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.xllib.b.k;
import java.util.Collection;

/* compiled from: DownloadsUtil */
public abstract class b {
    public static String a(String str) {
        String str2 = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                str2 = str.replaceAll("[/:：\\*\\?\\|\"<>“”!！？]", "_");
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        if (str2 == null) {
            return !TextUtils.isEmpty(str) ? str : "";
        } else {
            return str2;
        }
    }

    public static String b(String str) {
        StringBuilder stringBuilder = new StringBuilder("magnet:?xt=urn:btih:");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static java.lang.String c(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r1);
        if (r0 == 0) goto L_0x0009;
    L_0x0006:
        r1 = "";
        return r1;
    L_0x0009:
        r0 = "xt=urn:btih:([0-9a-fA-F]{40})";	 Catch:{ IllegalStateException -> 0x0023 }
        r0 = java.util.regex.Pattern.compile(r0);	 Catch:{ IllegalStateException -> 0x0023 }
        r1 = r0.matcher(r1);	 Catch:{ IllegalStateException -> 0x0023 }
        r0 = r1.find();	 Catch:{ IllegalStateException -> 0x0023 }
        if (r0 == 0) goto L_0x0023;	 Catch:{ IllegalStateException -> 0x0023 }
    L_0x0019:
        r1 = r1.toMatchResult();	 Catch:{ IllegalStateException -> 0x0023 }
        r0 = 1;	 Catch:{ IllegalStateException -> 0x0023 }
        r1 = r1.group(r0);	 Catch:{ IllegalStateException -> 0x0023 }
        return r1;
    L_0x0023:
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.engine.util.b.c(java.lang.String):java.lang.String");
    }

    public static java.lang.String d(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r1);
        if (r0 == 0) goto L_0x0009;
    L_0x0006:
        r1 = "";
        return r1;
    L_0x0009:
        r0 = "([0-9a-fA-F]{40})";	 Catch:{ IllegalStateException -> 0x0023 }
        r0 = java.util.regex.Pattern.compile(r0);	 Catch:{ IllegalStateException -> 0x0023 }
        r1 = r0.matcher(r1);	 Catch:{ IllegalStateException -> 0x0023 }
        r0 = r1.find();	 Catch:{ IllegalStateException -> 0x0023 }
        if (r0 == 0) goto L_0x0023;	 Catch:{ IllegalStateException -> 0x0023 }
    L_0x0019:
        r1 = r1.toMatchResult();	 Catch:{ IllegalStateException -> 0x0023 }
        r0 = 1;	 Catch:{ IllegalStateException -> 0x0023 }
        r1 = r1.group(r0);	 Catch:{ IllegalStateException -> 0x0023 }
        return r1;
    L_0x0023:
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.engine.util.b.d(java.lang.String):java.lang.String");
    }

    public static String a(String str, long j, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder("cid://");
        stringBuilder.append(str);
        stringBuilder.append("|size|");
        stringBuilder.append(j);
        stringBuilder.append("|gcid|");
        if (str2 == null) {
            str2 = "";
        }
        stringBuilder.append(str2);
        str = stringBuilder.toString();
        if (TextUtils.isEmpty(str3) != null) {
            return str;
        }
        j = new StringBuilder();
        j.append(str);
        j.append("|file|");
        j.append(str3);
        return j.toString();
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (k.b(str)) {
            CharSequence d = k.d(str);
            if (!TextUtils.isEmpty(d)) {
                str = d;
            }
        }
        return k.f(str);
    }

    public static long[] a(Collection<Long> collection) {
        int i = 0;
        long[] jArr = new long[(collection == null ? 0 : collection.size())];
        if (collection != null) {
            for (Long longValue : collection) {
                int i2 = i + 1;
                jArr[i] = longValue.longValue();
                i = i2;
            }
        }
        return jArr;
    }

    public static boolean f(String str) {
        return (TextUtils.isEmpty(str) || str.matches("[0]+") != null) ? null : true;
    }

    public static String a(TaskInfo taskInfo) {
        return taskInfo != null ? taskInfo.mLocalFileName : null;
    }
}
