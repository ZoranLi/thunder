package com.alibaba.fastjson.parser.a;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.parser.b;
import com.alibaba.fastjson.parser.e;
import com.alibaba.fastjson.parser.f;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: MapDeserializer */
public final class p implements r {
    public static p a = new p();

    public final int e_() {
        return 12;
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        if (type == JSONObject.class && aVar.e() == null) {
            return (JSONObject) aVar.a(new JSONObject(aVar.e.a(Feature.OrderedField)), null);
        }
        b bVar = aVar.e;
        if (bVar.a() == 8) {
            bVar.a(16);
            return null;
        }
        Map a = a(type);
        f c = aVar.c();
        try {
            aVar.a(c, (Object) a, obj);
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type type2 = parameterizedType.getActualTypeArguments()[0];
                type = parameterizedType.getActualTypeArguments()[1];
                if (String.class == type2) {
                    type = a(aVar, a, type, obj);
                } else {
                    type = a(aVar, a, type2, type);
                }
            } else {
                type = aVar.a(a, obj);
            }
            aVar.a(c);
            return type;
        } catch (Throwable th) {
            aVar.a(c);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Map a(com.alibaba.fastjson.parser.a r8, java.util.Map<java.lang.String, java.lang.Object> r9, java.lang.reflect.Type r10, java.lang.Object r11) {
        /*
        r0 = r8.e;
        r1 = r0.a();
        r2 = 12;
        if (r1 == r2) goto L_0x0022;
    L_0x000a:
        r8 = new com.alibaba.fastjson.JSONException;
        r9 = new java.lang.StringBuilder;
        r10 = "syntax error, expect {, actual ";
        r9.<init>(r10);
        r10 = r0.a();
        r9.append(r10);
        r9 = r9.toString();
        r8.<init>(r9);
        throw r8;
    L_0x0022:
        r1 = r8.c();
        r2 = 0;
    L_0x0027:
        r0.c();	 Catch:{ all -> 0x01a4 }
        r3 = r0.e();	 Catch:{ all -> 0x01a4 }
        r4 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas;	 Catch:{ all -> 0x01a4 }
        r4 = r0.a(r4);	 Catch:{ all -> 0x01a4 }
        if (r4 == 0) goto L_0x0045;
    L_0x0036:
        r4 = 44;
        if (r3 != r4) goto L_0x0045;
    L_0x003a:
        r0.f();	 Catch:{ all -> 0x01a4 }
        r0.c();	 Catch:{ all -> 0x01a4 }
        r3 = r0.e();	 Catch:{ all -> 0x01a4 }
        goto L_0x0036;
    L_0x0045:
        r4 = 58;
        r5 = 34;
        r6 = 16;
        if (r3 != r5) goto L_0x0074;
    L_0x004d:
        r3 = r8.b;	 Catch:{ all -> 0x01a4 }
        r3 = r0.a(r3, r5);	 Catch:{ all -> 0x01a4 }
        r0.c();	 Catch:{ all -> 0x01a4 }
        r7 = r0.e();	 Catch:{ all -> 0x01a4 }
        if (r7 == r4) goto L_0x00ff;
    L_0x005c:
        r9 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x01a4 }
        r10 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01a4 }
        r11 = "expect ':' at ";
        r10.<init>(r11);	 Catch:{ all -> 0x01a4 }
        r11 = r0.i();	 Catch:{ all -> 0x01a4 }
        r10.append(r11);	 Catch:{ all -> 0x01a4 }
        r10 = r10.toString();	 Catch:{ all -> 0x01a4 }
        r9.<init>(r10);	 Catch:{ all -> 0x01a4 }
        throw r9;	 Catch:{ all -> 0x01a4 }
    L_0x0074:
        r7 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        if (r3 != r7) goto L_0x0085;
    L_0x0078:
        r0.f();	 Catch:{ all -> 0x01a4 }
        r0.g();	 Catch:{ all -> 0x01a4 }
        r0.a(r6);	 Catch:{ all -> 0x01a4 }
        r8.a(r1);
        return r9;
    L_0x0085:
        r7 = 39;
        if (r3 != r7) goto L_0x00c0;
    L_0x0089:
        r3 = com.alibaba.fastjson.parser.Feature.AllowSingleQuotes;	 Catch:{ all -> 0x01a4 }
        r3 = r0.a(r3);	 Catch:{ all -> 0x01a4 }
        if (r3 != 0) goto L_0x0099;
    L_0x0091:
        r9 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x01a4 }
        r10 = "syntax error";
        r9.<init>(r10);	 Catch:{ all -> 0x01a4 }
        throw r9;	 Catch:{ all -> 0x01a4 }
    L_0x0099:
        r3 = r8.b;	 Catch:{ all -> 0x01a4 }
        r3 = r0.a(r3, r7);	 Catch:{ all -> 0x01a4 }
        r0.c();	 Catch:{ all -> 0x01a4 }
        r7 = r0.e();	 Catch:{ all -> 0x01a4 }
        if (r7 == r4) goto L_0x00ff;
    L_0x00a8:
        r9 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x01a4 }
        r10 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01a4 }
        r11 = "expect ':' at ";
        r10.<init>(r11);	 Catch:{ all -> 0x01a4 }
        r11 = r0.i();	 Catch:{ all -> 0x01a4 }
        r10.append(r11);	 Catch:{ all -> 0x01a4 }
        r10 = r10.toString();	 Catch:{ all -> 0x01a4 }
        r9.<init>(r10);	 Catch:{ all -> 0x01a4 }
        throw r9;	 Catch:{ all -> 0x01a4 }
    L_0x00c0:
        r3 = com.alibaba.fastjson.parser.Feature.AllowUnQuotedFieldNames;	 Catch:{ all -> 0x01a4 }
        r3 = r0.a(r3);	 Catch:{ all -> 0x01a4 }
        if (r3 != 0) goto L_0x00d0;
    L_0x00c8:
        r9 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x01a4 }
        r10 = "syntax error";
        r9.<init>(r10);	 Catch:{ all -> 0x01a4 }
        throw r9;	 Catch:{ all -> 0x01a4 }
    L_0x00d0:
        r3 = r8.b;	 Catch:{ all -> 0x01a4 }
        r3 = r0.b(r3);	 Catch:{ all -> 0x01a4 }
        r0.c();	 Catch:{ all -> 0x01a4 }
        r7 = r0.e();	 Catch:{ all -> 0x01a4 }
        if (r7 == r4) goto L_0x00ff;
    L_0x00df:
        r9 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x01a4 }
        r10 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01a4 }
        r11 = "expect ':' at ";
        r10.<init>(r11);	 Catch:{ all -> 0x01a4 }
        r11 = r0.i();	 Catch:{ all -> 0x01a4 }
        r10.append(r11);	 Catch:{ all -> 0x01a4 }
        r11 = ", actual ";
        r10.append(r11);	 Catch:{ all -> 0x01a4 }
        r10.append(r7);	 Catch:{ all -> 0x01a4 }
        r10 = r10.toString();	 Catch:{ all -> 0x01a4 }
        r9.<init>(r10);	 Catch:{ all -> 0x01a4 }
        throw r9;	 Catch:{ all -> 0x01a4 }
    L_0x00ff:
        r0.f();	 Catch:{ all -> 0x01a4 }
        r0.c();	 Catch:{ all -> 0x01a4 }
        r0.g();	 Catch:{ all -> 0x01a4 }
        r4 = com.alibaba.fastjson.a.DEFAULT_TYPE_KEY;	 Catch:{ all -> 0x01a4 }
        r7 = 13;
        if (r3 != r4) goto L_0x0161;
    L_0x010e:
        r4 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect;	 Catch:{ all -> 0x01a4 }
        r4 = r0.a(r4);	 Catch:{ all -> 0x01a4 }
        if (r4 != 0) goto L_0x0161;
    L_0x0116:
        r3 = r8.b;	 Catch:{ all -> 0x01a4 }
        r3 = r0.a(r3, r5);	 Catch:{ all -> 0x01a4 }
        r4 = r8.b();	 Catch:{ all -> 0x01a4 }
        r4 = r4.b();	 Catch:{ all -> 0x01a4 }
        r3 = com.alibaba.fastjson.c.j.a(r3, r4);	 Catch:{ all -> 0x01a4 }
        r4 = java.util.Map.class;
        r4 = r4.isAssignableFrom(r3);	 Catch:{ all -> 0x01a4 }
        if (r4 == 0) goto L_0x0140;
    L_0x0130:
        r0.a(r6);	 Catch:{ all -> 0x01a4 }
        r3 = r0.a();	 Catch:{ all -> 0x01a4 }
        if (r3 != r7) goto L_0x019c;
    L_0x0139:
        r0.a(r6);	 Catch:{ all -> 0x01a4 }
        r8.a(r1);
        return r9;
    L_0x0140:
        r9 = r8.b();	 Catch:{ all -> 0x01a4 }
        r9 = r9.a(r3);	 Catch:{ all -> 0x01a4 }
        r0.a(r6);	 Catch:{ all -> 0x01a4 }
        r10 = 2;
        r8.g = r10;	 Catch:{ all -> 0x01a4 }
        if (r1 == 0) goto L_0x0157;
    L_0x0150:
        r10 = r11 instanceof java.lang.Integer;	 Catch:{ all -> 0x01a4 }
        if (r10 != 0) goto L_0x0157;
    L_0x0154:
        r8.f();	 Catch:{ all -> 0x01a4 }
    L_0x0157:
        r9 = r9.a(r8, r3, r11);	 Catch:{ all -> 0x01a4 }
        r9 = (java.util.Map) r9;	 Catch:{ all -> 0x01a4 }
        r8.a(r1);
        return r9;
    L_0x0161:
        r0.d();	 Catch:{ all -> 0x01a4 }
        if (r2 == 0) goto L_0x0169;
    L_0x0166:
        r8.a(r1);	 Catch:{ all -> 0x01a4 }
    L_0x0169:
        r4 = r0.a();	 Catch:{ all -> 0x01a4 }
        r5 = 8;
        if (r4 != r5) goto L_0x0176;
    L_0x0171:
        r4 = 0;
        r0.d();	 Catch:{ all -> 0x01a4 }
        goto L_0x017a;
    L_0x0176:
        r4 = r8.a(r10, r3);	 Catch:{ all -> 0x01a4 }
    L_0x017a:
        r9.put(r3, r4);	 Catch:{ all -> 0x01a4 }
        r8.b(r9, r3);	 Catch:{ all -> 0x01a4 }
        r8.a(r1, r4, r3);	 Catch:{ all -> 0x01a4 }
        r8.a(r1);	 Catch:{ all -> 0x01a4 }
        r3 = r0.a();	 Catch:{ all -> 0x01a4 }
        r4 = 20;
        if (r3 == r4) goto L_0x01a0;
    L_0x018e:
        r4 = 15;
        if (r3 != r4) goto L_0x0193;
    L_0x0192:
        goto L_0x01a0;
    L_0x0193:
        if (r3 != r7) goto L_0x019c;
    L_0x0195:
        r0.d();	 Catch:{ all -> 0x01a4 }
        r8.a(r1);
        return r9;
    L_0x019c:
        r2 = r2 + 1;
        goto L_0x0027;
    L_0x01a0:
        r8.a(r1);
        return r9;
    L_0x01a4:
        r9 = move-exception;
        r8.a(r1);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.a.p.a(com.alibaba.fastjson.parser.a, java.util.Map, java.lang.reflect.Type, java.lang.Object):java.util.Map");
    }

    private static Object a(a aVar, Map<Object, Object> map, Type type, Type type2) {
        b bVar = aVar.e;
        if (bVar.a() == 12 || bVar.a() == 16) {
            r a = aVar.b().a(type);
            r a2 = aVar.b().a(type2);
            bVar.a(a.e_());
            f c = aVar.c();
            while (bVar.a() != 13) {
                try {
                    Object obj = null;
                    if (bVar.a() == 4 && bVar.t() && !bVar.a(Feature.DisableSpecialKeyDetect)) {
                        bVar.p();
                        if (bVar.a() == 4) {
                            map = bVar.l();
                            if ("..".equals(map) != null) {
                                obj = c.b.a;
                            } else if ("$".equals(map) != null) {
                                map = c;
                                while (map.b != null) {
                                    map = map.b;
                                }
                                obj = map.a;
                            } else {
                                aVar.a(new a.a(c, map));
                                aVar.g = 1;
                            }
                            bVar.a(13);
                            if (bVar.a() != 13) {
                                throw new JSONException("illegal ref");
                            }
                            bVar.a(16);
                            aVar.a(c);
                            return obj;
                        }
                        type = new StringBuilder("illegal ref, ");
                        type.append(e.a(bVar.a()));
                        throw new JSONException(type.toString());
                    }
                    if (map.size() == 0 && bVar.a() == 4 && com.alibaba.fastjson.a.DEFAULT_TYPE_KEY.equals(bVar.l()) && !bVar.a(Feature.DisableSpecialKeyDetect)) {
                        bVar.p();
                        bVar.a(16);
                        if (bVar.a() == 13) {
                            bVar.d();
                            return map;
                        }
                        bVar.a(a.e_());
                    }
                    Object a3 = a.a(aVar, type, null);
                    if (bVar.a() != 17) {
                        type = new StringBuilder("syntax error, expect :, actual ");
                        type.append(bVar.a());
                        throw new JSONException(type.toString());
                    }
                    bVar.a(a2.e_());
                    Object a4 = a2.a(aVar, type2, a3);
                    aVar.b(map, a3);
                    map.put(a3, a4);
                    if (bVar.a() == 16) {
                        bVar.a(a.e_());
                    }
                } finally {
                    aVar.a(c);
                }
            }
            bVar.a(16);
            aVar.a(c);
            return map;
        }
        map = new StringBuilder("syntax error, expect {, actual ");
        map.append(bVar.b());
        throw new JSONException(map.toString());
    }

    private static Map<Object, Object> a(Type type) {
        while (type != Properties.class) {
            if (type == Hashtable.class) {
                return new Hashtable();
            }
            if (type == IdentityHashMap.class) {
                return new IdentityHashMap();
            }
            if (type != SortedMap.class) {
                if (type != TreeMap.class) {
                    if (type != ConcurrentMap.class) {
                        if (type != ConcurrentHashMap.class) {
                            if (type != Map.class) {
                                if (type != HashMap.class) {
                                    if (type == LinkedHashMap.class) {
                                        return new LinkedHashMap();
                                    }
                                    if (type instanceof ParameterizedType) {
                                        type = ((ParameterizedType) type).getRawType();
                                    } else {
                                        Class cls = (Class) type;
                                        if (cls.isInterface()) {
                                            StringBuilder stringBuilder = new StringBuilder("unsupport type ");
                                            stringBuilder.append(type);
                                            throw new JSONException(stringBuilder.toString());
                                        }
                                        try {
                                            return (Map) cls.newInstance();
                                        } catch (Throwable e) {
                                            StringBuilder stringBuilder2 = new StringBuilder("unsupport type ");
                                            stringBuilder2.append(type);
                                            throw new JSONException(stringBuilder2.toString(), e);
                                        }
                                    }
                                }
                            }
                            return new HashMap();
                        }
                    }
                    return new ConcurrentHashMap();
                }
            }
            return new TreeMap();
        }
        return new Properties();
    }
}
