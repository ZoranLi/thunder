package com.xunlei.xllib.b;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.tencent.connect.common.Constants;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import com.umeng.message.proguard.k;
import com.xunlei.downloadprovider.ad.downloadlist.d;
import com.xunlei.downloadprovider.ad.home.a.f;
import com.xunlei.downloadprovider.pushmessage.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

/* compiled from: PercentEncoding */
public abstract class h {
    static final a a = new a();
    static final b b = new i();
    private static final c c = new c();

    /* compiled from: PercentEncoding */
    static class a {
        static Pattern a;

        a() {
        }

        public final java.lang.String a(java.lang.String r6, java.lang.String r7) throws java.io.UnsupportedEncodingException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r5 = this;
            if (r6 == 0) goto L_0x0080;
        L_0x0002:
            r0 = r6.isEmpty();
            if (r0 == 0) goto L_0x000a;
        L_0x0008:
            goto L_0x0080;
        L_0x000a:
            r0 = a;
            if (r0 != 0) goto L_0x0016;
        L_0x000e:
            r0 = "([%][[A-F][a-f][0-9]][[A-F][a-f][0-9]])+";
            r0 = java.util.regex.Pattern.compile(r0);
            a = r0;
        L_0x0016:
            r0 = a;
            r0 = r0.matcher(r6);
            r1 = new java.lang.StringBuilder;
            r2 = r6.length();
            r1.<init>(r2);
            r2 = 0;
        L_0x0026:
            r3 = r2;
            r4 = r0.find(r2);
            if (r4 == 0) goto L_0x006e;
        L_0x002d:
            r4 = r6.length();
            if (r2 >= r4) goto L_0x006e;
        L_0x0033:
            r2 = r0.toMatchResult();
            r4 = r2.start();
            r2 = r2.end();
            if (r4 <= r3) goto L_0x0048;
        L_0x0041:
            r3 = r6.substring(r3, r4);
            r1.append(r3);
        L_0x0048:
            r3 = r6.substring(r4, r2);
            r3 = r5.a(r3);
            r4 = java.nio.charset.Charset.forName(r7);	 Catch:{ CharacterCodingException -> 0x0068 }
            r4 = r4.newDecoder();	 Catch:{ CharacterCodingException -> 0x0068 }
            r3 = java.nio.ByteBuffer.wrap(r3);	 Catch:{ CharacterCodingException -> 0x0068 }
            r3 = r4.decode(r3);	 Catch:{ CharacterCodingException -> 0x0068 }
            r3 = r3.toString();	 Catch:{ CharacterCodingException -> 0x0068 }
            r1.append(r3);	 Catch:{ CharacterCodingException -> 0x0068 }
            goto L_0x0026;
        L_0x0068:
            r6 = new java.io.UnsupportedEncodingException;
            r6.<init>();
            throw r6;
        L_0x006e:
            r7 = r6.length();
            if (r7 <= r3) goto L_0x007b;
        L_0x0074:
            r6 = r6.substring(r3, r7);
            r1.append(r6);
        L_0x007b:
            r6 = r1.toString();
            return r6;
        L_0x0080:
            return r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.xllib.b.h.a.a(java.lang.String, java.lang.String):java.lang.String");
        }

