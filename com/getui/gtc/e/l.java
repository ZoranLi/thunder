package com.getui.gtc.e;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.getui.gtc.a.h;
import com.getui.gtc.entity.Ie;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public final class l {
    public static Ie a(int i, String str) {
        try {
            Class cls = Class.forName(str);
            AccessibleObject[] declaredConstructors = cls.getDeclaredConstructors();
            AccessibleObject.setAccessible(declaredConstructors, true);
            Constructor constructor = declaredConstructors[0];
            Method declaredMethod = cls.getDeclaredMethod("getIe", new Class[]{Integer.TYPE});
            declaredMethod.setAccessible(true);
            return (Ie) declaredMethod.invoke(constructor.newInstance(new Object[0]), new Object[]{Integer.valueOf(i)});
        } catch (Throwable th) {
            new String[1][0] = th.toString();
            return null;
        }
    }

    public static String a() {
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e;
        Throwable th;
        if (new File(c()).exists()) {
            byte[] bArr = new byte[1024];
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(c());
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        } catch (Exception e2) {
                            e = e2;
                        }
                    }
                    String str = new String(j.b(byteArrayOutputStream.toByteArray()), "utf-8");
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                        new String[1][0] = e3.toString();
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception e32) {
                        new String[1][0] = e32.toString();
                    }
                    return str;
                } catch (Exception e4) {
                    e32 = e4;
                    byteArrayOutputStream = null;
                    try {
                        new String[1][0] = e32.toString();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e322) {
                                new String[1][0] = e322.toString();
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                                return null;
                            } catch (Exception e3222) {
                                new String[1][0] = e3222.toString();
                                return null;
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e5) {
                                new String[1][0] = e5.toString();
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e52) {
                                new String[1][0] = e52.toString();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e3222 = e6;
                fileInputStream = null;
                byteArrayOutputStream = fileInputStream;
                new String[1][0] = e3222.toString();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                    return null;
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
                byteArrayOutputStream = fileInputStream;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        }
        return null;
    }

    public static String a(Context context) {
        try {
            if (VERSION.SDK_INT < 23) {
                return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            }
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                if ("wlan0".equalsIgnoreCase(networkInterface.getName())) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (!(hardwareAddress == null || hardwareAddress.length == 0)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            stringBuilder.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                        }
                        if (stringBuilder.length() > 0) {
                            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                        }
                        return stringBuilder.toString();
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            new String[1][0] = th.toString();
        }
    }

    public static void a(String str) {
        Throwable th;
        WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        FileOutputStream fileOutputStream = null;
        try {
            if (writeLock.tryLock()) {
                File file = new File(c());
                if (file.exists() || file.createNewFile()) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(c());
                    try {
                        fileOutputStream2.write(j.a(str.getBytes("utf-8")));
                        fileOutputStream = fileOutputStream2;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        writeLock.unlock();
                        throw th;
                    }
                }
                writeLock.unlock();
                return;
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e) {
                    new String[1][0] = e.toString();
                }
            }
            writeLock.unlock();
        } catch (Throwable th3) {
            th = th3;
            new String[1][0] = th.toString();
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            writeLock.unlock();
        }
    }

    public static java.lang.String b() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = "";
        r1 = new java.io.File;
        r2 = com.getui.gtc.a.a.e;
        r1.<init>(r2);
        r1 = r1.exists();
        if (r1 == 0) goto L_0x0079;
    L_0x000f:
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r1 = new byte[r1];
        r2 = 0;
        r3 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x006e, all -> 0x0060 }
        r4 = com.getui.gtc.a.a.e;	 Catch:{ Exception -> 0x006e, all -> 0x0060 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x006e, all -> 0x0060 }
        r4 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x006f, all -> 0x005d }
        r4.<init>();	 Catch:{ Exception -> 0x006f, all -> 0x005d }
    L_0x0020:
        r2 = r3.read(r1);	 Catch:{ Exception -> 0x005b, all -> 0x0059 }
        r5 = -1;	 Catch:{ Exception -> 0x005b, all -> 0x0059 }
        r6 = 0;	 Catch:{ Exception -> 0x005b, all -> 0x0059 }
        if (r2 == r5) goto L_0x002c;	 Catch:{ Exception -> 0x005b, all -> 0x0059 }
    L_0x0028:
        r4.write(r1, r6, r2);	 Catch:{ Exception -> 0x005b, all -> 0x0059 }
        goto L_0x0020;	 Catch:{ Exception -> 0x005b, all -> 0x0059 }
    L_0x002c:
        r1 = r4.toByteArray();	 Catch:{ Exception -> 0x005b, all -> 0x0059 }
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x005b, all -> 0x0059 }
        r1 = com.getui.gtc.e.j.b(r1);	 Catch:{ Exception -> 0x005b, all -> 0x0059 }
        r5 = "utf-8";	 Catch:{ Exception -> 0x005b, all -> 0x0059 }
        r2.<init>(r1, r5);	 Catch:{ Exception -> 0x005b, all -> 0x0059 }
        r1 = "\\|";	 Catch:{ Exception -> 0x005b, all -> 0x0059 }
        r1 = r2.split(r1);	 Catch:{ Exception -> 0x005b, all -> 0x0059 }
        r2 = r1.length;	 Catch:{ Exception -> 0x005b, all -> 0x0059 }
        r5 = 1;	 Catch:{ Exception -> 0x005b, all -> 0x0059 }
        if (r2 <= r5) goto L_0x0052;	 Catch:{ Exception -> 0x005b, all -> 0x0059 }
    L_0x0045:
        r2 = "V1";	 Catch:{ Exception -> 0x005b, all -> 0x0059 }
        r6 = r1[r6];	 Catch:{ Exception -> 0x005b, all -> 0x0059 }
        r2 = r2.equals(r6);	 Catch:{ Exception -> 0x005b, all -> 0x0059 }
        if (r2 == 0) goto L_0x0052;	 Catch:{ Exception -> 0x005b, all -> 0x0059 }
    L_0x004f:
        r1 = r1[r5];	 Catch:{ Exception -> 0x005b, all -> 0x0059 }
        r0 = r1;
    L_0x0052:
        r3.close();	 Catch:{ Exception -> 0x0055 }
    L_0x0055:
        r4.close();	 Catch:{ Exception -> 0x0079 }
        return r0;
    L_0x0059:
        r0 = move-exception;
        goto L_0x0063;
    L_0x005b:
        r2 = r4;
        goto L_0x006f;
    L_0x005d:
        r0 = move-exception;
        r4 = r2;
        goto L_0x0063;
    L_0x0060:
        r0 = move-exception;
        r3 = r2;
        r4 = r3;
    L_0x0063:
        if (r3 == 0) goto L_0x0068;
    L_0x0065:
        r3.close();	 Catch:{ Exception -> 0x0068 }
    L_0x0068:
        if (r4 == 0) goto L_0x006d;
    L_0x006a:
        r4.close();	 Catch:{ Exception -> 0x006d }
    L_0x006d:
        throw r0;
    L_0x006e:
        r3 = r2;
    L_0x006f:
        if (r3 == 0) goto L_0x0074;
    L_0x0071:
        r3.close();	 Catch:{ Exception -> 0x0074 }
    L_0x0074:
        if (r2 == 0) goto L_0x0079;
    L_0x0076:
        r2.close();	 Catch:{ Exception -> 0x0079 }
    L_0x0079:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.e.l.b():java.lang.String");
    }

    public static String b(Context context) {
        Throwable th;
        String str = "";
        try {
            CharSequence a = f.a(context, "GETUI_APPID");
            try {
                return TextUtils.isEmpty(a) ? context.getPackageName() : a;
            } catch (Throwable th2) {
                th = th2;
                str = a;
                new String[1][0] = th.toString();
                return str;
            }
        } catch (Throwable th3) {
            th = th3;
            new String[1][0] = th.toString();
            return str;
        }
    }

    public static String b(String str) {
        try {
            Class cls = Class.forName(str);
            AccessibleObject[] declaredConstructors = cls.getDeclaredConstructors();
            AccessibleObject.setAccessible(declaredConstructors, true);
            Constructor constructor = declaredConstructors[0];
            Method declaredMethod = cls.getDeclaredMethod("getSdkVersion", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(constructor.newInstance(new Object[0]), new Object[0]);
        } catch (Throwable th) {
            String[] strArr = new String[1];
            StringBuilder stringBuilder = new StringBuilder(" getSdkVersion error : ");
            stringBuilder.append(th.toString());
            strArr[0] = stringBuilder.toString();
            return null;
        }
    }

    public static int c(String str) {
        try {
            Class cls = Class.forName(str);
            AccessibleObject[] declaredConstructors = cls.getDeclaredConstructors();
            AccessibleObject.setAccessible(declaredConstructors, true);
            Constructor constructor = declaredConstructors[0];
            Method declaredMethod = cls.getDeclaredMethod("getSdkId", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(constructor.newInstance(new Object[0]), new Object[0])).intValue();
        } catch (Throwable th) {
            String[] strArr = new String[1];
            StringBuilder stringBuilder = new StringBuilder(" getSDKId error : ");
            stringBuilder.append(th.toString());
            strArr[0] = stringBuilder.toString();
            return 0;
        }
    }

    private static String c() {
        Context context = h.a;
        if (context == null) {
            return null;
        }
        File file = new File("/sdcard/libs");
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getAbsolutePath());
        stringBuilder.append(File.separator);
        stringBuilder.append(context.getPackageName());
        stringBuilder.append("_.db");
        return stringBuilder.toString();
    }

    public static String d(String str) {
        try {
            Class cls = Class.forName(str);
            AccessibleObject[] declaredConstructors = cls.getDeclaredConstructors();
            AccessibleObject.setAccessible(declaredConstructors, true);
            Constructor constructor = declaredConstructors[0];
            Method declaredMethod = cls.getDeclaredMethod("getSdkAppId", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(constructor.newInstance(new Object[0]), new Object[0]);
        } catch (Throwable th) {
            String[] strArr = new String[1];
            StringBuilder stringBuilder = new StringBuilder(" getAppId error : ");
            stringBuilder.append(th.toString());
            strArr[0] = stringBuilder.toString();
            return null;
        }
    }
}
