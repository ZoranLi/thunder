package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.a.b;
import com.alibaba.fastjson.parser.a.h;
import com.alibaba.fastjson.parser.a.i;
import com.alibaba.fastjson.parser.a.j;
import com.alibaba.fastjson.parser.a.k;
import com.alibaba.fastjson.parser.a.l;
import com.alibaba.fastjson.parser.a.m;
import com.alibaba.fastjson.parser.a.r;
import com.alibaba.fastjson.parser.a.u;
import com.alibaba.fastjson.serializer.ab;
import com.alibaba.fastjson.serializer.aj;
import com.alibaba.fastjson.serializer.ay;
import java.io.Closeable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* compiled from: DefaultJSONParser */
public class a implements Closeable {
    private static final Set<Class<?>> k;
    public final Object a;
    public final h b;
    protected g c;
    public String d;
    public final b e;
    protected f f;
    public int g;
    public List<j> h;
    public List<i> i;
    protected l j;
    private DateFormat l;
    private f[] m;
    private int n;
    private List<a> o;

    /* compiled from: DefaultJSONParser */
    public static class a {
        public k a;
        public f b;
        private final f c;
        private final String d;

        public a(f fVar, String str) {
            this.c = fVar;
            this.d = str;
        }
    }

    static {
        Set hashSet = new HashSet();
        k = hashSet;
        hashSet.add(Boolean.TYPE);
        k.add(Byte.TYPE);
        k.add(Short.TYPE);
        k.add(Integer.TYPE);
        k.add(Long.TYPE);
        k.add(Float.TYPE);
        k.add(Double.TYPE);
        k.add(Boolean.class);
        k.add(Byte.class);
        k.add(Short.class);
        k.add(Integer.class);
        k.add(Long.class);
        k.add(Float.class);
        k.add(Double.class);
        k.add(BigInteger.class);
        k.add(BigDecimal.class);
        k.add(String.class);
    }

    public final DateFormat a() {
        if (this.l == null) {
            this.l = new SimpleDateFormat(this.d, this.e.y());
            this.l.setTimeZone(this.e.x());
        }
        return this.l;
    }

    public a(String str, g gVar) {
        this((Object) str, new d(str, com.alibaba.fastjson.a.DEFAULT_PARSER_FEATURE), gVar);
    }

    public a(String str, g gVar, int i) {
        this((Object) str, new d(str, i), gVar);
    }

    public a(char[] cArr, int i, g gVar, int i2) {
        this((Object) cArr, new d(cArr, i, i2), gVar);
    }

