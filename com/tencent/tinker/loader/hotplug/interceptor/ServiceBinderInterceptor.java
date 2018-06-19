package com.tencent.tinker.loader.hotplug.interceptor;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.IBinder;
import android.os.IInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
public class ServiceBinderInterceptor extends Interceptor<IBinder> {
    private static final ClassLoader MY_CLASSLOADER = ServiceBinderInterceptor.class.getClassLoader();
    private static final String TAG = "Tinker.SvcBndrIntrcptr";
    private static Method sGetServiceMethod;
    private static Field sSCacheField;
    private static Class<?> sServiceManagerClazz;
    private final Context mBaseContext;
    private final BinderInvocationHandler mBinderInvocationHandler;
    private final String mServiceName;

    /* compiled from: BUGLY */
    public interface BinderInvocationHandler {
        Object invoke(Object obj, Method method, Object[] objArr) throws Throwable;
    }

    /* compiled from: BUGLY */
    private static class FakeClientBinderHandler implements InvocationHandler {
        private final BinderInvocationHandler mBinderInvocationHandler;
        private final IBinder mOriginalClientBinder;

        FakeClientBinderHandler(IBinder iBinder, BinderInvocationHandler binderInvocationHandler) {
            this.mOriginalClientBinder = iBinder;
            this.mBinderInvocationHandler = binderInvocationHandler;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (!"queryLocalInterface".equals(method.getName())) {
                return method.invoke(this.mOriginalClientBinder, objArr);
            }
            method = this.mOriginalClientBinder.getInterfaceDescriptor();
            if (method.equals("android.app.IActivityManager") != null) {
                method = "android.app.ActivityManagerNative";
            } else {
                objArr = new StringBuilder();
                objArr.append(method);
                objArr.append("$Stub");
                method = objArr.toString();
            }
            IInterface iInterface = (IInterface) ShareReflectUtil.findMethod(Class.forName(method), "asInterface", IBinder.class).invoke(null, new Object[]{this.mOriginalClientBinder});
            return ServiceBinderInterceptor.createProxy(iInterface.getClass().getClassLoader(), ServiceBinderInterceptor.getAllInterfacesThroughDeriveChain(iInterface.getClass()), new FakeInterfaceHandler(iInterface, (IBinder) obj, this.mBinderInvocationHandler));
        }
    }

    /* compiled from: BUGLY */
    private static class FakeInterfaceHandler implements InvocationHandler {
        private final BinderInvocationHandler mBinderInvocationHandler;
        private final IBinder mOriginalClientBinder;
        private final IInterface mOriginalInterface;

