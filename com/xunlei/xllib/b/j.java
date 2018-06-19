package com.xunlei.xllib.b;

import android.text.TextUtils;
import java.security.InvalidParameterException;

/* compiled from: StringUtil */
public abstract class j {
    public static java.lang.String a(byte[] r4, int r5, int r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = "UTF-8";	 Catch:{ CharacterCodingException -> 0x00a0, all -> 0x0060 }
        r1 = java.nio.charset.Charset.forName(r1);	 Catch:{ CharacterCodingException -> 0x00a0, all -> 0x0060 }
        r1 = r1.newDecoder();	 Catch:{ CharacterCodingException -> 0x00a0, all -> 0x0060 }
        r2 = java.nio.ByteBuffer.wrap(r4, r5, r6);	 Catch:{ CharacterCodingException -> 0x00a0, all -> 0x0060 }
        r1 = r1.decode(r2);	 Catch:{ CharacterCodingException -> 0x00a0, all -> 0x0060 }
        if (r1 == 0) goto L_0x001a;	 Catch:{ CharacterCodingException -> 0x00a0, all -> 0x0060 }
    L_0x0015:
        r1 = r1.toString();	 Catch:{ CharacterCodingException -> 0x00a0, all -> 0x0060 }
        r0 = r1;
    L_0x001a:
        if (r0 != 0) goto L_0x00de;
    L_0x001c:
        r1 = "GBK";	 Catch:{ CharacterCodingException -> 0x0053, all -> 0x0044 }
        r1 = java.nio.charset.Charset.forName(r1);	 Catch:{ CharacterCodingException -> 0x0053, all -> 0x0044 }
        r1 = r1.newDecoder();	 Catch:{ CharacterCodingException -> 0x0053, all -> 0x0044 }
        r2 = java.nio.ByteBuffer.wrap(r4, r5, r6);	 Catch:{ CharacterCodingException -> 0x0053, all -> 0x0044 }
        r1 = r1.decode(r2);	 Catch:{ CharacterCodingException -> 0x0053, all -> 0x0044 }
        if (r1 == 0) goto L_0x0035;	 Catch:{ CharacterCodingException -> 0x0053, all -> 0x0044 }
    L_0x0030:
        r1 = r1.toString();	 Catch:{ CharacterCodingException -> 0x0053, all -> 0x0044 }
        r0 = r1;
    L_0x0035:
        if (r0 != 0) goto L_0x00de;
    L_0x0037:
        r0 = new java.lang.String;
        r1 = "ISO-8859-1";
        r1 = java.nio.charset.Charset.forName(r1);
        r0.<init>(r4, r5, r6, r1);
        goto L_0x00de;
    L_0x0044:
        r1 = move-exception;
        if (r0 != 0) goto L_0x0052;
    L_0x0047:
        r0 = new java.lang.String;
        r2 = "ISO-8859-1";
        r2 = java.nio.charset.Charset.forName(r2);
        r0.<init>(r4, r5, r6, r2);
    L_0x0052:
        throw r1;
    L_0x0053:
        r0 = new java.lang.String;
        r1 = "ISO-8859-1";
        r1 = java.nio.charset.Charset.forName(r1);
        r0.<init>(r4, r5, r6, r1);
        goto L_0x00de;
    L_0x0060:
        r1 = move-exception;
        r2 = "GBK";	 Catch:{ CharacterCodingException -> 0x0094, all -> 0x0087 }
        r2 = java.nio.charset.Charset.forName(r2);	 Catch:{ CharacterCodingException -> 0x0094, all -> 0x0087 }
        r2 = r2.newDecoder();	 Catch:{ CharacterCodingException -> 0x0094, all -> 0x0087 }
        r3 = java.nio.ByteBuffer.wrap(r4, r5, r6);	 Catch:{ CharacterCodingException -> 0x0094, all -> 0x0087 }
        r2 = r2.decode(r3);	 Catch:{ CharacterCodingException -> 0x0094, all -> 0x0087 }
        if (r2 == 0) goto L_0x0079;	 Catch:{ CharacterCodingException -> 0x0094, all -> 0x0087 }
    L_0x0075:
        r0 = r2.toString();	 Catch:{ CharacterCodingException -> 0x0094, all -> 0x0087 }
    L_0x0079:
        if (r0 != 0) goto L_0x009f;
    L_0x007b:
        r0 = new java.lang.String;
        r2 = "ISO-8859-1";
        r2 = java.nio.charset.Charset.forName(r2);
        r0.<init>(r4, r5, r6, r2);
        goto L_0x009f;
    L_0x0087:
        r0 = move-exception;
        r1 = new java.lang.String;
        r2 = "ISO-8859-1";
        r2 = java.nio.charset.Charset.forName(r2);
        r1.<init>(r4, r5, r6, r2);
        throw r0;
    L_0x0094:
        r0 = new java.lang.String;
        r2 = "ISO-8859-1";
        r2 = java.nio.charset.Charset.forName(r2);
        r0.<init>(r4, r5, r6, r2);
    L_0x009f:
        throw r1;
    L_0x00a0:
        r1 = "GBK";	 Catch:{ CharacterCodingException -> 0x00d3, all -> 0x00c6 }
        r1 = java.nio.charset.Charset.forName(r1);	 Catch:{ CharacterCodingException -> 0x00d3, all -> 0x00c6 }
        r1 = r1.newDecoder();	 Catch:{ CharacterCodingException -> 0x00d3, all -> 0x00c6 }
        r2 = java.nio.ByteBuffer.wrap(r4, r5, r6);	 Catch:{ CharacterCodingException -> 0x00d3, all -> 0x00c6 }
        r1 = r1.decode(r2);	 Catch:{ CharacterCodingException -> 0x00d3, all -> 0x00c6 }
        if (r1 == 0) goto L_0x00b8;	 Catch:{ CharacterCodingException -> 0x00d3, all -> 0x00c6 }
    L_0x00b4:
        r0 = r1.toString();	 Catch:{ CharacterCodingException -> 0x00d3, all -> 0x00c6 }
    L_0x00b8:
        if (r0 != 0) goto L_0x00de;
    L_0x00ba:
        r0 = new java.lang.String;
        r1 = "ISO-8859-1";
        r1 = java.nio.charset.Charset.forName(r1);
        r0.<init>(r4, r5, r6, r1);
        goto L_0x00de;
    L_0x00c6:
        r0 = move-exception;
        r1 = new java.lang.String;
        r2 = "ISO-8859-1";
        r2 = java.nio.charset.Charset.forName(r2);
        r1.<init>(r4, r5, r6, r2);
        throw r0;
    L_0x00d3:
        r0 = new java.lang.String;
        r1 = "ISO-8859-1";
        r1 = java.nio.charset.Charset.forName(r1);
        r0.<init>(r4, r5, r6, r1);
    L_0x00de:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.xllib.b.j.a(byte[], int, int):java.lang.String");
    }

