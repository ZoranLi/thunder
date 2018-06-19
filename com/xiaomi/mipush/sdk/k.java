package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.umeng.message.MsgConstant;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.as;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class k {
    private static ActivityInfo a(PackageManager packageManager, Intent intent, Class<?> cls) {
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent, 16384)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo != null && cls.getCanonicalName().equals(activityInfo.name)) {
                return activityInfo;
            }
        }
        return null;
    }

    public static void a(Context context) {
        new Thread(new l(context)).start();
    }

    private static void a(Context context, String str, String str2) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(str);
        intent.setPackage(packageName);
        int i = 0;
        for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent, 16384)) {
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (activityInfo == null || TextUtils.isEmpty(activityInfo.name) || !activityInfo.name.equals(str2)) {
                i = 0;
                continue;
            } else {
                i = 1;
                continue;
            }
            if (i != 0) {
                break;
            }
        }
        if (i == 0) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", new Object[]{str2}));
        }
    }

    private static void a(ActivityInfo activityInfo, Boolean[] boolArr) {
        if (boolArr[0].booleanValue() != activityInfo.enabled) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.", new Object[]{activityInfo.name, boolArr[0]}));
        } else if (boolArr[1].booleanValue() != activityInfo.exported) {
            throw new a(String.format("<receiver android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.", new Object[]{activityInfo.name, boolArr[1]}));
        }
    }

    private static boolean a(PackageInfo packageInfo, String[] strArr) {
        for (ServiceInfo serviceInfo : packageInfo.services) {
            if (a(strArr, serviceInfo.name)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(String[] strArr, String str) {
        if (strArr == null || str == null) {
            return false;
        }
        for (CharSequence equals : strArr) {
            if (TextUtils.equals(equals, str)) {
                return true;
            }
        }
        return false;
    }

    private static void c(Context context) {
        ActivityInfo a;
        boolean z;
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(as.o);
        intent.setPackage(packageName);
        try {
            Boolean[] boolArr;
            a = a(packageManager, intent, Class.forName("com.xiaomi.push.service.receivers.PingReceiver"));
            if (MiPushClient.shouldUseMIUIPush(context)) {
                if (a != null) {
                    boolArr = new Boolean[]{Boolean.valueOf(true), Boolean.valueOf(false)};
                }
                intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent.setPackage(packageName);
                z = false;
                for (ResolveInfo resolveInfo : packageManager.queryBroadcastReceivers(intent, 16384)) {
                    a = resolveInfo.activityInfo;
                    if (a != null) {
                        try {
                            if (!TextUtils.isEmpty(a.name) && PushMessageReceiver.class.isAssignableFrom(Class.forName(a.name)) && a.enabled) {
                                z = true;
                                if (!z) {
                                    break;
                                }
                            }
                        } catch (Throwable e) {
                            b.a(e);
                        }
                    }
                    z = false;
                    if (!z) {
                        break;
                    }
                }
                if (!z) {
                    throw new a("Receiver: none of the subclasses of PushMessageReceiver is enabled or defined.");
                } else if (MiPushClient.getOpenHmsPush()) {
                    a(context, "com.huawei.android.push.intent.RECEIVE", "com.xiaomi.assemble.control.HmsPushReceiver");
                    a(context, "com.huawei.intent.action.PUSH", "com.huawei.hms.support.api.push.PushEventReceiver");
                }
            } else if (a == null) {
                throw new a(String.format("<receiver android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.", new Object[]{"com.xiaomi.push.service.receivers.PingReceiver"}));
            } else {
                boolArr = new Boolean[]{Boolean.valueOf(true), Boolean.valueOf(false)};
            }
            a(a, boolArr);
        } catch (Throwable e2) {
            b.a(e2);
        }
        intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(packageName);
        z = false;
        while (r0.hasNext()) {
            a = resolveInfo.activityInfo;
            if (a != null) {
                z = true;
                if (!z) {
                    break;
                }
            }
            z = false;
            if (!z) {
                break;
            }
        }
        if (!z) {
            throw new a("Receiver: none of the subclasses of PushMessageReceiver is enabled or defined.");
        } else if (MiPushClient.getOpenHmsPush()) {
            a(context, "com.huawei.android.push.intent.RECEIVE", "com.xiaomi.assemble.control.HmsPushReceiver");
            a(context, "com.huawei.intent.action.PUSH", "com.huawei.hms.support.api.push.PushEventReceiver");
        }
    }

    private static void c(Context context, PackageInfo packageInfo) {
        int i;
        Set hashSet = new HashSet();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getPackageName());
        stringBuilder.append(".permission.MIPUSH_RECEIVE");
        hashSet.addAll(Arrays.asList(new String[]{MsgConstant.PERMISSION_INTERNET, MsgConstant.PERMISSION_ACCESS_NETWORK_STATE, stringBuilder.toString(), MsgConstant.PERMISSION_ACCESS_WIFI_STATE, MsgConstant.PERMISSION_READ_PHONE_STATE, MsgConstant.PERMISSION_GET_TASKS, "android.permission.VIBRATE"}));
        if (packageInfo.permissions != null) {
            for (PermissionInfo permissionInfo : packageInfo.permissions) {
                if (r7.equals(permissionInfo.name)) {
                    i = 1;
                    break;
                }
            }
        }
        i = 0;
        if (i == 0) {
            throw new a(String.format("<permission android:name=\"%1$s\" .../> is undefined in AndroidManifest.", new Object[]{r7}));
        }
        if (packageInfo.requestedPermissions != null) {
            for (CharSequence charSequence : packageInfo.requestedPermissions) {
                if (!TextUtils.isEmpty(charSequence) && hashSet.contains(charSequence)) {
                    hashSet.remove(charSequence);
                    if (hashSet.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (!hashSet.isEmpty()) {
            throw new a(String.format("<uses-permission android:name=\"%1$s\"/> is missing in AndroidManifest.", new Object[]{hashSet.iterator().next()}));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void d(android.content.Context r11, android.content.pm.PackageInfo r12) {
        /*
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = new java.util.HashMap;
        r1.<init>();
        r2 = com.xiaomi.mipush.sdk.PushMessageHandler.class;
        r2 = r2.getCanonicalName();
        r3 = new com.xiaomi.mipush.sdk.k$b;
        r4 = com.xiaomi.mipush.sdk.PushMessageHandler.class;
        r4 = r4.getCanonicalName();
        r5 = "";
        r6 = 1;
        r3.<init>(r4, r6, r6, r5);
        r1.put(r2, r3);
        r2 = com.xiaomi.mipush.sdk.MessageHandleService.class;
        r2 = r2.getCanonicalName();
        r3 = new com.xiaomi.mipush.sdk.k$b;
        r4 = com.xiaomi.mipush.sdk.MessageHandleService.class;
        r4 = r4.getCanonicalName();
        r5 = "";
        r7 = 0;
        r3.<init>(r4, r6, r7, r5);
        r1.put(r2, r3);
        r11 = com.xiaomi.mipush.sdk.MiPushClient.shouldUseMIUIPush(r11);
        r2 = 2;
        if (r11 == 0) goto L_0x004f;
    L_0x003f:
        r11 = new java.lang.String[r2];
        r3 = "com.xiaomi.push.service.XMJobService";
        r11[r7] = r3;
        r3 = "com.xiaomi.push.service.XMPushService";
        r11[r6] = r3;
        r11 = a(r12, r11);
        if (r11 == 0) goto L_0x006b;
    L_0x004f:
        r11 = "com.xiaomi.push.service.XMJobService";
        r3 = new com.xiaomi.mipush.sdk.k$b;
        r4 = "com.xiaomi.push.service.XMJobService";
        r5 = "android.permission.BIND_JOB_SERVICE";
        r3.<init>(r4, r6, r7, r5);
        r1.put(r11, r3);
        r11 = "com.xiaomi.push.service.XMPushService";
        r3 = new com.xiaomi.mipush.sdk.k$b;
        r4 = "com.xiaomi.push.service.XMPushService";
        r5 = "";
        r3.<init>(r4, r6, r7, r5);
        r1.put(r11, r3);
    L_0x006b:
        r11 = r12.services;
        if (r11 == 0) goto L_0x0100;
    L_0x006f:
        r11 = r12.services;
        r12 = r11.length;
        r3 = r7;
    L_0x0073:
        if (r3 >= r12) goto L_0x0100;
    L_0x0075:
        r4 = r11[r3];
        r5 = r4.name;
        r5 = android.text.TextUtils.isEmpty(r5);
        if (r5 != 0) goto L_0x00fc;
    L_0x007f:
        r5 = r4.name;
        r5 = r1.containsKey(r5);
        if (r5 == 0) goto L_0x00fc;
    L_0x0087:
        r5 = r4.name;
        r5 = r1.remove(r5);
        r5 = (com.xiaomi.mipush.sdk.k.b) r5;
        r8 = r5.b;
        r9 = r5.c;
        r5 = r5.d;
        r10 = r4.enabled;
        if (r8 == r10) goto L_0x00b1;
    L_0x0099:
        r11 = new com.xiaomi.mipush.sdk.k$a;
        r12 = "<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong enabled attribute, which should be android:enabled=%2$b.";
        r0 = new java.lang.Object[r2];
        r1 = r4.name;
        r0[r7] = r1;
        r1 = java.lang.Boolean.valueOf(r8);
        r0[r6] = r1;
        r12 = java.lang.String.format(r12, r0);
        r11.<init>(r12);
        throw r11;
    L_0x00b1:
        r8 = r4.exported;
        if (r9 == r8) goto L_0x00cd;
    L_0x00b5:
        r11 = new com.xiaomi.mipush.sdk.k$a;
        r12 = "<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong exported attribute, which should be android:exported=%2$b.";
        r0 = new java.lang.Object[r2];
        r1 = r4.name;
        r0[r7] = r1;
        r1 = java.lang.Boolean.valueOf(r9);
        r0[r6] = r1;
        r12 = java.lang.String.format(r12, r0);
        r11.<init>(r12);
        throw r11;
    L_0x00cd:
        r8 = android.text.TextUtils.isEmpty(r5);
        if (r8 != 0) goto L_0x00ef;
    L_0x00d3:
        r8 = r4.permission;
        r8 = android.text.TextUtils.equals(r5, r8);
        if (r8 != 0) goto L_0x00ef;
    L_0x00db:
        r11 = new com.xiaomi.mipush.sdk.k$a;
        r12 = "<service android:name=\"%1$s\" .../> in AndroidManifest had the wrong permission attribute, which should be android:permission=\"%2$s\".";
        r0 = new java.lang.Object[r2];
        r1 = r4.name;
        r0[r7] = r1;
        r0[r6] = r5;
        r12 = java.lang.String.format(r12, r0);
        r11.<init>(r12);
        throw r11;
    L_0x00ef:
        r5 = r4.name;
        r4 = r4.processName;
        r0.put(r5, r4);
        r4 = r1.isEmpty();
        if (r4 != 0) goto L_0x0100;
    L_0x00fc:
        r3 = r3 + 1;
        goto L_0x0073;
    L_0x0100:
        r11 = r1.isEmpty();
        if (r11 != 0) goto L_0x0122;
    L_0x0106:
        r11 = new com.xiaomi.mipush.sdk.k$a;
        r12 = "<service android:name=\"%1$s\" .../> is missing or disabled in AndroidManifest.";
        r0 = new java.lang.Object[r6];
        r1 = r1.keySet();
        r1 = r1.iterator();
        r1 = r1.next();
        r0[r7] = r1;
        r12 = java.lang.String.format(r12, r0);
        r11.<init>(r12);
        throw r11;
    L_0x0122:
        r11 = com.xiaomi.mipush.sdk.PushMessageHandler.class;
        r11 = r11.getCanonicalName();
        r11 = r0.get(r11);
        r11 = (java.lang.CharSequence) r11;
        r12 = com.xiaomi.mipush.sdk.MessageHandleService.class;
        r12 = r12.getCanonicalName();
        r12 = r0.get(r12);
        r12 = (java.lang.CharSequence) r12;
        r11 = android.text.TextUtils.equals(r11, r12);
        if (r11 != 0) goto L_0x015e;
    L_0x0140:
        r11 = new com.xiaomi.mipush.sdk.k$a;
        r12 = "\"%1$s\" and \"%2$s\" must be running in the same process.";
        r0 = new java.lang.Object[r2];
        r1 = com.xiaomi.mipush.sdk.PushMessageHandler.class;
        r1 = r1.getCanonicalName();
        r0[r7] = r1;
        r1 = com.xiaomi.mipush.sdk.MessageHandleService.class;
        r1 = r1.getCanonicalName();
        r0[r6] = r1;
        r12 = java.lang.String.format(r12, r0);
        r11.<init>(r12);
        throw r11;
    L_0x015e:
        r11 = "com.xiaomi.push.service.XMJobService";
        r11 = r0.containsKey(r11);
        if (r11 == 0) goto L_0x019a;
    L_0x0166:
        r11 = "com.xiaomi.push.service.XMPushService";
        r11 = r0.containsKey(r11);
        if (r11 == 0) goto L_0x019a;
    L_0x016e:
        r11 = "com.xiaomi.push.service.XMJobService";
        r11 = r0.get(r11);
        r11 = (java.lang.CharSequence) r11;
        r12 = "com.xiaomi.push.service.XMPushService";
        r12 = r0.get(r12);
        r12 = (java.lang.CharSequence) r12;
        r11 = android.text.TextUtils.equals(r11, r12);
        if (r11 != 0) goto L_0x019a;
    L_0x0184:
        r11 = new com.xiaomi.mipush.sdk.k$a;
        r12 = "\"%1$s\" and \"%2$s\" must be running in the same process.";
        r0 = new java.lang.Object[r2];
        r1 = "com.xiaomi.push.service.XMJobService";
        r0[r7] = r1;
        r1 = "com.xiaomi.push.service.XMPushService";
        r0[r6] = r1;
        r12 = java.lang.String.format(r12, r0);
        r11.<init>(r12);
        throw r11;
    L_0x019a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.k.d(android.content.Context, android.content.pm.PackageInfo):void");
    }
}
