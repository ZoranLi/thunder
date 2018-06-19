package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.c.f;
import java.lang.reflect.Type;

/* compiled from: SerializeConfig */
public final class av extends f<Type, ao> {
    public static final av a = new av();
    private static boolean b = false;
    private static boolean c = false;
    private static boolean d = false;
    private boolean e;
    private b f;
    private String g;

    private com.alibaba.fastjson.serializer.ao b(java.lang.Class<?> r8) {
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
        r7 = this;
        r0 = r8.getModifiers();
        r0 = java.lang.reflect.Modifier.isPublic(r0);
        if (r0 != 0) goto L_0x0010;
    L_0x000a:
        r0 = new com.alibaba.fastjson.serializer.ag;
        r0.<init>(r8);
        return r0;
    L_0x0010:
        r0 = r7.e;
        r1 = 0;
        if (r0 == 0) goto L_0x001f;
    L_0x0015:
        r2 = r7.f;
        r2 = r2.a;
        r2 = r2.a(r8);
        if (r2 != 0) goto L_0x0027;
    L_0x001f:
        r2 = java.io.Serializable.class;
        if (r8 == r2) goto L_0x0027;
    L_0x0023:
        r2 = java.lang.Object.class;
        if (r8 != r2) goto L_0x0028;
    L_0x0027:
        r0 = r1;
    L_0x0028:
        r2 = com.alibaba.fastjson.a.d.class;
        r2 = r8.getAnnotation(r2);
        r2 = (com.alibaba.fastjson.a.d) r2;
        if (r2 == 0) goto L_0x0039;
    L_0x0032:
        r2 = r2.a();
        if (r2 != 0) goto L_0x0039;
    L_0x0038:
        r0 = r1;
    L_0x0039:
        if (r0 == 0) goto L_0x0046;
    L_0x003b:
        r2 = r8.getName();
        r2 = com.alibaba.fastjson.c.c.a(r2);
        if (r2 != 0) goto L_0x0046;
    L_0x0045:
        r0 = r1;
    L_0x0046:
        if (r0 == 0) goto L_0x006b;
    L_0x0048:
        r2 = r8.getDeclaredFields();
        r3 = r2.length;
        r4 = r1;
    L_0x004e:
        if (r4 >= r3) goto L_0x006b;
    L_0x0050:
        r5 = r2[r4];
        r6 = com.alibaba.fastjson.a.b.class;
        r5 = r5.getAnnotation(r6);
        r5 = (com.alibaba.fastjson.a.b) r5;
        if (r5 == 0) goto L_0x0068;
    L_0x005c:
        r5 = r5.b();
        r5 = com.alibaba.fastjson.c.c.a(r5);
        if (r5 != 0) goto L_0x0068;
    L_0x0066:
        r0 = r1;
        goto L_0x006b;
    L_0x0068:
        r4 = r4 + 1;
        goto L_0x004e;
    L_0x006b:
        if (r0 == 0) goto L_0x008b;
    L_0x006d:
        r0 = r7.f;	 Catch:{ ClassCastException -> 0x008b, Throwable -> 0x0076 }
        r0 = r0.a(r8);	 Catch:{ ClassCastException -> 0x008b, Throwable -> 0x0076 }
        if (r0 == 0) goto L_0x008b;
    L_0x0075:
        return r0;
    L_0x0076:
        r0 = move-exception;
        r1 = new com.alibaba.fastjson.JSONException;
        r2 = new java.lang.StringBuilder;
        r3 = "create asm serializer error, class ";
        r2.<init>(r3);
        r2.append(r8);
        r8 = r2.toString();
        r1.<init>(r8, r0);
        throw r1;
    L_0x008b:
        r0 = new com.alibaba.fastjson.serializer.ag;
        r0.<init>(r8);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.av.b(java.lang.Class):com.alibaba.fastjson.serializer.ao");
    }

    public static av a() {
        return a;
    }

