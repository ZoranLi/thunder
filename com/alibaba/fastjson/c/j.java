package com.alibaba.fastjson.c;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.a;
import com.alibaba.fastjson.a.d;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.a.b;
import com.alibaba.fastjson.parser.a.m;
import com.alibaba.fastjson.parser.g;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.av;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentMap;

/* compiled from: TypeUtils */
public class j {
    public static boolean a = false;
    private static boolean b = true;
    private static boolean c = false;
    private static Method d = null;
    private static boolean e = false;
    private static Method f = null;
    private static boolean g = false;
    private static Class<?> h;
    private static ConcurrentMap<String, Class<?>> i;

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = "fastjson.compatibleWithJavaBean";	 Catch:{ Throwable -> 0x001d }
        r0 = java.lang.System.getProperty(r0);	 Catch:{ Throwable -> 0x001d }
        r1 = "true";	 Catch:{ Throwable -> 0x001d }
        r1 = r1.equals(r0);	 Catch:{ Throwable -> 0x001d }
        if (r1 == 0) goto L_0x0012;	 Catch:{ Throwable -> 0x001d }
    L_0x000e:
        r0 = 1;	 Catch:{ Throwable -> 0x001d }
        a = r0;	 Catch:{ Throwable -> 0x001d }
        goto L_0x001d;	 Catch:{ Throwable -> 0x001d }
    L_0x0012:
        r1 = "false";	 Catch:{ Throwable -> 0x001d }
        r0 = r1.equals(r0);	 Catch:{ Throwable -> 0x001d }
        if (r0 == 0) goto L_0x001d;	 Catch:{ Throwable -> 0x001d }
    L_0x001a:
        r0 = 0;	 Catch:{ Throwable -> 0x001d }
        a = r0;	 Catch:{ Throwable -> 0x001d }
    L_0x001d:
        r0 = new java.util.concurrent.ConcurrentHashMap;
        r0.<init>();
        i = r0;
        r1 = "byte";
        r2 = java.lang.Byte.TYPE;
        r0.put(r1, r2);
        r0 = i;
        r1 = "short";
        r2 = java.lang.Short.TYPE;
        r0.put(r1, r2);
        r0 = i;
        r1 = "int";
        r2 = java.lang.Integer.TYPE;
        r0.put(r1, r2);
        r0 = i;
        r1 = "long";
        r2 = java.lang.Long.TYPE;
        r0.put(r1, r2);
        r0 = i;
        r1 = "float";
        r2 = java.lang.Float.TYPE;
        r0.put(r1, r2);
        r0 = i;
        r1 = "double";
        r2 = java.lang.Double.TYPE;
        r0.put(r1, r2);
        r0 = i;
        r1 = "boolean";
        r2 = java.lang.Boolean.TYPE;
        r0.put(r1, r2);
        r0 = i;
        r1 = "char";
        r2 = java.lang.Character.TYPE;
        r0.put(r1, r2);
        r0 = i;
        r1 = "[byte";
        r2 = byte[].class;
        r0.put(r1, r2);
        r0 = i;
        r1 = "[short";
        r2 = short[].class;
        r0.put(r1, r2);
        r0 = i;
        r1 = "[int";
        r2 = int[].class;
        r0.put(r1, r2);
        r0 = i;
        r1 = "[long";
        r2 = long[].class;
        r0.put(r1, r2);
        r0 = i;
        r1 = "[float";
        r2 = float[].class;
        r0.put(r1, r2);
        r0 = i;
        r1 = "[double";
        r2 = double[].class;
        r0.put(r1, r2);
        r0 = i;
        r1 = "[boolean";
        r2 = boolean[].class;
        r0.put(r1, r2);
        r0 = i;
        r1 = "[char";
        r2 = char[].class;
        r0.put(r1, r2);
        r0 = i;
        r1 = java.util.HashMap.class;
        r1 = r1.getName();
        r2 = java.util.HashMap.class;
        r0.put(r1, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.c.j.<clinit>():void");
    }

    public static String a(Object obj) {
        return obj == null ? null : obj.toString();
    }

    public static Byte b(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (!(str.length() == 0 || "null".equals(str))) {
                if (!"NULL".equals(str)) {
                    return Byte.valueOf(Byte.parseByte(str));
                }
            }
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("can not cast to byte, value : ");
        stringBuilder.append(obj);
        throw new JSONException(stringBuilder.toString());
    }

    public static Character c(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            if (str.length() == 1) {
                return Character.valueOf(str.charAt(null));
            }
            StringBuilder stringBuilder = new StringBuilder("can not cast to char, value : ");
            stringBuilder.append(obj);
            throw new JSONException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder("can not cast to char, value : ");
        stringBuilder.append(obj);
        throw new JSONException(stringBuilder.toString());
    }

    public static Short d(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (!(str.length() == 0 || "null".equals(str))) {
                if (!"NULL".equals(str)) {
                    return Short.valueOf(Short.parseShort(str));
                }
            }
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("can not cast to short, value : ");
        stringBuilder.append(obj);
        throw new JSONException(stringBuilder.toString());
    }

    public static BigDecimal e(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        obj = obj.toString();
        if (obj.length() == 0) {
            return null;
        }
        return new BigDecimal(obj);
    }

    public static BigInteger f(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if (!(obj instanceof Float)) {
            if (!(obj instanceof Double)) {
                obj = obj.toString();
                if (!(obj.length() == 0 || "null".equals(obj))) {
                    if (!"NULL".equals(obj)) {
                        return new BigInteger(obj);
                    }
                }
                return null;
            }
        }
        return BigInteger.valueOf(((Number) obj).longValue());
    }

    public static Float g(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (obj instanceof String) {
            obj = obj.toString();
            if (!(obj.length() == 0 || "null".equals(obj))) {
                if (!"NULL".equals(obj)) {
                    if (obj.indexOf(44) != 0) {
                        obj = obj.replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SP, "");
                    }
                    return Float.valueOf(Float.parseFloat(obj));
                }
            }
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("can not cast to float, value : ");
        stringBuilder.append(obj);
        throw new JSONException(stringBuilder.toString());
    }

