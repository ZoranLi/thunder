package com.alipay.a.a;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.alipay.a;

public final class b implements i, j {
    private static java.util.Collection<java.lang.Object> a(java.lang.Class<?> r2, java.lang.reflect.Type r3) {
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
        r0 = java.util.AbstractCollection.class;
        if (r2 != r0) goto L_0x000a;
    L_0x0004:
        r2 = new java.util.ArrayList;
        r2.<init>();
        return r2;
    L_0x000a:
        r0 = java.util.HashSet.class;
        r0 = r2.isAssignableFrom(r0);
        if (r0 == 0) goto L_0x0018;
    L_0x0012:
        r2 = new java.util.HashSet;
        r2.<init>();
        return r2;
    L_0x0018:
        r0 = java.util.LinkedHashSet.class;
        r0 = r2.isAssignableFrom(r0);
        if (r0 == 0) goto L_0x0026;
    L_0x0020:
        r2 = new java.util.LinkedHashSet;
        r2.<init>();
        return r2;
    L_0x0026:
        r0 = java.util.TreeSet.class;
        r0 = r2.isAssignableFrom(r0);
        if (r0 == 0) goto L_0x0034;
    L_0x002e:
        r2 = new java.util.TreeSet;
        r2.<init>();
        return r2;
    L_0x0034:
        r0 = java.util.ArrayList.class;
        r0 = r2.isAssignableFrom(r0);
        if (r0 == 0) goto L_0x0042;
    L_0x003c:
        r2 = new java.util.ArrayList;
        r2.<init>();
        return r2;
    L_0x0042:
        r0 = java.util.EnumSet.class;
        r0 = r2.isAssignableFrom(r0);
        if (r0 == 0) goto L_0x0061;
    L_0x004a:
        r2 = r3 instanceof java.lang.reflect.ParameterizedType;
        if (r2 == 0) goto L_0x0058;
    L_0x004e:
        r3 = (java.lang.reflect.ParameterizedType) r3;
        r2 = r3.getActualTypeArguments();
        r3 = 0;
        r2 = r2[r3];
        goto L_0x005a;
    L_0x0058:
        r2 = java.lang.Object.class;
    L_0x005a:
        r2 = (java.lang.Class) r2;
        r2 = java.util.EnumSet.noneOf(r2);
        return r2;
    L_0x0061:
        r3 = r2.newInstance();	 Catch:{ Exception -> 0x0069 }
        r3 = (java.util.Collection) r3;	 Catch:{ Exception -> 0x0069 }
        r2 = r3;
        return r2;
    L_0x0069:
        r3 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r1 = "create instane error, class ";
        r0.<init>(r1);
        r2 = r2.getName();
        r0.append(r2);
        r2 = r0.toString();
        r3.<init>(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.a.a.b.a(java.lang.Class, java.lang.reflect.Type):java.util.Collection<java.lang.Object>");
    }

    public final Object a(Object obj) {
        List arrayList = new ArrayList();
        for (Object b : (Iterable) obj) {
            arrayList.add(f.b(b));
        }
        return arrayList;
    }

    public final Object a(Object obj, Type type) {
        if (!obj.getClass().equals(a.class)) {
            return null;
        }
        a aVar = (a) obj;
        Collection a = a(com.alipay.a.b.a.a(type), type);
        if (type instanceof ParameterizedType) {
            int i = 0;
            type = ((ParameterizedType) type).getActualTypeArguments()[0];
            while (i < aVar.a()) {
                a.add(e.a(aVar.a(i), type));
                i++;
            }
            return a;
        }
        throw new IllegalArgumentException("Does not support the implement for generics.");
    }

    public final boolean a(Class<?> cls) {
        return Collection.class.isAssignableFrom(cls);
    }
}
