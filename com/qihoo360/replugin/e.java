package com.qihoo360.replugin;

import android.os.Build.VERSION;
import com.qihoo360.a.a.d;
import com.qihoo360.replugin.a.b;
import com.qihoo360.replugin.b.c;
import dalvik.system.PathClassLoader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;

/* compiled from: RePluginClassLoader */
public final class e extends PathClassLoader {
    private final ClassLoader a;
    private Method b;
    private Method c;
    private Method d;
    private Method e;

    public e(ClassLoader classLoader, ClassLoader classLoader2) {
        super("", "", classLoader);
        this.a = classLoader2;
        if (!(c.a == null || b.e == null)) {
            StringBuilder stringBuilder = new StringBuilder("copyFromOriginal: Fields=");
            stringBuilder.append(d.a(com.qihoo360.replugin.utils.e.a(classLoader2.getClass())));
            c.a("RePluginClassLoader", stringBuilder.toString());
        }
        if (VERSION.SDK_INT <= 10) {
            a("libPath", classLoader2);
            a("libraryPathElements", classLoader2);
            a("mDexs", classLoader2);
            a("mFiles", classLoader2);
            a("mPaths", classLoader2);
            a("mZips", classLoader2);
        } else {
            a("pathList", classLoader2);
        }
        Class cls = classLoader2.getClass();
        this.b = com.qihoo360.replugin.utils.e.a(cls, "findResource", String.class);
        this.b.setAccessible(true);
        this.c = com.qihoo360.replugin.utils.e.a(cls, "findResources", String.class);
        this.c.setAccessible(true);
        this.d = com.qihoo360.replugin.utils.e.a(cls, "findLibrary", String.class);
        this.d.setAccessible(true);
        this.e = com.qihoo360.replugin.utils.e.a(cls, "getPackage", String.class);
        this.e.setAccessible(true);
    }

    private void a(java.lang.String r7, java.lang.ClassLoader r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r8.getClass();	 Catch:{ IllegalAccessException -> 0x007e }
        r0 = com.qihoo360.replugin.utils.e.a(r0, r7);	 Catch:{ IllegalAccessException -> 0x007e }
        if (r0 != 0) goto L_0x000b;	 Catch:{ IllegalAccessException -> 0x007e }
    L_0x000a:
        return;	 Catch:{ IllegalAccessException -> 0x007e }
    L_0x000b:
        r1 = 1;	 Catch:{ IllegalAccessException -> 0x007e }
        r2 = 0;	 Catch:{ IllegalAccessException -> 0x007e }
        if (r0 == 0) goto L_0x0011;	 Catch:{ IllegalAccessException -> 0x007e }
    L_0x000f:
        r3 = r1;	 Catch:{ IllegalAccessException -> 0x007e }
        goto L_0x0012;	 Catch:{ IllegalAccessException -> 0x007e }
    L_0x0011:
        r3 = r2;	 Catch:{ IllegalAccessException -> 0x007e }
    L_0x0012:
        r4 = "The field must not be null";	 Catch:{ IllegalAccessException -> 0x007e }
        r5 = new java.lang.Object[r2];	 Catch:{ IllegalAccessException -> 0x007e }
        com.qihoo360.replugin.utils.f.a(r3, r4, r5);	 Catch:{ IllegalAccessException -> 0x007e }
        r3 = r0.getModifiers();	 Catch:{ NoSuchFieldException -> 0x004b, NoSuchFieldException -> 0x004b }
        r3 = java.lang.reflect.Modifier.isFinal(r3);	 Catch:{ NoSuchFieldException -> 0x004b, NoSuchFieldException -> 0x004b }
        if (r3 == 0) goto L_0x004b;	 Catch:{ NoSuchFieldException -> 0x004b, NoSuchFieldException -> 0x004b }
    L_0x0023:
        r3 = java.lang.reflect.Field.class;	 Catch:{ NoSuchFieldException -> 0x004b, NoSuchFieldException -> 0x004b }
        r4 = "modifiers";	 Catch:{ NoSuchFieldException -> 0x004b, NoSuchFieldException -> 0x004b }
        r3 = r3.getDeclaredField(r4);	 Catch:{ NoSuchFieldException -> 0x004b, NoSuchFieldException -> 0x004b }
        r4 = r3.isAccessible();	 Catch:{ NoSuchFieldException -> 0x004b, NoSuchFieldException -> 0x004b }
        r4 = r4 ^ r1;	 Catch:{ NoSuchFieldException -> 0x004b, NoSuchFieldException -> 0x004b }
        if (r4 == 0) goto L_0x0035;	 Catch:{ NoSuchFieldException -> 0x004b, NoSuchFieldException -> 0x004b }
    L_0x0032:
        r3.setAccessible(r1);	 Catch:{ NoSuchFieldException -> 0x004b, NoSuchFieldException -> 0x004b }
    L_0x0035:
        r1 = r0.getModifiers();	 Catch:{ all -> 0x0044 }
        r1 = r1 & -17;	 Catch:{ all -> 0x0044 }
        r3.setInt(r0, r1);	 Catch:{ all -> 0x0044 }
        if (r4 == 0) goto L_0x004b;
    L_0x0040:
        r3.setAccessible(r2);	 Catch:{ NoSuchFieldException -> 0x004b, NoSuchFieldException -> 0x004b }
        goto L_0x004b;	 Catch:{ NoSuchFieldException -> 0x004b, NoSuchFieldException -> 0x004b }
    L_0x0044:
        r1 = move-exception;	 Catch:{ NoSuchFieldException -> 0x004b, NoSuchFieldException -> 0x004b }
        if (r4 == 0) goto L_0x004a;	 Catch:{ NoSuchFieldException -> 0x004b, NoSuchFieldException -> 0x004b }
    L_0x0047:
        r3.setAccessible(r2);	 Catch:{ NoSuchFieldException -> 0x004b, NoSuchFieldException -> 0x004b }
    L_0x004a:
        throw r1;	 Catch:{ NoSuchFieldException -> 0x004b, NoSuchFieldException -> 0x004b }
    L_0x004b:
        r8 = r0.get(r8);	 Catch:{ IllegalAccessException -> 0x007e }
        r0.set(r6, r8);	 Catch:{ IllegalAccessException -> 0x007e }
        r1 = com.qihoo360.replugin.b.c.a;	 Catch:{ IllegalAccessException -> 0x007e }
        if (r1 == 0) goto L_0x007d;	 Catch:{ IllegalAccessException -> 0x007e }
    L_0x0056:
        r0 = r0.get(r6);	 Catch:{ IllegalAccessException -> 0x007e }
        r1 = "RePluginClassLoader";	 Catch:{ IllegalAccessException -> 0x007e }
        r2 = new java.lang.StringBuilder;	 Catch:{ IllegalAccessException -> 0x007e }
        r3 = "copyFieldValue: Copied. f=";	 Catch:{ IllegalAccessException -> 0x007e }
        r2.<init>(r3);	 Catch:{ IllegalAccessException -> 0x007e }
        r2.append(r7);	 Catch:{ IllegalAccessException -> 0x007e }
        r7 = "; actually=";	 Catch:{ IllegalAccessException -> 0x007e }
        r2.append(r7);	 Catch:{ IllegalAccessException -> 0x007e }
        r2.append(r0);	 Catch:{ IllegalAccessException -> 0x007e }
        r7 = "; orig=";	 Catch:{ IllegalAccessException -> 0x007e }
        r2.append(r7);	 Catch:{ IllegalAccessException -> 0x007e }
        r2.append(r8);	 Catch:{ IllegalAccessException -> 0x007e }
        r7 = r2.toString();	 Catch:{ IllegalAccessException -> 0x007e }
        com.qihoo360.replugin.b.c.a(r1, r7);	 Catch:{ IllegalAccessException -> 0x007e }
    L_0x007d:
        return;
    L_0x007e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.e.a(java.lang.String, java.lang.ClassLoader):void");
    }

