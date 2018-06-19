package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.c.d;
import com.alibaba.fastjson.c.f;
import com.alibaba.fastjson.parser.a.a;
import com.alibaba.fastjson.parser.a.k;
import com.alibaba.fastjson.parser.a.n;
import com.alibaba.fastjson.parser.a.r;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/* compiled from: ParserConfig */
public class g {
    public static g a = new g();
    private static boolean g = false;
    private static boolean h = false;
    public final h b;
    protected ClassLoader c;
    protected a d;
    private final f<Type, r> e;
    private boolean f;
    private String[] i;

    public static g a() {
        return a;
    }

    public g() {
        this(null);
    }

    private g(com.alibaba.fastjson.parser.a.a r5) {
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
        r4 = this;
        r4.<init>();
        r0 = new com.alibaba.fastjson.c.f;
        r0.<init>();
        r4.e = r0;
        r0 = com.alibaba.fastjson.c.c.b;
        r1 = 1;
        r0 = r0 ^ r1;
        r4.f = r0;
        r0 = new com.alibaba.fastjson.parser.h;
        r0.<init>();
        r4.b = r0;
        r0 = new java.lang.String[r1];
        r2 = "java.lang.Thread";
        r3 = 0;
        r0[r3] = r2;
        r4.i = r0;
        r0 = com.alibaba.fastjson.c.c.b;
        if (r0 != 0) goto L_0x002f;
    L_0x0024:
        r0 = new com.alibaba.fastjson.parser.a.a;	 Catch:{ ExceptionInInitializerError -> 0x002f, ExceptionInInitializerError -> 0x002f, ExceptionInInitializerError -> 0x002f }
        r2 = new com.alibaba.fastjson.c.a;	 Catch:{ ExceptionInInitializerError -> 0x002f, ExceptionInInitializerError -> 0x002f, ExceptionInInitializerError -> 0x002f }
        r2.<init>();	 Catch:{ ExceptionInInitializerError -> 0x002f, ExceptionInInitializerError -> 0x002f, ExceptionInInitializerError -> 0x002f }
        r0.<init>(r2);	 Catch:{ ExceptionInInitializerError -> 0x002f, ExceptionInInitializerError -> 0x002f, ExceptionInInitializerError -> 0x002f }
        r5 = r0;
    L_0x002f:
        r4.d = r5;
        if (r5 != 0) goto L_0x0035;
    L_0x0033:
        r4.f = r3;
    L_0x0035:
        r5 = r4.e;
        r0 = java.text.SimpleDateFormat.class;
        r2 = com.alibaba.fastjson.serializer.al.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.sql.Timestamp.class;
        r2 = com.alibaba.fastjson.parser.a.v.b;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.sql.Date.class;
        r2 = com.alibaba.fastjson.parser.a.v.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.sql.Time.class;
        r2 = com.alibaba.fastjson.parser.a.y.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.Date.class;
        r2 = com.alibaba.fastjson.serializer.v.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.Calendar.class;
        r2 = com.alibaba.fastjson.serializer.n.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = com.alibaba.fastjson.JSONObject.class;
        r2 = com.alibaba.fastjson.parser.a.p.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = com.alibaba.fastjson.JSONArray.class;
        r2 = com.alibaba.fastjson.serializer.s.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.Map.class;
        r2 = com.alibaba.fastjson.parser.a.p.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.HashMap.class;
        r2 = com.alibaba.fastjson.parser.a.p.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.LinkedHashMap.class;
        r2 = com.alibaba.fastjson.parser.a.p.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.TreeMap.class;
        r2 = com.alibaba.fastjson.parser.a.p.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.concurrent.ConcurrentMap.class;
        r2 = com.alibaba.fastjson.parser.a.p.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.concurrent.ConcurrentHashMap.class;
        r2 = com.alibaba.fastjson.parser.a.p.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.Collection.class;
        r2 = com.alibaba.fastjson.serializer.s.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.List.class;
        r2 = com.alibaba.fastjson.serializer.s.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.ArrayList.class;
        r2 = com.alibaba.fastjson.serializer.s.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.Object.class;
        r2 = com.alibaba.fastjson.parser.a.n.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.String.class;
        r2 = com.alibaba.fastjson.serializer.ay.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.StringBuffer.class;
        r2 = com.alibaba.fastjson.serializer.ay.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.StringBuilder.class;
        r2 = com.alibaba.fastjson.serializer.ay.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.Character.TYPE;
        r2 = com.alibaba.fastjson.serializer.p.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.Character.class;
        r2 = com.alibaba.fastjson.serializer.p.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.Byte.TYPE;
        r2 = com.alibaba.fastjson.parser.a.q.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.Byte.class;
        r2 = com.alibaba.fastjson.parser.a.q.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.Short.TYPE;
        r2 = com.alibaba.fastjson.parser.a.q.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.Short.class;
        r2 = com.alibaba.fastjson.parser.a.q.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.Integer.TYPE;
        r2 = com.alibaba.fastjson.serializer.ab.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.Integer.class;
        r2 = com.alibaba.fastjson.serializer.ab.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.Long.TYPE;
        r2 = com.alibaba.fastjson.serializer.aj.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.Long.class;
        r2 = com.alibaba.fastjson.serializer.aj.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.math.BigInteger.class;
        r2 = com.alibaba.fastjson.serializer.l.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.math.BigDecimal.class;
        r2 = com.alibaba.fastjson.serializer.k.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.Float.TYPE;
        r2 = com.alibaba.fastjson.serializer.aa.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.Float.class;
        r2 = com.alibaba.fastjson.serializer.aa.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.Double.TYPE;
        r2 = com.alibaba.fastjson.parser.a.q.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.Double.class;
        r2 = com.alibaba.fastjson.parser.a.q.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.Boolean.TYPE;
        r2 = com.alibaba.fastjson.serializer.m.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.Boolean.class;
        r2 = com.alibaba.fastjson.serializer.m.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.Class.class;
        r2 = com.alibaba.fastjson.serializer.al.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = char[].class;
        r2 = com.alibaba.fastjson.serializer.o.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.concurrent.atomic.AtomicBoolean.class;
        r2 = com.alibaba.fastjson.serializer.m.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.concurrent.atomic.AtomicInteger.class;
        r2 = com.alibaba.fastjson.serializer.ab.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.concurrent.atomic.AtomicLong.class;
        r2 = com.alibaba.fastjson.serializer.aj.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.concurrent.atomic.AtomicReference.class;
        r2 = com.alibaba.fastjson.serializer.as.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.ref.WeakReference.class;
        r2 = com.alibaba.fastjson.serializer.as.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.ref.SoftReference.class;
        r2 = com.alibaba.fastjson.serializer.as.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.UUID.class;
        r2 = com.alibaba.fastjson.serializer.al.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.TimeZone.class;
        r2 = com.alibaba.fastjson.serializer.al.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.Locale.class;
        r2 = com.alibaba.fastjson.serializer.al.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.Currency.class;
        r2 = com.alibaba.fastjson.serializer.u.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.net.InetAddress.class;
        r2 = com.alibaba.fastjson.serializer.al.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.net.Inet4Address.class;
        r2 = com.alibaba.fastjson.serializer.al.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.net.Inet6Address.class;
        r2 = com.alibaba.fastjson.serializer.al.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.net.InetSocketAddress.class;
        r2 = com.alibaba.fastjson.serializer.al.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.io.File.class;
        r2 = com.alibaba.fastjson.serializer.al.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.net.URI.class;
        r2 = com.alibaba.fastjson.serializer.al.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.net.URL.class;
        r2 = com.alibaba.fastjson.serializer.al.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.regex.Pattern.class;
        r2 = com.alibaba.fastjson.serializer.al.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.nio.charset.Charset.class;
        r2 = com.alibaba.fastjson.serializer.q.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.Number.class;
        r2 = com.alibaba.fastjson.parser.a.q.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.concurrent.atomic.AtomicIntegerArray.class;
        r2 = com.alibaba.fastjson.serializer.f.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.util.concurrent.atomic.AtomicLongArray.class;
        r2 = com.alibaba.fastjson.serializer.f.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.StackTraceElement.class;
        r2 = com.alibaba.fastjson.parser.a.w.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.io.Serializable.class;
        r2 = com.alibaba.fastjson.parser.a.n.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.Cloneable.class;
        r2 = com.alibaba.fastjson.parser.a.n.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.lang.Comparable.class;
        r2 = com.alibaba.fastjson.parser.a.n.a;
        r5.a(r0, r2);
        r5 = r4.e;
        r0 = java.io.Closeable.class;
        r2 = com.alibaba.fastjson.parser.a.n.a;
        r5.a(r0, r2);
        r5 = g;
        if (r5 != 0) goto L_0x02d4;
    L_0x029d:
        r5 = r4.e;	 Catch:{ Throwable -> 0x02d2 }
        r0 = "java.awt.Point";	 Catch:{ Throwable -> 0x02d2 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x02d2 }
        r2 = com.alibaba.fastjson.serializer.h.a;	 Catch:{ Throwable -> 0x02d2 }
        r5.a(r0, r2);	 Catch:{ Throwable -> 0x02d2 }
        r5 = r4.e;	 Catch:{ Throwable -> 0x02d2 }
        r0 = "java.awt.Font";	 Catch:{ Throwable -> 0x02d2 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x02d2 }
        r2 = com.alibaba.fastjson.serializer.h.a;	 Catch:{ Throwable -> 0x02d2 }
        r5.a(r0, r2);	 Catch:{ Throwable -> 0x02d2 }
        r5 = r4.e;	 Catch:{ Throwable -> 0x02d2 }
        r0 = "java.awt.Rectangle";	 Catch:{ Throwable -> 0x02d2 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x02d2 }
        r2 = com.alibaba.fastjson.serializer.h.a;	 Catch:{ Throwable -> 0x02d2 }
        r5.a(r0, r2);	 Catch:{ Throwable -> 0x02d2 }
        r5 = r4.e;	 Catch:{ Throwable -> 0x02d2 }
        r0 = "java.awt.Color";	 Catch:{ Throwable -> 0x02d2 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x02d2 }
        r2 = com.alibaba.fastjson.serializer.h.a;	 Catch:{ Throwable -> 0x02d2 }
        r5.a(r0, r2);	 Catch:{ Throwable -> 0x02d2 }
        goto L_0x02d4;
    L_0x02d2:
        g = r1;
    L_0x02d4:
        r5 = h;
        if (r5 != 0) goto L_0x03ab;
    L_0x02d8:
        r5 = r4.e;	 Catch:{ Throwable -> 0x03a9 }
        r0 = "java.time.LocalDateTime";	 Catch:{ Throwable -> 0x03a9 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x03a9 }
        r2 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x03a9 }
        r5.a(r0, r2);	 Catch:{ Throwable -> 0x03a9 }
        r5 = r4.e;	 Catch:{ Throwable -> 0x03a9 }
        r0 = "java.time.LocalDate";	 Catch:{ Throwable -> 0x03a9 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x03a9 }
        r2 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x03a9 }
        r5.a(r0, r2);	 Catch:{ Throwable -> 0x03a9 }
        r5 = r4.e;	 Catch:{ Throwable -> 0x03a9 }
        r0 = "java.time.LocalTime";	 Catch:{ Throwable -> 0x03a9 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x03a9 }
        r2 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x03a9 }
        r5.a(r0, r2);	 Catch:{ Throwable -> 0x03a9 }
        r5 = r4.e;	 Catch:{ Throwable -> 0x03a9 }
        r0 = "java.time.ZonedDateTime";	 Catch:{ Throwable -> 0x03a9 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x03a9 }
        r2 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x03a9 }
        r5.a(r0, r2);	 Catch:{ Throwable -> 0x03a9 }
        r5 = r4.e;	 Catch:{ Throwable -> 0x03a9 }
        r0 = "java.time.OffsetDateTime";	 Catch:{ Throwable -> 0x03a9 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x03a9 }
        r2 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x03a9 }
        r5.a(r0, r2);	 Catch:{ Throwable -> 0x03a9 }
        r5 = r4.e;	 Catch:{ Throwable -> 0x03a9 }
        r0 = "java.time.OffsetTime";	 Catch:{ Throwable -> 0x03a9 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x03a9 }
        r2 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x03a9 }
        r5.a(r0, r2);	 Catch:{ Throwable -> 0x03a9 }
        r5 = r4.e;	 Catch:{ Throwable -> 0x03a9 }
        r0 = "java.time.ZoneOffset";	 Catch:{ Throwable -> 0x03a9 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x03a9 }
        r2 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x03a9 }
        r5.a(r0, r2);	 Catch:{ Throwable -> 0x03a9 }
        r5 = r4.e;	 Catch:{ Throwable -> 0x03a9 }
        r0 = "java.time.ZoneRegion";	 Catch:{ Throwable -> 0x03a9 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x03a9 }
        r2 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x03a9 }
        r5.a(r0, r2);	 Catch:{ Throwable -> 0x03a9 }
        r5 = r4.e;	 Catch:{ Throwable -> 0x03a9 }
        r0 = "java.time.ZoneId";	 Catch:{ Throwable -> 0x03a9 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x03a9 }
        r2 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x03a9 }
        r5.a(r0, r2);	 Catch:{ Throwable -> 0x03a9 }
        r5 = r4.e;	 Catch:{ Throwable -> 0x03a9 }
        r0 = "java.time.Period";	 Catch:{ Throwable -> 0x03a9 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x03a9 }
        r2 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x03a9 }
        r5.a(r0, r2);	 Catch:{ Throwable -> 0x03a9 }
        r5 = r4.e;	 Catch:{ Throwable -> 0x03a9 }
        r0 = "java.time.Duration";	 Catch:{ Throwable -> 0x03a9 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x03a9 }
        r2 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x03a9 }
        r5.a(r0, r2);	 Catch:{ Throwable -> 0x03a9 }
        r5 = r4.e;	 Catch:{ Throwable -> 0x03a9 }
        r0 = "java.time.Instant";	 Catch:{ Throwable -> 0x03a9 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x03a9 }
        r2 = com.alibaba.fastjson.parser.a.o.a;	 Catch:{ Throwable -> 0x03a9 }
        r5.a(r0, r2);	 Catch:{ Throwable -> 0x03a9 }
        r5 = r4.e;	 Catch:{ Throwable -> 0x03a9 }
        r0 = "java.util.Optional";	 Catch:{ Throwable -> 0x03a9 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x03a9 }
        r2 = com.alibaba.fastjson.parser.a.s.a;	 Catch:{ Throwable -> 0x03a9 }
        r5.a(r0, r2);	 Catch:{ Throwable -> 0x03a9 }
        r5 = r4.e;	 Catch:{ Throwable -> 0x03a9 }
        r0 = "java.util.OptionalDouble";	 Catch:{ Throwable -> 0x03a9 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x03a9 }
        r2 = com.alibaba.fastjson.parser.a.s.a;	 Catch:{ Throwable -> 0x03a9 }
        r5.a(r0, r2);	 Catch:{ Throwable -> 0x03a9 }
        r5 = r4.e;	 Catch:{ Throwable -> 0x03a9 }
        r0 = "java.util.OptionalInt";	 Catch:{ Throwable -> 0x03a9 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x03a9 }
        r2 = com.alibaba.fastjson.parser.a.s.a;	 Catch:{ Throwable -> 0x03a9 }
        r5.a(r0, r2);	 Catch:{ Throwable -> 0x03a9 }
        r5 = r4.e;	 Catch:{ Throwable -> 0x03a9 }
        r0 = "java.util.OptionalLong";	 Catch:{ Throwable -> 0x03a9 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x03a9 }
        r2 = com.alibaba.fastjson.parser.a.s.a;	 Catch:{ Throwable -> 0x03a9 }
        r5.a(r0, r2);	 Catch:{ Throwable -> 0x03a9 }
        goto L_0x03ab;
    L_0x03a9:
        h = r1;
    L_0x03ab:
        r5 = "java.lang.Thread";
        r4.a(r5);
        r5 = java.lang.System.getProperties();
        r4.a(r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.g.<init>(com.alibaba.fastjson.parser.a.a):void");
    }

    private void a(Properties properties) {
        properties = properties.getProperty("fastjson.parser.deny");
        if (properties != null && properties.length() > 0) {
            properties = properties.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            for (String a : properties) {
                a(a);
            }
        }
    }

    public final r a(Type type) {
        while (true) {
            r rVar = (r) this.e.a(type);
            if (rVar != null) {
                return rVar;
            }
            if (type instanceof Class) {
                return a((Class) type, type);
            }
            if (!(type instanceof ParameterizedType)) {
                return n.a;
            }
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                return a((Class) rawType, type);
            }
            type = rawType;
        }
    }

    public final com.alibaba.fastjson.parser.a.r a(java.lang.Class<?> r6, java.lang.reflect.Type r7) {
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
        r5 = this;
    L_0x0000:
        r0 = r5.e;
        r0 = r0.a(r7);
        r0 = (com.alibaba.fastjson.parser.a.r) r0;
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        return r0;
    L_0x000b:
        if (r7 != 0) goto L_0x000e;
    L_0x000d:
        r7 = r6;
    L_0x000e:
        r0 = r5.e;
        r0 = r0.a(r7);
        r0 = (com.alibaba.fastjson.parser.a.r) r0;
        if (r0 == 0) goto L_0x0019;
    L_0x0018:
        return r0;
    L_0x0019:
        r1 = com.alibaba.fastjson.a.d.class;
        r1 = r6.getAnnotation(r1);
        r1 = (com.alibaba.fastjson.a.d) r1;
        if (r1 == 0) goto L_0x002e;
    L_0x0023:
        r1 = r1.h();
        r2 = java.lang.Void.class;
        if (r1 == r2) goto L_0x002e;
    L_0x002b:
        r6 = r1;
        r7 = r6;
        goto L_0x0000;
    L_0x002e:
        r1 = r7 instanceof java.lang.reflect.WildcardType;
        if (r1 != 0) goto L_0x003a;
    L_0x0032:
        r1 = r7 instanceof java.lang.reflect.TypeVariable;
        if (r1 != 0) goto L_0x003a;
    L_0x0036:
        r1 = r7 instanceof java.lang.reflect.ParameterizedType;
        if (r1 == 0) goto L_0x0042;
    L_0x003a:
        r0 = r5.e;
        r0 = r0.a(r6);
        r0 = (com.alibaba.fastjson.parser.a.r) r0;
    L_0x0042:
        if (r0 == 0) goto L_0x0045;
    L_0x0044:
        return r0;
    L_0x0045:
        r0 = 0;
    L_0x0046:
        r1 = r5.i;
        r1 = r1.length;
        if (r0 >= r1) goto L_0x0078;
    L_0x004b:
        r1 = r5.i;
        r1 = r1[r0];
        r2 = r6.getName();
        r3 = 36;
        r4 = 46;
        r2 = r2.replace(r3, r4);
        r1 = r2.startsWith(r1);
        if (r1 == 0) goto L_0x0075;
    L_0x0061:
        r6 = new com.alibaba.fastjson.JSONException;
        r7 = new java.lang.StringBuilder;
        r0 = "parser deny : ";
        r7.<init>(r0);
        r7.append(r2);
        r7 = r7.toString();
        r6.<init>(r7);
        throw r6;
    L_0x0075:
        r0 = r0 + 1;
        goto L_0x0046;
    L_0x0078:
        r0 = java.lang.Thread.currentThread();
        r0 = r0.getContextClassLoader();
        r1 = com.alibaba.fastjson.parser.a.e.class;	 Catch:{ Exception -> 0x00b0 }
        r0 = com.alibaba.fastjson.c.i.a(r1, r0);	 Catch:{ Exception -> 0x00b0 }
        r0 = r0.iterator();	 Catch:{ Exception -> 0x00b0 }
    L_0x008a:
        r1 = r0.hasNext();	 Catch:{ Exception -> 0x00b0 }
        if (r1 == 0) goto L_0x00b0;	 Catch:{ Exception -> 0x00b0 }
    L_0x0090:
        r1 = r0.next();	 Catch:{ Exception -> 0x00b0 }
        r1 = (com.alibaba.fastjson.parser.a.e) r1;	 Catch:{ Exception -> 0x00b0 }
        r2 = r1.a();	 Catch:{ Exception -> 0x00b0 }
        r2 = r2.iterator();	 Catch:{ Exception -> 0x00b0 }
    L_0x009e:
        r3 = r2.hasNext();	 Catch:{ Exception -> 0x00b0 }
        if (r3 == 0) goto L_0x008a;	 Catch:{ Exception -> 0x00b0 }
    L_0x00a4:
        r3 = r2.next();	 Catch:{ Exception -> 0x00b0 }
        r3 = (java.lang.reflect.Type) r3;	 Catch:{ Exception -> 0x00b0 }
        r4 = r5.e;	 Catch:{ Exception -> 0x00b0 }
        r4.a(r3, r1);	 Catch:{ Exception -> 0x00b0 }
        goto L_0x009e;
    L_0x00b0:
        r0 = r5.e;
        r0 = r0.a(r7);
        r0 = (com.alibaba.fastjson.parser.a.r) r0;
        if (r0 == 0) goto L_0x00bb;
    L_0x00ba:
        return r0;
    L_0x00bb:
        r0 = r6.isEnum();
        if (r0 == 0) goto L_0x00c7;
    L_0x00c1:
        r0 = new com.alibaba.fastjson.parser.a.g;
        r0.<init>(r6);
        goto L_0x0110;
    L_0x00c7:
        r0 = r6.isArray();
        if (r0 == 0) goto L_0x00d0;
    L_0x00cd:
        r0 = com.alibaba.fastjson.serializer.an.a;
        goto L_0x0110;
    L_0x00d0:
        r0 = java.util.Set.class;
        if (r6 == r0) goto L_0x010e;
    L_0x00d4:
        r0 = java.util.HashSet.class;
        if (r6 == r0) goto L_0x010e;
    L_0x00d8:
        r0 = java.util.Collection.class;
        if (r6 == r0) goto L_0x010e;
    L_0x00dc:
        r0 = java.util.List.class;
        if (r6 == r0) goto L_0x010e;
    L_0x00e0:
        r0 = java.util.ArrayList.class;
        if (r6 != r0) goto L_0x00e5;
    L_0x00e4:
        goto L_0x010e;
    L_0x00e5:
        r0 = java.util.Collection.class;
        r0 = r0.isAssignableFrom(r6);
        if (r0 == 0) goto L_0x00f0;
    L_0x00ed:
        r0 = com.alibaba.fastjson.serializer.s.a;
        goto L_0x0110;
    L_0x00f0:
        r0 = java.util.Map.class;
        r0 = r0.isAssignableFrom(r6);
        if (r0 == 0) goto L_0x00fb;
    L_0x00f8:
        r0 = com.alibaba.fastjson.parser.a.p.a;
        goto L_0x0110;
    L_0x00fb:
        r0 = java.lang.Throwable.class;
        r0 = r0.isAssignableFrom(r6);
        if (r0 == 0) goto L_0x0109;
    L_0x0103:
        r0 = new com.alibaba.fastjson.parser.a.x;
        r0.<init>(r6);
        goto L_0x0110;
    L_0x0109:
        r0 = r5.b(r6, r7);
        goto L_0x0110;
    L_0x010e:
        r0 = com.alibaba.fastjson.serializer.s.a;
    L_0x0110:
        r6 = r5.e;
        r6.a(r7, r0);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.g.a(java.lang.Class, java.lang.reflect.Type):com.alibaba.fastjson.parser.a.r");
    }

    private com.alibaba.fastjson.parser.a.r b(java.lang.Class<?> r9, java.lang.reflect.Type r10) {
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
        r0 = r8.f;
        r1 = 0;
        if (r0 == 0) goto L_0x0035;
    L_0x0005:
        r2 = com.alibaba.fastjson.a.d.class;
        r2 = r9.getAnnotation(r2);
        r2 = (com.alibaba.fastjson.a.d) r2;
        if (r2 == 0) goto L_0x0016;
    L_0x000f:
        r3 = r2.a();
        if (r3 != 0) goto L_0x0016;
    L_0x0015:
        r0 = r1;
    L_0x0016:
        if (r0 == 0) goto L_0x0035;
    L_0x0018:
        r2 = com.alibaba.fastjson.c.g.a(r2);
        if (r2 != 0) goto L_0x001f;
    L_0x001e:
        r2 = r9;
    L_0x001f:
        r3 = r2.getModifiers();
        r3 = java.lang.reflect.Modifier.isPublic(r3);
        if (r3 != 0) goto L_0x002b;
    L_0x0029:
        r0 = r1;
        goto L_0x0035;
    L_0x002b:
        r2 = r2.getSuperclass();
        r3 = java.lang.Object.class;
        if (r2 == r3) goto L_0x0035;
    L_0x0033:
        if (r2 != 0) goto L_0x001f;
    L_0x0035:
        r2 = r9.getTypeParameters();
        r2 = r2.length;
        if (r2 == 0) goto L_0x003d;
    L_0x003c:
        r0 = r1;
    L_0x003d:
        if (r0 == 0) goto L_0x004e;
    L_0x003f:
        r2 = r8.d;
        if (r2 == 0) goto L_0x004e;
    L_0x0043:
        r2 = r8.d;
        r2 = r2.a;
        r2 = r2.a(r9);
        if (r2 == 0) goto L_0x004e;
    L_0x004d:
        r0 = r1;
    L_0x004e:
        if (r0 == 0) goto L_0x0058;
    L_0x0050:
        r0 = r9.getName();
        r0 = com.alibaba.fastjson.c.c.a(r0);
    L_0x0058:
        if (r0 == 0) goto L_0x00e0;
    L_0x005a:
        r2 = r9.isInterface();
        if (r2 == 0) goto L_0x0061;
    L_0x0060:
        r0 = r1;
    L_0x0061:
        r2 = com.alibaba.fastjson.c.g.a(r9, r10);
        if (r0 == 0) goto L_0x006f;
    L_0x0067:
        r3 = r2.h;
        r3 = r3.length;
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r3 <= r4) goto L_0x006f;
    L_0x006e:
        r0 = r1;
    L_0x006f:
        r3 = r2.c;
        if (r0 == 0) goto L_0x007c;
    L_0x0073:
        if (r3 != 0) goto L_0x007c;
    L_0x0075:
        r3 = r9.isInterface();
        if (r3 != 0) goto L_0x007c;
    L_0x007b:
        r0 = r1;
    L_0x007c:
        r2 = r2.h;
        r3 = r2.length;
        r4 = r1;
    L_0x0080:
        if (r4 >= r3) goto L_0x00e0;
    L_0x0082:
        r5 = r2[r4];
        r6 = r5.g;
        if (r6 == 0) goto L_0x008a;
    L_0x0088:
        r0 = r1;
        goto L_0x00e0;
    L_0x008a:
        r6 = r5.d;
        r7 = r6.getModifiers();
        r7 = java.lang.reflect.Modifier.isPublic(r7);
        if (r7 != 0) goto L_0x0097;
    L_0x0096:
        goto L_0x0088;
    L_0x0097:
        r7 = r6.isMemberClass();
        if (r7 == 0) goto L_0x00a8;
    L_0x009d:
        r7 = r6.getModifiers();
        r7 = java.lang.reflect.Modifier.isStatic(r7);
        if (r7 != 0) goto L_0x00a8;
    L_0x00a7:
        goto L_0x0088;
    L_0x00a8:
        r7 = r5.a();
        if (r7 == 0) goto L_0x00bd;
    L_0x00ae:
        r7 = r5.a();
        r7 = r7.getName();
        r7 = com.alibaba.fastjson.c.c.a(r7);
        if (r7 != 0) goto L_0x00bd;
    L_0x00bc:
        goto L_0x0088;
    L_0x00bd:
        r5 = r5.b();
        if (r5 == 0) goto L_0x00ce;
    L_0x00c3:
        r5 = r5.b();
        r5 = com.alibaba.fastjson.c.c.a(r5);
        if (r5 != 0) goto L_0x00ce;
    L_0x00cd:
        goto L_0x0088;
    L_0x00ce:
        r5 = r6.isEnum();
        if (r5 == 0) goto L_0x00dd;
    L_0x00d4:
        r5 = r8.a(r6);
        r5 = r5 instanceof com.alibaba.fastjson.parser.a.g;
        if (r5 != 0) goto L_0x00dd;
    L_0x00dc:
        goto L_0x0088;
    L_0x00dd:
        r4 = r4 + 1;
        goto L_0x0080;
    L_0x00e0:
        if (r0 == 0) goto L_0x00f3;
    L_0x00e2:
        r2 = r9.isMemberClass();
        if (r2 == 0) goto L_0x00f3;
    L_0x00e8:
        r2 = r9.getModifiers();
        r2 = java.lang.reflect.Modifier.isStatic(r2);
        if (r2 != 0) goto L_0x00f3;
    L_0x00f2:
        r0 = r1;
    L_0x00f3:
        if (r0 != 0) goto L_0x00fb;
    L_0x00f5:
        r0 = new com.alibaba.fastjson.parser.a.m;
        r0.<init>(r9, r10);
        return r0;
    L_0x00fb:
        r0 = r8.d;	 Catch:{ NoSuchMethodException -> 0x0121, JSONException -> 0x011b, Exception -> 0x0102 }
        r0 = r0.a(r8, r9, r10);	 Catch:{ NoSuchMethodException -> 0x0121, JSONException -> 0x011b, Exception -> 0x0102 }
        return r0;
    L_0x0102:
        r10 = move-exception;
        r0 = new com.alibaba.fastjson.JSONException;
        r1 = new java.lang.StringBuilder;
        r2 = "create asm deserializer error, ";
        r1.<init>(r2);
        r9 = r9.getName();
        r1.append(r9);
        r9 = r1.toString();
        r0.<init>(r9, r10);
        throw r0;
    L_0x011b:
        r0 = new com.alibaba.fastjson.parser.a.m;
        r0.<init>(r9, r10);
        return r0;
    L_0x0121:
        r0 = new com.alibaba.fastjson.parser.a.m;
        r0.<init>(r9, r10);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.g.b(java.lang.Class, java.lang.reflect.Type):com.alibaba.fastjson.parser.a.r");
    }

    public static k a(com.alibaba.fastjson.c.g gVar, d dVar) {
        gVar = gVar.a;
        Class cls = dVar.d;
        if (cls != List.class) {
            if (cls != ArrayList.class) {
                return new com.alibaba.fastjson.parser.a.f(gVar, dVar);
            }
        }
        return new com.alibaba.fastjson.parser.a.d(gVar, dVar);
    }

    public static boolean a(Class<?> cls) {
        if (!(cls.isPrimitive() || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == BigInteger.class || cls == BigDecimal.class || cls == String.class || cls == Date.class || cls == java.sql.Date.class || cls == Time.class)) {
            if (cls != Timestamp.class) {
                return null;
            }
        }
        return true;
    }

    public static Field a(Class<?> cls, String str) {
        Field b = b((Class) cls, str);
        if (b == null) {
            StringBuilder stringBuilder = new StringBuilder("_");
            stringBuilder.append(str);
            b = b((Class) cls, stringBuilder.toString());
        }
        if (b != null) {
            return b;
        }
        stringBuilder = new StringBuilder("m_");
        stringBuilder.append(str);
        return b((Class) cls, stringBuilder.toString());
    }

    private static Field b(Class<?> cls, String str) {
        for (Field field : cls.getDeclaredFields()) {
            if (str.equals(field.getName())) {
                return field;
            }
        }
        return (cls.getSuperclass() == null || cls.getSuperclass() == Object.class) ? null : a(cls.getSuperclass(), str);
    }

    public final ClassLoader b() {
        return this.c;
    }

    private void a(String str) {
        if (str != null) {
            if (str.length() != 0) {
                Object obj = new String[(this.i.length + 1)];
                System.arraycopy(this.i, 0, obj, 0, this.i.length);
                obj[obj.length - 1] = str;
                this.i = obj;
            }
        }
    }
}