        protected byte[] a(String str) {
            return b.b(str.replaceAll("%", ""));
        }
    }

    /* compiled from: PercentEncoding */
    static class b {
        private static String[] a = new String[]{"%00", "%01", "%02", "%03", "%04", "%05", "%06", "%07", "%08", "%09", "%0A", "%0B", "%0C", "%0D", "%0E", "%0F", "%10", "%11", "%12", "%13", "%14", "%15", "%16", "%17", "%18", "%19", "%1A", "%1B", "%1C", "%1D", "%1E", "%1F", "%20", "!", "%22", "%23", "%24", "%25", "%26", "'", k.s, k.t, "*", "%2B", "%2C", "-", ".", "%2F", "0", "1", "2", "3", "4", "5", Constants.VIA_SHARE_TYPE_INFO, "7", "8", "9", "%3A", "%3B", "%3C", "%3D", "%3E", "%3F", "%40", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "%5B", "%5C", "%5D", "%5E", "_", "%60", "a", com.xunlei.downloadprovider.ad.common.adget.b.b.a, com.xunlei.downloadprovider.download.tasklist.list.feed.e.c.a, d.a, e.a, f.a, "g", IXAdRequestInfo.HEIGHT, "i", "j", "k", "l", "m", IXAdRequestInfo.AD_COUNT, "o", "p", IXAdRequestInfo.COST_NAME, "r", "s", DispatchConstants.TIMESTAMP, "u", "v", IXAdRequestInfo.WIDTH, "x", "y", "z", "%7B", "%7C", "%7D", com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR, "%7F", "%80", "%81", "%82", "%83", "%84", "%85", "%86", "%87", "%88", "%89", "%8A", "%8B", "%8C", "%8D", "%8E", "%8F", "%90", "%91", "%92", "%93", "%94", "%95", "%96", "%97", "%98", "%99", "%9A", "%9B", "%9C", "%9D", "%9E", "%9F", "%A0", "%A1", "%A2", "%A3", "%A4", "%A5", "%A6", "%A7", "%A8", "%A9", "%AA", "%AB", "%AC", "%AD", "%AE", "%AF", "%B0", "%B1", "%B2", "%B3", "%B4", "%B5", "%B6", "%B7", "%B8", "%B9", "%BA", "%BB", "%BC", "%BD", "%BE", "%BF", "%C0", "%C1", "%C2", "%C3", "%C4", "%C5", "%C6", "%C7", "%C8", "%C9", "%CA", "%CB", "%CC", "%CD", "%CE", "%CF", "%D0", "%D1", "%D2", "%D3", "%D4", "%D5", "%D6", "%D7", "%D8", "%D9", "%DA", "%DB", "%DC", "%DD", "%DE", "%DF", "%E0", "%E1", "%E2", "%E3", "%E4", "%E5", "%E6", "%E7", "%E8", "%E9", "%EA", "%EB", "%EC", "%ED", "%EE", "%EF", "%F0", "%F1", "%F2", "%F3", "%F4", "%F5", "%F6", "%F7", "%F8", "%F9", "%FA", "%FB", "%FC", "%FD", "%FE", "%FF"};

        protected boolean a(char c) {
            return false;
        }

        b() {
        }

        public final String a(String str, String str2) throws UnsupportedEncodingException {
            str = str.getBytes(str2);
            if (str.length == null) {
                return "";
            }
            str2 = new StringBuilder(str.length);
            for (int i = 0; i < str.length; i++) {
                int i2 = str[i] & 255;
                if (i2 > 32) {
                    if (i2 < Opcodes.NEG_FLOAT) {
                        if (a((char) str[i])) {
                            str2.append((char) str[i]);
                        } else {
                            str2.append(a[i2]);
                        }
                    }
                }
                str2.append(a[i2]);
            }
            return str2.toString();
        }
    }

    /* compiled from: PercentEncoding */
    public static class c {
        private static final b a = new b();
        private static final a b = new a();

        /* compiled from: PercentEncoding */
        private static class a extends a {
            private a() {
            }

            protected final byte[] a(String str) {
                str = super.a(str);
                if (str.length <= 0) {
                    return str;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length);
                for (int i = 0; i < str.length; i++) {
                    int i2;
                    byte b = str[i];
                    if (b < (byte) 0 || b >= (byte) 32) {
                        if ("#;,/?:@&=+$".indexOf(b) == -1) {
                            i2 = 0;
                            if (i2 == 0) {
                                try {
                                    byteArrayOutputStream.write(37);
                                    byteArrayOutputStream.write(a.a(str, i, 1, 0));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                byteArrayOutputStream.write(b);
                            }
                        }
                    }
                    i2 = 1;
                    if (i2 == 0) {
                        byteArrayOutputStream.write(b);
                    } else {
                        byteArrayOutputStream.write(37);
                        byteArrayOutputStream.write(a.a(str, i, 1, 0));
                    }
                }
                return byteArrayOutputStream.toByteArray();
            }
        }

        /* compiled from: PercentEncoding */
        private static class b extends b {
            private b() {
            }

            protected final boolean a(char c) {
                return "-_.!~*'();,/?:@&=+$#".indexOf(c) != '￿';
            }
        }

        public static String a(String str, String str2) throws UnsupportedEncodingException {
            return a.a(str, str2);
        }

        public static String b(String str, String str2) throws UnsupportedEncodingException {
            return b.a(str, str2);
        }
    }

    public static String a(String str, String str2) throws UnsupportedEncodingException {
        return a.a(str, str2);
    }

    public static String b(String str, String str2) throws UnsupportedEncodingException {
        return b.a(str, str2);
    }

    public static String a(String str) throws UnsupportedEncodingException {
        return c.a(str, "UTF-8");
    }

    public static String c(String str, String str2) throws UnsupportedEncodingException {
        return c.b(str, str2);
    }
}