    public av() {
        this((byte) 0);
    }

    private av(byte r3) {
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
        r2 = this;
        r3 = 0;
        r2.<init>(r3);
        r0 = com.alibaba.fastjson.c.c.b;
        r1 = 1;
        r0 = r0 ^ r1;
        r2.e = r0;
        r0 = com.alibaba.fastjson.a.DEFAULT_TYPE_KEY;
        r2.g = r0;
        r0 = r2.e;	 Catch:{ NoClassDefFoundError -> 0x001d, ExceptionInInitializerError -> 0x001a }
        if (r0 == 0) goto L_0x001f;	 Catch:{ NoClassDefFoundError -> 0x001d, ExceptionInInitializerError -> 0x001a }
    L_0x0012:
        r0 = new com.alibaba.fastjson.serializer.b;	 Catch:{ NoClassDefFoundError -> 0x001d, ExceptionInInitializerError -> 0x001a }
        r0.<init>();	 Catch:{ NoClassDefFoundError -> 0x001d, ExceptionInInitializerError -> 0x001a }
        r2.f = r0;	 Catch:{ NoClassDefFoundError -> 0x001d, ExceptionInInitializerError -> 0x001a }
        goto L_0x001f;
    L_0x001a:
        r2.e = r3;
        goto L_0x001f;
    L_0x001d:
        r2.e = r3;
    L_0x001f:
        r3 = java.lang.Boolean.class;
        r0 = com.alibaba.fastjson.serializer.m.a;
        r2.a(r3, r0);
        r3 = java.lang.Character.class;
        r0 = com.alibaba.fastjson.serializer.p.a;
        r2.a(r3, r0);
        r3 = java.lang.Byte.class;
        r0 = com.alibaba.fastjson.serializer.ab.a;
        r2.a(r3, r0);
        r3 = java.lang.Short.class;
        r0 = com.alibaba.fastjson.serializer.ab.a;
        r2.a(r3, r0);
        r3 = java.lang.Integer.class;
        r0 = com.alibaba.fastjson.serializer.ab.a;
        r2.a(r3, r0);
        r3 = java.lang.Long.class;
        r0 = com.alibaba.fastjson.serializer.aj.a;
        r2.a(r3, r0);
        r3 = java.lang.Float.class;
        r0 = com.alibaba.fastjson.serializer.aa.a;
        r2.a(r3, r0);
        r3 = java.lang.Double.class;
        r0 = com.alibaba.fastjson.serializer.w.a;
        r2.a(r3, r0);
        r3 = java.math.BigDecimal.class;
        r0 = com.alibaba.fastjson.serializer.k.a;
        r2.a(r3, r0);
        r3 = java.math.BigInteger.class;
        r0 = com.alibaba.fastjson.serializer.l.a;
        r2.a(r3, r0);
        r3 = java.lang.String.class;
        r0 = com.alibaba.fastjson.serializer.ay.a;
        r2.a(r3, r0);
        r3 = byte[].class;
        r0 = com.alibaba.fastjson.serializer.ap.a;
        r2.a(r3, r0);
        r3 = short[].class;
        r0 = com.alibaba.fastjson.serializer.ap.a;
        r2.a(r3, r0);
        r3 = int[].class;
        r0 = com.alibaba.fastjson.serializer.ap.a;
        r2.a(r3, r0);
        r3 = long[].class;
        r0 = com.alibaba.fastjson.serializer.ap.a;
        r2.a(r3, r0);
        r3 = float[].class;
        r0 = com.alibaba.fastjson.serializer.ap.a;
        r2.a(r3, r0);
        r3 = double[].class;
        r0 = com.alibaba.fastjson.serializer.ap.a;
        r2.a(r3, r0);
        r3 = boolean[].class;
        r0 = com.alibaba.fastjson.serializer.ap.a;
        r2.a(r3, r0);
        r3 = char[].class;
        r0 = com.alibaba.fastjson.serializer.ap.a;
        r2.a(r3, r0);
        r3 = java.lang.Object[].class;
        r0 = com.alibaba.fastjson.serializer.an.a;
        r2.a(r3, r0);
        r3 = java.lang.Class.class;
        r0 = com.alibaba.fastjson.serializer.al.a;
        r2.a(r3, r0);
        r3 = java.text.SimpleDateFormat.class;
        r0 = com.alibaba.fastjson.serializer.al.a;
        r2.a(r3, r0);
        r3 = java.util.Locale.class;
        r0 = com.alibaba.fastjson.serializer.al.a;
        r2.a(r3, r0);
        r3 = java.util.Currency.class;
        r0 = com.alibaba.fastjson.serializer.u.a;
        r2.a(r3, r0);
        r3 = java.util.TimeZone.class;
        r0 = com.alibaba.fastjson.serializer.al.a;
        r2.a(r3, r0);
        r3 = java.util.UUID.class;
        r0 = com.alibaba.fastjson.serializer.al.a;
        r2.a(r3, r0);
        r3 = java.net.InetAddress.class;
        r0 = com.alibaba.fastjson.serializer.al.a;
        r2.a(r3, r0);
        r3 = java.net.Inet4Address.class;
        r0 = com.alibaba.fastjson.serializer.al.a;
        r2.a(r3, r0);
        r3 = java.net.Inet6Address.class;
        r0 = com.alibaba.fastjson.serializer.al.a;
        r2.a(r3, r0);
        r3 = java.net.InetSocketAddress.class;
        r0 = com.alibaba.fastjson.serializer.al.a;
        r2.a(r3, r0);
        r3 = java.io.File.class;
        r0 = com.alibaba.fastjson.serializer.al.a;
        r2.a(r3, r0);
        r3 = java.net.URI.class;
        r0 = com.alibaba.fastjson.serializer.al.a;
        r2.a(r3, r0);
        r3 = java.net.URL.class;
        r0 = com.alibaba.fastjson.serializer.al.a;
        r2.a(r3, r0);
        r3 = java.lang.Appendable.class;
        r0 = com.alibaba.fastjson.serializer.d.a;
        r2.a(r3, r0);
        r3 = java.lang.StringBuffer.class;
        r0 = com.alibaba.fastjson.serializer.d.a;
        r2.a(r3, r0);
        r3 = java.lang.StringBuilder.class;
        r0 = com.alibaba.fastjson.serializer.d.a;
        r2.a(r3, r0);
        r3 = java.util.regex.Pattern.class;
        r0 = com.alibaba.fastjson.serializer.al.a;
        r2.a(r3, r0);
        r3 = java.nio.charset.Charset.class;
        r0 = com.alibaba.fastjson.serializer.q.a;
        r2.a(r3, r0);
        r3 = java.util.concurrent.atomic.AtomicBoolean.class;
        r0 = com.alibaba.fastjson.serializer.f.a;
        r2.a(r3, r0);
        r3 = java.util.concurrent.atomic.AtomicInteger.class;
        r0 = com.alibaba.fastjson.serializer.f.a;
        r2.a(r3, r0);
        r3 = java.util.concurrent.atomic.AtomicLong.class;
        r0 = com.alibaba.fastjson.serializer.f.a;
        r2.a(r3, r0);
        r3 = java.util.concurrent.atomic.AtomicReference.class;
        r0 = com.alibaba.fastjson.serializer.as.a;
        r2.a(r3, r0);
        r3 = java.util.concurrent.atomic.AtomicIntegerArray.class;
        r0 = com.alibaba.fastjson.serializer.f.a;
        r2.a(r3, r0);
        r3 = java.util.concurrent.atomic.AtomicLongArray.class;
        r0 = com.alibaba.fastjson.serializer.f.a;
        r2.a(r3, r0);
        r3 = java.lang.ref.WeakReference.class;
        r0 = com.alibaba.fastjson.serializer.as.a;
        r2.a(r3, r0);
        r3 = java.lang.ref.SoftReference.class;
        r0 = com.alibaba.fastjson.serializer.as.a;
        r2.a(r3, r0);
        r3 = b;
        if (r3 != 0) goto L_0x0194;
    L_0x0165:
        r3 = "java.awt.Color";	 Catch:{ Throwable -> 0x0192 }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x0192 }
        r0 = com.alibaba.fastjson.serializer.h.a;	 Catch:{ Throwable -> 0x0192 }
        r2.a(r3, r0);	 Catch:{ Throwable -> 0x0192 }
        r3 = "java.awt.Font";	 Catch:{ Throwable -> 0x0192 }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x0192 }
        r0 = com.alibaba.fastjson.serializer.h.a;	 Catch:{ Throwable -> 0x0192 }
        r2.a(r3, r0);	 Catch:{ Throwable -> 0x0192 }
        r3 = "java.awt.Point";	 Catch:{ Throwable -> 0x0192 }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x0192 }
        r0 = com.alibaba.fastjson.serializer.h.a;	 Catch:{ Throwable -> 0x0192 }
        r2.a(r3, r0);	 Catch:{ Throwable -> 0x0192 }
        r3 = "java.awt.Rectangle";	 Catch:{ Throwable -> 0x0192 }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x0192 }
        r0 = com.alibaba.fastjson.serializer.h.a;	 Catch:{ Throwable -> 0x0192 }
        r2.a(r3, r0);	 Catch:{ Throwable -> 0x0192 }
        goto L_0x0194;
    L_0x0192:
        b = r1;
    L_0x0194:
        r3 = c;
        if (r3 != 0) goto L_0x0240;
    L_0x0198:
        r3 = "java.time.LocalDateTime";	 Catch:{ Throwable -> 0x023e }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x023e }
        r0 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x023e }
        r2.a(r3, r0);	 Catch:{ Throwable -> 0x023e }
        r3 = "java.time.LocalDate";	 Catch:{ Throwable -> 0x023e }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x023e }
        r0 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x023e }
        r2.a(r3, r0);	 Catch:{ Throwable -> 0x023e }
        r3 = "java.time.LocalTime";	 Catch:{ Throwable -> 0x023e }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x023e }
        r0 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x023e }
        r2.a(r3, r0);	 Catch:{ Throwable -> 0x023e }
        r3 = "java.time.ZonedDateTime";	 Catch:{ Throwable -> 0x023e }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x023e }
        r0 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x023e }
        r2.a(r3, r0);	 Catch:{ Throwable -> 0x023e }
        r3 = "java.time.OffsetDateTime";	 Catch:{ Throwable -> 0x023e }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x023e }
        r0 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x023e }
        r2.a(r3, r0);	 Catch:{ Throwable -> 0x023e }
        r3 = "java.time.OffsetTime";	 Catch:{ Throwable -> 0x023e }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x023e }
        r0 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x023e }
        r2.a(r3, r0);	 Catch:{ Throwable -> 0x023e }
        r3 = "java.time.ZoneOffset";	 Catch:{ Throwable -> 0x023e }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x023e }
        r0 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x023e }
        r2.a(r3, r0);	 Catch:{ Throwable -> 0x023e }
        r3 = "java.time.ZoneRegion";	 Catch:{ Throwable -> 0x023e }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x023e }
        r0 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x023e }
        r2.a(r3, r0);	 Catch:{ Throwable -> 0x023e }
        r3 = "java.time.Period";	 Catch:{ Throwable -> 0x023e }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x023e }
        r0 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x023e }
        r2.a(r3, r0);	 Catch:{ Throwable -> 0x023e }
        r3 = "java.time.Duration";	 Catch:{ Throwable -> 0x023e }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x023e }
        r0 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x023e }
        r2.a(r3, r0);	 Catch:{ Throwable -> 0x023e }
        r3 = "java.time.Instant";	 Catch:{ Throwable -> 0x023e }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x023e }
        r0 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x023e }
        r2.a(r3, r0);	 Catch:{ Throwable -> 0x023e }
        r3 = "java.util.Optional";	 Catch:{ Throwable -> 0x023e }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x023e }
        r0 = com.alibaba.fastjson.parser.a.s.a;	 Catch:{ Throwable -> 0x023e }
        r2.a(r3, r0);	 Catch:{ Throwable -> 0x023e }
        r3 = "java.util.OptionalDouble";	 Catch:{ Throwable -> 0x023e }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x023e }
        r0 = com.alibaba.fastjson.parser.a.s.a;	 Catch:{ Throwable -> 0x023e }
        r2.a(r3, r0);	 Catch:{ Throwable -> 0x023e }
        r3 = "java.util.OptionalInt";	 Catch:{ Throwable -> 0x023e }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x023e }
        r0 = com.alibaba.fastjson.parser.a.s.a;	 Catch:{ Throwable -> 0x023e }
        r2.a(r3, r0);	 Catch:{ Throwable -> 0x023e }
        r3 = "java.util.OptionalLong";	 Catch:{ Throwable -> 0x023e }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x023e }
        r0 = com.alibaba.fastjson.parser.a.s.a;	 Catch:{ Throwable -> 0x023e }
        r2.a(r3, r0);	 Catch:{ Throwable -> 0x023e }
        goto L_0x0240;
    L_0x023e:
        c = r1;
    L_0x0240:
        r3 = d;
        if (r3 != 0) goto L_0x025d;
    L_0x0244:
        r3 = "oracle.sql.DATE";	 Catch:{ Throwable -> 0x025b }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x025b }
        r0 = com.alibaba.fastjson.serializer.v.a;	 Catch:{ Throwable -> 0x025b }
        r2.a(r3, r0);	 Catch:{ Throwable -> 0x025b }
        r3 = "oracle.sql.TIMESTAMP";	 Catch:{ Throwable -> 0x025b }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x025b }
        r0 = com.alibaba.fastjson.serializer.v.a;	 Catch:{ Throwable -> 0x025b }
        r2.a(r3, r0);	 Catch:{ Throwable -> 0x025b }
        return;
    L_0x025b:
        d = r1;
    L_0x025d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.av.<init>(byte):void");
    }

    public final com.alibaba.fastjson.serializer.ao a(java.lang.Class<?> r9) {
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
        r8 = this;
        r0 = r8.a(r9);
        r0 = (com.alibaba.fastjson.serializer.ao) r0;
        if (r0 != 0) goto L_0x0048;
    L_0x0008:
        r0 = java.lang.Thread.currentThread();	 Catch:{ ClassCastException -> 0x0042 }
        r0 = r0.getContextClassLoader();	 Catch:{ ClassCastException -> 0x0042 }
        r1 = com.alibaba.fastjson.serializer.g.class;	 Catch:{ ClassCastException -> 0x0042 }
        r0 = com.alibaba.fastjson.c.i.a(r1, r0);	 Catch:{ ClassCastException -> 0x0042 }
        r0 = r0.iterator();	 Catch:{ ClassCastException -> 0x0042 }
    L_0x001a:
        r1 = r0.hasNext();	 Catch:{ ClassCastException -> 0x0042 }
        if (r1 == 0) goto L_0x0042;	 Catch:{ ClassCastException -> 0x0042 }
    L_0x0020:
        r1 = r0.next();	 Catch:{ ClassCastException -> 0x0042 }
        r2 = r1 instanceof com.alibaba.fastjson.serializer.g;	 Catch:{ ClassCastException -> 0x0042 }
        if (r2 == 0) goto L_0x001a;	 Catch:{ ClassCastException -> 0x0042 }
    L_0x0028:
        r1 = (com.alibaba.fastjson.serializer.g) r1;	 Catch:{ ClassCastException -> 0x0042 }
        r2 = r1.a();	 Catch:{ ClassCastException -> 0x0042 }
        r2 = r2.iterator();	 Catch:{ ClassCastException -> 0x0042 }
    L_0x0032:
        r3 = r2.hasNext();	 Catch:{ ClassCastException -> 0x0042 }
        if (r3 == 0) goto L_0x001a;	 Catch:{ ClassCastException -> 0x0042 }
    L_0x0038:
        r3 = r2.next();	 Catch:{ ClassCastException -> 0x0042 }
        r3 = (java.lang.reflect.Type) r3;	 Catch:{ ClassCastException -> 0x0042 }
        r8.a(r3, r1);	 Catch:{ ClassCastException -> 0x0042 }
        goto L_0x0032;
    L_0x0042:
        r0 = r8.a(r9);
        r0 = (com.alibaba.fastjson.serializer.ao) r0;
    L_0x0048:
        if (r0 != 0) goto L_0x0092;
    L_0x004a:
        r1 = com.alibaba.fastjson.a.class;
        r1 = r1.getClassLoader();
        r2 = java.lang.Thread.currentThread();
        r2 = r2.getContextClassLoader();
        if (r1 == r2) goto L_0x0092;
    L_0x005a:
        r0 = com.alibaba.fastjson.serializer.g.class;	 Catch:{ ClassCastException -> 0x008c }
        r0 = com.alibaba.fastjson.c.i.a(r0, r1);	 Catch:{ ClassCastException -> 0x008c }
        r0 = r0.iterator();	 Catch:{ ClassCastException -> 0x008c }
    L_0x0064:
        r1 = r0.hasNext();	 Catch:{ ClassCastException -> 0x008c }
        if (r1 == 0) goto L_0x008c;	 Catch:{ ClassCastException -> 0x008c }
    L_0x006a:
        r1 = r0.next();	 Catch:{ ClassCastException -> 0x008c }
        r2 = r1 instanceof com.alibaba.fastjson.serializer.g;	 Catch:{ ClassCastException -> 0x008c }
        if (r2 == 0) goto L_0x0064;	 Catch:{ ClassCastException -> 0x008c }
    L_0x0072:
        r1 = (com.alibaba.fastjson.serializer.g) r1;	 Catch:{ ClassCastException -> 0x008c }
        r2 = r1.a();	 Catch:{ ClassCastException -> 0x008c }
        r2 = r2.iterator();	 Catch:{ ClassCastException -> 0x008c }
    L_0x007c:
        r3 = r2.hasNext();	 Catch:{ ClassCastException -> 0x008c }
        if (r3 == 0) goto L_0x0064;	 Catch:{ ClassCastException -> 0x008c }
    L_0x0082:
        r3 = r2.next();	 Catch:{ ClassCastException -> 0x008c }
        r3 = (java.lang.reflect.Type) r3;	 Catch:{ ClassCastException -> 0x008c }
        r8.a(r3, r1);	 Catch:{ ClassCastException -> 0x008c }
        goto L_0x007c;
    L_0x008c:
        r0 = r8.a(r9);
        r0 = (com.alibaba.fastjson.serializer.ao) r0;
    L_0x0092:
        if (r0 != 0) goto L_0x0218;
    L_0x0094:
        r0 = java.util.Map.class;
        r0 = r0.isAssignableFrom(r9);
        if (r0 == 0) goto L_0x00a3;
    L_0x009c:
        r0 = com.alibaba.fastjson.serializer.ak.a;
        r8.a(r9, r0);
        goto L_0x0211;
    L_0x00a3:
        r0 = java.util.List.class;
        r0 = r0.isAssignableFrom(r9);
        if (r0 == 0) goto L_0x00b2;
    L_0x00ab:
        r0 = com.alibaba.fastjson.serializer.ai.a;
        r8.a(r9, r0);
        goto L_0x0211;
    L_0x00b2:
        r0 = java.util.Collection.class;
        r0 = r0.isAssignableFrom(r9);
        if (r0 == 0) goto L_0x00c1;
    L_0x00ba:
        r0 = com.alibaba.fastjson.serializer.s.a;
        r8.a(r9, r0);
        goto L_0x0211;
    L_0x00c1:
        r0 = java.util.Date.class;
        r0 = r0.isAssignableFrom(r9);
        if (r0 == 0) goto L_0x00d0;
    L_0x00c9:
        r0 = com.alibaba.fastjson.serializer.v.a;
        r8.a(r9, r0);
        goto L_0x0211;
    L_0x00d0:
        r0 = com.alibaba.fastjson.b.class;
        r0 = r0.isAssignableFrom(r9);
        if (r0 == 0) goto L_0x00df;
    L_0x00d8:
        r0 = com.alibaba.fastjson.serializer.ac.a;
        r8.a(r9, r0);
        goto L_0x0211;
    L_0x00df:
        r0 = com.alibaba.fastjson.serializer.ad.class;
        r0 = r0.isAssignableFrom(r9);
        if (r0 == 0) goto L_0x00ee;
    L_0x00e7:
        r0 = com.alibaba.fastjson.serializer.ae.a;
        r8.a(r9, r0);
        goto L_0x0211;
    L_0x00ee:
        r0 = com.alibaba.fastjson.c.class;
        r0 = r0.isAssignableFrom(r9);
        if (r0 == 0) goto L_0x00fd;
    L_0x00f6:
        r0 = com.alibaba.fastjson.serializer.al.a;
        r8.a(r9, r0);
        goto L_0x0211;
    L_0x00fd:
        r0 = r9.isEnum();
        if (r0 != 0) goto L_0x020c;
    L_0x0103:
        r0 = r9.getSuperclass();
        if (r0 == 0) goto L_0x0115;
    L_0x0109:
        r0 = r9.getSuperclass();
        r0 = r0.isEnum();
        if (r0 == 0) goto L_0x0115;
    L_0x0113:
        goto L_0x020c;
    L_0x0115:
        r0 = r9.isArray();
        if (r0 == 0) goto L_0x012d;
    L_0x011b:
        r0 = r9.getComponentType();
        r1 = r8.a(r0);
        r2 = new com.alibaba.fastjson.serializer.e;
        r2.<init>(r0, r1);
        r8.a(r9, r2);
        goto L_0x0211;
    L_0x012d:
        r0 = java.lang.Throwable.class;
        r0 = r0.isAssignableFrom(r9);
        if (r0 == 0) goto L_0x0148;
    L_0x0135:
        r0 = com.alibaba.fastjson.c.j.a(r9);
        r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName;
        r1 = r1.mask;
        r0 = r0 | r1;
        r1 = new com.alibaba.fastjson.serializer.ag;
        r1.<init>(r9, r0);
        r8.a(r9, r1);
        goto L_0x0211;
    L_0x0148:
        r0 = java.util.TimeZone.class;
        r0 = r0.isAssignableFrom(r9);
        if (r0 == 0) goto L_0x0157;
    L_0x0150:
        r0 = com.alibaba.fastjson.serializer.al.a;
        r8.a(r9, r0);
        goto L_0x0211;
    L_0x0157:
        r0 = java.lang.Appendable.class;
        r0 = r0.isAssignableFrom(r9);
        if (r0 == 0) goto L_0x0166;
    L_0x015f:
        r0 = com.alibaba.fastjson.serializer.d.a;
        r8.a(r9, r0);
        goto L_0x0211;
    L_0x0166:
        r0 = java.nio.charset.Charset.class;
        r0 = r0.isAssignableFrom(r9);
        if (r0 == 0) goto L_0x0175;
    L_0x016e:
        r0 = com.alibaba.fastjson.serializer.q.a;
        r8.a(r9, r0);
        goto L_0x0211;
    L_0x0175:
        r0 = java.util.Enumeration.class;
        r0 = r0.isAssignableFrom(r9);
        if (r0 == 0) goto L_0x0184;
    L_0x017d:
        r0 = com.alibaba.fastjson.serializer.y.a;
        r8.a(r9, r0);
        goto L_0x0211;
    L_0x0184:
        r0 = java.util.Calendar.class;
        r0 = r0.isAssignableFrom(r9);
        if (r0 == 0) goto L_0x0193;
    L_0x018c:
        r0 = com.alibaba.fastjson.serializer.n.a;
        r8.a(r9, r0);
        goto L_0x0211;
    L_0x0193:
        r0 = java.sql.Clob.class;
        r0 = r0.isAssignableFrom(r9);
        if (r0 == 0) goto L_0x01a2;
    L_0x019b:
        r0 = com.alibaba.fastjson.serializer.r.a;
        r8.a(r9, r0);
        goto L_0x0211;
    L_0x01a2:
        r0 = java.lang.Iterable.class;
        r0 = r0.isAssignableFrom(r9);
        if (r0 != 0) goto L_0x0206;
    L_0x01aa:
        r0 = java.util.Iterator.class;
        r0 = r0.isAssignableFrom(r9);
        if (r0 == 0) goto L_0x01b3;
    L_0x01b2:
        goto L_0x0206;
    L_0x01b3:
        r0 = r9.getInterfaces();
        r1 = 0;
        r2 = r0.length;
        r3 = r1;
    L_0x01ba:
        r4 = 1;
        if (r3 >= r2) goto L_0x01ec;
    L_0x01bd:
        r5 = r0[r3];
        r5 = r5.getName();
        r6 = "net.sf.cglib.proxy.Factory";
        r6 = r5.equals(r6);
        if (r6 != 0) goto L_0x01e8;
    L_0x01cb:
        r6 = "org.springframework.cglib.proxy.Factory";
        r6 = r5.equals(r6);
        if (r6 == 0) goto L_0x01d4;
    L_0x01d3:
        goto L_0x01e8;
    L_0x01d4:
        r6 = "javassist.util.proxy.ProxyObject";
        r6 = r5.equals(r6);
        if (r6 != 0) goto L_0x01ed;
    L_0x01dc:
        r6 = "org.apache.ibatis.javassist.util.proxy.ProxyObject";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x01e5;
    L_0x01e4:
        goto L_0x01ed;
    L_0x01e5:
        r3 = r3 + 1;
        goto L_0x01ba;
    L_0x01e8:
        r7 = r4;
        r4 = r1;
        r1 = r7;
        goto L_0x01ed;
    L_0x01ec:
        r4 = r1;
    L_0x01ed:
        if (r1 != 0) goto L_0x01fa;
    L_0x01ef:
        if (r4 == 0) goto L_0x01f2;
    L_0x01f1:
        goto L_0x01fa;
    L_0x01f2:
        r0 = r8.b(r9);
        r8.a(r9, r0);
        goto L_0x0211;
    L_0x01fa:
        r0 = r9.getSuperclass();
        r0 = r8.a(r0);
        r8.a(r9, r0);
        return r0;
    L_0x0206:
        r0 = com.alibaba.fastjson.serializer.al.a;
        r8.a(r9, r0);
        goto L_0x0211;
    L_0x020c:
        r0 = com.alibaba.fastjson.serializer.x.a;
        r8.a(r9, r0);
    L_0x0211:
        r9 = r8.a(r9);
        r0 = r9;
        r0 = (com.alibaba.fastjson.serializer.ao) r0;
    L_0x0218:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.av.a(java.lang.Class):com.alibaba.fastjson.serializer.ao");
    }
}
