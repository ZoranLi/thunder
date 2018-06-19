package com.tencent.bugly.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import anet.channel.util.HttpConstant;
import com.baidu.android.common.security.RSAUtil;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.umeng.message.proguard.k;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: BUGLY */
public class ap {
    private static Map<String, String> a = null;
    private static boolean b = false;

    public static <T> T a(byte[] r0, android.os.Parcelable.Creator<T> r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0019 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = d(r0);
        r1 = r1.createFromParcel(r0);	 Catch:{ Throwable -> 0x0010, all -> 0x000e }
        if (r0 == 0) goto L_0x000d;
    L_0x000a:
        r0.recycle();
    L_0x000d:
        return r1;
    L_0x000e:
        r1 = move-exception;
        goto L_0x001b;
    L_0x0010:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ Throwable -> 0x0010, all -> 0x000e }
        if (r0 == 0) goto L_0x0019;
    L_0x0016:
        r0.recycle();
    L_0x0019:
        r0 = 0;
        return r0;
    L_0x001b:
        if (r0 == 0) goto L_0x0020;
    L_0x001d:
        r0.recycle();
    L_0x0020:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ap.a(byte[], android.os.Parcelable$Creator):T");
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            Writer stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.getBuffer().toString();
        } catch (Throwable th2) {
            if (!an.a(th2)) {
                th2.printStackTrace();
            }
            return "fail";
        }
    }

    public static String a() {
        return a(System.currentTimeMillis());
    }

    public static java.lang.String a(long r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.text.SimpleDateFormat;	 Catch:{ Exception -> 0x0013 }
        r1 = "yyyy-MM-dd HH:mm:ss";	 Catch:{ Exception -> 0x0013 }
        r2 = java.util.Locale.US;	 Catch:{ Exception -> 0x0013 }
        r0.<init>(r1, r2);	 Catch:{ Exception -> 0x0013 }
        r1 = new java.util.Date;	 Catch:{ Exception -> 0x0013 }
        r1.<init>(r3);	 Catch:{ Exception -> 0x0013 }
        r3 = r0.format(r1);	 Catch:{ Exception -> 0x0013 }
        return r3;
    L_0x0013:
        r3 = new java.util.Date;
        r3.<init>();
        r3 = r3.toString();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ap.a(long):java.lang.String");
    }

    public static java.lang.String a(java.util.Date r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r3 != 0) goto L_0x0004;
    L_0x0002:
        r3 = 0;
        return r3;
    L_0x0004:
        r0 = new java.text.SimpleDateFormat;	 Catch:{ Exception -> 0x0012 }
        r1 = "yyyy-MM-dd HH:mm:ss";	 Catch:{ Exception -> 0x0012 }
        r2 = java.util.Locale.US;	 Catch:{ Exception -> 0x0012 }
        r0.<init>(r1, r2);	 Catch:{ Exception -> 0x0012 }
        r3 = r0.format(r3);	 Catch:{ Exception -> 0x0012 }
        return r3;
    L_0x0012:
        r3 = new java.util.Date;
        r3.<init>();
        r3 = r3.toString();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ap.a(java.util.Date):java.lang.String");
    }

    public static byte[] a(byte[] bArr, int i, String str) {
        if (bArr != null) {
            if (i != -1) {
                an.c("rqdp{  enD:} %d %d", Integer.valueOf(bArr.length), Integer.valueOf(i));
                try {
                    i = aw.a(i);
                    if (i == 0) {
                        return null;
                    }
                    i.a(str);
                    return i.b(bArr);
                } catch (byte[] bArr2) {
                    if (an.a(bArr2) == 0) {
                        bArr2.printStackTrace();
                    }
                    return null;
                }
            }
        }
        return bArr2;
    }

    public static byte[] b(byte[] bArr, int i, String str) {
        if (bArr != null) {
            if (i != -1) {
                try {
                    ax a = aw.a(i);
                    if (a == null) {
                        return null;
                    }
                    a.a(str);
                    return a.a(bArr);
                } catch (byte[] bArr2) {
                    if (!an.a(bArr2)) {
                        bArr2.printStackTrace();
                    }
                    an.d("encrytype %d %s", Integer.valueOf(i), str);
                    return null;
                }
            }
        }
        return bArr2;
    }

    public static byte[] a(File file, String str, String str2) {
        ByteArrayInputStream byteArrayInputStream;
        ZipOutputStream zipOutputStream;
        int read;
        an.c("rqdp{  ZF start}", new Object[0]);
        if (file != null) {
            try {
                if (file.exists() && file.canRead()) {
                    str2 = new FileInputStream(file);
                    try {
                        file = file.getName();
                        byteArrayInputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
                        str = new ByteArrayOutputStream();
                        zipOutputStream = new ZipOutputStream(str);
                        zipOutputStream.setMethod(8);
                        zipOutputStream.putNextEntry(new ZipEntry(file));
                        file = new byte[1024];
                        if (str2 != null) {
                            while (true) {
                                read = str2.read(file);
                                if (read > 0) {
                                    break;
                                }
                                zipOutputStream.write(file, 0, read);
                            }
                        }
                        while (true) {
                            read = byteArrayInputStream.read(file);
                            if (read > 0) {
                                break;
                            }
                            zipOutputStream.write(file, 0, read);
                        }
                        zipOutputStream.closeEntry();
                        zipOutputStream.flush();
                        zipOutputStream.finish();
                        file = str.toByteArray();
                        if (str2 != null) {
                            try {
                                str2.close();
                            } catch (String str3) {
                                str3.printStackTrace();
                            }
                        }
                        zipOutputStream.close();
                        an.c("rqdp{  ZF end}", new Object[0]);
                        return file;
                    } catch (Throwable th) {
                        file = th;
                        zipOutputStream = null;
                        if (str2 != null) {
                            str2.close();
                        }
                        if (zipOutputStream != null) {
                            zipOutputStream.close();
                        }
                        an.c("rqdp{  ZF end}", new Object[0]);
                        throw file;
                    }
                }
            } catch (Throwable th2) {
                file = th2;
                str2 = null;
                zipOutputStream = str2;
                if (str2 != null) {
                    str2.close();
                }
                if (zipOutputStream != null) {
                    zipOutputStream.close();
                }
                an.c("rqdp{  ZF end}", new Object[0]);
                throw file;
            }
        }
        file = str2;
        str2 = null;
        byteArrayInputStream = new ByteArrayInputStream(str3.getBytes("UTF-8"));
        str3 = new ByteArrayOutputStream();
        zipOutputStream = new ZipOutputStream(str3);
        try {
            zipOutputStream.setMethod(8);
            zipOutputStream.putNextEntry(new ZipEntry(file));
            file = new byte[1024];
            if (str2 != null) {
                while (true) {
                    read = str2.read(file);
                    if (read > 0) {
                        break;
                    }
                    zipOutputStream.write(file, 0, read);
                }
            }
            while (true) {
                read = byteArrayInputStream.read(file);
                if (read > 0) {
                    break;
                }
                zipOutputStream.write(file, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.flush();
            zipOutputStream.finish();
            file = str3.toByteArray();
            if (str2 != null) {
                str2.close();
            }
            try {
                zipOutputStream.close();
            } catch (String str32) {
                str32.printStackTrace();
            }
            an.c("rqdp{  ZF end}", new Object[0]);
            return file;
        } catch (Throwable th3) {
            file = th3;
            if (an.a(file) == null) {
                file.printStackTrace();
            }
            if (str2 != null) {
                str2.close();
            }
            if (zipOutputStream != null) {
                zipOutputStream.close();
            }
            an.c("rqdp{  ZF end}", new Object[0]);
            return null;
        }
    }

    public static byte[] a(byte[] bArr, int i) {
        if (bArr != null) {
            if (i != -1) {
                String str = "[Util] Zip %d bytes data with type %s";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(bArr.length);
                objArr[1] = i == 2 ? "Gzip" : "zip";
                an.c(str, objArr);
                try {
                    i = aq.a(i);
                    if (i == 0) {
                        return null;
                    }
                    return i.a(bArr);
                } catch (byte[] bArr2) {
                    if (an.a(bArr2) == 0) {
                        bArr2.printStackTrace();
                    }
                    return null;
                }
            }
        }
        return bArr2;
    }

    public static byte[] b(byte[] bArr, int i) {
        if (bArr != null) {
            if (i != -1) {
                String str = "[Util] Unzip %d bytes data with type %s";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(bArr.length);
                objArr[1] = i == 2 ? "Gzip" : "zip";
                an.c(str, objArr);
                try {
                    i = aq.a(i);
                    if (i == 0) {
                        return null;
                    }
                    return i.b(bArr);
                } catch (byte[] bArr2) {
                    if (an.a(bArr2) == 0) {
                        bArr2.printStackTrace();
                    }
                    return null;
                }
            }
        }
        return bArr2;
    }

    public static byte[] a(byte[] bArr, int i, int i2, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return a(a(bArr, i), i2, str);
        } catch (byte[] bArr2) {
            if (an.a(bArr2) == 0) {
                bArr2.printStackTrace();
            }
            return null;
        }
    }

    public static byte[] b(byte[] bArr, int i, int i2, String str) {
        try {
            return b(b(bArr, i2, str), i);
        } catch (byte[] bArr2) {
            if (an.a(bArr2) == 0) {
                bArr2.printStackTrace();
            }
            return null;
        }
    }

    public static long b() {
        try {
            return (((System.currentTimeMillis() + ((long) TimeZone.getDefault().getRawOffset())) / 86400000) * 86400000) - ((long) TimeZone.getDefault().getRawOffset());
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(toHexString);
        }
        return stringBuffer.toString().toUpperCase();
    }

    public static String b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length != 0) {
                try {
                    MessageDigest instance = MessageDigest.getInstance("SHA-1");
                    instance.update(bArr);
                    return a(instance.digest());
                } catch (byte[] bArr2) {
                    if (!an.a(bArr2)) {
                        bArr2.printStackTrace();
                    }
                    return null;
                }
            }
        }
        return "NULL";
    }

    public static String a(File file, String str) {
        if (file != null && file.exists()) {
            if (file.canRead()) {
                FileInputStream fileInputStream;
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        file = MessageDigest.getInstance(str);
                        str = new byte[ShareConstants.MD5_FILE_BUF_LENGTH];
                        while (true) {
                            int read = fileInputStream.read(str);
                            if (read == -1) {
                                break;
                            }
                            file.update(str, 0, read);
                        }
                        file = a(file.digest());
                        try {
                            fileInputStream.close();
                        } catch (String str2) {
                            str2.printStackTrace();
                        }
                        return file;
                    } catch (IOException e) {
                        file = e;
                        if (an.a(file) == null) {
                            file.printStackTrace();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return null;
                    } catch (NoSuchAlgorithmException e2) {
                        file = e2;
                        try {
                            if (an.a(file) == null) {
                                file.printStackTrace();
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (File file2) {
                                    file2.printStackTrace();
                                }
                            }
                            return null;
                        } catch (Throwable th) {
                            file2 = th;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (String str22) {
                                    str22.printStackTrace();
                                }
                            }
                            throw file2;
                        }
                    }
                } catch (IOException e3) {
                    file2 = e3;
                    fileInputStream = null;
                    if (an.a(file2) == null) {
                        file2.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return null;
                } catch (NoSuchAlgorithmException e4) {
                    file2 = e4;
                    fileInputStream = null;
                    if (an.a(file2) == null) {
                        file2.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    file2 = th2;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw file2;
                }
            }
        }
        return null;
    }

    public static boolean a(File file, File file2, int i) {
        FileInputStream fileInputStream;
        ZipOutputStream zipOutputStream;
        an.c("rqdp{  ZF start}", new Object[0]);
        if (!(file == null || file2 == null)) {
            if (!file.equals(file2)) {
                if (file.exists()) {
                    if (file.canRead()) {
                        try {
                            if (!(file2.getParentFile() == null || file2.getParentFile().exists())) {
                                file2.getParentFile().mkdirs();
                            }
                            if (!file2.exists()) {
                                file2.createNewFile();
                            }
                        } catch (Throwable th) {
                            if (!an.a(th)) {
                                th.printStackTrace();
                            }
                        }
                        if (file2.exists()) {
                            if (file2.canRead()) {
                                FileInputStream fileInputStream2 = null;
                                try {
                                    fileInputStream = new FileInputStream(file);
                                    try {
                                        zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
                                        try {
                                            zipOutputStream.setMethod(8);
                                            zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                                            file = 1000;
                                            if (i > 1000) {
                                                file = i;
                                            }
                                            file = new byte[file];
                                            while (true) {
                                                file2 = fileInputStream.read(file);
                                                if (file2 <= null) {
                                                    break;
                                                }
                                                zipOutputStream.write(file, 0, file2);
                                            }
                                            zipOutputStream.flush();
                                            zipOutputStream.closeEntry();
                                            try {
                                                fileInputStream.close();
                                            } catch (File file3) {
                                                file3.printStackTrace();
                                            }
                                            try {
                                                zipOutputStream.close();
                                            } catch (File file32) {
                                                file32.printStackTrace();
                                            }
                                            an.c("rqdp{  ZF end}", new Object[0]);
                                            return true;
                                        } catch (Throwable th2) {
                                            file32 = th2;
                                            if (fileInputStream != null) {
                                                fileInputStream.close();
                                            }
                                            if (zipOutputStream != null) {
                                                zipOutputStream.close();
                                            }
                                            an.c("rqdp{  ZF end}", new Object[0]);
                                            throw file32;
                                        }
                                    } catch (Throwable th3) {
                                        file32 = th3;
                                        zipOutputStream = null;
                                        if (fileInputStream != null) {
                                            fileInputStream.close();
                                        }
                                        if (zipOutputStream != null) {
                                            zipOutputStream.close();
                                        }
                                        an.c("rqdp{  ZF end}", new Object[0]);
                                        throw file32;
                                    }
                                } catch (Throwable th4) {
                                    file32 = th4;
                                    fileInputStream = null;
                                    zipOutputStream = fileInputStream;
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                    }
                                    if (zipOutputStream != null) {
                                        zipOutputStream.close();
                                    }
                                    an.c("rqdp{  ZF end}", new Object[0]);
                                    throw file32;
                                }
                            }
                        }
                        return false;
                    }
                }
                an.d("rqdp{  !sFile.exists() || !sFile.canRead(),pls check ,return!}", new Object[0]);
                return false;
            }
        }
        an.d("rqdp{  err ZF 1R!}", new Object[0]);
        return false;
    }

    public static ArrayList<String> a(Context context, String[] strArr) {
        BufferedReader bufferedReader;
        ArrayList<String> arrayList = new ArrayList();
        if (a.a(context).J() != null) {
            context = new ArrayList();
            context.add(new String("unknown(low memory)"));
            return context;
        }
        context = null;
        BufferedReader bufferedReader2;
        try {
            strArr = Runtime.getRuntime().exec(strArr);
            bufferedReader = new BufferedReader(new InputStreamReader(strArr.getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                } catch (Throwable th) {
                    strArr = th;
                }
            }
            bufferedReader2 = new BufferedReader(new InputStreamReader(strArr.getErrorStream()));
            while (true) {
                try {
                    strArr = bufferedReader2.readLine();
                    if (strArr != null) {
                        arrayList.add(strArr);
                    } else {
                        try {
                            break;
                        } catch (Context context2) {
                            context2.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    strArr = th2;
                }
            }
            bufferedReader.close();
            try {
                bufferedReader2.close();
            } catch (Context context22) {
                context22.printStackTrace();
            }
            return arrayList;
        } catch (Throwable th3) {
            strArr = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (context22 != null) {
                context22.close();
            }
            throw strArr;
        }
    }

    public static String a(Context context, String str) {
        if (str != null) {
            if (!str.trim().equals("")) {
                if (a == null) {
                    a = new HashMap();
                    Context<String> a = a(context, new String[]{"/system/bin/sh", "-c", "getprop"});
                    if (a != null && a.size() > 0) {
                        an.b(ap.class, "Successfully get 'getprop' list.", new Object[0]);
                        Pattern compile = Pattern.compile("\\[(.+)\\]: \\[(.*)\\]");
                        for (String matcher : a) {
                            Matcher matcher2 = compile.matcher(matcher);
                            if (matcher2.find()) {
                                a.put(matcher2.group(1), matcher2.group(2));
                            }
                        }
                        an.b(ap.class, "System properties number: %d.", Integer.valueOf(a.size()));
                    }
                }
                return a.containsKey(str) != null ? (String) a.get(str) : "fail";
            }
        }
        return "";
    }

    public static void b(long j) {
        try {
            Thread.sleep(j);
        } catch (long j2) {
            j2.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2, int i) {
        an.c("rqdp{  sv sd start} %s", str);
        if (str2 != null) {
            if (str2.trim().length() > null) {
                context = new File(str);
                try {
                    if (context.exists() == null) {
                        if (context.getParentFile() != null) {
                            context.getParentFile().mkdirs();
                        }
                        context.createNewFile();
                    }
                    str = null;
                    try {
                        if (context.length() >= ((long) i)) {
                            i = new FileOutputStream(context, false);
                        } else {
                            i = new FileOutputStream(context, true);
                        }
                        str = i;
                        str.write(str2.getBytes("UTF-8"));
                        str.flush();
                    } catch (Context context2) {
                        if (an.a(context2) == null) {
                            context2.printStackTrace();
                        }
                        if (str != null) {
                        }
                    }
                    str.close();
                } catch (Context context22) {
                    if (an.a(context22) == null) {
                        context22.printStackTrace();
                    }
                }
                an.c("rqdp{  sv sd end}", new Object[0]);
            }
        }
    }

    public static boolean a(String str) {
        return (str == null || str.trim().length() <= null) ? true : null;
    }

    public static void b(String str) {
        if (str != null) {
            File file = new File(str);
            if (!(file.isFile() == null || file.exists() == null || file.canWrite() == null)) {
                file.delete();
            }
        }
    }

    public static byte[] c(long j) {
        try {
            return String.valueOf(j).getBytes("utf-8");
        } catch (long j2) {
            j2.printStackTrace();
            return 0;
        }
    }

    public static long c(byte[] bArr) {
        if (bArr == null) {
            return -1;
        }
        try {
            return Long.parseLong(new String(bArr, "utf-8"));
        } catch (byte[] bArr2) {
            bArr2.printStackTrace();
            return -1;
        }
    }

    public static Context a(Context context) {
        if (context == null) {
            return context;
        }
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public static String b(Throwable th) {
        if (th == null) {
            return "";
        }
        Writer stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static void a(java.lang.Class<?> r0, java.lang.String r1, java.lang.Object r2, java.lang.Object r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r0.getDeclaredField(r1);	 Catch:{ Exception -> 0x000c }
        r1 = 1;	 Catch:{ Exception -> 0x000c }
        r0.setAccessible(r1);	 Catch:{ Exception -> 0x000c }
        r0.set(r3, r2);	 Catch:{ Exception -> 0x000c }
        return;
    L_0x000c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ap.a(java.lang.Class, java.lang.String, java.lang.Object, java.lang.Object):void");
    }

    public static java.lang.Object a(java.lang.String r0, java.lang.String r1, java.lang.Object r2, java.lang.Class<?>[] r3, java.lang.Object[] r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0011 }
        r0 = r0.getDeclaredMethod(r1, r3);	 Catch:{ Exception -> 0x0011 }
        r1 = 1;	 Catch:{ Exception -> 0x0011 }
        r0.setAccessible(r1);	 Catch:{ Exception -> 0x0011 }
        r0 = r0.invoke(r2, r4);	 Catch:{ Exception -> 0x0011 }
        return r0;
    L_0x0011:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ap.a(java.lang.String, java.lang.String, java.lang.Object, java.lang.Class[], java.lang.Object[]):java.lang.Object");
    }

    public static void a(Parcel parcel, Map<String, PlugInBean> map) {
        if (map != null) {
            if (map.size() > 0) {
                int size = map.size();
                ArrayList arrayList = new ArrayList(size);
                ArrayList arrayList2 = new ArrayList(size);
                map = map.entrySet().iterator();
                while (map.hasNext()) {
                    Entry entry = (Entry) map.next();
                    arrayList.add(entry.getKey());
                    arrayList2.add(entry.getValue());
                }
                map = new Bundle();
                map.putInt("pluginNum", arrayList.size());
                size = 0;
                for (int i = 0; i < arrayList.size(); i++) {
                    StringBuilder stringBuilder = new StringBuilder("pluginKey");
                    stringBuilder.append(i);
                    map.putString(stringBuilder.toString(), (String) arrayList.get(i));
                }
                while (size < arrayList.size()) {
                    StringBuilder stringBuilder2 = new StringBuilder("pluginVal");
                    stringBuilder2.append(size);
                    stringBuilder2.append("plugInId");
                    map.putString(stringBuilder2.toString(), ((PlugInBean) arrayList2.get(size)).a);
                    stringBuilder2 = new StringBuilder("pluginVal");
                    stringBuilder2.append(size);
                    stringBuilder2.append("plugInUUID");
                    map.putString(stringBuilder2.toString(), ((PlugInBean) arrayList2.get(size)).c);
                    stringBuilder2 = new StringBuilder("pluginVal");
                    stringBuilder2.append(size);
                    stringBuilder2.append("plugInVersion");
                    map.putString(stringBuilder2.toString(), ((PlugInBean) arrayList2.get(size)).b);
                    size++;
                }
                parcel.writeBundle(map);
                return;
            }
        }
        parcel.writeBundle(null);
    }

    public static Map<String, PlugInBean> a(Parcel parcel) {
        parcel = parcel.readBundle();
        Map<String, PlugInBean> map = null;
        if (parcel == null) {
            return null;
        }
        int i;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        int intValue = ((Integer) parcel.get("pluginNum")).intValue();
        int i2 = 0;
        for (i = 0; i < intValue; i++) {
            StringBuilder stringBuilder = new StringBuilder("pluginKey");
            stringBuilder.append(i);
            arrayList.add(parcel.getString(stringBuilder.toString()));
        }
        for (i = 0; i < intValue; i++) {
            stringBuilder = new StringBuilder("pluginVal");
            stringBuilder.append(i);
            stringBuilder.append("plugInId");
            String string = parcel.getString(stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder("pluginVal");
            stringBuilder2.append(i);
            stringBuilder2.append("plugInUUID");
            String string2 = parcel.getString(stringBuilder2.toString());
            StringBuilder stringBuilder3 = new StringBuilder("pluginVal");
            stringBuilder3.append(i);
            stringBuilder3.append("plugInVersion");
            arrayList2.add(new PlugInBean(string, parcel.getString(stringBuilder3.toString()), string2));
        }
        if (arrayList.size() == arrayList2.size()) {
            map = new HashMap(arrayList.size());
            while (i2 < arrayList.size()) {
                map.put(arrayList.get(i2), PlugInBean.class.cast(arrayList2.get(i2)));
                i2++;
            }
        } else {
            an.e("map plugin parcel error!", new Object[0]);
        }
        return map;
    }

    public static void b(Parcel parcel, Map<String, String> map) {
        if (map != null) {
            if (map.size() > 0) {
                int size = map.size();
                ArrayList arrayList = new ArrayList(size);
                ArrayList arrayList2 = new ArrayList(size);
                map = map.entrySet().iterator();
                while (map.hasNext()) {
                    Entry entry = (Entry) map.next();
                    arrayList.add(entry.getKey());
                    arrayList2.add(entry.getValue());
                }
                map = new Bundle();
                map.putStringArrayList("keys", arrayList);
                map.putStringArrayList("values", arrayList2);
                parcel.writeBundle(map);
                return;
            }
        }
        parcel.writeBundle(null);
    }

    public static Map<String, String> b(Parcel parcel) {
        parcel = parcel.readBundle();
        Map<String, String> map = null;
        if (parcel == null) {
            return null;
        }
        List stringArrayList = parcel.getStringArrayList("keys");
        parcel = parcel.getStringArrayList("values");
        int i = 0;
        if (stringArrayList == null || parcel == null || stringArrayList.size() != parcel.size()) {
            an.e("map parcel error!", new Object[0]);
        } else {
            map = new HashMap(stringArrayList.size());
            while (i < stringArrayList.size()) {
                map.put(stringArrayList.get(i), parcel.get(i));
                i++;
            }
        }
        return map;
    }

    public static byte[] a(Parcelable parcelable) {
        Parcel obtain = Parcel.obtain();
        parcelable.writeToParcel(obtain, 0);
        parcelable = obtain.marshall();
        obtain.recycle();
        return parcelable;
    }

    public static Parcel d(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        return obtain;
    }

    public static String a(Context context, int i, String str) {
        Process process = null;
        if (AppInfo.a(context, "android.permission.READ_LOGS") == null) {
            an.d("no read_log permission!", new Object[0]);
            return null;
        }
        if (str == null) {
            str = new String[]{"logcat", "-d", "-v", "threadtime"};
        } else {
            str = new String[]{"logcat", "-d", "-v", "threadtime", "-s", str};
        }
        context = new StringBuilder();
        try {
            str = Runtime.getRuntime().exec(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(str.getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    context.append(readLine);
                    context.append("\n");
                    if (i > 0 && context.length() > i) {
                        context.delete(0, context.length() - i);
                    }
                }
                i = context.toString();
                if (str != null) {
                    try {
                        str.getOutputStream().close();
                    } catch (Context context2) {
                        context2.printStackTrace();
                    }
                    try {
                        str.getInputStream().close();
                    } catch (Context context22) {
                        context22.printStackTrace();
                    }
                    try {
                        str.getErrorStream().close();
                    } catch (Context context222) {
                        context222.printStackTrace();
                    }
                }
                return i;
            } catch (Throwable th) {
                context222 = th;
                process = str;
                if (process != null) {
                    process.getOutputStream().close();
                    process.getInputStream().close();
                    process.getErrorStream().close();
                }
                throw context222;
            }
        } catch (Throwable th2) {
            i = th2;
            if (an.a(i) == null) {
                i.printStackTrace();
            }
            str = new StringBuilder("\n[error:");
            str.append(i.toString());
            str.append("]");
            context222.append(str.toString());
            context222 = context222.toString();
            if (process != null) {
                process.getOutputStream().close();
                process.getInputStream().close();
                process.getErrorStream().close();
            }
            return context222;
        }
    }

    public static Map<String, String> a(int i, boolean z) {
        Map<String, String> hashMap = new HashMap(12);
        Map allStackTraces = Thread.getAllStackTraces();
        if (allStackTraces == null) {
            return 0;
        }
        long id = Thread.currentThread().getId();
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : allStackTraces.entrySet()) {
            if (!z || id != ((Thread) entry.getKey()).getId()) {
                int i2 = 0;
                stringBuilder.setLength(0);
                if (!(entry.getValue() == null || ((StackTraceElement[]) entry.getValue()).length == 0)) {
                    StringBuilder stringBuilder2;
                    StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) entry.getValue();
                    int length = stackTraceElementArr.length;
                    while (i2 < length) {
                        StackTraceElement stackTraceElement = stackTraceElementArr[i2];
                        if (i > 0 && stringBuilder.length() >= i) {
                            stringBuilder2 = new StringBuilder("\n[Stack over limit size :");
                            stringBuilder2.append(i);
                            stringBuilder2.append(" , has been cutted !]");
                            stringBuilder.append(stringBuilder2.toString());
                            break;
                        }
                        stringBuilder.append(stackTraceElement.toString());
                        stringBuilder.append("\n");
                        i2++;
                    }
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(((Thread) entry.getKey()).getName());
                    stringBuilder2.append(k.s);
                    stringBuilder2.append(((Thread) entry.getKey()).getId());
                    stringBuilder2.append(k.t);
                    hashMap.put(stringBuilder2.toString(), stringBuilder.toString());
                }
            }
        }
        return hashMap;
    }

    public static boolean b(android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = 1;
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ SecurityException -> 0x004a, Exception -> 0x003f }
        r3 = 14;	 Catch:{ SecurityException -> 0x004a, Exception -> 0x003f }
        if (r2 < r3) goto L_0x0011;	 Catch:{ SecurityException -> 0x004a, Exception -> 0x003f }
    L_0x0008:
        r4 = com.tencent.bugly.crashreport.common.info.a.b();	 Catch:{ SecurityException -> 0x004a, Exception -> 0x003f }
        r4 = r4.a();	 Catch:{ SecurityException -> 0x004a, Exception -> 0x003f }
        return r4;	 Catch:{ SecurityException -> 0x004a, Exception -> 0x003f }
    L_0x0011:
        r2 = r4.getPackageName();	 Catch:{ SecurityException -> 0x004a, Exception -> 0x003f }
        r3 = "activity";	 Catch:{ SecurityException -> 0x004a, Exception -> 0x003f }
        r4 = r4.getSystemService(r3);	 Catch:{ SecurityException -> 0x004a, Exception -> 0x003f }
        r4 = (android.app.ActivityManager) r4;	 Catch:{ SecurityException -> 0x004a, Exception -> 0x003f }
        if (r4 == 0) goto L_0x0051;	 Catch:{ SecurityException -> 0x004a, Exception -> 0x003f }
    L_0x001f:
        r4 = r4.getRunningTasks(r1);	 Catch:{ SecurityException -> 0x004a, Exception -> 0x003f }
        if (r4 == 0) goto L_0x003e;	 Catch:{ SecurityException -> 0x004a, Exception -> 0x003f }
    L_0x0025:
        r3 = r4.isEmpty();	 Catch:{ SecurityException -> 0x004a, Exception -> 0x003f }
        if (r3 != 0) goto L_0x003e;	 Catch:{ SecurityException -> 0x004a, Exception -> 0x003f }
    L_0x002b:
        r4 = r4.get(r0);	 Catch:{ SecurityException -> 0x004a, Exception -> 0x003f }
        r4 = (android.app.ActivityManager.RunningTaskInfo) r4;	 Catch:{ SecurityException -> 0x004a, Exception -> 0x003f }
        r4 = r4.topActivity;	 Catch:{ SecurityException -> 0x004a, Exception -> 0x003f }
        r4 = r4.getPackageName();	 Catch:{ SecurityException -> 0x004a, Exception -> 0x003f }
        r4 = r4.equals(r2);	 Catch:{ SecurityException -> 0x004a, Exception -> 0x003f }
        if (r4 == 0) goto L_0x003e;
    L_0x003d:
        return r1;
    L_0x003e:
        return r0;
    L_0x003f:
        r4 = move-exception;
        r0 = com.tencent.bugly.proguard.an.b(r4);
        if (r0 != 0) goto L_0x0051;
    L_0x0046:
        r4.printStackTrace();
        goto L_0x0051;
    L_0x004a:
        r4 = "无法获取GET_TASK权限，将在通知栏提醒升级，如需弹窗提醒，请在AndroidManifest.xml中添加GET_TASKS权限：\n<uses-permission android:name=\"android.permission.GET_TASKS\" />\n";
        r0 = new java.lang.Object[r0];
        com.tencent.bugly.proguard.an.e(r4, r0);
    L_0x0051:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ap.b(android.content.Context):boolean");
    }

    public static synchronized byte[] a(int i) {
        DataInputStream dataInputStream;
        Exception e;
        KeyGenerator instance;
        synchronized (ap.class) {
            try {
                byte[] bArr = new byte[(i / 8)];
                dataInputStream = new DataInputStream(new FileInputStream(new File("/dev/urandom")));
                try {
                    dataInputStream.readFully(bArr);
                    try {
                        dataInputStream.close();
                        return bArr;
                    } catch (int i2) {
                        if (!an.b(i2)) {
                            i2.printStackTrace();
                        }
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        an.e("Failed to read from /dev/urandom : %s", e);
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                        instance = KeyGenerator.getInstance("AES");
                        instance.init(i2, new SecureRandom());
                        i2 = instance.generateKey().getEncoded();
                        return i2;
                    } catch (Throwable th) {
                        i2 = th;
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                        throw i2;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                dataInputStream = null;
                an.e("Failed to read from /dev/urandom : %s", e);
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                instance = KeyGenerator.getInstance("AES");
                instance.init(i2, new SecureRandom());
                i2 = instance.generateKey().getEncoded();
                return i2;
            } catch (Throwable th2) {
                i2 = th2;
                dataInputStream = null;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                throw i2;
            }
        }
    }

    @TargetApi(19)
    public static byte[] a(int i, byte[] bArr, byte[] bArr2) {
        try {
            Key secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
            if (VERSION.SDK_INT >= 21) {
                if (!b) {
                    instance.init(i, secretKeySpec, new GCMParameterSpec(instance.getBlockSize() * 8, bArr2));
                    return instance.doFinal(bArr);
                }
            }
            instance.init(i, secretKeySpec, new IvParameterSpec(bArr2));
            return instance.doFinal(bArr);
        } catch (int i2) {
            b = 1;
            throw i2;
        } catch (int i22) {
            if (an.b(i22) == null) {
                i22.printStackTrace();
            }
            return 0;
        }
    }

    public static byte[] b(int i, byte[] bArr, byte[] bArr2) {
        try {
            KeyFactory instance = KeyFactory.getInstance(RSAUtil.ALGORITHM_RSA);
            if (i == 1) {
                bArr2 = instance.generatePublic(new X509EncodedKeySpec(bArr2));
            } else {
                bArr2 = instance.generatePrivate(new PKCS8EncodedKeySpec(bArr2));
            }
            Cipher instance2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance2.init(i, bArr2);
            return instance2.doFinal(bArr);
        } catch (int i2) {
            if (an.b(i2) == null) {
                i2.printStackTrace();
            }
            return 0;
        }
    }

    public static boolean a(Context context, String str, long j) {
        an.c("[Util] try to lock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir());
            stringBuilder.append(File.separator);
            stringBuilder.append(r1);
            File file = new File(stringBuilder.toString());
            if (file.exists()) {
                if (System.currentTimeMillis() - file.lastModified() < j) {
                    return false;
                }
                an.c("[Util] lock file(%s) is expired, unlock it", r1);
                b(context, str);
            }
            if (file.createNewFile()) {
                an.c("[Util] successfully locked file:%s (pid=%d | tid=%d)", r1, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                return true;
            }
            an.c("[Util] Failed to locked file:%s (pid=%d | tid=%d)", r1, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return false;
        } catch (Throwable th) {
            an.a(th);
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        an.c("[Util] try to unlock file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir());
            stringBuilder.append(File.separator);
            stringBuilder.append(str);
            File file = new File(stringBuilder.toString());
            if (file.exists() == null) {
                return true;
            }
            if (file.delete() == null) {
                return false;
            }
            an.c("[Util] successfully unlocked file:%s (pid=%d | tid=%d)", str, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return true;
        } catch (Context context2) {
            an.a(context2);
            return false;
        }
    }

    public static String a(File file) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        if (file != null && file.exists()) {
            if (file.canRead()) {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                    while (true) {
                        try {
                            file = bufferedReader.readLine();
                            if (file == null) {
                                break;
                            }
                            stringBuilder.append(file);
                            stringBuilder.append("\n");
                        } catch (Throwable th) {
                            file = th;
                        }
                    }
                    file = stringBuilder.toString();
                    try {
                        bufferedReader.close();
                    } catch (Throwable e) {
                        an.a(e);
                    }
                    return file;
                } catch (Throwable th2) {
                    file = th2;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    throw file;
                }
            }
        }
        return null;
    }

    public static BufferedReader b(File file) {
        if (file != null && file.exists()) {
            if (file.canRead()) {
                try {
                    return new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                } catch (File file2) {
                    an.a(file2);
                    return null;
                }
            }
        }
        return null;
    }

    public static BufferedReader a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            File file = new File(str, str2);
            if (file.exists() != null) {
                if (file.canRead() != null) {
                    return b(file);
                }
            }
            return null;
        } catch (String str3) {
            an.a(str3);
            return null;
        }
    }

    public static Thread a(Runnable runnable, String str) {
        try {
            Thread thread = new Thread(runnable);
            thread.setName(str);
            thread.start();
            return thread;
        } catch (Runnable runnable2) {
            an.e("[Util] Failed to start a thread to execute task with message: %s", runnable2.getMessage());
            return null;
        }
    }

    public static boolean a(Runnable runnable) {
        if (runnable != null) {
            am a = am.a();
            if (a != null) {
                return a.a(runnable);
            }
            String[] split = runnable.getClass().getName().split("\\.");
            if (a(runnable, split[split.length - 1]) != null) {
                return true;
            }
        }
        return null;
    }

    public static boolean c(String str) {
        if (a(str)) {
            return false;
        }
        if (str.length() > 255) {
            an.a("URL(%s)'s length is larger than 255.", str);
            return false;
        } else if (!str.toLowerCase().startsWith(HttpConstant.HTTP)) {
            an.a("URL(%s) is not start with \"http\".", str);
            return false;
        } else if (str.toLowerCase().contains("qq.com")) {
            return true;
        } else {
            an.a("URL(%s) does not contain \"qq.com\".", str);
            return false;
        }
    }

    public static SharedPreferences a(String str, Context context) {
        return context != null ? context.getSharedPreferences(str, 0) : null;
    }

    public static void b(String str, String str2) {
        if (a.b() != null && a.b().K != null) {
            a.b().K.edit().putString(str, str2).apply();
        }
    }

    public static String c(String str, String str2) {
        return (a.b() == null || a.b().K == null) ? "" : a.b().K.getString(str, str2);
    }

    public static String e(byte[] bArr) {
        if (bArr == null) {
            return "null";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            if (i != 0) {
                stringBuffer.append(':');
            }
            String toHexString = Integer.toHexString(bArr[i] & 255);
            if (toHexString.length() == 1) {
                StringBuilder stringBuilder = new StringBuilder("0");
                stringBuilder.append(toHexString);
                toHexString = stringBuilder.toString();
            }
            stringBuffer.append(toHexString);
        }
        return stringBuffer.toString().toUpperCase();
    }
}
