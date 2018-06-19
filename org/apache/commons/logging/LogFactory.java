package org.apache.commons.logging;

import java.io.InputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Enumeration;
import java.util.Hashtable;

public abstract class LogFactory {
    public static final String FACTORY_DEFAULT = "org.apache.commons.logging.impl.LogFactoryImpl";
    public static final String FACTORY_PROPERTIES = "commons-logging.properties";
    public static final String FACTORY_PROPERTY = "org.apache.commons.logging.LogFactory";
    protected static final String SERVICE_ID = "META-INF/services/org.apache.commons.logging.LogFactory";
    static Class class$java$lang$Thread;
    static Class class$org$apache$commons$logging$LogFactory;
    protected static Hashtable factories = new Hashtable();

    class AnonymousClass2 implements PrivilegedAction {
        private final ClassLoader val$classLoader;
        private final String val$factoryClass;

        AnonymousClass2(ClassLoader classLoader, String str) {
            this.val$classLoader = classLoader;
            this.val$factoryClass = str;
        }

        public Object run() {
            ClassLoader classLoader;
            Class class$;
            try {
                if (this.val$classLoader != null) {
                    return (LogFactory) this.val$classLoader.loadClass(this.val$factoryClass).newInstance();
                }
            } catch (ClassNotFoundException e) {
                classLoader = this.val$classLoader;
                if (LogFactory.class$org$apache$commons$logging$LogFactory == null) {
                    class$ = LogFactory.class$(LogFactory.FACTORY_PROPERTY);
                    LogFactory.class$org$apache$commons$logging$LogFactory = class$;
                } else {
                    class$ = LogFactory.class$org$apache$commons$logging$LogFactory;
                }
                if (classLoader == class$.getClassLoader()) {
                    throw e;
                }
            } catch (NoClassDefFoundError e2) {
                classLoader = this.val$classLoader;
                if (LogFactory.class$org$apache$commons$logging$LogFactory == null) {
                    class$ = LogFactory.class$(LogFactory.FACTORY_PROPERTY);
                    LogFactory.class$org$apache$commons$logging$LogFactory = class$;
                } else {
                    class$ = LogFactory.class$org$apache$commons$logging$LogFactory;
                }
                if (classLoader == class$.getClassLoader()) {
                    throw e2;
                }
            } catch (ClassCastException e3) {
                classLoader = this.val$classLoader;
                if (LogFactory.class$org$apache$commons$logging$LogFactory == null) {
                    class$ = LogFactory.class$(LogFactory.FACTORY_PROPERTY);
                    LogFactory.class$org$apache$commons$logging$LogFactory = class$;
                } else {
                    class$ = LogFactory.class$org$apache$commons$logging$LogFactory;
                }
                if (classLoader == class$.getClassLoader()) {
                    throw e3;
                }
            } catch (Throwable e4) {
                return new LogConfigurationException(e4);
            }
            return (LogFactory) Class.forName(this.val$factoryClass).newInstance();
        }
    }

    class AnonymousClass3 implements PrivilegedAction {
        private final ClassLoader val$loader;
        private final String val$name;

        AnonymousClass3(ClassLoader classLoader, String str) {
            this.val$loader = classLoader;
            this.val$name = str;
        }

        public Object run() {
            if (this.val$loader != null) {
                return this.val$loader.getResourceAsStream(this.val$name);
            }
            return ClassLoader.getSystemResourceAsStream(this.val$name);
        }
    }

    public abstract Object getAttribute(String str);

    public abstract String[] getAttributeNames();

    public abstract Log getInstance(Class cls) throws LogConfigurationException;

    public abstract Log getInstance(String str) throws LogConfigurationException;

    public abstract void release();

    public abstract void removeAttribute(String str);

    public abstract void setAttribute(String str, Object obj);

    protected LogFactory() {
    }

