package android.arch.lifecycle;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: Lifecycling */
final class f {
    private static Constructor<? extends GenericLifecycleObserver> a;
    private static Map<Class, Constructor<? extends GenericLifecycleObserver>> b = new HashMap();

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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = android.arch.lifecycle.ReflectiveGenericLifecycleObserver.class;	 Catch:{ NoSuchMethodException -> 0x0010 }
        r1 = 1;	 Catch:{ NoSuchMethodException -> 0x0010 }
        r1 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x0010 }
        r2 = 0;	 Catch:{ NoSuchMethodException -> 0x0010 }
        r3 = java.lang.Object.class;	 Catch:{ NoSuchMethodException -> 0x0010 }
        r1[r2] = r3;	 Catch:{ NoSuchMethodException -> 0x0010 }
        r0 = r0.getDeclaredConstructor(r1);	 Catch:{ NoSuchMethodException -> 0x0010 }
        a = r0;	 Catch:{ NoSuchMethodException -> 0x0010 }
    L_0x0010:
        r0 = new java.util.HashMap;
        r0.<init>();
        b = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.arch.lifecycle.f.<clinit>():void");
    }

    @NonNull
    static GenericLifecycleObserver a(Object obj) {
        if (obj instanceof GenericLifecycleObserver) {
            return (GenericLifecycleObserver) obj;
        }
        try {
            Class cls = obj.getClass();
            Constructor constructor = (Constructor) b.get(cls);
            if (constructor != null) {
                return (GenericLifecycleObserver) constructor.newInstance(new Object[]{obj});
            }
            constructor = a(cls);
            if (constructor == null) {
                constructor = a;
            } else if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            b.put(cls, constructor);
            return (GenericLifecycleObserver) constructor.newInstance(new Object[]{obj});
        } catch (Object obj2) {
            throw new RuntimeException(obj2);
        } catch (Object obj22) {
            throw new RuntimeException(obj22);
        } catch (Object obj222) {
            throw new RuntimeException(obj222);
        }
    }

    @android.support.annotation.Nullable
    private static java.lang.reflect.Constructor<? extends android.arch.lifecycle.GenericLifecycleObserver> a(java.lang.Class<?> r7) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
    L_0x0000:
        r0 = r7.getPackage();
        if (r0 == 0) goto L_0x000b;
    L_0x0006:
        r0 = r0.getName();
        goto L_0x000d;
    L_0x000b:
        r0 = "";
    L_0x000d:
        r1 = r7.getCanonicalName();
        r2 = 0;
        if (r1 != 0) goto L_0x0015;
    L_0x0014:
        return r2;
    L_0x0015:
        r3 = r0.isEmpty();
        r4 = 1;
        if (r3 == 0) goto L_0x001d;
    L_0x001c:
        goto L_0x0026;
    L_0x001d:
        r3 = r0.length();
        r3 = r3 + r4;
        r1 = r1.substring(r3);
    L_0x0026:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r5 = ".";
        r6 = "_";
        r1 = r1.replace(r5, r6);
        r3.append(r1);
        r1 = "_LifecycleAdapter";
        r3.append(r1);
        r1 = r3.toString();
        r3 = r0.isEmpty();	 Catch:{ ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0068 }
        if (r3 == 0) goto L_0x0046;	 Catch:{ ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0068 }
    L_0x0045:
        goto L_0x005a;	 Catch:{ ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0068 }
    L_0x0046:
        r3 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0068 }
        r3.<init>();	 Catch:{ ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0068 }
        r3.append(r0);	 Catch:{ ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0068 }
        r0 = ".";	 Catch:{ ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0068 }
        r3.append(r0);	 Catch:{ ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0068 }
        r3.append(r1);	 Catch:{ ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0068 }
        r1 = r3.toString();	 Catch:{ ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0068 }
    L_0x005a:
        r0 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0068 }
        r1 = new java.lang.Class[r4];	 Catch:{ ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0068 }
        r3 = 0;	 Catch:{ ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0068 }
        r1[r3] = r7;	 Catch:{ ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0068 }
        r0 = r0.getDeclaredConstructor(r1);	 Catch:{ ClassNotFoundException -> 0x006f, NoSuchMethodException -> 0x0068 }
        return r0;
    L_0x0068:
        r7 = move-exception;
        r0 = new java.lang.RuntimeException;
        r0.<init>(r7);
        throw r0;
    L_0x006f:
        r7 = r7.getSuperclass();
        if (r7 != 0) goto L_0x0000;
    L_0x0075:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.arch.lifecycle.f.a(java.lang.Class):java.lang.reflect.Constructor<? extends android.arch.lifecycle.GenericLifecycleObserver>");
    }
}
