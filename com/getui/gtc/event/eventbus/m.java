package com.getui.gtc.event.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class m {
    public static final Map a = new ConcurrentHashMap();
    private static final a[] e = new a[4];
    public List b;
    public final boolean c;
    private final boolean d;

    public final class a {
        public final List a = new ArrayList();
        final Map b = new HashMap();
        final Map c = new HashMap();
        final StringBuilder d = new StringBuilder(128);
        Class e;
        public Class f;
        boolean g;
        public com.getui.gtc.event.eventbus.a.a h;

        a() {
        }

        private boolean b(Method method, Class cls) {
            this.d.setLength(0);
            this.d.append(method.getName());
            StringBuilder stringBuilder = this.d;
            stringBuilder.append('>');
            stringBuilder.append(cls.getName());
            String stringBuilder2 = this.d.toString();
            Class declaringClass = method.getDeclaringClass();
            Class cls2 = (Class) this.c.put(stringBuilder2, declaringClass);
            if (cls2 != null) {
                if (!cls2.isAssignableFrom(declaringClass)) {
                    this.c.put(stringBuilder2, cls2);
                    return false;
                }
            }
            return true;
        }

        public final void a() {
            if (!this.g) {
                this.f = this.f.getSuperclass();
                String name = this.f.getName();
                if (!(name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android."))) {
                    return;
                }
            }
            this.f = null;
        }

        public final void a(Class cls) {
            this.f = cls;
            this.e = cls;
            this.g = false;
            this.h = null;
        }

        public final boolean a(Method method, Class cls) {
            Object put = this.b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (b((Method) put, cls)) {
                    this.b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return b(method, cls);
        }
    }

    m(List list, boolean z, boolean z2) {
        this.b = list;
        this.d = z;
        this.c = z2;
    }

    public static a a() {
        synchronized (e) {
            for (int i = 0; i < 4; i++) {
                a aVar = e[i];
                if (aVar != null) {
                    e[i] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }

    public static List a(a aVar) {
        List arrayList = new ArrayList(aVar.a);
        aVar.a.clear();
        aVar.b.clear();
        aVar.c.clear();
        int i = 0;
        aVar.d.setLength(0);
        aVar.e = null;
        aVar.f = null;
        aVar.g = false;
        aVar.h = null;
        synchronized (e) {
            while (i < 4) {
                if (e[i] == null) {
                    e[i] = aVar;
                    break;
                }
                i++;
            }
        }
        return arrayList;
    }

    public final void b(com.getui.gtc.event.eventbus.m.a r15) {
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
        r14 = this;
        r0 = 1;
        r1 = r15.f;	 Catch:{ Throwable -> 0x0008 }
        r1 = r1.getDeclaredMethods();	 Catch:{ Throwable -> 0x0008 }
        goto L_0x0010;
    L_0x0008:
        r1 = r15.f;
        r1 = r1.getMethods();
        r15.g = r0;
    L_0x0010:
        r2 = 0;
        r3 = r1.length;
        r4 = r2;
    L_0x0013:
        if (r4 >= r3) goto L_0x00e9;
    L_0x0015:
        r6 = r1[r4];
        r5 = r6.getModifiers();
        r7 = r5 & 1;
        if (r7 == 0) goto L_0x00a2;
    L_0x001f:
        r5 = r5 & 5192;
        if (r5 != 0) goto L_0x00a2;
    L_0x0023:
        r5 = r6.getParameterTypes();
        r7 = r5.length;
        if (r7 != r0) goto L_0x0059;
    L_0x002a:
        r7 = com.getui.gtc.event.eventbus.Subscribe.class;
        r7 = r6.getAnnotation(r7);
        r7 = (com.getui.gtc.event.eventbus.Subscribe) r7;
        if (r7 == 0) goto L_0x00e5;
    L_0x0034:
        r8 = r5[r2];
        r5 = r15.a(r6, r8);
        if (r5 == 0) goto L_0x00e5;
    L_0x003c:
        r9 = r7.threadMode();
        r11 = r15.a;
        r12 = new com.getui.gtc.event.eventbus.l;
        r10 = r7.priority();
        r13 = r7.sticky();
        r5 = r12;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r13;
        r5.<init>(r6, r7, r8, r9, r10);
        r11.add(r12);
        goto L_0x00e5;
    L_0x0059:
        r7 = r14.d;
        if (r7 == 0) goto L_0x00e5;
    L_0x005d:
        r7 = com.getui.gtc.event.eventbus.Subscribe.class;
        r7 = r6.isAnnotationPresent(r7);
        if (r7 == 0) goto L_0x00e5;
    L_0x0065:
        r15 = new java.lang.StringBuilder;
        r15.<init>();
        r0 = r6.getDeclaringClass();
        r0 = r0.getName();
        r15.append(r0);
        r0 = ".";
        r15.append(r0);
        r0 = r6.getName();
        r15.append(r0);
        r15 = r15.toString();
        r0 = new com.getui.gtc.event.eventbus.g;
        r1 = new java.lang.StringBuilder;
        r2 = "@Subscribe method ";
        r1.<init>(r2);
        r1.append(r15);
        r15 = "must have exactly 1 parameter but has ";
        r1.append(r15);
        r15 = r5.length;
        r1.append(r15);
        r15 = r1.toString();
        r0.<init>(r15);
        throw r0;
    L_0x00a2:
        r5 = r14.d;
        if (r5 == 0) goto L_0x00e5;
    L_0x00a6:
        r5 = com.getui.gtc.event.eventbus.Subscribe.class;
        r5 = r6.isAnnotationPresent(r5);
        if (r5 == 0) goto L_0x00e5;
    L_0x00ae:
        r15 = new java.lang.StringBuilder;
        r15.<init>();
        r0 = r6.getDeclaringClass();
        r0 = r0.getName();
        r15.append(r0);
        r0 = ".";
        r15.append(r0);
        r0 = r6.getName();
        r15.append(r0);
        r15 = r15.toString();
        r0 = new com.getui.gtc.event.eventbus.g;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r15);
        r15 = " is a illegal @Subscribe method: must be public, non-static, and non-abstract";
        r1.append(r15);
        r15 = r1.toString();
        r0.<init>(r15);
        throw r0;
    L_0x00e5:
        r4 = r4 + 1;
        goto L_0x0013;
    L_0x00e9:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.event.eventbus.m.b(com.getui.gtc.event.eventbus.m$a):void");
    }
}