    private a(Object obj, b bVar, g gVar) {
        this.d = com.alibaba.fastjson.a.DEFFAULT_DATE_FORMAT;
        this.n = 0;
        this.g = 0;
        this.h = null;
        this.i = null;
        this.j = null;
        this.e = bVar;
        this.a = obj;
        this.c = gVar;
        this.b = gVar.b;
        bVar.a(12);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.util.Map r18, java.lang.Object r19) {
        /*
        r17 = this;
        r1 = r17;
        r2 = r18;
        r3 = r19;
        r4 = r1.e;
        r5 = r4.a();
        r6 = 0;
        r7 = 8;
        if (r5 != r7) goto L_0x0015;
    L_0x0011:
        r4.d();
        return r6;
    L_0x0015:
        r5 = r4.a();
        r7 = 13;
        if (r5 != r7) goto L_0x0021;
    L_0x001d:
        r4.d();
        return r2;
    L_0x0021:
        r5 = r4.a();
        r8 = 12;
        r9 = 16;
        if (r5 == r8) goto L_0x0055;
    L_0x002b:
        r5 = r4.a();
        if (r5 == r9) goto L_0x0055;
    L_0x0031:
        r2 = new com.alibaba.fastjson.JSONException;
        r3 = new java.lang.StringBuilder;
        r5 = "syntax error, expect {, actual ";
        r3.<init>(r5);
        r5 = r4.b();
        r3.append(r5);
        r5 = ", ";
        r3.append(r5);
        r4 = r4.z();
        r3.append(r4);
        r3 = r3.toString();
        r2.<init>(r3);
        throw r2;
    L_0x0055:
        r5 = r1.f;
        r10 = 0;
    L_0x0058:
        r4.c();	 Catch:{ all -> 0x051a }
        r11 = r4.e();	 Catch:{ all -> 0x051a }
        r12 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas;	 Catch:{ all -> 0x051a }
        r12 = r4.a(r12);	 Catch:{ all -> 0x051a }
        r13 = 44;
        if (r12 == 0) goto L_0x0076;
    L_0x0069:
        if (r11 != r13) goto L_0x0076;
    L_0x006b:
        r4.f();	 Catch:{ all -> 0x051a }
        r4.c();	 Catch:{ all -> 0x051a }
        r11 = r4.e();	 Catch:{ all -> 0x051a }
        goto L_0x0069;
    L_0x0076:
        r14 = 45;
        r15 = 57;
        r8 = 48;
        r7 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        r6 = 58;
        r12 = 34;
        r9 = 1;
        if (r11 != r12) goto L_0x00b7;
    L_0x0085:
        r11 = r1.b;	 Catch:{ all -> 0x051a }
        r11 = r4.a(r11, r12);	 Catch:{ all -> 0x051a }
        r4.c();	 Catch:{ all -> 0x051a }
        r12 = r4.e();	 Catch:{ all -> 0x051a }
        if (r12 == r6) goto L_0x00b4;
    L_0x0094:
        r2 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x051a }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x051a }
        r6 = "expect ':' at ";
        r3.<init>(r6);	 Catch:{ all -> 0x051a }
        r4 = r4.i();	 Catch:{ all -> 0x051a }
        r3.append(r4);	 Catch:{ all -> 0x051a }
        r4 = ", name ";
        r3.append(r4);	 Catch:{ all -> 0x051a }
        r3.append(r11);	 Catch:{ all -> 0x051a }
        r3 = r3.toString();	 Catch:{ all -> 0x051a }
        r2.<init>(r3);	 Catch:{ all -> 0x051a }
        throw r2;	 Catch:{ all -> 0x051a }
    L_0x00b4:
        r6 = 0;
        goto L_0x01aa;
    L_0x00b7:
        if (r11 != r7) goto L_0x00c6;
    L_0x00b9:
        r4.f();	 Catch:{ all -> 0x051a }
        r4.g();	 Catch:{ all -> 0x051a }
        r4.d();	 Catch:{ all -> 0x051a }
        r1.a(r5);
        return r2;
    L_0x00c6:
        r12 = 39;
        if (r11 != r12) goto L_0x0101;
    L_0x00ca:
        r11 = com.alibaba.fastjson.parser.Feature.AllowSingleQuotes;	 Catch:{ all -> 0x051a }
        r11 = r4.a(r11);	 Catch:{ all -> 0x051a }
        if (r11 != 0) goto L_0x00da;
    L_0x00d2:
        r2 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x051a }
        r3 = "syntax error";
        r2.<init>(r3);	 Catch:{ all -> 0x051a }
        throw r2;	 Catch:{ all -> 0x051a }
    L_0x00da:
        r11 = r1.b;	 Catch:{ all -> 0x051a }
        r11 = r4.a(r11, r12);	 Catch:{ all -> 0x051a }
        r4.c();	 Catch:{ all -> 0x051a }
        r12 = r4.e();	 Catch:{ all -> 0x051a }
        if (r12 == r6) goto L_0x00b4;
    L_0x00e9:
        r2 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x051a }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x051a }
        r6 = "expect ':' at ";
        r3.<init>(r6);	 Catch:{ all -> 0x051a }
        r4 = r4.i();	 Catch:{ all -> 0x051a }
        r3.append(r4);	 Catch:{ all -> 0x051a }
        r3 = r3.toString();	 Catch:{ all -> 0x051a }
        r2.<init>(r3);	 Catch:{ all -> 0x051a }
        throw r2;	 Catch:{ all -> 0x051a }
    L_0x0101:
        r12 = 26;
        if (r11 != r12) goto L_0x010d;
    L_0x0105:
        r2 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x051a }
        r3 = "syntax error";
        r2.<init>(r3);	 Catch:{ all -> 0x051a }
        throw r2;	 Catch:{ all -> 0x051a }
    L_0x010d:
        if (r11 != r13) goto L_0x0117;
    L_0x010f:
        r2 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x051a }
        r3 = "syntax error";
        r2.<init>(r3);	 Catch:{ all -> 0x051a }
        throw r2;	 Catch:{ all -> 0x051a }
    L_0x0117:
        if (r11 < r8) goto L_0x011b;
    L_0x0119:
        if (r11 <= r15) goto L_0x011d;
    L_0x011b:
        if (r11 != r14) goto L_0x0159;
    L_0x011d:
        r4.g();	 Catch:{ all -> 0x051a }
        r4.h();	 Catch:{ all -> 0x051a }
        r11 = r4.a();	 Catch:{ all -> 0x051a }
        r12 = 2;
        if (r11 != r12) goto L_0x012f;
    L_0x012a:
        r11 = r4.j();	 Catch:{ all -> 0x051a }
        goto L_0x0133;
    L_0x012f:
        r11 = r4.a(r9);	 Catch:{ all -> 0x051a }
    L_0x0133:
        r12 = r4.e();	 Catch:{ all -> 0x051a }
        if (r12 == r6) goto L_0x00b4;
    L_0x0139:
        r2 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x051a }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x051a }
        r6 = "expect ':' at ";
        r3.<init>(r6);	 Catch:{ all -> 0x051a }
        r4 = r4.i();	 Catch:{ all -> 0x051a }
        r3.append(r4);	 Catch:{ all -> 0x051a }
        r4 = ", name ";
        r3.append(r4);	 Catch:{ all -> 0x051a }
        r3.append(r11);	 Catch:{ all -> 0x051a }
        r3 = r3.toString();	 Catch:{ all -> 0x051a }
        r2.<init>(r3);	 Catch:{ all -> 0x051a }
        throw r2;	 Catch:{ all -> 0x051a }
    L_0x0159:
        r12 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        if (r11 == r12) goto L_0x01a1;
    L_0x015d:
        r12 = 91;
        if (r11 != r12) goto L_0x0162;
    L_0x0161:
        goto L_0x01a1;
    L_0x0162:
        r11 = com.alibaba.fastjson.parser.Feature.AllowUnQuotedFieldNames;	 Catch:{ all -> 0x051a }
        r11 = r4.a(r11);	 Catch:{ all -> 0x051a }
        if (r11 != 0) goto L_0x0172;
    L_0x016a:
        r2 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x051a }
        r3 = "syntax error";
        r2.<init>(r3);	 Catch:{ all -> 0x051a }
        throw r2;	 Catch:{ all -> 0x051a }
    L_0x0172:
        r11 = r1.b;	 Catch:{ all -> 0x051a }
        r11 = r4.b(r11);	 Catch:{ all -> 0x051a }
        r4.c();	 Catch:{ all -> 0x051a }
        r12 = r4.e();	 Catch:{ all -> 0x051a }
        if (r12 == r6) goto L_0x00b4;
    L_0x0181:
        r2 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x051a }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x051a }
        r6 = "expect ':' at ";
        r3.<init>(r6);	 Catch:{ all -> 0x051a }
        r4 = r4.i();	 Catch:{ all -> 0x051a }
        r3.append(r4);	 Catch:{ all -> 0x051a }
        r4 = ", actual ";
        r3.append(r4);	 Catch:{ all -> 0x051a }
        r3.append(r12);	 Catch:{ all -> 0x051a }
        r3 = r3.toString();	 Catch:{ all -> 0x051a }
        r2.<init>(r3);	 Catch:{ all -> 0x051a }
        throw r2;	 Catch:{ all -> 0x051a }
    L_0x01a1:
        r4.d();	 Catch:{ all -> 0x051a }
        r6 = 0;
        r11 = r1.a(r6);	 Catch:{ all -> 0x051a }
        r6 = r9;
    L_0x01aa:
        if (r6 != 0) goto L_0x01b2;
    L_0x01ac:
        r4.f();	 Catch:{ all -> 0x051a }
        r4.c();	 Catch:{ all -> 0x051a }
    L_0x01b2:
        r6 = r4.e();	 Catch:{ all -> 0x051a }
        r4.g();	 Catch:{ all -> 0x051a }
        r12 = com.alibaba.fastjson.a.DEFAULT_TYPE_KEY;	 Catch:{ all -> 0x051a }
        if (r11 != r12) goto L_0x026c;
    L_0x01bd:
        r12 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect;	 Catch:{ all -> 0x051a }
        r12 = r4.a(r12);	 Catch:{ all -> 0x051a }
        if (r12 != 0) goto L_0x026c;
    L_0x01c5:
        r6 = r1.b;	 Catch:{ all -> 0x051a }
        r7 = 34;
        r6 = r4.a(r6, r7);	 Catch:{ all -> 0x051a }
        r7 = r1.c;	 Catch:{ all -> 0x051a }
        r7 = r7.b();	 Catch:{ all -> 0x051a }
        r7 = com.alibaba.fastjson.c.j.a(r6, r7);	 Catch:{ all -> 0x051a }
        if (r7 != 0) goto L_0x01e5;
    L_0x01d9:
        r7 = com.alibaba.fastjson.a.DEFAULT_TYPE_KEY;	 Catch:{ all -> 0x051a }
        r2.put(r7, r6);	 Catch:{ all -> 0x051a }
        r6 = 0;
        r7 = 13;
        r9 = 16;
        goto L_0x0058;
    L_0x01e5:
        r8 = 16;
        r4.a(r8);	 Catch:{ all -> 0x051a }
        r9 = r4.a();	 Catch:{ all -> 0x051a }
        r10 = 13;
        if (r9 != r10) goto L_0x023d;
    L_0x01f2:
        r4.a(r8);	 Catch:{ all -> 0x051a }
        r2 = r1.c;	 Catch:{ Exception -> 0x0233 }
        r2 = r2.a(r7);	 Catch:{ Exception -> 0x0233 }
        r3 = r2 instanceof com.alibaba.fastjson.parser.a.b;	 Catch:{ Exception -> 0x0233 }
        if (r3 == 0) goto L_0x0206;
    L_0x01ff:
        r2 = (com.alibaba.fastjson.parser.a.b) r2;	 Catch:{ Exception -> 0x0233 }
        r2 = r2.a();	 Catch:{ Exception -> 0x0233 }
        goto L_0x0212;
    L_0x0206:
        r3 = r2 instanceof com.alibaba.fastjson.parser.a.m;	 Catch:{ Exception -> 0x0233 }
        if (r3 == 0) goto L_0x0211;
    L_0x020a:
        r2 = (com.alibaba.fastjson.parser.a.m) r2;	 Catch:{ Exception -> 0x0233 }
        r2 = r2.a(r1, r7);	 Catch:{ Exception -> 0x0233 }
        goto L_0x0212;
    L_0x0211:
        r2 = 0;
    L_0x0212:
        if (r2 != 0) goto L_0x022f;
    L_0x0214:
        r2 = java.lang.Cloneable.class;
        if (r7 != r2) goto L_0x021e;
    L_0x0218:
        r2 = new java.util.HashMap;	 Catch:{ Exception -> 0x0233 }
        r2.<init>();	 Catch:{ Exception -> 0x0233 }
        goto L_0x022f;
    L_0x021e:
        r2 = "java.util.Collections$EmptyMap";
        r2 = r2.equals(r6);	 Catch:{ Exception -> 0x0233 }
        if (r2 == 0) goto L_0x022b;
    L_0x0226:
        r2 = java.util.Collections.emptyMap();	 Catch:{ Exception -> 0x0233 }
        goto L_0x022f;
    L_0x022b:
        r2 = r7.newInstance();	 Catch:{ Exception -> 0x0233 }
    L_0x022f:
        r1.a(r5);
        return r2;
    L_0x0233:
        r0 = move-exception;
        r2 = r0;
        r3 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x051a }
        r4 = "create instance error";
        r3.<init>(r4, r2);	 Catch:{ all -> 0x051a }
        throw r3;	 Catch:{ all -> 0x051a }
    L_0x023d:
        r4 = 2;
        r1.g = r4;	 Catch:{ all -> 0x051a }
        r4 = r1.f;	 Catch:{ all -> 0x051a }
        if (r4 == 0) goto L_0x024b;
    L_0x0244:
        r4 = r3 instanceof java.lang.Integer;	 Catch:{ all -> 0x051a }
        if (r4 != 0) goto L_0x024b;
    L_0x0248:
        r17.f();	 Catch:{ all -> 0x051a }
    L_0x024b:
        r4 = r18.size();	 Catch:{ all -> 0x051a }
        if (r4 <= 0) goto L_0x025e;
    L_0x0251:
        r3 = r1.c;	 Catch:{ all -> 0x051a }
        r2 = com.alibaba.fastjson.c.j.a(r2, r7, r3);	 Catch:{ all -> 0x051a }
        r1.c(r2);	 Catch:{ all -> 0x051a }
        r1.a(r5);
        return r2;
    L_0x025e:
        r2 = r1.c;	 Catch:{ all -> 0x051a }
        r2 = r2.a(r7);	 Catch:{ all -> 0x051a }
        r2 = r2.a(r1, r7, r3);	 Catch:{ all -> 0x051a }
        r1.a(r5);
        return r2;
    L_0x026c:
        r12 = "$ref";
        if (r11 != r12) goto L_0x032a;
    L_0x0270:
        r12 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect;	 Catch:{ all -> 0x051a }
        r12 = r4.a(r12);	 Catch:{ all -> 0x051a }
        if (r12 != 0) goto L_0x032a;
    L_0x0278:
        r2 = 4;
        r4.a(r2);	 Catch:{ all -> 0x051a }
        r2 = r4.a();	 Catch:{ all -> 0x051a }
        r3 = 4;
        if (r2 != r3) goto L_0x030e;
    L_0x0283:
        r2 = r4.l();	 Catch:{ all -> 0x051a }
        r3 = 13;
        r4.a(r3);	 Catch:{ all -> 0x051a }
        r3 = "@";
        r3 = r3.equals(r2);	 Catch:{ all -> 0x051a }
        if (r3 == 0) goto L_0x02ae;
    L_0x0294:
        r2 = r1.f;	 Catch:{ all -> 0x051a }
        if (r2 == 0) goto L_0x02f4;
    L_0x0298:
        r2 = r1.f;	 Catch:{ all -> 0x051a }
        r6 = r2.a;	 Catch:{ all -> 0x051a }
        r3 = r6 instanceof java.lang.Object[];	 Catch:{ all -> 0x051a }
        if (r3 != 0) goto L_0x02f5;
    L_0x02a0:
        r3 = r6 instanceof java.util.Collection;	 Catch:{ all -> 0x051a }
        if (r3 == 0) goto L_0x02a5;
    L_0x02a4:
        goto L_0x02f5;
    L_0x02a5:
        r3 = r2.b;	 Catch:{ all -> 0x051a }
        if (r3 == 0) goto L_0x02f4;
    L_0x02a9:
        r2 = r2.b;	 Catch:{ all -> 0x051a }
        r6 = r2.a;	 Catch:{ all -> 0x051a }
        goto L_0x02f5;
    L_0x02ae:
        r3 = "..";
        r3 = r3.equals(r2);	 Catch:{ all -> 0x051a }
        if (r3 == 0) goto L_0x02c8;
    L_0x02b6:
        r3 = r5.a;	 Catch:{ all -> 0x051a }
        if (r3 == 0) goto L_0x02bd;
    L_0x02ba:
        r6 = r5.a;	 Catch:{ all -> 0x051a }
        goto L_0x02f5;
    L_0x02bd:
        r3 = new com.alibaba.fastjson.parser.a$a;	 Catch:{ all -> 0x051a }
        r3.<init>(r5, r2);	 Catch:{ all -> 0x051a }
        r1.a(r3);	 Catch:{ all -> 0x051a }
        r1.g = r9;	 Catch:{ all -> 0x051a }
        goto L_0x02f4;
    L_0x02c8:
        r3 = "$";
        r3 = r3.equals(r2);	 Catch:{ all -> 0x051a }
        if (r3 == 0) goto L_0x02ea;
    L_0x02d0:
        r3 = r5;
    L_0x02d1:
        r6 = r3.b;	 Catch:{ all -> 0x051a }
        if (r6 == 0) goto L_0x02d8;
    L_0x02d5:
        r3 = r3.b;	 Catch:{ all -> 0x051a }
        goto L_0x02d1;
    L_0x02d8:
        r6 = r3.a;	 Catch:{ all -> 0x051a }
        if (r6 == 0) goto L_0x02df;
    L_0x02dc:
        r6 = r3.a;	 Catch:{ all -> 0x051a }
        goto L_0x02f5;
    L_0x02df:
        r6 = new com.alibaba.fastjson.parser.a$a;	 Catch:{ all -> 0x051a }
        r6.<init>(r3, r2);	 Catch:{ all -> 0x051a }
        r1.a(r6);	 Catch:{ all -> 0x051a }
        r1.g = r9;	 Catch:{ all -> 0x051a }
        goto L_0x02f4;
    L_0x02ea:
        r3 = new com.alibaba.fastjson.parser.a$a;	 Catch:{ all -> 0x051a }
        r3.<init>(r5, r2);	 Catch:{ all -> 0x051a }
        r1.a(r3);	 Catch:{ all -> 0x051a }
        r1.g = r9;	 Catch:{ all -> 0x051a }
    L_0x02f4:
        r6 = 0;
    L_0x02f5:
        r2 = r4.a();	 Catch:{ all -> 0x051a }
        r3 = 13;
        if (r2 == r3) goto L_0x0305;
    L_0x02fd:
        r2 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x051a }
        r3 = "syntax error";
        r2.<init>(r3);	 Catch:{ all -> 0x051a }
        throw r2;	 Catch:{ all -> 0x051a }
    L_0x0305:
        r2 = 16;
        r4.a(r2);	 Catch:{ all -> 0x051a }
        r1.a(r5);
        return r6;
    L_0x030e:
        r2 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x051a }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x051a }
        r6 = "illegal ref, ";
        r3.<init>(r6);	 Catch:{ all -> 0x051a }
        r4 = r4.a();	 Catch:{ all -> 0x051a }
        r4 = com.alibaba.fastjson.parser.e.a(r4);	 Catch:{ all -> 0x051a }
        r3.append(r4);	 Catch:{ all -> 0x051a }
        r3 = r3.toString();	 Catch:{ all -> 0x051a }
        r2.<init>(r3);	 Catch:{ all -> 0x051a }
        throw r2;	 Catch:{ all -> 0x051a }
    L_0x032a:
        if (r10 != 0) goto L_0x0334;
    L_0x032c:
        r10 = r17.a(r18, r19);	 Catch:{ all -> 0x051a }
        if (r5 != 0) goto L_0x0333;
    L_0x0332:
        r5 = r10;
    L_0x0333:
        r10 = r9;
    L_0x0334:
        r12 = r18.getClass();	 Catch:{ all -> 0x051a }
        r9 = com.alibaba.fastjson.JSONObject.class;
        if (r12 != r9) goto L_0x0346;
    L_0x033c:
        if (r11 != 0) goto L_0x0341;
    L_0x033e:
        r9 = "null";
        goto L_0x0345;
    L_0x0341:
        r9 = r11.toString();	 Catch:{ all -> 0x051a }
    L_0x0345:
        r11 = r9;
    L_0x0346:
        r9 = 34;
        if (r6 != r9) goto L_0x0373;
    L_0x034a:
        r4.m();	 Catch:{ all -> 0x051a }
        r6 = r4.l();	 Catch:{ all -> 0x051a }
        r8 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat;	 Catch:{ all -> 0x051a }
        r8 = r4.a(r8);	 Catch:{ all -> 0x051a }
        if (r8 == 0) goto L_0x036f;
    L_0x0359:
        r8 = new com.alibaba.fastjson.parser.d;	 Catch:{ all -> 0x051a }
        r8.<init>(r6);	 Catch:{ all -> 0x051a }
        r9 = r8.D();	 Catch:{ all -> 0x051a }
        if (r9 == 0) goto L_0x036c;
    L_0x0364:
        r6 = r8.C();	 Catch:{ all -> 0x051a }
        r6 = r6.getTime();	 Catch:{ all -> 0x051a }
    L_0x036c:
        r8.close();	 Catch:{ all -> 0x051a }
    L_0x036f:
        r2.put(r11, r6);	 Catch:{ all -> 0x051a }
        goto L_0x0395;
    L_0x0373:
        if (r6 < r8) goto L_0x0377;
    L_0x0375:
        if (r6 <= r15) goto L_0x0379;
    L_0x0377:
        if (r6 != r14) goto L_0x03da;
    L_0x0379:
        r4.h();	 Catch:{ all -> 0x051a }
        r6 = r4.a();	 Catch:{ all -> 0x051a }
        r8 = 2;
        if (r6 != r8) goto L_0x0388;
    L_0x0383:
        r6 = r4.j();	 Catch:{ all -> 0x051a }
        goto L_0x0392;
    L_0x0388:
        r6 = com.alibaba.fastjson.parser.Feature.UseBigDecimal;	 Catch:{ all -> 0x051a }
        r6 = r4.a(r6);	 Catch:{ all -> 0x051a }
        r6 = r4.a(r6);	 Catch:{ all -> 0x051a }
    L_0x0392:
        r2.put(r11, r6);	 Catch:{ all -> 0x051a }
    L_0x0395:
        r4.c();	 Catch:{ all -> 0x051a }
        r8 = r4.e();	 Catch:{ all -> 0x051a }
        if (r8 != r13) goto L_0x03a8;
    L_0x039e:
        r4.f();	 Catch:{ all -> 0x051a }
    L_0x03a1:
        r6 = 0;
        r8 = 13;
        r9 = 16;
        goto L_0x0517;
    L_0x03a8:
        if (r8 != r7) goto L_0x03ba;
    L_0x03aa:
        r4.f();	 Catch:{ all -> 0x051a }
        r4.g();	 Catch:{ all -> 0x051a }
        r4.d();	 Catch:{ all -> 0x051a }
        r1.a(r6, r11);	 Catch:{ all -> 0x051a }
        r1.a(r5);
        return r2;
    L_0x03ba:
        r2 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x051a }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x051a }
        r6 = "syntax error, position at ";
        r3.<init>(r6);	 Catch:{ all -> 0x051a }
        r4 = r4.i();	 Catch:{ all -> 0x051a }
        r3.append(r4);	 Catch:{ all -> 0x051a }
        r4 = ", name ";
        r3.append(r4);	 Catch:{ all -> 0x051a }
        r3.append(r11);	 Catch:{ all -> 0x051a }
        r3 = r3.toString();	 Catch:{ all -> 0x051a }
        r2.<init>(r3);	 Catch:{ all -> 0x051a }
        throw r2;	 Catch:{ all -> 0x051a }
    L_0x03da:
        r7 = 91;
        if (r6 != r7) goto L_0x041d;
    L_0x03de:
        r4.d();	 Catch:{ all -> 0x051a }
        r6 = new com.alibaba.fastjson.JSONArray;	 Catch:{ all -> 0x051a }
        r6.<init>();	 Catch:{ all -> 0x051a }
        r1.a(r6, r11);	 Catch:{ all -> 0x051a }
        r7 = com.alibaba.fastjson.parser.Feature.UseObjectArray;	 Catch:{ all -> 0x051a }
        r7 = r4.a(r7);	 Catch:{ all -> 0x051a }
        if (r7 == 0) goto L_0x03f5;
    L_0x03f1:
        r6 = r6.toArray();	 Catch:{ all -> 0x051a }
    L_0x03f5:
        r2.put(r11, r6);	 Catch:{ all -> 0x051a }
        r6 = r4.a();	 Catch:{ all -> 0x051a }
        r7 = 13;
        if (r6 != r7) goto L_0x0407;
    L_0x0400:
        r4.d();	 Catch:{ all -> 0x051a }
        r1.a(r5);
        return r2;
    L_0x0407:
        r6 = r4.a();	 Catch:{ all -> 0x051a }
        r7 = 16;
        if (r6 == r7) goto L_0x0417;
    L_0x040f:
        r2 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x051a }
        r3 = "syntax error";
        r2.<init>(r3);	 Catch:{ all -> 0x051a }
        throw r2;	 Catch:{ all -> 0x051a }
    L_0x0417:
        r9 = r7;
        r6 = 0;
        r8 = 13;
        goto L_0x0517;
    L_0x041d:
        r7 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        if (r6 != r7) goto L_0x04c9;
    L_0x0421:
        r4.d();	 Catch:{ all -> 0x051a }
        if (r3 == 0) goto L_0x0430;
    L_0x0426:
        r6 = r19.getClass();	 Catch:{ all -> 0x051a }
        r7 = java.lang.Integer.class;
        if (r6 != r7) goto L_0x0430;
    L_0x042e:
        r6 = 1;
        goto L_0x0431;
    L_0x0430:
        r6 = 0;
    L_0x0431:
        r7 = new com.alibaba.fastjson.JSONObject;	 Catch:{ all -> 0x051a }
        r8 = com.alibaba.fastjson.parser.Feature.OrderedField;	 Catch:{ all -> 0x051a }
        r8 = r4.a(r8);	 Catch:{ all -> 0x051a }
        r7.<init>(r8);	 Catch:{ all -> 0x051a }
        if (r6 != 0) goto L_0x0443;
    L_0x043e:
        r8 = r1.a(r5, r7, r11);	 Catch:{ all -> 0x051a }
        goto L_0x0444;
    L_0x0443:
        r8 = 0;
    L_0x0444:
        r9 = r1.j;	 Catch:{ all -> 0x051a }
        if (r9 == 0) goto L_0x0462;
    L_0x0448:
        if (r11 == 0) goto L_0x044d;
    L_0x044a:
        r11.toString();	 Catch:{ all -> 0x051a }
    L_0x044d:
        r9 = r1.j;	 Catch:{ all -> 0x051a }
        r9 = r9.a();	 Catch:{ all -> 0x051a }
        if (r9 == 0) goto L_0x0462;
    L_0x0455:
        r12 = r1.c;	 Catch:{ all -> 0x051a }
        r12 = r12.a(r9);	 Catch:{ all -> 0x051a }
        r9 = r12.a(r1, r9, r11);	 Catch:{ all -> 0x051a }
        r16 = 1;
        goto L_0x0465;
    L_0x0462:
        r9 = 0;
        r16 = 0;
    L_0x0465:
        if (r16 != 0) goto L_0x046b;
    L_0x0467:
        r9 = r1.a(r7, r11);	 Catch:{ all -> 0x051a }
    L_0x046b:
        if (r8 == 0) goto L_0x0471;
    L_0x046d:
        if (r7 == r9) goto L_0x0471;
    L_0x046f:
        r8.a = r2;	 Catch:{ all -> 0x051a }
    L_0x0471:
        r7 = r11.toString();	 Catch:{ all -> 0x051a }
        r1.b(r2, r7);	 Catch:{ all -> 0x051a }
        r7 = r18.getClass();	 Catch:{ all -> 0x051a }
        r8 = com.alibaba.fastjson.JSONObject.class;
        if (r7 != r8) goto L_0x0488;
    L_0x0480:
        r7 = r11.toString();	 Catch:{ all -> 0x051a }
        r2.put(r7, r9);	 Catch:{ all -> 0x051a }
        goto L_0x048b;
    L_0x0488:
        r2.put(r11, r9);	 Catch:{ all -> 0x051a }
    L_0x048b:
        if (r6 == 0) goto L_0x0490;
    L_0x048d:
        r1.a(r9, r11);	 Catch:{ all -> 0x051a }
    L_0x0490:
        r7 = r4.a();	 Catch:{ all -> 0x051a }
        r8 = 13;
        if (r7 != r8) goto L_0x04a2;
    L_0x0498:
        r4.d();	 Catch:{ all -> 0x051a }
        r1.a(r5);	 Catch:{ all -> 0x051a }
        r1.a(r5);
        return r2;
    L_0x04a2:
        r7 = r4.a();	 Catch:{ all -> 0x051a }
        r8 = 16;
        if (r7 != r8) goto L_0x04b1;
    L_0x04aa:
        if (r6 == 0) goto L_0x03a1;
    L_0x04ac:
        r17.f();	 Catch:{ all -> 0x051a }
        goto L_0x03a1;
    L_0x04b1:
        r2 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x051a }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x051a }
        r6 = "syntax error, ";
        r3.<init>(r6);	 Catch:{ all -> 0x051a }
        r4 = r4.b();	 Catch:{ all -> 0x051a }
        r3.append(r4);	 Catch:{ all -> 0x051a }
        r3 = r3.toString();	 Catch:{ all -> 0x051a }
        r2.<init>(r3);	 Catch:{ all -> 0x051a }
        throw r2;	 Catch:{ all -> 0x051a }
    L_0x04c9:
        r4.d();	 Catch:{ all -> 0x051a }
        r6 = 0;
        r7 = r1.a(r6);	 Catch:{ all -> 0x051a }
        r8 = r18.getClass();	 Catch:{ all -> 0x051a }
        r9 = com.alibaba.fastjson.JSONObject.class;
        if (r8 != r9) goto L_0x04dd;
    L_0x04d9:
        r11 = r11.toString();	 Catch:{ all -> 0x051a }
    L_0x04dd:
        r2.put(r11, r7);	 Catch:{ all -> 0x051a }
        r7 = r4.a();	 Catch:{ all -> 0x051a }
        r8 = 13;
        if (r7 != r8) goto L_0x04ef;
    L_0x04e8:
        r4.d();	 Catch:{ all -> 0x051a }
        r1.a(r5);
        return r2;
    L_0x04ef:
        r7 = r4.a();	 Catch:{ all -> 0x051a }
        r9 = 16;
        if (r7 == r9) goto L_0x0517;
    L_0x04f7:
        r2 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x051a }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x051a }
        r6 = "syntax error, position at ";
        r3.<init>(r6);	 Catch:{ all -> 0x051a }
        r4 = r4.i();	 Catch:{ all -> 0x051a }
        r3.append(r4);	 Catch:{ all -> 0x051a }
        r4 = ", name ";
        r3.append(r4);	 Catch:{ all -> 0x051a }
        r3.append(r11);	 Catch:{ all -> 0x051a }
        r3 = r3.toString();	 Catch:{ all -> 0x051a }
        r2.<init>(r3);	 Catch:{ all -> 0x051a }
        throw r2;	 Catch:{ all -> 0x051a }
    L_0x0517:
        r7 = r8;
        goto L_0x0058;
    L_0x051a:
        r0 = move-exception;
        r2 = r0;
        r1.a(r5);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.a.a(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public final g b() {
        return this.c;
    }

    public final <T> T a(Type type, Object obj) {
        if (this.e.a() == 8) {
            this.e.d();
            return null;
        }
        if (this.e.a() == 4) {
            type = com.alibaba.fastjson.c.j.c(type);
            if (type == byte[].class) {
                type = this.e.v();
                this.e.d();
                return type;
            } else if (type == char[].class) {
                type = this.e.l();
                this.e.d();
                return type.toCharArray();
            }
        }
        try {
            return this.c.a(type).a(this, type, obj);
        } catch (Type type2) {
            throw type2;
        } catch (Type type22) {
            obj = new JSONException(type22.getMessage(), type22);
        }
    }

    public final void a(Type type, Collection collection) {
        a(type, collection, null);
    }

    public final void a(Type type, Collection collection, Object obj) {
        if (this.e.a() == 21 || this.e.a() == 22) {
            this.e.d();
        }
        if (this.e.a() != 14) {
            collection = new StringBuilder("exepct '[', but ");
            collection.append(e.a(this.e.a()));
            collection.append(", ");
            collection.append(this.e.z());
            throw new JSONException(collection.toString());
        }
        r rVar;
        int i;
        if (Integer.TYPE == type) {
            rVar = ab.a;
            this.e.a(2);
        } else if (String.class == type) {
            rVar = ay.a;
            this.e.a(4);
        } else {
            rVar = this.c.a(type);
            this.e.a(rVar.e_());
        }
        f fVar = this.f;
        a((Object) collection, obj);
        obj = null;
        while (true) {
            try {
                i = 16;
                if (this.e.a(Feature.AllowArbitraryCommas)) {
                    while (this.e.a() == 16) {
                        this.e.d();
                    }
                }
                if (this.e.a() == 15) {
                    break;
                }
                Object obj2 = null;
                if (Integer.TYPE == type) {
                    collection.add(ab.a.a(this, null, null));
                } else if (String.class == type) {
                    if (this.e.a() == 4) {
                        obj2 = this.e.l();
                        this.e.a(16);
                    } else {
                        Object a = a(null);
                        if (a != null) {
                            obj2 = a.toString();
                        }
                    }
                    collection.add(obj2);
                } else {
                    if (this.e.a() == 8) {
                        this.e.d();
                    } else {
                        obj2 = rVar.a(this, type, Integer.valueOf(obj));
                    }
                    collection.add(obj2);
                    a(collection);
                }
                if (this.e.a() == 16) {
                    b bVar = this.e;
                    i = rVar.e_();
                    bVar.a(i);
                }
                obj++;
            } finally {
                a(fVar);
            }
        }
        this.e.a(i);
    }

    public final Object[] a(Type[] typeArr) {
        if (this.e.a() == 8) {
            this.e.a(16);
            return null;
        } else if (this.e.a() != 14) {
            r0 = new StringBuilder("syntax error : ");
            r0.append(this.e.b());
            throw new JSONException(r0.toString());
        } else {
            Object[] objArr = new Object[typeArr.length];
            if (typeArr.length == 0) {
                this.e.a(15);
                if (this.e.a() != 15) {
                    throw new JSONException("syntax error");
                }
                this.e.a(16);
                return new Object[0];
            }
            this.e.a(2);
            int i = 0;
            while (i < typeArr.length) {
                String str;
                if (this.e.a() == 8) {
                    this.e.a(16);
                    str = null;
                } else {
                    Type type = typeArr[i];
                    if (type != Integer.TYPE) {
                        if (type != Integer.class) {
                            if (type != String.class) {
                                boolean isArray;
                                Type componentType;
                                if (i == typeArr.length - 1 && (type instanceof Class)) {
                                    Class cls = (Class) type;
                                    isArray = cls.isArray();
                                    componentType = cls.getComponentType();
                                } else {
                                    isArray = false;
                                    componentType = null;
                                }
                                if (!isArray || this.e.a() == 14) {
                                    str = this.c.a(type).a(this, type, null);
                                } else {
                                    Object arrayList = new ArrayList();
                                    r a = this.c.a(componentType);
                                    int e_ = a.e_();
                                    if (this.e.a() != 15) {
                                        while (true) {
                                            arrayList.add(a.a(this, type, null));
                                            if (this.e.a() != 16) {
                                                break;
                                            }
                                            this.e.a(e_);
                                        }
                                        if (this.e.a() != 15) {
                                            r0 = new StringBuilder("syntax error :");
                                            r0.append(e.a(this.e.a()));
                                            throw new JSONException(r0.toString());
                                        }
                                    }
                                    str = com.alibaba.fastjson.c.j.a(arrayList, type, this.c);
                                }
                            } else if (this.e.a() == 4) {
                                str = this.e.l();
                                this.e.a(16);
                            } else {
                                str = com.alibaba.fastjson.c.j.a(a(null), type, this.c);
                            }
                        }
                    }
                    if (this.e.a() == 2) {
                        str = Integer.valueOf(this.e.n());
                        this.e.a(16);
                    } else {
                        str = com.alibaba.fastjson.c.j.a(a(null), type, this.c);
                    }
                }
                objArr[i] = str;
                if (this.e.a() == 15) {
                    break;
                } else if (this.e.a() != 16) {
                    r0 = new StringBuilder("syntax error :");
                    r0.append(e.a(this.e.a()));
                    throw new JSONException(r0.toString());
                } else {
                    if (i == typeArr.length - 1) {
                        this.e.a(15);
                    } else {
                        this.e.a(2);
                    }
                    i++;
                }
            }
            if (this.e.a() != 15) {
                throw new JSONException("syntax error");
            }
            this.e.a(16);
            return objArr;
        }
    }

    private void c(Object obj) {
        m mVar;
        Type type = obj.getClass();
        r a = this.c.a(type);
        if (a instanceof m) {
            mVar = (m) a;
        } else if (a instanceof b) {
            mVar = ((b) a).a;
        } else {
            mVar = null;
        }
        if (this.e.a() == 12 || this.e.a() == 16) {
            while (true) {
                String a2 = this.e.a(this.b);
                if (a2 == null) {
                    if (this.e.a() == 13) {
                        this.e.a(16);
                        return;
                    } else if (this.e.a() == 16 && this.e.a(Feature.AllowArbitraryCommas)) {
                    }
                }
                k a3 = mVar != null ? mVar.a(a2) : null;
                if (a3 != null) {
                    Object a4;
                    Class cls = a3.a.d;
                    Type type2 = a3.a.e;
                    if (cls == Integer.TYPE) {
                        this.e.p();
                        a4 = ab.a.a(this, type2, null);
                    } else if (cls == String.class) {
                        this.e.p();
                        a4 = ay.a(this);
                    } else if (cls == Long.TYPE) {
                        this.e.p();
                        a4 = aj.a.a(this, type2, null);
                    } else {
                        r a5 = this.c.a(cls, type2);
                        this.e.p();
                        a4 = a5.a(this, type2, null);
                    }
                    a3.a(obj, a4);
                    if (this.e.a() != 16 && this.e.a() == 13) {
                        this.e.a(16);
                        return;
                    }
                } else if (this.e.a(Feature.IgnoreNotMatch)) {
                    this.e.o();
                    a(null);
                    if (this.e.a() == 13) {
                        this.e.d();
                        return;
                    }
                } else {
                    StringBuilder stringBuilder = new StringBuilder("setter not found, class ");
                    stringBuilder.append(type.getName());
                    stringBuilder.append(", property ");
                    stringBuilder.append(a2);
                    throw new JSONException(stringBuilder.toString());
                }
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder("syntax error, expect {, actual ");
        stringBuilder2.append(this.e.b());
        throw new JSONException(stringBuilder2.toString());
    }

    public final void a(Collection collection) {
        if (this.g == 1) {
            if (collection instanceof List) {
                int size = collection.size() - 1;
                List list = (List) collection;
                a d = d();
                d.a = new u(this, list, size);
                d.b = this.f;
                this.g = 0;
                return;
            }
            a d2 = d();
            d2.a = new u(collection);
            d2.b = this.f;
            this.g = 0;
        }
    }

    public final void b(Map map, Object obj) {
        if (this.g == 1) {
            k uVar = new u(map, obj);
            map = d();
            map.a = uVar;
            map.b = this.f;
            this.g = null;
        }
    }

    public final void b(Collection collection) {
        a(collection, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.util.Collection r9, java.lang.Object r10) {
        /*
        r8 = this;
        r0 = r8.e;
        r1 = r0.a();
        r2 = 21;
        if (r1 == r2) goto L_0x0012;
    L_0x000a:
        r1 = r0.a();
        r2 = 22;
        if (r1 != r2) goto L_0x0015;
    L_0x0012:
        r0.d();
    L_0x0015:
        r1 = r0.a();
        r2 = 14;
        if (r1 == r2) goto L_0x0045;
    L_0x001d:
        r9 = new com.alibaba.fastjson.JSONException;
        r10 = new java.lang.StringBuilder;
        r1 = "syntax error, expect [, actual ";
        r10.<init>(r1);
        r1 = r0.a();
        r1 = com.alibaba.fastjson.parser.e.a(r1);
        r10.append(r1);
        r1 = ", pos ";
        r10.append(r1);
        r0 = r0.i();
        r10.append(r0);
        r10 = r10.toString();
        r9.<init>(r10);
        throw r9;
    L_0x0045:
        r1 = 4;
        r0.a(r1);
        r2 = r8.f;
        r8.a(r9, r10);
        r10 = 0;
        r3 = r10;
    L_0x0050:
        r4 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas;	 Catch:{ all -> 0x011c }
        r4 = r0.a(r4);	 Catch:{ all -> 0x011c }
        r5 = 16;
        if (r4 == 0) goto L_0x0064;
    L_0x005a:
        r4 = r0.a();	 Catch:{ all -> 0x011c }
        if (r4 != r5) goto L_0x0064;
    L_0x0060:
        r0.d();	 Catch:{ all -> 0x011c }
        goto L_0x005a;
    L_0x0064:
        r4 = r0.a();	 Catch:{ all -> 0x011c }
        r6 = 0;
        switch(r4) {
            case 2: goto L_0x0102;
            case 3: goto L_0x00ea;
            case 4: goto L_0x00c4;
            case 6: goto L_0x00be;
            case 7: goto L_0x00b8;
            case 8: goto L_0x00b4;
            case 12: goto L_0x00a0;
            case 14: goto L_0x0086;
            case 15: goto L_0x007f;
            case 20: goto L_0x0077;
            case 23: goto L_0x0072;
            default: goto L_0x006c;
        };	 Catch:{ all -> 0x011c }
    L_0x006c:
        r6 = r8.a(r6);	 Catch:{ all -> 0x011c }
        goto L_0x0109;
    L_0x0072:
        r0.a(r1);	 Catch:{ all -> 0x011c }
        goto L_0x0109;
    L_0x0077:
        r9 = new com.alibaba.fastjson.JSONException;	 Catch:{ all -> 0x011c }
        r10 = "unclosed jsonArray";
        r9.<init>(r10);	 Catch:{ all -> 0x011c }
        throw r9;	 Catch:{ all -> 0x011c }
    L_0x007f:
        r0.a(r5);	 Catch:{ all -> 0x011c }
        r8.a(r2);
        return;
    L_0x0086:
        r6 = new com.alibaba.fastjson.JSONArray;	 Catch:{ all -> 0x011c }
        r6.<init>();	 Catch:{ all -> 0x011c }
        r4 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x011c }
        r8.a(r6, r4);	 Catch:{ all -> 0x011c }
        r4 = com.alibaba.fastjson.parser.Feature.UseObjectArray;	 Catch:{ all -> 0x011c }
        r4 = r0.a(r4);	 Catch:{ all -> 0x011c }
        if (r4 == 0) goto L_0x0109;
    L_0x009a:
        r6 = r6.toArray();	 Catch:{ all -> 0x011c }
        goto L_0x0109;
    L_0x00a0:
        r4 = new com.alibaba.fastjson.JSONObject;	 Catch:{ all -> 0x011c }
        r6 = com.alibaba.fastjson.parser.Feature.OrderedField;	 Catch:{ all -> 0x011c }
        r6 = r0.a(r6);	 Catch:{ all -> 0x011c }
        r4.<init>(r6);	 Catch:{ all -> 0x011c }
        r6 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x011c }
        r6 = r8.a(r4, r6);	 Catch:{ all -> 0x011c }
        goto L_0x0109;
    L_0x00b4:
        r0.a(r1);	 Catch:{ all -> 0x011c }
        goto L_0x0109;
    L_0x00b8:
        r6 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x011c }
        r0.a(r5);	 Catch:{ all -> 0x011c }
        goto L_0x0109;
    L_0x00be:
        r6 = java.lang.Boolean.TRUE;	 Catch:{ all -> 0x011c }
        r0.a(r5);	 Catch:{ all -> 0x011c }
        goto L_0x0109;
    L_0x00c4:
        r6 = r0.l();	 Catch:{ all -> 0x011c }
        r0.a(r5);	 Catch:{ all -> 0x011c }
        r4 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat;	 Catch:{ all -> 0x011c }
        r4 = r0.a(r4);	 Catch:{ all -> 0x011c }
        if (r4 == 0) goto L_0x0109;
    L_0x00d3:
        r4 = new com.alibaba.fastjson.parser.d;	 Catch:{ all -> 0x011c }
        r4.<init>(r6);	 Catch:{ all -> 0x011c }
        r7 = r4.D();	 Catch:{ all -> 0x011c }
        if (r7 == 0) goto L_0x00e6;
    L_0x00de:
        r6 = r4.C();	 Catch:{ all -> 0x011c }
        r6 = r6.getTime();	 Catch:{ all -> 0x011c }
    L_0x00e6:
        r4.close();	 Catch:{ all -> 0x011c }
        goto L_0x0109;
    L_0x00ea:
        r4 = com.alibaba.fastjson.parser.Feature.UseBigDecimal;	 Catch:{ all -> 0x011c }
        r4 = r0.a(r4);	 Catch:{ all -> 0x011c }
        if (r4 == 0) goto L_0x00f9;
    L_0x00f2:
        r4 = 1;
        r4 = r0.a(r4);	 Catch:{ all -> 0x011c }
    L_0x00f7:
        r6 = r4;
        goto L_0x00fe;
    L_0x00f9:
        r4 = r0.a(r10);	 Catch:{ all -> 0x011c }
        goto L_0x00f7;
    L_0x00fe:
        r0.a(r5);	 Catch:{ all -> 0x011c }
        goto L_0x0109;
    L_0x0102:
        r6 = r0.j();	 Catch:{ all -> 0x011c }
        r0.a(r5);	 Catch:{ all -> 0x011c }
    L_0x0109:
        r9.add(r6);	 Catch:{ all -> 0x011c }
        r8.a(r9);	 Catch:{ all -> 0x011c }
        r4 = r0.a();	 Catch:{ all -> 0x011c }
        if (r4 != r5) goto L_0x0118;
    L_0x0115:
        r0.a(r1);	 Catch:{ all -> 0x011c }
    L_0x0118:
        r3 = r3 + 1;
        goto L_0x0050;
    L_0x011c:
        r9 = move-exception;
        r8.a(r2);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.a.a(java.util.Collection, java.lang.Object):void");
    }

    public final f c() {
        return this.f;
    }

    public final void a(a aVar) {
        if (this.o == null) {
            this.o = new ArrayList(2);
        }
        this.o.add(aVar);
    }

    public final a d() {
        return (a) this.o.get(this.o.size() - 1);
    }

    public final l e() {
        return this.j;
    }

    public final void a(l lVar) {
        this.j = lVar;
    }

    public final void a(f fVar) {
        if (!this.e.a(Feature.DisableCircularReferenceDetect)) {
            this.f = fVar;
        }
    }

    public final void f() {
        if (!this.e.a(Feature.DisableCircularReferenceDetect)) {
            this.f = this.f.b;
            this.m[this.n - 1] = null;
            this.n--;
        }
    }

    private f a(Object obj, Object obj2) {
        if (this.e.a(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return a(this.f, obj, obj2);
    }

    public final f a(f fVar, Object obj, Object obj2) {
        if (this.e.a(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        this.f = new f(fVar, obj, obj2);
        fVar = this.f;
        obj = this.n;
        this.n = obj + 1;
        if (this.m == null) {
            this.m = new f[8];
        } else if (obj >= this.m.length) {
            obj2 = new f[((this.m.length * 3) / 2)];
            System.arraycopy(this.m, 0, obj2, 0, this.m.length);
            this.m = obj2;
        }
        this.m[obj] = fVar;
        return this.f;
    }

    public final Object a(Object obj) {
        b bVar = this.e;
        StringBuilder stringBuilder;
        Collection hashSet;
        switch (bVar.a()) {
            case 2:
                obj = bVar.j();
                bVar.d();
                return obj;
            case 3:
                obj = bVar.a(bVar.a(Feature.UseBigDecimal));
                bVar.d();
                return obj;
            case 4:
                obj = bVar.l();
                bVar.a(16);
                if (bVar.a(Feature.AllowISO8601DateFormat)) {
                    d dVar = new d(obj);
                    try {
                        if (dVar.D()) {
                            obj = dVar.C().getTime();
                            return obj;
                        }
                        dVar.close();
                    } finally {
                        dVar.close();
                    }
                }
                return obj;
            case 6:
                bVar.d();
                return Boolean.TRUE;
            case 7:
                bVar.d();
                return Boolean.FALSE;
            case 8:
                bVar.d();
                return null;
            case 9:
                bVar.a(18);
                if (bVar.a() != 18) {
                    throw new JSONException("syntax error");
                }
                bVar.a(10);
                a(10);
                long longValue = bVar.j().longValue();
                a(2);
                a(11);
                return new Date(longValue);
            case 12:
                return a(new JSONObject(bVar.a(Feature.OrderedField)), obj);
            case 14:
                Collection jSONArray = new JSONArray();
                a(jSONArray, obj);
                return bVar.a(Feature.UseObjectArray) != null ? jSONArray.toArray() : jSONArray;
            case 20:
                if (bVar.q() != null) {
                    return null;
                }
                stringBuilder = new StringBuilder("unterminated json string, pos ");
                stringBuilder.append(bVar.r());
                throw new JSONException(stringBuilder.toString());
            case 21:
                bVar.d();
                hashSet = new HashSet();
                a(hashSet, obj);
                return hashSet;
            case 22:
                bVar.d();
                hashSet = new TreeSet();
                a(hashSet, obj);
                return hashSet;
            case 23:
                bVar.d();
                return null;
            default:
                stringBuilder = new StringBuilder("syntax error, pos ");
                stringBuilder.append(bVar.r());
                throw new JSONException(stringBuilder.toString());
        }
    }

    public final void a(int i) {
        b bVar = this.e;
        if (bVar.a() == i) {
            bVar.d();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("syntax error, expect ");
        stringBuilder.append(e.a(i));
        stringBuilder.append(", actual ");
        stringBuilder.append(e.a(bVar.a()));
        throw new JSONException(stringBuilder.toString());
    }

    public void close() {
        b bVar = this.e;
        try {
            if (!bVar.a(Feature.AutoCloseSource) || bVar.a() == 20) {
                bVar.close();
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("not close json text, token : ");
            stringBuilder.append(e.a(bVar.a()));
            throw new JSONException(stringBuilder.toString());
        } catch (Throwable th) {
            bVar.close();
        }
    }

    public final void g() {
        if (this.o != null) {
            int size = this.o.size();
            for (int i = 0; i < size; i++) {
                a aVar = (a) this.o.get(i);
                String a = aVar.d;
                Object obj = null;
                Object obj2 = aVar.b != null ? aVar.b.a : null;
                if (a.startsWith("$")) {
                    for (int i2 = 0; i2 < this.n; i2++) {
                        if (a.equals(this.m[i2].toString())) {
                            obj = this.m[i2].a;
                            break;
                        }
                    }
                } else {
                    obj = aVar.c.a;
                }
                k kVar = aVar.a;
                if (kVar != null) {
                    kVar.a(obj2, obj);
                }
            }
        }
    }

    public final void b(Object obj) {
        Type type;
        this.e.o();
        if (this.h != null) {
            type = null;
            for (j a : this.h) {
                type = a.a();
            }
        } else {
            type = null;
        }
        if (type == null) {
            a(null);
        } else {
            a(type, null);
        }
        if ((obj instanceof h) == null && this.i != null) {
            obj = this.i.iterator();
            while (obj.hasNext()) {
                obj.next();
            }
        }
    }
}