    public static String a(long j) {
        String str = j >= 3600000 ? "HH:mm:ss" : "mm:ss";
        if (TextUtils.isEmpty(str)) {
            throw new InvalidParameterException("Null or empty format string");
        }
        String str2;
        Object obj;
        String str3;
        String str4;
        Object obj2;
        String str5;
        long j2;
        StringBuilder stringBuilder;
        int indexOf;
        String valueOf;
        StringBuilder stringBuilder2;
        StringBuilder stringBuilder3;
        int indexOf2;
        StringBuilder stringBuilder4;
        long j3 = 0;
        long max = Math.max(0, (j + 500) / 1000);
        String str6 = "";
        Object obj3 = null;
        if (str.contains("HH")) {
            str6 = "HH";
        } else if (str.contains("H")) {
            str6 = "H";
        } else {
            str2 = str6;
            obj = null;
            str3 = "";
            if (str.contains("mm")) {
                str3 = "mm";
            } else if (str.contains("m")) {
                str4 = str3;
                obj2 = null;
                str5 = "";
                if (str.contains("ss")) {
                    if (str.contains("s")) {
                        str5 = "s";
                    }
                    if (obj != null && obj2 == null && obj3 == null) {
                        throw new IllegalArgumentException("Illegal format string");
                    }
                    j2 = max % 60;
                    max /= 60;
                    if (obj != null) {
                        j3 = max / 60;
                        max %= 60;
                    }
                    stringBuilder = new StringBuilder(str);
                    if (obj3 != null) {
                        indexOf = stringBuilder.indexOf(str5);
                        if (indexOf != -1) {
                            valueOf = String.valueOf(j2);
                            if (j2 < 10 && str5.length() > 1) {
                                stringBuilder2 = new StringBuilder("0");
                                stringBuilder2.append(valueOf);
                                valueOf = stringBuilder2.toString();
                            }
                            stringBuilder.replace(indexOf, str5.length() + indexOf, valueOf);
                        }
                    }
                    if (obj2 != null) {
                        indexOf = stringBuilder.indexOf(str4);
                        if (indexOf != -1) {
                            str3 = String.valueOf(max);
                            if (max < 10 && str4.length() > 1) {
                                stringBuilder3 = new StringBuilder("0");
                                stringBuilder3.append(str3);
                                str3 = stringBuilder3.toString();
                            }
                            stringBuilder.replace(indexOf, str4.length() + indexOf, str3);
                        }
                    }
                    if (obj != null) {
                        indexOf2 = stringBuilder.indexOf(str2);
                        if (indexOf2 != -1) {
                            str = String.valueOf(j3);
                            if (j3 < 10 && str2.length() > 1) {
                                stringBuilder4 = new StringBuilder("0");
                                stringBuilder4.append(str);
                                str = stringBuilder4.toString();
                            }
                            stringBuilder.replace(indexOf2, str2.length() + indexOf2, str);
                        }
                    }
                    return stringBuilder.toString();
                }
                str5 = "ss";
                obj3 = 1;
                if (obj != null) {
                }
                j2 = max % 60;
                max /= 60;
                if (obj != null) {
                    j3 = max / 60;
                    max %= 60;
                }
                stringBuilder = new StringBuilder(str);
                if (obj3 != null) {
                    indexOf = stringBuilder.indexOf(str5);
                    if (indexOf != -1) {
                        valueOf = String.valueOf(j2);
                        stringBuilder2 = new StringBuilder("0");
                        stringBuilder2.append(valueOf);
                        valueOf = stringBuilder2.toString();
                        stringBuilder.replace(indexOf, str5.length() + indexOf, valueOf);
                    }
                }
                if (obj2 != null) {
                    indexOf = stringBuilder.indexOf(str4);
                    if (indexOf != -1) {
                        str3 = String.valueOf(max);
                        stringBuilder3 = new StringBuilder("0");
                        stringBuilder3.append(str3);
                        str3 = stringBuilder3.toString();
                        stringBuilder.replace(indexOf, str4.length() + indexOf, str3);
                    }
                }
                if (obj != null) {
                    indexOf2 = stringBuilder.indexOf(str2);
                    if (indexOf2 != -1) {
                        str = String.valueOf(j3);
                        stringBuilder4 = new StringBuilder("0");
                        stringBuilder4.append(str);
                        str = stringBuilder4.toString();
                        stringBuilder.replace(indexOf2, str2.length() + indexOf2, str);
                    }
                }
                return stringBuilder.toString();
            } else {
                str3 = "m";
            }
            str4 = str3;
            obj2 = 1;
            str5 = "";
            if (str.contains("ss")) {
                if (str.contains("s")) {
                    str5 = "s";
                }
                if (obj != null) {
                }
                j2 = max % 60;
                max /= 60;
                if (obj != null) {
                    j3 = max / 60;
                    max %= 60;
                }
                stringBuilder = new StringBuilder(str);
                if (obj3 != null) {
                    indexOf = stringBuilder.indexOf(str5);
                    if (indexOf != -1) {
                        valueOf = String.valueOf(j2);
                        stringBuilder2 = new StringBuilder("0");
                        stringBuilder2.append(valueOf);
                        valueOf = stringBuilder2.toString();
                        stringBuilder.replace(indexOf, str5.length() + indexOf, valueOf);
                    }
                }
                if (obj2 != null) {
                    indexOf = stringBuilder.indexOf(str4);
                    if (indexOf != -1) {
                        str3 = String.valueOf(max);
                        stringBuilder3 = new StringBuilder("0");
                        stringBuilder3.append(str3);
                        str3 = stringBuilder3.toString();
                        stringBuilder.replace(indexOf, str4.length() + indexOf, str3);
                    }
                }
                if (obj != null) {
                    indexOf2 = stringBuilder.indexOf(str2);
                    if (indexOf2 != -1) {
                        str = String.valueOf(j3);
                        stringBuilder4 = new StringBuilder("0");
                        stringBuilder4.append(str);
                        str = stringBuilder4.toString();
                        stringBuilder.replace(indexOf2, str2.length() + indexOf2, str);
                    }
                }
                return stringBuilder.toString();
            }
            str5 = "ss";
            obj3 = 1;
            if (obj != null) {
            }
            j2 = max % 60;
            max /= 60;
            if (obj != null) {
                j3 = max / 60;
                max %= 60;
            }
            stringBuilder = new StringBuilder(str);
            if (obj3 != null) {
                indexOf = stringBuilder.indexOf(str5);
                if (indexOf != -1) {
                    valueOf = String.valueOf(j2);
                    stringBuilder2 = new StringBuilder("0");
                    stringBuilder2.append(valueOf);
                    valueOf = stringBuilder2.toString();
                    stringBuilder.replace(indexOf, str5.length() + indexOf, valueOf);
                }
            }
            if (obj2 != null) {
                indexOf = stringBuilder.indexOf(str4);
                if (indexOf != -1) {
                    str3 = String.valueOf(max);
                    stringBuilder3 = new StringBuilder("0");
                    stringBuilder3.append(str3);
                    str3 = stringBuilder3.toString();
                    stringBuilder.replace(indexOf, str4.length() + indexOf, str3);
                }
            }
            if (obj != null) {
                indexOf2 = stringBuilder.indexOf(str2);
                if (indexOf2 != -1) {
                    str = String.valueOf(j3);
                    stringBuilder4 = new StringBuilder("0");
                    stringBuilder4.append(str);
                    str = stringBuilder4.toString();
                    stringBuilder.replace(indexOf2, str2.length() + indexOf2, str);
                }
            }
            return stringBuilder.toString();
        }
        str2 = str6;
        obj = 1;
        str3 = "";
        if (str.contains("mm")) {
            str3 = "mm";
        } else if (str.contains("m")) {
            str4 = str3;
            obj2 = null;
            str5 = "";
            if (str.contains("ss")) {
                str5 = "ss";
            } else {
                if (str.contains("s")) {
                    str5 = "s";
                }
                if (obj != null) {
                }
                j2 = max % 60;
                max /= 60;
                if (obj != null) {
                    j3 = max / 60;
                    max %= 60;
                }
                stringBuilder = new StringBuilder(str);
                if (obj3 != null) {
                    indexOf = stringBuilder.indexOf(str5);
                    if (indexOf != -1) {
                        valueOf = String.valueOf(j2);
                        stringBuilder2 = new StringBuilder("0");
                        stringBuilder2.append(valueOf);
                        valueOf = stringBuilder2.toString();
                        stringBuilder.replace(indexOf, str5.length() + indexOf, valueOf);
                    }
                }
                if (obj2 != null) {
                    indexOf = stringBuilder.indexOf(str4);
                    if (indexOf != -1) {
                        str3 = String.valueOf(max);
                        stringBuilder3 = new StringBuilder("0");
                        stringBuilder3.append(str3);
                        str3 = stringBuilder3.toString();
                        stringBuilder.replace(indexOf, str4.length() + indexOf, str3);
                    }
                }
                if (obj != null) {
                    indexOf2 = stringBuilder.indexOf(str2);
                    if (indexOf2 != -1) {
                        str = String.valueOf(j3);
                        stringBuilder4 = new StringBuilder("0");
                        stringBuilder4.append(str);
                        str = stringBuilder4.toString();
                        stringBuilder.replace(indexOf2, str2.length() + indexOf2, str);
                    }
                }
                return stringBuilder.toString();
            }
            obj3 = 1;
            if (obj != null) {
            }
            j2 = max % 60;
            max /= 60;
            if (obj != null) {
                j3 = max / 60;
                max %= 60;
            }
            stringBuilder = new StringBuilder(str);
            if (obj3 != null) {
                indexOf = stringBuilder.indexOf(str5);
                if (indexOf != -1) {
                    valueOf = String.valueOf(j2);
                    stringBuilder2 = new StringBuilder("0");
                    stringBuilder2.append(valueOf);
                    valueOf = stringBuilder2.toString();
                    stringBuilder.replace(indexOf, str5.length() + indexOf, valueOf);
                }
            }
            if (obj2 != null) {
                indexOf = stringBuilder.indexOf(str4);
                if (indexOf != -1) {
                    str3 = String.valueOf(max);
                    stringBuilder3 = new StringBuilder("0");
                    stringBuilder3.append(str3);
                    str3 = stringBuilder3.toString();
                    stringBuilder.replace(indexOf, str4.length() + indexOf, str3);
                }
            }
            if (obj != null) {
                indexOf2 = stringBuilder.indexOf(str2);
                if (indexOf2 != -1) {
                    str = String.valueOf(j3);
                    stringBuilder4 = new StringBuilder("0");
                    stringBuilder4.append(str);
                    str = stringBuilder4.toString();
                    stringBuilder.replace(indexOf2, str2.length() + indexOf2, str);
                }
            }
            return stringBuilder.toString();
        } else {
            str3 = "m";
        }
        str4 = str3;
        obj2 = 1;
        str5 = "";
        if (str.contains("ss")) {
            if (str.contains("s")) {
                str5 = "s";
            }
            if (obj != null) {
            }
            j2 = max % 60;
            max /= 60;
            if (obj != null) {
                j3 = max / 60;
                max %= 60;
            }
            stringBuilder = new StringBuilder(str);
            if (obj3 != null) {
                indexOf = stringBuilder.indexOf(str5);
                if (indexOf != -1) {
                    valueOf = String.valueOf(j2);
                    stringBuilder2 = new StringBuilder("0");
                    stringBuilder2.append(valueOf);
                    valueOf = stringBuilder2.toString();
                    stringBuilder.replace(indexOf, str5.length() + indexOf, valueOf);
                }
            }
            if (obj2 != null) {
                indexOf = stringBuilder.indexOf(str4);
                if (indexOf != -1) {
                    str3 = String.valueOf(max);
                    stringBuilder3 = new StringBuilder("0");
                    stringBuilder3.append(str3);
                    str3 = stringBuilder3.toString();
                    stringBuilder.replace(indexOf, str4.length() + indexOf, str3);
                }
            }
            if (obj != null) {
                indexOf2 = stringBuilder.indexOf(str2);
                if (indexOf2 != -1) {
                    str = String.valueOf(j3);
                    stringBuilder4 = new StringBuilder("0");
                    stringBuilder4.append(str);
                    str = stringBuilder4.toString();
                    stringBuilder.replace(indexOf2, str2.length() + indexOf2, str);
                }
            }
            return stringBuilder.toString();
        }
        str5 = "ss";
        obj3 = 1;
        if (obj != null) {
        }
        j2 = max % 60;
        max /= 60;
        if (obj != null) {
            j3 = max / 60;
            max %= 60;
        }
        stringBuilder = new StringBuilder(str);
        if (obj3 != null) {
            indexOf = stringBuilder.indexOf(str5);
            if (indexOf != -1) {
                valueOf = String.valueOf(j2);
                stringBuilder2 = new StringBuilder("0");
                stringBuilder2.append(valueOf);
                valueOf = stringBuilder2.toString();
                stringBuilder.replace(indexOf, str5.length() + indexOf, valueOf);
            }
        }
        if (obj2 != null) {
            indexOf = stringBuilder.indexOf(str4);
            if (indexOf != -1) {
                str3 = String.valueOf(max);
                stringBuilder3 = new StringBuilder("0");
                stringBuilder3.append(str3);
                str3 = stringBuilder3.toString();
                stringBuilder.replace(indexOf, str4.length() + indexOf, str3);
            }
        }
        if (obj != null) {
            indexOf2 = stringBuilder.indexOf(str2);
            if (indexOf2 != -1) {
                str = String.valueOf(j3);
                stringBuilder4 = new StringBuilder("0");
                stringBuilder4.append(str);
                str = stringBuilder4.toString();
                stringBuilder.replace(indexOf2, str2.length() + indexOf2, str);
            }
        }
        return stringBuilder.toString();
    }
}
