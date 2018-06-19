package com.tencent.tinker.loader.hotplug.handler;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import com.tencent.tinker.loader.hotplug.interceptor.HandlerMessageInterceptor.MessageHandler;

/* compiled from: BUGLY */
public class MHMessageHandler implements MessageHandler {
    private static final int LAUNCH_ACTIVITY;
    private static final String TAG = "Tinker.MHMsgHndlr";
    private final Context mContext;

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "android.app.ActivityThread$H";	 Catch:{ Throwable -> 0x0012 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x0012 }
        r1 = "LAUNCH_ACTIVITY";	 Catch:{ Throwable -> 0x0012 }
        r0 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findField(r0, r1);	 Catch:{ Throwable -> 0x0012 }
        r1 = 0;	 Catch:{ Throwable -> 0x0012 }
        r0 = r0.getInt(r1);	 Catch:{ Throwable -> 0x0012 }
        goto L_0x0014;
    L_0x0012:
        r0 = 100;
    L_0x0014:
        LAUNCH_ACTIVITY = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.hotplug.handler.MHMessageHandler.<clinit>():void");
    }

    public MHMessageHandler(Context context) {
        while (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext == null) {
                break;
            }
            context = baseContext;
        }
        this.mContext = context;
    }

    public boolean handleMessage(android.os.Message r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r7.what;
        r1 = LAUNCH_ACTIVITY;
        r2 = 0;
        if (r0 != r1) goto L_0x008b;
    L_0x0007:
        r0 = r7.obj;	 Catch:{ Throwable -> 0x008b }
        if (r0 != 0) goto L_0x001d;	 Catch:{ Throwable -> 0x008b }
    L_0x000b:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x008b }
        r1 = "msg: [";	 Catch:{ Throwable -> 0x008b }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x008b }
        r7 = r7.what;	 Catch:{ Throwable -> 0x008b }
        r0.append(r7);	 Catch:{ Throwable -> 0x008b }
        r7 = "] has no 'obj' value.";	 Catch:{ Throwable -> 0x008b }
        r0.append(r7);	 Catch:{ Throwable -> 0x008b }
        return r2;	 Catch:{ Throwable -> 0x008b }
    L_0x001d:
        r7 = "intent";	 Catch:{ Throwable -> 0x008b }
        r7 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findField(r0, r7);	 Catch:{ Throwable -> 0x008b }
        r7 = r7.get(r0);	 Catch:{ Throwable -> 0x008b }
        r7 = (android.content.Intent) r7;	 Catch:{ Throwable -> 0x008b }
        if (r7 != 0) goto L_0x002c;	 Catch:{ Throwable -> 0x008b }
    L_0x002b:
        return r2;	 Catch:{ Throwable -> 0x008b }
    L_0x002c:
        r1 = r6.mContext;	 Catch:{ Throwable -> 0x008b }
        r1 = r1.getClassLoader();	 Catch:{ Throwable -> 0x008b }
        com.tencent.tinker.loader.shareutil.ShareIntentUtil.fixIntentClassLoader(r7, r1);	 Catch:{ Throwable -> 0x008b }
        r1 = "tinker_iek_old_component";	 Catch:{ Throwable -> 0x008b }
        r1 = r7.getParcelableExtra(r1);	 Catch:{ Throwable -> 0x008b }
        r1 = (android.content.ComponentName) r1;	 Catch:{ Throwable -> 0x008b }
        if (r1 != 0) goto L_0x0053;	 Catch:{ Throwable -> 0x008b }
    L_0x003f:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x008b }
        r1 = "oldComponent was null, start ";	 Catch:{ Throwable -> 0x008b }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x008b }
        r7 = r7.getComponent();	 Catch:{ Throwable -> 0x008b }
        r0.append(r7);	 Catch:{ Throwable -> 0x008b }
        r7 = " next.";	 Catch:{ Throwable -> 0x008b }
        r0.append(r7);	 Catch:{ Throwable -> 0x008b }
        return r2;	 Catch:{ Throwable -> 0x008b }
    L_0x0053:
        r3 = "activityInfo";	 Catch:{ Throwable -> 0x008b }
        r3 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findField(r0, r3);	 Catch:{ Throwable -> 0x008b }
        r3 = r3.get(r0);	 Catch:{ Throwable -> 0x008b }
        r3 = (android.content.pm.ActivityInfo) r3;	 Catch:{ Throwable -> 0x008b }
        if (r3 != 0) goto L_0x0062;	 Catch:{ Throwable -> 0x008b }
    L_0x0061:
        return r2;	 Catch:{ Throwable -> 0x008b }
    L_0x0062:
        r4 = r1.getClassName();	 Catch:{ Throwable -> 0x008b }
        r4 = com.tencent.tinker.loader.hotplug.IncrementComponentManager.queryActivityInfo(r4);	 Catch:{ Throwable -> 0x008b }
        if (r4 != 0) goto L_0x007b;	 Catch:{ Throwable -> 0x008b }
    L_0x006c:
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x008b }
        r0 = "Failed to query target activity's info, perhaps the target is not hotpluged component. Target: ";	 Catch:{ Throwable -> 0x008b }
        r7.<init>(r0);	 Catch:{ Throwable -> 0x008b }
        r0 = r1.getClassName();	 Catch:{ Throwable -> 0x008b }
        r7.append(r0);	 Catch:{ Throwable -> 0x008b }
        return r2;	 Catch:{ Throwable -> 0x008b }
    L_0x007b:
        r5 = r4.screenOrientation;	 Catch:{ Throwable -> 0x008b }
        r6.fixActivityScreenOrientation(r0, r5);	 Catch:{ Throwable -> 0x008b }
        r6.fixStubActivityInfo(r3, r4);	 Catch:{ Throwable -> 0x008b }
        r7.setComponent(r1);	 Catch:{ Throwable -> 0x008b }
        r0 = "tinker_iek_old_component";	 Catch:{ Throwable -> 0x008b }
        r7.removeExtra(r0);	 Catch:{ Throwable -> 0x008b }
    L_0x008b:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.hotplug.handler.MHMessageHandler.handleMessage(android.os.Message):boolean");
    }

    private void fixStubActivityInfo(ActivityInfo activityInfo, ActivityInfo activityInfo2) {
        copyInstanceFields(activityInfo2, activityInfo);
    }

    private <T> void copyInstanceFields(T r7, T r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        if (r7 == 0) goto L_0x0045;
    L_0x0002:
        if (r8 != 0) goto L_0x0005;
    L_0x0004:
        goto L_0x0045;
    L_0x0005:
        r0 = r7.getClass();
    L_0x0009:
        r1 = java.lang.Object.class;
        r1 = r0.equals(r1);
        if (r1 != 0) goto L_0x0044;
    L_0x0011:
        r1 = r0.getDeclaredFields();
        r2 = r1.length;
        r3 = 0;
    L_0x0017:
        if (r3 >= r2) goto L_0x003f;
    L_0x0019:
        r4 = r1[r3];
        r5 = r4.isSynthetic();
        if (r5 != 0) goto L_0x003c;
    L_0x0021:
        r5 = r4.getModifiers();
        r5 = java.lang.reflect.Modifier.isStatic(r5);
        if (r5 != 0) goto L_0x003c;
    L_0x002b:
        r5 = r4.isAccessible();
        if (r5 != 0) goto L_0x0035;
    L_0x0031:
        r5 = 1;
        r4.setAccessible(r5);
    L_0x0035:
        r5 = r4.get(r7);	 Catch:{ Throwable -> 0x003c }
        r4.set(r8, r5);	 Catch:{ Throwable -> 0x003c }
    L_0x003c:
        r3 = r3 + 1;
        goto L_0x0017;
    L_0x003f:
        r0 = r0.getSuperclass();
        goto L_0x0009;
    L_0x0044:
        return;
    L_0x0045:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.hotplug.handler.MHMessageHandler.copyInstanceFields(java.lang.Object, java.lang.Object):void");
    }

    private void fixActivityScreenOrientation(java.lang.Object r8, int r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = 2;
        r1 = -1;
        if (r9 != r1) goto L_0x0005;
    L_0x0004:
        r9 = r0;
    L_0x0005:
        r1 = "token";	 Catch:{ Throwable -> 0x0044 }
        r1 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findField(r8, r1);	 Catch:{ Throwable -> 0x0044 }
        r8 = r1.get(r8);	 Catch:{ Throwable -> 0x0044 }
        r1 = "android.app.ActivityManagerNative";	 Catch:{ Throwable -> 0x0044 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x0044 }
        r2 = "getDefault";	 Catch:{ Throwable -> 0x0044 }
        r3 = 0;	 Catch:{ Throwable -> 0x0044 }
        r4 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x0044 }
        r1 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findMethod(r1, r2, r4);	 Catch:{ Throwable -> 0x0044 }
        r2 = 0;	 Catch:{ Throwable -> 0x0044 }
        r4 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0044 }
        r1 = r1.invoke(r2, r4);	 Catch:{ Throwable -> 0x0044 }
        r2 = "setRequestedOrientation";	 Catch:{ Throwable -> 0x0044 }
        r4 = new java.lang.Class[r0];	 Catch:{ Throwable -> 0x0044 }
        r5 = android.os.IBinder.class;	 Catch:{ Throwable -> 0x0044 }
        r4[r3] = r5;	 Catch:{ Throwable -> 0x0044 }
        r5 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x0044 }
        r6 = 1;	 Catch:{ Throwable -> 0x0044 }
        r4[r6] = r5;	 Catch:{ Throwable -> 0x0044 }
        r2 = com.tencent.tinker.loader.shareutil.ShareReflectUtil.findMethod(r1, r2, r4);	 Catch:{ Throwable -> 0x0044 }
        r0 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x0044 }
        r0[r3] = r8;	 Catch:{ Throwable -> 0x0044 }
        r8 = java.lang.Integer.valueOf(r9);	 Catch:{ Throwable -> 0x0044 }
        r0[r6] = r8;	 Catch:{ Throwable -> 0x0044 }
        r2.invoke(r1, r0);	 Catch:{ Throwable -> 0x0044 }
        return;
    L_0x0044:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.hotplug.handler.MHMessageHandler.fixActivityScreenOrientation(java.lang.Object, int):void");
    }
}