    public static org.apache.commons.logging.LogFactory getFactory() throws org.apache.commons.logging.LogConfigurationException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.apache.commons.logging.LogFactory$1;
        r0.<init>();
        r0 = java.security.AccessController.doPrivileged(r0);
        r0 = (java.lang.ClassLoader) r0;
        r1 = getCachedFactory(r0);
        if (r1 == 0) goto L_0x0012;
    L_0x0011:
        return r1;
    L_0x0012:
        r2 = 0;
        r3 = "commons-logging.properties";	 Catch:{ IOException -> 0x0027, IOException -> 0x0027 }
        r3 = getResourceAsStream(r0, r3);	 Catch:{ IOException -> 0x0027, IOException -> 0x0027 }
        if (r3 == 0) goto L_0x0027;	 Catch:{ IOException -> 0x0027, IOException -> 0x0027 }
    L_0x001b:
        r4 = new java.util.Properties;	 Catch:{ IOException -> 0x0027, IOException -> 0x0027 }
        r4.<init>();	 Catch:{ IOException -> 0x0027, IOException -> 0x0027 }
        r4.load(r3);	 Catch:{ IOException -> 0x0026, IOException -> 0x0026 }
        r3.close();	 Catch:{ IOException -> 0x0026, IOException -> 0x0026 }
    L_0x0026:
        r2 = r4;
    L_0x0027:
        r3 = "org.apache.commons.logging.LogFactory";	 Catch:{ SecurityException -> 0x0034 }
        r3 = java.lang.System.getProperty(r3);	 Catch:{ SecurityException -> 0x0034 }
        if (r3 == 0) goto L_0x0034;	 Catch:{ SecurityException -> 0x0034 }
    L_0x002f:
        r3 = newFactory(r3, r0);	 Catch:{ SecurityException -> 0x0034 }
        r1 = r3;
    L_0x0034:
        if (r1 != 0) goto L_0x006b;
    L_0x0036:
        r3 = "META-INF/services/org.apache.commons.logging.LogFactory";	 Catch:{ Exception -> 0x006b }
        r3 = getResourceAsStream(r0, r3);	 Catch:{ Exception -> 0x006b }
        if (r3 == 0) goto L_0x006b;
    L_0x003e:
        r4 = new java.io.BufferedReader;	 Catch:{ UnsupportedEncodingException -> 0x004b }
        r5 = new java.io.InputStreamReader;	 Catch:{ UnsupportedEncodingException -> 0x004b }
        r6 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x004b }
        r5.<init>(r3, r6);	 Catch:{ UnsupportedEncodingException -> 0x004b }
        r4.<init>(r5);	 Catch:{ UnsupportedEncodingException -> 0x004b }
        goto L_0x0055;
    L_0x004b:
        r4 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x006b }
        r5 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x006b }
        r5.<init>(r3);	 Catch:{ Exception -> 0x006b }
        r4.<init>(r5);	 Catch:{ Exception -> 0x006b }
    L_0x0055:
        r3 = r4.readLine();	 Catch:{ Exception -> 0x006b }
        r4.close();	 Catch:{ Exception -> 0x006b }
        if (r3 == 0) goto L_0x006b;	 Catch:{ Exception -> 0x006b }
    L_0x005e:
        r4 = "";	 Catch:{ Exception -> 0x006b }
        r4 = r4.equals(r3);	 Catch:{ Exception -> 0x006b }
        if (r4 != 0) goto L_0x006b;	 Catch:{ Exception -> 0x006b }
    L_0x0066:
        r3 = newFactory(r3, r0);	 Catch:{ Exception -> 0x006b }
        r1 = r3;
    L_0x006b:
        if (r1 != 0) goto L_0x007b;
    L_0x006d:
        if (r2 == 0) goto L_0x007b;
    L_0x006f:
        r3 = "org.apache.commons.logging.LogFactory";
        r3 = r2.getProperty(r3);
        if (r3 == 0) goto L_0x007b;
    L_0x0077:
        r1 = newFactory(r3, r0);
    L_0x007b:
        if (r1 != 0) goto L_0x0096;
    L_0x007d:
        r1 = "org.apache.commons.logging.impl.LogFactoryImpl";
        r3 = class$org$apache$commons$logging$LogFactory;
        if (r3 != 0) goto L_0x008c;
    L_0x0083:
        r3 = "org.apache.commons.logging.LogFactory";
        r3 = class$(r3);
        class$org$apache$commons$logging$LogFactory = r3;
        goto L_0x008e;
    L_0x008c:
        r3 = class$org$apache$commons$logging$LogFactory;
    L_0x008e:
        r3 = r3.getClassLoader();
        r1 = newFactory(r1, r3);
    L_0x0096:
        if (r1 == 0) goto L_0x00b6;
    L_0x0098:
        cacheFactory(r0, r1);
        if (r2 == 0) goto L_0x00b6;
    L_0x009d:
        r0 = r2.propertyNames();
    L_0x00a1:
        r3 = r0.hasMoreElements();
        if (r3 != 0) goto L_0x00a8;
    L_0x00a7:
        goto L_0x00b6;
    L_0x00a8:
        r3 = r0.nextElement();
        r3 = (java.lang.String) r3;
        r4 = r2.getProperty(r3);
        r1.setAttribute(r3, r4);
        goto L_0x00a1;
    L_0x00b6:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.LogFactory.getFactory():org.apache.commons.logging.LogFactory");
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (String str2) {
            throw new NoClassDefFoundError(str2.getMessage());
        }
    }

    public static Log getLog(Class cls) throws LogConfigurationException {
        return getFactory().getInstance(cls);
    }

    public static Log getLog(String str) throws LogConfigurationException {
        return getFactory().getInstance(str);
    }

    public static void release(ClassLoader classLoader) {
        synchronized (factories) {
            LogFactory logFactory = (LogFactory) factories.get(classLoader);
            if (logFactory != null) {
                logFactory.release();
                factories.remove(classLoader);
            }
        }
    }

    public static void releaseAll() {
        synchronized (factories) {
            Enumeration elements = factories.elements();
            while (elements.hasMoreElements()) {
                ((LogFactory) elements.nextElement()).release();
            }
            factories.clear();
        }
    }

    protected static java.lang.ClassLoader getContextClassLoader() throws org.apache.commons.logging.LogConfigurationException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = class$java$lang$Thread;	 Catch:{ NoSuchMethodException -> 0x0040 }
        if (r1 != 0) goto L_0x000e;	 Catch:{ NoSuchMethodException -> 0x0040 }
    L_0x0005:
        r1 = "java.lang.Thread";	 Catch:{ NoSuchMethodException -> 0x0040 }
        r1 = class$(r1);	 Catch:{ NoSuchMethodException -> 0x0040 }
        class$java$lang$Thread = r1;	 Catch:{ NoSuchMethodException -> 0x0040 }
        goto L_0x0010;	 Catch:{ NoSuchMethodException -> 0x0040 }
    L_0x000e:
        r1 = class$java$lang$Thread;	 Catch:{ NoSuchMethodException -> 0x0040 }
    L_0x0010:
        r2 = "getContextClassLoader";	 Catch:{ NoSuchMethodException -> 0x0040 }
        r1 = r1.getMethod(r2, r0);	 Catch:{ NoSuchMethodException -> 0x0040 }
        r2 = java.lang.Thread.currentThread();	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x0022 }
        r1 = r1.invoke(r2, r0);	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x0022 }
        r1 = (java.lang.ClassLoader) r1;	 Catch:{ IllegalAccessException -> 0x0037, InvocationTargetException -> 0x0022 }
        r0 = r1;
        goto L_0x0053;
    L_0x0022:
        r1 = move-exception;
        r2 = r1.getTargetException();	 Catch:{ NoSuchMethodException -> 0x0040 }
        r2 = r2 instanceof java.lang.SecurityException;	 Catch:{ NoSuchMethodException -> 0x0040 }
        if (r2 != 0) goto L_0x0053;	 Catch:{ NoSuchMethodException -> 0x0040 }
    L_0x002b:
        r0 = new org.apache.commons.logging.LogConfigurationException;	 Catch:{ NoSuchMethodException -> 0x0040 }
        r2 = "Unexpected InvocationTargetException";	 Catch:{ NoSuchMethodException -> 0x0040 }
        r1 = r1.getTargetException();	 Catch:{ NoSuchMethodException -> 0x0040 }
        r0.<init>(r2, r1);	 Catch:{ NoSuchMethodException -> 0x0040 }
        throw r0;	 Catch:{ NoSuchMethodException -> 0x0040 }
    L_0x0037:
        r0 = move-exception;	 Catch:{ NoSuchMethodException -> 0x0040 }
        r1 = new org.apache.commons.logging.LogConfigurationException;	 Catch:{ NoSuchMethodException -> 0x0040 }
        r2 = "Unexpected IllegalAccessException";	 Catch:{ NoSuchMethodException -> 0x0040 }
        r1.<init>(r2, r0);	 Catch:{ NoSuchMethodException -> 0x0040 }
        throw r1;	 Catch:{ NoSuchMethodException -> 0x0040 }
    L_0x0040:
        r0 = class$org$apache$commons$logging$LogFactory;
        if (r0 != 0) goto L_0x004d;
    L_0x0044:
        r0 = "org.apache.commons.logging.LogFactory";
        r0 = class$(r0);
        class$org$apache$commons$logging$LogFactory = r0;
        goto L_0x004f;
    L_0x004d:
        r0 = class$org$apache$commons$logging$LogFactory;
    L_0x004f:
        r0 = r0.getClassLoader();
    L_0x0053:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.LogFactory.getContextClassLoader():java.lang.ClassLoader");
    }

    private static LogFactory getCachedFactory(ClassLoader classLoader) {
        return classLoader != null ? (LogFactory) factories.get(classLoader) : null;
    }

    private static void cacheFactory(ClassLoader classLoader, LogFactory logFactory) {
        if (classLoader != null && logFactory != null) {
            factories.put(classLoader, logFactory);
        }
    }

    protected static LogFactory newFactory(String str, ClassLoader classLoader) throws LogConfigurationException {
        str = AccessController.doPrivileged(new AnonymousClass2(classLoader, str));
        if ((str instanceof LogConfigurationException) == null) {
            return (LogFactory) str;
        }
        throw ((LogConfigurationException) str);
    }

    private static InputStream getResourceAsStream(ClassLoader classLoader, String str) {
        return (InputStream) AccessController.doPrivileged(new AnonymousClass3(classLoader, str));
    }
}