    public static Double h(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            obj = obj.toString();
            if (!(obj.length() == 0 || "null".equals(obj))) {
                if (!"NULL".equals(obj)) {
                    if (obj.indexOf(44) != 0) {
                        obj = obj.replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SP, "");
                    }
                    return Double.valueOf(Double.parseDouble(obj));
                }
            }
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("can not cast to double, value : ");
        stringBuilder.append(obj);
        throw new JSONException(stringBuilder.toString());
    }

    public static java.util.Date i(java.lang.Object r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5 instanceof java.util.Date;
        if (r1 == 0) goto L_0x000b;
    L_0x0008:
        r5 = (java.util.Date) r5;
        return r5;
    L_0x000b:
        r1 = r5 instanceof java.util.Calendar;
        if (r1 == 0) goto L_0x0016;
    L_0x000f:
        r5 = (java.util.Calendar) r5;
        r5 = r5.getTime();
        return r5;
    L_0x0016:
        r1 = -1;
        r3 = r5 instanceof java.lang.Number;
        if (r3 == 0) goto L_0x0028;
    L_0x001c:
        r5 = (java.lang.Number) r5;
        r0 = r5.longValue();
        r5 = new java.util.Date;
        r5.<init>(r0);
        return r5;
    L_0x0028:
        r3 = r5 instanceof java.lang.String;
        if (r3 == 0) goto L_0x008f;
    L_0x002c:
        r1 = r5;
        r1 = (java.lang.String) r1;
        r2 = 45;
        r2 = r1.indexOf(r2);
        r3 = -1;
        if (r2 == r3) goto L_0x0084;
    L_0x0038:
        r5 = r1.length();
        r0 = com.alibaba.fastjson.a.DEFFAULT_DATE_FORMAT;
        r0 = r0.length();
        if (r5 != r0) goto L_0x0047;
    L_0x0044:
        r5 = com.alibaba.fastjson.a.DEFFAULT_DATE_FORMAT;
        goto L_0x005f;
    L_0x0047:
        r5 = r1.length();
        r0 = 10;
        if (r5 != r0) goto L_0x0052;
    L_0x004f:
        r5 = "yyyy-MM-dd";
        goto L_0x005f;
    L_0x0052:
        r5 = r1.length();
        r0 = 19;
        if (r5 != r0) goto L_0x005d;
    L_0x005a:
        r5 = "yyyy-MM-dd HH:mm:ss";
        goto L_0x005f;
    L_0x005d:
        r5 = "yyyy-MM-dd HH:mm:ss.SSS";
    L_0x005f:
        r0 = new java.text.SimpleDateFormat;
        r2 = com.alibaba.fastjson.a.defaultLocale;
        r0.<init>(r5, r2);
        r5 = com.alibaba.fastjson.a.defaultTimeZone;
        r0.setTimeZone(r5);
        r5 = r0.parse(r1);	 Catch:{ ParseException -> 0x0070 }
        return r5;
    L_0x0070:
        r5 = new com.alibaba.fastjson.JSONException;
        r0 = new java.lang.StringBuilder;
        r2 = "can not cast to Date, value : ";
        r0.<init>(r2);
        r0.append(r1);
        r0 = r0.toString();
        r5.<init>(r0);
        throw r5;
    L_0x0084:
        r2 = r1.length();
        if (r2 != 0) goto L_0x008b;
    L_0x008a:
        return r0;
    L_0x008b:
        r1 = java.lang.Long.parseLong(r1);
    L_0x008f:
        r3 = 0;
        r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r0 >= 0) goto L_0x0121;
    L_0x0095:
        r0 = r5.getClass();
        r1 = "oracle.sql.TIMESTAMP";
        r2 = r0.getName();
        r1 = r1.equals(r2);
        r2 = 0;
        r3 = 1;
        if (r1 == 0) goto L_0x00d4;
    L_0x00a7:
        r1 = d;
        if (r1 != 0) goto L_0x00c0;
    L_0x00ab:
        r1 = c;
        if (r1 != 0) goto L_0x00c0;
    L_0x00af:
        r1 = "toJdbc";	 Catch:{ NoSuchMethodException -> 0x00be, all -> 0x00ba }
        r4 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x00be, all -> 0x00ba }
        r0 = r0.getMethod(r1, r4);	 Catch:{ NoSuchMethodException -> 0x00be, all -> 0x00ba }
        d = r0;	 Catch:{ NoSuchMethodException -> 0x00be, all -> 0x00ba }
        goto L_0x00be;
    L_0x00ba:
        r5 = move-exception;
        c = r3;
        throw r5;
    L_0x00be:
        c = r3;
    L_0x00c0:
        r0 = d;	 Catch:{ Exception -> 0x00cb }
        r1 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x00cb }
        r5 = r0.invoke(r5, r1);	 Catch:{ Exception -> 0x00cb }
        r5 = (java.util.Date) r5;
        return r5;
    L_0x00cb:
        r5 = move-exception;
        r0 = new com.alibaba.fastjson.JSONException;
        r1 = "can not cast oracle.sql.TIMESTAMP to Date";
        r0.<init>(r1, r5);
        throw r0;
    L_0x00d4:
        r1 = "oracle.sql.DATE";
        r4 = r0.getName();
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x010d;
    L_0x00e0:
        r1 = f;
        if (r1 != 0) goto L_0x00f9;
    L_0x00e4:
        r1 = e;
        if (r1 != 0) goto L_0x00f9;
    L_0x00e8:
        r1 = "toJdbc";	 Catch:{ NoSuchMethodException -> 0x00f7, all -> 0x00f3 }
        r4 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x00f7, all -> 0x00f3 }
        r0 = r0.getMethod(r1, r4);	 Catch:{ NoSuchMethodException -> 0x00f7, all -> 0x00f3 }
        f = r0;	 Catch:{ NoSuchMethodException -> 0x00f7, all -> 0x00f3 }
        goto L_0x00f7;
    L_0x00f3:
        r5 = move-exception;
        e = r3;
        throw r5;
    L_0x00f7:
        e = r3;
    L_0x00f9:
        r0 = f;	 Catch:{ Exception -> 0x0104 }
        r1 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0104 }
        r5 = r0.invoke(r5, r1);	 Catch:{ Exception -> 0x0104 }
        r5 = (java.util.Date) r5;
        return r5;
    L_0x0104:
        r5 = move-exception;
        r0 = new com.alibaba.fastjson.JSONException;
        r1 = "can not cast oracle.sql.DATE to Date";
        r0.<init>(r1, r5);
        throw r0;
    L_0x010d:
        r0 = new com.alibaba.fastjson.JSONException;
        r1 = new java.lang.StringBuilder;
        r2 = "can not cast to Date, value : ";
        r1.<init>(r2);
        r1.append(r5);
        r5 = r1.toString();
        r0.<init>(r5);
        throw r0;
    L_0x0121:
        r5 = new java.util.Date;
        r5.<init>(r1);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.c.j.i(java.lang.Object):java.util.Date");
    }

    public static Date j(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof java.util.Date) {
            return new Date(((java.util.Date) obj).getTime());
        }
        if (obj instanceof Calendar) {
            return new Date(((Calendar) obj).getTimeInMillis());
        }
        long longValue = obj instanceof Number ? ((Number) obj).longValue() : 0;
        if (obj instanceof String) {
            String str = (String) obj;
            if (!(str.length() == 0 || "null".equals(str))) {
                if (!"NULL".equals(str)) {
                    longValue = Long.parseLong(str);
                }
            }
            return null;
        }
        if (longValue > 0) {
            return new Date(longValue);
        }
        StringBuilder stringBuilder = new StringBuilder("can not cast to Date, value : ");
        stringBuilder.append(obj);
        throw new JSONException(stringBuilder.toString());
    }

    public static Timestamp k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return new Timestamp(((Calendar) obj).getTimeInMillis());
        }
        if (obj instanceof Timestamp) {
            return (Timestamp) obj;
        }
        if (obj instanceof java.util.Date) {
            return new Timestamp(((java.util.Date) obj).getTime());
        }
        long longValue = obj instanceof Number ? ((Number) obj).longValue() : 0;
        if (obj instanceof String) {
            String str = (String) obj;
            if (!(str.length() == 0 || "null".equals(str))) {
                if (!"NULL".equals(str)) {
                    longValue = Long.parseLong(str);
                }
            }
            return null;
        }
        if (longValue > 0) {
            return new Timestamp(longValue);
        }
        StringBuilder stringBuilder = new StringBuilder("can not cast to Date, value : ");
        stringBuilder.append(obj);
        throw new JSONException(stringBuilder.toString());
    }

    public static java.lang.Long l(java.lang.Object r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r4 instanceof java.lang.Number;
        if (r1 == 0) goto L_0x0013;
    L_0x0008:
        r4 = (java.lang.Number) r4;
        r0 = r4.longValue();
        r4 = java.lang.Long.valueOf(r0);
        return r4;
    L_0x0013:
        r1 = r4 instanceof java.lang.String;
        if (r1 == 0) goto L_0x0069;
    L_0x0017:
        r1 = r4;
        r1 = (java.lang.String) r1;
        r2 = r1.length();
        if (r2 == 0) goto L_0x0068;
    L_0x0020:
        r2 = "null";
        r2 = r2.equals(r1);
        if (r2 != 0) goto L_0x0068;
    L_0x0028:
        r2 = "NULL";
        r2 = r2.equals(r1);
        if (r2 == 0) goto L_0x0031;
    L_0x0030:
        goto L_0x0068;
    L_0x0031:
        r2 = 44;
        r2 = r1.indexOf(r2);
        if (r2 == 0) goto L_0x0041;
    L_0x0039:
        r2 = ",";
        r3 = "";
        r1 = r1.replaceAll(r2, r3);
    L_0x0041:
        r2 = java.lang.Long.parseLong(r1);	 Catch:{ NumberFormatException -> 0x004a }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ NumberFormatException -> 0x004a }
        return r2;
    L_0x004a:
        r2 = new com.alibaba.fastjson.parser.d;
        r2.<init>(r1);
        r1 = 0;
        r1 = r2.b(r1);
        if (r1 == 0) goto L_0x005a;
    L_0x0056:
        r0 = r2.C();
    L_0x005a:
        r2.close();
        if (r0 == 0) goto L_0x0069;
    L_0x005f:
        r0 = r0.getTimeInMillis();
        r4 = java.lang.Long.valueOf(r0);
        return r4;
    L_0x0068:
        return r0;
    L_0x0069:
        r0 = new com.alibaba.fastjson.JSONException;
        r1 = new java.lang.StringBuilder;
        r2 = "can not cast to long, value : ";
        r1.<init>(r2);
        r1.append(r4);
        r4 = r1.toString();
        r0.<init>(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.c.j.l(java.lang.Object):java.lang.Long");
    }

    public static Integer m(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            obj = (String) obj;
            if (!(obj.length() == 0 || "null".equals(obj))) {
                if (!"NULL".equals(obj)) {
                    if (obj.indexOf(44) != 0) {
                        obj = obj.replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SP, "");
                    }
                    return Integer.valueOf(Integer.parseInt(obj));
                }
            }
            return null;
        } else if (obj instanceof Boolean) {
            return Integer.valueOf(((Boolean) obj).booleanValue());
        } else {
            StringBuilder stringBuilder = new StringBuilder("can not cast to int, value : ");
            stringBuilder.append(obj);
            throw new JSONException(stringBuilder.toString());
        }
    }

    public static byte[] n(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return e.a((String) obj);
        }
        StringBuilder stringBuilder = new StringBuilder("can not cast to int, value : ");
        stringBuilder.append(obj);
        throw new JSONException(stringBuilder.toString());
    }

    public static Boolean o(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            boolean z = true;
            if (((Number) obj).intValue() != 1) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (!(str.length() == 0 || "null".equals(str))) {
                if (!"NULL".equals(str)) {
                    if (!"true".equalsIgnoreCase(str)) {
                        if (!"1".equals(str)) {
                            if (av.b.equalsIgnoreCase(str) || "0".equals(str)) {
                                return Boolean.FALSE;
                            }
                        }
                    }
                    return Boolean.TRUE;
                }
            }
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("can not cast to boolean, value : ");
        stringBuilder.append(obj);
        throw new JSONException(stringBuilder.toString());
    }

    public static <T> T a(Object obj, Class<T> cls) {
        return a(obj, (Class) cls, g.a());
    }

    public static <T> T a(Object obj, Class<T> cls, g gVar) {
        if (obj == null) {
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        } else if (cls == obj.getClass()) {
            return obj;
        } else {
            if (!(obj instanceof Map)) {
                if (cls.isArray()) {
                    if (obj instanceof Collection) {
                        Collection<Object> collection = (Collection) obj;
                        int i = 0;
                        T newInstance = Array.newInstance(cls.getComponentType(), collection.size());
                        for (Object a : collection) {
                            Array.set(newInstance, i, a(a, cls.getComponentType(), gVar));
                            i++;
                        }
                        return newInstance;
                    } else if (cls == byte[].class) {
                        return n(obj);
                    }
                }
                if (cls.isAssignableFrom(obj.getClass()) != null) {
                    return obj;
                }
                if (cls != Boolean.TYPE) {
                    if (cls != Boolean.class) {
                        if (cls != Byte.TYPE) {
                            if (cls != Byte.class) {
                                if (cls != Short.TYPE) {
                                    if (cls != Short.class) {
                                        if (cls != Integer.TYPE) {
                                            if (cls != Integer.class) {
                                                if (cls != Long.TYPE) {
                                                    if (cls != Long.class) {
                                                        if (cls != Float.TYPE) {
                                                            if (cls != Float.class) {
                                                                if (cls != Double.TYPE) {
                                                                    if (cls != Double.class) {
                                                                        if (cls == String.class) {
                                                                            return a(obj);
                                                                        }
                                                                        if (cls == BigDecimal.class) {
                                                                            return e(obj);
                                                                        }
                                                                        if (cls == BigInteger.class) {
                                                                            return f(obj);
                                                                        }
                                                                        if (cls == java.util.Date.class) {
                                                                            return i(obj);
                                                                        }
                                                                        if (cls == Date.class) {
                                                                            return j(obj);
                                                                        }
                                                                        if (cls == Timestamp.class) {
                                                                            return k(obj);
                                                                        }
                                                                        if (cls.isEnum() != null) {
                                                                            return b(obj, cls);
                                                                        }
                                                                        if (Calendar.class.isAssignableFrom(cls) != null) {
                                                                            obj = i(obj);
                                                                            if (cls == Calendar.class) {
                                                                                cls = Calendar.getInstance(a.defaultTimeZone, a.defaultLocale);
                                                                            } else {
                                                                                try {
                                                                                    cls = (Calendar) cls.newInstance();
                                                                                } catch (Object obj2) {
                                                                                    StringBuilder stringBuilder = new StringBuilder("can not cast to : ");
                                                                                    stringBuilder.append(cls.getName());
                                                                                    throw new JSONException(stringBuilder.toString(), obj2);
                                                                                }
                                                                            }
                                                                            cls.setTime(obj2);
                                                                            return cls;
                                                                        }
                                                                        if ((obj2 instanceof String) != null) {
                                                                            String str = (String) obj2;
                                                                            if (str.length() != null && "null".equals(str) == null) {
                                                                                if ("NULL".equals(str) == null) {
                                                                                    if (cls == Currency.class) {
                                                                                        return Currency.getInstance(str);
                                                                                    }
                                                                                }
                                                                            }
                                                                            return null;
                                                                        }
                                                                        gVar = new StringBuilder("can not cast to : ");
                                                                        gVar.append(cls.getName());
                                                                        throw new JSONException(gVar.toString());
                                                                    }
                                                                }
                                                                return h(obj2);
                                                            }
                                                        }
                                                        return g(obj2);
                                                    }
                                                }
                                                return l(obj2);
                                            }
                                        }
                                        return m(obj2);
                                    }
                                }
                                return d(obj2);
                            }
                        }
                        return b(obj2);
                    }
                }
                return o(obj2);
            } else if (cls == Map.class) {
                return obj2;
            } else {
                Map map = (Map) obj2;
                if (cls != Object.class || map.containsKey(a.DEFAULT_TYPE_KEY)) {
                    return a(map, (Class) cls, gVar);
                }
                return obj2;
            }
        }
    }

    private static <T> T b(Object obj, Class<T> cls) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                return Enum.valueOf(cls, str);
            }
            if (obj instanceof Number) {
                obj = ((Number) obj).intValue();
                Object[] enumConstants = cls.getEnumConstants();
                if (obj < enumConstants.length) {
                    return enumConstants[obj];
                }
            }
            StringBuilder stringBuilder = new StringBuilder("can not cast to : ");
            stringBuilder.append(cls.getName());
            throw new JSONException(stringBuilder.toString());
        } catch (Object obj2) {
            StringBuilder stringBuilder2 = new StringBuilder("can not cast to : ");
            stringBuilder2.append(cls.getName());
            throw new JSONException(stringBuilder2.toString(), obj2);
        }
    }

    public static <T> T a(Object obj, Type type, g gVar) {
        while (obj != null) {
            if (type instanceof Class) {
                return a(obj, (Class) type, gVar);
            }
            if (type instanceof ParameterizedType) {
                Type type2;
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type rawType = parameterizedType.getRawType();
                if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == List.class || rawType == ArrayList.class) {
                    type2 = parameterizedType.getActualTypeArguments()[0];
                    if (obj instanceof Iterable) {
                        if (rawType != Set.class) {
                            if (rawType != HashSet.class) {
                                if (rawType == TreeSet.class) {
                                    type = new TreeSet();
                                } else {
                                    type = new ArrayList();
                                }
                                for (Object a : (Iterable) obj) {
                                    type.add(a(a, type2, gVar));
                                }
                                return type;
                            }
                        }
                        type = new HashSet();
                        while (obj.hasNext()) {
                            type.add(a(a, type2, gVar));
                        }
                        return type;
                    }
                }
                if (rawType == Map.class || rawType == HashMap.class) {
                    type2 = parameterizedType.getActualTypeArguments()[0];
                    Type type3 = parameterizedType.getActualTypeArguments()[1];
                    if (obj instanceof Map) {
                        type = new HashMap();
                        for (Entry entry : ((Map) obj).entrySet()) {
                            type.put(a(entry.getKey(), type2, gVar), a(entry.getValue(), type3, gVar));
                        }
                        return type;
                    }
                }
                if ((obj instanceof String) && ((String) obj).length() == 0) {
                    return null;
                }
                if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
                    type = rawType;
                } else {
                    gVar = new StringBuilder("can not cast to : ");
                    gVar.append(parameterizedType);
                    throw new JSONException(gVar.toString());
                }
            }
            if ((obj instanceof String) != null) {
                String str = (String) obj;
                if (str.length() == 0 || "null".equals(str) || "NULL".equals(str) != null) {
                    return null;
                }
            }
            if ((type instanceof TypeVariable) != null) {
                return obj;
            }
            gVar = new StringBuilder("can not cast to : ");
            gVar.append(type);
            throw new JSONException(gVar.toString());
        }
        return null;
    }

    private static <T> T a(Map<String, Object> map, Class<T> cls, g gVar) {
        try {
            int i = 0;
            String str;
            if (cls == StackTraceElement.class) {
                String str2 = (String) map.get("className");
                String str3 = (String) map.get("methodName");
                str = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                if (number != null) {
                    i = number.intValue();
                }
                return new StackTraceElement(str2, str3, str, i);
            }
            Object obj = map.get(a.DEFAULT_TYPE_KEY);
            m mVar = null;
            if (obj instanceof String) {
                str = (String) obj;
                Class a = a(str, null);
                if (a == null) {
                    cls = new StringBuilder();
                    cls.append(str);
                    cls.append(" not found");
                    throw new ClassNotFoundException(cls.toString());
                } else if (!a.equals(cls)) {
                    return a((Map) map, a, gVar);
                }
            }
            if (cls.isInterface()) {
                if ((map instanceof JSONObject) != null) {
                    map = (JSONObject) map;
                } else {
                    map = new JSONObject((Map) map);
                }
                return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, map);
            }
            if (gVar == null) {
                gVar = g.a();
            }
            cls = gVar.a((Type) cls);
            if (cls instanceof m) {
                mVar = (m) cls;
            } else if (cls instanceof b) {
                mVar = ((b) cls).a;
            }
            if (mVar != null) {
                return mVar.a((Map) map, gVar);
            }
            throw new JSONException("can not get javaBeanDeserializer");
        } catch (Map<String, Object> map2) {
            throw new JSONException(map2.getMessage(), map2);
        }
    }

    public static java.lang.Class<?> a(java.lang.String r6, java.lang.ClassLoader r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
    L_0x0000:
        if (r6 == 0) goto L_0x0082;
    L_0x0002:
        r0 = r6.length();
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        goto L_0x0082;
    L_0x000a:
        r0 = i;
        r0 = r0.get(r6);
        r0 = (java.lang.Class) r0;
        if (r0 == 0) goto L_0x0015;
    L_0x0014:
        return r0;
    L_0x0015:
        r1 = 0;
        r2 = r6.charAt(r1);
        r3 = 91;
        r4 = 1;
        if (r2 != r3) goto L_0x0030;
    L_0x001f:
        r6 = r6.substring(r4);
        r6 = a(r6, r7);
        r6 = java.lang.reflect.Array.newInstance(r6, r1);
        r6 = r6.getClass();
        return r6;
    L_0x0030:
        r1 = "L";
        r1 = r6.startsWith(r1);
        if (r1 == 0) goto L_0x004a;
    L_0x0038:
        r1 = ";";
        r1 = r6.endsWith(r1);
        if (r1 == 0) goto L_0x004a;
    L_0x0040:
        r0 = r6.length();
        r0 = r0 - r4;
        r6 = r6.substring(r4, r0);
        goto L_0x0000;
    L_0x004a:
        if (r7 == 0) goto L_0x0060;
    L_0x004c:
        r7 = r7.loadClass(r6);	 Catch:{ Throwable -> 0x0058 }
        r0 = i;	 Catch:{ Throwable -> 0x0056 }
        r0.put(r6, r7);	 Catch:{ Throwable -> 0x0056 }
        return r7;
    L_0x0056:
        r0 = move-exception;
        goto L_0x005c;
    L_0x0058:
        r7 = move-exception;
        r5 = r0;
        r0 = r7;
        r7 = r5;
    L_0x005c:
        r0.printStackTrace();
        goto L_0x0061;
    L_0x0060:
        r7 = r0;
    L_0x0061:
        r0 = java.lang.Thread.currentThread();	 Catch:{ Throwable -> 0x0076 }
        r0 = r0.getContextClassLoader();	 Catch:{ Throwable -> 0x0076 }
        if (r0 == 0) goto L_0x0076;	 Catch:{ Throwable -> 0x0076 }
    L_0x006b:
        r0 = r0.loadClass(r6);	 Catch:{ Throwable -> 0x0076 }
        r7 = i;	 Catch:{ Throwable -> 0x0075 }
        r7.put(r6, r0);	 Catch:{ Throwable -> 0x0075 }
        return r0;
    L_0x0075:
        r7 = r0;
    L_0x0076:
        r0 = java.lang.Class.forName(r6);	 Catch:{ Throwable -> 0x0081 }
        r7 = i;	 Catch:{ Throwable -> 0x0080 }
        r7.put(r6, r0);	 Catch:{ Throwable -> 0x0080 }
        return r0;
    L_0x0080:
        r7 = r0;
    L_0x0081:
        return r7;
    L_0x0082:
        r6 = 0;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.c.j.a(java.lang.String, java.lang.ClassLoader):java.lang.Class<?>");
    }

    public static List<d> a(Class<?> cls, boolean z) {
        String str;
        d dVar;
        String str2;
        int i;
        int of;
        int i2;
        Object obj;
        Class cls2 = cls;
        Map linkedHashMap = new LinkedHashMap();
        Method[] methods = cls.getMethods();
        int length = methods.length;
        int i3 = 0;
        while (i3 < length) {
            int i4;
            int i5;
            Method[] methodArr;
            int i6;
            Field a;
            String str3;
            com.alibaba.fastjson.a.b bVar;
            Method method = methods[i3];
            String name = method.getName();
            if (!(Modifier.isStatic(method.getModifiers()) || method.getReturnType().equals(Void.TYPE) || method.getParameterTypes().length != 0 || method.getReturnType() == ClassLoader.class || (method.getName().equals("getMetaClass") && method.getReturnType().getName().equals("groovy.lang.MetaClass")))) {
                com.alibaba.fastjson.a.b bVar2;
                int i7;
                String substring;
                com.alibaba.fastjson.a.b bVar3;
                int a2;
                int i8;
                String str4;
                Method method2;
                com.alibaba.fastjson.a.b bVar4;
                char c;
                com.alibaba.fastjson.a.b bVar5 = (com.alibaba.fastjson.a.b) method.getAnnotation(com.alibaba.fastjson.a.b.class);
                if (bVar5 == null) {
                    bVar5 = a(cls2, method);
                }
                com.alibaba.fastjson.a.b bVar6 = bVar5;
                if (bVar6 == null) {
                    bVar2 = bVar6;
                    i4 = i3;
                    str = null;
                    i5 = 0;
                    i7 = 0;
                } else if (bVar6.d()) {
                    i5 = bVar6.a();
                    i7 = SerializerFeature.of(bVar6.f());
                    if (bVar6.b().length() != 0) {
                        name = bVar6.b();
                        String str5 = name;
                        d dVar2 = dVar;
                        i4 = i3;
                        dVar = new d(name, method, null, cls2, null, i5, i7, bVar6, null, null);
                        linkedHashMap.put(str5, dVar2);
                        methodArr = methods;
                        i6 = length;
                        i3 = i4 + 1;
                        methods = methodArr;
                        length = i6;
                    } else {
                        bVar2 = bVar6;
                        i4 = i3;
                        str = bVar2.g().length() != 0 ? bVar2.g() : null;
                    }
                }
                if (name.startsWith("get")) {
                    if (name.length() >= 4 && !name.equals("getClass")) {
                        String str6;
                        com.alibaba.fastjson.a.b bVar7;
                        String str7;
                        d dVar3;
                        String str8;
                        char charAt = name.charAt(3);
                        if (!Character.isUpperCase(charAt)) {
                            if (charAt <= 'Ȁ') {
                                if (charAt == '_') {
                                    substring = name.substring(4);
                                } else if (charAt == 'f') {
                                    substring = name.substring(3);
                                } else if (name.length() >= 5 && Character.isUpperCase(name.charAt(4))) {
                                    substring = a(name.substring(3));
                                }
                                if (!a(cls2, substring)) {
                                    a = g.a(cls2, substring);
                                    if (a == null) {
                                        bVar3 = (com.alibaba.fastjson.a.b) a.getAnnotation(com.alibaba.fastjson.a.b.class);
                                        if (bVar3 != null) {
                                            str6 = str;
                                            bVar7 = bVar3;
                                        } else if (bVar3.d()) {
                                            a2 = bVar3.a();
                                            i5 = SerializerFeature.of(bVar3.f());
                                            if (bVar3.b().length() != 0) {
                                                substring = bVar3.b();
                                            }
                                            if (bVar3.g().length() != 0) {
                                                str = bVar3.g();
                                            }
                                            str6 = str;
                                            bVar7 = bVar3;
                                            i7 = a2;
                                            i8 = i5;
                                            str7 = substring;
                                            methodArr = methods;
                                            i6 = length;
                                            dVar3 = dVar;
                                            str8 = str7;
                                            str4 = name;
                                            method2 = method;
                                            bVar4 = bVar2;
                                            c = 'f';
                                            dVar = new d(str7, method, a, cls2, null, i7, i8, bVar2, bVar7, str6);
                                            linkedHashMap.put(str8, dVar3);
                                            str = str6;
                                        }
                                    } else {
                                        str6 = str;
                                        bVar7 = null;
                                    }
                                    i8 = i7;
                                    i7 = i5;
                                    str7 = substring;
                                    methodArr = methods;
                                    i6 = length;
                                    dVar3 = dVar;
                                    str8 = str7;
                                    str4 = name;
                                    method2 = method;
                                    bVar4 = bVar2;
                                    c = 'f';
                                    dVar = new d(str7, method, a, cls2, null, i7, i8, bVar2, bVar7, str6);
                                    linkedHashMap.put(str8, dVar3);
                                    str = str6;
                                }
                            }
                        }
                        if (a) {
                            substring = a(name.substring(3));
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(Character.toLowerCase(name.charAt(3)));
                            stringBuilder.append(name.substring(4));
                            substring = stringBuilder.toString();
                        }
                        if (a(cls2, substring)) {
                            a = g.a(cls2, substring);
                            if (a == null) {
                                str6 = str;
                                bVar7 = null;
                            } else {
                                bVar3 = (com.alibaba.fastjson.a.b) a.getAnnotation(com.alibaba.fastjson.a.b.class);
                                if (bVar3 != null) {
                                    str6 = str;
                                    bVar7 = bVar3;
                                } else if (bVar3.d()) {
                                    a2 = bVar3.a();
                                    i5 = SerializerFeature.of(bVar3.f());
                                    if (bVar3.b().length() != 0) {
                                        substring = bVar3.b();
                                    }
                                    if (bVar3.g().length() != 0) {
                                        str = bVar3.g();
                                    }
                                    str6 = str;
                                    bVar7 = bVar3;
                                    i7 = a2;
                                    i8 = i5;
                                    str7 = substring;
                                    methodArr = methods;
                                    i6 = length;
                                    dVar3 = dVar;
                                    str8 = str7;
                                    str4 = name;
                                    method2 = method;
                                    bVar4 = bVar2;
                                    c = 'f';
                                    dVar = new d(str7, method, a, cls2, null, i7, i8, bVar2, bVar7, str6);
                                    linkedHashMap.put(str8, dVar3);
                                    str = str6;
                                }
                            }
                            i8 = i7;
                            i7 = i5;
                            str7 = substring;
                            methodArr = methods;
                            i6 = length;
                            dVar3 = dVar;
                            str8 = str7;
                            str4 = name;
                            method2 = method;
                            bVar4 = bVar2;
                            c = 'f';
                            dVar = new d(str7, method, a, cls2, null, i7, i8, bVar2, bVar7, str6);
                            linkedHashMap.put(str8, dVar3);
                            str = str6;
                        }
                    }
                    methodArr = methods;
                    i6 = length;
                    i3 = i4 + 1;
                    methods = methodArr;
                    length = i6;
                } else {
                    str4 = name;
                    method2 = method;
                    methodArr = methods;
                    bVar4 = bVar2;
                    i6 = length;
                    c = 'f';
                    i8 = i7;
                    i7 = i5;
                }
                String str9 = str4;
                if (str9.startsWith("is") && str9.length() >= 3) {
                    char charAt2 = str9.charAt(2);
                    if (Character.isUpperCase(charAt2)) {
                        if (a) {
                            substring = a(str9.substring(2));
                        } else {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(Character.toLowerCase(str9.charAt(2)));
                            stringBuilder2.append(str9.substring(3));
                            substring = stringBuilder2.toString();
                        }
                    } else if (charAt2 == '_') {
                        substring = str9.substring(3);
                    } else if (charAt2 == c) {
                        substring = str9.substring(2);
                    }
                    a = g.a(cls2, substring);
                    if (a == null) {
                        a = g.a(cls2, str9);
                    }
                    if (a != null) {
                        bVar3 = (com.alibaba.fastjson.a.b) a.getAnnotation(com.alibaba.fastjson.a.b.class);
                        if (bVar3 == null) {
                            str3 = str;
                            str2 = substring;
                            bVar = bVar3;
                        } else if (bVar3.d()) {
                            a2 = bVar3.a();
                            int of2 = SerializerFeature.of(bVar3.f());
                            if (bVar3.b().length() != 0) {
                                substring = bVar3.b();
                            }
                            if (bVar3.g().length() != 0) {
                                str = bVar3.g();
                            }
                            str3 = str;
                            str2 = substring;
                            bVar = bVar3;
                            i5 = a2;
                            i = of2;
                            linkedHashMap.put(str2, new d(str2, method2, a, cls2, null, i5, i, bVar4, bVar, str3));
                        }
                    } else {
                        str3 = str;
                        str2 = substring;
                        bVar = null;
                    }
                    i5 = i7;
                    i = i8;
                    linkedHashMap.put(str2, new d(str2, method2, a, cls2, null, i5, i, bVar4, bVar, str3));
                }
                i3 = i4 + 1;
                methods = methodArr;
                length = i6;
            }
            i4 = i3;
            methodArr = methods;
            i6 = length;
            i3 = i4 + 1;
            methods = methodArr;
            length = i6;
        }
        Field[] fields = cls.getFields();
        int length2 = fields.length;
        length = 0;
        while (length < length2) {
            Field[] fieldArr;
            a = fields[length];
            if (!Modifier.isStatic(a.getModifiers())) {
                String str10;
                bVar = (com.alibaba.fastjson.a.b) a.getAnnotation(com.alibaba.fastjson.a.b.class);
                str = a.getName();
                if (bVar == null) {
                    str3 = str;
                    str10 = null;
                    i5 = 0;
                    i = 0;
                } else if (bVar.d()) {
                    int a3 = bVar.a();
                    of = SerializerFeature.of(bVar.f());
                    if (bVar.b().length() != 0) {
                        str = bVar.b();
                    }
                    if (bVar.g().length() != 0) {
                        str3 = str;
                        i5 = a3;
                        i = of;
                        str10 = bVar.g();
                    } else {
                        str3 = str;
                        i5 = a3;
                        i = of;
                        str10 = null;
                    }
                }
                if (!linkedHashMap.containsKey(str3)) {
                    d dVar4 = dVar;
                    fieldArr = fields;
                    str2 = str3;
                    dVar = new d(str3, null, a, cls2, null, i5, i, null, bVar, str10);
                    linkedHashMap.put(str2, dVar4);
                    length++;
                    fields = fieldArr;
                }
            }
            fieldArr = fields;
            length++;
            fields = fieldArr;
        }
        List<d> arrayList = new ArrayList();
        d dVar5 = (d) cls2.getAnnotation(d.class);
        String[] b;
        if (dVar5 != null) {
            b = dVar5.b();
            if (b != null && b.length == linkedHashMap.size()) {
                of = b.length;
                i2 = 0;
                while (i2 < of) {
                    if (linkedHashMap.containsKey(b[i2])) {
                        i2++;
                    }
                }
                obj = 1;
                if (obj == null) {
                    for (Object obj2 : r1) {
                        arrayList.add((d) linkedHashMap.get(obj2));
                    }
                } else {
                    for (d add : linkedHashMap.values()) {
                        arrayList.add(add);
                    }
                    if (z) {
                        Collections.sort(arrayList);
                    }
                }
                return arrayList;
            }
        } else {
            b = null;
        }
        obj = null;
        if (obj == null) {
            while (r1.hasNext()) {
                arrayList.add(add);
            }
            if (z) {
                Collections.sort(arrayList);
            }
        } else {
            while (i2 < of) {
                arrayList.add((d) linkedHashMap.get(obj2));
            }
        }
        return arrayList;
    }

    public static com.alibaba.fastjson.a.b a(Class<?> cls, Method method) {
        cls = cls.getInterfaces();
        if (cls.length > 0) {
            Class[] parameterTypes = method.getParameterTypes();
            for (Class methods : cls) {
                for (Method method2 : methods.getMethods()) {
                    Class[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes2.length == parameterTypes.length && method2.getName().equals(method.getName())) {
                        Object obj;
                        for (int i = 0; i < parameterTypes.length; i++) {
                            if (!parameterTypes2[i].equals(parameterTypes[i])) {
                                obj = null;
                                break;
                            }
                        }
                        obj = 1;
                        if (obj != null) {
                            com.alibaba.fastjson.a.b bVar = (com.alibaba.fastjson.a.b) method2.getAnnotation(com.alibaba.fastjson.a.b.class);
                            if (bVar != null) {
                                return bVar;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        return null;
    }

    private static boolean a(Class<?> cls, String str) {
        d dVar = (d) cls.getAnnotation(d.class);
        if (dVar != null) {
            String[] c = dVar.c();
            if (c.length > 0) {
                for (Object equals : c) {
                    if (str.equals(equals)) {
                        return false;
                    }
                }
                return true;
            }
            String[] d = dVar.d();
            for (Object equals2 : d) {
                if (str.equals(equals2)) {
                    return true;
                }
            }
        }
        return (cls.getSuperclass() == Object.class || cls.getSuperclass() == null || a(cls.getSuperclass(), str) == null) ? false : true;
    }

    public static boolean a(Type type) {
        while (!(type instanceof ParameterizedType)) {
            if (!(type instanceof Class)) {
                return false;
            }
            type = ((Class) type).getGenericSuperclass();
            if (type == Object.class) {
                return false;
            }
        }
        return true;
    }

    public static Type b(Type type) {
        while (!(type instanceof ParameterizedType) && (type instanceof Class)) {
            type = ((Class) type).getGenericSuperclass();
        }
        return type;
    }

    public static Type c(Type type) {
        if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            if (genericComponentType == Byte.TYPE) {
                return byte[].class;
            }
            if (genericComponentType == Character.TYPE) {
                return char[].class;
            }
        }
        return type;
    }

    public static java.lang.reflect.Type d(java.lang.reflect.Type r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = g;
        if (r0 != 0) goto L_0x0014;
    L_0x0004:
        r0 = 1;
        r1 = "java.util.Optional";	 Catch:{ Exception -> 0x0012, all -> 0x000e }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x0012, all -> 0x000e }
        h = r1;	 Catch:{ Exception -> 0x0012, all -> 0x000e }
        goto L_0x0012;
    L_0x000e:
        r3 = move-exception;
        g = r0;
        throw r3;
    L_0x0012:
        g = r0;
    L_0x0014:
        r0 = r3 instanceof java.lang.reflect.ParameterizedType;
        if (r0 == 0) goto L_0x002b;
    L_0x0018:
        r0 = r3;
        r0 = (java.lang.reflect.ParameterizedType) r0;
        r1 = r0.getRawType();
        r2 = h;
        if (r1 != r2) goto L_0x002b;
    L_0x0023:
        r3 = r0.getActualTypeArguments();
        r0 = 0;
        r3 = r3[r0];
        return r3;
    L_0x002b:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.c.j.d(java.lang.reflect.Type):java.lang.reflect.Type");
    }

    public static Class<?> e(Type type) {
        while (type.getClass() != Class.class) {
            if (type instanceof ParameterizedType) {
                type = ((ParameterizedType) type).getRawType();
            } else if (type instanceof TypeVariable) {
                return (Class) ((TypeVariable) type).getBounds()[0];
            } else {
                return Object.class;
            }
        }
        return (Class) type;
    }

    public static Field a(Class<?> cls, String str, Field[] fieldArr) {
        while (true) {
            for (Field field : r6) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            cls = cls.getSuperclass();
            if (cls != null && cls != Object.class) {
                fieldArr = cls.getDeclaredFields();
            }
        }
        return null;
    }

    public static int a(Class<?> cls) {
        d dVar = (d) cls.getAnnotation(d.class);
        if (dVar == null) {
            return null;
        }
        return SerializerFeature.of(dVar.e());
    }

    public static int b(Class<?> cls) {
        d dVar = (d) cls.getAnnotation(d.class);
        if (dVar == null) {
            return null;
        }
        return Feature.of(dVar.f());
    }

    public static String a(String str) {
        if (str != null) {
            if (str.length() != 0) {
                if (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0))) {
                    return str;
                }
                str = str.toCharArray();
                str[0] = Character.toLowerCase(str[0]);
                return new String(str);
            }
        }
        return str;
    }

    public static void a(java.lang.reflect.AccessibleObject r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = b;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r1.isAccessible();
        if (r0 == 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        r0 = 1;
        r1.setAccessible(r0);	 Catch:{ AccessControlException -> 0x0011 }
        return;
    L_0x0011:
        r1 = 0;
        b = r1;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.c.j.a(java.lang.reflect.AccessibleObject):void");
    }

    public static Class<?> f(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return Object.class;
        }
        type = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (Modifier.isPublic(cls.getModifiers())) {
                return cls;
            }
            throw new JSONException("can not create ASMParser");
        }
        throw new JSONException("can not create ASMParser");
    }

    public static java.util.Collection g(java.lang.reflect.Type r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = r3;
    L_0x0001:
        r1 = r0 instanceof java.lang.Class;
        if (r1 == 0) goto L_0x008e;
    L_0x0005:
        r0 = (java.lang.Class) r0;
        r1 = java.util.AbstractCollection.class;
        if (r0 == r1) goto L_0x0088;
    L_0x000b:
        r1 = java.util.Collection.class;
        if (r0 != r1) goto L_0x0011;
    L_0x000f:
        goto L_0x0088;
    L_0x0011:
        r1 = java.util.HashSet.class;
        r1 = r0.isAssignableFrom(r1);
        if (r1 == 0) goto L_0x0020;
    L_0x0019:
        r3 = new java.util.HashSet;
        r3.<init>();
        goto L_0x008d;
    L_0x0020:
        r1 = java.util.LinkedHashSet.class;
        r1 = r0.isAssignableFrom(r1);
        if (r1 == 0) goto L_0x002e;
    L_0x0028:
        r3 = new java.util.LinkedHashSet;
        r3.<init>();
        goto L_0x008d;
    L_0x002e:
        r1 = java.util.TreeSet.class;
        r1 = r0.isAssignableFrom(r1);
        if (r1 == 0) goto L_0x003c;
    L_0x0036:
        r3 = new java.util.TreeSet;
        r3.<init>();
        goto L_0x008d;
    L_0x003c:
        r1 = java.util.ArrayList.class;
        r1 = r0.isAssignableFrom(r1);
        if (r1 == 0) goto L_0x004a;
    L_0x0044:
        r3 = new java.util.ArrayList;
        r3.<init>();
        goto L_0x008d;
    L_0x004a:
        r1 = java.util.EnumSet.class;
        r1 = r0.isAssignableFrom(r1);
        if (r1 == 0) goto L_0x0069;
    L_0x0052:
        r0 = r3 instanceof java.lang.reflect.ParameterizedType;
        if (r0 == 0) goto L_0x0060;
    L_0x0056:
        r3 = (java.lang.reflect.ParameterizedType) r3;
        r3 = r3.getActualTypeArguments();
        r0 = 0;
        r3 = r3[r0];
        goto L_0x0062;
    L_0x0060:
        r3 = java.lang.Object.class;
    L_0x0062:
        r3 = (java.lang.Class) r3;
        r3 = java.util.EnumSet.noneOf(r3);
        goto L_0x008d;
    L_0x0069:
        r3 = r0.newInstance();	 Catch:{ Exception -> 0x0070 }
        r3 = (java.util.Collection) r3;	 Catch:{ Exception -> 0x0070 }
        goto L_0x008d;
    L_0x0070:
        r3 = new com.alibaba.fastjson.JSONException;
        r1 = new java.lang.StringBuilder;
        r2 = "create instane error, class ";
        r1.<init>(r2);
        r0 = r0.getName();
        r1.append(r0);
        r0 = r1.toString();
        r3.<init>(r0);
        throw r3;
    L_0x0088:
        r3 = new java.util.ArrayList;
        r3.<init>();
    L_0x008d:
        return r3;
    L_0x008e:
        r1 = r0 instanceof java.lang.reflect.ParameterizedType;
        if (r1 == 0) goto L_0x009a;
    L_0x0092:
        r0 = (java.lang.reflect.ParameterizedType) r0;
        r0 = r0.getRawType();
        goto L_0x0001;
    L_0x009a:
        r3 = new com.alibaba.fastjson.JSONException;
        r0 = "TODO";
        r3.<init>(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.c.j.g(java.lang.reflect.Type):java.util.Collection");
    }
}