        FakeInterfaceHandler(IInterface iInterface, IBinder iBinder, BinderInvocationHandler binderInvocationHandler) {
            this.mOriginalInterface = iInterface;
            this.mOriginalClientBinder = iBinder;
            this.mBinderInvocationHandler = binderInvocationHandler;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if ("asBinder".equals(method.getName()) != null) {
                return this.mOriginalClientBinder;
            }
            return this.mBinderInvocationHandler.invoke(this.mOriginalInterface, method, objArr);
        }
    }

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor.class;
        r0 = r0.getClassLoader();
        MY_CLASSLOADER = r0;
        r0 = com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor.class;
        monitor-enter(r0);
        r1 = sServiceManagerClazz;	 Catch:{ all -> 0x0033 }
        if (r1 != 0) goto L_0x0031;
    L_0x000f:
        r1 = "android.os.ServiceManager";	 Catch:{ Throwable -> 0x0031 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x0031 }
        sServiceManagerClazz = r1;	 Catch:{ Throwable -> 0x0031 }
        r2 = "sCache";	 Catch:{ Throwable -> 0x0031 }
        r1 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findField(r1, r2);	 Catch:{ Throwable -> 0x0031 }
        sSCacheField = r1;	 Catch:{ Throwable -> 0x0031 }
        r1 = sServiceManagerClazz;	 Catch:{ Throwable -> 0x0031 }
        r2 = "getService";	 Catch:{ Throwable -> 0x0031 }
        r3 = 1;	 Catch:{ Throwable -> 0x0031 }
        r3 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x0031 }
        r4 = 0;	 Catch:{ Throwable -> 0x0031 }
        r5 = java.lang.String.class;	 Catch:{ Throwable -> 0x0031 }
        r3[r4] = r5;	 Catch:{ Throwable -> 0x0031 }
        r1 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findMethod(r1, r2, r3);	 Catch:{ Throwable -> 0x0031 }
        sGetServiceMethod = r1;	 Catch:{ Throwable -> 0x0031 }
    L_0x0031:
        monitor-exit(r0);	 Catch:{ all -> 0x0033 }
        return;	 Catch:{ all -> 0x0033 }
    L_0x0033:
        r1 = move-exception;	 Catch:{ all -> 0x0033 }
        monitor-exit(r0);	 Catch:{ all -> 0x0033 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor.<clinit>():void");
    }

    public ServiceBinderInterceptor(Context context, String str, BinderInvocationHandler binderInvocationHandler) {
        while (context != null && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        this.mBaseContext = context;
        this.mServiceName = str;
        this.mBinderInvocationHandler = binderInvocationHandler;
    }

    @Nullable
    protected IBinder fetchTarget() throws Throwable {
        return (IBinder) sGetServiceMethod.invoke(null, new Object[]{this.mServiceName});
    }

    @NonNull
    protected IBinder decorate(@Nullable IBinder iBinder) throws Throwable {
        if (iBinder == null) {
            throw new IllegalStateException("target is null.");
        } else if (ITinkerHotplugProxy.class.isAssignableFrom(iBinder.getClass())) {
            return iBinder;
        } else {
            return (IBinder) createProxy(iBinder.getClass().getClassLoader(), getAllInterfacesThroughDeriveChain(iBinder.getClass()), new FakeClientBinderHandler(iBinder, this.mBinderInvocationHandler));
        }
    }

    protected void inject(@Nullable IBinder iBinder) throws Throwable {
        ((Map) sSCacheField.get(null)).put(this.mServiceName, iBinder);
        if ("activity".equals(this.mServiceName)) {
            fixAMSBinderCache(iBinder);
            return;
        }
        if ("package".equals(this.mServiceName)) {
            fixPMSBinderCache(this.mBaseContext, iBinder);
        }
    }

    private static void fixAMSBinderCache(android.os.IBinder r5) throws java.lang.Throwable {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = "android.app.ActivityManagerNative";	 Catch:{ Throwable -> 0x0012 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x0012 }
        r2 = "gDefault";	 Catch:{ Throwable -> 0x0012 }
        r1 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findField(r1, r2);	 Catch:{ Throwable -> 0x0012 }
        r1 = r1.get(r0);	 Catch:{ Throwable -> 0x0012 }
        goto L_0x0022;
    L_0x0012:
        r1 = "android.app.ActivityManager";
        r1 = java.lang.Class.forName(r1);
        r2 = "IActivityManagerSingleton";
        r1 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findField(r1, r2);
        r1 = r1.get(r0);
    L_0x0022:
        r0 = "mInstance";
        r0 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findField(r1, r0);
        r2 = r0.get(r1);
        r2 = (android.os.IInterface) r2;
        if (r2 == 0) goto L_0x0074;
    L_0x0030:
        r3 = com.tencent.tinker.loader.hotplug.interceptor.Interceptor.ITinkerHotplugProxy.class;
        r2 = r2.getClass();
        r2 = r3.isAssignableFrom(r2);
        if (r2 == 0) goto L_0x003d;
    L_0x003c:
        goto L_0x0074;
    L_0x003d:
        r2 = r5.getInterfaceDescriptor();
        r2 = r5.queryLocalInterface(r2);
        if (r2 == 0) goto L_0x0058;
    L_0x0047:
        r3 = com.tencent.tinker.loader.hotplug.interceptor.Interceptor.ITinkerHotplugProxy.class;
        r4 = r2.getClass();
        r3 = r3.isAssignableFrom(r4);
        if (r3 != 0) goto L_0x0054;
    L_0x0053:
        goto L_0x0058;
    L_0x0054:
        r0.set(r1, r2);
        return;
    L_0x0058:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r3 = "fakeBinder does not return fakeInterface, binder: ";
        r1.<init>(r3);
        r1.append(r5);
        r5 = ", itf: ";
        r1.append(r5);
        r1.append(r2);
        r5 = r1.toString();
        r0.<init>(r5);
        throw r0;
    L_0x0074:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor.fixAMSBinderCache(android.os.IBinder):void");
    }

    private static void fixPMSBinderCache(Context context, IBinder iBinder) throws Throwable {
        Field findField = ShareReflectUtil.findField(Class.forName("android.app.ActivityThread"), "sPackageManager");
        IInterface iInterface = (IInterface) findField.get(null);
        if (!(iInterface == null || ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass()))) {
            iInterface = iBinder.queryLocalInterface(iBinder.getInterfaceDescriptor());
            if (iInterface != null) {
                if (ITinkerHotplugProxy.class.isAssignableFrom(iInterface.getClass())) {
                    findField.set(null, iInterface);
                }
            }
            StringBuilder stringBuilder = new StringBuilder("fakeBinder does not return fakeInterface, binder: ");
            stringBuilder.append(iBinder);
            stringBuilder.append(", itf: ");
            stringBuilder.append(iInterface);
            throw new IllegalStateException(stringBuilder.toString());
        }
        findField = ShareReflectUtil.findField(Class.forName("android.app.ApplicationPackageManager"), "mPM");
        context = context.getPackageManager();
        IInterface iInterface2 = (IInterface) findField.get(context);
        if (iInterface2 != null && !ITinkerHotplugProxy.class.isAssignableFrom(iInterface2.getClass())) {
            iInterface2 = iBinder.queryLocalInterface(iBinder.getInterfaceDescriptor());
            if (iInterface2 != null) {
                if (ITinkerHotplugProxy.class.isAssignableFrom(iInterface2.getClass())) {
                    findField.set(context, iInterface2);
                    return;
                }
            }
            stringBuilder = new StringBuilder("fakeBinder does not return fakeInterface, binder: ");
            stringBuilder.append(iBinder);
            stringBuilder.append(", itf: ");
            stringBuilder.append(iInterface2);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private static <T> T createProxy(java.lang.ClassLoader r3, java.lang.Class<?>[] r4, java.lang.reflect.InvocationHandler r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = r4.length;
        r1 = r1 + 1;
        r1 = new java.lang.Class[r1];
        r2 = r4.length;
        java.lang.System.arraycopy(r4, r0, r1, r0, r2);
        r4 = r4.length;
        r0 = com.tencent.tinker.loader.hotplug.interceptor.Interceptor.ITinkerHotplugProxy.class;
        r1[r4] = r0;
        r4 = MY_CLASSLOADER;	 Catch:{ Throwable -> 0x0016 }
        r4 = java.lang.reflect.Proxy.newProxyInstance(r4, r1, r5);	 Catch:{ Throwable -> 0x0016 }
        return r4;
    L_0x0016:
        r4 = move-exception;
        if (r3 == 0) goto L_0x0036;
    L_0x0019:
        r0 = MY_CLASSLOADER;
        if (r3 == r0) goto L_0x0036;
    L_0x001d:
        r5 = java.lang.reflect.Proxy.newProxyInstance(r3, r1, r5);	 Catch:{ Throwable -> 0x0022 }
        return r5;
    L_0x0022:
        r5 = new java.lang.RuntimeException;
        r0 = new java.lang.StringBuilder;
        r1 = "cl: ";
        r0.<init>(r1);
        r0.append(r3);
        r3 = r0.toString();
        r5.<init>(r3, r4);
        throw r5;
    L_0x0036:
        r5 = new java.lang.RuntimeException;
        r0 = new java.lang.StringBuilder;
        r1 = "cl: ";
        r0.<init>(r1);
        r0.append(r3);
        r3 = r0.toString();
        r5.<init>(r3, r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor.createProxy(java.lang.ClassLoader, java.lang.Class[], java.lang.reflect.InvocationHandler):T");
    }

    private static Class<?>[] getAllInterfacesThroughDeriveChain(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        Set hashSet = new HashSet(10);
        while (!Object.class.equals(cls)) {
            hashSet.addAll(Arrays.asList(cls.getInterfaces()));
            cls = cls.getSuperclass();
        }
        return (Class[]) hashSet.toArray(new Class[hashSet.size()]);
    }
}
