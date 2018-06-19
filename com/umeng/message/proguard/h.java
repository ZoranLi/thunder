package com.umeng.message.proguard;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.widget.Toast;
import com.alipay.sdk.data.a;
import com.igexin.sdk.PushConsts;
import com.taobao.accs.common.Constants;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengMessageCallbackHandlerService;
import com.umeng.message.common.UmLog;
import com.umeng.message.entity.Ucode;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.agoo.common.AgooConstants;

/* compiled from: Helper */
public class h {
    public static final String a = System.getProperty("line.separator");
    private static final String b = "Helper";
    private static final AtomicInteger c = new AtomicInteger(1);

    /* compiled from: Helper */
    final class AnonymousClass10 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass10(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please add or correct UmengMessageCallbackHandlerService in AndroidManifest!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass11 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass11(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please add or correct UmengMessageCallbackHandlerService in AndroidManifest!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass12 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass12(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please set umeng appsecret!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass13 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass13(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please add or correct UmengMessageCallbackHandlerService in AndroidManifest!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass14 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass14(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please add or correct UmengDownloadResourceService in AndroidManifest!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass15 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass15(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please add or correct UmengMessageIntentReceiverService in AndroidManifest!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass16 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass16(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please add required permission in AndroidManifest!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass17 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ Handler b;

        AnonymousClass17(Context context, Handler handler) {
            this.a = context;
            this.b = handler;
        }

        public final void run() {
            if (MessageSharedPrefs.getInstance(this.a).getRegisterTimes() <= 1) {
                UmLog.e(h.b, "mPushAgent.register should be called in both main process and channel process!");
                for (int i = 0; i < 3; i++) {
                    this.b.postDelayed(new Runnable(this) {
                        final /* synthetic */ AnonymousClass17 a;

                        {
                            this.a = r1;
                        }

                        public void run() {
                            Toast.makeText(this.a.a, "mPushAgent.register should be called in both main process and channel process!", 1).show();
                        }
                    }, (long) (a.a * i));
                }
            }
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass18 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass18(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please add or correct ChannelService in AndroidManifest!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass19 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass19(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please add or correct ChannelService in AndroidManifest!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass1(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please set umeng appkey!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass20 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass20(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please add or correct MsgDistributeService in AndroidManifest!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass21 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass21(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please add or correct EventReceiver in AndroidManifest!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass22 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass22(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please add or correct EventReceiver in AndroidManifest!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass23 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass23(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please add or correct EventReceiver in AndroidManifest!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass24 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass24(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please add or correct EventReceiver in AndroidManifest!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass2(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please add or correct ServiceReceiver in AndroidManifest!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass3(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please add or correct ServiceReceiver in AndroidManifest!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass4 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass4(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please add or correct AgooService in AndroidManifest!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass5 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass5(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please add or correct UmengIntentService in AndroidManifest!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass6 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass6(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please replace '${applicationId}.intent.action.COMMAND' with application's applicationId for AgooCommondReceiver in AndroidManifest!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass7 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass7(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please add or correct AgooCommondReceiver in AndroidManifest!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass8 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass8(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please add or correct NotificationProxyBroadcastReceiver in AndroidManifest!", 1).show();
        }
    }

    /* compiled from: Helper */
    final class AnonymousClass9 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass9(Context context) {
            this.a = context;
        }

        public final void run() {
            Toast.makeText(this.a, "Please add or correct UmengMessageCallbackHandlerService in AndroidManifest!", 1).show();
        }
    }

    public static java.lang.String a(java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r7 != 0) goto L_0x0004;
    L_0x0002:
        r7 = 0;
        return r7;
    L_0x0004:
        r0 = r7.getBytes();	 Catch:{ Exception -> 0x003e }
        r1 = "MD5";	 Catch:{ Exception -> 0x003e }
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ Exception -> 0x003e }
        r1.reset();	 Catch:{ Exception -> 0x003e }
        r1.update(r0);	 Catch:{ Exception -> 0x003e }
        r0 = r1.digest();	 Catch:{ Exception -> 0x003e }
        r1 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x003e }
        r1.<init>();	 Catch:{ Exception -> 0x003e }
        r2 = 0;	 Catch:{ Exception -> 0x003e }
        r3 = r2;	 Catch:{ Exception -> 0x003e }
    L_0x001f:
        r4 = r0.length;	 Catch:{ Exception -> 0x003e }
        if (r3 >= r4) goto L_0x0039;	 Catch:{ Exception -> 0x003e }
    L_0x0022:
        r4 = "%02X";	 Catch:{ Exception -> 0x003e }
        r5 = 1;	 Catch:{ Exception -> 0x003e }
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x003e }
        r6 = r0[r3];	 Catch:{ Exception -> 0x003e }
        r6 = java.lang.Byte.valueOf(r6);	 Catch:{ Exception -> 0x003e }
        r5[r2] = r6;	 Catch:{ Exception -> 0x003e }
        r4 = java.lang.String.format(r4, r5);	 Catch:{ Exception -> 0x003e }
        r1.append(r4);	 Catch:{ Exception -> 0x003e }
        r3 = r3 + 1;	 Catch:{ Exception -> 0x003e }
        goto L_0x001f;	 Catch:{ Exception -> 0x003e }
    L_0x0039:
        r0 = r1.toString();	 Catch:{ Exception -> 0x003e }
        return r0;
    L_0x003e:
        r0 = "[^[a-z][A-Z][0-9][.][_]]";
        r1 = "";
        r7 = r7.replaceAll(r0, r1);
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.h.a(java.lang.String):java.lang.String");
    }

    public static String b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            str = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : str) {
                stringBuffer.append(Integer.toHexString(255 & b));
            }
            return stringBuffer.toString();
        } catch (String str2) {
            UmLog.i(b, "getMD5 error", str2);
            return "";
        }
    }

    public static String a(File file) {
        byte[] bArr = new byte[1024];
        try {
            if (!file.isFile()) {
                return "";
            }
            MessageDigest instance = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    BigInteger bigInteger = new BigInteger(1, instance.digest());
                    return String.format("%1$032x", new Object[]{bigInteger});
                }
            }
        } catch (File file2) {
            file2.printStackTrace();
            return null;
        }
    }

    public static String a(Context context, long j) {
        if (j < 1000) {
            context = new StringBuilder();
            context.append((int) j);
            context.append("B");
            return context.toString();
        } else if (j < 1000000) {
            context = new StringBuilder();
            context.append(Math.round(((double) ((float) j)) / 4652007308841189376L));
            context.append("K");
            return context.toString();
        } else if (j < 1000000000) {
            context = new DecimalFormat("#0.0");
            r0 = new StringBuilder();
            r0.append(context.format(((double) ((float) j)) / 4696837146684686336L));
            r0.append("M");
            return r0.toString();
        } else {
            context = new DecimalFormat("#0.00");
            r0 = new StringBuilder();
            r0.append(context.format(((double) ((float) j)) / 4741671816366391296L));
            r0.append("G");
            return r0.toString();
        }
    }

    public static java.lang.String c(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.Long.valueOf(r5);	 Catch:{ NumberFormatException -> 0x0095 }
        r0 = r0.longValue();	 Catch:{ NumberFormatException -> 0x0095 }
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r5 >= 0) goto L_0x0021;
    L_0x000e:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = (int) r0;
        r5.append(r0);
        r0 = "B";
        r5.append(r0);
        r5 = r5.toString();
        goto L_0x0094;
    L_0x0021:
        r2 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
        r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r5 >= 0) goto L_0x004a;
    L_0x0028:
        r5 = new java.text.DecimalFormat;
        r2 = "#0.00";
        r5.<init>(r2);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r0 = (float) r0;
        r0 = (double) r0;
        r3 = 4652218415073722368; // 0x4090000000000000 float:0.0 double:1024.0;
        r0 = r0 / r3;
        r5 = r5.format(r0);
        r2.append(r5);
        r5 = "K";
        r2.append(r5);
        r5 = r2.toString();
        goto L_0x0094;
    L_0x004a:
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r5 >= 0) goto L_0x0073;
    L_0x0051:
        r5 = new java.text.DecimalFormat;
        r2 = "#0.00";
        r5.<init>(r2);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r0 = (float) r0;
        r0 = (double) r0;
        r3 = 4697254411347427328; // 0x4130000000000000 float:0.0 double:1048576.0;
        r0 = r0 / r3;
        r5 = r5.format(r0);
        r2.append(r5);
        r5 = "M";
        r2.append(r5);
        r5 = r2.toString();
        goto L_0x0094;
    L_0x0073:
        r5 = new java.text.DecimalFormat;
        r2 = "#0.00";
        r5.<init>(r2);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r0 = (float) r0;
        r0 = (double) r0;
        r3 = 4742290407621132288; // 0x41d0000000000000 float:0.0 double:1.073741824E9;
        r0 = r0 / r3;
        r5 = r5.format(r0);
        r2.append(r5);
        r5 = "G";
        r2.append(r5);
        r5 = r2.toString();
    L_0x0094:
        return r5;
    L_0x0095:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.h.c(java.lang.String):java.lang.String");
    }

    public static void a(Context context, String str) {
        context.startActivity(context.getPackageManager().getLaunchIntentForPackage(str));
    }

    public static boolean b(Context context, String str) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        }
    }

    public static boolean d(String str) {
        if (str != null) {
            if (str.length() != null) {
                return null;
            }
        }
        return true;
    }

    public static boolean e(String str) {
        if (d(str)) {
            return false;
        }
        str = str.trim().toLowerCase(Locale.US);
        if (!str.startsWith("http://")) {
            if (str.startsWith("https://") == null) {
                return false;
            }
        }
        return true;
    }

    public static String a() {
        return a(new Date());
    }

    public static String a(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static boolean a(Context context) {
        try {
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            context = context.getPackageName();
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(context)) {
                    return true;
                }
            }
            return false;
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static void b(java.io.InputStream r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0006;
    L_0x0002:
        r0.close();	 Catch:{ Exception -> 0x0006 }
        return;
    L_0x0006:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.h.b(java.io.InputStream):void");
    }

    public static void a(java.io.OutputStream r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0006;
    L_0x0002:
        r0.close();	 Catch:{ Exception -> 0x0006 }
        return;
    L_0x0006:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.h.a(java.io.OutputStream):void");
    }

    public static boolean b(Context context) {
        String packageName = ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getPackageName();
        if (packageName == null || packageName.equals(context.getPackageName()) == null) {
            return false;
        }
        return true;
    }

    public static boolean c(Context context) {
        return context.getPackageManager().checkPermission(MsgConstant.PERMISSION_GET_TASKS, context.getPackageName()) == null ? true : null;
    }

    public static boolean c(Context context, String str) {
        List runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
        boolean z = false;
        if (runningServices != null) {
            if (!runningServices.isEmpty()) {
                int i = 0;
                while (i < runningServices.size()) {
                    if (((RunningServiceInfo) runningServices.get(i)).service.getClassName().equals(str) && TextUtils.equals(((RunningServiceInfo) runningServices.get(i)).service.getPackageName(), context.getPackageName())) {
                        z = true;
                        break;
                    }
                    i++;
                }
                return z;
            }
        }
        return false;
    }

    public static String a(Context context, int i) {
        Context<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return "";
        }
        for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == i) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    public static void a(android.content.Context r2, java.lang.Class<?> r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r2.getPackageManager();	 Catch:{ Throwable -> 0x0026 }
        if (r0 != 0) goto L_0x0007;	 Catch:{ Throwable -> 0x0026 }
    L_0x0006:
        return;	 Catch:{ Throwable -> 0x0026 }
    L_0x0007:
        r1 = r2.getPackageName();	 Catch:{ Throwable -> 0x0026 }
        r1 = r0.getApplicationEnabledSetting(r1);	 Catch:{ Throwable -> 0x0026 }
        if (r1 >= 0) goto L_0x0012;	 Catch:{ Throwable -> 0x0026 }
    L_0x0011:
        return;	 Catch:{ Throwable -> 0x0026 }
    L_0x0012:
        r1 = new android.content.ComponentName;	 Catch:{ Throwable -> 0x0026 }
        r1.<init>(r2, r3);	 Catch:{ Throwable -> 0x0026 }
        r2 = r0.getComponentEnabledSetting(r1);	 Catch:{ Throwable -> 0x0026 }
        r3 = 1;	 Catch:{ Throwable -> 0x0026 }
        if (r2 == r3) goto L_0x0025;	 Catch:{ Throwable -> 0x0026 }
    L_0x001e:
        if (r2 != 0) goto L_0x0021;	 Catch:{ Throwable -> 0x0026 }
    L_0x0020:
        goto L_0x0025;	 Catch:{ Throwable -> 0x0026 }
    L_0x0021:
        r0.setComponentEnabledSetting(r1, r3, r3);	 Catch:{ Throwable -> 0x0026 }
        return;
    L_0x0025:
        return;
    L_0x0026:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.h.a(android.content.Context, java.lang.Class):void");
    }

    public static final void b(android.content.Context r3, java.lang.Class<?> r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r3 == 0) goto L_0x0037;
    L_0x0002:
        r0 = r3.getPackageManager();	 Catch:{ Throwable -> 0x0037 }
        if (r4 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r1 = new android.content.ComponentName;	 Catch:{ Throwable -> 0x0036 }
        r1.<init>(r3, r4);	 Catch:{ Throwable -> 0x0036 }
        r3 = r0.getComponentEnabledSetting(r1);	 Catch:{ Throwable -> 0x0036 }
        r4 = 2;	 Catch:{ Throwable -> 0x0036 }
        if (r3 != r4) goto L_0x0035;	 Catch:{ Throwable -> 0x0036 }
    L_0x0015:
        r3 = "Helper";	 Catch:{ Throwable -> 0x0036 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0036 }
        r2 = "rebootReceiver[";	 Catch:{ Throwable -> 0x0036 }
        r4.<init>(r2);	 Catch:{ Throwable -> 0x0036 }
        r2 = r1.toString();	 Catch:{ Throwable -> 0x0036 }
        r4.append(r2);	 Catch:{ Throwable -> 0x0036 }
        r2 = "]--->[ENABLED]";	 Catch:{ Throwable -> 0x0036 }
        r4.append(r2);	 Catch:{ Throwable -> 0x0036 }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x0036 }
        com.umeng.message.common.UmLog.d(r3, r4);	 Catch:{ Throwable -> 0x0036 }
        r3 = 1;	 Catch:{ Throwable -> 0x0036 }
        r0.setComponentEnabledSetting(r1, r3, r3);	 Catch:{ Throwable -> 0x0036 }
    L_0x0035:
        return;
    L_0x0036:
        return;
    L_0x0037:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.h.b(android.content.Context, java.lang.Class):void");
    }

    public static Object f(String str) {
        try {
            try {
                return new ObjectInputStream(new ByteArrayInputStream(d.h(str.getBytes()))).readObject();
            } catch (String str2) {
                str2.printStackTrace();
                return null;
            }
        } catch (String str22) {
            str22.printStackTrace();
        } catch (String str222) {
            str222.printStackTrace();
        }
    }

    public static java.lang.String a(java.lang.Object r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.io.ByteArrayOutputStream;
        r0.<init>();
        r1 = new java.io.ObjectOutputStream;	 Catch:{ IOException -> 0x001b }
        r1.<init>(r0);	 Catch:{ IOException -> 0x001b }
        r1.writeObject(r2);	 Catch:{ IOException -> 0x001b }
        r2 = new java.lang.String;	 Catch:{ IOException -> 0x001b }
        r0 = r0.toByteArray();	 Catch:{ IOException -> 0x001b }
        r0 = com.umeng.message.proguard.d.c(r0);	 Catch:{ IOException -> 0x001b }
        r2.<init>(r0);	 Catch:{ IOException -> 0x001b }
        goto L_0x001c;
    L_0x001b:
        r2 = 0;
    L_0x001c:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.h.a(java.lang.Object):java.lang.String");
    }

    public static String b() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static boolean a(Context context, Handler handler) {
        Context context2 = context;
        Handler handler2 = handler;
        if (!PushAgent.getInstance(context).isPushCheck()) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(PushAgent.getInstance(context).getMessageAppkey())) {
                handler2.post(new AnonymousClass1(context2));
                return false;
            } else if (TextUtils.isEmpty(PushAgent.getInstance(context).getMessageSecret())) {
                handler2.post(new AnonymousClass12(context2));
                return false;
            } else {
                CharSequence charSequence;
                boolean z;
                Intent intent = new Intent();
                intent.setPackage(context.getPackageName());
                intent.setAction(Constants.ACTION_SERVICE);
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentServices(intent, 64)) {
                    if (resolveInfo.serviceInfo.name.equals(com.taobao.accs.utl.a.channelService)) {
                        charSequence = resolveInfo.serviceInfo.processName;
                        if (!(TextUtils.isEmpty(charSequence) || TextUtils.equals(charSequence, context.getPackageName()) || !resolveInfo.serviceInfo.exported)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    intent = new Intent();
                    intent.setPackage(context.getPackageName());
                    intent.setAction("com.taobao.accs.intent.action.ELECTION");
                    for (ResolveInfo resolveInfo2 : context.getPackageManager().queryIntentServices(intent, 64)) {
                        if (resolveInfo2.serviceInfo.name.equals(com.taobao.accs.utl.a.channelService)) {
                            charSequence = resolveInfo2.serviceInfo.processName;
                            if (!(TextUtils.isEmpty(charSequence) || TextUtils.equals(charSequence, context.getPackageName()) || !resolveInfo2.serviceInfo.exported)) {
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    if (z) {
                        intent = new Intent();
                        intent.setPackage(context.getPackageName());
                        intent.setAction(Constants.ACTION_RECEIVE);
                        for (ResolveInfo resolveInfo22 : context.getPackageManager().queryIntentServices(intent, 64)) {
                            if (resolveInfo22.serviceInfo.name.equals(com.taobao.accs.utl.a.msgService) && resolveInfo22.serviceInfo.exported) {
                                z = true;
                                break;
                            }
                        }
                        z = false;
                        if (z) {
                            CharSequence charSequence2;
                            intent = new Intent();
                            intent.setPackage(context.getPackageName());
                            intent.setAction(PushConsts.ACTION_BROADCAST_TO_BOOT);
                            for (ResolveInfo resolveInfo222 : context.getPackageManager().queryBroadcastReceivers(intent, 64)) {
                                if (resolveInfo222.activityInfo.name.equals("com.taobao.accs.EventReceiver")) {
                                    charSequence2 = resolveInfo222.activityInfo.processName;
                                    if (!(TextUtils.isEmpty(charSequence2) || TextUtils.equals(charSequence2, context.getPackageName()))) {
                                        z = true;
                                        break;
                                    }
                                }
                            }
                            z = false;
                            if (z) {
                                intent = new Intent();
                                intent.setPackage(context.getPackageName());
                                intent.setAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
                                for (ResolveInfo resolveInfo2222 : context.getPackageManager().queryBroadcastReceivers(intent, 64)) {
                                    if (resolveInfo2222.activityInfo.name.equals("com.taobao.accs.EventReceiver")) {
                                        charSequence2 = resolveInfo2222.activityInfo.processName;
                                        if (!(TextUtils.isEmpty(charSequence2) || TextUtils.equals(charSequence2, context.getPackageName()))) {
                                            z = true;
                                            break;
                                        }
                                    }
                                }
                                z = false;
                                if (z) {
                                    intent = new Intent();
                                    intent.setPackage(context.getPackageName());
                                    intent.setAction("android.intent.action.PACKAGE_REMOVED");
                                    intent.setData(Uri.parse("package:"));
                                    for (ResolveInfo resolveInfo22222 : context.getPackageManager().queryBroadcastReceivers(intent, 64)) {
                                        if (resolveInfo22222.activityInfo.name.equals("com.taobao.accs.EventReceiver")) {
                                            charSequence2 = resolveInfo22222.activityInfo.processName;
                                            if (!(TextUtils.isEmpty(charSequence2) || TextUtils.equals(charSequence2, context.getPackageName()))) {
                                                z = true;
                                                break;
                                            }
                                        }
                                    }
                                    z = false;
                                    if (z) {
                                        intent = new Intent();
                                        intent.setPackage(context.getPackageName());
                                        intent.setAction(PushConsts.ACTION_BROADCAST_USER_PRESENT);
                                        for (ResolveInfo resolveInfo222222 : context.getPackageManager().queryBroadcastReceivers(intent, 64)) {
                                            if (resolveInfo222222.activityInfo.name.equals("com.taobao.accs.EventReceiver")) {
                                                charSequence2 = resolveInfo222222.activityInfo.processName;
                                                if (!(TextUtils.isEmpty(charSequence2) || TextUtils.equals(charSequence2, context.getPackageName()))) {
                                                    z = true;
                                                    break;
                                                }
                                            }
                                        }
                                        z = false;
                                        if (z) {
                                            intent = new Intent();
                                            intent.setPackage(context.getPackageName());
                                            intent.setAction(Constants.ACTION_COMMAND);
                                            for (ResolveInfo resolveInfo2222222 : context.getPackageManager().queryBroadcastReceivers(intent, 64)) {
                                                if (resolveInfo2222222.activityInfo.name.equals("com.taobao.accs.ServiceReceiver")) {
                                                    charSequence2 = resolveInfo2222222.activityInfo.processName;
                                                    if (!(TextUtils.isEmpty(charSequence2) || TextUtils.equals(charSequence2, context.getPackageName()))) {
                                                        z = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            z = false;
                                            if (z) {
                                                intent = new Intent();
                                                intent.setPackage(context.getPackageName());
                                                intent.setAction(Constants.ACTION_START_FROM_AGOO);
                                                for (ResolveInfo resolveInfo22222222 : context.getPackageManager().queryBroadcastReceivers(intent, 64)) {
                                                    if (resolveInfo22222222.activityInfo.name.equals("com.taobao.accs.ServiceReceiver")) {
                                                        charSequence2 = resolveInfo22222222.activityInfo.processName;
                                                        if (!(TextUtils.isEmpty(charSequence2) || TextUtils.equals(charSequence2, context.getPackageName()))) {
                                                            z = true;
                                                            break;
                                                        }
                                                    }
                                                }
                                                z = false;
                                                if (z) {
                                                    intent = new Intent();
                                                    intent.setPackage(context.getPackageName());
                                                    intent.setAction(Constants.ACTION_RECEIVE);
                                                    for (ResolveInfo resolveInfo222222222 : context.getPackageManager().queryIntentServices(intent, 64)) {
                                                        if (resolveInfo222222222.serviceInfo.name.equals("org.android.agoo.accs.AgooService") && resolveInfo222222222.serviceInfo.exported) {
                                                            z = true;
                                                            break;
                                                        }
                                                    }
                                                    z = false;
                                                    if (z) {
                                                        intent = new Intent();
                                                        intent.setPackage(context.getPackageName());
                                                        intent.setAction(AgooConstants.INTENT_FROM_AGOO_MESSAGE);
                                                        for (ResolveInfo resolveInfo2222222222 : context.getPackageManager().queryIntentServices(intent, 64)) {
                                                            if (resolveInfo2222222222.serviceInfo.name.equals("com.umeng.message.UmengIntentService") && resolveInfo2222222222.serviceInfo.exported) {
                                                                z = true;
                                                                break;
                                                            }
                                                        }
                                                        z = false;
                                                        if (z) {
                                                            intent = new Intent();
                                                            intent.setPackage(context.getPackageName());
                                                            StringBuilder stringBuilder = new StringBuilder();
                                                            stringBuilder.append(context.getPackageName());
                                                            stringBuilder.append(".intent.action.COMMAND");
                                                            intent.setAction(stringBuilder.toString());
                                                            for (ResolveInfo resolveInfo22222222222 : context.getPackageManager().queryBroadcastReceivers(intent, 64)) {
                                                                if (resolveInfo22222222222.activityInfo.name.equals("com.taobao.agoo.AgooCommondReceiver") && resolveInfo22222222222.activityInfo.exported) {
                                                                    z = true;
                                                                    break;
                                                                }
                                                            }
                                                            z = false;
                                                            if (z) {
                                                                intent = new Intent();
                                                                intent.setPackage(context.getPackageName());
                                                                intent.setAction("android.intent.action.PACKAGE_REMOVED");
                                                                intent.setData(Uri.parse("package:"));
                                                                for (ResolveInfo resolveInfo222222222222 : context.getPackageManager().queryBroadcastReceivers(intent, 64)) {
                                                                    if (resolveInfo222222222222.activityInfo.name.equals("com.taobao.agoo.AgooCommondReceiver") && resolveInfo222222222222.activityInfo.exported) {
                                                                        z = true;
                                                                        break;
                                                                    }
                                                                }
                                                                z = false;
                                                                if (z) {
                                                                    intent = new Intent();
                                                                    intent.setClassName(context.getPackageName(), "com.umeng.message.NotificationProxyBroadcastReceiver");
                                                                    for (ResolveInfo resolveInfo2222222222222 : context.getPackageManager().queryBroadcastReceivers(intent, 65536)) {
                                                                        if (resolveInfo2222222222222.activityInfo.name.equals("com.umeng.message.NotificationProxyBroadcastReceiver") && TextUtils.equals(resolveInfo2222222222222.activityInfo.processName, context.getPackageName()) && !resolveInfo2222222222222.activityInfo.exported) {
                                                                            z = true;
                                                                            break;
                                                                        }
                                                                    }
                                                                    z = false;
                                                                    if (z) {
                                                                        intent = new Intent();
                                                                        intent.setPackage(context.getPackageName());
                                                                        intent.setAction(MsgConstant.MESSAGE_REGISTER_CALLBACK_ACTION);
                                                                        for (ResolveInfo resolveInfo22222222222222 : context.getPackageManager().queryIntentServices(intent, 64)) {
                                                                            if (resolveInfo22222222222222.serviceInfo.name.equals(UmengMessageCallbackHandlerService.TAG) && TextUtils.equals(context.getPackageName(), resolveInfo22222222222222.serviceInfo.processName) && !resolveInfo22222222222222.serviceInfo.exported) {
                                                                                z = true;
                                                                                break;
                                                                            }
                                                                        }
                                                                        z = false;
                                                                        if (z) {
                                                                            intent = new Intent();
                                                                            intent.setPackage(context.getPackageName());
                                                                            intent.setAction(MsgConstant.MESSAGE_ENABLE_CALLBACK_ACTION);
                                                                            for (ResolveInfo resolveInfo222222222222222 : context.getPackageManager().queryIntentServices(intent, 64)) {
                                                                                if (resolveInfo222222222222222.serviceInfo.name.equals(UmengMessageCallbackHandlerService.TAG) && !resolveInfo222222222222222.serviceInfo.exported) {
                                                                                    z = true;
                                                                                    break;
                                                                                }
                                                                            }
                                                                            z = false;
                                                                            if (z) {
                                                                                intent = new Intent();
                                                                                intent.setPackage(context.getPackageName());
                                                                                intent.setAction(MsgConstant.MESSAGE_DISABLE_CALLBACK_ACTION);
                                                                                for (ResolveInfo resolveInfo2222222222222222 : context.getPackageManager().queryIntentServices(intent, 64)) {
                                                                                    if (resolveInfo2222222222222222.serviceInfo.name.equals(UmengMessageCallbackHandlerService.TAG) && !resolveInfo2222222222222222.serviceInfo.exported) {
                                                                                        z = true;
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                z = false;
                                                                                if (z) {
                                                                                    intent = new Intent();
                                                                                    intent.setPackage(context.getPackageName());
                                                                                    intent.setAction(MsgConstant.MESSAGE_MESSAGE_HANDLER_ACTION);
                                                                                    for (ResolveInfo resolveInfo22222222222222222 : context.getPackageManager().queryIntentServices(intent, 64)) {
                                                                                        if (resolveInfo22222222222222222.serviceInfo.name.equals(UmengMessageCallbackHandlerService.TAG) && !resolveInfo22222222222222222.serviceInfo.exported) {
                                                                                            z = true;
                                                                                            break;
                                                                                        }
                                                                                    }
                                                                                    z = false;
                                                                                    if (z) {
                                                                                        intent = new Intent();
                                                                                        intent.setClassName(context.getPackageName(), "com.umeng.message.UmengDownloadResourceService");
                                                                                        for (ResolveInfo resolveInfo222222222222222222 : context.getPackageManager().queryIntentServices(intent, 65536)) {
                                                                                            if (resolveInfo222222222222222222.serviceInfo.name.equals("com.umeng.message.UmengDownloadResourceService")) {
                                                                                                z = true;
                                                                                                break;
                                                                                            }
                                                                                        }
                                                                                        z = false;
                                                                                        if (z) {
                                                                                            intent = new Intent();
                                                                                            intent.setPackage(context.getPackageName());
                                                                                            intent.setAction(AgooConstants.BINDER_MSGRECEIVER_ACTION);
                                                                                            for (ResolveInfo resolveInfo2222222222222222222 : context.getPackageManager().queryIntentServices(intent, 64)) {
                                                                                                if (resolveInfo2222222222222222222.serviceInfo.name.equals("com.umeng.message.UmengMessageIntentReceiverService") && resolveInfo2222222222222222222.serviceInfo.exported) {
                                                                                                    charSequence2 = resolveInfo2222222222222222222.serviceInfo.processName;
                                                                                                    if (!(TextUtils.isEmpty(charSequence2) || TextUtils.equals(charSequence2, context.getPackageName()))) {
                                                                                                        z = true;
                                                                                                        break;
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            z = false;
                                                                                            if (z) {
                                                                                                int i;
                                                                                                int i2;
                                                                                                int i3;
                                                                                                int i4;
                                                                                                int i5;
                                                                                                int i6;
                                                                                                int i7;
                                                                                                int i8;
                                                                                                int i9;
                                                                                                int i10;
                                                                                                int i11;
                                                                                                int i12;
                                                                                                int i13;
                                                                                                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
                                                                                                if (packageInfo.requestedPermissions != null) {
                                                                                                    int i14 = 0;
                                                                                                    i = i14;
                                                                                                    i2 = i;
                                                                                                    i3 = i2;
                                                                                                    i4 = i3;
                                                                                                    i5 = i4;
                                                                                                    i6 = i5;
                                                                                                    i7 = i6;
                                                                                                    i8 = i7;
                                                                                                    i9 = i8;
                                                                                                    i10 = i9;
                                                                                                    i11 = i10;
                                                                                                    i12 = i11;
                                                                                                    i13 = i12;
                                                                                                    while (i14 < packageInfo.requestedPermissions.length) {
                                                                                                        if (MsgConstant.PERMISSION_INTERNET.equals(packageInfo.requestedPermissions[i14])) {
                                                                                                            i3 = 1;
                                                                                                        } else if (MsgConstant.PERMISSION_ACCESS_WIFI_STATE.equals(packageInfo.requestedPermissions[i14])) {
                                                                                                            i2 = 1;
                                                                                                        } else if (MsgConstant.PERMISSION_ACCESS_NETWORK_STATE.equals(packageInfo.requestedPermissions[i14])) {
                                                                                                            i = 1;
                                                                                                        } else if (MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE.equals(packageInfo.requestedPermissions[i14])) {
                                                                                                            i4 = 1;
                                                                                                        } else if (MsgConstant.PERMISSION_WAKE_LOCK.equals(packageInfo.requestedPermissions[i14])) {
                                                                                                            i5 = 1;
                                                                                                        } else if (MsgConstant.PERMISSION_READ_PHONE_STATE.equals(packageInfo.requestedPermissions[i14])) {
                                                                                                            i6 = 1;
                                                                                                        } else if (MsgConstant.PERMISSION_BROADCAST_PACKAGE_ADDED.equals(packageInfo.requestedPermissions[i14])) {
                                                                                                            i7 = 1;
                                                                                                        } else if (MsgConstant.PERMISSION_BROADCAST_PACKAGE_CHANGED.equals(packageInfo.requestedPermissions[i14])) {
                                                                                                            i8 = 1;
                                                                                                        } else if (MsgConstant.PERMISSION_BROADCAST_PACKAGE_INSTALL.equals(packageInfo.requestedPermissions[i14])) {
                                                                                                            i9 = 1;
                                                                                                        } else if (MsgConstant.PERMISSION_BROADCAST_PACKAGE_REPLACED.equals(packageInfo.requestedPermissions[i14])) {
                                                                                                            i10 = 1;
                                                                                                        } else if (MsgConstant.PERMISSION_RESTART_PACKAGES.equals(packageInfo.requestedPermissions[i14])) {
                                                                                                            i11 = 1;
                                                                                                        } else if (MsgConstant.PERMISSION_GET_TASKS.equals(packageInfo.requestedPermissions[i14])) {
                                                                                                            i12 = 1;
                                                                                                        } else if (MsgConstant.PERMISSION_RECEIVE_BOOT_COMPLETED.equals(packageInfo.requestedPermissions[i14])) {
                                                                                                            i13 = 1;
                                                                                                        }
                                                                                                        i14++;
                                                                                                    }
                                                                                                } else {
                                                                                                    i = 0;
                                                                                                    i2 = 0;
                                                                                                    i3 = 0;
                                                                                                    i4 = 0;
                                                                                                    i5 = 0;
                                                                                                    i6 = 0;
                                                                                                    i7 = 0;
                                                                                                    i8 = 0;
                                                                                                    i9 = 0;
                                                                                                    i10 = 0;
                                                                                                    i11 = 0;
                                                                                                    i12 = 0;
                                                                                                    i13 = 0;
                                                                                                }
                                                                                                Object obj = (i3 == 0 || i2 == 0 || i == 0 || i4 == 0 || i5 == 0 || i6 == 0 || i7 == 0 || i8 == 0 || i9 == 0 || i10 == 0 || i11 == 0 || i12 == 0 || i13 == 0) ? null : 1;
                                                                                                if (obj == null) {
                                                                                                    handler2.post(new AnonymousClass16(context2));
                                                                                                    return false;
                                                                                                }
                                                                                                return true;
                                                                                            }
                                                                                            handler2.post(new AnonymousClass15(context2));
                                                                                            return false;
                                                                                        }
                                                                                        handler2.post(new AnonymousClass14(context2));
                                                                                        return false;
                                                                                    }
                                                                                    handler2.post(new AnonymousClass13(context2));
                                                                                    return false;
                                                                                }
                                                                                handler2.post(new AnonymousClass11(context2));
                                                                                return false;
                                                                            }
                                                                            handler2.post(new AnonymousClass10(context2));
                                                                            return false;
                                                                        }
                                                                        handler2.post(new AnonymousClass9(context2));
                                                                        return false;
                                                                    }
                                                                    handler2.post(new AnonymousClass8(context2));
                                                                    return false;
                                                                }
                                                                handler2.post(new AnonymousClass7(context2));
                                                                return false;
                                                            }
                                                            handler2.post(new AnonymousClass6(context2));
                                                            return false;
                                                        }
                                                        handler2.post(new AnonymousClass5(context2));
                                                        return false;
                                                    }
                                                    handler2.post(new AnonymousClass4(context2));
                                                    return false;
                                                }
                                                handler2.post(new AnonymousClass3(context2));
                                                return false;
                                            }
                                            handler2.post(new AnonymousClass2(context2));
                                            return false;
                                        }
                                        handler2.post(new AnonymousClass24(context2));
                                        return false;
                                    }
                                    handler2.post(new AnonymousClass23(context2));
                                    return false;
                                }
                                handler2.post(new AnonymousClass22(context2));
                                return false;
                            }
                            handler2.post(new AnonymousClass21(context2));
                            return false;
                        }
                        handler2.post(new AnonymousClass20(context2));
                        return false;
                    }
                    handler2.post(new AnonymousClass19(context2));
                    return false;
                }
                handler2.post(new AnonymousClass18(context2));
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String b(File file) throws IOException {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                file = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    file.append(readLine);
                }
                file = file.toString();
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return file;
            } catch (Throwable th) {
                file = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw file;
            }
        } catch (Throwable th2) {
            file = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw file;
        }
    }

    public static boolean d(Context context) {
        String a = a(context, Process.myPid());
        return a != null ? a.equals(context.getPackageName()) : null;
    }

    public static void b(Context context, Handler handler) {
        MessageSharedPrefs.getInstance(context).setRegisterTimes(MessageSharedPrefs.getInstance(context).getRegisterTimes() + 1);
        if (d(context)) {
            handler.postDelayed(new AnonymousClass17(context, handler), 20000);
        }
    }

    public static String a(List<Ucode> list) throws IOException {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(list);
        list = URLEncoder.encode(byteArrayOutputStream.toString("ISO-8859-1"), "UTF-8");
        objectOutputStream.close();
        byteArrayOutputStream.close();
        return list;
    }

    public static List<Ucode> g(String str) throws IOException, ClassNotFoundException {
        InputStream byteArrayInputStream = new ByteArrayInputStream(URLDecoder.decode(str, "UTF-8").getBytes("ISO-8859-1"));
        str = new ObjectInputStream(byteArrayInputStream);
        List<Ucode> list = (List) str.readObject();
        str.close();
        byteArrayInputStream.close();
        return list;
    }
}