    protected final Class<?> findClass(String str) throws ClassNotFoundException {
        return super.findClass(str);
    }

    protected final URL findResource(String str) {
        try {
            return (URL) this.b.invoke(this.a, new Object[]{str});
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return super.findResource(str);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return super.findResource(str);
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return super.findResource(str);
        }
    }

    protected final Enumeration<URL> findResources(String str) {
        try {
            return (Enumeration) this.c.invoke(this.a, new Object[]{str});
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return super.findResources(str);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return super.findResources(str);
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return super.findResources(str);
        }
    }

    public final String findLibrary(String str) {
        try {
            return (String) this.d.invoke(this.a, new Object[]{str});
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return super.findLibrary(str);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return super.findLibrary(str);
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return super.findLibrary(str);
        }
    }

    protected final Package getPackage(String str) {
        Package packageR = null;
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            packageR = (Package) this.e.invoke(this.a, new Object[]{str});
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
        if (packageR == null) {
            packageR = super.getPackage(str);
        }
        if (packageR != null) {
            return packageR;
        }
        return definePackage(str, "Unknown", "0.0", "Unknown", "Unknown", "0.0", "Unknown", null);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append("[mBase=");
        stringBuilder.append(this.a.toString());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    protected final java.lang.Class<?> loadClass(java.lang.String r5, boolean r6) throws java.lang.ClassNotFoundException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = com.qihoo360.loader2.n.b;
        r0 = r0.b(r5);
        if (r0 == 0) goto L_0x0009;
    L_0x0008:
        return r0;
    L_0x0009:
        r0 = r4.a;	 Catch:{ Throwable -> 0x002f }
        r0 = r0.loadClass(r5);	 Catch:{ Throwable -> 0x002f }
        r1 = com.qihoo360.replugin.b.c.a;	 Catch:{ Throwable -> 0x002f }
        if (r1 == 0) goto L_0x002e;	 Catch:{ Throwable -> 0x002f }
    L_0x0013:
        r1 = com.qihoo360.replugin.RePlugin.getConfig();	 Catch:{ Throwable -> 0x002f }
        r1 = r1.g;	 Catch:{ Throwable -> 0x002f }
        if (r1 == 0) goto L_0x002e;	 Catch:{ Throwable -> 0x002f }
    L_0x001b:
        r1 = "RePluginClassLoader";	 Catch:{ Throwable -> 0x002f }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x002f }
        r3 = "loadClass: load other class, cn=";	 Catch:{ Throwable -> 0x002f }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x002f }
        r2.append(r5);	 Catch:{ Throwable -> 0x002f }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x002f }
        com.qihoo360.replugin.b.c.a(r1, r2);	 Catch:{ Throwable -> 0x002f }
    L_0x002e:
        return r0;
    L_0x002f:
        r5 = super.loadClass(r5, r6);
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.e.loadClass(java.lang.String, boolean):java.lang.Class<?>");
    }
}
