package com.qihoo360.replugin;

import android.os.Build.VERSION;
import com.qihoo360.replugin.model.PluginInfo;
import com.qihoo360.replugin.utils.b;
import com.qihoo360.replugin.utils.e;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import dalvik.system.DexClassLoader;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: PluginDexClassLoader */
public final class c extends DexClassLoader {
    private static Method b;
    private final ClassLoader a = g.b();

    public c(PluginInfo pluginInfo, String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
        a(pluginInfo, str, classLoader);
        Class cls = this.a.getClass();
        if (b == null) {
            pluginInfo = e.a(cls, "loadClass", String.class, Boolean.TYPE);
            b = pluginInfo;
            if (pluginInfo == null) {
                throw new NoSuchMethodError("loadClass");
            }
        }
    }

    protected final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        ClassNotFoundException classNotFoundException;
        try {
            Class<?> loadClass = super.loadClass(str, z);
            if (loadClass != null) {
                if (com.qihoo360.replugin.b.c.a && RePlugin.getConfig().g) {
                    StringBuilder stringBuilder = new StringBuilder("loadClass: load plugin class, cn=");
                    stringBuilder.append(str);
                    com.qihoo360.replugin.b.c.a("PluginDexClassLoader", stringBuilder.toString());
                }
                return loadClass;
            }
            classNotFoundException = null;
            if (RePlugin.getConfig().e) {
                try {
                    return a(str, z);
                } catch (ClassNotFoundException e) {
                    classNotFoundException = e;
                }
            }
            if (classNotFoundException == null) {
                return null;
            }
            throw classNotFoundException;
        } catch (ClassNotFoundException e2) {
            classNotFoundException = e2;
        }
    }

    private Class<?> a(String str, boolean z) throws ClassNotFoundException {
        try {
            Class cls = (Class) b.invoke(this.a, new Object[]{str, Boolean.valueOf(z)});
            if (com.qihoo360.replugin.b.c.a && RePlugin.getConfig().g) {
                StringBuilder stringBuilder = new StringBuilder("loadClass: load host class, cn=");
                stringBuilder.append(str);
                stringBuilder.append(", cz=");
                stringBuilder.append(cls);
                com.qihoo360.replugin.b.c.c("PluginDexClassLoader", stringBuilder.toString());
            }
            return cls;
        } catch (String str2) {
            throw new ClassNotFoundException("Calling the loadClass method failed (IllegalAccessException)", str2);
        } catch (String str22) {
            throw new ClassNotFoundException("Calling the loadClass method failed (InvocationTargetException)", str22);
        }
    }

    private void a(PluginInfo pluginInfo, String str, ClassLoader classLoader) {
        if (VERSION.SDK_INT < 21) {
            try {
                String<File> a = a(pluginInfo, str);
                if (a != null && a.size() > 0) {
                    List linkedList = new LinkedList();
                    Class cls = Class.forName("dalvik.system.BaseDexClassLoader");
                    Object a2 = e.a(cls, (Object) this, "pathList");
                    linkedList.add((Object[]) e.a(a2.getClass(), a2, "dexElements"));
                    String absolutePath = pluginInfo.getExtraOdexDir().getAbsolutePath();
                    for (File file : a) {
                        if (com.qihoo360.replugin.b.c.a && RePlugin.getConfig().g) {
                            StringBuilder stringBuilder = new StringBuilder("dex file:");
                            stringBuilder.append(file.getName());
                            com.qihoo360.replugin.b.c.a("PluginDexClassLoader", stringBuilder.toString());
                        }
                        Object a3 = e.a(cls, new DexClassLoader(file.getAbsolutePath(), absolutePath, absolutePath, classLoader), "pathList");
                        linkedList.add((Object[]) e.a(a3.getClass(), a3, "dexElements"));
                    }
                    e.a(a2.getClass(), a2, "dexElements", a(linkedList));
                    com.qihoo360.replugin.utils.c.c(pluginInfo.getExtraDexDir());
                    if (!(com.qihoo360.replugin.b.c.a == null || RePlugin.getConfig().g == null)) {
                        pluginInfo = Array.getLength(e.a(a2.getClass(), a2, "dexElements"));
                        classLoader = new StringBuilder("dexElements length:");
                        classLoader.append(pluginInfo);
                        com.qihoo360.replugin.b.c.a("PluginDexClassLoader", classLoader.toString());
                    }
                }
            } catch (PluginInfo pluginInfo2) {
                pluginInfo2.printStackTrace();
            }
        }
    }

    private static Object a(List<Object[]> list) {
        Iterator it = list.iterator();
        Object obj = null;
        int i = 0;
        while (it.hasNext()) {
            Object obj2 = (Object[]) it.next();
            if (obj == null) {
                obj = obj2;
            }
            i += obj2.length;
        }
        Object[] objArr = (Object[]) Array.newInstance(obj.getClass().getComponentType(), i);
        int i2 = 0;
        for (Object[] objArr2 : list) {
            System.arraycopy(objArr2, 0, objArr, i2, objArr2.length);
            i2 += objArr2.length;
        }
        return objArr;
    }

    private static List<File> a(PluginInfo pluginInfo, String str) {
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        if (pluginInfo != null) {
            try {
                zipFile = new ZipFile(str);
                try {
                    pluginInfo = a(pluginInfo, zipFile);
                    zipFile2 = zipFile;
                } catch (Exception e) {
                    pluginInfo = e;
                    try {
                        pluginInfo.printStackTrace();
                        b.a(zipFile);
                        return null;
                    } catch (Throwable th) {
                        pluginInfo = th;
                        zipFile2 = zipFile;
                        b.a(zipFile2);
                        throw pluginInfo;
                    }
                }
            } catch (Exception e2) {
                pluginInfo = e2;
                zipFile = null;
                pluginInfo.printStackTrace();
                b.a(zipFile);
                return null;
            } catch (Throwable th2) {
                pluginInfo = th2;
                b.a(zipFile2);
                throw pluginInfo;
            }
        }
        pluginInfo = null;
        b.a(zipFile2);
        return pluginInfo;
    }

    private static List<File> a(PluginInfo pluginInfo, ZipFile zipFile) {
        Closeable inputStream;
        Throwable th;
        List<File> linkedList = new LinkedList();
        Enumeration entries = zipFile.entries();
        String str = null;
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            String name = zipEntry.getName();
            if (!name.contains("../")) {
                try {
                    if (name.contains(ShareConstants.DEX_SUFFIX) && !name.equals("classes.dex")) {
                        if (str == null) {
                            str = pluginInfo.getExtraDexDir().getAbsolutePath();
                        }
                        File file = new File(str, name);
                        try {
                            inputStream = zipFile.getInputStream(zipEntry);
                            try {
                                com.qihoo360.replugin.utils.c.a((InputStream) inputStream, file);
                                if (com.qihoo360.replugin.b.c.a && RePlugin.getConfig().g) {
                                    StringBuilder stringBuilder = new StringBuilder("extractFile(): Success! fn=");
                                    stringBuilder.append(file.getName());
                                    com.qihoo360.replugin.b.c.a("PluginDexClassLoader", stringBuilder.toString());
                                }
                                b.a(inputStream);
                                linkedList.add(file);
                                if (com.qihoo360.replugin.b.c.a && RePlugin.getConfig().g) {
                                    StringBuilder stringBuilder2 = new StringBuilder("dex path:");
                                    stringBuilder2.append(file.getAbsolutePath());
                                    com.qihoo360.replugin.b.c.a("PluginDexClassLoader", stringBuilder2.toString());
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = null;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return linkedList;
        b.a(inputStream);
        throw th;
    }
}
