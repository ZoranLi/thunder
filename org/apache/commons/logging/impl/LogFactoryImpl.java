package org.apache.commons.logging.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.commons.logging.LogFactory;

public class LogFactoryImpl extends LogFactory {
    public static final String LOG_PROPERTY = "org.apache.commons.logging.Log";
    protected static final String LOG_PROPERTY_OLD = "org.apache.commons.logging.log";
    static Class class$java$lang$String;
    static Class class$org$apache$commons$logging$Log;
    static Class class$org$apache$commons$logging$LogFactory;
    protected Hashtable attributes = new Hashtable();
    protected Hashtable instances = new Hashtable();
    private String logClassName;
    protected Constructor logConstructor = null;
    protected Class[] logConstructorSignature;
    protected Method logMethod;
    protected Class[] logMethodSignature;

    class AnonymousClass1 implements PrivilegedAction {
        private final String val$name;

        AnonymousClass1(String str) {
            this.val$name = str;
        }

        public java.lang.Object run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r2 = this;
            r0 = org.apache.commons.logging.impl.LogFactoryImpl.access$000();
            if (r0 == 0) goto L_0x000d;
        L_0x0006:
            r1 = r2.val$name;	 Catch:{ ClassNotFoundException -> 0x000d }
            r0 = r0.loadClass(r1);	 Catch:{ ClassNotFoundException -> 0x000d }
            return r0;
        L_0x000d:
            r0 = r2.val$name;	 Catch:{ ClassNotFoundException -> 0x0014 }
            r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0014 }
            return r0;
        L_0x0014:
            r0 = move-exception;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.impl.LogFactoryImpl.1.run():java.lang.Object");
        }
    }

    static ClassLoader access$000() throws LogConfigurationException {
        return LogFactory.getContextClassLoader();
    }

    public LogFactoryImpl() {
        Class class$;
        Class class$2;
        Class[] clsArr = new Class[1];
        if (class$java$lang$String == null) {
            class$ = class$("java.lang.String");
            class$java$lang$String = class$;
        } else {
            class$ = class$java$lang$String;
        }
        clsArr[0] = class$;
        this.logConstructorSignature = clsArr;
        this.logMethod = null;
        Class[] clsArr2 = new Class[1];
        if (class$org$apache$commons$logging$LogFactory == null) {
            class$2 = class$(LogFactory.FACTORY_PROPERTY);
            class$org$apache$commons$logging$LogFactory = class$2;
        } else {
            class$2 = class$org$apache$commons$logging$LogFactory;
        }
        clsArr2[0] = class$2;
        this.logMethodSignature = clsArr2;
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (String str2) {
            throw new NoClassDefFoundError(str2.getMessage());
        }
    }

    public Object getAttribute(String str) {
        return this.attributes.get(str);
    }

    public String[] getAttributeNames() {
        Vector vector = new Vector();
        Enumeration keys = this.attributes.keys();
        while (keys.hasMoreElements()) {
            vector.addElement((String) keys.nextElement());
        }
        String[] strArr = new String[vector.size()];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = (String) vector.elementAt(i);
        }
        return strArr;
    }

    public Log getInstance(Class cls) throws LogConfigurationException {
        return getInstance(cls.getName());
    }

    public Log getInstance(String str) throws LogConfigurationException {
        Log log = (Log) this.instances.get(str);
        if (log != null) {
            return log;
        }
        log = newInstance(str);
        this.instances.put(str, log);
        return log;
    }

    public void release() {
        this.instances.clear();
    }

    public void removeAttribute(String str) {
        this.attributes.remove(str);
    }

    public void setAttribute(String str, Object obj) {
        if (obj == null) {
            this.attributes.remove(str);
        } else {
            this.attributes.put(str, obj);
        }
    }

    protected java.lang.String getLogClassName() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.logClassName;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r0 = r1.logClassName;
        return r0;
    L_0x0007:
        r0 = "org.apache.commons.logging.Log";
        r0 = r1.getAttribute(r0);
        r0 = (java.lang.String) r0;
        r1.logClassName = r0;
        r0 = r1.logClassName;
        if (r0 != 0) goto L_0x001f;
    L_0x0015:
        r0 = "org.apache.commons.logging.log";
        r0 = r1.getAttribute(r0);
        r0 = (java.lang.String) r0;
        r1.logClassName = r0;
    L_0x001f:
        r0 = r1.logClassName;
        if (r0 != 0) goto L_0x002b;
    L_0x0023:
        r0 = "org.apache.commons.logging.Log";	 Catch:{ SecurityException -> 0x002b }
        r0 = java.lang.System.getProperty(r0);	 Catch:{ SecurityException -> 0x002b }
        r1.logClassName = r0;	 Catch:{ SecurityException -> 0x002b }
    L_0x002b:
        r0 = r1.logClassName;
        if (r0 != 0) goto L_0x0037;
    L_0x002f:
        r0 = "org.apache.commons.logging.log";	 Catch:{ SecurityException -> 0x0037 }
        r0 = java.lang.System.getProperty(r0);	 Catch:{ SecurityException -> 0x0037 }
        r1.logClassName = r0;	 Catch:{ SecurityException -> 0x0037 }
    L_0x0037:
        r0 = r1.logClassName;
        if (r0 != 0) goto L_0x0045;
    L_0x003b:
        r0 = r1.isLog4JAvailable();
        if (r0 == 0) goto L_0x0045;
    L_0x0041:
        r0 = "org.apache.commons.logging.impl.Log4JLogger";
        r1.logClassName = r0;
    L_0x0045:
        r0 = r1.logClassName;
        if (r0 != 0) goto L_0x0053;
    L_0x0049:
        r0 = r1.isJdk14Available();
        if (r0 == 0) goto L_0x0053;
    L_0x004f:
        r0 = "org.apache.commons.logging.impl.Jdk14Logger";
        r1.logClassName = r0;
    L_0x0053:
        r0 = r1.logClassName;
        if (r0 != 0) goto L_0x005b;
    L_0x0057:
        r0 = "org.apache.commons.logging.impl.SimpleLog";
        r1.logClassName = r0;
    L_0x005b:
        r0 = r1.logClassName;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.impl.LogFactoryImpl.getLogClassName():java.lang.String");
    }

    protected java.lang.reflect.Constructor getLogConstructor() throws org.apache.commons.logging.LogConfigurationException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.logConstructor;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r0 = r5.logConstructor;
        return r0;
    L_0x0007:
        r0 = r5.getLogClassName();
        r1 = loadClass(r0);	 Catch:{ Throwable -> 0x008b }
        if (r1 != 0) goto L_0x0025;	 Catch:{ Throwable -> 0x008b }
    L_0x0011:
        r1 = new org.apache.commons.logging.LogConfigurationException;	 Catch:{ Throwable -> 0x008b }
        r2 = new java.lang.StringBuffer;	 Catch:{ Throwable -> 0x008b }
        r3 = "No suitable Log implementation for ";	 Catch:{ Throwable -> 0x008b }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x008b }
        r2.append(r0);	 Catch:{ Throwable -> 0x008b }
        r0 = r2.toString();	 Catch:{ Throwable -> 0x008b }
        r1.<init>(r0);	 Catch:{ Throwable -> 0x008b }
        throw r1;	 Catch:{ Throwable -> 0x008b }
    L_0x0025:
        r2 = class$org$apache$commons$logging$Log;	 Catch:{ Throwable -> 0x008b }
        if (r2 != 0) goto L_0x0032;	 Catch:{ Throwable -> 0x008b }
    L_0x0029:
        r2 = "org.apache.commons.logging.Log";	 Catch:{ Throwable -> 0x008b }
        r2 = class$(r2);	 Catch:{ Throwable -> 0x008b }
        class$org$apache$commons$logging$Log = r2;	 Catch:{ Throwable -> 0x008b }
        goto L_0x0034;	 Catch:{ Throwable -> 0x008b }
    L_0x0032:
        r2 = class$org$apache$commons$logging$Log;	 Catch:{ Throwable -> 0x008b }
    L_0x0034:
        r2 = r2.isAssignableFrom(r1);	 Catch:{ Throwable -> 0x008b }
        if (r2 != 0) goto L_0x0053;	 Catch:{ Throwable -> 0x008b }
    L_0x003a:
        r1 = new org.apache.commons.logging.LogConfigurationException;	 Catch:{ Throwable -> 0x008b }
        r2 = new java.lang.StringBuffer;	 Catch:{ Throwable -> 0x008b }
        r3 = "Class ";	 Catch:{ Throwable -> 0x008b }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x008b }
        r2.append(r0);	 Catch:{ Throwable -> 0x008b }
        r0 = " does not implement Log";	 Catch:{ Throwable -> 0x008b }
        r2.append(r0);	 Catch:{ Throwable -> 0x008b }
        r0 = r2.toString();	 Catch:{ Throwable -> 0x008b }
        r1.<init>(r0);	 Catch:{ Throwable -> 0x008b }
        throw r1;	 Catch:{ Throwable -> 0x008b }
    L_0x0053:
        r2 = "setLogFactory";	 Catch:{ Throwable -> 0x005e }
        r3 = r5.logMethodSignature;	 Catch:{ Throwable -> 0x005e }
        r2 = r1.getMethod(r2, r3);	 Catch:{ Throwable -> 0x005e }
        r5.logMethod = r2;	 Catch:{ Throwable -> 0x005e }
        goto L_0x0061;
    L_0x005e:
        r2 = 0;
        r5.logMethod = r2;
    L_0x0061:
        r2 = r5.logConstructorSignature;	 Catch:{ Throwable -> 0x006c }
        r1 = r1.getConstructor(r2);	 Catch:{ Throwable -> 0x006c }
        r5.logConstructor = r1;	 Catch:{ Throwable -> 0x006c }
        r1 = r5.logConstructor;	 Catch:{ Throwable -> 0x006c }
        return r1;
    L_0x006c:
        r1 = move-exception;
        r2 = new org.apache.commons.logging.LogConfigurationException;
        r3 = new java.lang.StringBuffer;
        r4 = "No suitable Log constructor ";
        r3.<init>(r4);
        r4 = r5.logConstructorSignature;
        r3.append(r4);
        r4 = " for ";
        r3.append(r4);
        r3.append(r0);
        r0 = r3.toString();
        r2.<init>(r0, r1);
        throw r2;
    L_0x008b:
        r0 = move-exception;
        r1 = new org.apache.commons.logging.LogConfigurationException;
        r1.<init>(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.impl.LogFactoryImpl.getLogConstructor():java.lang.reflect.Constructor");
    }

    private static Class loadClass(String str) throws ClassNotFoundException {
        str = AccessController.doPrivileged(new AnonymousClass1(str));
        if (str instanceof Class) {
            return (Class) str;
        }
        throw ((ClassNotFoundException) str);
    }

    protected boolean isJdk14Available() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = "java.util.logging.Logger";	 Catch:{ Throwable -> 0x000c }
        loadClass(r0);	 Catch:{ Throwable -> 0x000c }
        r0 = "org.apache.commons.logging.impl.Jdk14Logger";	 Catch:{ Throwable -> 0x000c }
        loadClass(r0);	 Catch:{ Throwable -> 0x000c }
        r0 = 1;
        return r0;
    L_0x000c:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.impl.LogFactoryImpl.isJdk14Available():boolean");
    }

    protected boolean isLog4JAvailable() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = "org.apache.log4j.Logger";	 Catch:{ Throwable -> 0x000c }
        loadClass(r0);	 Catch:{ Throwable -> 0x000c }
        r0 = "org.apache.commons.logging.impl.Log4JLogger";	 Catch:{ Throwable -> 0x000c }
        loadClass(r0);	 Catch:{ Throwable -> 0x000c }
        r0 = 1;
        return r0;
    L_0x000c:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.logging.impl.LogFactoryImpl.isLog4JAvailable():boolean");
    }

    protected Log newInstance(String str) throws LogConfigurationException {
        try {
            Object[] objArr = new Object[]{str};
            Log log = (Log) getLogConstructor().newInstance(objArr);
            if (this.logMethod != null) {
                objArr[0] = this;
                this.logMethod.invoke(log, objArr);
            }
            return log;
        } catch (Throwable th) {
            LogConfigurationException logConfigurationException = new LogConfigurationException(th);
        }
    }
}
