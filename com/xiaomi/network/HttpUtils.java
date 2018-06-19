package com.xiaomi.network;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import com.xiaomi.channel.commonutils.network.c;
import com.xiaomi.channel.commonutils.network.d;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class HttpUtils {

    public static class DefaultHttpGetProcessor extends HttpProcessor {
        public DefaultHttpGetProcessor() {
            super(1);
        }

        public String b(Context context, String str, List<c> list) {
            URL url;
            if (list == null) {
                url = new URL(str);
            } else {
                Builder buildUpon = Uri.parse(str).buildUpon();
                for (c cVar : list) {
                    buildUpon.appendQueryParameter(cVar.a(), cVar.b());
                }
                url = new URL(buildUpon.toString());
            }
            return d.a(context, url);
        }
    }

    static int a(int i, int i2) {
        return ((1080 + (((i2 + 243) / 1448) * Opcodes.LONG_TO_INT)) + i) + i2;
    }

    static int a(int i, int i2, int i3) {
        return (((1011 + (((i2 + 200) / 1448) * Opcodes.LONG_TO_INT)) + i2) + i) + i3;
    }

    private static int a(HttpProcessor httpProcessor, String str, List<c> list, String str2) {
        if (httpProcessor.a() == 1) {
            return a(str.length(), a(str2));
        }
        if (httpProcessor.a() != 2) {
            return -1;
        }
        return a(str.length(), a((List) list), a(str2));
    }

    static int a(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r2);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0010 }
        r2 = r2.getBytes(r0);	 Catch:{ UnsupportedEncodingException -> 0x0010 }
        r2 = r2.length;	 Catch:{ UnsupportedEncodingException -> 0x0010 }
        return r2;
    L_0x0010:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.network.HttpUtils.a(java.lang.String):int");
    }

    static int a(List<c> list) {
        int i = 0;
        for (c cVar : list) {
            if (!TextUtils.isEmpty(cVar.a())) {
                i += cVar.a().length();
            }
            if (!TextUtils.isEmpty(cVar.b())) {
                i += cVar.b().length();
            }
        }
        return i * 2;
    }

    public static String a(Context context, String str, List<c> list) {
        return a(context, str, list, new DefaultHttpGetProcessor(), true);
    }

    public static String a(Context context, String str, List<c> list, HttpProcessor httpProcessor, boolean z) {
        Fallback fallback;
        List list2;
        Exception e;
        String str2;
        Exception exception;
        String str3;
        long a;
        Context context2 = context;
        String str4 = str;
        List<c> list3 = list;
        HttpProcessor httpProcessor2 = httpProcessor;
        if (d.c(context)) {
            try {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    Fallback fallbacksByURL = HostManager.getInstance().getFallbacksByURL(str4);
                    if (fallbacksByURL != null) {
                        arrayList = fallbacksByURL.a(str4);
                    }
                    fallback = fallbacksByURL;
                } else {
                    fallback = null;
                }
                if (!arrayList.contains(str4)) {
                    arrayList.add(str4);
                }
                Iterator it = arrayList.iterator();
                String str5 = null;
                while (it.hasNext()) {
                    String str6 = (String) it.next();
                    List arrayList2 = list3 != null ? new ArrayList(list3) : null;
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        if (!httpProcessor2.a(context2, str6, arrayList2)) {
                            return str5;
                        }
                        String b = httpProcessor2.b(context2, str6, arrayList2);
                        try {
                            if (TextUtils.isEmpty(b)) {
                                str5 = b;
                                if (fallback != null) {
                                    list2 = arrayList2;
                                    try {
                                        fallback.a(str6, System.currentTimeMillis() - currentTimeMillis, (long) a(httpProcessor2, str6, arrayList2, str5), null);
                                    } catch (IOException e2) {
                                        e = e2;
                                        str2 = str5;
                                        exception = e;
                                        if (fallback == null) {
                                            str3 = str2;
                                        } else {
                                            a = (long) a(httpProcessor2, str6, list2, str2);
                                            str3 = str2;
                                            fallback.a(str6, System.currentTimeMillis() - currentTimeMillis, a, exception);
                                        }
                                        exception.printStackTrace();
                                        str5 = str3;
                                    }
                                }
                            } else if (fallback == null) {
                                return b;
                            } else {
                                str5 = b;
                                fallback.a(str6, System.currentTimeMillis() - currentTimeMillis, (long) a(httpProcessor2, str6, arrayList2, b));
                                return str5;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            str5 = b;
                            list2 = arrayList2;
                            str2 = str5;
                            exception = e;
                            if (fallback == null) {
                                a = (long) a(httpProcessor2, str6, list2, str2);
                                str3 = str2;
                                fallback.a(str6, System.currentTimeMillis() - currentTimeMillis, a, exception);
                            } else {
                                str3 = str2;
                            }
                            exception.printStackTrace();
                            str5 = str3;
                        }
                    } catch (IOException e4) {
                        e = e4;
                    }
                }
                return str5;
            } catch (MalformedURLException e5) {
                e5.printStackTrace();
            }
        }
        return null;
    }
}
