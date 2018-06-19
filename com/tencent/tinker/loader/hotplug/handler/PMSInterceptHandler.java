package com.tencent.tinker.loader.hotplug.handler;

import com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor.BinderInvocationHandler;
import java.lang.reflect.Method;

/* compiled from: BUGLY */
public class PMSInterceptHandler implements BinderInvocationHandler {
    private static final String TAG = "Tinker.PMSIntrcptHndlr";

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        String name = method.getName();
        if ("getActivityInfo".equals(name)) {
            return handleGetActivityInfo(obj, method, objArr);
        }
        if ("resolveIntent".equals(name)) {
            return handleResolveIntent(obj, method, objArr);
        }
        return method.invoke(obj, objArr);
    }

    private java.lang.Object handleGetActivityInfo(java.lang.Object r5, java.lang.reflect.Method r6, java.lang.Object[] r7) throws java.lang.Throwable {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r6.getExceptionTypes();
        r1 = 0;
        r5 = r6.invoke(r5, r7);	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        if (r5 == 0) goto L_0x000c;	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
    L_0x000b:
        return r5;	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
    L_0x000c:
        r5 = 0;	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
    L_0x000d:
        r2 = r7.length;	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        if (r5 >= r2) goto L_0x0034;	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
    L_0x0010:
        r2 = r7[r5];	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        r2 = r2 instanceof android.content.ComponentName;	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        if (r2 == 0) goto L_0x0031;	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
    L_0x0016:
        r2 = new java.lang.StringBuilder;	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        r3 = "locate componentName field of ";	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        r2.<init>(r3);	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        r3 = r6.getName();	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        r2.append(r3);	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        r3 = " done at idx: ";	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        r2.append(r3);	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        r2.append(r5);	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        r5 = r7[r5];	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        r5 = (android.content.ComponentName) r5;	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        goto L_0x0035;	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
    L_0x0031:
        r5 = r5 + 1;	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        goto L_0x000d;	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
    L_0x0034:
        r5 = r1;	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
    L_0x0035:
        if (r5 == 0) goto L_0x0040;	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
    L_0x0037:
        r5 = r5.getClassName();	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        r5 = com.tencent.tinker.loader.hotplug.IncrementComponentManager.queryActivityInfo(r5);	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        return r5;	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
    L_0x0040:
        r5 = new java.lang.StringBuilder;	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        r7 = "failed to locate componentName field of ";	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        r5.<init>(r7);	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        r6 = r6.getName();	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        r5.append(r6);	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        r6 = ", notice any crashes or mistakes after resolve works.";	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        r5.append(r6);	 Catch:{ InvocationTargetException -> 0x0055, Throwable -> 0x0054 }
        return r1;
    L_0x0054:
        return r1;
    L_0x0055:
        r5 = move-exception;
        r6 = r5.getTargetException();
        if (r0 == 0) goto L_0x0063;
    L_0x005c:
        r7 = r0.length;
        if (r7 <= 0) goto L_0x0063;
    L_0x005f:
        if (r6 == 0) goto L_0x0062;
    L_0x0061:
        r5 = r6;
    L_0x0062:
        throw r5;
    L_0x0063:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.hotplug.handler.PMSInterceptHandler.handleGetActivityInfo(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
    }

    private java.lang.Object handleResolveIntent(java.lang.Object r5, java.lang.reflect.Method r6, java.lang.Object[] r7) throws java.lang.Throwable {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r6.getExceptionTypes();
        r1 = 0;
        r5 = r6.invoke(r5, r7);	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        if (r5 == 0) goto L_0x000c;	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
    L_0x000b:
        return r5;	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
    L_0x000c:
        r5 = 0;	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
    L_0x000d:
        r2 = r7.length;	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        if (r5 >= r2) goto L_0x0034;	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
    L_0x0010:
        r2 = r7[r5];	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        r2 = r2 instanceof android.content.Intent;	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        if (r2 == 0) goto L_0x0031;	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
    L_0x0016:
        r2 = new java.lang.StringBuilder;	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        r3 = "locate intent field of ";	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        r2.<init>(r3);	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        r3 = r6.getName();	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        r2.append(r3);	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        r3 = " done at idx: ";	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        r2.append(r3);	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        r2.append(r5);	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        r5 = r7[r5];	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        r5 = (android.content.Intent) r5;	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        goto L_0x0035;	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
    L_0x0031:
        r5 = r5 + 1;	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        goto L_0x000d;	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
    L_0x0034:
        r5 = r1;	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
    L_0x0035:
        if (r5 == 0) goto L_0x003c;	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
    L_0x0037:
        r5 = com.tencent.tinker.loader.hotplug.IncrementComponentManager.resolveIntent(r5);	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        return r5;	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
    L_0x003c:
        r5 = new java.lang.StringBuilder;	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        r7 = "failed to locate intent field of ";	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        r5.<init>(r7);	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        r6 = r6.getName();	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        r5.append(r6);	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        r6 = ", notice any crashes or mistakes after resolve works.";	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        r5.append(r6);	 Catch:{ InvocationTargetException -> 0x0051, Throwable -> 0x0050 }
        return r1;
    L_0x0050:
        return r1;
    L_0x0051:
        r5 = move-exception;
        r6 = r5.getTargetException();
        if (r0 == 0) goto L_0x005f;
    L_0x0058:
        r7 = r0.length;
        if (r7 <= 0) goto L_0x005f;
    L_0x005b:
        if (r6 == 0) goto L_0x005e;
    L_0x005d:
        r5 = r6;
    L_0x005e:
        throw r5;
    L_0x005f:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.hotplug.handler.PMSInterceptHandler.handleResolveIntent(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
    }
}
